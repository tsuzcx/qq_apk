package com.etrump.mixlayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class ETLayout
{
  int jdField_a_of_type_Int;
  public long a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  public ETFont a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList<ETParagraph> jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public AtomicBoolean a;
  public boolean a;
  private ETTextLine[] jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
  public int b;
  public ETFont b;
  private ArrayList<CharacterStyle> b;
  public boolean b;
  public int c;
  private ArrayList<ETTextRange> jdField_c_of_type_JavaUtilArrayList = new ArrayList(16);
  private boolean jdField_c_of_type_Boolean;
  int d = -1;
  private int e;
  private int f;
  private int g;
  
  ETLayout()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(4);
    this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  }
  
  private int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      return "";
    }
    int j = 0;
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i;
    if (paramInt2 <= 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return null;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return null;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((ETParagraph)((Iterator)localObject1).next()).a();
          if (localObject2 == null) {
            return null;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          int j = i;
          for (;;)
          {
            i = j;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            ETFragment localETFragment = (ETFragment)((Iterator)localObject2).next();
            if (localETFragment == null) {
              return null;
            }
            String str = localETFragment.a();
            if (str != null)
            {
              localETFragment.a(j);
              j += str.length();
              localStringBuilder.append(str);
            }
          }
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.jdField_a_of_type_JavaLangCharSequence;
    if ((localObject != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((localObject instanceof Spanned))
      {
        b();
        return;
      }
      a(((CharSequence)localObject).toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
    }
  }
  
  private void a(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).setSignatureActionSpanData(paramInt1, paramInt2, paramCharacterStyle);
  }
  
  private void a(Canvas paramCanvas)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).drawSignatureSpan(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, this.jdField_a_of_type_AndroidGraphicsPaint, this.d, paramCanvas);
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramCharacterStyle = new ETParagraph(paramCharacterStyle, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramCharacterStyle.a(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramCharacterStyle);
  }
  
  private void a(ETEngine paramETEngine, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null) {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = null;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject1;
    while (i < m)
    {
      localObject1 = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      j = ((ETParagraph)localObject1).a(paramETEngine, paramInt, k, j);
      k = ((ETParagraph)localObject1).a();
      i += 1;
    }
    k = j + 1;
    this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = new ETTextLine[k];
    paramInt = 0;
    while (paramInt < k)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt] = new ETTextLine();
      paramInt += 1;
    }
    paramInt = 0;
    Object localObject2;
    while (paramInt < m)
    {
      localObject1 = ((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      i = 0;
      while (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (ETFragment)((ArrayList)localObject1).get(i);
        j = ((ETFragment)localObject2).e();
        if ((j >= 0) && (j < k)) {
          this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[j].a((ETFragment)localObject2);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < k)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt];
      ((ETTextLine)localObject1).a(paramETEngine, 0, i, this.jdField_a_of_type_Int);
      localObject2 = ((ETTextLine)localObject1).a().iterator();
      j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ETFragment localETFragment = (ETFragment)((Iterator)localObject2).next();
        ETTextRange[] arrayOfETTextRange = localETFragment.a(paramETEngine, j, i, ((ETTextLine)localObject1).a(), paramInt);
        if ((arrayOfETTextRange != null) && (arrayOfETTextRange.length > 0)) {
          Collections.addAll(this.jdField_c_of_type_JavaUtilArrayList, arrayOfETTextRange);
        }
        j += localETFragment.c();
      }
      i += ((ETTextLine)localObject1).a();
      paramInt += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return;
    }
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.a(this.g);
    paramString.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Object[] a()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return this.jdField_b_of_type_JavaUtilArrayList.toArray();
    }
    return null;
  }
  
  private int b()
  {
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if ((arrayOfETTextLine != null) && (arrayOfETTextLine.length != 0)) {
      return arrayOfETTextLine[(arrayOfETTextLine.length - 1)].b();
    }
    return 0;
  }
  
  private void b()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Object localObject = (Spanned)this.jdField_a_of_type_JavaLangCharSequence;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
    ETLayout.ETRange[] arrayOfETRange = new ETLayout.ETRange[arrayOfCharacterStyle.length];
    if (arrayOfETRange.length == 0)
    {
      a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOfETRange[i] = new ETLayout.ETRange();
      arrayOfETRange[i].jdField_a_of_type_Int = ((Spanned)localObject).getSpanStart(arrayOfCharacterStyle[i]);
      arrayOfETRange[i].jdField_b_of_type_Int = ((Spanned)localObject).getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOfETRange, new ETLayout.ETComparator());
    int j = 0;
    i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      int m = arrayOfETRange[i].jdField_a_of_type_Int;
      int k = arrayOfETRange[i].jdField_b_of_type_Int;
      if (m - j > 0) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, j, m).toString(), j, m, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      if (k - m > 0) {
        if ((arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof ClickableSpan))
        {
          j = m;
          if (m > 0)
          {
            j = m;
            if (this.jdField_a_of_type_JavaLangCharSequence.charAt(m - 1) == ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSysEmotcationHead()) {
              j = m + 1;
            }
          }
          a(a(this.jdField_a_of_type_JavaLangCharSequence, j, k).toString(), j, k, this.jdField_b_of_type_ComEtrumpMixlayoutETFont, true);
        }
        else if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfEmoticonSpan(arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle))
        {
          localObject = arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          a((CharacterStyle)localObject, this.jdField_b_of_type_JavaUtilArrayList.indexOf(localObject), m, k, false);
        }
        else if ((arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof RelativeSizeSpan))
        {
          localObject = a(this.jdField_a_of_type_JavaLangCharSequence, m, k);
          RelativeSizeSpan localRelativeSizeSpan = (RelativeSizeSpan)arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          ETFont localETFont = new ETFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          localETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          localETFont.setSize(localRelativeSizeSpan.getSizeChange() * this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          a(((CharSequence)localObject).toString(), m, k, localETFont, false, true);
        }
        else if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfSignatureActionSpan(arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle))
        {
          localObject = arrayOfETRange[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          a((CharacterStyle)localObject, this.jdField_b_of_type_JavaUtilArrayList.indexOf(localObject), m, k, false);
        }
      }
      if ((i == arrayOfCharacterStyle.length - 1) && (k < this.jdField_a_of_type_JavaLangCharSequence.length()))
      {
        localObject = this.jdField_a_of_type_JavaLangCharSequence;
        a(a((CharSequence)localObject, k, ((CharSequence)localObject).length()).toString(), k, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      i += 1;
      j = k;
    }
  }
  
  public int a()
  {
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (arrayOfETTextLine != null) {
      return arrayOfETTextLine.length;
    }
    return 0;
  }
  
  int a(int paramInt)
  {
    int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    int i = 0;
    while (i < j)
    {
      ETTextLine localETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i];
      if (paramInt < localETTextLine.d() + localETTextLine.a()) {
        return i;
      }
      i += 1;
    }
    return j - 1;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int k = a(paramInt2);
    int m = this.jdField_c_of_type_JavaUtilArrayList.size();
    int i = m - 1;
    paramInt2 = 0;
    while (paramInt2 < m)
    {
      ETTextRange localETTextRange = (ETTextRange)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt2);
      int j;
      if (localETTextRange.jdField_a_of_type_Int == k)
      {
        if (paramInt1 <= localETTextRange.jdField_a_of_type_AndroidGraphicsRect.right) {
          return paramInt2;
        }
        j = paramInt2;
      }
      else
      {
        j = i;
        if (localETTextRange.jdField_a_of_type_Int > k) {
          break;
        }
      }
      paramInt2 += 1;
      i = j;
    }
    return i + 1;
  }
  
  Rect a(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
      if (paramInt < localObject.length)
      {
        localObject = localObject[paramInt];
        paramInt = ((ETTextLine)localObject).c();
        int i = ((ETTextLine)localObject).d();
        return new Rect(paramInt, i, this.jdField_b_of_type_Int + paramInt, ((ETTextLine)localObject).a() + i);
      }
    }
    return null;
  }
  
  public CharacterStyle a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    int j = arrayOfETTextLine.length;
    while (i < j)
    {
      Object localObject = arrayOfETTextLine[i];
      localRect.left = ((ETTextLine)localObject).c();
      localRect.top = ((ETTextLine)localObject).d();
      localRect.right = (localRect.left + ((ETTextLine)localObject).b());
      localRect.bottom = (localRect.top + ((ETTextLine)localObject).a());
      if (localRect.contains(paramInt1, paramInt2))
      {
        localObject = ((ETTextLine)localObject).a(paramInt1);
        if (localObject != null) {
          return ((ETFragment)localObject).a();
        }
      }
      i += 1;
    }
    return null;
  }
  
  public ETDecoration a(ETEngine paramETEngine, boolean paramBoolean)
  {
    if (paramETEngine == null) {
      return null;
    }
    String str = a();
    int j = b();
    int k = a();
    ETSegment[] arrayOfETSegment = a(paramETEngine);
    Object[] arrayOfObject = a();
    if (!paramBoolean)
    {
      this.d = -1;
      if (this.jdField_b_of_type_JavaUtilArrayList != null)
      {
        int i = 0;
        while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          CharacterStyle localCharacterStyle = (CharacterStyle)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfSignatureActionSpan(localCharacterStyle))
          {
            this.d = i;
            break;
          }
          i += 1;
        }
      }
    }
    return (ETDecoration)ETDecoration.createDecoration(paramETEngine, str, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, j, k, arrayOfETSegment, arrayOfObject, this.jdField_c_of_type_Boolean, this.f, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, paramBoolean);
  }
  
  ETTextRange a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_c_of_type_JavaUtilArrayList.size())) {
      return (ETTextRange)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (arrayOfETTextLine == null) {
      return;
    }
    int k = arrayOfETTextLine.length;
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < k)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[paramInt2];
      localETTextLine.a(paramCanvas, paramInt1, i);
      i += localETTextLine.a();
      paramInt2 += 1;
    }
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    if (paramBitmap != null)
    {
      int m = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      paramInt1 = Build.VERSION.SDK_INT;
      paramInt2 = 2048;
      if (paramInt1 >= 14)
      {
        paramInt2 = paramCanvas.getMaximumBitmapHeight();
        paramInt1 = paramCanvas.getMaximumBitmapWidth();
      }
      else
      {
        paramInt1 = 2048;
      }
      if ((m <= paramInt1) && (i <= paramInt2))
      {
        paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      else
      {
        Rect localRect = new Rect(0, 0, 0, 0);
        while (i > 0)
        {
          int j;
          if (i >= paramInt2) {
            j = paramInt2;
          } else {
            j = i;
          }
          int n = i - j;
          localRect.left = 0;
          localRect.bottom += j;
          i = m;
          while (i > 0)
          {
            int k;
            if (i >= paramInt1) {
              k = paramInt1;
            } else {
              k = i;
            }
            i -= k;
            localRect.right += k;
            paramCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
            localRect.left += k;
          }
          localRect.top += j;
          i = n;
        }
      }
    }
    paramCanvas.restore();
  }
  
  @TargetApi(14)
  public final void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, boolean paramBoolean)
  {
    ETDecoration localETDecoration = paramETDecoration;
    if (paramETEngine != null)
    {
      if (paramBitmap == null) {
        return;
      }
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
      {
        int n = paramBitmap.getHeight();
        int j;
        int i;
        int i1;
        int k;
        if ((localETDecoration != null) && (2 == paramETDecoration.getDecorationType()))
        {
          if (paramBoolean)
          {
            localETDecoration.drawScene(paramBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            return;
          }
          paramETDecoration = localETDecoration.mMargins;
          if (paramETDecoration != null)
          {
            j = paramETDecoration.left;
            i = paramETDecoration.top;
          }
          else
          {
            i = 0;
            j = 0;
          }
          localETDecoration.drawBackground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          paramETDecoration = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
          if (paramETDecoration != null)
          {
            i1 = paramETDecoration.length;
            int m = 0;
            k = i;
            i = m;
          }
        }
        else
        {
          while (i < i1)
          {
            localETDecoration = paramETDecoration[i];
            localETDecoration.a(paramETEngine, paramBitmap, null, j, k);
            k += localETDecoration.a();
            if (k >= n) {
              return;
            }
            i += 1;
            continue;
            if (!paramBoolean) {
              localETDecoration = null;
            }
            if ((localETDecoration != null) && (1 == localETDecoration.getDecorationType())) {
              localETDecoration.drawBackground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            }
            paramETDecoration = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
            if (paramETDecoration != null)
            {
              k = paramETDecoration.length;
              i = 0;
              j = 0;
              while (i < k)
              {
                Object localObject = paramETDecoration[i];
                localObject.a(paramETEngine, paramBitmap, localETDecoration, 0, j);
                j += localObject.a();
                if (j >= n) {
                  break;
                }
                i += 1;
              }
            }
            if ((localETDecoration != null) && (1 == localETDecoration.getDecorationType())) {
              localETDecoration.drawForeground(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
            }
          }
        }
      }
    }
  }
  
  public boolean a(ETEngine paramETEngine, int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.e = paramInt1;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.f = paramInt3;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Boolean = true;
    paramCharSequence = this.jdField_b_of_type_ComEtrumpMixlayoutETFont;
    if (paramCharSequence != null)
    {
      paramETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      if (paramETFont != null)
      {
        paramCharSequence.copy(paramETFont);
        this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
      }
    }
    a();
    paramBoolean = this.jdField_a_of_type_Boolean;
    paramInt2 = 0;
    if (paramBoolean) {
      return false;
    }
    a(paramETEngine, paramInt1);
    paramETEngine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (paramETEngine != null)
    {
      int k = paramETEngine.length;
      paramInt3 = 0;
      int i = 0;
      paramInt1 = paramInt2;
      paramInt2 = i;
      while (paramInt1 < k)
      {
        int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt1].b();
        int m = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt1].a();
        i = paramInt3;
        if (j > paramInt3) {
          i = j;
        }
        paramInt2 += m;
        paramInt1 += 1;
        paramInt3 = i;
      }
      this.jdField_b_of_type_Int = paramInt3;
      this.jdField_c_of_type_Int = paramInt2;
      if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return true;
      }
      paramETEngine = new StringBuilder();
      paramETEngine.append("mesure fail mWidth=");
      paramETEngine.append(this.jdField_b_of_type_Int);
      paramETEngine.append(",mHeight");
      paramETEngine.append(this.jdField_c_of_type_Int);
      throw new Exception(paramETEngine.toString());
    }
    paramETEngine = new Exception("measure textLines fail");
    for (;;)
    {
      throw paramETEngine;
    }
  }
  
  public ETSegment[] a(ETEngine paramETEngine)
  {
    ArrayList localArrayList = new ArrayList();
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (arrayOfETTextLine == null) {
      return null;
    }
    int n = arrayOfETTextLine.length;
    int j = 0;
    int m = 0;
    int i = 0;
    while (j < n)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[j];
      Object localObject1 = localETTextLine.a();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      int k = 0;
      while (((Iterator)localObject1).hasNext())
      {
        ETFragment localETFragment = (ETFragment)((Iterator)localObject1).next();
        if (localETFragment == null) {
          return null;
        }
        ETSegment localETSegment = new ETSegment();
        localETSegment.type = 0;
        localETSegment.codePoint = -1;
        localETSegment.textOffset = 0;
        localETSegment.textLength = 0;
        localETSegment.lineNum = 0;
        localETSegment.textSize = 0;
        localETSegment.x = 0;
        localETSegment.y = 0;
        Object localObject2 = localETFragment.a();
        int i2;
        if (localObject2 != null)
        {
          localETSegment.textLength = ((String)localObject2).length();
          localETSegment.textOffset = m;
          localETSegment.type = 0;
          m += ((String)localObject2).length();
          i1 = localETTextLine.a();
          i2 = localETFragment.d();
          int i3 = localETTextLine.e();
          int i4 = localETFragment.a(paramETEngine);
          localETSegment.x = k;
          localETSegment.y = (i1 - i2 + i - (i3 - i4));
        }
        localObject2 = localETFragment.b();
        if (localObject2 != null)
        {
          localETSegment.textLength = 1;
          localETSegment.type = 1;
          localETSegment.codePoint = a(((String)localObject2).charAt(0), ((String)localObject2).charAt(1));
          i1 = localETTextLine.a();
          i2 = localETFragment.d();
          localETSegment.x = k;
          localETSegment.y = (i1 - i2 + i);
        }
        int i1 = localETFragment.b();
        if (i1 > -1)
        {
          localETSegment.type = 2;
          localETSegment.codePoint = i1;
          i1 = localETTextLine.a();
          i2 = localETFragment.d();
          localETSegment.x = k;
          localETSegment.y = (i1 - i2 + i);
          localObject2 = localETFragment.b();
          a(k, localETSegment.y, (CharacterStyle)localObject2);
        }
        localETSegment.textSize = localETFragment.a();
        localETSegment.lineNum = localETFragment.e();
        localArrayList.add(localETSegment);
        k += localETFragment.c();
      }
      i += localETTextLine.a();
      j += 1;
    }
    return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
  }
  
  public ETTextRange[] a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if ((localObject != null) && (paramInt < localObject.length))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ETTextRange localETTextRange = (ETTextRange)localIterator.next();
        if (localETTextRange.jdField_a_of_type_Int == paramInt) {
          ((ArrayList)localObject).add(localETTextRange);
        }
      }
      return (ETTextRange[])((ArrayList)localObject).toArray(new ETTextRange[0]);
    }
    return null;
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    int j = arrayOfETTextLine.length;
    while (i < j)
    {
      Object localObject = arrayOfETTextLine[i];
      localRect.left = ((ETTextLine)localObject).c();
      localRect.top = ((ETTextLine)localObject).d();
      localRect.right = (localRect.left + ((ETTextLine)localObject).b());
      localRect.bottom = (localRect.top + ((ETTextLine)localObject).a());
      if (localRect.contains(paramInt1, paramInt2))
      {
        localObject = ((ETTextLine)localObject).a(paramInt1);
        if (localObject != null) {
          return ((ETFragment)localObject).a().b();
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = this.d;
    if ((i > -1) && (i < this.jdField_b_of_type_JavaUtilArrayList.size())) {
      a(paramCanvas);
    }
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    if (arrayOfETTextLine == null) {
      return;
    }
    int k = arrayOfETTextLine.length;
    int j = 0;
    i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < k)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[paramInt2];
      localETTextLine.b(paramCanvas, paramInt1, i);
      i += localETTextLine.a();
      paramInt2 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */