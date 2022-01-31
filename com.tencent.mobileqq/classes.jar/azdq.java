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

public class azdq
  extends azdo
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private ArrayList<azdt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public azdq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(azdx paramazdx)
  {
    if ((paramazdx == null) || (paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new azdr(this, paramazdx));
    }
    c(paramazdx);
  }
  
  private void c(azdx paramazdx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.a(paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramazdx.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramazdx.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = paramazdx.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramazdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new azds(this, paramazdx));
      if (i <= 0) {
        break label216;
      }
      paramazdx.f = i;
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
  
  azdx a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      azdx localazdx1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localazdx1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localazdx1;
      }
      synchronized (this.b)
      {
        localazdx1 = a(this.b);
        if (localazdx1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localazdx1;
        }
      }
    }
    synchronized (this.c)
    {
      azdx localazdx2 = a(this.c);
      if (localazdx2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localazdx2;
      }
    }
    synchronized (this.d)
    {
      azdx localazdx3 = a(this.d);
      if (localazdx3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localazdx3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  azdx a(List<azdx> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    azdx localazdx;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localazdx = (azdx)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localazdx;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localazdx = (azdx)localIterator.next();
      if (localazdx.jdField_a_of_type_Azdg.jdField_a_of_type_Int != 0) {
        paramList.remove(localazdx);
      }
    }
    for (paramList = localazdx;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(aupx paramaupx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramaupx == null) || (paramaupx.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramaupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramaupx.a.jdField_a_of_type_Azdg.c;
    long l = paramaupx.a.jdField_a_of_type_Azdg.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof bara))) {
      ((bara)localObject).a();
    }
    a(paramaupx.a);
  }
  
  protected void a(azdx paramazdx)
  {
    super.a(paramazdx);
    if (paramazdx.jdField_a_of_type_Azdg.jdField_a_of_type_Int == 0)
    {
      aery localaery = aery.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localaery != null)
      {
        paramazdx = new azdt(this, paramazdx);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramazdx);
        localaery.a(paramazdx.a, paramazdx);
      }
    }
  }
  
  public void b(aupx paramaupx)
  {
    if ((paramaupx == null) || (paramaupx.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramaupx.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bdpz localbdpz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaupx.a.jdField_a_of_type_Azdg.c, paramaupx.a.jdField_a_of_type_Azdg.jdField_a_of_type_Long);
      if ((localbdpz instanceof bara)) {
        ((bara)localbdpz).a();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramaupx.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramaupx.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdq
 * JD-Core Version:    0.7.0.1
 */