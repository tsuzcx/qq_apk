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
  protected int a;
  private long jdField_a_of_type_Long;
  protected Paint a;
  protected Path a;
  private ExpressionLayout.SpanComparator jdField_a_of_type_ComVasColorFontExpressionLayout$SpanComparator;
  private final IETextView jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private List<List<ModelFastColorFont>> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  protected int[] a;
  protected int b;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private List<ModelFastColorFont> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  protected int[] b;
  protected int c;
  private Canvas jdField_c_of_type_AndroidGraphicsCanvas;
  private List<ModelFastColorFont> jdField_c_of_type_JavaUtilList;
  protected int[] c;
  protected int d;
  private List<ModelFastColorFont> d;
  protected int[] d;
  protected int[] e;
  private int f;
  protected int[] f;
  private int g;
  protected int[] g;
  private int h;
  protected int[] h;
  private int i;
  private int jdField_j_of_type_Int;
  private int[] jdField_j_of_type_ArrayOfInt = new int[2];
  private int jdField_k_of_type_Int;
  private int[] jdField_k_of_type_ArrayOfInt;
  private int jdField_l_of_type_Int;
  private int[] jdField_l_of_type_ArrayOfInt;
  private int[] m;
  
  public ExpressionLayout(View paramView, ETFont paramETFont)
  {
    this.jdField_h_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView = ((IETextView)paramView);
    this.jdField_a_of_type_ComVasColorFontExpressionLayout$SpanComparator = new ExpressionLayout.SpanComparator();
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  }
  
  private ModelFastColorFont a()
  {
    if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
      return new ModelFastColorFont();
    }
    return (ModelFastColorFont)this.jdField_d_of_type_JavaUtilList.remove(0);
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    j();
    int n = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((n != -2147483648) && (n != 1073741824)) {
      this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getETMaxWidth();
    } else {
      this.jdField_j_of_type_Int = Math.min(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getETMaxWidth(), paramInt1);
    }
    this.jdField_g_of_type_Int = (this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
    this.jdField_k_of_type_Int = 0;
    int i3 = paramCharSequence.length();
    n = this.jdField_d_of_type_JavaUtilList.size();
    if ((n < i3) && (!this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      while (n < i3)
      {
        if (!this.jdField_c_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList.remove(0));
        }
        n += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_k_of_type_ArrayOfInt = new int[i3];
    Object localObject1 = new int[i3];
    n = 0;
    while (n < i3)
    {
      localObject1[n] = paramCharSequence.charAt(n);
      n += 1;
    }
    float f2 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize();
    int i5 = (int)f2;
    FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (int[])localObject1, i5, this.jdField_k_of_type_ArrayOfInt);
    n = 0;
    int i2;
    int i1;
    while (n < i3)
    {
      i2 = this.jdField_k_of_type_ArrayOfInt[n];
      i1 = i2;
      if (i2 <= 0)
      {
        float f1 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint().measureText(String.valueOf((char)localObject1[n]));
        if (f1 <= 0.0F) {
          f1 = i5;
        }
        i1 = (int)(f1 * FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(n));
      }
      this.jdField_k_of_type_ArrayOfInt[n] = i1;
      n += 1;
    }
    Object localObject2;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject1 = (Spanned)paramCharSequence;
      localObject2 = (CharacterStyle[])((Spanned)localObject1).getSpans(0, ((Spanned)localObject1).length(), CharacterStyle.class);
      this.jdField_a_of_type_ComVasColorFontExpressionLayout$SpanComparator.a((Spanned)localObject1);
      Arrays.sort((Object[])localObject2, this.jdField_a_of_type_ComVasColorFontExpressionLayout$SpanComparator);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    this.jdField_f_of_type_Int = ((int)(FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
    this.jdField_l_of_type_Int = ((int)(f2 * FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
    if ((localObject1 != null) && (localObject2.length > 0))
    {
      i1 = 0;
      n = 0;
      while (n < localObject2.length)
      {
        Object localObject3 = localObject2[n];
        int i4 = ((Spanned)localObject1).getSpanStart(localObject3);
        i3 = ((Spanned)localObject1).getSpanEnd(localObject3);
        if (i3 == ((Spanned)localObject1).length()) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((i4 > i1) && (i3 > i4)) {
          a(null, ETLayout.a(paramCharSequence, i1, i4), i1, i5, 0, this.jdField_l_of_type_Int);
        }
        i1 = i3;
        if ((localObject3 instanceof ClickableSpan)) {
          a(null, ETLayout.a(paramCharSequence, i4, i1), i4, i5, 1, this.jdField_l_of_type_Int);
        } else if ((!(localObject3 instanceof EmoticonSpan)) && (!(localObject3 instanceof SignatureActionSpan)))
        {
          if ((localObject3 instanceof RelativeSizeSpan))
          {
            a((RelativeSizeSpan)localObject3, ETLayout.a(paramCharSequence, i4, i1), i4, i5, 3, this.jdField_l_of_type_Int);
          }
          else
          {
            localObject3 = a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Un Know CharacterStyle   start:");
            localStringBuilder.append(i4);
            localStringBuilder.append("  end:");
            localStringBuilder.append(i1);
            FastColorFontLog.b((String)localObject3, localStringBuilder.toString());
          }
        }
        else {
          a((CharacterStyle)localObject3);
        }
        if ((n == localObject2.length - 1) && (i2 == 0)) {
          a(null, ETLayout.a(paramCharSequence, i1, ((Spanned)localObject1).length()), i1, i5, 0, this.jdField_l_of_type_Int);
        }
        n += 1;
      }
    }
    else
    {
      a(null, paramCharSequence, 0, i5, 0, this.jdField_l_of_type_Int);
    }
    k();
    this.m = FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_ArrayOfInt, this.jdField_g_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId);
    paramCharSequence = this.m;
    if ((paramCharSequence != null) && (paramCharSequence.length >= 2))
    {
      this.jdField_j_of_type_Int = (paramCharSequence[0] + this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
      this.jdField_k_of_type_Int = (paramCharSequence[1] + this.jdField_c_of_type_Int + this.jdField_d_of_type_Int);
      l();
      return;
    }
    this.jdField_j_of_type_Int = paramInt1;
    this.jdField_k_of_type_Int = View.MeasureSpec.getSize(paramInt2);
  }
  
  private boolean a()
  {
    int n = this.jdField_j_of_type_Int;
    int i1 = this.jdField_a_of_type_Int;
    int i2 = this.jdField_b_of_type_Int;
    int i3 = 1;
    if (n - i1 - i2 <= 0) {
      n = 1;
    } else {
      n = 0;
    }
    if (this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int > this.jdField_h_of_type_Int) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= this.jdField_i_of_type_Int) {
      i3 = 0;
    }
    return n | 0x0 | i1 | i2 | i3;
  }
  
  private boolean a(CharacterStyle paramCharacterStyle)
  {
    int i1;
    int n;
    if ((paramCharacterStyle instanceof EmoticonSpan))
    {
      localObject = ((EmoticonSpan)paramCharacterStyle).getDrawable().getBounds();
      i1 = ((Rect)localObject).width();
      n = ((Rect)localObject).height();
    }
    else if ((paramCharacterStyle instanceof SignatureActionSpan))
    {
      localObject = (SignatureActionSpan)paramCharacterStyle;
      i1 = ((SignatureActionSpan)localObject).a();
      n = ((SignatureActionSpan)localObject).b();
    }
    else
    {
      n = 0;
      i1 = 0;
    }
    Object localObject = a();
    ((ModelFastColorFont)localObject).jdField_a_of_type_Char = 65535;
    ((ModelFastColorFont)localObject).jdField_a_of_type_Boolean = false;
    ((ModelFastColorFont)localObject).jdField_b_of_type_Int = i1;
    ((ModelFastColorFont)localObject).jdField_c_of_type_Int = n;
    ((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
    ((ModelFastColorFont)localObject).jdField_a_of_type_Int = 2;
    this.jdField_c_of_type_JavaUtilList.add(localObject);
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
    int i1 = paramCharSequence.length();
    int n = 0;
    while (n < i1)
    {
      char c1 = paramCharSequence.charAt(n);
      int i2 = paramInt1 + n;
      paramRelativeSizeSpan = this.jdField_k_of_type_ArrayOfInt;
      float f1;
      if (i2 < paramRelativeSizeSpan.length) {
        f1 = paramRelativeSizeSpan[i2];
      } else {
        f1 = paramInt2;
      }
      if (f1 <= 0.0F) {
        f1 = paramInt2;
      }
      i2 = (int)(f1 * FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
      paramRelativeSizeSpan = a();
      paramRelativeSizeSpan.jdField_a_of_type_Boolean = false;
      paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
      paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
      if (c1 == '\n')
      {
        paramRelativeSizeSpan.jdField_b_of_type_Int = i2;
        paramRelativeSizeSpan.jdField_c_of_type_Int = paramInt4;
      }
      else
      {
        paramRelativeSizeSpan.jdField_b_of_type_Int = ((int)(i2 * f2));
        paramRelativeSizeSpan.jdField_c_of_type_Int = ((int)(paramInt4 * f2));
      }
      this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
      n += 1;
    }
    return true;
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (!a(this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int)) {
      return false;
    }
    if (this.jdField_c_of_type_JavaUtilList.size() <= 0) {
      return false;
    }
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int n = 0;
    int i1 = 1;
    while (n < i2)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_c_of_type_JavaUtilList.get(n);
      this.jdField_a_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_c_of_type_Int;
      if (localModelFastColorFont.jdField_a_of_type_Int != 2) {
        i1 = 0;
      }
      n += 1;
    }
    return i1 == 0;
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    if ((this.jdField_h_of_type_Int <= 0) || (this.jdField_i_of_type_Int <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getResources().getDisplayMetrics();
      this.jdField_h_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_i_of_type_Int = localDisplayMetrics.heightPixels;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingRight();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingBottom();
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  private void k()
  {
    int i1 = this.jdField_c_of_type_JavaUtilList.size();
    this.jdField_a_of_type_ArrayOfInt = new int[i1];
    this.jdField_b_of_type_ArrayOfInt = new int[i1];
    this.jdField_c_of_type_ArrayOfInt = new int[i1];
    this.jdField_d_of_type_ArrayOfInt = new int[i1];
    this.jdField_e_of_type_ArrayOfInt = new int[i1];
    this.jdField_l_of_type_ArrayOfInt = new int[i1];
    this.jdField_f_of_type_ArrayOfInt = new int[i1];
    this.jdField_g_of_type_ArrayOfInt = new int[i1];
    int n = 0;
    while (n < i1)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_c_of_type_JavaUtilList.get(n);
      this.jdField_a_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[n] = localModelFastColorFont.jdField_c_of_type_Int;
      this.jdField_l_of_type_ArrayOfInt[n] = 0;
      if (localModelFastColorFont.jdField_a_of_type_Char == 65535) {
        this.jdField_l_of_type_ArrayOfInt[n] = 2;
      }
      if (localModelFastColorFont.jdField_a_of_type_Char == '\n') {
        this.jdField_l_of_type_ArrayOfInt[n] = 3;
      }
      n += 1;
    }
  }
  
  private void l()
  {
    int n = 0;
    while (n < this.jdField_a_of_type_ArrayOfInt.length)
    {
      ModelFastColorFont localModelFastColorFont1 = (ModelFastColorFont)this.jdField_c_of_type_JavaUtilList.get(n);
      if (this.jdField_l_of_type_ArrayOfInt[n] == 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(n));
        localModelFastColorFont1.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_f_of_type_ArrayOfInt[n] >= this.jdField_a_of_type_JavaUtilList.size())
      {
        i1 = this.jdField_a_of_type_JavaUtilList.size();
        while (i1 <= this.jdField_f_of_type_ArrayOfInt[n])
        {
          this.jdField_a_of_type_JavaUtilList.add(i1, new ArrayList());
          i1 += 1;
        }
      }
      List localList = (List)this.jdField_a_of_type_JavaUtilList.get(this.jdField_f_of_type_ArrayOfInt[n]);
      ModelFastColorFont localModelFastColorFont2 = a();
      int i1 = this.jdField_b_of_type_ArrayOfInt[n];
      int[] arrayOfInt1 = this.jdField_d_of_type_ArrayOfInt;
      localModelFastColorFont2.jdField_d_of_type_Int = (i1 - arrayOfInt1[n] / 2);
      i1 = this.jdField_c_of_type_ArrayOfInt[n];
      int[] arrayOfInt2 = this.jdField_e_of_type_ArrayOfInt;
      localModelFastColorFont2.jdField_e_of_type_Int = (i1 - arrayOfInt2[n] / 2);
      localModelFastColorFont2.jdField_b_of_type_Int = arrayOfInt1[n];
      localModelFastColorFont2.jdField_c_of_type_Int = arrayOfInt2[n];
      localModelFastColorFont2.jdField_a_of_type_Char = localModelFastColorFont1.jdField_a_of_type_Char;
      localModelFastColorFont2.jdField_a_of_type_Boolean = localModelFastColorFont1.jdField_a_of_type_Boolean;
      localModelFastColorFont2.jdField_a_of_type_AndroidTextStyleCharacterStyle = localModelFastColorFont1.jdField_a_of_type_AndroidTextStyleCharacterStyle;
      localModelFastColorFont2.jdField_a_of_type_Int = localModelFastColorFont1.jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaUtilList.add(localModelFastColorFont2);
      localList.add(this.jdField_g_of_type_ArrayOfInt[n], localModelFastColorFont2);
      n += 1;
    }
  }
  
  private void m()
  {
    Object localObject = this.jdField_c_of_type_AndroidGraphicsCanvas;
    if (localObject == null) {
      this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    } else {
      ((Canvas)localObject).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
    }
    int n = 2;
    for (;;)
    {
      localObject = this.m;
      if (n >= localObject.length) {
        break;
      }
      int i1 = localObject[n];
      int i2 = localObject[(n + 1)];
      int i3 = localObject[(n + 2)];
      int i4 = localObject[(n + 3)];
      i4 = localObject[(n + 4)];
      localObject = (ModelFastColorFont)this.jdField_c_of_type_JavaUtilList.get(i1);
      Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
      float f1 = i4;
      localPaint.setTextSize(f1);
      f1 /= 2.0F;
      float f2 = (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
      this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(((ModelFastColorFont)localObject).jdField_a_of_type_Char), i2, i3 + (f1 - f2), this.jdField_b_of_type_AndroidGraphicsPaint);
      n += 5;
    }
  }
  
  private void n()
  {
    int i1 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize() / 15.0F);
    Object localObject = this.jdField_b_of_type_AndroidGraphicsCanvas;
    if (localObject == null) {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    } else {
      ((Canvas)localObject).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int n = 0;
    while (n < i2)
    {
      localObject = (ModelFastColorFont)this.jdField_c_of_type_JavaUtilList.get(n);
      int i4 = this.jdField_d_of_type_ArrayOfInt[n];
      int i5 = this.jdField_e_of_type_ArrayOfInt[n];
      int i6 = this.jdField_b_of_type_ArrayOfInt[n] - i4 / 2;
      int i3 = this.jdField_c_of_type_ArrayOfInt[n] - i5 / 2;
      int i7 = ((ModelFastColorFont)localObject).jdField_a_of_type_Int;
      if (i7 != 1)
      {
        if (i7 == 2) {
          if ((((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof EmoticonSpan))
          {
            localObject = (EmoticonSpan)((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
            Canvas localCanvas = this.jdField_b_of_type_AndroidGraphicsCanvas;
            float f1 = i6;
            i4 = i3 + i5;
            ((EmoticonSpan)localObject).draw(localCanvas, null, 0, 0, f1, i3, i4, i4, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
          else if ((((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof SignatureActionSpan))
          {
            localObject = (SignatureActionSpan)((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
            ((SignatureActionSpan)localObject).jdField_a_of_type_Boolean = false;
            ((SignatureActionSpan)localObject).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, i6, i3, i3, i3 + i5, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
        }
      }
      else
      {
        localObject = a(i4, i1);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, i6, i3 + i5 - i1, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
      }
      n += 1;
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(this.jdField_h_of_type_ArrayOfInt);
    Object localObject1 = this.jdField_h_of_type_ArrayOfInt;
    int i2 = 0;
    int i3 = paramInt1 - localObject1[0];
    int i4 = paramInt2 - localObject1[1];
    paramInt2 = this.jdField_b_of_type_JavaUtilList.size();
    paramInt1 = 0;
    int n;
    int i1;
    while (paramInt1 < paramInt2)
    {
      localObject1 = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(paramInt1);
      n = this.jdField_a_of_type_Int;
      i1 = ((ModelFastColorFont)localObject1).jdField_d_of_type_Int;
      int i5 = this.jdField_c_of_type_Int;
      int i6 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
      int i7 = this.jdField_a_of_type_Int;
      int i8 = ((ModelFastColorFont)localObject1).jdField_d_of_type_Int;
      int i9 = ((ModelFastColorFont)localObject1).jdField_b_of_type_Int;
      int i10 = this.jdField_c_of_type_Int;
      int i11 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
      int i12 = ((ModelFastColorFont)localObject1).jdField_c_of_type_Int;
      if ((i3 >= n + i1) && (i3 <= i7 + i8 + i9) && (i4 >= i5 + i6) && (i4 <= i10 + i11 + i12)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    paramInt2 = 0;
    for (paramInt1 = 0; paramInt2 < this.jdField_a_of_type_JavaUtilList.size(); paramInt1 = n)
    {
      localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      n = paramInt1;
      if (localObject1 != null) {
        if (((List)localObject1).size() <= 0)
        {
          n = paramInt1;
        }
        else
        {
          Object localObject2 = ((List)localObject1).iterator();
          n = 0;
          while (((Iterator)localObject2).hasNext())
          {
            ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)((Iterator)localObject2).next();
            n += this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int;
          }
          i1 = i2;
          if (n / ((List)localObject1).size() < i4) {
            if (paramInt2 == this.jdField_a_of_type_JavaUtilList.size() - 1)
            {
              i1 = i2;
            }
            else
            {
              n = paramInt1 + ((List)localObject1).size();
              break label422;
            }
          }
          while (i1 < ((List)localObject1).size())
          {
            localObject2 = (ModelFastColorFont)((List)localObject1).get(i1);
            if (i3 <= this.jdField_a_of_type_Int + ((ModelFastColorFont)localObject2).jdField_d_of_type_Int + ((ModelFastColorFont)localObject2).jdField_b_of_type_Int) {
              return paramInt1 + i1;
            }
            i1 += 1;
          }
          return paramInt1 + ((List)localObject1).size();
        }
      }
      label422:
      paramInt2 += 1;
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    int n = 0;
    while (n < this.jdField_b_of_type_JavaUtilList.size())
    {
      paramTextGraphMap = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(n);
      if ((paramInt1 >= paramTextGraphMap.jdField_d_of_type_Int) && (paramInt1 <= paramTextGraphMap.jdField_d_of_type_Int + paramTextGraphMap.jdField_b_of_type_Int) && (paramInt2 >= paramTextGraphMap.jdField_e_of_type_Int) && (paramInt2 <= paramTextGraphMap.jdField_e_of_type_Int + paramTextGraphMap.jdField_c_of_type_Int)) {
        return n;
      }
      n += 1;
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramInt1, paramInt2);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap, null, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
      FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramInt1, paramInt2, localBitmap);
      localObject = localBitmap;
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        localObject = a();
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
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ExpressionLayout.1(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i1 = this.jdField_b_of_type_JavaUtilList.size();
    int n = 0;
    while (n < i1)
    {
      if ((n >= paramInt1) && (n < paramInt2))
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(n);
        this.jdField_a_of_type_AndroidGraphicsPath.addRect(this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int, this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int, this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int + localModelFastColorFont.jdField_b_of_type_Int, this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int, Path.Direction.CW);
      }
      n += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int n = paramInt;
    if (!paramBoolean) {
      n = paramInt - 1;
    }
    paramInt = n;
    if (n >= this.jdField_b_of_type_JavaUtilList.size()) {
      paramInt = this.jdField_b_of_type_JavaUtilList.size() - 1;
    }
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(paramArrayOfInt);
    ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int;
      paramArrayOfInt[1] += this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int;
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int + localModelFastColorFont.jdField_b_of_type_Int;
    paramArrayOfInt[1] += this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.hasSelected()) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-256);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  void a(String paramString)
  {
    if (FastColorFontHelper.jdField_a_of_type_Boolean)
    {
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  text:");
      paramString = this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
      Object localObject = null;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText;
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  fontId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        paramString = null;
      } else {
        paramString = Integer.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  chars.length:");
      paramString = this.jdField_a_of_type_ArrayOfInt;
      int n;
      if (paramString == null) {
        n = 0;
      } else {
        n = paramString.length;
      }
      localStringBuilder.append(n);
      localStringBuilder.append("\n  bitmapWidth:");
      paramString = this.jdField_a_of_type_AndroidGraphicsBitmap;
      int i1 = -1;
      if (paramString == null) {
        n = -1;
      } else {
        n = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      }
      localStringBuilder.append(n);
      localStringBuilder.append("\n  bitmapHeight:");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        n = i1;
      } else {
        n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      }
      localStringBuilder.append(n);
      localStringBuilder.append("\n  viewWidth:");
      localStringBuilder.append(this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      localStringBuilder.append("\n  viewHeight:");
      localStringBuilder.append(this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int);
      localStringBuilder.append("\n  paddingLeft:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("\n  paddingRight:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("\n  paddingTop:");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("\n  paddingBottom:");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append("\n  screenWidth:");
      localStringBuilder.append(this.jdField_h_of_type_Int);
      localStringBuilder.append("\n  screenHeight:");
      localStringBuilder.append(this.jdField_i_of_type_Int);
      localStringBuilder.append("\n  x[]:");
      localStringBuilder.append(Arrays.toString(this.jdField_b_of_type_ArrayOfInt));
      localStringBuilder.append("\n  y[]:");
      localStringBuilder.append(Arrays.toString(this.jdField_c_of_type_ArrayOfInt));
      localStringBuilder.append("\n  width[]:");
      localStringBuilder.append(Arrays.toString(this.jdField_d_of_type_ArrayOfInt));
      localStringBuilder.append("\n  height[]:");
      localStringBuilder.append(Arrays.toString(this.jdField_e_of_type_ArrayOfInt));
      localStringBuilder.append("\n  mAnimationId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        paramString = null;
      } else {
        paramString = Long.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  shouldDisplayAnimation:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        paramString = localObject;
      } else {
        paramString = Boolean.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation);
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("\n  frameIndex:");
      localStringBuilder.append(this.jdField_e_of_type_Int);
      localStringBuilder.append("\n  animInfo:");
      localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
      localStringBuilder.append("\n");
      FastColorFontLog.a(str, localStringBuilder.toString());
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (a())
    {
      FastColorFontLog.a(a(), "ExpressionLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!b())
    {
      FastColorFontLog.a(a(), "ExpressionLayout::onDraw 创建bitmap失败！");
      return false;
    }
    c();
    long l1 = System.nanoTime();
    m();
    FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
    a(paramCanvas);
    n();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (this.jdField_e_of_type_Int == 0)) {
      b();
    }
    if (FastColorFontHelper.jdField_a_of_type_Boolean)
    {
      paramCanvas = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("字数：");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfInt.length);
      localStringBuilder.append("\n   字号：");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize());
      localStringBuilder.append("px\n");
      FastColorFontLog.a(paramCanvas, l1, localStringBuilder.toString());
      a("ExpressionLayout::onDraw......");
    }
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (this.jdField_b_of_type_Boolean == paramBoolean) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont)) && (this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.isCacheMeasureResult())) {
      return this.jdField_j_of_type_ArrayOfInt;
    }
    if (this.jdField_a_of_type_Long != paramLong)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.setIsFounderAnimating(false);
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_e_of_type_Int = 0;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(-1, null, 0.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
    int n = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) && (this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getVisibility() != 8))
    {
      paramETFont = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getText();
      if (TextUtils.isEmpty(paramETFont))
      {
        paramETFont = this.jdField_j_of_type_ArrayOfInt;
        paramETFont[0] = n;
        paramETFont[1] = i1;
        return paramETFont;
      }
      paramLong = System.nanoTime();
      a(paramInt1, paramInt2, paramETFont);
      long l1 = System.nanoTime();
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        String str = a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("字数：");
        localStringBuilder.append(paramETFont.length());
        localStringBuilder.append("   字号：");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize());
        localStringBuilder.append("px   排版耗时：");
        localStringBuilder.append((float)(l1 - paramLong) / 1000000.0F);
        localStringBuilder.append("ms");
        FastColorFontLog.a(str, localStringBuilder.toString());
      }
      if (a())
      {
        paramETFont = this.jdField_j_of_type_ArrayOfInt;
        paramETFont[0] = n;
        paramETFont[1] = i1;
        return paramETFont;
      }
      paramETFont = this.jdField_j_of_type_ArrayOfInt;
      paramETFont[0] = this.jdField_j_of_type_Int;
      paramETFont[1] = this.jdField_k_of_type_Int;
      return paramETFont;
    }
    paramETFont = this.jdField_j_of_type_ArrayOfInt;
    paramETFont[0] = n;
    paramETFont[1] = i1;
    return paramETFont;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      if (a()) {
        return;
      }
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        return;
      }
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        str = a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......animInfo:");
        localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
        FastColorFontLog.a(str, localStringBuilder.toString());
      }
      this.jdField_e_of_type_Int = 0;
      if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
      {
        h();
        return;
      }
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
      if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
      {
        h();
        return;
      }
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
      localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
      FastColorFontLog.b(str, localStringBuilder.toString());
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
  }
  
  public void e()
  {
    super.e();
    this.jdField_b_of_type_AndroidGraphicsCanvas = null;
    this.jdField_c_of_type_AndroidGraphicsCanvas = null;
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    Object localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
    if (localObject != null)
    {
      ((Paint)localObject).reset();
      this.jdField_b_of_type_AndroidGraphicsPaint = null;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localObject != null) {
      ((Paint)localObject).reset();
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    if (localObject != null) {
      ((Path)localObject).reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.ExpressionLayout
 * JD-Core Version:    0.7.0.1
 */