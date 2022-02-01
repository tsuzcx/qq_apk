import android.content.Intent;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.AioQzonePicOperator.1;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class aziz
  extends aziw
{
  public aziz() {}
  
  public aziz(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!FileUtils.fileExistsAndNotEmpty(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public azkn a(Intent paramIntent)
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
      azko localazko = new azko();
      localazko.d((String)localObject);
      localazko.e(i);
      localazko.e(str);
      localazko.d(k);
      localazko.f(j);
      localazko.l(n);
      localazko.k(m);
      localazko.a(bool);
      localazko.f(paramIntent.rawMd5);
      localazko.a(paramIntent.fileSize);
      localObject = localazko.a();
      ((azkn)localObject).jdField_i_of_type_Boolean = true;
      ((azkn)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(azkn paramazkn)
  {
    long l = System.currentTimeMillis();
    if ((paramazkn != null) && (a(paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazkn.c, paramazkn.d, paramazkn.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramazkn.jdField_a_of_type_Int;
      localMessageForPic.path = paramazkn.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramazkn.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramazkn.jdField_a_of_type_Azkp != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramazkn.jdField_a_of_type_Azkp.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramazkn.jdField_a_of_type_Azkp.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramazkn.jdField_a_of_type_Azkp.c;
        }
        localMessageForPic.localUUID = paramazkn.jdField_a_of_type_JavaLangString;
        azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!bdkj.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramazkn.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramazkn.e;
        localMessageForPic.thumbHeight = paramazkn.f;
        localMessageForPic.width = paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramazkn.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramazkn.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramazkn.n;
        localMessageForPic.sync2Story = paramazkn.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramazkn.jdField_i_of_type_Boolean;
        str2 = bcrn.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(bcrn.s, paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(bcrn.t, String.valueOf(paramazkn.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramazkn.jdField_a_of_type_Long = localMessageForPic.uniseq;
        azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramazkn.jdField_b_of_type_Long;
        azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramazkn.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramazkn.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(azke paramazke)
  {
    azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramazke.a))
    {
      b(paramazke);
      return;
    }
    a(3, paramazke.a.jdField_a_of_type_Azkb);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null).downloadImediatly();
    azjq.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(azke paramazke)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramazke.a, paramazke), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziz
 * JD-Core Version:    0.7.0.1
 */