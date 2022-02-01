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
import com.tencent.mobileqq.screendetect.ScreenShotHelper;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
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
  private volatile Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new HBEntryShareActivity.1(this);
  private volatile String jdField_a_of_type_JavaLangString;
  
  private Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    return Utils.a(this.app, paramString, paramInt1, paramInt2, "");
  }
  
  private StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    int i = -16842919;
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[] { i }, paramDrawable1);
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
    int k = paramIntent.getIntExtra("all_count", 0);
    int i = paramIntent.getIntExtra("max_count", 0);
    int j = paramIntent.getIntExtra("pag_count", 0);
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (j < 0) {
        j = 0;
      }
      for (;;)
      {
        if ((k == 0) || (i == 0))
        {
          QLog.d("HBEntryShareActivity", 1, "loadShareLayoutByIntent finish,allCount = " + k + ",maxCount = " + i);
          finish();
          return null;
        }
        Object localObject1 = (ViewGroup)getWindow().getDecorView().findViewById(16908290);
        ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(this).inflate(paramInt, (ViewGroup)localObject1, false);
        localObject1 = (ImageView)localViewGroup.findViewById(2131374698);
        Object localObject2 = (TextView)localViewGroup.findViewById(2131374699);
        paramIntent.getStringExtra("header_icon");
        Object localObject3 = paramIntent.getStringExtra("header_name");
        String str = paramIntent.getStringExtra("header_text");
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(str)))
        {
          ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((TextView)localObject2).setText(String.format("%s%s", new Object[] { localObject3, str }));
          localObject1 = FaceDrawable.getDefaultDrawable(1, 3);
          localObject1 = FaceDrawable.getFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 3, (Drawable)localObject1, (Drawable)localObject1, null);
          ((ImageView)localViewGroup.findViewById(2131374705)).setImageDrawable((Drawable)localObject1);
          ((TextView)localViewGroup.findViewById(2131374706)).setText(ContactUtils.i(this.app, this.app.getCurrentUin()));
          localObject1 = Typeface.createFromAsset(getAssets(), "fonts/HuNan-CC.ttf");
          localObject2 = (TextView)localViewGroup.findViewById(2131374694);
          ((TextView)localObject2).setTypeface((Typeface)localObject1);
          ((TextView)localObject2).setText(String.valueOf(k));
          localObject3 = (FrameLayout)localViewGroup.findViewById(2131374708);
          localObject2 = Utils.a(this.app, paramIntent.getStringExtra("background_img2"), ((FrameLayout)localObject3).getWidth(), ((FrameLayout)localObject3).getHeight(), "default_share_bg_fullscreen");
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            QLog.d("HBEntryShareActivity", 1, "load full bg null");
            localObject1 = getResources().getDrawable(2130845547);
          }
          ((FrameLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
          ((TextView)localViewGroup.findViewById(2131374695)).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131699239), Integer.valueOf(i), getResources().getString(2131699237) }));
          localObject1 = (TextView)localViewGroup.findViewById(2131374696);
          if (j <= 0) {
            break label757;
          }
          ((TextView)localObject1).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131699241), Integer.valueOf(j), getResources().getString(2131699240) }));
          ((TextView)localObject1).setVisibility(0);
          label552:
          localObject1 = a(getIntent().getStringExtra("middle_img2"), 320, 400);
          if (localObject1 != null) {
            break label794;
          }
          localObject1 = getResources().getDrawable(2130845546);
        }
        label791:
        label794:
        for (;;)
        {
          ((LinearLayout)localViewGroup.findViewById(2131374691)).setBackgroundDrawable((Drawable)localObject1);
          localObject1 = (FrameLayout)localViewGroup.findViewById(2131374689);
          localObject2 = (RoundImageView)localViewGroup.findViewById(2131374688);
          localObject3 = a(getIntent().getStringExtra("qrcode_code"), 80, 80);
          if (localObject3 != null)
          {
            ((FrameLayout)localObject1).setBackgroundDrawable(getResources().getDrawable(2130845556));
            ((RoundImageView)localObject2).setImageDrawable((Drawable)localObject3);
            label680:
            paramIntent = paramIntent.getStringExtra("bottom_text");
            if (!TextUtils.isEmpty(paramIntent)) {
              break label791;
            }
            paramIntent = getResources().getString(2131699243);
          }
          for (;;)
          {
            ((TextView)localViewGroup.findViewById(2131374690)).setText(paramIntent);
            return localViewGroup;
            ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130845400));
            ((TextView)localObject2).setText(getResources().getString(2131699228));
            break;
            label757:
            ((TextView)localObject1).setVisibility(8);
            break label552;
            ((FrameLayout)localObject1).setBackgroundColor(0);
            ((RoundImageView)localObject2).setImageDrawable(getResources().getDrawable(2130845400));
            break label680;
          }
        }
      }
    }
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
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryShareActivity", 2, "saveView, width:" + paramView.getMeasuredWidth() + ", heiht:" + paramView.getMeasuredHeight());
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), Bitmap.Config.RGB_565);
      paramView.draw(new Canvas(localBitmap));
      paramView = String.format("%s/%s.jpg", new Object[] { BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath(), Long.valueOf(System.currentTimeMillis()) });
      boolean bool = FileUtil.a(localBitmap, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryShareActivity", 2, "saveView, wrote:" + bool + ", path:" + paramView + ",fileSize = " + FileUtils.a(paramView));
      }
      localBitmap.recycle();
      return paramView;
    }
    catch (Throwable paramView)
    {
      SpringHbMonitorReporter.a(404, paramView, new String[0]);
      QLog.d("HBEntryShareActivity", 1, "saveView2File exception, throwable=" + paramView.getMessage());
    }
    return null;
  }
  
  private void a()
  {
    if (FileUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      ScreenShotHelper.a(this, this.jdField_a_of_type_JavaLangString, true);
      return;
    }
    a(true);
    ViewGroup localViewGroup = a(getIntent(), 2131561272);
    if (localViewGroup != null) {
      localViewGroup.requestLayout();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new HBEntryShareActivity.3(this, localViewGroup), 500L);
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, List<String> paramList, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startActivity ,activityId = ").append(paramString1).append(",allCnt = ").append(paramInt1).append(",maxCnt = ").append(paramInt2).append(",pagCnt = ").append(paramInt3).append(",headerIcon = ").append(paramString2).append(",headerName = ").append(paramString3).append(",headerText = ").append(paramString4).append(",bg1Url = ").append(paramString5).append(",bg2Url = ").append(paramString6).append(",bottomCode = ").append(paramString7).append(",ticketList = ");
      if (paramList == null) {
        break label468;
      }
    }
    label468:
    for (Object localObject = paramList.toString();; localObject = "")
    {
      QLog.d("HBEntryShareActivity", 2, (String)localObject + ",middleImgUrl1 = " + paramString9 + ",middleImgUrl2 = " + paramString10 + ",btnImgUrl1 = " + paramString11 + ",btnImgUrl2 = " + paramString12 + ",btnImgApngUrl = " + paramString13);
      localObject = new Intent(paramBaseActivity, HBEntryShareActivity.class);
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
      paramBaseActivity.overridePendingTransition(2130772315, 2130771992);
      return;
    }
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
    View localView = findViewById(2131374702);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
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
    int j = paramIntent.getIntExtra("max_count", 0);
    int i = paramIntent.getIntExtra("pag_count", 0);
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryShareActivity", 2, "allCount=" + m + ", maxCount=" + j + ", pagCount=" + i);
    }
    if ((m <= 0) || (j <= 0))
    {
      QLog.d("HBEntryShareActivity", 1, "initViewByIntent finish,allCount = " + m + ",maxCount = " + j);
      finish();
      return false;
    }
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      if (j > m) {
        j = m;
      }
      for (;;)
      {
        setContentView(2131561271);
        findViewById(2131374693).setOnClickListener(this);
        findViewById(2131374703).setOnClickListener(this);
        findViewById(2131374702).setVisibility(8);
        Object localObject1 = Typeface.createFromAsset(getAssets(), "fonts/HuNan-CC.ttf");
        Object localObject2 = (TextView)findViewById(2131374694);
        ((TextView)localObject2).setTypeface((Typeface)localObject1);
        ((TextView)localObject2).setText(String.valueOf(m));
        ((TextView)findViewById(2131374695)).setText(String.format("%s%s%s", new Object[] { getResources().getString(2131699239), Integer.valueOf(j), getResources().getString(2131699237) }));
        localObject1 = paramIntent.getStringExtra("ticket_text");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = getResources().getString(2131699242);
        }
        for (;;)
        {
          ((TextView)findViewById(2131374704)).setText((CharSequence)localObject1);
          Object localObject3 = (RelativeLayout)findViewById(2131374700);
          localObject2 = Utils.a(this.app, paramIntent.getStringExtra("background_img1"), ((RelativeLayout)localObject3).getWidth(), ((RelativeLayout)localObject3).getHeight(), "default_share_bg_window");
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            QLog.d("HBEntryShareActivity", 1, "load window bg null");
            localObject1 = getResources().getDrawable(2130845545);
          }
          ((RelativeLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
          localObject3 = (LinearLayout)findViewById(2131374691);
          localObject2 = a(paramIntent.getStringExtra("middle_img1"), ((LinearLayout)localObject3).getWidth(), ((LinearLayout)localObject3).getHeight());
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = getResources().getDrawable(2130845546);
          }
          ((LinearLayout)localObject3).setBackgroundDrawable((Drawable)localObject1);
          localObject1 = (ImageView)findViewById(2131374698);
          localObject2 = (TextView)findViewById(2131374699);
          paramIntent.getStringExtra("header_icon");
          localObject3 = paramIntent.getStringExtra("header_name");
          paramIntent = paramIntent.getStringExtra("header_text");
          int k;
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty(paramIntent)))
          {
            ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            ((TextView)localObject2).setText(String.format("%s%s", new Object[] { localObject3, paramIntent }));
            localObject1 = (TextView)findViewById(2131374703);
            if (getIntent().getIntExtra("not_share", 0) != 1) {
              break label980;
            }
            k = 4;
            label608:
            ((TextView)localObject1).setVisibility(k);
            if (((TextView)localObject1).getVisibility() == 0)
            {
              paramIntent = a(getIntent().getStringExtra("button_img1"), AIOUtils.a(154.0F, getResources()), AIOUtils.a(45.0F, getResources()));
              localObject2 = a(getIntent().getStringExtra("button_img2"), AIOUtils.a(154.0F, getResources()), AIOUtils.a(45.0F, getResources()));
              if ((paramIntent == null) || (localObject2 == null)) {
                break label986;
              }
              paramIntent = a(paramIntent, (Drawable)localObject2);
              label711:
              ((TextView)localObject1).setBackgroundDrawable(paramIntent);
            }
          }
          for (;;)
          {
            try
            {
              localObject2 = getIntent().getStringExtra("button_img_apng");
              if (QLog.isColorLevel()) {
                QLog.d("HBEntryShareActivity", 2, "initViewByIntent btnImgApngUrl = " + (String)localObject2);
              }
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject3 = (SpringFestivalEntryManager)getAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
                paramIntent = ((SpringFestivalEntryManager)localObject3).b((String)localObject2);
                boolean bool = FileUtils.a(paramIntent);
                if (QLog.isColorLevel()) {
                  QLog.d("HBEntryShareActivity", 2, "initViewByIntent btnImgApngUrl exist = " + bool + ",apngFilePath = " + paramIntent);
                }
                if (!bool) {
                  continue;
                }
                localObject2 = new VasApngFactory.Options();
                ((VasApngFactory.Options)localObject2).a(URLDrawableHelper.TRANSPARENT);
                ((TextView)localObject1).setBackgroundDrawable(VasApngFactory.a("", (VasApngFactory.Options)localObject2, paramIntent));
                ((TextView)localObject1).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
              }
            }
            catch (Exception paramIntent)
            {
              label980:
              label986:
              SpringHbMonitorReporter.a(406, paramIntent, new String[0]);
              QLog.d("HBEntryShareActivity", 1, "initViewByIntent exception ", paramIntent);
              continue;
            }
            paramIntent = new HashMap();
            paramIntent.put("ext1", String.valueOf(m));
            paramIntent.put("ext2", String.valueOf(j));
            paramIntent.put("ext3", String.valueOf(i));
            a("exp", paramIntent);
            return true;
            ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(2130845400));
            ((TextView)localObject2).setText(getResources().getString(2131699228));
            break;
            k = 0;
            break label608;
            paramIntent = a(getResources().getDrawable(2130845548), getResources().getDrawable(2130845549));
            break label711;
            ((SpringFestivalEntryManager)localObject3).a(new HBEntryShareActivity.2(this, (String)localObject2, (TextView)localObject1, (SpringFestivalEntryManager)localObject3));
          }
        }
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getWindow().setFlags(1024, 1024);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(getIntent().getStringExtra("header_icon"), 72, 72);
    return a(getIntent());
  }
  
  public void doOnResume()
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
    int i = -1;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("refer", String.valueOf(i));
      a("clk", localHashMap);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      finish();
      continue;
      i = 1;
      a();
    }
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