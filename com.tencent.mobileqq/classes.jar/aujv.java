import android.app.Activity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aujv
  extends atwq
{
  private long jdField_a_of_type_Long = -1L;
  private abib jdField_a_of_type_Abib;
  private long b = -1L;
  
  public aujv(QQAppInterface paramQQAppInterface, Activity paramActivity, List<atuz> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("DeviceFileModel<FileAssistant>", 1, "FileBrowserModel init: type = device");
    }
    a(paramList, paramInt);
  }
  
  private boolean m()
  {
    Object localObject = this.jdField_a_of_type_Atuz.a();
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    if (localObject == null) {
      return false;
    }
    localObject = (MessageForDeviceSingleStruct)localObject;
    abkq localabkq = ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
    if ((((MessageForDeviceSingleStruct)localObject).nMediaSessionID > 0L) && (localabkq.a((MessageForDeviceSingleStruct)localObject)))
    {
      this.jdField_a_of_type_Long = ((MessageForDeviceSingleStruct)localObject).nMediaSessionID;
      return true;
    }
    return false;
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_Atuz.a();
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(((FileManagerEntity)localObject).peerUin, ((FileManagerEntity)localObject).peerType, ((FileManagerEntity)localObject).msgSeq);
    } while (localObject == null);
    localObject = (MessageForDeviceSingleStruct)localObject;
    this.jdField_a_of_type_Long = ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a((MessageForDeviceSingleStruct)localObject);
  }
  
  private void p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atuz.a();
    if (localFileManagerEntity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DeviceFileModel<FileAssistant>", 2, "fileEntity = null");
      }
    }
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgItemByUniseq(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.msgSeq);
    } while (localObject == null);
    Object localObject = (MessageForDeviceSingleStruct)localObject;
    ((abkw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().b((MessageForDeviceSingleStruct)localObject);
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
  
  public atvp a()
  {
    if (this.jdField_a_of_type_Atvp == null) {
      this.jdField_a_of_type_Atvp = new aujx(this);
    }
    return this.jdField_a_of_type_Atvp;
  }
  
  public atvr a()
  {
    return new aujz(this);
  }
  
  public atvs a()
  {
    return null;
  }
  
  public List<atxc> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new atvv((atuz)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Abib != null) {
      return;
    }
    this.jdField_a_of_type_Abib = new aujw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Abib);
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Abib != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Abib);
      this.jdField_a_of_type_Abib = null;
    }
  }
  
  public int d()
  {
    if (auea.b(d())) {
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
    if (auea.b(d())) {
      return 2;
    }
    if (m()) {
      return 4;
    }
    return 3;
  }
  
  public boolean i()
  {
    return NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujv
 * JD-Core Version:    0.7.0.1
 */