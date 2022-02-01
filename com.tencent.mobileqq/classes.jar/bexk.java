import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.1;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.2;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.3;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.7;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class bexk
  extends berm
{
  private int A;
  protected int a;
  protected long a;
  aocj jdField_a_of_type_Aocj = new bexn(this);
  protected aohl a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  protected int b;
  public boolean b;
  protected int c;
  berr jdField_e_of_type_Berr = new berr();
  private byte[] jdField_e_of_type_ArrayOfByte;
  private byte[] f;
  public boolean g;
  private volatile boolean h;
  private boolean i;
  int x = -1;
  private int y = 1;
  private int z;
  
  public bexk(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {}
    for (this.x = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; this.x = 0)
    {
      if (!this.jdField_a_of_type_Beyg.jdField_j_of_type_Boolean)
      {
        parambeyb = this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString;
        parambeyg = parambeyb.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == parambeyg.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + parambeyb);
        }
        b(9304, "path =" + parambeyb);
        d();
        this.jdField_q_of_type_Boolean = true;
      }
      return;
    }
    this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString = parambeyg[0];
    this.jdField_a_of_type_JavaLangString = parambeyg[1];
    this.jdField_c_of_type_Int = Integer.parseInt(parambeyg[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.jdField_c_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(parambeyg[3]);
  }
  
  private int a(String paramString)
  {
    int j = -1;
    if ("avi".equals(paramString)) {
      j = 2;
    }
    do
    {
      return j;
      if ("mp4".equals(paramString)) {
        return 3;
      }
      if ("wmv".equals(paramString)) {
        return 4;
      }
      if ("mkv".equals(paramString)) {
        return 5;
      }
      if ("rmvb".equals(paramString)) {
        return 6;
      }
      if ("rm".equals(paramString)) {
        return 7;
      }
      if ("afs".equals(paramString)) {
        return 8;
      }
      if ("mov".equals(paramString)) {
        return 9;
      }
      if ("mod".equals(paramString)) {
        return 10;
      }
      if ("ts".equals(paramString)) {
        return 1;
      }
    } while (!"mts".equals(paramString));
    return 11;
  }
  
  private bfbi a()
  {
    bfbi localbfbi = new bfbi();
    localbfbi.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbfbi.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    String str;
    int j;
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localbfbi.jdField_d_of_type_JavaLangString = str;
        localbfbi.jdField_k_of_type_Int = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label450;
        }
        j = ((MessageForBlessPTV)localObject).uinList.size();
        label121:
        localbfbi.l = j;
        label127:
        localbfbi.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
        localbfbi.i = 0;
        if ((localbfbi.f != 0) && (1008 != localbfbi.f)) {
          break label535;
        }
        localbfbi.jdField_b_of_type_JavaLangString = null;
        label170:
        if (localbfbi.f != 0) {
          break label550;
        }
        localbfbi.jdField_a_of_type_Int = 0;
        label184:
        localbfbi.jdField_b_of_type_Int = 2;
        localObject = new File(this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString);
        str = ((File)localObject).getName();
        localbfbi.jdField_a_of_type_JavaLangString = str;
        localbfbi.jdField_a_of_type_Long = ((File)localObject).length();
        localbfbi.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        localbfbi.jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localbfbi.jdField_e_of_type_Int = this.jdField_a_of_type_Int;
        localbfbi.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
        localbfbi.h = this.jdField_c_of_type_Int;
        localbfbi.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
        localObject = this.jdField_a_of_type_Bete;
        long l = localbfbi.jdField_a_of_type_Long + this.jdField_a_of_type_Long;
        this.jdField_q_of_type_Long = l;
        ((bete)localObject).jdField_a_of_type_Long = l;
        j = a(str.substring(str.lastIndexOf(".") + 1));
        localbfbi.g = j;
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(j));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
        if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))) {
          break label597;
        }
      }
    }
    label450:
    label597:
    for (localbfbi.j = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;; localbfbi.j = 0)
    {
      this.x = localbfbi.j;
      return localbfbi;
      str = "0";
      break;
      j = 1;
      break label121;
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).CheckIsHotVideo()))
      {
        localbfbi.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
        localbfbi.jdField_k_of_type_Int = 0;
        localbfbi.l = 1;
        break label127;
      }
      localbfbi.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
      localbfbi.jdField_k_of_type_Int = 0;
      localbfbi.l = 1;
      break label127;
      localbfbi.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
      break label170;
      if (1 == localbfbi.f)
      {
        localbfbi.jdField_a_of_type_Int = 1;
        break label184;
      }
      if (3000 == localbfbi.f)
      {
        localbfbi.jdField_a_of_type_Int = 2;
        break label184;
      }
      localbfbi.jdField_a_of_type_Int = 3;
      break label184;
    }
  }
  
  private im_msg_body.RichText a()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.jdField_f_of_type_JavaLangString != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)) {
          break label614;
        }
        Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        videoFile.ResvAttr localResvAttr;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          localResvAttr = new videoFile.ResvAttr();
          localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
          if ((localObject1 != null) && (((MessageForShortVideo)localObject1).CheckIsHotVideo()))
          {
            a(localResvAttr, (MessageForShortVideo)localObject1, localVideoFile);
            PBBytesField localPBBytesField = localResvAttr.bytes_camera_templateid;
            if (((MessageForShortVideo)localObject1).templateId == null) {
              break label600;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localPBBytesField = localResvAttr.bytes_camera_templateName;
            if (((MessageForShortVideo)localObject1).templateName == null) {
              break label607;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateName;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localResvAttr.uint32_long_video_kandian_type.set(this.A);
            a((MessageForShortVideo)localObject1, localResvAttr);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.z);
          }
        }
        else
        {
          localVideoFile.uint32_file_format.set(2);
          localVideoFile.uint32_file_size.set((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
          localVideoFile.uint32_file_time.set(this.jdField_c_of_type_Int);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_from_chat_type.set(-1);
          localVideoFile.uint32_to_chat_type.set(-1);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(anzj.a(2131712963)));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
        if (((MessageForShortVideo)localObject1).CheckIsDanceVideo()) {
          localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
        }
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString)));
        continue;
        localObject3 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label600:
      continue;
      label607:
      Object localObject3 = "";
      continue;
      label614:
      Object localObject2 = null;
    }
  }
  
  private void a(bcyf parambcyf, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    bbjw localbbjw;
    int j;
    if (parambcyf != null)
    {
      localbbjw = new bbjw(BaseApplication.getContext());
      j = 2002;
      switch (((MessageForShortVideo)paramMessageRecord).busiType)
      {
      }
    }
    for (;;)
    {
      if ((parambcyf.jdField_i_of_type_JavaLangString == null) || (parambcyf.jdField_i_of_type_JavaLangString.length() <= 0)) {
        parambcyf.jdField_i_of_type_JavaLangString = parambcyf.h;
      }
      localbbjw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcyf.jdField_i_of_type_JavaLangString, j, paramMessageRecord.istroop, paramMessageRecord.frienduin, false, paramBoolean, -1, null, parambcyf.f, parambcyf.jdField_e_of_type_JavaLangString);
      return;
      j = 2002;
      continue;
      j = 2001;
      continue;
      j = 2003;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((this.jdField_a_of_type_Long == 0L) && (paramMessageForShortVideo.thumbFileSize != 0)) {
      this.jdField_a_of_type_Long = paramMessageForShortVideo.thumbFileSize;
    }
    if ((this.jdField_q_of_type_Long == 0L) && (paramMessageForShortVideo.videoFileSize != 0)) {
      this.jdField_q_of_type_Long = (paramMessageForShortVideo.videoFileSize + this.jdField_a_of_type_Long);
    }
    if ((this.jdField_a_of_type_Int == 0) && (paramMessageForShortVideo.thumbWidth != 0)) {
      this.jdField_a_of_type_Int = paramMessageForShortVideo.thumbWidth;
    }
    if ((this.jdField_b_of_type_Int == 0) && (paramMessageForShortVideo.thumbHeight != 0)) {
      this.jdField_b_of_type_Int = paramMessageForShortVideo.thumbHeight;
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    int j = 6;
    String str = "unknown";
    if (this.jdField_g_of_type_Boolean)
    {
      j = 7;
      str = "favorite";
    }
    for (;;)
    {
      paramResvAttr.uint32_source.set(2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, new Object[] { "videoSource report: ", Integer.valueOf(j), ", from ", str });
      }
      return;
      if (paramMessageForShortVideo.busiType == 0)
      {
        str = "gallery";
        j = 2;
      }
      else if (paramMessageForShortVideo.busiType == 1)
      {
        str = "aio camera";
        j = 1;
      }
    }
  }
  
  private void a(videoFile.ResvAttr paramResvAttr, MessageForShortVideo paramMessageForShortVideo, im_msg_body.VideoFile paramVideoFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "constructRichText MessageForHotVideo ");
    }
    paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
    paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
    paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
    paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
    paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    label162:
    StringBuilder localStringBuilder;
    if (this.jdField_l_of_type_JavaLangString != null)
    {
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_l_of_type_JavaLangString));
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.length() <= 0)) {
        break label262;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_c_of_type_JavaLangString)));
      if ((paramMessageForShortVideo.md5 == null) || (paramMessageForShortVideo.md5.length() == 0)) {
        paramMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      }
      a(paramMessageForShortVideo);
      if ((paramMessageForShortVideo.videoFileName == null) || (paramMessageForShortVideo.videoFileName.length() == 0))
      {
        localStringBuilder = new StringBuilder();
        if (this.jdField_c_of_type_JavaLangString != null) {
          break label289;
        }
      }
    }
    label262:
    label289:
    for (paramResvAttr = "HotVideo";; paramResvAttr = this.jdField_c_of_type_JavaLangString)
    {
      paramMessageForShortVideo.videoFileName = (paramResvAttr + ".mp4");
      paramVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.videoFileName));
      return;
      if (paramMessageForShortVideo.uuid == null) {
        break;
      }
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.uuid));
      break;
      if (paramMessageForShortVideo.md5 == null) {
        break label162;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.md5)));
      break label162;
    }
  }
  
  private void a(im_msg_body.RichText paramRichText, bcyf parambcyf, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a(paramRichText);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo))) {
        break label174;
      }
      parambcyf = new StringBuilder().append("Mr_");
      if (localMessageRecord != null) {
        break label146;
      }
    }
    label146:
    for (paramRichText = "null";; paramRichText = "" + localMessageRecord.msgtype)
    {
      a(9368, "msgtypeError", paramRichText, this.jdField_c_of_type_Berr);
      d();
      return;
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      break;
    }
    label174:
    ((MessageForShortVideo)localMessageRecord).richText = paramRichText;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, subBusiType = " + ((MessageForShortVideo)localMessageRecord).subBusiType);
    }
    if ((this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null))
    {
      e();
      return;
    }
    if ((localMessageRecord instanceof MessageForBlessPTV))
    {
      ((MessageForBlessPTV)localMessageRecord).uuid = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, localMessageRecord.frienduin);
      azpw.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
      return;
    }
    if ((localMessageRecord instanceof MessageForDanceMachine))
    {
      ((MessageForDanceMachine)localMessageRecord).uuid = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(8034, true, localMessageRecord);
      azpw.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI dance machine data send finished");
      return;
    }
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Berr);
      d();
      return;
    }
    bhnn.a(String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long), "message", "sendMsg() []. mr = " + localMessageRecord.toString());
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(localMessageRecord, this.jdField_a_of_type_Aocj);
    a(parambcyf, localMessageRecord, paramBoolean);
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betf.a();
    this.jdField_a_of_type_Bete.b.a();
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.a();
    this.jdField_a_of_type_Bete.c.a();
    bete localbete = this.jdField_a_of_type_Bete;
    long l = System.nanoTime();
    localbete.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bete.h = 0L;
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {}
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long))
    {
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {
        bdcy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      return;
    }
  }
  
  public void a(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - paramLong) + "ms");
    }
    b(paramHashMap);
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      this.h = true;
    }
    ThreadManager.post(new ShortVideoUploadProcessor.3(this, l2, l3, l4, l5), 5, null, true);
    a(paramInt, "OnFailed.", "", this.jdField_b_of_type_Berr);
    if ((this.y == 3) && (this.jdField_e_of_type_Berr != null))
    {
      this.jdField_e_of_type_Berr.b();
      this.jdField_e_of_type_Berr.jdField_a_of_type_Int = 0;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      d();
      return;
      bdlr.a("Upload_Video_Error", String.valueOf(paramInt));
    }
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int j = 0;
      if (j < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfbz)parambfbj.jdField_a_of_type_JavaUtilList.get(j);
        if (QLog.isColorLevel()) {
          b("procUrl", parambfau.toString());
        }
        a(this.jdField_a_of_type_Berr, parambfau);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambfau.jdField_c_of_type_Int);
        }
        this.jdField_f_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parambfau.jdField_a_of_type_Boolean);
          }
          this.z = parambfau.jdField_a_of_type_Int;
          this.A = parambfau.jdField_b_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + parambfau.jdField_a_of_type_Int + ", response.videoKandianType = " + parambfau.jdField_b_of_type_Int);
          }
          if (parambfau.jdField_a_of_type_Boolean)
          {
            this.jdField_a_of_type_Boolean = true;
            d(1007);
            b(true);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          this.jdField_r_of_type_Long = parambfau.jdField_a_of_type_Long;
          d("<BDH_LOG> onBusiProtoResp() send by bdh");
          this.w = 1;
          t();
          continue;
          d();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {}
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int k = this.n;
    int j;
    long l;
    String str;
    if (paramBoolean)
    {
      j = 2;
      this.n = (j | k);
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 3000)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      }
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      str = this.jdField_a_of_type_Berr.a(1) + ";" + this.jdField_b_of_type_Berr.a(2) + ";" + this.jdField_c_of_type_Berr.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.x + "");
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label516;
      }
      str = this.jdField_l_of_type_JavaLangString;
      label252:
      localHashMap.put("param_uuid", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_a_of_type_Boolean + "");
      if (this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.jdField_a_of_type_JavaLangBoolean));
      }
      if (this.y != 3) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_BDH_Cache_Diff", String.valueOf(this.h));
      if (!paramBoolean) {
        break label525;
      }
      b(true, l);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
      }
      u();
      a(paramBoolean, l);
      return;
      j = 1;
      break;
      label516:
      str = this.jdField_f_of_type_JavaLangString;
      break label252;
      label525:
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int));
      b(false, l);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) && (this.w == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum > 32L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("segNum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().getCurrentConfig().segNum));
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      bdmc.a(BaseApplication.getContext()).a(null, "tempVideoUploadBDH", paramBoolean, paramLong, this.jdField_q_of_type_Long, localHashMap, "");
    }
  }
  
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          this.jdField_f_of_type_JavaLangString = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_a_of_type_Bete.jdField_a_of_type_Long + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      b(paramHashMap);
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        this.h = true;
      }
      this.jdField_b_of_type_Berr.b();
      this.jdField_b_of_type_Berr.jdField_a_of_type_Int = 1;
      this.jdField_s_of_type_Long = this.jdField_q_of_type_Long;
      this.jdField_b_of_type_Boolean = true;
      d(1007);
      b(false);
      ThreadManager.post(new ShortVideoUploadProcessor.2(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_a_of_type_Bete.a();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bhmi.d(paramString);
      paramString = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      String str = this.jdField_d_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        paramArrayOfByte = this.jdField_l_of_type_JavaLangString;
        a("actRichMediaNetMonitor_videoUp", true, 0, paramString, paramHashMap, str, paramArrayOfByte, this.x + "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
          continue;
          paramArrayOfByte = this.jdField_f_of_type_JavaLangString;
        }
      }
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 150	bexk:jdField_a_of_type_ArrayOfByte	[B
    //   4: ifnonnull +98 -> 102
    //   7: new 1057	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 129	bexk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokespecial 1058	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: lconst_0
    //   24: invokestatic 1064	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   27: putfield 150	bexk:jdField_a_of_type_ArrayOfByte	[B
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 150	bexk:jdField_a_of_type_ArrayOfByte	[B
    //   36: ifnonnull +58 -> 94
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: sipush 9041
    //   45: new 102	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 1066
    //   55: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 129	bexk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 122	bexk:b	(ILjava/lang/String;)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 124	bexk:d	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 1069	java/io/FileInputStream:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 1069	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: getfield 1073	bexk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   106: ifnonnull +126 -> 232
    //   109: aload_0
    //   110: new 1075	java/io/RandomAccessFile
    //   113: dup
    //   114: aload_0
    //   115: getfield 129	bexk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   118: ldc_w 1076
    //   121: invokespecial 1078	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: putfield 1073	bexk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   127: aload_0
    //   128: getfield 1073	bexk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   131: ifnonnull +101 -> 232
    //   134: aload_0
    //   135: sipush 9303
    //   138: ldc_w 1080
    //   141: invokevirtual 122	bexk:b	(ILjava/lang/String;)V
    //   144: aload_0
    //   145: invokevirtual 124	bexk:d	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   155: goto -53 -> 102
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 150	bexk:jdField_a_of_type_ArrayOfByte	[B
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokevirtual 1083	bexk:a	(Ljava/io/IOException;)V
    //   175: aload_2
    //   176: astore_1
    //   177: aload_0
    //   178: invokevirtual 124	bexk:d	()V
    //   181: aload_2
    //   182: ifnull -97 -> 85
    //   185: aload_2
    //   186: invokevirtual 1069	java/io/FileInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 1069	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 1070	java/io/IOException:printStackTrace	()V
    //   216: goto -7 -> 209
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 1084	java/io/FileNotFoundException:printStackTrace	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 1073	bexk:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   229: goto -102 -> 127
    //   232: aload_0
    //   233: new 224	java/io/File
    //   236: dup
    //   237: aload_0
    //   238: getfield 129	bexk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: invokevirtual 235	java/io/File:length	()J
    //   247: putfield 249	bexk:jdField_a_of_type_Long	J
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 129	bexk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   255: invokevirtual 1086	bexk:b	(Ljava/lang/String;)V
    //   258: iconst_1
    //   259: ireturn
    //   260: astore_2
    //   261: goto -60 -> 201
    //   264: astore_3
    //   265: goto -104 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	bexk
    //   20	53	1	localFileInputStream1	java.io.FileInputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   150	2	1	localIOException2	java.io.IOException
    //   162	15	1	localFileInputStream2	java.io.FileInputStream
    //   191	2	1	localIOException3	java.io.IOException
    //   200	6	1	localObject1	Object
    //   211	2	1	localIOException4	java.io.IOException
    //   219	2	1	localFileNotFoundException	FileNotFoundException
    //   18	168	2	localFileInputStream3	java.io.FileInputStream
    //   198	12	2	localObject2	Object
    //   260	1	2	localObject3	Object
    //   158	14	3	localIOException5	java.io.IOException
    //   264	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/io/IOException
    //   98	102	150	java/io/IOException
    //   7	19	158	java/io/IOException
    //   185	189	191	java/io/IOException
    //   7	19	198	finally
    //   205	209	211	java/io/IOException
    //   109	127	219	java/io/FileNotFoundException
    //   21	30	260	finally
    //   32	39	260	finally
    //   41	71	260	finally
    //   73	77	260	finally
    //   163	168	260	finally
    //   170	175	260	finally
    //   177	181	260	finally
    //   21	30	264	java/io/IOException
    //   32	39	264	java/io/IOException
    //   41	71	264	java/io/IOException
    //   73	77	264	java/io/IOException
  }
  
  public byte[] a(bfbi parambfbi)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(parambfbi.jdField_c_of_type_JavaLangString));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(parambfbi.jdField_d_of_type_JavaLangString));
    localPttShortVideoUploadReq.uint32_chat_type.set(parambfbi.jdField_a_of_type_Int);
    localPttShortVideoUploadReq.uint32_client_type.set(parambfbi.jdField_b_of_type_Int);
    if (parambfbi.jdField_b_of_type_JavaLangString != null) {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(parambfbi.jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      localPttShortVideoUploadReq.uint32_agent_type.set(parambfbi.i);
      localPttShortVideoUploadReq.uint32_business_type.set(parambfbi.j);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(parambfbi.jdField_a_of_type_JavaLangString);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbi.jdField_a_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(parambfbi.jdField_b_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.uint64_file_size.set(parambfbi.jdField_a_of_type_Long);
      localPttShortVideoFileInfo.uint32_file_res_length.set(parambfbi.jdField_d_of_type_Int);
      localPttShortVideoFileInfo.uint32_file_res_width.set(parambfbi.jdField_e_of_type_Int);
      localPttShortVideoFileInfo.uint32_file_format.set(parambfbi.g);
      localPttShortVideoFileInfo.uint32_file_time.set(parambfbi.h);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(parambfbi.jdField_b_of_type_Long);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      return localPttShortVideoUploadReq.toByteArray();
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
    }
  }
  
  public void aN_()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if ((((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0) && (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isPause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "video send pause!");
      }
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start()");
    }
    super.aN_();
    if (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).CheckIsHotVideo())
    {
      f();
      return;
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof bcyf))) {
      this.jdField_g_of_type_Boolean = ((bcyf)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).jdField_i_of_type_Boolean;
    }
    d(1001);
    this.jdField_a_of_type_Bete.a();
    g();
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.m);
    }
    if (this.m)
    {
      this.m = false;
      this.jdField_q_of_type_Boolean = false;
      d(1002);
      this.t = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_k_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      v();
      d(1001);
      this.jdField_a_of_type_Bern.a.post(new ShortVideoUploadProcessor.1(this));
    }
    return 0;
  }
  
  protected void b(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.jdField_a_of_type_Int = localOptions.outWidth;
    this.jdField_b_of_type_Int = localOptions.outHeight;
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!f())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "do not send message, due to mIsCancel=true || mIsPause=true.");
      }
      return;
    }
    Object localObject2;
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof bcyf)))
    {
      localObject2 = (bcyf)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
      this.jdField_i_of_type_Boolean = ((bcyf)localObject2).jdField_g_of_type_Boolean;
      localObject1 = localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, mNeedSyncStory = " + this.jdField_i_of_type_Boolean);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, isHotVideo = " + localObject1.jdField_e_of_type_Boolean);
        }
        if (localObject1.jdField_e_of_type_Boolean)
        {
          this.jdField_l_of_type_JavaLangString = localObject1.jdField_a_of_type_JavaLangString;
          this.jdField_c_of_type_JavaLangString = localObject1.jdField_e_of_type_JavaLangString;
          this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localObject1.jdField_e_of_type_JavaLangString);
          this.jdField_q_of_type_Long = (localObject1.jdField_e_of_type_Int + localObject1.jdField_b_of_type_Long);
          this.jdField_c_of_type_Int = localObject1.f;
          this.jdField_a_of_type_Long = localObject1.jdField_b_of_type_Long;
          this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localObject1.jdField_g_of_type_JavaLangString);
          this.jdField_b_of_type_Int = localObject1.jdField_d_of_type_Int;
          this.jdField_a_of_type_Int = localObject1.jdField_c_of_type_Int;
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      bhnn.a(String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long), "message", "sendMsg() start.");
      this.jdField_c_of_type_Berr.a();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      a((im_msg_body.RichText)localObject2, localObject1, paramBoolean);
      return;
    }
  }
  
  public boolean b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString))
    {
      this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString);
      bete localbete = this.jdField_a_of_type_Bete;
      String str = this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString;
      localbete.jdField_f_of_type_JavaLangString = str;
      this.jdField_c_of_type_JavaLangString = str;
    }
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return false;
    }
    if (!bhmi.b(this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString))
    {
      b(9042, "video file not exists");
      d();
      return false;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read video file error");
          d();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    return true;
  }
  
  public int c()
  {
    if ((this.jdField_a_of_type_Beyg != null) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0)) {
      this.o = true;
    }
    return 0;
  }
  
  protected String c()
  {
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 3000))
    {
      if (this.w == 1) {
        return "actShortVideoDiscussgroupUploadBDH";
      }
      return "actShortVideoDiscussgroupUpload";
    }
    if (this.w == 1) {
      return "actShortVideoUploadBDH";
    }
    return "actShortVideoUpload";
  }
  
  public void c()
  {
    if (!this.m)
    {
      this.m = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1004);
      if ((this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null))
      {
        azrh localazrh = new azrh();
        localazrh.jdField_a_of_type_Int = -1;
        localazrh.jdField_b_of_type_Int = 9037;
        localazrh.jdField_a_of_type_JavaLangString = "cancel";
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
      }
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
    }
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      d("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      d("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    d("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public void c(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
      b("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)(this.jdField_q_of_type_Long - this.jdField_a_of_type_Long));
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.videoAttr = this.z;
      localMessageForShortVideo.videoKandianType = this.A;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
  
  void d()
  {
    super.d();
    if ((this.y == 3) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.length() > 0)) {
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label320;
      }
    }
    label320:
    for (Object localObject = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long))
    {
      if ((localObject != null) && ((localObject instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject).md5 = this.jdField_c_of_type_JavaLangString;
      }
      d(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.jdField_k_of_type_Int);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.jdField_j_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
      {
        localObject = new azrh();
        ((azrh)localObject).jdField_a_of_type_Int = -1;
        ((azrh)localObject).jdField_b_of_type_Int = this.jdField_k_of_type_Int;
        ((azrh)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b((azrh)localObject);
      }
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForBlessPTV)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, false, this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
        azpw.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForDanceMachine)))
      {
        ((MessageForDanceMachine)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).errorCode = 1;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(8034, false, this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        azpw.a("ShortVideoUploadProcessor", "onError", "notifyUI dance machine send error");
      }
      return;
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.b(paramInt));
    }
    if ((this.m) && (1004 != paramInt)) {
      return;
    }
    bcwu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bete, this.jdField_a_of_type_Beyg);
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aohl != null) {
      this.jdField_a_of_type_Aohl.a(this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString + this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    }
    String str;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = 0;
      localazrh.jdField_a_of_type_Long = (this.jdField_q_of_type_Long - this.jdField_a_of_type_Long);
      localazrh.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_l_of_type_JavaLangString;
        localazrh.jdField_c_of_type_JavaLangString = str;
        localazrh.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localazrh.jdField_c_of_type_Int = this.z;
        localazrh.jdField_d_of_type_Int = this.A;
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onSuccess uuid = " + localazrh.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 2) {
        w();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      c(true);
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start() isHotVideo");
    }
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject == null) || ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof bcwz)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if ((localMessageForShortVideo.md5 != null) && (localMessageForShortVideo.md5.length() > 0)) {
        this.jdField_c_of_type_JavaLangString = localMessageForShortVideo.md5;
      }
      if ((localMessageForShortVideo.uuid != null) && (localMessageForShortVideo.uuid.length() > 0)) {
        this.jdField_l_of_type_JavaLangString = localMessageForShortVideo.uuid;
      }
      if ((localMessageForShortVideo.thumbMD5 != null) && (localMessageForShortVideo.thumbMD5.length() > 0)) {
        this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localMessageForShortVideo.thumbMD5);
      }
    }
    d(1001);
    b(false);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Beyg.jdField_j_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "is Presend ");
      }
      this.y = 3;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Beyg.k);
      if (a()) {
        break label159;
      }
    }
    label157:
    label159:
    while (!i())
    {
      do
      {
        return;
      } while (!b());
      if (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 1) {
        if (VideoUpConfigInfo.sSwitch != 2) {}
      }
      for (this.y = 2;; this.y = 2) {
        do
        {
          if (bexh.jdField_a_of_type_Long <= 0L) {
            break label157;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put("param_cost_c_comp", String.valueOf(bexh.jdField_a_of_type_Long));
          break;
        } while ((((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType != 2) || (PTVUpConfigInfo.sSwitch != 2));
      }
      break;
    }
    QLog.d("ShortVideoUploadProcessor", 1, "<BDH_LOG>mSwitch : " + this.y);
    switch (this.y)
    {
    default: 
      r();
      return;
    }
    this.w = 1;
    t();
  }
  
  public void h()
  {
    try
    {
      int j;
      if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session() != null)
      {
        j = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session().length;
        this.jdField_f_of_type_ArrayOfByte = new byte[j];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getHttpconn_sig_session(), 0, this.jdField_f_of_type_ArrayOfByte, 0, j);
      }
      if (SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey() != null)
      {
        j = SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey().length;
        this.jdField_e_of_type_ArrayOfByte = new byte[j];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString).getSessionKey(), 0, this.jdField_e_of_type_ArrayOfByte, 0, j);
      }
      return;
    }
    finally {}
  }
  
  public boolean i()
  {
    h();
    if ((this.jdField_f_of_type_ArrayOfByte == null) || (this.jdField_f_of_type_ArrayOfByte.length == 0) || (this.jdField_e_of_type_ArrayOfByte == null) || (this.jdField_e_of_type_ArrayOfByte.length == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "sessionKey or sigSession is null ! ");
      }
      HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString);
    }
    return true;
  }
  
  void r()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    }
    bfbi localbfbi = a();
    localbfau.jdField_a_of_type_Bfcb = this;
    localbfau.jdField_a_of_type_JavaLangString = "short_video_up";
    localbfau.jdField_a_of_type_JavaUtilList.add(localbfbi);
    localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
      d();
    }
    do
    {
      return;
      if (localbfbi.jdField_a_of_type_Long == 0L)
      {
        b(9303, "video filesize is 0");
        d();
        return;
      }
      if (this.jdField_a_of_type_Long == 0L)
      {
        b(9303, "thumbfile filesize is 0");
        d();
        return;
      }
      if ((localbfbi.j == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      }
      b("requestStart", localbfau.toString());
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  public void s()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUploadProcessor", 2, "inter_retry resume sendMsg!");
        }
        b(false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long))
    {
      b(false);
      return;
    }
    aN_();
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Berr.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int k;
    do
    {
      return;
      long l = SystemClock.uptimeMillis();
      Object localObject = a();
      bfbi localbfbi = a();
      byte[] arrayOfByte = a(localbfbi);
      bexl localbexl = new bexl(this, (String)localObject, l);
      int j = 12;
      if (localbfbi.j == 0) {
        j = 25;
      }
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), j, (String)localObject, (int)this.jdField_r_of_type_Long, this.jdField_b_of_type_ArrayOfByte, localbexl, arrayOfByte, true);
      localObject = new bexm(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + k + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + j);
      }
    } while (k == 0);
    a(k, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Berr);
    d();
  }
  
  protected void u()
  {
    if (((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType == 0) {
      ThreadManager.post(new ShortVideoUploadProcessor.7(this, this.jdField_a_of_type_Beyg.jdField_i_of_type_JavaLangString), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexk
 * JD-Core Version:    0.7.0.1
 */