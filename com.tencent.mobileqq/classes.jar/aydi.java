import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.qphone.base.util.QLog;

public class aydi
  extends aydl
{
  public aydi(MessageReceivingAdapter paramMessageReceivingAdapter, int paramInt, MessageForArkApp paramMessageForArkApp) {}
  
  public boolean onClick(View paramView)
  {
    int i = 0;
    ayej.b(this.jdField_a_of_type_Int + 1, aydg.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp), "1");
    paramView = ayep.a(ayep.a(aydg.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp), "fromid", String.valueOf(60013)), "startsrc", String.valueOf(60013));
    try
    {
      int j = Integer.parseInt(ayep.a(paramView, "roomid"));
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MessageReceivingAdapter", 4, localException, new Object[0]);
      }
    }
    Log.i("MessageReceivingAdapter", "jumpUrl = " + paramView);
    return ayen.a(MessageReceivingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter), paramView, i, 60012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydi
 * JD-Core Version:    0.7.0.1
 */