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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.report.ReportConstant.Event;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbReporter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
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
  public static int a = 10;
  public static long a = -1L;
  public static int b = -1;
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
    inflate(paramContext, 2131559219, this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet = new HBEntryBannerServlet();
    a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367964));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367968));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367973));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367967));
    this.c = ((ImageView)findViewById(2131367965));
    this.d = ((ImageView)findViewById(2131367969));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367972));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367966));
    this.e = ((ImageView)findViewById(2131367970));
    this.f = ((ImageView)findViewById(2131367971));
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.c.setOnClickListener(this);
  }
  
  private RelativeLayout.LayoutParams a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.height = AIOUtils.b(32.0F, getResources());
      localLayoutParams.addRule(1, 2131367973);
      localLayoutParams.addRule(15);
      return localLayoutParams;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.height = AIOUtils.b(32.0F, getResources());
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  private void a()
  {
    boolean bool;
    if (Math.abs(System.currentTimeMillis() - jdField_a_of_type_Long) > jdField_a_of_type_Int * 60 * 1000) {
      bool = true;
    } else {
      bool = false;
    }
    if ((jdField_a_of_type_Long == -1L) || (bool))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet = new HBEntryBannerServlet();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerServlet.a();
      jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateActivityRealtimeNumber, timeApprove:");
      localStringBuilder.append(bool);
      QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("jumpGame,jumpUrl = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject1).toString());
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
    if (localObject1 != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramString = paramString.trim();
      if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
      {
        if (paramString.startsWith("mqqapi://"))
        {
          paramString = JumpParser.a((BaseQQAppInterface)localObject1, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramString);
          if (paramString != null) {
            paramString.a();
          }
        }
      }
      else {
        b(paramString);
      }
    }
  }
  
  private void a(String paramString, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("reportBanner actionName = ");
      paramMap.append(paramString);
      QLog.d("HBEntryBannerView", 2, paramMap.toString());
    }
    ((Map)localObject).put("active_id", this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.n());
    SpringHbReporter.a(ReportConstant.Event.m, 0, 1, (Map)localObject, paramString);
  }
  
  private void a(WeakReference<Activity> paramWeakReference)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playFireWorkAnimation fireWorkPlayCount = ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",fireWorkImgUrl = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    if ((paramWeakReference != null) && ((paramWeakReference.get() instanceof QBaseActivity)))
    {
      localObject2 = (SpringFestivalEntryManager)((QBaseActivity)paramWeakReference.get()).getAppRuntime().getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      paramWeakReference = ((SpringFestivalEntryManager)localObject2).b((String)localObject1);
      boolean bool = FileUtils.fileExists(paramWeakReference);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playFireWorkAnimation exist = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(",apngFilePath = ");
        localStringBuilder.append(paramWeakReference);
        QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
      }
      if (bool)
      {
        localObject1 = new ApngOptions();
        ((ApngOptions)localObject1).a(URLDrawableHelper.TRANSPARENT);
        ((ApngOptions)localObject1).a(i);
        paramWeakReference = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", (ApngOptions)localObject1, paramWeakReference);
        this.d.setImageDrawable(paramWeakReference);
        return;
      }
      ((SpringFestivalEntryManager)localObject2).a(new HBEntryBannerView.1(this, (String)localObject1, i, (SpringFestivalEntryManager)localObject2));
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(getResources().getDrawable(2130840330));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    String str;
    if (paramBoolean) {
      str = "#E9FEFF";
    } else {
      str = "#F7E5C3";
    }
    localTextView.setTextColor(Color.parseColor(str));
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(14.0F);
  }
  
  private void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpWeb,schemeUrl = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("HBEntryBannerView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      localObject = new Intent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), QQBrowserActivity.class);
      BaseApplicationImpl.getApplication().startActivity(((Intent)localObject).putExtra("url", paramString));
    }
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
      this.c.setImageDrawable(getResources().getDrawable(2130840327));
      this.jdField_a_of_type_Float = 3.42F;
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b() == 1)
    {
      this.c.setImageDrawable(getResources().getDrawable(2130840326));
      this.jdField_a_of_type_Float = 2.62F;
    }
    if (QLog.isColorLevel())
    {
      paramHBEntryBannerData = new StringBuilder();
      paramHBEntryBannerData.append("updateHbEntryData:");
      paramHBEntryBannerData.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b());
      QLog.d("HBEntryBannerView", 2, paramHBEntryBannerData.toString());
      paramHBEntryBannerData = new StringBuilder();
      paramHBEntryBannerData.append("updateHbEntryData hbBannerRatio:");
      paramHBEntryBannerData.append(this.jdField_a_of_type_Float);
      paramHBEntryBannerData.append(",isDesktopOpened: ");
      paramHBEntryBannerData.append(paramBoolean);
      paramHBEntryBannerData.append(", imgUrl:");
      paramHBEntryBannerData.append(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.d());
      QLog.d("HBEntryBannerView", 2, paramHBEntryBannerData.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateHbEntryData params.width = ");
        localStringBuilder.append(paramHBEntryBannerData.width);
        localStringBuilder.append(",params.height = ");
        localStringBuilder.append(paramHBEntryBannerData.height);
        localStringBuilder.append(",img backBgWidth = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",img backBgHeiht = ");
        localStringBuilder.append(j);
        QLog.d("HBEntryBannerView", 2, localStringBuilder.toString());
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
        try
        {
          a(paramWeakReference);
        }
        catch (Exception paramWeakReference)
        {
          QLog.d("HBEntryBannerView", 1, "updateHbEntryData playFireWorkAnimation exception", paramWeakReference);
          SpringHbMonitorReporter.a(405, paramWeakReference, new String[] { Log.getStackTraceString(paramWeakReference) });
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.b() == 1) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    a(paramBoolean);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.i()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.i());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(a(true));
    }
    else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(a(false));
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setFocusableInTouchMode(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.c() == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j())) {
          paramWeakReference = getResources().getString(2131699329);
        } else {
          paramWeakReference = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData.j();
        }
        if (jdField_b_of_type_Int != -1)
        {
          paramHBEntryBannerData = new StringBuilder();
          paramHBEntryBannerData.append(jdField_b_of_type_Int);
          paramHBEntryBannerData.append(paramWeakReference);
          paramWeakReference = paramHBEntryBannerData.toString();
          this.jdField_b_of_type_AndroidWidgetTextView.setText(paramWeakReference);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getText(2131699330));
        }
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
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = 2;
    switch (i)
    {
    default: 
      i = -1;
      break;
    case 2131367971: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern2");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData;
      i = j;
      if (localObject != null)
      {
        b(((HBEntryBannerData)localObject).l());
        i = j;
      }
      break;
    case 2131367970: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_lantern1");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData;
      if (localObject != null) {
        b(((HBEntryBannerData)localObject).k());
      }
      i = 1;
      break;
    case 2131367965: 
      if (QLog.isColorLevel()) {
        QLog.d("HBEntryBannerView", 2, "onClick hb_applets_banner_background");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalHBEntryBannerData;
      if (localObject != null) {
        a(((HBEntryBannerData)localObject).m());
      }
      i = 3;
    }
    Object localObject = new HashMap();
    ((Map)localObject).put("refer", String.valueOf(i));
    a("clk", (Map)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerView
 * JD-Core Version:    0.7.0.1
 */