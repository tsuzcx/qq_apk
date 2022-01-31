import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor.2;
import com.tencent.mobileqq.transfile.LightVideoUploadProcessor.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class bauo
  extends bark
{
  public static boolean a;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long;
  alwx jdField_a_of_type_Alwx = new baup(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  axxo jdField_a_of_type_Axxo;
  private axxp jdField_a_of_type_Axxp;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  private MessageForLightVideo jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo;
  Bdh_extinfo.PicInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
  RequestAck jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck;
  String jdField_a_of_type_JavaLangString;
  Map<Integer, Bdh_extinfo.VideoInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected int b;
  private long jdField_b_of_type_Long;
  protected RandomAccessFile b;
  private String jdField_b_of_type_JavaLangString;
  public ArrayList<axxo> b;
  List<Transaction> jdField_b_of_type_JavaUtilList = new ArrayList();
  public Map<Integer, axxo> b;
  boolean jdField_b_of_type_Boolean = false;
  protected int c;
  private long c;
  private byte[] d;
  int x;
  private volatile int y;
  
  public bauo(bard parambard, bayk parambayk)
  {
    super(parambard, parambayk);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    parambard = parambayk.jdField_b_of_type_JavaLangObject;
    if ((parambard != null) && ((parambard instanceof axxp))) {
      this.jdField_a_of_type_Axxp = ((axxp)parambayk.jdField_b_of_type_JavaLangObject);
    }
    if ((this.jdField_a_of_type_Bard != null) && (this.jdField_a_of_type_Bard.a != null)) {
      this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Bard.a;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = ((MessageForLightVideo)parambayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    jdField_a_of_type_Boolean = VideoUpConfigInfo.sIsPreSendSignal;
  }
  
  private bbbl a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "makeShortVideoUpReq");
    }
    bbbl localbbbl = new bbbl();
    localbbbl.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbbbl.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbbl.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbbl.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbbl.i = 0;
    if ((localbbbl.f == 0) || (1008 == localbbbl.f))
    {
      localbbbl.jdField_b_of_type_JavaLangString = null;
      if (localbbbl.f != 0) {
        break label254;
      }
      localbbbl.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localbbbl.jdField_b_of_type_Int = 2;
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      localbbbl.jdField_a_of_type_JavaLangString = ((File)localObject).getName();
      localbbbl.jdField_a_of_type_Long = ((File)localObject).length();
      localbbbl.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      localbbbl.jdField_b_of_type_ArrayOfByte = this.d;
      localbbbl.e = this.jdField_c_of_type_Int;
      localbbbl.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      localbbbl.h = this.x;
      localbbbl.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localObject = this.jdField_a_of_type_Bass;
      long l = localbbbl.jdField_a_of_type_Long + this.jdField_b_of_type_Long;
      this.q = l;
      ((bass)localObject).jdField_a_of_type_Long = l;
      localbbbl.g = 3;
      localbbbl.k = 3;
      localbbbl.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.busiType;
      return localbbbl;
      localbbbl.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
      break;
      label254:
      if (1 == localbbbl.f) {
        localbbbl.jdField_a_of_type_Int = 1;
      } else if (3000 == localbbbl.f) {
        localbbbl.jdField_a_of_type_Int = 2;
      } else {
        localbbbl.jdField_a_of_type_Int = 3;
      }
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
        if (this.f != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.f));
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoUploadProcessor", 2, "constructRichText ,mResid uuid=" + this.f + " mLocalVideoTime:" + this.x + " mVideoTime:" + this.jdField_c_of_type_Long);
        }
        if (!(this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label659;
        }
        Object localObject1 = (MessageForLightVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        Object localObject3;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForLightVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForLightVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForLightVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForLightVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForLightVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForLightVideo)localObject1).subBusiType);
          localObject3 = new videoFile.ResvAttr();
          ((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.set(((MessageForLightVideo)localObject1).msgTailType);
          localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString));
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bayk.f)));
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(0);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)(this.q - this.jdField_b_of_type_Long));
        if (this.x == 0)
        {
          if ((this.jdField_a_of_type_Axxp != null) && (this.jdField_a_of_type_Axxp.jdField_b_of_type_Int != 0))
          {
            localVideoFile.uint32_file_time.set(this.jdField_a_of_type_Axxp.jdField_b_of_type_Int / 1000);
            localVideoFile.uint32_thumb_width.set(this.jdField_c_of_type_Int);
            localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.d));
            localVideoFile.uint32_thumb_file_size.set((int)this.jdField_b_of_type_Long);
            localVideoFile.uint32_from_chat_type.set(-1);
            localVideoFile.uint32_to_chat_type.set(-1);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            localObject1 = alud.a(2131706434);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(BaseApplication.getContext().getString(2131691348)));
            Object localObject4 = new TextMsgExtPb.ResvAttr();
            ((TextMsgExtPb.ResvAttr)localObject4).wording.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            ((im_msg_body.Text)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject4).toByteArray()));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            localObject4 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(27);
            ((im_msg_body.CommonElem)localObject4).uint32_business_type.set(1);
            hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
            localMsgElemInfo_servtype27.video_file.set(localVideoFile);
            ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype27.toByteArray()));
            ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject4);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          localVideoFile.uint32_file_time.set((int)this.jdField_c_of_type_Long);
          continue;
        }
        localVideoFile.uint32_file_time.set(this.x);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LightVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      continue;
      label659:
      Object localObject2 = null;
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_b_of_type_JavaIoRandomAccessFile != null) && (this.jdField_a_of_type_JavaIoRandomAccessFile != null)) {}
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
        try
        {
          this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "r");
          if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
            return false;
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
      if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
        continue;
      }
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile != null) {
          continue;
        }
        return false;
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
  }
  
  /* Error */
  private void t()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +12 -> 18
    //   9: ldc 120
    //   11: iconst_2
    //   12: ldc_w 486
    //   15: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: invokestatic 491	android/os/SystemClock:uptimeMillis	()J
    //   21: lstore_2
    //   22: aload_0
    //   23: getfield 175	bauo:d	[B
    //   26: arraylength
    //   27: aload_0
    //   28: getfield 172	bauo:jdField_a_of_type_ArrayOfByte	[B
    //   31: arraylength
    //   32: iadd
    //   33: newarray byte
    //   35: astore 5
    //   37: aload_0
    //   38: getfield 175	bauo:d	[B
    //   41: iconst_0
    //   42: aload 5
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 175	bauo:d	[B
    //   49: arraylength
    //   50: invokestatic 497	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   53: aload_0
    //   54: getfield 172	bauo:jdField_a_of_type_ArrayOfByte	[B
    //   57: iconst_0
    //   58: aload 5
    //   60: aload_0
    //   61: getfield 175	bauo:d	[B
    //   64: arraylength
    //   65: aload_0
    //   66: getfield 172	bauo:jdField_a_of_type_ArrayOfByte	[B
    //   69: arraylength
    //   70: invokestatic 497	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   73: new 247	java/lang/StringBuilder
    //   76: dup
    //   77: invokestatic 501	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   80: invokespecial 502	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 5
    //   85: invokestatic 506	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   88: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 508
    //   94: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore 10
    //   102: invokestatic 491	android/os/SystemClock:uptimeMillis	()J
    //   105: pop2
    //   106: new 155	java/io/File
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 511	java/io/File:delete	()Z
    //   118: pop
    //   119: new 155	java/io/File
    //   122: dup
    //   123: aload 10
    //   125: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 5
    //   130: aload 5
    //   132: invokevirtual 514	java/io/File:exists	()Z
    //   135: istore 4
    //   137: iload 4
    //   139: ifne +9 -> 148
    //   142: aload 5
    //   144: invokevirtual 517	java/io/File:createNewFile	()Z
    //   147: pop
    //   148: new 519	java/io/FileOutputStream
    //   151: dup
    //   152: aload 5
    //   154: invokespecial 522	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: astore 5
    //   159: new 524	java/io/BufferedOutputStream
    //   162: dup
    //   163: aload 5
    //   165: invokespecial 527	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   168: astore 7
    //   170: aload 5
    //   172: astore 8
    //   174: aload 7
    //   176: astore 6
    //   178: aload_0
    //   179: invokespecial 529	bauo:a	()Z
    //   182: ifne +642 -> 824
    //   185: aload 5
    //   187: astore 8
    //   189: aload 7
    //   191: astore 6
    //   193: aload_0
    //   194: sipush 9303
    //   197: ldc_w 531
    //   200: invokevirtual 534	bauo:b	(ILjava/lang/String;)V
    //   203: aload 5
    //   205: astore 8
    //   207: aload 7
    //   209: astore 6
    //   211: aload_0
    //   212: invokevirtual 536	bauo:d	()V
    //   215: aload 7
    //   217: ifnull +8 -> 225
    //   220: aload 7
    //   222: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   225: aload 5
    //   227: ifnull +8 -> 235
    //   230: aload 5
    //   232: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   235: return
    //   236: astore 6
    //   238: aload 6
    //   240: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   243: goto -95 -> 148
    //   246: astore 8
    //   248: aconst_null
    //   249: astore 6
    //   251: aload 7
    //   253: astore 5
    //   255: aload 8
    //   257: astore 7
    //   259: aload 7
    //   261: invokevirtual 479	java/io/FileNotFoundException:printStackTrace	()V
    //   264: aload 6
    //   266: ifnull +8 -> 274
    //   269: aload 6
    //   271: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   274: aload 5
    //   276: ifnull +8 -> 284
    //   279: aload 5
    //   281: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   284: aload_0
    //   285: invokespecial 543	bauo:a	()Lbbbl;
    //   288: astore 5
    //   290: new 545	pttcenterservice/PttShortVideo$PttShortVideoUploadReq
    //   293: dup
    //   294: invokespecial 546	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:<init>	()V
    //   297: astore 6
    //   299: aload 6
    //   301: iconst_1
    //   302: invokevirtual 547	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:setHasFlag	(Z)V
    //   305: aload 6
    //   307: getfield 551	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_fromuin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   310: aload 5
    //   312: getfield 139	bbbl:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   315: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   318: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   321: aload 6
    //   323: getfield 565	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_touin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   326: aload 5
    //   328: getfield 142	bbbl:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   331: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   334: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   337: aload 6
    //   339: getfield 568	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_chat_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   342: aload 5
    //   344: getfield 151	bbbl:jdField_a_of_type_Int	I
    //   347: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   350: aload 6
    //   352: getfield 571	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_client_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: aload 5
    //   357: getfield 153	bbbl:jdField_b_of_type_Int	I
    //   360: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   363: aload 5
    //   365: getfield 150	bbbl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   368: ifnull +821 -> 1189
    //   371: aload 6
    //   373: getfield 574	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   376: aload 5
    //   378: getfield 150	bbbl:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   381: invokestatic 557	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   384: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   387: aload 6
    //   389: getfield 577	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_agent_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: aload 5
    //   394: getfield 149	bbbl:i	I
    //   397: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   400: aload 6
    //   402: getfield 578	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   405: aload 5
    //   407: getfield 213	bbbl:jdField_j_of_type_Int	I
    //   410: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   413: aload 6
    //   415: getfield 581	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_flag_support_large_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   418: iconst_1
    //   419: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   422: aload 6
    //   424: getfield 584	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint32_sub_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   427: iconst_3
    //   428: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   431: new 586	pttcenterservice/PttShortVideo$PttShortVideoFileInfo
    //   434: dup
    //   435: invokespecial 587	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:<init>	()V
    //   438: astore 7
    //   440: aload 7
    //   442: getfield 591	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   445: aload 5
    //   447: getfield 165	bbbl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   450: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   453: aload 7
    //   455: getfield 596	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   458: aload 5
    //   460: getfield 173	bbbl:jdField_a_of_type_ArrayOfByte	[B
    //   463: invokestatic 339	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   466: invokevirtual 245	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   469: aload 7
    //   471: getfield 597	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   474: aload 5
    //   476: getfield 177	bbbl:jdField_b_of_type_ArrayOfByte	[B
    //   479: invokestatic 339	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   482: invokevirtual 245	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   485: aload 7
    //   487: getfield 600	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   490: aload 5
    //   492: getfield 170	bbbl:jdField_a_of_type_Long	J
    //   495: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   498: aload 7
    //   500: getfield 603	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_length	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   503: aload 5
    //   505: getfield 184	bbbl:jdField_d_of_type_Int	I
    //   508: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   511: aload 7
    //   513: getfield 606	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_res_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   516: aload 5
    //   518: getfield 181	bbbl:e	I
    //   521: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   524: aload 7
    //   526: getfield 607	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   529: aload 5
    //   531: getfield 204	bbbl:g	I
    //   534: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   537: aload 7
    //   539: getfield 608	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   542: aload 5
    //   544: getfield 189	bbbl:h	I
    //   547: invokevirtual 282	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   550: aload 7
    //   552: getfield 611	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:uint64_thumb_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   555: aload 5
    //   557: getfield 192	bbbl:jdField_b_of_type_Long	J
    //   560: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   563: aload 6
    //   565: getfield 615	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:msg_PttShortVideoFileInfo	Lpttcenterservice/PttShortVideo$PttShortVideoFileInfo;
    //   568: aload 7
    //   570: invokevirtual 616	pttcenterservice/PttShortVideo$PttShortVideoFileInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   573: aload 6
    //   575: invokevirtual 617	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:toByteArray	()[B
    //   578: astore 5
    //   580: new 619	com/tencent/qphone/base/util/Cryptor
    //   583: dup
    //   584: invokespecial 620	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   587: aload 5
    //   589: aload_0
    //   590: getfield 621	bauo:jdField_b_of_type_ArrayOfByte	[B
    //   593: invokevirtual 625	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   596: astore 5
    //   598: new 627	bauq
    //   601: dup
    //   602: aload_0
    //   603: aload 10
    //   605: lload_2
    //   606: invokespecial 630	bauq:<init>	(Lbauo;Ljava/lang/String;J)V
    //   609: astore 6
    //   611: aload_0
    //   612: new 632	com/tencent/mobileqq/highway/transaction/Transaction
    //   615: dup
    //   616: aload_0
    //   617: getfield 69	bauo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   620: invokevirtual 635	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   623: bipush 12
    //   625: aload 10
    //   627: aload_0
    //   628: getfield 637	bauo:r	J
    //   631: l2i
    //   632: aload_0
    //   633: getfield 639	bauo:jdField_c_of_type_ArrayOfByte	[B
    //   636: aload_0
    //   637: getfield 172	bauo:jdField_a_of_type_ArrayOfByte	[B
    //   640: aload 6
    //   642: aload 5
    //   644: invokespecial 642	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   647: putfield 645	bauo:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   650: aload_0
    //   651: getfield 69	bauo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   654: invokevirtual 649	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   657: aload_0
    //   658: getfield 645	bauo:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   661: invokevirtual 655	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   664: istore_1
    //   665: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +114 -> 782
    //   671: ldc 120
    //   673: iconst_2
    //   674: new 247	java/lang/StringBuilder
    //   677: dup
    //   678: invokespecial 248	java/lang/StringBuilder:<init>	()V
    //   681: ldc_w 657
    //   684: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: iload_1
    //   688: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   691: ldc_w 659
    //   694: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload_0
    //   698: getfield 645	bauo:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   701: invokevirtual 663	com/tencent/mobileqq/highway/transaction/Transaction:getTransationId	()I
    //   704: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: ldc_w 665
    //   710: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload_0
    //   714: getfield 131	bauo:jdField_a_of_type_Bayk	Lbayk;
    //   717: getfield 133	bayk:jdField_a_of_type_Long	J
    //   720: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: ldc_w 667
    //   726: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload_0
    //   730: getfield 668	bauo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   733: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 670
    //   739: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_0
    //   743: getfield 673	bauo:l	Ljava/lang/String;
    //   746: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: ldc_w 675
    //   752: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_0
    //   756: getfield 645	bauo:jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   759: getfield 678	com/tencent/mobileqq/highway/transaction/Transaction:filePath	Ljava/lang/String;
    //   762: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 680
    //   768: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: bipush 12
    //   773: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   776: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: iload_1
    //   783: ifeq -548 -> 235
    //   786: aload_0
    //   787: iload_1
    //   788: ldc_w 682
    //   791: ldc_w 684
    //   794: aload_0
    //   795: getfield 687	bauo:jdField_b_of_type_Barh	Lbarh;
    //   798: invokevirtual 690	bauo:a	(ILjava/lang/String;Ljava/lang/String;Lbarh;)V
    //   801: aload_0
    //   802: invokevirtual 536	bauo:d	()V
    //   805: return
    //   806: astore 6
    //   808: aload 6
    //   810: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   813: goto -588 -> 225
    //   816: astore 5
    //   818: aload 5
    //   820: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   823: return
    //   824: aload 5
    //   826: astore 8
    //   828: aload 7
    //   830: astore 6
    //   832: aload_0
    //   833: getfield 468	bauo:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   836: invokevirtual 691	java/io/RandomAccessFile:length	()J
    //   839: l2i
    //   840: newarray byte
    //   842: astore 9
    //   844: aload 5
    //   846: astore 8
    //   848: aload 7
    //   850: astore 6
    //   852: aload_0
    //   853: getfield 468	bauo:jdField_b_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   856: aload 9
    //   858: invokevirtual 695	java/io/RandomAccessFile:read	([B)I
    //   861: pop
    //   862: aload 5
    //   864: astore 8
    //   866: aload 7
    //   868: astore 6
    //   870: aload 7
    //   872: aload 9
    //   874: invokevirtual 699	java/io/BufferedOutputStream:write	([B)V
    //   877: aload 5
    //   879: astore 8
    //   881: aload 7
    //   883: astore 6
    //   885: ldc_w 700
    //   888: newarray byte
    //   890: astore 9
    //   892: aload 5
    //   894: astore 8
    //   896: aload 7
    //   898: astore 6
    //   900: aload_0
    //   901: getfield 470	bauo:jdField_a_of_type_JavaIoRandomAccessFile	Ljava/io/RandomAccessFile;
    //   904: aload 9
    //   906: invokevirtual 695	java/io/RandomAccessFile:read	([B)I
    //   909: istore_1
    //   910: iload_1
    //   911: iconst_m1
    //   912: if_icmpeq +23 -> 935
    //   915: aload 5
    //   917: astore 8
    //   919: aload 7
    //   921: astore 6
    //   923: aload 7
    //   925: aload 9
    //   927: iconst_0
    //   928: iload_1
    //   929: invokevirtual 703	java/io/BufferedOutputStream:write	([BII)V
    //   932: goto -40 -> 892
    //   935: aload 5
    //   937: astore 8
    //   939: aload 7
    //   941: astore 6
    //   943: invokestatic 491	android/os/SystemClock:uptimeMillis	()J
    //   946: pop2
    //   947: aload 7
    //   949: ifnull +8 -> 957
    //   952: aload 7
    //   954: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   957: aload 5
    //   959: ifnull -675 -> 284
    //   962: aload 5
    //   964: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   967: goto -683 -> 284
    //   970: astore 5
    //   972: aload 5
    //   974: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   977: goto -693 -> 284
    //   980: astore 6
    //   982: aload 6
    //   984: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   987: goto -30 -> 957
    //   990: astore 6
    //   992: aload 6
    //   994: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   997: goto -723 -> 274
    //   1000: astore 5
    //   1002: aload 5
    //   1004: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1007: goto -723 -> 284
    //   1010: astore 9
    //   1012: aconst_null
    //   1013: astore 5
    //   1015: aconst_null
    //   1016: astore 7
    //   1018: aload 5
    //   1020: astore 8
    //   1022: aload 7
    //   1024: astore 6
    //   1026: aload 9
    //   1028: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1031: aload 7
    //   1033: ifnull +8 -> 1041
    //   1036: aload 7
    //   1038: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   1041: aload 5
    //   1043: ifnull -759 -> 284
    //   1046: aload 5
    //   1048: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   1051: goto -767 -> 284
    //   1054: astore 5
    //   1056: aload 5
    //   1058: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1061: goto -777 -> 284
    //   1064: astore 6
    //   1066: aload 6
    //   1068: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1071: goto -30 -> 1041
    //   1074: astore 9
    //   1076: aconst_null
    //   1077: astore 5
    //   1079: aconst_null
    //   1080: astore 7
    //   1082: aload 5
    //   1084: astore 8
    //   1086: aload 7
    //   1088: astore 6
    //   1090: aload 9
    //   1092: invokevirtual 704	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1095: aload 7
    //   1097: ifnull +8 -> 1105
    //   1100: aload 7
    //   1102: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   1105: aload 5
    //   1107: ifnull -823 -> 284
    //   1110: aload 5
    //   1112: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   1115: goto -831 -> 284
    //   1118: astore 5
    //   1120: aload 5
    //   1122: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1125: goto -841 -> 284
    //   1128: astore 6
    //   1130: aload 6
    //   1132: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1135: goto -30 -> 1105
    //   1138: astore 7
    //   1140: aconst_null
    //   1141: astore 5
    //   1143: aconst_null
    //   1144: astore 6
    //   1146: aload 6
    //   1148: ifnull +8 -> 1156
    //   1151: aload 6
    //   1153: invokevirtual 539	java/io/BufferedOutputStream:close	()V
    //   1156: aload 5
    //   1158: ifnull +8 -> 1166
    //   1161: aload 5
    //   1163: invokevirtual 540	java/io/FileOutputStream:close	()V
    //   1166: aload 7
    //   1168: athrow
    //   1169: astore 6
    //   1171: aload 6
    //   1173: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1176: goto -20 -> 1156
    //   1179: astore 5
    //   1181: aload 5
    //   1183: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   1186: goto -20 -> 1166
    //   1189: aload 6
    //   1191: getfield 574	pttcenterservice/PttShortVideo$PttShortVideoUploadReq:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1194: lconst_0
    //   1195: invokevirtual 562	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1198: goto -811 -> 387
    //   1201: astore 7
    //   1203: aconst_null
    //   1204: astore 6
    //   1206: goto -60 -> 1146
    //   1209: astore 7
    //   1211: aload 8
    //   1213: astore 5
    //   1215: goto -69 -> 1146
    //   1218: astore 7
    //   1220: goto -74 -> 1146
    //   1223: astore 9
    //   1225: aconst_null
    //   1226: astore 7
    //   1228: goto -146 -> 1082
    //   1231: astore 9
    //   1233: goto -151 -> 1082
    //   1236: astore 9
    //   1238: aconst_null
    //   1239: astore 7
    //   1241: goto -223 -> 1018
    //   1244: astore 9
    //   1246: goto -228 -> 1018
    //   1249: astore 7
    //   1251: aconst_null
    //   1252: astore 6
    //   1254: goto -995 -> 259
    //   1257: astore 8
    //   1259: aload 7
    //   1261: astore 6
    //   1263: aload 8
    //   1265: astore 7
    //   1267: goto -1008 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1270	0	this	bauo
    //   664	265	1	i	int
    //   21	585	2	l	long
    //   135	3	4	bool	boolean
    //   35	608	5	localObject1	Object
    //   816	147	5	localIOException1	IOException
    //   970	3	5	localIOException2	IOException
    //   1000	3	5	localIOException3	IOException
    //   1013	34	5	localObject2	Object
    //   1054	3	5	localIOException4	IOException
    //   1077	34	5	localObject3	Object
    //   1118	3	5	localIOException5	IOException
    //   1141	21	5	localObject4	Object
    //   1179	3	5	localIOException6	IOException
    //   1213	1	5	localObject5	Object
    //   176	34	6	localObject6	Object
    //   236	3	6	localIOException7	IOException
    //   249	392	6	localObject7	Object
    //   806	3	6	localIOException8	IOException
    //   830	112	6	localObject8	Object
    //   980	3	6	localIOException9	IOException
    //   990	3	6	localIOException10	IOException
    //   1024	1	6	localObject9	Object
    //   1064	3	6	localIOException11	IOException
    //   1088	1	6	localObject10	Object
    //   1128	3	6	localIOException12	IOException
    //   1144	8	6	localObject11	Object
    //   1169	21	6	localIOException13	IOException
    //   1204	58	6	localFileNotFoundException1	FileNotFoundException
    //   1	1100	7	localObject12	Object
    //   1138	29	7	localObject13	Object
    //   1201	1	7	localObject14	Object
    //   1209	1	7	localObject15	Object
    //   1218	1	7	localObject16	Object
    //   1226	14	7	localObject17	Object
    //   1249	11	7	localFileNotFoundException2	FileNotFoundException
    //   1265	1	7	localObject18	Object
    //   172	34	8	localObject19	Object
    //   246	10	8	localFileNotFoundException3	FileNotFoundException
    //   826	386	8	localObject20	Object
    //   1257	7	8	localFileNotFoundException4	FileNotFoundException
    //   842	84	9	arrayOfByte	byte[]
    //   1010	17	9	localIOException14	IOException
    //   1074	17	9	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1223	1	9	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1231	1	9	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1236	1	9	localIOException15	IOException
    //   1244	1	9	localIOException16	IOException
    //   100	526	10	str	String
    // Exception table:
    //   from	to	target	type
    //   142	148	236	java/io/IOException
    //   102	137	246	java/io/FileNotFoundException
    //   142	148	246	java/io/FileNotFoundException
    //   148	159	246	java/io/FileNotFoundException
    //   238	243	246	java/io/FileNotFoundException
    //   220	225	806	java/io/IOException
    //   230	235	816	java/io/IOException
    //   962	967	970	java/io/IOException
    //   952	957	980	java/io/IOException
    //   269	274	990	java/io/IOException
    //   279	284	1000	java/io/IOException
    //   102	137	1010	java/io/IOException
    //   148	159	1010	java/io/IOException
    //   238	243	1010	java/io/IOException
    //   1046	1051	1054	java/io/IOException
    //   1036	1041	1064	java/io/IOException
    //   102	137	1074	java/lang/OutOfMemoryError
    //   142	148	1074	java/lang/OutOfMemoryError
    //   148	159	1074	java/lang/OutOfMemoryError
    //   238	243	1074	java/lang/OutOfMemoryError
    //   1110	1115	1118	java/io/IOException
    //   1100	1105	1128	java/io/IOException
    //   102	137	1138	finally
    //   142	148	1138	finally
    //   148	159	1138	finally
    //   238	243	1138	finally
    //   1151	1156	1169	java/io/IOException
    //   1161	1166	1179	java/io/IOException
    //   159	170	1201	finally
    //   178	185	1209	finally
    //   193	203	1209	finally
    //   211	215	1209	finally
    //   832	844	1209	finally
    //   852	862	1209	finally
    //   870	877	1209	finally
    //   885	892	1209	finally
    //   900	910	1209	finally
    //   923	932	1209	finally
    //   943	947	1209	finally
    //   1026	1031	1209	finally
    //   1090	1095	1209	finally
    //   259	264	1218	finally
    //   159	170	1223	java/lang/OutOfMemoryError
    //   178	185	1231	java/lang/OutOfMemoryError
    //   193	203	1231	java/lang/OutOfMemoryError
    //   211	215	1231	java/lang/OutOfMemoryError
    //   832	844	1231	java/lang/OutOfMemoryError
    //   852	862	1231	java/lang/OutOfMemoryError
    //   870	877	1231	java/lang/OutOfMemoryError
    //   885	892	1231	java/lang/OutOfMemoryError
    //   900	910	1231	java/lang/OutOfMemoryError
    //   923	932	1231	java/lang/OutOfMemoryError
    //   943	947	1231	java/lang/OutOfMemoryError
    //   159	170	1236	java/io/IOException
    //   178	185	1244	java/io/IOException
    //   193	203	1244	java/io/IOException
    //   211	215	1244	java/io/IOException
    //   832	844	1244	java/io/IOException
    //   852	862	1244	java/io/IOException
    //   870	877	1244	java/io/IOException
    //   885	892	1244	java/io/IOException
    //   900	910	1244	java/io/IOException
    //   923	932	1244	java/io/IOException
    //   943	947	1244	java/io/IOException
    //   159	170	1249	java/io/FileNotFoundException
    //   178	185	1257	java/io/FileNotFoundException
    //   193	203	1257	java/io/FileNotFoundException
    //   211	215	1257	java/io/FileNotFoundException
    //   832	844	1257	java/io/FileNotFoundException
    //   852	862	1257	java/io/FileNotFoundException
    //   870	877	1257	java/io/FileNotFoundException
    //   885	892	1257	java/io/FileNotFoundException
    //   900	910	1257	java/io/FileNotFoundException
    //   923	932	1257	java/io/FileNotFoundException
    //   943	947	1257	java/io/FileNotFoundException
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "cancel");
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelAckRequest(this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    this.jdField_a_of_type_Axxp = null;
    return super.a();
  }
  
  public void a(axxo paramaxxo)
  {
    if (paramaxxo.a())
    {
      b(paramaxxo);
      return;
    }
    if (paramaxxo.b())
    {
      d(paramaxxo);
      return;
    }
    c(paramaxxo);
  }
  
  /* Error */
  void a(baus parambaus)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 748	baus:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: astore 5
    //   8: aload_1
    //   9: getfield 749	baus:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 6
    //   14: aload_1
    //   15: getfield 750	baus:jdField_b_of_type_ArrayOfByte	[B
    //   18: astore 7
    //   20: aload_1
    //   21: getfield 751	baus:jdField_c_of_type_ArrayOfByte	[B
    //   24: astore 8
    //   26: aload_1
    //   27: getfield 752	baus:jdField_a_of_type_Int	I
    //   30: istore_2
    //   31: aload_1
    //   32: getfield 753	baus:d	[B
    //   35: astore 9
    //   37: aload_1
    //   38: getfield 755	baus:jdField_a_of_type_Axxo	Laxxo;
    //   41: astore 9
    //   43: aload_1
    //   44: getfield 756	baus:jdField_a_of_type_Long	J
    //   47: lstore_3
    //   48: new 758	baut
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 759	baut:<init>	(Lbauo;)V
    //   56: astore_1
    //   57: new 632	com/tencent/mobileqq/highway/transaction/Transaction
    //   60: dup
    //   61: aload_0
    //   62: getfield 69	bauo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 635	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: bipush 16
    //   70: aload 5
    //   72: iconst_0
    //   73: aload 6
    //   75: aload 7
    //   77: aload_1
    //   78: aload 8
    //   80: invokespecial 642	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 106	bauo:y	I
    //   89: ifeq +12 -> 101
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 106	bauo:y	I
    //   98: putfield 762	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   101: aload_1
    //   102: aload 5
    //   104: putfield 764	baut:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   107: aload_1
    //   108: iload_2
    //   109: putfield 765	baut:jdField_a_of_type_Int	I
    //   112: aload_1
    //   113: aload 9
    //   115: putfield 766	baut:jdField_a_of_type_Axxo	Laxxo;
    //   118: aload_0
    //   119: getfield 69	bauo:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 649	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   125: aload 5
    //   127: invokevirtual 655	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +11 -> 143
    //   135: aload_0
    //   136: iload_2
    //   137: invokevirtual 768	bauo:f	(I)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload_0
    //   144: getfield 44	bauo:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   147: aload 5
    //   149: invokeinterface 771 2 0
    //   154: pop
    //   155: goto -15 -> 140
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	bauo
    //   0	163	1	parambaus	baus
    //   30	107	2	i	int
    //   47	1	3	l	long
    //   6	142	5	localObject1	Object
    //   12	62	6	arrayOfByte1	byte[]
    //   18	58	7	arrayOfByte2	byte[]
    //   24	55	8	arrayOfByte3	byte[]
    //   35	79	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	101	158	finally
    //   101	131	158	finally
    //   135	140	158	finally
    //   143	155	158	finally
  }
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbcc)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambbax.jdField_c_of_type_Int);
        }
        this.f = parambbax.jdField_a_of_type_JavaLangString;
        if (parambbax.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parambbax.jdField_a_of_type_Boolean);
          }
          if (parambbax.jdField_a_of_type_Boolean)
          {
            d(1007);
            b(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (g())
          {
            t();
          }
          else
          {
            d();
            continue;
            b(parambbax.jdField_c_of_type_Int, "onBusiProtoResp error");
            d();
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    long l;
    if ((this.jdField_a_of_type_Axxp != null) && (this.jdField_a_of_type_Axxp.jdField_b_of_type_Long != 0L))
    {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Axxp.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.q + " mUploadType:" + this.jdField_a_of_type_Int + " errorCode:" + this.jdField_j_of_type_Int);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      if (!paramBoolean) {
        break label197;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("upload_suc_flag", "1");
    }
    while ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_JavaUtilHashMap.put("upload_segment_fail_flag", "1");
      }
      azri.a(BaseApplication.getContext()).a(null, "LightVideoSend", paramBoolean, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      label197:
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("upload_type", String.valueOf(this.jdField_a_of_type_Int));
    azri.a(BaseApplication.getContext()).a(null, "LightVideoSendComplete", paramBoolean, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, null);
  }
  
  public void aP_()
  {
    super.aP_();
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_j_of_type_JavaLangString;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bayk.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Bayk.k == null) {
      this.d = HexUtil.hexStr2Bytes(aygu.a(this.jdField_b_of_type_JavaLangString));
    }
    this.d = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bayk.k);
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize = ((int)new File(this.jdField_b_of_type_JavaLangString).length());
    }
    this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbFileSize;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbWidth;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.thumbHeight;
    o();
    if (g()) {
      if (this.jdField_a_of_type_Axxp != null) {
        if (this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean)
        {
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_Axxp.a(this);
          label234:
          d(1001);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "start, mUploadType = " + this.jdField_a_of_type_Int);
      }
      return;
      this.jdField_a_of_type_Int = 2;
      break;
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bayk.f == null) {
        this.jdField_a_of_type_Bayk.f = aygu.a(this.jdField_a_of_type_JavaLangString);
      }
      localObject = this.jdField_a_of_type_Bass;
      String str = this.jdField_a_of_type_Bayk.f;
      ((bass)localObject).f = str;
      this.jdField_c_of_type_JavaLangString = str;
      this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bayk.f);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime == 0))
      {
        localObject = new azkl();
        azkk.a(this.jdField_a_of_type_JavaLangString, (azkl)localObject);
        int i = localObject.a[3];
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)new File(this.jdField_a_of_type_JavaLangString).length());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
      }
      this.q = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize;
      this.x = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime;
      f();
      break label234;
      HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Axxp.a(this);
    }
  }
  
  void b(axxo paramaxxo)
  {
    String str = paramaxxo.jdField_a_of_type_JavaLangString;
    int i = (int)this.jdField_b_of_type_Long;
    byte[] arrayOfByte1 = this.jdField_c_of_type_ArrayOfByte;
    byte[] arrayOfByte3 = this.jdField_b_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.d;
    long l = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + str + " index :" + paramaxxo.jdField_d_of_type_Int + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + i);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(1);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l);
    if (jdField_a_of_type_Boolean) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(i);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo = localPicInfo;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(localPicInfo);
      arrayOfByte3 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), arrayOfByte3);
      localObject = new baus(this);
      ((baus)localObject).jdField_a_of_type_JavaLangString = str;
      ((baus)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte1;
      ((baus)localObject).jdField_b_of_type_ArrayOfByte = arrayOfByte2;
      ((baus)localObject).jdField_c_of_type_ArrayOfByte = arrayOfByte3;
      ((baus)localObject).jdField_a_of_type_Int = 0;
      ((baus)localObject).d = arrayOfByte2;
      ((baus)localObject).jdField_a_of_type_Axxo = paramaxxo;
      ((baus)localObject).jdField_a_of_type_Long = i;
      a((baus)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Axxp != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "confirm send:" + this.jdField_a_of_type_Axxp.b());
      }
      if (!this.jdField_a_of_type_Axxp.b()) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMsg() start.");
    }
    im_msg_body.RichText localRichText = a();
    if (localRichText == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Barh);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.richText = localRichText;
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, this.jdField_a_of_type_Alwx);
  }
  
  void c(axxo paramaxxo)
  {
    String str = paramaxxo.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.d;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(paramaxxo.jdField_b_of_type_JavaLangString);
    int j = paramaxxo.jdField_d_of_type_Int;
    int k = paramaxxo.jdField_b_of_type_Int;
    int m = paramaxxo.jdField_a_of_type_Int;
    int n = paramaxxo.e;
    long l = paramaxxo.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + j + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + i);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.jdField_a_of_type_Long);
    if (jdField_a_of_type_Boolean) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(i);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint64_starttime.set(l);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(0);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.jdField_b_of_type_ArrayOfByte);
      localObject2 = new baus(this);
      ((baus)localObject2).jdField_a_of_type_JavaLangString = str;
      ((baus)localObject2).jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      ((baus)localObject2).jdField_b_of_type_ArrayOfByte = arrayOfByte1;
      ((baus)localObject2).jdField_c_of_type_ArrayOfByte = ((byte[])localObject1);
      ((baus)localObject2).jdField_a_of_type_Int = j;
      ((baus)localObject2).d = arrayOfByte2;
      ((baus)localObject2).jdField_a_of_type_Axxo = paramaxxo;
      ((baus)localObject2).jdField_a_of_type_Long = i;
      a((baus)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onError");
    }
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      awki localawki = new awki();
      localawki.jdField_a_of_type_Int = -1;
      localawki.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localawki.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
    }
  }
  
  public void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMessageToUpdate,state = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileStatus = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.msgData);
  }
  
  void d(axxo paramaxxo)
  {
    String str = paramaxxo.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.d;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(paramaxxo.jdField_b_of_type_JavaLangString);
    int j = paramaxxo.jdField_d_of_type_Int;
    int k = paramaxxo.jdField_b_of_type_Int;
    int m = paramaxxo.jdField_a_of_type_Int;
    int n = paramaxxo.e;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + j + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + "fileSize:" + i);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.jdField_a_of_type_Long);
    if (jdField_a_of_type_Boolean) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(i);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(1);
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.jdField_b_of_type_ArrayOfByte);
      localObject2 = new baus(this);
      ((baus)localObject2).jdField_a_of_type_JavaLangString = str;
      ((baus)localObject2).jdField_a_of_type_ArrayOfByte = this.jdField_c_of_type_ArrayOfByte;
      ((baus)localObject2).jdField_b_of_type_ArrayOfByte = arrayOfByte1;
      ((baus)localObject2).jdField_c_of_type_ArrayOfByte = ((byte[])localObject1);
      ((baus)localObject2).jdField_a_of_type_Int = j;
      ((baus)localObject2).d = arrayOfByte2;
      ((baus)localObject2).jdField_a_of_type_Axxo = paramaxxo;
      ((baus)localObject2).jdField_a_of_type_Long = i;
      a((baus)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  void e()
  {
    this.jdField_j_of_type_Int = 0;
    super.e();
    awki localawki = new awki();
    localawki.jdField_a_of_type_Int = 0;
    localawki.jdField_a_of_type_Long = (this.q - this.jdField_b_of_type_Long);
    localawki.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    if (this.f == null) {}
    for (String str = this.l;; str = this.f)
    {
      localawki.jdField_c_of_type_JavaLangString = str;
      localawki.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "onSuccess uuid = " + localawki.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh == null) {
        break;
      }
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
      this.jdField_a_of_type_AndroidOsHandler.post(new LightVideoUploadProcessor.2(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uuid = localawki.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.md5 = localawki.jdField_d_of_type_JavaLangString;
    d(1003);
  }
  
  public void e(axxo paramaxxo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "addToSendQuene, info:" + paramaxxo + " mSendingInfos:" + this.jdField_b_of_type_JavaUtilMap.size() + " mReadyToSendInfos:" + this.jdField_b_of_type_JavaUtilArrayList.size() + " mUploadType" + this.jdField_a_of_type_Int);
    }
    if (paramaxxo.c())
    {
      this.jdField_a_of_type_Axxo = paramaxxo;
      h();
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    bass localbass = this.jdField_a_of_type_Bass;
    localbass.jdField_a_of_type_Long += paramaxxo.jdField_a_of_type_Long;
    this.q += paramaxxo.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaUtilArrayList.add(paramaxxo);
    s();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendRequest");
    }
    bbax localbbax = new bbax();
    bbbl localbbbl = a();
    localbbax.jdField_a_of_type_Bbce = this;
    localbbax.jdField_a_of_type_JavaLangString = "short_video_up";
    localbbax.jdField_a_of_type_JavaUtilList.add(localbbbl);
    localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onSendFileSliceFailed, mSendFileSliceFailed:" + this.jdField_b_of_type_Boolean + " mUploadType:" + this.jdField_a_of_type_Int + " errCode:" + paramInt);
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap.put("segment_error_code", String.valueOf(paramInt));
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.jdField_a_of_type_Int == 0) {
      h();
    }
  }
  
  public void f(axxo paramaxxo)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new LightVideoUploadProcessor.5(this, paramaxxo));
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.jdField_b_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile = null;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> sendCompleteFile Start.   this:" + this);
    }
    if (!g()) {
      o();
    }
    if (!g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "session is null, sendRequest ");
      }
      f();
      return;
    }
    t();
  }
  
  public void h()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkNeedSendCompleteFile check, mUploadType:" + this.jdField_a_of_type_Int + " mSendFileSliceFailed:" + this.jdField_b_of_type_Boolean + " mCombineInfo:" + this.jdField_a_of_type_Axxo);
    }
    int i;
    if (this.jdField_a_of_type_Int == 0) {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Int = 1;
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.jdField_a_of_type_Axxo != null))
      {
        this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Bayk.f = this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Axxo.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString);
        bass localbass = this.jdField_a_of_type_Bass;
        String str = this.jdField_a_of_type_Axxo.jdField_b_of_type_JavaLangString;
        localbass.f = str;
        this.jdField_c_of_type_JavaLangString = str;
        this.q = this.jdField_a_of_type_Axxo.jdField_a_of_type_Long;
        this.x = (this.jdField_a_of_type_Axxo.e / 1000);
        g();
      }
      return;
      if ((this.jdField_a_of_type_Axxo != null) && (!this.jdField_a_of_type_Axxo.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Int = 4;
        i = j;
        continue;
        i = j;
        if (this.jdField_a_of_type_Int != 2)
        {
          i = j;
          if (this.jdField_a_of_type_Int == 1) {}
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected void i()
  {
    super.i();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendProgressMessage,progress;" + this.n + " transferedSize:" + this.jdField_a_of_type_Bass.e + " fileSize:" + this.jdField_a_of_type_Bass.jdField_a_of_type_Long);
    }
  }
  
  public void r()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendAckToBDHServer");
    }
    long l1 = this.jdField_a_of_type_Long;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
    Object localObject2 = new ArrayList();
    int i = 0;
    while (i <= this.jdField_a_of_type_JavaUtilMap.size())
    {
      localObject3 = (Bdh_extinfo.VideoInfo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (localObject3 != null) {
        ((List)localObject2).add(localObject3);
      }
      i += 1;
    }
    Object localObject3 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).uint32_cmd.set(3);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).uint64_session_id.set(l1);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l2;
    if (jdField_a_of_type_Boolean)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      l1 = Long.parseLong(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString);
      l2 = Long.parseLong(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      localShortVideoSureReqInfo.uint64_fromuin.set(l1);
      localShortVideoSureReqInfo.uint64_touin.set(l2);
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 0) && (1008 != this.jdField_a_of_type_Bayk.jdField_a_of_type_Int)) {
        break label405;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      label217:
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int != 0) {
        break label418;
      }
      i = j;
    }
    for (;;)
    {
      j = ((MessageForLightVideo)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_sub_business_type.set(3);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set((MessageMicro)localObject1);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set((List)localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).toByteArray(), this.jdField_b_of_type_ArrayOfByte);
      localObject2 = new baur(this);
      localObject1 = new RequestAck(String.valueOf(l1), 16, this.jdField_c_of_type_ArrayOfByte, 30000L, (IRequestCallback)localObject2, (byte[])localObject1, this.d, this.y);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().SubmitAckRequest((RequestAck)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = ((RequestAck)localObject1);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject3).bool_is_merge_cmd_before_data.set(false);
      break;
      label405:
      localShortVideoSureReqInfo.uint64_group_code.set(l2);
      break label217;
      label418:
      if (1 == this.jdField_a_of_type_Bayk.jdField_a_of_type_Int) {
        i = 1;
      } else if (3000 == this.jdField_a_of_type_Bayk.jdField_a_of_type_Int) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public void s()
  {
    if (this.jdField_b_of_type_JavaUtilMap.size() >= 3) {}
    label144:
    for (;;)
    {
      return;
      for (;;)
      {
        if ((this.jdField_b_of_type_JavaUtilMap.size() >= 3) || (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0)) {
          break label144;
        }
        axxo localaxxo = (axxo)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localaxxo == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "sendSlice, info:" + localaxxo + " mSendingInfos:" + this.jdField_b_of_type_JavaUtilMap.size() + " mReadyToSendInfos:" + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(localaxxo.jdField_d_of_type_Int), localaxxo);
        a(localaxxo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauo
 * JD-Core Version:    0.7.0.1
 */