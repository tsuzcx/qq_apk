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

public class aywp
  extends aywt
{
  public aywp() {}
  
  public aywp(QQAppInterface paramQQAppInterface)
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
          String str2 = bkcx.a(paramString);
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
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(ayyg paramayyg, MessageForPic paramMessageForPic)
  {
    paramayyg = paramayyg.jdField_a_of_type_JavaUtilArrayList;
    int i = paramayyg.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramayyg.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramayyg.get(j)).intValue();
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
  
  public ayxr a(Intent paramIntent)
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
      paramIntent = new ayxr();
      ayyh localayyh = new ayyh();
      localayyh.d(1009);
      localayyh.a((String)localObject1);
      localayyh.c(str1);
      localayyh.c(bdzh.jdField_f_of_type_Int);
      localayyh.g((int)l3);
      localayyh.h((int)l4);
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localayyh.a((int)l5);
      localayyh.i(k);
      localayyh.j(n);
      localObject3 = bdsh.a((String)localObject3);
      if (localObject3 != null) {
        localayyh.b(((File)localObject3).getAbsolutePath());
      }
      localayyh.e(i);
      localayyh.e(str5);
      localayyh.d(str6);
      localayyh.f(str4);
      localayyh.b(l1);
      localayyh.m(i1);
      paramIntent.jdField_a_of_type_Ayyg = localayyh.a();
      paramIntent.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Ayyg.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Ayyg;
        if (bley.a((String)localObject1)) {
          bgnl.a();
        }
        try
        {
          ((ayyg)localObject2).jdField_a_of_type_JavaUtilArrayList = bley.a((String)localObject1);
          bgnl.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bgmg.b((String)localObject1))
          {
            localObject1 = new ayxq();
            ((ayxq)localObject1).a(1009);
            ((ayxq)localObject1).a(str1);
            ((ayxq)localObject1).b(str2);
            ((ayxq)localObject1).b(j);
            ((ayxq)localObject1).c(str3);
            ((ayxq)localObject1).a(l1);
            ((ayxq)localObject1).d(str4);
            ((ayxq)localObject1).c(m);
            paramIntent.jdField_a_of_type_Ayxp = ((ayxq)localObject1).a();
            paramIntent.jdField_a_of_type_Ayxp.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Ayxp.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Ayxp.jdField_b_of_type_Long = l2;
          }
          ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Ayyg.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bgmg.a((String)localObject1));
            }
          }
        }
      }
    }
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public ayxr a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bgjz.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      ayxr localayxr;
      if (i == 0)
      {
        i = 65537;
        Object localObject = bdzx.a(paramMessageForPic, i).toString();
        localayxr = new ayxr();
        localayxr.b = paramMessageForPic.isSendFromLocal();
        ayyh localayyh = new ayyh();
        localayyh.d(1009);
        localayyh.a(paramMessageForPic.path);
        localayyh.c(paramString3);
        localayyh.c(bdzh.jdField_f_of_type_Int);
        localayyh.g((int)paramMessageForPic.width);
        localayyh.h((int)paramMessageForPic.height);
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localayyh.a((int)paramMessageForPic.size);
        localayyh.i(paramMessageForPic.fileSizeFlag);
        localayyh.a(paramMessageForPic.thumbWidth);
        localayyh.b(paramMessageForPic.thumbHeight);
        localayyh.j(paramMessageForPic.imageType);
        localObject = bdsh.a((String)localObject);
        if (localObject != null) {
          localayyh.b(((File)localObject).getAbsolutePath());
        }
        localayyh.e(paramInt);
        localayyh.e(paramString1);
        localayyh.d(paramString2);
        localayyh.f(paramMessageForPic.md5);
        localayxr.jdField_a_of_type_Ayyg = localayyh.a();
        localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localayxr.jdField_a_of_type_Ayyg.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localayxr.jdField_a_of_type_Ayyg;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bley.a(paramMessageForPic.path))) {
          bgnl.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bley.a(paramMessageForPic.path);
        bgnl.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bgmg.b(paramMessageForPic.path)))
        {
          paramString1 = new ayxq();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localayxr.jdField_a_of_type_Ayxp = paramString1.a();
          localayxr.jdField_a_of_type_Ayxp.jdField_e_of_type_JavaLangString = "chatimg";
          localayxr.jdField_a_of_type_Ayxp.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localayxr.jdField_a_of_type_Ayxp.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localayxr.jdField_a_of_type_Ayyg.jdField_a_of_type_Ayyi != null)
        {
          bool = true;
          ayxi.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localayxr;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bgmg.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public ayyg a(Intent paramIntent)
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
      ayyh localayyh = new ayyh();
      localayyh.d((String)localObject2);
      localayyh.a(str3);
      localayyh.e(i);
      localayyh.e(str2);
      localayyh.d(k);
      localayyh.f(j);
      localayyh.l(n);
      localayyh.k(m);
      localayyh.a(bool1);
      localayyh.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new ayyf();
        ((ayyf)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((ayyf)localObject2).b = str1;
        localayyh.a((ayyf)localObject2);
      }
      localObject1 = localayyh.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((ayyg)localObject1).p = i;
        ((ayyg)localObject1).jdField_j_of_type_JavaLangString = str1;
        ((ayyg)localObject1).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((ayyg)localObject1).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((ayyg)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(ayxr paramayxr)
  {
    boolean bool = true;
    if ((paramayxr == null) || (!paramayxr.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ayyg localayyg = paramayxr.jdField_a_of_type_Ayyg;
    bdxa localbdxa = new bdxa();
    localbdxa.c = localayyg.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayyg.c, localayyg.jdField_d_of_type_JavaLangString, localayyg.jdField_b_of_type_Int);
    localMessageForPic.path = localayyg.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localayyg.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localayyg.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (bdxz.a(localayyg.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localayyg.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramayxr.jdField_a_of_type_Ayyg.l;
    paramayxr = paramayxr.jdField_a_of_type_Ayxp;
    if (paramayxr != null)
    {
      if (paramayxr.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramayxr.jdField_f_of_type_JavaLangString;
      }
      if (paramayxr.jdField_a_of_type_Long != 0L) {
        localbdxa.jdField_a_of_type_Long = paramayxr.jdField_a_of_type_Long;
      }
      if (paramayxr.c != null) {
        localbdxa.jdField_a_of_type_JavaLangString = paramayxr.c;
      }
      if (paramayxr.jdField_b_of_type_Int != -1) {
        localbdxa.jdField_a_of_type_Int = paramayxr.jdField_b_of_type_Int;
      }
      if (paramayxr.jdField_g_of_type_JavaLangString != null) {
        localbdxa.b = paramayxr.jdField_g_of_type_JavaLangString;
      }
    }
    if (localayyg.q != -1)
    {
      paramayxr = new PicMessageExtraData();
      paramayxr.imageBizType = localayyg.q;
      localMessageForPic.picExtraData = paramayxr;
    }
    localMessageForPic.picExtraFlag = bdzh.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localbdxa;
    if (localayyg.jdField_a_of_type_Ayyi != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localayyg.jdField_a_of_type_Ayyi.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localayyg.jdField_a_of_type_Ayyi.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localayyg.jdField_a_of_type_Ayyi.c;
      }
      localMessageForPic.localUUID = localayyg.jdField_a_of_type_JavaLangString;
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bley.a(localayyg.jdField_g_of_type_JavaLangString);
      paramayxr = localayyg.jdField_a_of_type_JavaUtilArrayList;
      if ((paramayxr == null) || (paramayxr.isEmpty())) {
        break label760;
      }
      a(localayyg, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localayyg.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramayxr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramayxr != null) {
        paramayxr.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new bdsx(paramayxr));
      }
      a(localMessageForPic);
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(ayyg paramayyg)
  {
    long l = System.currentTimeMillis();
    if ((paramayyg != null) && (paramayyg.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = bbzh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayyg.c, paramayyg.jdField_d_of_type_JavaLangString, paramayyg.jdField_b_of_type_Int);
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!bcsc.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramayyg.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramayyg.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramayyg.jdField_f_of_type_Int;
        localObject = new File(paramayyg.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramayyg.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (bdxz.a(paramayyg.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramayyg.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramayyg.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramayyg.n;
        localMessageForPic.sync2Story = paramayyg.jdField_h_of_type_Boolean;
        String str = bbyw.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramayyg);
        localMessageForPic.imageType = bley.a(paramayyg.jdField_g_of_type_JavaLangString);
        localObject = paramayyg.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramayyg, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramayyg.jdField_a_of_type_Long = localMessageForPic.uniseq;
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramayyg.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramayyg.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramayyg.jdField_h_of_type_JavaLangString;
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
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), ayyz.a(i), j);
  }
  
  public ArrayList<ayxr> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(ayyu paramayyu)
  {
    if (paramayyu != null)
    {
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramayyu);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramayyu.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramayyu.c;
      localMessageForPic.groupFileID = paramayyu.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramayyu.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((annq.a(paramMessageForPic)) || (anlk.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = bdzx.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (anlk.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bgey.o);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      ayxi.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = bdzx.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, ayyg paramayyg)
  {
    aqjq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayyg.c, paramayyg.jdField_b_of_type_Int, paramayyg.o);
    if (paramayyg.jdField_b_of_type_Int == 0) {
      aqjq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayyg.c);
    }
    for (;;)
    {
      if (paramayyg.jdField_a_of_type_Int == 1036) {
        arkw.a(paramMessageForPic);
      }
      if (paramayyg.jdField_a_of_type_Int == 1039) {
        annq.a(paramMessageForPic, false);
      }
      if (paramayyg.jdField_a_of_type_Int == 1040) {
        anlk.a(paramMessageForPic, false);
      }
      if (paramayyg.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramayyg.jdField_j_of_type_JavaLangString);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramayyg.jdField_d_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramayyg.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramayyg.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramayyg.jdField_f_of_type_Long));
      }
      if (paramayyg.jdField_j_of_type_Boolean) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramayyg.jdField_b_of_type_Int == 1) {
        aqjq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayyg.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywp
 * JD-Core Version:    0.7.0.1
 */