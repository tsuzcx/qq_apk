import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qphone.base.util.QLog;

public class bjcb
  extends Handler
{
  public bjcb(CardContainer paramCardContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CardContainer", 2, "-->handleMessage MSG_UPDATE");
      }
      CardContainer.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetAnyScaleTypeImageView.setImageDrawable(this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcb
 * JD-Core Version:    0.7.0.1
 */