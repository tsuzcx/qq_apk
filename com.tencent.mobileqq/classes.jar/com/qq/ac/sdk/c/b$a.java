package com.qq.ac.sdk.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.ac.sdk.bean.BaseResponse;
import com.qq.ac.sdk.listener.BaseInfoListener;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$a
  implements BaseInfoListener
{
  private int a;
  
  public b$a(b paramb) {}
  
  public final void a(Integer paramInteger)
  {
    this.a = paramInteger.intValue();
  }
  
  public final void onFailure(int paramInt)
  {
    BaseInfoListener localBaseInfoListener = (BaseInfoListener)this.b.a.get(this.a);
    if (localBaseInfoListener == null)
    {
      com.qq.ac.sdk.g.b.b("DataInfoImplProxy", "baseInfoListener BaseInfoListener is null mType = " + this.a);
      return;
    }
    localBaseInfoListener.onFailure(-60001);
    this.b.a.remove(this.a);
  }
  
  public final void onResponse(String paramString)
  {
    BaseInfoListener localBaseInfoListener = (BaseInfoListener)this.b.a.get(this.a);
    if (localBaseInfoListener == null)
    {
      com.qq.ac.sdk.g.b.b("DataInfoImplProxy", "baseInfoListener BaseInfoListener is null mType = " + this.a);
      return;
    }
    com.qq.ac.sdk.g.b.a("DataInfoImplProxy", "onResponse response = " + paramString);
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        i = new JSONObject(paramString).getInt("ret");
        if (i != 0) {
          continue;
        }
        paramString = com.b.a.b.a.a(paramString);
        com.qq.ac.sdk.g.b.a("DataInfoImplProxy", "onResponse result = " + paramString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localBaseInfoListener.onResponse(paramString);
      }
      catch (JSONException paramString)
      {
        int i;
        localBaseInfoListener.onFailure(-60005);
        continue;
        localBaseInfoListener.onFailure(i);
        continue;
      }
      this.b.a.remove(this.a);
      return;
      localBaseInfoListener.onFailure(-60003);
      continue;
      localBaseInfoListener.onFailure(-60004);
    }
  }
  
  public final BaseResponse onSyncResponse(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.ac.sdk.c.b.a
 * JD-Core Version:    0.7.0.1
 */