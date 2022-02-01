package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.aelight.camera.qqstory.api.IShortVideoManager;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.config.business.MsgTabCameraConfBean;
import com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatUtils;
import com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import common.config.service.QzoneConfig.QzoneConfigChangeListener;
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
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
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
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private volatile boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private volatile boolean jdField_d_of_type_Boolean;
  
  public ConversationTitleBtnCtrl(Conversation paramConversation)
  {
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
    Object localObject1;
    if (this.jdField_d_of_type_Int == 2)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130851074);
      }
      if ((QzoneConfig.getQQCircleShowGuideOnMessageTab()) && (QCircleHostConfig.isNeedShowMessageEntranceAnim() != 0))
      {
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localObject1 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_AndroidAppActivity;
            if ((localObject2 != null) && (ViewUtils.a((Context)localObject2) > 0))
            {
              ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ViewUtils.a(this.jdField_a_of_type_AndroidAppActivity), ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
              this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          Object localObject2 = new ApngOptions();
          ((ApngOptions)localObject2).a(1);
          localObject1 = new ConversationTitleBtnCtrl.1(this);
          ((ApngOptions)localObject2).a(new ConversationTitleBtnCtrl.2(this));
          localObject2 = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20210303143357_iBKkt6tBJO.png", (ApngOptions)localObject2);
          this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          if ((localObject2 != null) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof ApngDrawable))) {
            ((ApngDrawable)((URLDrawable)localObject2).getCurrDrawable()).setOnPlayRepeatListener((ApngDrawable.OnPlayRepeatListener)localObject1);
          }
        }
      }
      else
      {
        localObject1 = this.jdField_c_of_type_AndroidViewView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
        if (localObject1 != null) {
          ((RedTouch)localObject1).setVisibility(8);
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
      if (localObject1 != null) {
        ((RedTouch)localObject1).setVisibility(0);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(0);
        IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidWidgetImageView);
        boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).bNeedShowLimitChatInTitleEntrance(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("switchType isMatchChatMode =");
          ((StringBuilder)localObject1).append(bool);
          QLog.d("ConversationTitleBtnCtrl", 4, ((StringBuilder)localObject1).toString());
        }
        if (bool)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851073);
          this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691217));
          this.jdField_d_of_type_Int = 1;
        }
        else
        {
          j();
        }
      }
      if ((this.jdField_d_of_type_Int == 0) && (Build.VERSION.SDK_INT < 21))
      {
        QLog.d("ConversationTitleBtnCtrl", 1, "version below 5.0, hide the camera");
        localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
        if (localObject1 != null) {
          ((RedTouch)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.jdField_c_of_type_AndroidViewView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void i()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    if (localObject != null) {
      ((RedTouch)localObject).setVisibility(8);
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
    int i = this.jdField_d_of_type_Int;
    if ((i != 0) && (i != 2))
    {
      this.jdField_d_of_type_Int = 0;
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null)
      {
        localImageView.setImageResource(2130851071);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691218));
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_d_of_type_Int == 2)
    {
      this.jdField_b_of_type_Boolean = true;
      ThreadManager.getSubThreadHandler().post(new ConversationTitleBtnCtrl.10(this));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365232);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365233));
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131373901);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131373900));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131374387);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365234));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(2131365231));
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
    ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).beginSession();
    ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).milestone("userClick");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    } else {
      bool = true;
    }
    if (!bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().requestPermissions(new ConversationTitleBtnCtrl.7(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      return;
    }
    b(paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateQQCircle ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ConversationTitleBtnCtrl", 1, localStringBuilder.toString());
    if ((QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a())) && (QzoneConfig.isQQCircleShowLebaBySwitchButton(StudyModeManager.a())))
    {
      this.jdField_d_of_type_Int = 2;
      h();
      b(paramBoolean);
    }
    else
    {
      this.jdField_d_of_type_Int = 0;
      h();
    }
    if (QzoneConfig.isQQCircleShowMessageEntrance(StudyModeManager.a()))
    {
      this.jdField_a_of_type_JavaLangRunnable = new ConversationTitleBtnCtrl.3(this);
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void b()
  {
    boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).bNeedShowLimitChatInTitleEntrance(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a());
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchType isMatchChatMode =");
      localStringBuilder.append(bool);
      QLog.d("ConversationTitleBtnCtrl", 4, localStringBuilder.toString());
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130851073);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691217));
      this.jdField_d_of_type_Int = 1;
    }
    else
    {
      j();
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.5(this));
  }
  
  public void b(View paramView)
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
    Object localObject2 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView != localObject3)
    {
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!((RedTouch)localObject3).c()) {}
      }
    }
    else
    {
      localObject2 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getRuntimeService(IRedTouchManager.class, "");
      localObject3 = ((IRedTouchManager)localObject2).getAppInfo(6, "120000");
      localObject1 = ((IShortVideoManager)QRoute.api(IShortVideoManager.class)).parseLinkFromRedTouchBuffer(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get(), "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCameraBtnClick---has red point, jumpSchme=");
      localStringBuilder.append((String)localObject1);
      QLog.i("ConversationTitleBtnCtrl", 1, localStringBuilder.toString());
      ((IRedTouchManager)localObject2).onRedTouchItemClick((BusinessInfoCheckUpdate.AppInfo)localObject3, null);
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if (!((String)localObject1).contains("cmode"))
      {
        localObject2 = "?";
        if (((String)localObject1).contains("?")) {
          localObject2 = "&";
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("cmode");
        ((StringBuilder)localObject3).append("=");
        ((StringBuilder)localObject3).append("all");
        localObject2 = ((String)localObject1).concat(((StringBuilder)localObject3).toString());
      }
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).setData(Uri.parse((String)localObject2));
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.8(this), 500L);
    if (paramView != this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch) {
      paramView = "1";
    } else {
      paramView = "3";
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
  }
  
  public void b(boolean paramBoolean)
  {
    int j = this.jdField_d_of_type_Int;
    int i = 2;
    if (j != 2) {
      return;
    }
    if (!paramBoolean) {
      i = 5;
    }
    ThreadManager.post(new ConversationTitleBtnCtrl.4(this), i, null, false);
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
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null))
    {
      if ((MsgTabCameraSwitchProcessor.a().jdField_a_of_type_Int == 1) && (Build.VERSION.SDK_INT >= 21))
      {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(0);
        Object localObject1 = (IRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject1).getAppInfo(6, "120000");
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
        boolean bool1 = RedTouch.a(localAppInfo);
        boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.c();
        if (bool1)
        {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
          int i = this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshCameraRedTouch, outerRedType=");
          ((StringBuilder)localObject2).append(i);
          QLog.i("ConversationTitleBtnCtrl", 1, ((StringBuilder)localObject2).toString());
          if (i == 0) {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          } else {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          }
          ((IRedTouchManager)localObject1).onRedTouchItemExposure(localAppInfo, null);
          if (!paramBoolean) {
            ReportController.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
          }
        }
        else if (bool2)
        {
          this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.d();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (paramBoolean)
        {
          if (!bool1) {
            localObject1 = "1";
          } else {
            localObject1 = "3";
          }
          ReportController.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, (String)localObject1, "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
      }
      return;
    }
    QLog.e("ConversationTitleBtnCtrl", 1, "refreshCameraRedTouch, not inited");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterSyncMsg ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    QLog.d("ConversationTitleBtnCtrl", 1, localStringBuilder.toString());
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
        QLog.d("ConversationTitleBtnCtrl", 4, ((StringBuilder)localObject).toString());
      }
      int i = this.jdField_d_of_type_Int;
      if (i == 0)
      {
        a(paramView);
      }
      else if (i == 1)
      {
        ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), 6);
      }
      else if (i == 2)
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if ((localObject != null) && (((View)localObject).getVisibility() != 0))
        {
          QLog.e("ConversationTitleBtnCtrl", 1, "QQCircle entrance logo is not visilbe,direct return!");
        }
        else
        {
          HashMap localHashMap1 = new HashMap();
          HashMap localHashMap2 = new HashMap();
          localObject = "1";
          localHashMap1.put("key_enable_splash", "1");
          localHashMap1.put("key_jump_from", "4");
          if (!this.jdField_d_of_type_Boolean) {
            localObject = "0";
          }
          localHashMap1.put("key_show_active_red_dot", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append("");
          localHashMap1.put("key_unread_red_num", ((StringBuilder)localObject).toString());
          if (this.jdField_a_of_type_Int > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append("");
            localHashMap1.put("key_assign_show_tab_type", ((StringBuilder)localObject).toString());
          }
          localObject = this.jdField_a_of_type_ArrayOfByte;
          if ((localObject != null) && (localObject.length > 0)) {
            localHashMap2.put("key_red_dot_trans_info", localObject);
          }
          ThreadManager.post(new ConversationTitleBtnCtrl.6(this), 5, null, false);
          if (this.jdField_b_of_type_Int > 0) {
            a(2);
          } else if (this.jdField_d_of_type_Boolean) {
            a(1);
          } else {
            a(3);
          }
          localHashMap1.put("xsj_main_entrance", "msg_ur_icon");
          QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), "openfolder", localHashMap1, localHashMap2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigChange()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ConversationTitleBtnCtrl.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl
 * JD-Core Version:    0.7.0.1
 */