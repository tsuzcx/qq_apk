import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class bcaj
  implements bjyt
{
  public bbzo a;
  
  public bcaj(bcag parambcag, bbzo parambbzo)
  {
    this.jdField_a_of_type_Bbzo = parambbzo;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bbzo.g = 3;
    this.jdField_a_of_type_Bbzo.c(paramString);
    ((Activity)bcag.a(this.jdField_a_of_type_Bcag)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bbzo.g = 2;
    ((Activity)bcag.a(this.jdField_a_of_type_Bcag)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaj
 * JD-Core Version:    0.7.0.1
 */