import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class bmel
  extends Handler
{
  public bmel(bmek parambmek) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (bmek.a(this.a) != null)
      {
        wtb.b("0X80080E3", wtb.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(bmek.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        this.a.jdField_a_of_type_Bmkf.getActivity().startActivityForResult(paramMessage, 100);
      }
      this.a.c();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Bmix.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Bmix.a != null)
      {
        this.a.jdField_a_of_type_Bmix.a.d();
        this.a.jdField_a_of_type_Bmix.z();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.jdField_a_of_type_Bmix.a(0);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmel
 * JD-Core Version:    0.7.0.1
 */