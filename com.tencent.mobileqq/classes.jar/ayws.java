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

public class ayws
  extends aywp
{
  public ayws() {}
  
  public ayws(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bgmg.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public ayyg a(Intent paramIntent)
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
      ayyh localayyh = new ayyh();
      localayyh.d((String)localObject);
      localayyh.e(i);
      localayyh.e(str);
      localayyh.d(k);
      localayyh.f(j);
      localayyh.l(n);
      localayyh.k(m);
      localayyh.a(bool);
      localayyh.f(paramIntent.rawMd5);
      localayyh.a(paramIntent.fileSize);
      localObject = localayyh.a();
      ((ayyg)localObject).jdField_i_of_type_Boolean = true;
      ((ayyg)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(ayyg paramayyg)
  {
    long l = System.currentTimeMillis();
    if ((paramayyg != null) && (a(paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayyg.c, paramayyg.d, paramayyg.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramayyg.jdField_a_of_type_Int;
      localMessageForPic.path = paramayyg.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramayyg.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramayyg.jdField_a_of_type_Ayyi != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramayyg.jdField_a_of_type_Ayyi.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramayyg.jdField_a_of_type_Ayyi.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramayyg.jdField_a_of_type_Ayyi.c;
        }
        localMessageForPic.localUUID = paramayyg.jdField_a_of_type_JavaLangString;
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!bcsc.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramayyg.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramayyg.e;
        localMessageForPic.thumbHeight = paramayyg.f;
        localMessageForPic.width = paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramayyg.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramayyg.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramayyg.n;
        localMessageForPic.sync2Story = paramayyg.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramayyg.jdField_i_of_type_Boolean;
        str2 = bbyw.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(bbyw.s, paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(bbyw.t, String.valueOf(paramayyg.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramayyg.jdField_a_of_type_Long = localMessageForPic.uniseq;
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramayyg.jdField_b_of_type_Long;
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramayyg.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramayyg.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(ayxx paramayxx)
  {
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramayxx.a))
    {
      b(paramayxx);
      return;
    }
    a(3, paramayxx.a.jdField_a_of_type_Ayxt);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    bdzx.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(ayxx paramayxx)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramayxx.a, paramayxx), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayws
 * JD-Core Version:    0.7.0.1
 */