import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class bltl
  extends DynamicTextItem
{
  private Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = alpo.a(2131706262);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 16;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private int jdField_c_of_type_Int = 8;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_c_of_type_AndroidTextTextPaint;
  private int jdField_d_of_type_Int = -1;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_e_of_type_Int = 12;
  private RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private int f = 10;
  private int g = 15;
  private int h = 25;
  private int i = 20;
  private int j = 5;
  private int k = 3;
  private int l = -5;
  private int m;
  private int n;
  
  public bltl(int paramInt, List<String> paramList, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap1, paramBitmap1.getNinePatchChunk(), null);
    this.jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap2, paramBitmap2.getNinePatchChunk(), null);
    d();
    this.m = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(alpo.a(2131706263)));
    this.n = ((int)(this.jdField_b_of_type_AndroidTextTextPaint.measureText(alpo.a(2131706261)) * 10.0F));
    if (paramList == null) {}
    for (paramInt = 0;; paramInt = paramList.size())
    {
      int i1 = 0;
      while (i1 < paramInt)
      {
        a(i1, (String)paramList.get(i1));
        QLog.i("JourneyTextItem", 2, "JourneyTextItem index: " + i1 + " text: " + (String)paramList.get(i1));
        i1 += 1;
      }
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if ((paramRectF == null) || (paramPointF == null)) {}
    do
    {
      return false;
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
    } while ((paramFloat1 <= paramRectF.left) || (paramFloat1 >= paramRectF.right) || (paramFloat2 <= paramRectF.top) || (paramFloat2 >= paramRectF.bottom));
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_c_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_c_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int * 0.8F);
    this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Int);
  }
  
  public float a()
  {
    return (int)Math.max(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.width());
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_e_of_type_AndroidGraphicsRectF.left * f1, this.jdField_e_of_type_AndroidGraphicsRectF.top * f1, this.jdField_e_of_type_AndroidGraphicsRectF.right * f1, f1 * this.jdField_e_of_type_AndroidGraphicsRectF.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 0;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 1;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable bmmn parambmmn, bmtw parambmtw)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (parambmmn != null) {
      return parambmtw.a(parambmmn, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - a()) / 2.0F, (paramFloat2 - b()) / 2.0F);
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.jdField_e_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 1;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new blto(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return;
    }
    super.a(paramInt, paramString);
    String str2 = a(paramInt, new bltm(this));
    if (QLog.isColorLevel()) {
      QLog.i("JourneyTextItem", 2, "setText index: " + paramInt + " text: " + str2);
    }
    String str1 = "";
    float f5;
    float f4;
    float f1;
    float f2;
    float f6;
    int i1;
    label173:
    float f3;
    if (paramInt == 0)
    {
      paramString = bcjk.b(str2);
      this.jdField_a_of_type_JavaUtilList.clear();
      f5 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
      f4 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      f1 = this.jdField_b_of_type_AndroidGraphicsRectF.width();
      this.jdField_b_of_type_AndroidGraphicsRectF.height();
      f2 = this.jdField_d_of_type_AndroidGraphicsRectF.width();
      f6 = this.jdField_d_of_type_AndroidGraphicsRectF.height();
      if (paramInt != 0) {
        break label965;
      }
      paramString = paramString.split("\n");
      int i3 = paramString.length;
      i1 = 0;
      paramInt = 0;
      int i2 = paramInt;
      if (i1 < i3)
      {
        str1 = paramString[i1];
        if (str1.length() < 20) {
          break label707;
        }
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, 15));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(15, 20));
        paramInt = 5;
        label274:
        if (this.jdField_a_of_type_JavaUtilList.size() <= 4) {
          break label956;
        }
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, 4);
        i2 = paramInt;
      }
      paramInt = this.jdField_a_of_type_JavaUtilList.size();
      i1 = this.h;
      i3 = this.g;
      f5 = paramInt * this.jdField_b_of_type_Int + (i1 * 2 + (paramInt - 1) * i3);
      paramInt = this.i;
      i1 = this.f;
      f4 = i2 * this.jdField_b_of_type_Int + (paramInt * 2 + (i2 - 1) * i1);
      f3 = f1;
      f1 = f6;
      label387:
      paramInt = this.jdField_e_of_type_Int;
      if (f5 <= f3) {
        break label1031;
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f5, f4);
      this.jdField_d_of_type_AndroidGraphicsRectF.set((f5 - f2) * 0.5F, paramInt + f4 + this.k, f2 + (f5 - f2) * 0.5F, f4 + paramInt + f1 + this.k);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.h * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.top + this.i * 0.7F, this.jdField_a_of_type_AndroidGraphicsRectF.right - this.h * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.i * 0.7F);
      this.jdField_e_of_type_AndroidGraphicsRectF.set(this.jdField_d_of_type_AndroidGraphicsRectF.left - this.h * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.top - this.i * 0.2F, this.jdField_d_of_type_AndroidGraphicsRectF.right + this.h * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.bottom + this.i * 0.2F);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.bottom + this.l, f3 + this.jdField_e_of_type_AndroidGraphicsRectF.left, f1 + this.jdField_e_of_type_AndroidGraphicsRectF.bottom + this.l);
      return;
      this.jdField_a_of_type_JavaLangString = str2;
      paramString = str1;
      if (this.jdField_a_of_type_JavaLangString.length() < 20) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 20);
      paramString = str1;
      break;
      label707:
      if (str1.length() > 15)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, 15));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(15, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 10)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 5)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, str1.length()));
        paramInt = 5;
        break label274;
      }
      this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, str1.length()));
      paramInt = Math.max(paramInt, str1.length());
      break label274;
      label956:
      i1 += 1;
      break label173;
      label965:
      this.jdField_a_of_type_AndroidTextStaticLayout = blui.a(str2, 0, str2.length(), this.jdField_b_of_type_AndroidTextTextPaint, this.n, Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false, null, 0, 2);
      f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(0);
      f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      f3 = this.j + f2;
      break label387;
      label1031:
      f6 = (f3 - f5) * 0.5F;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f6, 0.0F, f5 + f6, f4);
      this.jdField_d_of_type_AndroidGraphicsRectF.set((f3 - f2) * 0.5F, paramInt + f4 + this.k, f2 + (f3 - f2) * 0.5F, f4 + paramInt + f1 + this.k);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (b(0)) {
      paramCanvas.drawRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    if (b(1)) {
      paramCanvas.drawRoundRect(this.jdField_e_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    this.jdField_a_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_b_of_type_AndroidGraphicsRectF);
    int i2 = (int)(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.h * 1.3D);
    int i1 = (int)(this.i + this.m * 0.8D);
    int i3 = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i3 >= 0)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(i3);
      int i6 = str.length();
      int i5 = 0;
      int i4 = i1;
      i1 = i5;
      while (i1 < i6)
      {
        paramCanvas.drawText(str.substring(i1, i1 + 1), i2, i4, this.jdField_a_of_type_AndroidTextTextPaint);
        i4 += this.m + this.f;
        i1 += 1;
      }
      i4 = this.m;
      i5 = this.g;
      i1 = (int)(this.i + this.m * 0.8D);
      i3 -= 1;
      i2 += i4 + i5;
    }
    paramCanvas.translate(this.jdField_d_of_type_AndroidGraphicsRectF.left, this.jdField_d_of_type_AndroidGraphicsRectF.top);
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null) {
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.top;
  }
  
  public boolean b()
  {
    boolean bool = false;
    String str1 = a(0, new bltn(this));
    String str2 = b(1);
    if (((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) || (super.b())) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltl
 * JD-Core Version:    0.7.0.1
 */