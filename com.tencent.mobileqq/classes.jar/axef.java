import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.ArrayList;

public class axef
  implements acwb
{
  public View a;
  private axei jdField_a_of_type_Axei;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public axef(axed paramaxed, axei paramaxei)
  {
    this.jdField_a_of_type_Axei = paramaxei;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!axed.a(this.jdField_a_of_type_Axed))
    {
      TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      axed.a(this.jdField_a_of_type_Axed, true);
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      if (axed.a(this.jdField_a_of_type_Axed) == null) {
        axed.a(this.jdField_a_of_type_Axed, TVK_SDKMgr.getProxyFactory());
      }
      if (axed.a(this.jdField_a_of_type_Axed) != null)
      {
        if (axed.a(this.jdField_a_of_type_Axed) == null) {
          axed.a(this.jdField_a_of_type_Axed, axed.a(this.jdField_a_of_type_Axed).getCacheMgr(BaseApplicationImpl.getContext()));
        }
        if (axed.a(this.jdField_a_of_type_Axed) != null)
        {
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          String str = ShortVideoUtils.a(this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
          localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20160518));
          localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(ShortVideoUtils.a()));
          localTVK_PlayerVideoInfo.setVid(this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          axed.a(this.jdField_a_of_type_Axed).preLoadVideoByUrl(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ArrayOfJavaLangString[0], null, localTVK_PlayerVideoInfo);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
          }
          this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
          this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          this.jdField_a_of_type_Axed.a.a().a(this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
          ausf.a(1000, 100);
        }
      }
    }
    for (;;)
    {
      BaseShortVideoOprerator.a(this.jdField_a_of_type_Axed.a, this.jdField_a_of_type_Axei);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video but sdk not installed");
      }
    }
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    if (paramayqo.jdField_b_of_type_Long != this.jdField_a_of_type_Axei.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((paramayqo.jdField_b_of_type_Int != 6) && (paramayqo.jdField_b_of_type_Int != 17) && (paramayqo.jdField_b_of_type_Int != 9) && (paramayqo.jdField_b_of_type_Int != 20)) {
      return;
    }
    switch (paramayqo.d)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramayqo.c != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramayqo.c;
        this.jdField_a_of_type_JavaLangString = paramayqo.u;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!bbkk.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          paramayqo = this.jdField_a_of_type_ArrayOfJavaLangString;
          paramayqo[paramInt1] = (paramayqo[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_Axei.jdField_a_of_type_Axeg != null) {
          this.jdField_a_of_type_Axei.jdField_a_of_type_Axeg.a(paramayqo.d);
        }
        axed.a(this.jdField_a_of_type_Axed).remove(this);
        return;
      }
      this.jdField_a_of_type_Axei.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_Axei.jdField_a_of_type_Boolean) {
        axed.a(this.jdField_a_of_type_Axed, this.jdField_a_of_type_Axei);
      }
      break;
    }
    for (;;)
    {
      axed.a(this.jdField_a_of_type_Axed).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axef
 * JD-Core Version:    0.7.0.1
 */