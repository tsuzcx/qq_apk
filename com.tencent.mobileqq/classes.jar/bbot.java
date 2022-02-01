import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.segment.VideoSend.1;
import com.tencent.mobileqq.richmedia.segment.VideoSend.2;
import com.tencent.mobileqq.richmedia.segment.VideoSend.3;
import com.tencent.mobileqq.richmedia.segment.VideoSend.4;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class bbot
  extends bbop
  implements azla
{
  public int a;
  public azlb a;
  bbos jdField_a_of_type_Bbos;
  public QQAppInterface a;
  public MessageForLightVideo a;
  public LightVideoUploadProcessor a;
  TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  public ArrayList<bbos> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getSubThreadLooper());
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public long b;
  public bbos b;
  protected String b;
  public ArrayList<bbos> b;
  boolean b;
  public bbos c;
  
  public bbot(long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  private MessageForLightVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = bcsa.a(paramQQAppInterface, paramBundle.curFriendUin, paramBundle.troopUin, paramBundle.curType);
    paramBundle = a();
    if (FileUtil.fileExistsAndNotEmpty(paramBundle))
    {
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramBundle);
      paramQQAppInterface.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      paramQQAppInterface.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      paramQQAppInterface.thumbMD5 = bbyf.a(paramBundle);
      paramQQAppInterface.thumbFileSize = ((int)new File(paramBundle).length());
      localObject = ShortVideoUtils.getShortVideoThumbPicPath(paramQQAppInterface.thumbMD5, "jpg");
      FileUtils.copyFile(paramBundle, (String)localObject);
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
  
  public static TransferRequest a(MessageForLightVideo paramMessageForLightVideo)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mRec = paramMessageForLightVideo;
    localTransferRequest.mSelfUin = paramMessageForLightVideo.selfuin;
    localTransferRequest.mPeerUin = paramMessageForLightVideo.frienduin;
    localTransferRequest.mUinType = paramMessageForLightVideo.istroop;
    localTransferRequest.mUniseq = paramMessageForLightVideo.uniseq;
    localTransferRequest.mFileType = paramMessageForLightVideo.fileType;
    localTransferRequest.mThumbPath = paramMessageForLightVideo.mThumbFilePath;
    localTransferRequest.mThumbMd5 = paramMessageForLightVideo.thumbMD5;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mBusiType = paramMessageForLightVideo.busiType;
    return localTransferRequest;
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
      Object localObject = (bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
      ((bbob)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq);
      ((bbob)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, null);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor.getFileMsg();
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "check processor status:" + ((FileMsg)localObject).status);
        }
        if (((FileMsg)localObject).status == 1007) {
          this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor.sendMsg(false);
        }
      }
    }
  }
  
  public void a(bbos parambbos)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.2(this, parambbos));
  }
  
  public void a(bbos parambbos, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.1(this, parambbos, paramBundle));
  }
  
  public void a(LightVideoUploadProcessor paramLightVideoUploadProcessor)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.3(this, paramLightVideoUploadProcessor));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkAllSliceDone, mThumbInfo:" + this.jdField_a_of_type_Bbos + " mAudioInfo:" + this.jdField_b_of_type_Bbos);
    }
    return (this.jdField_a_of_type_Bbos != null) && (this.jdField_b_of_type_Bbos != null);
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "cancelTask");
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor.cancel();
      this.jdField_a_of_type_ComTencentMobileqqTransfileLightVideoUploadProcessor = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void b(bbos parambbos, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bbos = parambbos;
    paramBundle = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
    paramBundle.uniseq = Long.parseLong(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = paramBundle;
    TransferRequest localTransferRequest = a(paramBundle);
    if (this.jdField_a_of_type_Int == 1) {}
    for (localTransferRequest.mIsPresend = true;; localTransferRequest.mIsPresend = false)
    {
      localTransferRequest.mUpCallBack = this;
      localTransferRequest.extraObject = this;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = localTransferRequest;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      parambbos.jdField_b_of_type_JavaLangString = paramBundle.thumbMD5;
      parambbos.a = paramBundle.thumbFileSize;
      a(parambbos);
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
    if ((this.jdField_a_of_type_Azlb != null) && (this.c != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "destroy");
      }
      bboo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onSend(azlb paramazlb)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new VideoSend.4(this, paramazlb));
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbot
 * JD-Core Version:    0.7.0.1
 */