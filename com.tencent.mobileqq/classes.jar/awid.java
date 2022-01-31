import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.AioPicOperator.1;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class awid
  extends awih
{
  public awid() {}
  
  public awid(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    long l = System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break;
        }
        try
        {
          String str2 = bhpp.a(paramString);
          paramString = str2;
          if (str2 == null) {
            paramString = "";
          }
        }
        catch (IOException paramString)
        {
          paramString = "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(awju paramawju, MessageForPic paramMessageForPic)
  {
    paramawju = paramawju.jdField_a_of_type_JavaUtilArrayList;
    int i = paramawju.size();
    int j;
    if (i == 10)
    {
      i = 9;
      j = 4;
    }
    for (;;)
    {
      if (i != -1)
      {
        paramMessageForPic.mDownloadLength = ((Integer)paramawju.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramawju.get(j)).intValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "AioPicOperator.loadPgInfo():showLen " + paramMessageForPic.mShowLength + ", downloadLen " + paramMessageForPic.mDownloadLength);
      }
      return;
      if (i == 6)
      {
        i = 5;
        j = 5;
      }
      else
      {
        j = -1;
        i = -1;
      }
    }
  }
  
  public awjf a(Intent paramIntent)
  {
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      Object localObject1 = paramIntent.getStringExtra("forward_filepath");
      Object localObject2 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str5 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str6 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      String str1 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject3 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
      int j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
      long l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      int k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      String str4 = paramIntent.getStringExtra("forward_photo_md5");
      int m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      long l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      int i1 = paramIntent.getIntExtra("forward_photo_imagebiz_type", -1);
      paramIntent = new awjf();
      awjv localawjv = new awjv();
      localawjv.d(1009);
      localawjv.a((String)localObject1);
      localawjv.c(str1);
      localawjv.c(baye.jdField_f_of_type_Int);
      localawjv.g((int)l3);
      localawjv.h((int)l4);
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localawjv.a((int)l5);
      localawjv.i(k);
      localawjv.j(n);
      localObject3 = baqn.a((String)localObject3);
      if (localObject3 != null) {
        localawjv.b(((File)localObject3).getAbsolutePath());
      }
      localawjv.e(i);
      localawjv.e(str5);
      localawjv.d(str6);
      localawjv.f(str4);
      localawjv.b(l1);
      localawjv.m(i1);
      paramIntent.jdField_a_of_type_Awju = localawjv.a();
      paramIntent.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Awju.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Awju;
        if (biqe.a((String)localObject1)) {
          bdif.a();
        }
        try
        {
          ((awju)localObject2).jdField_a_of_type_JavaUtilArrayList = biqe.a((String)localObject1);
          bdif.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bdhb.b((String)localObject1))
          {
            localObject1 = new awje();
            ((awje)localObject1).a(1009);
            ((awje)localObject1).a(str1);
            ((awje)localObject1).b(str2);
            ((awje)localObject1).b(j);
            ((awje)localObject1).c(str3);
            ((awje)localObject1).a(l1);
            ((awje)localObject1).d(str4);
            ((awje)localObject1).c(m);
            paramIntent.jdField_a_of_type_Awjd = ((awje)localObject1).a();
            paramIntent.jdField_a_of_type_Awjd.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Awjd.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Awjd.jdField_b_of_type_Long = l2;
          }
          awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Awju.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bdhb.a((String)localObject1));
            }
          }
        }
      }
    }
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public awjf a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bdex.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      awjf localawjf;
      if (i == 0)
      {
        i = 65537;
        Object localObject = bayu.a(paramMessageForPic, i).toString();
        localawjf = new awjf();
        localawjf.b = paramMessageForPic.isSendFromLocal();
        awjv localawjv = new awjv();
        localawjv.d(1009);
        localawjv.a(paramMessageForPic.path);
        localawjv.c(paramString3);
        localawjv.c(baye.jdField_f_of_type_Int);
        localawjv.g((int)paramMessageForPic.width);
        localawjv.h((int)paramMessageForPic.height);
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localawjv.a((int)paramMessageForPic.size);
        localawjv.i(paramMessageForPic.fileSizeFlag);
        localawjv.a(paramMessageForPic.thumbWidth);
        localawjv.b(paramMessageForPic.thumbHeight);
        localawjv.j(paramMessageForPic.imageType);
        localObject = baqn.a((String)localObject);
        if (localObject != null) {
          localawjv.b(((File)localObject).getAbsolutePath());
        }
        localawjv.e(paramInt);
        localawjv.e(paramString1);
        localawjv.d(paramString2);
        localawjv.f(paramMessageForPic.md5);
        localawjf.jdField_a_of_type_Awju = localawjv.a();
        localawjf.jdField_a_of_type_Awju.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localawjf.jdField_a_of_type_Awju.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localawjf.jdField_a_of_type_Awju;
        if ((paramString1.jdField_h_of_type_Int < 0) && (biqe.a(paramMessageForPic.path))) {
          bdif.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = biqe.a(paramMessageForPic.path);
        bdif.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bdhb.b(paramMessageForPic.path)))
        {
          paramString1 = new awje();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localawjf.jdField_a_of_type_Awjd = paramString1.a();
          localawjf.jdField_a_of_type_Awjd.jdField_e_of_type_JavaLangString = "chatimg";
          localawjf.jdField_a_of_type_Awjd.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localawjf.jdField_a_of_type_Awjd.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localawjf.jdField_a_of_type_Awju.jdField_a_of_type_Awjw != null)
        {
          bool = true;
          awiw.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localawjf;
          i = 0;
          continue;
          i = 1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bdhb.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public awju a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject2 = paramIntent.getStringExtra("uin");
      String str2 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      String str3 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool1 = paramIntent.getBooleanExtra("video_sync_to_story", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
      Object localObject1 = paramIntent.getStringExtra("widgetinfo");
      String str1 = paramIntent.getStringExtra("key_camera_material_name");
      awjv localawjv = new awjv();
      localawjv.d((String)localObject2);
      localawjv.a(str3);
      localawjv.e(i);
      localawjv.e(str2);
      localawjv.d(k);
      localawjv.f(j);
      localawjv.l(n);
      localawjv.k(m);
      localawjv.a(bool1);
      localawjv.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new awjt();
        ((awjt)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((awjt)localObject2).b = str1;
        localawjv.a((awjt)localObject2);
      }
      localObject1 = localawjv.a();
      apkh.a(paramIntent, (awju)localObject1);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((awju)localObject1).p = i;
        ((awju)localObject1).m = str1;
        ((awju)localObject1).jdField_e_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((awju)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((awju)localObject1).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(awjf paramawjf)
  {
    boolean bool = true;
    if ((paramawjf == null) || (!paramawjf.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    awju localawju = paramawjf.jdField_a_of_type_Awju;
    bavm localbavm = new bavm();
    localbavm.c = localawju.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = azaf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawju.c, localawju.d, localawju.jdField_b_of_type_Int);
    localMessageForPic.path = localawju.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localawju.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localawju.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (baws.a(localawju.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localawju.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramawjf.jdField_a_of_type_Awju.l;
    paramawjf = paramawjf.jdField_a_of_type_Awjd;
    if (paramawjf != null)
    {
      if (paramawjf.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramawjf.jdField_f_of_type_JavaLangString;
      }
      if (paramawjf.jdField_a_of_type_Long != 0L) {
        localbavm.jdField_a_of_type_Long = paramawjf.jdField_a_of_type_Long;
      }
      if (paramawjf.c != null) {
        localbavm.jdField_a_of_type_JavaLangString = paramawjf.c;
      }
      if (paramawjf.jdField_b_of_type_Int != -1) {
        localbavm.jdField_a_of_type_Int = paramawjf.jdField_b_of_type_Int;
      }
      if (paramawjf.jdField_g_of_type_JavaLangString != null) {
        localbavm.b = paramawjf.jdField_g_of_type_JavaLangString;
      }
    }
    if (localawju.q != -1)
    {
      paramawjf = new PicMessageExtraData();
      paramawjf.imageBizType = localawju.q;
      localMessageForPic.picExtraData = paramawjf;
    }
    localMessageForPic.picExtraFlag = baye.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localbavm;
    if (localawju.jdField_a_of_type_Awjw != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localawju.jdField_a_of_type_Awjw.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localawju.jdField_a_of_type_Awjw.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localawju.jdField_a_of_type_Awjw.c;
      }
      localMessageForPic.localUUID = localawju.jdField_a_of_type_JavaLangString;
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = biqe.a(localawju.jdField_g_of_type_JavaLangString);
      paramawjf = localawju.jdField_a_of_type_JavaUtilArrayList;
      if ((paramawjf == null) || (paramawjf.isEmpty())) {
        break label760;
      }
      a(localawju, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localawju.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramawjf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramawjf != null) {
        paramawjf.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new barf(paramawjf));
      }
      a(localMessageForPic);
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(awju paramawju)
  {
    long l = System.currentTimeMillis();
    if ((paramawju != null) && (paramawju.jdField_g_of_type_JavaLangString != null))
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!azqb.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramawju.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramawju.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramawju.jdField_f_of_type_Int;
        localObject = new File(paramawju.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramawju.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (baws.a(paramawju.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramawju.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramawju.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramawju.n;
        localMessageForPic.sync2Story = paramawju.jdField_h_of_type_Boolean;
        String str = ayzs.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramawju);
        localMessageForPic.imageType = biqe.a(paramawju.jdField_g_of_type_JavaLangString);
        localObject = paramawju.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramawju, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramawju.jdField_a_of_type_Long = localMessageForPic.uniseq;
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramawju.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramawju.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramawju.jdField_h_of_type_JavaLangString;
        break label229;
        label705:
        localObject = "0";
        break label507;
        label713:
        if (QLog.isColorLevel()) {
          QLog.d("peak_pgjpeg", 2, "Slice infos is null");
        }
      }
    }
    return null;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), awkj.a(i), j);
  }
  
  public ArrayList<awjf> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForMixedMsg == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramMessageForMixedMsg.msgElemList == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
      }
    }
    awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(awki paramawki)
  {
    if (paramawki != null)
    {
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramawki);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramawki.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramawki.c;
      localMessageForPic.groupFileID = paramawki.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramawki.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((alul.a(paramMessageForPic)) || (alse.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = bayu.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (alse.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bcyz.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      awiw.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = bayu.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, awju paramawju)
  {
    aoiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawju.c, paramawju.jdField_b_of_type_Int, paramawju.o);
    if (paramawju.jdField_b_of_type_Int == 0) {
      aoiy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawju.c);
    }
    for (;;)
    {
      if (paramawju.jdField_a_of_type_Int == 1036) {
        apib.a(paramMessageForPic);
      }
      if (paramawju.jdField_a_of_type_Int == 1039) {
        alul.a(paramMessageForPic, false);
      }
      if (paramawju.jdField_a_of_type_Int == 1040) {
        alse.a(paramMessageForPic, false);
      }
      if ((paramawju.jdField_a_of_type_Int == 1044) || (paramawju.jdField_a_of_type_Int == 1049)) {
        apkh.a(paramMessageForPic, paramawju);
      }
      if (paramawju.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramawju.m);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramawju.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramawju.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramawju.jdField_f_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramawju.jdField_g_of_type_Long));
      }
      if (paramawju.j) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramawju.jdField_b_of_type_Int == 1) {
        aoiy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawju.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awid
 * JD-Core Version:    0.7.0.1
 */