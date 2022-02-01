import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCodec;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.List;
import java.util.Map;

public abstract class atis
  implements MethodChannel.MethodCallHandler
{
  public static final MethodCodec a = StandardMethodCodec.INSTANCE;
  
  protected abstract List<String> a(String paramString, int paramInt);
  
  protected abstract void a(int paramInt1, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean);
  
  protected abstract void a(MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString);
  
  protected abstract void a(String paramString, int paramInt);
  
  protected abstract void a(String paramString, MethodChannel.Result paramResult);
  
  protected abstract void a(String paramString1, String paramString2);
  
  protected abstract void a(String paramString1, String paramString2, String paramString3);
  
  protected abstract void a(String paramString, List<String> paramList, int paramInt, long paramLong);
  
  protected abstract void a(String paramString, byte[] paramArrayOfByte, MethodChannel.Result paramResult);
  
  protected abstract void a(Map<String, String> paramMap, MethodChannel.Result paramResult);
  
  protected abstract void b(String paramString1, String paramString2);
  
  public void onMethodCall(@NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    int i = 0;
    String str = paramMethodCall.method;
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall] method=" + str);
    }
    if ("sendSsoRequest".equals(str)) {
      a((String)paramMethodCall.argument("cmd"), (byte[])paramMethodCall.argument("body"), paramResult);
    }
    do
    {
      return;
      if ("openHomepage".equals(str))
      {
        a((String)paramMethodCall.argument("pb_id"));
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("openTagpage".equals(str))
      {
        a((String)paramMethodCall.argument("tagID"), (String)paramMethodCall.argument("tagName"));
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("openDetailpage".equals(str))
      {
        a((String)paramMethodCall.argument("feedID"), (String)paramMethodCall.argument("userID"), (String)paramMethodCall.argument("createTime"));
        paramResult.success(Integer.valueOf(0));
        return;
      }
      if ("changeFollowState".equals(str))
      {
        b((String)paramMethodCall.argument("userId"), (String)paramMethodCall.argument("followState"));
        paramResult.success(Integer.valueOf(0));
        return;
      }
      int j;
      boolean bool;
      if ("reportReadOp".equals(str)) {
        try
        {
          i = ((Integer)paramMethodCall.argument("action")).intValue();
          j = ((Integer)paramMethodCall.argument("secondAction")).intValue();
          int k = ((Integer)paramMethodCall.argument("thirdAction")).intValue();
          paramResult = (Map)paramMethodCall.argument("extInfo");
          bool = ((Boolean)paramMethodCall.argument("immediately")).booleanValue();
          if (QLog.isColorLevel()) {
            QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall]reportReadOp action=" + i + ", subAction=" + j + ", thirdAction=" + k + ", map=" + paramResult);
          }
          a(i, j, k, paramResult, bool);
          return;
        }
        catch (Exception paramMethodCall)
        {
          QLog.w("flutter.QQCircleChannelHandler", 1, "[onMethodCall] ", paramMethodCall);
          return;
        }
      }
      if ("checkNetworkReachability".equals(str))
      {
        bool = NetworkUtil.isNetworkAvailable();
        if (QLog.isColorLevel()) {
          QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall]checkNetworkReachability, network available=" + bool);
        }
        paramResult.success(Boolean.valueOf(bool));
        return;
      }
      if ("loadNoNetImgs".equals(str))
      {
        a(paramResult);
        return;
      }
      long l1;
      if ("cacheData".equals(str))
      {
        str = (String)paramMethodCall.argument("key");
        try
        {
          i = ((Integer)paramMethodCall.argument("type")).intValue();
          List localList = (List)paramMethodCall.argument("value");
          l1 = -1L;
          try
          {
            long l2 = ((Long)paramMethodCall.argument("expireTime")).longValue();
            l1 = l2;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              QLog.w("flutter.QQCircleChannelHandler", 1, "[onMethodCall] ", localException2);
            }
            a(str, localException1, i, l1);
            paramResult.success(Integer.valueOf(0));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall]cacheData, key=" + str + ", type=" + i + ", value=" + paramMethodCall.argument("value") + ", expireTime=" + l1);
          }
          if ((localList == null) || (localList.isEmpty()))
          {
            QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall]cacheData, invalid value");
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QLog.w("flutter.QQCircleChannelHandler", 1, "[onMethodCall] ", localException1);
            i = 0;
          }
        }
      }
      if ("asyncGetValue".equals(str))
      {
        str = (String)paramMethodCall.argument("key");
        try
        {
          j = ((Integer)paramMethodCall.argument("type")).intValue();
          i = j;
        }
        catch (Exception paramMethodCall)
        {
          for (;;)
          {
            QLog.w("flutter.QQCircleChannelHandler", 1, "[onMethodCall] ", paramMethodCall);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall]asyncGetValue, key=" + str + ", type=" + i);
        }
        if (TextUtils.isEmpty(str))
        {
          QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] invalid key");
          paramResult.success(null);
        }
        paramMethodCall = a(str, i);
        if (QLog.isColorLevel()) {
          QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall] list=" + paramMethodCall);
        }
        paramResult.success(paramMethodCall);
        return;
      }
      if ("removeCache".equals(str))
      {
        str = (String)paramMethodCall.argument("key");
        try
        {
          i = ((Integer)paramMethodCall.argument("type")).intValue();
          if (QLog.isColorLevel()) {
            QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall] key=" + str + ", type=" + i);
          }
          if (TextUtils.isEmpty(str)) {
            QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] invalid key");
          }
          a(str, i);
          paramResult.success(Integer.valueOf(0));
          return;
        }
        catch (Exception paramMethodCall)
        {
          for (;;)
          {
            QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] ", paramMethodCall);
            i = 0;
          }
        }
      }
      if ("parseText".equals(str)) {
        try
        {
          paramMethodCall = (String)paramMethodCall.argument("content");
          if (QLog.isColorLevel()) {
            QLog.d("flutter.QQCircleChannelHandler", 2, "[onMethodCall] parseText content=" + paramMethodCall);
          }
          if (TextUtils.isEmpty(paramMethodCall)) {
            QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] parseText invalid key");
          }
          a(paramMethodCall, paramResult);
          return;
        }
        catch (Exception paramMethodCall)
        {
          QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] parseText ", paramMethodCall);
          return;
        }
      }
    } while (!"parseTextBatch".equals(str));
    try
    {
      a((Map)paramMethodCall.argument("contentMap"), paramResult);
      return;
    }
    catch (Exception paramMethodCall)
    {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[onMethodCall] parseTextBatch ", paramMethodCall);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atis
 * JD-Core Version:    0.7.0.1
 */