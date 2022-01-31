package com.etrump.mixlayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import ps;
import pt;

public class ETLayout
{
  public int a;
  public long a;
  public Bitmap a;
  private ETDecoration jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
  private ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstance();
  public ETFont a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(16);
  public AtomicBoolean a;
  public boolean a;
  private ETTextLine[] jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
  public int b;
  public ETFont b;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  private int e;
  
  ETLayout()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, "", 24.0F);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramCharSequence == null) {
      return new String("");
    }
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
      return new String("");
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
  
  private final void a(Bitmap paramBitmap)
  {
    int k;
    int i;
    int j;
    if ((paramBitmap != null) && (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null))
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      }
      k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      if (i < k)
      {
        this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramBitmap, 0, j);
        j += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a();
        if (j < paramBitmap.getHeight()) {}
      }
      else
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.b(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        }
        return;
      }
      i += 1;
    }
  }
  
  private void a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramEmoticonSpan = new ETParagraph(paramEmoticonSpan, paramInt1, paramInt2, paramBoolean);
    paramEmoticonSpan.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmoticonSpan);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.a(this.e);
    paramString.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spanned)) {
        c();
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
  }
  
  private final void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < k)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a(paramCanvas, paramInt1, i);
      i += this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      paramInt2 += 1;
    }
  }
  
  private void c()
  {
    Object localObject = (Spanned)this.jdField_a_of_type_JavaLangCharSequence;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
    pt[] arrayOfpt = new pt[arrayOfCharacterStyle.length];
    if ((arrayOfpt == null) || (arrayOfpt.length == 0))
    {
      a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      return;
    }
    int i = 0;
    while (i < arrayOfCharacterStyle.length)
    {
      arrayOfpt[i] = new pt();
      arrayOfpt[i].jdField_a_of_type_Int = ((Spanned)localObject).getSpanStart(arrayOfCharacterStyle[i]);
      arrayOfpt[i].jdField_b_of_type_Int = ((Spanned)localObject).getSpanEnd(arrayOfCharacterStyle[i]);
      arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle = arrayOfCharacterStyle[i];
      i += 1;
    }
    Arrays.sort(arrayOfpt, new ps());
    i = 0;
    int j = 0;
    label169:
    int m;
    int k;
    if (i < arrayOfCharacterStyle.length)
    {
      m = arrayOfpt[i].jdField_a_of_type_Int;
      k = arrayOfpt[i].jdField_b_of_type_Int;
      if (m - j > 0) {
        a(a(this.jdField_a_of_type_JavaLangCharSequence, j, m).toString(), j, m, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
      }
      if (k - m > 0)
      {
        if (!(arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof ClickableSpan)) {
          break label372;
        }
        if ((m <= 0) || (this.jdField_a_of_type_JavaLangCharSequence.charAt(m - 1) != '\024')) {
          break label523;
        }
      }
    }
    label523:
    for (j = m + 1;; j = m)
    {
      a(a(this.jdField_a_of_type_JavaLangCharSequence, j, k).toString(), j, k, this.jdField_b_of_type_ComEtrumpMixlayoutETFont, true);
      for (;;)
      {
        if ((i == arrayOfCharacterStyle.length - 1) && (k < this.jdField_a_of_type_JavaLangCharSequence.length())) {
          a(a(this.jdField_a_of_type_JavaLangCharSequence, k, this.jdField_a_of_type_JavaLangCharSequence.length()).toString(), k, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
        }
        i += 1;
        j = k;
        break label169;
        break;
        label372:
        if ((arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof QQText.EmoticonSpan))
        {
          a((QQText.EmoticonSpan)arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle, m, k, false);
        }
        else if ((arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof RelativeSizeSpan))
        {
          localObject = a(this.jdField_a_of_type_JavaLangCharSequence, m, k);
          RelativeSizeSpan localRelativeSizeSpan = (RelativeSizeSpan)arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          ETFont localETFont = new ETFont(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          localETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
          localETFont.setSize(localRelativeSizeSpan.getSizeChange() * this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize());
          a(((CharSequence)localObject).toString(), m, k, localETFont, false, true);
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null) {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = null;
    }
    int m = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    int j = 0;
    int k = 0;
    Object localObject;
    while (i < m)
    {
      localObject = (ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      k = ((ETParagraph)localObject).a(paramInt, j, k);
      j = ((ETParagraph)localObject).a();
      i += 1;
    }
    j = k + 1;
    this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine = new ETTextLine[j];
    paramInt = 0;
    while (paramInt < j)
    {
      this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt] = new ETTextLine();
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < m)
    {
      localObject = ((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a();
      i = 0;
      while (i < ((ArrayList)localObject).size())
      {
        ETFragment localETFragment = (ETFragment)((ArrayList)localObject).get(i);
        k = localETFragment.c();
        if ((k >= 0) && (k < j)) {
          this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[k].a(localETFragment);
        }
        i += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i = 0;
    while (paramInt < j)
    {
      localObject = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt];
      ((ETTextLine)localObject).a(0, i);
      i += ((ETTextLine)localObject).a();
      paramInt += 1;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    if (i < j)
    {
      localRect.left = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].c();
      localRect.top = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].d();
      localRect.right = (localRect.left + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].b());
      localRect.bottom = (localRect.top + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      ETFragment localETFragment;
      do
      {
        i += 1;
        break;
        localETFragment = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramInt1);
      } while (localETFragment == null);
      return localETFragment.a().b();
    }
    return -1;
  }
  
  public ETDecoration a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration;
  }
  
  public QQText.EmoticonSpan a(int paramInt1, int paramInt2)
  {
    int i = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    if (i < j)
    {
      localRect.left = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].c();
      localRect.top = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].d();
      localRect.right = (localRect.left + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].b());
      localRect.bottom = (localRect.top + this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a());
      if (!localRect.contains(paramInt1, paramInt2)) {}
      ETFragment localETFragment;
      do
      {
        i += 1;
        break;
        localETFragment = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[i].a(paramInt1);
      } while (localETFragment == null);
      return localETFragment.a();
    }
    return null;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize() * 4;
    int k = this.d;
    int i;
    if (this.jdField_b_of_type_Int < j)
    {
      i = j;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() < i) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > j + i)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label141;
      }
      QLog.d("ETTextView", 2, "ETLayout doDrawText create bitmap width = " + k + " height = " + i);
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(k, i, Bitmap.Config.ARGB_8888);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
      i = this.jdField_b_of_type_Int;
      break;
      label141:
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  @TargetApi(14)
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int j = 2048;
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    int i2;
    int k;
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      i2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      k = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      if (Build.VERSION.SDK_INT < 14) {
        break label259;
      }
      i = paramCanvas.getMaximumBitmapHeight();
      j = paramCanvas.getMaximumBitmapWidth();
    }
    for (;;)
    {
      if ((i2 <= j) && (k <= i)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      }
      for (;;)
      {
        paramCanvas.restore();
        b(paramCanvas, paramInt1, paramInt2);
        return;
        Rect localRect = new Rect(0, 0, 0, 0);
        while (k > 0)
        {
          int n;
          int m;
          if (k >= i)
          {
            n = i;
            localRect.left = 0;
            localRect.bottom += n;
            m = i2;
            label157:
            if (m <= 0) {
              break label236;
            }
            if (m < j) {
              break label229;
            }
          }
          label229:
          for (int i1 = j;; i1 = m)
          {
            m -= i1;
            localRect.right += i1;
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localRect, localRect, null);
            localRect.left = (i1 + localRect.left);
            break label157;
            n = k;
            break;
          }
          label236:
          localRect.top = (n + localRect.top);
          k -= n;
        }
      }
      label259:
      i = 2048;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.b();
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = null;
    }
    if ((this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine == null) || (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length == 0)) {}
    Object localObject2;
    label73:
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return false;
        } while ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0));
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = ((ETParagraph)((Iterator)localObject2).next()).a();
      } while (localObject3 == null);
      localObject3 = ((ArrayList)localObject3).iterator();
      int j = i;
      for (;;)
      {
        i = j;
        if (!((Iterator)localObject3).hasNext()) {
          break label73;
        }
        Object localObject4 = (ETFragment)((Iterator)localObject3).next();
        if (localObject4 == null) {
          break;
        }
        localObject4 = ((ETFragment)localObject4).a(j);
        if (localObject4 != null)
        {
          j += ((String)localObject4).length();
          ((StringBuilder)localObject1).append((String)localObject4);
        }
      }
      int i = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[(this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length - 1)].b();
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = ETDecoration.a(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine, ((StringBuilder)localObject1).toString(), paramInt1, paramInt2, j, i, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    } while (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null);
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((ETParagraph)((Iterator)localObject1).next()).a();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ETFragment)((Iterator)localObject2).next();
          if ((localObject3 != null) && (((ETFragment)localObject3).d() == 0)) {
            ((ETFragment)localObject3).a(this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration);
          }
        }
      }
    }
    return true;
  }
  
  public boolean a(int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2)
  {
    this.d = paramInt1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
    }
    b();
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    c(paramInt1);
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine == null) {
      throw new Exception("measure textLines fail");
    }
    int k = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
    paramInt2 = 0;
    int i = 0;
    paramInt1 = 0;
    int m;
    if (paramInt2 < k)
    {
      int j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].b();
      m = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[paramInt2].a();
      if (j <= paramInt1) {
        break label240;
      }
      paramInt1 = j;
    }
    label240:
    for (;;)
    {
      i += m;
      paramInt2 += 1;
      break;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = i;
      if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {
        throw new Exception("mesure fail mWidth=" + this.jdField_a_of_type_Int + ",mHeight" + this.jdField_b_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return true;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt);
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Boolean) {
        ((ETParagraph)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a().setColor(paramInt);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */