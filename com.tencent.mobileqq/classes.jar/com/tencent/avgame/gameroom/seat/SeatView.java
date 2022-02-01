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
  protected Player a;
  protected ISeatPresenter a;
  protected SeatViewAdapter a;
  protected ActionSheet a;
  protected boolean a;
  protected boolean b = false;
  protected boolean c = false;
  
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
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter = new SeatPresenterImp(this);
  }
  
  private void a(Player paramPlayer)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getContext(), 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(2131690361);
      paramPlayer = new SeatView.1(this, paramPlayer);
      localQQCustomDialog.setPositiveButton(2131694583, paramPlayer);
      localQQCustomDialog.setNegativeButton(2131690728, paramPlayer);
      localQQCustomDialog.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        return;
      }
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        i = paramInt;
        if (!this.b) {}
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
            this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
        }
      }
      else {
        a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      }
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
  
  public RectF a()
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
          localObject = ((MemberItemView)localObject).a();
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
  
  public ISeatPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter;
  }
  
  public List<MemberVideoDisplayInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = GameEngine.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject2 = getChildAt(i);
      if ((localObject2 instanceof MemberItemView))
      {
        localObject2 = ((MemberItemView)localObject2).a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
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
  
  public void a()
  {
    Object localObject = GameEngine.a().a();
    int i;
    if ((localObject != null) && (((EngineData)localObject).a() != null)) {
      i = ((EngineData)localObject).a().a;
    } else {
      i = 0;
    }
    int j = 2;
    if (GameEngine.a().a()) {
      j = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(j);
    ReportController.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, ((StringBuilder)localObject).toString(), "", "", "");
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a();
    this.c = true;
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
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter.notifyDataSetChanged();
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(paramIGameRoomPresenter);
    setNumColumns(4);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter = new SeatViewAdapter(getContext(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter.a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a());
    setAdapter(this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatViewAdapter.a(this);
  }
  
  public void a(SeatMemberInfo paramSeatMemberInfo)
  {
    if (paramSeatMemberInfo != null)
    {
      if (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer;
      this.jdField_a_of_type_Boolean = GameEngine.a().a();
      this.b = false;
      if (GameEngine.a().a() != null)
      {
        paramSeatMemberInfo = GameEngine.a().a().getAccount();
        if (TextUtils.equals(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer.uin, paramSeatMemberInfo)) {
          this.b = true;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getContext(), null));
      if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690287);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690290);
      if (!this.b) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690286);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      }
      catch (Exception paramSeatMemberInfo)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
      paramSeatMemberInfo = new StringBuilder();
      paramSeatMemberInfo.append("");
      paramSeatMemberInfo.append(GameEngine.a().a().a());
      ReportController.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", paramSeatMemberInfo.toString(), "", "");
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return this.c;
  }
  
  public RectF b()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof AddMemberItemView)) {
        return ((AddMemberItemView)localView).a();
      }
      i += 1;
    }
    return null;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer = null;
    ActionSheet localActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (localActionSheet == null) {
      return;
    }
    localActionSheet.setOnButtonClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */