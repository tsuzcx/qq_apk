import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

public class borv
  extends Handler
{
  public borv(boru paramboru) {}
  
  public void dispatchMessage(Message paramMessage)
  {
    super.dispatchMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      if (boru.a(this.a) != null)
      {
        ykw.b("0X80080E3", ykw.a);
        paramMessage = new ArrayList();
        paramMessage.add(Uri.parse(boru.a(this.a)));
        paramMessage = new Intent("", Uri.parse("pituopenapi://TTPTBEAUTIFY?back=1&v=490&refer=qqimageedit")).setClassName("com.tencent.ttpic", "com.tencent.ttpic.module.MainActivity").putParcelableArrayListExtra("android.intent.extra.STREAM", paramMessage);
        paramMessage.putExtra("big_brother_source_key", "biz_src_jc_editor");
        this.a.jdField_a_of_type_Bouo.getActivity().startActivityForResult(paramMessage, 100);
      }
      this.a.b();
      return;
    case 2: 
      paramMessage = (Bitmap)paramMessage.obj;
      this.a.jdField_a_of_type_Botw.a(paramMessage, false);
      this.a.jdField_a_of_type_Boolean = true;
      return;
    }
    this.a.jdField_a_of_type_Botw.a(0);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borv
 * JD-Core Version:    0.7.0.1
 */