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

public class axtg
  extends axtc
  implements awfy
{
  public int a;
  public awfz a;
  axtf jdField_a_of_type_Axtf;
  public baqf a;
  baub jdField_a_of_type_Baub;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public ArrayList<axtf> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public axtf b;
  protected String b;
  public ArrayList<axtf> b;
  boolean b;
  public axtf c;
  
  public axtg(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public static baub a(MessageForLightVideo paramMessageForLightVideo)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForLightVideo;
    localbaub.jdField_b_of_type_JavaLangString = paramMessageForLightVideo.selfuin;
    localbaub.c = paramMessageForLightVideo.frienduin;
    localbaub.jdField_a_of_type_Int = paramMessageForLightVideo.istroop;
    localbaub.jdField_a_of_type_Long = paramMessageForLightVideo.uniseq;
    localbaub.jdField_b_of_type_Int = paramMessageForLightVideo.fileType;
    localbaub.j = paramMessageForLightVideo.mThumbFilePath;
    localbaub.k = paramMessageForLightVideo.thumbMD5;
    localbaub.jdField_a_of_type_Boolean = true;
    localbaub.e = paramMessageForLightVideo.busiType;
    return localbaub;
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = ayvw.a(paramQQAppInterface, paramBundle.jdField_a_of_type_JavaLangString, paramBundle.jdField_b_of_type_JavaLangString, paramBundle.jdField_a_of_type_Int);
    paramBundle = a();
    if (arof.b(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = aycl.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.a(paramQQAppInterface.thumbMD5, "jpg");
      bdcs.d(paramBundle, (String)localObject);
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
      Object localObject = (axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
      ((axso)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((axso)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_Baqf != null)
      {
        localObject = this.jdField_a_of_type_Baqf.a();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((baoj)localObject).d);
        }
        if (((baoj)localObject).d == 1007) {
          this.jdField_a_of_type_Baqf.b(false);
        }
      }
    }
  }
  
  public void a(awfz paramawfz) {}
  
  public void a(axtf paramaxtf)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, paramaxtf));
  }
  
  public void a(axtf paramaxtf, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, paramaxtf, paramBundle));
  }
  
  public void a(baqf parambaqf)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, parambaqf));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Axtf + " mAudioInfo:" + this.jdField_b_of_type_Axtf);
    }
    return (this.jdField_a_of_type_Axtf != null) && (this.jdField_b_of_type_Axtf != null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Baqf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_Baqf.a();
      this.jdField_a_of_type_Baqf = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(awfz paramawfz)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramawfz));
  }
  
  public void b(axtf paramaxtf, Bundle paramBundle)
  {
    this.jdField_a_of_type_Axtf = paramaxtf;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    baub localbaub = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localbaub.i = true;; localbaub.i = false)
    {
      localbaub.jdField_a_of_type_Awfy = this;
      localbaub.jdField_b_of_type_JavaLangObject = this;
      this.jdField_a_of_type_Baub = localbaub;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
      paramaxtf.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      paramaxtf.jdField_a_of_type_Long = paramBundle.thumbFileSize;
      a(paramaxtf);
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
    if ((this.jdField_a_of_type_Awfz != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      axtb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtg
 * JD-Core Version:    0.7.0.1
 */