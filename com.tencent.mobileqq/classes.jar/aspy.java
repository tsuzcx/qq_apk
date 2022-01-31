import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.HotPicRecyclerView;

public class aspy
  extends Handler
{
  public aspy(HotPicPageView paramHotPicPageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (HotPicPageView.b);
          this.a.i();
          return;
        } while ((HotPicPageView.b) || (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.getVisibility() != 0) || (this.a.jdField_a_of_type_Asqe == null) || (this.a.jdField_a_of_type_Asqe.getItemCount() == 0));
        i = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a();
      } while (i < 0);
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(i);
    } while ((paramMessage == null) || (!(paramMessage instanceof asqh)));
    paramMessage = (asqh)paramMessage;
    if (paramMessage.jdField_a_of_type_Int == 0)
    {
      this.a.b(paramMessage, i);
      return;
    }
    paramMessage.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspy
 * JD-Core Version:    0.7.0.1
 */