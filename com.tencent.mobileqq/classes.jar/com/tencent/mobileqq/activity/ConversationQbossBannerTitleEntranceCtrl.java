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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ConversationQbossBannerTitleEntranceCtrl
  implements View.OnClickListener, QzoneConfig.QzoneConfigChangeListener
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private boolean jdField_a_of_type_Boolean = false;
  private View b;
  
  public ConversationQbossBannerTitleEntranceCtrl(Conversation paramConversation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    QzoneConfig.getInstance().addListener(this);
  }
  
  private void c()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 1)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "hideAllEntrances");
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365232);
      this.b = paramView.findViewById(2131374387);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365234));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateQQCircle ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, localStringBuilder.toString());
    if ((QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a())) && (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a())))
    {
      this.jdField_a_of_type_Int = 1;
      c();
    }
    else
    {
      this.jdField_a_of_type_Int = 0;
      c();
    }
    if (QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a())) {
      ThreadManager.getSubThreadHandler().post(new ConversationQbossBannerTitleEntranceCtrl.1(this));
    }
    b(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 0;
    QzoneConfig.getInstance().removeListener(this);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int != 1) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 5;
    }
    ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.2(this), i, null, false);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long < 500L)
    {
      jdField_a_of_type_Long = l;
    }
    else
    {
      jdField_a_of_type_Long = l;
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userClick time=");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("ConversationQbossBannerTitleEntranceCtrl", 4, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("key_enable_splash", "1");
        ((HashMap)localObject).put("key_jump_from", "4");
        QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), "openfolder", (HashMap)localObject);
        ThreadManager.post(new ConversationQbossBannerTitleEntranceCtrl.3(this), 5, null, false);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationQbossBannerTitleEntranceCtrl", 1, "onConfigChange");
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationQbossBannerTitleEntranceCtrl.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl
 * JD-Core Version:    0.7.0.1
 */