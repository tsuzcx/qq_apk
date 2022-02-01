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
  int a;
  public long b = 0L;
  public ETFont c;
  public ETFont d = new ETFont(0, "", 24.0F);
  public int e;
  public int f;
  public boolean g = false;
  public boolean h;
  int i = -1;
  Paint j = new Paint(1);
  public AtomicBoolean k = new AtomicBoolean(false);
  private CharSequence l;
  private int m;
  private ArrayList<ETParagraph> n = new ArrayList(16);
  private ETTextLine[] o;
  private ArrayList<CharacterStyle> p = new ArrayList(4);
  private boolean q;
  private int r;
  private int s;
  private ArrayList<ETTextRange> t = new ArrayList(16);
  
  private int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      return "";
    }
    int i2 = 0;
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > paramCharSequence.length()) {
      paramInt1 = paramCharSequence.length();
    }
    paramInt2 = paramInt1 - i1;
    if (paramInt2 <= 0) {
      return "";
    }
    char[] arrayOfChar = new char[paramInt2];
    paramInt1 = i2;
    while (paramInt1 < paramInt2)
    {
      arrayOfChar[paramInt1] = paramCharSequence.charAt(paramInt1 + i1);
      paramInt1 += 1;
    }
    return String.valueOf(arrayOfChar);
  }
  
  private void a(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).setSignatureActionSpanData(paramInt1, paramInt2, paramCharacterStyle);
  }
  
  private void a(Canvas paramCanvas)
  {
    ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).drawSignatureSpan(this.p, this.c, this.j, this.i, paramCanvas);
  }
  
  private void a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.n == null) {
      return;
    }
    paramCharacterStyle = new ETParagraph(paramCharacterStyle, paramInt1, paramInt2, paramInt3, paramBoolean);
    paramCharacterStyle.a(this.s);
    this.n.add(paramCharacterStyle);
  }
  
  private void a(ETEngine paramETEngine, int paramInt)
  {
    if (this.o != null) {
      this.o = null;
    }
    int i4 = this.n.size();
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    Object localObject1;
    while (i1 < i4)
    {
      localObject1 = (ETParagraph)this.n.get(i1);
      i2 = ((ETParagraph)localObject1).a(paramETEngine, paramInt, i3, i2);
      i3 = ((ETParagraph)localObject1).b();
      i1 += 1;
    }
    i3 = i2 + 1;
    this.o = new ETTextLine[i3];
    paramInt = 0;
    while (paramInt < i3)
    {
      this.o[paramInt] = new ETTextLine();
      paramInt += 1;
    }
    paramInt = 0;
    Object localObject2;
    while (paramInt < i4)
    {
      localObject1 = ((ETParagraph)this.n.get(paramInt)).a();
      i1 = 0;
      while (i1 < ((ArrayList)localObject1).size())
      {
        localObject2 = (ETFragment)((ArrayList)localObject1).get(i1);
        i2 = ((ETFragment)localObject2).g();
        if ((i2 >= 0) && (i2 < i3)) {
          this.o[i2].a((ETFragment)localObject2);
        }
        i1 += 1;
      }
      paramInt += 1;
    }
    paramInt = 0;
    i1 = 0;
    while (paramInt < i3)
    {
      localObject1 = this.o[paramInt];
      ((ETTextLine)localObject1).a(paramETEngine, 0, i1, this.a);
      localObject2 = ((ETTextLine)localObject1).f().iterator();
      i2 = 0;
      while (((Iterator)localObject2).hasNext())
      {
        ETFragment localETFragment = (ETFragment)((Iterator)localObject2).next();
        ETTextRange[] arrayOfETTextRange = localETFragment.a(paramETEngine, i2, i1, ((ETTextLine)localObject1).a(), paramInt);
        if ((arrayOfETTextRange != null) && (arrayOfETTextRange.length > 0)) {
          Collections.addAll(this.t, arrayOfETTextRange);
        }
        i2 += localETFragment.e();
      }
      i1 += ((ETTextLine)localObject1).a();
      paramInt += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean)
  {
    if (this.n == null) {
      return;
    }
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean);
    paramString.a(this.s);
    this.n.add(paramString);
    this.g = false;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ETFont paramETFont, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.n == null) {
      return;
    }
    paramString = new ETParagraph(paramString, paramInt1, paramInt2, paramETFont, paramBoolean1);
    paramString.a(this.s);
    paramString.a = paramBoolean2;
    this.n.add(paramString);
    this.g = false;
  }
  
  private void b()
  {
    Object localObject = this.n;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.l;
    if ((localObject != null) && (this.c != null))
    {
      if ((localObject instanceof Spanned))
      {
        c();
        return;
      }
      a(((CharSequence)localObject).toString(), 0, this.l.length(), this.c, false);
    }
  }
  
  private void c()
  {
    this.p.clear();
    Object localObject = (Spanned)this.l;
    CharacterStyle[] arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
    ETLayout.ETRange[] arrayOfETRange = new ETLayout.ETRange[arrayOfCharacterStyle.length];
    if (arrayOfETRange.length == 0)
    {
      a(this.l.toString(), 0, this.l.length(), this.c, false);
      return;
    }
    int i1 = 0;
    while (i1 < arrayOfCharacterStyle.length)
    {
      arrayOfETRange[i1] = new ETLayout.ETRange();
      arrayOfETRange[i1].a = ((Spanned)localObject).getSpanStart(arrayOfCharacterStyle[i1]);
      arrayOfETRange[i1].b = ((Spanned)localObject).getSpanEnd(arrayOfCharacterStyle[i1]);
      arrayOfETRange[i1].c = arrayOfCharacterStyle[i1];
      i1 += 1;
    }
    Arrays.sort(arrayOfETRange, new ETLayout.ETComparator());
    int i2 = 0;
    i1 = 0;
    while (i1 < arrayOfCharacterStyle.length)
    {
      int i4 = arrayOfETRange[i1].a;
      int i3 = arrayOfETRange[i1].b;
      if (i4 - i2 > 0) {
        a(a(this.l, i2, i4).toString(), i2, i4, this.c, false);
      }
      if (i3 - i4 > 0) {
        if ((arrayOfETRange[i1].c instanceof ClickableSpan))
        {
          i2 = i4;
          if (i4 > 0)
          {
            i2 = i4;
            if (this.l.charAt(i4 - 1) == ((IETFontAdapter)QRoute.api(IETFontAdapter.class)).getSysEmotcationHead()) {
              i2 = i4 + 1;
            }
          }
          a(a(this.l, i2, i3).toString(), i2, i3, this.d, true);
        }
        else if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfEmoticonSpan(arrayOfETRange[i1].c))
        {
          localObject = arrayOfETRange[i1].c;
          this.p.add(localObject);
          a((CharacterStyle)localObject, this.p.indexOf(localObject), i4, i3, false);
        }
        else if ((arrayOfETRange[i1].c instanceof RelativeSizeSpan))
        {
          localObject = a(this.l, i4, i3);
          RelativeSizeSpan localRelativeSizeSpan = (RelativeSizeSpan)arrayOfETRange[i1].c;
          ETFont localETFont = new ETFont(this.c.mFontId, this.c.mFontPath, this.c.getSize());
          localETFont.copy(this.c);
          localETFont.setSize(localRelativeSizeSpan.getSizeChange() * this.c.getSize());
          a(((CharSequence)localObject).toString(), i4, i3, localETFont, false, true);
        }
        else if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfSignatureActionSpan(arrayOfETRange[i1].c))
        {
          localObject = arrayOfETRange[i1].c;
          this.p.add(localObject);
          a((CharacterStyle)localObject, this.p.indexOf(localObject), i4, i3, false);
        }
      }
      if ((i1 == arrayOfCharacterStyle.length - 1) && (i3 < this.l.length()))
      {
        localObject = this.l;
        a(a((CharSequence)localObject, i3, ((CharSequence)localObject).length()).toString(), i3, this.l.length(), this.c, false);
      }
      i1 += 1;
      i2 = i3;
    }
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = this.o;
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return null;
      }
      localObject1 = this.n;
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return null;
        }
        localObject1 = this.n.iterator();
        int i1 = 0;
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((ETParagraph)((Iterator)localObject1).next()).a();
          if (localObject2 == null) {
            return null;
          }
          localObject2 = ((ArrayList)localObject2).iterator();
          int i2 = i1;
          for (;;)
          {
            i1 = i2;
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
              localETFragment.a(i2);
              i2 += str.length();
              localStringBuilder.append(str);
            }
          }
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  private int e()
  {
    ETTextLine[] arrayOfETTextLine = this.o;
    if ((arrayOfETTextLine != null) && (arrayOfETTextLine.length != 0)) {
      return arrayOfETTextLine[(arrayOfETTextLine.length - 1)].b();
    }
    return 0;
  }
  
  private Object[] f()
  {
    ArrayList localArrayList = this.p;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return this.p.toArray();
    }
    return null;
  }
  
  public int a()
  {
    ETTextLine[] arrayOfETTextLine = this.o;
    if (arrayOfETTextLine != null) {
      return arrayOfETTextLine.length;
    }
    return 0;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i3 = e(paramInt2);
    int i4 = this.t.size();
    int i1 = i4 - 1;
    paramInt2 = 0;
    while (paramInt2 < i4)
    {
      ETTextRange localETTextRange = (ETTextRange)this.t.get(paramInt2);
      int i2;
      if (localETTextRange.b == i3)
      {
        if (paramInt1 <= localETTextRange.c.right) {
          return paramInt2;
        }
        i2 = paramInt2;
      }
      else
      {
        i2 = i1;
        if (localETTextRange.b > i3) {
          break;
        }
      }
      paramInt2 += 1;
      i1 = i2;
    }
    return i1 + 1;
  }
  
  public ETDecoration a(ETEngine paramETEngine, boolean paramBoolean)
  {
    if (paramETEngine == null) {
      return null;
    }
    String str = d();
    int i2 = e();
    int i3 = a();
    ETSegment[] arrayOfETSegment = a(paramETEngine);
    Object[] arrayOfObject = f();
    if (!paramBoolean)
    {
      this.i = -1;
      if (this.p != null)
      {
        int i1 = 0;
        while (i1 < this.p.size())
        {
          CharacterStyle localCharacterStyle = (CharacterStyle)this.p.get(i1);
          if (((IETFontAdapter)QRoute.api(IETFontAdapter.class)).isInstanceOfSignatureActionSpan(localCharacterStyle))
          {
            this.i = i1;
            break;
          }
          i1 += 1;
        }
      }
    }
    return (ETDecoration)ETDecoration.createDecoration(paramETEngine, str, this.e, this.f, i2, i3, arrayOfETSegment, arrayOfObject, this.q, this.r, this.c, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
  }
  
  public final void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    ETTextLine[] arrayOfETTextLine = this.o;
    if (arrayOfETTextLine == null) {
      return;
    }
    int i3 = arrayOfETTextLine.length;
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < i3)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[paramInt2];
      localETTextLine.a(paramCanvas, paramInt1, i1);
      i1 += localETTextLine.a();
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
      int i4 = paramBitmap.getWidth();
      int i1 = paramBitmap.getHeight();
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
      if ((i4 <= paramInt1) && (i1 <= paramInt2))
      {
        paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      }
      else
      {
        Rect localRect = new Rect(0, 0, 0, 0);
        while (i1 > 0)
        {
          int i2;
          if (i1 >= paramInt2) {
            i2 = paramInt2;
          } else {
            i2 = i1;
          }
          int i5 = i1 - i2;
          localRect.left = 0;
          localRect.bottom += i2;
          i1 = i4;
          while (i1 > 0)
          {
            int i3;
            if (i1 >= paramInt1) {
              i3 = paramInt1;
            } else {
              i3 = i1;
            }
            i1 -= i3;
            localRect.right += i3;
            paramCanvas.drawBitmap(paramBitmap, localRect, localRect, null);
            localRect.left += i3;
          }
          localRect.top += i2;
          i1 = i5;
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
      if ((this.e > 0) && (this.f > 0))
      {
        int i5 = paramBitmap.getHeight();
        int i2;
        int i1;
        int i6;
        int i3;
        if ((localETDecoration != null) && (2 == paramETDecoration.getDecorationType()))
        {
          if (paramBoolean)
          {
            localETDecoration.drawScene(paramBitmap, 0, 0, this.c);
            return;
          }
          paramETDecoration = localETDecoration.mMargins;
          if (paramETDecoration != null)
          {
            i2 = paramETDecoration.left;
            i1 = paramETDecoration.top;
          }
          else
          {
            i1 = 0;
            i2 = 0;
          }
          localETDecoration.drawBackground(paramBitmap, this.c);
          paramETDecoration = this.o;
          if (paramETDecoration != null)
          {
            i6 = paramETDecoration.length;
            int i4 = 0;
            i3 = i1;
            i1 = i4;
          }
        }
        else
        {
          while (i1 < i6)
          {
            localETDecoration = paramETDecoration[i1];
            localETDecoration.a(paramETEngine, paramBitmap, null, i2, i3);
            i3 += localETDecoration.a();
            if (i3 >= i5) {
              return;
            }
            i1 += 1;
            continue;
            if (!paramBoolean) {
              localETDecoration = null;
            }
            if ((localETDecoration != null) && (1 == localETDecoration.getDecorationType())) {
              localETDecoration.drawBackground(paramBitmap, this.c);
            }
            paramETDecoration = this.o;
            if (paramETDecoration != null)
            {
              i3 = paramETDecoration.length;
              i1 = 0;
              i2 = 0;
              while (i1 < i3)
              {
                Object localObject = paramETDecoration[i1];
                localObject.a(paramETEngine, paramBitmap, localETDecoration, 0, i2);
                i2 += localObject.a();
                if (i2 >= i5) {
                  break;
                }
                i1 += 1;
              }
            }
            if ((localETDecoration != null) && (1 == localETDecoration.getDecorationType())) {
              localETDecoration.drawForeground(paramBitmap, this.c);
            }
          }
        }
      }
    }
  }
  
  public boolean a(ETEngine paramETEngine, int paramInt1, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.m = paramInt1;
    this.q = paramBoolean;
    this.r = paramInt3;
    this.l = paramCharSequence;
    this.c = paramETFont;
    this.g = true;
    paramCharSequence = this.d;
    if (paramCharSequence != null)
    {
      paramETFont = this.c;
      if (paramETFont != null)
      {
        paramCharSequence.copy(paramETFont);
        this.d.setColor(paramInt2);
      }
    }
    b();
    paramBoolean = this.g;
    paramInt2 = 0;
    if (paramBoolean) {
      return false;
    }
    a(paramETEngine, paramInt1);
    paramETEngine = this.o;
    if (paramETEngine != null)
    {
      int i3 = paramETEngine.length;
      paramInt3 = 0;
      int i1 = 0;
      paramInt1 = paramInt2;
      paramInt2 = i1;
      while (paramInt1 < i3)
      {
        int i2 = this.o[paramInt1].b();
        int i4 = this.o[paramInt1].a();
        i1 = paramInt3;
        if (i2 > paramInt3) {
          i1 = i2;
        }
        paramInt2 += i4;
        paramInt1 += 1;
        paramInt3 = i1;
      }
      this.e = paramInt3;
      this.f = paramInt2;
      if ((this.e > 0) && (this.f > 0))
      {
        this.k.set(true);
        return true;
      }
      paramETEngine = new StringBuilder();
      paramETEngine.append("mesure fail mWidth=");
      paramETEngine.append(this.e);
      paramETEngine.append(",mHeight");
      paramETEngine.append(this.f);
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
    ETTextLine[] arrayOfETTextLine = this.o;
    if (arrayOfETTextLine == null) {
      return null;
    }
    int i5 = arrayOfETTextLine.length;
    int i2 = 0;
    int i4 = 0;
    int i1 = 0;
    while (i2 < i5)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[i2];
      Object localObject1 = localETTextLine.f();
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      int i3 = 0;
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
        int i7;
        if (localObject2 != null)
        {
          localETSegment.textLength = ((String)localObject2).length();
          localETSegment.textOffset = i4;
          localETSegment.type = 0;
          i4 += ((String)localObject2).length();
          i6 = localETTextLine.a();
          i7 = localETFragment.f();
          int i8 = localETTextLine.e();
          int i9 = localETFragment.a(paramETEngine);
          localETSegment.x = i3;
          localETSegment.y = (i6 - i7 + i1 - (i8 - i9));
        }
        localObject2 = localETFragment.b();
        if (localObject2 != null)
        {
          localETSegment.textLength = 1;
          localETSegment.type = 1;
          localETSegment.codePoint = a(((String)localObject2).charAt(0), ((String)localObject2).charAt(1));
          i6 = localETTextLine.a();
          i7 = localETFragment.f();
          localETSegment.x = i3;
          localETSegment.y = (i6 - i7 + i1);
        }
        int i6 = localETFragment.d();
        if (i6 > -1)
        {
          localETSegment.type = 2;
          localETSegment.codePoint = i6;
          i6 = localETTextLine.a();
          i7 = localETFragment.f();
          localETSegment.x = i3;
          localETSegment.y = (i6 - i7 + i1);
          localObject2 = localETFragment.j();
          a(i3, localETSegment.y, (CharacterStyle)localObject2);
        }
        localETSegment.textSize = localETFragment.c();
        localETSegment.lineNum = localETFragment.g();
        localArrayList.add(localETSegment);
        i3 += localETFragment.e();
      }
      i1 += localETTextLine.a();
      i2 += 1;
    }
    return (ETSegment[])localArrayList.toArray(new ETSegment[localArrayList.size()]);
  }
  
  public int b(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    ETTextLine[] arrayOfETTextLine = this.o;
    int i2 = arrayOfETTextLine.length;
    while (i1 < i2)
    {
      Object localObject = arrayOfETTextLine[i1];
      localRect.left = ((ETTextLine)localObject).c();
      localRect.top = ((ETTextLine)localObject).d();
      localRect.right = (localRect.left + ((ETTextLine)localObject).b());
      localRect.bottom = (localRect.top + ((ETTextLine)localObject).a());
      if (localRect.contains(paramInt1, paramInt2))
      {
        localObject = ((ETTextLine)localObject).a(paramInt1);
        if (localObject != null) {
          return ((ETFragment)localObject).h().c();
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  ETTextRange b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.t.size())) {
      return (ETTextRange)this.t.get(paramInt);
    }
    return null;
  }
  
  public void b(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i1 = this.i;
    if ((i1 > -1) && (i1 < this.p.size())) {
      a(paramCanvas);
    }
    ETTextLine[] arrayOfETTextLine = this.o;
    if (arrayOfETTextLine == null) {
      return;
    }
    int i3 = arrayOfETTextLine.length;
    int i2 = 0;
    i1 = paramInt2;
    paramInt2 = i2;
    while (paramInt2 < i3)
    {
      ETTextLine localETTextLine = arrayOfETTextLine[paramInt2];
      localETTextLine.b(paramCanvas, paramInt1, i1);
      i1 += localETTextLine.a();
      paramInt2 += 1;
    }
  }
  
  Rect c(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.o;
      if (paramInt < localObject.length)
      {
        localObject = localObject[paramInt];
        paramInt = ((ETTextLine)localObject).c();
        int i1 = ((ETTextLine)localObject).d();
        return new Rect(paramInt, i1, this.e + paramInt, ((ETTextLine)localObject).a() + i1);
      }
    }
    return null;
  }
  
  public CharacterStyle c(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    Rect localRect = new Rect(0, 0, 0, 0);
    ETTextLine[] arrayOfETTextLine = this.o;
    int i2 = arrayOfETTextLine.length;
    while (i1 < i2)
    {
      Object localObject = arrayOfETTextLine[i1];
      localRect.left = ((ETTextLine)localObject).c();
      localRect.top = ((ETTextLine)localObject).d();
      localRect.right = (localRect.left + ((ETTextLine)localObject).b());
      localRect.bottom = (localRect.top + ((ETTextLine)localObject).a());
      if (localRect.contains(paramInt1, paramInt2))
      {
        localObject = ((ETTextLine)localObject).a(paramInt1);
        if (localObject != null) {
          return ((ETFragment)localObject).i();
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public ETTextRange[] d(int paramInt)
  {
    Object localObject = this.o;
    if ((localObject != null) && (paramInt < localObject.length))
    {
      localObject = new ArrayList();
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        ETTextRange localETTextRange = (ETTextRange)localIterator.next();
        if (localETTextRange.b == paramInt) {
          ((ArrayList)localObject).add(localETTextRange);
        }
      }
      return (ETTextRange[])((ArrayList)localObject).toArray(new ETTextRange[0]);
    }
    return null;
  }
  
  int e(int paramInt)
  {
    int i2 = this.o.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ETTextLine localETTextLine = this.o[i1];
      if (paramInt < localETTextLine.d() + localETTextLine.a()) {
        return i1;
      }
      i1 += 1;
    }
    return i2 - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayout
 * JD-Core Version:    0.7.0.1
 */