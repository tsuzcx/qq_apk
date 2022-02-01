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

public class azpf
  extends azpc
{
  public azpf() {}
  
  public azpf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bhmi.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public azqt a(Intent paramIntent)
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
      azqu localazqu = new azqu();
      localazqu.d((String)localObject);
      localazqu.e(i);
      localazqu.e(str);
      localazqu.d(k);
      localazqu.f(j);
      localazqu.l(n);
      localazqu.k(m);
      localazqu.a(bool);
      localazqu.f(paramIntent.rawMd5);
      localazqu.a(paramIntent.fileSize);
      localObject = localazqu.a();
      ((azqt)localObject).jdField_i_of_type_Boolean = true;
      ((azqt)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(azqt paramazqt)
  {
    long l = System.currentTimeMillis();
    if ((paramazqt != null) && (a(paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazqt.c, paramazqt.d, paramazqt.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramazqt.jdField_a_of_type_Int;
      localMessageForPic.path = paramazqt.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramazqt.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramazqt.jdField_a_of_type_Azqv != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramazqt.jdField_a_of_type_Azqv.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramazqt.jdField_a_of_type_Azqv.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramazqt.jdField_a_of_type_Azqv.c;
        }
        localMessageForPic.localUUID = paramazqt.jdField_a_of_type_JavaLangString;
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!bdku.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramazqt.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramazqt.e;
        localMessageForPic.thumbHeight = paramazqt.f;
        localMessageForPic.width = paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramazqt.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramazqt.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramazqt.n;
        localMessageForPic.sync2Story = paramazqt.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramazqt.jdField_i_of_type_Boolean;
        str2 = bcrn.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(bcrn.s, paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(bcrn.t, String.valueOf(paramazqt.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramazqt.jdField_a_of_type_Long = localMessageForPic.uniseq;
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramazqt.jdField_b_of_type_Long;
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramazqt.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramazqt.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(azqk paramazqk)
  {
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramazqk.a))
    {
      b(paramazqk);
      return;
    }
    a(3, paramazqk.a.jdField_a_of_type_Azqh);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    beyq.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(azqk paramazqk)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramazqk.a, paramazqk), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpf
 * JD-Core Version:    0.7.0.1
 */