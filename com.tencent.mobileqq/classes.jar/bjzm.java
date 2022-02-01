import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.proxyimpl.VideoJsProxyImpl.2;

public class bjzm
  implements DialogInterface.OnClickListener
{
  public bjzm(VideoJsProxyImpl.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjzk.a(this.a.this$0, this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_Boolean, this.a.b);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzm
 * JD-Core Version:    0.7.0.1
 */