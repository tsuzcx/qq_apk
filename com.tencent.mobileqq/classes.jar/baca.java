import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class baca
  implements bhxi
{
  public babf a;
  
  public baca(babx parambabx, babf parambabf)
  {
    this.jdField_a_of_type_Babf = parambabf;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Babf.g = 3;
    this.jdField_a_of_type_Babf.c(paramString);
    ((Activity)babx.a(this.jdField_a_of_type_Babx)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Babf.g = 2;
    ((Activity)babx.a(this.jdField_a_of_type_Babx)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baca
 * JD-Core Version:    0.7.0.1
 */