import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class aqwb
  implements arai
{
  protected QQAppInterface a;
  protected LinkedHashMap<Long, aqwc> a;
  
  public aqwb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected int a(String paramString)
  {
    paramString = arso.a(paramString);
    if (".mp4".equalsIgnoreCase(paramString)) {
      return 17;
    }
    if (".rmvb".equalsIgnoreCase(paramString)) {
      return 18;
    }
    if (".avi".equalsIgnoreCase(paramString)) {
      return 19;
    }
    if (".wmv".equalsIgnoreCase(paramString)) {
      return 20;
    }
    if (".flv".equalsIgnoreCase(paramString)) {
      return 21;
    }
    if (".3gp".equalsIgnoreCase(paramString)) {
      return 22;
    }
    if (".mkv".equalsIgnoreCase(paramString)) {
      return 23;
    }
    if (".asf".equalsIgnoreCase(paramString)) {
      return 26;
    }
    if (".vob".equalsIgnoreCase(paramString)) {
      return 27;
    }
    if (".m4v".equalsIgnoreCase(paramString)) {
      return 28;
    }
    if (".f4v".equalsIgnoreCase(paramString)) {
      return 29;
    }
    if (".mov".equalsIgnoreCase(paramString)) {
      return 30;
    }
    if (".mpeg".equalsIgnoreCase(paramString)) {
      return 31;
    }
    if (".mpg".equalsIgnoreCase(paramString)) {
      return 32;
    }
    if (".rm".equalsIgnoreCase(paramString)) {
      return 33;
    }
    if (".webm".equalsIgnoreCase(paramString)) {
      return 34;
    }
    return -1;
  }
  
  protected final aqwc a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call getSession ID[" + l + "] in mMap DowloadSession");
        }
      }
    }
    aqwc localaqwc = (aqwc)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Long.valueOf(paramLong));
    return localaqwc;
  }
  
  protected String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "64*64";
    case 0: 
      return "16*16";
    case 1: 
      return "32*32";
    case 2: 
      return "64*64";
    case 3: 
      return "128*128";
    case 4: 
      return "320*320";
    case 5: 
      return "384*384";
    case 6: 
      return "640*640";
    case 7: 
      return "750*750";
    }
    return "1024*1024";
  }
  
  protected String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    default: 
      str = "x-video-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-video-";
      continue;
      str = "minni-video-";
      continue;
      str = "small-video-";
      continue;
      str = "middle-video-";
      continue;
      str = "large-video-";
      continue;
      str = "xlarge-video-";
      continue;
      str = "screen-video-";
    }
  }
  
  protected void a()
  {
    File localFile = new File(arqx.a().d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  protected final void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] removeSession");
      if (QLog.isDevelopLevel())
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call removeSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(long paramLong, int paramInt, arah paramarah) {}
  
  public void a(long paramLong, arah paramarah) {}
  
  public void a(long paramLong, bdpx parambdpx) {}
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, arah paramarah)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted suc:" + paramBoolean + " retCode[" + paramInt + "] thumbPath:" + paramString);
    a(paramLong);
  }
  
  protected final void a(long paramLong, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, boolean paramBoolean2, String paramString5, short paramShort, String paramString6)
  {
    QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrlResult suc:" + paramBoolean1 + " strDomain:" + paramString1 + " port:" + paramInt + " urlParam:" + paramString2 + " cookie:" + paramString4);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramLong, paramBoolean1, paramString1, paramInt, paramString2, paramString3, paramString4, paramBoolean2, paramString5, paramShort, paramString6);
  }
  
  protected final void a(aqwc paramaqwc)
  {
    if (paramaqwc == null)
    {
      QLog.e("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb] addSession = null");
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilLinkedHashMap)
    {
      QLog.i("BaseThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramaqwc.jdField_a_of_type_Long + "] addSession");
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Long.valueOf(paramaqwc.jdField_a_of_type_Long), paramaqwc);
      if (QLog.isDevelopLevel())
      {
        paramaqwc = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (paramaqwc.hasNext())
        {
          long l = ((Long)paramaqwc.next()).longValue();
          QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] call addSession ID[" + l + "] in mMapDowloadSession");
        }
      }
    }
  }
  
  protected void a(aqwc paramaqwc, String paramString)
  {
    if ((paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext != null) && ((paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext instanceof String)) && ("igonFlow".equalsIgnoreCase((String)paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext))) {
      paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mContext = null;
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!arbp.a()) && (arrr.a()))
      {
        QLog.i("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] size(wh)[" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "]autoDownload Thumb switch is off!");
        return;
      }
      long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, this);
      if (l == -1L)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] size(wh)[" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth + ":" + paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight + "] thumb is Downloading,waiting please!");
        return;
      }
      paramString = paramaqwc.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      i = paramString.mThumbRetryCount;
      paramString.mThumbRetryCount = (i + 1);
      if (i > 10)
      {
        QLog.w("BaseThumbDownloader<FileAssistant>", 1, "thumb retry over 10 count, igon!");
        return;
      }
      paramaqwc.jdField_a_of_type_Long = l;
      a(paramaqwc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
      return;
    }
  }
  
  public boolean a(long paramLong, arah paramarah)
  {
    return false;
  }
  
  public void b(long paramLong, arah paramarah) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqwb
 * JD-Core Version:    0.7.0.1
 */