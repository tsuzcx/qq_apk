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

public class barp
  extends barc
{
  private int jdField_a_of_type_Int;
  alwx jdField_a_of_type_Alwx = new bars(this);
  protected bayf a;
  public QQAppInterface a;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  protected CSDataHighwayHead.LoginSigHead a;
  protected boolean a;
  public boolean b;
  protected byte[] d;
  private barh e;
  protected byte[] e;
  private barh jdField_f_of_type_Barh = new barh();
  private byte[] jdField_f_of_type_ArrayOfByte;
  private boolean jdField_g_of_type_Boolean;
  private byte[] jdField_g_of_type_ArrayOfByte;
  
  public barp(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_e_of_type_Barh = new barh();
    this.jdField_a_of_type_Bayf = parambayf;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    this.jdField_a_of_type_Bass.jdField_b_of_type_Int = this.jdField_a_of_type_Bayk.jdField_b_of_type_Int;
    this.jdField_a_of_type_Bass.jdField_b_of_type_Long = this.jdField_a_of_type_Bayk.jdField_a_of_type_Long;
    this.jdField_a_of_type_Bass.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bass.q = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_Bass.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Bass.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = ((ProxyIpManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(3)).getProxyIp(3);
    this.jdField_a_of_type_Boolean = OpenUpConfig.isOpenUpEnable;
    this.jdField_a_of_type_Int = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
    {
      this.jdField_g_of_type_Boolean = ((MessageForPic)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryPhoto;
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
  }
  
  private im_msg_body.RichText a()
  {
    label1040:
    label1048:
    label1063:
    label1065:
    for (int i = 1;; i = 0)
    {
      im_msg_body.RichText localRichText;
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        try
        {
          localRichText = new im_msg_body.RichText();
          localObject3 = new im_msg_body.NotOnlineImage();
          g();
          ((im_msg_body.NotOnlineImage)localObject3).file_path.set(ByteStringMicro.copyFromUtf8(this.jdField_d_of_type_JavaLangString));
          if (this.jdField_a_of_type_Bass.jdField_h_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject3).download_path.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bass.jdField_h_of_type_JavaLangString));
          }
          if (this.jdField_a_of_type_Bass.jdField_g_of_type_JavaLangString != null) {
            ((im_msg_body.NotOnlineImage)localObject3).res_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_Bass.jdField_g_of_type_JavaLangString));
          }
          ((im_msg_body.NotOnlineImage)localObject3).file_len.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.NotOnlineImage)localObject3).pic_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
          ((im_msg_body.NotOnlineImage)localObject3).pic_height.set(this.jdField_q_of_type_Int);
          ((im_msg_body.NotOnlineImage)localObject3).pic_width.set(this.p);
          Object localObject1 = ((im_msg_body.NotOnlineImage)localObject3).original;
          if (!this.jdField_l_of_type_Boolean) {
            break label1065;
          }
          ((PBUInt32Field)localObject1).set(i);
          localObject4 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
          switch (this.jdField_a_of_type_Bayk.jdField_e_of_type_Int)
          {
          case 1008: 
            if (QLog.isColorLevel()) {
              b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_Bayk.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.NotOnlineImage)localObject3).biz_type.get());
            }
            localObject1 = new im_msg_body.Elem();
            if (!alse.a((MessageRecord)localObject4)) {
              break label1020;
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
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(alud.a(2131701677)));
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).text.set((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
            if (!(localObject5 instanceof MessageForStructing)) {
              break label1063;
            }
            localObject3 = (MessageForStructing)localObject5;
            if ((((MessageForStructing)localObject3).structingMsg == null) || (!(((MessageForStructing)localObject3).structingMsg instanceof StructMsgForImageShare))) {
              break label1063;
            }
            StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)((MessageForStructing)localObject3).structingMsg;
            localObject4 = localStructMsgForImageShare.getFirstImageElement();
            if (localObject4 == null) {
              break label1063;
            }
            ((azwy)localObject4).U = this.jdField_c_of_type_JavaLangString;
            if (this.jdField_f_of_type_JavaLangString != null) {
              break label1040;
            }
            localObject1 = this.jdField_l_of_type_JavaLangString;
            ((azwy)localObject4).T = ((String)localObject1);
            ((azwy)localObject4).d = this.jdField_q_of_type_Long;
            ((azwy)localObject4).jdField_e_of_type_Long = ((MessageRecord)localObject5).time;
            if (!agiy.b(localStructMsgForImageShare.mMsgActionData)) {
              break label1048;
            }
            localObject5 = ((azwy)localObject4).S;
            ((azwy)localObject4).S = "";
            localObject1 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
            ((azwy)localObject4).S = ((String)localObject5);
            if ((TextUtils.isEmpty(((MessageForStructing)localObject3).frienduin)) || (localObject1 == null)) {
              break label1063;
            }
            localObject3 = new im_msg_body.RichMsg();
            ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
            localRichText.elems.add((MessageMicro)localObject1);
            break label1063;
            localObject1 = new NotOnlineImageExtPb.ResvAttr();
            continue;
            if (!MessageForStructing.class.isInstance(localObject4)) {
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", localException);
          }
          localException.printStackTrace();
          return null;
        }
        if (((MessageForStructing)localObject4).isHotPicsStruct())
        {
          Object localObject2 = new NotOnlineImageExtPb.ResvAttr();
          ((NotOnlineImageExtPb.ResvAttr)localObject2).uint32_image_biz_type.set(2);
          ((im_msg_body.NotOnlineImage)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(2);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(3);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(4);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(5);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(6);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(7);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(8);
          continue;
          ((im_msg_body.NotOnlineImage)localObject3).biz_type.set(9);
          continue;
          label1020:
          ((im_msg_body.Elem)localObject2).not_online_image.set((MessageMicro)localObject3);
          localRichText.elems.add((MessageMicro)localObject2);
          continue;
          localObject2 = this.jdField_f_of_type_JavaLangString;
          continue;
          localObject2 = ((MessageForStructing)localObject3).structingMsg.getXmlBytes();
        }
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
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileId_str:" + paramArrayOfByte);
        }
        this.jdField_a_of_type_Bass.jdField_g_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_f_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_a_of_type_Bass.jdField_h_of_type_JavaLangString = paramArrayOfByte;
        this.jdField_l_of_type_JavaLangString = paramArrayOfByte;
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bayf.a.post(new C2CPicUploadProcessor.2(this));
  }
  
  private void w()
  {
    this.jdField_a_of_type_Bass.jdField_a_of_type_Bast.a();
    this.jdField_a_of_type_Bass.jdField_b_of_type_Bast.a();
    this.jdField_a_of_type_Bass.jdField_a_of_type_Basu.a();
    this.jdField_a_of_type_Bass.jdField_c_of_type_Bast.a();
    bass localbass = this.jdField_a_of_type_Bass;
    long l = System.nanoTime();
    localbass.jdField_g_of_type_Long = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bass.jdField_h_of_type_Long = 0L;
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
  
  public void a(bbax parambbax, bbbm parambbbm)
  {
    super.a(parambbax, parambbbm);
    b(parambbax, parambbbm);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + baws.b(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int) + "." + baws.a(this.jdField_a_of_type_Bayk.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      bool = paramBoolean;
      if (this.v == 1)
      {
        this.jdField_c_of_type_Barh.jdField_a_of_type_Int = 1;
        bool = true;
      }
    }
    Object localObject1 = this.jdField_a_of_type_Barh.a(1) + ";" + this.jdField_b_of_type_Barh.a(2) + ";" + this.jdField_c_of_type_Barh.a(3);
    Object localObject2 = this.jdField_e_of_type_Barh.a(21) + ";" + this.jdField_f_of_type_Barh.a(22);
    if (QLog.isColorLevel())
    {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + (String)localObject1);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + (String)localObject2);
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.jdField_a_of_type_Barh.toString() + ";mStepTrans: " + this.jdField_b_of_type_Barh.toString() + ";mStepMsg: " + this.jdField_c_of_type_Barh.toString() + ";mStepTransPre: " + this.jdField_e_of_type_Barh.toString() + ";mStepTransLeft: " + this.jdField_f_of_type_Barh.toString() + ";");
    }
    if (!bool)
    {
      if (this.jdField_j_of_type_Int == 9004) {
        break label505;
      }
      if (i()) {}
    }
    if (this.jdField_a_of_type_Bayk.jdField_e_of_type_Int == 1030) {}
    label505:
    Object localObject3;
    while (((!bool) && (bawk.b(this.jdField_j_of_type_Int))) || (this.h) || ((bool) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!bool) && ((this.jdField_m_of_type_Int & 0x1) > 0)))
    {
      return;
      localObject3 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
      if ("connError_unreachable".equalsIgnoreCase((String)localObject3))
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        break;
      }
      if (!"connError_noroute".equalsIgnoreCase((String)localObject3)) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
      break;
    }
    int j = this.jdField_m_of_type_Int;
    long l3;
    long l2;
    if (bool)
    {
      i = 2;
      this.jdField_m_of_type_Int = (i | j);
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      l3 = System.nanoTime();
      l2 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
      Log.i("AutoMonitor", "SendC2CPic, cost=" + (this.jdField_b_of_type_Barh.jdField_b_of_type_Long - this.jdField_b_of_type_Barh.jdField_a_of_type_Long) / 1000000L);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_openUpStep", localObject2);
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_f_of_type_JavaLangString != null) {
        break label1450;
      }
      localObject1 = this.jdField_l_of_type_JavaLangString;
      label764:
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_toUin", this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_f_of_type_Boolean + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", aips.a() + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bdin.a(BaseApplication.getContext()) + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Bayk.jdField_e_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_openUp", String.valueOf(this.jdField_a_of_type_Boolean));
      localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
      if (!this.jdField_a_of_type_Bayk.q) {
        break label1459;
      }
    }
    label1450:
    label1459:
    for (int i = 1;; i = 0)
    {
      ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
      f(bool);
      if (!bool) {
        break label1502;
      }
      p();
      if (this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean)
      {
        long l1 = 0L;
        if (this.jdField_u_of_type_Long != 0L) {
          l1 = (l3 - this.jdField_u_of_type_Long) / 1000000L;
        }
        if (this.jdField_a_of_type_Bayk.j) {
          l1 = l2;
        }
        double d1 = l1 / l2;
        aips.a(l1, this.jdField_q_of_type_Long, this.jdField_f_of_type_Boolean, d1);
        if ((d1 >= 0.0D) && (d1 <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d1 + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Bayk.j + ",Percent = " + d1);
        }
      }
      b(true, l2);
      localObject1 = new HashMap();
      localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((HashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
      }
      i = 1;
      break;
      localObject1 = this.jdField_f_of_type_JavaLangString;
      break label764;
    }
    azri.a(BaseApplication.getContext()).a(null, b(), true, l2, this.jdField_q_of_type_Long, (HashMap)localObject1, "");
    for (;;)
    {
      l();
      super.a(bool);
      return;
      label1502:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long));
      b(false, l2);
      azri.a(BaseApplication.getContext()).a(null, b(), false, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  protected byte[] a()
  {
    this.jdField_f_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString).getSessionKey();
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
        this.jdField_g_of_type_ArrayOfByte = SessionInfo.getInstance(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString).getHttpconn_sig_session();
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
            l1 = Long.valueOf(this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString).longValue();
            localObject2 = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
            Object localObject1 = localObject2;
            if (((String)localObject2).startsWith("+")) {
              localObject1 = ((String)localObject2).substring(1);
            }
            l2 = Long.valueOf((String)localObject1).longValue();
            i = (int)this.jdField_q_of_type_Long;
            j = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = this.jdField_a_of_type_ArrayOfByte;
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
  
  public void aP_()
  {
    super.aP_();
    r();
  }
  
  public int b()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = false;
      this.o = false;
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
      this.jdField_a_of_type_Bigh.a();
      w();
      this.jdField_a_of_type_Bayf.a.post(new C2CPicUploadProcessor.5(this));
    }
    return 0;
  }
  
  protected String b()
  {
    if (this.w == 1) {
      return "actC2CPicUploadV2";
    }
    return "actC2CPicUploadV1";
  }
  
  protected void b(bbax parambbax, bbbm parambbbm)
  {
    this.jdField_a_of_type_Bbax = null;
    bass localbass;
    String str;
    if (parambbbm != null)
    {
      int i = 0;
      if (i < parambbbm.jdField_a_of_type_JavaUtilList.size())
      {
        parambbax = (bbbo)parambbbm.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambbax.toString());
        }
        this.jdField_i_of_type_Boolean = parambbax.d;
        a(this.jdField_a_of_type_Barh, parambbax);
        if (parambbax.jdField_c_of_type_Int != 0) {
          break label432;
        }
        b(parambbax.jdField_a_of_type_Boolean);
        if (parambbax.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp picUpResp.isExist.");
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Bass.jdField_e_of_type_Long = this.jdField_a_of_type_Bass.jdField_a_of_type_Long;
          localbass = this.jdField_a_of_type_Bass;
          str = parambbax.jdField_a_of_type_JavaLangString;
          localbass.jdField_g_of_type_JavaLangString = str;
          this.jdField_f_of_type_JavaLangString = str;
          localbass = this.jdField_a_of_type_Bass;
          parambbax = parambbax.jdField_b_of_type_JavaLangString;
          localbass.jdField_h_of_type_JavaLangString = parambbax;
          this.jdField_l_of_type_JavaLangString = parambbax;
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
        localbass = this.jdField_a_of_type_Bass;
        str = parambbax.jdField_a_of_type_JavaLangString;
        localbass.jdField_g_of_type_JavaLangString = str;
        this.jdField_f_of_type_JavaLangString = str;
        localbass = this.jdField_a_of_type_Bass;
        str = parambbax.jdField_b_of_type_JavaLangString;
        localbass.jdField_h_of_type_JavaLangString = str;
        this.jdField_l_of_type_JavaLangString = str;
      }
      for (;;)
      {
        this.jdField_m_of_type_JavaLangString = parambbax.jdField_c_of_type_JavaLangString;
        this.jdField_r_of_type_Long = parambbax.jdField_a_of_type_Long;
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
        this.jdField_f_of_type_Barh.a();
        break;
        this.jdField_b_of_type_Barh.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Barh.a();
      }
      s();
      break;
      d("<BDH_LOG> onBusiProtoResp() error : " + parambbax.jdField_c_of_type_Int + " ,select HTTP channel");
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
    switch (bavg.a().a())
    {
    default: 
      i = j;
    case 2: 
      Object localObject = bavg.a().a();
      j = i;
      if (localObject != null)
      {
        j = i;
        if (((String)localObject).contains("wap")) {
          j = 5;
        }
      }
      localPicInfoExt.uint32_net_type.set(j);
      localObject = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject)) {
        localPicInfoExt.uint32_img_type.set(((MessageForPic)localObject).imageType);
      }
      localPicInfoExt.uint32_app_pic_type.set(1);
      localPicInfoExt.uint32_pic_width.set(this.p);
      localPicInfoExt.uint32_pic_height.set(this.jdField_q_of_type_Int);
      if (!this.jdField_l_of_type_Boolean) {
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
    if ((localObject != null) && (((bayk)localObject).h))
    {
      if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayo))) {
        this.jdField_l_of_type_Boolean = ((bayo)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    b("uiParam", this.jdField_a_of_type_Bayk.toString());
    localObject = this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString;
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
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bass.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_Bass.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + (String)localObject)));
      d();
      return -1;
    }
    localObject = bdhb.b((String)localObject);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((((String)localObject).contains(bdhb.jdField_a_of_type_JavaLangString)) || (!bdhb.f((String)localObject)))
      {
        a(9072, (String)localObject, d((String)localObject), null);
        d();
        new Handler(Looper.getMainLooper()).post(new C2CPicUploadProcessor.1(this));
        return -1;
      }
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
    }
    if (l >= bazm.a())
    {
      a(9063, (String)localObject, d((String)localObject), null);
      d();
      return -1;
    }
    if ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject instanceof bayo))) {
      this.jdField_l_of_type_Boolean = ((bayo)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    }
    return 0;
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_Bbax != null)
      {
        bbcd.b(this.jdField_a_of_type_Bbax);
        this.jdField_a_of_type_Bbax = null;
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
      } while (this.jdField_a_of_type_Bave == null);
      this.jdField_a_of_type_Baue.b(this.jdField_a_of_type_Bave);
      this.jdField_a_of_type_Bave = null;
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
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      awki localawki = new awki();
      localawki.jdField_a_of_type_Int = -1;
      localawki.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localawki.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.jdField_g_of_type_Boolean) {
      bmcp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt, f());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    Object localObject;
    azwy localazwy;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
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
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
              return;
            }
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localazwy = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localazwy == null);
    localazwy.U = this.jdField_c_of_type_JavaLangString;
    if (this.jdField_f_of_type_JavaLangString == null) {}
    for (String str = this.jdField_l_of_type_JavaLangString;; str = this.jdField_f_of_type_JavaLangString)
    {
      localazwy.T = str;
      localazwy.d = this.jdField_q_of_type_Long;
      localazwy.jdField_e_of_type_Long = localMessageRecord.time;
      ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
      return;
    }
  }
  
  void e()
  {
    super.e();
    String str;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      awki localawki = new awki();
      localawki.jdField_a_of_type_Int = 0;
      localawki.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localawki.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      if (this.jdField_f_of_type_JavaLangString == null)
      {
        str = this.jdField_l_of_type_JavaLangString;
        localawki.jdField_c_of_type_JavaLangString = str;
        if (this.jdField_a_of_type_Bayk.r) {
          localawki.jdField_a_of_type_JavaLangObject = a();
        }
        this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.b(localawki);
      }
    }
    for (;;)
    {
      d(1003);
      if (this.jdField_a_of_type_Bbax != null)
      {
        bbcd.b(this.jdField_a_of_type_Bbax);
        this.jdField_a_of_type_Bbax = null;
      }
      return;
      str = this.jdField_f_of_type_JavaLangString;
      break;
      d(true);
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Barh.a();
    bbax localbbax = new bbax();
    bbbg localbbbg = new bbbg();
    localbbbg.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_b_of_type_JavaLangString;
    localbbbg.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString;
    localbbbg.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_Bayk.jdField_d_of_type_JavaLangString;
    localbbbg.f = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbbbg.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbbbg.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbbbg.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localbbbg.jdField_c_of_type_Int = this.p;
    localbbbg.jdField_d_of_type_Int = this.jdField_q_of_type_Int;
    boolean bool;
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Int == 1006)
    {
      bool = true;
      localbbbg.jdField_c_of_type_Boolean = bool;
      localbbbg.b = this.jdField_l_of_type_Boolean;
      localbbax.jdField_a_of_type_Bbce = this;
      localbbax.jdField_a_of_type_JavaLangString = "c2c_pic_up";
      localbbax.jdField_a_of_type_JavaUtilList.add(localbbbg);
      localbbax.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      a(localbbbg);
      MessageRecord localMessageRecord = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localMessageRecord))
      {
        localbbbg.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
        this.jdField_u_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      }
      if (e()) {
        break label249;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Barh);
      d();
    }
    label249:
    do
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        b("requestStart", localbbax.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bbax = localbbax;
    bbcd.a(localbbax);
  }
  
  protected void r()
  {
    d(1000);
    this.jdField_a_of_type_Bass.a();
    d(1001);
    bayk localbayk = a();
    if ((localbayk != null) && (localbayk.h))
    {
      this.p = localbayk.l;
      this.jdField_q_of_type_Int = localbayk.jdField_m_of_type_Int;
      this.jdField_q_of_type_Long = localbayk.jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bdhe.a(localbayk.jdField_f_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = localbayk.jdField_f_of_type_JavaLangString;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Bass.jdField_f_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
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
      this.jdField_d_of_type_ArrayOfByte = a();
      this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead = a();
      this.jdField_e_of_type_ArrayOfByte = b();
      if ((this.jdField_d_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.jdField_d_of_type_ArrayOfByte + " mLoginSigHead:" + this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);
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
      this.jdField_e_of_type_Barh.a();
    }
    while (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      return;
      this.jdField_b_of_type_Barh.a();
    }
    Object localObject = bdhe.a(this.jdField_m_of_type_JavaLangString);
    barq localbarq = new barq(this, SystemClock.uptimeMillis());
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4, this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, this.jdField_d_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, localbarq, this.jdField_a_of_type_Int, this.jdField_e_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqHighwayProtocolCSDataHighwayHead$LoginSigHead);; this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_Bayk.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_a_of_type_ArrayOfByte, localbarq))
    {
      localObject = new barr(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bayk.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 1);
      }
      if (i == 0) {
        break;
      }
      a(i, "SubmitError.", "", this.jdField_b_of_type_Barh);
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
    Object localObject1 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if ((localObject1 != null) && ((localObject1 instanceof MessageForPic)) && (((MessageForPic)localObject1).DSKey != 0L))
    {
      e();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = a();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Barh);
        d();
        return;
      }
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null) {
        this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.a((im_msg_body.RichText)localObject1);
      }
      if ((this.jdField_a_of_type_Bayk.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
        ((MessageForPic)this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
      }
      h();
      e();
      return;
    }
    this.jdField_c_of_type_Barh.a();
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Barh);
      d();
      return;
    }
    if (this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh != null)
    {
      localObject1 = this.jdField_a_of_type_Bayk.jdField_a_of_type_Awkh.a((im_msg_body.RichText)localObject2);
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
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Barh);
      d();
      return;
      if (this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Bayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bayk.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bayk.jdField_a_of_type_Int, this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
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
      a(9366, "illegal app", null, this.jdField_c_of_type_Barh);
      d();
      return;
    }
    h();
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Alwx, this);
  }
  
  public void u()
  {
    if (this.o) {
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
    aP_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     barp
 * JD-Core Version:    0.7.0.1
 */