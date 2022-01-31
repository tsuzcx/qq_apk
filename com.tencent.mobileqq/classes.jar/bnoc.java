import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class bnoc
  extends bnny
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230753);
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private int b;
  
  public bnoc()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.mFilterType = 5;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Int != -1) {
      GlUtil.deleteTexture(this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      wxe.b("Q.qqstory.publish.edit GPULordKelvinFilter", "mosaic bitmap recycle");
    }
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glActiveTexture(33985);
    if (this.jdField_a_of_type_Int == -1)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        QLog.w("Q.qqstory.publish.edit GPULordKelvinFilter", 1, "bitmap error");
        return;
      }
      this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    GLES20.glBindTexture(3553, this.jdField_a_of_type_Int);
    GLES20.glUniform1i(this.b, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localInputStream = BaseApplicationImpl.getContext().getResources().openRawResource(2130845704);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream(localInputStream);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        InputStream localInputStream;
        localObject3 = localIOException1;
        wxe.e("Q.qqstory.publish.edit GPULordKelvinFilter", "OutOfMemoryError:%s", new Object[] { localOutOfMemoryError.getMessage() });
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label111;
        }
      }
      try
      {
        localInputStream.close();
        this.b = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    try
    {
      localObject3.close();
      label111:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        localIOException3.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoc
 * JD-Core Version:    0.7.0.1
 */