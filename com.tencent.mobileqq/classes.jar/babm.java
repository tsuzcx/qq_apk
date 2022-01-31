import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class babm
  implements bhwr
{
  public baar a;
  
  public babm(babj parambabj, baar parambaar)
  {
    this.jdField_a_of_type_Baar = parambaar;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Baar.g = 3;
    this.jdField_a_of_type_Baar.c(paramString);
    ((Activity)babj.a(this.jdField_a_of_type_Babj)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Baar.g = 2;
    ((Activity)babj.a(this.jdField_a_of_type_Babj)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     babm
 * JD-Core Version:    0.7.0.1
 */