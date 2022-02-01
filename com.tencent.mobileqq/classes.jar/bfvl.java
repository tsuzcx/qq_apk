import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class bfvl
  implements bmjf
{
  public bfuq a;
  
  public bfvl(bfvi parambfvi, bfuq parambfuq)
  {
    this.jdField_a_of_type_Bfuq = parambfuq;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bfuq.g = 3;
    this.jdField_a_of_type_Bfuq.c(paramString);
    ((Activity)bfvi.a(this.jdField_a_of_type_Bfvi)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bfuq.g = 2;
    ((Activity)bfvi.a(this.jdField_a_of_type_Bfvi)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvl
 * JD-Core Version:    0.7.0.1
 */