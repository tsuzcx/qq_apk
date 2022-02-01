package com.tencent.mobileqq.activity.emogroupstore;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.emosm.view.CardLayoutManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqperf.monitor.memory.ActivityLeakSolution;
import java.util.List;

public class SDKSetEmotionDialog
  extends ReportDialog
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public SDKSetEmotionDialog(Context paramContext)
  {
    super(paramContext, 2131755842);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    setContentView(2131559082);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365811));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365807));
    this.c = ((TextView)findViewById(2131365796));
    this.d = ((TextView)findViewById(2131365802));
    this.e = ((TextView)findViewById(2131365766));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367459));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131377753));
    this.f = ((TextView)findViewById(2131373573));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131366311));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365814));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365840));
  }
  
  public SDKSetEmotionDialog a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.c.setVisibility(8);
      return this;
    }
    this.c.setText(paramInt);
    this.c.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691194));
    this.c.setVisibility(0);
    this.c.setOnClickListener(new SDKSetEmotionDialog.1(this, paramOnClickListener));
    return this;
  }
  
  public SDKSetEmotionDialog a(String paramString)
  {
    if (paramString != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return this;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return this;
  }
  
  public SDKSetEmotionDialog a(List<String> paramList, View.OnClickListener paramOnClickListener)
  {
    if ((paramList == null) || (paramOnClickListener == null)) {
      return this;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(new StackAdapter(paramList));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(new DefaultItemAnimator());
    paramList = new CardLayoutManager(paramOnClickListener);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramList);
    return this;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (paramInt > 0)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    if ((this.f == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        this.f.setVisibility(0);
        this.f.setText(paramString);
      }
    } while ((paramInt < 0) || (paramInt > 100));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt, true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
  }
  
  public SDKSetEmotionDialog b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.e.setVisibility(8);
      return this;
    }
    this.e.setText(paramInt);
    this.e.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691194));
    this.e.setVisibility(0);
    this.e.setOnClickListener(new SDKSetEmotionDialog.2(this, paramOnClickListener));
    return this;
  }
  
  public SDKSetEmotionDialog b(String paramString)
  {
    if ((this.f == null) || (this.jdField_a_of_type_AndroidWidgetProgressBar == null)) {
      return this;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.f.setVisibility(0);
      this.f.setText(paramString);
      return this;
    }
    this.f.setVisibility(4);
    return this;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = SDKSetEmotionHelper.a(this.jdField_a_of_type_AndroidWidgetProgressBar, paramInt);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public SDKSetEmotionDialog c(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.d.setVisibility(8);
      return this;
    }
    this.d.setText(paramInt);
    this.d.setContentDescription(getContext().getString(paramInt) + getContext().getString(2131691194));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new SDKSetEmotionDialog.3(this, paramOnClickListener));
    return this;
  }
  
  public void dismiss()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      super.dismiss();
      return;
    }
    catch (Exception localException) {}finally
    {
      ActivityLeakSolution.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKSetEmotionDialog
 * JD-Core Version:    0.7.0.1
 */