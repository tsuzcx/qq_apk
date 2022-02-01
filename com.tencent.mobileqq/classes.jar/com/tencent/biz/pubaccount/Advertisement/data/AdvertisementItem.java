package com.tencent.biz.pubaccount.Advertisement.data;

import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.AdInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.MsgCommonData;
import tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.Video;

public class AdvertisementItem
{
  public int a;
  public long a;
  public VideoDownloadItem a;
  public String a;
  public ArrayList<VideoCoverItem> a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public long d;
  public String d;
  public String e = "";
  public String f = "";
  
  public AdvertisementItem()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  public AdvertisementItem(String paramString1, String paramString2, ArrayList<VideoCoverItem> paramArrayList, String paramString3)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem = new VideoDownloadItem(paramString3);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("AdvertisementItem json:");
      paramString1.append(paramString3);
      QLog.d("AdvertisementItem", 2, paramString1.toString());
    }
  }
  
  public static AdvertisementItem a(String paramString)
  {
    try
    {
      paramString = b(new JSONObject(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AdvertisementItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        AdvertisementItem localAdvertisementItem = new AdvertisementItem();
        localAdvertisementItem.jdField_a_of_type_JavaLangString = paramJSONObject.getString("uint64_from_uin");
        localAdvertisementItem.jdField_d_of_type_JavaLangString = paramJSONObject.optString("str_nick");
        localAdvertisementItem.e = paramJSONObject.optString("str_head_url");
        localAdvertisementItem.f = paramJSONObject.optString("str_brief");
        localAdvertisementItem.jdField_b_of_type_JavaLangString = paramJSONObject.getString("str_url");
        localAdvertisementItem.jdField_a_of_type_Long = (paramJSONObject.optLong("uint32_pushTime") * 1000L);
        localAdvertisementItem.jdField_b_of_type_Long = (paramJSONObject.optLong("uint32_invalidTime") * 1000L);
        localAdvertisementItem.jdField_b_of_type_Int = paramJSONObject.optInt("uint32_maxExposureTime");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_msg_video");
        localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        i = 0;
        if (i < localJSONArray.length())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(i, localJSONArray.getJSONObject(i));
          if (localVideoCoverItem != null) {
            localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.add(localVideoCoverItem);
          }
        }
        else
        {
          localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem = VideoDownloadItem.a(paramJSONObject.optString("msg_msgCommonData"), localAdvertisementItem.jdField_a_of_type_JavaLangString, localAdvertisementItem.jdField_d_of_type_JavaLangString);
          paramJSONObject = localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
          if (paramJSONObject == null) {
            return null;
          }
          return localAdvertisementItem;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static AdvertisementItem a(submsgtype0xf9.AdInfo paramAdInfo, MsgInfo paramMsgInfo)
  {
    AdvertisementItem localAdvertisementItem = new AdvertisementItem();
    try
    {
      if (paramAdInfo.uint64_from_uin.has()) {
        localAdvertisementItem.jdField_a_of_type_JavaLangString = String.valueOf(paramAdInfo.uint64_from_uin.get());
      }
      if (paramAdInfo.str_nick.has()) {
        localAdvertisementItem.jdField_d_of_type_JavaLangString = paramAdInfo.str_nick.get();
      }
      if (paramAdInfo.str_head_url.has()) {
        localAdvertisementItem.e = paramAdInfo.str_head_url.get();
      }
      if (paramAdInfo.str_brief.has()) {
        localAdvertisementItem.f = paramAdInfo.str_brief.get();
      }
      if (paramAdInfo.str_url.has()) {
        localAdvertisementItem.jdField_b_of_type_JavaLangString = paramAdInfo.str_url.get();
      }
      if (paramAdInfo.rpt_msg_video.has())
      {
        localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        int i = 0;
        Iterator localIterator = paramAdInfo.rpt_msg_video.get().iterator();
        while (localIterator.hasNext())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(i, (submsgtype0xf9.Video)localIterator.next());
          if (localVideoCoverItem != null)
          {
            localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.add(localVideoCoverItem);
            i += 1;
          }
        }
      }
      if (paramAdInfo.msg_msgCommonData.has()) {
        localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem = VideoDownloadItem.a(paramAdInfo.msg_msgCommonData, localAdvertisementItem.jdField_a_of_type_JavaLangString, localAdvertisementItem.jdField_d_of_type_JavaLangString);
      }
      if (paramAdInfo.uint32_pushTime.has()) {
        localAdvertisementItem.jdField_a_of_type_Long = (paramAdInfo.uint32_pushTime.get() * 1000L);
      }
      if (paramAdInfo.uint32_invalidTime.has()) {
        localAdvertisementItem.jdField_b_of_type_Long = (paramAdInfo.uint32_invalidTime.get() * 1000L);
      }
      localAdvertisementItem.jdField_b_of_type_Int = paramAdInfo.uint32_maxExposureTime.get();
      localAdvertisementItem.jdField_c_of_type_JavaLangString = String.valueOf(paramMsgInfo.lMsgUid);
      localAdvertisementItem.jdField_a_of_type_Short = paramMsgInfo.shMsgSeq;
      localAdvertisementItem.jdField_d_of_type_Long = paramMsgInfo.lMsgUid;
      if (QLog.isColorLevel())
      {
        paramAdInfo = new StringBuilder();
        paramAdInfo.append("PbData:");
        paramAdInfo.append(localAdvertisementItem.toString());
        QLog.w("AdvertisementItem", 2, paramAdInfo.toString());
      }
      ReportController.a(null, "dc00898", "", localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", b(), localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
      return localAdvertisementItem;
    }
    catch (Exception paramAdInfo)
    {
      paramAdInfo.printStackTrace();
    }
    return localAdvertisementItem;
  }
  
  private static AdvertisementItem b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        AdvertisementItem localAdvertisementItem = new AdvertisementItem();
        localAdvertisementItem.jdField_a_of_type_JavaLangString = paramJSONObject.getString("senderUin");
        localAdvertisementItem.jdField_b_of_type_JavaLangString = paramJSONObject.getString("pageUrl");
        localAdvertisementItem.jdField_c_of_type_JavaLangString = paramJSONObject.optString("adMsgId");
        localAdvertisementItem.jdField_a_of_type_Long = paramJSONObject.optLong("pushTime");
        localAdvertisementItem.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("hasReport");
        localAdvertisementItem.jdField_d_of_type_JavaLangString = paramJSONObject.optString("str_nick");
        localAdvertisementItem.e = paramJSONObject.optString("str_head_url");
        localAdvertisementItem.f = paramJSONObject.optString("str_brief");
        localAdvertisementItem.jdField_a_of_type_Int = paramJSONObject.optInt("video_preload_state");
        localAdvertisementItem.jdField_b_of_type_Long = paramJSONObject.optLong("invalidTime");
        localAdvertisementItem.jdField_c_of_type_Long = paramJSONObject.optLong("msgTime");
        localAdvertisementItem.jdField_a_of_type_Short = ((short)paramJSONObject.optInt("shMsgSeq"));
        localAdvertisementItem.jdField_d_of_type_Long = paramJSONObject.optLong("msgUid");
        localAdvertisementItem.jdField_b_of_type_Int = ((short)paramJSONObject.optInt("maxExposureTime"));
        localAdvertisementItem.jdField_c_of_type_Int = ((short)paramJSONObject.optInt("realExposureTime"));
        localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        Object localObject = paramJSONObject.getJSONArray("videoList");
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(((JSONArray)localObject).getJSONObject(i));
          if (localVideoCoverItem != null) {
            localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.add(localVideoCoverItem);
          }
        }
        else
        {
          boolean bool = QLog.isColorLevel();
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("convertFromJson msgCommonData");
            ((StringBuilder)localObject).append(paramJSONObject.optString("msgCommonData"));
            QLog.w("AdvertisementItem", 2, ((StringBuilder)localObject).toString());
          }
          localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem = new VideoDownloadItem(paramJSONObject.optString("msgCommonData"));
          return localAdvertisementItem;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static String b()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
  }
  
  public String a()
  {
    try
    {
      Object localObject1 = new JSONArray();
      Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JSONObject localJSONObject = ((VideoCoverItem)((Iterator)localObject2).next()).a();
        if (localJSONObject != null) {
          ((JSONArray)localObject1).put(localJSONObject);
        }
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("senderUin", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("pageUrl", this.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject2).put("adMsgId", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject2).put("pushTime", this.jdField_a_of_type_Long);
      ((JSONObject)localObject2).put("hasReport", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject2).put("videoList", localObject1);
      ((JSONObject)localObject2).put("str_nick", this.jdField_d_of_type_JavaLangString);
      ((JSONObject)localObject2).put("str_head_url", this.e);
      ((JSONObject)localObject2).put("str_brief", this.f);
      ((JSONObject)localObject2).put("video_preload_state", this.jdField_a_of_type_Int);
      ((JSONObject)localObject2).put("invalidTime", this.jdField_b_of_type_Long);
      ((JSONObject)localObject2).put("msgTime", this.jdField_c_of_type_Long);
      ((JSONObject)localObject2).put("shMsgSeq", this.jdField_a_of_type_Short);
      ((JSONObject)localObject2).put("msgUid", this.jdField_d_of_type_Long);
      ((JSONObject)localObject2).put("maxExposureTime", this.jdField_b_of_type_Int);
      ((JSONObject)localObject2).put("realExposureTime", this.jdField_c_of_type_Int);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convertToJson msgCommonData");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a().toString());
        QLog.w("AdvertisementItem", 2, ((StringBuilder)localObject1).toString());
      }
      ((JSONObject)localObject2).put("msgCommonData", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a().toString());
      localObject1 = ((JSONObject)localObject2).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public oidb_cmd0x886.AdInfo a(int paramInt)
  {
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localAdInfo.uint64_pull_time.set(this.jdField_a_of_type_Long);
    localAdInfo.enum_report_type.set(paramInt);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_JavaLangString);
    }
    catch (Exception localException1)
    {
      long l1;
      label62:
      label80:
      break label62;
    }
    l1 = 0L;
    try
    {
      long l3 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString);
      l2 = l3;
    }
    catch (Exception localException2)
    {
      break label80;
    }
    localAdInfo.uint64_pos_id.set(l1);
    localAdInfo.uint64_aid.set(l2);
    return localAdInfo;
  }
  
  public boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i == 0) {
      return true;
    }
    int j = this.jdField_c_of_type_Int;
    if (j >= i) {
      return false;
    }
    this.jdField_c_of_type_Int = (j + 1);
    return true;
  }
  
  public boolean b()
  {
    VideoDownloadItem localVideoDownloadItem = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem;
    return (localVideoDownloadItem != null) && (!TextUtils.isEmpty(localVideoDownloadItem.jdField_a_of_type_JavaLangString));
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Long < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (AdvertisementItem)paramObject;
      return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====mSenderUin ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====mContentPageUrl ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====invalidTime ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====shMsgSeq ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Short);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====maxExposureTime ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("====VideoCoverItem ");
      localStringBuilder2.append(localVideoCoverItem.toString());
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      continue;
      localStringBuilder1.append("====VideoCoverItem NULL ~ \n");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("====VideoDownloadItem ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.toString());
      ((StringBuilder)localObject).append("\n");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem
 * JD-Core Version:    0.7.0.1
 */