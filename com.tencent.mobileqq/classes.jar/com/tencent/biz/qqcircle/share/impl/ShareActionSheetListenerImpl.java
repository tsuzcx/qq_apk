package com.tencent.biz.qqcircle.share.impl;

import android.app.Activity;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.debug.QCircleDebugActionSheet;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.IRichMediaListener;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation.Builder;
import com.tencent.biz.qqcircle.share.interfaces.IDialogListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFuelAnimationEvent;
import com.tencent.mobileqq.share.api.ShareActionSheetClickListener;
import cooperation.qqcircle.report.QCircleReportBean;

public class ShareActionSheetListenerImpl
  implements ShareActionSheetClickListener
{
  private final QCircleShareInfo a;
  private final int b;
  private final int c;
  private final Activity d;
  private final QCircleReportBean e;
  private final String f;
  private final byte[] g;
  private final QCircleRichMediaDownLoadManager.IRichMediaListener h;
  private final IDialogListener i;
  
  public ShareActionSheetListenerImpl(ShareActionSheetListenerImpl.Builder paramBuilder)
  {
    this.a = ShareActionSheetListenerImpl.Builder.a(paramBuilder);
    this.b = ShareActionSheetListenerImpl.Builder.b(paramBuilder);
    this.c = ShareActionSheetListenerImpl.Builder.c(paramBuilder);
    this.d = ShareActionSheetListenerImpl.Builder.d(paramBuilder);
    this.e = ShareActionSheetListenerImpl.Builder.e(paramBuilder);
    this.f = ShareActionSheetListenerImpl.Builder.f(paramBuilder);
    this.g = ShareActionSheetListenerImpl.Builder.g(paramBuilder);
    this.h = ShareActionSheetListenerImpl.Builder.h(paramBuilder);
    this.i = ShareActionSheetListenerImpl.Builder.i(paramBuilder);
  }
  
  public void cancelPushDisable()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.b).a(this.d).b(this.c).a(this.e).e(12).a();
    this.i.a(false, true);
  }
  
  public void delete()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.e).b(this.c).a(this.b).e(8).a();
    this.i.a(false, true);
  }
  
  public void deleteHasPush()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).e(9).a();
    this.i.a(false, true);
  }
  
  public void feedback() {}
  
  public void hideHim()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.b).b(this.c).a(this.e).d(4).c(false).e(7).a();
    this.i.a(false, false);
  }
  
  public void hideThisWork()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).d(3).c(false).e(7).a();
    this.i.a(false, false);
  }
  
  public void jumpQcirclePrivateMessage()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).a(this.e).e(11).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void miniAppDebugOn()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QCircleShareInfo)localObject).b != null))
    {
      localObject = this.d;
      if (localObject == null) {
        return;
      }
      QCircleDebugActionSheet.a((Activity)localObject, this.a);
      this.i.a(false, false);
    }
  }
  
  public void report()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.f).a(this.e).a(this.g).e(4).a();
    this.i.a();
    this.i.a(false, false);
  }
  
  public void save()
  {
    this.i.b();
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).a(this.h).e(10).a();
    this.i.a(false, false);
  }
  
  public void shareToQQ()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).a(this.f).a(this.g).e(0).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void shareToQZone()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.b).b(this.c).a(this.d).a(this.f).a(this.g).a(this.e).e(1).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void shareToSpecifiedFriend(String paramString, int paramInt)
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).a(this.f).a(this.g).b(paramString).c(paramInt).e(2).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void shareToWeChat()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.b).b(this.c).a(this.d).a(this.e).a(this.f).a(this.g).a(true).e(3).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void shareToWeChatCircle()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.b).b(this.c).a(this.d).a(this.e).a(this.f).a(this.g).a(false).e(3).a();
    SimpleEventBus.getInstance().dispatchEvent(new QCircleFuelAnimationEvent());
    this.i.a(false, false);
  }
  
  public void showReportDisLike()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).a(this.b).b(this.c).a(this.e).a(this.i).e(5).a();
    this.i.a(true, true);
  }
  
  public void switchBarrageClose()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).b(true).e(6).a();
    this.i.a(false, false);
  }
  
  public void switchBarrageOpen()
  {
    new QCircleBaseShareOperation.Builder().a(this.a).a(this.d).b(false).e(6).a();
    this.i.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.share.impl.ShareActionSheetListenerImpl
 * JD-Core Version:    0.7.0.1
 */