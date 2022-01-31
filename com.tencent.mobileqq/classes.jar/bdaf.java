import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bdaf
  extends Handler
{
  static int a;
  public aeov a;
  public WeakReference<Context> a;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(aeov paramaeov)
  {
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu Called");
    if ((paramaeov instanceof aema))
    {
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is BubbleOnlongClickListener");
      paramaeov = ((aema)paramaeov).a;
      if ((paramaeov != null) && (paramaeov.a()))
      {
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper dismiss");
        paramaeov.a();
        return;
      }
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper notshow");
      return;
    }
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is: " + paramaeov.getClass());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == jdField_a_of_type_Int) && ((paramMessage.obj instanceof View)) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramMessage = (aelt)aekt.a((View)paramMessage.obj);
      QLog.d("SystemDragUtils", 1, "DRAG TRIGGER: holder is: " + paramMessage.getClass());
      if (paramMessage.a != null) {
        ThreadManager.executeOnFileThread(new SystemDragUtils.TouchHandler.1(this, paramMessage));
      }
    }
    else
    {
      return;
    }
    QLog.e("SystemDragUtils", 1, "DRAG TRIGGER: holder message is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdaf
 * JD-Core Version:    0.7.0.1
 */