import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class bffg
  implements bmrk
{
  public bfel a;
  
  public bffg(bffd parambffd, bfel parambfel)
  {
    this.jdField_a_of_type_Bfel = parambfel;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfel.g = 3;
    this.jdField_a_of_type_Bfel.c(paramString);
    ((Activity)bffd.a(this.jdField_a_of_type_Bffd)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bfel.g = 2;
    ((Activity)bffd.a(this.jdField_a_of_type_Bffd)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffg
 * JD-Core Version:    0.7.0.1
 */