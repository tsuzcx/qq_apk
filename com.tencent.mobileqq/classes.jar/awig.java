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

public class awig
  extends awid
{
  public awig() {}
  
  public awig(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean a(PhotoSendParams paramPhotoSendParams)
  {
    if ((paramPhotoSendParams == null) || (TextUtils.isEmpty(paramPhotoSendParams.rawMd5)) || (TextUtils.isEmpty(paramPhotoSendParams.thumbPath)) || (!bdhb.b(paramPhotoSendParams.thumbPath)) || (TextUtils.isEmpty(paramPhotoSendParams.rawDownloadUrl)))
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
  
  public awju a(Intent paramIntent)
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
      awjv localawjv = new awjv();
      localawjv.d((String)localObject);
      localawjv.e(i);
      localawjv.e(str);
      localawjv.d(k);
      localawjv.f(j);
      localawjv.l(n);
      localawjv.k(m);
      localawjv.a(bool);
      localawjv.f(paramIntent.rawMd5);
      localawjv.a(paramIntent.fileSize);
      localObject = localawjv.a();
      ((awju)localObject).jdField_i_of_type_Boolean = true;
      ((awju)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(awju paramawju)
  {
    long l = System.currentTimeMillis();
    if ((paramawju != null) && (a(paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawju.c, paramawju.d, paramawju.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramawju.jdField_a_of_type_Int;
      localMessageForPic.path = paramawju.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramawju.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramawju.jdField_a_of_type_Awjw != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramawju.jdField_a_of_type_Awjw.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramawju.jdField_a_of_type_Awjw.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramawju.jdField_a_of_type_Awjw.c;
        }
        localMessageForPic.localUUID = paramawju.jdField_a_of_type_JavaLangString;
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!azqb.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramawju.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramawju.e;
        localMessageForPic.thumbHeight = paramawju.f;
        localMessageForPic.width = paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramawju.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramawju.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramawju.n;
        localMessageForPic.sync2Story = paramawju.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramawju.jdField_i_of_type_Boolean;
        str2 = ayzs.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(ayzs.s, paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(ayzs.t, String.valueOf(paramawju.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramawju.jdField_a_of_type_Long = localMessageForPic.uniseq;
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramawju.jdField_b_of_type_Long;
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramawju.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramawju.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(awjl paramawjl)
  {
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramawjl.a))
    {
      b(paramawjl);
      return;
    }
    a(3, paramawjl.a.jdField_a_of_type_Awjh);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    bayu.a(paramMessageForPic, 65537, null, null).downloadImediatly();
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(awjl paramawjl)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramawjl.a, paramawjl), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awig
 * JD-Core Version:    0.7.0.1
 */