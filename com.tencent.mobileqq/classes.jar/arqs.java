import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoReq;
import com.tencent.pb.hotpicmsg.HotPicMsg.GetImgInfoRsp;
import com.tencent.pb.hotpicmsg.HotPicMsg.ImgInfo;
import com.tencent.pb.hotpicmsg.HotPicMsg.ReqBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.RspBody;
import com.tencent.pb.hotpicmsg.HotPicMsg.ThirdPartyInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class arqs
  implements Manager
{
  volatile arqu jdField_a_of_type_Arqu;
  arqv jdField_a_of_type_Arqv;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  List<EmotionSearchItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  WeakReference<arqt> jdField_a_of_type_MqqUtilWeakReference;
  volatile arqu b;
  
  public arqs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static arqs a(QQAppInterface paramQQAppInterface)
  {
    return (arqs)paramQQAppInterface.getManager(367);
  }
  
  private void a(arqt paramarqt)
  {
    if (paramarqt == null) {
      return;
    }
    int i;
    if (paramarqt.jdField_a_of_type_Arqu == null)
    {
      i = 0;
      label14:
      if (paramarqt.jdField_a_of_type_Arqu != null) {
        break label63;
      }
    }
    label63:
    for (String str = "";; str = paramarqt.jdField_a_of_type_Arqu.jdField_a_of_type_JavaLangString)
    {
      a(paramarqt.jdField_a_of_type_Int, i, str);
      if (this.jdField_a_of_type_Arqv == null) {
        break;
      }
      this.jdField_a_of_type_Arqv.a(paramarqt);
      return;
      i = paramarqt.jdField_a_of_type_Arqu.jdField_a_of_type_Int;
      break label14;
    }
  }
  
  private void a(arqu paramarqu, List<EmotionSearchItem> arg2, int paramInt)
  {
    if (!paramarqu.a(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionSearchManager", 2, "handleResponsData requestTask not current error, requestTask = " + paramarqu.jdField_a_of_type_Int + "|" + paramarqu.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    arqt localarqt = new arqt(paramInt);
    paramarqu.jdField_a_of_type_Boolean = false;
    if ((paramInt == 0) && (???.size() > 0) && (this.jdField_a_of_type_JavaUtilList.size() == ((EmotionSearchItem)???.get(0)).picIndex))
    {
      this.jdField_a_of_type_JavaUtilList.addAll(???);
      paramarqu.jdField_a_of_type_Boolean = true;
    }
    localarqt.jdField_a_of_type_Arqu = paramarqu;
    localarqt.jdField_a_of_type_JavaUtilList = new ArrayList();
    localarqt.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Arqu = this.b;
      this.b = null;
      if ((paramarqu.jdField_a_of_type_Int == 0) && (paramInt == 0)) {
        this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(localarqt);
      }
      a(localarqt);
      return;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "requestData start");
    }
    Object localObject1 = this.b;
    if (localObject1 == null)
    {
      QLog.e("EmotionSearchManager", 2, "requestData currentSearchingTask is null");
      return;
    }
    int i = ((arqu)localObject1).b;
    int j = ((arqu)localObject1).b;
    int k = ((arqu)localObject1).c;
    Object localObject2 = new HotPicMsg.ReqBody();
    Object localObject3 = new HotPicMsg.GetImgInfoReq();
    ((HotPicMsg.ReqBody)localObject2).setHasFlag(true);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint64_src_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_src_term.set(3);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_start_pic_index.set(i);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_end_pic_index.set(j + 16 - 1);
    ((HotPicMsg.GetImgInfoReq)localObject3).uint32_build_ver.set(k);
    if (((arqu)localObject1).jdField_a_of_type_Int == 1)
    {
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_search_req.set(1);
      ((HotPicMsg.GetImgInfoReq)localObject3).str_search_word.set(((arqu)localObject1).jdField_a_of_type_JavaLangString);
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_client_ver.set(ByteStringMicro.copyFromUtf8("8.4.1"));
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_need_update.set(0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "sessionId:" + str);
      }
      ((HotPicMsg.GetImgInfoReq)localObject3).bytes_session_id.set(ByteStringMicro.copyFromUtf8(str));
      ((HotPicMsg.ReqBody)localObject2).msg_get_imginfo_req.set((MessageMicro)localObject3);
      localObject2 = ((HotPicMsg.ReqBody)localObject2).toByteArray();
      localObject3 = ByteBuffer.allocate(localObject2.length + 4);
      ((ByteBuffer)localObject3).putInt(localObject2.length + 4).put((byte[])localObject2);
      localObject3 = ((ByteBuffer)localObject3).array();
      localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), avci.class);
      ((NewIntent)localObject2).putExtra("key_body", (byte[])localObject3);
      ((NewIntent)localObject2).putExtra("key_cmd", "ImagePopular.GetInfo");
      ((NewIntent)localObject2).putExtra("isFrom_EmoSearch", true);
      ((NewIntent)localObject2).putExtra("EmoSearch_reqType", ((arqu)localObject1).jdField_a_of_type_Int);
      if (((arqu)localObject1).jdField_a_of_type_JavaLangString != null) {
        break label422;
      }
    }
    label422:
    for (localObject1 = "";; localObject1 = ((arqu)localObject1).jdField_a_of_type_JavaLangString)
    {
      ((NewIntent)localObject2).putExtra("EmoSearch_reqKeywords", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject2);
      return;
      ((HotPicMsg.GetImgInfoReq)localObject3).uint32_pic_tag.set(2);
      break;
    }
  }
  
  public void a()
  {
    if (this.b != null)
    {
      a(new arqt(-103));
      return;
    }
    if (this.jdField_a_of_type_Arqu == null)
    {
      a(new arqt(-102));
      return;
    }
    if (!this.jdField_a_of_type_Arqu.jdField_a_of_type_Boolean)
    {
      a(new arqt(-104));
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.b = this.jdField_a_of_type_Arqu;
      this.b.b = this.jdField_a_of_type_JavaUtilList.size();
      c();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "reportEmoSearchMonitor result: " + paramInt1);
    }
    HashMap localHashMap = new HashMap();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localHashMap.put("keywords", str);
    localHashMap.put("searchType", paramInt2 + "");
    localHashMap.put("result", paramInt1 + "");
    paramString = bctj.a(BaseApplication.getContext());
    if (paramInt1 == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.a(null, "emo_search_monitor", bool, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = 0;
    int i;
    arqu localarqu;
    try
    {
      i = paramIntent.getIntExtra("EmoSearch_reqType", 0);
      paramIntent = paramIntent.getStringExtra("EmoSearch_reqKeywords");
      localarqu = this.b;
      if (localarqu == null) {
        QLog.e("EmotionSearchManager", 2, "handleResonpse currentSearchingTask is null");
      }
      for (;;)
      {
        return;
        if (localarqu.a(i, paramIntent)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EmotionSearchManager", 2, "handleResonpse resp not current task current");
        }
      }
      localArrayList = new ArrayList();
    }
    finally {}
    ArrayList localArrayList;
    int k = -100;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      paramIntent = new byte[i];
      bgva.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      paramFromServiceMsg.putWupBuffer(paramIntent);
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramIntent = paramFromServiceMsg.getWupBuffer();
          paramFromServiceMsg = new HotPicMsg.RspBody();
          paramFromServiceMsg.mergeFrom(paramIntent);
          paramFromServiceMsg = (HotPicMsg.GetImgInfoRsp)paramFromServiceMsg.msg_get_imginfo_rsp.get();
          if ((paramFromServiceMsg != null) && ((paramFromServiceMsg.int32_result.get() == 0) || (paramFromServiceMsg.int32_result.get() == -5)))
          {
            k = paramFromServiceMsg.uint32_build_ver.get();
            paramIntent = new ArrayList();
            paramFromServiceMsg = paramFromServiceMsg.rpt_msg_img_info.get();
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              i = 0;
              if (i < paramFromServiceMsg.size())
              {
                Object localObject = (HotPicMsg.ImgInfo)paramFromServiceMsg.get(i);
                EmotionSearchItem localEmotionSearchItem = new EmotionSearchItem();
                localEmotionSearchItem.version = k;
                localEmotionSearchItem.picIndex = ((HotPicMsg.ImgInfo)localObject).uint32_pic_index.get();
                localEmotionSearchItem.fileType = ((HotPicMsg.ImgInfo)localObject).uint32_file_type.get();
                localEmotionSearchItem.sourceType = ((HotPicMsg.ImgInfo)localObject).uint32_source_type.get();
                localEmotionSearchItem.height = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_height.get();
                localEmotionSearchItem.width = ((HotPicMsg.ImgInfo)localObject).uint32_thumb_file_width.get();
                localEmotionSearchItem.url = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_down_url.get().toStringUtf8();
                localEmotionSearchItem.md5 = ((HotPicMsg.ImgInfo)localObject).bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                localEmotionSearchItem.fileSize = ((HotPicMsg.ImgInfo)localObject).uint64_thumb_file_size.get();
                localEmotionSearchItem.originalMD5 = ((HotPicMsg.ImgInfo)localObject).bytes_file_md5.get().toStringUtf8().toUpperCase();
                localEmotionSearchItem.originalUrl = ((HotPicMsg.ImgInfo)localObject).bytes_pic_down_url.get().toStringUtf8();
                localEmotionSearchItem.originalHeight = ((HotPicMsg.ImgInfo)localObject).uint32_file_height.get();
                localEmotionSearchItem.originalWidth = ((HotPicMsg.ImgInfo)localObject).uint32_file_width.get();
                localEmotionSearchItem.oringinalSize = ((HotPicMsg.ImgInfo)localObject).uint64_file_size.get();
                if (localEmotionSearchItem.sourceType == 3)
                {
                  localObject = ((HotPicMsg.ImgInfo)localObject).msg_third_party_info;
                  localEmotionSearchItem.iconUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_icon_url.get().toStringUtf8();
                  localEmotionSearchItem.name = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_name.get().toStringUtf8();
                  localEmotionSearchItem.jumpUrl = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_jump_url.get().toStringUtf8();
                  localEmotionSearchItem.appid = ((HotPicMsg.ThirdPartyInfo)localObject).bytes_appid.get().toStringUtf8();
                }
                paramIntent.add(localEmotionSearchItem);
                i += 1;
                continue;
              }
            }
            localArrayList.addAll(paramIntent);
            i = j;
          }
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          i = -100;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            i = j;
            QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC success,size:" + localArrayList.size());
          }
          i = 0;
          a(localarqu, localArrayList, i);
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          label670:
          break label670;
        }
      }
      j = paramFromServiceMsg.int32_result.get();
      i = j;
      if (QLog.isColorLevel())
      {
        i = j;
        QLog.d("EmotionSearchManager", 2, "handleResonpse,REQ_GET_PIC error,result:" + paramFromServiceMsg.int32_result.get());
      }
      i = j;
      continue;
      paramIntent.printStackTrace();
      continue;
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionSearchManager", 2, "handleResonpse,msg.getResultCode() error:" + paramFromServiceMsg.getResultCode());
        i = k;
      }
    }
  }
  
  public void a(arqu arg1)
  {
    if (??? == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      if ("pushEmotionSearchTask start task = " + ???.jdField_a_of_type_Int + "|" + ???.jdField_a_of_type_JavaLangString != null) {
        break label106;
      }
    }
    label106:
    for (??? = "";; ??? = ???.jdField_a_of_type_JavaLangString)
    {
      QLog.d("EmotionSearchManager", 2, (String)???);
      if (!???.a(this.b)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmotionSearchManager", 2, "pushEmotionSearchTask isSame task");
      }
      ??? = new arqt(-101);
      ((arqt)???).jdField_a_of_type_Arqu = ???;
      a((arqt)???);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.b = ???;
      this.jdField_a_of_type_JavaUtilList.clear();
      if (???.jdField_a_of_type_Int != 0) {
        break label228;
      }
      if (this.jdField_a_of_type_MqqUtilWeakReference == null) {
        break label223;
      }
      ??? = (arqt)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (??? == null) {
        break label223;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(((arqt)???).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Arqu = this.b;
      this.b = null;
      a(true);
      a((arqt)???);
      return;
      ??? = finally;
      throw ???;
    }
    label223:
    a(false);
    label228:
    c();
  }
  
  public void a(arqv paramarqv)
  {
    this.jdField_a_of_type_Arqv = paramarqv;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionSearchManager", 2, "reportEmoSearchCatchUseMonitor isUse: " + paramBoolean);
    }
    bctj.a(BaseApplication.getContext()).a(null, "emo_search_catch_use_monitor", paramBoolean, 0L, 0L, null, null);
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Arqu = null;
      this.b = null;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Arqv = null;
      return;
    }
  }
  
  public void onDestroy()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqs
 * JD-Core Version:    0.7.0.1
 */