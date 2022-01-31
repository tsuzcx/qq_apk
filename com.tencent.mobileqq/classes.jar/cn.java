import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import java.util.ArrayList;
import java.util.Iterator;

class cn
  implements DialogInterface.OnClickListener
{
  cn(cm paramcm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ajum localajum = (ajum)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.a(8);
    Object localObject;
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isReportPause = true;
      if (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) {
        fc.m(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
    }
    else
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2000) && (!this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle())) {
        fc.o(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.isSingle()) || (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2335)) {
        break label251;
      }
      localajum.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupId(), 0L, true);
      localObject = null;
      paramInt = 0;
    }
    for (;;)
    {
      localajum.a(this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet);
      if (paramInt != 0) {
        localajum.a((DataLineMsgSet)localObject);
      }
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Fk.b();
      this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_Fk.notifyDataSetChanged();
      paramDialogInterface.dismiss();
      return;
      fc.k(this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app);
      break;
      label251:
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject).next();
        localajum.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, true);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().size() == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.getGroupType() == -2005))
      {
        paramInt = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.getSetIndex(((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid) + 1;
        if ((paramInt < this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.size()) && (((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).msgtype == -5041) && (Long.parseLong(((DataLineMsgRecord)this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt).values().get(0)).getExtInfoFromExtStr("tim_aio_file_msg_uiniseq")) == ((DataLineMsgRecord)this.a.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSet.values().get(0)).sessionid))
        {
          localObject = this.a.jdField_a_of_type_ComDatalineActivitiesLiteActivity.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgSetList.get(paramInt);
          paramInt = 1;
          continue;
        }
      }
      localObject = null;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     cn
 * JD-Core Version:    0.7.0.1
 */