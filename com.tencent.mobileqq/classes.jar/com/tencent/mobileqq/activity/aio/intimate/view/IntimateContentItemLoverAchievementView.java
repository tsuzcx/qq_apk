package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import agmd;
import agml;
import agmm;
import agmn;
import agmo;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import arau;
import arav;
import bdla;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class IntimateContentItemLoverAchievementView
  extends IntimateContentItemBaseView
{
  private agmn jdField_a_of_type_Agmn = new agml(this);
  private agmo jdField_a_of_type_Agmo;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView;
  
  public IntimateContentItemLoverAchievementView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemLoverAchievementView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      paramString = new SpannableString(paramString);
      paramString.setSpan(new StyleSpan(0), paramInt1, paramInt1 + paramInt2, 33);
      paramString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(14.0F)), paramInt1, paramInt1 + paramInt2, 33);
      paramString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.jdField_a_of_type_AndroidContentContext, 2131166830)), paramInt1, paramInt1 + paramInt2, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntimateContentItemLoverAchievementView", 2, "getUnBoldContent fail:" + paramString.toString());
      }
    }
    return null;
  }
  
  private void m()
  {
    bdla.b(null, "dc00898", "", "", "0X800B567", "0X800B567", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559316, this, true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject).findViewById(2131365273));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131365275));
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = ((RecyclerView)((View)localObject).findViewById(2131365274));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this);
    this.jdField_a_of_type_Agmo = new agmo(this, null);
    localObject = new agmm(this, this.jdField_a_of_type_Agll.a(), 3);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(this.jdField_a_of_type_Agmo);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = arav.a().T;
    } while (TextUtils.isEmpty(paramView));
    m();
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_AndroidContentContext, paramView, 2064, null);
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt)
  {
    if ((paramIntimateInfo != null) && (paramIntimateInfo.loveAchievementInfo != null) && (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      setVisibility(0);
      SpannableString localSpannableString = a(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693311), new Object[] { Integer.valueOf(paramIntimateInfo.loveAchievementInfo.b), Integer.valueOf(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_Int) }), 0, 3);
      if (localSpannableString != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
      }
      if (paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 3) {
        this.jdField_a_of_type_Agmo.a(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.subList(0, 3));
      }
      for (;;)
      {
        bdla.b(null, "dc00898", "", "", "0X800B566", "0X800B566", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_Agmo.a(paramIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    setVisibility(8);
  }
  
  protected boolean a()
  {
    boolean bool = arav.a().b;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.loveAchievementInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
    for (int i = 1; (bool) && (this.jdField_a_of_type_Int == 1) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView.setAdapter(null);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView = null;
    }
    super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemLoverAchievementView
 * JD-Core Version:    0.7.0.1
 */