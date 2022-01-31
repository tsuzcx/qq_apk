import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class bnnz
  extends bnny
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230751);
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public bnnz()
  {
    this(0.5F);
  }
  
  public bnnz(float paramFloat)
  {
    super("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void onDrawTexture()
  {
    super.onDrawTexture();
    GLES20.glUniform1f(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "brightness");
    a(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnz
 * JD-Core Version:    0.7.0.1
 */