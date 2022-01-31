import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreLoader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.ArrayList;

public class azdt
  implements aesa
{
  public View a;
  private azdx jdField_a_of_type_Azdx;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public azdt(azdq paramazdq, azdx paramazdx)
  {
    this.jdField_a_of_type_Azdx = paramazdx;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!VideoPlaySDKManager.getInstance().isSDKReady()) {
      VideoPlaySDKManager.getInstance().initSDKAsync(this.jdField_a_of_type_Azdq.a.getApplication(), new azdu(this));
    }
    b();
    BaseShortVideoOprerator.a(this.jdField_a_of_type_Azdq.a, this.jdField_a_of_type_Azdx);
  }
  
  private void b()
  {
    ISPlayerPreLoader localISPlayerPreLoader = SuperPlayerFactory.createPreLoader(BaseApplicationImpl.getContext(), 101);
    String str1 = ShortVideoUtils.a(this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    String str2 = this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localISPlayerPreLoader.startPreDownload(SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ArrayOfJavaLangString, 101, str2, str1), this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime * 1000L, this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize, ShortVideoUtils.a() * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str1);
    }
    this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
    this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
    this.jdField_a_of_type_Azdq.a.a().a(this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
    awoa.a(1000, 100);
  }
  
  public void a(View paramView, bass parambass, int paramInt1, int paramInt2)
  {
    if (parambass.jdField_b_of_type_Long != this.jdField_a_of_type_Azdx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((parambass.jdField_b_of_type_Int != 6) && (parambass.jdField_b_of_type_Int != 17) && (parambass.jdField_b_of_type_Int != 9) && (parambass.jdField_b_of_type_Int != 20)) {
      return;
    }
    switch (parambass.d)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (parambass.c != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = parambass.c;
        this.jdField_a_of_type_JavaLangString = parambass.u;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!bdnn.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          parambass = this.jdField_a_of_type_ArrayOfJavaLangString;
          parambass[paramInt1] = (parambass[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_Azdx.jdField_a_of_type_Azdv != null) {
          this.jdField_a_of_type_Azdx.jdField_a_of_type_Azdv.a(parambass.d);
        }
        azdq.a(this.jdField_a_of_type_Azdq).remove(this);
        return;
      }
      this.jdField_a_of_type_Azdx.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_Azdx.jdField_a_of_type_Boolean) {
        azdq.a(this.jdField_a_of_type_Azdq, this.jdField_a_of_type_Azdx);
      }
      break;
    }
    for (;;)
    {
      azdq.a(this.jdField_a_of_type_Azdq).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdt
 * JD-Core Version:    0.7.0.1
 */