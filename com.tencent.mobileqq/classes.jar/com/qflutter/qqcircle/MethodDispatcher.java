package com.qflutter.qqcircle;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.List;
import java.util.Map;

final class MethodDispatcher
{
  public static final String TAG = "MethodDispatcher";
  private IQQCircleMethod methodBridge;
  
  public static MethodDispatcher getInstance()
  {
    return MethodDispatcher.SingleHolder.INSTANCE;
  }
  
  public void dispatch(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int i = 0;
    Object localObject1 = paramMethodCall.method;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onMethodCall] method=");
    ((StringBuilder)localObject2).append(paramMethodCall.method);
    PLog.d("MethodDispatcher", ((StringBuilder)localObject2).toString());
    if (this.methodBridge == null) {
      PLog.e("MethodDispatcher", "[onMethodCall] invalid methodBridge");
    }
    do
    {
      return;
      if ("sendSsoRequest".equals(paramMethodCall.method))
      {
        localObject1 = (String)paramMethodCall.argument("cmd");
        paramMethodCall = (byte[])paramMethodCall.argument("body");
        this.methodBridge.sendSsoRequest((String)localObject1, paramMethodCall, paramResult);
        return;
      }
      if ("openHomepage".equals(localObject1))
      {
        paramMethodCall = (String)paramMethodCall.argument("pb_id");
        this.methodBridge.gotoMainPage(paramMethodCall);
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("openTagpage".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("tagID");
        paramMethodCall = (String)paramMethodCall.argument("tagName");
        this.methodBridge.openTagPage((String)localObject1, paramMethodCall);
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("openDetailpage".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("feedID");
        localObject2 = (String)paramMethodCall.argument("userID");
        paramMethodCall = (String)paramMethodCall.argument("createTime");
        this.methodBridge.openDetailPage((String)localObject1, (String)localObject2, paramMethodCall);
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("changeFollowState".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("userId");
        paramMethodCall = (String)paramMethodCall.argument("followState");
        this.methodBridge.changeFollowState((String)localObject1, paramMethodCall);
        paramResult.success(Integer.valueOf(0));
        return;
      }
      int j;
      boolean bool;
      if ("reportReadOp".equals(localObject1)) {
        try
        {
          i = ((Integer)paramMethodCall.argument("action")).intValue();
          j = ((Integer)paramMethodCall.argument("secondAction")).intValue();
          int k = ((Integer)paramMethodCall.argument("thirdAction")).intValue();
          localObject1 = (Map)paramMethodCall.argument("extInfo");
          bool = ((Boolean)paramMethodCall.argument("immediately")).booleanValue();
          if (PLog.isColorLevel())
          {
            paramMethodCall = new StringBuilder();
            paramMethodCall.append("[onMethodCall]reportReadOp action=");
            paramMethodCall.append(i);
            paramMethodCall.append(", subAction=");
            paramMethodCall.append(j);
            paramMethodCall.append(", thirdAction=");
            paramMethodCall.append(k);
            paramMethodCall.append(", map=");
            paramMethodCall.append(localObject1);
            PLog.d("MethodDispatcher", paramMethodCall.toString());
          }
          this.methodBridge.reportDC05504(i, j, k, (Map)localObject1, bool);
          paramResult.success(Integer.valueOf(0));
          return;
        }
        catch (Exception paramMethodCall)
        {
          PLog.w("MethodDispatcher", "[onMethodCall] ", paramMethodCall);
          return;
        }
      }
      if ("checkNetworkReachability".equals(localObject1))
      {
        bool = AppNetConnInfo.isNetSupport();
        if (PLog.isColorLevel())
        {
          paramMethodCall = new StringBuilder();
          paramMethodCall.append("[onMethodCall]checkNetworkReachability, network available=");
          paramMethodCall.append(bool);
          PLog.d("MethodDispatcher", paramMethodCall.toString());
        }
        paramResult.success(Boolean.valueOf(bool));
        return;
      }
      if ("loadNoNetImgs".equals(localObject1))
      {
        this.methodBridge.loadNoNetworkImage(paramResult);
        return;
      }
      if ("cacheData".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("key");
        try
        {
          i = ((Integer)paramMethodCall.argument("type")).intValue();
          localObject2 = (List)paramMethodCall.argument("value");
        }
        catch (Exception localException1)
        {
          try
          {
            l = ((Long)paramMethodCall.argument("expireTime")).longValue();
            if (PLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("[onMethodCall]cacheData, key=");
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(", type=");
              localStringBuilder.append(i);
              localStringBuilder.append(", value=");
              localStringBuilder.append(paramMethodCall.argument("value"));
              localStringBuilder.append(", expireTime=");
              localStringBuilder.append(l);
              PLog.d("MethodDispatcher", localStringBuilder.toString());
            }
            if ((localObject2 == null) || (((List)localObject2).isEmpty()))
            {
              PLog.e("MethodDispatcher", "[onMethodCall]cacheData, invalid value");
              return;
              localException1 = localException1;
              PLog.w("MethodDispatcher", "[onMethodCall] ", localException1);
              i = 0;
            }
          }
          catch (Exception localException2)
          {
            long l;
            for (;;)
            {
              PLog.w("MethodDispatcher", "[onMethodCall] ", localException2);
              l = -1L;
            }
            this.methodBridge.saveCache((String)localObject1, localException1, i, l);
            paramResult.success(Integer.valueOf(0));
            return;
          }
        }
      }
      if ("asyncGetValue".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("key");
        try
        {
          j = ((Integer)paramMethodCall.argument("type")).intValue();
          i = j;
        }
        catch (Exception paramMethodCall)
        {
          for (;;)
          {
            PLog.w("MethodDispatcher", "[onMethodCall] ", paramMethodCall);
          }
        }
        if (PLog.isColorLevel())
        {
          paramMethodCall = new StringBuilder();
          paramMethodCall.append("[onMethodCall]asyncGetValue, key=");
          paramMethodCall.append((String)localObject1);
          paramMethodCall.append(", type=");
          paramMethodCall.append(i);
          PLog.d("MethodDispatcher", paramMethodCall.toString());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          PLog.e("MethodDispatcher", "[onMethodCall] invalid key");
          paramResult.success(null);
        }
        paramMethodCall = this.methodBridge.getCache((String)localObject1, i);
        if (PLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[onMethodCall] list=");
          ((StringBuilder)localObject1).append(paramMethodCall);
          PLog.d("MethodDispatcher", ((StringBuilder)localObject1).toString());
        }
        paramResult.success(paramMethodCall);
        return;
      }
      if ("removeCache".equals(localObject1))
      {
        localObject1 = (String)paramMethodCall.argument("key");
        try
        {
          i = ((Integer)paramMethodCall.argument("type")).intValue();
          if (PLog.isColorLevel())
          {
            paramMethodCall = new StringBuilder();
            paramMethodCall.append("[onMethodCall] key=");
            paramMethodCall.append((String)localObject1);
            paramMethodCall.append(", type=");
            paramMethodCall.append(i);
            PLog.d("MethodDispatcher", paramMethodCall.toString());
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            PLog.e("MethodDispatcher", "[onMethodCall] invalid key");
          }
          this.methodBridge.clearCache((String)localObject1, i);
          paramResult.success(Integer.valueOf(0));
          return;
        }
        catch (Exception paramMethodCall)
        {
          for (;;)
          {
            PLog.e("MethodDispatcher", "[onMethodCall] ", paramMethodCall);
            i = 0;
          }
        }
      }
      if ("parseText".equals(localObject1)) {
        try
        {
          paramMethodCall = (String)paramMethodCall.argument("content");
          if (PLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[onMethodCall] parseText content=");
            ((StringBuilder)localObject1).append(paramMethodCall);
            PLog.d("MethodDispatcher", ((StringBuilder)localObject1).toString());
          }
          if (TextUtils.isEmpty(paramMethodCall)) {
            PLog.e("MethodDispatcher", "[onMethodCall] parseText invalid key");
          }
          this.methodBridge.parseText(paramMethodCall, paramResult);
          return;
        }
        catch (Exception paramMethodCall)
        {
          PLog.e("MethodDispatcher", "[onMethodCall] parseText ", paramMethodCall);
          return;
        }
      }
    } while (!"parseTextBatch".equals(localObject1));
    try
    {
      paramMethodCall = (Map)paramMethodCall.argument("contentMap");
      this.methodBridge.parseTextBatch(paramMethodCall, paramResult);
      return;
    }
    catch (Exception paramMethodCall)
    {
      PLog.e("MethodDispatcher", "[onMethodCall] parseTextBatch ", paramMethodCall);
    }
  }
  
  public void setMethodBridge(IQQCircleMethod paramIQQCircleMethod)
  {
    this.methodBridge = paramIQQCircleMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqcircle.MethodDispatcher
 * JD-Core Version:    0.7.0.1
 */