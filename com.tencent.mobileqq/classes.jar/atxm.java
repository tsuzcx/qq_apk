import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.qphone.base.util.QLog;

final class atxm
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Shader.TileMode jdField_a_of_type_AndroidGraphicsShader$TileMode = null;
  boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  Shader.TileMode jdField_b_of_type_AndroidGraphicsShader$TileMode = null;
  String[] jdField_b_of_type_ArrayOfJavaLangString;
  int c = 119;
  int d = 160;
  
  public atxm(atxx paramatxx)
  {
    if (paramatxx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PngFrameDrawable", 2, "【ramdom magic】 png frame param is null.");
      }
      throw new IllegalArgumentException("【ramdom magic】 png frame param is null.");
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramatxx.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = paramatxx.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_Int = paramatxx.c;
    this.jdField_b_of_type_Int = paramatxx.jdField_b_of_type_Int;
    this.jdField_a_of_type_Boolean = paramatxx.jdField_a_of_type_Boolean;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public Drawable newDrawable()
  {
    return new atxk(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PngFrameDrawable", 2, "func newDrawable");
    }
    return new atxk(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atxm
 * JD-Core Version:    0.7.0.1
 */