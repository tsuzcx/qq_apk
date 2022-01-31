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

public class awbh
  extends awbd
  implements auoq
{
  public int a;
  public auor a;
  awbg jdField_a_of_type_Awbg;
  public aysi a;
  aywc jdField_a_of_type_Aywc;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<awbg> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public awbg b;
  protected String b;
  public ArrayList<awbg> b;
  boolean b;
  public awbg c;
  
  public awbh(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static aywc a(MessageForLightVideo paramMessageForLightVideo)
  {
    aywc localaywc = new aywc();
    localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localaywc.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localaywc.c = paramMessageForLightVideo.frienduin;
    localaywc.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localaywc.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localaywc.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localaywc.j = paramMessageForLightVideo.mThumbFilePath;
    localaywc.k = paramMessageForLightVideo.thumbMD5;
    localaywc.jdField_a_of_type_Boolean = true;
    localaywc.e = paramMessageForLightVideo.busiType;
    return localaywc;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = axas.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (apvd.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = awhh.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bbdx.d(paramBundle, (String)localObject);
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
      Object localObject = (awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((awap)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((awap)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Aysi != null)
      {
        localObject = this.jdField_a_of_type_Aysi.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((ayqo)localObject).d);
        }
        if (((ayqo)localObject).d == 1007) {
          this.jdField_a_of_type_Aysi.b(false);
        }
      }
    }
  }
  
  public void a(auor paramauor) {}
  
  public void a(awbg paramawbg)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, paramawbg));
  }
  
  public void a(awbg paramawbg, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, paramawbg, paramBundle));
  }
  
  public void a(aysi paramaysi)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, paramaysi));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Awbg + " mAudioInfo:" + this.jdField_b_of_type_Awbg);
    }
    return (this.jdField_a_of_type_Awbg != null) && (this.jdField_b_of_type_Awbg != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aysi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Aysi.a();
      this.jdField_a_of_type_Aysi = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(auor paramauor)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramauor));
  }
  
  public void b(awbg paramawbg, Bundle paramBundle)
  {
    this.jdField_a_of_type_Awbg = paramawbg;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    aywc localaywc = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localaywc.i = true;; localaywc.i = false)
    {
      localaywc.jdField_a_of_type_Auoq = this;
      localaywc.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Aywc = localaywc;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
      paramawbg.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      paramawbg.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(paramawbg);
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
    if ((this.jdField_a_of_type_Auor != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      awbc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbh
 * JD-Core Version:    0.7.0.1
 */