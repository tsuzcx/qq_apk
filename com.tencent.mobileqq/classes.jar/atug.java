import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atug
  extends atub
{
  private atpa a;
  
  public atug(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Atpa = new atuh(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
  
  private atui a(long paramLong, boolean paramBoolean)
  {
    atuc localatuc = a(paramLong);
    if (localatuc == null) {
      return null;
    }
    if ((localatuc instanceof atui)) {
      return (atui)localatuc;
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
    str = aumo.a().d() + a(paramInt, str);
    if (bhmi.b(str) == true)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
      return str;
    }
    atui localatui = new atui(paramFileManagerEntity);
    localatui.jdField_a_of_type_Int = paramInt;
    localatui.b = i;
    a(localatui, str);
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localatui.jdField_a_of_type_Long + "]");
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramList = a(paramLong, false);
    if ((paramList != null) && (paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!TextUtils.isEmpty(paramString)) && (atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 5)))
    {
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new atum(paramString, paramInt);
      paramList = atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 5);
      if ((paramList != null) && (!paramList.a()))
      {
        paramString = new ArrayList();
        paramList = paramList.a.iterator();
        while (paramList.hasNext())
        {
          atun localatun = (atun)paramList.next();
          paramString.add(localatun.jdField_a_of_type_JavaLangString + ":" + localatun.jdField_a_of_type_Int);
        }
        QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] discVideo thumb. use IPv4:");
    }
    return null;
  }
  
  public void a(long paramLong, atyq paramatyq) {}
  
  public void a(long paramLong, bhva parambhva)
  {
    parambhva.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, atyq paramatyq)
  {
    atui localatui = a(paramLong, false);
    if (localatui == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      aunj.d(localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localatui.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatui.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramatyq);
  }
  
  public boolean a(long paramLong, atyq paramatyq)
  {
    paramatyq = a(paramLong, false);
    if (paramatyq == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, atyq paramatyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atug
 * JD-Core Version:    0.7.0.1
 */