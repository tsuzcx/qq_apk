import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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

public class bhnl
  extends DynamicTextItem
{
  private static float[] jdField_a_of_type_ArrayOfFloat = { 62.0F, 35.5F, 8.0F, 13.0F, 117.0F, 35.0F, 22.0F, 14.0F, 181.0F, 40.0F, 25.0F, 13.0F };
  private float jdField_a_of_type_Float;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList(3);
  private int b;
  
  public bhnl(int paramInt, Typeface paramTypeface, @NonNull List<String> paramList, @NonNull List<Bitmap> paramList1)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString, Point paramPoint)
  {
    int i = paramInt3;
    while (i >= 16)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(aciy.a(i, this.jdField_a_of_type_AndroidContentResResources));
      StaticLayout localStaticLayout = bhno.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
      this.jdField_b_of_type_AndroidTextStaticLayout = localStaticLayout;
      int j = 1;
      paramInt3 = j;
      if (localStaticLayout.getLineCount() > 1)
      {
        paramInt3 = j;
        if (localStaticLayout.getLineVisibleEnd(1) < paramString.length()) {
          paramInt3 = 0;
        }
      }
      if (localStaticLayout.getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        float f1 = super.a(localStaticLayout);
        float f2 = localStaticLayout.getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      i -= 2;
    }
    return false;
  }
  
  public float a()
  {
    return ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).getWidth();
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new bhnm(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = b(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = a(10, paramString);
    Point[] arrayOfPoint = new Point[3];
    paramString = new float[3];
    localObject1 = new boolean[3];
    StaticLayout[] arrayOfStaticLayout = new StaticLayout[3];
    int[] arrayOfInt = new int[3];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < 3)
    {
      arrayOfPoint[paramInt] = new Point(0, 0);
      localObject1[paramInt] = 0;
      f1 = aciy.a(jdField_a_of_type_ArrayOfFloat[(paramInt * 4)], this.jdField_a_of_type_AndroidContentResResources);
      f2 = aciy.a(jdField_a_of_type_ArrayOfFloat[(paramInt * 4 + 1)], this.jdField_a_of_type_AndroidContentResResources);
      localObject1[paramInt] = a((int)f1, (int)f2, 37, (String)localObject2, arrayOfPoint[paramInt]);
      arrayOfStaticLayout[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout;
      paramString[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[3];
    paramInt = 0;
    if (paramInt < 3)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramString[paramInt]);
      arrayOfInt[paramInt] = arrayOfStaticLayout[paramInt].getLineCount();
      if (localObject1[paramInt] != 0)
      {
        f1 = aciy.a(jdField_a_of_type_ArrayOfFloat[(paramInt * 4)], this.jdField_a_of_type_AndroidContentResResources);
        f2 = aciy.a(jdField_a_of_type_ArrayOfFloat[(paramInt * 4 + 1)], this.jdField_a_of_type_AndroidContentResResources);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout[paramInt]) * arrayOfStaticLayout[paramInt].getHeight() / (f1 * f2));
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShadowBubbleTextItem", 2, "scale:" + localObject2[paramInt] + " index:" + paramInt);
        }
        paramInt += 1;
        break;
        localObject2[paramInt] = 0.0F;
      }
    }
    int j = 2;
    paramInt = 2;
    if (paramInt >= 0)
    {
      int i;
      if ((localObject1[paramInt] == 1) && (localObject1[j] == 1) && (arrayOfInt[paramInt] < arrayOfInt[j])) {
        i = paramInt;
      }
      do
      {
        paramInt -= 1;
        j = i;
        break;
        i = j;
      } while (localObject2[paramInt] <= localObject2[j]);
      if ((localObject1[paramInt] == 1) && (localObject1[j] == 1) && (arrayOfInt[paramInt] > arrayOfInt[j])) {}
      for (int k = 1;; k = 0)
      {
        i = j;
        if (k != 0) {
          break;
        }
        i = paramInt;
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShadowBubbleTextItem", 2, "curIndex:" + j);
    }
    this.jdField_b_of_type_Int = j;
    this.jdField_b_of_type_AndroidTextStaticLayout = arrayOfStaticLayout[j];
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramString[j]);
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int), 0.0F, 0.0F, this.jdField_a_of_type_AndroidTextTextPaint);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      float f1 = aciy.a(jdField_a_of_type_ArrayOfFloat[(this.jdField_b_of_type_Int * 4 + 2)], this.jdField_a_of_type_AndroidContentResResources);
      float f2 = aciy.a(jdField_a_of_type_ArrayOfFloat[(this.jdField_b_of_type_Int * 4 + 3)], this.jdField_a_of_type_AndroidContentResResources);
      float f3 = aciy.a(jdField_a_of_type_ArrayOfFloat[(this.jdField_b_of_type_Int * 4)], this.jdField_a_of_type_AndroidContentResResources);
      float f4 = aciy.a(jdField_a_of_type_ArrayOfFloat[(this.jdField_b_of_type_Int * 4 + 1)], this.jdField_a_of_type_AndroidContentResResources);
      float f5 = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      float f6 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_Float = aciy.a(2.0F, this.jdField_a_of_type_AndroidContentResResources);
      paramCanvas.translate(f1 + (f3 - f5) * 0.5F, f2 + (f4 - f6) * 0.5F);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = (0.0F - this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.top = (0.0F - this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Float * 2.0F + f5);
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_Float * 2.0F + f6);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return ((Bitmap)this.jdField_a_of_type_JavaUtilList.get(this.jdField_b_of_type_Int)).getHeight();
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhnl
 * JD-Core Version:    0.7.0.1
 */