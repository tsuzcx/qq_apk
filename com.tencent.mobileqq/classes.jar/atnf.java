import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atnf
  extends atkr
{
  private atfq a;
  
  public atnf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Atfq = new atng(this);
    paramQQAppInterface.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
  }
  
  private atnh a(long paramLong, boolean paramBoolean)
  {
    atks localatks = a(paramLong);
    if (localatks == null) {
      return null;
    }
    if ((localatks instanceof atnh)) {
      return (atnh)localatks;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    a();
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    Object localObject2 = audf.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!FileUtil.fileExistsAndNotEmpty((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = audf.a().d() + a(paramInt, bkwk.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new atnh(paramFileManagerEntity);
    ((atnh)localObject2).jdField_a_of_type_Int = paramInt;
    ((atnh)localObject2).b = i;
    a((atks)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((atnh)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    paramList = a(paramLong, false);
    if ((paramList != null) && (paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (!TextUtils.isEmpty(paramString)) && (atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. is config enable IPv6. domain[" + paramString + "]");
      paramString = new atlc(paramString, paramInt);
      paramList = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
      if ((paramList != null) && (!paramList.a()))
      {
        paramString = new ArrayList();
        paramList = paramList.a.iterator();
        while (paramList.hasNext())
        {
          atld localatld = (atld)paramList.next();
          paramString.add(localatld.jdField_a_of_type_JavaLangString + ":" + localatld.jdField_a_of_type_Int);
        }
        QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv6. hostlist:" + paramString.toString());
        return paramString;
      }
      QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] [IPv6-File] offlineVideo thumb. use IPv4");
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
    atnh localatnh = a(paramLong, false);
    if (localatnh == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localatnh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      auea.d(localatnh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(localatnh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(paramBoolean, 50, new Object[] { localatnh.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localatnh.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramatpg);
  }
  
  public boolean a(long paramLong, atpg paramatpg)
  {
    paramatpg = a(paramLong, false);
    if (paramatpg == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(paramatpg.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramatpg.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, paramLong);
    return true;
  }
  
  public void b(long paramLong, atpg paramatpg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnf
 * JD-Core Version:    0.7.0.1
 */