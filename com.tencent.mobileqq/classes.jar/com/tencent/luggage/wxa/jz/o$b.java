package com.tencent.luggage.wxa.jz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.ig.f;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class o$b
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<b> CREATOR = new o.b.1();
  public c a;
  public int b;
  public String c;
  public String d;
  public String e;
  public boolean f = false;
  public String g = "";
  public String h = null;
  public String i = null;
  private m j;
  
  public o$b(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public o$b(com.tencent.luggage.wxa.jx.a parama, c paramc, int paramInt)
  {
    this.j = parama;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.qq.b.a());
    localStringBuilder.append("/image/");
    localStringBuilder.append(paramString.hashCode());
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
    try
    {
      Object localObject1 = new JSONObject(this.e);
      String str3 = ((JSONObject)localObject1).optString("src");
      String str4 = ((JSONObject)localObject1).optString("title");
      String str5 = ((JSONObject)localObject1).optString("epname");
      String str6 = ((JSONObject)localObject1).optString("singer");
      localObject2 = ((JSONObject)localObject1).optString("coverImgUrl");
      String str7 = ((JSONObject)localObject1).optString("webUrl");
      String str1 = ((JSONObject)localObject1).optString("protocol");
      double d2 = ((JSONObject)localObject1).optDouble("startTime", 0.0D);
      String str2 = ((JSONObject)localObject1).optString("songLyric");
      double d1 = ((JSONObject)localObject1).optDouble("playbackRate", 1.0D);
      double d3 = ((JSONObject)localObject1).optDouble("volume", 1.0D);
      localObject1 = ((JSONObject)localObject1).optString("operationType");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        localObject2 = com.tencent.luggage.wxa.nr.b.b().c();
        if ((!af.c((String)localObject2)) && (!((String)localObject2).equals(this.c)))
        {
          o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject2, this.c });
          return;
        }
        this.f = false;
        if (((String)localObject1).equalsIgnoreCase("pause"))
        {
          if (com.tencent.luggage.wxa.ig.b.b())
          {
            o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
            return;
          }
          this.f = true;
          this.g = "pause music fail";
        }
        else if (((String)localObject1).equalsIgnoreCase("stop"))
        {
          if (com.tencent.luggage.wxa.ig.b.c())
          {
            o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            return;
          }
          this.f = true;
          this.g = "stop music fail";
        }
        e();
        return;
      }
      if (TextUtils.isEmpty(str3))
      {
        o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.f = true;
        this.g = "src is null";
        e();
        return;
      }
      if ((str2 != null) && (str2.length() > 32768))
      {
        o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.f = true;
        this.g = "songLyric is large than 32KB";
        e();
        return;
      }
      o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str3, str4, str5, str6, localObject2, str1, str7, Double.valueOf(d2), this.d, Double.valueOf(d1) });
      if ((d1 >= 0.5D) && (d1 <= 2.0D)) {
        break label447;
      }
      d1 = 1.0D;
      label447:
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      if (TextUtils.isEmpty(str2)) {
        o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
      } else {
        o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str2 });
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c);
      localStringBuilder.append(str3);
      localStringBuilder.append((String)localObject1);
      ((StringBuilder)localObject2).append(localStringBuilder.toString().hashCode());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = f.a(c(), (String)localObject1, str4, str6, str7, str3, str3, (String)localObject2, com.tencent.luggage.wxa.hz.a.d(), a((String)localObject1), str5, this.c);
      ((e)localObject1).u = ((int)(1000.0D * d2));
      ((e)localObject1).w = str1;
      ((e)localObject1).l = str2;
      ((e)localObject1).A = d1;
      if (this.d.startsWith("file://")) {
        ((e)localObject1).o = this.d;
      }
      ((e)localObject1).D = this.h;
      ((e)localObject1).E = this.i;
      ((e)localObject1).B = ((float)d3);
      com.tencent.luggage.wxa.nr.b.b().a(((e)localObject1).c);
      com.tencent.luggage.wxa.nr.b.b().a((e)localObject1);
      int k;
      if ((((e)localObject1).b(com.tencent.luggage.wxa.ig.a.f())) && (com.tencent.luggage.wxa.ig.a.d())) {
        k = 1;
      } else {
        k = 0;
      }
      if (k == 0)
      {
        o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
        com.tencent.luggage.wxa.ig.a.b((e)localObject1);
      }
      else
      {
        o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
        com.tencent.luggage.wxa.ig.a.a((e)localObject1);
      }
      o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
      o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
      this.f = false;
      e();
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
      this.f = true;
      this.g = "parser data fail, data is invalid";
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exception:%s");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", ((StringBuilder)localObject2).toString());
      e();
    }
  }
  
  public void a(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.e = paramParcel.readString();
    int k = paramParcel.readInt();
    boolean bool = true;
    if (k != 1) {
      bool = false;
    }
    this.f = bool;
    this.g = paramParcel.readString();
    this.d = paramParcel.readString();
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public void b()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
      return;
    }
    if (!this.f)
    {
      o.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
      this.a.a(this.b, this.j.b("ok"));
      return;
    }
    o.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.g });
    c localc = this.a;
    int k = this.b;
    m localm = this.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(this.g);
    localc.a(k, localm.b(localStringBuilder.toString()));
  }
  
  protected int c()
  {
    return 11;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.o.b
 * JD-Core Version:    0.7.0.1
 */