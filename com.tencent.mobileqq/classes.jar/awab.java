import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class awab
  extends avzw
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230754);
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private int b;
  
  public awab()
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.mFilterType = 6;
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
      veg.b("Q.qqstory.publish.edit GPUNashvilleFilter", "mosaic bitmap recycle");
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
        QLog.w("Q.qqstory.publish.edit GPUNashvilleFilter", 1, "bitmap error");
        return;
      }
      this.jdField_a_of_type_Int = GlUtil.createTexture(3553, this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    GLES20.glBindTexture(3553, this.jdField_a_of_type_Int);
    GLES20.glUniform1i(this.b, 1);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream(BaseApplicationImpl.getContext().getResources().openRawResource(2130845264));
      this.b = GLES20.glGetUniformLocation(getProgram(), "sTexture2");
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        veg.e("Q.qqstory.publish.edit GPUNashvilleFilter", "OutOfMemoryError:%s", new Object[] { localOutOfMemoryError.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awab
 * JD-Core Version:    0.7.0.1
 */