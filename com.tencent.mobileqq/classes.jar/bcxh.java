import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcxh
  extends bcxf
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private ArrayList<bcxk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcxh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bcxn parambcxn)
  {
    if ((parambcxn == null) || (parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new bcxi(this, parambcxn));
    }
    c(parambcxn);
  }
  
  private void c(bcxn parambcxn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.a(parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((parambcxn.jdField_a_of_type_ArrayOfJavaLangString != null) && (parambcxn.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = parambcxn.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + parambcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new bcxj(this, parambcxn));
      if (i <= 0) {
        break label216;
      }
      parambcxn.f = i;
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
  
  bcxn a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bcxn localbcxn1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localbcxn1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localbcxn1;
      }
      synchronized (this.b)
      {
        localbcxn1 = a(this.b);
        if (localbcxn1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localbcxn1;
        }
      }
    }
    synchronized (this.c)
    {
      bcxn localbcxn2 = a(this.c);
      if (localbcxn2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localbcxn2;
      }
    }
    synchronized (this.d)
    {
      bcxn localbcxn3 = a(this.d);
      if (localbcxn3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localbcxn3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  bcxn a(List<bcxn> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    bcxn localbcxn;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localbcxn = (bcxn)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localbcxn;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localbcxn = (bcxn)localIterator.next();
      if (localbcxn.jdField_a_of_type_Bcwx.jdField_a_of_type_Int != 0) {
        paramList.remove(localbcxn);
      }
    }
    for (paramList = localbcxn;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(axpw paramaxpw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramaxpw == null) || (paramaxpw.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramaxpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramaxpw.a.jdField_a_of_type_Bcwx.c;
    long l = paramaxpw.a.jdField_a_of_type_Bcwx.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof berj))) {
      ((berj)localObject).a();
    }
    a(paramaxpw.a);
  }
  
  protected void a(bcxn parambcxn)
  {
    super.a(parambcxn);
    if (parambcxn.jdField_a_of_type_Bcwx.jdField_a_of_type_Int == 0)
    {
      agid localagid = agid.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localagid != null)
      {
        parambcxn = new bcxk(this, parambcxn);
        this.jdField_a_of_type_JavaUtilArrayList.add(parambcxn);
        localagid.a(parambcxn.a, parambcxn);
      }
    }
  }
  
  public void b(axpw paramaxpw)
  {
    if ((paramaxpw == null) || (paramaxpw.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramaxpw.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bhvc localbhvc = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramaxpw.a.jdField_a_of_type_Bcwx.c, paramaxpw.a.jdField_a_of_type_Bcwx.jdField_a_of_type_Long);
      if ((localbhvc instanceof berj)) {
        ((berj)localbhvc).a();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramaxpw.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramaxpw.a.f);
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
 * Qualified Name:     bcxh
 * JD-Core Version:    0.7.0.1
 */