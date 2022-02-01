import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.VasApngUtil;

public class bgwc
  implements bgwb
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public bgwc(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public URLDrawable a(Drawable paramDrawable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", this.jdField_a_of_type_Int);
    localBundle.putBoolean("key_use_cache", false);
    return VasApngUtil.getApngDrawable(this.jdField_a_of_type_JavaLangString, "dontCacheMe", paramDrawable, null, this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwc
 * JD-Core Version:    0.7.0.1
 */