package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public class WSVerticalForAioRedPresenter
  extends WSVerticalForRecommendPresenter
{
  public WSVerticalForAioRedPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private void u()
  {
    WSVerticalPageContract.View localView = z();
    if (localView == null) {
      return;
    }
    localView.a("fullscreen_videoplay");
  }
  
  protected boolean B()
  {
    return true;
  }
  
  protected boolean H()
  {
    return true;
  }
  
  protected boolean I()
  {
    return true;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    super.a(paramWSSimpleBaseEvent);
    if ((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) {
      u();
    }
  }
  
  protected void b(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    super.b(paramList, paramBoolean1, paramBoolean2, paramObject);
    if ((paramBoolean2) && (WSUserAuthDialog.a())) {
      WSSimpleEventBus.a().a(new WSUserAuthEvent());
    }
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (z() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForAioRedPresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public void g()
  {
    super.g();
    P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForAioRedPresenter
 * JD-Core Version:    0.7.0.1
 */