import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class beoi
  implements bkxw
{
  public benn a;
  
  public beoi(beof parambeof, benn parambenn)
  {
    this.jdField_a_of_type_Benn = parambenn;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Benn.g = 3;
    this.jdField_a_of_type_Benn.c(paramString);
    ((Activity)beof.a(this.jdField_a_of_type_Beof)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Benn.g = 2;
    ((Activity)beof.a(this.jdField_a_of_type_Beof)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoi
 * JD-Core Version:    0.7.0.1
 */