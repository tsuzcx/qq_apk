import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aqrz
  extends aqrs
{
  private aqnl a;
  
  public aqrz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aqnl = new aqsa(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aqnl);
  }
  
  private aqsb a(long paramLong, boolean paramBoolean)
  {
    aqrt localaqrt = a(paramLong);
    if (localaqrt == null) {
      return null;
    }
    if ((localaqrt instanceof aqsb)) {
      return (aqsb)localaqrt;
    }
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. can not getThumb of file:" + paramFileManagerEntity.fileName);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    String str = paramFileManagerEntity.Uuid.replace("/", "");
    a();
    str = armo.a().d() + a(paramInt, str);
    if (bdcs.b(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    aqsb localaqsb = new aqsb(paramFileManagerEntity);
    localaqsb.jdField_a_of_type_Int = paramInt;
    localaqsb.b = i;
    a(localaqsb, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaqsb.jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, aqvy paramaqvy) {}
  
  public void a(long paramLong, bdlo parambdlo)
  {
    parambdlo.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, aqvy paramaqvy)
  {
    aqsb localaqsb = a(paramLong, false);
    if (localaqsb == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaqsb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      arni.e(localaqsb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaqsb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaqsb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaqsb.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramaqvy);
  }
  
  public boolean a(long paramLong, aqvy paramaqvy)
  {
    paramaqvy = a(paramLong, false);
    if (paramaqvy == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramaqvy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, aqvy paramaqvy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqrz
 * JD-Core Version:    0.7.0.1
 */