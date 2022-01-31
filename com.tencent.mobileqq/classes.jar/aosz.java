import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aosz
{
  private int jdField_a_of_type_Int;
  private aotf jdField_a_of_type_Aotf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private String jdField_a_of_type_JavaLangString;
  private List<aotf> jdField_a_of_type_JavaUtilList;
  private int b = 0;
  
  public aosz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.WeiYunDirKey = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.c;
    localFileManagerEntity.strLargeThumPath = paramWeiYunFileInfo.e;
    localFileManagerEntity.strFileSHA = paramWeiYunFileInfo.j;
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.i;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.srvTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity.nFileType = 0;
    localFileManagerEntity.cloudType = 2;
    return localFileManagerEntity;
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.trim().length() == 0) || (this.jdField_a_of_type_JavaLangString.equals(localFileManagerEntity.peerUin)))
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.jdField_a_of_type_Int = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {}
    while (paramInt2 == 0) {
      return false;
    }
    return true;
  }
  
  private boolean a(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool;
    if (paramIntent.getBooleanExtra("is_in_zip", false))
    {
      bool = a(paramForwardFileInfo);
      this.b = 1;
      if (bool) {
        break label247;
      }
      QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.b() + "] return false");
    }
    label247:
    while (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      return bool;
      switch (paramForwardFileInfo.b())
      {
      case 10005: 
      case 10008: 
      default: 
        if (QLog.isDevelopLevel()) {
          QLog.w("FileViewerParamParser", 4, "parseImageGallery: type[" + paramForwardFileInfo.b() + "] is not implemented");
        }
      case 10000: 
      case 10006: 
      case 10002: 
        do
        {
          bool = false;
          break;
          bool = b(paramIntent);
          break;
        } while (!QLog.isDevelopLevel());
        QLog.w("FileViewerParamParser", 4, "parseImageGallery: not support OfflineFile type");
        bool = false;
        break;
      case 10003: 
        bool = c(paramIntent);
        break;
      case 10001: 
        bool = a();
        break;
      case 10004: 
        bool = d(paramIntent);
        break;
      case 10009: 
        bool = e(paramIntent);
        break;
      case 10007: 
        bool = b();
        break;
      case 10010: 
        bool = c();
        break;
      }
    }
    QLog.e("FileViewerParamParser", 1, "parseImageGallery type[" + paramForwardFileInfo.b() + "] list is empty");
    return false;
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    paramForwardFileInfo = paramForwardFileInfo.a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramForwardFileInfo = paramForwardFileInfo.iterator();
    int i = 0;
    while (paramForwardFileInfo.hasNext())
    {
      Object localObject = (Long)paramForwardFileInfo.next();
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((Long)localObject).longValue());
      if (localObject != null)
      {
        if (apdh.b(((FileManagerEntity)localObject).getFilePath())) {
          ((FileManagerEntity)localObject).status = 1;
        }
        if (((FileManagerEntity)localObject).nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.jdField_a_of_type_Int = i;
        }
        while (a(((FileManagerEntity)localObject).nFileType, ((FileManagerEntity)localObject).getCloudType()))
        {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean b()
  {
    Object localObject3 = aonm.b();
    Object localObject2 = aonm.a();
    Object localObject1 = aonm.d();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a((FileInfo)localObject3));
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (apck.a(((WeiYunFileInfo)localObject2).c) == 0) {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (WeiYunFileInfo)localObject2));
        }
      }
    }
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  private boolean b(Intent paramIntent)
  {
    Object localObject = aonm.a();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
      return false;
    }
    int k = paramIntent.getIntExtra("clicked_file_hashcode", 0);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = ((ArrayList)localObject).iterator();
    int i = 0;
    int j = 0;
    if (paramIntent.hasNext())
    {
      localObject = (FileInfo)paramIntent.next();
      if ((i == 0) && (((FileInfo)localObject).hashCode() == k))
      {
        this.jdField_a_of_type_Int = j;
        this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        i = 1;
      }
      for (;;)
      {
        j += 1;
        break;
        this.jdField_a_of_type_JavaUtilList.add(aosy.a((FileInfo)localObject));
      }
    }
    aonm.a();
    return true;
  }
  
  private boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if ((5 == localFileManagerEntity.getCloudType()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOlSenderProgress == localFileManagerEntity.nOlSenderProgress) && ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.trim().length() == 0) || (this.jdField_a_of_type_JavaLangString.equals(localFileManagerEntity.peerUin))))
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.jdField_a_of_type_Int = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          break;
        }
      }
    }
    return true;
  }
  
  private boolean c(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("local_weiyun_list");
    if ((paramIntent == null) || (paramIntent.size() == 0)) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramIntent.next();
      if ((localWeiYunFileInfo.jdField_a_of_type_JavaLangString != null) && (localWeiYunFileInfo.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId))) {
        this.jdField_a_of_type_Int = i;
      }
      do
      {
        do
        {
          i += 1;
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localWeiYunFileInfo));
          break;
        } while (apck.a(localWeiYunFileInfo.c) == 0);
        if (!localWeiYunFileInfo.jdField_a_of_type_Boolean) {
          break;
        }
      } while (localWeiYunFileInfo.c.toLowerCase().endsWith("heic"));
    }
    return true;
  }
  
  private boolean d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_Uinseq_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.jdField_a_of_type_Int = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  private boolean e(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_SessionId_ImageList");
    if (paramIntent == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramIntent = paramIntent.iterator();
    int i = 0;
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0L, "", 0, l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) {
          this.jdField_a_of_type_Int = i;
        }
        while (a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType()))
        {
          this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity));
          i += 1;
          break;
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public aoqz a(BaseActivity paramBaseActivity)
  {
    return new aota(this, paramBaseActivity);
  }
  
  public aotf a()
  {
    return this.jdField_a_of_type_Aotf;
  }
  
  public List<aotf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(Intent paramIntent)
  {
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    long l = localForwardFileInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      if (localForwardFileInfo.d() != 9) {
        break label104;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = axeg.a(localForwardFileInfo);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("FileViewerParamParser", 1, "FileViewerParamParsernot found, bug. sessionid:" + String.valueOf(l));
      return false;
      label104:
      WeiYunFileInfo localWeiYunFileInfo = localForwardFileInfo.a();
      if (localWeiYunFileInfo != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = a(localWeiYunFileInfo);
      }
    }
    if (5 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType) {
      apck.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    boolean bool;
    if (a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType()))
    {
      bool = a(paramIntent, localForwardFileInfo);
      if ((!bool) && ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) && (localForwardFileInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null))
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilList.add(aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_Aotf = aosy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.b = 3;
      return true;
    }
    return bool;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosz
 * JD-Core Version:    0.7.0.1
 */