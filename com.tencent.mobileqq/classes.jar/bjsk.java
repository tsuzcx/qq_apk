import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import java.util.ArrayList;

public class bjsk
  extends Handler
{
  public bjsk(bjsj parambjsj) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (bjsj.a(this.a) != null)
      {
        vem.b("0X80080E3", vem.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(bjsj.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        this.a.jdField_a_of_type_Bjye.getActivity().startActivityForResult(paramMessage, 100);
      }
      this.a.c();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Bjww.a(paramMessage, false);
      if (this.a.jdField_a_of_type_Bjww.a != null)
      {
        this.a.jdField_a_of_type_Bjww.a.d();
        this.a.jdField_a_of_type_Bjww.z();
      }
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.jdField_a_of_type_Bjww.a(0);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjsk
 * JD-Core Version:    0.7.0.1
 */