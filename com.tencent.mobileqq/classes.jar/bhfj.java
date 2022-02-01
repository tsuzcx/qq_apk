import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class bhfj
{
  private static boolean b;
  private int jdField_a_of_type_Int = 10;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(5);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private View jdField_a_of_type_AndroidViewView;
  private boolean jdField_a_of_type_Boolean;
  
  public bhfj(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    int i = this.jdField_a_of_type_AndroidViewView.getWidth() / this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_AndroidViewView.getHeight() / this.jdField_a_of_type_Int;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() != i) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() != j))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MosaicEffect", 2, "draw: try to alloc bitmap w x h=[" + i + "x" + j + "]");
      }
      if (i > 0) {
        break label406;
      }
      QLog.e("MosaicEffect", 1, "draw: mosaicWidth <= 0");
      i = 1;
    }
    label406:
    for (;;)
    {
      if (j <= 0)
      {
        QLog.e("MosaicEffect", 1, "draw: mosaicHeight <= 0");
        j = 1;
      }
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", localException1);
          try
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.RGB_565);
          }
          catch (Exception localException2)
          {
            QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", localException2);
          }
          continue;
          this.jdField_a_of_type_AndroidGraphicsBitmap.eraseColor(0);
          this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidViewView.computeScroll();
          i = this.jdField_a_of_type_AndroidGraphicsCanvas.save();
          float f = 1.0F / this.jdField_a_of_type_Int;
          this.jdField_a_of_type_AndroidGraphicsCanvas.scale(f, f);
          this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-this.jdField_a_of_type_AndroidViewView.getScrollX(), -this.jdField_a_of_type_AndroidViewView.getScrollY());
          this.jdField_a_of_type_Boolean = false;
          if ((this.jdField_a_of_type_AndroidViewView instanceof bhfk)) {
            ((bhfk)this.jdField_a_of_type_AndroidViewView).b(this.jdField_a_of_type_AndroidGraphicsCanvas);
          }
          this.jdField_a_of_type_AndroidGraphicsCanvas.restoreToCount(i);
          this.jdField_a_of_type_AndroidGraphicsCanvas.setBitmap(null);
          this.jdField_a_of_type_Boolean = true;
          if ((this.jdField_a_of_type_AndroidViewView instanceof bhfk)) {
            ((bhfk)this.jdField_a_of_type_AndroidViewView).b(paramCanvas);
          }
          if (QLog.isColorLevel())
          {
            QLog.i("MosaicEffect", 2, "draw: " + (SystemClock.uptimeMillis() - l) + " ms");
            return;
          }
        }
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void b(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(false);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (!paramCanvas.getClipBounds(this.jdField_a_of_type_AndroidGraphicsRect)) {
          break label159;
        }
        if ((!paramCanvas.isHardwareAccelerated()) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getWidth() < this.jdField_a_of_type_AndroidGraphicsRect.width()) || (this.jdField_a_of_type_AndroidViewView.getHeight() < this.jdField_a_of_type_AndroidGraphicsRect.height()))) {
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidViewView.getWidth(), this.jdField_a_of_type_AndroidViewView.getHeight());
        }
        if (b)
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
          paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    label159:
    while (!(this.jdField_a_of_type_AndroidViewView instanceof bhfk))
    {
      return;
      QLog.e("MosaicEffect", 1, "onDraw: clipBound is empty " + this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    ((bhfk)this.jdField_a_of_type_AndroidViewView).c(this.jdField_a_of_type_AndroidGraphicsCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfj
 * JD-Core Version:    0.7.0.1
 */