import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

public class av
  implements bliz
{
  public av(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, ek paramek, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.cancel();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -1000)
      {
        paramView = this.jdField_a_of_type_Ek.a().jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramView, this.jdField_a_of_type_Ek.a().jdField_a_of_type_Long, -1);
      }
      else
      {
        DataLineMsgRecord localDataLineMsgRecord;
        if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 0);
            }
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005) || (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2009))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.setPaused(false);
          paramView = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
          while (paramView.hasNext())
          {
            localDataLineMsgRecord = (DataLineMsgRecord)paramView.next();
            if (DataLineMsgSet.isCanReciveOrResend(localDataLineMsgRecord)) {
              this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(localDataLineMsgRecord.path, localDataLineMsgRecord.sessionid, 2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     av
 * JD-Core Version:    0.7.0.1
 */