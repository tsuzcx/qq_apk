package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  implements Parcelable
{
  public static final Parcelable.Creator<g> CREATOR = new g.1();
  private static volatile g J;
  public static final g a = new g();
  public int A;
  public int B;
  public g.d C;
  public g.c D;
  public long E;
  public String[] F;
  public int G;
  public int H;
  public int I;
  public int b = 2147483647;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public String j;
  public String k;
  public g.b l = new g.b();
  public int[] m;
  public int n;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  public int v;
  public int w;
  public int x;
  public String[] y;
  public double z;
  
  static
  {
    g localg = a;
    localg.c = 5;
    localg.d = 1;
    localg.e = 300;
    localg.f = 50;
    localg.g = 1048576;
    localg.h = 1048576;
    localg.i = 20971520;
    localg.m = g.a.a;
    localg = a;
    localg.n = 50;
    localg.o = 11;
    localg.p = 12;
    localg.r = 1800;
    localg.s = 307200;
    localg.t = 25;
    localg.u = 10485760;
    localg.v = 314572800;
    localg.w = 1;
    localg.x = 50;
    localg.y = g.a.b;
    localg = a;
    localg.z = 0.0D;
    localg.A = 60;
    localg.B = 60;
    localg.C = new g.d();
    a.D = new g.c();
    localg = a;
    localg.E = 30L;
    localg.F = g.a.c;
    localg = a;
    localg.G = 10;
    localg.I = 86400;
  }
  
  private g() {}
  
  protected g(Parcel paramParcel)
  {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readString();
    this.k = paramParcel.readString();
    this.l = ((g.b)paramParcel.readParcelable(g.b.class.getClassLoader()));
    this.m = paramParcel.createIntArray();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readInt();
    this.r = paramParcel.readInt();
    this.s = paramParcel.readInt();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readInt();
    this.v = paramParcel.readInt();
    this.w = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.createStringArray();
    this.z = paramParcel.readDouble();
    this.A = paramParcel.readInt();
    this.C = ((g.d)paramParcel.readParcelable(g.d.class.getClassLoader()));
    this.D = ((g.c)paramParcel.readParcelable(g.c.class.getClassLoader()));
    this.E = paramParcel.readLong();
    this.F = paramParcel.createStringArray();
    this.G = paramParcel.readInt();
    this.I = paramParcel.readInt();
    this.H = paramParcel.readInt();
    this.B = paramParcel.readInt();
  }
  
  private static g a(String paramString)
  {
    o.e("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[] { paramString });
    try
    {
      paramString = new JSONObject(paramString);
      g localg = new g();
      Object localObject1 = paramString.optJSONObject("HTTPSetting");
      int i1;
      if (localObject1 != null)
      {
        Object localObject2 = ((JSONObject)localObject1).optString("HTTPHeaderMode", "");
        if (((String)localObject2).equals("BlackList")) {
          localg.l.a = 1;
        } else if (((String)localObject2).equals("WhiteList")) {
          localg.l.a = 2;
        }
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderBlackList");
        if (localObject2 != null)
        {
          localg.l.b = new ArrayList();
          i1 = 0;
          while (i1 < ((JSONArray)localObject2).length())
          {
            localg.l.b.add(((JSONArray)localObject2).getString(i1));
            i1 += 1;
          }
        }
        localObject2 = ((JSONObject)localObject1).optJSONArray("HeaderWhiteList");
        if (localObject2 != null)
        {
          localg.l.c = new ArrayList();
          i1 = 0;
          while (i1 < ((JSONArray)localObject2).length())
          {
            localg.l.c.add(((JSONArray)localObject2).getString(i1));
            i1 += 1;
          }
        }
        localg.l.d = ((JSONObject)localObject1).optInt("WebsocketMaxTimeoutMS", -1);
        localg.l.e = ((JSONObject)localObject1).optInt("UploadMaxTimeoutMS", -1);
        localg.l.f = ((JSONObject)localObject1).optInt("DownloadMaxTimeoutMS", -1);
        localg.l.g = ((JSONObject)localObject1).optInt("RequestMaxTimeoutMS", -1);
        localg.l.h = ((JSONObject)localObject1).optString("HTTPHeaderReferer");
      }
      localg.C = new g.d();
      localObject1 = paramString.optJSONObject("SyncVersionSetting");
      if (localObject1 != null)
      {
        localg.C.a = ((JSONObject)localObject1).optLong("PullVersionInterval", localg.C.a);
        localg.C.b = ((JSONObject)localObject1).optLong("PullVersionWxaUsageLastInterval", localg.C.b);
        localg.C.c = ((JSONObject)localObject1).optInt("PullVersionMaxCount", localg.C.c);
        localg.C.d = ((JSONObject)localObject1).optInt("PullVersionMaxCountPerRequest", localg.C.d);
      }
      localg.D = new g.c();
      localObject1 = paramString.optJSONObject("PackageManager");
      if (localObject1 != null)
      {
        localg.D.a = ((JSONObject)localObject1).optLong("CheckInterval", localg.D.a);
        localg.D.b = ((JSONObject)localObject1).optLong("WithoutContactClearSeconds", localg.D.b);
        localg.D.c = ((JSONObject)localObject1).optLong("ClientStorageMinMB", localg.D.c);
        localg.D.d = ((JSONObject)localObject1).optInt("WholeClientStoragePercent", localg.D.d);
      }
      localg.j = paramString.optString("CDNBaseURL");
      localg.k = paramString.optString("CDNPreConnectURL", "https://res.servicewechat.com");
      localg.c = paramString.optInt("AppMaxRunningCount", 5);
      localg.d = paramString.optInt("AppSharedResourceBackgroundRunningCount", 1);
      localg.e = paramString.optInt("TempFileSizeLimitTotal", 300);
      localg.f = paramString.optInt("DownloadFileSizeLimit", 50);
      localg.g = paramString.optInt("MaxLocalStorageItemSize", 1048576);
      localg.h = paramString.optInt("MaxGlobalStorageItemSize", 1048576);
      localg.i = paramString.optInt("MaxGlobalStorageSize", 20971520);
      localg.u = paramString.optInt("NativeBufferSizeLimitByte", 10485760);
      localg.v = paramString.optInt("NativeBufferQueueLimitByte", 314572800);
      localg.I = paramString.optInt("WeUseRecallInterval", 86400);
      localObject1 = paramString.optJSONArray("SyncLaunchSceneList");
      if (localObject1 != null)
      {
        localg.m = new int[((JSONArray)localObject1).length()];
        i1 = 0;
        while (i1 < ((JSONArray)localObject1).length())
        {
          localg.m[i1] = ((JSONArray)localObject1).optInt(i1, 0);
          i1 += 1;
        }
      }
      if (localg.m == null) {
        localg.m = g.a.a;
      }
      localg.n = paramString.optInt("StarNumberLimitation", 50);
      localg.o = paramString.optInt("TaskBarItemCountLimitation", 11);
      localg.p = paramString.optInt("NewTaskBarRecentsItemCountLimitation", 12);
      localg.q = paramString.optInt("TaskBarSyncUsageRecordIntervalMinute", 20);
      localg.r = paramString.optInt("WidgetImageFlowLimitDuration", 1800);
      localg.s = paramString.optInt("WidgetImageFlowLimitMaxSize", 307200);
      localg.t = paramString.optInt("WidgetDrawMinInterval", 25);
      localg.w = paramString.optInt("GameMaxRunningCount", 1);
      localg.x = paramString.optInt("GameDownloadFileSizeLimit", 50);
      localObject1 = paramString.optJSONArray("SubContextImgDomain");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() != 0))
      {
        localg.y = new String[((JSONArray)localObject1).length()];
        i1 = 0;
      }
      while (i1 < ((JSONArray)localObject1).length())
      {
        localg.y[i1] = ((JSONArray)localObject1).optString(i1, null);
        i1 += 1;
        continue;
        localg.y = g.a.b;
      }
      localg.z = paramString.optDouble("GamePerfCollectSamplePercentage", 0.0D);
      localg.A = paramString.optInt("GamePerfCollectInterval", 60);
      localg.B = paramString.optInt("PerformIndexReportGapInSeconds", 60);
      localg.E = paramString.optLong("OpendataMaxFileStorageSize", 30L);
      localObject1 = paramString.optJSONArray("PreDownloadUserNameBlackList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        localg.F = new String[((JSONArray)localObject1).length()];
        i1 = 0;
      }
      while (i1 < ((JSONArray)localObject1).length())
      {
        localg.F[i1] = ((JSONArray)localObject1).optString(i1, null);
        i1 += 1;
        continue;
        localg.F = g.a.c;
      }
      localg.G = paramString.optInt("WXDataMaxRequestConcurrent", 10);
      localg.H = paramString.optInt("WxaWebRenderingCacheMaxStorageSizeMB", 100);
      return localg;
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[] { af.a(paramString) });
    }
    return null;
  }
  
  static String a()
  {
    i locali = new i(a.j().replace("/data/user/0", "/data/data"), "wxaapp/res/");
    if (!locali.j()) {
      locali.u();
    }
    return new i(locali, "AppService.conf").l();
  }
  
  @NonNull
  public static g b()
  {
    g localg2 = c();
    g localg1 = localg2;
    if (localg2 == null) {
      localg1 = a;
    }
    return localg1;
  }
  
  @Nullable
  private static g c()
  {
    Object localObject1;
    label41:
    try
    {
      localObject1 = J;
      if (localObject1 != null) {}
    }
    finally {}
    try
    {
      try
      {
        localObject1 = k.e(a());
      }
      catch (IOException localIOException)
      {
        o.b("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", new Object[] { localIOException });
        break label78;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject3 = null;
      break label41;
    }
    boolean bool = af.c(localIOException);
    if (bool) {
      return null;
    }
    J = a(localIOException);
    g localg = J;
    return localg;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeString(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeParcelable(this.l, paramInt);
    paramParcel.writeIntArray(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeInt(this.o);
    paramParcel.writeInt(this.r);
    paramParcel.writeInt(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeInt(this.u);
    paramParcel.writeInt(this.v);
    paramParcel.writeInt(this.w);
    paramParcel.writeInt(this.x);
    paramParcel.writeStringArray(this.y);
    paramParcel.writeDouble(this.z);
    paramParcel.writeInt(this.A);
    paramParcel.writeParcelable(this.C, paramInt);
    paramParcel.writeParcelable(this.D, paramInt);
    paramParcel.writeLong(this.E);
    paramParcel.writeStringArray(this.F);
    paramParcel.writeInt(this.G);
    paramParcel.writeInt(this.I);
    paramParcel.writeInt(this.H);
    paramParcel.writeInt(this.B);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.g
 * JD-Core Version:    0.7.0.1
 */