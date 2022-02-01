package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ConversationQbossBannerTitleEntranceCtrl
  implements View.OnClickListener, QzoneConfig.QzoneConfigChangeListener
{
  private static long b;
  private int a = 0;
  private View c;
  private View d;
  private TextView e;
  private Conversation f;
  private Activity g;
  private Handler h;
  private boolean i = false;
  
  public ConversationQbossBannerTitleEntranceCtrl(Conversation paramConversation)
  {
    this.f = paramConversation;
    this.g = this.f.P();
    this.h = new Handler(Looper.getMainLooper());
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void c()
  {
    Object localObject;
    if (this.a == 1)
    {
      localObject = this.c;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.e;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "hideAllEntrances");
    Object localObject = this.c;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  public void a()
  {
    d();
  }
  
  public void a(View paramView)
  {
    if (this.i) {
      return;
    }
    this.i = true;
    if (paramView != null)
    {
      this.c = paramView.findViewById(2131431398);
      this.d = paramView.findViewById(2131442553);
      this.e = ((TextView)paramView.findViewById(2131431400));
      this.c.setOnClickListener(this);
    }
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateQQCircle ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, localStringBuilder.toString());
    if ((QCircleConfigHelper.b(StudyModeManager.h())) && (QCircleConfigHelper.e(StudyModeManager.h())))
    {
      this.a = 1;
      c();
    }
    else
    {
      this.a = 0;
      c();
    }
    if (QCircleConfigHelper.b(StudyModeManager.h())) {
      ThreadManager.getSubThreadHandler().post(new ConversationQbossBannerTitleEntranceCtrl.1(this));
    }
    b(paramBoolean);
  }
  
  public void b()
  {
    this.a = 0;
    QzoneConfig.getInstance().removeListener(this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.a != 1) {
      return;
    }
    int j;
    if (paramBoolean) {
      j = 2;
    } else {
      j = 5;
    }
    ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.2(this), j, null, false);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - b < 500L)
    {
      b = l;
    }
    else
    {
      b = l;
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userClick time=");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("ConversationQbossBannerTitleEntranceCtrl", 4, ((StringBuilder)localObject).toString());
      }
      if (this.a == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("key_enable_splash", "1");
        ((HashMap)localObject).put("key_jump_from", "4");
        QCircleUtils.a().enterBySchemeAction(this.f.P(), "openfolder", (HashMap)localObject);
        ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.3(this), 5, null, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "onConfigChange");
    this.h.post(new ConversationQbossBannerTitleEntranceCtrl.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl
 * JD-Core Version:    0.7.0.1
 */