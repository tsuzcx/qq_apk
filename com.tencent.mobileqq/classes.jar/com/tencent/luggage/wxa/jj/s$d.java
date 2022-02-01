package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.luggage.wxa.jj.s.h;>;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s$d
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new s.d.1();
  public String a;
  public int b;
  public String c;
  public String d;
  public boolean e;
  public List<Integer> f = new LinkedList();
  
  public s$d() {}
  
  protected s$d(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    int i = paramParcel.readByte();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.e = bool;
    if (this.f == null) {
      this.f = new LinkedList();
    }
    paramParcel.readList(this.f, Integer.class.getClassLoader());
  }
  
  @Nullable
  public static List<d> a(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if ((paramObject instanceof String))
        {
          paramObject = new JSONArray((String)paramObject);
        }
        else if ((paramObject instanceof JSONArray))
        {
          paramObject = (JSONArray)paramObject;
        }
        else
        {
          o.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "WxaPluginCodeInfo.optPluginCodeInfoList() invalid pluginCodeObj:%s", new Object[] { paramObject.getClass().getName() });
          paramObject = null;
        }
        if (paramObject != null)
        {
          if (paramObject.length() == 0) {
            return null;
          }
          LinkedList localLinkedList = new LinkedList();
          int i = 0;
          if (i < paramObject.length())
          {
            Object localObject = paramObject.getJSONObject(i);
            if (localObject != null)
            {
              d locald = new d();
              locald.a = ((JSONObject)localObject).optString("plugin_id");
              locald.b = ((JSONObject)localObject).optInt("inner_version");
              locald.c = ((JSONObject)localObject).optString("md5");
              locald.d = ((JSONObject)localObject).optString("prefix_path");
              if (((JSONObject)localObject).optBoolean("auto_update")) {
                break label321;
              }
              if (((JSONObject)localObject).optInt("auto_update", 0) > 0)
              {
                break label321;
                locald.e = bool;
                localObject = ((JSONObject)localObject).optJSONArray("contexts");
                if (localObject != null)
                {
                  if (((JSONArray)localObject).length() > 0) {
                    break label326;
                  }
                  continue;
                  if (j >= ((JSONArray)localObject).length()) {
                    continue;
                  }
                  locald.f.add(Integer.valueOf(((JSONArray)localObject).optInt(j)));
                  j += 1;
                  continue;
                }
                locald.f.add(Integer.valueOf(0));
                localLinkedList.add(locald);
              }
            }
            else
            {
              i += 1;
            }
          }
          else
          {
            return localLinkedList;
          }
        }
        else
        {
          return null;
        }
      }
      catch (JSONException paramObject)
      {
        o.b("MicroMsg.AppBrand.WxaAttributes.WxaPluginCodeInfo", "parse json array, e = %s", new Object[] { paramObject });
        return null;
      }
      boolean bool = false;
      continue;
      label321:
      bool = true;
      continue;
      label326:
      int j = 0;
    }
  }
  
  public static List<d> a(List<s.h> paramList, Object paramObject, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = localObject2;
      for (;;)
      {
        localObject1 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (s.h)localIterator.next();
        if (((s.h)localObject1).a == paramInt) {
          paramList = ((s.h)localObject1).c;
        }
      }
    }
    paramList = (List<s.h>)localObject1;
    if (localObject1 == null) {
      paramList = a(paramObject);
    }
    return paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeList(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.s.d
 * JD-Core Version:    0.7.0.1
 */