import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class apav
  extends aoyq
{
  private aouj a;
  
  public apav(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aouj = new apaw(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aouj);
  }
  
  private apax a(long paramLong, boolean paramBoolean)
  {
    aoyr localaoyr = a(paramLong);
    if (localaoyr == null) {
      return null;
    }
    if ((localaoyr instanceof apax)) {
      return (apax)localaoyr;
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
    Object localObject2 = apti.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!apvb.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = apti.a().d() + a(paramInt, bfkp.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bbdj.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new apax(paramFileManagerEntity);
    ((apax)localObject2).jdField_a_of_type_Int = paramInt;
    ((apax)localObject2).b = i;
    a((aoyr)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((apax)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, apcw paramapcw) {}
  
  public void a(long paramLong, bbmg parambbmg)
  {
    parambbmg.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apcw paramapcw)
  {
    apax localapax = a(paramLong, false);
    if (localapax == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localapax.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      apue.e(localapax.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localapax.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localapax.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localapax.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramapcw);
  }
  
  public boolean a(long paramLong, apcw paramapcw)
  {
    paramapcw = a(paramLong, false);
    if (paramapcw == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, apcw paramapcw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apav
 * JD-Core Version:    0.7.0.1
 */