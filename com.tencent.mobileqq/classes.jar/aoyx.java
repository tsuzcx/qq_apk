import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aoyx
  extends aoyq
{
  private aouj a;
  
  public aoyx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aouj = new aoyy(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aouj);
  }
  
  private aoyz a(long paramLong, boolean paramBoolean)
  {
    aoyr localaoyr = a(paramLong);
    if (localaoyr == null) {
      return null;
    }
    if ((localaoyr instanceof aoyz)) {
      return (aoyz)localaoyr;
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
    str = apti.a().d() + a(paramInt, str);
    if (bbdj.b(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    aoyz localaoyz = new aoyz(paramFileManagerEntity);
    localaoyz.jdField_a_of_type_Int = paramInt;
    localaoyz.b = i;
    a(localaoyz, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaoyz.jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, apcw paramapcw) {}
  
  public void a(long paramLong, bbmg parambbmg)
  {
    parambbmg.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apcw paramapcw)
  {
    aoyz localaoyz = a(paramLong, false);
    if (localaoyz == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaoyz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      apue.e(localaoyz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaoyz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaoyz.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaoyz.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramapcw);
  }
  
  public boolean a(long paramLong, apcw paramapcw)
  {
    paramapcw = a(paramLong, false);
    if (paramapcw == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramapcw.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, apcw paramapcw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoyx
 * JD-Core Version:    0.7.0.1
 */