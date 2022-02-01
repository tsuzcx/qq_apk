package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.FontReportUtils;
import com.etrump.mixlayout.TextGraphMap;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FounderColorLayout
  extends FounderBaseLayout
  implements FounderBaseLayout.FounderHighlightInterface
{
  public static boolean a = false;
  protected int A;
  protected int[] B;
  protected int C;
  protected boolean D = false;
  protected Paint E = new Paint();
  protected int[] F = new int[2];
  protected Paint G;
  protected Path H;
  private long I;
  private int[] J = new int[2];
  private SparseIntArray K;
  private ArrayList<Integer> L;
  private int[] M;
  private boolean N;
  private int O;
  private Paint P;
  private Paint Q;
  private List<ModelFastColorFont> R;
  private List<ModelFastColorFont> S;
  private int T;
  private int U;
  private int V;
  private int W;
  private int X;
  private int Y;
  private int Z;
  private int aa;
  private int ab;
  private int ac;
  private int ad;
  private boolean ae;
  private FounderColorLayout.SpanComparator af;
  protected IETextView b;
  protected Canvas c;
  protected Canvas d;
  protected List<List<ModelFastColorFont>> e;
  protected List<ModelFastColorFont> f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int[] m;
  protected int[] n;
  protected int[] u;
  protected int[] v;
  protected int[] w;
  protected int x;
  protected int y;
  protected int z;
  
  public FounderColorLayout(IETextView paramIETextView, ETFont paramETFont)
  {
    this.b = paramIETextView;
    this.q = paramETFont;
    n();
    this.af = new FounderColorLayout.SpanComparator();
    this.E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    int i5 = this.e.size();
    int i2 = 0;
    while (i2 < i5)
    {
      if (i2 >= paramInt3) {
        return paramInt2;
      }
      List localList = (List)this.e.get(i2);
      if (a(localList))
      {
        paramInt2 += paramInt1;
        if (i2 == i5 - 1) {
          i1 = 0;
        }
      }
      for (int i1 = this.z;; i1 = this.z)
      {
        paramInt2 += i1;
        break label275;
        this.y = Math.max(this.y, localList.size());
        int i6 = localList.size();
        int i3 = 0;
        ModelFastColorFont localModelFastColorFont;
        for (i1 = 0; i3 < i6; i1 = i4)
        {
          localModelFastColorFont = (ModelFastColorFont)localList.get(i3);
          i4 = i1;
          if (localModelFastColorFont.d > i1) {
            i4 = localModelFastColorFont.d;
          }
          i3 += 1;
        }
        int i4 = localList.size();
        i3 = 0;
        while (i3 < i4)
        {
          localModelFastColorFont = (ModelFastColorFont)localList.get(i3);
          localModelFastColorFont.f = (i1 - localModelFastColorFont.d + paramInt2 - (int)((1.0F - localModelFastColorFont.d / i1) * paramFloat));
          i3 += 1;
        }
        paramInt2 += i1;
        if (i2 == i5 - 1) {
          break;
        }
      }
      label275:
      i2 += 1;
    }
    return paramInt2;
  }
  
  @TargetApi(16)
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    n();
    e(View.MeasureSpec.getMode(paramInt1), View.MeasureSpec.getSize(paramInt1));
    this.l = 0;
    this.O = 0;
    this.V = 0;
    this.W = 0;
    this.Y = 0;
    this.Z = 0;
    this.aa = 0;
    this.X = 1;
    this.ac = 0;
    this.g = this.b.getPaddingLeft();
    this.h = this.b.getPaddingRight();
    this.i = this.b.getPaddingTop();
    this.j = this.b.getPaddingBottom();
    this.ab = (this.k - this.g - this.h);
    if (Build.VERSION.SDK_INT >= 16) {
      this.Z = this.b.getMaxEms();
    }
    this.aa = this.ab;
    this.e.clear();
    this.R.clear();
    paramInt1 = this.S.size();
    paramInt2 = paramCharSequence.length();
    if ((paramInt1 < paramInt2) && (!this.f.isEmpty())) {
      while (paramInt1 < paramInt2)
      {
        if (!this.f.isEmpty()) {
          this.S.add(this.f.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.f.clear();
    this.K.clear();
    this.L.clear();
    this.M = new int[paramInt2];
    Object localObject1 = new int[paramInt2];
    a(paramCharSequence, paramInt2, (int[])localObject1, 0, false);
    float f1 = this.b.getTextSize();
    int i1 = (int)f1;
    FastColorFontHelper.a().a(this.q.mFontId, (int[])localObject1, i1, this.M);
    a(paramInt2, (int[])localObject1, i1);
    Object localObject2;
    Object localObject3;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject1 = (Spanned)paramCharSequence;
      localObject2 = (CharacterStyle[])((Spanned)localObject1).getSpans(0, ((Spanned)localObject1).length(), CharacterStyle.class);
      this.af.a((Spanned)localObject1);
      Arrays.sort((Object[])localObject2, this.af);
      localObject3 = localObject1;
    }
    else
    {
      localObject1 = null;
      localObject3 = localObject1;
      localObject2 = localObject1;
    }
    this.z = ((int)(FastColorFontCache.a(this.q.mFontId) * f1 / FastColorFontCache.e(this.q.mFontId)));
    a(paramCharSequence, i1, (CharacterStyle[])localObject2, localObject3, (int)(f1 * FastColorFontCache.d(this.q.mFontId) / FastColorFontCache.e(this.q.mFontId)));
    if (Build.VERSION.SDK_INT >= 16) {
      paramInt1 = this.b.getMaxLines();
    } else {
      paramInt1 = 0;
    }
    f1 = this.b.getPaint().getFontMetrics().bottom;
    this.y = 0;
    this.x = this.e.size();
    paramInt1 = a(i1, 0, paramInt1, f1);
    paramInt2 = this.O;
    if (paramInt2 < this.ab) {
      this.k = (paramInt2 + this.g + this.h);
    }
    this.l = (paramInt1 + this.j + this.i);
  }
  
  private void a(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int i1 = 0;
    while (i1 < paramInt1)
    {
      int i3 = this.M[i1];
      int i2 = i3;
      if (i3 <= 0)
      {
        float f1 = this.b.getPaint().measureText(String.valueOf((char)paramArrayOfInt[i1]));
        if (f1 <= 0.0F) {
          f1 = paramInt2;
        }
        i2 = (int)(f1 * FastColorFontCache.d(this.q.mFontId) / FastColorFontCache.e(this.q.mFontId));
        this.L.add(Integer.valueOf(i1));
      }
      this.M[i1] = i2;
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, ModelFastColorFont paramModelFastColorFont)
  {
    if (paramModelFastColorFont.c > 0)
    {
      if (paramModelFastColorFont.d <= 0) {
        return;
      }
      BitmapShader localBitmapShader = FastColorFontCache.a(this.q.mFontId, this.q.mComboIndex, paramModelFastColorFont.c, paramModelFastColorFont.d);
      Bitmap localBitmap1;
      if (localBitmapShader == null)
      {
        localBitmap2 = Bitmap.createBitmap(paramModelFastColorFont.c, paramModelFastColorFont.d, Bitmap.Config.ARGB_8888);
        localBitmap1 = Bitmap.createBitmap(paramModelFastColorFont.c, paramModelFastColorFont.d, Bitmap.Config.ARGB_8888);
        int i1 = FastColorFontHelper.a().a(this.q.mFontId, localBitmap2, localBitmap1, this.q.mComboIndex);
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2) {
              break label290;
            }
            localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            FastColorFontCache.a(this.q.mFontId, this.q.mComboIndex, paramModelFastColorFont.c, paramModelFastColorFont.d, localBitmapShader);
            FastColorFontCache.a(this.q.mFontId, this.q.mComboIndex, paramModelFastColorFont.c, paramModelFastColorFont.d, localBitmap1);
            break label290;
          }
          localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
          FastColorFontCache.a(this.q.mFontId, this.q.mComboIndex, paramModelFastColorFont.c, paramModelFastColorFont.d, localBitmapShader);
          localBitmap1.recycle();
        }
        else
        {
          localBitmap2.recycle();
          localBitmap1.recycle();
        }
        localBitmap1 = null;
      }
      else
      {
        localBitmap1 = FastColorFontCache.b(this.q.mFontId, this.q.mComboIndex, paramModelFastColorFont.c, paramModelFastColorFont.d);
      }
      label290:
      Bitmap localBitmap2 = Bitmap.createBitmap(paramModelFastColorFont.c, paramModelFastColorFont.d, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = this.d;
      if (localCanvas == null) {
        this.d = new Canvas(localBitmap2);
      } else {
        localCanvas.setBitmap(localBitmap2);
      }
      if (localBitmap1 != null) {
        this.d.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
      }
      if (localBitmapShader != null) {
        this.Q.setShader(localBitmapShader);
      }
      this.Q.setTextSize(paramModelFastColorFont.d);
      this.d.drawText(String.valueOf(paramModelFastColorFont.b), 0.0F, (int)(paramModelFastColorFont.d / 2.0F - (this.Q.descent() + this.Q.ascent()) / 2.0F), this.Q);
      paramCanvas.drawBitmap(localBitmap2, paramModelFastColorFont.e, paramModelFastColorFont.f, this.Q);
      localBitmap2.recycle();
    }
  }
  
  private void a(CharSequence paramCharSequence, int paramInt1, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean)
  {
    int i2 = 0;
    int i1 = paramInt2;
    paramInt2 = i2;
    boolean bool = paramBoolean;
    while (paramInt2 < paramInt1)
    {
      paramArrayOfInt[paramInt2] = paramCharSequence.charAt(paramInt2);
      if (((paramArrayOfInt[paramInt2] >= 97) && (paramArrayOfInt[paramInt2] <= 122)) || ((paramArrayOfInt[paramInt2] >= 65) && (paramArrayOfInt[paramInt2] <= 90)))
      {
        if (!bool)
        {
          i2 = paramInt2;
          paramBoolean = true;
          break label150;
        }
        paramBoolean = bool;
        i2 = i1;
        if (paramInt2 != paramInt1 - 1) {
          break label150;
        }
        this.K.put(i1, paramInt1 - i1);
      }
      else
      {
        paramBoolean = bool;
        i2 = i1;
        if (!bool) {
          break label150;
        }
        this.K.put(i1, paramInt2 - i1);
      }
      paramBoolean = false;
      i2 = i1;
      label150:
      paramInt2 += 1;
      bool = paramBoolean;
      i1 = i2;
    }
  }
  
  private void a(CharSequence paramCharSequence, int paramInt1, CharacterStyle[] paramArrayOfCharacterStyle, Spanned paramSpanned, int paramInt2)
  {
    int i1;
    int i2;
    if ((paramSpanned != null) && (paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0))
    {
      a(paramArrayOfCharacterStyle, paramSpanned);
      i1 = 0;
      i2 = 0;
    }
    while (i2 < paramArrayOfCharacterStyle.length)
    {
      CharacterStyle localCharacterStyle = paramArrayOfCharacterStyle[i2];
      int i4 = paramSpanned.getSpanStart(localCharacterStyle);
      int i3 = paramSpanned.getSpanEnd(localCharacterStyle);
      boolean bool;
      if (i3 == paramSpanned.length()) {
        bool = true;
      } else {
        bool = false;
      }
      if (a(paramCharSequence, paramInt1, paramInt2, i1, i4, i3)) {
        return;
      }
      if (a(paramCharSequence, paramInt1, paramInt2, localCharacterStyle, i4, i3, bool)) {
        return;
      }
      if ((i2 == paramArrayOfCharacterStyle.length - 1) && (!bool) && (a(ETLayout.a(paramCharSequence, i3, paramSpanned.length()), i3, paramInt1, 0, true, paramInt2))) {
        return;
      }
      i2 += 1;
      i1 = i3;
      continue;
      a(paramCharSequence, 0, paramInt1, 0, true, paramInt2);
    }
  }
  
  private void a(CharacterStyle[] paramArrayOfCharacterStyle, Spanned paramSpanned)
  {
    int i3 = paramArrayOfCharacterStyle.length;
    int i1 = 0;
    while (i1 < i3)
    {
      Object localObject = paramArrayOfCharacterStyle[i1];
      if ((localObject instanceof RelativeSizeSpan))
      {
        int i2 = paramSpanned.getSpanStart(localObject);
        int i4 = paramSpanned.getSpanEnd(localObject);
        float f1 = ((RelativeSizeSpan)localObject).getSizeChange();
        while (i2 < i4)
        {
          localObject = this.M;
          localObject[i2] = ((int)(localObject[i2] * f1));
          i2 += 1;
        }
      }
      i1 += 1;
    }
  }
  
  private boolean a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramCharacterStyle instanceof EmoticonSpan))
    {
      localObject = ((EmoticonSpan)paramCharacterStyle).getDrawable().getBounds();
      paramInt1 = ((Rect)localObject).width();
      paramInt2 = ((Rect)localObject).height();
    }
    else if ((paramCharacterStyle instanceof SignatureActionSpan))
    {
      localObject = (SignatureActionSpan)paramCharacterStyle;
      paramInt1 = ((SignatureActionSpan)localObject).a();
      paramInt2 = ((SignatureActionSpan)localObject).b();
    }
    else
    {
      paramInt2 = 0;
      paramInt1 = 0;
    }
    Object localObject = o();
    ((ModelFastColorFont)localObject).b = 65535;
    ((ModelFastColorFont)localObject).h = false;
    ((ModelFastColorFont)localObject).c = paramInt1;
    ((ModelFastColorFont)localObject).d = paramInt2;
    ((ModelFastColorFont)localObject).i = paramCharacterStyle;
    ((ModelFastColorFont)localObject).a = paramInt3;
    if (this.aa < ((ModelFastColorFont)localObject).c)
    {
      this.W = Math.max(this.V, this.W);
      this.V = ((ModelFastColorFont)localObject).c;
      this.X += 1;
      this.ac = 0;
      ((ModelFastColorFont)localObject).e = this.ac;
      ((ModelFastColorFont)localObject).g = this.X;
      this.ac = ((ModelFastColorFont)localObject).c;
      this.aa = (this.ab - ((ModelFastColorFont)localObject).c);
      this.e.add(this.R);
      this.R = new ArrayList();
      this.R.add(localObject);
      this.f.add(localObject);
    }
    else
    {
      this.V += ((ModelFastColorFont)localObject).c;
      ((ModelFastColorFont)localObject).e = this.ac;
      ((ModelFastColorFont)localObject).g = this.X;
      this.aa -= ((ModelFastColorFont)localObject).c;
      this.ac += ((ModelFastColorFont)localObject).c;
      this.R.add(localObject);
      this.f.add(localObject);
    }
    paramInt1 = this.ac;
    if (paramInt1 > this.O) {
      this.O = paramInt1;
    }
    this.Y += 1;
    paramInt1 = this.Z;
    if ((paramInt1 > 0) && (this.Y >= paramInt1))
    {
      this.e.add(this.R);
      return true;
    }
    if (paramBoolean) {
      this.e.add(this.R);
    }
    return false;
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    float f2 = paramRelativeSizeSpan.getSizeChange();
    int i5 = paramCharSequence.length();
    int i2 = 0;
    while (i2 < i5)
    {
      char c1 = paramCharSequence.charAt(i2);
      paramRelativeSizeSpan = o();
      int i1;
      if (c1 == '\n')
      {
        paramRelativeSizeSpan.h = false;
        paramRelativeSizeSpan.a = paramInt3;
        paramRelativeSizeSpan.c = 0;
        paramRelativeSizeSpan.d = paramInt4;
        paramRelativeSizeSpan.b = c1;
        paramRelativeSizeSpan.e = this.ac;
        i1 = this.X;
        paramRelativeSizeSpan.g = i1;
        this.aa = this.ab;
        this.X = (i1 + 1);
        this.ac = 0;
        this.W = Math.max(this.V, this.W);
        this.V = 0;
        this.R.add(paramRelativeSizeSpan);
        this.e.add(this.R);
        this.R = new ArrayList();
      }
      else
      {
        if (this.K.size() > 0)
        {
          localObject = this.K;
          int i6 = paramInt1 + i2;
          int i7 = ((SparseIntArray)localObject).get(i6);
          if (i7 > 0)
          {
            int i4 = 0;
            i1 = 0;
            for (;;)
            {
              i3 = i1;
              if (i4 >= i7) {
                break;
              }
              i1 += this.M[(i6 + i4)];
              i4 += 1;
            }
          }
        }
        int i3 = 0;
        i1 = paramInt1 + i2;
        Object localObject = this.M;
        float f1;
        if (i1 < localObject.length) {
          f1 = localObject[i1];
        } else {
          f1 = paramInt2 * f2;
        }
        paramRelativeSizeSpan.h = this.L.contains(Integer.valueOf(i1));
        paramRelativeSizeSpan.a = paramInt3;
        paramRelativeSizeSpan.c = ((int)f1);
        if (paramRelativeSizeSpan.h) {
          i1 = paramInt2;
        } else {
          i1 = paramInt4;
        }
        paramRelativeSizeSpan.d = ((int)(i1 * f2));
        paramRelativeSizeSpan.b = c1;
        if ((this.aa >= paramRelativeSizeSpan.c) && ((this.aa >= i3) || (this.ac == 0)))
        {
          this.V += paramRelativeSizeSpan.c;
          paramRelativeSizeSpan.e = this.ac;
          paramRelativeSizeSpan.g = this.X;
          this.aa -= paramRelativeSizeSpan.c;
          this.ac += paramRelativeSizeSpan.c;
          this.R.add(paramRelativeSizeSpan);
        }
        else
        {
          this.W = Math.max(this.V, this.W);
          this.V = paramRelativeSizeSpan.c;
          this.X += 1;
          this.ac = 0;
          paramRelativeSizeSpan.e = this.ac;
          paramRelativeSizeSpan.g = this.X;
          this.ac = paramRelativeSizeSpan.c;
          this.aa = (this.ab - paramRelativeSizeSpan.c);
          this.e.add(this.R);
          this.R = new ArrayList();
          this.R.add(paramRelativeSizeSpan);
        }
        i1 = this.ac;
        if (i1 > this.O) {
          this.O = i1;
        }
        this.Y += 1;
        i1 = this.Z;
        if ((i1 > 0) && (this.Y >= i1))
        {
          this.e.add(this.R);
          return true;
        }
      }
      this.f.add(paramRelativeSizeSpan);
      if ((i2 == i5 - 1) && (paramBoolean)) {
        this.e.add(this.R);
      }
      i2 += 1;
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    return (paramInt4 > paramInt3) && (paramInt5 > paramInt4) && (a(ETLayout.a(paramCharSequence, paramInt3, paramInt4), paramInt3, paramInt1, 0, false, paramInt2));
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i5 = paramCharSequence.length();
    int i2 = 0;
    while (i2 < i5)
    {
      char c1 = paramCharSequence.charAt(i2);
      ModelFastColorFont localModelFastColorFont = o();
      int i1;
      if (c1 == '\n')
      {
        localModelFastColorFont.h = false;
        localModelFastColorFont.a = paramInt3;
        localModelFastColorFont.c = 0;
        localModelFastColorFont.d = paramInt4;
        localModelFastColorFont.b = c1;
        localModelFastColorFont.e = this.ac;
        i1 = this.X;
        localModelFastColorFont.g = i1;
        this.aa = this.ab;
        this.X = (i1 + 1);
        this.ac = 0;
        this.W = Math.max(this.V, this.W);
        this.V = 0;
        this.R.add(localModelFastColorFont);
        this.e.add(this.R);
        this.R = new ArrayList();
      }
      else
      {
        if (this.K.size() > 0)
        {
          localObject = this.K;
          int i6 = paramInt1 + i2;
          int i7 = ((SparseIntArray)localObject).get(i6);
          if (i7 > 0)
          {
            int i4 = 0;
            i1 = 0;
            for (;;)
            {
              i3 = i1;
              if (i4 >= i7) {
                break;
              }
              i1 += this.M[(i6 + i4)];
              i4 += 1;
            }
          }
        }
        int i3 = 0;
        i1 = paramInt1 + i2;
        Object localObject = this.M;
        float f1;
        if (i1 < localObject.length) {
          f1 = localObject[i1];
        } else {
          f1 = paramInt2;
        }
        localModelFastColorFont.h = this.L.contains(Integer.valueOf(i1));
        localModelFastColorFont.a = paramInt3;
        localModelFastColorFont.c = ((int)f1);
        if (localModelFastColorFont.h) {
          i1 = paramInt2;
        } else {
          i1 = paramInt4;
        }
        localModelFastColorFont.d = i1;
        localModelFastColorFont.b = c1;
        if ((this.aa >= localModelFastColorFont.c) && ((this.aa >= i3) || (this.ac == 0)))
        {
          this.V += localModelFastColorFont.c;
          localModelFastColorFont.e = this.ac;
          localModelFastColorFont.g = this.X;
          this.aa -= localModelFastColorFont.c;
          this.ac += localModelFastColorFont.c;
          this.R.add(localModelFastColorFont);
        }
        else
        {
          this.W = Math.max(this.V, this.W);
          this.V = localModelFastColorFont.c;
          this.X += 1;
          this.ac = 0;
          localModelFastColorFont.e = this.ac;
          localModelFastColorFont.g = this.X;
          this.ac = localModelFastColorFont.c;
          this.aa = (this.ab - localModelFastColorFont.c);
          this.e.add(this.R);
          this.R = new ArrayList();
          this.R.add(localModelFastColorFont);
        }
        i1 = this.ac;
        if (i1 > this.O) {
          this.O = i1;
        }
        this.Y += 1;
        i1 = this.Z;
        if ((i1 > 0) && (this.Y >= i1))
        {
          this.e.add(this.R);
          return true;
        }
      }
      this.f.add(localModelFastColorFont);
      if ((i2 == i5 - 1) && (paramBoolean)) {
        this.e.add(this.R);
      }
      i2 += 1;
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((paramCharacterStyle instanceof ClickableSpan))
    {
      if (a(ETLayout.a(paramCharSequence, paramInt3, paramInt4), paramInt3, paramInt1, 1, paramBoolean, paramInt2)) {
        return true;
      }
    }
    else if ((!(paramCharacterStyle instanceof EmoticonSpan)) && (!(paramCharacterStyle instanceof SignatureActionSpan)))
    {
      if ((paramCharacterStyle instanceof RelativeSizeSpan))
      {
        if (a((RelativeSizeSpan)paramCharacterStyle, ETLayout.a(paramCharSequence, paramInt3, paramInt4), paramInt3, paramInt1, 3, paramBoolean, paramInt2)) {
          return true;
        }
      }
      else
      {
        paramCharSequence = new StringBuilder();
        paramCharSequence.append("Un Know CharacterStyle   start:");
        paramCharSequence.append(paramInt3);
        paramCharSequence.append("  end:");
        paramCharSequence.append(paramInt4);
        FastColorFontLog.b("FounderColorLayout", paramCharSequence.toString());
      }
    }
    else if (a(paramCharacterStyle, paramInt3, paramInt4, 2, paramBoolean)) {
      return true;
    }
    return false;
  }
  
  private boolean a(List<ModelFastColorFont> paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -2147483648) && (paramInt1 != 1073741824))
    {
      this.k = this.b.getETMaxWidth();
      return;
    }
    this.k = Math.min(this.b.getETMaxWidth(), paramInt2);
  }
  
  private void n()
  {
    if (this.N) {
      return;
    }
    this.N = true;
    if (this.f == null) {
      this.f = new ArrayList();
    }
    if (this.R == null) {
      this.R = new ArrayList();
    }
    if (this.e == null) {
      this.e = new ArrayList();
    }
    if (this.S == null) {
      this.S = new ArrayList();
    }
    if ((this.T <= 0) || (this.U <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.b.getResources().getDisplayMetrics();
      this.T = localDisplayMetrics.widthPixels;
      this.U = localDisplayMetrics.heightPixels;
    }
    if (this.P == null)
    {
      this.P = new Paint(1);
      this.P.setDither(true);
      this.P.setFilterBitmap(true);
      this.P.setStyle(Paint.Style.FILL);
    }
    if (this.Q == null)
    {
      this.Q = new Paint(1);
      this.Q.setDither(true);
      this.Q.setFilterBitmap(true);
    }
    if (this.L == null) {
      this.L = new ArrayList();
    }
    if (this.K == null) {
      this.K = new SparseIntArray();
    }
    if (this.G == null)
    {
      this.G = new Paint(1);
      this.G.setDither(true);
      this.G.setFilterBitmap(true);
      this.G.setStyle(Paint.Style.FILL);
    }
    this.H = new Path();
  }
  
  private ModelFastColorFont o()
  {
    if (this.S.isEmpty()) {
      return new ModelFastColorFont();
    }
    return (ModelFastColorFont)this.S.remove(0);
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    int i1 = 0;
    while (i1 < this.f.size())
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(i1);
      if ((paramInt1 >= localModelFastColorFont.e) && (paramInt1 <= localModelFastColorFont.e + localModelFastColorFont.c) && (paramInt2 >= localModelFastColorFont.f) && (paramInt2 <= localModelFastColorFont.f + localModelFastColorFont.d)) {
        return paramTextGraphMap.b(i1);
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
      FastColorFontHelper.a().a(this.q.mFontId, localBitmap, null);
      FastColorFontCache.b(this.q.mFontId, this.q.mComboIndex, paramInt1, paramInt2, localBitmap);
      localObject = localBitmap;
      if (FastColorFontHelper.a)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("create new under line bitmap.... width:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append("  height:");
        ((StringBuilder)localObject).append(paramInt2);
        FastColorFontLog.a("FounderColorLayout", ((StringBuilder)localObject).toString());
        localObject = localBitmap;
      }
    }
    return localObject;
  }
  
  protected void a()
  {
    super.a();
    this.r.addUpdateListener(new FounderColorLayout.1(this));
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (!paramBoolean) {
      i1 = paramInt - 1;
    }
    paramInt = i1;
    if (i1 >= this.f.size())
    {
      paramInt = this.f.size() - 1;
      paramBoolean = false;
    }
    if (paramInt < 0) {
      return;
    }
    this.b.getLocationInWindow(paramArrayOfInt);
    ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.g + localModelFastColorFont.e;
      paramArrayOfInt[1] += this.i + localModelFastColorFont.f + localModelFastColorFont.d;
      return;
    }
    paramArrayOfInt[0] += this.g + localModelFastColorFont.e + localModelFastColorFont.c;
    paramArrayOfInt[1] += this.i + localModelFastColorFont.f + localModelFastColorFont.d;
  }
  
  protected void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      this.b.invalidate();
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (m())
    {
      a("FounderColorLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!k())
    {
      a("FounderColorLayout::onDraw 创建bitmap失败！");
      return false;
    }
    List localList = this.e;
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (this.m.length <= 0)
      {
        a(HardCodeUtil.a(2131902847));
        return false;
      }
      c();
      c(paramCanvas);
      long l1 = System.nanoTime();
      int i1 = FastColorFontCache.b(this.q.mFontId);
      if ((this.q.mShouldDisplayAnimation) && (!this.D) && (i1 == 3))
      {
        int i2 = this.x;
        if ((i2 > 0) && (i2 < 6))
        {
          FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.s, this.p);
          l();
          paramCanvas.drawBitmap(this.o, this.g, this.i, null);
          if (this.s == 0) {
            b();
          }
          if (FastColorFontHelper.a)
          {
            long l2 = System.nanoTime();
            paramCanvas = new StringBuilder();
            paramCanvas.append("动画帧耗时 frameIndex:");
            paramCanvas.append(this.s);
            paramCanvas.append("  行：");
            paramCanvas.append(this.x);
            paramCanvas.append("  列：");
            paramCanvas.append(this.y);
            paramCanvas.append("  耗时：");
            paramCanvas.append((float)(l2 - l1) / 1000000.0F);
            paramCanvas.append("ms");
            FastColorFontLog.b("FounderColorLayout", paramCanvas.toString());
            if (this.s == 0) {
              a("drawAnimationText.....");
            }
          }
          return true;
        }
      }
      if ((!this.D) && (i1 == 5))
      {
        FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.o, this.k - this.g - this.h, this.l - this.i - this.j, this.q.mComboIndex);
        l();
        paramCanvas.drawBitmap(this.o, this.g, this.i, null);
        return true;
      }
      this.B = new int[0];
      FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.o, this.k - this.g - this.h, this.l - this.i - this.j, this.A, this.B, this.C);
      l();
      paramCanvas.drawBitmap(this.o, this.g, this.i, null);
      return true;
    }
    a(HardCodeUtil.a(2131902848));
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.I == paramLong) && (this.ae == paramBoolean) && (this.q.equals(paramETFont)) && (this.b.isCacheMeasureResult())) {
      return this.J;
    }
    Object localObject;
    if (this.I != paramLong)
    {
      if (this.q != null) {
        this.q.mShouldDisplayAnimation = false;
      }
      localObject = this.b;
      if (localObject != null) {
        ((IETextView)localObject).setIsFounderAnimating(false);
      }
      if (this.r != null) {
        this.r.cancel();
      }
      this.s = 0;
    }
    this.I = paramLong;
    this.ae = paramBoolean;
    this.q = new ETFont(-1, null, 0.0F);
    this.q.copy(paramETFont);
    this.J[0] = View.MeasureSpec.getSize(paramInt1);
    this.J[1] = View.MeasureSpec.getSize(paramInt2);
    if ((this.q != null) && (!TextUtils.isEmpty(this.q.mFontPath)))
    {
      localObject = this.b;
      if ((localObject != null) && (((IETextView)localObject).getVisibility() != 8))
      {
        localObject = this.b.getText();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return this.J;
        }
        paramLong = System.nanoTime();
        a(paramInt1, paramInt2, (CharSequence)localObject);
        double d1 = (float)(System.nanoTime() - paramLong) / 1000000.0F;
        if (FastColorFontHelper.a)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("字数：");
          localStringBuilder.append(((CharSequence)localObject).length());
          localStringBuilder.append("   字号：");
          localStringBuilder.append(this.b.getTextSize());
          localStringBuilder.append("px   排版耗时：");
          localStringBuilder.append(d1);
          localStringBuilder.append("ms");
          FastColorFontLog.a("FounderColorLayout", localStringBuilder.toString());
        }
        if (this.b != null) {
          FontReportUtils.a("action_measure", paramETFont.mFontId, 4, this.b.getText().length(), d1);
        }
        if (m()) {
          return this.J;
        }
        paramETFont = this.J;
        paramETFont[0] = this.k;
        paramETFont[1] = this.l;
        return paramETFont;
      }
    }
    return this.J;
  }
  
  public void b()
  {
    if (this.q != null)
    {
      if (m()) {
        return;
      }
      if (FastColorFontCache.b(this.q.mFontId) < 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("当前字体未加载或不支持动画...");
        localStringBuilder.append(this.q.mFontPath);
        FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
        return;
      }
      int i1 = this.x;
      if ((i1 > 0) && (i1 <= 5) && (!this.D))
      {
        if ((this.r != null) && (this.r.isRunning())) {
          return;
        }
        if ((this.p[0] > 0) && (this.p[1] > 0))
        {
          i();
          return;
        }
        this.s = 0;
        FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.s, this.p);
        if ((this.p[0] > 0) && (this.p[1] > 0))
        {
          i();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
        localStringBuilder.append(Arrays.toString(this.p));
        FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0行或超过5行不支持播放动画...");
      localStringBuilder.append(this.q.mFontPath);
      FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.H.reset();
    int i2 = this.f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 >= paramInt1) && (i1 < paramInt2))
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(i1);
        this.H.addRect(this.g + localModelFastColorFont.e, this.i + localModelFastColorFont.f, this.g + localModelFastColorFont.e + localModelFastColorFont.c, this.i + localModelFastColorFont.f + localModelFastColorFont.d, Path.Direction.CW);
      }
      i1 += 1;
    }
    this.b.invalidate();
  }
  
  protected void b(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-256);
    localPaint.setStrokeWidth(1.0F);
    int i1 = 0;
    while (i1 < this.m.length)
    {
      int i2 = this.g;
      int[] arrayOfInt1 = this.n;
      float f1 = arrayOfInt1[i1] + i2;
      int i3 = this.i;
      int[] arrayOfInt2 = this.u;
      paramCanvas.drawRect(f1, arrayOfInt2[i1] + i3, i2 + arrayOfInt1[i1] + this.v[i1], i3 + arrayOfInt2[i1] + this.w[i1], localPaint);
      i1 += 1;
    }
  }
  
  public int c(int paramInt1, int paramInt2)
  {
    this.b.getLocationInWindow(this.F);
    Object localObject1 = this.F;
    int i5 = 0;
    int i6 = localObject1[0];
    int i7 = localObject1[1];
    int i2 = 0;
    int i1 = 0;
    while (i2 < this.e.size())
    {
      localObject1 = (List)this.e.get(i2);
      int i3 = -2147483648;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)((Iterator)localObject2).next();
        i4 = this.i + localModelFastColorFont.f + localModelFastColorFont.d;
        if (i4 > i3) {
          i3 = i4;
        }
      }
      int i4 = i5;
      if (i3 < paramInt2 - i7) {
        if (i2 == this.e.size() - 1)
        {
          i4 = i5;
        }
        else
        {
          i1 += ((List)localObject1).size();
          i2 += 1;
          continue;
        }
      }
      while (i4 < ((List)localObject1).size())
      {
        localObject2 = (ModelFastColorFont)((List)localObject1).get(i4);
        if (paramInt1 - i6 <= this.g + ((ModelFastColorFont)localObject2).e + ((ModelFastColorFont)localObject2).c) {
          return i1 + i4;
        }
        i4 += 1;
      }
      return i1 + ((List)localObject1).size();
    }
    return -1;
  }
  
  protected void c(Canvas paramCanvas)
  {
    if (!this.b.hasSelected()) {
      return;
    }
    this.G.setColor(this.b.highlightBackgroundColor());
    paramCanvas.drawPath(this.H, this.G);
  }
  
  public void d()
  {
    this.H.reset();
    this.b.invalidate();
  }
  
  public void e()
  {
    super.e();
    this.c = null;
    this.d = null;
  }
  
  protected boolean k()
  {
    if (!d(this.k - this.g - this.h, this.l - this.i - this.j)) {
      return false;
    }
    int i2 = this.f.size();
    if (i2 <= 0) {
      return false;
    }
    if (this.ad != i2) {
      this.m = new int[i2];
    }
    int i1 = this.ad;
    if ((i1 < i2) || (i1 - i2 > 100))
    {
      this.n = new int[i2];
      this.u = new int[i2];
      this.v = new int[i2];
      this.w = new int[i2];
    }
    this.ad = i2;
    this.D = true;
    i1 = 0;
    while (i1 < i2)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(i1);
      this.m[i1] = localModelFastColorFont.b;
      this.n[i1] = localModelFastColorFont.e;
      this.u[i1] = localModelFastColorFont.f;
      this.v[i1] = localModelFastColorFont.c;
      this.w[i1] = localModelFastColorFont.d;
      if (localModelFastColorFont.a != 2) {
        this.D = false;
      }
      i1 += 1;
    }
    return true;
  }
  
  protected void l()
  {
    int i2 = (int)(this.b.getTextSize() / 15.0F);
    Object localObject1 = this.c;
    if (localObject1 == null) {
      this.c = new Canvas(this.o);
    } else {
      ((Canvas)localObject1).setBitmap(this.o);
    }
    int i3 = this.f.size();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject1 = (ModelFastColorFont)this.f.get(i1);
      int i4 = ((ModelFastColorFont)localObject1).a;
      Object localObject2;
      if (i4 != 1)
      {
        if (i4 == 2)
        {
          this.c.drawRect(((ModelFastColorFont)localObject1).e, ((ModelFastColorFont)localObject1).f, ((ModelFastColorFont)localObject1).e + ((ModelFastColorFont)localObject1).c, ((ModelFastColorFont)localObject1).f + ((ModelFastColorFont)localObject1).d, this.E);
          Canvas localCanvas;
          float f1;
          int i5;
          int i6;
          if ((((ModelFastColorFont)localObject1).i instanceof EmoticonSpan))
          {
            localObject2 = (EmoticonSpan)((ModelFastColorFont)localObject1).i;
            localCanvas = this.c;
            f1 = ((ModelFastColorFont)localObject1).e;
            i4 = ((ModelFastColorFont)localObject1).f;
            i5 = ((ModelFastColorFont)localObject1).f;
            i6 = ((ModelFastColorFont)localObject1).d;
            int i7 = ((ModelFastColorFont)localObject1).f;
            ((EmoticonSpan)localObject2).draw(localCanvas, null, 0, 0, f1, i4, i6 + i5, ((ModelFastColorFont)localObject1).d + i7, this.b.getPaint());
          }
          else if ((((ModelFastColorFont)localObject1).i instanceof SignatureActionSpan))
          {
            localObject2 = (SignatureActionSpan)((ModelFastColorFont)localObject1).i;
            ((SignatureActionSpan)localObject2).c = false;
            localCanvas = this.c;
            f1 = ((ModelFastColorFont)localObject1).e;
            i4 = ((ModelFastColorFont)localObject1).f;
            i5 = ((ModelFastColorFont)localObject1).f;
            i6 = ((ModelFastColorFont)localObject1).f;
            ((SignatureActionSpan)localObject2).draw(localCanvas, null, 0, 0, f1, i4, i5, ((ModelFastColorFont)localObject1).d + i6, this.b.getPaint());
          }
        }
      }
      else
      {
        localObject2 = a(((ModelFastColorFont)localObject1).c, i2);
        this.c.drawBitmap((Bitmap)localObject2, ((ModelFastColorFont)localObject1).e, ((ModelFastColorFont)localObject1).f + ((ModelFastColorFont)localObject1).d - i2, this.b.getPaint());
      }
      if (((ModelFastColorFont)localObject1).h) {
        a(this.c, (ModelFastColorFont)localObject1);
      }
      i1 += 1;
    }
  }
  
  protected boolean m()
  {
    int i1 = this.k;
    int i2 = this.g;
    int i3 = this.h;
    int i4 = 1;
    if (i1 - i2 - i3 <= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.l - this.i - this.j <= 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.k - this.g - this.h > this.T) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (this.l - this.i - this.j <= this.U) {
      i4 = 0;
    }
    return i1 | 0x0 | i2 | i3 | i4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout
 * JD-Core Version:    0.7.0.1
 */