import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class anst
  implements auir
{
  anst(ansr paramansr, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    audr.c(BaseApplicationImpl.getContext().getString(2131692491));
    ((ansr)this.jdField_a_of_type_Ansr.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).OnSessionComplete(this.jdField_a_of_type_Long, 41, paramInt);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = (String)paramObject;
    paramObject = (ansr)this.jdField_a_of_type_Ansr.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject.OnSessionComplete(this.jdField_a_of_type_Long, 0, -999);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
        int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Long);
        localDataLineMsgRecord = this.jdField_a_of_type_Ansr.app.getMessageFacade().getDatalineMessageManager(i).a(this.jdField_a_of_type_Long);
      } while (localDataLineMsgRecord == null);
      localDataLineMsgRecord.serverPath = ((String)localObject);
      localDataLineMsgRecord.nOpType = 1;
      localDataLineMsgRecord.bIsSended = true;
      localDataLineMsgRecord.bIsTransfering = false;
      if (localDataLineMsgRecord.entityID != 0L)
      {
        localObject = this.jdField_a_of_type_Ansr.app.getFileManagerDataCenter().a(localDataLineMsgRecord.entityID);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).Uuid = localDataLineMsgRecord.serverPath;
        }
      }
    } while (!paramObject.a(localDataLineMsgRecord));
    paramObject.a(localDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anst
 * JD-Core Version:    0.7.0.1
 */