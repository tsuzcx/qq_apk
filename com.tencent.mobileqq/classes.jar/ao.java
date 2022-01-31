import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.dataline.util.DatalineSessionAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import java.util.ArrayList;
import java.util.Iterator;

class ao
  implements DialogInterface.OnClickListener
{
  ao(an paraman) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        DataLineReportUtil.m(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
        DataLineReportUtil.o(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label233;
      }
      localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, true);
    }
    for (;;)
    {
      localDataLineHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.b();
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.a.notifyDataSetChanged();
      paramDialogInterface.dismiss();
      return;
      DataLineReportUtil.k(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      break;
      label233:
      Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (localIterator.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
        localDataLineHandler.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ao
 * JD-Core Version:    0.7.0.1
 */