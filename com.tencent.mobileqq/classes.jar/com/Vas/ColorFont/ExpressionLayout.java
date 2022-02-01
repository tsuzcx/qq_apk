package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.TextGraphMap;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExpressionLayout
  extends FounderBaseLayout
  implements FounderBaseLayout.FounderHighlightInterface
{
  private boolean A;
  private int[] B;
  private int C;
  private int D;
  private List<List<ModelFastColorFont>> E;
  private List<ModelFastColorFont> F;
  private List<ModelFastColorFont> G;
  private List<ModelFastColorFont> H;
  private int I;
  private int J;
  private int K;
  private int L;
  private ExpressionLayout.SpanComparator M;
  private int[] N;
  private int[] O;
  private int P;
  private long Q;
  private boolean R;
  protected int a;
  protected int b;
  protected int c;
  protected int d;
  protected int[] e;
  protected int[] f;
  protected int[] g;
  protected int[] h;
  protected int[] i;
  protected int[] j;
  protected int[] k;
  protected int[] l = new int[2];
  protected Paint m;
  protected Path n;
  private final IETextView u;
  private int[] v = new int[2];
  private Canvas w;
  private Canvas x;
  private Paint y;
  private ArrayList<Integer> z;
  
  public ExpressionLayout(View paramView, ETFont paramETFont)
  {
    this.q = paramETFont;
    this.u = ((IETextView)paramView);
    this.M = new ExpressionLayout.SpanComparator();
    this.t = new Canvas();
  }
  
  private float a(CharSequence paramCharSequence, int paramInt)
  {
    this.B = new int[paramInt];
    int[] arrayOfInt = new int[paramInt];
    int i2 = 0;
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfInt[i1] = paramCharSequence.charAt(i1);
      i1 += 1;
    }
    float f2 = this.u.getTextSize();
    int i4 = (int)f2;
    FastColorFontHelper.a().a(this.q.mFontId, arrayOfInt, i4, this.B);
    i1 = i2;
    while (i1 < paramInt)
    {
      int i3 = this.B[i1];
      i2 = i3;
      if (i3 <= 0)
      {
        float f1 = this.u.getPaint().measureText(String.valueOf((char)arrayOfInt[i1]));
        if (f1 <= 0.0F) {
          f1 = i4;
        }
        i2 = (int)(f1 * FastColorFontCache.d(this.q.mFontId) / FastColorFontCache.e(this.q.mFontId));
        this.z.add(Integer.valueOf(i1));
      }
      this.B[i1] = i2;
      i1 += 1;
    }
    return f2;
  }
  
  private int a(CharSequence paramCharSequence, int paramInt1, CharacterStyle[] paramArrayOfCharacterStyle, Spanned paramSpanned, int paramInt2, int paramInt3)
  {
    Object localObject = paramArrayOfCharacterStyle[paramInt3];
    int i2 = paramSpanned.getSpanStart(localObject);
    int i3 = paramSpanned.getSpanEnd(localObject);
    int i1;
    if (i3 == paramSpanned.length()) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i2 > paramInt2) && (i3 > i2)) {
      a(null, ETLayout.a(paramCharSequence, paramInt2, i2), paramInt2, paramInt1, 0, this.P);
    }
    if ((localObject instanceof ClickableSpan)) {
      a(null, ETLayout.a(paramCharSequence, i2, i3), i2, paramInt1, 1, this.P);
    } else if ((!(localObject instanceof EmoticonSpan)) && (!(localObject instanceof SignatureActionSpan)))
    {
      if ((localObject instanceof RelativeSizeSpan))
      {
        a((RelativeSizeSpan)localObject, ETLayout.a(paramCharSequence, i2, i3), i2, paramInt1, 3, this.P);
      }
      else
      {
        localObject = f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Un Know CharacterStyle   start:");
        localStringBuilder.append(i2);
        localStringBuilder.append("  end:");
        localStringBuilder.append(i3);
        FastColorFontLog.b((String)localObject, localStringBuilder.toString());
      }
    }
    else {
      a((CharacterStyle)localObject);
    }
    if ((paramInt3 == paramArrayOfCharacterStyle.length - 1) && (i1 == 0)) {
      a(null, ETLayout.a(paramCharSequence, i3, paramSpanned.length()), i3, paramInt1, 0, this.P);
    }
    return i3;
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    l();
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if ((i2 != -2147483648) && (i2 != 1073741824)) {
      this.K = this.u.getETMaxWidth();
    } else {
      this.K = Math.min(this.u.getETMaxWidth(), i1);
    }
    this.D = (this.K - this.a - this.b);
    this.L = 0;
    i2 = paramCharSequence.length();
    paramInt1 = this.H.size();
    if ((paramInt1 < i2) && (!this.G.isEmpty())) {
      while (paramInt1 < i2)
      {
        if (!this.G.isEmpty()) {
          this.H.add(this.G.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.G.clear();
    this.E.clear();
    this.F.clear();
    float f1 = a(paramCharSequence, i2);
    boolean bool = paramCharSequence instanceof Spanned;
    Spanned localSpanned = null;
    CharacterStyle[] arrayOfCharacterStyle;
    if (bool)
    {
      localSpanned = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])localSpanned.getSpans(0, localSpanned.length(), CharacterStyle.class);
      this.M.a(localSpanned);
      Arrays.sort(arrayOfCharacterStyle, this.M);
    }
    else
    {
      arrayOfCharacterStyle = null;
    }
    this.C = ((int)(FastColorFontCache.a(this.q.mFontId) * f1 / FastColorFontCache.e(this.q.mFontId)));
    this.P = ((int)(FastColorFontCache.d(this.q.mFontId) * f1 / FastColorFontCache.e(this.q.mFontId)));
    a(paramCharSequence, (int)f1, arrayOfCharacterStyle, localSpanned);
    m();
    this.O = FastColorFontHelper.a().a(this.q.mFontId, this.e, this.f, this.g, this.h, this.i, this.N, this.j, this.k, this.C, this.P, this.D, this.q.mAnimationId);
    paramCharSequence = this.O;
    if ((paramCharSequence != null) && (paramCharSequence.length >= 2))
    {
      this.K = (paramCharSequence[0] + this.a + this.b);
      this.L = (paramCharSequence[1] + this.c + this.d);
      n();
      return;
    }
    this.K = i1;
    this.L = View.MeasureSpec.getSize(paramInt2);
  }
  
  private void a(CharSequence paramCharSequence, int paramInt, CharacterStyle[] paramArrayOfCharacterStyle, Spanned paramSpanned)
  {
    if ((paramSpanned != null) && (paramArrayOfCharacterStyle.length > 0))
    {
      int i2 = 0;
      int i1 = 0;
      while (i1 < paramArrayOfCharacterStyle.length)
      {
        i2 = a(paramCharSequence, paramInt, paramArrayOfCharacterStyle, paramSpanned, i2, i1);
        i1 += 1;
      }
      return;
    }
    a(null, paramCharSequence, 0, paramInt, 0, this.P);
  }
  
  private boolean a(CharacterStyle paramCharacterStyle)
  {
    int i2;
    int i1;
    if ((paramCharacterStyle instanceof EmoticonSpan))
    {
      localObject = ((EmoticonSpan)paramCharacterStyle).getDrawable().getBounds();
      i2 = ((Rect)localObject).width();
      i1 = ((Rect)localObject).height();
    }
    else if ((paramCharacterStyle instanceof SignatureActionSpan))
    {
      localObject = (SignatureActionSpan)paramCharacterStyle;
      i2 = ((SignatureActionSpan)localObject).a();
      i1 = ((SignatureActionSpan)localObject).b();
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    Object localObject = o();
    ((ModelFastColorFont)localObject).b = 65535;
    ((ModelFastColorFont)localObject).h = false;
    ((ModelFastColorFont)localObject).c = i2;
    ((ModelFastColorFont)localObject).d = i1;
    ((ModelFastColorFont)localObject).i = paramCharacterStyle;
    ((ModelFastColorFont)localObject).a = 2;
    this.G.add(localObject);
    return true;
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2;
    if (paramRelativeSizeSpan != null) {
      f2 = paramRelativeSizeSpan.getSizeChange();
    } else {
      f2 = 1.0F;
    }
    int i2 = paramCharSequence.length();
    int i1 = 0;
    while (i1 < i2)
    {
      char c1 = paramCharSequence.charAt(i1);
      int i3 = paramInt1 + i1;
      paramRelativeSizeSpan = this.B;
      float f1;
      if (i3 < paramRelativeSizeSpan.length) {
        f1 = paramRelativeSizeSpan[i3];
      } else {
        f1 = paramInt2;
      }
      if (f1 <= 0.0F) {
        f1 = paramInt2;
      }
      i3 = (int)(f1 * FastColorFontCache.d(this.q.mFontId) / FastColorFontCache.e(this.q.mFontId));
      paramRelativeSizeSpan = o();
      paramRelativeSizeSpan.h = false;
      paramRelativeSizeSpan.a = paramInt3;
      paramRelativeSizeSpan.b = c1;
      if (c1 == '\n')
      {
        paramRelativeSizeSpan.c = i3;
        paramRelativeSizeSpan.d = paramInt4;
      }
      else
      {
        paramRelativeSizeSpan.c = ((int)(i3 * f2));
        paramRelativeSizeSpan.d = ((int)(paramInt4 * f2));
      }
      this.G.add(paramRelativeSizeSpan);
      i1 += 1;
    }
    return true;
  }
  
  private boolean k()
  {
    int i1 = this.K;
    int i2 = this.a;
    int i3 = this.b;
    int i4 = 1;
    if (i1 - i2 - i3 <= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.L - this.c - this.d <= 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.K - this.a - this.b > this.I) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (this.L - this.c - this.d <= this.J) {
      i4 = 0;
    }
    return i1 | 0x0 | i2 | i3 | i4;
  }
  
  private void l()
  {
    if (this.A) {
      return;
    }
    this.A = true;
    if (this.E == null) {
      this.E = new ArrayList();
    }
    if (this.G == null) {
      this.G = new ArrayList();
    }
    if (this.F == null) {
      this.F = new ArrayList();
    }
    if (this.H == null) {
      this.H = new ArrayList();
    }
    if ((this.I <= 0) || (this.J <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.u.getResources().getDisplayMetrics();
      this.I = localDisplayMetrics.widthPixels;
      this.J = localDisplayMetrics.heightPixels;
    }
    if (this.z == null) {
      this.z = new ArrayList();
    }
    this.a = this.u.getPaddingLeft();
    this.b = this.u.getPaddingRight();
    this.c = this.u.getPaddingTop();
    this.d = this.u.getPaddingBottom();
    if (this.m == null)
    {
      this.m = new Paint(1);
      this.m.setDither(true);
      this.m.setFilterBitmap(true);
      this.m.setStyle(Paint.Style.FILL);
    }
    this.n = new Path();
  }
  
  private void m()
  {
    int i2 = this.G.size();
    this.e = new int[i2];
    this.f = new int[i2];
    this.g = new int[i2];
    this.h = new int[i2];
    this.i = new int[i2];
    this.N = new int[i2];
    this.j = new int[i2];
    this.k = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.G.get(i1);
      this.e[i1] = localModelFastColorFont.b;
      this.f[i1] = localModelFastColorFont.e;
      this.g[i1] = localModelFastColorFont.f;
      this.h[i1] = localModelFastColorFont.c;
      this.i[i1] = localModelFastColorFont.d;
      this.N[i1] = 0;
      if (localModelFastColorFont.b == 65535) {
        this.N[i1] = 2;
      }
      if (localModelFastColorFont.b == '\n') {
        this.N[i1] = 3;
      }
      i1 += 1;
    }
  }
  
  private void n()
  {
    int i1 = 0;
    while (i1 < this.e.length)
    {
      ModelFastColorFont localModelFastColorFont1 = (ModelFastColorFont)this.G.get(i1);
      if (this.N[i1] == 1)
      {
        this.z.add(Integer.valueOf(i1));
        localModelFastColorFont1.h = true;
      }
      if (this.j[i1] >= this.E.size())
      {
        i2 = this.E.size();
        while (i2 <= this.j[i1])
        {
          this.E.add(i2, new ArrayList());
          i2 += 1;
        }
      }
      List localList = (List)this.E.get(this.j[i1]);
      ModelFastColorFont localModelFastColorFont2 = o();
      int i2 = this.f[i1];
      int[] arrayOfInt1 = this.h;
      localModelFastColorFont2.e = (i2 - arrayOfInt1[i1] / 2);
      i2 = this.g[i1];
      int[] arrayOfInt2 = this.i;
      localModelFastColorFont2.f = (i2 - arrayOfInt2[i1] / 2);
      localModelFastColorFont2.c = arrayOfInt1[i1];
      localModelFastColorFont2.d = arrayOfInt2[i1];
      localModelFastColorFont2.b = localModelFastColorFont1.b;
      localModelFastColorFont2.h = localModelFastColorFont1.h;
      localModelFastColorFont2.i = localModelFastColorFont1.i;
      localModelFastColorFont2.a = localModelFastColorFont1.a;
      this.F.add(localModelFastColorFont2);
      localList.add(this.k[i1], localModelFastColorFont2);
      i1 += 1;
    }
  }
  
  private ModelFastColorFont o()
  {
    if (this.H.isEmpty()) {
      return new ModelFastColorFont();
    }
    return (ModelFastColorFont)this.H.remove(0);
  }
  
  private boolean p()
  {
    this.z.clear();
    if (!d(this.K - this.a - this.b, this.L - this.c - this.d)) {
      return false;
    }
    if (this.G.size() <= 0) {
      return false;
    }
    int i3 = this.G.size();
    int i1 = 0;
    int i2 = 1;
    while (i1 < i3)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.G.get(i1);
      this.e[i1] = localModelFastColorFont.b;
      this.f[i1] = localModelFastColorFont.e;
      this.g[i1] = localModelFastColorFont.f;
      this.h[i1] = localModelFastColorFont.c;
      this.i[i1] = localModelFastColorFont.d;
      if (localModelFastColorFont.a != 2) {
        i2 = 0;
      }
      i1 += 1;
    }
    return i2 == 0;
  }
  
  private void q()
  {
    Object localObject = this.x;
    if (localObject == null) {
      this.x = new Canvas(this.o);
    } else {
      ((Canvas)localObject).setBitmap(this.o);
    }
    if (this.y == null)
    {
      this.y = new Paint();
      this.y.setColor(-16777216);
    }
    int i1 = 2;
    for (;;)
    {
      localObject = this.O;
      if (i1 >= localObject.length) {
        break;
      }
      int i2 = localObject[i1];
      int i3 = localObject[(i1 + 1)];
      int i4 = localObject[(i1 + 2)];
      int i5 = localObject[(i1 + 3)];
      i5 = localObject[(i1 + 4)];
      localObject = (ModelFastColorFont)this.G.get(i2);
      Paint localPaint = this.y;
      float f1 = i5;
      localPaint.setTextSize(f1);
      f1 /= 2.0F;
      float f2 = (this.y.descent() + this.y.ascent()) / 2.0F;
      this.x.drawText(String.valueOf(((ModelFastColorFont)localObject).b), i3, i4 + (f1 - f2), this.y);
      i1 += 5;
    }
  }
  
  private void r()
  {
    int i2 = (int)(this.u.getTextSize() / 15.0F);
    Object localObject = this.w;
    if (localObject == null) {
      this.w = new Canvas(this.o);
    } else {
      ((Canvas)localObject).setBitmap(this.o);
    }
    int i3 = this.G.size();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject = (ModelFastColorFont)this.G.get(i1);
      int i5 = this.h[i1];
      int i6 = this.i[i1];
      int i7 = this.f[i1] - i5 / 2;
      int i4 = this.g[i1] - i6 / 2;
      int i8 = ((ModelFastColorFont)localObject).a;
      if (i8 != 1)
      {
        if (i8 == 2) {
          if ((((ModelFastColorFont)localObject).i instanceof EmoticonSpan))
          {
            localObject = (EmoticonSpan)((ModelFastColorFont)localObject).i;
            Canvas localCanvas = this.w;
            float f1 = i7;
            i5 = i4 + i6;
            ((EmoticonSpan)localObject).draw(localCanvas, null, 0, 0, f1, i4, i5, i5, this.u.getPaint());
          }
          else if ((((ModelFastColorFont)localObject).i instanceof SignatureActionSpan))
          {
            localObject = (SignatureActionSpan)((ModelFastColorFont)localObject).i;
            ((SignatureActionSpan)localObject).c = false;
            ((SignatureActionSpan)localObject).draw(this.w, null, 0, 0, i7, i4, i4, i4 + i6, this.u.getPaint());
          }
        }
      }
      else
      {
        localObject = a(i5, i2);
        this.w.drawBitmap((Bitmap)localObject, i7, i4 + i6 - i2, this.u.getPaint());
      }
      i1 += 1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    int i1 = 0;
    while (i1 < this.F.size())
    {
      paramTextGraphMap = (ModelFastColorFont)this.F.get(i1);
      if ((paramInt1 >= paramTextGraphMap.e) && (paramInt1 <= paramTextGraphMap.e + paramTextGraphMap.c) && (paramInt2 >= paramTextGraphMap.f) && (paramInt2 <= paramTextGraphMap.f + paramTextGraphMap.d)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = FastColorFontCache.c(this.q.mFontId, this.q.mComboIndex, paramInt1, paramInt2);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      FastColorFontHelper.a().a(this.q.mFontId, localBitmap, null, this.q.mComboIndex);
      FastColorFontCache.b(this.q.mFontId, this.q.mComboIndex, paramInt1, paramInt2, localBitmap);
      localObject = localBitmap;
      if (FastColorFontHelper.a)
      {
        localObject = f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create new under line bitmap.... width:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("  height:");
        localStringBuilder.append(paramInt2);
        FastColorFontLog.a((String)localObject, localStringBuilder.toString());
        localObject = localBitmap;
      }
    }
    return localObject;
  }
  
  protected void a()
  {
    super.a();
    this.r.addUpdateListener(new ExpressionLayout.1(this));
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (!paramBoolean) {
      i1 = paramInt - 1;
    }
    paramInt = i1;
    if (i1 >= this.F.size()) {
      paramInt = this.F.size() - 1;
    }
    if (paramInt < 0) {
      return;
    }
    this.u.getLocationInWindow(paramArrayOfInt);
    ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.F.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.a + localModelFastColorFont.e;
      paramArrayOfInt[1] += this.c + localModelFastColorFont.f + localModelFastColorFont.d;
      return;
    }
    paramArrayOfInt[0] += this.a + localModelFastColorFont.e + localModelFastColorFont.c;
    paramArrayOfInt[1] += this.c + localModelFastColorFont.f + localModelFastColorFont.d;
  }
  
  void a(String paramString)
  {
    if (FastColorFontHelper.a)
    {
      String str = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  text:");
      paramString = this.q;
      Object localObject = null;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = this.q.mText;
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  fontId:");
      if (this.q == null) {
        paramString = null;
      } else {
        paramString = Integer.valueOf(this.q.mFontId);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  chars.length:");
      paramString = this.e;
      int i1;
      if (paramString == null) {
        i1 = 0;
      } else {
        i1 = paramString.length;
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("\n  bitmapWidth:");
      paramString = this.o;
      int i2 = -1;
      if (paramString == null) {
        i1 = -1;
      } else {
        i1 = this.o.getWidth();
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("\n  bitmapHeight:");
      if (this.o == null) {
        i1 = i2;
      } else {
        i1 = this.o.getHeight();
      }
      localStringBuilder.append(i1);
      localStringBuilder.append("\n  viewWidth:");
      localStringBuilder.append(this.K - this.a - this.b);
      localStringBuilder.append("\n  viewHeight:");
      localStringBuilder.append(this.L - this.c - this.d);
      localStringBuilder.append("\n  paddingLeft:");
      localStringBuilder.append(this.a);
      localStringBuilder.append("\n  paddingRight:");
      localStringBuilder.append(this.b);
      localStringBuilder.append("\n  paddingTop:");
      localStringBuilder.append(this.c);
      localStringBuilder.append("\n  paddingBottom:");
      localStringBuilder.append(this.d);
      localStringBuilder.append("\n  screenWidth:");
      localStringBuilder.append(this.I);
      localStringBuilder.append("\n  screenHeight:");
      localStringBuilder.append(this.J);
      localStringBuilder.append("\n  x[]:");
      localStringBuilder.append(Arrays.toString(this.f));
      localStringBuilder.append("\n  y[]:");
      localStringBuilder.append(Arrays.toString(this.g));
      localStringBuilder.append("\n  width[]:");
      localStringBuilder.append(Arrays.toString(this.h));
      localStringBuilder.append("\n  height[]:");
      localStringBuilder.append(Arrays.toString(this.i));
      localStringBuilder.append("\n  mAnimationId:");
      if (this.q == null) {
        paramString = null;
      } else {
        paramString = Long.valueOf(this.q.mAnimationId);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  shouldDisplayAnimation:");
      if (this.q == null) {
        paramString = localObject;
      } else {
        paramString = Boolean.valueOf(this.q.mShouldDisplayAnimation);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  frameIndex:");
      localStringBuilder.append(this.s);
      localStringBuilder.append("\n  animInfo:");
      localStringBuilder.append(Arrays.toString(this.p));
      localStringBuilder.append("\n");
      FastColorFontLog.a(str, localStringBuilder.toString());
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (k())
    {
      FastColorFontLog.a(f(), "ExpressionLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!p())
    {
      FastColorFontLog.a(f(), "ExpressionLayout::onDraw 创建bitmap失败！");
      return false;
    }
    c();
    long l1 = System.nanoTime();
    q();
    FastColorFontHelper.a().a(this.q.mFontId, this.e, this.f, this.g, this.h, this.i, this.N, this.C, this.P, this.D, this.q.mAnimationId, this.s, this.o, this.p, this.q.mComboIndex);
    b(paramCanvas);
    r();
    paramCanvas.drawBitmap(this.o, this.a, this.c, null);
    if ((this.q.mShouldDisplayAnimation) && (this.s == 0)) {
      b();
    }
    if (FastColorFontHelper.a)
    {
      paramCanvas = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("字数：");
      localStringBuilder.append(this.e.length);
      localStringBuilder.append("\n   字号：");
      localStringBuilder.append(this.u.getTextSize());
      localStringBuilder.append("px\n");
      FastColorFontLog.a(paramCanvas, l1, localStringBuilder.toString());
      a("ExpressionLayout::onDraw......");
    }
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.Q == paramLong) && (this.R == paramBoolean) && (this.q.equals(paramETFont)) && (this.u.isCacheMeasureResult())) {
      return this.v;
    }
    if (this.Q != paramLong)
    {
      if (this.q != null) {
        this.q.mShouldDisplayAnimation = false;
      }
      this.u.setIsFounderAnimating(false);
      if (this.r != null) {
        this.r.cancel();
      }
      this.s = 0;
    }
    this.Q = paramLong;
    this.R = paramBoolean;
    this.q = new ETFont(-1, null, 0.0F);
    this.q.copy(paramETFont);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    if ((this.q != null) && (!TextUtils.isEmpty(this.q.mFontPath)) && (this.u.getVisibility() != 8))
    {
      paramETFont = this.u.getText();
      if (TextUtils.isEmpty(paramETFont))
      {
        paramETFont = this.v;
        paramETFont[0] = i1;
        paramETFont[1] = i2;
        return paramETFont;
      }
      paramLong = System.nanoTime();
      a(paramInt1, paramInt2, paramETFont);
      long l1 = System.nanoTime();
      if (FastColorFontHelper.a)
      {
        String str = f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("字数：");
        localStringBuilder.append(paramETFont.length());
        localStringBuilder.append("   字号：");
        localStringBuilder.append(this.u.getTextSize());
        localStringBuilder.append("px   排版耗时：");
        localStringBuilder.append((float)(l1 - paramLong) / 1000000.0F);
        localStringBuilder.append("ms");
        FastColorFontLog.a(str, localStringBuilder.toString());
      }
      if (k())
      {
        paramETFont = this.v;
        paramETFont[0] = i1;
        paramETFont[1] = i2;
        return paramETFont;
      }
      paramETFont = this.v;
      paramETFont[0] = this.K;
      paramETFont[1] = this.L;
      return paramETFont;
    }
    paramETFont = this.v;
    paramETFont[0] = i1;
    paramETFont[1] = i2;
    return paramETFont;
  }
  
  public void b()
  {
    if (this.q != null)
    {
      if (k()) {
        return;
      }
      if ((this.r != null) && (this.r.isRunning())) {
        return;
      }
      if (FastColorFontHelper.a)
      {
        str = f();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......animInfo:");
        localStringBuilder.append(Arrays.toString(this.p));
        FastColorFontLog.a(str, localStringBuilder.toString());
      }
      this.s = 0;
      if ((this.p[0] > 0) && (this.p[1] > 0))
      {
        i();
        return;
      }
      FastColorFontHelper.a().a(this.q.mFontId, this.e, this.f, this.g, this.h, this.i, this.N, this.C, this.P, this.D, this.q.mAnimationId, this.s, this.o, this.p, this.q.mComboIndex);
      if ((this.p[0] > 0) && (this.p[1] > 0))
      {
        i();
        return;
      }
      String str = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
      localStringBuilder.append(Arrays.toString(this.p));
      FastColorFontLog.b(str, localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.n.reset();
    int i2 = this.F.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 >= paramInt1) && (i1 < paramInt2))
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.F.get(i1);
        this.n.addRect(this.a + localModelFastColorFont.e, this.c + localModelFastColorFont.f, this.a + localModelFastColorFont.e + localModelFastColorFont.c, this.c + localModelFastColorFont.f + localModelFastColorFont.d, Path.Direction.CW);
      }
      i1 += 1;
    }
    this.u.invalidate();
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (!this.u.hasSelected()) {
      return;
    }
    this.m.setColor(-256);
    paramCanvas.drawPath(this.n, this.m);
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    this.u.getLocationInWindow(this.l);
    Object localObject1 = this.l;
    int i3 = 0;
    int i4 = paramInt1 - localObject1[0];
    int i5 = paramInt2 - localObject1[1];
    paramInt2 = this.F.size();
    paramInt1 = 0;
    int i1;
    int i2;
    while (paramInt1 < paramInt2)
    {
      localObject1 = (ModelFastColorFont)this.F.get(paramInt1);
      i1 = this.a;
      i2 = ((ModelFastColorFont)localObject1).e;
      int i6 = this.c;
      int i7 = ((ModelFastColorFont)localObject1).f;
      int i8 = this.a;
      int i9 = ((ModelFastColorFont)localObject1).e;
      int i10 = ((ModelFastColorFont)localObject1).c;
      int i11 = this.c;
      int i12 = ((ModelFastColorFont)localObject1).f;
      int i13 = ((ModelFastColorFont)localObject1).d;
      if ((i4 >= i1 + i2) && (i4 <= i8 + i9 + i10) && (i5 >= i6 + i7) && (i5 <= i11 + i12 + i13)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt2 < this.E.size(); paramInt1 = i1)
    {
      localObject1 = (List)this.E.get(paramInt2);
      i1 = paramInt1;
      if (localObject1 != null) {
        if (((List)localObject1).size() <= 0)
        {
          i1 = paramInt1;
        }
        else
        {
          Object localObject2 = ((List)localObject1).iterator();
          i1 = 0;
          while (((Iterator)localObject2).hasNext())
          {
            ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)((Iterator)localObject2).next();
            i1 += this.c + localModelFastColorFont.f + localModelFastColorFont.d;
          }
          i2 = i3;
          if (i1 / ((List)localObject1).size() < i5) {
            if (paramInt2 == this.E.size() - 1)
            {
              i2 = i3;
            }
            else
            {
              i1 = paramInt1 + ((List)localObject1).size();
              break label422;
            }
          }
          while (i2 < ((List)localObject1).size())
          {
            localObject2 = (ModelFastColorFont)((List)localObject1).get(i2);
            if (i4 <= this.a + ((ModelFastColorFont)localObject2).e + ((ModelFastColorFont)localObject2).c) {
              return paramInt1 + i2;
            }
            i2 += 1;
          }
          return paramInt1 + ((List)localObject1).size();
        }
      }
      label422:
      paramInt2 += 1;
    }
    return -1;
  }
  
  protected void c()
  {
    if (this.t == null) {
      this.t = new Canvas();
    }
    this.t.setBitmap(this.o);
    this.t.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void d()
  {
    this.n.reset();
    this.u.invalidate();
  }
  
  public void e()
  {
    super.e();
    this.w = null;
    this.x = null;
    this.t = null;
    Object localObject = this.y;
    if (localObject != null)
    {
      ((Paint)localObject).reset();
      this.y = null;
    }
    localObject = this.m;
    if (localObject != null) {
      ((Paint)localObject).reset();
    }
    localObject = this.n;
    if (localObject != null) {
      ((Path)localObject).reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.ExpressionLayout
 * JD-Core Version:    0.7.0.1
 */