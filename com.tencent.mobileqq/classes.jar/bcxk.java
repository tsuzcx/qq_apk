import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

public class bcxk
  implements agif
{
  public View a;
  private bcxn jdField_a_of_type_Bcxn;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public bcxk(bcxh parambcxh, bcxn parambcxn)
  {
    this.jdField_a_of_type_Bcxn = parambcxn;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new bcxl(this));
    }
    b();
    BaseShortVideoOprerator.a(this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcxn);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 101);
    }
    String str = ShortVideoUtils.a(this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    Object localObject = this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ArrayOfJavaLangString, 101, (String)localObject, str);
    long l1 = this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    long l2 = this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
    l2 = ShortVideoUtils.a();
    this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)localObject, l1 * 1000L, l2 * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
    }
    this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
    this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
    this.jdField_a_of_type_Bcxh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
    azvd.a(1000, 100);
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    if (parambete.jdField_b_of_type_Long != this.jdField_a_of_type_Bcxn.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((parambete.jdField_b_of_type_Int != 6) && (parambete.jdField_b_of_type_Int != 17) && (parambete.jdField_b_of_type_Int != 9) && (parambete.jdField_b_of_type_Int != 20)) {
      return;
    }
    switch (parambete.d)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (parambete.c != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = parambete.c;
        this.jdField_a_of_type_JavaLangString = parambete.u;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!bhsr.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          parambete = this.jdField_a_of_type_ArrayOfJavaLangString;
          parambete[paramInt1] = (parambete[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm != null) {
          this.jdField_a_of_type_Bcxn.jdField_a_of_type_Bcxm.a(parambete.d);
        }
        bcxh.a(this.jdField_a_of_type_Bcxh).remove(this);
        return;
      }
      this.jdField_a_of_type_Bcxn.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_Bcxn.jdField_a_of_type_Boolean) {
        bcxh.a(this.jdField_a_of_type_Bcxh, this.jdField_a_of_type_Bcxn);
      }
      break;
    }
    for (;;)
    {
      bcxh.a(this.jdField_a_of_type_Bcxh).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcxk
 * JD-Core Version:    0.7.0.1
 */