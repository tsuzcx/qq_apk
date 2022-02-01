package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bblk;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import qjm;
import qjn;
import qjo;
import qjp;
import rck;
import zuq;

public class NativeAwesomeCommentView
  extends FrameLayout
  implements IView
{
  public static int a;
  ClickableSpan jdField_a_of_type_AndroidTextStyleClickableSpan = new qjm(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private rck jdField_a_of_type_Rck;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = ((Integer)bkwm.a(rck.i, Integer.valueOf(1))).intValue();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public NativeAwesomeCommentView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)inflate(getContext(), 2131560086, this).findViewById(2131379484));
  }
  
  public static void setMaxLines(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    if (getVisibility() == 0) {
      return getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (getVisibility() == 0) {
      return getMeasuredWidth();
    }
    return 0;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setAwesomeCommentInfo(rck paramrck)
  {
    int i = 1;
    if ((paramrck == null) || (rck.c == 1))
    {
      setVisibility(8);
      QLog.d("ReadInJoyAwesomeCommentView", 2, "awesomeComment is null");
      return;
    }
    setVisibility(0);
    QLog.d("ReadInJoyAwesomeCommentView", 2, "setAwesomeCommentInfo: " + paramrck);
    this.jdField_a_of_type_Rck = paramrck;
    Object localObject1 = paramrck.jdField_b_of_type_JavaLangString;
    String str = bblk.b(paramrck.d);
    Object localObject2 = bblk.b(paramrck.g);
    localObject2 = new SpannableString("  " + str + ": " + (String)localObject2);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842750);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      ((URLDrawable)localObject1).setBounds(0, 0, paramrck.jdField_a_of_type_Int * 2, paramrck.jdField_b_of_type_Int * 2);
      ((URLDrawable)localObject1).setCallback(new qjn(this, (SpannableString)localObject2));
      ((URLDrawable)localObject1).setDownloadListener(new qjo(this, (SpannableString)localObject2));
      ((SpannableString)localObject2).setSpan(new zuq((Drawable)localObject1), 0, 1, 17);
    }
    if (!TextUtils.isEmpty(str)) {
      i = str.length() + 1;
    }
    ((SpannableString)localObject2).setSpan(this.jdField_a_of_type_AndroidTextStyleClickableSpan, 2, i + 1, 17);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject2, 7, 16));
    if (jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(jdField_a_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new qjp(this, paramrck));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */