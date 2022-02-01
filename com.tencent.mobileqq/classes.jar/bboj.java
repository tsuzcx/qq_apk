import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richmedia.segment.VideoSend.1;
import com.tencent.mobileqq.richmedia.segment.VideoSend.2;
import com.tencent.mobileqq.richmedia.segment.VideoSend.3;
import com.tencent.mobileqq.richmedia.segment.VideoSend.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class bboj
  extends bbof
  implements azrg
{
  public int a;
  public azrh a;
  bboi jdField_a_of_type_Bboi;
  public beuw a;
  beyg jdField_a_of_type_Beyg;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<bboi> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public bboi b;
  protected String b;
  public ArrayList<bboi> b;
  boolean b;
  public bboi c;
  
  public bboj(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static beyg a(MessageForLightVideo paramMessageForLightVideo)
  {
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localbeyg.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localbeyg.c = paramMessageForLightVideo.frienduin;
    localbeyg.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localbeyg.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localbeyg.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localbeyg.jdField_j_of_type_JavaLangString = paramMessageForLightVideo.mThumbFilePath;
    localbeyg.k = paramMessageForLightVideo.thumbMD5;
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.e = paramMessageForLightVideo.busiType;
    return localbeyg;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = bcry.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (auog.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = bbxv.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bhmi.d(paramBundle, (String)localObject);
      paramQQAppInterface.mThumbFilePath = ((String)localObject);
    }
    paramQQAppInterface.lastModified = 0L;
    paramQQAppInterface.fileSource = "camera";
    paramQQAppInterface.extraflag = 32772;
    paramQQAppInterface.videoFileStatus = 999;
    paramQQAppInterface.videoFileFormat = 2;
    paramQQAppInterface.videoFileProgress = 0;
    paramQQAppInterface.busiType = 1;
    paramQQAppInterface.fileType = 327689;
    paramQQAppInterface.fromChatType = -1;
    paramQQAppInterface.toChatType = -1;
    paramQQAppInterface.uiOperatorFlag = 1;
    paramQQAppInterface.mPreUpload = true;
    paramQQAppInterface.serial();
    return paramQQAppInterface;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo != null) && (!this.jdField_b_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "addMsg");
      }
      this.jdField_b_of_type_Boolean = true;
      Object localObject = (bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((bbnr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((bbnr)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Beuw != null)
      {
        localObject = this.jdField_a_of_type_Beuw.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((bete)localObject).d);
        }
        if (((bete)localObject).d == 1007) {
          this.jdField_a_of_type_Beuw.b(false);
        }
      }
    }
  }
  
  public void a(azrh paramazrh) {}
  
  public void a(bboi parambboi)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, parambboi));
  }
  
  public void a(bboi parambboi, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, parambboi, paramBundle));
  }
  
  public void a(beuw parambeuw)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, parambeuw));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Bboi + " mAudioInfo:" + this.jdField_b_of_type_Bboi);
    }
    return (this.jdField_a_of_type_Bboi != null) && (this.jdField_b_of_type_Bboi != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Beuw != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Beuw.a();
      this.jdField_a_of_type_Beuw = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(azrh paramazrh)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramazrh));
  }
  
  public void b(bboi parambboi, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bboi = parambboi;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    beyg localbeyg = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localbeyg.jdField_j_of_type_Boolean = true;; localbeyg.jdField_j_of_type_Boolean = false)
    {
      localbeyg.jdField_a_of_type_Azrg = this;
      localbeyg.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Beyg = localbeyg;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
      parambboi.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      parambboi.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(parambboi);
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Azrh != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      bboe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboj
 * JD-Core Version:    0.7.0.1
 */