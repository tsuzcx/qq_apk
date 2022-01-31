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
import nrt;
import ors;
import pgd;
import pxj;
import pxt;
import qbs;
import rqj;

public class ComponentContentUgcSource
  extends LinearLayout
  implements View.OnClickListener, pxj
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  qbs jdField_a_of_type_Qbs;
  
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
      localObject = this.jdField_a_of_type_Qbs.a.a();
    } while (localObject == null);
    nrt.a((ArticleInfo)localObject);
    rqj.a((ArticleInfo)localObject, this.jdField_a_of_type_Qbs.a.e());
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560135, this, true);
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379240));
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379241));
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      paramObject = (pgd)paramObject;
      this.jdField_a_of_type_Qbs.a(paramObject);
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
    if ((rqj.b(paramObject)) || ((rqj.i(paramObject)) && (!rqj.m(paramObject))) || (ors.g(paramObject)) || ((ors.h(paramObject)) && (!rqj.l(paramObject))) || (rqj.d(paramObject)))
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
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */