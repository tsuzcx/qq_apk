import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ax
  implements bkzq
{
  public ax(LiteActivity paramLiteActivity, long paramLong, DataLineMsgSet paramDataLineMsgSet, List paramList, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.cancel();
      return;
      if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(this.jdField_a_of_type_Long))
      {
        paramView = (ansr)this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
        this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
        if (paramView.a(this.jdField_a_of_type_JavaUtilList))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord))
            {
              localDataLineMsgRecord.bIsResendOrRecvFile = true;
              localDataLineMsgRecord.fileMsgStatus = 0L;
              localDataLineMsgRecord.progress = 0.0F;
            }
          }
          this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.notifyDataSetChanged();
        }
        else
        {
          audr.a(2131693648);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ax
 * JD-Core Version:    0.7.0.1
 */