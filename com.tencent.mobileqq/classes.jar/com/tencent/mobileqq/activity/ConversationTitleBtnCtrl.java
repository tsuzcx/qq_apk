package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.config.business.MsgTabCameraConfBean;
import com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor;
import com.tencent.mobileqq.extendfriend.limitchat.ExpandFriendChatUtil;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import dov.com.tencent.biz.qqstory.takevideo.ShortVideoForwardManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ConversationTitleBtnCtrl
  implements View.OnClickListener, QzoneConfig.QzoneConfigChangeListener
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int = -1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private volatile int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private volatile boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean;
  
  public ConversationTitleBtnCtrl(Conversation paramConversation)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", "1");
    localHashMap.put("ext5", this.jdField_a_of_type_JavaLangString);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 2, 2, paramInt, localHashMap, null, null);
  }
  
  private void h()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130851158);
      }
      if ((QzoneConfig.isQQCircleShowMessageEntranceTips()) && (QCircleHostConfig.isNeedShowMessageEntranceTips() == 1)) {
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          if ((localLayoutParams != null) && (this.jdField_a_of_type_AndroidAppActivity != null) && (ViewUtils.a(this.jdField_a_of_type_AndroidAppActivity) > 0))
          {
            localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin + (ViewUtils.a(this.jdField_a_of_type_AndroidAppActivity) - ViewUtils.b(32.0F)), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
          }
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          QCircleHostConfig.setNeedShowMessageEntranceTips(false);
          ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.1(this), 5000L);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
        }
        return;
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
      boolean bool = ExpandFriendChatUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
      if (QLog.isDevelopLevel()) {
        QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
      }
      if (!bool) {
        break label428;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851157);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691296));
      this.jdField_d_of_type_Int = 1;
    }
    for (;;)
    {
      if ((this.jdField_d_of_type_Int == 0) && (Build.VERSION.SDK_INT < 21))
      {
        QLog.d("ConversationTitleBtnCtrl", 1, "version below 5.0, hide the camera");
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
        }
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_c_of_type_AndroidViewView != null) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label428:
      j();
    }
  }
  
  private void i()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void j()
  {
    if ((this.jdField_d_of_type_Int != 0) && (this.jdField_d_of_type_Int != 2))
    {
      this.jdField_d_of_type_Int = 0;
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851155);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691297));
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getSubThreadHandler().post(new ConversationTitleBtnCtrl.9(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365368);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365369));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131374348);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374853);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365370));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365367));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_AndroidWidgetImageView).a();
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    QzoneConfig.getInstance().addListener(this);
    a(true);
  }
  
  public void a(View paramView)
  {
    AELaunchRecorder.a().d();
    AELaunchRecorder.a().a("userClick");
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());; bool = true)
    {
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().requestPermissions(new ConversationTitleBtnCtrl.6(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      b(paramView);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "updateQQCircle " + paramBoolean);
    if ((QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a())) && (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a())))
    {
      this.jdField_d_of_type_Int = 2;
      if (QCircleHostConfig.isNeedShowMessageEntranceTips() == -1) {
        QCircleHostConfig.setNeedShowMessageEntranceTips(true);
      }
      h();
      b(paramBoolean);
    }
    for (;;)
    {
      if (QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a()))
      {
        this.jdField_a_of_type_JavaLangRunnable = new ConversationTitleBtnCtrl.2(this);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
      this.jdField_d_of_type_Int = 0;
      h();
    }
  }
  
  public void b()
  {
    boolean bool = ExpandFriendChatUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    if (QLog.isDevelopLevel()) {
      QLog.d("ConversationTitleBtnCtrl", 4, "switchType isMatchChatMode =" + bool);
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851157);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691296));
      this.jdField_d_of_type_Int = 1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.4(this));
      return;
      j();
    }
  }
  
  public void b(View paramView)
  {
    Object localObject2 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c()) {}
      }
    }
    else
    {
      localObject2 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject2).a(6, "120000");
      localObject1 = ShortVideoForwardManager.a(localAppInfo.buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      QLog.i("ConversationTitleBtnCtrl", 1, "handleCameraBtnClick---has red point, jumpSchme=" + (String)localObject1);
      ((RedTouchManager)localObject2).a(localAppInfo, null);
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        if (!((String)localObject1).contains("?")) {
          break label265;
        }
        localObject2 = "&";
        localObject2 = ((String)localObject1).concat((String)localObject2 + "cmode" + "=" + "all");
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.7(this), 500L);
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch) {}
    for (paramView = "1";; paramView = "3")
    {
      ReportController.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
      return;
      label265:
      localObject2 = "?";
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i = 2;
    if (this.jdField_d_of_type_Int != 2) {
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      ThreadManager.post(new ConversationTitleBtnCtrl.3(this), i, null, false);
      return;
      i = 5;
    }
  }
  
  public void c()
  {
    j();
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null) && (MsgTabCameraSwitchProcessor.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21) && (this.jdField_d_of_type_Int == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Int == 2) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null))
    {
      QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
      return;
    }
    if ((MsgTabCameraSwitchProcessor.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
      Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a(6, "120000");
      RedTouch localRedTouch = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      boolean bool1 = RedTouch.a(localAppInfo);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
      if (bool1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
        ((RedTouchManager)localObject).b(localAppInfo, null);
        if (!paramBoolean) {
          ReportController.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
        }
        label171:
        if (!paramBoolean) {
          break label235;
        }
        if (bool1) {
          break label237;
        }
      }
      label235:
      label237:
      for (localObject = "1";; localObject = "3")
      {
        ReportController.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject, "", "", "");
        return;
        if ((bool1) || (!bool2)) {
          break label171;
        }
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        break label171;
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void f()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onAfterSyncMsg " + this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    k();
  }
  
  public void g()
  {
    QCircleUtils.a().releaseWhenExitQCircle();
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374348) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      long l = System.currentTimeMillis();
      if (l - jdField_a_of_type_Long < 500L)
      {
        jdField_a_of_type_Long = l;
      }
      else
      {
        jdField_a_of_type_Long = l;
        if (QLog.isDevelopLevel()) {
          QLog.d("ConversationTitleBtnCtrl", 4, "userClick time=" + System.currentTimeMillis());
        }
        if (this.jdField_d_of_type_Int == 0)
        {
          a(paramView);
        }
        else if (this.jdField_d_of_type_Int == 1)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("ExtendFriendLimitChatFromeType", 1);
          PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), (Intent)localObject, ExtendFriendLimitChatMatchFragment.class);
        }
        else if (this.jdField_d_of_type_Int == 2)
        {
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
            break;
          }
          QLog.e("ConversationTitleBtnCtrl", 1, "QQCircle entrance logo is not visilbe,direct return!");
        }
      }
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put("key_enable_splash", "1");
    localHashMap1.put("key_jump_from", "4");
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = "1";
      label237:
      localHashMap1.put("key_show_active_red_dot", localObject);
      localHashMap1.put("key_unread_red_num", this.jdField_b_of_type_Int + "");
      if (this.jdField_a_of_type_Int > 0) {
        localHashMap1.put("key_assign_show_tab_type", this.jdField_a_of_type_Int + "");
      }
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
        localHashMap2.put("key_red_dot_trans_info", this.jdField_a_of_type_ArrayOfByte);
      }
      ThreadManager.post(new ConversationTitleBtnCtrl.5(this), 5, null, false);
      if (this.jdField_b_of_type_Int <= 0) {
        break label416;
      }
      a(2);
    }
    for (;;)
    {
      localHashMap1.put("xsj_main_entrance", "msg_ur_icon");
      QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), "openfolder", localHashMap1, localHashMap2);
      break;
      localObject = "0";
      break label237;
      label416:
      if (this.jdField_d_of_type_Boolean) {
        a(1);
      } else {
        a(3);
      }
    }
  }
  
  public void onConfigChange()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "onConfigChange");
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.8(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl
 * JD-Core Version:    0.7.0.1
 */