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

public class atoq
  extends aton
{
  public atoq() {}
  
  public atoq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bace.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public atqd a(Intent paramIntent)
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
      atqe localatqe = new atqe();
      localatqe.d((String)localObject);
      localatqe.e(i);
      localatqe.e(str);
      localatqe.d(k);
      localatqe.f(j);
      localatqe.l(n);
      localatqe.k(m);
      localatqe.a(bool);
      localatqe.f(paramIntent.rawMd5);
      localatqe.a(paramIntent.fileSize);
      localObject = localatqe.a();
      ((atqd)localObject).jdField_i_of_type_Boolean = true;
      ((atqd)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(atqd paramatqd)
  {
    long l = System.currentTimeMillis();
    if ((paramatqd != null) && (a(paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = awbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatqd.c, paramatqd.d, paramatqd.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramatqd.jdField_a_of_type_Int;
      localMessageForPic.path = paramatqd.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramatqd.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramatqd.jdField_a_of_type_Atqf != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramatqd.jdField_a_of_type_Atqf.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramatqd.jdField_a_of_type_Atqf.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramatqd.jdField_a_of_type_Atqf.c;
        }
        localMessageForPic.localUUID = paramatqd.jdField_a_of_type_JavaLangString;
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!awqg.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramatqd.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramatqd.e;
        localMessageForPic.thumbHeight = paramatqd.f;
        localMessageForPic.width = paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramatqd.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramatqd.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramatqd.n;
        localMessageForPic.sync2Story = paramatqd.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramatqd.jdField_i_of_type_Boolean;
        str2 = awav.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(awav.s, paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(awav.t, String.valueOf(paramatqd.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramatqd.jdField_a_of_type_Long = localMessageForPic.uniseq;
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramatqd.jdField_b_of_type_Long;
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramatqd.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramatqd.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(atpv paramatpv)
  {
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramatpv.a))
    {
      b(paramatpv);
      return;
    }
    a(3, paramatpv.a.jdField_a_of_type_Atpr);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    axwd.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(atpv paramatpv)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramatpv.a, paramatpv), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoq
 * JD-Core Version:    0.7.0.1
 */