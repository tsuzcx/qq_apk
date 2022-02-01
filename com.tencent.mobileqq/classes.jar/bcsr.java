import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.Nullable;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class bcsr
  implements bcsk
{
  @Nullable
  private MessageForPtt a(msg_comm.Msg paramMsg, MessageForPtt paramMessageForPtt)
  {
    Object localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("<---decodePBMsgElems: elems: ");
      if (localObject1 == null)
      {
        paramMsg = null;
        QLog.d("PTTDecoder", 2, paramMsg);
      }
    }
    else
    {
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        break label102;
      }
      paramMsg = null;
    }
    label102:
    do
    {
      return paramMsg;
      paramMsg = Integer.valueOf(((List)localObject1).size());
      break;
      paramMsg = ((List)localObject1).iterator();
      while (paramMsg.hasNext())
      {
        localObject2 = (im_msg_body.Elem)paramMsg.next();
        if ((((im_msg_body.Elem)localObject2).general_flags.has()) && (((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.has())) {
          try
          {
            localObject1 = new generalflags.ResvAttr();
            ((generalflags.ResvAttr)localObject1).mergeFrom(((im_msg_body.Elem)localObject2).general_flags.bytes_pb_reserve.get().toByteArray());
            if (((generalflags.ResvAttr)localObject1).bytes_pb_ptt_waveform.has())
            {
              localObject2 = new ptt_waveform.PttWaveform();
              ((ptt_waveform.PttWaveform)localObject2).mergeFrom(((generalflags.ResvAttr)localObject1).bytes_pb_ptt_waveform.get().toByteArray());
              paramMessageForPtt.waveformArray = bhfx.a((ptt_waveform.PttWaveform)localObject2);
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                if (paramMessageForPtt.waveformArray != null)
                {
                  localObject2 = paramMessageForPtt.waveformArray;
                  int j = localObject2.length;
                  int i = 0;
                  while (i < j)
                  {
                    ((StringBuilder)localObject1).append(localObject2[i]);
                    ((StringBuilder)localObject1).append(";");
                    i += 1;
                  }
                }
                QLog.d("PTTDecoder", 2, "decodeC2CMsgPkg_PTT, waveformArray = " + ((StringBuilder)localObject1).toString());
              }
            }
          }
          catch (Throwable localThrowable) {}
        }
      }
      if (paramMessageForPtt.waveformArray == null) {
        break label350;
      }
      paramMsg = paramMessageForPtt;
    } while (paramMessageForPtt.waveformArray.length != 0);
    label350:
    paramMessageForPtt.buileDefaultWaveform();
    return paramMessageForPtt;
  }
  
  private void a(long paramLong, String paramString1, String paramString2)
  {
    try
    {
      if (!paramString2.contains("_")) {}
      for (paramString2 = paramString2.substring(0, paramString2.length() - 4);; paramString2 = paramString2.substring(paramString2.lastIndexOf("_") + 1, paramString2.length() - 4))
      {
        paramString2 = paramLong + "_" + paramString2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PTTDecoder", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + paramString2 + " fileUuid:" + paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, im_msg_body.RichText paramRichText, MessageRecord paramMessageRecord)
  {
    if (paramRichText.elems.has())
    {
      paramRichText = paramRichText.elems.get().iterator();
      while (paramRichText.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramRichText.next();
        if ((localElem.common_elem.has()) && (21 == localElem.common_elem.uint32_service_type.get()))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramMessageRecord);
          aqvh.a(paramMsg, localElem, localArrayList, paramMessageHandler.app);
        }
      }
    }
  }
  
  private boolean a(im_msg_body.RichText paramRichText, im_msg_body.Ptt paramPtt)
  {
    if ((!paramRichText.ptt.has()) || (!paramPtt.uint32_file_type.has()) || ((paramPtt.uint32_file_type.get() != 4) && (paramPtt.uint32_file_type.get() != 6)) || (!paramPtt.bytes_file_uuid.has()))
    {
      if (QLog.isColorLevel())
      {
        paramRichText = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
        if (paramPtt != null) {
          break label92;
        }
        paramRichText.append(" ptt is null.");
      }
      for (;;)
      {
        QLog.d("PTTDecoder", 2, paramRichText.toString());
        return true;
        label92:
        paramRichText.append(" HasileType:").append(paramPtt.uint32_file_type.has()).append(" fileType:").append(paramPtt.uint32_file_type.get()).append(" hasUUID:").append(paramPtt.bytes_file_uuid.has());
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTTDecoder", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + paramPtt.uint32_file_type.get());
    }
    return false;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.RichText localRichText;
    im_msg_body.Ptt localPtt;
    do
    {
      return;
      localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)localRichText.ptt.get();
    } while (a(localRichText, localPtt));
    int i4;
    long l1;
    Object localObject1;
    Object localObject5;
    int k;
    label181:
    int i2;
    int i5;
    int i6;
    Object localObject3;
    long l2;
    if (bdtt.a(paramMessageHandler.app))
    {
      i4 = 1;
      l1 = -1L;
      localObject1 = "";
      if (!localPtt.bytes_reserve.has()) {
        break label1265;
      }
      localObject5 = localPtt.bytes_reserve.get().toByteArray();
      if ((localObject5 == null) || (localObject5.length <= 1)) {
        break label1265;
      }
      i = localObject5[0];
      parambcre = "";
      k = 0;
      j = 0;
      i = 0;
      n = 0;
      m = 0;
      i1 = 1;
      if (i1 >= localObject5.length - 1) {
        break label695;
      }
      i2 = localObject5[i1];
      i1 += 1;
      i5 = PkgTools.getShortData((byte[])localObject5, i1);
      i6 = i1 + 2;
      if (i2 != 3) {
        break label335;
      }
      localObject3 = new byte[i5];
      PkgTools.copyData((byte[])localObject3, 0, (byte[])localObject5, i6, i5);
      l2 = PkgTools.getLongData((byte[])localObject3, 0);
      if (l2 > 0L) {
        l1 = l2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTTDecoder", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
      }
      localObject3 = localObject1;
      localObject1 = parambcre;
      parambcre = (bcre)localObject3;
    }
    label307:
    label335:
    Object localObject4;
    Object localObject6;
    Object localObject2;
    for (;;)
    {
      i1 = i6 + i5;
      localObject3 = parambcre;
      parambcre = (bcre)localObject1;
      localObject1 = localObject3;
      break label181;
      i4 = 0;
      break;
      if (i2 == 9)
      {
        localObject3 = new byte[i5];
        PkgTools.copyData((byte[])localObject3, 0, (byte[])localObject5, i6, i5);
        n = bhhd.b(bhbx.a(PkgTools.getLongData((byte[])localObject3, 0)));
        localObject3 = parambcre;
        parambcre = (bcre)localObject1;
        localObject1 = localObject3;
      }
      else if (i2 == 8)
      {
        localObject3 = new byte[i5];
        PkgTools.copyData((byte[])localObject3, 0, (byte[])localObject5, i6, i5);
        m = (int)PkgTools.getLongData((byte[])localObject3, 0);
        localObject3 = parambcre;
        parambcre = (bcre)localObject1;
        localObject1 = localObject3;
      }
      else
      {
        if (i2 != 10) {
          break label1250;
        }
        localObject4 = new byte[i5];
        PkgTools.copyData((byte[])localObject4, 0, (byte[])localObject5, i6, i5);
        localObject6 = new ptt_reserve.ReserveStruct();
        localObject3 = localObject1;
        int i3 = k;
        i2 = j;
        i1 = i;
        try
        {
          ((ptt_reserve.ReserveStruct)localObject6).mergeFrom((byte[])localObject4);
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          i = ((ptt_reserve.ReserveStruct)localObject6).uint32_change_voice.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          j = ((ptt_reserve.ReserveStruct)localObject6).uint32_redpack_type.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          k = ((ptt_reserve.ReserveStruct)localObject6).uint32_autototext_voice.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          localObject4 = ((ptt_reserve.ReserveStruct)localObject6).bytes_voice_text_abs.get().toStringUtf8();
          localObject1 = parambcre;
          localObject3 = localObject4;
          i3 = k;
          i2 = j;
          i1 = i;
          if (((ptt_reserve.ReserveStruct)localObject6).bytes_redpack_score_id.has())
          {
            localObject3 = localObject4;
            i3 = k;
            i2 = j;
            i1 = i;
            localObject1 = ((ptt_reserve.ReserveStruct)localObject6).bytes_redpack_score_id.get().toStringUtf8();
          }
          parambcre = (bcre)localObject4;
        }
        catch (Exception localException)
        {
          localObject2 = parambcre;
          parambcre = (bcre)localObject3;
          k = i3;
          j = i2;
          i = i1;
        }
      }
    }
    label695:
    int i1 = j;
    int j = n;
    int n = m;
    int m = j;
    j = i;
    int i = i1;
    for (;;)
    {
      if (localPtt.bytes_down_para.has())
      {
        localObject3 = localPtt.bytes_down_para.get();
        if (localObject3 == null) {}
      }
      for (localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();; localObject3 = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject3)) {}
        for (i1 = 1;; i1 = 2)
        {
          bdla.b(paramMessageHandler.app, "CliOper", "", "", "0X80060E4", "0X80060E4", i1, 0, "", "", "", "8.4.10");
          localObject4 = localPtt.bytes_file_uuid.get().toStringUtf8();
          localObject6 = localPtt.bytes_file_name.get().toStringUtf8();
          localObject5 = HexUtil.bytes2HexStr(localPtt.bytes_file_md5.get().toByteArray());
          a(l3, (String)localObject4, (String)localObject6);
          localObject6 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject6).localPath.set((String)localObject4);
          ((RichMsg.PttRec)localObject6).size.set(localPtt.uint32_file_size.get());
          ((RichMsg.PttRec)localObject6).type.set(2);
          ((RichMsg.PttRec)localObject6).uuid.set((String)localObject4);
          ((RichMsg.PttRec)localObject6).isRead.set(false);
          ((RichMsg.PttRec)localObject6).serverStorageSource.set("pttcenter");
          ((RichMsg.PttRec)localObject6).isReport.set(0);
          ((RichMsg.PttRec)localObject6).version.set(5);
          ((RichMsg.PttRec)localObject6).pttFlag.set(i4);
          ((RichMsg.PttRec)localObject6).autototext_voice.set(k);
          ((RichMsg.PttRec)localObject6).sttText.set((String)localObject2);
          l2 = System.currentTimeMillis() / 1000L;
          long l4 = paramMsg.msg_head.msg_time.get();
          ((RichMsg.PttRec)localObject6).msgRecTime.set(l2);
          ((RichMsg.PttRec)localObject6).msgTime.set(l4);
          ((RichMsg.PttRec)localObject6).voiceType.set(n);
          ((RichMsg.PttRec)localObject6).voiceLength.set(m);
          ((RichMsg.PttRec)localObject6).voiceChangeFlag.set(j);
          ((RichMsg.PttRec)localObject6).redpack_type.set(i);
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            ((RichMsg.PttRec)localObject6).md5.set((String)localObject5);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + n + " voiceLengh:" + m);
          }
          i = bcsc.a(paramMessageHandler.app, String.valueOf(l3));
          ((RichMsg.PttRec)localObject6).longPttVipFlag.set(i);
          ((RichMsg.PttRec)localObject6).directUrl.set((String)localObject3);
          localObject2 = bcsa.a(-2002);
          ((MessageRecord)localObject2).msgtype = -2002;
          ((MessageRecord)localObject2).msgData = ((RichMsg.PttRec)localObject6).toByteArray();
          ((MessageRecord)localObject2).time = l1;
          localObject3 = a(paramMsg, (MessageForPtt)localObject2);
          if (localObject3 == null) {
            break;
          }
          ((MessageForPtt)localObject3).parse();
          paramList.add(localObject2);
          a(paramMessageHandler, paramMsg, localRichText, (MessageRecord)localObject2);
          alcm.b(parambcre, (MessageRecord)localObject2);
          return;
        }
      }
      label1250:
      localObject3 = parambcre;
      parambcre = (bcre)localObject2;
      localObject2 = localObject3;
      break label307;
      label1265:
      localObject2 = "";
      parambcre = "";
      k = 0;
      i = 0;
      j = 0;
      m = 0;
      n = 0;
      l1 = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsr
 * JD-Core Version:    0.7.0.1
 */