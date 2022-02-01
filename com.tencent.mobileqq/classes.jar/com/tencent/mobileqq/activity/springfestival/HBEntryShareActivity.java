package com.tencent.mobileqq.activity.springfestival;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class HBEntryShareActivity
  extends BaseActivity
  implements View.OnClickListener
{
  View.OnTouchListener a = new HBEntryShareActivity.1(this);
  private volatile Drawable b;
  private volatile String c;
  
  private Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    return Utils.a(this.app, paramString, paramInt1, paramInt2, "");
  }
  
  private StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[] { -16842919 }, paramDrawable1);
    return localStateListDrawable;
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private ViewGroup a(Intent paramIntent, int paramInt)
  {
    if (paramIntent == null)
    {
      QLog.d("HBEntryShareActivity", 1, "loadShareLayoutByIntent finish for null intent");
      finish();
      return null;
    }
    int m = paramIntent.getIntExtra("all_count", 0);
    int j = paramIntent.getIntExtra("max_count", 0);
    int k = paramIntent.getIntExtra("pag_count", 0);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = k;
    if (k < 0) {
      j = 0;
    }
    if ((m != 0) && (i != 0))
    {
      Object localObject1 = (ViewGroup)getWindow().getDecorView().findViewById(16908290);
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(paramInt, (ViewGroup)localObject1, false);
      localObject1 = (ImageView)localViewGroup.findViewById(2131442331);
      Object localObject2 = (TextView)localViewGroup.findViewById(2131442332);
      paramIntent.getStringExtra("header_icon");
      Object localObject3 = paramIntent.getStringExtra("header_name");
      String str = paramIntent.getStringExtra("header_text");
      if ((this.b != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(str)))
      {
        ((ImageView)localObject1).setImageDrawable(this.b);
        ((TextView)localObject2).setText(String.format("%s%s", new Object[] { localObject3, str }));
      }
      else
      {
        ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130846729));
        ((TextView)localObject2).setText(getResources().getString(2131897349));
      }
      localObject1 = FaceDrawable.getDefaultDrawable(1, 3);
      localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 3, (Drawable)localObject1, (Drawable)localObject1, null);
      ((ImageView)localViewGroup.findViewById(2131442338)).setImageDrawable((Drawable)localObject1);
      ((TextView)localViewGroup.findViewById(2131442339)).setText(ContactUtils.c(this.app, this.app.getCurrentUin()));
      localObject1 = Typeface.createFromAsset(getAssets(), "fonts/HuNan-CC.ttf");
      localObject2 = (TextView)localViewGroup.findViewById(2131442327);
      ((TextView)localObject2).setTypeface((Typeface)localObject1);
      ((TextView)localObject2).setText(String.valueOf(m));
      localObject3 = (FrameLayout)localViewGroup.findViewById(2131442341);
      localObject2 = Utils.a(this.app, paramIntent.getStringExtra("background_img2"), ((FrameLayout)localObject3).getWidth(), ((FrameLayout)localObject3).getHeight(), "default_share_bg_fullscreen");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.d("HBEntryShareActivity", 1, "load full bg null");
        localObject1 = getResources().getDrawable(2130846876);
      }
      ((FrameLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
      ((TextView)localViewGroup.findViewById(2131442328)).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131897360), Integer.valueOf(i), getResources().getString(2131897358) }));
      localObject1 = (TextView)localViewGroup.findViewById(2131442329);
      if (j > 0)
      {
        ((TextView)localObject1).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131897362), Integer.valueOf(j), getResources().getString(2131897361) }));
        ((TextView)localObject1).setVisibility(0);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject2 = a(getIntent().getStringExtra("middle_img2"), 320, 400);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getResources().getDrawable(2130846875);
      }
      ((LinearLayout)localViewGroup.findViewById(2131442324)).setBackgroundDrawable((Drawable)localObject1);
      localObject1 = (FrameLayout)localViewGroup.findViewById(2131442322);
      localObject2 = (RoundImageView)localViewGroup.findViewById(2131442321);
      localObject3 = a(getIntent().getStringExtra("qrcode_code"), 80, 80);
      if (localObject3 != null)
      {
        ((FrameLayout)localObject1).setBackgroundDrawable(getResources().getDrawable(2130846885));
        ((RoundImageView)localObject2).setImageDrawable((Drawable)localObject3);
      }
      else
      {
        ((FrameLayout)localObject1).setBackgroundColor(0);
        ((RoundImageView)localObject2).setImageDrawable(getResources().getDrawable(2130846729));
      }
      localObject1 = paramIntent.getStringExtra("bottom_text");
      paramIntent = (Intent)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramIntent = getResources().getString(2131897364);
      }
      ((TextView)localViewGroup.findViewById(2131442323)).setText(paramIntent);
      return localViewGroup;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("loadShareLayoutByIntent finish,allCount = ");
    paramIntent.append(m);
    paramIntent.append(",maxCount = ");
    paramIntent.append(i);
    QLog.d("HBEntryShareActivity", 1, paramIntent.toString());
    finish();
    return null;
  }
  
  public static String a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      if ((paramView.getWidth() <= 0) || (paramView.getHeight() <= 0))
      {
        paramView.measure(0, 0);
        paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveView, width:");
        ((StringBuilder)localObject).append(paramView.getMeasuredWidth());
        ((StringBuilder)localObject).append(", heiht:");
        ((StringBuilder)localObject).append(paramView.getMeasuredHeight());
        QLog.d("HBEntryShareActivity", 2, ((StringBuilder)localObject).toString());
      }
      localObject = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.RGB_565);
      paramView.draw(new Canvas((Bitmap)localObject));
      paramView = String.format("%s/%s.jpg", new Object[] { BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath(), Long.valueOf(System.currentTimeMillis()) });
      boolean bool = FileUtil.a((Bitmap)localObject, paramView);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveView, wrote:");
        localStringBuilder.append(bool);
        localStringBuilder.append(", path:");
        localStringBuilder.append(paramView);
        localStringBuilder.append(",fileSize = ");
        localStringBuilder.append(FileUtils.getFileSizes(paramView));
        QLog.d("HBEntryShareActivity", 2, localStringBuilder.toString());
      }
      ((Bitmap)localObject).recycle();
      return paramView;
    }
    catch (Throwable paramView)
    {
      SpringHbMonitorReporter.a(404, paramView, new String[0]);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveView2File exception, throwable=");
      ((StringBuilder)localObject).append(paramView.getMessage());
      QLog.d("HBEntryShareActivity", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private void a()
  {
    if (FileUtil.d(this.c))
    {
      ScreenShotHelper.a(this, this.c, true);
      return;
    }
    a(true);
    ViewGroup localViewGroup = a(getIntent(), 2131627465);
    if (localViewGroup != null) {
      localViewGroup.requestLayout();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new HBEntryShareActivity.3(this, localViewGroup), 500L);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, List<String> paramList, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startActivity ,activityId = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",allCnt = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",maxCnt = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",pagCnt = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",headerIcon = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",headerName = ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(",headerText = ");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(",bg1Url = ");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(",bg2Url = ");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(",bottomCode = ");
      localStringBuilder.append(paramString7);
      localStringBuilder.append(",ticketList = ");
      if (paramList != null) {
        localObject = paramList.toString();
      } else {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",middleImgUrl1 = ");
      localStringBuilder.append(paramString9);
      localStringBuilder.append(",middleImgUrl2 = ");
      localStringBuilder.append(paramString10);
      localStringBuilder.append(",btnImgUrl1 = ");
      localStringBuilder.append(paramString11);
      localStringBuilder.append(",btnImgUrl2 = ");
      localStringBuilder.append(paramString12);
      localStringBuilder.append(",btnImgApngUrl = ");
      localStringBuilder.append(paramString13);
      QLog.d("HBEntryShareActivity", 2, localStringBuilder.toString());
    }
    Object localObject = new Intent(paramBaseActivity, HBEntryShareActivity.class);
    if ((paramList != null) && (!paramList.isEmpty())) {
      ((Intent)localObject).putExtra("ticket_text", (String)paramList.get(new Random().nextInt(paramList.size())));
    }
    ((Intent)localObject).putExtra("all_count", paramInt1);
    ((Intent)localObject).putExtra("max_count", paramInt2);
    ((Intent)localObject).putExtra("pag_count", paramInt3);
    ((Intent)localObject).putExtra("not_share", paramInt4);
    ((Intent)localObject).putExtra("background_img1", paramString5);
    ((Intent)localObject).putExtra("background_img2", paramString6);
    ((Intent)localObject).putExtra("header_icon", paramString2);
    ((Intent)localObject).putExtra("header_name", paramString3);
    ((Intent)localObject).putExtra("header_text", paramString4);
    ((Intent)localObject).putExtra("qrcode_code", paramString7);
    ((Intent)localObject).putExtra("bottom_text", paramString8);
    ((Intent)localObject).putExtra("activity_id", paramString1);
    ((Intent)localObject).putExtra("button_img1", paramString11);
    ((Intent)localObject).putExtra("button_img2", paramString12);
    ((Intent)localObject).putExtra("button_img_apng", paramString13);
    ((Intent)localObject).putExtra("middle_img1", paramString9);
    ((Intent)localObject).putExtra("middle_img2", paramString10);
    paramBaseActivity.startActivity((Intent)localObject);
    paramBaseActivity.overridePendingTransition(2130772435, 2130772007);
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("active_id", getIntent().getStringExtra("activity_id"));
    SpringHbReporter.a(ReportConstant.Event.n, 0, 1, (Map)localObject, paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = findViewById(2131442335);
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private boolean a(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      QLog.d("HBEntryShareActivity", 1, "initViewByIntent finish for null intent");
      finish();
      return false;
    }
    int m = paramIntent.getIntExtra("all_count", 0);
    int k = paramIntent.getIntExtra("max_count", 0);
    int j = paramIntent.getIntExtra("pag_count", 0);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("allCount=");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(", maxCount=");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(", pagCount=");
      ((StringBuilder)localObject1).append(j);
      QLog.d("HBEntryShareActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if ((m > 0) && (k > 0))
    {
      int i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k > m) {
        j = m;
      }
      setContentView(2131627464);
      findViewById(2131442326).setOnClickListener(this);
      findViewById(2131442336).setOnClickListener(this);
      findViewById(2131442335).setVisibility(8);
      localObject1 = Typeface.createFromAsset(getAssets(), "fonts/HuNan-CC.ttf");
      Object localObject2 = (TextView)findViewById(2131442327);
      ((TextView)localObject2).setTypeface((Typeface)localObject1);
      ((TextView)localObject2).setText(String.valueOf(m));
      ((TextView)findViewById(2131442328)).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131897360), Integer.valueOf(j), getResources().getString(2131897358) }));
      localObject2 = paramIntent.getStringExtra("ticket_text");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getResources().getString(2131897363);
      }
      ((TextView)findViewById(2131442337)).setText((CharSequence)localObject1);
      Object localObject3 = (RelativeLayout)findViewById(2131442333);
      localObject2 = Utils.a(this.app, paramIntent.getStringExtra("background_img1"), ((RelativeLayout)localObject3).getWidth(), ((RelativeLayout)localObject3).getHeight(), "default_share_bg_window");
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        QLog.d("HBEntryShareActivity", 1, "load window bg null");
        localObject1 = getResources().getDrawable(2130846874);
      }
      ((RelativeLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
      localObject3 = (LinearLayout)findViewById(2131442324);
      localObject2 = a(paramIntent.getStringExtra("middle_img1"), ((LinearLayout)localObject3).getWidth(), ((LinearLayout)localObject3).getHeight());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = getResources().getDrawable(2130846875);
      }
      ((LinearLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
      localObject1 = (ImageView)findViewById(2131442331);
      localObject2 = (TextView)findViewById(2131442332);
      paramIntent.getStringExtra("header_icon");
      localObject3 = paramIntent.getStringExtra("header_name");
      paramIntent = paramIntent.getStringExtra("header_text");
      if ((this.b != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(paramIntent)))
      {
        ((ImageView)localObject1).setImageDrawable(this.b);
        ((TextView)localObject2).setText(String.format("%s%s", new Object[] { localObject3, paramIntent }));
      }
      else
      {
        ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130846729));
        ((TextView)localObject2).setText(getResources().getString(2131897349));
      }
      localObject1 = (TextView)findViewById(2131442336);
      if (getIntent().getIntExtra("not_share", 0) == 1) {
        k = 4;
      } else {
        k = 0;
      }
      ((TextView)localObject1).setVisibility(k);
      if (((TextView)localObject1).getVisibility() == 0)
      {
        paramIntent = a(getIntent().getStringExtra("button_img1"), AIOUtils.b(154.0F, getResources()), AIOUtils.b(45.0F, getResources()));
        localObject2 = a(getIntent().getStringExtra("button_img2"), AIOUtils.b(154.0F, getResources()), AIOUtils.b(45.0F, getResources()));
        if ((paramIntent != null) && (localObject2 != null)) {
          paramIntent = a(paramIntent, (Drawable)localObject2);
        } else {
          paramIntent = a(getResources().getDrawable(2130846877), getResources().getDrawable(2130846878));
        }
        ((TextView)localObject1).setBackgroundDrawable(paramIntent);
      }
      try
      {
        paramIntent = getIntent().getStringExtra("button_img_apng");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("initViewByIntent btnImgApngUrl = ");
          ((StringBuilder)localObject2).append(paramIntent);
          QLog.d("HBEntryShareActivity", 2, ((StringBuilder)localObject2).toString());
        }
        if (!TextUtils.isEmpty(paramIntent))
        {
          localObject3 = (SpringFestivalEntryManager)getAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
          localObject2 = ((SpringFestivalEntryManager)localObject3).b(paramIntent);
          boolean bool = FileUtils.fileExists((String)localObject2);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initViewByIntent btnImgApngUrl exist = ");
            localStringBuilder.append(bool);
            localStringBuilder.append(",apngFilePath = ");
            localStringBuilder.append((String)localObject2);
            QLog.d("HBEntryShareActivity", 2, localStringBuilder.toString());
          }
          if (bool)
          {
            paramIntent = new ApngOptions();
            paramIntent.a(URLDrawableHelperConstants.a);
            ((TextView)localObject1).setBackgroundDrawable(((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", paramIntent, (String)localObject2));
            ((TextView)localObject1).setOnTouchListener(this.a);
          }
          else
          {
            ((SpringFestivalEntryManager)localObject3).a(new HBEntryShareActivity.2(this, paramIntent, (TextView)localObject1, (SpringFestivalEntryManager)localObject3));
          }
        }
      }
      catch (Exception paramIntent)
      {
        SpringHbMonitorReporter.a(406, paramIntent, new String[0]);
        QLog.d("HBEntryShareActivity", 1, "initViewByIntent exception ", paramIntent);
      }
      paramIntent = new HashMap();
      paramIntent.put("ext1", String.valueOf(m));
      paramIntent.put("ext2", String.valueOf(j));
      paramIntent.put("ext3", String.valueOf(i));
      a("exp", paramIntent);
      return true;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("initViewByIntent finish,allCount = ");
    paramIntent.append(m);
    paramIntent.append(",maxCount = ");
    paramIntent.append(k);
    QLog.d("HBEntryShareActivity", 1, paramIntent.toString());
    finish();
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFlags(1024, 1024);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.b = a(getIntent().getStringExtra("header_icon"), 72, 72);
    return a(getIntent());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131442326)
    {
      if (i != 2131442336)
      {
        i = -1;
      }
      else
      {
        i = 1;
        a();
      }
    }
    else
    {
      i = 2;
      finish();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("refer", String.valueOf(i));
    a("clk", localHashMap);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryShareActivity
 * JD-Core Version:    0.7.0.1
 */