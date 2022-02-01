import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atkw
  extends atkr
{
  private atfq a;
  
  public atkw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Atfq = new atkx(this);
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
  
  private atky a(long paramLong, boolean paramBoolean)
  {
    atks localatks = a(paramLong);
    if (localatks == null) {
      return null;
    }
    if ((localatks instanceof atky)) {
      return (atky)localatks;
    }
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. can not getThumb of file:" + paramFileManagerEntity.fileName);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    String str = paramFileManagerEntity.Uuid.replace("/", "");
    a();
    str = audf.a().d() + a(paramInt, str);
    if (FileUtils.fileExistsAndNotEmpty(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    atky localatky = new atky(paramFileManagerEntity);
    localatky.jdField_a_of_type_Int = paramInt;
    localatky.b = i;
    a(localatky, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localatky.jdField_a_of_type_Long + "]");
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramList = a(paramLong, false);
    if ((paramList != null) && (paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!TextUtils.isEmpty(paramString)) && (atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
    {
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new atlc(paramString, paramInt);
      paramList = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 5);
      if ((paramList != null) && (!paramList.a()))
      {
        paramString = new ArrayList();
        paramList = paramList.a.iterator();
        while (paramList.hasNext())
        {
          atld localatld = (atld)paramList.next();
          paramString.add(localatld.jdField_a_of_type_JavaLangString + ":" + localatld.jdField_a_of_type_Int);
        }
        QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv4:");
    }
    return null;
  }
  
  public void a(long paramLong, atpg paramatpg) {}
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    paramHttpMsg.busiType = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atpg paramatpg)
  {
    atky localatky = a(paramLong, false);
    if (localatky == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localatky.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      auea.d(localatky.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localatky.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 50, new Object[] { localatky.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatky.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramatpg);
  }
  
  public boolean a(long paramLong, atpg paramatpg)
  {
    paramatpg = a(paramLong, false);
    if (paramatpg == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().b(paramatpg.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatpg.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, atpg paramatpg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atkw
 * JD-Core Version:    0.7.0.1
 */