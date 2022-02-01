import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.util.MustRunOnGLThread;

public class boqy
{
  public static boolean a;
  private int a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public boqy()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @MustRunOnGLThread
  public void a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_c_of_type_Int = arrayOfInt[0];
    this.jdField_c_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @MustRunOnGLThread
  public void b()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.jdField_c_of_type_Int;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    jdField_a_of_type_Boolean = false;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @MustRunOnGLThread
  public void c()
  {
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {}
    Bitmap localBitmap1;
    do
    {
      return;
      localBitmap1 = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), "/sdcard/Tencent/aekit/test.png", 1);
    } while (!BitmapUtils.isLegal(localBitmap1));
    Bitmap localBitmap2;
    if (Math.abs(localBitmap1.getHeight() / localBitmap1.getWidth() - 1.777778F) > 0.0001D)
    {
      int i = (int)(localBitmap1.getWidth() * 16.0F / 9.0F);
      localBitmap2 = Bitmap.createBitmap(localBitmap1.getWidth(), i, Bitmap.Config.ARGB_8888);
      localBitmap2.eraseColor(-1);
      Canvas localCanvas = new Canvas(localBitmap2);
      Paint localPaint = new Paint(6);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(localBitmap1, 0.0F, (i - localBitmap1.getHeight()) / 2, localPaint);
      GlUtil.loadTexture(this.jdField_c_of_type_Int, localBitmap2);
      localBitmap1.recycle();
      localBitmap2.recycle();
      this.jdField_a_of_type_Int = localBitmap2.getWidth();
    }
    for (this.jdField_b_of_type_Int = localBitmap2.getHeight();; this.jdField_b_of_type_Int = localBitmap1.getHeight())
    {
      this.jdField_b_of_type_Boolean = true;
      return;
      GlUtil.loadTexture(this.jdField_c_of_type_Int, localBitmap1);
      localBitmap1.recycle();
      this.jdField_a_of_type_Int = localBitmap1.getWidth();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqy
 * JD-Core Version:    0.7.0.1
 */