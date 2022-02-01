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

public class azpc
  extends azpg
{
  public azpc() {}
  
  public azpc(QQAppInterface paramQQAppInterface)
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
          String str2 = bleb.a(paramString);
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
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(azqt paramazqt, MessageForPic paramMessageForPic)
  {
    paramazqt = paramazqt.jdField_a_of_type_JavaUtilArrayList;
    int i = paramazqt.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramazqt.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramazqt.get(j)).intValue();
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
  
  public azqf a(Intent paramIntent)
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
      paramIntent = new azqf();
      azqu localazqu = new azqu();
      localazqu.d(1009);
      localazqu.a((String)localObject1);
      localazqu.c(str1);
      localazqu.c(beya.jdField_f_of_type_Int);
      localazqu.g((int)l3);
      localazqu.h((int)l4);
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localazqu.a((int)l5);
      localazqu.i(k);
      localazqu.j(n);
      localObject3 = beqz.a((String)localObject3);
      if (localObject3 != null) {
        localazqu.b(((File)localObject3).getAbsolutePath());
      }
      localazqu.e(i);
      localazqu.e(str5);
      localazqu.d(str6);
      localazqu.f(str4);
      localazqu.b(l1);
      localazqu.m(i1);
      paramIntent.jdField_a_of_type_Azqt = localazqu.a();
      paramIntent.jdField_a_of_type_Azqt.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Azqt.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Azqt;
        if (bmgb.a((String)localObject1)) {
          bhnn.a();
        }
        try
        {
          ((azqt)localObject2).jdField_a_of_type_JavaUtilArrayList = bmgb.a((String)localObject1);
          bhnn.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!bhmi.b((String)localObject1))
          {
            localObject1 = new azqe();
            ((azqe)localObject1).a(1009);
            ((azqe)localObject1).a(str1);
            ((azqe)localObject1).b(str2);
            ((azqe)localObject1).b(j);
            ((azqe)localObject1).c(str3);
            ((azqe)localObject1).a(l1);
            ((azqe)localObject1).d(str4);
            ((azqe)localObject1).c(m);
            paramIntent.jdField_a_of_type_Azqd = ((azqe)localObject1).a();
            paramIntent.jdField_a_of_type_Azqd.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Azqd.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Azqd.jdField_b_of_type_Long = l2;
          }
          azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Azqt.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + bhmi.a((String)localObject1));
            }
          }
        }
      }
    }
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public azqf a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bhka.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      azqf localazqf;
      if (i == 0)
      {
        i = 65537;
        Object localObject = beyq.a(paramMessageForPic, i).toString();
        localazqf = new azqf();
        localazqf.b = paramMessageForPic.isSendFromLocal();
        azqu localazqu = new azqu();
        localazqu.d(1009);
        localazqu.a(paramMessageForPic.path);
        localazqu.c(paramString3);
        localazqu.c(beya.jdField_f_of_type_Int);
        localazqu.g((int)paramMessageForPic.width);
        localazqu.h((int)paramMessageForPic.height);
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localazqu.a((int)paramMessageForPic.size);
        localazqu.i(paramMessageForPic.fileSizeFlag);
        localazqu.a(paramMessageForPic.thumbWidth);
        localazqu.b(paramMessageForPic.thumbHeight);
        localazqu.j(paramMessageForPic.imageType);
        localObject = beqz.a((String)localObject);
        if (localObject != null) {
          localazqu.b(((File)localObject).getAbsolutePath());
        }
        localazqu.e(paramInt);
        localazqu.e(paramString1);
        localazqu.d(paramString2);
        localazqu.f(paramMessageForPic.md5);
        localazqf.jdField_a_of_type_Azqt = localazqu.a();
        localazqf.jdField_a_of_type_Azqt.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localazqf.jdField_a_of_type_Azqt.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localazqf.jdField_a_of_type_Azqt;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bmgb.a(paramMessageForPic.path))) {
          bhnn.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bmgb.a(paramMessageForPic.path);
        bhnn.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!bhmi.b(paramMessageForPic.path)))
        {
          paramString1 = new azqe();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localazqf.jdField_a_of_type_Azqd = paramString1.a();
          localazqf.jdField_a_of_type_Azqd.jdField_e_of_type_JavaLangString = "chatimg";
          localazqf.jdField_a_of_type_Azqd.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localazqf.jdField_a_of_type_Azqd.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.b;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localazqf.jdField_a_of_type_Azqt.jdField_a_of_type_Azqv != null)
        {
          bool = true;
          azpw.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localazqf;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + bhmi.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public azqt a(Intent paramIntent)
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
      azqu localazqu = new azqu();
      localazqu.d((String)localObject2);
      localazqu.a(str3);
      localazqu.e(i);
      localazqu.e(str2);
      localazqu.d(k);
      localazqu.f(j);
      localazqu.l(n);
      localazqu.k(m);
      localazqu.a(bool1);
      localazqu.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new azqs();
        ((azqs)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((azqs)localObject2).b = str1;
        localazqu.a((azqs)localObject2);
      }
      localObject1 = localazqu.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((azqt)localObject1).p = i;
        ((azqt)localObject1).jdField_j_of_type_JavaLangString = str1;
        ((azqt)localObject1).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((azqt)localObject1).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((azqt)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(azqf paramazqf)
  {
    boolean bool = true;
    if ((paramazqf == null) || (!paramazqf.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    azqt localazqt = paramazqf.jdField_a_of_type_Azqt;
    bevt localbevt = new bevt();
    localbevt.c = localazqt.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazqt.c, localazqt.jdField_d_of_type_JavaLangString, localazqt.jdField_b_of_type_Int);
    localMessageForPic.path = localazqt.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localazqt.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localazqt.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (bews.a(localazqt.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localazqt.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramazqf.jdField_a_of_type_Azqt.l;
    paramazqf = paramazqf.jdField_a_of_type_Azqd;
    if (paramazqf != null)
    {
      if (paramazqf.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramazqf.jdField_f_of_type_JavaLangString;
      }
      if (paramazqf.jdField_a_of_type_Long != 0L) {
        localbevt.jdField_a_of_type_Long = paramazqf.jdField_a_of_type_Long;
      }
      if (paramazqf.c != null) {
        localbevt.jdField_a_of_type_JavaLangString = paramazqf.c;
      }
      if (paramazqf.jdField_b_of_type_Int != -1) {
        localbevt.jdField_a_of_type_Int = paramazqf.jdField_b_of_type_Int;
      }
      if (paramazqf.jdField_g_of_type_JavaLangString != null) {
        localbevt.b = paramazqf.jdField_g_of_type_JavaLangString;
      }
    }
    if (localazqt.q != -1)
    {
      paramazqf = new PicMessageExtraData();
      paramazqf.imageBizType = localazqt.q;
      localMessageForPic.picExtraData = paramazqf;
    }
    localMessageForPic.picExtraFlag = beya.jdField_f_of_type_Int;
    localMessageForPic.picExtraObject = localbevt;
    if (localazqt.jdField_a_of_type_Azqv != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localazqt.jdField_a_of_type_Azqv.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localazqt.jdField_a_of_type_Azqv.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localazqt.jdField_a_of_type_Azqv.c;
      }
      localMessageForPic.localUUID = localazqt.jdField_a_of_type_JavaLangString;
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bmgb.a(localazqt.jdField_g_of_type_JavaLangString);
      paramazqf = localazqt.jdField_a_of_type_JavaUtilArrayList;
      if ((paramazqf == null) || (paramazqf.isEmpty())) {
        break label760;
      }
      a(localazqt, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localazqt.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramazqf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (paramazqf != null) {
        paramazqf.a(localMessageForPic.frienduin + localMessageForPic.uniseq, new berp(paramazqf));
      }
      a(localMessageForPic);
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(azqt paramazqt)
  {
    long l = System.currentTimeMillis();
    if ((paramazqt != null) && (paramazqt.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = bcry.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazqt.c, paramazqt.jdField_d_of_type_JavaLangString, paramazqt.jdField_b_of_type_Int);
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
      label229:
      Object localObject;
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
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!bdku.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramazqt.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramazqt.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramazqt.jdField_f_of_type_Int;
        localObject = new File(paramazqt.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramazqt.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (bews.a(paramazqt.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramazqt.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramazqt.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramazqt.n;
        localMessageForPic.sync2Story = paramazqt.jdField_h_of_type_Boolean;
        String str = bcrn.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramazqt);
        localMessageForPic.imageType = bmgb.a(paramazqt.jdField_g_of_type_JavaLangString);
        localObject = paramazqt.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramazqt, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramazqt.jdField_a_of_type_Long = localMessageForPic.uniseq;
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramazqt.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramazqt.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramazqt.jdField_h_of_type_JavaLangString;
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
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), azrm.a(i), j);
  }
  
  public ArrayList<azqf> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a(azrh paramazrh)
  {
    if (paramazrh != null)
    {
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramazrh);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramazrh.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramazrh.c;
      localMessageForPic.groupFileID = paramazrh.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramazrh.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((anzr.a(paramMessageForPic)) || (anxg.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = beyq.a(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (anxg.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bhez.o);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      azpw.a(this.b, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = beyq.a(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, azqt paramazqt)
  {
    aqyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazqt.c, paramazqt.jdField_b_of_type_Int, paramazqt.o);
    if (paramazqt.jdField_b_of_type_Int == 0) {
      aqyt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazqt.c);
    }
    for (;;)
    {
      if (paramazqt.jdField_a_of_type_Int == 1036) {
        asam.a(paramMessageForPic);
      }
      if (paramazqt.jdField_a_of_type_Int == 1039) {
        anzr.a(paramMessageForPic, false);
      }
      if (paramazqt.jdField_a_of_type_Int == 1040) {
        anxg.a(paramMessageForPic, false);
      }
      if (paramazqt.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramazqt.jdField_j_of_type_JavaLangString);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramazqt.jdField_d_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramazqt.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramazqt.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramazqt.jdField_f_of_type_Long));
      }
      if (paramazqt.jdField_j_of_type_Boolean) {
        paramMessageForPic.isStoryPhoto = true;
      }
      return;
      if (paramazqt.jdField_b_of_type_Int == 1) {
        aqyt.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazqt.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpc
 * JD-Core Version:    0.7.0.1
 */