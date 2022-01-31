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

public class avbm
  extends avbi
  implements atqq
{
  public int a;
  public atqr a;
  avbl jdField_a_of_type_Avbl;
  public axrz a;
  axvt jdField_a_of_type_Axvt;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<avbl> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public avbl b;
  protected String b;
  public ArrayList<avbl> b;
  boolean b;
  public avbl c;
  
  public avbm(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static axvt a(MessageForLightVideo paramMessageForLightVideo)
  {
    axvt localaxvt = new axvt();
    localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localaxvt.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localaxvt.c = paramMessageForLightVideo.frienduin;
    localaxvt.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localaxvt.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localaxvt.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localaxvt.j = paramMessageForLightVideo.mThumbFilePath;
    localaxvt.k = paramMessageForLightVideo.thumbMD5;
    localaxvt.jdField_a_of_type_Boolean = true;
    localaxvt.e = paramMessageForLightVideo.busiType;
    return localaxvt;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = awbi.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (apdh.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = avhm.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bace.d(paramBundle, (String)localObject);
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
      Object localObject = (avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((avau)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((avau)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Axrz != null)
      {
        localObject = this.jdField_a_of_type_Axrz.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((axqf)localObject).d);
        }
        if (((axqf)localObject).d == 1007) {
          this.jdField_a_of_type_Axrz.b(false);
        }
      }
    }
  }
  
  public void a(atqr paramatqr) {}
  
  public void a(avbl paramavbl)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, paramavbl));
  }
  
  public void a(avbl paramavbl, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, paramavbl, paramBundle));
  }
  
  public void a(axrz paramaxrz)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, paramaxrz));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Avbl + " mAudioInfo:" + this.jdField_b_of_type_Avbl);
    }
    return (this.jdField_a_of_type_Avbl != null) && (this.jdField_b_of_type_Avbl != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Axrz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Axrz.a();
      this.jdField_a_of_type_Axrz = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(atqr paramatqr)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramatqr));
  }
  
  public void b(avbl paramavbl, Bundle paramBundle)
  {
    this.jdField_a_of_type_Avbl = paramavbl;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    axvt localaxvt = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localaxvt.i = true;; localaxvt.i = false)
    {
      localaxvt.jdField_a_of_type_Atqq = this;
      localaxvt.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Axvt = localaxvt;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
      paramavbl.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      paramavbl.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(paramavbl);
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
    if ((this.jdField_a_of_type_Atqr != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      avbh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avbm
 * JD-Core Version:    0.7.0.1
 */