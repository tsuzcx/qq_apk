import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.mobileqq.widget.WorkSpaceView;
import java.lang.ref.WeakReference;

public class bcjn
  extends Handler
{
  private ADView jdField_a_of_type_ComTencentMobileqqWidgetADView;
  private WeakReference<ADView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bcjn(ADView paramADView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramADView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView = ((ADView)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetADView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a == null));
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getChildCount() > 1) && (this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getWidth() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a(this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a() + 1);
      }
      try
      {
        axuj localaxuj = (axuj)this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a.a()).getTag();
        i = localaxuj.a;
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.setContentDescription(localaxuj.n);
        i *= 1000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i = 5000;
        }
      }
      sendEmptyMessageDelayed(0, i);
      this.jdField_a_of_type_ComTencentMobileqqWidgetADView = null;
      continue;
      removeMessages(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcjn
 * JD-Core Version:    0.7.0.1
 */