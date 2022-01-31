import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aokb
  extends aohw
{
  private aodp a;
  
  public aokb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aodp = new aokc(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aodp);
  }
  
  private aokd a(long paramLong, boolean paramBoolean)
  {
    aohx localaohx = a(paramLong);
    if (localaohx == null) {
      return null;
    }
    if ((localaohx instanceof aokd)) {
      return (aokd)localaohx;
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
    Object localObject2 = apbo.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!apdh.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = apbo.a().d() + a(paramInt, becz.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bace.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new aokd(paramFileManagerEntity);
    ((aokd)localObject2).jdField_a_of_type_Int = paramInt;
    ((aokd)localObject2).b = i;
    a((aohx)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((aokd)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, aomc paramaomc) {}
  
  public void a(long paramLong, bakw parambakw)
  {
    parambakw.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, aomc paramaomc)
  {
    aokd localaokd = a(paramLong, false);
    if (localaokd == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaokd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      apck.e(localaokd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaokd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaokd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaokd.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramaomc);
  }
  
  public boolean a(long paramLong, aomc paramaomc)
  {
    paramaomc = a(paramLong, false);
    if (paramaomc == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaomc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, aomc paramaomc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokb
 * JD-Core Version:    0.7.0.1
 */