import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class atwk
  extends atwq
{
  private ansy a;
  
  public atwk(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atuz> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    ansr localansr = (ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Atuz.a().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getDatalineMessageManager(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localansr.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label188;
        }
        dq.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localansr.a(localArrayList)) {
        break;
      }
      localFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0) {
        localDataLineMsgRecord.progress = 0.0F;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getDatalineMessageManager(i).c(localDataLineMsgRecord.msgId);
      return;
      label188:
      dq.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    audr.a(2131693648);
  }
  
  private void p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    ansr localansr;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localansr = (ansr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getDatalineMessageManager(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label148;
      }
      if (!localDataLineMsgRecord.isReportPause)
      {
        localDataLineMsgRecord.isReportPause = true;
        dq.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      localansr.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      localFileManagerEntity.status = 3;
      return;
      label148:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        dq.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void q()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidAppActivity)) {
      audr.a(2131692469);
    }
    Object localObject;
    ansr localansr;
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Atuz.a();
      localansr = (ansr)this.jdField_a_of_type_Atuw.a().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.jdField_a_of_type_Atuw.a().getMessageFacade().getDatalineMessageManager(i).a(((FileManagerEntity)localObject).uniseq);
    } while ((localObject == null) || (f() != 6000));
    ((DataLineMsgRecord)localObject).bIsResendOrRecvFile = true;
    switch (e())
    {
    default: 
      return;
    case -1: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      if (FileUtils.fileExists(d()))
      {
        localansr.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localansr.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localansr.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    if (((DataLineMsgRecord)localObject).nOpType == 35)
    {
      localansr.b((DataLineMsgRecord)localObject);
      return;
    }
    localansr.a().a((DataLineMsgRecord)localObject, i, 2);
  }
  
  public int a()
  {
    int i = e();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public aqoa a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new atvi(this.jdField_a_of_type_Atuw.a().getMessageFacade().getDatalineMessageManager(i).a(localFileManagerEntity.uniseq));
  }
  
  public atvp a()
  {
    if (this.jdField_a_of_type_Atvp == null) {
      this.jdField_a_of_type_Atvp = new atwo(this);
    }
    return this.jdField_a_of_type_Atvp;
  }
  
  public atvs a()
  {
    if (this.jdField_a_of_type_Atvs == null) {
      this.jdField_a_of_type_Atvs = new atwm(this);
    }
    return this.jdField_a_of_type_Atvs;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Ansy != null) {
      return;
    }
    this.jdField_a_of_type_Ansy = new atwl(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Ansy);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList[] arrayOfArrayList = super.a();
    if (!FileUtil.fileExistsAndNotEmpty(d())) {
      arrayOfArrayList = null;
    }
    return arrayOfArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ansy != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ansy);
      this.jdField_a_of_type_Ansy = null;
    }
  }
  
  public int d()
  {
    if (auea.b(d())) {
      return 3;
    }
    return super.d();
  }
  
  public String h()
  {
    String str2 = super.h();
    int i = i();
    String str1;
    if (i == 5) {
      str1 = "";
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return str1;
              if (i == 0) {
                break;
              }
              str1 = str2;
            } while (i != 6);
            str1 = str2;
          } while (this.jdField_a_of_type_Atuz == null);
          localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
          str1 = str2;
        } while (localFileManagerEntity == null);
        str1 = str2;
      } while (auea.c(localFileManagerEntity.getFilePath()));
      str1 = str2;
    } while (!auea.a(localFileManagerEntity));
    return "";
  }
  
  public int i()
  {
    int j = super.i();
    int i;
    if (j != 0)
    {
      i = j;
      if (j != 6) {}
    }
    else
    {
      i = j;
      if (this.jdField_a_of_type_Atuz != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!auea.c(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (auea.a(localFileManagerEntity)) {
              i = 5;
            }
          }
        }
      }
    }
    return i;
  }
  
  public boolean i()
  {
    if (g() == 35) {
      return false;
    }
    return super.i();
  }
  
  public int j()
  {
    int j = 2;
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L)) {
        if ((this.jdField_a_of_type_Atuw != null) && (this.jdField_a_of_type_Atuw.e())) {
          i = j;
        }
      }
      for (;;)
      {
        return i;
        if (i != 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atwk
 * JD-Core Version:    0.7.0.1
 */