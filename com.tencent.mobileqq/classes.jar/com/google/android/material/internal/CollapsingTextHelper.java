package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class CollapsingTextHelper
{
  @NonNull
  private static final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private static final boolean jdField_a_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 16;
  private TimeInterpolator jdField_a_of_type_AndroidAnimationTimeInterpolator;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @NonNull
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  @NonNull
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  @NonNull
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private final View jdField_a_of_type_AndroidViewView;
  private CancelableFontCallback jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
  @Nullable
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float = 15.0F;
  private int jdField_b_of_type_Int = 16;
  private TimeInterpolator jdField_b_of_type_AndroidAnimationTimeInterpolator;
  private ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  @NonNull
  private final Rect jdField_b_of_type_AndroidGraphicsRect;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  @NonNull
  private final TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private CancelableFontCallback jdField_b_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
  @Nullable
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 15.0F;
  private int jdField_c_of_type_Int = 1;
  private ColorStateList jdField_c_of_type_AndroidContentResColorStateList;
  private Typeface jdField_c_of_type_AndroidGraphicsTypeface;
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private ColorStateList jdField_d_of_type_AndroidContentResColorStateList;
  private boolean jdField_d_of_type_Boolean;
  private float jdField_e_of_type_Float;
  private boolean jdField_e_of_type_Boolean;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private float v;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 18) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    jdField_a_of_type_AndroidGraphicsPaint = null;
    Paint localPaint = jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null)
    {
      localPaint.setAntiAlias(true);
      jdField_a_of_type_AndroidGraphicsPaint.setColor(-65281);
    }
  }
  
  public CollapsingTextHelper(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(129);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint(this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, @Nullable TimeInterpolator paramTimeInterpolator)
  {
    float f1 = paramFloat3;
    if (paramTimeInterpolator != null) {
      f1 = paramTimeInterpolator.getInterpolation(paramFloat3);
    }
    return AnimationUtils.a(paramFloat1, paramFloat2, f1);
  }
  
  private float a(int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.jdField_c_of_type_Boolean) {
          return this.jdField_b_of_type_AndroidGraphicsRect.right - a();
        }
        return this.jdField_b_of_type_AndroidGraphicsRect.left;
      }
      if (this.jdField_c_of_type_Boolean) {
        return this.jdField_b_of_type_AndroidGraphicsRect.left;
      }
      return this.jdField_b_of_type_AndroidGraphicsRect.right - a();
    }
    return paramInt1 / 2.0F - a() / 2.0F;
  }
  
  private float a(@NonNull RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 17) && ((paramInt2 & 0x7) != 1))
    {
      if (((paramInt2 & 0x800005) != 8388613) && ((paramInt2 & 0x5) != 5))
      {
        if (this.jdField_c_of_type_Boolean) {
          return this.jdField_b_of_type_AndroidGraphicsRect.right;
        }
        return paramRectF.left + a();
      }
      if (this.jdField_c_of_type_Boolean) {
        return paramRectF.left + a();
      }
      return this.jdField_b_of_type_AndroidGraphicsRect.right;
    }
    return paramInt1 / 2.0F + a() / 2.0F;
  }
  
  private static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = Color.alpha(paramInt1);
    float f3 = Color.alpha(paramInt2);
    float f4 = Color.red(paramInt1);
    float f5 = Color.red(paramInt2);
    float f6 = Color.green(paramInt1);
    float f7 = Color.green(paramInt2);
    float f8 = Color.blue(paramInt1);
    float f9 = Color.blue(paramInt2);
    return Color.argb((int)(f2 * f1 + f3 * paramFloat), (int)(f4 * f1 + f5 * paramFloat), (int)(f6 * f1 + f7 * paramFloat), (int)(f8 * f1 + f9 * paramFloat));
  }
  
  @ColorInt
  private int a(@Nullable ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return 0;
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt != null) {
      return paramColorStateList.getColorForState(arrayOfInt, 0);
    }
    return paramColorStateList.getDefaultColor();
  }
  
  private StaticLayout a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    try
    {
      StaticLayout localStaticLayout = StaticLayoutBuilderCompat.a(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, (int)paramFloat).a(TextUtils.TruncateAt.END).b(paramBoolean).a(Layout.Alignment.ALIGN_NORMAL).a(false).a(paramInt).a();
    }
    catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException localStaticLayoutBuilderCompatException)
    {
      Log.e("CollapsingTextHelper", localStaticLayoutBuilderCompatException.getCause().getMessage(), localStaticLayoutBuilderCompatException);
      localObject = null;
    }
    return (StaticLayout)Preconditions.checkNotNull(localObject);
  }
  
  private void a(@NonNull Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i1 = this.jdField_a_of_type_AndroidTextTextPaint.getAlpha();
    paramCanvas.translate(paramFloat1, paramFloat2);
    Object localObject = this.jdField_a_of_type_AndroidTextTextPaint;
    paramFloat1 = this.u;
    paramFloat2 = i1;
    ((TextPaint)localObject).setAlpha((int)(paramFloat1 * paramFloat2));
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha((int)(this.t * paramFloat2));
    int i2 = this.jdField_a_of_type_AndroidTextStaticLayout.getLineBaseline(0);
    localObject = this.jdField_c_of_type_JavaLangCharSequence;
    int i3 = ((CharSequence)localObject).length();
    paramFloat1 = i2;
    paramCanvas.drawText((CharSequence)localObject, 0, i3, 0.0F, paramFloat1, this.jdField_a_of_type_AndroidTextTextPaint);
    String str = this.jdField_c_of_type_JavaLangCharSequence.toString().trim();
    localObject = str;
    if (str.endsWith("…")) {
      localObject = str.substring(0, str.length() - 1);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAlpha(i1);
    paramCanvas.drawText((String)localObject, 0, Math.min(this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(0), ((String)localObject).length()), 0.0F, paramFloat1, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  private void a(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.jdField_b_of_type_Float);
    paramTextPaint.setTypeface(this.jdField_b_of_type_AndroidGraphicsTypeface);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(this.s);
    }
  }
  
  private static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001F;
  }
  
  private static boolean a(@NonNull Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramRect.left == paramInt1) && (paramRect.top == paramInt2) && (paramRect.right == paramInt3) && (paramRect.bottom == paramInt4);
  }
  
  private boolean a(Typeface paramTypeface)
  {
    CancelableFontCallback localCancelableFontCallback = this.jdField_b_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != paramTypeface)
    {
      this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
      return true;
    }
    return false;
  }
  
  private boolean a(@NonNull CharSequence paramCharSequence)
  {
    TextDirectionHeuristicCompat localTextDirectionHeuristicCompat;
    if (c()) {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
    } else {
      localTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    }
    return localTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  @ColorInt
  private int b()
  {
    return a(this.jdField_a_of_type_AndroidContentResColorStateList);
  }
  
  private void b(@NonNull TextPaint paramTextPaint)
  {
    paramTextPaint.setTextSize(this.jdField_c_of_type_Float);
    paramTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    if (Build.VERSION.SDK_INT >= 21) {
      paramTextPaint.setLetterSpacing(this.r);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Int > 1) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean);
  }
  
  private boolean b(Typeface paramTypeface)
  {
    CancelableFontCallback localCancelableFontCallback = this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    if (this.jdField_b_of_type_AndroidGraphicsTypeface != paramTypeface)
    {
      this.jdField_b_of_type_AndroidGraphicsTypeface = paramTypeface;
      return true;
    }
    return false;
  }
  
  private void c()
  {
    c(this.jdField_a_of_type_Float);
  }
  
  private void c(float paramFloat)
  {
    d(paramFloat);
    this.h = a(this.f, this.g, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
    this.i = a(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
    g(a(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramFloat, this.jdField_b_of_type_AndroidAnimationTimeInterpolator));
    e(1.0F - a(0.0F, 1.0F, 1.0F - paramFloat, AnimationUtils.jdField_b_of_type_AndroidAnimationTimeInterpolator));
    f(a(1.0F, 0.0F, paramFloat, AnimationUtils.jdField_b_of_type_AndroidAnimationTimeInterpolator));
    if (this.jdField_b_of_type_AndroidContentResColorStateList != this.jdField_a_of_type_AndroidContentResColorStateList) {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(a(b(), a(), paramFloat));
    } else {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(a());
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      float f1 = this.r;
      float f2 = this.s;
      if (f1 != f2) {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(a(f2, f1, paramFloat, AnimationUtils.jdField_b_of_type_AndroidAnimationTimeInterpolator));
      } else {
        this.jdField_a_of_type_AndroidTextTextPaint.setLetterSpacing(f1);
      }
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(a(this.o, this.l, paramFloat, null), a(this.p, this.m, paramFloat, null), a(this.q, this.n, paramFloat, null), a(a(this.jdField_d_of_type_AndroidContentResColorStateList), a(this.jdField_c_of_type_AndroidContentResColorStateList), paramFloat));
    ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_AndroidViewView);
  }
  
  private boolean c()
  {
    return ViewCompat.getLayoutDirection(this.jdField_a_of_type_AndroidViewView) == 1;
  }
  
  private void d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void d(float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.left = a(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.left, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = a(this.jdField_d_of_type_Float, this.jdField_e_of_type_Float, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = a(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_b_of_type_AndroidGraphicsRect.right, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = a(this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsRect.bottom, paramFloat, this.jdField_a_of_type_AndroidAnimationTimeInterpolator);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) && (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()))
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangCharSequence)) {
        return;
      }
      c(0.0F);
      int i1 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth();
      int i2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      if (i1 > 0)
      {
        if (i2 <= 0) {
          return;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(localCanvas);
        if (this.jdField_b_of_type_AndroidGraphicsPaint == null) {
          this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(3);
        }
      }
    }
  }
  
  private void e(float paramFloat)
  {
    this.t = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void f()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  private void f(float paramFloat)
  {
    this.u = paramFloat;
    ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void g(float paramFloat)
  {
    h(paramFloat);
    boolean bool;
    if ((jdField_a_of_type_Boolean) && (this.j != 1.0F)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_d_of_type_Boolean = bool;
    if (this.jdField_d_of_type_Boolean) {
      e();
    }
    ViewCompat.postInvalidateOnAnimation(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void h(float paramFloat)
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      return;
    }
    float f2 = this.jdField_b_of_type_AndroidGraphicsRect.width();
    float f3 = this.jdField_a_of_type_AndroidGraphicsRect.width();
    boolean bool2 = a(paramFloat, this.jdField_c_of_type_Float);
    boolean bool1 = false;
    int i3 = 1;
    float f1;
    Object localObject;
    Typeface localTypeface;
    int i1;
    if (bool2)
    {
      f1 = this.jdField_c_of_type_Float;
      this.j = 1.0F;
      localObject = this.jdField_c_of_type_AndroidGraphicsTypeface;
      localTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
      if (localObject != localTypeface)
      {
        this.jdField_c_of_type_AndroidGraphicsTypeface = localTypeface;
        i1 = 1;
        paramFloat = f2;
      }
      else
      {
        i1 = 0;
        paramFloat = f2;
      }
    }
    else
    {
      f1 = this.jdField_b_of_type_Float;
      localObject = this.jdField_c_of_type_AndroidGraphicsTypeface;
      localTypeface = this.jdField_b_of_type_AndroidGraphicsTypeface;
      if (localObject != localTypeface)
      {
        this.jdField_c_of_type_AndroidGraphicsTypeface = localTypeface;
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (a(paramFloat, this.jdField_b_of_type_Float)) {
        this.j = 1.0F;
      } else {
        this.j = (paramFloat / this.jdField_b_of_type_Float);
      }
      paramFloat = this.jdField_c_of_type_Float / this.jdField_b_of_type_Float;
      if (f3 * paramFloat > f2) {
        paramFloat = Math.min(f2 / paramFloat, f3);
      } else {
        paramFloat = f3;
      }
    }
    int i2 = i1;
    if (paramFloat > 0.0F)
    {
      if ((this.k == f1) && (!this.jdField_e_of_type_Boolean) && (i1 == 0)) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      this.k = f1;
      this.jdField_e_of_type_Boolean = false;
      i2 = i1;
    }
    if ((this.jdField_b_of_type_JavaLangCharSequence == null) || (i2 != 0))
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.k);
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_c_of_type_AndroidGraphicsTypeface);
      localObject = this.jdField_a_of_type_AndroidTextTextPaint;
      if (this.j != 1.0F) {
        bool1 = true;
      }
      ((TextPaint)localObject).setLinearText(bool1);
      this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_JavaLangCharSequence);
      i1 = i3;
      if (b()) {
        i1 = this.jdField_c_of_type_Int;
      }
      this.jdField_a_of_type_AndroidTextStaticLayout = a(i1, paramFloat, this.jdField_c_of_type_Boolean);
      this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidTextStaticLayout.getText();
    }
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_JavaLangCharSequence == null) {
      return 0.0F;
    }
    b(this.jdField_b_of_type_AndroidTextTextPaint);
    TextPaint localTextPaint = this.jdField_b_of_type_AndroidTextTextPaint;
    CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
    return localTextPaint.measureText(localCharSequence, 0, localCharSequence.length());
  }
  
  @ColorInt
  public int a()
  {
    return a(this.jdField_b_of_type_AndroidContentResColorStateList);
  }
  
  public ColorStateList a()
  {
    return this.jdField_b_of_type_AndroidContentResColorStateList;
  }
  
  @Nullable
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  void a()
  {
    boolean bool;
    if ((this.jdField_b_of_type_AndroidGraphicsRect.width() > 0) && (this.jdField_b_of_type_AndroidGraphicsRect.height() > 0) && (this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) && (this.jdField_a_of_type_AndroidGraphicsRect.height() > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_b_of_type_Boolean = bool;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_b_of_type_Float != paramFloat)
    {
      this.jdField_b_of_type_Float = paramFloat;
      b();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.jdField_a_of_type_AndroidGraphicsRect, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.jdField_e_of_type_Boolean = true;
      a();
    }
  }
  
  public void a(TimeInterpolator paramTimeInterpolator)
  {
    this.jdField_b_of_type_AndroidAnimationTimeInterpolator = paramTimeInterpolator;
    b();
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_b_of_type_AndroidContentResColorStateList = paramColorStateList;
      b();
    }
  }
  
  public void a(@NonNull Canvas paramCanvas)
  {
    int i3 = paramCanvas.save();
    if ((this.jdField_b_of_type_JavaLangCharSequence != null) && (this.jdField_b_of_type_Boolean))
    {
      float f1 = this.h;
      StaticLayout localStaticLayout = this.jdField_a_of_type_AndroidTextStaticLayout;
      int i2 = 0;
      float f2 = localStaticLayout.getLineLeft(0);
      float f3 = this.v;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.k);
      float f4 = this.h;
      float f5 = this.i;
      int i1 = i2;
      if (this.jdField_d_of_type_Boolean)
      {
        i1 = i2;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
          i1 = 1;
        }
      }
      float f6 = this.j;
      if (f6 != 1.0F) {
        paramCanvas.scale(f6, f6, f4, f5);
      }
      if (i1 != 0)
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, f4, f5, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.restoreToCount(i3);
        return;
      }
      if (b())
      {
        a(paramCanvas, f1 + f2 - f3 * 2.0F, f5);
      }
      else
      {
        paramCanvas.translate(f4, f5);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i3);
    }
  }
  
  public void a(@NonNull Rect paramRect)
  {
    a(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void a(@NonNull RectF paramRectF, int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = a(this.jdField_a_of_type_JavaLangCharSequence);
    paramRectF.left = a(paramInt1, paramInt2);
    paramRectF.top = this.jdField_b_of_type_AndroidGraphicsRect.top;
    paramRectF.right = a(paramRectF, paramInt1, paramInt2);
    paramRectF.bottom = (this.jdField_b_of_type_AndroidGraphicsRect.top + c());
  }
  
  public void a(Typeface paramTypeface)
  {
    if (a(paramTypeface)) {
      b();
    }
  }
  
  public void a(@Nullable CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangCharSequence, paramCharSequence)))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      this.jdField_b_of_type_JavaLangCharSequence = null;
      f();
      b();
    }
  }
  
  public final boolean a()
  {
    ColorStateList localColorStateList = this.jdField_b_of_type_AndroidContentResColorStateList;
    if ((localColorStateList == null) || (!localColorStateList.isStateful())) {
      localColorStateList = this.jdField_a_of_type_AndroidContentResColorStateList;
    }
    return (localColorStateList != null) && (localColorStateList.isStateful());
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    if (a())
    {
      b();
      return true;
    }
    return false;
  }
  
  public float b()
  {
    a(this.jdField_b_of_type_AndroidTextTextPaint);
    return -this.jdField_b_of_type_AndroidTextTextPaint.ascent();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidViewView.getHeight() > 0) && (this.jdField_a_of_type_AndroidViewView.getWidth() > 0))
    {
      d();
      c();
    }
  }
  
  public void b(float paramFloat)
  {
    paramFloat = MathUtils.clamp(paramFloat, 0.0F, 1.0F);
    if (paramFloat != this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_Float = paramFloat;
      c();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      b();
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!a(this.jdField_b_of_type_AndroidGraphicsRect, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      this.jdField_e_of_type_Boolean = true;
      a();
    }
  }
  
  public void b(TimeInterpolator paramTimeInterpolator)
  {
    this.jdField_a_of_type_AndroidAnimationTimeInterpolator = paramTimeInterpolator;
    b();
  }
  
  public void b(ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      b();
    }
  }
  
  public void b(@NonNull Rect paramRect)
  {
    b(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public void b(Typeface paramTypeface)
  {
    if (b(paramTypeface)) {
      b();
    }
  }
  
  public float c()
  {
    b(this.jdField_b_of_type_AndroidTextTextPaint);
    return -this.jdField_b_of_type_AndroidTextTextPaint.ascent();
  }
  
  public void c(int paramInt)
  {
    TextAppearance localTextAppearance = new TextAppearance(this.jdField_a_of_type_AndroidViewView.getContext(), paramInt);
    if (localTextAppearance.jdField_a_of_type_AndroidContentResColorStateList != null) {
      this.jdField_b_of_type_AndroidContentResColorStateList = localTextAppearance.jdField_a_of_type_AndroidContentResColorStateList;
    }
    if (localTextAppearance.jdField_e_of_type_Float != 0.0F) {
      this.jdField_c_of_type_Float = localTextAppearance.jdField_e_of_type_Float;
    }
    if (localTextAppearance.jdField_d_of_type_AndroidContentResColorStateList != null) {
      this.jdField_c_of_type_AndroidContentResColorStateList = localTextAppearance.jdField_d_of_type_AndroidContentResColorStateList;
    }
    this.m = localTextAppearance.jdField_a_of_type_Float;
    this.n = localTextAppearance.jdField_b_of_type_Float;
    this.l = localTextAppearance.jdField_c_of_type_Float;
    this.r = localTextAppearance.jdField_d_of_type_Float;
    CancelableFontCallback localCancelableFontCallback = this.jdField_b_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    this.jdField_b_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback = new CancelableFontCallback(new CollapsingTextHelper.1(this), localTextAppearance.a());
    localTextAppearance.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_b_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback);
    b();
  }
  
  public void c(Typeface paramTypeface)
  {
    boolean bool1 = a(paramTypeface);
    boolean bool2 = b(paramTypeface);
    if ((bool1) || (bool2)) {
      b();
    }
  }
  
  public float d()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void d(int paramInt)
  {
    TextAppearance localTextAppearance = new TextAppearance(this.jdField_a_of_type_AndroidViewView.getContext(), paramInt);
    if (localTextAppearance.jdField_a_of_type_AndroidContentResColorStateList != null) {
      this.jdField_a_of_type_AndroidContentResColorStateList = localTextAppearance.jdField_a_of_type_AndroidContentResColorStateList;
    }
    if (localTextAppearance.jdField_e_of_type_Float != 0.0F) {
      this.jdField_b_of_type_Float = localTextAppearance.jdField_e_of_type_Float;
    }
    if (localTextAppearance.jdField_d_of_type_AndroidContentResColorStateList != null) {
      this.jdField_d_of_type_AndroidContentResColorStateList = localTextAppearance.jdField_d_of_type_AndroidContentResColorStateList;
    }
    this.p = localTextAppearance.jdField_a_of_type_Float;
    this.q = localTextAppearance.jdField_b_of_type_Float;
    this.o = localTextAppearance.jdField_c_of_type_Float;
    this.s = localTextAppearance.jdField_d_of_type_Float;
    CancelableFontCallback localCancelableFontCallback = this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback;
    if (localCancelableFontCallback != null) {
      localCancelableFontCallback.a();
    }
    this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback = new CancelableFontCallback(new CollapsingTextHelper.2(this), localTextAppearance.a());
    localTextAppearance.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComGoogleAndroidMaterialResourcesCancelableFontCallback);
    b();
  }
  
  public void e(int paramInt)
  {
    if (paramInt != this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = paramInt;
      f();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.CollapsingTextHelper
 * JD-Core Version:    0.7.0.1
 */