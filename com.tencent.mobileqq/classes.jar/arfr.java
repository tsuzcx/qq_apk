import android.app.Activity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arfr
  extends arfh
{
  private long jdField_a_of_type_Long = -1L;
  private zqp jdField_a_of_type_Zqp;
  private long b = -1L;
  
  public arfr(Activity paramActivity, List<ardq> paramList, int paramInt)
  {
    super(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    a(paramList, paramInt);
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_Ardq.a();
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
    zte localzte = ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localzte.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.jdField_a_of_type_Long = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_Ardq.a();
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
    this.jdField_a_of_type_Long = ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a((MessageForDeviceSingleStruct)localObject);
  }
  
  private void p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Ardq.a();
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
    ((ztk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().b((MessageForDeviceSingleStruct)localObject);
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
  
  public areg a()
  {
    if (this.jdField_a_of_type_Areg == null) {
      this.jdField_a_of_type_Areg = new arft(this);
    }
    return this.jdField_a_of_type_Areg;
  }
  
  public arei a()
  {
    return new arfv(this);
  }
  
  public arej a()
  {
    return null;
  }
  
  public List<argc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new arem((ardq)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Zqp != null) {
      return;
    }
    this.jdField_a_of_type_Zqp = new arfs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Zqp);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Zqp != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Zqp);
      this.jdField_a_of_type_Zqp = null;
    }
  }
  
  public int d()
  {
    if (arni.b(d())) {
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
    if (arni.b(d())) {
      return 2;
    }
    if (a()) {
      return 4;
    }
    return 3;
  }
  
  public boolean i()
  {
    return bdee.h(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfr
 * JD-Core Version:    0.7.0.1
 */