package com.tencent.luggage.wxa.jz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONException;
import org.json.JSONObject;

public class l$d
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<d> CREATOR = new l.d.1();
  public c a;
  public int b;
  public String c;
  public String d;
  public boolean e = false;
  public String f = "";
  private m g;
  
  public l$d(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public l$d(com.tencent.luggage.wxa.jx.a parama, c paramc, int paramInt)
  {
    this.g = parama;
    this.a = paramc;
    this.b = paramInt;
  }
  
  public void a()
  {
    o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
    Object localObject1 = com.tencent.luggage.wxa.nr.b.b().c();
    if ((!af.c((String)localObject1)) && (!((String)localObject1).equals(this.c)))
    {
      o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.c });
      this.e = true;
      this.f = "appid not match cannot operate";
      e();
      return;
    }
    try
    {
      localObject1 = new JSONObject(this.d);
      localObject2 = ((JSONObject)localObject1).optString("operationType");
      double d1 = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
        this.e = true;
        this.f = "operationType is null";
        e();
        return;
      }
      o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject2, Double.valueOf(d1) });
      this.e = false;
      if (((String)localObject2).equalsIgnoreCase("play"))
      {
        localObject2 = com.tencent.luggage.wxa.nr.b.b().a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = com.tencent.luggage.wxa.ig.a.f();
        }
        if (localObject1 != null) {
          com.tencent.luggage.wxa.nr.b.b().a(((e)localObject1).c);
        }
        if (com.tencent.luggage.wxa.ig.b.a())
        {
          o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
        else if (com.tencent.luggage.wxa.ig.a.d())
        {
          this.e = true;
          this.f = "music is playing, don't play again";
        }
        else if ((localObject1 != null) && (this.c.equals(((e)localObject1).p)))
        {
          o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.luggage.wxa.ig.a.b((e)localObject1);
        }
        else
        {
          this.e = true;
          this.f = "play music fail";
        }
      }
      else if (((String)localObject2).equalsIgnoreCase("pause"))
      {
        if (com.tencent.luggage.wxa.ig.b.b())
        {
          o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
        }
        else
        {
          this.e = true;
          this.f = "pause music fail";
        }
      }
      else if (((String)localObject2).equalsIgnoreCase("seek"))
      {
        if (d1 < 0.0D)
        {
          o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
          this.e = true;
          this.f = "currentTime is invalid";
        }
        else if (com.tencent.luggage.wxa.ig.b.a((int)(d1 * 1000.0D)))
        {
          o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
        }
        else
        {
          this.e = true;
          this.f = "seek music fail";
        }
      }
      else if (((String)localObject2).equalsIgnoreCase("stop"))
      {
        if (com.tencent.luggage.wxa.ig.b.c())
        {
          o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
        }
        else
        {
          this.e = true;
          this.f = "stop music fail";
        }
      }
      else
      {
        o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
        this.e = true;
        this.f = "operationType is invalid";
      }
      if (this.e) {
        o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", this.f);
      }
      e();
      return;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.d });
      this.e = true;
      this.f = "parser data fail, data is invalid";
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("exception:%s");
      ((StringBuilder)localObject2).append(localJSONException.getMessage());
      o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", ((StringBuilder)localObject2).toString());
      e();
    }
  }
  
  public void a(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.e = bool;
    this.f = paramParcel.readString();
  }
  
  public void b()
  {
    if (this.a == null)
    {
      o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
      return;
    }
    if (!this.e)
    {
      o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
      this.a.a(this.b, this.g.b("ok"));
      return;
    }
    o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.f });
    c localc = this.a;
    int i = this.b;
    m localm = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(this.f);
    localc.a(i, localm.b(localStringBuilder.toString()));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.l.d
 * JD-Core Version:    0.7.0.1
 */