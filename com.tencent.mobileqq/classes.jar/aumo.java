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

public class aumo
  extends auml
{
  public aumo() {}
  
  public aumo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bbdj.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public auob a(Intent paramIntent)
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
      auoc localauoc = new auoc();
      localauoc.d((String)localObject);
      localauoc.e(i);
      localauoc.e(str);
      localauoc.d(k);
      localauoc.f(j);
      localauoc.l(n);
      localauoc.k(m);
      localauoc.a(bool);
      localauoc.f(paramIntent.rawMd5);
      localauoc.a(paramIntent.fileSize);
      localObject = localauoc.a();
      ((auob)localObject).jdField_i_of_type_Boolean = true;
      ((auob)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(auob paramauob)
  {
    long l = System.currentTimeMillis();
    if ((paramauob != null) && (a(paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramauob.c, paramauob.d, paramauob.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramauob.jdField_a_of_type_Int;
      localMessageForPic.path = paramauob.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramauob.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramauob.jdField_a_of_type_Auod != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramauob.jdField_a_of_type_Auod.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramauob.jdField_a_of_type_Auod.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramauob.jdField_a_of_type_Auod.c;
        }
        localMessageForPic.localUUID = paramauob.jdField_a_of_type_JavaLangString;
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!axqf.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramauob.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramauob.e;
        localMessageForPic.thumbHeight = paramauob.f;
        localMessageForPic.width = paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramauob.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramauob.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramauob.n;
        localMessageForPic.sync2Story = paramauob.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramauob.jdField_i_of_type_Boolean;
        str2 = axad.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(axad.s, paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(axad.t, String.valueOf(paramauob.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramauob.jdField_a_of_type_Long = localMessageForPic.uniseq;
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramauob.jdField_b_of_type_Long;
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramauob.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramauob.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(aunt paramaunt)
  {
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramaunt.a))
    {
      b(paramaunt);
      return;
    }
    a(3, paramaunt.a.jdField_a_of_type_Aunp);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    aywk.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(aunt paramaunt)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramaunt.a, paramaunt), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumo
 * JD-Core Version:    0.7.0.1
 */