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

public class aycn
  extends ayck
{
  public aycn() {}
  
  public aycn(QQAppInterface paramQQAppInterface)
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
  
  public ayeb a(Intent paramIntent)
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
      ayec localayec = new ayec();
      localayec.d((String)localObject);
      localayec.e(i);
      localayec.e(str);
      localayec.d(k);
      localayec.f(j);
      localayec.l(n);
      localayec.k(m);
      localayec.a(bool);
      localayec.f(paramIntent.rawMd5);
      localayec.a(paramIntent.fileSize);
      localObject = localayec.a();
      ((ayeb)localObject).jdField_i_of_type_Boolean = true;
      ((ayeb)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams = paramIntent;
      ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(ayeb paramayeb)
  {
    long l = System.currentTimeMillis();
    if ((paramayeb != null) && (a(paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams)))
    {
      MessageForPic localMessageForPic = bbli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayeb.c, paramayeb.d, paramayeb.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramayeb.jdField_a_of_type_Int;
      localMessageForPic.path = paramayeb.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramayeb.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label228:
      String str2;
      if (paramayeb.jdField_a_of_type_Ayed != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramayeb.jdField_a_of_type_Ayed.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramayeb.jdField_a_of_type_Ayed.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramayeb.jdField_a_of_type_Ayed.c;
        }
        localMessageForPic.localUUID = paramayeb.jdField_a_of_type_JavaLangString;
        ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawMd5;
        if (!bcdo.a()) {
          break label509;
        }
        localMessageForPic.bigThumbMsgUrl = paramayeb.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramayeb.e;
        localMessageForPic.thumbHeight = paramayeb.f;
        localMessageForPic.width = paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawWidth;
        localMessageForPic.height = paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawHeight;
        localMessageForPic.extLong = paramayeb.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramayeb.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramayeb.n;
        localMessageForPic.sync2Story = paramayeb.jdField_h_of_type_Boolean;
        localMessageForPic.isQzonePic = paramayeb.jdField_i_of_type_Boolean;
        str2 = bbkv.r;
        if (!localMessageForPic.isQzonePic) {
          break label521;
        }
      }
      label521:
      for (String str1 = "1";; str1 = "0")
      {
        localMessageForPic.saveExtInfoToExtStr(str2, str1);
        localMessageForPic.saveExtInfoToExtStr(bbkv.s, paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.rawDownloadUrl);
        localMessageForPic.saveExtInfoToExtStr(bbkv.t, String.valueOf(paramayeb.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoSendParams.fileSize));
        localMessageForPic.imageType = 1000;
        localMessageForPic.serial();
        paramayeb.jdField_a_of_type_Long = localMessageForPic.uniseq;
        ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        localMessageForPic.DSKey = paramayeb.jdField_b_of_type_Long;
        ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramayeb.jdField_b_of_type_Long);
        return localMessageForPic;
        bool = false;
        break;
        label509:
        localMessageForPic.thumbMsgUrl = paramayeb.jdField_h_of_type_JavaLangString;
        break label228;
      }
    }
    return null;
  }
  
  public void a(ayds paramayds)
  {
    ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramayds.a))
    {
      b(paramayds);
      return;
    }
    a(3, paramayds.a.jdField_a_of_type_Aydp);
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null).downloadImediatly();
    ayde.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
  }
  
  protected void b(ayds paramayds)
  {
    ThreadManager.post(new AioQzonePicOperator.1(this, paramayds.a, paramayds), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycn
 * JD-Core Version:    0.7.0.1
 */