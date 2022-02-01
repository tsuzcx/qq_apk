package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class r
  implements s
{
  public List<q> a;
  public o b;
  public p c;
  public s d;
  public String e = "";
  public String f;
  
  public r(String paramString)
  {
    this.f = paramString;
  }
  
  public JSONObject a()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
      if ((this.b != null) && (this.c != null) && (this.d != null))
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("header", this.b.a());
        localObject2 = new JSONObject();
        localObject3 = this.d.a();
        ((JSONObject)localObject3).put("properties", this.c.a());
      }
    }
    try
    {
      ((JSONObject)localObject3).put("events_global_properties", new JSONObject(this.e));
    }
    catch (JSONException localJSONException)
    {
      label124:
      Iterator localIterator;
      break label124;
    }
    ((JSONObject)localObject3).put("events_global_properties", this.e);
    ((JSONObject)localObject2).put("events_common", localObject3);
    Object localObject3 = new JSONArray();
    localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      JSONObject localJSONObject = ((q)localIterator.next()).a();
      if (localJSONObject != null) {
        ((JSONArray)localObject3).put(localJSONObject);
      } else {
        y.e("hmsSdk", "custom event is empty,delete this event");
      }
    }
    ((JSONObject)localObject2).put("events", localObject3);
    Object localObject2 = ((JSONObject)localObject2).toString();
    try
    {
      localObject2 = HexUtil.byteArray2HexStr(AesCbc.encrypt(r0.a(((String)localObject2).getBytes("UTF-8")), HexUtil.hexStr2ByteArray(this.f)));
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        y.e("hmsSdk", "eventInfo encrypt failed,report over!");
        return null;
      }
      ((JSONObject)localObject1).put("event", localObject2);
      return localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label274:
      break label274;
    }
    localObject1 = "getBitZip(): Unsupported coding : utf-8";
    for (;;)
    {
      y.e("hmsSdk", (String)localObject1);
      return null;
      localObject1 = "model in wrong format";
      continue;
      localObject1 = "Not have actionEvent to send";
    }
  }
  
  public void a(c1 paramc1)
  {
    this.d = paramc1;
  }
  
  public void a(o paramo)
  {
    this.b = paramo;
  }
  
  public void a(p paramp)
  {
    this.c = paramp;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.e = paramString;
    }
  }
  
  public void a(List<q> paramList)
  {
    this.a = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.r
 * JD-Core Version:    0.7.0.1
 */