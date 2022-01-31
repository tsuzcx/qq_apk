import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class bmix
  extends Handler
{
  public bmix(bmiw parambmiw) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (bmiw.a(this.a) != null)
      {
        wxk.b("0X80080E3", wxk.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(bmiw.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        this.a.jdField_a_of_type_Bmor.getActivity().startActivityForResult(paramMessage, 100);
      }
      this.a.c();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Bmnj.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Bmnj.a != null)
      {
        this.a.jdField_a_of_type_Bmnj.a.d();
        this.a.jdField_a_of_type_Bmnj.z();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.jdField_a_of_type_Bmnj.a(0);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmix
 * JD-Core Version:    0.7.0.1
 */