import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class apaz
  extends aoyu
{
  private aoun a;
  
  public apaz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aoun = new apba(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  private apbb a(long paramLong, boolean paramBoolean)
  {
    aoyv localaoyv = a(paramLong);
    if (localaoyv == null) {
      return null;
    }
    if ((localaoyv instanceof apbb)) {
      return (apbb)localaoyv;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    a();
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    Object localObject2 = aptm.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!apvd.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = aptm.a().d() + a(paramInt, bflg.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bbdx.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new apbb(paramFileManagerEntity);
    ((apbb)localObject2).jdField_a_of_type_Int = paramInt;
    ((apbb)localObject2).b = i;
    a((aoyv)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((apbb)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, apda paramapda) {}
  
  public void a(long paramLong, bbmu parambbmu)
  {
    parambbmu.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apda paramapda)
  {
    apbb localapbb = a(paramLong, false);
    if (localapbb == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localapbb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      apug.e(localapbb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localapbb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localapbb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localapbb.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramapda);
  }
  
  public boolean a(long paramLong, apda paramapda)
  {
    paramapda = a(paramLong, false);
    if (paramapda == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, apda paramapda) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apaz
 * JD-Core Version:    0.7.0.1
 */