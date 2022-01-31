import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class bjhy
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  Resources jdField_a_of_type_AndroidContentResResources;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString;
  List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList(2);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public bjhy(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
    this.jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(actj.a(9.0F, this.jdField_a_of_type_AndroidContentResResources));
    this.g = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
    if (this.jdField_b_of_type_Int <= 0)
    {
      this.jdField_b_of_type_Int += this.g;
      this.jdField_b_of_type_Int += actj.a(3.0F, this.jdField_a_of_type_AndroidContentResResources);
      paramInt = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight() + paramInt);
    }
    if (this.c <= 0)
    {
      this.c += this.g;
      this.c += actj.a(3.0F, this.jdField_a_of_type_AndroidContentResResources);
      paramInt = this.c;
      this.c = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getHeight() + paramInt);
    }
    if (this.h <= 0) {
      this.h = actj.a(2.0F, this.jdField_a_of_type_AndroidContentResResources);
    }
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public float a()
  {
    return this.d + this.h * 2;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    this.jdField_a_of_type_JavaLangString = super.b(paramInt);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\n", "");
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\r", "");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangString = " ";
      this.jdField_a_of_type_Boolean = false;
      paramInt = bjiw.a(this.jdField_a_of_type_JavaLangString);
      if (paramInt >= 5) {
        break label184;
      }
      this.f = 1;
      this.d = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth() * paramInt);
      if (paramInt > 1) {
        this.d += (paramInt - 1) * actj.a(9.0F, this.jdField_a_of_type_AndroidContentResResources);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label176;
      }
    }
    label176:
    for (paramInt = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight();; paramInt = this.jdField_b_of_type_Int)
    {
      this.e = paramInt;
      return;
      this.jdField_b_of_type_Boolean = false;
      break;
    }
    label184:
    this.d = (((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getWidth() * 5 + actj.a(9.0F, this.jdField_a_of_type_AndroidContentResResources) * 4);
    this.f = (paramInt / 5);
    if (paramInt % 5 > 0) {
      this.f += 1;
    }
    this.e = ((this.f - 1) * this.c + (this.f - 1) * actj.a(15.0F, this.jdField_a_of_type_AndroidContentResResources));
    int i = this.e;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = (int)(this.jdField_a_of_type_Float * this.c + 0.5F);; paramInt = this.c)
    {
      this.e = (paramInt + i);
      return;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    int j;
    label25:
    int k;
    label48:
    int m;
    label71:
    int i5;
    int i6;
    int i7;
    int n;
    label115:
    int i1;
    label131:
    float f1;
    int i8;
    if (bjiw.a(this.jdField_a_of_type_JavaLangString) < 5)
    {
      j = 1;
      if (j == 0) {
        break label284;
      }
      k = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getWidth();
      if (j == 0) {
        break label305;
      }
      m = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0)).getHeight();
      i5 = actj.a(9.0F, this.jdField_a_of_type_AndroidContentResResources);
      i6 = actj.a(15.0F, this.jdField_a_of_type_AndroidContentResResources);
      i7 = actj.a(3.0F, this.jdField_a_of_type_AndroidContentResResources);
      if (j == 0) {
        break label326;
      }
      n = this.jdField_b_of_type_Int;
      if (j == 0) {
        break label335;
      }
      i1 = actj.a(40.0F, this.jdField_a_of_type_AndroidContentResResources);
      f1 = actj.a(9.0F, this.jdField_a_of_type_AndroidContentResResources);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i1);
      i8 = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
      paramCanvas.save();
      paramCanvas.translate(this.h, this.h);
      if (!this.jdField_b_of_type_Boolean) {
        break label349;
      }
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(0), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    for (;;)
    {
      paramCanvas.restore();
      if (!super.b(0)) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = a();
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = b();
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      return;
      j = 0;
      break label25;
      label284:
      k = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getWidth();
      break label48;
      label305:
      m = ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(1)).getHeight();
      break label71;
      label326:
      n = this.c;
      break label115;
      label335:
      i1 = actj.a(36.0F, this.jdField_a_of_type_AndroidContentResResources);
      break label131;
      label349:
      paramCanvas.save();
      int i2 = 0;
      int i = 0;
      while (i2 < this.f)
      {
        int i3;
        label416:
        int i4;
        label419:
        String str;
        label473:
        Object localObject;
        if ((this.jdField_a_of_type_Boolean) && (i2 == this.f - 1))
        {
          i3 = 1;
          paramCanvas.save();
          if (i3 == 0) {
            break label690;
          }
          paramCanvas.scale(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
          i3 = 6;
          i4 = 0;
          if ((i4 >= i3) || (i >= this.jdField_a_of_type_JavaLangString.length())) {
            break label755;
          }
          int i9 = bjiw.a(this.jdField_a_of_type_JavaLangString.charAt(i));
          if (i9 != 2) {
            break label696;
          }
          str = this.jdField_a_of_type_JavaLangString.substring(i, i + 2);
          float f2 = 0.5F * k;
          if ((i9 == 0) || (i9 == 3))
          {
            if (i9 != 3) {
              break label714;
            }
            localObject = str;
            label501:
            this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
            float f3 = this.g;
            float f4 = this.jdField_a_of_type_AndroidTextTextPaint.descent();
            this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
            paramCanvas.drawText((String)localObject, f2, f3 - f4, this.jdField_a_of_type_AndroidTextTextPaint);
          }
          paramCanvas.save();
          paramCanvas.translate(0.0F, this.g + i7);
          if (j == 0) {
            break label728;
          }
          localObject = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(0);
          label589:
          paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
          paramCanvas.restore();
          this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(i1);
          paramCanvas.drawText(str, f2, this.g + i7 + 0.5F * (m - i8) - this.jdField_a_of_type_AndroidTextTextPaint.ascent(), this.jdField_a_of_type_AndroidTextTextPaint);
          if (i9 != 2) {
            break label746;
          }
          i += 2;
        }
        for (;;)
        {
          paramCanvas.translate(k + i5, 0.0F);
          i4 += 1;
          break label419;
          i3 = 0;
          break;
          label690:
          i3 = 5;
          break label416;
          label696:
          str = this.jdField_a_of_type_JavaLangString.substring(i, i + 1);
          break label473;
          label714:
          localObject = ChnToSpell.a(str, 1).jdField_a_of_type_JavaLangString;
          break label501;
          label728:
          localObject = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(1);
          break label589;
          label746:
          i += 1;
        }
        label755:
        paramCanvas.restore();
        paramCanvas.translate(0.0F, n + i6);
        i2 += 1;
      }
      paramCanvas.restore();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.e + this.h * 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjhy
 * JD-Core Version:    0.7.0.1
 */