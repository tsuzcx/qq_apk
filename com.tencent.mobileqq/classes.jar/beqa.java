import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class beqa
{
  Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new beqb(this, Looper.getMainLooper());
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  
  public beqa(Context paramContext) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetToast != null) {
      this.jdField_a_of_type_AndroidWidgetToast.cancel();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    beqc localbeqc = new beqc(null);
    localbeqc.jdField_a_of_type_Int = paramInt4;
    localbeqc.b = paramInt1;
    localbeqc.c = paramInt3;
    localbeqc.d = paramInt2;
    localMessage.obj = localbeqc;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    beqc localbeqc = new beqc(null);
    localbeqc.jdField_a_of_type_Int = paramInt3;
    localbeqc.jdField_a_of_type_JavaLangString = paramString;
    localbeqc.c = paramInt2;
    localbeqc.d = paramInt1;
    localMessage.obj = localbeqc;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     beqa
 * JD-Core Version:    0.7.0.1
 */