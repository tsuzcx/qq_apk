import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class bijy
  extends birb
{
  public float a;
  public int a;
  @NonNull
  public Bitmap a;
  public PointF a;
  public bijn a;
  public biyc a;
  public boolean a;
  public Rect[] a;
  public String[] a;
  public float b;
  public boolean b;
  public float c;
  public float d;
  public float e = 1.0F;
  
  public bijy(bijw parambijw, String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    super(paramPointF, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Biyc = new biyc();
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoteLayer", 2, "draw bitmap is null");
      }
    }
    do
    {
      return;
      paramCanvas.save();
      paramCanvas.concat(bijw.a(this.jdField_a_of_type_Bijw).a(this));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, -this.u / 2.0F, -this.v / 2.0F, bijw.a(this.jdField_a_of_type_Bijw));
      if ((this.k) && (this.jdField_a_of_type_Boolean))
      {
        paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
        Path localPath = new Path();
        Rect[] arrayOfRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
        int j = arrayOfRect.length;
        i = 0;
        while (i < j)
        {
          Rect localRect = arrayOfRect[i];
          localPath.reset();
          localPath.addRoundRect(new RectF(localRect.left + 10, localRect.top + 5, localRect.right - 10, localRect.bottom - 5), 4.0F, 4.0F, Path.Direction.CCW);
          paramCanvas.drawPath(localPath, bijw.b(this.jdField_a_of_type_Bijw));
          i += 1;
        }
      }
      paramCanvas.restore();
    } while (!this.k);
    int i = -1;
    if (this.b) {
      i = 2130839318;
    }
    biqy.a(paramCanvas, bijw.a(this.jdField_a_of_type_Bijw), this, i, 2130843735, 2130843742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijy
 * JD-Core Version:    0.7.0.1
 */