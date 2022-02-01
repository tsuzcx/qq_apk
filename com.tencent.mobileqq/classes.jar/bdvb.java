import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.1;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.4;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class bdvb
  extends bdst
  implements bhku
{
  long jdField_a_of_type_Long;
  anqd jdField_a_of_type_Anqd = new bdve(this);
  bdzi jdField_a_of_type_Bdzi;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  boolean jdField_a_of_type_Boolean = true;
  private long b;
  public boolean b;
  private boolean g;
  private boolean h;
  
  public bdvb(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_Bdzi = parambdzi;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
    {
      this.h = ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryPhoto;
      if (this.h) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private im_msg_body.Elem a()
  {
    Object localObject = (aopm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
    if ((localObject != null) && (((aopm)localObject).a()) && (((aopm)localObject).a() == 1L))
    {
      localObject = ((aopm)localObject).a();
      if (localObject != null)
      {
        int i = ((Setting)localObject).systemHeadID;
        int j = ((Setting)localObject).bHeadType;
        localObject = new im_msg_body.Elem();
        im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
        localCommonElem.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        ((im_msg_body.Elem)localObject).common_elem.set(localCommonElem);
        return localObject;
      }
    }
    return null;
  }
  
  private int i()
  {
    switch (this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int)
    {
    default: 
      return 200;
    case 1008: 
      return 105;
    case 1007: 
      return 101;
    case 1009: 
      return 104;
    case 1006: 
      return 103;
    }
    return 106;
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Bdul.a();
    this.jdField_a_of_type_Bduk.b.a();
    this.jdField_a_of_type_Bduk.jdField_a_of_type_Bdum.a();
    this.jdField_a_of_type_Bduk.jdField_c_of_type_Bdul.a();
    bduk localbduk = this.jdField_a_of_type_Bduk;
    long l = System.nanoTime();
    localbduk.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bduk.h = 0L;
  }
  
  public int a()
  {
    return super.a();
  }
  
  protected im_msg_body.RichText a()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject4 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject4).uint32_file_id.set((int)this.jdField_a_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = (bdyf)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject4).uint32_server_ip.set(a(((bdyf)localObject1).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject4).uint32_server_port.set(((bdyf)localObject1).jdField_a_of_type_Int);
        }
        g();
        ((im_msg_body.CustomFace)localObject4).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject4).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          ((im_msg_body.CustomFace)localObject4).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
        ((im_msg_body.CustomFace)localObject4).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_b_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject4).str_file_path.set(this.d);
        Object localObject1 = ((im_msg_body.CustomFace)localObject4).uint32_origin;
        if (!this.n) {
          break label999;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject5 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (MessageForPic.class.isInstance(localObject5))
        {
          localObject3 = (MessageForPic)localObject5;
          ((im_msg_body.CustomFace)localObject4).uint32_show_len.set(((MessageForPic)localObject3).mShowLength);
          ((im_msg_body.CustomFace)localObject4).uint32_download_len.set(((MessageForPic)localObject3).mDownloadLength);
          ((im_msg_body.CustomFace)localObject4).image_type.set(((MessageForPic)localObject3).imageType);
          if (((MessageForPic)localObject3).picExtraData != null)
          {
            localObject1 = ((MessageForPic)localObject3).picExtraData.getCustomFaceResvAttr();
            ((CustomFaceExtPb.ResvAttr)localObject1).uint32_source.set(a((MessageForPic)localObject3));
            ((im_msg_body.CustomFace)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
          }
        }
        else
        {
          ((im_msg_body.CustomFace)localObject4).biz_type.set(d());
          ((im_msg_body.CustomFace)localObject4).uint32_width.set(this.p);
          ((im_msg_body.CustomFace)localObject4).uint32_height.set(this.jdField_q_of_type_Int);
          ((im_msg_body.CustomFace)localObject4).uint32_size.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.CustomFace)localObject4).uint32_source.set(i());
          if (QLog.isColorLevel()) {
            b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject4).biz_type.get());
          }
          localObject3 = new im_msg_body.RichText();
          localObject1 = new im_msg_body.Elem();
          if (!annq.a((MessageRecord)localObject5)) {
            break label817;
          }
          ((im_msg_body.Elem)localObject1).hc_flash_pic.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(anni.a(2131704146)));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject1;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)))
            {
              localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg;
              localObject5 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
              if (localObject5 != null)
              {
                ((bcxy)localObject5).ac = this.jdField_c_of_type_JavaLangString;
                ((bcxy)localObject5).ab = this.d;
                ((bcxy)localObject5).c = this.jdField_a_of_type_Long;
                ((bcxy)localObject5).jdField_e_of_type_Long = ((MessageRecord)localObject1).time;
                ((bcxy)localObject5).d = this.jdField_q_of_type_Long;
                if (!ahte.b(((StructMsgForImageShare)localObject6).mMsgActionData)) {
                  break label985;
                }
                localObject6 = ((bcxy)localObject5).aa;
                ((bcxy)localObject5).aa = "";
                localObject1 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
                ((bcxy)localObject5).aa = ((String)localObject6);
                if ((!TextUtils.isEmpty(((MessageForStructing)localObject4).frienduin)) && (localObject1 != null))
                {
                  localObject4 = new im_msg_body.RichMsg();
                  ((im_msg_body.RichMsg)localObject4).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
                  localObject1 = new im_msg_body.Elem();
                  ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject4);
                  ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
                }
              }
            }
          }
          localObject1 = a();
          if ((localObject3 == null) || (((im_msg_body.RichText)localObject3).elems == null) || (localObject1 == null)) {
            break label997;
          }
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label997;
          }
          QLog.e("GroupPicUploadProcessor", 2, "QQ 18 constructPicRichText add richtext common_elem headid and type");
          break label997;
        }
        localObject1 = new CustomFaceExtPb.ResvAttr();
        continue;
        if (!anlk.a((MessageRecord)localObject5)) {
          break label965;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label817:
      Object localObject5 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject5).uint32_service_type.set(3);
      Object localObject6 = new hummer_commelem.MsgElemInfo_servtype3();
      ((hummer_commelem.MsgElemInfo_servtype3)localObject6).flash_troop_pic.set((MessageMicro)localObject4);
      ((im_msg_body.CommonElem)localObject5).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject6).toByteArray()));
      localException.common_elem.set((MessageMicro)localObject5);
      ((im_msg_body.RichText)localObject3).elems.add(localException);
      if (QLog.isColorLevel()) {
        QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
      }
      Object localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(anni.a(2131704145)));
      Object localObject4 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject2);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
      continue;
      label965:
      ((im_msg_body.Elem)localObject2).custom_face.set((MessageMicro)localObject4);
      ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
      continue;
      label985:
      localObject2 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
      continue;
      label997:
      return localObject3;
      label999:
      int i = 0;
    }
  }
  
  public void a(bebv parambebv, beck parambeck)
  {
    super.a(parambebv, parambeck);
    b(parambebv, parambeck);
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	bdvb:jdField_a_of_type_Bdzn	Lbdzn;
    //   6: iconst_1
    //   7: putfield 565	bdzn:jdField_l_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 46	bdvb:jdField_a_of_type_Bdzn	Lbdzn;
    //   14: getfield 51	bdzn:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 567	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 570	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 573	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 575	bdvb:g	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 577	bdvb:h	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 581	bdvb:f	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 577	bdvb:h	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 581	bdvb:f	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	bdvb
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
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
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if (!"connError_unreachable".equalsIgnoreCase((String)localObject2)) {
          break label346;
        }
      }
      label346:
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        while (this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int == 1030)
        {
          return;
          if ("connError_noroute".equalsIgnoreCase((String)localObject2)) {
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
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Bdsz.jdField_b_of_type_Long - this.jdField_b_of_type_Bdsz.jdField_a_of_type_Long) / 1000000L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.d);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.f + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", akgm.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bgnt.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.n + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int));
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Bdzn.p) {
          break label876;
        }
      }
      label876:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        e(paramBoolean);
        a(paramBoolean, l2, l1);
        return;
        i = 1;
        break;
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
        akgm.a(l, this.jdField_q_of_type_Long, this.f, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Bdzn.jdField_j_of_type_Boolean + ",Percent = " + d);
        }
      }
      b(true, paramLong1);
      bctj.a(BaseApplication.getContext()).a(null, c(), true, paramLong1, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
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
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long));
      b(false, paramLong1);
      bctj.a(BaseApplication.getContext()).a(null, c(), false, paramLong1, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  public void aN_()
  {
    super.aN_();
    f(false);
  }
  
  public int b()
  {
    if (this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = false;
      this.jdField_q_of_type_Boolean = false;
      d(1002);
      if (this.w != 1)
      {
        this.jdField_s_of_type_Long = 0L;
        this.jdField_m_of_type_JavaLangString = null;
      }
      this.jdField_t_of_type_Int = 0;
      this.jdField_s_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      this.jdField_j_of_type_Int = 0;
      this.jdField_j_of_type_JavaLangString = "";
      this.jdField_a_of_type_Bktt.a();
      v();
      this.jdField_a_of_type_Bdzi.a.post(new GroupPicUploadProcessor.4(this));
    }
    return 0;
  }
  
  protected void b(bebv parambebv, beck parambeck)
  {
    this.jdField_a_of_type_Bebv = null;
    int i;
    if (parambeck != null)
    {
      i = 0;
      if (i < parambeck.jdField_a_of_type_JavaUtilList.size())
      {
        parambebv = (becx)parambeck.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", parambebv.toString());
        }
        this.jdField_k_of_type_Boolean = parambebv.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_k_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Bdsz, parambebv);
        if ((parambebv instanceof becp))
        {
          parambebv = (becp)parambebv;
          if (parambebv.c != 0) {
            break label297;
          }
          b(parambebv.jdField_a_of_type_Boolean);
          if (!parambebv.jdField_a_of_type_Boolean) {
            break label204;
          }
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.f = true;
          this.jdField_a_of_type_Bduk.jdField_e_of_type_Long = this.jdField_a_of_type_Bduk.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = parambebv.jdField_a_of_type_Long;
          this.jdField_a_of_type_JavaUtilArrayList = parambebv.jdField_a_of_type_JavaUtilArrayList;
          s();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      label204:
      d(1002);
      if (!a()) {
        return;
      }
      this.jdField_a_of_type_Long = parambebv.jdField_a_of_type_Long;
      this.jdField_m_of_type_JavaLangString = parambebv.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = parambebv.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_s_of_type_Long = parambebv.jdField_b_of_type_Int;
      this.jdField_t_of_type_Long = parambebv.jdField_a_of_type_Int;
      this.jdField_r_of_type_Long = parambebv.jdField_b_of_type_Long;
      this.w = 1;
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
      }
      r();
    }
    label297:
    d("<BDH_LOG> onBusiProtoResp() error : " + parambebv.c + " ,select HTTP channel");
    this.w = 2;
    d();
  }
  
  public int c()
  {
    super.c();
    return h();
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.w == 1) {
        return "actGroupPicUploadV2";
      }
      return "actGroupPicUploadV1";
    }
    if (this.w == 1) {
      return "actDiscussPicUploadV2";
    }
    return "actDiscussPicUpload";
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
            ((MessageForPic)localObject).path = this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            ((MessageForPic)localObject).uuid = this.d;
            ((MessageForPic)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localbcxy = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localbcxy == null);
    localbcxy.ac = this.jdField_c_of_type_JavaLangString;
    localbcxy.ab = this.d;
    localbcxy.d = this.jdField_q_of_type_Long;
    localbcxy.c = this.jdField_a_of_type_Long;
    localbcxy.jdField_e_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
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
    if (this.jdField_a_of_type_Bdzn.n) {
      azub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(b());
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.h) {
      bovt.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt, f());
    }
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      ayyu localayyu = new ayyu();
      localayyu.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localayyu.d = this.jdField_c_of_type_JavaLangString;
      localayyu.jdField_c_of_type_JavaLangString = this.d;
      localayyu.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString;
      localayyu.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Bdzn.jdField_q_of_type_Boolean) {
        localayyu.jdField_a_of_type_JavaLangObject = a();
      }
      this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.b(localayyu);
    }
    for (;;)
    {
      d(1003);
      return;
      c(true);
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Bdsz.a();
    bebv localbebv = new bebv();
    bece localbece = new bece();
    localbece.jdField_a_of_type_JavaLangString = this.d;
    localbece.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
    localbece.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbece.c = this.p;
    localbece.d = this.jdField_q_of_type_Int;
    localbece.jdField_b_of_type_Boolean = this.n;
    localbece.jdField_b_of_type_Int = this.jdField_a_of_type_Bdzn.jdField_e_of_type_Int;
    a(localbece);
    MessageRecord localMessageRecord = this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localbece.jdField_a_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
      this.jdField_u_of_type_Int = ((MessageForPic)localMessageRecord).imageType;
    }
    localbece.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.jdField_b_of_type_JavaLangString;
    localbece.d = this.jdField_a_of_type_Bdzn.jdField_c_of_type_JavaLangString;
    localbece.e = this.jdField_a_of_type_Bdzn.d;
    localbece.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int == 1026)
    {
      localbece.f = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    localbebv.jdField_a_of_type_Bedc = this;
    localbebv.jdField_a_of_type_JavaLangString = "grp_pic_up";
    localbebv.jdField_a_of_type_JavaUtilList.add(localbece);
    localbebv.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_a_of_type_Bdsz);
      d();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        b("requestStart", localbebv.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Bebv = localbebv;
    bedb.a(localbebv);
  }
  
  protected void f(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Bduk.a();
    d(1001);
    bdzn localbdzn = a();
    if ((localbdzn != null) && (localbdzn.h))
    {
      this.p = localbdzn.jdField_l_of_type_Int;
      this.jdField_q_of_type_Int = localbdzn.jdField_m_of_type_Int;
      this.jdField_q_of_type_Long = localbdzn.jdField_e_of_type_Long;
      this.jdField_b_of_type_ArrayOfByte = bgmj.a(localbdzn.f);
      this.d = localbdzn.f;
      this.jdField_c_of_type_JavaLangString = this.d;
      this.jdField_a_of_type_Bduk.f = this.d;
      this.d = (this.d + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
    }
    while (!a(true)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
    f();
  }
  
  protected int h()
  {
    b("uiParam", this.jdField_a_of_type_Bdzn.toString());
    switch (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int)
    {
    }
    for (this.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Boolean = true)
    {
      localObject = a();
      if ((localObject == null) || (!((bdzn)localObject).h)) {
        break;
      }
      if ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject instanceof bdzr))) {
        this.n = ((bdzr)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
      }
      return 0;
    }
    Object localObject = this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString;
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
        new Handler(Looper.getMainLooper()).post(new GroupPicUploadProcessor.1(this));
        return -1;
      }
      this.e = ((String)localObject);
    }
    if (l >= beao.b())
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
  
  protected void o()
  {
    int i = this.jdField_a_of_type_Bdzn.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Bdws instanceof bdvs))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
      return;
    }
    ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString);
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_Long == -1L) {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_Bdsz.a();
      Object localObject = bgmj.a(this.jdField_m_of_type_JavaLangString);
      bdvc localbdvc = new bdvc(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, this.jdField_a_of_type_Bdzn.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_b_of_type_ArrayOfByte, localbdvc);
      localObject = new bdvd(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_Bdsz);
    d();
  }
  
  void s()
  {
    if (!f())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
      return;
    }
    this.jdField_c_of_type_Bdsz.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    t();
  }
  
  void t()
  {
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
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Bdzn.jdField_i_of_type_Boolean) && (this.f)) {
          ((MessageForPic)this.jdField_a_of_type_Bdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        h();
        e();
        return;
        if (!e())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Bdsz);
          d();
          return;
        }
        if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null) {
          this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Bdsz);
      d();
      return;
    }
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Bdsz);
      d();
      return;
    }
    if (this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt != null)
    {
      localObject1 = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Ayyt.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label402;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label375;
      }
    }
    label375:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
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
    label402:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    h();
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Anqd, this);
  }
  
  public void u()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if ((this.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_Long != 0L))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        s();
        return;
      }
      if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      aN_();
      return;
    }
    aN_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvb
 * JD-Core Version:    0.7.0.1
 */