package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.HexUtil;
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

public class RelatedEmoticonSearchHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.app.RelatedEmoticonSearchHandler";
  private BaseQQAppInterface b;
  
  public RelatedEmoticonSearchHandler(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface);
    this.b = paramBaseQQAppInterface;
  }
  
  private void b(int paramInt)
  {
    notifyUI(1, false, Integer.valueOf(paramInt));
  }
  
  protected String a(int paramInt)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.b;
    if (localBaseQQAppInterface == null) {
      return "";
    }
    return localBaseQQAppInterface.getApp().getResources().getString(paramInt);
  }
  
  protected String a(MarkFaceMessage paramMarkFaceMessage)
  {
    if (paramMarkFaceMessage == null) {
      return null;
    }
    return EmosmUtils.a(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
  }
  
  protected String a(MessageForPic paramMessageForPic)
  {
    if (this.b == null) {
      return null;
    }
    paramMessageForPic = paramMessageForPic.picExtraData.textSummary;
    String str1 = a(2131888229);
    String str2 = a(2131888230);
    String str3 = a(2131888236);
    String str4 = a(2131888233);
    if ((!TextUtils.isEmpty(paramMessageForPic)) && (!str1.equals(paramMessageForPic)) && (!str2.equals(paramMessageForPic)) && (!str3.equals(paramMessageForPic)) && (!str4.equals(paramMessageForPic)) && (paramMessageForPic.startsWith("[")) && (paramMessageForPic.endsWith("]"))) {
      return paramMessageForPic;
    }
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new RelatedEmoticonSearchHandler.1(this, paramChatMessage, paramInt));
  }
  
  protected void a(List<oidb_0xe9c.ImgInfo> paramList, int paramInt)
  {
    RelatedEmoticonManager.RelatedEmotionSearchResult localRelatedEmotionSearchResult = new RelatedEmoticonManager.RelatedEmotionSearchResult();
    localRelatedEmotionSearchResult.defaultCount = paramInt;
    localRelatedEmotionSearchResult.resultItems = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (oidb_0xe9c.ImgInfo)paramList.next();
        RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem localSearchResultItem = new RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem();
        ByteStringMicro localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_md5.get();
        if (localByteStringMicro != null) {
          localSearchResultItem.md5 = localByteStringMicro.toStringUtf8();
        }
        localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_down_url.get();
        if (localByteStringMicro != null) {
          localSearchResultItem.url = localByteStringMicro.toStringUtf8();
        }
        localByteStringMicro = ((oidb_0xe9c.ImgInfo)localObject).bytes_img_other.get();
        if (localByteStringMicro != null) {
          localSearchResultItem.imgOther = localByteStringMicro.toStringUtf8();
        }
        localSearchResultItem.height = ((oidb_0xe9c.ImgInfo)localObject).uint32_img_height.get();
        localSearchResultItem.width = ((oidb_0xe9c.ImgInfo)localObject).uint32_img_width.get();
        localSearchResultItem.imgSize = ((oidb_0xe9c.ImgInfo)localObject).uint64_img_size.get();
        localObject = ((oidb_0xe9c.ImgInfo)localObject).bytes_resource_id.get();
        if (localObject != null) {
          localSearchResultItem.resourceId = ((ByteStringMicro)localObject).toStringUtf8();
        }
        localRelatedEmotionSearchResult.resultItems.add(localSearchResultItem);
      }
    }
    notifyUI(1, true, localRelatedEmotionSearchResult);
  }
  
  protected void a(List<String> paramList, MarkFaceMessage paramMarkFaceMessage, String paramString1, String paramString2)
  {
    if ((paramList != null) && (paramMarkFaceMessage != null) && (paramString1 != null) && (paramString2 != null))
    {
      if (this.b == null) {
        return;
      }
      paramMarkFaceMessage = paramMarkFaceMessage.faceName;
      if (!TextUtils.isEmpty(paramMarkFaceMessage)) {
        paramList.add(paramMarkFaceMessage);
      }
      paramMarkFaceMessage = ((IEmoticonManagerService)this.b.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(paramString2, paramString1);
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
            if (TextUtils.isEmpty(paramMarkFaceMessage.name)) {
              return;
            }
          }
          catch (Exception paramString1)
          {
            QLog.e("RelatedEmoticonSearchHandler", 4, paramString1, new Object[0]);
          }
        } else if (!paramList.contains(paramMarkFaceMessage.name)) {
          paramList.add(paramMarkFaceMessage.name);
        }
      }
    }
  }
  
  public void b(ChatMessage paramChatMessage, int paramInt)
  {
    if (this.b == null) {
      return;
    }
    oidb_0xe9c.RelatedFaceReq localRelatedFaceReq = new oidb_0xe9c.RelatedFaceReq();
    ArrayList localArrayList = new ArrayList();
    boolean bool = paramChatMessage instanceof MessageForPic;
    Object localObject3 = null;
    Object localObject2 = null;
    if (bool)
    {
      localObject3 = (MessageForPic)paramChatMessage;
      localObject2 = ((MessageForPic)localObject3).md5;
      localObject1 = EmoticonPanelUtils.b((MessageForPic)localObject3);
      String str1 = EmoticonPanelUtils.a((MessageForPic)localObject3);
      if (!TextUtils.isEmpty(str1)) {
        localRelatedFaceReq.uint32_face_type.set(Integer.parseInt(str1));
      } else {
        localRelatedFaceReq.uint32_face_type.set(0);
      }
      if (!TextUtils.isEmpty(((MessageForPic)localObject3).uuid)) {
        localRelatedFaceReq.str_uuid.set(((MessageForPic)localObject3).uuid);
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
        QLog.e("RelatedEmoticonSearchHandler", 4, localException, new Object[0]);
      }
      l = ((MessageForPic)localObject3).groupFileID;
      localRelatedFaceReq.uint64_file_id.set(l);
    }
    else
    {
      if ((paramChatMessage instanceof MessageForMarketFace))
      {
        MarkFaceMessage localMarkFaceMessage = ((MessageForMarketFace)paramChatMessage).mMarkFaceMessage;
        if (localMarkFaceMessage != null)
        {
          String str2 = a(localMarkFaceMessage);
          String str3 = String.valueOf(localMarkFaceMessage.dwTabID);
          if (str2 != null)
          {
            localRelatedFaceReq.uint32_face_type.set(1);
            localObject2 = HexUtil.bytes2HexStr(MD5.getFileMd5(EmotionPanelConstans.emoticonEncryptPath.replace("[epId]", str3).replace("[eId]", str2)));
            String str4 = EmotionPanelConstans.emoticonEncryptExtensionUrl.replace("[eIdSub]", str2.substring(0, 2)).replace("[eId]", str2);
            int i = localMarkFaceMessage.imageWidth;
            localObject3 = "200";
            if (i != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localMarkFaceMessage.imageWidth);
              ((StringBuilder)localObject1).append("");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            else
            {
              localObject1 = "200";
            }
            str4 = str4.replace("[width]", (CharSequence)localObject1);
            localObject1 = localObject3;
            if (localMarkFaceMessage.imageHeight != 0)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(localMarkFaceMessage.imageHeight);
              ((StringBuilder)localObject1).append("");
              localObject1 = ((StringBuilder)localObject1).toString();
            }
            localObject1 = str4.replace("[height]", (CharSequence)localObject1);
            localRelatedFaceReq.bytes_emoji_id.set(ByteStringMicro.copyFromUtf8(str2));
            localRelatedFaceReq.bytes_package_id.set(ByteStringMicro.copyFromUtf8(str3));
          }
          else
          {
            localObject1 = null;
          }
          localRelatedFaceReq.uint32_width.set(localMarkFaceMessage.imageWidth);
          localRelatedFaceReq.uint32_height.set(localMarkFaceMessage.imageHeight);
          a(localArrayList, localMarkFaceMessage, str2, str3);
          break label530;
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
    }
    label530:
    localRelatedFaceReq.uint64_msg_time.set(paramChatMessage.time);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localRelatedFaceReq.str_img_md5.set((String)localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      localRelatedFaceReq.str_url.set((String)localObject1);
    }
    if (bool)
    {
      paramChatMessage = (MessageForPic)paramChatMessage;
      if (paramChatMessage.picExtraData != null)
      {
        paramChatMessage = a(paramChatMessage);
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localArrayList.add(paramChatMessage);
        }
      }
    }
    if (!localArrayList.isEmpty()) {
      localRelatedFaceReq.str_labels.set(localArrayList);
    }
    paramChatMessage = new oidb_0xe9c.ReqBody();
    long l = System.currentTimeMillis();
    paramChatMessage.bytes_session_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(l)));
    paramChatMessage.uint64_src_uin.set(Long.parseLong(this.b.getCurrentAccountUin()));
    paramChatMessage.uint32_src_term.set(3);
    paramChatMessage.uint32_aio_type.set(EmoticonPanelUtils.f(paramInt));
    paramChatMessage.str_client_ver.set("8.8.17");
    paramChatMessage.relatedFaceReqBody.set(localRelatedFaceReq);
    Object localObject1 = (IEmosmService)QRoute.api(IEmosmService.class);
    localObject2 = this.b;
    localObject1 = ((IEmosmService)localObject1).findFriendCardByUin((BaseQQAppInterface)localObject2, ((BaseQQAppInterface)localObject2).getCurrentAccountUin());
    if (localObject1 != null) {
      paramChatMessage.uint32_age.set(((Card)localObject1).age);
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xe9c_1", 3740, 1, paramChatMessage.toByteArray()));
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return RelatedEmoSearchObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvc.0xe9c_1".equals(paramToServiceMsg.getServiceCmd()))
    {
      paramToServiceMsg = new oidb_0xe9c.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.int32_ret_code.get();
        if (i == 0)
        {
          a(paramToServiceMsg.relatedFaceRspBody.rpt_img_info.get(), paramToServiceMsg.relatedFaceRspBody.img_num.get());
          return;
        }
        b(i);
        return;
      }
      b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RelatedEmoticonSearchHandler
 * JD-Core Version:    0.7.0.1
 */