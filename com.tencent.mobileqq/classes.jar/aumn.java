import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.item.FlashPicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class aumn
  extends aumr
{
  public aumn() {}
  
  public aumn(QQAppInterface paramQQAppInterface)
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
          String str2 = bfko.a(paramString);
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
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(auod paramauod, MessageForPic paramMessageForPic)
  {
    paramauod = paramauod.jdField_a_of_type_JavaUtilArrayList;
    int i = paramauod.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramauod.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramauod.get(j)).intValue();
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
  
  public aunp a(Intent paramIntent)
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
      paramIntent = new aunp();
      auoe localauoe = new auoe();
      localauoe.d(1009);
      localauoe.a((String)localObject1);
      localauoe.c(str1);
      localauoe.c(ayvw.jdField_f_of_type_Int);
      localauoe.g((int)l3);
      localauoe.h((int)l4);
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localauoe.a((int)l5);
      localauoe.i(k);
      localauoe.j(n);
      localObject3 = ayoi.a((String)localObject3);
      if (localObject3 != null) {
        localauoe.b(((File)localObject3).getAbsolutePath());
      }
      localauoe.e(i);
      localauoe.e(str5);
      localauoe.d(str6);
      localauoe.f(str4);
      localauoe.b(l1);
      localauoe.m(i1);
      paramIntent.jdField_a_of_type_Auod = localauoe.a();
      paramIntent.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Auod.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Auod;
        if (bgky.a((String)localObject1)) {
          bbfb.a();
        }
        try
        {
          ((auod)localObject2).jdField_a_of_type_JavaUtilArrayList = bgky.a((String)localObject1);
          bbfb.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bbdx.b((String)localObject1))
          {
            localObject1 = new auno();
            ((auno)localObject1).a(1009);
            ((auno)localObject1).a(str1);
            ((auno)localObject1).b(str2);
            ((auno)localObject1).b(j);
            ((auno)localObject1).c(str3);
            ((auno)localObject1).a(l1);
            ((auno)localObject1).d(str4);
            ((auno)localObject1).c(m);
            paramIntent.jdField_a_of_type_Aunn = ((auno)localObject1).a();
            paramIntent.jdField_a_of_type_Aunn.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Aunn.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Aunn.jdField_b_of_type_Long = l2;
          }
          aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Auod.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bbdx.a((String)localObject1));
            }
          }
        }
      }
    }
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public aunp a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bbbu.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      aunp localaunp;
      if (i == 0)
      {
        i = 65537;
        Object localObject = aywm.a(paramMessageForPic, i).toString();
        localaunp = new aunp();
        localaunp.b = paramMessageForPic.isSendFromLocal();
        auoe localauoe = new auoe();
        localauoe.d(1009);
        localauoe.a(paramMessageForPic.path);
        localauoe.c(paramString3);
        localauoe.c(ayvw.jdField_f_of_type_Int);
        localauoe.g((int)paramMessageForPic.width);
        localauoe.h((int)paramMessageForPic.height);
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localauoe.a((int)paramMessageForPic.size);
        localauoe.i(paramMessageForPic.fileSizeFlag);
        localauoe.a(paramMessageForPic.thumbWidth);
        localauoe.b(paramMessageForPic.thumbHeight);
        localauoe.j(paramMessageForPic.imageType);
        localObject = ayoi.a((String)localObject);
        if (localObject != null) {
          localauoe.b(((File)localObject).getAbsolutePath());
        }
        localauoe.e(paramInt);
        localauoe.e(paramString1);
        localauoe.d(paramString2);
        localauoe.f(paramMessageForPic.md5);
        localaunp.jdField_a_of_type_Auod = localauoe.a();
        localaunp.jdField_a_of_type_Auod.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localaunp.jdField_a_of_type_Auod.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localaunp.jdField_a_of_type_Auod;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bgky.a(paramMessageForPic.path))) {
          bbfb.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bgky.a(paramMessageForPic.path);
        bbfb.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bbdx.b(paramMessageForPic.path)))
        {
          paramString1 = new auno();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localaunp.jdField_a_of_type_Aunn = paramString1.a();
          localaunp.jdField_a_of_type_Aunn.jdField_e_of_type_JavaLangString = "chatimg";
          localaunp.jdField_a_of_type_Aunn.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localaunp.jdField_a_of_type_Aunn.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localaunp.jdField_a_of_type_Auod.jdField_a_of_type_Auof != null)
        {
          bool = true;
          aung.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localaunp;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bbdx.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public auod a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getStringExtra("uin");
      String str1 = paramIntent.getStringExtra("troop_uin");
      int i = paramIntent.getIntExtra("uintype", 1003);
      int j = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      int k = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      String str2 = paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH");
      int m = paramIntent.getIntExtra("entrance", 0);
      int n = paramIntent.getIntExtra("key_confess_topicid", 0);
      boolean bool1 = paramIntent.getBooleanExtra("video_sync_to_story", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
      String str3 = paramIntent.getStringExtra("widgetinfo");
      auoe localauoe = new auoe();
      localauoe.d((String)localObject);
      localauoe.a(str2);
      localauoe.e(i);
      localauoe.e(str1);
      localauoe.d(k);
      localauoe.f(j);
      localauoe.l(n);
      localauoe.k(m);
      localauoe.a(bool1);
      localauoe.b(bool2);
      localauoe.g(str3);
      localObject = localauoe.a();
      anor.a(paramIntent, (auod)localObject);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((auod)localObject).p = i;
        ((auod)localObject).m = str1;
        ((auod)localObject).jdField_e_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((auod)localObject).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((auod)localObject).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(aunp paramaunp)
  {
    boolean bool = true;
    if ((paramaunp == null) || (!paramaunp.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    auod localauod = paramaunp.jdField_a_of_type_Auod;
    aytg localaytg = new aytg();
    localaytg.c = localauod.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = axas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localauod.c, localauod.d, localauod.jdField_b_of_type_Int);
    localMessageForPic.path = localauod.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localauod.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localauod.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (ayuk.a(localauod.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localauod.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramaunp.jdField_a_of_type_Auod.l;
    paramaunp = paramaunp.jdField_a_of_type_Aunn;
    if (paramaunp != null)
    {
      if (paramaunp.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramaunp.jdField_f_of_type_JavaLangString;
      }
      if (paramaunp.jdField_a_of_type_Long != 0L) {
        localaytg.jdField_a_of_type_Long = paramaunp.jdField_a_of_type_Long;
      }
      if (paramaunp.c != null) {
        localaytg.jdField_a_of_type_JavaLangString = paramaunp.c;
      }
      if (paramaunp.jdField_b_of_type_Int != -1) {
        localaytg.jdField_a_of_type_Int = paramaunp.jdField_b_of_type_Int;
      }
      if (paramaunp.jdField_g_of_type_JavaLangString != null) {
        localaytg.b = paramaunp.jdField_g_of_type_JavaLangString;
      }
    }
    if (localauod.q != -1)
    {
      paramaunp = new PicMessageExtraData();
      paramaunp.imageBizType = localauod.q;
      localMessageForPic.picExtraData = paramaunp;
    }
    localMessageForPic.picExtraFlag = ayvw.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localaytg;
    if (localauod.jdField_a_of_type_Auof != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localauod.jdField_a_of_type_Auof.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localauod.jdField_a_of_type_Auof.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localauod.jdField_a_of_type_Auof.c;
      }
      localMessageForPic.localUUID = localauod.jdField_a_of_type_JavaLangString;
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bgky.a(localauod.jdField_g_of_type_JavaLangString);
      paramaunp = localauod.jdField_a_of_type_JavaUtilArrayList;
      if ((paramaunp == null) || (paramaunp.isEmpty())) {
        break label760;
      }
      a(localauod, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localauod.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramaunp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramaunp != null) {
        paramaunp.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new aypb(paramaunp));
      }
      a(localMessageForPic);
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(auod paramauod)
  {
    long l = System.currentTimeMillis();
    if ((paramauod != null) && (paramauod.jdField_g_of_type_JavaLangString != null))
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!axqh.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramauod.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramauod.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramauod.jdField_f_of_type_Int;
        localObject = new File(paramauod.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramauod.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (ayuk.a(paramauod.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramauod.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramauod.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramauod.n;
        localMessageForPic.sync2Story = paramauod.jdField_h_of_type_Boolean;
        String str = axaf.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramauod);
        localMessageForPic.imageType = bgky.a(paramauod.jdField_g_of_type_JavaLangString);
        localObject = paramauod.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramauod, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramauod.jdField_a_of_type_Long = localMessageForPic.uniseq;
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        aung.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramauod.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramauod.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramauod.jdField_h_of_type_JavaLangString;
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
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), auos.a(i), j);
  }
  
  public ArrayList<aunp> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    aung.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(auor paramauor)
  {
    if (paramauor != null)
    {
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramauor);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramauor.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramauor.c;
      localMessageForPic.groupFileID = paramauor.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramauor.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((ajyi.a(paramMessageForPic)) || (ajwb.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = aywm.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (ajwb.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bavw.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      aung.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = aywm.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, auod paramauod)
  {
    amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauod.c, paramauod.jdField_b_of_type_Int, paramauod.o);
    if (paramauod.jdField_b_of_type_Int == 0) {
      amnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauod.c);
    }
    for (;;)
    {
      if (paramauod.jdField_a_of_type_Int == 1036) {
        anml.a(paramMessageForPic);
      }
      if (paramauod.jdField_a_of_type_Int == 1039) {
        ajyi.a(paramMessageForPic, false);
      }
      if (paramauod.jdField_a_of_type_Int == 1040) {
        ajwb.a(paramMessageForPic, false);
      }
      if ((paramauod.jdField_a_of_type_Int == 1044) || (paramauod.jdField_a_of_type_Int == 1049)) {
        anor.a(paramMessageForPic, paramauod);
      }
      if (paramauod.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramauod.m);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramauod.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramauod.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramauod.jdField_f_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramauod.jdField_g_of_type_Long));
      }
      if (paramauod.j) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramauod.jdField_b_of_type_Int == 1) {
        amnr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauod.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumn
 * JD-Core Version:    0.7.0.1
 */