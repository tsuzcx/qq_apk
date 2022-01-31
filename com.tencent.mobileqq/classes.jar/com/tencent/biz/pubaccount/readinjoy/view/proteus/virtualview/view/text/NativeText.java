package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import mut;
import muu;

public class NativeText
  extends TextBase
{
  protected NativeTextImp a;
  protected boolean b;
  protected float d;
  protected float e;
  
  public NativeText(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_d_of_type_Float = 1.0F;
    this.jdField_e_of_type_Float = 0.0F;
    this.a = new NativeTextImp(paramVafContext.a());
  }
  
  public int a()
  {
    return this.a.a();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a()
  {
    int k = 1;
    super.a();
    this.a.setIncludeFontPadding(false);
    this.a.setPadding(this.o, this.q, this.p, this.r);
    this.a.setTextSize(0, this.C);
    this.a.setBorderColor(this.jdField_f_of_type_Int);
    this.a.setBorderWidth(this.jdField_e_of_type_Int);
    this.a.setBorderTopLeftRadius(this.h);
    this.a.setBorderTopRightRadius(this.i);
    this.a.setBorderBottomLeftRadius(this.j);
    this.a.setBorderBottomRightRadius(this.k);
    this.a.setBackgroundColor(this.jdField_d_of_type_Int);
    this.a.setTextColor(this.B);
    if ((this.D & 0x1) != 0) {}
    for (int i = 33;; i = 1)
    {
      int j = i;
      if ((this.D & 0x8) != 0) {
        j = i | 0x10;
      }
      this.a.setPaintFlags(j);
      if ((this.D & 0x2) != 0) {
        this.a.setTypeface(null, 3);
      }
      if (this.E > 0) {
        this.a.setLines(this.E);
      }
      if (this.F > 0) {
        this.a.setMaxLines(this.F);
      }
      if (this.G >= 0) {
        this.a.setEllipsize(android.text.TextUtils.TruncateAt.values()[this.G]);
      }
      if ((this.s & 0x4) != 0) {
        i = k;
      }
      for (;;)
      {
        if ((this.s & 0x20) != 0)
        {
          j = i | 0x10;
          label277:
          this.a.setGravity(j);
          this.a.setLineSpacing(this.jdField_e_of_type_Float, this.jdField_d_of_type_Float);
          if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
            break label429;
          }
          d(this.jdField_e_of_type_JavaLangString);
        }
        for (;;)
        {
          if (b()) {
            this.a.setOnClickListener(new mut(this));
          }
          if (c()) {
            this.a.setOnLongClickListener(new muu(this));
          }
          return;
          if ((this.s & 0x1) != 0)
          {
            i = 3;
            break;
          }
          if ((this.s & 0x2) == 0) {
            break label438;
          }
          i = 5;
          break;
          if ((this.s & 0x8) != 0)
          {
            j = i | 0x30;
            break label277;
          }
          j = i;
          if ((this.s & 0x10) == 0) {
            break label277;
          }
          j = i | 0x50;
          break label277;
          label429:
          d("");
        }
        label438:
        i = 0;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a.b(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_e_of_type_JavaLangString = paramString;
      d(this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return this.a.b();
  }
  
  public void c(int paramInt)
  {
    if (this.B != paramInt)
    {
      this.B = paramInt;
      this.a.setTextColor(this.B);
    }
  }
  
  protected void c(String paramString)
  {
    if (this.jdField_f_of_type_JavaLangString != null) {
      this.a.setCompoundDrawablesWithIntrinsicBounds(DrawableUtil.a(this.a.getContext(), this.jdField_f_of_type_JavaLangString, null, null), null, null, null);
    }
  }
  
  protected void d(String paramString)
  {
    if (this.b)
    {
      this.a.setText(Html.fromHtml(paramString));
      return;
    }
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText
 * JD-Core Version:    0.7.0.1
 */