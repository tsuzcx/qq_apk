import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcxl
  extends bcxj
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private ArrayList<bcxo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcxl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bcxr parambcxr)
  {
    if ((parambcxr == null) || (parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!bapt.a()) {
      bapt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new bcxm(this, parambcxr));
    }
    c(parambcxr);
  }
  
  private void c(bcxr parambcxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.getShortVideoSavePath(parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((parambcxr.jdField_a_of_type_ArrayOfJavaLangString != null) && (parambcxr.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = parambcxr.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + parambcxr.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new bcxn(this, parambcxr));
      if (i <= 0) {
        break label216;
      }
      parambcxr.f = i;
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
  
  bcxr a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bcxr localbcxr1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localbcxr1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localbcxr1;
      }
      synchronized (this.b)
      {
        localbcxr1 = a(this.b);
        if (localbcxr1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localbcxr1;
        }
      }
    }
    synchronized (this.c)
    {
      bcxr localbcxr2 = a(this.c);
      if (localbcxr2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localbcxr2;
      }
    }
    synchronized (this.d)
    {
      bcxr localbcxr3 = a(this.d);
      if (localbcxr3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localbcxr3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  bcxr a(List<bcxr> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    bcxr localbcxr;
    if (bapt.a())
    {
      localbcxr = (bcxr)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localbcxr;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localbcxr = (bcxr)localIterator.next();
      if (localbcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_Int != 0) {
        paramList.remove(localbcxr);
      }
    }
    for (paramList = localbcxr;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(axjf paramaxjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramaxjf == null) || (paramaxjf.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramaxjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramaxjf.a.jdField_a_of_type_Bcxb.c;
    long l = paramaxjf.a.jdField_a_of_type_Bcxb.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    a(paramaxjf.a);
  }
  
  protected void a(bcxr parambcxr)
  {
    super.a(parambcxr);
    if (parambcxr.jdField_a_of_type_Bcxb.jdField_a_of_type_Int == 0)
    {
      afsl localafsl = afsl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localafsl != null)
      {
        parambcxr = new bcxo(this, parambcxr);
        this.jdField_a_of_type_JavaUtilArrayList.add(parambcxr);
        localafsl.a(parambcxr.a, parambcxr);
      }
    }
  }
  
  public void b(axjf paramaxjf)
  {
    if ((paramaxjf == null) || (paramaxjf.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramaxjf.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      IHttpCommunicatorListener localIHttpCommunicatorListener = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().findProcessor(paramaxjf.a.jdField_a_of_type_Bcxb.c, paramaxjf.a.jdField_a_of_type_Bcxb.jdField_a_of_type_Long);
      if ((localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramaxjf.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramaxjf.a.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopAllPreDownload();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxl
 * JD-Core Version:    0.7.0.1
 */