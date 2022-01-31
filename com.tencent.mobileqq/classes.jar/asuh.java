import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class asuh
  extends auon
{
  ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = null;
  
  asuh(asug paramasug, ArrayList paramArrayList, HashMap paramHashMap, MessageRecord paramMessageRecord, astr paramastr, asue paramasue) {}
  
  private int a(MessageForPic paramMessageForPic, aunu paramaunu)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject = "";
    if (paramaunu.jdField_a_of_type_JavaLangObject != null) {
      if ((paramaunu.jdField_a_of_type_JavaLangObject instanceof im_msg_body.NotOnlineImage))
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramaunu.jdField_a_of_type_JavaLangObject);
        if (paramMessageForPic.picExtraData != null)
        {
          localObject = paramMessageForPic.picExtraData.getOfflineImageResvAttr();
          localElem.not_online_image.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((NotOnlineImageExtPb.ResvAttr)((NotOnlineImageExtPb.ResvAttr)localObject).get()).toByteArray()), true);
        }
        if (paramaunu.b)
        {
          if (!localElem.not_online_image.res_id.has()) {
            break label314;
          }
          localObject = localElem.not_online_image.res_id.get().toStringUtf8();
        }
      }
    }
    for (;;)
    {
      paramMessageForPic.uuid = ((String)localObject);
      paramMessageForPic.path = ((String)localObject);
      paramMessageForPic.md5 = bbdj.c(asty.a);
      paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
      paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
      paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
      paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, " pic resp uuid = " + (String)localObject + " picMsgMD5 = " + paramMessageForPic.md5 + " hasCode = " + paramMessageForPic.hashCode());
      }
      int i = 1;
      for (;;)
      {
        if (i != 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic success");
          }
          localRichText.elems.add(localElem);
          if (paramaunu.jdField_a_of_type_Int == 0)
          {
            i = 0;
            paramMessageForPic.richText = localRichText;
            return i;
            label314:
            if (!localElem.not_online_image.download_path.has()) {
              break label597;
            }
            localObject = localElem.not_online_image.download_path.get().toStringUtf8();
            break;
            if ((paramaunu.jdField_a_of_type_JavaLangObject instanceof im_msg_body.CustomFace))
            {
              localElem.custom_face.set((im_msg_body.CustomFace)paramaunu.jdField_a_of_type_JavaLangObject);
              if (paramMessageForPic.picExtraData != null)
              {
                CustomFaceExtPb.ResvAttr localResvAttr = paramMessageForPic.picExtraData.getCustomFaceResvAttr();
                localElem.custom_face.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)localResvAttr.get()).toByteArray()), true);
              }
              if (paramaunu.b)
              {
                if (localElem.custom_face.str_file_path.has()) {
                  localObject = localElem.custom_face.str_file_path.get();
                }
                paramMessageForPic.uuid = ((String)localObject);
                paramMessageForPic.path = ((String)localObject);
                paramMessageForPic.md5 = bbdj.c(asty.a);
                paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
              }
              i = 1;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("PicMultiMsgProcessor", 2, "WTF, picResult.mExtraObj is " + paramaunu.jdField_a_of_type_JavaLangObject.getClass().getSimpleName());
            }
            i = 0;
            continue;
          }
          if (paramaunu.jdField_a_of_type_Aunp == null) {
            break label591;
          }
        }
      }
      label591:
      for (int j = paramaunu.jdField_a_of_type_Aunp.jdField_a_of_type_Int;; j = -1)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PicMultiMsgProcessor", 2, "[requestUploadPics] Bad picture element");
        i = j;
        break;
        if (QLog.isColorLevel()) {
          QLog.e("PicMultiMsgProcessor", 2, "updateMessageForPic failed, add empty element");
        }
        i = -1;
        break;
      }
      label597:
      localObject = "";
    }
  }
  
  private boolean a(ArrayList<aunu> paramArrayList)
  {
    int k = 0;
    boolean bool1 = false;
    int n = 0;
    int j = 0;
    Object localObject1;
    int i;
    label152:
    int m;
    boolean bool2;
    label288:
    Object localObject2;
    label483:
    int i1;
    if (n < this.b.size())
    {
      localObject1 = (MessageRecord)this.b.get(n);
      i = k;
      if (j < paramArrayList.size())
      {
        i = k;
        if (((aunu)paramArrayList.get(j)).b) {
          i = 1;
        }
      }
      if (((localObject1 instanceof MessageForPic)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForPic))))
      {
        if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
          QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
        }
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForPic)((MessageForReplyText)localObject1).getSourceMessage();
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + n + "], resultIndex[" + j + "]");
          }
          m = a((MessageForPic)localObject1, (aunu)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (m != 0)
          {
            b(m);
            if (!this.jdField_a_of_type_Asug.a(m)) {
              break label288;
            }
            bool2 = true;
            k = i;
          }
        }
        for (;;)
        {
          i = j + 1;
          j = k;
          bool1 = bool2;
          n += 1;
          k = j;
          j = i;
          break;
          localObject1 = (MessageForPic)localObject1;
          break label152;
          localObject2 = this.jdField_a_of_type_Asug.a.a().a((MessageRecord)localObject1, asug.a(), false);
          ((MessageRecord)localObject2).setId(((MessageForPic)localObject1).getId());
          ((MessageRecord)localObject2).setStatus(((MessageForPic)localObject1).getStatus());
          this.b.set(n, localObject2);
          bool2 = this.jdField_a_of_type_Asug.a.a().a(this.jdField_a_of_type_JavaUtilHashMap, (MessageRecord)localObject2);
          if (QLog.isColorLevel()) {
            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForPic errCode:%d, update:%s, uniseq:%d", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
          }
          k = 1;
          bool2 = bool1;
        }
      }
      if (((localObject1 instanceof MessageForMixedMsg)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForMixedMsg)))) {
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForMixedMsg)((MessageForReplyText)localObject1).getSourceMessage();
          if (((MessageForMixedMsg)localObject1).msgElemList == null) {
            break label814;
          }
          i1 = 0;
          label494:
          m = j;
          k = i;
          bool2 = bool1;
          if (i1 >= ((MessageForMixedMsg)localObject1).msgElemList.size()) {
            break label824;
          }
          localObject2 = (MessageRecord)((MessageForMixedMsg)localObject1).msgElemList.get(i1);
          if (!(localObject2 instanceof MessageForPic)) {
            break label1719;
          }
          if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject2 = (MessageForPic)localObject2;
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + n + "], subMsgIndex[" + i1 + ", resultIndex[" + j + "]");
          }
          m = a((MessageForPic)localObject2, (aunu)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (m != 0)
          {
            b(m);
            if (!this.jdField_a_of_type_Asug.a(m)) {
              break label724;
            }
            bool2 = true;
            k = i;
          }
          label686:
          i = j + 1;
          j = k;
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      k = j;
      j = i;
      i = k;
      break label494;
      localObject1 = (MessageForMixedMsg)localObject1;
      break label483;
      label724:
      localObject2 = this.jdField_a_of_type_Asug.a.a().a((MessageRecord)localObject2, ajyc.a(2131708151), false);
      ((MessageForMixedMsg)localObject1).msgElemList.set(i1, localObject2);
      if (QLog.isColorLevel()) {
        QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForMixedMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(m), Long.valueOf(((MessageRecord)localObject2).uniseq) }));
      }
      k = 1;
      bool2 = bool1;
      break label686;
      label814:
      bool2 = bool1;
      k = i;
      m = j;
      label824:
      i = m;
      j = k;
      bool1 = bool2;
      break;
      if ((((MessageRecord)localObject1).msgtype == -1036) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && (((MessageForReplyText)localObject1).getSourceMessage().msgtype == -1036))) {
        if ((localObject1 instanceof MessageForReplyText))
        {
          localObject1 = (MessageForLongMsg)((MessageForReplyText)localObject1).getSourceMessage();
          label905:
          localObject1 = ((MessageForLongMsg)localObject1).longMsgFragmentList.iterator();
        }
      }
      label1705:
      label1716:
      for (;;)
      {
        label965:
        Object localObject3;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (!(localObject2 instanceof MessageForMixedMsg)) {
            continue;
          }
          localObject2 = (MessageForMixedMsg)localObject2;
          if (((MessageForMixedMsg)localObject2).msgElemList == null) {
            continue;
          }
          m = 0;
          if (m >= ((MessageForMixedMsg)localObject2).msgElemList.size()) {
            break label1716;
          }
          localObject3 = (MessageRecord)((MessageForMixedMsg)localObject2).msgElemList.get(m);
          if (!(localObject3 instanceof MessageForPic)) {
            break label1705;
          }
          if ((j >= paramArrayList.size()) && (QLog.isColorLevel())) {
            QLog.e("PicMultiMsgProcessor", 2, "WTF, The count of MessageForPics is not equal to the count of PicResults");
          }
          localObject3 = (MessageForPic)localObject3;
          if (QLog.isColorLevel()) {
            QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForMixedMsg, MsgIndex[" + n + "], subMsgIndex[" + m + ", resultIndex[" + j + "]");
          }
          i1 = a((MessageForPic)localObject3, (aunu)paramArrayList.get(j));
          k = i;
          bool2 = bool1;
          if (i1 != 0)
          {
            b(i1);
            if (this.jdField_a_of_type_Asug.a(i1))
            {
              bool2 = true;
              k = i;
            }
          }
          else
          {
            label1147:
            i = j + 1;
            j = k;
            bool1 = bool2;
          }
        }
        for (;;)
        {
          m += 1;
          k = j;
          j = i;
          i = k;
          break label965;
          localObject1 = (MessageForLongMsg)localObject1;
          break label905;
          localObject3 = this.jdField_a_of_type_Asug.a.a().a((MessageRecord)localObject3, ajyc.a(2131708152), false);
          ((MessageForMixedMsg)localObject2).msgElemList.set(m, localObject3);
          if (QLog.isColorLevel()) {
            QLog.e("PicMultiMsgProcessor", 2, String.format("updateMessageForLongMsg errCode:%d, uniseq:%d", new Object[] { Integer.valueOf(i1), Long.valueOf(((MessageRecord)localObject3).uniseq) }));
          }
          k = 1;
          bool2 = bool1;
          break label1147;
          k = i;
          i = j;
          j = k;
          break;
          if (((localObject1 instanceof MessageForStructing)) || (((localObject1 instanceof MessageForReplyText)) && (((MessageForReplyText)localObject1).getSourceMessage() != null) && ((((MessageForReplyText)localObject1).getSourceMessage() instanceof MessageForMixedMsg))))
          {
            if ((localObject1 instanceof MessageForReplyText))
            {
              localObject1 = (MessageForStructing)((MessageForReplyText)localObject1).getSourceMessage();
              localObject2 = ((MessageForStructing)localObject1).structingMsg;
            }
            for (;;)
            {
              if ((localObject2 != null) && ((localObject2 instanceof StructMsgForImageShare)))
              {
                localObject2 = ((StructMsgForImageShare)localObject2).getFirstImageElement();
                if ((localObject2 != null) && (((axwt)localObject2).a != null))
                {
                  localObject2 = ((axwt)localObject2).a;
                  if (QLog.isColorLevel()) {
                    QLog.d("PicMultiMsgProcessor", 2, "updateMessageForPic for MessageForPic, MsgIndex[" + n + "], resultIndex[" + j + "]");
                  }
                  if (((MessageForStructing)localObject1).isHotPicsStruct())
                  {
                    localObject1 = new PicMessageExtraData();
                    ((PicMessageExtraData)localObject1).imageBizType = 2;
                    ((MessageForPic)localObject2).picExtraData = ((PicMessageExtraData)localObject1);
                  }
                  k = a((MessageForPic)localObject2, (aunu)paramArrayList.get(j));
                  bool2 = bool1;
                  if (k != 0)
                  {
                    b(k);
                    bool2 = bool1;
                    if (this.jdField_a_of_type_Asug.a(k)) {
                      bool2 = true;
                    }
                  }
                  k = j + 1;
                  j = i;
                  bool1 = bool2;
                  i = k;
                  break;
                  localObject1 = (MessageForStructing)localObject1;
                  localObject2 = ((MessageForStructing)localObject1).structingMsg;
                  continue;
                  if (k != 0)
                  {
                    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
                      axqw.b(this.jdField_a_of_type_Asug.a, "CliOper", "", "", "0X800662B", "0X800662B", 0, 1, 0, "", "", "", "");
                    }
                    if (QLog.isColorLevel()) {
                      QLog.e("PicMultiMsgProcessor", 2, "requestUploadPics isPicMsgModify");
                    }
                    this.jdField_a_of_type_Asug.a.a().a().a(this.b, null);
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.isReMultiMsg) {
                    axqw.b(this.jdField_a_of_type_Asug.a, "CliOper", "", "", "0X800662A", "0X800662A", 0, 1, 0, "", "", "", "");
                  }
                  return bool1;
                }
              }
            }
          }
          k = i;
          i = j;
          j = k;
          break;
          k = i;
          i = j;
          j = k;
        }
      }
      label1719:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList<aunu> paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "onForwardMultiMsgPicsUpload success[" + paramArrayList.size() + "]");
      }
      boolean bool2 = a(paramArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("PicMultiMsgProcessor", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("totalCount", String.valueOf(paramArrayList.size()));
      axrl localaxrl;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localHashMap.put("errCount", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
        localHashMap.put("errCodeStr", Arrays.asList(new ArrayList[] { this.jdField_a_of_type_JavaUtilArrayList }).toString());
        localHashMap.put("errCode", String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.get(0)));
        localaxrl = axrl.a(BaseApplication.getContext());
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          break label261;
        }
      }
      label261:
      for (bool1 = true;; bool1 = false)
      {
        localaxrl.a(null, "MultiMsgPicSendResult", bool1, 0L, paramArrayList.size(), localHashMap, null);
        bool1 = bool2;
        if (!bool1) {
          break label317;
        }
        this.jdField_a_of_type_Astr.a(1, 1, this.jdField_a_of_type_Asue);
        return;
        localHashMap.put("errCount", "0");
        localHashMap.put("errCode", "0");
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("PicMultiMsgProcessor", 2, "onForwardMultiMsgPicsUpload failed");
    }
    paramArrayList = axrl.a(BaseApplication.getContext());
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramArrayList.a(null, "MultiMsgPicSendFail", bool1, 0L, 0L, null, null);
      bool1 = true;
      break;
    }
    label317:
    this.jdField_a_of_type_Astr.a(0, 1, this.jdField_a_of_type_Asue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asuh
 * JD-Core Version:    0.7.0.1
 */