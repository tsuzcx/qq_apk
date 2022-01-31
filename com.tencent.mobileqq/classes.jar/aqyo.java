import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.hotchat.ui.HeartView;
import java.util.Random;

public class aqyo
  extends aqyn
{
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  private int[] jdField_a_of_type_ArrayOfInt = { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  
  public aqyo(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public aqyo(Context paramContext, int paramInt, aqyh paramaqyh)
  {
    super(paramContext, paramInt, paramaqyh);
  }
  
  public static void a(HeartLayout paramHeartLayout)
  {
    if ((paramHeartLayout == null) || (paramHeartLayout.a() == null)) {}
    do
    {
      return;
      paramHeartLayout = paramHeartLayout.a();
    } while (paramHeartLayout == null);
    paramHeartLayout.j = 2400;
    aqyj.b = 0.05F;
  }
  
  public Bitmap a()
  {
    super.a();
    return b();
  }
  
  public Bitmap b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
      Bitmap localBitmap1;
      Bitmap localBitmap2;
      do
      {
        return null;
        if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
          this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(3);
        }
        if (this.jdField_a_of_type_AndroidGraphicsCanvas == null) {
          this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas();
        }
        localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        localBitmap2 = HeartView.a(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      } while (localBitmap2 == null);
      Canvas localCanvas = this.jdField_a_of_type_AndroidGraphicsCanvas;
      localCanvas.setBitmap(localBitmap2);
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      localPaint.setColorFilter(new PorterDuffColorFilter(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_JavaUtilRandom.nextInt(this.jdField_a_of_type_ArrayOfInt.length)], PorterDuff.Mode.SRC_ATOP));
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
      localPaint.setColorFilter(null);
      if (Build.VERSION.SDK_INT >= 11) {
        localCanvas.setBitmap(null);
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqyo
 * JD-Core Version:    0.7.0.1
 */