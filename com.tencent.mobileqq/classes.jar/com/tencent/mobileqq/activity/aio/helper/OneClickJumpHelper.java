package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipItemBuilder.Holder;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class OneClickJumpHelper
  implements ILifeCycleHelper, AbsListView.OnScrollListener
{
  private TroopAIOContext a;
  private long b = -1L;
  
  public OneClickJumpHelper(AIOContext paramAIOContext)
  {
    this.a = ((TroopAIOContext)paramAIOContext);
  }
  
  private void a()
  {
    TroopListUI localTroopListUI = (TroopListUI)this.a.e().b();
    if ((localTroopListUI.y().a() == JumpState.JUMP_SUCCESS) && (localTroopListUI.y().b() != JumpState.GRAY_TIP_CLICK))
    {
      long l = this.a.e().d().o();
      if (this.b != l)
      {
        this.b = l;
        localTroopListUI.d(false);
      }
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = AIOUtils.b(paramView);
    if ((paramView instanceof UniteGrayTipItemBuilder.Holder))
    {
      paramView = (UniteGrayTipItemBuilder.Holder)paramView;
      if (((paramView.q instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramView.q).tipParam.i == 131093)) {
        this.a.g().post(new OneClickJumpHelper.1(this, paramBoolean));
      }
    }
  }
  
  @NonNull
  public String getTag()
  {
    return "OneClickJumpHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      OneClickJumpUtil.a(this.a.a());
      OneClickJumpUtil.d = null;
      com.tencent.mobileqq.activity.aio.rebuild.msglist.OneClickJumpMsgFilter.b = -1L;
      this.a.e().b().a(false);
      this.a.e().b().c(false);
      return;
    }
    com.tencent.mobileqq.activity.aio.rebuild.msglist.OneClickJumpMsgFilter.b = -1L;
    this.a.e().b().a(false);
    this.a.e().b().c(false);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.T() < paramInt1)
    {
      a();
      a(this.a.R(), false);
      return;
    }
    paramInt1 = paramInt1 + paramInt2 - 1;
    if ((paramInt1 < this.a.U()) && (paramInt1 > 0)) {
      a(this.a.S(), true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OneClickJumpHelper
 * JD-Core Version:    0.7.0.1
 */