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
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class c
  extends j
  implements k
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected Paint a;
  protected Path a;
  private final ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private e jdField_a_of_type_E;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  private List<List<r>> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  protected int[] a;
  protected int b;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private List<r> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  protected int[] b;
  protected int c;
  private Canvas jdField_c_of_type_AndroidGraphicsCanvas;
  private List<r> jdField_c_of_type_JavaUtilList;
  protected int[] c;
  protected int d;
  private List<r> d;
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
  
  public c(View paramView, ETFont paramETFont)
  {
    this.jdField_h_of_type_ArrayOfInt = new int[2];
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView);
    this.jdField_a_of_type_E = new e();
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  }
  
  private r a()
  {
    if (this.jdField_d_of_type_JavaUtilList.isEmpty()) {
      return new r();
    }
    return (r)this.jdField_d_of_type_JavaUtilList.remove(0);
  }
  
  private void a(int paramInt1, int paramInt2, CharSequence paramCharSequence)
  {
    j();
    int n = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    if ((n == -2147483648) || (n == 1073741824)) {}
    int i2;
    for (this.jdField_j_of_type_Int = Math.min(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth, i3);; this.jdField_j_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMaxWidth)
    {
      this.jdField_g_of_type_Int = (this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      this.jdField_k_of_type_Int = 0;
      i2 = paramCharSequence.length();
      paramInt1 = this.jdField_d_of_type_JavaUtilList.size();
      if ((paramInt1 >= i2) || (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
        break;
      }
      while (paramInt1 < i2)
      {
        if (!this.jdField_c_of_type_JavaUtilList.isEmpty()) {
          this.jdField_d_of_type_JavaUtilList.add(this.jdField_c_of_type_JavaUtilList.remove(0));
        }
        paramInt1 += 1;
      }
    }
    this.jdField_c_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_k_of_type_ArrayOfInt = new int[i2];
    Object localObject = new int[i2];
    paramInt1 = 0;
    while (paramInt1 < i2)
    {
      localObject[paramInt1] = paramCharSequence.charAt(paramInt1);
      paramInt1 += 1;
    }
    float f2 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize();
    int i4 = (int)f2;
    g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, (int[])localObject, i4, this.jdField_k_of_type_ArrayOfInt);
    paramInt1 = 0;
    int i1;
    if (paramInt1 < i2)
    {
      i1 = this.jdField_k_of_type_ArrayOfInt[paramInt1];
      n = i1;
      float f1;
      if (i1 <= 0)
      {
        f1 = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint().measureText(String.valueOf((char)localObject[paramInt1]));
        if (f1 <= 0.0F) {
          break label374;
        }
      }
      for (;;)
      {
        n = (int)(f1 * f.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / f.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
        this.jdField_k_of_type_ArrayOfInt[paramInt1] = n;
        paramInt1 += 1;
        break;
        label374:
        f1 = i4;
      }
    }
    CharacterStyle[] arrayOfCharacterStyle;
    if ((paramCharSequence instanceof Spanned))
    {
      localObject = (Spanned)paramCharSequence;
      arrayOfCharacterStyle = (CharacterStyle[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), CharacterStyle.class);
      this.jdField_a_of_type_E.a((Spanned)localObject);
      Arrays.sort(arrayOfCharacterStyle, this.jdField_a_of_type_E);
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = ((int)(f.a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / f.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
      this.jdField_l_of_type_Int = ((int)(f.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) * f2 / f.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId)));
      if ((localObject != null) && (arrayOfCharacterStyle.length > 0))
      {
        paramInt1 = 0;
        n = 0;
        if (n < arrayOfCharacterStyle.length)
        {
          CharacterStyle localCharacterStyle = arrayOfCharacterStyle[n];
          i4 = ((Spanned)localObject).getSpanStart(localCharacterStyle);
          i2 = ((Spanned)localObject).getSpanEnd(localCharacterStyle);
          if (i2 == ((Spanned)localObject).length())
          {
            i1 = 1;
            label565:
            if ((i4 > paramInt1) && (i2 > i4)) {
              a(null, fj.a(paramCharSequence, paramInt1, i4), paramInt1, (int)f2, 0, this.jdField_l_of_type_Int);
            }
            if (!(localCharacterStyle instanceof ClickableSpan)) {
              break label694;
            }
            a(null, fj.a(paramCharSequence, i4, i2), i4, (int)f2, 1, this.jdField_l_of_type_Int);
          }
          for (;;)
          {
            if ((n == arrayOfCharacterStyle.length - 1) && (i1 == 0)) {
              a(null, fj.a(paramCharSequence, i2, ((Spanned)localObject).length()), i2, (int)f2, 0, this.jdField_l_of_type_Int);
            }
            n += 1;
            paramInt1 = i2;
            break;
            i1 = 0;
            break label565;
            label694:
            if (((localCharacterStyle instanceof bain)) || ((localCharacterStyle instanceof axye))) {
              a(localCharacterStyle);
            } else if ((localCharacterStyle instanceof RelativeSizeSpan)) {
              a((RelativeSizeSpan)localCharacterStyle, fj.a(paramCharSequence, i4, i2), i4, (int)f2, 3, this.jdField_l_of_type_Int);
            } else {
              i.b(a(), "Un Know CharacterStyle   start:" + i4 + "  end:" + i2);
            }
          }
        }
      }
      else
      {
        a(null, paramCharSequence, 0, (int)f2, 0, this.jdField_l_of_type_Int);
      }
      k();
      this.m = g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_ArrayOfInt, this.jdField_g_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId);
      if ((this.m == null) || (this.m.length < 2))
      {
        this.jdField_j_of_type_Int = i3;
        this.jdField_k_of_type_Int = View.MeasureSpec.getSize(paramInt2);
        return;
      }
      this.jdField_j_of_type_Int = (this.m[0] + this.jdField_a_of_type_Int + this.jdField_b_of_type_Int);
      this.jdField_k_of_type_Int = (this.m[1] + this.jdField_c_of_type_Int + this.jdField_d_of_type_Int);
      l();
      return;
      localObject = null;
      arrayOfCharacterStyle = null;
    }
  }
  
  private boolean a()
  {
    int i3 = 1;
    int n;
    int i1;
    label41:
    int i2;
    if (this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int <= 0)
    {
      n = 1;
      if (this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int > 0) {
        break label101;
      }
      i1 = 1;
      if (this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int <= this.jdField_h_of_type_Int) {
        break label106;
      }
      i2 = 1;
      label64:
      if (this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int <= this.jdField_i_of_type_Int) {
        break label111;
      }
    }
    for (;;)
    {
      return i2 | 0x0 | n | i1 | i3;
      n = 0;
      break;
      label101:
      i1 = 0;
      break label41;
      label106:
      i2 = 0;
      break label64;
      label111:
      i3 = 0;
    }
  }
  
  private boolean a(CharacterStyle paramCharacterStyle)
  {
    Object localObject;
    int i1;
    int n;
    if ((paramCharacterStyle instanceof bain))
    {
      localObject = ((bain)paramCharacterStyle).a().getBounds();
      i1 = ((Rect)localObject).width();
      n = ((Rect)localObject).height();
    }
    for (;;)
    {
      localObject = a();
      ((r)localObject).jdField_a_of_type_Char = 65535;
      ((r)localObject).jdField_a_of_type_Boolean = false;
      ((r)localObject).jdField_b_of_type_Int = i1;
      ((r)localObject).jdField_c_of_type_Int = n;
      ((r)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle = paramCharacterStyle;
      ((r)localObject).jdField_a_of_type_Int = 2;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
      return true;
      if ((paramCharacterStyle instanceof axye))
      {
        localObject = (axye)paramCharacterStyle;
        i1 = ((axye)localObject).a();
        n = ((axye)localObject).b();
      }
      else
      {
        n = 0;
        i1 = 0;
      }
    }
  }
  
  private boolean a(RelativeSizeSpan paramRelativeSizeSpan, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    if (paramRelativeSizeSpan != null) {
      f2 = paramRelativeSizeSpan.getSizeChange();
    }
    int i1 = paramCharSequence.length();
    int n = 0;
    if (n < i1)
    {
      char c1 = paramCharSequence.charAt(n);
      float f1;
      label65:
      label72:
      int i2;
      if (paramInt1 + n < this.jdField_k_of_type_ArrayOfInt.length)
      {
        f1 = this.jdField_k_of_type_ArrayOfInt[(paramInt1 + n)];
        if (f1 <= 0.0F) {
          break label170;
        }
        i2 = (int)(f1 * f.d(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId) / f.e(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId));
        paramRelativeSizeSpan = a();
        paramRelativeSizeSpan.jdField_a_of_type_Boolean = false;
        paramRelativeSizeSpan.jdField_a_of_type_Int = paramInt3;
        paramRelativeSizeSpan.jdField_a_of_type_Char = c1;
        if (c1 != '\n') {
          break label178;
        }
        paramRelativeSizeSpan.jdField_b_of_type_Int = i2;
      }
      for (paramRelativeSizeSpan.jdField_c_of_type_Int = paramInt4;; paramRelativeSizeSpan.jdField_c_of_type_Int = ((int)(paramInt4 * f2)))
      {
        this.jdField_c_of_type_JavaUtilList.add(paramRelativeSizeSpan);
        n += 1;
        break;
        f1 = paramInt2;
        break label65;
        label170:
        f1 = paramInt2;
        break label72;
        label178:
        paramRelativeSizeSpan.jdField_b_of_type_Int = ((int)(i2 * f2));
      }
    }
    return true;
  }
  
  private boolean b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (!a(this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int)) {}
    while (this.jdField_c_of_type_JavaUtilList.size() <= 0) {
      return false;
    }
    int i2 = this.jdField_c_of_type_JavaUtilList.size();
    int i1 = 0;
    int n = 1;
    label70:
    if (i1 < i2)
    {
      r localr = (r)this.jdField_c_of_type_JavaUtilList.get(i1);
      this.jdField_a_of_type_ArrayOfInt[i1] = localr.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[i1] = localr.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[i1] = localr.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[i1] = localr.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[i1] = localr.jdField_c_of_type_Int;
      if (localr.jdField_a_of_type_Int == 2) {
        break label169;
      }
      n = 0;
    }
    label169:
    for (;;)
    {
      i1 += 1;
      break label70;
      if (n != 0) {
        break;
      }
      return true;
    }
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
      DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getResources().getDisplayMetrics();
      this.jdField_h_of_type_Int = localDisplayMetrics.widthPixels;
      this.jdField_i_of_type_Int = localDisplayMetrics.heightPixels;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingRight();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingBottom();
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
      r localr = (r)this.jdField_c_of_type_JavaUtilList.get(n);
      this.jdField_a_of_type_ArrayOfInt[n] = localr.jdField_a_of_type_Char;
      this.jdField_b_of_type_ArrayOfInt[n] = localr.jdField_d_of_type_Int;
      this.jdField_c_of_type_ArrayOfInt[n] = localr.jdField_e_of_type_Int;
      this.jdField_d_of_type_ArrayOfInt[n] = localr.jdField_b_of_type_Int;
      this.jdField_e_of_type_ArrayOfInt[n] = localr.jdField_c_of_type_Int;
      this.jdField_l_of_type_ArrayOfInt[n] = 0;
      if (localr.jdField_a_of_type_Char == 65535) {
        this.jdField_l_of_type_ArrayOfInt[n] = 2;
      }
      if (localr.jdField_a_of_type_Char == '\n') {
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
      r localr1 = (r)this.jdField_c_of_type_JavaUtilList.get(n);
      if (this.jdField_l_of_type_ArrayOfInt[n] == 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(n));
        localr1.jdField_a_of_type_Boolean = true;
      }
      if (this.jdField_f_of_type_ArrayOfInt[n] >= this.jdField_a_of_type_JavaUtilList.size())
      {
        int i1 = this.jdField_a_of_type_JavaUtilList.size();
        while (i1 <= this.jdField_f_of_type_ArrayOfInt[n])
        {
          this.jdField_a_of_type_JavaUtilList.add(i1, new ArrayList());
          i1 += 1;
        }
      }
      List localList = (List)this.jdField_a_of_type_JavaUtilList.get(this.jdField_f_of_type_ArrayOfInt[n]);
      r localr2 = a();
      localr2.jdField_d_of_type_Int = (this.jdField_b_of_type_ArrayOfInt[n] - this.jdField_d_of_type_ArrayOfInt[n] / 2);
      localr2.jdField_e_of_type_Int = (this.jdField_c_of_type_ArrayOfInt[n] - this.jdField_e_of_type_ArrayOfInt[n] / 2);
      localr2.jdField_b_of_type_Int = this.jdField_d_of_type_ArrayOfInt[n];
      localr2.jdField_c_of_type_Int = this.jdField_e_of_type_ArrayOfInt[n];
      localr2.jdField_a_of_type_Char = localr1.jdField_a_of_type_Char;
      localr2.jdField_a_of_type_Boolean = localr1.jdField_a_of_type_Boolean;
      localr2.jdField_a_of_type_AndroidTextStyleCharacterStyle = localr1.jdField_a_of_type_AndroidTextStyleCharacterStyle;
      localr2.jdField_a_of_type_Int = localr1.jdField_a_of_type_Int;
      this.jdField_b_of_type_JavaUtilList.add(localr2);
      localList.add(this.jdField_g_of_type_ArrayOfInt[n], localr2);
      n += 1;
    }
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-16777216);
      }
      int n = 2;
      while (n < this.m.length)
      {
        int i1 = this.m[n];
        int i2 = this.m[(n + 1)];
        int i3 = this.m[(n + 2)];
        int i4 = this.m[(n + 3)];
        i4 = this.m[(n + 4)];
        r localr = (r)this.jdField_c_of_type_JavaUtilList.get(i1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(i4);
        float f1 = i4 / 2.0F;
        float f2 = (this.jdField_b_of_type_AndroidGraphicsPaint.descent() + this.jdField_b_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(localr.jdField_a_of_type_Char), i2, i3 + (f1 - f2), this.jdField_b_of_type_AndroidGraphicsPaint);
        n += 5;
      }
      this.jdField_c_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  private void n()
  {
    int i1 = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int n;
    label47:
    Object localObject;
    int i3;
    int i4;
    int i5;
    int i6;
    if (this.jdField_b_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      int i2 = this.jdField_c_of_type_JavaUtilList.size();
      n = 0;
      if (n >= i2) {
        return;
      }
      localObject = (r)this.jdField_c_of_type_JavaUtilList.get(n);
      i3 = this.jdField_d_of_type_ArrayOfInt[n];
      i4 = this.jdField_e_of_type_ArrayOfInt[n];
      i5 = this.jdField_b_of_type_ArrayOfInt[n] - i3 / 2;
      i6 = this.jdField_c_of_type_ArrayOfInt[n] - i4 / 2;
      switch (((r)localObject).jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      n += 1;
      break label47;
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      localObject = a(i3, i1);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, i5, i4 + i6 - i1, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      if ((((r)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bain))
      {
        ((bain)((r)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, i5, i6, i6 + i4, i6 + i4, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((((r)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof axye))
      {
        localObject = (axye)((r)localObject).jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((axye)localObject).jdField_a_of_type_Boolean = false;
        ((axye)localObject).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, i5, i6, i6, i6 + i4, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.jdField_h_of_type_ArrayOfInt);
    int i3 = paramInt1 - this.jdField_h_of_type_ArrayOfInt[0];
    int i4 = paramInt2 - this.jdField_h_of_type_ArrayOfInt[1];
    paramInt2 = this.jdField_b_of_type_JavaUtilList.size();
    paramInt1 = 0;
    Object localObject1;
    int n;
    int i1;
    int i5;
    while (paramInt1 < paramInt2)
    {
      localObject1 = (r)this.jdField_b_of_type_JavaUtilList.get(paramInt1);
      n = this.jdField_a_of_type_Int;
      i1 = ((r)localObject1).jdField_d_of_type_Int;
      i5 = this.jdField_c_of_type_Int;
      int i6 = ((r)localObject1).jdField_e_of_type_Int;
      int i7 = this.jdField_a_of_type_Int;
      int i8 = ((r)localObject1).jdField_d_of_type_Int;
      int i9 = ((r)localObject1).jdField_b_of_type_Int;
      int i10 = this.jdField_c_of_type_Int;
      int i11 = ((r)localObject1).jdField_e_of_type_Int;
      int i12 = ((r)localObject1).jdField_c_of_type_Int;
      if ((i3 >= n + i1) && (i3 <= i7 + i8 + i9) && (i4 >= i5 + i6) && (i4 <= i12 + (i10 + i11))) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    paramInt2 = 0;
    paramInt1 = 0;
    if (paramInt2 < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt2);
      if (localObject1 == null) {
        break label429;
      }
      if (((List)localObject1).size() > 0) {}
    }
    label429:
    for (;;)
    {
      paramInt2 += 1;
      break;
      Object localObject2 = ((List)localObject1).iterator();
      r localr;
      for (n = 0; ((Iterator)localObject2).hasNext(); n = localr.jdField_c_of_type_Int + (i1 + i5) + n)
      {
        localr = (r)((Iterator)localObject2).next();
        i1 = this.jdField_c_of_type_Int;
        i5 = localr.jdField_e_of_type_Int;
      }
      i1 = i2;
      if (n / ((List)localObject1).size() < i4)
      {
        if (paramInt2 == this.jdField_a_of_type_JavaUtilList.size() - 1) {
          i1 = i2;
        }
      }
      else
      {
        while (i1 < ((List)localObject1).size())
        {
          localObject2 = (r)((List)localObject1).get(i1);
          paramInt2 = this.jdField_a_of_type_Int;
          n = ((r)localObject2).jdField_d_of_type_Int;
          if (i3 <= ((r)localObject2).jdField_b_of_type_Int + (paramInt2 + n)) {
            return paramInt1 + i1;
          }
          i1 += 1;
        }
        return ((List)localObject1).size() + paramInt1;
      }
      paramInt1 += ((List)localObject1).size();
      continue;
      return -1;
    }
  }
  
  public int a(int paramInt1, int paramInt2, gg paramgg)
  {
    int n = 0;
    while (n < this.jdField_b_of_type_JavaUtilList.size())
    {
      paramgg = (r)this.jdField_b_of_type_JavaUtilList.get(n);
      if ((paramInt1 >= paramgg.jdField_d_of_type_Int) && (paramInt1 <= paramgg.jdField_d_of_type_Int + paramgg.jdField_b_of_type_Int) && (paramInt2 >= paramgg.jdField_e_of_type_Int))
      {
        int i1 = paramgg.jdField_e_of_type_Int;
        if (paramInt2 <= paramgg.jdField_c_of_type_Int + i1) {
          return n;
        }
      }
      n += 1;
    }
    return -1;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = f.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramInt1, paramInt2);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, localBitmap2, null, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
      f.b(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex, paramInt1, paramInt2, localBitmap2);
      localBitmap1 = localBitmap2;
      if (g.jdField_a_of_type_Boolean)
      {
        i.a(a(), "create new under line bitmap.... width:" + paramInt1 + "  height:" + paramInt2);
        localBitmap1 = localBitmap2;
      }
    }
    return localBitmap1;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new d(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i1 = this.jdField_b_of_type_JavaUtilList.size();
    int n = 0;
    if (n < i1)
    {
      if ((n < paramInt1) || (n >= paramInt2)) {}
      for (;;)
      {
        n += 1;
        break;
        r localr = (r)this.jdField_b_of_type_JavaUtilList.get(n);
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f1 = this.jdField_a_of_type_Int + localr.jdField_d_of_type_Int;
        float f2 = this.jdField_c_of_type_Int + localr.jdField_e_of_type_Int;
        float f3 = this.jdField_a_of_type_Int + localr.jdField_d_of_type_Int + localr.jdField_b_of_type_Int;
        int i2 = this.jdField_c_of_type_Int;
        int i3 = localr.jdField_e_of_type_Int;
        localPath.addRect(f1, f2, f3, localr.jdField_c_of_type_Int + (i2 + i3), Path.Direction.CW);
      }
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    r localr = (r)this.jdField_b_of_type_JavaUtilList.get(paramInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_Int + localr.jdField_d_of_type_Int;
      paramInt = paramArrayOfInt[1];
      n = this.jdField_c_of_type_Int;
      i1 = localr.jdField_e_of_type_Int;
      paramArrayOfInt[1] = (localr.jdField_c_of_type_Int + (n + i1) + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_Int + localr.jdField_d_of_type_Int + localr.jdField_b_of_type_Int;
    paramInt = paramArrayOfInt[1];
    n = this.jdField_c_of_type_Int;
    int i1 = localr.jdField_e_of_type_Int;
    paramArrayOfInt[1] = (localr.jdField_c_of_type_Int + (n + i1) + paramInt);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.hasSelected()) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-256);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  void a(String paramString)
  {
    int i1 = -1;
    Object localObject = null;
    String str;
    StringBuilder localStringBuilder;
    label68:
    int n;
    if (g.jdField_a_of_type_Boolean)
    {
      str = a();
      localStringBuilder = new StringBuilder().append(paramString).append("\n  text:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label416;
      }
      paramString = null;
      localStringBuilder = localStringBuilder.append(paramString).append("\n  fontId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label427;
      }
      paramString = null;
      paramString = localStringBuilder.append(paramString).append("\n  chars.length:");
      if (this.jdField_a_of_type_ArrayOfInt != null) {
        break label441;
      }
      n = 0;
      label90:
      paramString = paramString.append(n).append("\n  bitmapWidth:");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label450;
      }
      n = -1;
      label111:
      paramString = paramString.append(n).append("\n  bitmapHeight:");
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        break label461;
      }
      n = i1;
      label132:
      localStringBuilder = paramString.append(n).append("\n  viewWidth:").append(this.jdField_j_of_type_Int - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int).append("\n  viewHeight:").append(this.jdField_k_of_type_Int - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int).append("\n  paddingLeft:").append(this.jdField_a_of_type_Int).append("\n  paddingRight:").append(this.jdField_b_of_type_Int).append("\n  paddingTop:").append(this.jdField_c_of_type_Int).append("\n  paddingBottom:").append(this.jdField_d_of_type_Int).append("\n  screenWidth:").append(this.jdField_h_of_type_Int).append("\n  screenHeight:").append(this.jdField_i_of_type_Int).append("\n  x[]:").append(Arrays.toString(this.jdField_b_of_type_ArrayOfInt)).append("\n  y[]:").append(Arrays.toString(this.jdField_c_of_type_ArrayOfInt)).append("\n  width[]:").append(Arrays.toString(this.jdField_d_of_type_ArrayOfInt)).append("\n  height[]:").append(Arrays.toString(this.jdField_e_of_type_ArrayOfInt)).append("\n  mAnimationId:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label472;
      }
      paramString = null;
      label342:
      localStringBuilder = localStringBuilder.append(paramString).append("\n  shouldDisplayAnimation:");
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        break label486;
      }
    }
    label416:
    label427:
    label441:
    label450:
    label461:
    label472:
    label486:
    for (paramString = localObject;; paramString = Boolean.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation))
    {
      i.a(str, paramString + "\n  frameIndex:" + this.jdField_e_of_type_Int + "\n  animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt) + "\n");
      return;
      paramString = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mText;
      break;
      paramString = Integer.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId);
      break label68;
      n = this.jdField_a_of_type_ArrayOfInt.length;
      break label90;
      n = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      break label111;
      n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      break label132;
      paramString = Long.valueOf(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId);
      break label342;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (a())
    {
      i.a(a(), "ExpressionLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!b())
    {
      i.a(a(), "ExpressionLayout::onDraw 创建bitmap失败！");
      return false;
    }
    c();
    long l1 = System.nanoTime();
    m();
    g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
    a(paramCanvas);
    n();
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (this.jdField_e_of_type_Int == 0)) {
      b();
    }
    if (g.jdField_a_of_type_Boolean)
    {
      i.a(a(), l1, "字数：" + this.jdField_a_of_type_ArrayOfInt.length + "\n   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px\n");
      a("ExpressionLayout::onDraw......");
    }
    return true;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_Long == paramLong) && (this.jdField_b_of_type_Boolean == paramBoolean) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont)) && (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isCacheMeasureResult())) {
      return this.jdField_j_of_type_ArrayOfInt;
    }
    if (this.jdField_a_of_type_Long != paramLong)
    {
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation = false;
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.isFounderAnimating = false;
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
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath)) || (this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getVisibility() == 8))
    {
      this.jdField_j_of_type_ArrayOfInt[0] = n;
      this.jdField_j_of_type_ArrayOfInt[1] = i1;
      return this.jdField_j_of_type_ArrayOfInt;
    }
    paramETFont = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getText();
    if (TextUtils.isEmpty(paramETFont))
    {
      this.jdField_j_of_type_ArrayOfInt[0] = n;
      this.jdField_j_of_type_ArrayOfInt[1] = i1;
      return this.jdField_j_of_type_ArrayOfInt;
    }
    paramLong = System.nanoTime();
    a(paramInt1, paramInt2, paramETFont);
    long l1 = System.nanoTime();
    if (g.jdField_a_of_type_Boolean) {
      i.a(a(), "字数：" + paramETFont.length() + "   字号：" + this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() + "px   排版耗时：" + (float)(l1 - paramLong) / 1000000.0F + "ms");
    }
    if (a())
    {
      this.jdField_j_of_type_ArrayOfInt[0] = n;
      this.jdField_j_of_type_ArrayOfInt[1] = i1;
      return this.jdField_j_of_type_ArrayOfInt;
    }
    this.jdField_j_of_type_ArrayOfInt[0] = this.jdField_j_of_type_Int;
    this.jdField_j_of_type_ArrayOfInt[1] = this.jdField_k_of_type_Int;
    return this.jdField_j_of_type_ArrayOfInt;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (a())) {}
    while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    if (g.jdField_a_of_type_Boolean) {
      i.a(a(), "StartAnimation......animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
    }
    this.jdField_e_of_type_Int = 0;
    if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
    {
      h();
      return;
    }
    g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_l_of_type_ArrayOfInt, this.jdField_f_of_type_Int, this.jdField_l_of_type_Int, this.jdField_g_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
    if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
    {
      h();
      return;
    }
    i.b(a(), "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
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
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void e()
  {
    super.e();
    this.jdField_b_of_type_AndroidGraphicsCanvas = null;
    this.jdField_c_of_type_AndroidGraphicsCanvas = null;
    this.jdField_a_of_type_AndroidGraphicsCanvas = null;
    if (this.jdField_b_of_type_AndroidGraphicsPaint != null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.reset();
      this.jdField_b_of_type_AndroidGraphicsPaint = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    }
    if (this.jdField_a_of_type_AndroidGraphicsPath != null) {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c
 * JD-Core Version:    0.7.0.1
 */