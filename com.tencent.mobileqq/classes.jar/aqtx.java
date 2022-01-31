import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqtx
  extends aqrs
{
  private aqnl a;
  
  public aqtx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aqnl = new aqty(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  private aqtz a(long paramLong, boolean paramBoolean)
  {
    aqrt localaqrt = a(paramLong);
    if (localaqrt == null) {
      return null;
    }
    if ((localaqrt instanceof aqtz)) {
      return (aqtz)localaqrt;
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
    Object localObject2 = armo.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!arof.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = armo.a().d() + a(paramInt, bhma.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bdcs.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new aqtz(paramFileManagerEntity);
    ((aqtz)localObject2).jdField_a_of_type_Int = paramInt;
    ((aqtz)localObject2).b = i;
    a((aqrt)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((aqtz)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, aqvy paramaqvy) {}
  
  public void a(long paramLong, bdlo parambdlo)
  {
    parambdlo.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, aqvy paramaqvy)
  {
    aqtz localaqtz = a(paramLong, false);
    if (localaqtz == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaqtz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      arni.e(localaqtz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaqtz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaqtz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaqtz.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramaqvy);
  }
  
  public boolean a(long paramLong, aqvy paramaqvy)
  {
    paramaqvy = a(paramLong, false);
    if (paramaqvy == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, aqvy paramaqvy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqtx
 * JD-Core Version:    0.7.0.1
 */