package com.tencent.biz.pubaccount.weishi_new.follow.joinGroup;

import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.request.QQGroupDetailRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import org.jetbrains.annotations.NotNull;

public class WSJoinGroupDataProcessor
{
  private static volatile WSJoinGroupDataProcessor a;
  private String b;
  
  public static WSJoinGroupDataProcessor a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WSJoinGroupDataProcessor();
        }
      }
      finally {}
    }
    return a;
  }
  
  @NotNull
  private IWeishiServiceListener a(String paramString, WSJoinGroupDataProcessor.DataCallback paramDataCallback)
  {
    return new WSJoinGroupDataProcessor.1(this, paramDataCallback, paramString);
  }
  
  public void a(String paramString1, String paramString2, WSJoinGroupDataProcessor.DataCallback paramDataCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestGroupSign: UserConfig request  groupId = ");
    localStringBuilder.append(paramString1);
    WSLog.e("WSJoinGroupDataProcessor", localStringBuilder.toString());
    this.b = paramString1;
    if (paramDataCallback != null) {
      paramDataCallback.b();
    }
    paramString2 = new QQGroupDetailRequest(paramString1, paramString2);
    paramString2.d = paramString1;
    paramString1 = new WeishiTask(paramString2, null, a(paramString1, paramDataCallback), 4014);
    WeishiBusinessLooper.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.joinGroup.WSJoinGroupDataProcessor
 * JD-Core Version:    0.7.0.1
 */