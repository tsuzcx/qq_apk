import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apmc
  extends apmi
{
  private ajut a;
  
  public apmc(Activity paramActivity, List<apkt> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void m()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Apkt.a().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localajum.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label187;
        }
        fc.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localajum.a(localArrayList)) {
        break;
      }
      localFileManagerEntity.status = 2;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      if (Float.compare(localDataLineMsgRecord.progress, 1.0F) == 0) {
        localDataLineMsgRecord.progress = 0.0F;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).c(localDataLineMsgRecord.msgId);
      return;
      label187:
      fc.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    aptx.a(2131693946);
  }
  
  private void n()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    ajum localajum;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
      localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
      if (localDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DatalineFileModel<FileAssistant>", 2, "datalineFileStopTransfer : dataline record is null");
        }
        return;
      }
      if ((localDataLineMsgRecord.strMoloKey == null) || (!DataLineMsgSet.isSingle(localDataLineMsgRecord))) {
        break label147;
      }
      if (!localDataLineMsgRecord.isReportPause)
      {
        localDataLineMsgRecord.isReportPause = true;
        fc.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      localajum.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      localFileManagerEntity.status = 3;
      return;
      label147:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        fc.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void o()
  {
    if (!bbfj.d(this.jdField_a_of_type_AndroidAppActivity)) {
      aptx.a(2131692666);
    }
    Object localObject;
    ajum localajum;
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Apkt.a();
      localajum = (ajum)this.jdField_a_of_type_Apkq.a().a(8);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.jdField_a_of_type_Apkq.a().a().a(i).a(((FileManagerEntity)localObject).uniseq);
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
      if (bbdx.a(c()))
      {
        localajum.a(c(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localajum.a(c(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localajum.a(c(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    if (((DataLineMsgRecord)localObject).nOpType == 35)
    {
      localajum.b((DataLineMsgRecord)localObject);
      return;
    }
    localajum.a().a((DataLineMsgRecord)localObject, i, 2);
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
  
  public amgv a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new aplb(this.jdField_a_of_type_Apkq.a().a().a(i).a(localFileManagerEntity.uniseq));
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new apmg(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplk a()
  {
    if (this.jdField_a_of_type_Aplk == null) {
      this.jdField_a_of_type_Aplk = new apme(this);
    }
    return this.jdField_a_of_type_Aplk;
  }
  
  public ArrayList<bbjs>[] a()
  {
    ArrayList[] arrayOfArrayList = super.a();
    if ((!apvd.b(c())) && (arrayOfArrayList != null) && (arrayOfArrayList.length > 0))
    {
      Iterator localIterator = arrayOfArrayList[0].iterator();
      while (localIterator.hasNext())
      {
        bbjs localbbjs = (bbjs)localIterator.next();
        if (localbbjs.b == 2130843486) {
          arrayOfArrayList[0].remove(localbbjs);
        }
      }
    }
    return arrayOfArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ajut != null) {
      return;
    }
    this.jdField_a_of_type_Ajut = new apmd(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Ajut);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ajut != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Ajut);
      this.jdField_a_of_type_Ajut = null;
    }
  }
  
  public int d()
  {
    if (apug.b(c())) {
      return 3;
    }
    return super.d();
  }
  
  public String f()
  {
    String str2 = super.f();
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
          } while (this.jdField_a_of_type_Apkt == null);
          localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
          str1 = str2;
        } while (localFileManagerEntity == null);
        str1 = str2;
      } while (apug.c(localFileManagerEntity.getFilePath()));
      str1 = str2;
    } while (!apug.a(localFileManagerEntity));
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
      if (this.jdField_a_of_type_Apkt != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!apug.c(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (apug.a(localFileManagerEntity)) {
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
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L)) {
        if ((this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.d())) {
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
 * Qualified Name:     apmc
 * JD-Core Version:    0.7.0.1
 */