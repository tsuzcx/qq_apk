package com.tencent.luggage.wxa.cb;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.a;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONObject;

class a$d
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<d> CREATOR = new a.d.7();
  com.tencent.luggage.wxa.id.a.b a;
  c.c b;
  public String c;
  public String d;
  public boolean e = false;
  public String f;
  public int g;
  public String h;
  private m i;
  private h j;
  private int k;
  private final com.tencent.luggage.wxa.qy.c l = new a.d.6(this);
  
  public a$d(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public a$d(m paramm, h paramh, int paramInt)
  {
    this.i = paramm;
    this.j = paramh;
    this.k = paramInt;
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
    try
    {
      Object localObject2 = new JSONObject(this.c);
      String str1 = ((JSONObject)localObject2).optString("operationType");
      String str2 = ((JSONObject)localObject2).optString("dataUrl");
      if (af.c(str1))
      {
        this.g = -1;
        this.e = true;
        this.h = "operationType is null or nil";
        e();
        return;
      }
      if (!com.tencent.luggage.wxa.nr.b.b().a(this.d, str1))
      {
        o.d("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
        this.g = -1;
        this.e = true;
        this.h = "appid not match cannot operate";
        e();
        return;
      }
      Object localObject1 = str1;
      if (a.e())
      {
        localObject1 = str1;
        if (!a.d())
        {
          localObject1 = str1;
          if (str1.equalsIgnoreCase("play"))
          {
            localObject1 = a.f();
            if ((localObject1 != null) && ((af.c(str2)) || (str2.equals(((e)localObject1).i))))
            {
              if (com.tencent.luggage.wxa.nr.b.b().a(this.d, "resume"))
              {
                o.d("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[] { this.d });
                localObject1 = "resume";
              }
              else
              {
                o.d("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                localObject1 = str1;
              }
            }
            else
            {
              o.d("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
              localObject1 = str1;
            }
          }
        }
      }
      if (((String)localObject1).equalsIgnoreCase("play"))
      {
        localObject1 = ((JSONObject)localObject2).optString("title");
        str1 = ((JSONObject)localObject2).optString("singer");
        String str3 = ((JSONObject)localObject2).optString("epname");
        localObject2 = ((JSONObject)localObject2).optString("coverImgUrl");
        if (af.c(str2))
        {
          this.g = -1;
          this.e = true;
          this.h = "dataUrl is null or nil";
          e();
          return;
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[] { localObject1, str1, str3, localObject2, str2, str2, str2 });
        a.c();
        String str4 = com.tencent.luggage.wxa.nr.b.b().c();
        if (!af.c(str4))
        {
          o.d("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { str4, this.d });
          com.tencent.luggage.wxa.nr.b.b().c(str4);
        }
        t.a(new a.d.1(this, str2, (String)localObject2, (String)localObject1, str1, str2, str2, str3), 500L);
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("resume"))
      {
        localObject1 = com.tencent.luggage.wxa.nr.b.b().c();
        if (!af.c((String)localObject1))
        {
          o.d("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[] { localObject1, this.d });
          com.tencent.luggage.wxa.nr.b.b().c((String)localObject1);
        }
        com.tencent.luggage.wxa.nr.b.b().a(this.l, this.d);
        com.tencent.luggage.wxa.nr.b.b().b(this.d);
        localObject1 = a.f();
        if (localObject1 != null) {
          com.tencent.luggage.wxa.nr.b.b().a(((e)localObject1).c);
        }
        if (com.tencent.luggage.wxa.ig.b.a())
        {
          t.a(new a.d.2(this), 500L);
          return;
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
        this.g = -1;
        this.e = true;
        this.h = "resume play fail";
        e();
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("pause"))
      {
        if (com.tencent.luggage.wxa.ig.b.b())
        {
          t.a(new a.d.3(this), 500L);
          return;
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
        this.g = -1;
        this.e = true;
        this.h = "pause play fail";
        e();
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("seek"))
      {
        if (com.tencent.luggage.wxa.ig.b.a(af.a(af.a(((JSONObject)localObject2).optString("position")), -1) * 1000))
        {
          t.a(new a.d.4(this), 500L);
          return;
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
        this.g = -1;
        this.e = true;
        this.h = "seek fail";
        e();
        return;
      }
      if (((String)localObject1).equalsIgnoreCase("stop"))
      {
        if (com.tencent.luggage.wxa.ig.b.c())
        {
          t.a(new a.d.5(this), 500L);
          return;
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
        this.g = -1;
        this.e = false;
        this.h = "stop play fail";
        e();
        return;
      }
      this.g = -1;
      this.e = true;
      e();
      return;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.JsApiOperateMusicPlayer", localException.toString());
      this.g = -1;
      this.e = true;
      this.h = "data is null";
      e();
    }
  }
  
  public void a(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readString();
  }
  
  public void b()
  {
    Boolean localBoolean1 = Boolean.valueOf(true);
    int m = this.g;
    Boolean localBoolean2 = Boolean.valueOf(false);
    o.d("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[] { Integer.valueOf(m) });
    h localh = this.j;
    m = this.k;
    m localm = this.i;
    Object localObject;
    if (this.e)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail");
      if (TextUtils.isEmpty(this.h))
      {
        localObject = "";
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(this.h);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append((String)localObject);
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "ok";
    }
    localh.a(m, localm.b((String)localObject));
    m = this.g;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            if (m != 4)
            {
              if (m == 7) {}
            }
            else
            {
              o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
              this.j.a("onMusicError", this.f);
              this.a.a("Music#isPlaying", localBoolean2);
              com.tencent.luggage.wxa.iu.c.b(this.j.getAppId(), this.b);
            }
          }
          else
          {
            o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
            new a.b(null).a(this.j).a(this.f).b();
            this.a.a("Music#isPlaying", localBoolean2);
            com.tencent.luggage.wxa.iu.c.b(this.j.getAppId(), this.b);
          }
        }
        else
        {
          o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
          new a.a(null).a(this.j).a(this.f).b();
        }
        o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.a.a("Music#isPlaying", localBoolean2);
        com.tencent.luggage.wxa.iu.c.b(this.j.getAppId(), this.b);
        return;
      }
      o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
      this.a.a("Music#isPlaying", localBoolean1);
      com.tencent.luggage.wxa.iu.c.a(this.j.getAppId(), this.b);
      return;
    }
    o.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
    new a.c(null).a(this.j).a(this.f).b();
    this.a.a("Music#isPlaying", localBoolean1);
    com.tencent.luggage.wxa.iu.c.a(this.j.getAppId(), this.b);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cb.a.d
 * JD-Core Version:    0.7.0.1
 */