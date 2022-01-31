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

public class awdu
  extends awdy
{
  public awdu() {}
  
  public awdu(QQAppInterface paramQQAppInterface)
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
          String str2 = bhli.a(paramString);
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
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(awfl paramawfl, MessageForPic paramMessageForPic)
  {
    paramawfl = paramawfl.jdField_a_of_type_JavaUtilArrayList;
    int i = paramawfl.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramawfl.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramawfl.get(j)).intValue();
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
  
  public awew a(Intent paramIntent)
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
      paramIntent = new awew();
      awfm localawfm = new awfm();
      localawfm.d(1009);
      localawfm.a((String)localObject1);
      localawfm.c(str1);
      localawfm.c(batv.jdField_f_of_type_Int);
      localawfm.g((int)l3);
      localawfm.h((int)l4);
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localawfm.a((int)l5);
      localawfm.i(k);
      localawfm.j(n);
      localObject3 = bame.a((String)localObject3);
      if (localObject3 != null) {
        localawfm.b(((File)localObject3).getAbsolutePath());
      }
      localawfm.e(i);
      localawfm.e(str5);
      localawfm.d(str6);
      localawfm.f(str4);
      localawfm.b(l1);
      localawfm.m(i1);
      paramIntent.jdField_a_of_type_Awfl = localawfm.a();
      paramIntent.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Awfl.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Awfl;
        if (bilx.a((String)localObject1)) {
          bddw.a();
        }
        try
        {
          ((awfl)localObject2).jdField_a_of_type_JavaUtilArrayList = bilx.a((String)localObject1);
          bddw.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bdcs.b((String)localObject1))
          {
            localObject1 = new awev();
            ((awev)localObject1).a(1009);
            ((awev)localObject1).a(str1);
            ((awev)localObject1).b(str2);
            ((awev)localObject1).b(j);
            ((awev)localObject1).c(str3);
            ((awev)localObject1).a(l1);
            ((awev)localObject1).d(str4);
            ((awev)localObject1).c(m);
            paramIntent.jdField_a_of_type_Aweu = ((awev)localObject1).a();
            paramIntent.jdField_a_of_type_Aweu.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Aweu.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Aweu.jdField_b_of_type_Long = l2;
          }
          awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Awfl.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bdcs.a((String)localObject1));
            }
          }
        }
      }
    }
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public awew a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bdao.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      awew localawew;
      if (i == 0)
      {
        i = 65537;
        Object localObject = baul.a(paramMessageForPic, i).toString();
        localawew = new awew();
        localawew.b = paramMessageForPic.isSendFromLocal();
        awfm localawfm = new awfm();
        localawfm.d(1009);
        localawfm.a(paramMessageForPic.path);
        localawfm.c(paramString3);
        localawfm.c(batv.jdField_f_of_type_Int);
        localawfm.g((int)paramMessageForPic.width);
        localawfm.h((int)paramMessageForPic.height);
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localawfm.a((int)paramMessageForPic.size);
        localawfm.i(paramMessageForPic.fileSizeFlag);
        localawfm.a(paramMessageForPic.thumbWidth);
        localawfm.b(paramMessageForPic.thumbHeight);
        localawfm.j(paramMessageForPic.imageType);
        localObject = bame.a((String)localObject);
        if (localObject != null) {
          localawfm.b(((File)localObject).getAbsolutePath());
        }
        localawfm.e(paramInt);
        localawfm.e(paramString1);
        localawfm.d(paramString2);
        localawfm.f(paramMessageForPic.md5);
        localawew.jdField_a_of_type_Awfl = localawfm.a();
        localawew.jdField_a_of_type_Awfl.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localawew.jdField_a_of_type_Awfl.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localawew.jdField_a_of_type_Awfl;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bilx.a(paramMessageForPic.path))) {
          bddw.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bilx.a(paramMessageForPic.path);
        bddw.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bdcs.b(paramMessageForPic.path)))
        {
          paramString1 = new awev();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localawew.jdField_a_of_type_Aweu = paramString1.a();
          localawew.jdField_a_of_type_Aweu.jdField_e_of_type_JavaLangString = "chatimg";
          localawew.jdField_a_of_type_Aweu.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localawew.jdField_a_of_type_Aweu.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localawew.jdField_a_of_type_Awfl.jdField_a_of_type_Awfn != null)
        {
          bool = true;
          awen.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localawew;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bdcs.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public awfl a(Intent paramIntent)
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
      awfm localawfm = new awfm();
      localawfm.d((String)localObject2);
      localawfm.a(str3);
      localawfm.e(i);
      localawfm.e(str2);
      localawfm.d(k);
      localawfm.f(j);
      localawfm.l(n);
      localawfm.k(m);
      localawfm.a(bool1);
      localawfm.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new awfk();
        ((awfk)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((awfk)localObject2).b = str1;
        localawfm.a((awfk)localObject2);
      }
      localObject1 = localawfm.a();
      apfy.a(paramIntent, (awfl)localObject1);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((awfl)localObject1).p = i;
        ((awfl)localObject1).m = str1;
        ((awfl)localObject1).jdField_e_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((awfl)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((awfl)localObject1).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(awew paramawew)
  {
    boolean bool = true;
    if ((paramawew == null) || (!paramawew.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    awfl localawfl = paramawew.jdField_a_of_type_Awfl;
    bard localbard = new bard();
    localbard.c = localawfl.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localawfl.c, localawfl.d, localawfl.jdField_b_of_type_Int);
    localMessageForPic.path = localawfl.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localawfl.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localawfl.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (basj.a(localawfl.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localawfl.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramawew.jdField_a_of_type_Awfl.l;
    paramawew = paramawew.jdField_a_of_type_Aweu;
    if (paramawew != null)
    {
      if (paramawew.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramawew.jdField_f_of_type_JavaLangString;
      }
      if (paramawew.jdField_a_of_type_Long != 0L) {
        localbard.jdField_a_of_type_Long = paramawew.jdField_a_of_type_Long;
      }
      if (paramawew.c != null) {
        localbard.jdField_a_of_type_JavaLangString = paramawew.c;
      }
      if (paramawew.jdField_b_of_type_Int != -1) {
        localbard.jdField_a_of_type_Int = paramawew.jdField_b_of_type_Int;
      }
      if (paramawew.jdField_g_of_type_JavaLangString != null) {
        localbard.b = paramawew.jdField_g_of_type_JavaLangString;
      }
    }
    if (localawfl.q != -1)
    {
      paramawew = new PicMessageExtraData();
      paramawew.imageBizType = localawfl.q;
      localMessageForPic.picExtraData = paramawew;
    }
    localMessageForPic.picExtraFlag = batv.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localbard;
    if (localawfl.jdField_a_of_type_Awfn != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localawfl.jdField_a_of_type_Awfn.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localawfl.jdField_a_of_type_Awfn.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localawfl.jdField_a_of_type_Awfn.c;
      }
      localMessageForPic.localUUID = localawfl.jdField_a_of_type_JavaLangString;
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bilx.a(localawfl.jdField_g_of_type_JavaLangString);
      paramawew = localawfl.jdField_a_of_type_JavaUtilArrayList;
      if ((paramawew == null) || (paramawew.isEmpty())) {
        break label760;
      }
      a(localawfl, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localawfl.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramawew = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramawew != null) {
        paramawew.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new bamw(paramawew));
      }
      a(localMessageForPic);
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(awfl paramawfl)
  {
    long l = System.currentTimeMillis();
    if ((paramawfl != null) && (paramawfl.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = ayvw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawfl.c, paramawfl.d, paramawfl.jdField_b_of_type_Int);
      localMessageForPic.busiType = paramawfl.jdField_a_of_type_Int;
      localMessageForPic.path = paramawfl.jdField_g_of_type_JavaLangString;
      localMessageForPic.size = 0L;
      localMessageForPic.type = 1;
      localMessageForPic.isRead = true;
      localMessageForPic.extraflag = 32772;
      if (paramawfl.jdField_g_of_type_Int == 1) {
        localMessageForPic.fileSizeFlag = 1;
      }
      boolean bool;
      label229:
      Object localObject;
      if (paramawfl.jdField_a_of_type_Awfn != null)
      {
        bool = true;
        if (bool)
        {
          localMessageForPic.msgseq = paramawfl.jdField_a_of_type_Awfn.jdField_a_of_type_Long;
          localMessageForPic.shmsgseq = paramawfl.jdField_a_of_type_Awfn.jdField_b_of_type_Long;
          localMessageForPic.msgUid = paramawfl.jdField_a_of_type_Awfn.c;
        }
        localMessageForPic.localUUID = paramawfl.jdField_a_of_type_JavaLangString;
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!azls.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramawfl.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramawfl.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramawfl.jdField_f_of_type_Int;
        localObject = new File(paramawfl.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramawfl.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (basj.a(paramawfl.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramawfl.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramawfl.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramawfl.n;
        localMessageForPic.sync2Story = paramawfl.jdField_h_of_type_Boolean;
        String str = ayvj.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramawfl);
        localMessageForPic.imageType = bilx.a(paramawfl.jdField_g_of_type_JavaLangString);
        localObject = paramawfl.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramawfl, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramawfl.jdField_a_of_type_Long = localMessageForPic.uniseq;
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        awen.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramawfl.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramawfl.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramawfl.jdField_h_of_type_JavaLangString;
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
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), awga.a(i), j);
  }
  
  public ArrayList<awew> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    awen.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(awfz paramawfz)
  {
    if (paramawfz != null)
    {
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramawfz);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramawfz.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramawfz.c;
      localMessageForPic.groupFileID = paramawfz.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramawfz.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((alpw.a(paramMessageForPic)) || (alnp.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = baul.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (alnp.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bcuq.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      awen.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = baul.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, awfl paramawfl)
  {
    aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawfl.c, paramawfl.jdField_b_of_type_Int, paramawfl.o);
    if (paramawfl.jdField_b_of_type_Int == 0) {
      aoep.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawfl.c);
    }
    for (;;)
    {
      if (paramawfl.jdField_a_of_type_Int == 1036) {
        apds.a(paramMessageForPic);
      }
      if (paramawfl.jdField_a_of_type_Int == 1039) {
        alpw.a(paramMessageForPic, false);
      }
      if (paramawfl.jdField_a_of_type_Int == 1040) {
        alnp.a(paramMessageForPic, false);
      }
      if ((paramawfl.jdField_a_of_type_Int == 1044) || (paramawfl.jdField_a_of_type_Int == 1049)) {
        apfy.a(paramMessageForPic, paramawfl);
      }
      if (paramawfl.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramawfl.m);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramawfl.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramawfl.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramawfl.jdField_f_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramawfl.jdField_g_of_type_Long));
      }
      if (paramawfl.j) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramawfl.jdField_b_of_type_Int == 1) {
        aoep.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramawfl.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awdu
 * JD-Core Version:    0.7.0.1
 */