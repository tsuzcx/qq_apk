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
  protected int a;
  private long jdField_a_of_type_Long;
  protected Paint a;
  protected Path a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private FounderColorLayout.SpanComparator jdField_a_of_type_ComVasColorFontFounderColorLayout$SpanComparator;
  protected IETextView a;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  protected List<List<ModelFastColorFont>> a;
  protected int[] a;
  protected int b;
  protected Canvas b;
  protected Paint b;
  protected List<ModelFastColorFont> b;
  protected boolean b;
  protected int[] b;
  protected int c;
  protected Canvas c;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private List<ModelFastColorFont> jdField_c_of_type_JavaUtilList;
  private boolean jdField_c_of_type_Boolean;
  protected int[] c;
  protected int d;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  private List<ModelFastColorFont> jdField_d_of_type_JavaUtilList;
  private boolean jdField_d_of_type_Boolean;
  protected int[] d;
  protected int[] e;
  protected int f;
  protected int[] f;
  protected int g;
  protected int[] g;
  protected int h;
  private int[] h;
  protected int i;
  protected int j;
  private int[] j;
  protected int k;
  protected int l;
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
  private int w;
  private int x;
  
  public FounderColorLayout(IETextView paramIETextView, ETFont paramETFont)
  {
    this.jdField_h_of_type_ArrayOfInt = new int[2];
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_g_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView = paramIETextView;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    k();
    this.jdField_a_of_type_ComVasColorFontFounderColorLayout$SpanComparator = new FounderColorLayout.SpanComparator();
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }
  
  private ModelFastColorFont a()
  {
    if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
      return new ModelFastColorFont();
    }
    return (ModelFastColorFont)this.jdField_d_of_type_JavaUtilList.remove(0);
  }
  
  @TargetApi(16)
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    k();
    paramInt2 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if ((paramInt2 != -2147483648) && (paramInt2 != 1073741824)) {
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getETMaxWidth();
    } else {
      this.jdField_f_of_type_Int = Math.min(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getETMaxWidth(), paramInt1);
    }
    this.jdField_g_of_type_Int = 0;
    this.m = 0;
    this.p = 0;
    this.q = 0;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.r = 1;
    this.w = 0;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingLeft();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingRight();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingTop();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaddingBottom();
    this.v = (this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
    if (Build.VERSION.SDK_INT >= 16) {
      this.t = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getMaxEms();
    }
    this.u = this.v;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_JavaUtilList.clear();
    paramInt1 = this.jdField_d_of_type_JavaUtilList.size();
    int i4 = paramCharSequence.length();
    if ((paramInt1 < i4) && (!this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      while (paramInt1 < i4)
      {
        if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_j_of_type_ArrayOfInt = new int[i4];
    Object localObject1 = new int[i4];
    paramInt1 = 0;
    int i1 = 0;
    int i3;
    for (int i2 = 0; paramInt1 < i4; i2 = paramInt2)
    {
      localObject1[paramInt1] = paramCharSequence.charAt(paramInt1);
      if (((localObject1[paramInt1] >= 97) && (localObject1[paramInt1] <= 122)) || ((localObject1[paramInt1] >= 65) && (localObject1[paramInt1] <= 90)))
      {
        if (i2 == 0)
        {
          i3 = paramInt1;
          paramInt2 = 1;
          break label479;
        }
        i3 = i1;
        paramInt2 = i2;
        if (paramInt1 != i4 - 1) {
          break label479;
        }
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, i4 - i1);
      }
      else
      {
        i3 = i1;
        paramInt2 = i2;
        if (i2 == 0) {
          break label479;
        }
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i1, paramInt1 - i1);
      }
      paramInt2 = 0;
      i3 = i1;
      label479:
      paramInt1 += 1;
      i1 = i3;
    }
    float f2 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize();
    int i5 = (int)f2;
    FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (int[])localObject1, i5, this.jdField_j_of_type_ArrayOfInt);
    paramInt1 = 0;
    while (paramInt1 < i4)
    {
      i1 = this.jdField_j_of_type_ArrayOfInt[paramInt1];
      paramInt2 = i1;
      if (i1 <= 0)
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint().measureText(String.valueOf((char)localObject1[paramInt1]));
        if (f1 <= 0.0F) {
          f1 = i5;
        }
        paramInt2 = (int)(f1 * FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
      }
      this.jdField_j_of_type_ArrayOfInt[paramInt1] = paramInt2;
      paramInt1 += 1;
    }
    Object localObject2;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject1 = (Spanned)paramCharSequence;
      localObject2 = (CharacterStyle[])((Spanned)localObject1).getSpans(0, ((Spanned)localObject1).length(), CharacterStyle.class);
      this.jdField_a_of_type_ComVasColorFontFounderColorLayout$SpanComparator.a((Spanned)localObject1);
      Arrays.sort((Object[])localObject2, this.jdField_a_of_type_ComVasColorFontFounderColorLayout$SpanComparator);
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    this.jdField_j_of_type_Int = ((int)(FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
    i1 = (int)(f2 * FastColorFontCache.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / FastColorFontCache.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
    Object localObject3;
    if ((localObject1 != null) && (localObject2 != null) && (localObject2.length > 0))
    {
      i2 = localObject2.length;
      paramInt1 = 0;
      while (paramInt1 < i2)
      {
        localObject3 = localObject2[paramInt1];
        if ((localObject3 instanceof RelativeSizeSpan))
        {
          paramInt2 = ((Spanned)localObject1).getSpanStart(localObject3);
          i3 = ((Spanned)localObject1).getSpanEnd(localObject3);
          f1 = ((RelativeSizeSpan)localObject3).getSizeChange();
          while (paramInt2 < i3)
          {
            localObject3 = this.jdField_j_of_type_ArrayOfInt;
            localObject3[paramInt2] = ((int)(localObject3[paramInt2] * f1));
            paramInt2 += 1;
          }
        }
        paramInt1 += 1;
      }
      i2 = 0;
      paramInt2 = 0;
      paramInt1 = i1;
      i1 = i2;
    }
    while (paramInt2 < localObject2.length)
    {
      localObject3 = localObject2[paramInt2];
      i3 = ((Spanned)localObject1).getSpanStart(localObject3);
      i2 = ((Spanned)localObject1).getSpanEnd(localObject3);
      boolean bool;
      if (i2 == ((Spanned)localObject1).length()) {
        bool = true;
      } else {
        bool = false;
      }
      if ((i3 <= i1) || (i2 <= i3) || (!a(ETLayout.a(paramCharSequence, i1, i3), i1, i5, 0, false, paramInt1)))
      {
        i1 = i2;
        if ((localObject3 instanceof ClickableSpan)) {
          if (a(ETLayout.a(paramCharSequence, i3, i1), i3, i5, 1, bool, paramInt1)) {
            break;
          }
        } else if ((!(localObject3 instanceof EmoticonSpan)) && (!(localObject3 instanceof SignatureActionSpan)))
        {
          if ((localObject3 instanceof RelativeSizeSpan))
          {
            if (a((RelativeSizeSpan)localObject3, ETLayout.a(paramCharSequence, i3, i1), i3, i5, 3, bool, paramInt1)) {
              break;
            }
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Un Know CharacterStyle   start:");
            ((StringBuilder)localObject3).append(i3);
            ((StringBuilder)localObject3).append("  end:");
            ((StringBuilder)localObject3).append(i1);
            FastColorFontLog.b("FounderColorLayout", ((StringBuilder)localObject3).toString());
          }
        }
        else {
          if (a((CharacterStyle)localObject3, i3, i1, 2, bool)) {
            break;
          }
        }
        if ((paramInt2 != localObject2.length - 1) || (bool) || (!a(ETLayout.a(paramCharSequence, i1, ((Spanned)localObject1).length()), i1, i5, 0, true, paramInt1)))
        {
          paramInt2 += 1;
          continue;
          a(paramCharSequence, 0, i5, 0, true, i1);
        }
      }
    }
    if (Build.VERSION.SDK_INT >= 16) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getMaxLines();
    } else {
      i1 = 0;
    }
    paramCharSequence = this;
    float f1 = paramCharSequence.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint().getFontMetrics().bottom;
    paramCharSequence.jdField_i_of_type_Int = 0;
    paramCharSequence.jdField_h_of_type_Int = paramCharSequence.jdField_a_of_type_JavaUtilList.size();
    int i6 = paramCharSequence.jdField_a_of_type_JavaUtilList.size();
    i2 = 0;
    paramInt1 = 0;
    while ((i2 < i6) && (i2 < i1))
    {
      localObject1 = (List)paramCharSequence.jdField_a_of_type_JavaUtilList.get(i2);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramCharSequence.jdField_i_of_type_Int = Math.max(paramCharSequence.jdField_i_of_type_Int, ((List)localObject1).size());
        int i7 = ((List)localObject1).size();
        i3 = 0;
        for (paramInt2 = 0; i3 < i7; paramInt2 = i4)
        {
          localObject2 = (ModelFastColorFont)((List)localObject1).get(i3);
          i4 = paramInt2;
          if (((ModelFastColorFont)localObject2).jdField_c_of_type_Int > paramInt2) {
            i4 = ((ModelFastColorFont)localObject2).jdField_c_of_type_Int;
          }
          i3 += 1;
        }
        i4 = ((List)localObject1).size();
        i3 = 0;
        while (i3 < i4)
        {
          localObject2 = (ModelFastColorFont)((List)localObject1).get(i3);
          ((ModelFastColorFont)localObject2).jdField_e_of_type_Int = (paramInt2 - ((ModelFastColorFont)localObject2).jdField_c_of_type_Int + paramInt1 - (int)((1.0F - ((ModelFastColorFont)localObject2).jdField_c_of_type_Int / paramInt2) * f1));
          i3 += 1;
        }
        paramInt2 = paramInt1 + paramInt2;
        if (i2 != i6 - 1)
        {
          paramInt1 = paramCharSequence.jdField_j_of_type_Int;
          break label1561;
        }
      }
      else
      {
        paramInt2 = paramInt1 + i5;
        if (i2 != i6 - 1) {
          break label1556;
        }
      }
      paramInt1 = 0;
      break label1561;
      label1556:
      paramInt1 = paramCharSequence.jdField_j_of_type_Int;
      label1561:
      paramInt1 = paramInt2 + paramInt1;
      i2 += 1;
    }
    paramInt2 = paramCharSequence.m;
    if (paramInt2 < paramCharSequence.v) {
      paramCharSequence.jdField_f_of_type_Int = (paramInt2 + paramCharSequence.jdField_a_of_type_Int + paramCharSequence.jdField_b_of_type_Int);
    }
    paramCharSequence.jdField_g_of_type_Int = (paramInt1 + paramCharSequence.jdField_d_of_type_Int + paramCharSequence.jdField_c_of_type_Int);
  }
  
  private void a(Canvas paramCanvas, ModelFastColorFont paramModelFastColorFont)
  {
    if (paramModelFastColorFont.jdField_b_of_type_Int > 0)
    {
      if (paramModelFastColorFont.jdField_c_of_type_Int <= 0) {
        return;
      }
      BitmapShader localBitmapShader = FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int);
      Bitmap localBitmap1;
      if (localBitmapShader == null)
      {
        localBitmap2 = Bitmap.createBitmap(paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
        localBitmap1 = Bitmap.createBitmap(paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
        int i1 = FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap2, localBitmap1, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2) {
              break label290;
            }
            localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, localBitmapShader);
            FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, localBitmap1);
            break label290;
          }
          localBitmapShader = new BitmapShader(localBitmap2, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
          FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, localBitmapShader);
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
        localBitmap1 = FastColorFontCache.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int);
      }
      label290:
      Bitmap localBitmap2 = Bitmap.createBitmap(paramModelFastColorFont.jdField_b_of_type_Int, paramModelFastColorFont.jdField_c_of_type_Int, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = this.jdField_c_of_type_AndroidGraphicsCanvas;
      if (localCanvas == null) {
        this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(localBitmap2);
      } else {
        localCanvas.setBitmap(localBitmap2);
      }
      if (localBitmap1 != null) {
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
      }
      if (localBitmapShader != null) {
        this.jdField_d_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      }
      this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(paramModelFastColorFont.jdField_c_of_type_Int);
      this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(paramModelFastColorFont.jdField_a_of_type_Char), 0.0F, (int)(paramModelFastColorFont.jdField_c_of_type_Int / 2.0F - (this.jdField_d_of_type_AndroidGraphicsPaint.descent() + this.jdField_d_of_type_AndroidGraphicsPaint.ascent()) / 2.0F), this.jdField_d_of_type_AndroidGraphicsPaint);
      paramCanvas.drawBitmap(localBitmap2, paramModelFastColorFont.jdField_d_of_type_Int, paramModelFastColorFont.jdField_e_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
      localBitmap2.recycle();
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
    Object localObject = a();
    ((ModelFastColorFont)localObject).jdField_a_of_type_Char = 65535;
    ((ModelFastColorFont)localObject).jdField_a_of_type_Boolean = false;
    ((ModelFastColorFont)localObject).jdField_b_of_type_Int = paramInt1;
    ((ModelFastColorFont)localObject).jdField_c_of_type_Int = paramInt2;
    ((ModelFastColorFont)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
    ((ModelFastColorFont)localObject).jdField_a_of_type_Int = paramInt3;
    if (this.u < ((ModelFastColorFont)localObject).jdField_b_of_type_Int)
    {
      this.q = Math.max(this.p, this.q);
      this.p = ((ModelFastColorFont)localObject).jdField_b_of_type_Int;
      this.r += 1;
      this.w = 0;
      ((ModelFastColorFont)localObject).jdField_d_of_type_Int = this.w;
      ((ModelFastColorFont)localObject).jdField_f_of_type_Int = this.r;
      this.w = ((ModelFastColorFont)localObject).jdField_b_of_type_Int;
      this.u = (this.v - ((ModelFastColorFont)localObject).jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
      this.jdField_c_of_type_JavaUtilList.add(localObject);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
    }
    else
    {
      this.p += ((ModelFastColorFont)localObject).jdField_b_of_type_Int;
      ((ModelFastColorFont)localObject).jdField_d_of_type_Int = this.w;
      ((ModelFastColorFont)localObject).jdField_f_of_type_Int = this.r;
      this.u -= ((ModelFastColorFont)localObject).jdField_b_of_type_Int;
      this.w += ((ModelFastColorFont)localObject).jdField_b_of_type_Int;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
    }
    paramInt1 = this.w;
    if (paramInt1 > this.m) {
      this.m = paramInt1;
    }
    this.s += 1;
    paramInt1 = this.t;
    if ((paramInt1 > 0) && (this.s >= paramInt1))
    {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      return true;
    }
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
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
      paramRelativeSizeSpan = a();
      int i1;
      if (c1 == '\n')
      {
        paramRelativeSizeSpan.jdField_a_of_type_Boolean = false;
        paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
        paramRelativeSizeSpan.jdField_b_of_type_Int = 0;
        paramRelativeSizeSpan.jdField_c_of_type_Int = paramInt4;
        paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
        paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
        i1 = this.r;
        paramRelativeSizeSpan.jdField_f_of_type_Int = i1;
        this.u = this.v;
        this.r = (i1 + 1);
        this.w = 0;
        this.q = Math.max(this.p, this.q);
        this.p = 0;
        this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      else
      {
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          localObject = this.jdField_a_of_type_AndroidUtilSparseIntArray;
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
              i1 += this.jdField_j_of_type_ArrayOfInt[(i6 + i4)];
              i4 += 1;
            }
          }
        }
        int i3 = 0;
        i1 = paramInt1 + i2;
        Object localObject = this.jdField_j_of_type_ArrayOfInt;
        float f1;
        if (i1 < localObject.length) {
          f1 = localObject[i1];
        } else {
          f1 = paramInt2 * f2;
        }
        paramRelativeSizeSpan.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(i1));
        paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
        paramRelativeSizeSpan.jdField_b_of_type_Int = ((int)f1);
        if (paramRelativeSizeSpan.jdField_a_of_type_Boolean) {
          i1 = paramInt2;
        } else {
          i1 = paramInt4;
        }
        paramRelativeSizeSpan.jdField_c_of_type_Int = ((int)(i1 * f2));
        paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
        if ((this.u >= paramRelativeSizeSpan.jdField_b_of_type_Int) && ((this.u >= i3) || (this.w == 0)))
        {
          this.p += paramRelativeSizeSpan.jdField_b_of_type_Int;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.r;
          this.u -= paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.w += paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
        else
        {
          this.q = Math.max(this.p, this.q);
          this.p = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.r += 1;
          this.w = 0;
          paramRelativeSizeSpan.jdField_d_of_type_Int = this.w;
          paramRelativeSizeSpan.jdField_f_of_type_Int = this.r;
          this.w = paramRelativeSizeSpan.jdField_b_of_type_Int;
          this.u = (this.v - paramRelativeSizeSpan.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          this.jdField_c_of_type_JavaUtilList = new ArrayList();
          this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        }
        i1 = this.w;
        if (i1 > this.m) {
          this.m = i1;
        }
        this.s += 1;
        i1 = this.t;
        if ((i1 > 0) && (this.s >= i1))
        {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          return true;
        }
      }
      this.jdField_b_of_type_JavaUtilList.add(paramRelativeSizeSpan);
      if ((i2 == i5 - 1) && (paramBoolean)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      }
      i2 += 1;
    }
    return false;
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    int i5 = paramCharSequence.length();
    int i2 = 0;
    while (i2 < i5)
    {
      char c1 = paramCharSequence.charAt(i2);
      ModelFastColorFont localModelFastColorFont = a();
      int i1;
      if (c1 == '\n')
      {
        localModelFastColorFont.jdField_a_of_type_Boolean = false;
        localModelFastColorFont.jdField_a_of_type_Int = paramInt3;
        localModelFastColorFont.jdField_b_of_type_Int = 0;
        localModelFastColorFont.jdField_c_of_type_Int = paramInt4;
        localModelFastColorFont.jdField_a_of_type_Char = c1;
        localModelFastColorFont.jdField_d_of_type_Int = this.w;
        i1 = this.r;
        localModelFastColorFont.jdField_f_of_type_Int = i1;
        this.u = this.v;
        this.r = (i1 + 1);
        this.w = 0;
        this.q = Math.max(this.p, this.q);
        this.p = 0;
        this.jdField_c_of_type_JavaUtilList.add(localModelFastColorFont);
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      else
      {
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() > 0)
        {
          localObject = this.jdField_a_of_type_AndroidUtilSparseIntArray;
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
              i1 += this.jdField_j_of_type_ArrayOfInt[(i6 + i4)];
              i4 += 1;
            }
          }
        }
        int i3 = 0;
        i1 = paramInt1 + i2;
        Object localObject = this.jdField_j_of_type_ArrayOfInt;
        float f1;
        if (i1 < localObject.length) {
          f1 = localObject[i1];
        } else {
          f1 = paramInt2;
        }
        localModelFastColorFont.jdField_a_of_type_Boolean = this.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(i1));
        localModelFastColorFont.jdField_a_of_type_Int = paramInt3;
        localModelFastColorFont.jdField_b_of_type_Int = ((int)f1);
        if (localModelFastColorFont.jdField_a_of_type_Boolean) {
          i1 = paramInt2;
        } else {
          i1 = paramInt4;
        }
        localModelFastColorFont.jdField_c_of_type_Int = i1;
        localModelFastColorFont.jdField_a_of_type_Char = c1;
        if ((this.u >= localModelFastColorFont.jdField_b_of_type_Int) && ((this.u >= i3) || (this.w == 0)))
        {
          this.p += localModelFastColorFont.jdField_b_of_type_Int;
          localModelFastColorFont.jdField_d_of_type_Int = this.w;
          localModelFastColorFont.jdField_f_of_type_Int = this.r;
          this.u -= localModelFastColorFont.jdField_b_of_type_Int;
          this.w += localModelFastColorFont.jdField_b_of_type_Int;
          this.jdField_c_of_type_JavaUtilList.add(localModelFastColorFont);
        }
        else
        {
          this.q = Math.max(this.p, this.q);
          this.p = localModelFastColorFont.jdField_b_of_type_Int;
          this.r += 1;
          this.w = 0;
          localModelFastColorFont.jdField_d_of_type_Int = this.w;
          localModelFastColorFont.jdField_f_of_type_Int = this.r;
          this.w = localModelFastColorFont.jdField_b_of_type_Int;
          this.u = (this.v - localModelFastColorFont.jdField_b_of_type_Int);
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          this.jdField_c_of_type_JavaUtilList = new ArrayList();
          this.jdField_c_of_type_JavaUtilList.add(localModelFastColorFont);
        }
        i1 = this.w;
        if (i1 > this.m) {
          this.m = i1;
        }
        this.s += 1;
        i1 = this.t;
        if ((i1 > 0) && (this.s >= i1))
        {
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
          return true;
        }
      }
      this.jdField_b_of_type_JavaUtilList.add(localModelFastColorFont);
      if ((i2 == i5 - 1) && (paramBoolean)) {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList);
      }
      i2 += 1;
    }
    return false;
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_c_of_type_JavaUtilList == null) {
      this.jdField_c_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_d_of_type_JavaUtilList == null) {
      this.jdField_d_of_type_JavaUtilList = new ArrayList();
    }
    if ((this.n <= 0) || (this.o <= 0))
    {
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getResources().getDisplayMetrics();
      this.n = localDisplayMetrics.widthPixels;
      this.o = localDisplayMetrics.heightPixels;
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_c_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    if (this.jdField_d_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_d_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_d_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_d_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseIntArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setDither(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getLocationInWindow(this.jdField_g_of_type_ArrayOfInt);
    Object localObject1 = this.jdField_g_of_type_ArrayOfInt;
    int i5 = 0;
    int i6 = localObject1[0];
    int i7 = localObject1[1];
    int i2 = 0;
    int i1 = 0;
    while (i2 < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(i2);
      int i3 = -2147483648;
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)((Iterator)localObject2).next();
        i4 = this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int;
        if (i4 > i3) {
          i3 = i4;
        }
      }
      int i4 = i5;
      if (i3 < paramInt2 - i7) {
        if (i2 == this.jdField_a_of_type_JavaUtilList.size() - 1)
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
        if (paramInt1 - i6 <= this.jdField_a_of_type_Int + ((ModelFastColorFont)localObject2).jdField_d_of_type_Int + ((ModelFastColorFont)localObject2).jdField_b_of_type_Int) {
          return i1 + i4;
        }
        i4 += 1;
      }
      return i1 + ((List)localObject1).size();
    }
    return -1;
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    int i1 = 0;
    while (i1 < this.jdField_b_of_type_JavaUtilList.size())
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i1);
      if ((paramInt1 >= localModelFastColorFont.jdField_d_of_type_Int) && (paramInt1 <= localModelFastColorFont.jdField_d_of_type_Int + localModelFastColorFont.jdField_b_of_type_Int) && (paramInt2 >= localModelFastColorFont.jdField_e_of_type_Int) && (paramInt2 <= localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int)) {
        return paramTextGraphMap.b(i1);
      }
      i1 += 1;
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
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap, null);
      FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex, paramInt1, paramInt2, localBitmap);
      localObject = localBitmap;
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
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
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FounderColorLayout.1(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i2 = this.jdField_b_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      if ((i1 >= paramInt1) && (i1 < paramInt2))
      {
        ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i1);
        this.jdField_a_of_type_AndroidGraphicsPath.addRect(this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int, this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int, this.jdField_a_of_type_Int + localModelFastColorFont.jdField_d_of_type_Int + localModelFastColorFont.jdField_b_of_type_Int, this.jdField_c_of_type_Int + localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int, Path.Direction.CW);
      }
      i1 += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i1 = paramInt;
    if (!paramBoolean) {
      i1 = paramInt - 1;
    }
    paramInt = i1;
    if (i1 >= this.jdField_b_of_type_JavaUtilList.size())
    {
      paramInt = this.jdField_b_of_type_JavaUtilList.size() - 1;
      paramBoolean = false;
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
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(-256);
    localPaint.setStrokeWidth(1.0F);
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ArrayOfInt.length)
    {
      int i2 = this.jdField_a_of_type_Int;
      int[] arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
      float f1 = arrayOfInt1[i1] + i2;
      int i3 = this.jdField_c_of_type_Int;
      int[] arrayOfInt2 = this.jdField_c_of_type_ArrayOfInt;
      paramCanvas.drawRect(f1, arrayOfInt2[i1] + i3, i2 + arrayOfInt1[i1] + this.jdField_d_of_type_ArrayOfInt[i1], i3 + arrayOfInt2[i1] + this.jdField_e_of_type_ArrayOfInt[i1], localPaint);
      i1 += 1;
    }
  }
  
  protected void a(String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.invalidate();
    }
  }
  
  protected boolean a()
  {
    if (!a(this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int)) {
      return false;
    }
    int i2 = this.jdField_b_of_type_JavaUtilList.size();
    if (i2 <= 0) {
      return false;
    }
    if (this.x != i2) {
      this.jdField_a_of_type_ArrayOfInt = new int[i2];
    }
    int i1 = this.x;
    if ((i1 < i2) || (i1 - i2 > 100))
    {
      this.jdField_b_of_type_ArrayOfInt = new int[i2];
      this.jdField_c_of_type_ArrayOfInt = new int[i2];
      this.jdField_d_of_type_ArrayOfInt = new int[i2];
      this.jdField_e_of_type_ArrayOfInt = new int[i2];
    }
    this.x = i2;
    this.jdField_b_of_type_Boolean = true;
    i1 = 0;
    while (i1 < i2)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i1);
      this.jdField_a_of_type_ArrayOfInt[i1] = localModelFastColorFont.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[i1] = localModelFastColorFont.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[i1] = localModelFastColorFont.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[i1] = localModelFastColorFont.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[i1] = localModelFastColorFont.jdField_c_of_type_Int;
      if (localModelFastColorFont.jdField_a_of_type_Int != 2) {
        this.jdField_b_of_type_Boolean = false;
      }
      i1 += 1;
    }
    return true;
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (b())
    {
      a("FounderColorLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!a())
    {
      a("FounderColorLayout::onDraw 创建bitmap失败！");
      return false;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (this.jdField_a_of_type_ArrayOfInt.length <= 0)
      {
        a(HardCodeUtil.a(2131704956));
        return false;
      }
      c();
      b(paramCanvas);
      long l1 = System.nanoTime();
      int i1 = FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (!this.jdField_b_of_type_Boolean) && (i1 == 3))
      {
        int i2 = this.jdField_h_of_type_Int;
        if ((i2 > 0) && (i2 < 6))
        {
          FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt);
          j();
          paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
          if (this.jdField_e_of_type_Int == 0) {
            b();
          }
          if (FastColorFontHelper.jdField_a_of_type_Boolean)
          {
            long l2 = System.nanoTime();
            paramCanvas = new StringBuilder();
            paramCanvas.append("动画帧耗时 frameIndex:");
            paramCanvas.append(this.jdField_e_of_type_Int);
            paramCanvas.append("  行：");
            paramCanvas.append(this.jdField_h_of_type_Int);
            paramCanvas.append("  列：");
            paramCanvas.append(this.jdField_i_of_type_Int);
            paramCanvas.append("  耗时：");
            paramCanvas.append((float)(l2 - l1) / 1000000.0F);
            paramCanvas.append("ms");
            FastColorFontLog.b("FounderColorLayout", paramCanvas.toString());
            if (this.jdField_e_of_type_Int == 0) {
              a("drawAnimationText.....");
            }
          }
          return true;
        }
      }
      if ((!this.jdField_b_of_type_Boolean) && (i1 == 5))
      {
        FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
        j();
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
        return true;
      }
      this.jdField_f_of_type_ArrayOfInt = new int[0];
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.k, this.jdField_f_of_type_ArrayOfInt, this.l);
      j();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
      return true;
    }
    a(HardCodeUtil.a(2131704957));
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (this.jdField_d_of_type_Boolean == paramBoolean) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont)) && (this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.isCacheMeasureResult())) {
      return this.jdField_h_of_type_ArrayOfInt;
    }
    Object localObject;
    if (this.jdField_a_of_type_Long != paramLong)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView;
      if (localObject != null) {
        ((IETextView)localObject).setIsFounderAnimating(false);
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_e_of_type_Int = 0;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(-1, null, 0.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
    this.jdField_h_of_type_ArrayOfInt[0] = View.MeasureSpec.getSize(paramInt1);
    this.jdField_h_of_type_ArrayOfInt[1] = View.MeasureSpec.getSize(paramInt2);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView;
      if ((localObject != null) && (((IETextView)localObject).getVisibility() != 8))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getText();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return this.jdField_h_of_type_ArrayOfInt;
        }
        paramLong = System.nanoTime();
        a(paramInt1, paramInt2, (CharSequence)localObject);
        double d1 = (float)(System.nanoTime() - paramLong) / 1000000.0F;
        if (FastColorFontHelper.jdField_a_of_type_Boolean)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("字数：");
          localStringBuilder.append(((CharSequence)localObject).length());
          localStringBuilder.append("   字号：");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize());
          localStringBuilder.append("px   排版耗时：");
          localStringBuilder.append(d1);
          localStringBuilder.append("ms");
          FastColorFontLog.a("FounderColorLayout", localStringBuilder.toString());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView != null) {
          FontReportUtils.a("action_measure", paramETFont.mFontId, 4, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getText().length(), d1);
        }
        if (b()) {
          return this.jdField_h_of_type_ArrayOfInt;
        }
        paramETFont = this.jdField_h_of_type_ArrayOfInt;
        paramETFont[0] = this.jdField_f_of_type_Int;
        paramETFont[1] = this.jdField_g_of_type_Int;
        return paramETFont;
      }
    }
    return this.jdField_h_of_type_ArrayOfInt;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      if (b()) {
        return;
      }
      if (FastColorFontCache.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) < 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("当前字体未加载或不支持动画...");
        localStringBuilder.append(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
        return;
      }
      int i1 = this.jdField_h_of_type_Int;
      if ((i1 > 0) && (i1 <= 5) && (!this.jdField_b_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
          return;
        }
        if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
        {
          h();
          return;
        }
        this.jdField_e_of_type_Int = 0;
        FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.jdField_j_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt);
        if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
        {
          h();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
        localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
        FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0行或超过5行不支持播放动画...");
      localStringBuilder.append(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
      FastColorFontLog.b("FounderColorLayout", localStringBuilder.toString());
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.hasSelected()) {
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.highlightBackgroundColor());
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  protected boolean b()
  {
    int i1 = this.jdField_f_of_type_Int;
    int i2 = this.jdField_a_of_type_Int;
    int i3 = this.jdField_b_of_type_Int;
    int i4 = 1;
    if (i1 - i2 - i3 <= 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (this.jdField_f_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int > this.n) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    if (this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= this.o) {
      i4 = 0;
    }
    return i1 | 0x0 | i2 | i3 | i4;
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
  }
  
  protected void j()
  {
    int i2 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize() / 15.0F);
    Object localObject1 = this.jdField_b_of_type_AndroidGraphicsCanvas;
    if (localObject1 == null) {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    } else {
      ((Canvas)localObject1).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    int i3 = this.jdField_b_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i3)
    {
      localObject1 = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i1);
      int i4 = ((ModelFastColorFont)localObject1).jdField_a_of_type_Int;
      Object localObject2;
      if (i4 != 1)
      {
        if (i4 == 2)
        {
          this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(((ModelFastColorFont)localObject1).jdField_d_of_type_Int, ((ModelFastColorFont)localObject1).jdField_e_of_type_Int, ((ModelFastColorFont)localObject1).jdField_d_of_type_Int + ((ModelFastColorFont)localObject1).jdField_b_of_type_Int, ((ModelFastColorFont)localObject1).jdField_e_of_type_Int + ((ModelFastColorFont)localObject1).jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
          Canvas localCanvas;
          float f1;
          int i5;
          int i6;
          if ((((ModelFastColorFont)localObject1).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof EmoticonSpan))
          {
            localObject2 = (EmoticonSpan)((ModelFastColorFont)localObject1).jdField_a_of_type_AndroidTextStyleCharacterStyle;
            localCanvas = this.jdField_b_of_type_AndroidGraphicsCanvas;
            f1 = ((ModelFastColorFont)localObject1).jdField_d_of_type_Int;
            i4 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            i5 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            i6 = ((ModelFastColorFont)localObject1).jdField_c_of_type_Int;
            int i7 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            ((EmoticonSpan)localObject2).draw(localCanvas, null, 0, 0, f1, i4, i6 + i5, ((ModelFastColorFont)localObject1).jdField_c_of_type_Int + i7, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
          else if ((((ModelFastColorFont)localObject1).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof SignatureActionSpan))
          {
            localObject2 = (SignatureActionSpan)((ModelFastColorFont)localObject1).jdField_a_of_type_AndroidTextStyleCharacterStyle;
            ((SignatureActionSpan)localObject2).jdField_a_of_type_Boolean = false;
            localCanvas = this.jdField_b_of_type_AndroidGraphicsCanvas;
            f1 = ((ModelFastColorFont)localObject1).jdField_d_of_type_Int;
            i4 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            i5 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            i6 = ((ModelFastColorFont)localObject1).jdField_e_of_type_Int;
            ((SignatureActionSpan)localObject2).draw(localCanvas, null, 0, 0, f1, i4, i5, ((ModelFastColorFont)localObject1).jdField_c_of_type_Int + i6, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
        }
      }
      else
      {
        localObject2 = a(((ModelFastColorFont)localObject1).jdField_b_of_type_Int, i2);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject2, ((ModelFastColorFont)localObject1).jdField_d_of_type_Int, ((ModelFastColorFont)localObject1).jdField_e_of_type_Int + ((ModelFastColorFont)localObject1).jdField_c_of_type_Int - i2, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
      }
      if (((ModelFastColorFont)localObject1).jdField_a_of_type_Boolean) {
        a(this.jdField_b_of_type_AndroidGraphicsCanvas, (ModelFastColorFont)localObject1);
      }
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderColorLayout
 * JD-Core Version:    0.7.0.1
 */