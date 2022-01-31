import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class azau
  implements bgnx
{
  public ayzz a;
  
  public azau(azar paramazar, ayzz paramayzz)
  {
    this.jdField_a_of_type_Ayzz = paramayzz;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ayzz.g = 3;
    this.jdField_a_of_type_Ayzz.c(paramString);
    ((Activity)azar.a(this.jdField_a_of_type_Azar)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Ayzz.g = 2;
    ((Activity)azar.a(this.jdField_a_of_type_Azar)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azau
 * JD-Core Version:    0.7.0.1
 */