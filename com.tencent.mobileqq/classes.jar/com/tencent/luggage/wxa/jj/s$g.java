package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s$g
  implements Parcelable
{
  public static final Parcelable.Creator<g> CREATOR = new s.g.1();
  public String a;
  public String b;
  public boolean c;
  public int d;
  public String[] e;
  public List<s.d> f;
  public String g;
  public List<s.h> h;
  private JSONObject i;
  
  public s$g() {}
  
  protected s$g(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = bool;
    this.d = paramParcel.readInt();
    this.e = paramParcel.createStringArray();
    this.f = paramParcel.createTypedArrayList(s.d.CREATOR);
    this.g = paramParcel.readString();
    this.h = paramParcel.createTypedArrayList(s.h.CREATOR);
  }
  
  public static List<g> a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    try
    {
      Object localObject = new JSONArray(paramString);
      if (((JSONArray)localObject).length() <= 0) {
        return null;
      }
      localObject = a((JSONArray)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      o.b("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, json = %s, e = %s", new Object[] { paramString, localJSONException });
    }
    return null;
  }
  
  @Nullable
  public static List<g> a(@Nullable JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    try
    {
      LinkedList localLinkedList = new LinkedList();
      int j = 0;
      while (j < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
        if (localJSONObject != null)
        {
          g localg = new g();
          localg.i = localJSONObject;
          localg.a = localJSONObject.getString("name");
          localg.b = localJSONObject.getString("md5");
          localg.d = localJSONObject.optInt("size", 0);
          localg.c = localJSONObject.optBoolean("independent", false);
          localg.e = a(localJSONObject);
          localg.g = localJSONObject.optString("without_lib_md5");
          localg.h = s.h.a(localJSONObject.optJSONArray("widget_list"));
          localg.f = s.d.a(localg.h, localJSONObject.opt("separated_plugin_list"), 23);
          localLinkedList.add(localg);
        }
        j += 1;
      }
      return localLinkedList;
    }
    catch (JSONException paramJSONArray)
    {
      o.b("MicroMsg.AppBrand.WxaAttributes.WxaVersionModuleInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
    }
    return null;
  }
  
  private static String[] a(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("alias");
    int j = 0;
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      String[] arrayOfString = new String[paramJSONObject.length()];
      while (j < paramJSONObject.length())
      {
        arrayOfString[j] = paramJSONObject.optString(j);
        j += 1;
      }
      return arrayOfString;
    }
    return new String[0];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s.g
 * JD-Core Version:    0.7.0.1
 */