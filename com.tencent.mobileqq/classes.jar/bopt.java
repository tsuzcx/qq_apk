import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class bopt
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float = 0.85F;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_b_of_type_Float = 0.9F;
  private int jdField_b_of_type_Int = 4;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private float jdField_c_of_type_Float = 2.0F;
  private int jdField_c_of_type_Int = 4;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 36;
  private int e = 36;
  private int f = 95;
  private int g = 180;
  private int h;
  private int i;
  private int j;
  private int k = 1;
  
  public bopt(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
    this.jdField_c_of_type_AndroidGraphicsBitmap = paramBitmap3;
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_b_of_type_Int = afur.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_d_of_type_Int = afur.a(this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.jdField_c_of_type_Int = afur.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
    this.e = afur.a(this.e, this.jdField_a_of_type_AndroidContentResResources);
    this.f = afur.a(this.f, this.jdField_a_of_type_AndroidContentResResources);
    this.g = afur.a(this.g, this.jdField_a_of_type_AndroidContentResResources);
    this.j = this.jdField_b_of_type_Int;
    a(paramTypeface);
    int m = Math.min(paramList.size(), a());
    paramInt = 0;
    while (paramInt < m)
    {
      a(paramInt, (String)paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  private void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#045389"));
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#ddf3fd"));
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(afur.a(2.0F, this.jdField_a_of_type_AndroidContentResResources));
    if (Build.VERSION.SDK_INT >= 21) {
      this.jdField_b_of_type_AndroidTextTextPaint.setShadowLayer(afur.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), afur.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), afur.a(1.0F, this.jdField_a_of_type_AndroidContentResResources), Color.parseColor("#33000000"));
    }
  }
  
  private void d()
  {
    this.jdField_d_of_type_Float *= this.jdField_b_of_type_Float;
  }
  
  public float a()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.width();
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new bopv(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = bfsj.b(super.a(paramInt, new bopu(this))).replaceAll("\n", "");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramInt = paramString.length();
    if (paramInt > 10)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 10));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(10, Math.min(20, paramInt)));
      this.jdField_d_of_type_Float = Math.min(this.g / 10, this.jdField_d_of_type_Int / this.jdField_c_of_type_Float);
      d();
      paramInt = (int)((this.jdField_d_of_type_Int - this.jdField_d_of_type_Float * 2.0F) / 3.0F);
      this.i = paramInt;
      this.h = paramInt;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_d_of_type_Int + this.jdField_c_of_type_Int * 2, 10.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_Int * 2 + this.j * 2);
      this.k = 3;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF.left + this.jdField_c_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.right - this.jdField_c_of_type_Int * 1.2F, this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_b_of_type_Int * 1.2F);
      return;
      if (paramInt > 5)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 5));
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(5, paramInt));
        this.jdField_d_of_type_Float = ((int)Math.min(this.f / 5, this.jdField_d_of_type_Int / this.jdField_c_of_type_Float));
        d();
        paramInt = (int)((this.jdField_d_of_type_Int - this.jdField_d_of_type_Float * 2.0F) / 3.0F);
        this.i = paramInt;
        this.h = paramInt;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_d_of_type_Int + this.jdField_c_of_type_Int * 2, 5.0F * this.jdField_d_of_type_Float + this.jdField_b_of_type_Int * 2 + this.j * 2);
        this.k = 2;
      }
      else if (paramInt > 1)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_d_of_type_Float = Math.min(this.jdField_d_of_type_Int, this.f / paramInt);
        d();
        this.h = 0;
        this.i = ((int)((this.jdField_d_of_type_Int - this.jdField_d_of_type_Float) / 2.0F));
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_d_of_type_Int + this.jdField_c_of_type_Int * 2, paramInt * this.jdField_d_of_type_Float + this.jdField_b_of_type_Int * 2 + this.j * 2);
        this.k = 2;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.jdField_d_of_type_Float = this.jdField_d_of_type_Int;
        d();
        this.jdField_b_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_d_of_type_Int + this.jdField_c_of_type_Int * 2, this.jdField_d_of_type_Float + this.jdField_b_of_type_Int * 2 + this.j * 2);
        this.h = 0;
        this.i = ((int)((this.jdField_d_of_type_Int - this.jdField_d_of_type_Float) / 2.0F));
        this.k = 1;
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    Object localObject;
    if (1 == this.k) {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (;;)
    {
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRectF, null);
      }
      if (super.b(0)) {
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_d_of_type_Float);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_d_of_type_Float);
      int i1 = (int)(this.jdField_c_of_type_Int + this.i + this.jdField_d_of_type_Float * 0.5D);
      int m = (int)(this.jdField_b_of_type_Int + this.jdField_d_of_type_Float * this.jdField_a_of_type_Float + this.j);
      int n = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        if (n < 0) {
          break label341;
        }
        localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        int i4 = ((String)localObject).length();
        int i3 = 0;
        int i2 = m;
        m = i3;
        for (;;)
        {
          if (m < i4)
          {
            paramCanvas.drawText(((String)localObject).substring(m, m + 1), i1, i2, this.jdField_b_of_type_AndroidTextTextPaint);
            paramCanvas.drawText(((String)localObject).substring(m, m + 1), i1, i2, this.jdField_a_of_type_AndroidTextTextPaint);
            i2 = (int)(i2 + this.jdField_d_of_type_Float);
            m += 1;
            continue;
            if (2 == this.k)
            {
              localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
              break;
            }
            if (3 != this.k) {
              break label342;
            }
            localObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
            break;
          }
        }
        i1 = (int)(i1 + (this.h + this.jdField_d_of_type_Float));
        m = (int)(this.jdField_b_of_type_Int + this.jdField_d_of_type_Float * this.jdField_a_of_type_Float + this.j);
        n -= 1;
      }
      label341:
      return;
      label342:
      localObject = null;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.height();
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopt
 * JD-Core Version:    0.7.0.1
 */