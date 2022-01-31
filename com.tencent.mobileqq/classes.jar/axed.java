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

public class axed
  implements acwf
{
  public View a;
  private axeg jdField_a_of_type_Axeg;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public axed(axeb paramaxeb, axeg paramaxeg)
  {
    this.jdField_a_of_type_Axeg = paramaxeg;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!axeb.a(this.jdField_a_of_type_Axeb))
    {
      TVK_SDKMgr.initSdk(BaseApplicationImpl.getContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      axeb.a(this.jdField_a_of_type_Axeb, true);
    }
    if (TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext()))
    {
      if (axeb.a(this.jdField_a_of_type_Axeb) == null) {
        axeb.a(this.jdField_a_of_type_Axeb, TVK_SDKMgr.getProxyFactory());
      }
      if (axeb.a(this.jdField_a_of_type_Axeb) != null)
      {
        if (axeb.a(this.jdField_a_of_type_Axeb) == null) {
          axeb.a(this.jdField_a_of_type_Axeb, axeb.a(this.jdField_a_of_type_Axeb).getCacheMgr(BaseApplicationImpl.getContext()));
        }
        if (axeb.a(this.jdField_a_of_type_Axeb) != null)
        {
          TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
          String str = ShortVideoUtils.a(this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          localTVK_PlayerVideoInfo.setConfigMap("file_dir", str);
          localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", String.valueOf(20160518));
          localTVK_PlayerVideoInfo.setConfigMap("cache_duration", String.valueOf(ShortVideoUtils.a()));
          localTVK_PlayerVideoInfo.setVid(this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          axeb.a(this.jdField_a_of_type_Axeb).preLoadVideoByUrl(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ArrayOfJavaLangString[0], null, localTVK_PlayerVideoInfo);
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
          }
          this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
          this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          this.jdField_a_of_type_Axeb.a.a().a(this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
          ausd.a(1000, 100);
        }
      }
    }
    for (;;)
    {
      BaseShortVideoOprerator.a(this.jdField_a_of_type_Axeb.a, this.jdField_a_of_type_Axeg);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video but sdk not installed");
      }
    }
  }
  
  public void a(View paramView, ayqm paramayqm, int paramInt1, int paramInt2)
  {
    if (paramayqm.jdField_b_of_type_Long != this.jdField_a_of_type_Axeg.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((paramayqm.jdField_b_of_type_Int != 6) && (paramayqm.jdField_b_of_type_Int != 17) && (paramayqm.jdField_b_of_type_Int != 9) && (paramayqm.jdField_b_of_type_Int != 20)) {
      return;
    }
    switch (paramayqm.d)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramayqm.c != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramayqm.c;
        this.jdField_a_of_type_JavaLangString = paramayqm.u;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!bbjw.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          paramayqm = this.jdField_a_of_type_ArrayOfJavaLangString;
          paramayqm[paramInt1] = (paramayqm[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_Axeg.jdField_a_of_type_Axee != null) {
          this.jdField_a_of_type_Axeg.jdField_a_of_type_Axee.a(paramayqm.d);
        }
        axeb.a(this.jdField_a_of_type_Axeb).remove(this);
        return;
      }
      this.jdField_a_of_type_Axeg.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_Axeg.jdField_a_of_type_Boolean) {
        axeb.a(this.jdField_a_of_type_Axeb, this.jdField_a_of_type_Axeg);
      }
      break;
    }
    for (;;)
    {
      axeb.a(this.jdField_a_of_type_Axeb).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axed
 * JD-Core Version:    0.7.0.1
 */