import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class bbne
{
  Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new bbnf(this, Looper.getMainLooper());
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  
  public bbne(Context paramContext) {}
  
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
    bbng localbbng = new bbng(null);
    localbbng.jdField_a_of_type_Int = paramInt4;
    localbbng.b = paramInt1;
    localbbng.c = paramInt3;
    localbbng.d = paramInt2;
    localMessage.obj = localbbng;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bbng localbbng = new bbng(null);
    localbbng.jdField_a_of_type_Int = paramInt3;
    localbbng.jdField_a_of_type_JavaLangString = paramString;
    localbbng.c = paramInt2;
    localbbng.d = paramInt1;
    localMessage.obj = localbbng;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbne
 * JD-Core Version:    0.7.0.1
 */