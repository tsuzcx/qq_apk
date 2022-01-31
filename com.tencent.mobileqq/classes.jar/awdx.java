import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.AioQzonePicOperator.1;
import com.tencent.qphone.base.util.QLog;

public class awdx
  extends awdu
{
  public awdx() {}
  
  public awdx(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bdcs.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = this.b;
        localStringBuilder = new StringBuilder().append("AioQzonePicOperator checkParams:");
        if (paramPhotoSendParams == null) {
          break label92;
        }
      }
      label92:
      for (paramPhotoSendParams = paramPhotoSendParams.toString();; paramPhotoSendParams = "")
      {
        QLog.e(str, 2, paramPhotoSendParams);
        return false;
      }
    }
    return true;
  }
  
  public awfl a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("uin");
      String str = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool = paramIntent.getBooleanExtra("video_sync_to_story", false);
      paramIntent = (PhotoSendParams)paramIntent.getParcelableExtra("PhotoConst.photo_send_qzone_pic_file_params");
      if (!a(paramIntent)) {
        return null;
      }
      awfm localawfm = new awfm();
      localawfm.d((String)localObject);
      localawfm.e(i);
      localawfm.e(str);
      localawfm.d(k);
      localawfm.f(j);
      localawfm.l(n);
      localawfm.k(m);
      localawfm.a(bool);
      localawfm.f(paramIntent.rawMd5);
      localawfm.a(paramIntent.fileSize);
      localObject = localawfm.a();
      ((awfl)localObject).jdField_i_of_type_Boolean = true;
      ((awfl)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(awfl paramawfl)
  {
    long l = System.currentTimeMillis();
    if ((paramawfl != null) && (a(paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawfl.c, paramawfl.d, paramawfl.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramawfl.jdField_a_of_type_Int;
      localMessageForPic.path = paramawfl.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramawfl.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramawfl.jdField_a_of_type_Awfn != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramawfl.jdField_a_of_type_Awfn.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramawfl.jdField_a_of_type_Awfn.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramawfl.jdField_a_of_type_Awfn.c;
        }
        localMessageForPic.localUUID = paramawfl.jdField_a_of_type_JavaLangString;
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!azls.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramawfl.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramawfl.e;
        localMessageForPic.thumbHeight = paramawfl.f;
        localMessageForPic.width = paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramawfl.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramawfl.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramawfl.n;
        localMessageForPic.sync2Story = paramawfl.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramawfl.jdField_i_of_type_Boolean;
        str2 = ayvj.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(ayvj.s, paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(ayvj.t, String.valueOf(paramawfl.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramawfl.jdField_a_of_type_Long = localMessageForPic.uniseq;
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramawfl.jdField_b_of_type_Long;
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramawfl.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramawfl.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(awfc paramawfc)
  {
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramawfc.a))
    {
      b(paramawfc);
      return;
    }
    a(3, paramawfc.a.jdField_a_of_type_Awey);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    baul.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(awfc paramawfc)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramawfc.a, paramawfc), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdx
 * JD-Core Version:    0.7.0.1
 */