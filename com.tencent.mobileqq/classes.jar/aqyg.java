import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqyg
  extends aqwb
{
  private aqru a;
  
  public aqyg(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aqru = new aqyh(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqru);
  }
  
  private aqyi a(long paramLong, boolean paramBoolean)
  {
    aqwc localaqwc = a(paramLong);
    if (localaqwc == null) {
      return null;
    }
    if ((localaqwc instanceof aqyi)) {
      return (aqyi)localaqwc;
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
    Object localObject2 = arqx.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!arso.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = arqx.a().d() + a(paramInt, bhqh.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bdhb.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new aqyi(paramFileManagerEntity);
    ((aqyi)localObject2).jdField_a_of_type_Int = paramInt;
    ((aqyi)localObject2).b = i;
    a((aqwc)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((aqyi)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, arah paramarah) {}
  
  public void a(long paramLong, bdpx parambdpx)
  {
    parambdpx.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, arah paramarah)
  {
    aqyi localaqyi = a(paramLong, false);
    if (localaqyi == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaqyi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      arrr.e(localaqyi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaqyi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaqyi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaqyi.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramarah);
  }
  
  public boolean a(long paramLong, arah paramarah)
  {
    paramarah = a(paramLong, false);
    if (paramarah == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramarah.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, arah paramarah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyg
 * JD-Core Version:    0.7.0.1
 */