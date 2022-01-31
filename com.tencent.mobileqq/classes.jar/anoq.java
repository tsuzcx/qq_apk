import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.cs.doutu.Doutu.GetImgInfoReq;
import tencent.im.cs.doutu.Doutu.GetImgInfoRsp;
import tencent.im.cs.doutu.Doutu.ImgInfo;
import tencent.im.cs.doutu.Doutu.ReqBody;
import tencent.im.cs.doutu.Doutu.RspBody;
import tencent.im.cs.doutu.DoutuRecommend.GetImgInfoReq;
import tencent.im.cs.doutu.DoutuRecommend.GetImgInfoRsp;
import tencent.im.cs.doutu.DoutuRecommend.ImgInfo;
import tencent.im.cs.doutu.DoutuRecommend.ReqBody;
import tencent.im.cs.doutu.DoutuRecommend.RspBody;

public class anoq
  extends MSFServlet
{
  public List<DoutuData> a(List<DoutuRecommend.ImgInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DoutuRecommend.ImgInfo localImgInfo = (DoutuRecommend.ImgInfo)paramList.next();
      DoutuData localDoutuData = new DoutuData();
      localDoutuData.pic_md5 = localImgInfo.bytes_pic_md5.get().toStringUtf8();
      localDoutuData.pic_size = localImgInfo.uint64_pic_size.get();
      localDoutuData.pic_height = localImgInfo.uint32_pic_height.get();
      localDoutuData.pic_width = localImgInfo.uint32_pic_width.get();
      localDoutuData.pic_down_url = localImgInfo.bytes_pic_down_url.get().toStringUtf8();
      localDoutuData.thumb_md5 = localImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
      localDoutuData.thumb_size = localImgInfo.uint64_thumb_size.get();
      localDoutuData.thumb_height = localImgInfo.uint32_thumb_height.get();
      localDoutuData.thumb_width = localImgInfo.uint32_thumb_width.get();
      localDoutuData.thumb_down_url = localImgInfo.bytes_thumb_down_url.get().toStringUtf8();
      localDoutuData.suppliers_name = localImgInfo.bytes_source_name.get().toStringUtf8();
      localArrayList.add(localDoutuData);
    }
    return localArrayList;
  }
  
  public List<DoutuData> a(List<Doutu.ImgInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Doutu.ImgInfo localImgInfo = (Doutu.ImgInfo)paramList.next();
      DoutuData localDoutuData = new DoutuData();
      localDoutuData.pic_md5 = localImgInfo.bytes_pic_md5.get().toStringUtf8();
      localDoutuData.pic_size = localImgInfo.uint64_pic_size.get();
      localDoutuData.pic_height = localImgInfo.uint32_pic_height.get();
      localDoutuData.pic_width = localImgInfo.uint32_pic_width.get();
      localDoutuData.pic_down_url = localImgInfo.bytes_pic_down_url.get().toStringUtf8();
      localDoutuData.thumb_md5 = localImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
      localDoutuData.thumb_size = localImgInfo.uint64_thumb_size.get();
      localDoutuData.thumb_height = localImgInfo.uint32_thumb_height.get();
      localDoutuData.thumb_width = localImgInfo.uint32_thumb_width.get();
      localDoutuData.thumb_down_url = localImgInfo.bytes_thumb_down_url.get().toStringUtf8();
      localDoutuData.suppliers_name = localImgInfo.bytes_source_name.get().toStringUtf8();
      if (paramInt > 0) {
        localDoutuData.pic_type = paramInt;
      }
      localArrayList.add(localDoutuData);
    }
    return localArrayList;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("KEY_CMD", -1);
    long l = paramIntent.getLongExtra("key_sequence", 0L);
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServlet", 2, "onReceive, cmd = " + j + ", key:" + l);
    }
    boolean bool;
    if (paramFromServiceMsg == null)
    {
      bool = false;
      paramIntent = (anoi)getAppRuntime().getManager(214);
      if (!bool) {
        break label505;
      }
    }
    label616:
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        switch (j)
        {
        case 2: 
        case 3: 
        case 4: 
        default: 
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("DoutuServlet", 2, paramIntent, new Object[0]);
        return;
      }
      bool = paramFromServiceMsg.isSuccess();
      break;
      Object localObject = new Doutu.RspBody();
      ((Doutu.RspBody)localObject).mergeFrom(paramFromServiceMsg);
      paramFromServiceMsg = (Doutu.GetImgInfoRsp)((Doutu.RspBody)localObject).msg_get_imginfo_rsp.get();
      int i = paramFromServiceMsg.int32_result.get();
      if (i == 0)
      {
        localObject = paramFromServiceMsg.rpt_msg_img_info.get();
        if ((localObject == null) || (((List)localObject).size() == 0))
        {
          if (paramIntent != null) {
            paramIntent.a(false, null);
          }
          if (QLog.isColorLevel()) {
            QLog.i("DoutuServlet", 2, "onReceive: rpt_msg_img_info is null");
          }
        }
        else
        {
          paramIntent.a(true, a((List)localObject, paramFromServiceMsg.uint32_rsp_type.get()));
        }
      }
      else
      {
        if (paramIntent != null) {
          paramIntent.a(false, null);
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
        paramIntent = paramFromServiceMsg;
        if (paramFromServiceMsg == null) {
          paramIntent = "null";
        }
        if (QLog.isColorLevel())
        {
          QLog.i("DoutuServlet", 2, "onReceive : Failed ! result = " + i + ", errMsg = " + paramIntent);
          return;
          localObject = new DoutuRecommend.RspBody();
          ((DoutuRecommend.RspBody)localObject).mergeFrom(paramFromServiceMsg);
          paramFromServiceMsg = (DoutuRecommend.GetImgInfoRsp)((DoutuRecommend.RspBody)localObject).msg_get_imginfo_rsp.get();
          i = paramFromServiceMsg.int32_result.get();
          if (i == 0)
          {
            paramIntent.a(true, a(paramFromServiceMsg.rpt_msg_img_info.get()), l);
            return;
          }
          if (paramIntent != null) {
            paramIntent.a(false, null, l);
          }
          paramIntent = paramFromServiceMsg.bytes_fail_msg.get().toStringUtf8();
          if (QLog.isColorLevel())
          {
            QLog.i("DoutuServlet", 2, "onReceive recommend Failed result:" + i + ", errMsg:" + paramIntent);
            return;
            if (QLog.isColorLevel())
            {
              QLog.d("DoutuServlet", 2, "onReceive CMD_REPORT_NEW  success .");
              return;
              label505:
              if (paramFromServiceMsg == null)
              {
                i = -1;
                switch (j)
                {
                }
              }
              for (;;)
              {
                if (!QLog.isColorLevel()) {
                  break label616;
                }
                QLog.i("DoutuServlet", 2, "onReceive : Failed, errCode:" + i + ", cmd:" + j);
                return;
                i = paramFromServiceMsg.getResultCode();
                break;
                if (paramIntent != null)
                {
                  paramIntent.a(false, null);
                  continue;
                  if (paramIntent != null) {
                    paramIntent.a(l);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("KEY_CMD", -1);
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject3;
    switch (i)
    {
    default: 
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    for (;;)
    {
      if ((localObject2 != null) && (localObject1 != null))
      {
        paramPacket.setSSOCommand((String)localObject2);
        paramPacket.putSendData((byte[])localObject1);
      }
      while (!QLog.isColorLevel())
      {
        return;
        localObject1 = new Doutu.GetImgInfoReq();
        long l1 = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
        i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
        int j = paramIntent.getShortExtra("key_gender", (short)0);
        ((Doutu.GetImgInfoReq)localObject1).uint64_src_uin.set(l1);
        ((Doutu.GetImgInfoReq)localObject1).uint32_age.set(i);
        ((Doutu.GetImgInfoReq)localObject1).uint32_src_term.set(2);
        ((Doutu.GetImgInfoReq)localObject1).uin32_gender.set(j);
        if (QLog.isColorLevel()) {
          QLog.i("DoutuServlet", 2, "onSend, CMD_DOU_TU , src_uin = " + l1 + ", age = " + i + ", gender:" + j);
        }
        paramIntent = new Doutu.ReqBody();
        paramIntent.msg_get_imginfo_req.set((MessageMicro)localObject1);
        localObject2 = "ImageFight.GetInfo";
        localObject1 = bbma.a(paramIntent.toByteArray());
        break;
        localObject1 = new DoutuRecommend.GetImgInfoReq();
        l1 = paramIntent.getLongExtra("KEY_SRC_UIN", 0L);
        long l2 = paramIntent.getLongExtra("KEY_TO_UIN", 0L);
        localObject2 = paramIntent.getStringExtra("KEY_MD5");
        i = paramIntent.getByteExtra("KEY_AGE", (byte)0);
        j = paramIntent.getShortExtra("key_gender", (short)0);
        localObject3 = paramIntent.getStringExtra("key_url");
        int k = paramIntent.getIntExtra("KEY_SESSION_TYPE", 0);
        if (QLog.isColorLevel()) {
          QLog.i("DoutuServlet", 2, "onSend,CMD_RECOMMEND, srcUin1:" + l1 + ", md5Str:" + (String)localObject2 + ", age = " + i + ", gender:" + j);
        }
        ((DoutuRecommend.GetImgInfoReq)localObject1).uint64_src_uin.set(l1);
        ((DoutuRecommend.GetImgInfoReq)localObject1).uint64_to_uin.set(l2);
        ((DoutuRecommend.GetImgInfoReq)localObject1).uint32_src_term.set(2);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          ((DoutuRecommend.GetImgInfoReq)localObject1).bytes_md5.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        }
        if (k == 1) {
          ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(1);
        }
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).bytes_url.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
          }
          ((DoutuRecommend.GetImgInfoReq)localObject1).uin32_gender.set(j);
          ((DoutuRecommend.GetImgInfoReq)localObject1).uint32_age.set(i);
          paramIntent = new DoutuRecommend.ReqBody();
          paramIntent.msg_get_imginfo_req.set((MessageMicro)localObject1);
          localObject2 = "ImageFightRecSvc.GetImage";
          localObject1 = bbma.a(paramIntent.toByteArray());
          paramPacket.setTimeout(3000L);
          break;
          if (k == 2) {
            ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(2);
          } else {
            ((DoutuRecommend.GetImgInfoReq)localObject1).chat_type.set(255);
          }
        }
        localObject1 = bbma.a(paramIntent.getStringExtra("key_report_content").getBytes());
        if (!QLog.isColorLevel()) {
          break label676;
        }
        localObject2 = paramIntent.getStringExtra("key_report_content");
        localObject3 = new StringBuilder().append("onSend,CMD_REPORT_NEW, REPORT_CONTENT :");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "null";
        }
        QLog.d("DoutuServlet", 2, paramIntent);
        localObject2 = "MQInference.CommonReport";
        break;
      }
      QLog.e("DoutuServlet", 2, "exception request!");
      return;
      label676:
      localObject2 = "MQInference.CommonReport";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoq
 * JD-Core Version:    0.7.0.1
 */