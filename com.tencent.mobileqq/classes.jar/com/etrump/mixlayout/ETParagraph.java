package com.etrump.mixlayout;

import android.text.style.CharacterStyle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.util.ArrayList;

public class ETParagraph
{
  private int jdField_a_of_type_Int;
  private CharacterStyle jdField_a_of_type_AndroidTextStyleCharacterStyle;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ETFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
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
  
  public ETParagraph(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
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
  
  private int a(CharacterStyle paramCharacterStyle)
  {
    return ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSpanWidth(paramCharacterStyle);
  }
  
  private int a(ETEngine paramETEngine, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return 0;
      }
      long l = paramETEngine.native_textLayoutLock(paramString, this.f, 1073741823, this.g, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      int j = paramETEngine.native_textLayoutLineTotal(l);
      if (j < 1)
      {
        paramETEngine.native_textLayoutUnlock(l);
        return 0;
      }
      if (paramETEngine.native_textLayoutHasPreLine(l) == true)
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
        int k = paramETEngine.native_textLayoutLineRangeFrom(l, i);
        int m = paramETEngine.native_textLayoutLineRangeTo(l, i);
        int n = paramETEngine.native_textLayoutLineWidth(l, i);
        int i1 = paramETEngine.native_textLayoutLineHeight(l, i);
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
        paramString.d(this.e + j);
        paramString.e(0);
        paramString.a(this);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.g = 0;
        i = j + 1;
      }
      else if (j == 1)
      {
        this.g += localObject[0].c();
        i = j;
      }
      else
      {
        this.g = localObject[(j - 1)].c();
        i = j;
      }
      this.e += i - 1;
      paramETEngine.native_textLayoutUnlock(l);
      return i;
    }
    return 0;
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt)
  {
    if (paramCharacterStyle == null) {
      return;
    }
    int i = a(paramCharacterStyle);
    if (this.jdField_b_of_type_Boolean == true)
    {
      if (this.g != 0)
      {
        this.g = i;
        this.e += 1;
      }
    }
    else
    {
      int j = this.g;
      if (j == 0)
      {
        this.g = i;
      }
      else if (this.f < i + j)
      {
        this.g = i;
        this.e += 1;
      }
      else
      {
        this.g = (j + i);
      }
    }
    paramCharacterStyle = new ETFragment(paramCharacterStyle, paramInt);
    paramCharacterStyle.d(this.e);
    paramCharacterStyle.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCharacterStyle);
    if ((this.jdField_b_of_type_Boolean == true) && (this.g != 0))
    {
      this.g = 0;
      this.e += 1;
    }
  }
  
  private void a(ETEngine paramETEngine)
  {
    int n = this.jdField_a_of_type_JavaLangString.length();
    int k = -1;
    int i = 0;
    while (i < n)
    {
      if (Character.isHighSurrogate(this.jdField_a_of_type_JavaLangString.charAt(i)))
      {
        j = i + 1;
        if ((j < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j))))
        {
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, i));
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(i, i + 2));
          m = j;
          break label137;
        }
      }
      int j = k;
      int m = i;
      if (i + 1 == n)
      {
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, n));
        j = n;
        m = i;
      }
      label137:
      i = m + 1;
      k = j;
    }
  }
  
  private void a(ETEngine paramETEngine, String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramETEngine.sysMeasureText(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int j = paramETEngine.sysFontHeight(paramString, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize(), 0, 0, 0, 0, 0, 0, 0);
    int k = this.f;
    int m = this.g;
    if (k < i + m)
    {
      this.g = i;
      this.e += 1;
    }
    else
    {
      this.g = (m + i);
    }
    paramETEngine = new ETFragment(paramString);
    paramETEngine.b(i);
    paramETEngine.c(j);
    paramETEngine.d(this.e);
    paramETEngine.e(1);
    paramETEngine.a(this);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramETEngine);
  }
  
  private void b(ETEngine paramETEngine)
  {
    int n = this.jdField_a_of_type_JavaLangString.length();
    int k = -1;
    int i = 0;
    while (i < n)
    {
      char c1 = this.jdField_a_of_type_JavaLangString.charAt(i);
      int j;
      int m;
      if (Character.isHighSurrogate(c1))
      {
        j = i + 1;
        if ((j < n) && (Character.isLowSurrogate(this.jdField_a_of_type_JavaLangString.charAt(j))))
        {
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, i));
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(i, i + 2));
          m = j;
          break label193;
        }
      }
      if (!paramETEngine.native_isPaintableChar(c1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont))
      {
        a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, i));
        a(paramETEngine, String.valueOf(c1));
        j = i;
        m = i;
      }
      else
      {
        j = k;
        m = i;
        if (i + 1 == n)
        {
          a(paramETEngine, this.jdField_a_of_type_JavaLangString.substring(k + 1, n));
          j = n;
          m = i;
        }
      }
      label193:
      i = m + 1;
      k = j;
    }
  }
  
  protected int a()
  {
    return this.g;
  }
  
  public int a(ETEngine paramETEngine, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.e = paramInt3;
    this.f = paramInt1;
    this.g = paramInt2;
    CharacterStyle localCharacterStyle = this.jdField_a_of_type_AndroidTextStyleCharacterStyle;
    if (localCharacterStyle != null)
    {
      a(localCharacterStyle, this.jdField_a_of_type_Int);
      return this.e;
    }
    if ((paramETEngine != null) && (this.jdField_a_of_type_JavaLangString != null))
    {
      if (ETEngine.getInstance().isEnableCallbackDrawing()) {
        a(paramETEngine);
      } else {
        b(paramETEngine);
      }
      return this.e;
    }
    return this.e;
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public ArrayList<ETFragment> a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETParagraph
 * JD-Core Version:    0.7.0.1
 */