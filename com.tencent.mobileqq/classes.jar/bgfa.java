import android.app.Activity;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.AudioItem.AudioUploadCallback.2;

public class bgfa
  implements bnsp
{
  public bgef a;
  
  public bgfa(bgex parambgex, bgef parambgef)
  {
    this.jdField_a_of_type_Bgef = parambgef;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Bgef.g = 3;
    this.jdField_a_of_type_Bgef.c(paramString);
    ((Activity)bgex.a(this.jdField_a_of_type_Bgex)).runOnUiThread(new AudioItem.AudioUploadCallback.1(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Bgef.g = 2;
    ((Activity)bgex.a(this.jdField_a_of_type_Bgex)).runOnUiThread(new AudioItem.AudioUploadCallback.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfa
 * JD-Core Version:    0.7.0.1
 */