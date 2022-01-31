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

public class awev
  implements aclm
{
  public View a;
  private awey jdField_a_of_type_Awey;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public awev(awet paramawet, awey paramawey)
  {
    this.jdField_a_of_type_Awey = paramawey;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!awet.a(this.jdField_a_of_type_Awet))
    {
      TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      awet.a(this.jdField_a_of_type_Awet, true);
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      if (awet.a(this.jdField_a_of_type_Awet) == null) {
        awet.a(this.jdField_a_of_type_Awet, TVK_SDKMgr.getProxyFactory());
      }
      if (awet.a(this.jdField_a_of_type_Awet) != null)
      {
        if (awet.a(this.jdField_a_of_type_Awet) == null) {
          awet.a(this.jdField_a_of_type_Awet, awet.a(this.jdField_a_of_type_Awet).getCacheMgr(BaseApplicationImpl.getContext()));
        }
        if (awet.a(this.jdField_a_of_type_Awet) != null)
        {
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          String str = ShortVideoUtils.a(this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
          localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20160518));
          localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(ShortVideoUtils.a()));
          localTVK_PlayerVideoInfo.setVid(this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          awet.a(this.jdField_a_of_type_Awet).preLoadVideoByUrl(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ArrayOfJavaLangString[0], null, localTVK_PlayerVideoInfo);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
          }
          this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
          this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          this.jdField_a_of_type_Awet.a.a().a(this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
          atuf.a(1000, 100);
        }
      }
    }
    for (;;)
    {
      BaseShortVideoOprerator.a(this.jdField_a_of_type_Awet.a, this.jdField_a_of_type_Awey);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video but sdk not installed");
      }
    }
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, " handleMessage what==" + paramInt1 + ", arg1:" + paramInt2);
    }
    if (paramaxqf.jdField_b_of_type_Long != this.jdField_a_of_type_Awey.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((paramaxqf.jdField_b_of_type_Int != 6) && (paramaxqf.jdField_b_of_type_Int != 17) && (paramaxqf.jdField_b_of_type_Int != 9) && (paramaxqf.jdField_b_of_type_Int != 20)) {
      return;
    }
    switch (paramaxqf.d)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramaxqf.c != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramaxqf.c;
        this.jdField_a_of_type_JavaLangString = paramaxqf.u;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!baip.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          paramaxqf = this.jdField_a_of_type_ArrayOfJavaLangString;
          paramaxqf[paramInt1] = (paramaxqf[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_Awey.jdField_a_of_type_Awew != null) {
          this.jdField_a_of_type_Awey.jdField_a_of_type_Awew.a(paramaxqf.d);
        }
        awet.a(this.jdField_a_of_type_Awet).remove(this);
        return;
      }
      this.jdField_a_of_type_Awey.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_Awey.jdField_a_of_type_Boolean) {
        awet.a(this.jdField_a_of_type_Awet, this.jdField_a_of_type_Awey);
      }
      break;
    }
    for (;;)
    {
      awet.a(this.jdField_a_of_type_Awet).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awev
 * JD-Core Version:    0.7.0.1
 */