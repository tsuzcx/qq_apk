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

public class aumq
  extends aumn
{
  public aumq() {}
  
  public aumq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bbdx.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public auod a(Intent paramIntent)
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
      auoe localauoe = new auoe();
      localauoe.d((String)localObject);
      localauoe.e(i);
      localauoe.e(str);
      localauoe.d(k);
      localauoe.f(j);
      localauoe.l(n);
      localauoe.k(m);
      localauoe.a(bool);
      localauoe.f(paramIntent.rawMd5);
      localauoe.a(paramIntent.fileSize);
      localObject = localauoe.a();
      ((auod)localObject).jdField_i_of_type_Boolean = true;
      ((auod)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(auod paramauod)
  {
    long l = System.currentTimeMillis();
    if ((paramauod != null) && (a(paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramauod.c, paramauod.d, paramauod.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramauod.jdField_a_of_type_Int;
      localMessageForPic.path = paramauod.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramauod.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramauod.jdField_a_of_type_Auof != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramauod.jdField_a_of_type_Auof.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramauod.jdField_a_of_type_Auof.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramauod.jdField_a_of_type_Auof.c;
        }
        localMessageForPic.localUUID = paramauod.jdField_a_of_type_JavaLangString;
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!axqh.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramauod.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramauod.e;
        localMessageForPic.thumbHeight = paramauod.f;
        localMessageForPic.width = paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramauod.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramauod.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramauod.n;
        localMessageForPic.sync2Story = paramauod.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramauod.jdField_i_of_type_Boolean;
        str2 = axaf.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(axaf.s, paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(axaf.t, String.valueOf(paramauod.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramauod.jdField_a_of_type_Long = localMessageForPic.uniseq;
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramauod.jdField_b_of_type_Long;
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramauod.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramauod.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(aunv paramaunv)
  {
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramaunv.a))
    {
      b(paramaunv);
      return;
    }
    a(3, paramaunv.a.jdField_a_of_type_Aunr);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    aywm.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(aunv paramaunv)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramaunv.a, paramaunv), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumq
 * JD-Core Version:    0.7.0.1
 */