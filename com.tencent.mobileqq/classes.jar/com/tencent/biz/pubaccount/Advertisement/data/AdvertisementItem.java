package com.tencent.biz.pubaccount.Advertisement.data;

import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
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
import java.util.ArrayList;
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
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementRecentUserManager", 2, "AdvertisementItem json:" + paramString3);
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
            break;
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
    int i = 0;
    AdvertisementItem localAdvertisementItem = new AdvertisementItem();
    label408:
    for (;;)
    {
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
          Iterator localIterator = paramAdInfo.rpt_msg_video.get().iterator();
          if (localIterator.hasNext())
          {
            VideoCoverItem localVideoCoverItem = VideoCoverItem.a(i, (submsgtype0xf9.Video)localIterator.next());
            if (localVideoCoverItem == null) {
              break label408;
            }
            localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.add(localVideoCoverItem);
            i += 1;
            break label408;
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
        if (QLog.isColorLevel()) {
          QLog.w("ImaxAdvertisement", 2, "PbData:" + localAdvertisementItem.toString());
        }
        ReportController.a(null, "dc00898", "", localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString, "", PublicAccountAdUtil.a(), localAdvertisementItem.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_b_of_type_JavaLangString);
        return localAdvertisementItem;
      }
      catch (Exception paramAdInfo)
      {
        paramAdInfo.printStackTrace();
        return localAdvertisementItem;
      }
    }
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
        JSONArray localJSONArray = paramJSONObject.getJSONArray("videoList");
        i = 0;
        if (i < localJSONArray.length())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(localJSONArray.getJSONObject(i));
          if (localVideoCoverItem != null) {
            localAdvertisementItem.jdField_a_of_type_JavaUtilArrayList.add(localVideoCoverItem);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.w("AdvertisementRecentUserManager", 2, "convertFromJson msgCommonData" + paramJSONObject.optString("msgCommonData"));
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
  
  public String a()
  {
    Object localObject;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        JSONObject localJSONObject = ((VideoCoverItem)((Iterator)localObject).next()).a();
        if (localJSONObject != null) {
          localJSONArray.put(localJSONObject);
        }
      }
      localObject = new JSONObject();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    ((JSONObject)localObject).put("senderUin", this.jdField_a_of_type_JavaLangString);
    ((JSONObject)localObject).put("pageUrl", this.jdField_b_of_type_JavaLangString);
    ((JSONObject)localObject).put("adMsgId", this.jdField_c_of_type_JavaLangString);
    ((JSONObject)localObject).put("pushTime", this.jdField_a_of_type_Long);
    ((JSONObject)localObject).put("hasReport", this.jdField_a_of_type_Boolean);
    ((JSONObject)localObject).put("videoList", localException);
    ((JSONObject)localObject).put("str_nick", this.jdField_d_of_type_JavaLangString);
    ((JSONObject)localObject).put("str_head_url", this.e);
    ((JSONObject)localObject).put("str_brief", this.f);
    ((JSONObject)localObject).put("video_preload_state", this.jdField_a_of_type_Int);
    ((JSONObject)localObject).put("invalidTime", this.jdField_b_of_type_Long);
    ((JSONObject)localObject).put("msgTime", this.jdField_c_of_type_Long);
    ((JSONObject)localObject).put("shMsgSeq", this.jdField_a_of_type_Short);
    ((JSONObject)localObject).put("msgUid", this.jdField_d_of_type_Long);
    ((JSONObject)localObject).put("maxExposureTime", this.jdField_b_of_type_Int);
    ((JSONObject)localObject).put("realExposureTime", this.jdField_c_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.w("AdvertisementRecentUserManager", 2, "convertToJson msgCommonData" + this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a().toString());
    }
    ((JSONObject)localObject).put("msgCommonData", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.a().toString());
    String str = ((JSONObject)localObject).toString();
    return str;
  }
  
  public oidb_cmd0x886.AdInfo a(int paramInt)
  {
    long l2 = 0L;
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.jdField_c_of_type_JavaLangString));
    localAdInfo.uint64_pull_time.set(this.jdField_a_of_type_Long);
    localAdInfo.enum_report_type.set(paramInt);
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_d_of_type_JavaLangString);
      try
      {
        long l3 = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_c_of_type_JavaLangString);
        l2 = l3;
      }
      catch (Exception localException2)
      {
        label75:
        break label75;
      }
      localAdInfo.uint64_pos_id.set(l1);
      localAdInfo.uint64_aid.set(l2);
      return localAdInfo;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Int == 0) {
      return true;
    }
    if (this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) {
      return false;
    }
    this.jdField_c_of_type_Int += 1;
    return true;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.jdField_a_of_type_JavaLangString));
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
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (AdvertisementItem)paramObject;
    return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("====mSenderUin " + this.jdField_a_of_type_JavaLangString + "\n").append("====mContentPageUrl " + this.jdField_b_of_type_JavaLangString + "\n").append("====invalidTime " + this.jdField_b_of_type_Long).append("====shMsgSeq " + this.jdField_a_of_type_Short).append("====maxExposureTime " + this.jdField_b_of_type_Int);
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    while (localIterator.hasNext())
    {
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)localIterator.next();
      localStringBuilder.append("====VideoCoverItem " + localVideoCoverItem.toString() + "\n");
      continue;
      localStringBuilder.append("====VideoCoverItem NULL ~ \n");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem != null) {
      localStringBuilder.append("====VideoDownloadItem " + this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataVideoDownloadItem.toString() + "\n");
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem
 * JD-Core Version:    0.7.0.1
 */