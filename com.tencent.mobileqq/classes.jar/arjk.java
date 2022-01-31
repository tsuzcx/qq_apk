import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class arjk
  extends arjq
{
  private alqv a;
  
  public arjk(Activity paramActivity, List<arhz> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DatalineFileModel<FileAssistant>", 1, "FileBrowserModel init: type = dataline");
    }
    a(paramList, paramInt);
  }
  
  private void o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    alqo localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    int i = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_Arhz.a().uniseq);
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(localFileManagerEntity.uniseq);
    if (localDataLineMsgRecord == null) {
      return;
    }
    if (localDataLineMsgRecord.strMoloKey != null)
    {
      localalqo.b(111);
      if (localDataLineMsgRecord.fileMsgStatus == 1L)
      {
        if (!DataLineMsgSet.isSingle(localDataLineMsgRecord)) {
          break label187;
        }
        dl.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
      if (!localalqo.a(localArrayList)) {
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
      dl.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    arri.a(2131694064);
  }
  
  private void p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    alqo localalqo;
    DataLineMsgRecord localDataLineMsgRecord;
    if ((localFileManagerEntity.getCloudType() == 6) && (localFileManagerEntity.peerDin == 0L))
    {
      localalqo = (alqo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
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
        dl.k(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      localalqo.a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
      localFileManagerEntity.status = 3;
      return;
      label147:
      if ((!localDataLineMsgRecord.isReportPause) && (localDataLineMsgRecord.msgtype == -2335))
      {
        localDataLineMsgRecord.isReportPause = true;
        dl.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
  }
  
  private void q()
  {
    if (!bdin.d(this.jdField_a_of_type_AndroidAppActivity)) {
      arri.a(2131692747);
    }
    Object localObject;
    alqo localalqo;
    int i;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Arhz.a();
      localalqo = (alqo)this.jdField_a_of_type_Arhw.a().a(8);
      i = DataLineMsgRecord.getDevTypeBySeId(((FileManagerEntity)localObject).uniseq);
      localObject = this.jdField_a_of_type_Arhw.a().a().a(i).a(((FileManagerEntity)localObject).uniseq);
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
      if (bdhb.a(d()))
      {
        localalqo.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 0, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
        return;
      }
      break;
    case 0: 
      localalqo.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 1, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    case 2: 
      localalqo.a(d(), ((DataLineMsgRecord)localObject).thumbPath, 2, ((DataLineMsgRecord)localObject).sessionid, ((DataLineMsgRecord)localObject).groupId, ((DataLineMsgRecord)localObject).groupSize, ((DataLineMsgRecord)localObject).groupIndex, true);
      return;
    }
    if (((DataLineMsgRecord)localObject).nOpType == 35)
    {
      localalqo.b((DataLineMsgRecord)localObject);
      return;
    }
    localalqo.a().a((DataLineMsgRecord)localObject, i, 2);
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public aocf a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
    int i = DataLineMsgRecord.getDevTypeBySeId(localFileManagerEntity.uniseq);
    return new arii(this.jdField_a_of_type_Arhw.a().a().a(i).a(localFileManagerEntity.uniseq));
  }
  
  public arip a()
  {
    if (this.jdField_a_of_type_Arip == null) {
      this.jdField_a_of_type_Arip = new arjo(this);
    }
    return this.jdField_a_of_type_Arip;
  }
  
  public aris a()
  {
    if (this.jdField_a_of_type_Aris == null) {
      this.jdField_a_of_type_Aris = new arjm(this);
    }
    return this.jdField_a_of_type_Aris;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Alqv != null) {
      return;
    }
    this.jdField_a_of_type_Alqv = new arjl(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Alqv);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList[] arrayOfArrayList = super.a();
    if (!arso.b(d())) {
      arrayOfArrayList = null;
    }
    return arrayOfArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Alqv != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del datalineObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Alqv);
      this.jdField_a_of_type_Alqv = null;
    }
  }
  
  public int d()
  {
    if (arrr.b(d())) {
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
          } while (this.jdField_a_of_type_Arhz == null);
          localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
          str1 = str2;
        } while (localFileManagerEntity == null);
        str1 = str2;
      } while (arrr.c(localFileManagerEntity.getFilePath()));
      str1 = str2;
    } while (!arrr.a(localFileManagerEntity));
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
      if (this.jdField_a_of_type_Arhz != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
        i = j;
        if (localFileManagerEntity != null)
        {
          i = j;
          if (!arrr.c(localFileManagerEntity.getFilePath()))
          {
            i = j;
            if (arrr.a(localFileManagerEntity)) {
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
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arhz.a();
      if ((localFileManagerEntity != null) && (localFileManagerEntity.uniseq != 0L)) {
        if ((this.jdField_a_of_type_Arhw != null) && (this.jdField_a_of_type_Arhw.d())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjk
 * JD-Core Version:    0.7.0.1
 */