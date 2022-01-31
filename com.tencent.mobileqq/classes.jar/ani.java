import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.qq.im.poi.LbsPackManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.IOException;

public class ani
  implements Runnable
{
  public ani(LbsPackManager paramLbsPackManager, Bitmap paramBitmap, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((this.jdField_a_of_type_Int != 128) || (this.b != 128))
    {
      float f1 = 128.0F / this.jdField_a_of_type_Int;
      float f2 = 128.0F / this.b;
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(f1, f2);
      localObject1 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_Int, this.b, (Matrix)localObject1, true);
    }
    Bitmap localBitmap;
    if (localObject1 != null) {
      localBitmap = this.jdField_a_of_type_ComQqImPoiLbsPackManager.a((Bitmap)localObject1, 3, -3881788);
    }
    try
    {
      Object localObject2 = (String)LbsPackManager.a(this.jdField_a_of_type_ComQqImPoiLbsPackManager).get(this.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = LbsPackManager.d(this.jdField_a_of_type_JavaLangString);
      }
      localObject2 = new File((String)localObject1 + ".temp");
      ImageUtil.a(localBitmap, (File)localObject2);
      FileUtils.b((File)localObject2, new File((String)localObject1));
      localObject2 = LbsPackManager.a();
      if (localObject2 != null) {
        ((LruCache)localObject2).put(this.jdField_a_of_type_JavaLangString, localObject1);
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ani
 * JD-Core Version:    0.7.0.1
 */