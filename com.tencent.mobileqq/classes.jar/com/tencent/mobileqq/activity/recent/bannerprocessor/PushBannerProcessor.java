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
import com.tencent.mobileqq.banner.BannerTypeCollections;
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
  public static final int a = BannerTypeCollections.y;
  public boolean b = false;
  public float c = 0.0F;
  public int d;
  private boolean e = false;
  
  public PushBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(Message paramMessage)
  {
    if (f())
    {
      BannerManager.a().a(a, 2, paramMessage);
      paramMessage = FrameHelperActivity.a((BaseActivity)this.f);
      if (paramMessage == null) {
        return;
      }
      paramMessage = (Conversation)paramMessage.a(Conversation.class);
      if (paramMessage != null) {
        paramMessage.L();
      }
    }
    else
    {
      BannerManager.a().a(a, 0, null);
    }
  }
  
  private boolean a(View paramView)
  {
    Config localConfig = ((QQAppInterface)this.f.getAppRuntime()).getConfig(this.f.getAppRuntime().getCurrentAccountUin(), false);
    if (localConfig == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushBannerConfig", 2, "loadPushBanner");
      }
      k();
      return false;
    }
    int m = localConfig.a(0);
    if (m > 0)
    {
      ((ADView)paramView.findViewById(2131427870)).i();
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
      if (QLog.isDevelopLevel())
      {
        paramView = new StringBuilder();
        paramView.append("loadPushBanner, addnum = ");
        paramView.append(j);
        QLog.i("Q.recent.banner", 4, paramView.toString());
      }
      if (j > 0)
      {
        g();
        return true;
      }
    }
    return false;
  }
  
  private boolean a(Config paramConfig, int paramInt, View paramView)
  {
    PushBanner localPushBanner = new PushBanner(paramConfig.f(0, paramInt), paramConfig.d(0, paramInt), paramConfig.b(0, paramInt));
    localPushBanner.n = paramConfig.c(0, paramInt);
    localPushBanner.o = paramConfig.e(0, paramInt);
    boolean bool = localPushBanner.a(paramConfig.c(0, paramInt));
    if ((localPushBanner.c != null) && (localPushBanner.c.contains("|")) && (!CommonUtil.a(Long.parseLong(localPushBanner.c.substring(0, localPushBanner.c.indexOf("|"))), Long.parseLong(localPushBanner.c.substring(localPushBanner.c.indexOf("|") + 1))))) {
      return false;
    }
    if ((bool) && (!"".equals(localPushBanner.k)))
    {
      localPushBanner.m = JumpParser.a((QQAppInterface)this.f.getAppRuntime(), this.f, localPushBanner.k);
      int i;
      if (localPushBanner.m == null) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramConfig = paramConfig.a(0, paramInt);
        Object localObject;
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addPushBanner, bannerPic = ");
          ((StringBuilder)localObject).append(paramConfig);
          QLog.i("PUSH BANNER", 4, ((StringBuilder)localObject).toString());
        }
        if (paramConfig != null)
        {
          localObject = (FrameLayout)this.f.getLayoutInflater().inflate(2131625673, null);
          ImageView localImageView = (ImageView)((FrameLayout)localObject).findViewById(2131427615);
          localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          localImageView.setImageBitmap(paramConfig);
          DisplayMetrics localDisplayMetrics = this.f.getResources().getDisplayMetrics();
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView.getLayoutParams();
          i = paramConfig.getHeight() * Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) / paramConfig.getWidth();
          localLayoutParams.height = Math.max((int)(localDisplayMetrics.density * 30.0F), Math.min(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 68 / 320, i));
          localImageView.setLayoutParams(localLayoutParams);
          paramConfig = (ImageView)((FrameLayout)localObject).findViewById(2131440907);
          paramConfig.setTag(localPushBanner);
          paramConfig.setContentDescription(HardCodeUtil.a(2131899165));
          paramConfig.setOnClickListener(new PushBannerProcessor.3(this));
          ((FrameLayout)localObject).setTag(localPushBanner);
          ((ADView)paramView.findViewById(2131427870)).a((View)localObject, paramInt);
          paramView.setTag(2131427870, localPushBanner.a);
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean h()
  {
    return this.f.getResources().getConfiguration().orientation == 1;
  }
  
  private boolean i()
  {
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reveive_newpb");
    localStringBuilder.append(this.f.getAppRuntime().getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private boolean j()
  {
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("push_banner_display");
    localStringBuilder.append(this.f.getAppRuntime().getAccount());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  private void k()
  {
    ThreadManager.post(new PushBannerProcessor.2(this), 5, null, false);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = this.f.getLayoutInflater().inflate(2131625672, null);
    paramBanner.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    paramBanner.findViewById(2131440895).setVisibility(8);
    ((LinearLayout)paramBanner.findViewById(2131430806)).setOnClickListener(new PushBannerProcessor.1(this));
    return paramBanner;
  }
  
  public Object a(int paramInt)
  {
    Banner localBanner = BannerManager.a().a(a);
    if ((localBanner != null) && (localBanner.c != null))
    {
      if (paramInt == 0) {
        return localBanner.c.getTag();
      }
      return localBanner.c.getTag(paramInt);
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("fight.setPushBannerHeight:");
      ((StringBuilder)localObject1).append(paramFloat);
      ((StringBuilder)localObject1).append(",mIsStoryShow:");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = BannerManager.a().a(a);
    if (localObject1 != null)
    {
      if (((Banner)localObject1).c == null) {
        return;
      }
      if (!((Banner)localObject1).d) {
        return;
      }
      float f1 = 0.0F;
      if (paramFloat > 0.0F)
      {
        a(true);
        return;
      }
      localObject1 = ((Banner)localObject1).c;
      if (localObject1 == null) {
        return;
      }
      int j = (int)Math.abs(paramFloat);
      localObject1 = ((View)localObject1).findViewById(2131440895);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      int k = this.d;
      float f2;
      float f3;
      if (this.b)
      {
        int m = localLayoutParams.height;
        i = this.d;
        if (m == i) {
          return;
        }
        if (paramFloat >= -k)
        {
          if (paramFloat >= -3.0F) {
            break label304;
          }
          j = k - j;
          paramFloat = j / i;
          i = j;
          break label295;
        }
      }
      else
      {
        if (localLayoutParams.height == 0) {
          return;
        }
        ((View)localObject1).findViewById(2131430806).setVisibility(4);
        f2 = this.c;
        f3 = k;
        if (paramFloat >= f2 - f3) {
          break label273;
        }
      }
      int i = 0;
      paramFloat = f1;
      break label306;
      label273:
      if (paramFloat < f2)
      {
        i = (int)(paramFloat + f3 - f2);
        paramFloat = i / f3;
      }
      else
      {
        label295:
        i = this.d;
        label304:
        paramFloat = 1.0F;
      }
      label306:
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("fight.setPushBannerHeight.lp.height = ");
        ((StringBuilder)localObject2).append(localLayoutParams.height);
        ((StringBuilder)localObject2).append("height:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",alpha:");
        ((StringBuilder)localObject2).append(paramFloat);
        QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject2).toString());
      }
      if (localLayoutParams.height != i)
      {
        if (i == 0)
        {
          localObject2 = a(2131427870);
          if ((localObject2 != null) && ((localObject2 instanceof String))) {
            try
            {
              j = Integer.parseInt((String)localObject2);
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          } else {
            j = 0;
          }
          ReportController.b(this.f.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", j, 0, "", "", "", "");
        }
        localLayoutParams.height = i;
        ((View)localObject1).setAlpha(paramFloat);
        ((View)localObject1).requestLayout();
      }
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.findViewById(2131440895).setVisibility(0);
    paramMessage = (RelativeLayout)paramBanner.c.findViewById(2131427871);
    paramBanner = (ADView)paramBanner.c.findViewById(2131427870);
    if (h())
    {
      paramMessage.setPadding(0, 0, 0, 0);
      paramBanner.j();
    }
    else
    {
      paramMessage.setPadding(0, -1, 0, 0);
    }
    ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 12, 0, "", "", "", "");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1 = BannerManager.a().a(a);
    if (localObject1 != null)
    {
      if (((Banner)localObject1).c == null) {
        return;
      }
      if (!((Banner)localObject1).d) {
        return;
      }
      localObject1 = ((Banner)localObject1).c;
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((View)localObject1).findViewById(2131440895);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject1).getLayoutParams();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fight.setPushBannerHeight.lp.height1 = ");
        localStringBuilder.append(localLayoutParams.height);
        QLog.d("Q.recent.banner", 2, localStringBuilder.toString());
      }
      int i;
      if (paramBoolean)
      {
        if ((localLayoutParams.height != this.d) || (((View)localObject1).findViewById(2131430806).getVisibility() != 0) || (((View)localObject1).getAlpha() != 1.0F))
        {
          ((View)localObject1).findViewById(2131430806).setVisibility(0);
          ((View)localObject1).setAlpha(1.0F);
          localLayoutParams.height = this.d;
          ((View)localObject1).requestLayout();
          localObject1 = a(2131427870);
          if ((localObject1 != null) && ((localObject1 instanceof String))) {
            try
            {
              i = Integer.parseInt((String)localObject1);
            }
            catch (Throwable localThrowable1)
            {
              localThrowable1.printStackTrace();
            }
          } else {
            i = 0;
          }
          ReportController.b(this.f.getAppRuntime(), "dc00898", "", "", "0X80087C2", "0X80087C2", i, 0, "3", "", "", "");
        }
      }
      else if (localLayoutParams.height != 0)
      {
        localThrowable1.findViewById(2131430806).setVisibility(4);
        localThrowable1.setAlpha(0.0F);
        localLayoutParams.height = 0;
        localThrowable1.requestLayout();
        Object localObject2 = a(2131427870);
        if ((localObject2 != null) && ((localObject2 instanceof String))) {
          try
          {
            i = Integer.parseInt((String)localObject2);
          }
          catch (Throwable localThrowable2)
          {
            localThrowable2.printStackTrace();
          }
        } else {
          i = 0;
        }
        ReportController.b(this.f.getAppRuntime(), "dc00898", "", "", "0X80094CD", "0X80094CD", i, 0, "", "", "", "");
      }
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    this.b = paramBoolean;
    this.c = paramFloat;
  }
  
  public int b()
  {
    return a;
  }
  
  public void b(Banner paramBanner)
  {
    if ((paramBanner.a == a) && (this.b)) {
      paramBanner.c.findViewById(2131440895).getLayoutParams().height = 0;
    }
  }
  
  public void c()
  {
    this.g.removeMessages(1000);
    Object localObject = BannerManager.a().a(a);
    if ((localObject != null) && (((Banner)localObject).c != null))
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)((Banner)localObject).c.findViewById(2131427871);
      localObject = (ADView)((Banner)localObject).c.findViewById(2131427870);
      if (localObject != null)
      {
        ((ADView)localObject).k();
        ((ADView)localObject).i();
      }
      if (localRelativeLayout != null) {
        localRelativeLayout.setPadding(0, -1, 0, 0);
      }
    }
    this.e = false;
  }
  
  public void d() {}
  
  public void e()
  {
    Object localObject1 = BannerManager.a().a(a);
    if ((localObject1 != null) && (((Banner)localObject1).c != null))
    {
      localObject1 = (ADView)((Banner)localObject1).c.findViewById(2131427870);
      Object localObject2 = ((ADView)localObject1).e(0);
      if (localObject2 != null)
      {
        int i = ((ViewGroup)localObject2).getChildCount() - 1;
        int j = 0;
        Object localObject3;
        while (i >= 0)
        {
          localObject3 = ((ViewGroup)localObject2).getChildAt(i);
          PushBanner localPushBanner = (PushBanner)((View)localObject3).getTag();
          String str = localPushBanner.c;
          int k = str.indexOf("|");
          if (!CommonUtil.a(Long.parseLong(str.substring(0, k)), Long.parseLong(str.substring(k + 1))))
          {
            ((ADView)localObject1).a(0, i, (View)localObject3);
            Config.c.a(localPushBanner.n);
            j = 1;
          }
          i -= 1;
        }
        if (j != 0)
        {
          if (((ViewGroup)localObject2).getChildCount() == 0)
          {
            localObject2 = this.f.getSharedPreferences("mobileQQ", 0).edit();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("push_banner_display");
            ((StringBuilder)localObject3).append(this.f.getAppRuntime().getAccount());
            ((SharedPreferences.Editor)localObject2).putBoolean(((StringBuilder)localObject3).toString(), false).commit();
            ((ADView)localObject1).i();
            BannerManager.a().a(a, 0, null);
            this.e = false;
          }
          else
          {
            g();
          }
          localObject1 = new ConfigManager(this.f.getApplicationContext(), ConfigServlet.a);
          ((ConfigManager)localObject1).c();
          ((ConfigManager)localObject1).d();
          return;
        }
        g();
      }
    }
  }
  
  public boolean f()
  {
    boolean bool1 = i();
    boolean bool2;
    Object localObject1;
    if ((this.e) && (!bool1))
    {
      bool2 = true;
    }
    else if (j())
    {
      Object localObject2 = BannerManager.a().a(a);
      localObject1 = null;
      if (localObject2 != null) {
        localObject1 = a((Banner)localObject2);
      }
      if (localObject1 != null) {
        bool1 = a((View)localObject1);
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (bool1)
      {
        ((View)localObject1).findViewById(2131440895).setVisibility(0);
        this.e = true;
        localObject1 = this.f.getSharedPreferences("mobileQQ", 0).edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reveive_newpb");
        ((StringBuilder)localObject2).append(this.f.getAppRuntime().getAccount());
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), false).commit();
        bool2 = bool1;
      }
    }
    else
    {
      bool2 = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isNeedShowPushBanner, isNeedShow = ");
      ((StringBuilder)localObject1).append(bool2);
      QLog.i("Q.recent.banner", 4, ((StringBuilder)localObject1).toString());
    }
    return bool2;
  }
  
  public void g()
  {
    this.g.removeMessages(1000);
    long l = System.currentTimeMillis();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).add(5, 1);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).clear(12);
    ((Calendar)localObject).clear(13);
    ((Calendar)localObject).clear(14);
    l = ((Calendar)localObject).getTimeInMillis() - (l - 10L) + 300000L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Check banner delay: ");
      ((StringBuilder)localObject).append(l);
      QLog.d("PushBanner", 2, ((StringBuilder)localObject).toString());
    }
    this.g.sendEmptyMessageDelayed(1000, l);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1000)
    {
      if (i != 4000) {
        switch (i)
        {
        default: 
          break;
        case 2005: 
          if (this.d != 0) {
            break;
          }
          this.d = AIOUtils.b(50.0F, this.f.getResources());
          break;
        case 2004: 
          a(paramMessage.arg1);
          break;
        case 2003: 
          a(paramMessage.getData().getBoolean("isStoryShow"), paramMessage.getData().getFloat("nodeOffset"));
          break;
        case 2002: 
          a(paramMessage.getData().getBoolean("visible"));
          break;
        case 2001: 
          a(paramMessage.getData().getFloat("height"));
          break;
        case 2000: 
          a(paramMessage);
          break;
        }
      } else {
        a(paramMessage.arg1);
      }
    }
    else {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner");
        }
        e();
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushBanner", 2, "checkAndClosePushBanner Exception:", paramMessage);
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor
 * JD-Core Version:    0.7.0.1
 */