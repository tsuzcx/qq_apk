import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class bces
  implements bkda
{
  public bcdx a;
  
  public bces(bcep parambcep, bcdx parambcdx)
  {
    this.jdField_a_of_type_Bcdx = parambcdx;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bcdx.g = 3;
    this.jdField_a_of_type_Bcdx.c(paramString);
    ((Activity)bcep.a(this.jdField_a_of_type_Bcep)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bcdx.g = 2;
    ((Activity)bcep.a(this.jdField_a_of_type_Bcep)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bces
 * JD-Core Version:    0.7.0.1
 */