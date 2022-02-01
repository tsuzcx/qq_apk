import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;

public class bisy
{
  Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private Handler jdField_a_of_type_AndroidOsHandler = new bisz(this, Looper.getMainLooper());
  Toast jdField_a_of_type_AndroidWidgetToast = null;
  
  public bisy(Context paramContext) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bita localbita = new bita(null);
    localbita.jdField_a_of_type_Int = paramInt4;
    localbita.b = paramInt1;
    localbita.c = paramInt3;
    localbita.d = paramInt2;
    localMessage.obj = localbita;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    bita localbita = new bita(null);
    localbita.jdField_a_of_type_Int = paramInt3;
    localbita.jdField_a_of_type_JavaLangString = paramString;
    localbita.c = paramInt2;
    localbita.d = paramInt1;
    localMessage.obj = localbita;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bisy
 * JD-Core Version:    0.7.0.1
 */