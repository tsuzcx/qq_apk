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

public class bavq
  extends bavm
  implements ayyt
{
  public int a;
  public ayyu a;
  bavp jdField_a_of_type_Bavp;
  public bdwd a;
  bdzn jdField_a_of_type_Bdzn;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<bavp> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public bavp b;
  protected String b;
  public ArrayList<bavp> b;
  boolean b;
  public bavp c;
  
  public bavq(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static bdzn a(MessageForLightVideo paramMessageForLightVideo)
  {
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localbdzn.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localbdzn.c = paramMessageForLightVideo.frienduin;
    localbdzn.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localbdzn.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localbdzn.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localbdzn.j = paramMessageForLightVideo.mThumbFilePath;
    localbdzn.k = paramMessageForLightVideo.thumbMD5;
    localbdzn.jdField_a_of_type_Boolean = true;
    localbdzn.e = paramMessageForLightVideo.busiType;
    return localbdzn;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = bbzh.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (atwl.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = bbfc.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bgmg.d(paramBundle, (String)localObject);
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
      Object localObject = (bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((bauy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((bauy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Bdwd != null)
      {
        localObject = this.jdField_a_of_type_Bdwd.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((bduk)localObject).d);
        }
        if (((bduk)localObject).d == 1007) {
          this.jdField_a_of_type_Bdwd.b(false);
        }
      }
    }
  }
  
  public void a(ayyu paramayyu) {}
  
  public void a(bavp parambavp)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, parambavp));
  }
  
  public void a(bavp parambavp, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, parambavp, paramBundle));
  }
  
  public void a(bdwd parambdwd)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, parambdwd));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Bavp + " mAudioInfo:" + this.jdField_b_of_type_Bavp);
    }
    return (this.jdField_a_of_type_Bavp != null) && (this.jdField_b_of_type_Bavp != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bdwd != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Bdwd.a();
      this.jdField_a_of_type_Bdwd = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(ayyu paramayyu)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramayyu));
  }
  
  public void b(bavp parambavp, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bavp = parambavp;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    bdzn localbdzn = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localbdzn.i = true;; localbdzn.i = false)
    {
      localbdzn.jdField_a_of_type_Ayyt = this;
      localbdzn.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Bdzn = localbdzn;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
      parambavp.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      parambavp.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(parambavp);
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
    if ((this.jdField_a_of_type_Ayyu != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      bavl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavq
 * JD-Core Version:    0.7.0.1
 */