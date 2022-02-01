import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class bz
  implements biyc
{
  public bz(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void a(int paramInt)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      audr.b(auea.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692593));
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.b, null, this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), 0, false);
      this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getMessageFacade().getDatalineMessageManager(paramInt).c(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgId);
      return;
    }
    audr.b(auea.d(this.jdField_a_of_type_JavaLangString) + this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getString(2131692593));
    this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getFileManagerEngine().a(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bz
 * JD-Core Version:    0.7.0.1
 */