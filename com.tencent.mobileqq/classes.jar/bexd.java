import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.1;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.3;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class bexd
  extends berm
{
  private int A;
  protected int a;
  protected long a;
  aocj jdField_a_of_type_Aocj = new bexg(this);
  protected aohl a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
  protected String a;
  public boolean a;
  protected int b;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  protected int c;
  private byte[] e;
  private byte[] f;
  boolean g = false;
  public boolean h;
  int x = -1;
  int y = 0;
  private int z;
  
  public bexd(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    if ((this.jdField_a_of_type_Beyg != null) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo)))
    {
      this.x = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      this.g = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryVideo;
      if (this.g) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = ((MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
    String[] arrayOfString;
    for (;;)
    {
      parambeyb = parambeyg.i;
      arrayOfString = parambeyb.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + parambeyb);
      }
      b(9304, "path =" + parambeyb);
      d();
      this.jdField_q_of_type_Boolean = true;
      return;
      this.x = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    parambeyg.i = arrayOfString[0];
    this.jdField_a_of_type_JavaLangString = arrayOfString[1];
    this.jdField_c_of_type_Int = Integer.parseInt(arrayOfString[2]);
    this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(arrayOfString[3]);
  }
  
  private bfbh a()
  {
    bfbh localbfbh = new bfbh();
    localbfbh.jdField_g_of_type_Int = ((int)this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbfbh.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfbh.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbh.jdField_f_of_type_Int = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbfbh.jdField_l_of_type_Int = 0;
    localbfbh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbh.jdField_e_of_type_Int = 2;
    if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof bcwz)))
    {
      localObject = (bcwz)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
      localbfbh.jdField_a_of_type_Int = ((bcwz)localObject).jdField_c_of_type_Int;
      localbfbh.jdField_b_of_type_Int = ((bcwz)localObject).jdField_d_of_type_Int;
      localbfbh.jdField_c_of_type_Int = ((bcwz)localObject).jdField_e_of_type_Int;
      localbfbh.jdField_d_of_type_Int = ((bcwz)localObject).jdField_f_of_type_Int;
      this.x = localbfbh.jdField_c_of_type_Int;
      int i = ((bcwz)localObject).j;
      this.jdField_c_of_type_Int = i;
      localbfbh.jdField_k_of_type_Int = i;
      localbfbh.jdField_f_of_type_JavaLangString = ((bcwz)localObject).jdField_a_of_type_JavaLangString;
      localbfbh.jdField_a_of_type_JavaLangString = ((bcwz)localObject).k;
      localbfbh.j = ((bcwz)localObject).jdField_l_of_type_Int;
      localbfbh.jdField_g_of_type_JavaLangString = ((bcwz)localObject).jdField_l_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileFormat", String.valueOf(localbfbh.j));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResLength", String.valueOf(this.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picResWidth", String.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromChatType", String.valueOf(localbfbh.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toChatType", String.valueOf(localbfbh.jdField_b_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromBusiType", String.valueOf(localbfbh.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toBusiType", String.valueOf(localbfbh.jdField_d_of_type_Int));
      if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
        localbfbh.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      localbfbh.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      localbfbh.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localbfbh.i = this.jdField_a_of_type_Int;
      localbfbh.jdField_h_of_type_Int = this.jdField_b_of_type_Int;
      if (localbfbh.jdField_a_of_type_JavaLangString != null) {
        break label416;
      }
    }
    label416:
    for (Object localObject = "";; localObject = localbfbh.jdField_a_of_type_JavaLangString)
    {
      localbfbh.jdField_a_of_type_JavaLangString = ((String)localObject);
      localbfbh.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      localbfbh.jdField_b_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      return localbfbh;
      b("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
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
        if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length > 0)) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        }
        if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() > 0)) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.jdField_f_of_type_JavaLangString));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.jdField_f_of_type_JavaLangString);
        }
        if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            if ((((MessageForShortVideo)localObject1).videoFileName != null) && (((MessageForShortVideo)localObject1).videoFileName.length() > 0)) {
              localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            }
            if ((((MessageForShortVideo)localObject1).fileSource != null) && (((MessageForShortVideo)localObject1).fileSource.length() > 0)) {
              localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            }
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0)) {
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          }
          localVideoFile.uint32_thumb_file_size.set((int)this.jdField_a_of_type_Long);
          localVideoFile.uint32_file_size.set((int)this.jdField_b_of_type_Long);
          localVideoFile.uint32_thumb_width.set(this.jdField_a_of_type_Int);
          localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
          if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
          }
          Object localObject3 = new videoFile.ResvAttr();
          a((MessageForShortVideo)localObject1, (videoFile.ResvAttr)localObject3);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 3 , from msg tab camera");
            }
            ((videoFile.ResvAttr)localObject3).uint32_source.set(3);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
            localVideoFile.uint32_video_attr.set(this.z);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(anzj.a(2131712933)));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 4 , from forward");
          }
          ((videoFile.ResvAttr)localObject3).uint32_source.set(4);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        b("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.CheckIsHotVideo()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "constructRichText MessageForHotVideo ");
      }
      if ((paramMessageForShortVideo.hotVideoIconUrl != null) && (paramMessageForShortVideo.hotVideoIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
      }
      if ((paramMessageForShortVideo.hotVideoTitle != null) && (paramMessageForShortVideo.hotVideoTitle.length() > 0)) {
        paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
      }
      if ((paramMessageForShortVideo.hotVideoUrl != null) && (paramMessageForShortVideo.hotVideoUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
      }
      if ((paramMessageForShortVideo.hotVideoSubIconUrl != null) && (paramMessageForShortVideo.hotVideoSubIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
      }
      paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    }
    Object localObject;
    if (paramMessageForShortVideo != null)
    {
      paramResvAttr.uint32_msg_tail_type.set(paramMessageForShortVideo.msgTailType);
      if (paramMessageForShortVideo.CheckIsDanceVideo()) {
        paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
      }
      PBBytesField localPBBytesField = paramResvAttr.bytes_camera_templateid;
      if (paramMessageForShortVideo.templateId == null) {
        break label258;
      }
      localObject = paramMessageForShortVideo.templateId;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = paramResvAttr.bytes_camera_templateName;
      if (paramMessageForShortVideo.templateName == null) {
        break label264;
      }
    }
    label258:
    label264:
    for (paramMessageForShortVideo = paramMessageForShortVideo.templateName;; paramMessageForShortVideo = "")
    {
      ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo));
      paramResvAttr.uint32_long_video_kandian_type.set(this.A);
      return;
      localObject = "";
      break;
    }
  }
  
  private void r()
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
  
  public void a(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - paramLong) + "ms");
    }
    b(paramHashMap);
    ThreadManager.post(new ShortVideoForwardProcessor.3(this, l2, l3, l4, l5), 5, null, true);
    a(paramInt, "OnFailed.", "", this.jdField_b_of_type_Berr);
    d();
  }
  
  public void a(bfau parambfau, bfbj parambfbj)
  {
    this.jdField_a_of_type_Bfau = null;
    if (parambfbj != null)
    {
      int i = 0;
      if (i < parambfbj.jdField_a_of_type_JavaUtilList.size())
      {
        parambfau = (bfby)parambfbj.jdField_a_of_type_JavaUtilList.get(i);
        b("procUrl", parambfau.toString());
        a(this.jdField_a_of_type_Berr, parambfau);
        this.jdField_f_of_type_JavaLangString = parambfau.jdField_a_of_type_JavaLangString;
        if (parambfau.jdField_c_of_type_Int == 0)
        {
          this.z = parambfau.jdField_a_of_type_Int;
          this.A = parambfau.jdField_b_of_type_Int;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + parambfau.jdField_a_of_type_Int + ", response.videoKandianType = " + parambfau.jdField_b_of_type_Int);
          }
          if (parambfau.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoForwardProcessor", 2, "ShortVideo exist on server.");
            }
            this.jdField_b_of_type_Boolean = true;
            d(1007);
            b(true);
          }
          for (;;)
          {
            i += 1;
            break;
            a(parambfau);
          }
        }
        if (-5100026 == this.jdField_k_of_type_Int) {
          b(-5100026, "安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString);
        }
        for (;;)
        {
          d();
          break;
          b(9045, anzj.a(2131712959));
        }
      }
    }
  }
  
  public void a(bfby parambfby)
  {
    if (this.x == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoForwardProcessor", 2, "check ShortVideo before forward:" + this.jdField_a_of_type_Beyg.i);
      }
      if ((a()) && (ShortVideoUtils.d()))
      {
        b(9305, "onBusiProtoResp=> video file can not play");
        d();
        parambfby = new HashMap();
        parambfby.put(BaseConstants.RDM_NoChangeFailCode, "");
        parambfby.put("filePath", this.jdField_a_of_type_Beyg.i);
        parambfby.put("uuid", this.jdField_l_of_type_JavaLangString);
        parambfby.put("md5", this.jdField_a_of_type_Beyg.jdField_f_of_type_JavaLangString);
        bdmc.a(BaseApplication.getContext()).a(null, "actForwardVideoBroken", true, 0L, 0L, parambfby, "");
      }
    }
    while (!b()) {
      return;
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.length() > 0))
    {
      if ((this.jdField_f_of_type_ArrayOfByte == null) || (this.jdField_f_of_type_ArrayOfByte.length == 0)) {
        this.jdField_f_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(bhmi.c(this.jdField_a_of_type_JavaLangString));
      }
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        this.jdField_a_of_type_Long = ((File)localObject).length();
        b(this.jdField_a_of_type_JavaLangString);
        this.jdField_q_of_type_Long = (this.jdField_b_of_type_Long + this.jdField_a_of_type_Long);
        if ((this.jdField_b_of_type_ArrayOfByte != null) && (this.jdField_b_of_type_ArrayOfByte.length > 0) && (this.e != null) && (this.e.length > 0) && (this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0) && (this.jdField_f_of_type_ArrayOfByte != null) && (this.jdField_f_of_type_ArrayOfByte.length > 0) && ((!Arrays.equals(this.jdField_b_of_type_ArrayOfByte, this.e)) || (!Arrays.equals(this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_ArrayOfByte))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "md5 diffrent : resend request !   mLocalMd5 : " + HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte) + " mVideoMd5_local : " + HexUtil.bytes2HexStr(this.e) + " thumbFileMd5 : " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte) + " mThumbMd5_local : " + HexUtil.bytes2HexStr(this.jdField_f_of_type_ArrayOfByte));
          }
          this.jdField_b_of_type_ArrayOfByte = this.e;
          this.jdField_a_of_type_ArrayOfByte = this.jdField_f_of_type_ArrayOfByte;
          f();
        }
      }
      else
      {
        b(9042, "onBusiProtoResp=> thumb file not exists");
        d();
      }
    }
    else
    {
      b(9302, "onBusiProtoResp=> mThumbFilePath is null");
      d();
      return;
    }
    Object localObject = this.jdField_a_of_type_Bete;
    long l = this.jdField_b_of_type_Long + this.jdField_a_of_type_Long;
    this.jdField_q_of_type_Long = l;
    ((bete)localObject).jdField_a_of_type_Long = l;
    this.jdField_r_of_type_Long = parambfby.jdField_a_of_type_Long;
    this.w = 1;
    h();
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int))) {}
    while ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.n & 0x2) > 0)) || ((!paramBoolean) && ((this.n & 0x1) > 0))) {
      return;
    }
    int j = this.n;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.n = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
      str = this.jdField_a_of_type_Berr.a(1) + ";" + this.jdField_b_of_type_Berr.a(2) + ";" + this.jdField_c_of_type_Berr.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str);
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label495;
      }
      str = this.jdField_l_of_type_JavaLangString;
      label176:
      localHashMap.put("param_uuid", str);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busiType", this.x + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fileMd5", HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_thumbSize", String.valueOf(this.jdField_a_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_videoDuration", String.valueOf(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_b_of_type_Boolean + "");
      if (!paramBoolean) {
        break label504;
      }
      b(true, l);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, l, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.jdField_b_of_type_Berr.jdField_b_of_type_Long - this.jdField_b_of_type_Berr.jdField_a_of_type_Long) / 1000000L + ", getReportTAG = " + c());
      return;
      i = 1;
      break;
      label495:
      str = this.jdField_f_of_type_JavaLangString;
      break label176;
      label504:
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
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bfci.jdField_l_of_type_JavaLangString = (this.x + "");
    this.jdField_a_of_type_Bfci.jdField_j_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    bfci localbfci = this.jdField_a_of_type_Bfci;
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localbfci.k = str;
      this.jdField_a_of_type_Bfci.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Bfci.jdField_b_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Bfci.jdField_c_of_type_JavaLangString = String.valueOf(paramInt);
      this.jdField_a_of_type_Bfci.jdField_b_of_type_Long = this.jdField_q_of_type_Long;
      a("actRichMediaNetMonitor_videoUp", paramBoolean);
      return;
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
            QLog.d("ShortVideoForwardProcessor", 2, "set uuid from BDH ");
          }
        }
      }
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.jdField_a_of_type_Bete.jdField_a_of_type_Long + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      b(paramHashMap);
      this.jdField_b_of_type_Berr.b();
      this.jdField_b_of_type_Berr.jdField_a_of_type_Int = 1;
      this.jdField_s_of_type_Long = this.jdField_q_of_type_Long;
      this.h = true;
      b(false);
      ThreadManager.post(new ShortVideoForwardProcessor.2(this, l2, l3, l4, l5), 5, null, true);
      this.jdField_a_of_type_Bete.a();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      bhmi.d(paramString);
      a(true, 0, (String)paramHashMap.get("ip"), (String)paramHashMap.get("port"));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoForwardProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: new 929	android/media/MediaPlayer
    //   7: dup
    //   8: invokespecial 930	android/media/MediaPlayer:<init>	()V
    //   11: astore 5
    //   13: new 932	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   21: getfield 81	beyg:i	Ljava/lang/String;
    //   24: invokespecial 933	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 5
    //   31: aload 4
    //   33: invokevirtual 937	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   36: invokevirtual 941	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   39: aload 5
    //   41: invokevirtual 944	android/media/MediaPlayer:prepare	()V
    //   44: aload 5
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: invokevirtual 947	android/media/MediaPlayer:release	()V
    //   54: iload_2
    //   55: istore_1
    //   56: aload 4
    //   58: ifnull +10 -> 68
    //   61: aload 4
    //   63: invokevirtual 950	java/io/FileInputStream:close	()V
    //   66: iload_2
    //   67: istore_1
    //   68: iload_1
    //   69: ireturn
    //   70: astore 4
    //   72: aconst_null
    //   73: astore 4
    //   75: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 97
    //   83: iconst_2
    //   84: ldc_w 952
    //   87: invokestatic 652	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore_1
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 947	android/media/MediaPlayer:release	()V
    //   100: aload 4
    //   102: ifnull -34 -> 68
    //   105: aload 4
    //   107: invokevirtual 950	java/io/FileInputStream:close	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_3
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokevirtual 947	android/media/MediaPlayer:release	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 950	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore 4
    //   146: goto -4 -> 142
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: goto -31 -> 122
    //   156: astore_3
    //   157: goto -35 -> 122
    //   160: astore 6
    //   162: aload_3
    //   163: astore 5
    //   165: aload 6
    //   167: astore_3
    //   168: goto -46 -> 122
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 5
    //   177: astore_3
    //   178: goto -103 -> 75
    //   181: astore_3
    //   182: aload 5
    //   184: astore_3
    //   185: goto -110 -> 75
    //   188: astore_3
    //   189: iconst_0
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	bexd
    //   55	37	1	bool1	boolean
    //   3	64	2	bool2	boolean
    //   1	96	3	localObject1	Object
    //   112	1	3	localException1	Exception
    //   115	28	3	localObject2	Object
    //   149	1	3	localObject3	Object
    //   156	7	3	localObject4	Object
    //   167	1	3	localObject5	Object
    //   171	1	3	localException2	Exception
    //   177	1	3	localObject6	Object
    //   181	1	3	localException3	Exception
    //   184	1	3	localObject7	Object
    //   188	1	3	localException4	Exception
    //   27	35	4	localFileInputStream	java.io.FileInputStream
    //   70	1	4	localException5	Exception
    //   73	65	4	localObject8	Object
    //   144	1	4	localException6	Exception
    //   151	23	4	localObject9	Object
    //   11	172	5	localObject10	Object
    //   160	6	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	70	java/lang/Exception
    //   96	100	112	java/lang/Exception
    //   105	110	112	java/lang/Exception
    //   4	13	115	finally
    //   127	132	144	java/lang/Exception
    //   137	142	144	java/lang/Exception
    //   13	29	149	finally
    //   29	44	156	finally
    //   75	90	160	finally
    //   13	29	171	java/lang/Exception
    //   29	44	181	java/lang/Exception
    //   49	54	188	java/lang/Exception
    //   61	66	188	java/lang/Exception
  }
  
  public byte[] a(bfbh parambfbh)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(parambfbh.jdField_d_of_type_JavaLangString));
    localPttShortVideoUploadReq.uint32_chat_type.set(parambfbh.jdField_b_of_type_Int);
    localPttShortVideoUploadReq.uint32_client_type.set(parambfbh.jdField_e_of_type_Int);
    PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo;
    PBStringField localPBStringField;
    if (parambfbh.jdField_b_of_type_JavaLangString != null)
    {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(parambfbh.jdField_b_of_type_JavaLangString));
      localPttShortVideoUploadReq.uint32_agent_type.set(parambfbh.jdField_l_of_type_Int);
      localPttShortVideoUploadReq.uint32_business_type.set(parambfbh.jdField_d_of_type_Int);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPBStringField = localPttShortVideoFileInfo.str_file_name;
      if (parambfbh.jdField_a_of_type_JavaLangString != null) {
        break label276;
      }
    }
    label276:
    for (String str = "";; str = parambfbh.jdField_a_of_type_JavaLangString)
    {
      localPBStringField.set(str);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(parambfbh.jdField_a_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(parambfbh.jdField_b_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.uint64_file_size.set(parambfbh.jdField_a_of_type_Long);
      localPttShortVideoFileInfo.uint32_file_res_length.set(parambfbh.jdField_h_of_type_Int);
      localPttShortVideoFileInfo.uint32_file_res_width.set(parambfbh.i);
      localPttShortVideoFileInfo.uint32_file_format.set(parambfbh.j);
      localPttShortVideoFileInfo.uint32_file_time.set(parambfbh.jdField_k_of_type_Int);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(parambfbh.jdField_b_of_type_Long);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      return localPttShortVideoUploadReq.toByteArray();
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
      break;
    }
  }
  
  /* Error */
  public void aN_()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 124	bexd:jdField_q_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 97
    //   16: iconst_2
    //   17: ldc_w 1029
    //   20: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1031	berm:aN_	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 654	bexd:d	(I)V
    //   34: aload_0
    //   35: getfield 521	bexd:jdField_a_of_type_Bete	Lbete;
    //   38: invokevirtual 910	bete:a	()V
    //   41: aload_0
    //   42: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   45: getfield 664	beyg:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokestatic 1037	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   59: getfield 664	beyg:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   62: invokestatic 147	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 255	bexd:jdField_b_of_type_ArrayOfByte	[B
    //   68: aload_0
    //   69: getfield 521	bexd:jdField_a_of_type_Bete	Lbete;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   77: getfield 664	beyg:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 1038	bete:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 1039	bexd:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   95: getfield 178	beyg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   105: getfield 178	beyg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   108: instanceof 180
    //   111: ifeq +92 -> 203
    //   114: aload_0
    //   115: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   118: getfield 178	beyg:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   121: checkcast 180	bcwz
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 1040	bcwz:i	I
    //   130: i2l
    //   131: putfield 244	bexd:jdField_b_of_type_Long	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 1042	bcwz:jdField_m_of_type_Int	I
    //   139: i2l
    //   140: putfield 246	bexd:jdField_a_of_type_Long	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 1043	bcwz:jdField_g_of_type_Int	I
    //   148: putfield 229	bexd:jdField_a_of_type_Int	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 1044	bcwz:jdField_h_of_type_Int	I
    //   156: putfield 226	bexd:jdField_b_of_type_Int	I
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 1046	bcwz:jdField_c_of_type_Boolean	Z
    //   164: putfield 394	bexd:jdField_a_of_type_Boolean	Z
    //   167: aload_0
    //   168: getfield 255	bexd:jdField_b_of_type_ArrayOfByte	[B
    //   171: ifnull +20 -> 191
    //   174: aload_0
    //   175: getfield 255	bexd:jdField_b_of_type_ArrayOfByte	[B
    //   178: arraylength
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: getfield 244	bexd:jdField_b_of_type_Long	J
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +79 -> 267
    //   191: aload_0
    //   192: invokevirtual 1048	bexd:h	()Z
    //   195: ifne +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 121	bexd:d	()V
    //   202: return
    //   203: aload_0
    //   204: ldc_w 1050
    //   207: ldc_w 261
    //   210: invokevirtual 264	bexd:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: sipush 9302
    //   217: ldc_w 1052
    //   220: invokevirtual 119	bexd:b	(ILjava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 121	bexd:d	()V
    //   227: return
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 255	bexd:jdField_b_of_type_ArrayOfByte	[B
    //   233: putfield 729	bexd:e	[B
    //   236: new 715	java/io/File
    //   239: dup
    //   240: aload_0
    //   241: getfield 65	bexd:jdField_a_of_type_Beyg	Lbeyg;
    //   244: getfield 81	beyg:i	Ljava/lang/String;
    //   247: invokespecial 718	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore_1
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 723	java/io/File:length	()J
    //   256: putfield 244	bexd:jdField_b_of_type_Long	J
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 1055	java/io/File:getName	()Ljava/lang/String;
    //   264: putfield 238	bexd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   271: ifnull +34 -> 305
    //   274: aload_0
    //   275: getfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   278: arraylength
    //   279: ifeq +26 -> 305
    //   282: aload_0
    //   283: getfield 246	bexd:jdField_a_of_type_Long	J
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +17 -> 305
    //   291: aload_0
    //   292: getfield 229	bexd:jdField_a_of_type_Int	I
    //   295: ifle +10 -> 305
    //   298: aload_0
    //   299: getfield 226	bexd:jdField_b_of_type_Int	I
    //   302: ifgt +132 -> 434
    //   305: new 932	java/io/FileInputStream
    //   308: dup
    //   309: aload_0
    //   310: getfield 133	bexd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   313: invokespecial 933	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   316: astore_2
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: aload_2
    //   321: lconst_0
    //   322: invokestatic 1061	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   325: putfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   334: ifnonnull +56 -> 390
    //   337: aload_2
    //   338: astore_1
    //   339: aload_0
    //   340: sipush 9041
    //   343: new 99	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1063
    //   353: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 133	bexd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 119	bexd:b	(ILjava/lang/String;)V
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: invokevirtual 121	bexd:d	()V
    //   375: aload_2
    //   376: ifnull -369 -> 7
    //   379: aload_2
    //   380: invokevirtual 950	java/io/FileInputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 1064	java/io/IOException:printStackTrace	()V
    //   389: return
    //   390: aload_2
    //   391: astore_1
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   397: putfield 708	bexd:jdField_f_of_type_ArrayOfByte	[B
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 950	java/io/FileInputStream:close	()V
    //   408: aload_0
    //   409: new 715	java/io/File
    //   412: dup
    //   413: aload_0
    //   414: getfield 133	bexd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   417: invokespecial 718	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 723	java/io/File:length	()J
    //   423: putfield 246	bexd:jdField_a_of_type_Long	J
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 133	bexd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   431: invokevirtual 725	bexd:b	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 747	bexd:f	()V
    //   438: return
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 1064	java/io/IOException:printStackTrace	()V
    //   444: goto -36 -> 408
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_2
    //   451: astore_1
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 149	bexd:jdField_a_of_type_ArrayOfByte	[B
    //   457: aload_2
    //   458: astore_1
    //   459: aload_0
    //   460: aload_3
    //   461: invokevirtual 1067	bexd:a	(Ljava/io/IOException;)V
    //   464: aload_2
    //   465: astore_1
    //   466: aload_0
    //   467: invokevirtual 121	bexd:d	()V
    //   470: aload_2
    //   471: ifnull -464 -> 7
    //   474: aload_2
    //   475: invokevirtual 950	java/io/FileInputStream:close	()V
    //   478: return
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 1064	java/io/IOException:printStackTrace	()V
    //   484: return
    //   485: astore_2
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 950	java/io/FileInputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual 1064	java/io/IOException:printStackTrace	()V
    //   503: goto -7 -> 496
    //   506: astore_2
    //   507: goto -19 -> 488
    //   510: astore_3
    //   511: goto -61 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	bexd
    //   72	299	1	localObject1	Object
    //   384	2	1	localIOException1	java.io.IOException
    //   391	1	1	localObject2	Object
    //   439	2	1	localIOException2	java.io.IOException
    //   451	15	1	localObject3	Object
    //   479	2	1	localIOException3	java.io.IOException
    //   487	6	1	localObject4	Object
    //   498	2	1	localIOException4	java.io.IOException
    //   80	395	2	localObject5	Object
    //   485	12	2	localObject6	Object
    //   506	1	2	localObject7	Object
    //   447	14	3	localIOException5	java.io.IOException
    //   510	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   379	383	384	java/io/IOException
    //   404	408	439	java/io/IOException
    //   305	317	447	java/io/IOException
    //   474	478	479	java/io/IOException
    //   305	317	485	finally
    //   492	496	498	java/io/IOException
    //   319	328	506	finally
    //   330	337	506	finally
    //   339	369	506	finally
    //   371	375	506	finally
    //   392	400	506	finally
    //   452	457	506	finally
    //   459	464	506	finally
    //   466	470	506	finally
    //   319	328	510	java/io/IOException
    //   330	337	510	java/io/IOException
    //   339	369	510	java/io/IOException
    //   371	375	510	java/io/IOException
    //   392	400	510	java/io/IOException
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.m);
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
      this.jdField_a_of_type_Bluw.a();
      r();
      this.jdField_a_of_type_Bern.a.post(new ShortVideoForwardProcessor.1(this));
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
    int k = 2002;
    int i = 0;
    if (!f()) {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
    }
    Object localObject1;
    label238:
    do
    {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
      this.jdField_c_of_type_Berr.a();
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
      {
        localObject1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label266;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label238;
        }
      }
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Berr);
        d();
        return;
        if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          break;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        break;
      }
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if ((this.jdField_a_of_type_Beyg.jdField_e_of_type_Int == 1010) && (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null))
      {
        super.e();
        localObject2 = new azrh();
        ((azrh)localObject2).jdField_a_of_type_Int = 0;
        ((azrh)localObject2).jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        ((azrh)localObject2).jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        if (this.jdField_f_of_type_JavaLangString == null) {}
        for (localObject1 = this.jdField_l_of_type_JavaLangString;; localObject1 = this.jdField_f_of_type_JavaLangString)
        {
          ((azrh)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((azrh)localObject2).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
          ((azrh)localObject2).jdField_c_of_type_Int = this.z;
          ((azrh)localObject2).jdField_d_of_type_Int = this.A;
          this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a((azrh)localObject2);
          this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b((azrh)localObject2);
          return;
        }
      }
      ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Aocj);
    } while ((this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject == null) || (!(this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject instanceof bcwz)));
    label266:
    Object localObject2 = (bcwz)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject;
    bbjw localbbjw = new bbjw(BaseApplication.getContext());
    int j;
    switch (((bcwz)localObject2).jdField_c_of_type_Int)
    {
    default: 
      i = 5;
    case 0: 
      j = k;
      switch (((bcwz)localObject2).jdField_f_of_type_Int)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      localbbjw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((bcwz)localObject2).jdField_h_of_type_JavaLangString, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((bcwz)localObject2).jdField_m_of_type_JavaLangString, ((bcwz)localObject2).j, ((bcwz)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 1;
      break;
      i = 3000;
      break;
      i = 5;
      break;
      j = 2001;
      continue;
      j = 2003;
    }
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_Beyg.i != null) && (this.jdField_a_of_type_Beyg.i.length() > 0))
    {
      if ((this.e == null) || (this.e.length == 0)) {
        this.e = HexUtil.hexStr2Bytes(bhmi.c(this.jdField_a_of_type_Beyg.i));
      }
      File localFile = new File(this.jdField_a_of_type_Beyg.i);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        this.jdField_b_of_type_Long = localFile.length();
        this.jdField_b_of_type_JavaLangString = localFile.getName();
        return true;
      }
      b(9042, "onBusiProtoResp=> video file not exists");
      d();
      return false;
    }
    b(9302, "onBusiProtoResp=> video file path null");
    d();
    return false;
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
    if (this.w == 1) {
      return "actShortVideoForwardBDH";
    }
    return "actShortVideoForward";
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
    localMessageForShortVideo.videoFileSize = ((int)this.jdField_q_of_type_Long);
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
    if (-5100026 == this.jdField_k_of_type_Int) {
      d(5001);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
      {
        azrh localazrh = new azrh();
        localazrh.jdField_a_of_type_Int = -1;
        localazrh.jdField_b_of_type_Int = this.jdField_k_of_type_Int;
        localazrh.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
      }
      return;
      if (9042 == this.jdField_k_of_type_Int) {
        d(5002);
      } else {
        d(1005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.g) {
      bpxo.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramInt, f());
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
      localazrh.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      localazrh.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_l_of_type_JavaLangString;
        localazrh.jdField_c_of_type_JavaLangString = str;
        localazrh.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
        localazrh.jdField_c_of_type_Int = this.z;
        localazrh.jdField_d_of_type_Int = this.A;
        this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
      }
    }
    for (;;)
    {
      d(1003);
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      c(true);
    }
  }
  
  void f()
  {
    this.jdField_a_of_type_Berr.a();
    bfau localbfau = new bfau();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    }
    bfbh localbfbh = a();
    if (localbfbh == null) {}
    do
    {
      return;
      localbfau.jdField_a_of_type_Bfcb = this;
      localbfau.jdField_a_of_type_JavaLangString = "short_video_fw";
      localbfau.jdField_a_of_type_JavaUtilList.add(localbfbh);
      localbfau.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_a_of_type_Berr);
        d();
        return;
      }
      b("requestStart", localbfau.toString());
    } while (!f());
    this.jdField_a_of_type_Bfau = localbfau;
    bfca.a(localbfau);
  }
  
  public void g()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if (this.jdField_f_of_type_JavaLangString != null)
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        b(false);
        return;
      }
      if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      aN_();
      return;
    }
    aN_();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Berr.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      return;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Beyg.i, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read video file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read thumb file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = a();
    bfbh localbfbh = a();
    if (localbfbh == null)
    {
      b(9302, "makeShortVideoForwardReq failed");
      d();
      return;
    }
    byte[] arrayOfByte = a(localbfbh);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH . ,shortVideoReq.md5 :" + HexUtil.bytes2HexStr(localbfbh.jdField_a_of_type_ArrayOfByte) + ",shortVideoReq.thumbFileMd5 = " + HexUtil.bytes2HexStr(localbfbh.jdField_b_of_type_ArrayOfByte) + ",mLocalMd5 = " + HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte));
    }
    bexe localbexe = new bexe(this, (String)localObject, l);
    if (localbfbh.jdField_c_of_type_Int == 0) {}
    for (int i = 25;; i = 12)
    {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), i, (String)localObject, (int)this.jdField_r_of_type_Long, this.jdField_b_of_type_ArrayOfByte, localbexe, arrayOfByte, true);
      localObject = new bexf(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 12);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Berr);
      d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexd
 * JD-Core Version:    0.7.0.1
 */