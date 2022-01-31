import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayzh
  extends ayzf
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private ArrayList<ayzk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ayzh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ayzo paramayzo)
  {
    if ((paramayzo == null) || (paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new ayzi(this, paramayzo));
    }
    c(paramayzo);
  }
  
  private void c(ayzo paramayzo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.a(paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramayzo.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramayzo.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = paramayzo.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramayzo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new ayzj(this, paramayzo));
      if (i <= 0) {
        break label216;
      }
      paramayzo.f = i;
    }
    label216:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
      return;
    }
    QLog.e("ShortVideoPreDownloader", 2, " downFullVideo error preLoadId = " + i);
  }
  
  ayzo a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ayzo localayzo1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localayzo1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localayzo1;
      }
      synchronized (this.b)
      {
        localayzo1 = a(this.b);
        if (localayzo1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localayzo1;
        }
      }
    }
    synchronized (this.c)
    {
      ayzo localayzo2 = a(this.c);
      if (localayzo2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localayzo2;
      }
    }
    synchronized (this.d)
    {
      ayzo localayzo3 = a(this.d);
      if (localayzo3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localayzo3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  ayzo a(List<ayzo> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    ayzo localayzo;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localayzo = (ayzo)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localayzo;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localayzo = (ayzo)localIterator.next();
      if (localayzo.jdField_a_of_type_Ayyx.jdField_a_of_type_Int != 0) {
        paramList.remove(localayzo);
      }
    }
    for (paramList = localayzo;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(aulo paramaulo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramaulo == null) || (paramaulo.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramaulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramaulo.a.jdField_a_of_type_Ayyx.c;
    long l = paramaulo.a.jdField_a_of_type_Ayyx.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof bamr))) {
      ((bamr)localObject).a();
    }
    a(paramaulo.a);
  }
  
  protected void a(ayzo paramayzo)
  {
    super.a(paramayzo);
    if (paramayzo.jdField_a_of_type_Ayyx.jdField_a_of_type_Int == 0)
    {
      aenj localaenj = aenj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaenj != null)
      {
        paramayzo = new ayzk(this, paramayzo);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramayzo);
        localaenj.a(paramayzo.a, paramayzo);
      }
    }
  }
  
  public void b(aulo paramaulo)
  {
    if ((paramaulo == null) || (paramaulo.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramaulo.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bdlq localbdlq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaulo.a.jdField_a_of_type_Ayyx.c, paramaulo.a.jdField_a_of_type_Ayyx.jdField_a_of_type_Long);
      if ((localbdlq instanceof bamr)) {
        ((bamr)localbdlq).a();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramaulo.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramaulo.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzh
 * JD-Core Version:    0.7.0.1
 */