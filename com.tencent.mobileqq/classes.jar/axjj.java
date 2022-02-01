import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.now.message.MessageReceivingAdapter;
import com.tencent.qphone.base.util.QLog;

public class axjj
  extends axjm
{
  public axjj(MessageReceivingAdapter paramMessageReceivingAdapter, int paramInt, MessageForArkApp paramMessageForArkApp) {}
  
  public boolean onClick(View paramView)
  {
    j = 0;
    axkk.b(this.jdField_a_of_type_Int + 1, axjh.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp), "1");
    paramView = axjh.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    if (TextUtils.isEmpty(paramView)) {
      return false;
    }
    paramView = axkq.a(axkq.a(paramView, "fromid", String.valueOf(60013)), "startsrc", String.valueOf(60013));
    try
    {
      String str = axkq.a(paramView, "roomid");
      i = j;
      if (!TextUtils.isEmpty(str)) {
        i = Integer.parseInt(str);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MessageReceivingAdapter", 4, localException, new Object[0]);
        int i = j;
      }
    }
    Log.i("MessageReceivingAdapter", "jumpUrl = " + paramView);
    return axko.a(MessageReceivingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter), paramView, i, 60012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjj
 * JD-Core Version:    0.7.0.1
 */