package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.qqcircle.widgets.QCirclePushToastView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.event.QCirclePushToastEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;
import feedcloud.FeedCloudToastshowsvr.StToast;
import java.util.ArrayList;

public class QCirclePushToastPart
  extends QCircleBasePart
  implements SimpleEventReceiver
{
  private QCirclePushToastView a;
  private FrameLayout c;
  
  public String a()
  {
    return "QCirclePushToastPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.c = ((FrameLayout)paramView.findViewById(2131440957));
    if ((this.c == null) && ((paramView instanceof FrameLayout))) {
      this.c = ((FrameLayout)paramView);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    RFWTypefaceUtil.a("https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
    RFWTypefaceUtil.a("https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (TextUtils.equals(paramString, "tab_changed"))
    {
      paramString = this.a;
      if (paramString != null) {
        paramString.b();
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushToastEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.a;
    if (paramActivity != null) {
      paramActivity.b();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushToastEvent))
    {
      QCirclePushToastEvent localQCirclePushToastEvent = (QCirclePushToastEvent)paramSimpleBaseEvent;
      QLog.d("QCirclePushToastPart", 1, "onReceivePushToastEvent");
      if (localQCirclePushToastEvent.mData != null)
      {
        paramSimpleBaseEvent = new FeedCloudToastshowsvr.StGetToastDetailRsp();
        try
        {
          paramSimpleBaseEvent.mergeFrom(localQCirclePushToastEvent.mData);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        paramSimpleBaseEvent = (FeedCloudToastshowsvr.StToast)paramSimpleBaseEvent.toastInfo.get();
        if (paramSimpleBaseEvent != null)
        {
          RFThreadManager.getUIHandler().post(new QCirclePushToastPart.1(this, paramSimpleBaseEvent));
          return;
        }
        QLog.d("QCirclePushToastPart", 1, "onReceivePushToastEvent, not show toast because of stToast is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart
 * JD-Core Version:    0.7.0.1
 */