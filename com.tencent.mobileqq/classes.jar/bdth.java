import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.NewServiceTicket;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.1;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.2;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.manager.ProxyIpManager;
import mqq.manager.TicketManager;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class bdth
  extends bdst
{
  private int jdField_a_of_type_Int;
  anqd jdField_a_of_type_Anqd = new bdtk(this);
  protected bdzi a;
  public QQAppInterface a;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  protected CSDataHighwayHead.LoginSigHead a;
  protected boolean a;
  protected byte[] a;
  public boolean b;
  private bdsz e;
  protected byte[] e;
  private bdsz jdField_f_of_type_Bdsz = new bdsz();
  private byte[] jdField_f_of_type_ArrayOfByte;
  private boolean jdField_g_of_type_Boolean;
  private byte[] jdField_g_of_type_ArrayOfByte;
  
  public bdth(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_e_of_type_Bdsz = new bdsz();
    this.jdField_a_of_type_Bdzi = parambdzi;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_Bduk.jdField_b_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bduk.jdField_b_of_type_Long = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bduk.q = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Bduk.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    this.jdField_a_of_type_Boolean = OpenUpConfig.isOpenUpEnable;
    this.jdField_a_of_type_Int = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
    {
      this.jdField_g_of_type_Boolean = ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryPhoto;
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
  }
  
  private im_msg_body.RichText a()
  {
    label778:
    label798:
    label806:
    label820:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        Object localObject3;
        try
        {
          localRichText = new im_msg_body.RichText();
          localObject3 = new im_msg_body.NotOnlineImage();
          g();
          ((im_msg_body.NotOnlineImage)localObject3).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
          if (this.jdField_a_of_type_Bduk.jdField_h_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject3).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bduk.jdField_h_of_type_JavaLangString));
          }
          if (this.jdField_a_of_type_Bduk.jdField_g_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject3).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bduk.jdField_g_of_type_JavaLangString));
          }
          ((im_msg_body.NotOnlineImage)localObject3).file_len.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.NotOnlineImage)localObject3).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
          ((im_msg_body.NotOnlineImage)localObject3).pic_height.set(this.jdField_q_of_type_Int);
          ((im_msg_body.NotOnlineImage)localObject3).pic_width.set(this.p);
          Object localObject1 = ((im_msg_body.NotOnlineImage)localObject3).original;
          if (!this.n) {
            break label820;
          }
          ((PBUInt32Field)localObject1).set(i);
          Object localObject4 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          Object localObject5;
          if (MessageForPic.class.isInstance(localObject4))
          {
            localObject5 = (MessageForPic)localObject4;
            ((im_msg_body.NotOnlineImage)localObject3).uint32_show_len.set(((MessageForPic)localObject5).mShowLength);
            ((im_msg_body.NotOnlineImage)localObject3).uint32_download_len.set(((MessageForPic)localObject5).mDownloadLength);
            ((im_msg_body.NotOnlineImage)localObject3).img_type.set(((MessageForPic)localObject5).imageType);
            if (((MessageForPic)localObject5).picExtraData != null)
            {
              localObject1 = ((MessageForPic)localObject5).picExtraData.getOfflineImageResvAttr();
              ((NotOnlineImageExtPb.ResvAttr)localObject1).uint32_source.set(a((MessageForPic)localObject5));
              ((im_msg_body.NotOnlineImage)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
            }
          }
          else
          {
            ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(d());
            if (QLog.isColorLevel()) {
              b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject3).biz_type.get());
            }
            localObject1 = new im_msg_body.Elem();
            if (!anlk.a((MessageRecord)localObject4)) {
              break label778;
            }
            localObject4 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(3);
            localObject5 = new hummer_commelem.MsgElemInfo_servtype3();
            ((hummer_commelem.MsgElemInfo_servtype3)localObject5).flash_c2c_pic.set((MessageMicro)localObject3);
            ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject5).toByteArray()));
            ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject4);
            localRichText.elems.add((MessageMicro)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
            }
            localObject1 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(anni.a(2131700101)));
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
            if (!(localObject5 instanceof MessageForStructing)) {
              break;
            }
            localObject3 = (MessageForStructing)localObject5;
            if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))) {
              break;
            }
            StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            localObject4 = localStructMsgForImageShare.getFirstImageElement();
            if (localObject4 == null) {
              break;
            }
            ((bcxy)localObject4).ac = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_f_of_type_JavaLangString != null) {
              break label798;
            }
            localObject1 = this.jdField_l_of_type_JavaLangString;
            ((bcxy)localObject4).ab = ((String)localObject1);
            ((bcxy)localObject4).d = this.jdField_q_of_type_Long;
            ((bcxy)localObject4).jdField_e_of_type_Long = ((MessageRecord)localObject5).time;
            if (!ahte.b(localStructMsgForImageShare.mMsgActionData)) {
              break label806;
            }
            localObject5 = ((bcxy)localObject4).aa;
            ((bcxy)localObject4).aa = "";
            localObject1 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
            ((bcxy)localObject4).aa = ((String)localObject5);
            if ((TextUtils.isEmpty(((MessageForStructing)localObject3).frienduin)) || (localObject1 == null)) {
              break;
            }
            localObject3 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            break;
          }
          localObject1 = new NotOnlineImageExtPb.ResvAttr();
          continue;
          localException.not_online_image.set((MessageMicro)localObject3);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        localRichText.elems.add(localException);
        continue;
        Object localObject2 = this.jdField_f_of_type_JavaLangString;
        continue;
        localObject2 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
      }
      return localRichText;
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new CSDataHighwayHead.PicRspExtInfo();
      try
      {
        ((CSDataHighwayHead.PicRspExtInfo)localObject).mergeFrom(paramArrayOfByte);
        if (((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.has())
        {
          paramArrayOfByte = ((CSDataHighwayHead.PicRspExtInfo)localObject).bytes_skey.get().toByteArray();
          localObject = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + paramArrayOfByte.length);
          }
          Cryptor localCryptor = new Cryptor();
          if (this.jdField_f_of_type_ArrayOfByte != null)
          {
            localObject = localCryptor.decrypt((byte[])localObject, 0, paramArrayOfByte.length, this.jdField_f_of_type_ArrayOfByte);
            if ((localObject != null) && (localObject.length > 36))
            {
              if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + localObject.length);
              }
              paramArrayOfByte = new byte[localObject.length];
              System.arraycopy(localObject, 0, paramArrayOfByte, 0, localObject.length);
              int j = ByteBuffer.wrap(paramArrayOfByte).getShort(34);
              localObject = new char[j];
              while (i < j)
              {
                localObject[i] = ((char)paramArrayOfByte[(i + 36)]);
                i += 1;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, paramArrayOfByte.getMessage());
          }
        }
        paramArrayOfByte = String.valueOf((char[])localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileIdStr:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_Bduk.jdField_g_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_f_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_a_of_type_Bduk.jdField_h_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_l_of_type_JavaLangString = paramArrayOfByte;
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bdzi.a.post(new C2CPicUploadProcessor.2(this));
  }
  
  private void w()
  {
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Bdul.a();
    this.jdField_a_of_type_Bduk.jdField_b_of_type_Bdul.a();
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Bdum.a();
    this.jdField_a_of_type_Bduk.jdField_c_of_type_Bdul.a();
    bduk localbduk = this.jdField_a_of_type_Bduk;
    long l = System.nanoTime();
    localbduk.jdField_g_of_type_Long = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bduk.jdField_h_of_type_Long = 0L;
  }
  
  protected CSDataHighwayHead.LoginSigHead a()
  {
    CSDataHighwayHead.LoginSigHead localLoginSigHead = new CSDataHighwayHead.LoginSigHead();
    Object localObject1 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if ((localObject1 != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
    {
      localObject1 = ((TicketManager)localObject1).getA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if (localObject1 == null) {
        break label103;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).getBytes("utf-8");
        if ((localObject1 == null) || (localObject1.length == 0)) {
          return null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      localLoginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(localUnsupportedEncodingException));
      localLoginSigHead.uint32_loginsig_type.set(8);
      return localLoginSigHead;
      label103:
      Object localObject2 = null;
    }
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    super.a(parambebv, parambeck);
    b(parambebv, parambeck);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + bdxz.b(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int) + "." + bdxz.a(this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((!paramBoolean) && (this.v == 1))
    {
      this.jdField_c_of_type_Bdsz.jdField_a_of_type_Int = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_Bdsz.a(1) + ";" + this.jdField_b_of_type_Bdsz.a(2) + ";" + this.jdField_c_of_type_Bdsz.a(3);
      localObject2 = this.jdField_e_of_type_Bdsz.a(21) + ";" + this.jdField_f_of_type_Bdsz.a(22);
      if (QLog.isColorLevel())
      {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + (String)localObject1);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject2);
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.jdField_a_of_type_Bdsz.toString() + ";mStepTrans: " + this.jdField_b_of_type_Bdsz.toString() + ";mStepMsg: " + this.jdField_c_of_type_Bdsz.toString() + ";mStepTransPre: " + this.jdField_e_of_type_Bdsz.toString() + ";mStepTransLeft: " + this.jdField_f_of_type_Bdsz.toString() + ";");
      }
      String str;
      if (!paramBoolean)
      {
        str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase(str)) {
          break label520;
        }
      }
      label520:
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        while (this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int == 1030)
        {
          return;
          if ("connError_noroute".equalsIgnoreCase(str)) {
            this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
          }
        }
      } while (((!paramBoolean) && (bdxr.a(this.jdField_j_of_type_Int))) || (this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0)));
      int j = this.jdField_m_of_type_Int;
      long l1;
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.jdField_m_of_type_Int = (i | j);
        this.jdField_l_of_type_Long = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.jdField_k_of_type_Long) / 1000000L;
        Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.jdField_b_of_type_Bdsz.jdField_b_of_type_Long - this.jdField_b_of_type_Bdsz.jdField_a_of_type_Long) / 1000000L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_openUpStep", localObject2);
        localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
        if (this.jdField_f_of_type_JavaLangString != null) {
          break label1072;
        }
        localObject1 = this.jdField_l_of_type_JavaLangString;
        label728:
        ((HashMap)localObject2).put("param_uuid", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_f_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", akgm.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bgnt.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.n + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_openUp", String.valueOf(this.jdField_a_of_type_Boolean));
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Bdzn.p) {
          break label1081;
        }
      }
      label1072:
      label1081:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        e(paramBoolean);
        a(paramBoolean, l2, l1);
        return;
        i = 1;
        break;
        localObject1 = this.jdField_f_of_type_JavaLangString;
        break label728;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      p();
      if (this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean)
      {
        long l = 0L;
        if (this.jdField_u_of_type_Long != 0L) {
          l = (paramLong2 - this.jdField_u_of_type_Long) / 1000000L;
        }
        if (this.jdField_a_of_type_Bdzn.jdField_j_of_type_Boolean) {
          l = paramLong1;
        }
        double d = l / paramLong1;
        akgm.a(l, this.jdField_q_of_type_Long, this.jdField_f_of_type_Boolean, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Bdzn.jdField_j_of_type_Boolean + ",Percent = " + d);
        }
      }
      b(true, paramLong1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localHashMap.put(localEntry.getKey(), localEntry.getValue());
      }
      bctj.a(BaseApplication.getContext()).a(null, c(), true, paramLong1, this.jdField_q_of_type_Long, localHashMap, "");
    }
    for (;;)
    {
      m();
      super.a(paramBoolean);
      return;
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long));
      b(false, paramLong1);
      bctj.a(BaseApplication.getContext()).a(null, c(), false, paramLong1, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  protected byte[] a()
  {
    this.jdField_f_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString).getSessionKey();
    if ((this.jdField_f_of_type_ArrayOfByte == null) || (this.jdField_f_of_type_ArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
      }
    }
    byte[] arrayOfByte;
    do
    {
      long l1;
      long l2;
      int i;
      int j;
      for (;;)
      {
        return null;
        this.jdField_g_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString).getHttpconn_sig_session();
        if ((this.jdField_g_of_type_ArrayOfByte == null) || (this.jdField_g_of_type_ArrayOfByte.length == 0))
        {
          if (QLog.isColorLevel())
          {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            return null;
          }
        }
        else {
          try
          {
            l1 = Long.valueOf(this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString).longValue();
            localObject2 = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.jdField_q_of_type_Long;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.jdField_b_of_type_ArrayOfByte;
            if ((localObject1 == null) || (localObject1.length == 0))
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
              return null;
            }
          }
          catch (Exception localException)
          {
            QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", localException);
            return null;
          }
        }
      }
      localObject2 = ByteBuffer.allocate(localException.length + 56 + 8);
      ((ByteBuffer)localObject2).putInt(0, 1).putLong(4, l1).putLong(12, l2).putInt(20, i).putInt(24, j);
      localObject2 = ((ByteBuffer)localObject2).array();
      System.arraycopy(localException, 0, localObject2, 28, localException.length);
      arrayOfByte = new Cryptor().encrypt((byte[])localObject2, this.jdField_f_of_type_ArrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
    return null;
    Object localObject2 = new CSDataHighwayHead.NewServiceTicket();
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_ukey.set(ByteStringMicro.copyFrom(arrayOfByte));
    ((CSDataHighwayHead.NewServiceTicket)localObject2).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_g_of_type_ArrayOfByte));
    return ((CSDataHighwayHead.NewServiceTicket)localObject2).toByteArray();
  }
  
  public void aN_()
  {
    super.aN_();
    r();
  }
  
  public int b()
  {
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      this.jdField_q_of_type_Boolean = false;
      d(1002);
      this.t = 0;
      this.jdField_s_of_type_Int = 0;
      if (this.w != 1)
      {
        this.jdField_f_of_type_JavaLangString = null;
        this.jdField_l_of_type_JavaLangString = null;
        this.jdField_s_of_type_Long = 0L;
      }
      this.jdField_m_of_type_JavaLangString = null;
      this.jdField_r_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_Bktt.a();
      w();
      this.jdField_a_of_type_Bdzi.a.post(new C2CPicUploadProcessor.5(this));
    }
    return 0;
  }
  
  protected void b(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    bduk localbduk;
    String str;
    if (parambeck != null)
    {
      int i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becm)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.d;
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if (parambebv.jdField_c_of_type_Int != 0) {
          break label432;
        }
        b(parambebv.jdField_a_of_type_Boolean);
        if (parambebv.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Bduk.jdField_e_of_type_Long = this.jdField_a_of_type_Bduk.jdField_a_of_type_Long;
          localbduk = this.jdField_a_of_type_Bduk;
          str = parambebv.jdField_a_of_type_JavaLangString;
          localbduk.jdField_g_of_type_JavaLangString = str;
          this.jdField_f_of_type_JavaLangString = str;
          localbduk = this.jdField_a_of_type_Bduk;
          parambebv = parambebv.jdField_b_of_type_JavaLangString;
          localbduk.jdField_h_of_type_JavaLangString = parambebv;
          this.jdField_l_of_type_JavaLangString = parambebv;
          if (this.jdField_a_of_type_Boolean) {
            if ((!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) || (!this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()))
            {
              this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
              t();
            }
          }
          for (;;)
          {
            i += 1;
            break;
            t();
          }
        }
        d(1002);
        if (a()) {
          break label249;
        }
      }
    }
    label249:
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
      if (!this.jdField_a_of_type_Boolean)
      {
        localbduk = this.jdField_a_of_type_Bduk;
        str = parambebv.jdField_a_of_type_JavaLangString;
        localbduk.jdField_g_of_type_JavaLangString = str;
        this.jdField_f_of_type_JavaLangString = str;
        localbduk = this.jdField_a_of_type_Bduk;
        str = parambebv.jdField_b_of_type_JavaLangString;
        localbduk.jdField_h_of_type_JavaLangString = str;
        this.jdField_l_of_type_JavaLangString = str;
      }
      for (;;)
      {
        this.jdField_m_of_type_JavaLangString = parambebv.jdField_c_of_type_JavaLangString;
        this.jdField_r_of_type_Long = parambebv.jdField_a_of_type_Long;
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
        }
        this.w = 1;
        if (!this.jdField_a_of_type_Boolean) {
          break label425;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction == null) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.continueTrans();
        this.jdField_f_of_type_Bdsz.a();
        break;
        this.jdField_b_of_type_Bdsz.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Bdsz.a();
      }
      s();
      break;
      d("<BDH_LOG> onBusiProtoResp() error : " + parambebv.jdField_c_of_type_Int + " ,select HTTP channel");
      this.w = 2;
    } while ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isFinish.get()) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.isSuccess.get()));
    label425:
    label432:
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
    d();
  }
  
  protected byte[] b()
  {
    int j = 6;
    int k = 3;
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    localPicInfoExt.uint32_busi_type.set(1);
    localPicInfoExt.uint32_src_term.set(5);
    localPicInfoExt.uint32_plat_type.set(9);
    int i = j;
    switch (bdwu.a().a())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = bdwu.a().a();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.p);
      localPicInfoExt.uint32_pic_height.set(this.jdField_q_of_type_Int);
      if (!this.n) {
        break;
      }
    }
    for (i = k;; i = 1)
    {
      localPicInfoExt.uint32_pic_flag.set(i);
      return localPicInfoExt.toByteArray();
      i = 3;
      break;
      i = 7;
      break;
      i = 8;
      break;
    }
  }
  
  public int c()
  {
    Object localObject = a();
    if ((localObject != null) && (((bdzn)localObject).h))
    {
      if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzr))) {
        this.n = ((bdzr)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    localObject = this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File((String)localObject);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + (String)localObject)));
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bduk.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + (String)localObject)));
      d();
      return -1;
    }
    localObject = bgmg.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(bgmg.jdField_a_of_type_JavaLangString)) || (!bgmg.f((String)localObject)))
      {
        a(9072, (String)localObject, c((String)localObject), null);
        d();
        new Handler(Looper.getMainLooper()).post(new C2CPicUploadProcessor.1(this));
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
    }
    if (l >= beao.a())
    {
      a(9063, (String)localObject, c((String)localObject), null);
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzr))) {
      this.n = ((bdzr)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  protected String c()
  {
    if (this.w == 1) {
      return "actC2CPicUploadV2";
    }
    return "actC2CPicUploadV1";
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_Bebv != null)
      {
        bedb.b(this.jdField_a_of_type_Bebv);
        this.jdField_a_of_type_Bebv = null;
      }
    }
    switch (this.w)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        d("<BDH_LOG> pause() BUT current status is INIT");
        return;
        d("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_Bdws == null);
      this.jdField_a_of_type_Bdvu.b(this.jdField_a_of_type_Bdws);
      this.jdField_a_of_type_Bdws = null;
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
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    Object localObject;
    bcxy localbcxy;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
          b("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            b("updateDb", "is multiMsg");
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            if (this.jdField_f_of_type_JavaLangString == null) {}
            for (str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
            {
              ((MessageForPic)localObject).uuid = str;
              ((MessageForPic)localObject).serial();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localbcxy = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localbcxy == null);
    localbcxy.ac = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localbcxy.ab = str;
      localbcxy.d = this.jdField_q_of_type_Long;
      localbcxy.jdField_e_of_type_Long = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = -1;
      localayyu.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localayyu.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.jdField_g_of_type_Boolean) {
      bovt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt, f());
    }
  }
  
  void e()
  {
    super.e();
    String str;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Int = 0;
      localayyu.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localayyu.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_l_of_type_JavaLangString;
        localayyu.jdField_c_of_type_JavaLangString = str;
        if (this.jdField_a_of_type_Bdzn.jdField_q_of_type_Boolean) {
          localayyu.jdField_a_of_type_JavaLangObject = a();
        }
        this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
      }
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bebv != null)
      {
        bedb.b(this.jdField_a_of_type_Bebv);
        this.jdField_a_of_type_Bebv = null;
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      c(true);
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = new bebv();
    bece localbece = new bece();
    localbece.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbece.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbece.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_d_of_type_JavaLangString;
    localbece.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbece.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbece.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbece.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbece.jdField_c_of_type_Int = this.p;
    localbece.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localbece.jdField_c_of_type_Boolean = bool;
      localbece.b = this.n;
      localbebv.jdField_a_of_type_Bedc = this;
      localbebv.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
      localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      a(localbece);
      MessageRecord localMessageRecord = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localbece.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.jdField_u_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label249;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    label249:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Bduk.a();
    d(1001);
    bdzn localbdzn = a();
    if ((localbdzn != null) && (localbdzn.h))
    {
      this.p = localbdzn.l;
      this.jdField_q_of_type_Int = localbdzn.jdField_m_of_type_Int;
      this.jdField_q_of_type_Long = localbdzn.jdField_e_of_type_Long;
      this.jdField_b_of_type_ArrayOfByte = bgmj.a(localbdzn.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localbdzn.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bduk.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.jdField_e_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
    }
    while (!a(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_e_of_type_ArrayOfByte = b();
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_a_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
        }
        f();
        s();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
      }
      this.jdField_a_of_type_Boolean = false;
      f();
      return;
    }
    f();
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_e_of_type_Bdsz.a();
    }
    while (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      return;
      this.jdField_b_of_type_Bdsz.a();
    }
    Object localObject = bgmj.a(this.jdField_m_of_type_JavaLangString);
    bdti localbdti = new bdti(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4, this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, localbdti, this.jdField_a_of_type_Int, this.jdField_e_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);; this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_b_of_type_ArrayOfByte, localbdti))
    {
      localObject = new bdtj(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      a(i, "SubmitError.", "", this.jdField_b_of_type_Bdsz);
      d();
      return;
    }
  }
  
  void t()
  {
    if (!f())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Bdsz);
        d();
        return;
      }
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null) {
        this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.a((im_msg_body.RichText)localObject1);
      }
      if ((this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
        ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
      }
      h();
      e();
      return;
    }
    this.jdField_c_of_type_Bdsz.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Bdsz);
      d();
      return;
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      localObject1 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label469;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label442;
      }
    }
    label442:
    for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Bdsz);
      d();
      return;
      if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
      break;
    }
    label469:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
      if (((MessageForPic)localObject1).isBlessPic)
      {
        ((MessageForPic)localObject1).uuid = this.jdField_f_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(999, true, ((MessageRecord)localObject1).frienduin);
        return;
      }
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Bdsz);
      d();
      return;
    }
    h();
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Anqd, this);
  }
  
  public void u()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) || (this.jdField_l_of_type_JavaLangString != null))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        t();
        return;
      }
      v();
      return;
    }
    aN_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdth
 * JD-Core Version:    0.7.0.1
 */