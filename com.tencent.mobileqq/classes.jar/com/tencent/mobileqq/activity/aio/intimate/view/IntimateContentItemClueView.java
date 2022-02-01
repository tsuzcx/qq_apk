package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import bbcv;
import bbcz;
import com.tencent.mobileqq.data.IntimateInfo;

public class IntimateContentItemClueView
  extends IntimateContentItemBaseView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bbcv jdField_a_of_type_Bbcv;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  
  public IntimateContentItemClueView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateContentItemClueView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559312, this, true).findViewById(2131367353));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  protected void a(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Bbcv == null);
    this.jdField_a_of_type_Bbcv.a(this.jdField_a_of_type_Agll.a(), this.jdField_a_of_type_Agll.a());
    bbcz.b(1);
  }
  
  protected void a(IntimateInfo paramIntimateInfo, int paramInt) {}
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Bbcv == null)
    {
      this.jdField_a_of_type_Bbcv = new bbcv(this.jdField_a_of_type_Agll.a());
      bbcv localbbcv = this.jdField_a_of_type_Bbcv;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bbcv.a());
    }
    return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
      bbcz.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemClueView
 * JD-Core Version:    0.7.0.1
 */