package com.tencent.gdtad.views.videoceiling;

import aanp;
import aaqk;
import aaql;
import aaqm;
import aekt;
import alpo;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GdtVideoCeilingTitleBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private aaqm jdField_a_of_type_Aaqm;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private TextView b;
  
  public GdtVideoCeilingTitleBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    aanp.b("GdtVideoCeilingView", "updateBar Style " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int != 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(0);
      String str = alpo.a(2131705608) + this.jdField_a_of_type_JavaLangString;
      int i = "在APP中打开".length();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.length() <= i))
      {
        this.b.setText(str);
        return;
      }
      this.b.setText("在APP中打开");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377884));
    this.b = ((TextView)findViewById(2131371374));
    this.b.setOnClickListener(new aaqk(this));
    View localView = findViewById(2131363020);
    int i = aekt.a(5.0F, getResources());
    aekt.a(localView, i, i, 0, i);
    localView.setOnClickListener(new aaql(this));
  }
  
  public void setAppName(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnBtnClickListener(aaqm paramaaqm)
  {
    this.jdField_a_of_type_Aaqm = paramaaqm;
  }
  
  public void setStyle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setWebBarTitle(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar
 * JD-Core Version:    0.7.0.1
 */