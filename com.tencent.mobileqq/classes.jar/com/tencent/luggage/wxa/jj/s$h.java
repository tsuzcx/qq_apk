package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ru.a;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s$h
  implements Parcelable
{
  public static final Parcelable.Creator<h> CREATOR = new s.h.1();
  public int a;
  public String b;
  public List<s.d> c;
  
  public s$h() {}
  
  protected s$h(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(s.d.CREATOR);
  }
  
  @Nullable
  public static List<h> a(@Nullable String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    try
    {
      paramString = a(new JSONArray(paramString));
      return paramString;
    }
    catch (JSONException paramString)
    {
      o.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramString });
    }
    return null;
  }
  
  @Nullable
  public static List<h> a(@Nullable JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      try
      {
        if (paramJSONArray.length() <= 0) {
          return null;
        }
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            h localh = new h();
            localh.a = localJSONObject.optInt("package_type");
            localh.b = localJSONObject.optString("wxapkg_md5");
            if (ArrayUtils.contains(a.b, localh.a))
            {
              localh.c = s.d.a(localJSONObject.opt("separated_plugin_list"));
              localLinkedList.add(localh);
            }
          }
          i += 1;
        }
        return localLinkedList;
      }
      catch (JSONException paramJSONArray)
      {
        o.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramJSONArray });
      }
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s.h
 * JD-Core Version:    0.7.0.1
 */