package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import aakc;
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
import bcsc;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import qvr;
import qvs;
import qvt;
import qvu;
import roq;

public class NativeAwesomeCommentView
  extends FrameLayout
  implements IView
{
  public static int a;
  ClickableSpan jdField_a_of_type_AndroidTextStyleClickableSpan = new qvr(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private roq jdField_a_of_type_Roq;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Int = ((Integer)bmhv.a(roq.i, Integer.valueOf(1))).intValue();
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)inflate(getContext(), 2131560133, this).findViewById(2131379793));
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
  
  public void setAwesomeCommentInfo(roq paramroq)
  {
    int i = 1;
    if ((paramroq == null) || (roq.c == 1))
    {
      setVisibility(8);
      QLog.d("ReadInJoyAwesomeCommentView", 2, "awesomeComment is null");
      return;
    }
    setVisibility(0);
    QLog.d("ReadInJoyAwesomeCommentView", 2, "setAwesomeCommentInfo: " + paramroq);
    this.jdField_a_of_type_Roq = paramroq;
    Object localObject1 = paramroq.jdField_b_of_type_JavaLangString;
    String str = bcsc.b(paramroq.d);
    Object localObject2 = bcsc.b(paramroq.g);
    localObject2 = new SpannableString("  " + str + ": " + (String)localObject2);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130842782);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions);
      ((URLDrawable)localObject1).setBounds(0, 0, paramroq.jdField_a_of_type_Int * 2, paramroq.jdField_b_of_type_Int * 2);
      ((URLDrawable)localObject1).setCallback(new qvs(this, (SpannableString)localObject2));
      ((URLDrawable)localObject1).setDownloadListener(new qvt(this, (SpannableString)localObject2));
      ((SpannableString)localObject2).setSpan(new aakc((Drawable)localObject1), 0, 1, 17);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new qvu(this, paramroq));
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2147483647);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView
 * JD-Core Version:    0.7.0.1
 */