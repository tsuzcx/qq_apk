package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class e
{
  private static HashMap<String, e.a> C = new HashMap();
  private static String a = "TXCDataReport";
  private int A = 0;
  private String B;
  private String D = "";
  private String E = "";
  private HashMap b = new HashMap(100);
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private Context h;
  private String i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private boolean p;
  private long q;
  private int r;
  private long s;
  private long t;
  private boolean u = false;
  private long v = 0L;
  private long w = 0L;
  private long x = 0L;
  private long y = 0L;
  private long z = 0L;
  
  public e(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.i = TXCCommonUtil.getAppVersion();
    this.r = 5000;
    this.z = 0L;
  }
  
  private void a(int paramInt, String paramString)
  {
    String str2 = TXCStatus.b(this.D, 7121);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString;
    }
    this.b.put("str_session_id", str1);
    this.b.put("u32_server_ip", TXCStatus.b(this.D, 7110));
    if (this.u)
    {
      this.b.put("str_stream_url", TXCStatus.b(this.D, 7116));
      f((String)this.b.get("str_stream_url"));
    }
    else
    {
      this.b.put("str_stream_url", TXCStatus.b(this.D, 7119));
    }
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_session_id", (String)this.b.get("str_session_id"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_os_info", (String)this.b.get("str_os_info"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(paramString, paramInt, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "u32_server_ip", (String)this.b.get("u32_server_ip"));
    TXCDRApi.txSetEventValue(paramString, paramInt, "str_stream_url", (String)this.b.get("str_stream_url"));
  }
  
  private void c(int paramInt)
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, a.am, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", ((Long)this.b.get("u64_timestamp")).longValue());
    long l7 = TXCStatus.a(this.D, 7107);
    long l2 = TXCStatus.a(this.D, 7108);
    long l3 = -1L;
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l7;
    }
    if (l1 < 0L) {
      l2 = -1L;
    } else {
      l2 = l1;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_dns_time", l2);
    long l4 = TXCStatus.a(this.D, 7109);
    l2 = l4;
    if (l4 != -1L) {
      l2 = l4 - l7;
    }
    if (l2 >= 0L) {
      l3 = l2;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_connect_server_time", l3);
    int i1 = TXCStatus.c(this.D, 5004);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", i1);
    this.j = (TXCStatus.a(this.D, 6001) - l7);
    l3 = this.j;
    if (l3 < 0L) {
      l3 = -1L;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_i_frame", l3);
    l4 = TXCStatus.a(this.D, 7103) - l7;
    if (l4 < 0L) {
      l3 = -1L;
    } else {
      l3 = l4;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_frame_down", l3);
    long l5 = TXCStatus.a(this.D, 5005) - l7;
    if (l5 < 0L) {
      l3 = -1L;
    } else {
      l3 = l5;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_video_decode_time", l3);
    long l6 = TXCStatus.a(this.D, 7104) - l7;
    if (l6 < 0L) {
      l3 = -1L;
    } else {
      l3 = l6;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_frame_down", l3);
    l7 = TXCStatus.a(this.D, 2033) - l7;
    if (l7 < 0L) {
      l3 = -1L;
    } else {
      l3 = l7;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_first_audio_render_time", l3);
    int i2 = TXCStatus.c(this.D, 7105);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_err_code", i2);
    int i3 = TXCStatus.c(this.D, 7106);
    TXCDRApi.txSetEventIntValue(str, paramInt, "str_err_info", i3);
    int i4 = TXCStatus.c(this.D, 7112);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(i4));
    int i5 = TXCStatus.c(this.D, 7111);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(i5));
    TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
    TXCDRApi.nativeReportEvent(str, paramInt);
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report evt ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(": token=");
    localStringBuilder.append(str);
    localStringBuilder.append("\n");
    localStringBuilder.append("str_user_id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_user_id"));
    localStringBuilder.append("\n");
    localStringBuilder.append("dev_uuid");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("dev_uuid"));
    localStringBuilder.append("\n");
    localStringBuilder.append("str_session_id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_session_id"));
    localStringBuilder.append("\n");
    localStringBuilder.append("str_device_type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_device_type"));
    localStringBuilder.append("\n");
    localStringBuilder.append("str_os_info");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_os_info"));
    localStringBuilder.append("\n");
    localStringBuilder.append("str_package_name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_package_name"));
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_network_type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("u32_network_type"));
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_server_ip");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("u32_server_ip"));
    localStringBuilder.append("\n");
    localStringBuilder.append("str_stream_url");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_stream_url"));
    localStringBuilder.append("\n");
    localStringBuilder.append("u64_timestamp");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("u64_timestamp"));
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_dns_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l1);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_connect_server_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l2);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_video_decode_type");
    localStringBuilder.append("=");
    localStringBuilder.append(i1);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_first_frame_down");
    localStringBuilder.append("=");
    localStringBuilder.append(l4);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_first_video_decode_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l5);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_first_i_frame");
    localStringBuilder.append("=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_first_audio_frame_down");
    localStringBuilder.append("=");
    localStringBuilder.append(l6);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_first_audio_render_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l7);
    localStringBuilder.append("\n");
    localStringBuilder.append("u64_err_code");
    localStringBuilder.append("=");
    localStringBuilder.append(i2);
    localStringBuilder.append("\n");
    localStringBuilder.append("str_err_info");
    localStringBuilder.append("=");
    localStringBuilder.append(i3);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_link_type");
    localStringBuilder.append("=");
    localStringBuilder.append(i4);
    localStringBuilder.append("\n");
    localStringBuilder.append("u32_channel_type");
    localStringBuilder.append("=");
    localStringBuilder.append(i5);
    localStringBuilder.append("\n");
    localStringBuilder.append("str_app_version");
    localStringBuilder.append("=");
    localStringBuilder.append(this.i);
    TXCLog.d((String)localObject, localStringBuilder.toString());
  }
  
  protected static boolean c(String paramString)
  {
    if ((paramString != null) && (paramString.contains("myqcloud"))) {
      return true;
    }
    return c.a().a(paramString);
  }
  
  private void d(int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void e(int paramInt)
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).url = this.c;
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = true;
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, paramInt, a.am, (TXCDRExtInfo)localObject);
    a(paramInt, str);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    localObject = f.a();
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_cpu_usage", localObject[1]);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_app_cpu_usage", localObject[0]);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_cpu_usage", String.valueOf(TXCStatus.d(this.D, 9002)));
    TXCDRApi.txSetEventValue(str, paramInt, "u32_avg_memory", String.valueOf(TXCStatus.d(this.D, 9005)));
    localObject = this.D;
    int i1 = 2;
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_recv_av_diff_time", TXCStatus.a((String)localObject, 6014, 2));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_play_av_diff_time", TXCStatus.a(this.D, 6013, 2));
    TXCDRApi.txSetEventValue(str, paramInt, "u64_playtime", String.valueOf((TXCTimeUtil.getUtcTimeTick() - this.z) / 1000L));
    if (TXCStatus.c(this.D, 2015) != 0) {
      i1 = 1;
    }
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_type", i1);
    long l1 = TXCStatus.a(this.D, 2002);
    long l2 = this.o;
    if (l2 == -1L) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", Long.valueOf(0L).longValue());
    } else if (l1 >= l2) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", l1 - l2);
    } else {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_block_count", Long.valueOf(-1L).longValue());
    }
    this.o = l1;
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_cache_time", TXCStatus.c(this.D, 2010));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_drop", TXCStatus.c(this.D, 2014));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_type", TXCStatus.c(this.D, 5004));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_recv_fps", j());
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_fps", (int)TXCStatus.d(this.D, 6002));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_time", TXCStatus.c(this.D, 6007));
    l1 = TXCStatus.a(this.D, 6008);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_cache_count", l1);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_cache_count", l1);
    l2 = TXCStatus.a(this.D, 6004);
    long l3 = this.k;
    if (l3 == -1L) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", 0L);
    } else if (l2 >= l3) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_block_count", 0L);
    }
    this.k = l2;
    i1 = TXCStatus.c(this.D, 7102);
    int i2 = TXCStatus.c(this.D, 7101);
    l2 = i1 + i2;
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_net_speed", l2);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_net_speed", l2);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_audio_bitrate", i1);
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_avg_video_bitrate", i2);
    TXCDRApi.txSetEventValue(str, paramInt, "u32_link_type", String.valueOf(TXCStatus.c(this.D, 7112)));
    TXCDRApi.txSetEventValue(str, paramInt, "u32_channel_type", String.valueOf(TXCStatus.c(this.D, 7111)));
    TXCDRApi.txSetEventValue(str, paramInt, "str_app_version", this.i);
    l2 = TXCStatus.a(this.D, 6021);
    l3 = this.l;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_light_block_count", 0L);
    }
    this.l = l2;
    l2 = TXCStatus.a(this.D, 6003);
    l3 = this.m;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_large_block_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_large_block_count", 0L);
    }
    this.m = l2;
    l2 = TXCStatus.c(this.D, 2034);
    l3 = this.n;
    if (l2 > l3) {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_jitter_60ms_count", l2 - l3);
    } else {
      TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_jitter_60ms_count", 0L);
    }
    this.n = l2;
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_video_decode_fail", TXCStatus.c(this.D, 9007));
    TXCDRApi.txSetEventIntValue(str, paramInt, "u32_audio_decode_fail", TXCStatus.c(this.D, 2035));
    TXCDRApi.nativeReportEvent(str, paramInt);
    if (this.u)
    {
      this.y += 1L;
      this.x += l1;
      if (l1 > this.w) {
        this.w = l1;
      }
    }
  }
  
  private void f(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("room://")))
    {
      paramString = paramString.split("/");
      paramString[(paramString.length - 1)].split("_");
      TXCStatus.a(this.D, 7112, Long.valueOf(3L));
    }
  }
  
  private int g(String paramString)
  {
    paramString = (Number)this.b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  private void i()
  {
    a(6002, 6017, 6018);
    int[] arrayOfInt = f.a();
    TXCStatus.a(this.D, 9001, Integer.valueOf(arrayOfInt[0]));
    a(9001, 9002, 9003);
    TXCStatus.a(this.D, 9004, Integer.valueOf(f.b()));
    a(9004, 9005, 9006);
  }
  
  private int j()
  {
    long l1 = TXCTimeUtil.getTimeTick();
    long l2 = TXCStatus.c(this.D, 6019);
    int i1;
    if ((l2 != 0L) && (l1 != 0L))
    {
      long l3 = this.s;
      i1 = (int)((l2 - this.t) * 1000L / (l1 - l3));
    }
    else
    {
      i1 = 0;
    }
    this.s = l1;
    this.t = l2;
    return i1;
  }
  
  private void k()
  {
    Object localObject1 = new HashMap();
    String str1 = TXCStatus.b(this.D, 7116);
    Object localObject2 = TXCStatus.b(this.D, 7117);
    Object localObject3 = TXCStatus.b(this.D, 7118);
    int i1 = TXCStatus.c(this.D, 7105);
    String str2 = TXCStatus.b(this.D, 7106);
    int i2 = TXCStatus.c(this.D, 7111);
    ((Map)localObject1).put("stream_url", str1);
    ((Map)localObject1).put("stream_id", localObject2);
    ((Map)localObject1).put("bizid", localObject3);
    ((Map)localObject1).put("err_code", String.valueOf(i1));
    ((Map)localObject1).put("err_info", str2);
    ((Map)localObject1).put("channel_type", String.valueOf(i2));
    long l1 = System.currentTimeMillis();
    long l2 = this.v;
    ((Map)localObject1).put("start_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(this.v)));
    ((Map)localObject1).put("end_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(l1)));
    ((Map)localObject1).put("total_time", String.valueOf(l1 - l2));
    l2 = TXCStatus.a(this.D, 6003);
    l1 = TXCStatus.a(this.D, 6006);
    long l3 = TXCStatus.a(this.D, 6005);
    if (l2 != 0L) {
      l1 /= l2;
    } else {
      l1 = 0L;
    }
    ((Map)localObject1).put("block_count", String.valueOf(l2));
    ((Map)localObject1).put("block_duration_max", String.valueOf(l3));
    ((Map)localObject1).put("block_duration_avg", String.valueOf(l1));
    l1 = this.y;
    if (l1 != 0L) {
      l1 = this.x / l1;
    } else {
      l1 = 0L;
    }
    ((Map)localObject1).put("jitter_cache_max", String.valueOf(this.w));
    ((Map)localObject1).put("jitter_cache_avg", String.valueOf(l1));
    str1 = TXCDRApi.txCreateToken();
    i1 = a.af;
    i2 = a.al;
    localObject2 = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject2).command_id_comment = "LINKMIC";
    TXCDRApi.InitEvent(this.h, str1, i1, i2, (TXCDRExtInfo)localObject2);
    localObject2 = a;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("report evt 40402: token=");
    ((StringBuilder)localObject3).append(str1);
    TXCLog.d((String)localObject2, ((StringBuilder)localObject3).toString());
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RealTimePlayStatisticInfo: ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" = ");
      localStringBuilder.append((String)localObject3);
      TXCLog.e(str2, localStringBuilder.toString());
      if ((localObject2 != null) && (((String)localObject2).length() > 0) && (localObject3 != null)) {
        TXCDRApi.txSetEventValue(str1, i1, (String)localObject2, (String)localObject3);
      }
    }
    TXCDRApi.nativeReportEvent(str1, i1);
    this.u = false;
    this.v = 0L;
    this.y = 0L;
    this.x = 0L;
    this.w = 0L;
  }
  
  private void l()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    long l1 = TXCStatus.a(this.D, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.P, a.al, (TXCDRExtInfo)localObject);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.P, "u64_timestamp", TXCTimeUtil.getUtcTimeTick());
    TXCDRApi.txSetEventValue(str, a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_dns_time", -1L);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_connect_server_time", -1L);
    TXCDRApi.txSetEventValue(str, a.P, "u32_server_ip", "");
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_resolution", this.d << 16 | this.e);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str, a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, a.P, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    TXCDRApi.nativeReportEvent(str, a.P);
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report evt 40001: token=");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_stream_url");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("u64_timestamp");
    localStringBuilder.append("=");
    localStringBuilder.append(l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_device_type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_device_type"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_network_type");
    localStringBuilder.append("=");
    localStringBuilder.append(g("u32_network_type"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_dns_time");
    localStringBuilder.append("=-1 ");
    localStringBuilder.append("u32_connect_server_time");
    localStringBuilder.append("=-1 ");
    localStringBuilder.append("u32_server_ip");
    localStringBuilder.append("= ");
    localStringBuilder.append("u32_video_resolution");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d << 16 | this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_audio_samplerate");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_video_bitrate");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_user_id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_user_id"));
    localStringBuilder.append(" ");
    localStringBuilder.append("str_package_name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_package_name"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_channel_type");
    localStringBuilder.append("=");
    localStringBuilder.append(l1);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_app_version");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("dev_uuid"));
    localStringBuilder.append(" ");
    localStringBuilder.append("dev_uuid");
    localStringBuilder.append("=");
    localStringBuilder.append(g("u32_max_load"));
    TXCLog.d((String)localObject, localStringBuilder.toString());
  }
  
  private void m()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    String str1 = TXCStatus.b(this.D, 7012);
    long l4 = TXCStatus.a(this.D, 7009);
    long l2 = TXCStatus.a(this.D, 7010);
    long l1 = l2;
    if (l2 != -1L) {
      l1 = l2 - l4;
    }
    long l3 = TXCStatus.a(this.D, 7011);
    l2 = l3;
    if (l3 != -1L) {
      l2 = l3 - l4;
    }
    l3 = TXCStatus.a(this.D, 7013);
    String str2 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str2, a.P, a.al, (TXCDRExtInfo)localObject);
    l4 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str2, a.P, "u64_timestamp", l4);
    TXCDRApi.txSetEventValue(str2, a.P, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_network_type", g("u32_network_type"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_dns_time", l1);
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_connect_server_time", l2);
    TXCDRApi.txSetEventValue(str2, a.P, "u32_server_ip", str1);
    int i1 = a.P;
    int i2 = this.d;
    TXCDRApi.txSetEventIntValue(str2, i1, "u32_video_resolution", this.e | i2 << 16);
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_audio_samplerate", this.g);
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_video_bitrate", this.f);
    TXCDRApi.txSetEventValue(str2, a.P, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str2, a.P, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str2, a.P, "u32_channel_type", l3);
    TXCDRApi.txSetEventValue(str2, a.P, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str2, a.P, "dev_uuid", (String)this.b.get("dev_uuid"));
    localObject = TXCStatus.b(this.D, 7019);
    TXCDRApi.txSetEventValue(str2, a.P, "str_nearest_ip_list", (String)localObject);
    TXCDRApi.nativeReportEvent(str2, a.P);
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report evt 40001: token=");
    localStringBuilder.append(str2);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_stream_url");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("u64_timestamp");
    localStringBuilder.append("=");
    localStringBuilder.append(l4);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_device_type");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_device_type"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_network_type");
    localStringBuilder.append("=");
    localStringBuilder.append(g("u32_network_type"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_dns_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l1);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_connect_server_time");
    localStringBuilder.append("=");
    localStringBuilder.append(l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_server_ip");
    localStringBuilder.append("=");
    localStringBuilder.append(str1);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_video_resolution");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d << 16 | this.e);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_audio_samplerate");
    localStringBuilder.append("=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_video_bitrate");
    localStringBuilder.append("=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_user_id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_user_id"));
    localStringBuilder.append(" ");
    localStringBuilder.append("str_package_name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_package_name"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_channel_type");
    localStringBuilder.append("=");
    localStringBuilder.append(l3);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_app_version");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("dev_uuid"));
    localStringBuilder.append(" ");
    localStringBuilder.append("dev_uuid");
    localStringBuilder.append("=");
    localStringBuilder.append(g("u32_max_load"));
    TXCLog.d((String)localObject, localStringBuilder.toString());
  }
  
  private void n()
  {
    Object localObject = new TXCDRExtInfo();
    ((TXCDRExtInfo)localObject).report_common = false;
    ((TXCDRExtInfo)localObject).report_status = false;
    ((TXCDRExtInfo)localObject).url = this.c;
    long l3 = TXCStatus.a(this.D, 7009);
    long l1 = TXCStatus.a(this.D, 7013);
    String str = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str, a.R, a.al, (TXCDRExtInfo)localObject);
    long l2 = TXCTimeUtil.getUtcTimeTick();
    TXCDRApi.txSetEventIntValue(str, a.R, "u64_timestamp", l2);
    l3 = (TXCTimeUtil.getTimeTick() - l3) / 1000L;
    TXCDRApi.txSetEventIntValue(str, a.R, "u32_result", l3);
    TXCDRApi.txSetEventValue(str, a.R, "str_user_id", (String)this.b.get("str_user_id"));
    TXCDRApi.txSetEventValue(str, a.R, "str_package_name", (String)this.b.get("str_package_name"));
    TXCDRApi.txSetEventIntValue(str, a.R, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str, a.R, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str, a.R, "dev_uuid", (String)this.b.get("dev_uuid"));
    int i1 = TXCStatus.c(this.D, 7016);
    TXCDRApi.txSetEventValue(str, a.R, "u32_ip_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.D, 7017);
    TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_quic", String.valueOf(i1));
    i1 = TXCStatus.c(this.D, 7018);
    TXCDRApi.txSetEventValue(str, a.R, "u32_connect_count_tcp", String.valueOf(i1));
    TXCDRApi.nativeReportEvent(str, a.R);
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report evt 40002: token=");
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_stream_url");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ");
    localStringBuilder.append("u64_timestamp");
    localStringBuilder.append("=");
    localStringBuilder.append(l2);
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_result");
    localStringBuilder.append("=");
    localStringBuilder.append(l3);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_user_id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_user_id"));
    localStringBuilder.append(" ");
    localStringBuilder.append("str_package_name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("str_package_name"));
    localStringBuilder.append(" ");
    localStringBuilder.append("u32_channel_type");
    localStringBuilder.append("=");
    localStringBuilder.append(l1);
    localStringBuilder.append(" ");
    localStringBuilder.append("str_app_version");
    localStringBuilder.append("=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" ");
    localStringBuilder.append("dev_uuid");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b.get("dev_uuid"));
    TXCLog.d((String)localObject, localStringBuilder.toString());
  }
  
  private void o()
  {
    TXCDRExtInfo localTXCDRExtInfo = new TXCDRExtInfo();
    localTXCDRExtInfo.report_common = false;
    localTXCDRExtInfo.report_status = true;
    localTXCDRExtInfo.url = this.c;
    Object localObject = f.a();
    int i1 = localObject[0];
    int i2 = localObject[1];
    int i3 = f.b();
    long l1 = TXCStatus.a(this.D, 7013);
    int i4 = TXCStatus.c(this.D, 7004);
    int i5 = TXCStatus.c(this.D, 7003);
    double d1 = TXCStatus.d(this.D, 4001);
    int i6 = TXCStatus.c(this.D, 7005);
    int i7 = TXCStatus.c(this.D, 7002);
    int i8 = TXCStatus.c(this.D, 7001);
    int i9 = TXCStatus.c(this.D, 4007);
    localObject = TXCStatus.b(this.D, 7012);
    String str1 = TXCStatus.b(this.D, 7014);
    String str2 = TXCStatus.b(this.D, 7015);
    String str3 = TXCStatus.b(this.D, 3001);
    long l2 = TXCStatus.a(this.D, 3002);
    double d2 = TXCStatus.d(this.D, 3003);
    int i10 = TXCStatus.c(this.D, 7020);
    String str4 = (String)this.b.get("token");
    TXCDRApi.InitEvent(this.h, str4, a.Q, a.al, localTXCDRExtInfo);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_audio_bitrate", i7);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_video_bitrate", i8);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_net_speed", i5 + i4);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_fps", (int)d1);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_cache_size", i6);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_cpu_usage", i2);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_app_cpu_usage", i1);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_avg_memory", i3);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_channel_type", l1);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_app_version", this.i);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_device_type", (String)this.b.get("str_device_type"));
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_hw_enc", i9);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_server_ip", (String)localObject);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_quic_connection_id", str1);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_quic_connection_stats", str2);
    TXCDRApi.txSetEventValue(str4, a.Q, "str_beauty_stats", str3);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_send_strategy", i10);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_preprocess_timecost", l2);
    TXCDRApi.txSetEventIntValue(str4, a.Q, "u32_preprocess_fps_out", (int)d2);
    TXCDRApi.nativeReportEvent(str4, a.Q);
  }
  
  private void p()
  {
    this.p = false;
    this.q = 0L;
    this.A = 0;
    Object localObject2 = this.E;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = TXCCommonUtil.getUserId();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = f.b(this.h);
    }
    this.b.put("str_user_id", localObject2);
    this.b.put("str_device_type", f.c());
    this.b.put("str_device_type", f.c());
    this.b.put("u32_network_type", Integer.valueOf(f.e(this.h)));
    this.b.put("token", f.e());
    this.b.put("str_package_name", f.c(this.h));
    this.b.put("dev_uuid", f.f(this.h));
    this.b.put("str_os_info", f.d());
    this.z = TXCTimeUtil.getUtcTimeTick();
    this.b.put("u64_timestamp", Long.valueOf(this.z));
  }
  
  public void a()
  {
    p();
    this.k = -1L;
    this.o = -1L;
    this.l = 0L;
    this.m = 0L;
    this.n = 0L;
    this.v = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 6002)
    {
      d2 = TXCStatus.d(this.D, paramInt1);
      if (d2 < 0.001D) {
        return;
      }
      d1 = TXCStatus.d(this.D, paramInt2);
      paramInt1 = TXCStatus.c(this.D, paramInt3) + 1;
      d3 = paramInt1;
      Double.isNaN(d3);
      d2 = (d2 - d1) / d3;
      TXCStatus.a(this.D, paramInt2, Double.valueOf(d1 + d2));
      TXCStatus.a(this.D, paramInt3, Integer.valueOf(paramInt1));
      return;
    }
    double d2 = TXCStatus.c(this.D, paramInt1);
    if (d2 < 0.001D) {
      return;
    }
    double d1 = TXCStatus.d(this.D, paramInt2);
    paramInt1 = TXCStatus.c(this.D, paramInt3) + 1;
    Double.isNaN(d2);
    double d3 = paramInt1;
    Double.isNaN(d3);
    d2 = (d2 - d1) / d3;
    TXCStatus.a(this.D, paramInt2, Double.valueOf(d1 + d2));
    TXCStatus.a(this.D, paramInt3, Integer.valueOf(paramInt1));
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
    b(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void b()
  {
    if (this.p)
    {
      n();
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("push ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" failed!");
    TXCLog.e(str, localStringBuilder.toString());
    l();
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.B = paramString;
  }
  
  public void c()
  {
    if (this.p)
    {
      if (this.u) {
        e(a.Y);
      } else if (d() != e.a.c) {
        e(a.V);
      }
      if (this.u) {
        d(a.Z);
      } else {
        d(a.W);
      }
    }
    else
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play ");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" failed");
      TXCLog.e(str, localStringBuilder.toString());
      if (this.u) {
        c(a.X);
      } else {
        c(a.U);
      }
    }
    if (this.u) {
      k();
    }
    TXCStatus.a(this.D, 7107, Long.valueOf(0L));
    TXCStatus.a(this.D, 2033, Long.valueOf(0L));
    TXCStatus.a(this.D, 6001, Long.valueOf(0L));
    TXCStatus.a(this.D, 7104, Long.valueOf(0L));
    TXCStatus.a(this.D, 7108, Long.valueOf(0L));
  }
  
  protected e.a d()
  {
    try
    {
      Object localObject = Uri.parse(this.B);
      if (localObject == null) {
        return e.a.a;
      }
      String str1 = ((Uri)localObject).getHost();
      if (TextUtils.isEmpty(str1)) {
        return e.a.a;
      }
      String str2 = ((Uri)localObject).getScheme();
      if (str2 == null) {
        return e.a.a;
      }
      if ((!str2.equals("rtmp")) && (!str2.equals("http")) && (!str2.equals("https"))) {
        return e.a.a;
      }
      if (c(str1)) {
        return e.a.b;
      }
      localObject = ((Uri)localObject).getQueryParameterNames();
      if ((localObject != null) && ((((Set)localObject).contains("bizid")) || (((Set)localObject).contains("txTime")) || (((Set)localObject).contains("txSecret")))) {
        return e.a.b;
      }
      if (C.containsKey(str1)) {
        return (e.a)C.get(str1);
      }
      C.put(str1, e.a.a);
      new Thread(new e.1(this, str1)).start();
    }
    catch (Exception localException)
    {
      TXCLog.e(a, "check stream failed.", localException);
    }
    return e.a.a;
  }
  
  public void d(String paramString)
  {
    this.D = paramString;
  }
  
  public void e()
  {
    if ((!this.p) && (!TextUtils.isEmpty(TXCStatus.b(this.D, 7012))))
    {
      m();
      this.p = true;
    }
    if (this.q <= 0L) {
      this.q = TXCTimeUtil.getTimeTick();
    }
    if ((this.p) && (TXCTimeUtil.getTimeTick() - this.q > 5000L))
    {
      o();
      this.q = TXCTimeUtil.getTimeTick();
    }
  }
  
  public void e(String paramString)
  {
    this.E = paramString;
  }
  
  public void f()
  {
    i();
    int i1;
    if (!this.p)
    {
      long l1 = TXCStatus.a(this.D, 6001);
      long l2 = TXCStatus.a(this.D, 7104);
      long l3 = TXCStatus.a(this.D, 2033);
      long l4 = TXCStatus.a(this.D, 7108);
      if ((l1 > 0L) && (l2 > 0L) && (l4 > 0L) && (l3 > 0L))
      {
        if (this.u) {
          i1 = a.X;
        } else {
          i1 = a.U;
        }
        c(i1);
        this.r = 5000;
        this.p = true;
      }
      String str = TXCStatus.b(this.D, 7119);
      if (str != null) {
        b(str);
      }
    }
    if ((this.A >= 3) && (!this.p))
    {
      if (this.u) {
        i1 = a.X;
      } else {
        i1 = a.U;
      }
      c(i1);
      this.r = 5000;
      this.p = true;
    }
    this.A += 1;
    if (this.q <= 0L) {
      this.q = TXCTimeUtil.getTimeTick();
    }
    if (TXCTimeUtil.getTimeTick() > this.q + this.r)
    {
      if (this.u)
      {
        e(a.Y);
        this.r = 5000;
      }
      else
      {
        if (d() == e.a.c) {
          return;
        }
        e(a.V);
        this.r = TXCDRApi.getStatusReportInterval();
        if (this.r < 5000) {
          this.r = 5000;
        }
        if (this.r > 300000) {
          this.r = 300000;
        }
      }
      this.k = TXCStatus.a(this.D, 6004);
      this.o = TXCStatus.c(this.D, 2002);
      this.q = TXCTimeUtil.getTimeTick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */