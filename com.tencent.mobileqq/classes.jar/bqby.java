import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class bqby
  extends Handler
{
  public bqby(bqbx parambqbx) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (bqbx.a(this.a) != null)
      {
        yuq.b("0X80080E3", yuq.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(bqbx.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        this.a.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(paramMessage, 100);
      }
      this.a.c();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Bqgk.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Bqgk.a != null)
      {
        this.a.jdField_a_of_type_Bqgk.a.d();
        this.a.jdField_a_of_type_Bqgk.z();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.jdField_a_of_type_Bqgk.a(0);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqby
 * JD-Core Version:    0.7.0.1
 */