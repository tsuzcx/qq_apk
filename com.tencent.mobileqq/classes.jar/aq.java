import android.view.View;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

public class aq
  implements bhuk
{
  public aq(LiteActivity paramLiteActivity, DataLineMsgSet paramDataLineMsgSet, ef paramef, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhuf.cancel();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -1000)
      {
        paramView = this.jdField_a_of_type_Ef.a().jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a(paramView, this.jdField_a_of_type_Ef.a().jdField_a_of_type_Long, -1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aq
 * JD-Core Version:    0.7.0.1
 */