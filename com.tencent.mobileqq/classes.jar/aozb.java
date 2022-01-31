import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class aozb
  extends aoyu
{
  private aoun a;
  
  public aozb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Aoun = new aozc(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Aoun);
  }
  
  private aozd a(long paramLong, boolean paramBoolean)
  {
    aoyv localaoyv = a(paramLong);
    if (localaoyv == null) {
      return null;
    }
    if ((localaoyv instanceof aozd)) {
      return (aozd)localaoyv;
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
    str = aptm.a().d() + a(paramInt, str);
    if (bbdx.b(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    aozd localaozd = new aozd(paramFileManagerEntity);
    localaozd.jdField_a_of_type_Int = paramInt;
    localaozd.b = i;
    a(localaozd, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localaozd.jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, apda paramapda) {}
  
  public void a(long paramLong, bbmu parambbmu)
  {
    parambbmu.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, apda paramapda)
  {
    aozd localaozd = a(paramLong, false);
    if (localaozd == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localaozd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      apug.e(localaozd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localaozd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localaozd.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localaozd.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramapda);
  }
  
  public boolean a(long paramLong, apda paramapda)
  {
    paramapda = a(paramLong, false);
    if (paramapda == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramapda.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, apda paramapda) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aozb
 * JD-Core Version:    0.7.0.1
 */