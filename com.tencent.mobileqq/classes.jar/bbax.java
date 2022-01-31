import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class bbax
  extends Handler
{
  static int a;
  public acxn a;
  public WeakReference<Context> a;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(acxn paramacxn)
  {
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu Called");
    if ((paramacxn instanceof acuu))
    {
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is BubbleOnlongClickListener");
      paramacxn = ((acuu)paramacxn).a;
      if ((paramacxn != null) && (paramacxn.a()))
      {
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper dismiss");
        paramacxn.a();
        return;
      }
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper notshow");
      return;
    }
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is: " + paramacxn.getClass());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == jdField_a_of_type_Int) && ((paramMessage.obj instanceof View)) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramMessage = (acun)actn.a((View)paramMessage.obj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbax
 * JD-Core Version:    0.7.0.1
 */