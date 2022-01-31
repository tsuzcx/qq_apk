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

public class aton
  extends ator
{
  public aton() {}
  
  public aton(QQAppInterface paramQQAppInterface)
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
          String str2 = bech.a(paramString);
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
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(atqd paramatqd, MessageForPic paramMessageForPic)
  {
    paramatqd = paramatqd.jdField_a_of_type_JavaUtilArrayList;
    int i = paramatqd.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramatqd.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramatqd.get(j)).intValue();
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
  
  public atpp a(Intent paramIntent)
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
      paramIntent = new atpp();
      atqe localatqe = new atqe();
      localatqe.d(1009);
      localatqe.a((String)localObject1);
      localatqe.c(str1);
      localatqe.c(axvn.jdField_f_of_type_Int);
      localatqe.g((int)l3);
      localatqe.h((int)l4);
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localatqe.a((int)l5);
      localatqe.i(k);
      localatqe.j(n);
      localObject3 = axoa.a((String)localObject3);
      if (localObject3 != null) {
        localatqe.b(((File)localObject3).getAbsolutePath());
      }
      localatqe.e(i);
      localatqe.e(str5);
      localatqe.d(str6);
      localatqe.f(str4);
      localatqe.b(l1);
      localatqe.m(i1);
      paramIntent.jdField_a_of_type_Atqd = localatqe.a();
      paramIntent.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Atqd.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Atqd;
        if (bfcq.a((String)localObject1)) {
          badi.a();
        }
        try
        {
          ((atqd)localObject2).jdField_a_of_type_JavaUtilArrayList = bfcq.a((String)localObject1);
          badi.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bace.b((String)localObject1))
          {
            localObject1 = new atpo();
            ((atpo)localObject1).a(1009);
            ((atpo)localObject1).a(str1);
            ((atpo)localObject1).b(str2);
            ((atpo)localObject1).b(j);
            ((atpo)localObject1).c(str3);
            ((atpo)localObject1).a(l1);
            ((atpo)localObject1).d(str4);
            ((atpo)localObject1).c(m);
            paramIntent.jdField_a_of_type_Atpn = ((atpo)localObject1).a();
            paramIntent.jdField_a_of_type_Atpn.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Atpn.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Atpn.jdField_b_of_type_Long = l2;
          }
          atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Atqd.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bace.a((String)localObject1));
            }
          }
        }
      }
    }
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public atpp a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((baac.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      atpp localatpp;
      if (i == 0)
      {
        i = 65537;
        Object localObject = axwd.a(paramMessageForPic, i).toString();
        localatpp = new atpp();
        localatpp.b = paramMessageForPic.isSendFromLocal();
        atqe localatqe = new atqe();
        localatqe.d(1009);
        localatqe.a(paramMessageForPic.path);
        localatqe.c(paramString3);
        localatqe.c(axvn.jdField_f_of_type_Int);
        localatqe.g((int)paramMessageForPic.width);
        localatqe.h((int)paramMessageForPic.height);
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localatqe.a((int)paramMessageForPic.size);
        localatqe.i(paramMessageForPic.fileSizeFlag);
        localatqe.a(paramMessageForPic.thumbWidth);
        localatqe.b(paramMessageForPic.thumbHeight);
        localatqe.j(paramMessageForPic.imageType);
        localObject = axoa.a((String)localObject);
        if (localObject != null) {
          localatqe.b(((File)localObject).getAbsolutePath());
        }
        localatqe.e(paramInt);
        localatqe.e(paramString1);
        localatqe.d(paramString2);
        localatqe.f(paramMessageForPic.md5);
        localatpp.jdField_a_of_type_Atqd = localatqe.a();
        localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localatpp.jdField_a_of_type_Atqd.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localatpp.jdField_a_of_type_Atqd;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bfcq.a(paramMessageForPic.path))) {
          badi.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bfcq.a(paramMessageForPic.path);
        badi.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bace.b(paramMessageForPic.path)))
        {
          paramString1 = new atpo();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localatpp.jdField_a_of_type_Atpn = paramString1.a();
          localatpp.jdField_a_of_type_Atpn.jdField_e_of_type_JavaLangString = "chatimg";
          localatpp.jdField_a_of_type_Atpn.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localatpp.jdField_a_of_type_Atpn.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localatpp.jdField_a_of_type_Atqd.jdField_a_of_type_Atqf != null)
        {
          bool = true;
          atpg.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localatpp;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bace.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public atqd a(Intent paramIntent)
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
      atqe localatqe = new atqe();
      localatqe.d((String)localObject);
      localatqe.a(str2);
      localatqe.e(i);
      localatqe.e(str1);
      localatqe.d(k);
      localatqe.f(j);
      localatqe.l(n);
      localatqe.k(m);
      localatqe.a(bool1);
      localatqe.b(bool2);
      localatqe.g(str3);
      localObject = localatqe.a();
      amye.a(paramIntent, (atqd)localObject);
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((atqd)localObject).p = i;
        ((atqd)localObject).m = str1;
        ((atqd)localObject).jdField_e_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((atqd)localObject).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((atqd)localObject).jdField_g_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject;
    }
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(atpp paramatpp)
  {
    boolean bool = true;
    if ((paramatpp == null) || (!paramatpp.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    atqd localatqd = paramatpp.jdField_a_of_type_Atqd;
    axsx localaxsx = new axsx();
    localaxsx.c = localatqd.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = awbi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localatqd.c, localatqd.d, localatqd.jdField_b_of_type_Int);
    localMessageForPic.path = localatqd.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localatqd.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localatqd.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (axub.a(localatqd.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localatqd.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramatpp.jdField_a_of_type_Atqd.l;
    paramatpp = paramatpp.jdField_a_of_type_Atpn;
    if (paramatpp != null)
    {
      if (paramatpp.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramatpp.jdField_f_of_type_JavaLangString;
      }
      if (paramatpp.jdField_a_of_type_Long != 0L) {
        localaxsx.jdField_a_of_type_Long = paramatpp.jdField_a_of_type_Long;
      }
      if (paramatpp.c != null) {
        localaxsx.jdField_a_of_type_JavaLangString = paramatpp.c;
      }
      if (paramatpp.jdField_b_of_type_Int != -1) {
        localaxsx.jdField_a_of_type_Int = paramatpp.jdField_b_of_type_Int;
      }
      if (paramatpp.jdField_g_of_type_JavaLangString != null) {
        localaxsx.b = paramatpp.jdField_g_of_type_JavaLangString;
      }
    }
    if (localatqd.q != -1)
    {
      paramatpp = new PicMessageExtraData();
      paramatpp.imageBizType = localatqd.q;
      localMessageForPic.picExtraData = paramatpp;
    }
    localMessageForPic.picExtraFlag = axvn.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localaxsx;
    if (localatqd.jdField_a_of_type_Atqf != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localatqd.jdField_a_of_type_Atqf.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localatqd.jdField_a_of_type_Atqf.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localatqd.jdField_a_of_type_Atqf.c;
      }
      localMessageForPic.localUUID = localatqd.jdField_a_of_type_JavaLangString;
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bfcq.a(localatqd.jdField_g_of_type_JavaLangString);
      paramatpp = localatqd.jdField_a_of_type_JavaUtilArrayList;
      if ((paramatpp == null) || (paramatpp.isEmpty())) {
        break label760;
      }
      a(localatqd, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localatqd.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramatpp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramatpp != null) {
        paramatpp.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new axou(paramatpp));
      }
      a(localMessageForPic);
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(atqd paramatqd)
  {
    long l = System.currentTimeMillis();
    if ((paramatqd != null) && (paramatqd.jdField_g_of_type_JavaLangString != null))
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!awqg.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramatqd.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramatqd.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramatqd.jdField_f_of_type_Int;
        localObject = new File(paramatqd.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramatqd.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (axub.a(paramatqd.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramatqd.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramatqd.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramatqd.n;
        localMessageForPic.sync2Story = paramatqd.jdField_h_of_type_Boolean;
        String str = awav.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramatqd);
        localMessageForPic.imageType = bfcq.a(paramatqd.jdField_g_of_type_JavaLangString);
        localObject = paramatqd.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramatqd, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramatqd.jdField_a_of_type_Long = localMessageForPic.uniseq;
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramatqd.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramatqd.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramatqd.jdField_h_of_type_JavaLangString;
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
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), atqs.a(i), j);
  }
  
  public ArrayList<atpp> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(atqr paramatqr)
  {
    if (paramatqr != null)
    {
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramatqr);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramatqr.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramatqr.c;
      localMessageForPic.groupFileID = paramatqr.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramatqr.d;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((ajke.a(paramMessageForPic)) || (ajhz.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = axwd.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (ajhz.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(azue.n);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      atpg.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = axwd.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, atqd paramatqd)
  {
    alyc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramatqd.c, paramatqd.jdField_b_of_type_Int, paramatqd.o);
    if (paramatqd.jdField_b_of_type_Int == 0) {
      alyc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramatqd.c);
    }
    for (;;)
    {
      if (paramatqd.jdField_a_of_type_Int == 1036) {
        amvy.a(paramMessageForPic);
      }
      if (paramatqd.jdField_a_of_type_Int == 1039) {
        ajke.a(paramMessageForPic, false);
      }
      if (paramatqd.jdField_a_of_type_Int == 1040) {
        ajhz.a(paramMessageForPic, false);
      }
      if ((paramatqd.jdField_a_of_type_Int == 1044) || (paramatqd.jdField_a_of_type_Int == 1049)) {
        amye.a(paramMessageForPic, paramatqd);
      }
      if (paramatqd.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramatqd.m);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramatqd.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramatqd.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramatqd.jdField_f_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramatqd.jdField_g_of_type_Long));
      }
      if (paramatqd.j) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramatqd.jdField_b_of_type_Int == 1) {
        alyc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramatqd.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aton
 * JD-Core Version:    0.7.0.1
 */