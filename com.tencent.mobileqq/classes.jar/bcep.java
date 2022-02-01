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

public class bcep
  extends bcen
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private ArrayList<bces> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public bcep(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(bcev parambcev)
  {
    if ((parambcev == null) || (parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new bceq(this, parambcev));
    }
    c(parambcev);
  }
  
  private void c(bcev parambcev)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.a(parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((parambcev.jdField_a_of_type_ArrayOfJavaLangString != null) && (parambcev.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = parambcev.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + parambcev.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new bcer(this, parambcev));
      if (i <= 0) {
        break label216;
      }
      parambcev.f = i;
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
  
  bcev a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      bcev localbcev1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localbcev1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localbcev1;
      }
      synchronized (this.b)
      {
        localbcev1 = a(this.b);
        if (localbcev1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localbcev1;
        }
      }
    }
    synchronized (this.c)
    {
      bcev localbcev2 = a(this.c);
      if (localbcev2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localbcev2;
      }
    }
    synchronized (this.d)
    {
      bcev localbcev3 = a(this.d);
      if (localbcev3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localbcev3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  bcev a(List<bcev> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    bcev localbcev;
    if (VideoPlaySDKManager.getInstance().isSDKReady())
    {
      localbcev = (bcev)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localbcev;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localbcev = (bcev)localIterator.next();
      if (localbcev.jdField_a_of_type_Bcef.jdField_a_of_type_Int != 0) {
        paramList.remove(localbcev);
      }
    }
    for (paramList = localbcev;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(awxd paramawxd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramawxd == null) || (paramawxd.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramawxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramawxd.a.jdField_a_of_type_Bcef.c;
    long l = paramawxd.a.jdField_a_of_type_Bcef.jdField_a_of_type_Long;
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof bdsr))) {
      ((bdsr)localObject).a();
    }
    a(paramawxd.a);
  }
  
  protected void a(bcev parambcev)
  {
    super.a(parambcev);
    if (parambcev.jdField_a_of_type_Bcef.jdField_a_of_type_Int == 0)
    {
      afyj localafyj = afyj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localafyj != null)
      {
        parambcev = new bces(this, parambcev);
        this.jdField_a_of_type_JavaUtilArrayList.add(parambcev);
        localafyj.a(parambcev.a, parambcev);
      }
    }
  }
  
  public void b(awxd paramawxd)
  {
    if ((paramawxd == null) || (paramawxd.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramawxd.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      bguz localbguz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramawxd.a.jdField_a_of_type_Bcef.c, paramawxd.a.jdField_a_of_type_Bcef.jdField_a_of_type_Long);
      if ((localbguz instanceof bdsr)) {
        ((bdsr)localbguz).a();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramawxd.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramawxd.a.f);
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
 * Qualified Name:     bcep
 * JD-Core Version:    0.7.0.1
 */