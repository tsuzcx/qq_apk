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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
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
  private static long s;
  private ImageView a = null;
  private View b;
  private ImageView c;
  private View d;
  private TextView e;
  private View f;
  private ImageView g;
  private boolean h;
  private boolean i;
  private int j = -1;
  private String k;
  private volatile boolean l = true;
  private volatile boolean m;
  private volatile int n;
  private volatile int o;
  private RedTouch p;
  private Conversation q;
  private int r = 0;
  private Activity t;
  private Handler u;
  private byte[] v;
  private Runnable w;
  
  public ConversationTitleBtnCtrl(Conversation paramConversation)
  {
    this.q = paramConversation;
    this.t = this.q.P();
    this.u = new Handler(Looper.getMainLooper());
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", "1");
    localHashMap.put("ext5", this.k);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(2).setSubActionType(2).setThrActionType(paramInt).setExtras(localHashMap));
  }
  
  private void h()
  {
    Object localObject1;
    if (this.r == 2)
    {
      localObject1 = this.b;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        this.c.setImageResource(2130853305);
      }
      if ((QzoneConfig.getQQCircleShowGuideOnMessageTab()) && (QCircleHostConfig.isNeedShowMessageEntranceAnim() != 0))
      {
        if (this.f != null)
        {
          this.b.setVisibility(8);
          localObject1 = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
          if (localObject1 != null)
          {
            localObject2 = this.t;
            if ((localObject2 != null) && (ViewUtils.getStatusBarHeight((Context)localObject2) > 0))
            {
              ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ViewUtils.getStatusBarHeight(this.t), ((RelativeLayout.LayoutParams)localObject1).rightMargin, ((RelativeLayout.LayoutParams)localObject1).bottomMargin);
              this.f.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            }
          }
          this.f.setVisibility(0);
          Object localObject2 = new ApngOptions();
          ((ApngOptions)localObject2).a(1);
          localObject1 = new ConversationTitleBtnCtrl.1(this);
          ((ApngOptions)localObject2).a(new ConversationTitleBtnCtrl.2(this));
          localObject2 = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20210303143357_iBKkt6tBJO.png", (ApngOptions)localObject2);
          this.g.setImageDrawable((Drawable)localObject2);
          if ((localObject2 != null) && ((((URLDrawable)localObject2).getCurrDrawable() instanceof ApngDrawable))) {
            ((ApngDrawable)((URLDrawable)localObject2).getCurrDrawable()).setOnPlayRepeatListener((ApngDrawable.OnPlayRepeatListener)localObject1);
          }
        }
      }
      else
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = this.a;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = this.p;
        if (localObject1 != null) {
          ((RedTouch)localObject1).setVisibility(8);
        }
      }
    }
    else
    {
      localObject1 = this.p;
      if (localObject1 != null) {
        ((RedTouch)localObject1).setVisibility(0);
      }
      localObject1 = this.a;
      if (localObject1 != null)
      {
        ((ImageView)localObject1).setVisibility(0);
        IphoneTitleBarActivity.setLayerType(this.a);
        boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).bNeedShowLimitChatInTitleEntrance(this.q.s());
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("switchType isMatchChatMode =");
          ((StringBuilder)localObject1).append(bool);
          QLog.d("ConversationTitleBtnCtrl", 4, ((StringBuilder)localObject1).toString());
        }
        if (bool)
        {
          this.a.setImageResource(2130853304);
          this.a.setContentDescription(this.t.getString(2131888163));
          this.r = 1;
        }
        else
        {
          j();
        }
      }
      if ((this.r == 0) && (Build.VERSION.SDK_INT < 21))
      {
        QLog.d("ConversationTitleBtnCtrl", 1, "version below 5.0, hide the camera");
        localObject1 = this.a;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = this.p;
        if (localObject1 != null) {
          ((RedTouch)localObject1).setVisibility(8);
        }
      }
      localObject1 = this.b;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.f;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      localObject1 = this.e;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
  }
  
  private void i()
  {
    QLog.d("ConversationTitleBtnCtrl", 1, "hideAllEntrances");
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.f;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.e;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.a;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.p;
    if (localObject != null) {
      ((RedTouch)localObject).setVisibility(8);
    }
    this.j = -1;
    this.v = null;
    this.k = null;
    this.n = 0;
    this.m = false;
    this.o = 0;
  }
  
  private void j()
  {
    int i1 = this.r;
    if ((i1 != 0) && (i1 != 2))
    {
      this.r = 0;
      ImageView localImageView = this.a;
      if (localImageView != null)
      {
        localImageView.setImageResource(2130853302);
        this.a.setContentDescription(this.t.getString(2131888164));
      }
    }
  }
  
  private void k()
  {
    if (this.r == 2)
    {
      this.i = true;
      ThreadManager.getSubThreadHandler().post(new ConversationTitleBtnCtrl.10(this));
    }
  }
  
  public void a()
  {
    this.b = this.q.d(2131431398);
    this.c = ((ImageView)this.q.d(2131431399));
    this.f = this.q.d(2131441657);
    this.g = ((ImageView)this.q.d(2131441656));
    this.d = this.b.findViewById(2131442553);
    this.e = ((TextView)this.q.d(2131431400));
    this.a = ((ImageView)this.q.d(2131431397));
    this.p = new RedTouch(this.q.P(), this.a).a();
    this.b.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.f.setOnClickListener(this);
    QzoneConfig.getInstance().addListener(this);
    a(true);
  }
  
  public void a(View paramView)
  {
    ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).beginSession();
    ((IAELaunchRecorder)QRoute.api(IAELaunchRecorder.class)).milestone("userClick");
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = PermissionUtils.isStorePermissionEnable(this.q.P());
    } else {
      bool = true;
    }
    if (!bool)
    {
      this.q.P().requestPermissions(new ConversationTitleBtnCtrl.7(this, paramView), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
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
    if ((QCircleConfigHelper.b(StudyModeManager.h())) && (QCircleConfigHelper.e(StudyModeManager.h())))
    {
      this.r = 2;
      h();
      b(paramBoolean);
    }
    else
    {
      this.r = 0;
      h();
    }
    if (QCircleConfigHelper.b(StudyModeManager.h()))
    {
      this.w = new ConversationTitleBtnCtrl.3(this);
      ThreadManager.getSubThreadHandler().post(this.w);
    }
  }
  
  public void b()
  {
    boolean bool = ((IExpandChatUtils)QRoute.api(IExpandChatUtils.class)).bNeedShowLimitChatInTitleEntrance(this.q.s());
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchType isMatchChatMode =");
      localStringBuilder.append(bool);
      QLog.d("ConversationTitleBtnCtrl", 4, localStringBuilder.toString());
    }
    if (bool)
    {
      this.a.setImageResource(2130853304);
      this.a.setContentDescription(this.t.getString(2131888163));
      this.r = 1;
    }
    else
    {
      j();
    }
    this.u.post(new ConversationTitleBtnCtrl.5(this));
  }
  
  public void b(View paramView)
  {
    Object localObject3 = this.p;
    Object localObject2 = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=mainCamera&uin=&appid=406&widgetid=&shareto=1";
    if (paramView != localObject3)
    {
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (!((RedTouch)localObject3).h()) {}
      }
    }
    else
    {
      localObject2 = (IRedTouchManager)this.q.aF.getRuntimeService(IRedTouchManager.class, "");
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
    this.q.P().startActivity((Intent)localObject1);
    ThreadManager.getUIHandler().postDelayed(new ConversationTitleBtnCtrl.8(this), 500L);
    if (paramView != this.p) {
      paramView = "1";
    } else {
      paramView = "3";
    }
    ReportController.b(null, "dc00898", "", "", "0X800A2D5", "0X800A2D5", 0, 0, paramView, "", "", "");
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = this.r;
    int i1 = 2;
    if (i2 != 2) {
      return;
    }
    if (!paramBoolean) {
      i1 = 5;
    }
    ThreadManager.post(new ConversationTitleBtnCtrl.4(this), i1, null, false);
  }
  
  public void c()
  {
    j();
    if ((this.p != null) && (MsgTabCameraSwitchProcessor.a().a == 1) && (Build.VERSION.SDK_INT >= 21) && (this.r == 0))
    {
      this.p.g();
      this.a.setVisibility(0);
    }
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.r == 2) {
      return;
    }
    if ((this.a != null) && (this.p != null))
    {
      if ((MsgTabCameraSwitchProcessor.a().a == 1) && (Build.VERSION.SDK_INT >= 21))
      {
        this.p.setVisibility(0);
        Object localObject1 = (IRedTouchManager)this.q.aF.getRuntimeService(IRedTouchManager.class, "");
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject1).getAppInfo(6, "120000");
        Object localObject2 = this.p;
        boolean bool1 = RedTouch.d(localAppInfo);
        boolean bool2 = this.p.h();
        if (bool1)
        {
          this.p.a(localAppInfo);
          int i1 = this.p.getOuterRedType();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshCameraRedTouch, outerRedType=");
          ((StringBuilder)localObject2).append(i1);
          QLog.i("ConversationTitleBtnCtrl", 1, ((StringBuilder)localObject2).toString());
          if (i1 == 0) {
            this.a.setVisibility(0);
          } else {
            this.a.setVisibility(8);
          }
          ((IRedTouchManager)localObject1).onRedTouchItemExposure(localAppInfo, null);
          if (!paramBoolean) {
            ReportController.b(null, "dc00898", "", "", "0X800A2D4", "0X800A2D4", 0, 0, "3", "", "", "");
          }
        }
        else if (bool2)
        {
          this.p.g();
          this.a.setVisibility(0);
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
        this.a.setVisibility(8);
        this.p.setVisibility(8);
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
    this.l = true;
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAfterSyncMsg ");
    localStringBuilder.append(this.r);
    QLog.d("ConversationTitleBtnCtrl", 1, localStringBuilder.toString());
    this.h = true;
    k();
  }
  
  public void g()
  {
    QCircleUtils.a().releaseWhenExitQCircle();
    if (this.w != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.w);
    }
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - s < 500L)
    {
      s = l1;
    }
    else
    {
      s = l1;
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("userClick time=");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("ConversationTitleBtnCtrl", 4, ((StringBuilder)localObject).toString());
      }
      int i1 = this.r;
      if (i1 == 0)
      {
        a(paramView);
      }
      else if (i1 == 1)
      {
        ((IExpandEntrance)QRoute.api(IExpandEntrance.class)).enterExpand(this.q.P(), this.q.s(), 6);
      }
      else if (i1 == 2)
      {
        localObject = this.b;
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
          if (!this.m) {
            localObject = "0";
          }
          localHashMap1.put("key_show_active_red_dot", localObject);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.n);
          ((StringBuilder)localObject).append("");
          localHashMap1.put("key_unread_red_num", ((StringBuilder)localObject).toString());
          if (this.j > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.j);
            ((StringBuilder)localObject).append("");
            localHashMap1.put("key_assign_show_tab_type", ((StringBuilder)localObject).toString());
          }
          localObject = this.v;
          if ((localObject != null) && (localObject.length > 0)) {
            localHashMap2.put("key_red_dot_trans_info", localObject);
          }
          ThreadManager.post(new ConversationTitleBtnCtrl.6(this), 5, null, false);
          if (this.n > 0) {
            a(2);
          } else if (this.m) {
            a(1);
          } else {
            a(3);
          }
          localHashMap1.put("xsj_main_entrance", "msg_ur_icon");
          QCircleUtils.a().enterBySchemeAction(this.q.P(), "openfolder", localHashMap1, localHashMap2);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onConfigChange()
  {
    this.u.post(new ConversationTitleBtnCtrl.9(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl
 * JD-Core Version:    0.7.0.1
 */