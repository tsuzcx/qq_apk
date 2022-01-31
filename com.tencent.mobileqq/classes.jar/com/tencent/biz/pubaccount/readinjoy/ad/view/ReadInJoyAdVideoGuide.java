package com.tencent.biz.pubaccount.readinjoy.ad.view;

import actn;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bavi;
import bbfd;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import nmf;
import oco;

public class ReadInJoyAdVideoGuide
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private oco jdField_a_of_type_Oco;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public ReadInJoyAdVideoGuide(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoyAdVideoGuide(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 4;
    }
    if (this.jdField_a_of_type_Int != 12) {
      return 1;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (bbfd.a(getContext(), this.jdField_a_of_type_JavaLangString)) {
        return 3;
      }
      return 2;
    }
    return 0;
  }
  
  private String a()
  {
    switch (a())
    {
    default: 
      return "";
    case 4: 
      return getResources().getText(2131718456).toString();
    case 2: 
      return getResources().getText(2131718451).toString();
    case 3: 
      return getResources().getText(2131718453).toString();
    }
    return getResources().getText(2131718494).toString();
  }
  
  private void a(Context paramContext)
  {
    inflate(paramContext, 2131559800, this);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    b();
  }
  
  private void a(String paramString)
  {
    Resources localResources;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
    {
      localResources = getResources();
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = actn.a(60.0F, localResources);
      localURLDrawableOptions.mRequestHeight = actn.a(60.0F, localResources);
    }
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      paramString.setTag(bavi.b(actn.a(60.0F, localResources), actn.a(60.0F, localResources), actn.a(12.0F, localResources)));
      paramString.setDecodeHandler(bavi.i);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131362668));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362680));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363520));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362039);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  private void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      String str = paramString;
      if (paramString.length() > 12) {
        str = paramString.substring(0, 11) + "…";
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      a();
    }
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
    for (String str = this.jdField_b_of_type_JavaLangString;; str = a())
    {
      if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(str))) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = nmf.ay;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Oco != null) {
        this.jdField_a_of_type_Oco.a(paramView, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyAdVideoGuide", 2, "onClick:" + i);
      }
      return;
      i = nmf.au;
      continue;
      i = nmf.av;
      continue;
      i = nmf.aw;
      continue;
      i = nmf.ax;
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyAdVideoGuide", 2, "onVisibilityChanged:" + paramInt);
    }
    super.onVisibilityChanged(paramView, paramInt);
    a();
  }
  
  public void setAdGuideClickListener(oco paramoco)
  {
    this.jdField_a_of_type_Oco = paramoco;
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Int = paramInt;
    a(paramString1);
    b(paramString2);
    c(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:").append(this.jdField_a_of_type_Int).append("\n");
      localStringBuilder.append("icon:").append(paramString1).append("\n");
      localStringBuilder.append("name:").append(paramString2).append("\n");
      localStringBuilder.append("pkgname:").append(paramString3).append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
  }
  
  public void setAppInfo(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramString1);
    b(paramString2);
    c(paramString3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("setAppInfo:\n");
      localStringBuilder.append("type:").append(this.jdField_a_of_type_Int).append("\n");
      localStringBuilder.append("icon:").append(paramString1).append("\n");
      localStringBuilder.append("name:").append(paramString2).append("\n");
      localStringBuilder.append("pkgname:").append(paramString3).append("\n");
      localStringBuilder.append("isAmsSubscribeAd:").append(paramBoolean).append("\n");
      QLog.d("ReadInJoyAdVideoGuide", 2, localStringBuilder.toString());
    }
  }
  
  public void setBtnInfo(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdVideoGuide
 * JD-Core Version:    0.7.0.1
 */