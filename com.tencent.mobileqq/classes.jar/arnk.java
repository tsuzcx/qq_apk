import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class arnk
  implements aroj
{
  arnk(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return a(paramString1, paramInt1, paramString2, paramInt2, paramString3, paramString4, paramString5, paramLong, paramInt3, 0L, 0);
  }
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong1, int paramInt3, long paramLong2, int paramInt4)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.fileUuid = paramString3;
    if (paramString2 != null) {
      localDataLineMsgRecord.uOwnerUin = Long.valueOf(paramString2).longValue();
    }
    localDataLineMsgRecord.selfuin = paramString1;
    localDataLineMsgRecord.filename = paramString4;
    if (paramString5 != null)
    {
      localDataLineMsgRecord.thumbPath = arof.a(arof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()), arni.a(paramString5));
      bdcs.d(paramString5, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramLong1;
    localDataLineMsgRecord.busId = paramInt2;
    localDataLineMsgRecord.forwardTroopFileEntrance = paramInt3;
    if (paramInt1 == 0) {
      localDataLineMsgRecord.fileFrom = 1;
    }
    for (localDataLineMsgRecord.nOpType = 29;; localDataLineMsgRecord.nOpType = 31)
    {
      localDataLineMsgRecord.istroop = paramInt1;
      paramString1 = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      localDataLineMsgRecord.sessionid = paramString1.a(0, this.jdField_a_of_type_Int).longValue();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.issend = 1;
      localDataLineMsgRecord.isread = true;
      localDataLineMsgRecord.issuc = false;
      ((alxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localDataLineMsgRecord);
      localDataLineMsgRecord.time = ayvc.a();
      localDataLineMsgRecord.progress = 0.2F;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      localDataLineMsgRecord.msgtype = allz.a(0);
      localDataLineMsgRecord.bIsTransfering = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
      paramString1.a(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)allz.b(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
      return localDataLineMsgRecord.sessionid;
      localDataLineMsgRecord.fileFrom = 2;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt3)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "getDatalineProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    if (paramInt != 0)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        armz.c(BaseApplicationImpl.getContext().getString(2131692750));
        paramBoolean = false;
      }
    }
    else
    {
      paramString1 = (allz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if (paramBoolean) {
        break label158;
      }
      paramString1.OnSessionComplete(paramLong, 41, paramInt);
    }
    label158:
    do
    {
      do
      {
        return;
        armz.c(paramString1);
        break;
        if (TextUtils.isEmpty(paramString4))
        {
          paramString1.OnSessionComplete(paramLong, 0, paramInt);
          return;
        }
        paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt).a(paramLong);
      } while (paramString2 == null);
      paramString2.serverPath = paramString4;
      paramString2.nOpType = 1;
      paramString2.bIsSended = true;
      paramString2.bIsTransfering = false;
      if (paramString2.entityID != 0L)
      {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.entityID);
        if (paramString3 != null)
        {
          paramString3.status = 1;
          paramString3.Uuid = paramString2.serverPath;
        }
      }
    } while (!paramString1.a(paramString2));
    paramString1.a(paramString2);
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arnk
 * JD-Core Version:    0.7.0.1
 */