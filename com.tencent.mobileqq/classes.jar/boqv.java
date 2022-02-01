import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class boqv
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float = 0.73F;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "#ffffff";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float jdField_b_of_type_Float = 0.31F;
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  public boqv(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * paramFloat);
  }
  
  private void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramTypeface);
    this.e = a(48.75F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.e);
    this.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(anni.a(2131703496)));
    this.f = a(27.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.f);
    this.c = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(anni.a(2131703495)));
    this.g = a(18.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.g);
    this.d = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(anni.a(2131703497)));
    this.k = a(0.0F);
    this.l = a(0.0F);
    this.h = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * 0.98D));
    this.i = ((int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 0.98D));
  }
  
  public float a()
  {
    return this.h;
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new boqx(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = super.a(paramInt, new boqw(this));
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    int i1 = paramString.length();
    int n;
    if (i1 > 10)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(0, 10));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString.substring(10, Math.min(i1, 20)));
      this.j = this.g;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
      this.m = this.d;
      paramInt = this.m;
      n = this.k + paramInt * 2;
      paramInt = this.m * 10 + this.l * 9;
    }
    while (paramInt > this.i * this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, paramInt - this.jdField_a_of_type_Float * this.i, this.h, this.i * (1.0F - this.jdField_a_of_type_Float) + paramInt);
      paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
      f1 = this.h - n;
      f2 = this.jdField_b_of_type_Float;
      f3 = this.h;
      f4 = this.jdField_b_of_type_Float;
      paramString.set(f1 * f2, 0.0F, n * (1.0F - this.jdField_b_of_type_Float) + f3 * f4, paramInt);
      return;
      int i2;
      if (i1 > 5)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.j = this.f;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
        this.m = this.c;
        n = this.m * 1;
        paramInt = this.m;
        i2 = this.l;
        paramInt = Math.max(i1 - 1, 0) * i2 + paramInt * i1;
      }
      else
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        this.j = this.e;
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
        this.m = this.jdField_b_of_type_Int;
        n = this.m * 1;
        paramInt = i1;
        if (i1 == 0) {
          paramInt = 2;
        }
        i1 = this.m;
        i2 = this.l;
        paramInt = Math.max(paramInt - 1, 0) * i2 + i1 * paramInt;
      }
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.h, this.i);
    paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f1 = this.h - n;
    float f2 = this.jdField_b_of_type_Float;
    float f3 = (this.i * this.jdField_a_of_type_Float - paramInt) / 2.0F;
    float f4 = this.h;
    float f5 = this.jdField_b_of_type_Float;
    float f6 = n;
    float f7 = this.jdField_b_of_type_Float;
    float f8 = this.i;
    float f9 = this.jdField_a_of_type_Float;
    paramString.set(f1 * f2, f3, f6 * (1.0F - f7) + f4 * f5, (paramInt + f8 * f9) / 2.0F);
  }
  
  public void a(Canvas paramCanvas)
  {
    Object localObject = new Rect();
    ((Rect)localObject).set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    if (super.b(0)) {
      paramCanvas.drawRoundRect(new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left, this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_b_of_type_AndroidGraphicsRectF.right, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + this.m * 0.1F), 6.0F, 6.0F, a());
    }
    int i1 = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.left + 0.5D * this.m);
    int n = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.m);
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i2 >= 0)
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
      int i5 = ((String)localObject).length();
      int i4 = 0;
      int i3 = n;
      n = i4;
      while (n < i5)
      {
        paramCanvas.drawText(((String)localObject).substring(n, n + 1), i1, i3, this.jdField_a_of_type_AndroidTextTextPaint);
        i3 += this.m + this.l;
        n += 1;
      }
      i3 = this.m;
      i4 = this.k;
      n = (int)(this.jdField_b_of_type_AndroidGraphicsRectF.top + this.m);
      i2 -= 1;
      i1 += i3 + i4;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.bottom - Math.min(this.jdField_b_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqv
 * JD-Core Version:    0.7.0.1
 */