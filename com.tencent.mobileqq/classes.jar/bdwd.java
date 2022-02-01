import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.SystemClock;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
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
import com.tencent.mobileqq.pb.PBStringField;
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
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class bdwd
  extends bdsu
{
  public static boolean a;
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  anqd jdField_a_of_type_Anqd = new bdwe(this);
  bavp jdField_a_of_type_Bavp;
  private bavq jdField_a_of_type_Bavq;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.a;
  private MessageForLightVideo jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo;
  Bdh_extinfo.PicInfo jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
  RequestAck jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck;
  String jdField_a_of_type_JavaLangString;
  Map<Integer, Bdh_extinfo.VideoInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected int b;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  public ArrayList<bavp> b;
  List<Transaction> jdField_b_of_type_JavaUtilList = new ArrayList();
  public Map<Integer, bavp> b;
  boolean jdField_b_of_type_Boolean = false;
  protected int c;
  private long c;
  protected RandomAccessFile c;
  private byte[] e;
  int x;
  private volatile int y;
  
  public bdwd(bdsv parambdsv, bdzn parambdzn)
  {
    super(parambdsv, parambdzn);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    parambdsv = parambdzn.jdField_b_of_type_JavaLangObject;
    if ((parambdsv != null) && ((parambdsv instanceof bavq))) {
      this.jdField_a_of_type_Bavq = ((bavq)parambdzn.jdField_b_of_type_JavaLangObject);
    }
    if ((this.jdField_a_of_type_Bdsv != null) && (this.jdField_a_of_type_Bdsv.a != null)) {
      this.jdField_a_of_type_AndroidOsHandler = this.jdField_a_of_type_Bdsv.a;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo = ((MessageForLightVideo)parambdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    jdField_a_of_type_Boolean = VideoUpConfigInfo.sIsPreSendSignal;
  }
  
  private becj a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "makeShortVideoUpReq");
    }
    becj localbecj = new becj();
    localbecj.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    localbecj.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbecj.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbecj.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbecj.i = 0;
    if ((localbecj.f == 0) || (1008 == localbecj.f))
    {
      localbecj.jdField_b_of_type_JavaLangString = null;
      if (localbecj.f != 0) {
        break label254;
      }
      localbecj.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localbecj.jdField_b_of_type_Int = 2;
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      localbecj.jdField_a_of_type_JavaLangString = ((File)localObject).getName();
      localbecj.jdField_a_of_type_Long = ((File)localObject).length();
      localbecj.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      localbecj.jdField_b_of_type_ArrayOfByte = this.e;
      localbecj.e = this.jdField_c_of_type_Int;
      localbecj.jdField_d_of_type_Int = this.jdField_b_of_type_Int;
      localbecj.h = this.x;
      localbecj.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localObject = this.jdField_a_of_type_Bduk;
      long l = localbecj.jdField_a_of_type_Long + this.jdField_b_of_type_Long;
      this.q = l;
      ((bduk)localObject).jdField_a_of_type_Long = l;
      localbecj.g = 3;
      localbecj.k = 3;
      localbecj.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.busiType;
      return localbecj;
      localbecj.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
      break;
      label254:
      if (1 == localbecj.f) {
        localbecj.jdField_a_of_type_Int = 1;
      } else if (3000 == localbecj.f) {
        localbecj.jdField_a_of_type_Int = 2;
      } else {
        localbecj.jdField_a_of_type_Int = 3;
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
        if (!(this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForLightVideo)) {
          break label659;
        }
        Object localObject1 = (MessageForLightVideo)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
          localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString));
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bdzn.f)));
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(0);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)(this.q - this.jdField_b_of_type_Long));
        if (this.x == 0)
        {
          if ((this.jdField_a_of_type_Bavq != null) && (this.jdField_a_of_type_Bavq.jdField_b_of_type_Int != 0))
          {
            localVideoFile.uint32_file_time.set(this.jdField_a_of_type_Bavq.jdField_b_of_type_Int / 1000);
            localVideoFile.uint32_thumb_width.set(this.jdField_c_of_type_Int);
            localVideoFile.uint32_thumb_height.set(this.jdField_b_of_type_Int);
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.e));
            localVideoFile.uint32_thumb_file_size.set((int)this.jdField_b_of_type_Long);
            localVideoFile.uint32_from_chat_type.set(-1);
            localVideoFile.uint32_to_chat_type.set(-1);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            localObject1 = anni.a(2131704845);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(BaseApplication.getContext().getString(2131691131)));
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
    if ((this.jdField_c_of_type_JavaIoRandomAccessFile != null) && (this.jdField_b_of_type_JavaIoRandomAccessFile != null)) {}
    for (;;)
    {
      return true;
      if (this.jdField_c_of_type_JavaIoRandomAccessFile == null) {
        try
        {
          this.jdField_c_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_b_of_type_JavaLangString, "r");
          if (this.jdField_c_of_type_JavaIoRandomAccessFile == null) {
            return false;
          }
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          for (;;)
          {
            localFileNotFoundException1.printStackTrace();
            this.jdField_c_of_type_JavaIoRandomAccessFile = null;
          }
        }
      }
      if (this.jdField_b_of_type_JavaIoRandomAccessFile != null) {
        continue;
      }
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_JavaLangString, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile != null) {
          continue;
        }
        return false;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendFileByBDH");
    }
    long l = SystemClock.uptimeMillis();
    if (!a())
    {
      b(9303, "read  file error");
      d();
      return;
    }
    String str = a();
    Object localObject1 = a();
    Object localObject2 = new PttShortVideo.PttShortVideoUploadReq();
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).setHasFlag(true);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_fromuin.set(Long.parseLong(((becj)localObject1).jdField_c_of_type_JavaLangString));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_touin.set(Long.parseLong(((becj)localObject1).jdField_d_of_type_JavaLangString));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_chat_type.set(((becj)localObject1).jdField_a_of_type_Int);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_client_type.set(((becj)localObject1).jdField_b_of_type_Int);
    if (((becj)localObject1).jdField_b_of_type_JavaLangString != null) {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(Long.parseLong(((becj)localObject1).jdField_b_of_type_JavaLangString));
    }
    for (;;)
    {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_agent_type.set(((becj)localObject1).i);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_business_type.set(((becj)localObject1).jdField_j_of_type_Int);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_flag_support_large_size.set(1);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_sub_business_type.set(3);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(((becj)localObject1).jdField_a_of_type_JavaLangString);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(((becj)localObject1).jdField_a_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(((becj)localObject1).jdField_b_of_type_ArrayOfByte));
      localPttShortVideoFileInfo.uint64_file_size.set(((becj)localObject1).jdField_a_of_type_Long);
      localPttShortVideoFileInfo.uint32_file_res_length.set(((becj)localObject1).jdField_d_of_type_Int);
      localPttShortVideoFileInfo.uint32_file_res_width.set(((becj)localObject1).e);
      localPttShortVideoFileInfo.uint32_file_format.set(((becj)localObject1).g);
      localPttShortVideoFileInfo.uint32_file_time.set(((becj)localObject1).h);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(((becj)localObject1).jdField_b_of_type_Long);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      localObject1 = ((PttShortVideo.PttShortVideoUploadReq)localObject2).toByteArray();
      localObject1 = new Cryptor().encrypt((byte[])localObject1, this.jdField_c_of_type_ArrayOfByte);
      localObject2 = new bdwf(this, str, l);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 12, str, (int)this.r, this.d, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.l + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 12);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Bdsz);
      d();
      return;
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(0L);
    }
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
    this.jdField_a_of_type_Bavq = null;
    return super.a();
  }
  
  public void a(bavp parambavp)
  {
    if (parambavp.a())
    {
      b(parambavp);
      return;
    }
    if (parambavp.b())
    {
      d(parambavp);
      return;
    }
    c(parambavp);
  }
  
  /* Error */
  void a(bdwh parambdwh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 692	bdwh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: astore 5
    //   8: aload_1
    //   9: getfield 693	bdwh:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 6
    //   14: aload_1
    //   15: getfield 694	bdwh:jdField_b_of_type_ArrayOfByte	[B
    //   18: astore 7
    //   20: aload_1
    //   21: getfield 695	bdwh:jdField_c_of_type_ArrayOfByte	[B
    //   24: astore 8
    //   26: aload_1
    //   27: getfield 696	bdwh:jdField_a_of_type_Int	I
    //   30: istore_2
    //   31: aload_1
    //   32: getfield 697	bdwh:d	[B
    //   35: astore 9
    //   37: aload_1
    //   38: getfield 699	bdwh:jdField_a_of_type_Bavp	Lbavp;
    //   41: astore 9
    //   43: aload_1
    //   44: getfield 700	bdwh:jdField_a_of_type_Long	J
    //   47: lstore_3
    //   48: new 702	bdwi
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 703	bdwi:<init>	(Lbdwd;)V
    //   56: astore_1
    //   57: new 590	com/tencent/mobileqq/highway/transaction/Transaction
    //   60: dup
    //   61: aload_0
    //   62: getfield 69	bdwd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 593	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: bipush 16
    //   70: aload 5
    //   72: iconst_0
    //   73: aload 6
    //   75: aload 7
    //   77: aload_1
    //   78: aload 8
    //   80: invokespecial 600	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 106	bdwd:y	I
    //   89: ifeq +12 -> 101
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 106	bdwd:y	I
    //   98: putfield 706	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   101: aload_1
    //   102: aload 5
    //   104: putfield 708	bdwi:jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   107: aload_1
    //   108: iload_2
    //   109: putfield 709	bdwi:jdField_a_of_type_Int	I
    //   112: aload_1
    //   113: aload 9
    //   115: putfield 710	bdwi:jdField_a_of_type_Bavp	Lbavp;
    //   118: aload_0
    //   119: getfield 69	bdwd:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 607	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   125: aload 5
    //   127: invokevirtual 613	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +11 -> 143
    //   135: aload_0
    //   136: iload_2
    //   137: invokevirtual 712	bdwd:f	(I)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload_0
    //   144: getfield 44	bdwd:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   147: aload 5
    //   149: invokeinterface 715 2 0
    //   154: pop
    //   155: goto -15 -> 140
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	bdwd
    //   0	163	1	parambdwh	bdwh
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
  
  public void a(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    if (parambeck != null)
    {
      int i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (beda)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + parambebv.jdField_c_of_type_Int);
        }
        this.f = parambebv.jdField_a_of_type_JavaLangString;
        if (parambebv.jdField_c_of_type_Int == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + parambebv.jdField_a_of_type_Boolean);
          }
          if (parambebv.jdField_a_of_type_Boolean)
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
            b(parambebv.jdField_c_of_type_Int, "onBusiProtoResp error");
            d();
          }
        }
      }
    }
  }
  
  public void a(Bdh_extinfo.ShortVideoReqExtInfo paramShortVideoReqExtInfo)
  {
    paramShortVideoReqExtInfo = new Cryptor().encrypt(paramShortVideoReqExtInfo.toByteArray(), this.jdField_c_of_type_ArrayOfByte);
    bdwg localbdwg = new bdwg(this);
    paramShortVideoReqExtInfo = new RequestAck(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString, 16, this.d, 30000L, localbdwg, paramShortVideoReqExtInfo, this.e, this.y);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().SubmitAckRequest(paramShortVideoReqExtInfo);
    this.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = paramShortVideoReqExtInfo;
  }
  
  protected void a(boolean paramBoolean)
  {
    long l;
    if ((this.jdField_a_of_type_Bavq != null) && (this.jdField_a_of_type_Bavq.jdField_b_of_type_Long != 0L))
    {
      l = System.currentTimeMillis() - this.jdField_a_of_type_Bavq.jdField_b_of_type_Long;
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
      bctj.a(BaseApplication.getContext()).a(null, "LightVideoSend", paramBoolean, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, null);
      return;
      label197:
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("upload_type", String.valueOf(this.jdField_a_of_type_Int));
    bctj.a(BaseApplication.getContext()).a(null, "LightVideoSendComplete", paramBoolean, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, null);
  }
  
  public void aN_()
  {
    super.aN_();
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_j_of_type_JavaLangString;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long;
    if (this.jdField_a_of_type_Bdzn.k == null) {
      this.e = HexUtil.hexStr2Bytes(bbfc.a(this.jdField_b_of_type_JavaLangString));
    }
    this.e = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bdzn.k);
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
    i();
    if (g()) {
      if (this.jdField_a_of_type_Bavq != null) {
        if (this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean)
        {
          this.jdField_a_of_type_Int = 0;
          this.jdField_a_of_type_Bavq.a(this);
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
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString;
      if (this.jdField_a_of_type_Bdzn.f == null) {
        this.jdField_a_of_type_Bdzn.f = bbfc.a(this.jdField_a_of_type_JavaLangString);
      }
      localObject = this.jdField_a_of_type_Bduk;
      String str = this.jdField_a_of_type_Bdzn.f;
      ((bduk)localObject).f = str;
      this.jdField_c_of_type_JavaLangString = str;
      this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bdzn.f);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime == 0))
      {
        localObject = new bclk();
        bclj.a(this.jdField_a_of_type_JavaLangString, (bclk)localObject);
        int i = localObject.a[3];
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize = ((int)new File(this.jdField_a_of_type_JavaLangString).length());
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime = (i / 1000);
      }
      this.q = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileSize;
      this.x = this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.videoFileTime;
      f();
      break label234;
      HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Bavq.a(this);
    }
  }
  
  void b(bavp parambavp)
  {
    String str = parambavp.jdField_a_of_type_JavaLangString;
    int i = (int)this.jdField_b_of_type_Long;
    byte[] arrayOfByte1 = this.d;
    byte[] arrayOfByte3 = this.jdField_c_of_type_ArrayOfByte;
    byte[] arrayOfByte2 = this.e;
    long l = this.jdField_a_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + str + " index :" + parambavp.jdField_d_of_type_Int + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + i);
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
      localObject = new bdwh(this);
      ((bdwh)localObject).jdField_a_of_type_JavaLangString = str;
      ((bdwh)localObject).jdField_a_of_type_ArrayOfByte = arrayOfByte1;
      ((bdwh)localObject).jdField_b_of_type_ArrayOfByte = arrayOfByte2;
      ((bdwh)localObject).jdField_c_of_type_ArrayOfByte = arrayOfByte3;
      ((bdwh)localObject).jdField_a_of_type_Int = 0;
      ((bdwh)localObject).d = arrayOfByte2;
      ((bdwh)localObject).jdField_a_of_type_Bavp = parambavp;
      ((bdwh)localObject).jdField_a_of_type_Long = i;
      a((bdwh)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bavq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "confirm send:" + this.jdField_a_of_type_Bavq.b());
      }
      if (!this.jdField_a_of_type_Bavq.b()) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMsg() start.");
    }
    im_msg_body.RichText localRichText = a();
    if (localRichText == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Bdsz);
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.richText = localRichText;
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo, this.jdField_a_of_type_Anqd);
  }
  
  void c(bavp parambavp)
  {
    String str = parambavp.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.e;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(parambavp.jdField_b_of_type_JavaLangString);
    int j = parambavp.jdField_d_of_type_Int;
    int k = parambavp.jdField_b_of_type_Int;
    int m = parambavp.jdField_a_of_type_Int;
    int n = parambavp.e;
    long l = parambavp.jdField_b_of_type_Long;
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
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      localObject2 = new bdwh(this);
      ((bdwh)localObject2).jdField_a_of_type_JavaLangString = str;
      ((bdwh)localObject2).jdField_a_of_type_ArrayOfByte = this.d;
      ((bdwh)localObject2).jdField_b_of_type_ArrayOfByte = arrayOfByte1;
      ((bdwh)localObject2).jdField_c_of_type_ArrayOfByte = ((byte[])localObject1);
      ((bdwh)localObject2).jdField_a_of_type_Int = j;
      ((bdwh)localObject2).d = arrayOfByte2;
      ((bdwh)localObject2).jdField_a_of_type_Bavp = parambavp;
      ((bdwh)localObject2).jdField_a_of_type_Long = i;
      a((bdwh)localObject2);
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
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = -1;
      localayyu.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localayyu.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
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
  
  void d(bavp parambavp)
  {
    String str = parambavp.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.e;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(parambavp.jdField_b_of_type_JavaLangString);
    int j = parambavp.jdField_d_of_type_Int;
    int k = parambavp.jdField_b_of_type_Int;
    int m = parambavp.jdField_a_of_type_Int;
    int n = parambavp.e;
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
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.jdField_c_of_type_ArrayOfByte);
      localObject2 = new bdwh(this);
      ((bdwh)localObject2).jdField_a_of_type_JavaLangString = str;
      ((bdwh)localObject2).jdField_a_of_type_ArrayOfByte = this.d;
      ((bdwh)localObject2).jdField_b_of_type_ArrayOfByte = arrayOfByte1;
      ((bdwh)localObject2).jdField_c_of_type_ArrayOfByte = ((byte[])localObject1);
      ((bdwh)localObject2).jdField_a_of_type_Int = j;
      ((bdwh)localObject2).d = arrayOfByte2;
      ((bdwh)localObject2).jdField_a_of_type_Bavp = parambavp;
      ((bdwh)localObject2).jdField_a_of_type_Long = i;
      a((bdwh)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  void e()
  {
    this.jdField_j_of_type_Int = 0;
    super.e();
    ayyu localayyu = new ayyu();
    localayyu.jdField_a_of_type_Int = 0;
    localayyu.jdField_a_of_type_Long = (this.q - this.jdField_b_of_type_Long);
    localayyu.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    if (this.f == null) {}
    for (String str = this.l;; str = this.f)
    {
      localayyu.jdField_c_of_type_JavaLangString = str;
      localayyu.jdField_c_of_type_Long = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "onSuccess uuid = " + localayyu.jdField_c_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt == null) {
        break;
      }
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
      this.jdField_a_of_type_AndroidOsHandler.post(new LightVideoUploadProcessor.2(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.uuid = localayyu.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForLightVideo.md5 = localayyu.jdField_d_of_type_JavaLangString;
    d(1003);
  }
  
  public void e(bavp parambavp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "addToSendQuene, info:" + parambavp + " mSendingInfos:" + this.jdField_b_of_type_JavaUtilMap.size() + " mReadyToSendInfos:" + this.jdField_b_of_type_JavaUtilArrayList.size() + " mUploadType" + this.jdField_a_of_type_Int);
    }
    if (parambavp.c())
    {
      this.jdField_a_of_type_Bavp = parambavp;
      h();
    }
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    bduk localbduk = this.jdField_a_of_type_Bduk;
    localbduk.jdField_a_of_type_Long += parambavp.jdField_a_of_type_Long;
    this.q += parambavp.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaUtilArrayList.add(parambavp);
    s();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendRequest");
    }
    bebv localbebv = new bebv();
    becj localbecj = a();
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "short_video_up";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbecj);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
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
  
  public void f(bavp parambavp)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new LightVideoUploadProcessor.5(this, parambavp));
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.jdField_c_of_type_JavaIoRandomAccessFile != null) {}
    try
    {
      this.jdField_c_of_type_JavaIoRandomAccessFile.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.jdField_c_of_type_JavaIoRandomAccessFile = null;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> sendCompleteFile Start.   this:" + this);
    }
    if (!g()) {
      i();
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
      QLog.d("VideoSend", 2, "checkNeedSendCompleteFile check, mUploadType:" + this.jdField_a_of_type_Int + " mSendFileSliceFailed:" + this.jdField_b_of_type_Boolean + " mCombineInfo:" + this.jdField_a_of_type_Bavp);
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
      if ((i != 0) && (this.jdField_a_of_type_Bavp != null))
      {
        this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString = this.jdField_a_of_type_Bavp.jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_Bdzn.f = this.jdField_a_of_type_Bavp.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean = false;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bavp.jdField_a_of_type_JavaLangString;
        this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_Bavp.jdField_b_of_type_JavaLangString);
        bduk localbduk = this.jdField_a_of_type_Bduk;
        String str = this.jdField_a_of_type_Bavp.jdField_b_of_type_JavaLangString;
        localbduk.f = str;
        this.jdField_c_of_type_JavaLangString = str;
        this.q = this.jdField_a_of_type_Bavp.jdField_a_of_type_Long;
        this.x = (this.jdField_a_of_type_Bavp.e / 1000);
        g();
      }
      return;
      if ((this.jdField_a_of_type_Bavp != null) && (!this.jdField_a_of_type_Bavp.jdField_a_of_type_Boolean))
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
  
  protected void j()
  {
    super.j();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendProgressMessage,progress;" + this.n + " transferedSize:" + this.jdField_a_of_type_Bduk.e + " fileSize:" + this.jdField_a_of_type_Bduk.jdField_a_of_type_Long);
    }
  }
  
  public void r()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendAckToBDHServer");
    }
    long l1 = this.jdField_a_of_type_Long;
    Bdh_extinfo.PicInfo localPicInfo = this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolBdh_extinfo$PicInfo;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= this.jdField_a_of_type_JavaUtilMap.size())
    {
      localObject = (Bdh_extinfo.VideoInfo)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(i));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(3);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l1);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l2;
    if (jdField_a_of_type_Boolean)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      l1 = Long.parseLong(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString);
      l2 = Long.parseLong(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
      localShortVideoSureReqInfo.uint64_fromuin.set(l1);
      localShortVideoSureReqInfo.uint64_touin.set(l2);
      if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int != 0) && (1008 != this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int)) {
        break label328;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      label217:
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int != 0) {
        break label341;
      }
      i = j;
    }
    for (;;)
    {
      j = ((MessageForLightVideo)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).busiType;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_sub_business_type.set(3);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(localPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(localArrayList);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      a((Bdh_extinfo.ShortVideoReqExtInfo)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label328:
      localShortVideoSureReqInfo.uint64_group_code.set(l2);
      break label217;
      label341:
      if (1 == this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int) {
        i = 1;
      } else if (3000 == this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int) {
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
        bavp localbavp = (bavp)this.jdField_b_of_type_JavaUtilArrayList.remove(0);
        if (localbavp == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "sendSlice, info:" + localbavp + " mSendingInfos:" + this.jdField_b_of_type_JavaUtilMap.size() + " mReadyToSendInfos:" + this.jdField_b_of_type_JavaUtilArrayList.size());
        }
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(localbavp.jdField_d_of_type_Int), localbavp);
        a(localbavp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwd
 * JD-Core Version:    0.7.0.1
 */