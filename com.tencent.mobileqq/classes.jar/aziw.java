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
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.RichText;

public class aziw
  extends azja
{
  public aziw() {}
  
  public aziw(QQAppInterface paramQQAppInterface)
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
          String str2 = bkvq.a(paramString);
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
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(azkn paramazkn, MessageForPic paramMessageForPic)
  {
    paramazkn = paramazkn.jdField_a_of_type_JavaUtilArrayList;
    int i = paramazkn.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramazkn.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramazkn.get(j)).intValue();
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
  
  public azjz a(Intent paramIntent)
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
      paramIntent = new azjz();
      azko localazko = new azko();
      localazko.d(1009);
      localazko.a((String)localObject1);
      localazko.c(str1);
      localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
      localazko.g((int)l3);
      localazko.h((int)l4);
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localazko.a((int)l5);
      localazko.i(k);
      localazko.j(n);
      localObject3 = AbsDownloader.getFile((String)localObject3);
      if (localObject3 != null) {
        localazko.b(((File)localObject3).getAbsolutePath());
      }
      localazko.e(i);
      localazko.e(str5);
      localazko.d(str6);
      localazko.f(str4);
      localazko.b(l1);
      localazko.m(i1);
      paramIntent.jdField_a_of_type_Azkn = localazko.a();
      paramIntent.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Azkn.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Azkn;
        if (blvp.a((String)localObject1)) {
          bhfd.a();
        }
        try
        {
          ((azkn)localObject2).jdField_a_of_type_JavaUtilArrayList = blvp.a((String)localObject1);
          bhfd.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
          {
            localObject1 = new azjy();
            ((azjy)localObject1).a(1009);
            ((azjy)localObject1).a(str1);
            ((azjy)localObject1).b(str2);
            ((azjy)localObject1).b(j);
            ((azjy)localObject1).c(str3);
            ((azjy)localObject1).a(l1);
            ((azjy)localObject1).d(str4);
            ((azjy)localObject1).c(m);
            paramIntent.jdField_a_of_type_Azjx = ((azjy)localObject1).a();
            paramIntent.jdField_a_of_type_Azjx.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Azjx.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Azjx.jdField_b_of_type_Long = l2;
          }
          azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Azkn.jdField_e_of_type_JavaLangString = "chatimg";
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + (String)localObject1 + "'s size is " + FileUtils.getFileSizes((String)localObject1));
            }
          }
        }
      }
    }
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public azjz a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bhca.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      azjz localazjz;
      if (i == 0)
      {
        i = 65537;
        Object localObject = URLDrawableHelper.getURL(paramMessageForPic, i).toString();
        localazjz = new azjz();
        localazjz.jdField_b_of_type_Boolean = paramMessageForPic.isSendFromLocal();
        azko localazko = new azko();
        localazko.d(1009);
        localazko.a(paramMessageForPic.path);
        localazko.c(paramString3);
        localazko.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
        localazko.g((int)paramMessageForPic.width);
        localazko.h((int)paramMessageForPic.height);
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localazko.a((int)paramMessageForPic.size);
        localazko.i(paramMessageForPic.fileSizeFlag);
        localazko.a(paramMessageForPic.thumbWidth);
        localazko.b(paramMessageForPic.thumbHeight);
        localazko.j(paramMessageForPic.imageType);
        localObject = AbsDownloader.getFile((String)localObject);
        if (localObject != null) {
          localazko.b(((File)localObject).getAbsolutePath());
        }
        localazko.e(paramInt);
        localazko.e(paramString1);
        localazko.d(paramString2);
        localazko.f(paramMessageForPic.md5);
        localazjz.jdField_a_of_type_Azkn = localazko.a();
        localazjz.jdField_a_of_type_Azkn.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localazjz.jdField_a_of_type_Azkn.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localazjz.jdField_a_of_type_Azkn;
        if ((paramString1.jdField_h_of_type_Int < 0) && (blvp.a(paramMessageForPic.path))) {
          bhfd.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = blvp.a(paramMessageForPic.path);
        bhfd.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)))
        {
          paramString1 = new azjy();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localazjz.jdField_a_of_type_Azjx = paramString1.a();
          localazjz.jdField_a_of_type_Azjx.jdField_e_of_type_JavaLangString = "chatimg";
          localazjz.jdField_a_of_type_Azjx.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localazjz.jdField_a_of_type_Azjx.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.jdField_b_of_type_JavaLangString;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localazjz.jdField_a_of_type_Azkn.jdField_a_of_type_Azkp != null)
        {
          bool = true;
          azjq.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localazjz;
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
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + FileUtils.getFileSizes(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public azkn a(Intent paramIntent)
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
      boolean bool3 = paramIntent.getBooleanExtra("quick_send_is_emo_search", false);
      boolean bool4 = paramIntent.getBooleanExtra("HOT_PIC_SEND_PIC", false);
      azko localazko = new azko();
      localazko.d((String)localObject2);
      localazko.a(str3);
      localazko.e(i);
      localazko.e(str2);
      localazko.d(k);
      localazko.f(j);
      localazko.l(n);
      localazko.k(m);
      localazko.a(bool1);
      localazko.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new azkm();
        ((azkm)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((azkm)localObject2).jdField_b_of_type_JavaLangString = str1;
        localazko.a((azkm)localObject2);
      }
      localObject1 = localazko.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((azkn)localObject1).p = i;
        ((azkn)localObject1).jdField_j_of_type_JavaLangString = str1;
        ((azkn)localObject1).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((azkn)localObject1).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((azkn)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      i = paramIntent.getIntExtra("key_pic_send_source", 0);
      if (((azkn)localObject1).jdField_a_of_type_Azkm == null) {
        ((azkn)localObject1).jdField_a_of_type_Azkm = new azkm();
      }
      ((azkn)localObject1).jdField_a_of_type_Azkm.jdField_a_of_type_Int = i;
      ((azkn)localObject1).jdField_a_of_type_Azkm.jdField_b_of_type_Boolean = bool3;
      ((azkn)localObject1).jdField_a_of_type_Azkm.c = bool4;
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(azjz paramazjz)
  {
    boolean bool = true;
    if ((paramazjz == null) || (!paramazjz.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    azkn localazkn = paramazjz.jdField_a_of_type_Azkn;
    PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
    localPicFowardDbRecordData.fowardThumbPath = localazkn.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localazkn.c, localazkn.jdField_d_of_type_JavaLangString, localazkn.jdField_b_of_type_Int);
    localMessageForPic.path = localazkn.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localazkn.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localazkn.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(localazkn.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localazkn.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramazjz.jdField_a_of_type_Azkn.l;
    paramazjz = paramazjz.jdField_a_of_type_Azjx;
    if (paramazjz != null)
    {
      if (paramazjz.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramazjz.jdField_f_of_type_JavaLangString;
      }
      if (paramazjz.jdField_a_of_type_Long != 0L) {
        localPicFowardDbRecordData.fowardOrgId = paramazjz.jdField_a_of_type_Long;
      }
      if (paramazjz.c != null) {
        localPicFowardDbRecordData.fowardOrgUin = paramazjz.c;
      }
      if (paramazjz.jdField_b_of_type_Int != -1) {
        localPicFowardDbRecordData.fowardOrgUinType = paramazjz.jdField_b_of_type_Int;
      }
      if (paramazjz.jdField_g_of_type_JavaLangString != null) {
        localPicFowardDbRecordData.fowardOrgUrl = paramazjz.jdField_g_of_type_JavaLangString;
      }
    }
    if (localazkn.q != -1)
    {
      paramazjz = new PicMessageExtraData();
      paramazjz.imageBizType = localazkn.q;
      localMessageForPic.picExtraData = paramazjz;
    }
    localMessageForPic.picExtraFlag = TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO;
    localMessageForPic.picExtraObject = localPicFowardDbRecordData;
    if (localazkn.jdField_a_of_type_Azkp != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localazkn.jdField_a_of_type_Azkp.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localazkn.jdField_a_of_type_Azkp.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localazkn.jdField_a_of_type_Azkp.c;
      }
      localMessageForPic.localUUID = localazkn.jdField_a_of_type_JavaLangString;
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = blvp.a(localazkn.jdField_g_of_type_JavaLangString);
      paramazjz = localazkn.jdField_a_of_type_JavaUtilArrayList;
      if ((paramazjz == null) || (paramazjz.isEmpty())) {
        break label760;
      }
      a(localazkn, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localazkn.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramazjz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      if (paramazjz != null) {
        paramazjz.addProcessor(localMessageForPic.frienduin + localMessageForPic.uniseq, new BaseTransProcessor(paramazjz));
      }
      a(localMessageForPic);
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(azkn paramazkn)
  {
    long l = System.currentTimeMillis();
    if ((paramazkn != null) && (paramazkn.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazkn.c, paramazkn.jdField_d_of_type_JavaLangString, paramazkn.jdField_b_of_type_Int);
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
      label229:
      Object localObject;
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
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!bdkj.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramazkn.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramazkn.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramazkn.jdField_f_of_type_Int;
        localObject = new File(paramazkn.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramazkn.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (RichMediaUtil.isPicLandscape(paramazkn.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramazkn.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramazkn.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramazkn.n;
        localMessageForPic.sync2Story = paramazkn.jdField_h_of_type_Boolean;
        String str = bcrn.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramazkn);
        localMessageForPic.imageType = blvp.a(paramazkn.jdField_g_of_type_JavaLangString);
        localObject = paramazkn.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramazkn, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramazkn.jdField_a_of_type_Long = localMessageForPic.uniseq;
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramazkn.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramazkn.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramazkn.jdField_h_of_type_JavaLangString;
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
  
  public CompressInfo a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    int j = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), azlg.a(i), j);
  }
  
  public ArrayList<azjz> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((anwf.a(paramMessageForPic)) || (anud.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (anud.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bgxc.o);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, azkn paramazkn)
  {
    aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazkn.c, paramazkn.jdField_b_of_type_Int, paramazkn.o);
    PicMessageExtraData localPicMessageExtraData1;
    if (paramazkn.jdField_b_of_type_Int == 0)
    {
      aqvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazkn.c);
      if (paramazkn.jdField_a_of_type_Int == 1036) {
        arxx.a(paramMessageForPic);
      }
      if (paramazkn.jdField_a_of_type_Int == 1039) {
        anwf.a(paramMessageForPic, false);
      }
      if (paramazkn.jdField_a_of_type_Int == 1040) {
        anud.a(paramMessageForPic, false);
      }
      if (paramazkn.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramazkn.jdField_j_of_type_JavaLangString);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramazkn.jdField_d_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramazkn.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramazkn.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramazkn.jdField_f_of_type_Long));
      }
      if (paramazkn.jdField_j_of_type_Boolean) {
        paramMessageForPic.isStoryPhoto = true;
      }
      PicMessageExtraData localPicMessageExtraData2 = paramMessageForPic.picExtraData;
      localPicMessageExtraData1 = localPicMessageExtraData2;
      if (localPicMessageExtraData2 == null) {
        localPicMessageExtraData1 = new PicMessageExtraData();
      }
      if (!paramazkn.d()) {
        break label245;
      }
      localPicMessageExtraData1.imageBizType = 13;
    }
    for (;;)
    {
      paramMessageForPic.picExtraData = localPicMessageExtraData1;
      return;
      if (paramazkn.jdField_b_of_type_Int != 1) {
        break;
      }
      aqvh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramazkn.c);
      break;
      label245:
      if (paramazkn.e()) {
        localPicMessageExtraData1.imageBizType = 2;
      }
    }
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void updateMsg(azlb paramazlb)
  {
    if (paramazlb != null)
    {
      azjq.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramazlb);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramazlb.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramazlb.c;
      localMessageForPic.groupFileID = paramazlb.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramazlb.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aziw
 * JD-Core Version:    0.7.0.1
 */