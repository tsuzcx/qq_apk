import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RelatedEmoticonSearchHandler.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import tencent.im.oidb.cmd0xe9c.oidb_0xe9c.ImgInfo;
import tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RelatedFaceReq;
import tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RelatedFaceRsp;
import tencent.im.oidb.cmd0xe9c.oidb_0xe9c.ReqBody;
import tencent.im.oidb.cmd0xe9c.oidb_0xe9c.RspBody;

public class aogn
  extends anud
{
  public aogn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt)
  {
    notifyUI(1, false, Integer.valueOf(paramInt));
  }
  
  protected String a(int paramInt)
  {
    if (this.app == null) {
      return "";
    }
    return this.app.getApp().getResources().getString(paramInt);
  }
  
  protected String a(MarkFaceMessage paramMarkFaceMessage)
  {
    if (paramMarkFaceMessage == null) {
      return null;
    }
    return asfa.a(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
  }
  
  protected String a(MessageForPic paramMessageForPic)
  {
    if (this.app == null) {}
    String str1;
    String str2;
    String str3;
    String str4;
    do
    {
      return null;
      paramMessageForPic = paramMessageForPic.picExtraData.textSummary;
      str1 = a(2131691126);
      str2 = a(2131691127);
      str3 = a(2131691133);
      str4 = a(2131691130);
    } while ((TextUtils.isEmpty(paramMessageForPic)) || (str1.equals(paramMessageForPic)) || (str2.equals(paramMessageForPic)) || (str3.equals(paramMessageForPic)) || (str4.equals(paramMessageForPic)) || (!paramMessageForPic.startsWith("[")) || (!paramMessageForPic.endsWith("]")));
    return paramMessageForPic;
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new RelatedEmoticonSearchHandler.1(this, paramChatMessage, paramInt));
  }
  
  protected void a(List<oidb_0xe9c.ImgInfo> paramList, int paramInt)
  {
    asti localasti = new asti();
    localasti.jdField_a_of_type_Int = paramInt;
    localasti.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0xe9c.ImgInfo)paramList.next();
        astj localastj = new astj();
        ByteStringMicro localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_md5.get();
        if (localByteStringMicro != null) {
          localastj.jdField_a_of_type_JavaLangString = localByteStringMicro.toStringUtf8();
        }
        localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_down_url.get();
        if (localByteStringMicro != null) {
          localastj.jdField_b_of_type_JavaLangString = localByteStringMicro.toStringUtf8();
        }
        localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_other.get();
        if (localByteStringMicro != null) {
          localastj.d = localByteStringMicro.toStringUtf8();
        }
        localastj.jdField_b_of_type_Int = ((oidb_0xe9c.ImgInfo)localObject).uint32_img_height.get();
        localastj.jdField_a_of_type_Int = ((oidb_0xe9c.ImgInfo)localObject).uint32_img_width.get();
        localastj.jdField_a_of_type_Long = ((oidb_0xe9c.ImgInfo)localObject).uint64_img_size.get();
        localObject = ((oidb_0xe9c.ImgInfo)localObject).bytes_resource_id.get();
        if (localObject != null) {
          localastj.c = ((ByteStringMicro)localObject).toStringUtf8();
        }
        localasti.jdField_a_of_type_JavaUtilList.add(localastj);
      }
    }
    notifyUI(1, true, localasti);
  }
  
  protected void a(List<String> paramList, MarkFaceMessage paramMarkFaceMessage, String paramString1, String paramString2)
  {
    if ((paramList == null) || (paramMarkFaceMessage == null) || (paramString1 == null) || (paramString2 == null) || (this.app == null)) {}
    do
    {
      for (;;)
      {
        return;
        paramMarkFaceMessage = paramMarkFaceMessage.faceName;
        if (!TextUtils.isEmpty(paramMarkFaceMessage)) {
          paramList.add(paramMarkFaceMessage);
        }
        paramMarkFaceMessage = ((axfj)this.app.getManager(14)).a(paramString2, paramString1);
        if (paramMarkFaceMessage != null) {
          if (!TextUtils.isEmpty(paramMarkFaceMessage.keywords)) {
            try
            {
              paramString1 = new JSONArray(paramMarkFaceMessage.keywords);
              int j = paramString1.length();
              int i = 0;
              while (i < j)
              {
                paramString2 = (String)paramString1.get(i);
                if ((!TextUtils.isEmpty(paramString2)) && (!paramList.contains(paramString2))) {
                  paramList.add(paramString2);
                }
                i += 1;
              }
              if (TextUtils.isEmpty(paramMarkFaceMessage.name)) {}
            }
            catch (Exception paramString1)
            {
              QLog.e("RelatedEmoticonSearchHandler", 4, paramString1, new Object[0]);
            }
          }
        }
      }
    } while (paramList.contains(paramMarkFaceMessage.name));
    paramList.add(paramMarkFaceMessage.name);
  }
  
  public void b(ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject2 = null;
    String str1 = null;
    if (this.app == null) {
      return;
    }
    oidb_0xe9c.RelatedFaceReq localRelatedFaceReq = new oidb_0xe9c.RelatedFaceReq();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if ((paramChatMessage instanceof MessageForPic))
    {
      localObject1 = ((MessageForPic)paramChatMessage).md5;
      localObject2 = asos.b((MessageForPic)paramChatMessage);
      str1 = asos.a((MessageForPic)paramChatMessage);
      if (!TextUtils.isEmpty(str1))
      {
        localRelatedFaceReq.uint32_face_type.set(Integer.parseInt(str1));
        if (!TextUtils.isEmpty(((MessageForPic)paramChatMessage).uuid)) {
          localRelatedFaceReq.str_uuid.set(((MessageForPic)paramChatMessage).uuid);
        }
      }
      try
      {
        if (!TextUtils.isEmpty(paramChatMessage.senderuin)) {
          localRelatedFaceReq.uint64_from_uin.set(Long.parseLong(paramChatMessage.senderuin));
        }
        if (!TextUtils.isEmpty(paramChatMessage.frienduin)) {
          localRelatedFaceReq.uint64_group_code.set(Long.parseLong(paramChatMessage.frienduin));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l;
          QLog.e("RelatedEmoticonSearchHandler", 4, localException, new Object[0]);
        }
      }
      l = ((MessageForPic)paramChatMessage).groupFileID;
      localRelatedFaceReq.uint64_file_id.set(l);
    }
    for (;;)
    {
      localRelatedFaceReq.uint64_msg_time.set(paramChatMessage.time);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localRelatedFaceReq.str_img_md5.set((String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localRelatedFaceReq.str_url.set((String)localObject2);
      }
      if (((paramChatMessage instanceof MessageForPic)) && (((MessageForPic)paramChatMessage).picExtraData != null))
      {
        paramChatMessage = a((MessageForPic)paramChatMessage);
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localArrayList.add(paramChatMessage);
        }
      }
      if (!localArrayList.isEmpty()) {
        localRelatedFaceReq.str_labels.set(localArrayList);
      }
      paramChatMessage = new oidb_0xe9c.ReqBody();
      l = System.currentTimeMillis();
      paramChatMessage.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(l)));
      paramChatMessage.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      paramChatMessage.uint32_src_term.set(3);
      paramChatMessage.uint32_aio_type.set(asos.b(paramInt));
      paramChatMessage.str_client_ver.set("8.4.5");
      paramChatMessage.relatedFaceReqBody.set(localRelatedFaceReq);
      localObject1 = (anyw)this.app.getManager(51);
      if (localObject1 != null)
      {
        localObject1 = ((anyw)localObject1).b(this.app.getCurrentAccountUin());
        if (localObject1 != null) {
          paramChatMessage.uint32_age.set(((Card)localObject1).age);
        }
      }
      sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, paramChatMessage.toByteArray()));
      return;
      localRelatedFaceReq.uint32_face_type.set(0);
      break;
      Object localObject3;
      if ((paramChatMessage instanceof MessageForMarketFace))
      {
        MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage).mMarkFaceMessage;
        if (localMarkFaceMessage != null)
        {
          localObject3 = a(localMarkFaceMessage);
          String str2 = String.valueOf(localMarkFaceMessage.dwTabID);
          if (localObject3 != null)
          {
            localRelatedFaceReq.uint32_face_type.set(1);
            localObject2 = bhml.a(MD5.getFileMd5(asos.s.replace("[epId]", str2).replace("[eId]", (CharSequence)localObject3)));
            String str3 = asos.h.replace("[eIdSub]", ((String)localObject3).substring(0, 2)).replace("[eId]", (CharSequence)localObject3);
            if (localMarkFaceMessage.imageWidth != 0)
            {
              localObject1 = localMarkFaceMessage.imageWidth + "";
              label612:
              str3 = str3.replace("[width]", (CharSequence)localObject1);
              if (localMarkFaceMessage.imageHeight == 0) {
                break label756;
              }
              localObject1 = localMarkFaceMessage.imageHeight + "";
              label657:
              localObject1 = str3.replace("[height]", (CharSequence)localObject1);
              localRelatedFaceReq.bytes_emoji_id.set(ByteStringMicro.copyFromUtf8((String)localObject3));
              localRelatedFaceReq.bytes_package_id.set(ByteStringMicro.copyFromUtf8(str2));
            }
          }
          for (;;)
          {
            localRelatedFaceReq.uint32_width.set(localMarkFaceMessage.imageWidth);
            localRelatedFaceReq.uint32_height.set(localMarkFaceMessage.imageHeight);
            a(localArrayList, localMarkFaceMessage, (String)localObject3, str2);
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break;
            localObject1 = "200";
            break label612;
            label756:
            localObject1 = "200";
            break label657;
            localObject1 = null;
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return aogm.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ("OidbSvc.0xe9c_1".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = new oidb_0xe9c.RspBody();
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i != 0) {
        break label80;
      }
      i = paramToServiceMsg.int32_ret_code.get();
      if (i == 0) {
        a(paramToServiceMsg.relatedFaceRspBody.rpt_img_info.get(), paramToServiceMsg.relatedFaceRspBody.img_num.get());
      }
    }
    else
    {
      return;
    }
    a(i);
    return;
    label80:
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogn
 * JD-Core Version:    0.7.0.1
 */