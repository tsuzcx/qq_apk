import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class apmt
  extends apmi
{
  private long jdField_a_of_type_Long = -1L;
  private ybw jdField_a_of_type_Ybw;
  private long b = -1L;
  
  public apmt(Activity paramActivity, List<apkt> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    a(paramList, paramInt);
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_Apkt.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
      return false;
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      return false;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return false;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    yel localyel = ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localyel.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.jdField_a_of_type_Long = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  private void m()
  {
    Object localObject = this.jdField_a_of_type_Apkt.a();
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      do
      {
        return;
      } while (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()));
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    } while (localObject == null);
    localObject = (MessageForDeviceSingleStruct)localObject;
    this.jdField_a_of_type_Long = ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a((MessageForDeviceSingleStruct)localObject);
  }
  
  private void n()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.msgSeq);
    } while (localObject == null);
    Object localObject = (MessageForDeviceSingleStruct)localObject;
    ((yer)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().b((MessageForDeviceSingleStruct)localObject);
    localFileManagerEntity.status = 3;
    this.jdField_a_of_type_Long = -1L;
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
    case 1: 
    default: 
      return 1;
    case 0: 
      return 6;
    }
    return 2;
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new apmv(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplj a()
  {
    return new apmx(this);
  }
  
  public aplk a()
  {
    return null;
  }
  
  public List<apnc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new apln((apkt)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Ybw != null) {
      return;
    }
    this.jdField_a_of_type_Ybw = new apmu(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ybw);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Ybw != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ybw);
      this.jdField_a_of_type_Ybw = null;
    }
  }
  
  public int d()
  {
    if (apug.b(c())) {
      return 3;
    }
    return super.d();
  }
  
  public int h()
  {
    return 2;
  }
  
  public int i()
  {
    if (apug.b(c())) {
      return 2;
    }
    if (a()) {
      return 4;
    }
    return 3;
  }
  
  public boolean i()
  {
    return bbfj.h(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmt
 * JD-Core Version:    0.7.0.1
 */