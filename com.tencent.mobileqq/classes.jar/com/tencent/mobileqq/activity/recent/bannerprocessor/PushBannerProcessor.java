package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerOnAddToView;
import com.tencent.mobileqq.config.Config;
import com.tencent.mobileqq.config.ConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Calendar;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class PushBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle, IBannerOnAddToView
{
  public float a;
  public int a;
  public boolean a;
  private boolean b = false;
  
  public PushBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(Message paramMessage)
  {
    if (a())
    {
      BannerManager.a().a(24, 2, paramMessage);
      paramMessage = (Conversation)FrameHelperActivity.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).a(Conversation.class);
      if (paramMessage != null) {
        paramMessage.z();
      }
      return;
    }
    BannerManager.a().a(24, 0, null);
  }
  
  private boolean a(View paramView)
  {
    Config localConfig = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getCurrentAccountUin(), false);
    if (localConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      e();
      return false;
    }
    int m = localConfig.a(0);
    if (m > 0)
    {
      ((ADView)paramView.findViewById(2131362258)).h();
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (a(localConfig, i, paramView)) {
          k = j + 1;
        }
        i += 1;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "loadPushBanner, addnum = " + j);
      }
      if (j > 0)
      {
        d();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Config paramConfig, int paramInt, View paramView)
  {
    PushBanner localPushBanner = new PushBanner(paramConfig.a(0, paramInt), paramConfig.b(0, paramInt), paramConfig.a(0, paramInt));
    localPushBanner.l = paramConfig.a(0, paramInt);
    localPushBanner.m = paramConfig.c(0, paramInt);
    boolean bool = localPushBanner.a(paramConfig.a(0, paramInt));
    if ((localPushBanner.c != null) && (localPushBanner.c.contains("|")) && (!CommonUtil.a(Long.parseLong(localPushBanner.c.substring(0, localPushBanner.c.indexOf("|"))), Long.parseLong(localPushBanner.c.substring(localPushBanner.c.indexOf("|") + 1))))) {
      return false;
    }
    if ((bool) && (!"".equals(localPushBanner.j)))
    {
      localPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = JumpParser.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localPushBanner.j);
      if (localPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction == null) {}
      for (int i = 0; i != 0; i = 1)
      {
        Object localObject = paramConfig.a(0, paramInt);
        if (QLog.isDevelopLevel()) {
          QLog.i("PUSH BANNER", 4, "addPushBanner, bannerPic = " + localObject);
        }
        if (localObject == null) {
          break;
        }
        paramConfig = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559767, null);
        ImageView localImageView = (ImageView)paramConfig.findViewById(2131362022);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localImageView.setImageBitmap((Bitmap)localObject);
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDisplayMetrics();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
        i = ((Bitmap)localObject).getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / ((Bitmap)localObject).getWidth();
        localLayoutParams.height = Math.max((int)(30.0F * localDisplayMetrics.density), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i));
        localImageView.setLayoutParams(localLayoutParams);
        localObject = (ImageView)paramConfig.findViewById(2131373725);
        ((ImageView)localObject).setTag(localPushBanner);
        ((ImageView)localObject).setContentDescription(HardCodeUtil.a(2131701005));
        ((ImageView)localObject).setOnClickListener(new PushBannerProcessor.3(this));
        paramConfig.setTag(localPushBanner);
        ((ADView)paramView.findViewById(2131362258)).a(paramConfig, paramInt);
        paramView.setTag(2131362258, localPushBanner.jdField_a_of_type_JavaLangString);
        return true;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getConfiguration().orientation == 1;
  }
  
  private boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount(), false);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSharedPreferences("mobileQQ", 0).getBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount(), true);
  }
  
  private void e()
  {
    ThreadManager.post(new PushBannerProcessor.2(this), 5, null, false);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559766, null);
    paramBanner.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    paramBanner.findViewById(2131373714).setVisibility(8);
    ((LinearLayout)paramBanner.findViewById(2131364815)).setOnClickListener(new PushBannerProcessor.1(this));
    return paramBanner;
  }
  
  public Object a(int paramInt)
  {
    Object localObject2 = null;
    Banner localBanner = BannerManager.a().a(24);
    Object localObject1 = localObject2;
    if (localBanner != null)
    {
      localObject1 = localObject2;
      if (localBanner.jdField_a_of_type_AndroidViewView != null)
      {
        if (paramInt != 0) {
          break label44;
        }
        localObject1 = localBanner.jdField_a_of_type_AndroidViewView.getTag();
      }
    }
    return localObject1;
    label44:
    return localBanner.jdField_a_of_type_AndroidViewView.getTag(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    Object localObject = BannerManager.a().a(24);
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362259);
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362258);
      if (localObject != null)
      {
        ((ADView)localObject).j();
        ((ADView)localObject).h();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.b = false;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight:" + paramFloat + ",mIsStoryShow:" + this.jdField_a_of_type_Boolean);
    }
    Object localObject1 = BannerManager.a().a(24);
    if ((localObject1 == null) || (((Banner)localObject1).jdField_a_of_type_AndroidViewView == null))
    {
      break label68;
      break label68;
    }
    for (;;)
    {
      label68:
      return;
      if (!((Banner)localObject1).jdField_a_of_type_Boolean) {
        continue;
      }
      if (paramFloat > 0.0F)
      {
        a(true);
        return;
      }
      localObject1 = ((Banner)localObject1).jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        break;
      }
      int i = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131373714);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int j = this.jdField_a_of_type_Int;
      label160:
      Object localObject2;
      int k;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localLayoutParams.height == this.jdField_a_of_type_Int) {
          break;
        }
        if (paramFloat < -j)
        {
          paramFloat = 0.0F;
          i = 0;
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height = " + localLayoutParams.height + "height:" + i + ",alpha:" + paramFloat);
          }
          if (localLayoutParams.height == i) {
            break;
          }
          if (i == 0)
          {
            localObject2 = a(2131362258);
            k = 0;
            j = k;
            if (localObject2 != null)
            {
              j = k;
              if (!(localObject2 instanceof String)) {}
            }
          }
        }
      }
      try
      {
        j = Integer.parseInt((String)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", j, 0, "", "", "", "");
        localLayoutParams.height = i;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
        return;
        if (paramFloat >= -3.0F)
        {
          i = this.jdField_a_of_type_Int;
          paramFloat = 1.0F;
          break label160;
        }
        paramFloat = (j - i) / this.jdField_a_of_type_Int;
        i = j - i;
        break label160;
        if (localLayoutParams.height == 0) {
          continue;
        }
        ((View)localObject1).findViewById(2131364815).setVisibility(4);
        if (paramFloat < this.jdField_a_of_type_Float - j)
        {
          paramFloat = 0.0F;
          i = 0;
          break label160;
        }
        if (paramFloat < this.jdField_a_of_type_Float)
        {
          i = (int)(j + paramFloat - this.jdField_a_of_type_Float);
          paramFloat = i / j;
          break label160;
        }
        i = this.jdField_a_of_type_Int;
        paramFloat = 1.0F;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
          j = k;
        }
      }
    }
  }
  
  public void a(Banner paramBanner)
  {
    if ((paramBanner.jdField_a_of_type_Int == 24) && (this.jdField_a_of_type_Boolean)) {
      paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131373714).getLayoutParams().height = 0;
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131373714).setVisibility(0);
    paramMessage = (RelativeLayout)paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131362259);
    paramBanner = (ADView)paramBanner.jdField_a_of_type_AndroidViewView.findViewById(2131362258);
    if (b())
    {
      paramMessage.setPadding(0, 0, 0, 0);
      paramBanner.i();
    }
    for (;;)
    {
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
      return;
      paramMessage.setPadding(0, -1, 0, 0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = BannerManager.a().a(24);
    if ((localObject1 == null) || (((Banner)localObject1).jdField_a_of_type_AndroidViewView == null)) {}
    label20:
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    do
    {
      do
      {
        do
        {
          break label20;
          do
          {
            return;
          } while (!((Banner)localObject1).jdField_a_of_type_Boolean);
          localObject1 = ((Banner)localObject1).jdField_a_of_type_AndroidViewView;
        } while (localObject1 == null);
        localObject1 = ((View)localObject1).findViewById(2131373714);
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "fight.setPushBannerHeight.lp.height1 = " + localLayoutParams.height);
        }
        if (!paramBoolean) {
          break;
        }
      } while ((localLayoutParams.height == this.jdField_a_of_type_Int) && (((View)localObject1).findViewById(2131364815).getVisibility() == 0) && (((View)localObject1).getAlpha() == 1.0F));
      ((View)localObject1).findViewById(2131364815).setVisibility(0);
      ((View)localObject1).setAlpha(1.0F);
      localLayoutParams.height = this.jdField_a_of_type_Int;
      ((View)localObject1).requestLayout();
      localObject1 = a(2131362258);
      if ((localObject1 != null) && ((localObject1 instanceof String))) {}
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)localObject1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "3", "", "", "");
          return;
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        i = 0;
      }
    } while (localLayoutParams.height == 0);
    localThrowable1.findViewById(2131364815).setVisibility(4);
    localThrowable1.setAlpha(0.0F);
    localLayoutParams.height = 0;
    localThrowable1.requestLayout();
    Object localObject2 = a(2131362258);
    if ((localObject2 != null) && ((localObject2 instanceof String))) {}
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject2);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", i, 0, "", "", "", "");
        return;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
      }
      i = 0;
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public boolean a()
  {
    boolean bool1 = true;
    boolean bool2 = c();
    if ((this.b) && (!bool2)) {}
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent.banner", 4, "isNeedShowPushBanner, isNeedShow = " + bool1);
      }
      return bool1;
      if (d())
      {
        Object localObject = BannerManager.a().a(24);
        if (localObject != null) {}
        for (localObject = a((Banner)localObject);; localObject = null)
        {
          if (localObject != null) {}
          for (bool1 = a((View)localObject);; bool1 = false)
          {
            if (bool1)
            {
              ((View)localObject).findViewById(2131373714).setVisibility(0);
              this.b = true;
              this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("reveive_newpb" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount(), false).commit();
            }
            break;
          }
        }
      }
      bool1 = false;
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    Object localObject = BannerManager.a().a(24);
    ViewGroup localViewGroup;
    int j;
    int i;
    if ((localObject != null) && (((Banner)localObject).jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)((Banner)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131362258);
      localViewGroup = ((ADView)localObject).a(0);
      if (localViewGroup != null)
      {
        j = localViewGroup.getChildCount();
        i = 0;
        j -= 1;
        if (j >= 0)
        {
          View localView = localViewGroup.getChildAt(j);
          PushBanner localPushBanner = (PushBanner)localView.getTag();
          String str = localPushBanner.c;
          int k = str.indexOf("|");
          if (CommonUtil.a(Long.parseLong(str.substring(0, k)), Long.parseLong(str.substring(k + 1)))) {
            break label292;
          }
          ((ADView)localObject).a(0, j, localView);
          Config.a.a(localPushBanner.l);
          i = 1;
        }
      }
    }
    label292:
    for (;;)
    {
      j -= 1;
      break;
      if (i != 0)
      {
        if (localViewGroup.getChildCount() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount(), false).commit();
          ((ADView)localObject).h();
          BannerManager.a().a(24, 0, null);
          this.b = false;
        }
        for (;;)
        {
          localObject = new ConfigManager(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext(), ConfigServlet.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            ((ConfigManager)localObject).b();
            ((ConfigManager)localObject).c();
          }
          return;
          d();
        }
      }
      d();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 0);
    localCalendar.clear(12);
    localCalendar.clear(13);
    localCalendar.clear(14);
    l = localCalendar.getTimeInMillis() - (l - 10L) + 300000L;
    if (QLog.isColorLevel()) {
      QLog.d("PushBanner", 2, "Check banner delay: " + l);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, l);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner");
        }
        c();
      }
      catch (Exception paramMessage) {}
      if (QLog.isColorLevel())
      {
        QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
        continue;
        a(paramMessage);
        continue;
        a(paramMessage.getData().getFloat("height"));
        continue;
        a(paramMessage.getData().getBoolean("visible"));
        continue;
        a(paramMessage.getData().getBoolean("isStoryShow"), paramMessage.getData().getFloat("nodeOffset"));
        continue;
        a(paramMessage.arg1);
        continue;
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Int = AIOUtils.a(50.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
          continue;
          a(paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor
 * JD-Core Version:    0.7.0.1
 */