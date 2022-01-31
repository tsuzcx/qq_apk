import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class azzt
  extends Handler
{
  static int a;
  public acmv a;
  public WeakReference<Context> a;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(acmv paramacmv)
  {
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu Called");
    if ((paramacmv instanceof ackb))
    {
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is BubbleOnlongClickListener");
      paramacmv = ((ackb)paramacmv).a;
      if ((paramacmv != null) && (paramacmv.a()))
      {
        QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper dismiss");
        paramacmv.a();
        return;
      }
      QLog.d("SystemDragUtils", 1, "dismissBubbleMenu menuWrapper notshow");
      return;
    }
    QLog.d("SystemDragUtils", 1, "dismissBubbleMenu listener is: " + paramacmv.getClass());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == jdField_a_of_type_Int) && ((paramMessage.obj instanceof View)) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      paramMessage = (acju)aciy.a((View)paramMessage.obj);
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
 * Qualified Name:     azzt
 * JD-Core Version:    0.7.0.1
 */