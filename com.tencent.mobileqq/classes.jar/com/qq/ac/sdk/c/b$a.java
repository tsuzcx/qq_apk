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
    Object localObject = (BaseInfoListener)this.b.a.get(this.a);
    if (localObject == null)
    {
      localObject = new StringBuilder("baseInfoListener BaseInfoListener is null mType = ");
      ((StringBuilder)localObject).append(this.a);
      com.qq.ac.sdk.g.b.b("DataInfoImplProxy", ((StringBuilder)localObject).toString());
      return;
    }
    ((BaseInfoListener)localObject).onFailure(-60001);
    this.b.a.remove(this.a);
  }
  
  public final void onResponse(String paramString)
  {
    BaseInfoListener localBaseInfoListener = (BaseInfoListener)this.b.a.get(this.a);
    if (localBaseInfoListener == null)
    {
      paramString = new StringBuilder("baseInfoListener BaseInfoListener is null mType = ");
      paramString.append(this.a);
      com.qq.ac.sdk.g.b.b("DataInfoImplProxy", paramString.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("onResponse response = ");
    localStringBuilder.append(paramString);
    com.qq.ac.sdk.g.b.a("DataInfoImplProxy", localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = new JSONObject(paramString).getInt("ret");
      if (i == 0)
      {
        paramString = com.b.a.b.a.a(paramString);
        localStringBuilder = new StringBuilder("onResponse result = ");
        localStringBuilder.append(paramString);
        com.qq.ac.sdk.g.b.a("DataInfoImplProxy", localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramString)) {
          localBaseInfoListener.onResponse(paramString);
        } else {
          localBaseInfoListener.onFailure(-60003);
        }
      }
      else
      {
        localBaseInfoListener.onFailure(i);
      }
    }
    catch (JSONException paramString)
    {
      int i;
      label175:
      label184:
      break label175;
    }
    i = -60005;
    break label184;
    i = -60004;
    localBaseInfoListener.onFailure(i);
    this.b.a.remove(this.a);
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