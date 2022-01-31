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

public class axxp
  extends axxl
  implements awkh
{
  public int a;
  public awki a;
  axxo jdField_a_of_type_Axxo;
  public bauo a;
  bayk jdField_a_of_type_Bayk;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<axxo> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public axxo b;
  protected String b;
  public ArrayList<axxo> b;
  boolean b;
  public axxo c;
  
  public axxp(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static bayk a(MessageForLightVideo paramMessageForLightVideo)
  {
    bayk localbayk = new bayk();
    localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localbayk.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localbayk.c = paramMessageForLightVideo.frienduin;
    localbayk.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localbayk.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localbayk.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localbayk.j = paramMessageForLightVideo.mThumbFilePath;
    localbayk.k = paramMessageForLightVideo.thumbMD5;
    localbayk.jdField_a_of_type_Boolean = true;
    localbayk.e = paramMessageForLightVideo.busiType;
    return localbayk;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = azaf.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (arso.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = aygu.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bdhb.d(paramBundle, (String)localObject);
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
      Object localObject = (axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((axwx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((axwx)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Bauo != null)
      {
        localObject = this.jdField_a_of_type_Bauo.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((bass)localObject).d);
        }
        if (((bass)localObject).d == 1007) {
          this.jdField_a_of_type_Bauo.b(false);
        }
      }
    }
  }
  
  public void a(awki paramawki) {}
  
  public void a(axxo paramaxxo)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, paramaxxo));
  }
  
  public void a(axxo paramaxxo, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, paramaxxo, paramBundle));
  }
  
  public void a(bauo parambauo)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, parambauo));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Axxo + " mAudioInfo:" + this.jdField_b_of_type_Axxo);
    }
    return (this.jdField_a_of_type_Axxo != null) && (this.jdField_b_of_type_Axxo != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bauo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Bauo.a();
      this.jdField_a_of_type_Bauo = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(awki paramawki)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramawki));
  }
  
  public void b(axxo paramaxxo, Bundle paramBundle)
  {
    this.jdField_a_of_type_Axxo = paramaxxo;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    bayk localbayk = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localbayk.i = true;; localbayk.i = false)
    {
      localbayk.jdField_a_of_type_Awkh = this;
      localbayk.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Bayk = localbayk;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
      paramaxxo.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      paramaxxo.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(paramaxxo);
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
    if ((this.jdField_a_of_type_Awki != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      axxk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxp
 * JD-Core Version:    0.7.0.1
 */