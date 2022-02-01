import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

public class bqkh
  extends bqrk
{
  public float a;
  public int a;
  @NonNull
  public Bitmap a;
  public PointF a;
  public bqjw a;
  public bqyc a;
  public boolean a;
  public Rect[] a;
  public String[] a;
  public float b;
  public boolean b;
  public float c;
  public float d;
  public float e = 1.0F;
  
  public bqkh(bqkf parambqkf, String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    super(paramPointF, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Bqyc = new bqyc();
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
      paramCanvas.concat(bqkf.a(this.jdField_a_of_type_Bqkf).a(this));
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, -this.u / 2.0F, -this.v / 2.0F, bqkf.a(this.jdField_a_of_type_Bqkf));
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
          paramCanvas.drawPath(localPath, bqkf.b(this.jdField_a_of_type_Bqkf));
          i += 1;
        }
      }
      paramCanvas.restore();
    } while (!this.k);
    int i = -1;
    if (this.b) {
      i = 2130839611;
    }
    bqrh.a(paramCanvas, bqkf.a(this.jdField_a_of_type_Bqkf), this, i, 2130844637, 2130844644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqkh
 * JD-Core Version:    0.7.0.1
 */