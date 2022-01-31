import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.open.agent.CardContainer;
import com.tencent.qphone.base.util.QLog;

public class bczn
  extends Handler
{
  public bczn(CardContainer paramCardContainer, Looper paramLooper)
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
      continue;
      if ((paramMessage.obj instanceof String))
      {
        Object localObject = (String)paramMessage.obj;
        localObject = this.a.a((String)localObject);
        if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 1))
        {
          this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
          Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10001).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bczn
 * JD-Core Version:    0.7.0.1
 */