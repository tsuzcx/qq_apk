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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class bcsp
  implements bcsi
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.RichText localRichText;
    Object localObject5;
    do
    {
      return;
      localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localObject5 = (im_msg_body.Ptt)localRichText.ptt.get();
      if ((localRichText.ptt.has()) && (((im_msg_body.Ptt)localObject5).uint32_file_type.has()) && ((((im_msg_body.Ptt)localObject5).uint32_file_type.get() == 4) || (((im_msg_body.Ptt)localObject5).uint32_file_type.get() == 6)) && (((im_msg_body.Ptt)localObject5).bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localObject5 == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("PTTDecoder", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(((im_msg_body.Ptt)localObject5).uint32_file_type.has()).append(" fileType:").append(((im_msg_body.Ptt)localObject5).uint32_file_type.get()).append(" hasUUID:").append(((im_msg_body.Ptt)localObject5).bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTTDecoder", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + ((im_msg_body.Ptt)localObject5).uint32_file_type.get());
    }
    int i4;
    long l1;
    Object localObject1;
    Object localObject6;
    int k;
    label356:
    int i2;
    int i5;
    int i6;
    Object localObject3;
    long l2;
    if (bduh.a(paramMessageHandler.app))
    {
      i4 = 1;
      l1 = -1L;
      localObject1 = "";
      if (!((im_msg_body.Ptt)localObject5).bytes_reserve.has()) {
        break label1993;
      }
      localObject6 = ((im_msg_body.Ptt)localObject5).bytes_reserve.get().toByteArray();
      if ((localObject6 == null) || (localObject6.length <= 1)) {
        break label1993;
      }
      i = localObject6[0];
      parambcre = "";
      k = 0;
      j = 0;
      i = 0;
      n = 0;
      m = 0;
      i1 = 1;
      if (i1 >= localObject6.length - 1) {
        break label869;
      }
      i2 = localObject6[i1];
      i1 += 1;
      i5 = bhvd.a((byte[])localObject6, i1);
      i6 = i1 + 2;
      if (i2 != 3) {
        break label509;
      }
      localObject3 = new byte[i5];
      bhvd.a((byte[])localObject3, 0, (byte[])localObject6, i6, i5);
      l2 = bhvd.a((byte[])localObject3, 0);
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
    label481:
    label509:
    Object localObject4;
    Object localObject7;
    Object localObject2;
    for (;;)
    {
      i1 = i6 + i5;
      localObject3 = parambcre;
      parambcre = (bcre)localObject1;
      localObject1 = localObject3;
      break label356;
      i4 = 0;
      break;
      if (i2 == 9)
      {
        localObject3 = new byte[i5];
        bhvd.a((byte[])localObject3, 0, (byte[])localObject6, i6, i5);
        n = bhrp.b(bhjx.a(bhvd.a((byte[])localObject3, 0)));
        localObject3 = parambcre;
        parambcre = (bcre)localObject1;
        localObject1 = localObject3;
      }
      else if (i2 == 8)
      {
        localObject3 = new byte[i5];
        bhvd.a((byte[])localObject3, 0, (byte[])localObject6, i6, i5);
        m = (int)bhvd.a((byte[])localObject3, 0);
        localObject3 = parambcre;
        parambcre = (bcre)localObject1;
        localObject1 = localObject3;
      }
      else
      {
        if (i2 != 10) {
          break label1978;
        }
        localObject4 = new byte[i5];
        bhvd.a((byte[])localObject4, 0, (byte[])localObject6, i6, i5);
        localObject7 = new ptt_reserve.ReserveStruct();
        localObject3 = localObject1;
        int i3 = k;
        i2 = j;
        i1 = i;
        try
        {
          ((ptt_reserve.ReserveStruct)localObject7).mergeFrom((byte[])localObject4);
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          i = ((ptt_reserve.ReserveStruct)localObject7).uint32_change_voice.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          j = ((ptt_reserve.ReserveStruct)localObject7).uint32_redpack_type.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          k = ((ptt_reserve.ReserveStruct)localObject7).uint32_autototext_voice.get();
          localObject3 = localObject1;
          i3 = k;
          i2 = j;
          i1 = i;
          localObject4 = ((ptt_reserve.ReserveStruct)localObject7).bytes_voice_text_abs.get().toStringUtf8();
          localObject1 = parambcre;
          localObject3 = localObject4;
          i3 = k;
          i2 = j;
          i1 = i;
          if (((ptt_reserve.ReserveStruct)localObject7).bytes_redpack_score_id.has())
          {
            localObject3 = localObject4;
            i3 = k;
            i2 = j;
            i1 = i;
            localObject1 = ((ptt_reserve.ReserveStruct)localObject7).bytes_redpack_score_id.get().toStringUtf8();
          }
          parambcre = (bcre)localObject4;
        }
        catch (Exception localException1)
        {
          localObject2 = parambcre;
          parambcre = (bcre)localObject3;
          k = i3;
          j = i2;
          i = i1;
        }
      }
    }
    label869:
    int i1 = j;
    int j = n;
    int n = m;
    int m = j;
    j = i;
    int i = i1;
    for (;;)
    {
      if (((im_msg_body.Ptt)localObject5).bytes_down_para.has())
      {
        localObject3 = ((im_msg_body.Ptt)localObject5).bytes_down_para.get();
        if (localObject3 == null) {}
      }
      for (localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();; localObject3 = "") {
        for (;;)
        {
          if (TextUtils.isEmpty((CharSequence)localObject3))
          {
            i1 = 1;
            bdll.b(paramMessageHandler.app, "CliOper", "", "", "0X80060E4", "0X80060E4", i1, 0, "", "", "", "8.4.5");
            localObject6 = ((im_msg_body.Ptt)localObject5).bytes_file_uuid.get().toStringUtf8();
            localObject4 = ((im_msg_body.Ptt)localObject5).bytes_file_name.get().toStringUtf8();
            localObject7 = bhml.a(((im_msg_body.Ptt)localObject5).bytes_file_md5.get().toByteArray());
          }
          try
          {
            if (!((String)localObject4).contains("_"))
            {
              localObject4 = ((String)localObject4).substring(0, ((String)localObject4).length() - 4);
              localObject4 = l3 + "_" + (String)localObject4;
              if (QLog.isColorLevel()) {
                QLog.d("PTTDecoder", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject4 + " fileUuid:" + (String)localObject6);
              }
              localObject4 = new RichMsg.PttRec();
              ((RichMsg.PttRec)localObject4).localPath.set((String)localObject6);
              ((RichMsg.PttRec)localObject4).size.set(((im_msg_body.Ptt)localObject5).uint32_file_size.get());
              ((RichMsg.PttRec)localObject4).type.set(2);
              ((RichMsg.PttRec)localObject4).uuid.set((String)localObject6);
              ((RichMsg.PttRec)localObject4).isRead.set(false);
              ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
              ((RichMsg.PttRec)localObject4).isReport.set(0);
              ((RichMsg.PttRec)localObject4).version.set(5);
              ((RichMsg.PttRec)localObject4).pttFlag.set(i4);
              ((RichMsg.PttRec)localObject4).autototext_voice.set(k);
              ((RichMsg.PttRec)localObject4).sttText.set((String)localObject2);
              l2 = System.currentTimeMillis() / 1000L;
              long l4 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject4).msgRecTime.set(l2);
              ((RichMsg.PttRec)localObject4).msgTime.set(l4);
              ((RichMsg.PttRec)localObject4).voiceType.set(n);
              ((RichMsg.PttRec)localObject4).voiceLength.set(m);
              ((RichMsg.PttRec)localObject4).voiceChangeFlag.set(j);
              ((RichMsg.PttRec)localObject4).redpack_type.set(i);
              if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                ((RichMsg.PttRec)localObject4).md5.set((String)localObject7);
              }
              if (QLog.isColorLevel()) {
                QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + n + " voiceLengh:" + m);
              }
              i = bcsa.a(paramMessageHandler.app, String.valueOf(l3));
              ((RichMsg.PttRec)localObject4).longPttVipFlag.set(i);
              ((RichMsg.PttRec)localObject4).directUrl.set((String)localObject3);
              localObject3 = bcry.a(-2002);
              ((MessageRecord)localObject3).msgtype = -2002;
              ((MessageRecord)localObject3).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
              ((MessageRecord)localObject3).time = l1;
              localObject4 = (MessageForPtt)localObject3;
              localObject5 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              if (QLog.isColorLevel())
              {
                localObject6 = new StringBuilder().append("<---decodePBMsgElems: elems: ");
                if (localObject5 != null) {
                  break label1770;
                }
                localObject2 = null;
                QLog.d("PTTDecoder", 2, localObject2);
              }
              if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
                break;
              }
              localObject2 = ((List)localObject5).iterator();
              do
              {
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                localObject6 = (im_msg_body.Elem)((Iterator)localObject2).next();
              } while ((!((im_msg_body.Elem)localObject6).general_flags.has()) || (!((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has()));
            }
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              try
              {
                localObject5 = new generalflags.ResvAttr();
                ((generalflags.ResvAttr)localObject5).mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                if (((generalflags.ResvAttr)localObject5).bytes_pb_ptt_waveform.has())
                {
                  localObject6 = new ptt_waveform.PttWaveform();
                  ((ptt_waveform.PttWaveform)localObject6).mergeFrom(((generalflags.ResvAttr)localObject5).bytes_pb_ptt_waveform.get().toByteArray());
                  ((MessageForPtt)localObject4).waveformArray = bhoi.a((ptt_waveform.PttWaveform)localObject6);
                  if (QLog.isColorLevel())
                  {
                    localObject5 = new StringBuilder();
                    localObject6 = ((MessageForPtt)localObject4).waveformArray;
                    j = localObject6.length;
                    i = 0;
                    if (i < j)
                    {
                      ((StringBuilder)localObject5).append(localObject6[i]);
                      ((StringBuilder)localObject5).append(";");
                      i += 1;
                      continue;
                      i1 = 2;
                      break;
                      localObject4 = ((String)localObject4).substring(((String)localObject4).lastIndexOf("_") + 1, ((String)localObject4).length() - 4);
                      continue;
                      localException2 = localException2;
                      localException2.printStackTrace();
                      continue;
                      label1770:
                      localObject2 = Integer.valueOf(((List)localObject5).size());
                      continue;
                    }
                    QLog.d("PTTDecoder", 2, "decodeC2CMsgPkg_PTT, waveformArray = " + ((StringBuilder)localObject5).toString());
                  }
                }
              }
              catch (Throwable localThrowable) {}
            }
            if ((localException2.waveformArray == null) || (localException2.waveformArray.length == 0)) {
              localException2.buileDefaultWaveform();
            }
            localException2.parse();
            paramList.add(localObject3);
            if (localRichText.elems.has())
            {
              paramList = localRichText.elems.get().iterator();
              while (paramList.hasNext())
              {
                localObject2 = (im_msg_body.Elem)paramList.next();
                if ((((im_msg_body.Elem)localObject2).common_elem.has()) && (21 == ((im_msg_body.Elem)localObject2).common_elem.uint32_service_type.get()))
                {
                  ArrayList localArrayList = new ArrayList();
                  localArrayList.add(localObject3);
                  aqyt.a(paramMsg, (im_msg_body.Elem)localObject2, localArrayList, paramMessageHandler.app);
                }
              }
            }
            aljb.b(parambcre, (MessageRecord)localObject3);
            return;
          }
        }
      }
      label1978:
      localObject3 = parambcre;
      parambcre = (bcre)localObject2;
      localObject2 = localObject3;
      break label481;
      label1993:
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
 * Qualified Name:     bcsp
 * JD-Core Version:    0.7.0.1
 */