package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheet.OnDismissListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

public class SeatView
  extends GridView
  implements ISeatView, SeatViewAdapter.OnItemClickListener, ActionSheet.OnButtonClickListener, ActionSheet.OnDismissListener
{
  protected SeatViewAdapter a;
  protected ISeatPresenter b = new SeatPresenterImp(this);
  protected ActionSheet c;
  protected Player d;
  protected boolean e = false;
  protected boolean f = false;
  protected boolean g = false;
  
  public SeatView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SeatView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SeatView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Player paramPlayer)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getContext(), 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(2131887272);
      paramPlayer = new SeatView.1(this, paramPlayer);
      localQQCustomDialog.setPositiveButton(2131892267, paramPlayer);
      localQQCustomDialog.setNegativeButton(2131887648, paramPlayer);
      localQQCustomDialog.show();
    }
  }
  
  public RectF a(long paramLong)
  {
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (((MemberItemView)localObject).a(String.valueOf(paramLong)))
        {
          localObject = ((MemberItemView)localObject).getPlayerHeadViewRect();
          break label64;
        }
      }
      i += 1;
    }
    Object localObject = null;
    label64:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPlayerHeadViewRect result:");
      localStringBuilder.append(localObject);
      QLog.i("SeatView", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a()
  {
    Object localObject = GameEngine.a().s();
    int i;
    if ((localObject != null) && (((EngineData)localObject).f() != null)) {
      i = ((EngineData)localObject).f().a;
    } else {
      i = 0;
    }
    int j = 2;
    if (GameEngine.a().d()) {
      j = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(j);
    ReportController.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, ((StringBuilder)localObject).toString(), "", "", "");
    this.b.c();
    this.g = true;
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (((MemberItemView)localObject).a(String.valueOf(paramLong))) {
          break label62;
        }
      }
      i += 1;
    }
    Object localObject = null;
    label62:
    if (localObject != null) {
      ((MemberItemView)localObject).a(paramBoolean);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    this.a.a(this.b.a(), this.b.b());
    this.a.notifyDataSetChanged();
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.b.a(paramIGameRoomPresenter);
    setNumColumns(4);
    this.a = new SeatViewAdapter(getContext(), this.b);
    this.a.a(this.b.a(), this.b.b());
    setAdapter(this.a);
    this.a.a(this);
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if (paramSeatMemberInfo != null)
    {
      if (paramSeatMemberInfo.a == null) {
        return;
      }
      this.d = paramSeatMemberInfo.a;
      this.e = GameEngine.a().d();
      this.f = false;
      if (GameEngine.a().f() != null)
      {
        paramSeatMemberInfo = GameEngine.a().f().getAccount();
        if (TextUtils.equals(this.d.uin, paramSeatMemberInfo)) {
          this.f = true;
        }
      }
      this.c = ((ActionSheet)ActionSheetHelper.b(getContext(), null));
      if ((this.e) && (!this.f)) {
        this.c.addButton(2131887198);
      }
      this.c.addButton(2131887201);
      if (!this.f) {
        this.c.addButton(2131887197);
      }
      this.c.addCancelButton(2131887648);
      this.c.setOnButtonClickListener(this);
      this.c.setOnDismissListener(this);
      try
      {
        this.c.show();
      }
      catch (Exception paramSeatMemberInfo)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
      paramSeatMemberInfo = new StringBuilder();
      paramSeatMemberInfo.append("");
      paramSeatMemberInfo.append(GameEngine.a().s().i());
      ReportController.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", paramSeatMemberInfo.toString(), "", "");
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean b()
  {
    return this.g;
  }
  
  public RectF getAddMemberViewRect()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof AddMemberItemView)) {
        return ((AddMemberItemView)localView).getViewRect();
      }
      i += 1;
    }
    return null;
  }
  
  public RectF getAddMemberViewRectInRootView()
  {
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof AddMemberItemView))
      {
        localObject = (AddMemberItemView)localObject;
        int[] arrayOfInt = new int[2];
        GameRoomViewLayoutParamsDef.a((View)localObject, arrayOfInt);
        RectF localRectF = new RectF();
        localRectF.left = arrayOfInt[0];
        localRectF.top = arrayOfInt[1];
        localRectF.right = (localRectF.left + ((AddMemberItemView)localObject).getMeasuredWidth());
        localRectF.bottom = (localRectF.top + ((AddMemberItemView)localObject).getMeasuredHeight());
        return localRectF;
      }
      i += 1;
    }
    return null;
  }
  
  public List<MemberVideoDisplayInfo> getMemberHeadViewDisplayInfoList()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = GameEngine.a().s().e();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject2 = getChildAt(i);
      if ((localObject2 instanceof MemberItemView))
      {
        localObject2 = ((MemberItemView)localObject2).a(this.b);
        if ((localObject2 != null) && (((RoomInfo)localObject1).getPlayer(String.valueOf(((MemberVideoDisplayInfo)localObject2).a)) != null)) {
          localArrayList.add(localObject2);
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getMemberHeadViewDisplayInfoList infoList:");
      ((StringBuilder)localObject1).append(localArrayList);
      QLog.i("SeatView", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public ISeatPresenter getPresenter()
  {
    return this.b;
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.c != null)
    {
      if (this.d == null) {
        return;
      }
      int i;
      if (this.e)
      {
        i = paramInt;
        if (!this.f) {}
      }
      else
      {
        i = paramInt + 1;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            this.b.c(this.d);
          }
        }
        else {
          this.b.b(this.d);
        }
      }
      else {
        a(this.d);
      }
      try
      {
        this.c.setOnButtonClickListener(null);
        this.c.dismiss();
        this.c = null;
        this.d = null;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public void onDismiss()
  {
    this.d = null;
    ActionSheet localActionSheet = this.c;
    if (localActionSheet == null) {
      return;
    }
    localActionSheet.setOnButtonClickListener(null);
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */