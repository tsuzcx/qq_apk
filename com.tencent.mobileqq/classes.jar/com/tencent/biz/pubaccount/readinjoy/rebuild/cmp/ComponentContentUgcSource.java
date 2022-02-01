package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import oat;
import pha;
import pxk;
import qqr;
import qrb;
import qva;
import snh;

public class ComponentContentUgcSource
  extends LinearLayout
  implements View.OnClickListener, qqr
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  qva jdField_a_of_type_Qva;
  
  public ComponentContentUgcSource(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentContentUgcSource(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcSource", 2, "business url is " + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    Object localObject;
    do
    {
      return;
      localObject = new Intent(getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      getContext().startActivity((Intent)localObject);
      localObject = this.jdField_a_of_type_Qva.a.a();
    } while (localObject == null);
    oat.a((ArticleInfo)localObject);
    snh.a((ArticleInfo)localObject, this.jdField_a_of_type_Qva.a.e());
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qva = new qva();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560277, this, true);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380167));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380168));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pxk))
    {
      paramObject = (pxk)paramObject;
      this.jdField_a_of_type_Qva.a(paramObject);
      paramObject = paramObject.a();
      if (paramObject != null) {
        break label46;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcSource", 2, "article info is null");
      }
    }
    return;
    label46:
    if ((snh.g(paramObject)) || ((snh.i(paramObject)) && (!snh.m(paramObject))) || (pha.g(paramObject)) || ((pha.h(paramObject)) && (!snh.l(paramObject))) || (snh.d(paramObject)))
    {
      localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = paramObject.businessName;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(paramObject.businessNamePrefix))
    {
      localSpannableStringBuilder.append(paramObject.businessNamePrefix);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramObject.businessUrl;
      return;
      localSpannableStringBuilder.append((CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
      setVisibility(0);
    }
  }
  
  public void a(qrb paramqrb)
  {
    this.jdField_a_of_type_Qva.a(paramqrb);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */