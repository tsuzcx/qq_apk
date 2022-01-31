import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;

class aofj
  implements Runnable
{
  aofj(aofi paramaofi, Bitmap paramBitmap) {}
  
  public void run()
  {
    SLog.a("Q.qqstory.publish.edit.LocalVideoSelectActivity", "load cover completed and havePlaying=%s", Boolean.valueOf(LocalVideoSelectActivity.a(this.jdField_a_of_type_Aofi.a)));
    if (!LocalVideoSelectActivity.a(this.jdField_a_of_type_Aofi.a))
    {
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Aofi.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      LocalVideoSelectActivity.a(this.jdField_a_of_type_Aofi.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aofj
 * JD-Core Version:    0.7.0.1
 */