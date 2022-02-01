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
  public String a;
  public String b;
  public ArrayList<VideoCoverItem> c;
  public String d = "";
  public long e;
  public boolean f;
  public VideoDownloadItem g;
  public String h = "";
  public String i = "";
  public String j = "";
  public int k = 0;
  public long l;
  public long m;
  public short n;
  public long o;
  public int p = 0;
  public int q = 0;
  
  public AdvertisementItem() {}
  
  public AdvertisementItem(String paramString1, String paramString2, ArrayList<VideoCoverItem> paramArrayList, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.g = new VideoDownloadItem(paramString3);
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
      int i1;
      try
      {
        AdvertisementItem localAdvertisementItem = new AdvertisementItem();
        localAdvertisementItem.a = paramJSONObject.getString("uint64_from_uin");
        localAdvertisementItem.h = paramJSONObject.optString("str_nick");
        localAdvertisementItem.i = paramJSONObject.optString("str_head_url");
        localAdvertisementItem.j = paramJSONObject.optString("str_brief");
        localAdvertisementItem.b = paramJSONObject.getString("str_url");
        localAdvertisementItem.e = (paramJSONObject.optLong("uint32_pushTime") * 1000L);
        localAdvertisementItem.l = (paramJSONObject.optLong("uint32_invalidTime") * 1000L);
        localAdvertisementItem.p = paramJSONObject.optInt("uint32_maxExposureTime");
        JSONArray localJSONArray = paramJSONObject.getJSONArray("rpt_msg_video");
        localAdvertisementItem.c = new ArrayList();
        i1 = 0;
        if (i1 < localJSONArray.length())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(i1, localJSONArray.getJSONObject(i1));
          if (localVideoCoverItem != null) {
            localAdvertisementItem.c.add(localVideoCoverItem);
          }
        }
        else
        {
          localAdvertisementItem.g = VideoDownloadItem.a(paramJSONObject.optString("msg_msgCommonData"), localAdvertisementItem.a, localAdvertisementItem.h);
          paramJSONObject = localAdvertisementItem.g;
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
      i1 += 1;
    }
  }
  
  public static AdvertisementItem a(submsgtype0xf9.AdInfo paramAdInfo, MsgInfo paramMsgInfo)
  {
    AdvertisementItem localAdvertisementItem = new AdvertisementItem();
    try
    {
      if (paramAdInfo.uint64_from_uin.has()) {
        localAdvertisementItem.a = String.valueOf(paramAdInfo.uint64_from_uin.get());
      }
      if (paramAdInfo.str_nick.has()) {
        localAdvertisementItem.h = paramAdInfo.str_nick.get();
      }
      if (paramAdInfo.str_head_url.has()) {
        localAdvertisementItem.i = paramAdInfo.str_head_url.get();
      }
      if (paramAdInfo.str_brief.has()) {
        localAdvertisementItem.j = paramAdInfo.str_brief.get();
      }
      if (paramAdInfo.str_url.has()) {
        localAdvertisementItem.b = paramAdInfo.str_url.get();
      }
      if (paramAdInfo.rpt_msg_video.has())
      {
        localAdvertisementItem.c = new ArrayList();
        int i1 = 0;
        Iterator localIterator = paramAdInfo.rpt_msg_video.get().iterator();
        while (localIterator.hasNext())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(i1, (submsgtype0xf9.Video)localIterator.next());
          if (localVideoCoverItem != null)
          {
            localAdvertisementItem.c.add(localVideoCoverItem);
            i1 += 1;
          }
        }
      }
      if (paramAdInfo.msg_msgCommonData.has()) {
        localAdvertisementItem.g = VideoDownloadItem.a(paramAdInfo.msg_msgCommonData, localAdvertisementItem.a, localAdvertisementItem.h);
      }
      if (paramAdInfo.uint32_pushTime.has()) {
        localAdvertisementItem.e = (paramAdInfo.uint32_pushTime.get() * 1000L);
      }
      if (paramAdInfo.uint32_invalidTime.has()) {
        localAdvertisementItem.l = (paramAdInfo.uint32_invalidTime.get() * 1000L);
      }
      localAdvertisementItem.p = paramAdInfo.uint32_maxExposureTime.get();
      localAdvertisementItem.d = String.valueOf(paramMsgInfo.lMsgUid);
      localAdvertisementItem.n = paramMsgInfo.shMsgSeq;
      localAdvertisementItem.o = paramMsgInfo.lMsgUid;
      if (QLog.isColorLevel())
      {
        paramAdInfo = new StringBuilder();
        paramAdInfo.append("PbData:");
        paramAdInfo.append(localAdvertisementItem.toString());
        QLog.w("AdvertisementItem", 2, paramAdInfo.toString());
      }
      ReportController.a(null, "dc00898", "", localAdvertisementItem.g.a, "0X8008F5C", "0X8008F5C", 0, 0, localAdvertisementItem.g.c, "", d(), localAdvertisementItem.g.b);
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
      int i1;
      try
      {
        AdvertisementItem localAdvertisementItem = new AdvertisementItem();
        localAdvertisementItem.a = paramJSONObject.getString("senderUin");
        localAdvertisementItem.b = paramJSONObject.getString("pageUrl");
        localAdvertisementItem.d = paramJSONObject.optString("adMsgId");
        localAdvertisementItem.e = paramJSONObject.optLong("pushTime");
        localAdvertisementItem.f = paramJSONObject.optBoolean("hasReport");
        localAdvertisementItem.h = paramJSONObject.optString("str_nick");
        localAdvertisementItem.i = paramJSONObject.optString("str_head_url");
        localAdvertisementItem.j = paramJSONObject.optString("str_brief");
        localAdvertisementItem.k = paramJSONObject.optInt("video_preload_state");
        localAdvertisementItem.l = paramJSONObject.optLong("invalidTime");
        localAdvertisementItem.m = paramJSONObject.optLong("msgTime");
        localAdvertisementItem.n = ((short)paramJSONObject.optInt("shMsgSeq"));
        localAdvertisementItem.o = paramJSONObject.optLong("msgUid");
        localAdvertisementItem.p = ((short)paramJSONObject.optInt("maxExposureTime"));
        localAdvertisementItem.q = ((short)paramJSONObject.optInt("realExposureTime"));
        localAdvertisementItem.c = new ArrayList();
        Object localObject = paramJSONObject.getJSONArray("videoList");
        i1 = 0;
        if (i1 < ((JSONArray)localObject).length())
        {
          VideoCoverItem localVideoCoverItem = VideoCoverItem.a(((JSONArray)localObject).getJSONObject(i1));
          if (localVideoCoverItem != null) {
            localAdvertisementItem.c.add(localVideoCoverItem);
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
          localAdvertisementItem.g = new VideoDownloadItem(paramJSONObject.optString("msgCommonData"));
          return localAdvertisementItem;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return null;
      }
      i1 += 1;
    }
  }
  
  public static String d()
  {
    return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis()));
  }
  
  public oidb_cmd0x886.AdInfo a(int paramInt)
  {
    oidb_cmd0x886.AdInfo localAdInfo = new oidb_cmd0x886.AdInfo();
    localAdInfo.bytes_trace_id.set(ByteStringMicro.copyFromUtf8(this.d));
    localAdInfo.uint64_pull_time.set(this.e);
    localAdInfo.enum_report_type.set(paramInt);
    long l2 = 0L;
    try
    {
      l1 = Long.parseLong(this.g.d);
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
      long l3 = Long.parseLong(this.g.c);
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
    int i1 = this.p;
    if (i1 == 0) {
      return true;
    }
    int i2 = this.q;
    if (i2 >= i1) {
      return false;
    }
    this.q = (i2 + 1);
    return true;
  }
  
  public boolean b()
  {
    VideoDownloadItem localVideoDownloadItem = this.g;
    return (localVideoDownloadItem != null) && (!TextUtils.isEmpty(localVideoDownloadItem.a));
  }
  
  public String c()
  {
    try
    {
      Object localObject1 = new JSONArray();
      Object localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        JSONObject localJSONObject = ((VideoCoverItem)((Iterator)localObject2).next()).a();
        if (localJSONObject != null) {
          ((JSONArray)localObject1).put(localJSONObject);
        }
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("senderUin", this.a);
      ((JSONObject)localObject2).put("pageUrl", this.b);
      ((JSONObject)localObject2).put("adMsgId", this.d);
      ((JSONObject)localObject2).put("pushTime", this.e);
      ((JSONObject)localObject2).put("hasReport", this.f);
      ((JSONObject)localObject2).put("videoList", localObject1);
      ((JSONObject)localObject2).put("str_nick", this.h);
      ((JSONObject)localObject2).put("str_head_url", this.i);
      ((JSONObject)localObject2).put("str_brief", this.j);
      ((JSONObject)localObject2).put("video_preload_state", this.k);
      ((JSONObject)localObject2).put("invalidTime", this.l);
      ((JSONObject)localObject2).put("msgTime", this.m);
      ((JSONObject)localObject2).put("shMsgSeq", this.n);
      ((JSONObject)localObject2).put("msgUid", this.o);
      ((JSONObject)localObject2).put("maxExposureTime", this.p);
      ((JSONObject)localObject2).put("realExposureTime", this.q);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("convertToJson msgCommonData");
        ((StringBuilder)localObject1).append(this.g.a().toString());
        QLog.w("AdvertisementItem", 2, ((StringBuilder)localObject1).toString());
      }
      ((JSONObject)localObject2).put("msgCommonData", this.g.a().toString());
      localObject1 = ((JSONObject)localObject2).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public boolean e()
  {
    return this.l < NetConnInfoCenter.getServerTimeMillis();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (AdvertisementItem)paramObject;
      return this.a.equals(paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====mSenderUin ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====mContentPageUrl ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====invalidTime ");
    ((StringBuilder)localObject).append(this.l);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====shMsgSeq ");
    ((StringBuilder)localObject).append(this.n);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("====maxExposureTime ");
    ((StringBuilder)localObject).append(this.p);
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = this.c;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      localObject = this.c.iterator();
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
    if (this.g != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("====VideoDownloadItem ");
      ((StringBuilder)localObject).append(this.g.toString());
      ((StringBuilder)localObject).append("\n");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem
 * JD-Core Version:    0.7.0.1
 */