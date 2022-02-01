package com.tencent.biz.qqcircle.flutter;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qflutter.qqcircle.IQQCircleMethod;
import com.tencent.biz.qqcircle.flutter.annotation.ChannelMethodName;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.Result;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class QQCircleMethodImpl
  implements IQQCircleMethod
{
  public static final String COMMENT_CLICK = "CommentClick";
  public static final String COMMENT_INPUT_CLICK = "CommentInputClick";
  public static final String PRAISE_CLICK = "PraiseClick";
  public static final String SHARE_CLICK = "ShareClick";
  public static final String TAG = "QQCircleMethodImpl";
  Map<String, Method> methodMap = new HashMap();
  
  private QQCircleMethodImpl()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = QQCircleMethodMine.class.getMethods();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.isAnnotationPresent(ChannelMethodName.class))
      {
        ChannelMethodName localChannelMethodName = (ChannelMethodName)localObject2.getAnnotation(ChannelMethodName.class);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[QQCircleMethodImpl] annotation name=");
          localStringBuilder.append(localChannelMethodName.a());
          QLog.d("QQCircleMethodImpl", 2, localStringBuilder.toString());
        }
        this.methodMap.put(localChannelMethodName.a(), localObject2);
      }
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[QQCircleMethodImpl] annotation cost=");
    ((StringBuilder)localObject1).append(l2 - l1);
    QLog.d("QQCircleMethodImpl", 1, ((StringBuilder)localObject1).toString());
  }
  
  public static QQCircleMethodImpl getInstance()
  {
    return QQCircleMethodImpl.SingleHolder.a;
  }
  
  public FeedCloudMeta.StFeed getCurrentFeed()
  {
    return QQCircleMethodMine.getCurrentFeed();
  }
  
  public void onMethodCall(@Nullable Context paramContext, @NonNull View paramView, @NonNull MethodCall paramMethodCall, @NonNull MethodChannel.Result paramResult)
  {
    String str = paramMethodCall.method;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onMethodCall] method=");
    localStringBuilder.append(paramMethodCall.method);
    localStringBuilder.append(", activity=");
    localStringBuilder.append(paramContext);
    QLog.d("QQCircleMethodImpl", 1, localStringBuilder.toString());
    try
    {
      if (this.methodMap.containsKey(str))
      {
        ((Method)this.methodMap.get(str)).invoke(null, new Object[] { paramContext, paramView, paramMethodCall, paramResult });
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("[onMethodCall] not implemented method: ");
      paramContext.append(str);
      QLog.w("QQCircleMethodImpl", 1, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("QQCircleMethodImpl", 1, "[onMethodCall]", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.QQCircleMethodImpl
 * JD-Core Version:    0.7.0.1
 */