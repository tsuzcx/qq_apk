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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import b;
import c;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FounderColorLayout
{
  public static boolean a;
  public int a;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private c jdField_a_of_type_C;
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private List jdField_a_of_type_JavaUtilList;
  public int[] a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private List jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  private int[] jdField_c_of_type_ArrayOfInt;
  private int jdField_d_of_type_Int;
  private List jdField_d_of_type_JavaUtilList;
  private boolean jdField_d_of_type_Boolean;
  private int[] jdField_d_of_type_ArrayOfInt;
  private int jdField_e_of_type_Int;
  private int[] jdField_e_of_type_ArrayOfInt;
  private int jdField_f_of_type_Int;
  private int[] jdField_f_of_type_ArrayOfInt;
  private int jdField_g_of_type_Int;
  private int[] jdField_g_of_type_ArrayOfInt;
  private int jdField_h_of_type_Int;
  private int[] jdField_h_of_type_ArrayOfInt;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public FounderColorLayout(ETTextView paramETTextView, ETFont paramETFont)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[] { -1, -1 };
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    d();
    this.jdField_a_of_type_C = new c();
    this.jdField_c_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  private Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap2, null);
      FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramInt1, paramInt2, localBitmap2);
      localBitmap1 = localBitmap2;
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        FastColorFontLog.a("FounderColorLayout", "create new under line bitmap.... width:" + paramInt1 + "  height:" + paramInt2);
        localBitmap1 = localBitmap2;
      }
    }
    return localBitmap1;
  }
  
  private d a()
  {
    if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
      return new d();
    }
    return (d)this.jdField_d_of_type_JavaUtilList.remove(0);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    }
    while ((paramInt1 <= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (paramInt2 <= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) && ((paramInt1 << 1 >= this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) || (paramInt2 << 1 >= this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()))) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  @TargetApi(16)
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    d();
    this.i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Int;
    this.j = 0;
    this.jdField_b_of_type_Int = 0;
    this.k = 0;
    this.l = 0;
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.m = 1;
    this.r = 0;
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft();
    this.jdField_f_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingRight();
    this.jdField_g_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    this.jdField_h_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingBottom();
    this.q = (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.jdField_a_of_type_Int - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int);
    if (Build.VERSION.SDK_INT >= 16) {
      this.o = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxEms();
    }
    this.p = this.q;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    paramInt1 = this.jdField_d_of_type_JavaUtilList.size();
    int i5 = paramCharSequence.length();
    if ((paramInt1 < i5) && (!this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      while (paramInt1 < i5)
      {
        if (!this.jdField_c_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_ArrayOfInt = new int[i5];
    Object localObject = new int[i5];
    int i1 = 0;
    int i3 = 0;
    paramInt2 = 0;
    int i2;
    if (paramInt2 < i5)
    {
      localObject[paramInt2] = paramCharSequence.charAt(paramInt2);
      if (((localObject[paramInt2] >= 97) && (localObject[paramInt2] <= 122)) || ((localObject[paramInt2] >= 65) && (localObject[paramInt2] <= 90))) {
        if (i3 == 0)
        {
          paramInt1 = 1;
          i2 = paramInt2;
        }
      }
      for (;;)
      {
        paramInt2 += 1;
        i3 = paramInt1;
        i1 = i2;
        break;
        paramInt1 = i3;
        i2 = i1;
        if (paramInt2 == i5 - 1)
        {
          paramInt1 = 0;
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, i5 - i1);
          i2 = i1;
          continue;
          paramInt1 = i3;
          i2 = i1;
          if (i3 != 0)
          {
            paramInt1 = 0;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, paramInt2 - i1);
            i2 = i1;
          }
        }
      }
    }
    float f2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize();
    int i4 = (int)f2;
    FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (int[])localObject, i4, this.jdField_c_of_type_ArrayOfInt);
    paramInt1 = 0;
    float f1;
    if (paramInt1 < i5)
    {
      i1 = this.jdField_c_of_type_ArrayOfInt[paramInt1];
      paramInt2 = i1;
      if (i1 <= 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().measureText(String.valueOf((char)localObject[paramInt1]));
        if (f1 <= 0.0F) {
          break label561;
        }
      }
      for (;;)
      {
        paramInt2 = (int)f1;
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
        this.jdField_c_of_type_ArrayOfInt[paramInt1] = paramInt2;
        paramInt1 += 1;
        break;
        label561:
        f1 = i4;
      }
    }
    CharacterStyle[] arrayOfCharacterStyle;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
      this.jdField_a_of_type_C.a((Spanned)localObject);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_C);
    }
    for (;;)
    {
      this.v = ((int)(FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
      i2 = (int)(FastColorFontCache.c(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
      CharacterStyle localCharacterStyle;
      int i6;
      boolean bool;
      if ((localObject != null) && (arrayOfCharacterStyle != null) && (arrayOfCharacterStyle.length > 0))
      {
        i1 = 0;
        i3 = arrayOfCharacterStyle.length;
        paramInt1 = 0;
        while (paramInt1 < i3)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt1];
          if ((localCharacterStyle instanceof RelativeSizeSpan))
          {
            paramInt2 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
            i5 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
            f1 = ((RelativeSizeSpan)localCharacterStyle).getSizeChange();
            while (paramInt2 < i5)
            {
              i6 = this.jdField_c_of_type_ArrayOfInt[paramInt2];
              this.jdField_c_of_type_ArrayOfInt[paramInt2] = ((int)(i6 * f1));
              paramInt2 += 1;
            }
          }
          paramInt1 += 1;
        }
        paramInt2 = 0;
        paramInt1 = i1;
        if (paramInt2 < arrayOfCharacterStyle.length)
        {
          localCharacterStyle = arrayOfCharacterStyle[paramInt2];
          i3 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
          i1 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
          if (i1 == ((Spanned)localObject).length())
          {
            bool = true;
            label856:
            if ((i3 <= paramInt1) || (i1 <= i3) || (!a(ETLayout.a(paramCharSequence, paramInt1, i3), paramInt1, i4, 0, false, i2))) {
              break label1021;
            }
          }
        }
        else
        {
          label890:
          if (Build.VERSION.SDK_INT < 16) {
            break label1480;
          }
        }
      }
      label1215:
      label1477:
      label1480:
      for (paramInt2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getMaxLines();; paramInt2 = 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().getFontMetrics().bottom;
        this.u = 0;
        this.t = this.jdField_a_of_type_JavaUtilList.size();
        i5 = this.jdField_a_of_type_JavaUtilList.size();
        i1 = 0;
        i2 = 0;
        if ((i1 >= i5) || (i1 >= paramInt2))
        {
          if (this.jdField_b_of_type_Int < this.q) {
            this.i = (this.jdField_b_of_type_Int + this.jdField_e_of_type_Int + this.jdField_f_of_type_Int);
          }
          this.j = (this.jdField_h_of_type_Int + i2 + this.jdField_g_of_type_Int);
          return;
          bool = false;
          break label856;
          label1021:
          if ((localCharacterStyle instanceof ClickableSpan)) {
            if (a(ETLayout.a(paramCharSequence, i3, i1), i3, i4, 1, bool, i2)) {
              break label890;
            }
          }
          for (;;)
          {
            if ((paramInt2 == arrayOfCharacterStyle.length - 1) && (!bool) && (a(ETLayout.a(paramCharSequence, i1, ((Spanned)localObject).length()), i1, i4, 0, true, i2))) {
              break label1215;
            }
            paramInt2 += 1;
            paramInt1 = i1;
            break;
            if ((localCharacterStyle instanceof QQText.EmoticonSpan))
            {
              if (!a((QQText.EmoticonSpan)localCharacterStyle, i3, i1, 2, bool)) {
                continue;
              }
              break label890;
            }
            if ((localCharacterStyle instanceof RelativeSizeSpan))
            {
              if (!a((RelativeSizeSpan)localCharacterStyle, paramCharSequence.subSequence(i3, i1), i3, i4, 3, bool, i2)) {
                continue;
              }
              break label890;
            }
            FastColorFontLog.b("FounderColorLayout", "Un Know CharacterStyle   start:" + i3 + "  end:" + i1);
          }
          break label890;
          a(paramCharSequence, 0, i4, 0, true, i2);
          break label890;
        }
        paramCharSequence = (List)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((paramCharSequence == null) || (paramCharSequence.isEmpty()))
        {
          if (i1 == i5 - 1) {}
          for (paramInt1 = 0;; paramInt1 = this.v)
          {
            paramInt1 += i2 + i4;
            i1 += 1;
            i2 = paramInt1;
            break;
          }
        }
        this.u = Math.max(this.u, paramCharSequence.size());
        paramInt1 = 0;
        i6 = paramCharSequence.size();
        i3 = 0;
        if (i3 < i6)
        {
          localObject = (d)paramCharSequence.get(i3);
          if (((d)localObject).jdField_c_of_type_Int <= paramInt1) {
            break label1477;
          }
          paramInt1 = ((d)localObject).jdField_c_of_type_Int;
        }
        for (;;)
        {
          i3 += 1;
          break label1330;
          i6 = paramCharSequence.size();
          i3 = 0;
          while (i3 < i6)
          {
            localObject = (d)paramCharSequence.get(i3);
            ((d)localObject).jdField_e_of_type_Int = (paramInt1 - ((d)localObject).jdField_c_of_type_Int + i2 - (int)((1.0F - ((d)localObject).jdField_c_of_type_Int / paramInt1) * f1));
            i3 += 1;
          }
          if (i1 == i5 - 1) {}
          for (i3 = 0;; i3 = this.v)
          {
            paramInt1 = i3 + (i2 + paramInt1);
            break;
          }
        }
      }
      label1330:
      localObject = null;
      arrayOfCharacterStyle = null;
    }
  }
  
  private void a(long paramLong)
  {
    if (FastColorFontHelper.jdField_a_of_type_Boolean)
    {
      float f1 = (float)(System.nanoTime() - paramLong) / 1000000.0F;
      FastColorFontLog.a(f1 / this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().length());
      FastColorFontLog.a("FounderColorLayout", "字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "  字数：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText().length() + "  绘制耗时：" + f1 + "ms   平均单字耗时：" + FastColorFontLog.a() + "ms  采样数：" + FastColorFontLog.jdField_a_of_type_Int + "  手机型号：" + FastColorFontLog.jdField_a_of_type_JavaLangString + "  " + FastColorFontLog.b);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-256);
    localPaint.setStrokeWidth(1.0F);
    int i1 = 0;
    while (i1 < this.jdField_d_of_type_ArrayOfInt.length)
    {
      paramCanvas.drawRect(this.jdField_e_of_type_Int + this.jdField_e_of_type_ArrayOfInt[i1], this.jdField_g_of_type_Int + this.jdField_f_of_type_ArrayOfInt[i1], this.jdField_e_of_type_Int + this.jdField_e_of_type_ArrayOfInt[i1] + this.jdField_g_of_type_ArrayOfInt[i1], this.jdField_g_of_type_Int + this.jdField_f_of_type_ArrayOfInt[i1] + this.jdField_h_of_type_ArrayOfInt[i1], localPaint);
      i1 += 1;
    }
  }
  
  private void a(Canvas paramCanvas, d paramd)
  {
    Object localObject;
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    if ((paramd.jdField_b_of_type_Int > 0) && (paramd.jdField_c_of_type_Int > 0))
    {
      localObject = FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int);
      if (localObject != null) {
        break label299;
      }
      localObject = Bitmap.createBitmap(paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      localBitmap1 = Bitmap.createBitmap(paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      int i1 = FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (Bitmap)localObject, localBitmap1);
      localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
      FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int, (BitmapShader)localObject);
      if (i1 != 2) {
        break label293;
      }
      FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int, localBitmap1);
      localBitmap2 = Bitmap.createBitmap(paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      if (this.jdField_b_of_type_AndroidGraphicsCanvas != null) {
        break label322;
      }
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap2);
    }
    for (;;)
    {
      if (localBitmap1 != null) {
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(paramd.jdField_c_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(paramd.jdField_a_of_type_Char), 0.0F, (int)(paramd.jdField_c_of_type_Int / 2.0F - (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F), this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(localBitmap2, paramd.jdField_d_of_type_Int, paramd.jdField_e_of_type_Int, this.jdField_b_of_type_AndroidGraphicsPaint);
      return;
      label293:
      localBitmap1 = null;
      break;
      label299:
      localBitmap1 = FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, paramd.jdField_b_of_type_Int, paramd.jdField_c_of_type_Int);
      break;
      label322:
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(localBitmap2);
    }
  }
  
  private void a(String paramString)
  {
    int i2 = -1;
    Object localObject = null;
    StringBuilder localStringBuilder;
    label62:
    int i1;
    if (FastColorFontHelper.jdField_a_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder().append(paramString).append("\n  text:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label436;
      }
      paramString = null;
      localStringBuilder = localStringBuilder.append(paramString).append("\n  fontId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label447;
      }
      paramString = null;
      paramString = localStringBuilder.append(paramString).append("\n  chars.length:");
      if (this.jdField_d_of_type_ArrayOfInt != null) {
        break label461;
      }
      i1 = 0;
      label84:
      paramString = paramString.append(i1).append("\n  bitmapWidth:");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label470;
      }
      i1 = -1;
      label105:
      paramString = paramString.append(i1).append("\n  bitmapHeight:");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label481;
      }
      i1 = i2;
      label126:
      localStringBuilder = paramString.append(i1).append("\n  viewWidth:").append(this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int).append("\n  viewHeight:").append(this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int).append("\n  paddingLeft:").append(this.jdField_e_of_type_Int).append("\n  paddingRight:").append(this.jdField_f_of_type_Int).append("\n  paddingTop:").append(this.jdField_g_of_type_Int).append("\n  paddingBottom:").append(this.jdField_h_of_type_Int).append("\n  screenWidth:").append(this.jdField_c_of_type_Int).append("\n  screenHeight:").append(this.jdField_d_of_type_Int).append("\n  rows:").append(this.t).append("\n  columns:").append(this.u).append("\n  x[]:").append(Arrays.toString(this.jdField_e_of_type_ArrayOfInt)).append("\n  y[]:").append(Arrays.toString(this.jdField_f_of_type_ArrayOfInt)).append("\n  width[]:").append(Arrays.toString(this.jdField_g_of_type_ArrayOfInt)).append("\n  height[]:").append(Arrays.toString(this.jdField_h_of_type_ArrayOfInt)).append("\n  mAnimationId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label492;
      }
      paramString = null;
      label362:
      localStringBuilder = localStringBuilder.append(paramString).append("\n  shouldDisplayAnimation:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label506;
      }
    }
    label436:
    label447:
    label461:
    label470:
    label481:
    label492:
    label506:
    for (paramString = localObject;; paramString = Boolean.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation))
    {
      FastColorFontLog.a("FounderColorLayout", paramString + "\n  frameIndex:" + this.jdField_a_of_type_Int + "\n  animInfo:" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + "\n");
      return;
      paramString = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText;
      break;
      paramString = Integer.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      break label62;
      i1 = this.jdField_d_of_type_ArrayOfInt.length;
      break label84;
      i1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      break label105;
      i1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      break label126;
      paramString = Long.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId);
      break label362;
    }
  }
  
  private boolean a()
  {
    a(this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int);
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    if (i2 <= 0) {
      return true;
    }
    if (this.s != i2) {
      this.jdField_d_of_type_ArrayOfInt = new int[i2];
    }
    if ((this.s < i2) || (this.s - i2 > 100))
    {
      this.jdField_e_of_type_ArrayOfInt = new int[i2];
      this.jdField_f_of_type_ArrayOfInt = new int[i2];
      this.jdField_g_of_type_ArrayOfInt = new int[i2];
      this.jdField_h_of_type_ArrayOfInt = new int[i2];
    }
    this.s = i2;
    this.jdField_d_of_type_Boolean = true;
    int i1 = 0;
    while (i1 < i2)
    {
      d locald = (d)this.jdField_c_of_type_JavaUtilList.get(i1);
      this.jdField_d_of_type_ArrayOfInt[i1] = locald.jdField_a_of_type_Char;
      this.jdField_e_of_type_ArrayOfInt[i1] = locald.jdField_d_of_type_Int;
      this.jdField_f_of_type_ArrayOfInt[i1] = locald.jdField_e_of_type_Int;
      this.jdField_g_of_type_ArrayOfInt[i1] = locald.jdField_b_of_type_Int;
      this.jdField_h_of_type_ArrayOfInt[i1] = locald.jdField_c_of_type_Int;
      if (locald.jdField_a_of_type_Int != 2) {
        this.jdField_d_of_type_Boolean = false;
      }
      i1 += 1;
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
      if (c1 == '\n')
      {
        this.p = this.q;
        this.m += 1;
        this.r = 0;
        this.l = Math.max(this.k, this.l);
        this.k = 0;
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
        if ((i2 == i5 - 1) && (paramBoolean)) {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
        }
        i2 += 1;
      }
      else
      {
        int i4 = 0;
        int i1 = 0;
        int i3 = i4;
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          int i6 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1 + i2);
          i3 = i4;
          if (i6 > 0)
          {
            i4 = 0;
            for (;;)
            {
              i3 = i1;
              if (i4 >= i6) {
                break;
              }
              i3 = this.jdField_c_of_type_ArrayOfInt[(paramInt1 + i2 + i4)];
              i4 += 1;
              i1 = i3 + i1;
            }
          }
        }
        paramRelativeSizeSpan = a();
        float f1;
        if (paramInt1 + i2 < this.jdField_c_of_type_ArrayOfInt.length)
        {
          f1 = this.jdField_c_of_type_ArrayOfInt[(paramInt1 + i2)];
          label261:
          paramRelativeSizeSpan.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt1 + i2));
          paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
          paramRelativeSizeSpan.jdField_b_of_type_Int = ((int)f1);
          if (!paramRelativeSizeSpan.jdField_a_of_type_Boolean) {
            break label543;
          }
          i1 = paramInt2;
          label303:
          paramRelativeSizeSpan.jdField_c_of_type_Int = ((int)(i1 * f2));
          paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
          if ((this.p >= paramRelativeSizeSpan.jdField_b_of_type_Int) && ((this.p >= i3) || (this.r == 0))) {
            break label550;
          }
          this.l = Math.max(this.k, this.l);
          this.k = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.m += 1;
          this.r = 0;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.r;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.m;
          this.r = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.p = (this.q - paramRelativeSizeSpan.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
          this.jdField_b_of_type_JavaUtilList = new ArrayList();
          this.jdField_b_of_type_JavaUtilList.add(paramRelativeSizeSpan);
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
        for (;;)
        {
          if (this.r > this.jdField_b_of_type_Int) {
            this.jdField_b_of_type_Int = this.r;
          }
          this.n += 1;
          if ((this.o <= 0) || (this.n < this.o)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
          return true;
          f1 = paramInt2 * f2;
          break label261;
          label543:
          i1 = paramInt4;
          break label303;
          label550:
          this.k += paramRelativeSizeSpan.jdField_b_of_type_Int;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.r;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.m;
          this.p -= paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.r += paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.jdField_b_of_type_JavaUtilList.add(paramRelativeSizeSpan);
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
      }
    }
    return false;
  }
  
  private boolean a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool = false;
    Rect localRect = paramEmoticonSpan.a().getBounds();
    d locald = a();
    locald.jdField_a_of_type_Char = 65535;
    locald.jdField_a_of_type_Boolean = false;
    locald.jdField_b_of_type_Int = localRect.width();
    locald.jdField_c_of_type_Int = localRect.height();
    locald.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    locald.jdField_a_of_type_Int = paramInt3;
    if (this.p < locald.jdField_b_of_type_Int)
    {
      this.l = Math.max(this.k, this.l);
      this.k = locald.jdField_b_of_type_Int;
      this.m += 1;
      this.r = 0;
      locald.jdField_d_of_type_Int = this.r;
      locald.jdField_f_of_type_Int = this.m;
      this.r = locald.jdField_b_of_type_Int;
      this.p = (this.q - locald.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_b_of_type_JavaUtilList.add(locald);
      this.jdField_c_of_type_JavaUtilList.add(locald);
      if (this.r > this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = this.r;
      }
      this.n += 1;
      if ((this.o <= 0) || (this.n < this.o)) {
        break label360;
      }
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      bool = true;
    }
    label360:
    while (!paramBoolean)
    {
      return bool;
      this.k += locald.jdField_b_of_type_Int;
      locald.jdField_d_of_type_Int = this.r;
      locald.jdField_f_of_type_Int = this.m;
      this.p -= locald.jdField_b_of_type_Int;
      this.r += locald.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaUtilList.add(locald);
      this.jdField_c_of_type_JavaUtilList.add(locald);
      break;
    }
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    boolean bool2 = false;
    int i5 = paramCharSequence.length();
    int i2 = 0;
    boolean bool1;
    char c1;
    for (;;)
    {
      bool1 = bool2;
      if (i2 >= i5) {
        break label535;
      }
      c1 = paramCharSequence.charAt(i2);
      if (c1 != '\n') {
        break;
      }
      this.p = this.q;
      this.m += 1;
      this.r = 0;
      this.l = Math.max(this.k, this.l);
      this.k = 0;
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      if ((i2 == i5 - 1) && (paramBoolean)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      }
      i2 += 1;
    }
    int i1;
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
    {
      int i6 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1 + i2);
      if (i6 > 0)
      {
        int i4 = 0;
        for (i1 = 0;; i1 = i3 + i1)
        {
          i3 = i1;
          if (i4 >= i6) {
            break;
          }
          i3 = this.jdField_c_of_type_ArrayOfInt[(paramInt1 + i2 + i4)];
          i4 += 1;
        }
      }
    }
    int i3 = 0;
    float f1;
    label249:
    d locald;
    if (paramInt1 + i2 < this.jdField_c_of_type_ArrayOfInt.length)
    {
      f1 = this.jdField_c_of_type_ArrayOfInt[(paramInt1 + i2)];
      locald = a();
      locald.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(paramInt1 + i2));
      locald.jdField_a_of_type_Int = paramInt3;
      locald.jdField_b_of_type_Int = ((int)f1);
      if (!locald.jdField_a_of_type_Boolean) {
        break label545;
      }
      i1 = paramInt2;
      label300:
      locald.jdField_c_of_type_Int = i1;
      locald.jdField_a_of_type_Char = c1;
      if ((this.p >= locald.jdField_b_of_type_Int) && ((this.p >= i3) || (this.r == 0))) {
        break label552;
      }
      this.l = Math.max(this.k, this.l);
      this.k = locald.jdField_b_of_type_Int;
      this.m += 1;
      this.r = 0;
      locald.jdField_d_of_type_Int = this.r;
      locald.jdField_f_of_type_Int = this.m;
      this.r = locald.jdField_b_of_type_Int;
      this.p = (this.q - locald.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      this.jdField_b_of_type_JavaUtilList.add(locald);
      this.jdField_c_of_type_JavaUtilList.add(locald);
    }
    for (;;)
    {
      if (this.r > this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = this.r;
      }
      this.n += 1;
      if ((this.o <= 0) || (this.n < this.o)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList);
      bool1 = true;
      label535:
      return bool1;
      f1 = paramInt2;
      break label249;
      label545:
      i1 = paramInt4;
      break label300;
      label552:
      this.k += locald.jdField_b_of_type_Int;
      locald.jdField_d_of_type_Int = this.r;
      locald.jdField_f_of_type_Int = this.m;
      this.p -= locald.jdField_b_of_type_Int;
      this.r += locald.jdField_b_of_type_Int;
      this.jdField_b_of_type_JavaUtilList.add(locald);
      this.jdField_c_of_type_JavaUtilList.add(locald);
    }
  }
  
  private void b(int paramInt1, int paramInt2) {}
  
  private boolean b()
  {
    return (this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int <= 0) || (this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int <= 0) || (this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int > this.jdField_c_of_type_Int) || (this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int > this.jdField_d_of_type_Int);
  }
  
  private void d()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_d_of_type_JavaUtilList == null) {
        this.jdField_d_of_type_JavaUtilList = new ArrayList();
      }
      if ((this.jdField_c_of_type_Int <= 0) || (this.jdField_d_of_type_Int <= 0))
      {
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getResources().getDisplayMetrics();
        this.jdField_c_of_type_Int = localDisplayMetrics.widthPixels;
        this.jdField_d_of_type_Int = localDisplayMetrics.heightPixels;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      }
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
        this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
      }
    }
  }
  
  private void e()
  {
    int i2 = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i1;
    label47:
    d locald;
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      int i3 = this.jdField_c_of_type_JavaUtilList.size();
      i1 = 0;
      if (i1 >= i3) {
        return;
      }
      locald = (d)this.jdField_c_of_type_JavaUtilList.get(i1);
      switch (locald.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      if (locald.jdField_a_of_type_Boolean) {
        a(this.jdField_a_of_type_AndroidGraphicsCanvas, locald);
      }
      i1 += 1;
      break label47;
      this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      Bitmap localBitmap = a(locald.jdField_b_of_type_Int, i2);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap, locald.jdField_d_of_type_Int, locald.jdField_e_of_type_Int + locald.jdField_c_of_type_Int - i2, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(locald.jdField_d_of_type_Int, locald.jdField_e_of_type_Int, locald.jdField_d_of_type_Int + locald.jdField_b_of_type_Int, locald.jdField_e_of_type_Int + locald.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsPaint);
      locald.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan.draw(this.jdField_a_of_type_AndroidGraphicsCanvas, null, 0, 0, locald.jdField_d_of_type_Int, locald.jdField_e_of_type_Int, locald.jdField_e_of_type_Int + locald.jdField_c_of_type_Int, locald.jdField_e_of_type_Int + locald.jdField_c_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      g();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    while (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.jdField_a_of_type_ArrayOfInt[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ArrayOfInt[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_ArrayOfInt[0] * this.jdField_a_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new b(this));
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilList.size())
    {
      d locald = (d)this.jdField_c_of_type_JavaUtilList.get(i1);
      if ((paramInt1 >= locald.jdField_d_of_type_Int) && (paramInt1 <= locald.jdField_d_of_type_Int + locald.jdField_b_of_type_Int) && (paramInt2 >= locald.jdField_e_of_type_Int))
      {
        int i2 = locald.jdField_e_of_type_Int;
        if (paramInt2 <= locald.jdField_c_of_type_Int + i2) {
          return i1;
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (b())) {}
    do
    {
      return;
      if (FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) < 3)
      {
        FastColorFontLog.b("FounderColorLayout", "当前字体未加载或不支持动画..." + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        return;
      }
      if ((this.t <= 0) || (this.t > 5) || (this.jdField_d_of_type_Boolean))
      {
        FastColorFontLog.b("FounderColorLayout", "0行或超过5行不支持播放动画..." + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    FastColorFontLog.a("FounderColorLayout", "StartAnimation......animInfo:" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt));
    if ((this.jdField_a_of_type_ArrayOfInt[0] > 0) && (this.jdField_a_of_type_ArrayOfInt[1] > 0))
    {
      f();
      return;
    }
    this.jdField_a_of_type_Int = 0;
    b(this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int);
    FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_f_of_type_ArrayOfInt, this.jdField_g_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int, this.t, this.u, this.v, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt);
    if ((this.jdField_a_of_type_ArrayOfInt[0] > 0) && (this.jdField_a_of_type_ArrayOfInt[1] > 0))
    {
      f();
      return;
    }
    FastColorFontLog.b("FounderColorLayout", "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt));
  }
  
  public boolean a(Canvas paramCanvas, long paramLong)
  {
    if (b())
    {
      FastColorFontLog.b("FounderColorLayout", "bitmap 宽高为0或超过屏幕尺寸  bitmap宽高[" + (this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int) + "," + (this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int) + "]，屏幕宽高：[" + this.jdField_c_of_type_Int + "," + this.jdField_d_of_type_Int + "]");
      return false;
    }
    if (a()) {
      return true;
    }
    long l1 = System.nanoTime();
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (!this.jdField_d_of_type_Boolean) && (FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) == 3) && (this.t > 0) && (this.t < 6))
    {
      b(this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int);
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_f_of_type_ArrayOfInt, this.jdField_g_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int, this.t, this.u, this.v, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt);
      e();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_e_of_type_Int, this.jdField_g_of_type_Int, null);
      if (this.jdField_a_of_type_Int == 0) {
        a();
      }
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        paramLong = System.nanoTime();
        FastColorFontLog.b("FounderColorLayout", "动画帧耗时 frameIndex:" + this.jdField_a_of_type_Int + "  行：" + this.t + "  列：" + this.u + "  耗时：" + (float)(paramLong - l1) / 1000000.0F + "ms");
        FastColorFontLog.a(this.t, (float)(paramLong - l1) / 1000000.0F);
        if (this.jdField_a_of_type_Int == 0) {
          a("drawAnimationText.....");
        }
      }
    }
    for (;;)
    {
      return true;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break;
      }
      if (this.jdField_d_of_type_ArrayOfInt.length > 0)
      {
        if (paramLong != this.jdField_b_of_type_Long)
        {
          this.jdField_b_of_type_Long = paramLong;
          if (this.jdField_d_of_type_ArrayOfInt.length > 0) {
            FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_f_of_type_ArrayOfInt, this.jdField_g_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, this.i - this.jdField_e_of_type_Int - this.jdField_f_of_type_Int, this.j - this.jdField_g_of_type_Int - this.jdField_h_of_type_Int);
          }
        }
        e();
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_e_of_type_Int, this.jdField_g_of_type_Int, null);
        if (jdField_a_of_type_Boolean) {
          a(paramCanvas);
        }
        if (FastColorFontHelper.jdField_a_of_type_Boolean)
        {
          a("drawText......");
          a(l1);
        }
      }
    }
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (this.jdField_c_of_type_Boolean == paramBoolean) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont))) {
      return this.jdField_b_of_type_ArrayOfInt;
    }
    if (this.jdField_a_of_type_Long != paramLong)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      }
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.g = false;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_b_of_type_Long = 0L;
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() != 8))
    {
      paramETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText();
      if (!TextUtils.isEmpty(paramETFont))
      {
        paramLong = System.nanoTime();
        a(paramInt1, paramInt2, paramETFont);
        long l1 = System.nanoTime();
        FastColorFontLog.a("FounderColorLayout", "字数：" + paramETFont.length() + "   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px   排版耗时：" + (float)(l1 - paramLong) / 1000000.0F + "ms");
        if (b())
        {
          this.jdField_b_of_type_ArrayOfInt[0] = 0;
          this.jdField_b_of_type_ArrayOfInt[1] = 0;
        }
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_ArrayOfInt;
      this.jdField_b_of_type_ArrayOfInt[0] = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
      this.jdField_b_of_type_ArrayOfInt[1] = View.MeasureSpec.makeMeasureSpec(this.j, 1073741824);
      continue;
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      this.jdField_b_of_type_ArrayOfInt[1] = 0;
      continue;
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      this.jdField_b_of_type_ArrayOfInt[1] = 0;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) && (this.jdField_a_of_type_Int > 0))
    {
      FastColorFontLog.a("FounderColorLayout", "PauseAnimation...... animInfo:" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + "  frameIndex:" + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (this.jdField_a_of_type_ArrayOfInt[0] <= 0) || (this.jdField_a_of_type_ArrayOfInt[1] <= 0)) {}
    while ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) || (this.jdField_a_of_type_Int <= 0) || (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ArrayOfInt[0])) {
      return;
    }
    FastColorFontLog.a("FounderColorLayout", "RestartAnimation...... animInfo:" + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + "  frameIndex:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = true;
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0] });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_a_of_type_Int) * this.jdField_a_of_type_ArrayOfInt[1]);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout
 * JD-Core Version:    0.7.0.1
 */