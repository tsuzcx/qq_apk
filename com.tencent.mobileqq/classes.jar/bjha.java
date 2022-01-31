import android.opengl.GLES20;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;

public class bjha
  extends GPUBaseFilter
{
  private static String jdField_a_of_type_JavaLangString = GlUtil.readTextFromRawResource(BaseApplicationImpl.getContext(), 2131230755);
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public bjha()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", jdField_a_of_type_JavaLangString);
  }
  
  public bjha(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    this.mFilterType = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, float paramFloat)
  {
    float f2 = 1.0F;
    float f1 = 0.0F;
    if (paramFloat > 1.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < 0.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = paramBoolean;
        this.jdField_a_of_type_Float = paramFloat;
        return;
      }
    }
  }
  
  public void onDrawTexture()
  {
    float f2 = 1.0F;
    int i = this.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = 1.0F;
      GLES20.glUniform1f(i, f1);
      GLES20.glUniform1f(this.jdField_a_of_type_Int, this.jdField_a_of_type_Float);
      i = this.c;
      if (!this.jdField_a_of_type_Boolean) {
        break label57;
      }
    }
    label57:
    for (float f1 = f2;; f1 = 2.0F)
    {
      GLES20.glUniform1f(i, f1);
      return;
      f1 = 2.0F;
      break;
    }
  }
  
  public void onInitialized()
  {
    this.jdField_a_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "percent");
    this.jdField_b_of_type_Int = GLES20.glGetUniformLocation(getProgram(), "drawPart");
    this.c = GLES20.glGetUniformLocation(getProgram(), "cutX");
  }
  
  public String toString()
  {
    double d2 = 1.0D;
    int i = this.mFilterType;
    double d1;
    float f;
    if (this.jdField_b_of_type_Boolean)
    {
      d1 = 1.0D;
      f = this.jdField_a_of_type_Float;
      if (!this.jdField_a_of_type_Boolean) {
        break label77;
      }
    }
    for (;;)
    {
      return String.format("filter type=%s, draw left=%s, draw percent=%s, directionx=%s", new Object[] { Integer.valueOf(i), Double.valueOf(d1), Float.valueOf(f), Double.valueOf(d2) });
      d1 = 2.0D;
      break;
      label77:
      d2 = 2.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjha
 * JD-Core Version:    0.7.0.1
 */