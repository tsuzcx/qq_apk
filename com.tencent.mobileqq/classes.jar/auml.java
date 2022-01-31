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

public class auml
  extends aump
{
  public auml() {}
  
  public auml(QQAppInterface paramQQAppInterface)
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
          String str2 = bfjx.a(paramString);
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
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(auob paramauob, MessageForPic paramMessageForPic)
  {
    paramauob = paramauob.jdField_a_of_type_JavaUtilArrayList;
    int i = paramauob.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramauob.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramauob.get(j)).intValue();
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
  
  public aunn a(Intent paramIntent)
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
      paramIntent = new aunn();
      auoc localauoc = new auoc();
      localauoc.d(1009);
      localauoc.a((String)localObject1);
      localauoc.c(str1);
      localauoc.c(ayvu.jdField_f_of_type_Int);
      localauoc.g((int)l3);
      localauoc.h((int)l4);
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localauoc.a((int)l5);
      localauoc.i(k);
      localauoc.j(n);
      localObject3 = ayog.a((String)localObject3);
      if (localObject3 != null) {
        localauoc.b(((File)localObject3).getAbsolutePath());
      }
      localauoc.e(i);
      localauoc.e(str5);
      localauoc.d(str6);
      localauoc.f(str4);
      localauoc.b(l1);
      localauoc.m(i1);
      paramIntent.jdField_a_of_type_Auob = localauoc.a();
      paramIntent.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Auob.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Auob;
        if (bgkh.a((String)localObject1)) {
          bben.a();
        }
        try
        {
          ((auob)localObject2).jdField_a_of_type_JavaUtilArrayList = bgkh.a((String)localObject1);
          bben.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bbdj.b((String)localObject1))
          {
            localObject1 = new aunm();
            ((aunm)localObject1).a(1009);
            ((aunm)localObject1).a(str1);
            ((aunm)localObject1).b(str2);
            ((aunm)localObject1).b(j);
            ((aunm)localObject1).c(str3);
            ((aunm)localObject1).a(l1);
            ((aunm)localObject1).d(str4);
            ((aunm)localObject1).c(m);
            paramIntent.jdField_a_of_type_Aunl = ((aunm)localObject1).a();
            paramIntent.jdField_a_of_type_Aunl.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Aunl.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Aunl.jdField_b_of_type_Long = l2;
          }
          aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Auob.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bbdj.a((String)localObject1));
            }
          }
        }
      }
    }
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public aunn a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bbbg.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      aunn localaunn;
      if (i == 0)
      {
        i = 65537;
        Object localObject = aywk.a(paramMessageForPic, i).toString();
        localaunn = new aunn();
        localaunn.b = paramMessageForPic.isSendFromLocal();
        auoc localauoc = new auoc();
        localauoc.d(1009);
        localauoc.a(paramMessageForPic.path);
        localauoc.c(paramString3);
        localauoc.c(ayvu.jdField_f_of_type_Int);
        localauoc.g((int)paramMessageForPic.width);
        localauoc.h((int)paramMessageForPic.height);
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localauoc.a((int)paramMessageForPic.size);
        localauoc.i(paramMessageForPic.fileSizeFlag);
        localauoc.a(paramMessageForPic.thumbWidth);
        localauoc.b(paramMessageForPic.thumbHeight);
        localauoc.j(paramMessageForPic.imageType);
        localObject = ayog.a((String)localObject);
        if (localObject != null) {
          localauoc.b(((File)localObject).getAbsolutePath());
        }
        localauoc.e(paramInt);
        localauoc.e(paramString1);
        localauoc.d(paramString2);
        localauoc.f(paramMessageForPic.md5);
        localaunn.jdField_a_of_type_Auob = localauoc.a();
        localaunn.jdField_a_of_type_Auob.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localaunn.jdField_a_of_type_Auob.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localaunn.jdField_a_of_type_Auob;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bgkh.a(paramMessageForPic.path))) {
          bben.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bgkh.a(paramMessageForPic.path);
        bben.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bbdj.b(paramMessageForPic.path)))
        {
          paramString1 = new aunm();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localaunn.jdField_a_of_type_Aunl = paramString1.a();
          localaunn.jdField_a_of_type_Aunl.jdField_e_of_type_JavaLangString = "chatimg";
          localaunn.jdField_a_of_type_Aunl.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localaunn.jdField_a_of_type_Aunl.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localaunn.jdField_a_of_type_Auob.jdField_a_of_type_Auod != null)
        {
          bool = true;
          aune.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localaunn;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bbdj.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public auob a(Intent paramIntent)
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
      auoc localauoc = new auoc();
      localauoc.d((String)localObject);
      localauoc.a(str2);
      localauoc.e(i);
      localauoc.e(str1);
      localauoc.d(k);
      localauoc.f(j);
      localauoc.l(n);
      localauoc.k(m);
      localauoc.a(bool1);
      localauoc.b(bool2);
      localauoc.g(str3);
      localObject = localauoc.a();
      anom.a(paramIntent, (auob)localObject);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((auob)localObject).p = i;
        ((auob)localObject).m = str1;
        ((auob)localObject).jdField_e_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((auob)localObject).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((auob)localObject).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(aunn paramaunn)
  {
    boolean bool = true;
    if ((paramaunn == null) || (!paramaunn.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    auob localauob = paramaunn.jdField_a_of_type_Auob;
    ayte localayte = new ayte();
    localayte.c = localauob.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localauob.c, localauob.d, localauob.jdField_b_of_type_Int);
    localMessageForPic.path = localauob.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localauob.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localauob.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (ayui.a(localauob.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localauob.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramaunn.jdField_a_of_type_Auob.l;
    paramaunn = paramaunn.jdField_a_of_type_Aunl;
    if (paramaunn != null)
    {
      if (paramaunn.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramaunn.jdField_f_of_type_JavaLangString;
      }
      if (paramaunn.jdField_a_of_type_Long != 0L) {
        localayte.jdField_a_of_type_Long = paramaunn.jdField_a_of_type_Long;
      }
      if (paramaunn.c != null) {
        localayte.jdField_a_of_type_JavaLangString = paramaunn.c;
      }
      if (paramaunn.jdField_b_of_type_Int != -1) {
        localayte.jdField_a_of_type_Int = paramaunn.jdField_b_of_type_Int;
      }
      if (paramaunn.jdField_g_of_type_JavaLangString != null) {
        localayte.b = paramaunn.jdField_g_of_type_JavaLangString;
      }
    }
    if (localauob.q != -1)
    {
      paramaunn = new PicMessageExtraData();
      paramaunn.imageBizType = localauob.q;
      localMessageForPic.picExtraData = paramaunn;
    }
    localMessageForPic.picExtraFlag = ayvu.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localayte;
    if (localauob.jdField_a_of_type_Auod != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localauob.jdField_a_of_type_Auod.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localauob.jdField_a_of_type_Auod.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localauob.jdField_a_of_type_Auod.c;
      }
      localMessageForPic.localUUID = localauob.jdField_a_of_type_JavaLangString;
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bgkh.a(localauob.jdField_g_of_type_JavaLangString);
      paramaunn = localauob.jdField_a_of_type_JavaUtilArrayList;
      if ((paramaunn == null) || (paramaunn.isEmpty())) {
        break label760;
      }
      a(localauob, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localauob.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramaunn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramaunn != null) {
        paramaunn.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new ayoz(paramaunn));
      }
      a(localMessageForPic);
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(auob paramauob)
  {
    long l = System.currentTimeMillis();
    if ((paramauob != null) && (paramauob.jdField_g_of_type_JavaLangString != null))
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!axqf.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramauob.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramauob.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramauob.jdField_f_of_type_Int;
        localObject = new File(paramauob.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramauob.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (ayui.a(paramauob.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramauob.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramauob.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramauob.n;
        localMessageForPic.sync2Story = paramauob.jdField_h_of_type_Boolean;
        String str = axad.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramauob);
        localMessageForPic.imageType = bgkh.a(paramauob.jdField_g_of_type_JavaLangString);
        localObject = paramauob.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramauob, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramauob.jdField_a_of_type_Long = localMessageForPic.uniseq;
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        aune.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramauob.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramauob.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramauob.jdField_h_of_type_JavaLangString;
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
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), auoq.a(i), j);
  }
  
  public ArrayList<aunn> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    aune.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(auop paramauop)
  {
    if (paramauop != null)
    {
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramauop);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramauop.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramauop.c;
      localMessageForPic.groupFileID = paramauop.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramauop.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((ajyk.a(paramMessageForPic)) || (ajwd.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = aywk.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (ajwd.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bavi.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      aune.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = aywk.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, auob paramauob)
  {
    amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauob.c, paramauob.jdField_b_of_type_Int, paramauob.o);
    if (paramauob.jdField_b_of_type_Int == 0) {
      amns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauob.c);
    }
    for (;;)
    {
      if (paramauob.jdField_a_of_type_Int == 1036) {
        anmg.a(paramMessageForPic);
      }
      if (paramauob.jdField_a_of_type_Int == 1039) {
        ajyk.a(paramMessageForPic, false);
      }
      if (paramauob.jdField_a_of_type_Int == 1040) {
        ajwd.a(paramMessageForPic, false);
      }
      if ((paramauob.jdField_a_of_type_Int == 1044) || (paramauob.jdField_a_of_type_Int == 1049)) {
        anom.a(paramMessageForPic, paramauob);
      }
      if (paramauob.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramauob.m);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramauob.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramauob.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramauob.jdField_f_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramauob.jdField_g_of_type_Long));
      }
      if (paramauob.j) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramauob.jdField_b_of_type_Int == 1) {
        amns.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramauob.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auml
 * JD-Core Version:    0.7.0.1
 */