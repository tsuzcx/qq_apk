package com.tencent.avgame.gameroom.seat;

import android.content.Context;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
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
      localQQCustomDialog.setMessage(2131690437);
      paramPlayer = new SeatView.1(this, paramPlayer);
      localQQCustomDialog.setPositiveButton(2131694615, paramPlayer);
      localQQCustomDialog.setNegativeButton(2131690800, paramPlayer);
      localQQCustomDialog.show();
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
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
    switch (i)
    {
    }
    for (;;)
    {
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
        return;
      }
      a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.b(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
      continue;
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.c(this.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer);
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
        float f = localRectF.top;
        localRectF.bottom = (((AddMemberItemView)localObject).getMeasuredHeight() + f);
        return localRectF;
      }
      i += 1;
    }
    return null;
  }
  
  public RectF a(long paramLong)
  {
    int i = 0;
    if (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (!((MemberItemView)localObject).a(String.valueOf(paramLong))) {}
      }
    }
    for (Object localObject = ((MemberItemView)localObject).a();; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SeatView", 2, "getPlayerHeadViewRect result:" + localObject);
      }
      return localObject;
      i += 1;
      break;
    }
  }
  
  public ISeatPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter;
  }
  
  public List<MemberVideoDisplayInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    RoomInfo localRoomInfo = GameEngine.a().a().a();
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = ((MemberItemView)localObject).a(this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter);
        if ((localObject != null) && (localRoomInfo.getPlayer(String.valueOf(((MemberVideoDisplayInfo)localObject).a)) != null)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SeatView", 2, "getMemberHeadViewDisplayInfoList infoList:" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a()
  {
    EngineData localEngineData = GameEngine.a().a();
    if ((localEngineData != null) && (localEngineData.a() != null)) {}
    for (int i = localEngineData.a().a;; i = 0)
    {
      if (GameEngine.a().a()) {}
      for (int j = 1;; j = 2)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B0A6", "0X800B0A6", i, 0, "" + j, "", "", "");
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatISeatPresenter.a();
        this.c = true;
        return;
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if (i < getChildCount())
    {
      localObject = getChildAt(i);
      if ((localObject instanceof MemberItemView))
      {
        localObject = (MemberItemView)localObject;
        if (!((MemberItemView)localObject).a(String.valueOf(paramLong))) {}
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ((MemberItemView)localObject).a(paramBoolean);
      }
      return;
      i += 1;
      break;
      localObject = null;
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
    if ((paramSeatMemberInfo == null) || (paramSeatMemberInfo.jdField_a_of_type_ComTencentAvgameGamelogicDataPlayer == null)) {
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690364);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690367);
    if (!this.b) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131690363);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      ReportController.b(null, "dc00898", "", "", "0X800B02A", "0X800B02A", 0, 0, "", "" + GameEngine.a().a().a(), "", "");
      return;
    }
    catch (Exception paramSeatMemberInfo)
    {
      for (;;)
      {
        QLog.e("SeatView", 1, "onMemberItemClick error:", paramSeatMemberInfo);
      }
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.seat.SeatView
 * JD-Core Version:    0.7.0.1
 */