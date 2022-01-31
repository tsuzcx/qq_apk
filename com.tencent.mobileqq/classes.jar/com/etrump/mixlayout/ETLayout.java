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
  int jdField_a_of_type_Int;
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
  private ArrayList b;
  public boolean b;
  public int c;
  private boolean c;
  private int d = 0;
  private int e;
  private int f;
  
  ETLayout()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_c_of_type_Boolean = false;
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
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if ((this.jdField_a_of_type_JavaLangCharSequence != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      if ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spanned)) {
        b();
      }
    }
    else {
      return;
    }
    a(this.jdField_a_of_type_JavaLangCharSequence.toString(), 0, this.jdField_a_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, false);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    int j = 2048;
    if (paramCanvas == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramInt1, paramInt2);
    int n;
    int i;
    if (paramBitmap != null)
    {
      n = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      if (Build.VERSION.SDK_INT < 14) {
        break label234;
      }
      paramInt1 = paramCanvas.getMaximumBitmapHeight();
    }
    for (paramInt2 = paramCanvas.getMaximumBitmapWidth();; paramInt2 = j)
    {
      if ((n <= paramInt2) && (i <= paramInt1)) {
        paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      for (;;)
      {
        paramCanvas.restore();
        return;
        Rect localRect = new Rect(0, 0, 0, 0);
        while (i > 0)
        {
          int k;
          if (i >= paramInt1)
          {
            k = paramInt1;
            localRect.left = 0;
            localRect.bottom += k;
            j = n;
            label136:
            if (j <= 0) {
              break label211;
            }
            if (j < paramInt2) {
              break label204;
            }
          }
          label204:
          for (int m = paramInt2;; m = j)
          {
            j -= m;
            localRect.right += m;
            paramCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
            localRect.left = (m + localRect.left);
            break label136;
            k = i;
            break;
          }
          label211:
          localRect.top = (k + localRect.top);
          i -= k;
        }
      }
      label234:
      paramInt1 = 2048;
    }
  }
  
  private void a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramEmoticonSpan = new ETParagraph(paramEmoticonSpan, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramEmoticonSpan.a(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEmoticonSpan);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.a(this.f);
    paramString.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b()
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
          break label546;
        }
      }
    }
    label546:
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
          localObject = (QQText.EmoticonSpan)arrayOfpt[i].jdField_a_of_type_AndroidTextStyleCharacterStyle;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          a((QQText.EmoticonSpan)localObject, this.jdField_b_of_type_JavaUtilArrayList.indexOf(localObject), m, k, false);
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
  
  private void b(int paramInt)
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
        k = localETFragment.e();
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
      ((ETTextLine)localObject).a(0, i, this.jdField_a_of_type_Int);
      i += ((ETTextLine)localObject).a();
      paramInt += 1;
    }
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
  
  public Rect a()
  {
    return new Rect(0, 0, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
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
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  @TargetApi(14)
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {}
    while ((this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize() * 4;
    int k = this.e;
    int i;
    if (this.jdField_c_of_type_Int < j)
    {
      i = j;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() < i) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > j + i)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label243;
      }
      QLog.d("ETLayout", 2, "ETLayout draw create bitmap width = " + k + " height = " + i);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(k, i, Bitmap.Config.ARGB_8888);
        paramCanvas.save();
        paramCanvas.translate(paramInt1, paramInt2);
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null) || (2 != this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getDecorationType())) {
          break label254;
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.drawScene(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        a(paramCanvas, 0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap);
        paramCanvas.restore();
        return;
        i = this.jdField_c_of_type_Int;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ETLayout", 2, "ETLayout draw create bitmap oom");
        continue;
      }
      label243:
      this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
    }
    label254:
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) && (1 == this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getDecorationType())) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.drawBackground(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
    }
    ETTextLine[] arrayOfETTextLine;
    if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine != null)
    {
      arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
      i = arrayOfETTextLine.length;
      paramInt1 = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      if (paramInt1 < i)
      {
        ETTextLine localETTextLine = arrayOfETTextLine[paramInt1];
        localETTextLine.a(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, paramInt2);
        paramInt2 += localETTextLine.a();
        if (paramInt2 < this.jdField_c_of_type_Int) {}
      }
      else
      {
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null) && (1 == this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.getDecorationType())) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.drawForeground(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
        }
        if (this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine == null) {
          break;
        }
        b(paramCanvas, 0, 0);
        break;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(ETDecoration paramETDecoration)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration == null)
    {
      label7:
      return;
    }
    else
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.deleteDescriptor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = null;
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = paramETDecoration;
      paramETDecoration = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    for (;;)
    {
      if (!paramETDecoration.hasNext()) {
        break label7;
      }
      Object localObject = ((ETParagraph)paramETDecoration.next()).a();
      if (localObject == null) {
        break;
      }
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ETFragment localETFragment = (ETFragment)((Iterator)localObject).next();
        if ((localETFragment != null) && (localETFragment.f() == 0)) {
          localETFragment.a(this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration);
        }
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration != null)
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration.deleteDescriptor();
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
        ETFragment localETFragment = (ETFragment)((Iterator)localObject3).next();
        if (localETFragment == null) {
          break;
        }
        String str = localETFragment.a();
        if (str != null)
        {
          localETFragment.a(j);
          j += str.length();
          ((StringBuilder)localObject1).append(str);
        }
      }
      localObject2 = a();
      int i = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length;
      j = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine[(this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine.length - 1)].b();
      this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration = ETDecoration.createDecoration(this.jdField_a_of_type_ComEtrumpMixlayoutETEngine, ((StringBuilder)localObject1).toString(), (ETSegment[])localObject2, this.jdField_b_of_type_JavaUtilArrayList.toArray(), paramInt1, paramInt2, j, i, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
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
          if ((localObject3 != null) && (((ETFragment)localObject3).f() == 0)) {
            ((ETFragment)localObject3).a(this.jdField_a_of_type_ComEtrumpMixlayoutETDecoration);
          }
        }
      }
    }
    return true;
  }
  
  public boolean a(int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2)
  {
    this.e = paramInt1;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_b_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null))
    {
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.copy(this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      this.jdField_b_of_type_ComEtrumpMixlayoutETFont.setColor(paramInt2);
    }
    a();
    if (this.jdField_a_of_type_Boolean) {
      return false;
    }
    b(paramInt1);
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
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_c_of_type_Int = i;
      if ((this.jdField_b_of_type_Int <= 0) || (this.jdField_c_of_type_Int <= 0)) {
        throw new Exception("mesure fail mWidth=" + this.jdField_b_of_type_Int + ",mHeight" + this.jdField_c_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return true;
    }
  }
  
  public ETSegment[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ETTextLine[] arrayOfETTextLine = this.jdField_a_of_type_ArrayOfComEtrumpMixlayoutETTextLine;
    int i1 = arrayOfETTextLine.length;
    int k = 0;
    int j = 0;
    int i = 0;
    while (k < i1)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[k];
      Object localObject = localETTextLine.a();
      if (localObject == null) {
        return null;
      }
      localObject = ((ArrayList)localObject).iterator();
      int m = 0;
      while (((Iterator)localObject).hasNext())
      {
        ETFragment localETFragment = (ETFragment)((Iterator)localObject).next();
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
        String str = localETFragment.a();
        int n = i;
        int i2;
        if (str != null)
        {
          localETSegment.textLength = str.length();
          localETSegment.textOffset = i;
          localETSegment.type = 0;
          n = i + str.length();
          i = localETTextLine.a();
          i2 = localETFragment.d();
          int i3 = localETTextLine.e();
          int i4 = localETFragment.g();
          localETSegment.x = m;
          localETSegment.y = (i - i2 + j - (i3 - i4));
        }
        str = localETFragment.b();
        if (str != null)
        {
          localETSegment.textLength = 1;
          localETSegment.type = 1;
          localETSegment.codePoint = a(str.charAt(0), str.charAt(1));
          i = localETTextLine.a();
          i2 = localETFragment.d();
          localETSegment.x = m;
          localETSegment.y = (i - i2 + j);
        }
        i = localETFragment.b();
        if (i > -1)
        {
          localETSegment.type = 2;
          localETSegment.codePoint = i;
          i = localETTextLine.a();
          i2 = localETFragment.d();
          localETSegment.x = m;
          localETSegment.y = (i - i2 + j);
        }
        localETSegment.textSize = localETFragment.a();
        localETSegment.lineNum = localETFragment.e();
        localArrayList.add(localETSegment);
        m = localETFragment.c() + m;
        i = n;
      }
      m = localETTextLine.a();
      k += 1;
      j += m;
    }
    return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */