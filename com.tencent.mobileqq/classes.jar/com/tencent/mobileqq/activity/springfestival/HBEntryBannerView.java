package com.tencent.mobileqq.activity.springfestival;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class HBEntryBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  public static int a;
  public static long a;
  public static int b;
  private float jdField_a_of_type_Float = 2.62F;
  private final ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private HBEntryBannerData jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData;
  private HBEntryBannerServlet jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private final ImageView jdField_b_of_type_AndroidWidgetImageView;
  private final RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final ImageView c;
  private final ImageView d;
  private final ImageView e;
  private final ImageView f;
  
  static
  {
    jdField_a_of_type_Int = 10;
    jdField_a_of_type_Long = -1L;
    jdField_b_of_type_Int = -1;
  }
  
  public HBEntryBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HBEntryBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HBEntryBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131559342, this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet = new HBEntryBannerServlet();
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368213));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368217));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368222));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368216));
    this.c = ((ImageView)findViewById(2131368214));
    this.d = ((ImageView)findViewById(2131368218));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368221));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368215));
    this.e = ((ImageView)findViewById(2131368219));
    this.f = ((ImageView)findViewById(2131368220));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private RelativeLayout.LayoutParams a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.height = AIOUtils.a(32.0F, getResources());
      localLayoutParams.addRule(1, 2131368222);
      localLayoutParams.addRule(15);
      return localLayoutParams;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.height = AIOUtils.a(32.0F, getResources());
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  private void a()
  {
    if (Math.abs(System.currentTimeMillis() - jdField_a_of_type_Long) > jdField_a_of_type_Int * 60 * 1000) {}
    for (boolean bool = true;; bool = false)
    {
      if ((jdField_a_of_type_Long == -1L) || (bool))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet = new HBEntryBannerServlet();
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet.a();
        jdField_a_of_type_Long = System.currentTimeMillis();
      }
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "updateActivityRealtimeNumber, timeApprove:" + bool);
      }
      return;
    }
  }
  
  private void a(View paramView, String paramString, boolean paramBoolean)
  {
    paramString = Utils.a(paramString, paramView.getWidth(), paramView.getHeight(), paramBoolean);
    if ((paramView instanceof ImageView)) {
      ((ImageView)paramView).setImageDrawable(paramString);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "jumpGame,jumpUrl = " + paramString);
    }
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getRuntime();
      localObject1 = localObject2;
      if ((localObject3 instanceof QQAppInterface)) {
        localObject1 = (QQAppInterface)localObject3;
      }
    }
    if ((localObject1 == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return;
        paramString = paramString.trim();
        if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
        {
          b(paramString);
          return;
        }
      } while (!paramString.startsWith("mqqapi://"));
      paramString = JumpParser.a((QQAppInterface)localObject1, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
    } while (paramString == null);
    paramString.a();
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "reportBanner actionName = " + paramString);
    }
    ((Map)localObject).put("active_id", this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.n());
    SpringHbReporter.a(ReportConstant.Event.m, 0, 1, (Map)localObject, paramString);
  }
  
  private void a(WeakReference<Activity> paramWeakReference)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.a();
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "playFireWorkAnimation fireWorkPlayCount = " + i + ",fireWorkImgUrl = " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    while ((paramWeakReference == null) || (!(paramWeakReference.get() instanceof QBaseActivity))) {
      return;
    }
    SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)((QBaseActivity)paramWeakReference.get()).getAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    paramWeakReference = localSpringFestivalEntryManager.b((String)localObject);
    boolean bool = FileUtils.a(paramWeakReference);
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "playFireWorkAnimation exist = " + bool + ",apngFilePath = " + paramWeakReference);
    }
    if (bool)
    {
      localObject = new VasApngFactory.Options();
      ((VasApngFactory.Options)localObject).a(URLDrawableHelper.TRANSPARENT);
      ((VasApngFactory.Options)localObject).a(i);
      paramWeakReference = VasApngFactory.a("", (VasApngFactory.Options)localObject, paramWeakReference);
      this.d.setImageDrawable(paramWeakReference);
      return;
    }
    localSpringFestivalEntryManager.a(new HBEntryBannerView.1(this, (String)localObject, i, localSpringFestivalEntryManager));
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean)
  {
    TextView localTextView;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130840461));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label97;
      }
    }
    label97:
    for (int i = Color.parseColor("#E9FEFF");; i = Color.parseColor("#F7E5C3"))
    {
      localTextView.setTextColor(i);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HBEntryBannerView", 2, "jumpWeb,schemeUrl = " + paramString);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Intent localIntent = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
    BaseApplicationImpl.getApplication().startActivity(localIntent.putExtra("url", paramString));
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  public void a(WeakReference<Activity> paramWeakReference, HBEntryBannerData paramHBEntryBannerData, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData = paramHBEntryBannerData;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData == null) {
      return;
    }
    if (paramBoolean) {
      a("exp", null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b() == 0)
    {
      this.c.setImageDrawable(getResources().getDrawable(2130840458));
      this.jdField_a_of_type_Float = 3.42F;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("HBEntryBannerView", 2, "updateHbEntryData:" + this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b());
        QLog.d("HBEntryBannerView", 2, "updateHbEntryData hbBannerRatio:" + this.jdField_a_of_type_Float + ",isDesktopOpened: " + paramBoolean + ", imgUrl:" + this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.d());
      }
      if ((this.c.getMeasuredWidth() > 0) && (this.c.getMeasuredHeight() > 0))
      {
        paramHBEntryBannerData = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        int i = this.c.getMeasuredWidth() - paramHBEntryBannerData.leftMargin - paramHBEntryBannerData.rightMargin;
        int j = (int)(i / this.jdField_a_of_type_Float);
        paramHBEntryBannerData.width = this.c.getMeasuredWidth();
        paramHBEntryBannerData.height = (paramHBEntryBannerData.topMargin + j + paramHBEntryBannerData.bottomMargin);
        this.c.setLayoutParams(paramHBEntryBannerData);
        Object localObject = Utils.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.d(), i, j, true);
        if (QLog.isColorLevel())
        {
          QLog.d("HBEntryBannerView", 2, "updateHbEntryData setImageDrawable");
          QLog.d("HBEntryBannerView", 2, "updateHbEntryData params.width = " + paramHBEntryBannerData.width + ",params.height = " + paramHBEntryBannerData.height + ",img backBgWidth = " + i + ",img backBgHeiht = " + j);
        }
        this.c.setImageDrawable((Drawable)localObject);
        this.d.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.a())
        {
          localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).width = paramHBEntryBannerData.width;
          ((RelativeLayout.LayoutParams)localObject).height = paramHBEntryBannerData.height;
          this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.d.setVisibility(0);
        }
      }
      try
      {
        a(paramWeakReference);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b() == 1)
        {
          paramBoolean = true;
          a(paramBoolean);
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.i())) {
            break label791;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.i());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(a(true));
          if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
            this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
            if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.c() == 3)
            {
              this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j())) {
                break label862;
              }
              paramWeakReference = getResources().getString(2131699225);
              if (jdField_b_of_type_Int == -1) {
                break label873;
              }
              paramWeakReference = jdField_b_of_type_Int + paramWeakReference;
              this.jdField_b_of_type_AndroidWidgetTextView.setText(paramWeakReference);
              this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#E9FEFF"));
              this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(18.0F);
              this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
          a(this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.f(), false);
          a(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.e(), true);
          a(this.e, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.g(), false);
          a(this.f, this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.h(), false);
          requestLayout();
          invalidate();
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b() != 1) {
            continue;
          }
          this.c.setImageDrawable(getResources().getDrawable(2130840457));
          this.jdField_a_of_type_Float = 2.62F;
        }
      }
      catch (Exception paramWeakReference)
      {
        for (;;)
        {
          QLog.d("HBEntryBannerView", 1, "updateHbEntryData playFireWorkAnimation exception", paramWeakReference);
          SpringHbMonitorReporter.a(405, paramWeakReference, new String[] { Log.getStackTraceString(paramWeakReference) });
          continue;
          paramBoolean = false;
          continue;
          label791:
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j()))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j());
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(a(false));
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            continue;
            label862:
            paramWeakReference = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j();
            continue;
            label873:
            this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getText(2131699226));
          }
        }
      }
    }
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    int j = 2;
    int i;
    switch (paramView.getId())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("refer", String.valueOf(i));
      a("clk", localHashMap);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_background");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData != null) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.m());
      }
      i = 3;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern1");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData != null) {
        b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.k());
      }
      i = 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern2");
      }
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData != null)
      {
        b(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.l());
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerView
 * JD-Core Version:    0.7.0.1
 */