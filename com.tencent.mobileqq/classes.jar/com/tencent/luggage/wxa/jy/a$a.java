package com.tencent.luggage.wxa.jy;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a$a
  extends com.tencent.mm.plugin.appbrand.ipc.b
{
  public static final Parcelable.Creator<a> CREATOR = new a.a.1();
  private m a;
  private h b;
  private int c;
  private String d;
  private String e;
  private JSONArray f;
  private boolean g;
  private String h;
  private boolean i;
  
  public a$a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public a$a(m paramm, h paramh, int paramInt, JSONObject paramJSONObject)
  {
    h();
    this.a = paramm;
    this.b = paramh;
    this.c = paramInt;
    this.d = paramJSONObject.optString("packageName");
    paramm = paramJSONObject.optJSONArray("packageNameArray");
    if (paramm != null) {
      this.e = paramm.toString();
    }
    this.i = true;
  }
  
  private void c()
  {
    if (!af.c(this.e))
    {
      j();
      return;
    }
    PackageInfo localPackageInfo = com.tencent.luggage.wxa.pc.b.a(r.a(), this.d);
    int j;
    if (localPackageInfo == null) {
      j = 0;
    } else {
      j = localPackageInfo.versionCode;
    }
    String str;
    if (localPackageInfo == null) {
      str = "null";
    } else {
      str = localPackageInfo.versionName;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doGetInstallState, packageName = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", packageInfo = ");
    localStringBuilder.append(localPackageInfo);
    localStringBuilder.append(", version = ");
    localStringBuilder.append(j);
    localStringBuilder.append(", versionName = ");
    localStringBuilder.append(str);
    o.d("MicroMsg.JsApiGetInstallState", localStringBuilder.toString());
    if (localPackageInfo == null)
    {
      this.g = false;
    }
    else
    {
      this.h = str;
      this.g = true;
    }
    this.i = false;
  }
  
  private void j()
  {
    for (;;)
    {
      int j;
      Object localObject;
      try
      {
        JSONArray localJSONArray = new JSONArray(this.e);
        this.f = new JSONArray();
        j = 0;
        if (j < localJSONArray.length())
        {
          String str3 = localJSONArray.optString(j);
          localObject = com.tencent.luggage.wxa.pc.b.a(r.a(), str3);
          int k;
          if (localObject == null)
          {
            k = 0;
          }
          else
          {
            k = ((PackageInfo)localObject).versionCode;
            break label276;
            String str1 = ((PackageInfo)localObject).versionName;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getInstallState, packageName = ");
            localStringBuilder.append(str3);
            localStringBuilder.append(", packageInfo = ");
            localStringBuilder.append(localObject);
            localStringBuilder.append(", version = ");
            localStringBuilder.append(k);
            localStringBuilder.append(", versionName = ");
            localStringBuilder.append(str1);
            o.d("MicroMsg.JsApiGetInstallState", localStringBuilder.toString());
            boolean bool;
            if (localObject != null) {
              bool = true;
            } else {
              bool = false;
            }
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("packageName", str3);
              ((JSONObject)localObject).put("isInstalled", bool);
              if (bool)
              {
                ((JSONObject)localObject).put("versionCode", k);
                ((JSONObject)localObject).put("versionName", str1);
              }
              this.f.put(localObject);
            }
            catch (JSONException localJSONException1)
            {
              o.d("MicroMsg.JsApiGetInstallState", localJSONException1.getMessage());
            }
          }
        }
        else
        {
          this.i = false;
          return;
        }
      }
      catch (JSONException localJSONException2)
      {
        o.b("MicroMsg.JsApiGetInstallState", localJSONException2.getMessage());
        this.i = true;
        return;
      }
      label276:
      if (localObject == null)
      {
        String str2 = "null";
        continue;
        j += 1;
      }
    }
  }
  
  public void a()
  {
    c();
    e();
  }
  
  public void a(Parcel paramParcel)
  {
    this.d = paramParcel.readString();
    this.e = paramParcel.readString();
    int j = paramParcel.readInt();
    boolean bool2 = false;
    if (j == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.g = bool1;
    this.h = paramParcel.readString();
    paramParcel = paramParcel.readString();
    if (paramParcel != null) {
      try
      {
        this.f = new JSONArray(paramParcel);
        return;
      }
      catch (JSONException paramParcel)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFromParcel: ");
        localStringBuilder.append(paramParcel.getMessage());
        o.b("MicroMsg.JsApiGetInstallState", localStringBuilder.toString());
      }
    }
  }
  
  public void b()
  {
    boolean bool = true;
    if (this.b != null) {
      bool = false;
    }
    o.e("MicroMsg.JsApiGetInstallState", "callback, service is null: %b", new Object[] { Boolean.valueOf(bool) });
    i();
    if (this.i)
    {
      this.b.a(this.c, this.a.b("fail"));
      return;
    }
    HashMap localHashMap = new HashMap();
    JSONArray localJSONArray = this.f;
    if (localJSONArray != null)
    {
      localHashMap.put("result", localJSONArray);
    }
    else
    {
      localHashMap.put("versionName", this.h);
      localHashMap.put("isInstalled", Boolean.valueOf(this.g));
    }
    this.b.a(this.c, this.a.a("ok", localHashMap));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jy.a.a
 * JD-Core Version:    0.7.0.1
 */