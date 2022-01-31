import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable;

public class bbnz
  implements bbny
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public bbnz(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public URLDrawable a(Drawable paramDrawable)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_loop", this.jdField_a_of_type_Int);
    localBundle.putBoolean("key_use_cache", false);
    return bbqz.a(this.jdField_a_of_type_JavaLangString, "dontCacheMe", paramDrawable, null, this.jdField_a_of_type_JavaLangString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbnz
 * JD-Core Version:    0.7.0.1
 */