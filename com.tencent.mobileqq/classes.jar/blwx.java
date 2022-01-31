import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import java.util.ArrayList;
import java.util.List;

public class blwx
  extends DynamicTextItem
{
  float jdField_a_of_type_Float = 0.0F;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  blwv jdField_a_of_type_Blwv = null;
  ArrayList<blwv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int;
  float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private int f;
  private int g;
  
  public blwx(int paramInt, @NonNull List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(aepi.a(3.0F, BaseApplicationImpl.getContext().getResources()));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      this.g = paramInt;
      this.jdField_d_of_type_Int = aepi.a(paramFloat1, BaseApplicationImpl.getApplication().getResources());
      this.jdField_e_of_type_Int = aepi.a(paramFloat2, BaseApplicationImpl.getApplication().getResources());
      this.f = aepi.a(paramFloat3, BaseApplicationImpl.getApplication().getResources());
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = aepi.a(paramFloat, BaseApplicationImpl.getContext().getResources());
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, Point paramPoint)
  {
    int j = paramInt3;
    while (j >= paramInt4)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(j);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(j);
      StaticLayout localStaticLayout1 = blyu.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      StaticLayout localStaticLayout2 = blyu.a(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      this.jdField_b_of_type_AndroidTextStaticLayout = localStaticLayout1;
      this.jdField_a_of_type_AndroidTextStaticLayout = localStaticLayout2;
      paramInt3 = 1;
      int i = 1;
      if (localStaticLayout1.getLineCount() > 1)
      {
        if (localStaticLayout1.getLineVisibleEnd(1) < paramString.length()) {
          i = 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BasicTextRegionTextItem", 2, "[" + paramString.length() + "," + paramInt5 + "," + localStaticLayout1.getLineEnd(0));
        }
        paramInt3 = i;
        if (paramString.length() >= paramInt5)
        {
          paramInt3 = i;
          if (localStaticLayout1.getLineEnd(0) < paramInt5) {
            paramInt3 = 0;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("BasicTextRegionTextItem", 2, "==>" + localStaticLayout1.getHeight() + " ==>" + paramInt2 + " ==>" + j + " ==>" + paramInt4);
      }
      if (localStaticLayout1.getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        float f1 = super.a(localStaticLayout1);
        float f2 = localStaticLayout1.getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      j -= 1;
    }
    return false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Blwv.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new blwy(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = super.b(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = a(10, paramString);
    Object localObject3 = new Point[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramString = new float[this.jdField_a_of_type_JavaUtilArrayList.size()];
    localObject1 = new boolean[this.jdField_a_of_type_JavaUtilArrayList.size()];
    StaticLayout[] arrayOfStaticLayout1 = new StaticLayout[this.jdField_a_of_type_JavaUtilArrayList.size()];
    StaticLayout[] arrayOfStaticLayout2 = new StaticLayout[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int[] arrayOfInt = new int[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3[paramInt] = new Point(0, 0);
      blwv localblwv = (blwv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localObject1[paramInt] = 0;
      f1 = localblwv.jdField_c_of_type_Int;
      f2 = localblwv.jdField_d_of_type_Int;
      localObject1[paramInt] = a((int)f1, (int)f2, localblwv.h, localblwv.g, (String)localObject2, localblwv.jdField_a_of_type_Int, localblwv.i, localObject3[paramInt]);
      arrayOfStaticLayout1[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout;
      arrayOfStaticLayout2[paramInt] = this.jdField_a_of_type_AndroidTextStaticLayout;
      paramString[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramInt = 0;
    if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3 = (blwv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramString[paramInt]);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(paramString[paramInt]);
      arrayOfInt[paramInt] = arrayOfStaticLayout1[paramInt].getLineCount();
      if (localObject1[paramInt] != 0)
      {
        f1 = aepi.a(((blwv)localObject3).jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
        f2 = aepi.a(((blwv)localObject3).jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout1[paramInt]) * arrayOfStaticLayout1[paramInt].getHeight() / (f2 * f1));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BasicTextRegionTextItem", 2, "scale:" + localObject2[paramInt] + " index:" + paramInt);
        }
        paramInt += 1;
        break;
        localObject2[paramInt] = 0.0F;
      }
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    if (paramInt >= 0) {
      if ((localObject1[paramInt] == 1) && (localObject1[i] == 1)) {
        i = paramInt;
      }
    }
    for (;;)
    {
      paramInt -= 1;
      break;
      if (localObject2[paramInt] > localObject2[i])
      {
        int j;
        if ((localObject1[paramInt] == 1) && (localObject1[i] == 1) && (arrayOfInt[paramInt] > arrayOfInt[i])) {
          j = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            i = paramInt;
            break;
            j = 0;
            continue;
            if (QLog.isColorLevel()) {
              QLog.i("BasicTextRegionTextItem", 2, "curIndex:" + i);
            }
            this.jdField_a_of_type_Blwv = ((blwv)this.jdField_a_of_type_JavaUtilArrayList.get(i));
            this.jdField_b_of_type_AndroidTextStaticLayout = arrayOfStaticLayout1[i];
            this.jdField_a_of_type_AndroidTextStaticLayout = arrayOfStaticLayout2[i];
            this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramString[i]);
            this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(paramString[i]);
            return;
          }
        }
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.jdField_a_of_type_Blwv.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      this.jdField_c_of_type_Float = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      this.jdField_d_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_Blwv.jdField_e_of_type_Int + (this.jdField_a_of_type_Blwv.jdField_c_of_type_Int - this.jdField_c_of_type_Float) / 2.0F);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Blwv.f + (this.jdField_a_of_type_Blwv.jdField_d_of_type_Int - this.jdField_d_of_type_Float) / 2.0F);
      paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_d_of_type_Int);
        this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.g);
        paramCanvas.translate(this.jdField_e_of_type_Int, this.f);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
        paramCanvas.translate(-this.jdField_e_of_type_Int, -this.f);
      }
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (0.0F - this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (0.0F - this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_c_of_type_Float + this.jdField_e_of_type_Float * 2.0F);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_d_of_type_Float + this.jdField_e_of_type_Float * 2.0F);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Blwv.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwx
 * JD-Core Version:    0.7.0.1
 */