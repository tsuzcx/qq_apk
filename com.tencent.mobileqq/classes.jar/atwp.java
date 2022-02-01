import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atwp
  extends atub
{
  private atpa a;
  
  public atwp(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Atpa = new atwq(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_Atpa);
  }
  
  private atwr a(long paramLong, boolean paramBoolean)
  {
    atuc localatuc = a(paramLong);
    if (localatuc == null) {
      return null;
    }
    if ((localatuc instanceof atwr)) {
      return (atwr)localatuc;
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
    Object localObject2 = aumo.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!auog.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = aumo.a().d() + a(paramInt, blev.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (bhmi.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new atwr(paramFileManagerEntity);
    ((atwr)localObject2).jdField_a_of_type_Int = paramInt;
    ((atwr)localObject2).b = i;
    a((atuc)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((atwr)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramList = a(paramLong, false);
    if ((paramList != null) && (paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!TextUtils.isEmpty(paramString)) && (atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new atum(paramString, paramInt);
      paramList = atul.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      if ((paramList != null) && (!paramList.a()))
      {
        paramString = new ArrayList();
        paramList = paramList.a.iterator();
        while (paramList.hasNext())
        {
          atun localatun = (atun)paramList.next();
          paramString.add(localatun.jdField_a_of_type_JavaLangString + ":" + localatun.jdField_a_of_type_Int);
        }
        QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv4");
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
    atwr localatwr = a(paramLong, false);
    if (localatwr == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localatwr.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      aunj.d(localatwr.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localatwr.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localatwr.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatwr.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramatyq);
  }
  
  public boolean a(long paramLong, atyq paramatyq)
  {
    paramatyq = a(paramLong, false);
    if (paramatyq == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatyq.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, paramLong);
    return true;
  }
  
  public void b(long paramLong, atyq paramatyq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atwp
 * JD-Core Version:    0.7.0.1
 */