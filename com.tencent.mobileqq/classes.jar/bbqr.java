import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bbqr
  extends bbqp
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private ArrayList<bbqu> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bbqr(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bbqx parambbqx)
  {
    if ((parambbqx == null) || (parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new bbqs(this, parambbqx));
    }
    c(parambbqx);
  }
  
  private void c(bbqx parambbqx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.getShortVideoSavePath(parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((parambbqx.jdField_a_of_type_ArrayOfJavaLangString != null) && (parambbqx.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = parambbqx.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + parambbqx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new bbqt(this, parambbqx));
      if (i <= 0) {
        break label216;
      }
      parambbqx.f = i;
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
  
  bbqx a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bbqx localbbqx1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localbbqx1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localbbqx1;
      }
      synchronized (this.b)
      {
        localbbqx1 = a(this.b);
        if (localbbqx1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localbbqx1;
        }
      }
    }
    synchronized (this.c)
    {
      bbqx localbbqx2 = a(this.c);
      if (localbbqx2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localbbqx2;
      }
    }
    synchronized (this.d)
    {
      bbqx localbbqx3 = a(this.d);
      if (localbbqx3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localbbqx3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  bbqx a(List<bbqx> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    bbqx localbbqx;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localbbqx = (bbqx)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localbbqx;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localbbqx = (bbqx)localIterator.next();
      if (localbbqx.jdField_a_of_type_Bbqh.jdField_a_of_type_Int != 0) {
        paramList.remove(localbbqx);
      }
    }
    for (paramList = localbbqx;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(awdd paramawdd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramawdd == null) || (paramawdd.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramawdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramawdd.a.jdField_a_of_type_Bbqh.c;
    long l = paramawdd.a.jdField_a_of_type_Bbqh.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    a(paramawdd.a);
  }
  
  protected void a(bbqx parambbqx)
  {
    super.a(parambbqx);
    if (parambbqx.jdField_a_of_type_Bbqh.jdField_a_of_type_Int == 0)
    {
      afaz localafaz = afaz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localafaz != null)
      {
        parambbqx = new bbqu(this, parambbqx);
        this.jdField_a_of_type_JavaUtilArrayList.add(parambbqx);
        localafaz.a(parambbqx.a, parambbqx);
      }
    }
  }
  
  public void b(awdd paramawdd)
  {
    if ((paramawdd == null) || (paramawdd.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramawdd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramawdd.a.jdField_a_of_type_Bbqh.c, paramawdd.a.jdField_a_of_type_Bbqh.jdField_a_of_type_Long);
      if ((localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramawdd.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramawdd.a.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbqr
 * JD-Core Version:    0.7.0.1
 */