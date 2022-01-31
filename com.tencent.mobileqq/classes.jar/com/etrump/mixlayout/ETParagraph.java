package com.etrump.mixlayout;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import java.util.ArrayList;

public class ETParagraph
{
  private int jdField_a_of_type_Int;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private QQText.EmoticonSpan jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  
  public ETParagraph(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  public ETParagraph(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private int a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return 0;
    }
    long l = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLock(paramString, this.f, 1073741823, this.g, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineTotal(l);
    if (j < 1)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutUnlock(l);
      return 0;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutHasPreLine(l) == true)
    {
      localObject = new ETFragment("");
      ((ETFragment)localObject).d(this.e);
      ((ETFragment)localObject).e(0);
      ((ETFragment)localObject).a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      this.g = 0;
      this.e += 1;
    }
    Object localObject = new ETFragment[j];
    int i = 0;
    while (i < j)
    {
      localObject[i] = new ETFragment("");
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      int k = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineRangeFrom(l, i);
      int m = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineRangeTo(l, i);
      int n = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineWidth(l, i);
      int i1 = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutLineHeight(l, i);
      localObject[i].a(paramString.substring(k, m));
      localObject[i].b(n);
      localObject[i].c(i1);
      localObject[i].d(this.e + i);
      localObject[i].e(0);
      localObject[i].a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject[i]);
      i += 1;
    }
    if (paramString.substring(paramString.length() - 1).equals("\n"))
    {
      paramString = new ETFragment("");
      paramString.d(this.e);
      paramString.e(0);
      paramString.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      this.g = 0;
      this.e += 1;
    }
    if (j == 1) {}
    for (this.g += localObject[0].c();; this.g = localObject[(j - 1)].c())
    {
      this.e += j - 1;
      this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_textLayoutUnlock(l);
      return j;
    }
  }
  
  private void a()
  {
    int k = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int j = 0;
    if (j < n)
    {
      int m;
      int i;
      if ((Character.isHighSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j))) && (j + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j + 1))))
      {
        a(this.jdField_a_of_type_JavaLangString.substring(k + 1, j));
        a(this.jdField_a_of_type_JavaLangString.substring(j, j + 2));
        m = j + 1;
        i = m;
      }
      for (;;)
      {
        j = m + 1;
        k = i;
        break;
        m = j;
        i = k;
        if (j + 1 == n)
        {
          a(this.jdField_a_of_type_JavaLangString.substring(k + 1, n));
          i = n;
          m = j;
        }
      }
    }
  }
  
  private void a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt)
  {
    if (paramEmoticonSpan == null) {
      return;
    }
    Rect localRect = paramEmoticonSpan.a().getBounds();
    if (this.jdField_b_of_type_Boolean == true) {
      if (this.g != 0)
      {
        this.g = localRect.width();
        this.e += 1;
      }
    }
    for (;;)
    {
      paramEmoticonSpan = new ETFragment(paramEmoticonSpan, paramInt);
      paramEmoticonSpan.d(this.e);
      paramEmoticonSpan.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramEmoticonSpan);
      if ((this.jdField_b_of_type_Boolean != true) || (this.g == 0)) {
        break;
      }
      this.g = 0;
      this.e += 1;
      return;
      if (this.g == 0)
      {
        this.g = localRect.width();
      }
      else if (this.f < localRect.width() + this.g)
      {
        this.g = localRect.width();
        this.e += 1;
      }
      else
      {
        int i = this.g;
        this.g = (localRect.width() + i);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.sysMeasureText(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.sysFontHeight(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    if (this.f < this.g + i)
    {
      this.g = i;
      this.e += 1;
    }
    for (;;)
    {
      paramString = new ETFragment(paramString);
      paramString.b(i);
      paramString.c(j);
      paramString.d(this.e);
      paramString.e(1);
      paramString.a(this);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
      return;
      this.g += i;
    }
  }
  
  private void b()
  {
    int m = -1;
    int n = this.jdField_a_of_type_JavaLangString.length();
    int i = 0;
    if (i < n)
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(i);
      int k;
      int j;
      if ((Character.isHighSurrogate(c1)) && (i + 1 < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(i + 1))))
      {
        a(this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
        a(this.jdField_a_of_type_JavaLangString.substring(i, i + 2));
        k = i + 1;
        j = k;
      }
      for (;;)
      {
        i = k + 1;
        m = j;
        break;
        if (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isPaintableChar(c1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont))
        {
          a(this.jdField_a_of_type_JavaLangString.substring(m + 1, i));
          a(String.valueOf(c1));
          j = i;
          k = i;
        }
        else
        {
          k = i;
          j = m;
          if (i + 1 == n)
          {
            a(this.jdField_a_of_type_JavaLangString.substring(m + 1, n));
            j = n;
            k = i;
          }
        }
      }
    }
  }
  
  protected int a()
  {
    return this.g;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = paramInt3;
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan != null)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan, this.jdField_a_of_type_Int);
      return this.e;
    }
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETEngine == null) || (this.jdField_a_of_type_JavaLangString == null)) {
      return this.e;
    }
    if (ETEngine.getInstance().isEnableCallbackDrawing()) {
      a();
    }
    for (;;)
    {
      return this.e;
      b();
    }
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETParagraph
 * JD-Core Version:    0.7.0.1
 */