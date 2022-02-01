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

public class ayck
  extends ayco
{
  public ayck() {}
  
  public ayck(QQAppInterface paramQQAppInterface)
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
          String str2 = bjkf.a(paramString);
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
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "calcMD5", "md5:" + paramString + ",cost:" + (System.currentTimeMillis() - l));
    return paramString;
  }
  
  private void a(ayeb paramayeb, MessageForPic paramMessageForPic)
  {
    paramayeb = paramayeb.jdField_a_of_type_JavaUtilArrayList;
    int i = paramayeb.size();
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
        paramMessageForPic.mDownloadLength = ((Integer)paramayeb.get(i)).intValue();
        paramMessageForPic.mShowLength = ((Integer)paramayeb.get(j)).intValue();
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
  
  public aydn a(Intent paramIntent)
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
      paramIntent = new aydn();
      ayec localayec = new ayec();
      localayec.d(1009);
      localayec.a((String)localObject1);
      localayec.c(str1);
      localayec.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
      localayec.g((int)l3);
      localayec.h((int)l4);
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo(Intent obj)", "image_width = " + l3 + ",image_height = " + l4);
      localayec.a((int)l5);
      localayec.i(k);
      localayec.j(n);
      localObject3 = AbsDownloader.getFile((String)localObject3);
      if (localObject3 != null) {
        localayec.b(((File)localObject3).getAbsolutePath());
      }
      localayec.e(i);
      localayec.e(str5);
      localayec.d(str6);
      localayec.f(str4);
      localayec.b(l1);
      localayec.m(i1);
      paramIntent.jdField_a_of_type_Ayeb = localayec.a();
      paramIntent.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString = ((String)localObject2);
      if (k == 1) {
        paramIntent.jdField_a_of_type_Ayeb.jdField_e_of_type_JavaLangString = "chatraw";
      }
      for (;;)
      {
        localObject2 = paramIntent.jdField_a_of_type_Ayeb;
        if (bkkh.a((String)localObject1)) {
          bfwl.a();
        }
        try
        {
          ((ayeb)localObject2).jdField_a_of_type_JavaUtilArrayList = bkkh.a((String)localObject1);
          bfwl.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + (String)localObject1 + ")");
          if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
          {
            localObject1 = new aydm();
            ((aydm)localObject1).a(1009);
            ((aydm)localObject1).a(str1);
            ((aydm)localObject1).b(str2);
            ((aydm)localObject1).b(j);
            ((aydm)localObject1).c(str3);
            ((aydm)localObject1).a(l1);
            ((aydm)localObject1).d(str4);
            ((aydm)localObject1).c(m);
            paramIntent.jdField_a_of_type_Aydl = ((aydm)localObject1).a();
            paramIntent.jdField_a_of_type_Aydl.jdField_e_of_type_JavaLangString = "chatimg";
            paramIntent.jdField_a_of_type_Aydl.jdField_e_of_type_Int = k;
            paramIntent.jdField_a_of_type_Aydl.jdField_b_of_type_Long = l2;
          }
          ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "");
          return paramIntent;
          paramIntent.jdField_a_of_type_Ayeb.jdField_e_of_type_JavaLangString = "chatimg";
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
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public aydn a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((bfti.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      aydn localaydn;
      if (i == 0)
      {
        i = 65537;
        Object localObject = URLDrawableHelper.getURL(paramMessageForPic, i).toString();
        localaydn = new aydn();
        localaydn.jdField_b_of_type_Boolean = paramMessageForPic.isSendFromLocal();
        ayec localayec = new ayec();
        localayec.d(1009);
        localayec.a(paramMessageForPic.path);
        localayec.c(paramString3);
        localayec.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
        localayec.g((int)paramMessageForPic.width);
        localayec.h((int)paramMessageForPic.height);
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localayec.a((int)paramMessageForPic.size);
        localayec.i(paramMessageForPic.fileSizeFlag);
        localayec.a(paramMessageForPic.thumbWidth);
        localayec.b(paramMessageForPic.thumbHeight);
        localayec.j(paramMessageForPic.imageType);
        localObject = AbsDownloader.getFile((String)localObject);
        if (localObject != null) {
          localayec.b(((File)localObject).getAbsolutePath());
        }
        localayec.e(paramInt);
        localayec.e(paramString1);
        localayec.d(paramString2);
        localayec.f(paramMessageForPic.md5);
        localaydn.jdField_a_of_type_Ayeb = localayec.a();
        localaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        localaydn.jdField_a_of_type_Ayeb.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = localaydn.jdField_a_of_type_Ayeb;
        if ((paramString1.jdField_h_of_type_Int < 0) && (bkkh.a(paramMessageForPic.path))) {
          bfwl.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = bkkh.a(paramMessageForPic.path);
        bfwl.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)))
        {
          paramString1 = new aydm();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          localaydn.jdField_a_of_type_Aydl = paramString1.a();
          localaydn.jdField_a_of_type_Aydl.jdField_e_of_type_JavaLangString = "chatimg";
          localaydn.jdField_a_of_type_Aydl.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          localaydn.jdField_a_of_type_Aydl.jdField_b_of_type_Long = paramMessageForPic.groupFileID;
        }
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.jdField_b_of_type_JavaLangString;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (localaydn.jdField_a_of_type_Ayeb.jdField_a_of_type_Ayed != null)
        {
          bool = true;
          ayde.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localaydn;
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
  
  public ayeb a(Intent paramIntent)
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
      ayec localayec = new ayec();
      localayec.d((String)localObject2);
      localayec.a(str3);
      localayec.e(i);
      localayec.e(str2);
      localayec.d(k);
      localayec.f(j);
      localayec.l(n);
      localayec.k(m);
      localayec.a(bool1);
      localayec.b(bool2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new ayea();
        ((ayea)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((ayea)localObject2).jdField_b_of_type_JavaLangString = str1;
        localayec.a((ayea)localObject2);
      }
      localObject1 = localayec.a();
      i = paramIntent.getIntExtra("key_is_sync_qzone", 0);
      if (i == 1)
      {
        str1 = paramIntent.getStringExtra("key_qzone_album_id");
        ((ayeb)localObject1).p = i;
        ((ayeb)localObject1).jdField_j_of_type_JavaLangString = str1;
        ((ayeb)localObject1).jdField_d_of_type_Long = paramIntent.getLongExtra("key_qzone_batch_id", 0L);
        ((ayeb)localObject1).jdField_e_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_COUNT", 0);
        ((ayeb)localObject1).jdField_f_of_type_Long = paramIntent.getIntExtra("PhotoConst.PHOTO_SEND_PATH_INDEX", 0);
      }
      i = paramIntent.getIntExtra("key_pic_send_source", 0);
      if (((ayeb)localObject1).jdField_a_of_type_Ayea == null) {
        ((ayeb)localObject1).jdField_a_of_type_Ayea = new ayea();
      }
      ((ayeb)localObject1).jdField_a_of_type_Ayea.jdField_a_of_type_Int = i;
      ((ayeb)localObject1).jdField_a_of_type_Ayea.jdField_b_of_type_Boolean = bool3;
      ((ayeb)localObject1).jdField_a_of_type_Ayea.c = bool4;
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "");
      return localObject1;
    }
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createPicUploadInfo", "unknow obj");
    return null;
  }
  
  public MessageRecord a(aydn paramaydn)
  {
    boolean bool = true;
    if ((paramaydn == null) || (!paramaydn.jdField_a_of_type_Boolean)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ayeb localayeb = paramaydn.jdField_a_of_type_Ayeb;
    PicFowardDbRecordData localPicFowardDbRecordData = new PicFowardDbRecordData();
    localPicFowardDbRecordData.fowardThumbPath = localayeb.jdField_h_of_type_JavaLangString;
    MessageForPic localMessageForPic = bbli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localayeb.c, localayeb.jdField_d_of_type_JavaLangString, localayeb.jdField_b_of_type_Int);
    localMessageForPic.path = localayeb.jdField_g_of_type_JavaLangString;
    localMessageForPic.type = 1;
    Object localObject = new File(localayeb.jdField_g_of_type_JavaLangString);
    if (((File)localObject).exists())
    {
      if (GifDrawable.isGifFile((File)localObject)) {
        localMessageForPic.imageType = 2000;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      SafeBitmapFactory.decodeFile(localayeb.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
      localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
      if (RichMediaUtil.isPicLandscape(localayeb.jdField_g_of_type_JavaLangString))
      {
        localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
        localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
        if (QLog.isColorLevel()) {
          ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
        }
      }
      localMessageForPic.md5 = localayeb.jdField_f_of_type_JavaLangString;
    }
    localMessageForPic.fileSizeFlag = paramaydn.jdField_a_of_type_Ayeb.l;
    paramaydn = paramaydn.jdField_a_of_type_Aydl;
    if (paramaydn != null)
    {
      if (paramaydn.jdField_f_of_type_JavaLangString != null) {
        localMessageForPic.md5 = paramaydn.jdField_f_of_type_JavaLangString;
      }
      if (paramaydn.jdField_a_of_type_Long != 0L) {
        localPicFowardDbRecordData.fowardOrgId = paramaydn.jdField_a_of_type_Long;
      }
      if (paramaydn.c != null) {
        localPicFowardDbRecordData.fowardOrgUin = paramaydn.c;
      }
      if (paramaydn.jdField_b_of_type_Int != -1) {
        localPicFowardDbRecordData.fowardOrgUinType = paramaydn.jdField_b_of_type_Int;
      }
      if (paramaydn.jdField_g_of_type_JavaLangString != null) {
        localPicFowardDbRecordData.fowardOrgUrl = paramaydn.jdField_g_of_type_JavaLangString;
      }
    }
    if (localayeb.q != -1)
    {
      paramaydn = new PicMessageExtraData();
      paramaydn.imageBizType = localayeb.q;
      localMessageForPic.picExtraData = paramaydn;
    }
    localMessageForPic.picExtraFlag = TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO;
    localMessageForPic.picExtraObject = localPicFowardDbRecordData;
    if (localayeb.jdField_a_of_type_Ayed != null)
    {
      if (bool)
      {
        localMessageForPic.msgseq = localayeb.jdField_a_of_type_Ayed.jdField_a_of_type_Long;
        localMessageForPic.shmsgseq = localayeb.jdField_a_of_type_Ayed.jdField_b_of_type_Long;
        localMessageForPic.msgUid = localayeb.jdField_a_of_type_Ayed.c;
      }
      localMessageForPic.localUUID = localayeb.jdField_a_of_type_JavaLangString;
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
      localMessageForPic.imageType = bkkh.a(localayeb.jdField_g_of_type_JavaLangString);
      paramaydn = localayeb.jdField_a_of_type_JavaUtilArrayList;
      if ((paramaydn == null) || (paramaydn.isEmpty())) {
        break label760;
      }
      a(localayeb, localMessageForPic);
      localMessageForPic.imageType = 1003;
    }
    for (;;)
    {
      localMessageForPic.serial();
      localayeb.jdField_a_of_type_Long = localMessageForPic.uniseq;
      paramaydn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController();
      if (paramaydn != null) {
        paramaydn.addProcessor(localMessageForPic.frienduin + localMessageForPic.uniseq, new BaseTransProcessor(paramaydn));
      }
      a(localMessageForPic);
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "cost:" + (System.currentTimeMillis() - l));
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packForwardMsg", "retry:" + bool);
      return localMessageForPic;
      bool = false;
      break;
      label760:
      if (QLog.isColorLevel()) {
        QLog.d("peak_pgjpeg", 2, "Slice infos is null");
      }
    }
  }
  
  public MessageRecord a(ayeb paramayeb)
  {
    long l = System.currentTimeMillis();
    if ((paramayeb != null) && (paramayeb.jdField_g_of_type_JavaLangString != null))
    {
      MessageForPic localMessageForPic = bbli.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramayeb.c, paramayeb.jdField_d_of_type_JavaLangString, paramayeb.jdField_b_of_type_Int);
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
      label229:
      Object localObject;
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
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "bindUrlKeyAndUniseq", localMessageForPic.localUUID + "|" + localMessageForPic.uniseq);
        localMessageForPic.md5 = a(localMessageForPic.path);
        if (!bcdo.a()) {
          break label693;
        }
        localMessageForPic.bigThumbMsgUrl = paramayeb.jdField_h_of_type_JavaLangString;
        localMessageForPic.thumbWidth = paramayeb.jdField_e_of_type_Int;
        localMessageForPic.thumbHeight = paramayeb.jdField_f_of_type_Int;
        localObject = new File(paramayeb.jdField_g_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          if (GifDrawable.isGifFile((File)localObject)) {
            localMessageForPic.imageType = 3;
          }
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          ((BitmapFactory.Options)localObject).inSampleSize = 1;
          SafeBitmapFactory.decodeFile(paramayeb.jdField_g_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          localMessageForPic.width = ((BitmapFactory.Options)localObject).outWidth;
          localMessageForPic.height = ((BitmapFactory.Options)localObject).outHeight;
          if (RichMediaUtil.isPicLandscape(paramayeb.jdField_g_of_type_JavaLangString))
          {
            localMessageForPic.width = ((BitmapFactory.Options)localObject).outHeight;
            localMessageForPic.height = ((BitmapFactory.Options)localObject).outWidth;
            if (QLog.isColorLevel()) {
              ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + ((BitmapFactory.Options)localObject).outWidth + ",options.outHeight = " + ((BitmapFactory.Options)localObject).outHeight + ",mr.width = " + localMessageForPic.width + ",mr.height = " + localMessageForPic.height);
            }
          }
        }
        localMessageForPic.extLong = paramayeb.jdField_i_of_type_Int;
        localMessageForPic.extStr = paramayeb.jdField_i_of_type_JavaLangString;
        localMessageForPic.msgVia = paramayeb.n;
        localMessageForPic.sync2Story = paramayeb.jdField_h_of_type_Boolean;
        String str = bbkv.m;
        if (!localMessageForPic.sync2Story) {
          break label705;
        }
        localObject = "1";
        label507:
        localMessageForPic.saveExtInfoToExtStr(str, (String)localObject);
        a(localMessageForPic, paramayeb);
        localMessageForPic.imageType = bkkh.a(paramayeb.jdField_g_of_type_JavaLangString);
        localObject = paramayeb.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label713;
        }
        a(paramayeb, localMessageForPic);
        localMessageForPic.imageType = 1003;
      }
      for (;;)
      {
        localMessageForPic.serial();
        paramayeb.jdField_a_of_type_Long = localMessageForPic.uniseq;
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
        a(localMessageForPic);
        ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramayeb.jdField_b_of_type_Long);
        localMessageForPic.DSKey = paramayeb.jdField_b_of_type_Long;
        return localMessageForPic;
        bool = false;
        break;
        label693:
        localMessageForPic.thumbMsgUrl = paramayeb.jdField_h_of_type_JavaLangString;
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
    return new CompressInfo(paramIntent.getStringExtra("PhotoConst.PHOTO_SEND_PATH"), ayeu.a(i), j);
  }
  
  public ArrayList<aydn> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
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
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  protected void a(MessageForPic paramMessageForPic)
  {
    long l = System.currentTimeMillis();
    if ((amtr.a(paramMessageForPic)) || (amrp.a(paramMessageForPic)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseMemoryCache = false;
      localURLDrawableOptions.mLoadingDrawable = FlashPicItemBuilder.a(BaseApplicationImpl.getApplication().getResources());
      URLDrawable localURLDrawable = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, localURLDrawableOptions);
      if (amrp.a(paramMessageForPic)) {
        localURLDrawableOptions.isFlashPic = true;
      }
      localURLDrawable.setDecodeHandler(bfol.o);
      localURLDrawable.downloadImediatly();
    }
    for (;;)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "preload thumb", "cost:" + (System.currentTimeMillis() - l));
      return;
      paramMessageForPic = URLDrawableHelper.getDrawable(paramMessageForPic, 65537, null, null);
      paramMessageForPic.downloadImediatly();
      ThreadManagerV2.getUIHandlerV2().post(new AioPicOperator.1(this, paramMessageForPic));
    }
  }
  
  protected void a(MessageForPic paramMessageForPic, ayeb paramayeb)
  {
    apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayeb.c, paramayeb.jdField_b_of_type_Int, paramayeb.o);
    PicMessageExtraData localPicMessageExtraData1;
    if (paramayeb.jdField_b_of_type_Int == 0)
    {
      apse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayeb.c);
      if (paramayeb.jdField_a_of_type_Int == 1036) {
        aquj.a(paramMessageForPic);
      }
      if (paramayeb.jdField_a_of_type_Int == 1039) {
        amtr.a(paramMessageForPic, false);
      }
      if (paramayeb.jdField_a_of_type_Int == 1040) {
        amrp.a(paramMessageForPic, false);
      }
      if (paramayeb.p == 1)
      {
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_is_sync_qzone", String.valueOf(1));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_album_id", paramayeb.jdField_j_of_type_JavaLangString);
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_id", String.valueOf(paramayeb.jdField_d_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_is_raw", String.valueOf(paramayeb.jdField_g_of_type_Int));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_batch_count", String.valueOf(paramayeb.jdField_e_of_type_Long));
        paramMessageForPic.saveExtInfoToExtStr("msg_extra_key_qzone_photo_index", String.valueOf(paramayeb.jdField_f_of_type_Long));
      }
      if (paramayeb.jdField_j_of_type_Boolean) {
        paramMessageForPic.isStoryPhoto = true;
      }
      PicMessageExtraData localPicMessageExtraData2 = paramMessageForPic.picExtraData;
      localPicMessageExtraData1 = localPicMessageExtraData2;
      if (localPicMessageExtraData2 == null) {
        localPicMessageExtraData1 = new PicMessageExtraData();
      }
      if (!paramayeb.d()) {
        break label245;
      }
      localPicMessageExtraData1.imageBizType = 13;
    }
    for (;;)
    {
      paramMessageForPic.picExtraData = localPicMessageExtraData1;
      return;
      if (paramayeb.jdField_b_of_type_Int != 1) {
        break;
      }
      apse.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPic, paramayeb.c);
      break;
      label245:
      if (paramayeb.e()) {
        localPicMessageExtraData1.imageBizType = 2;
      }
    }
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForRichText))) {
      ((MessageForRichText)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void updateMsg(ayep paramayep)
  {
    if (paramayep != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "updateMsg", "resut:" + paramayep);
      MessageForPic localMessageForPic = (MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForPic.size = paramayep.jdField_a_of_type_Long;
      localMessageForPic.uuid = paramayep.c;
      localMessageForPic.groupFileID = paramayep.jdField_b_of_type_Long;
      localMessageForPic.md5 = paramayep.jdField_d_of_type_JavaLangString;
      localMessageForPic.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForPic.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayck
 * JD-Core Version:    0.7.0.1
 */