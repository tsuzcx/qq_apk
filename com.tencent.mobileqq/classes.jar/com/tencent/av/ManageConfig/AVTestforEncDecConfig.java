package com.tencent.av.ManageConfig;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.av.mediacodec.config.CodecConfigUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class AVTestforEncDecConfig
  extends QAVConfigBase<AVTestforEncDecConfig.Item>
{
  public AVTestforEncDecConfig()
  {
    super(431);
  }
  
  static AVTestforEncDecConfig.TestInfo a(CodecTestInfo.TestInfos paramTestInfos)
  {
    int j = paramTestInfos.b;
    int i = 4;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramTestInfos.c;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel())
      {
        paramTestInfos = new StringBuilder();
        paramTestInfos.append("min_sdk不合法, codec[");
        paramTestInfos.append(j);
        paramTestInfos.append("], min_sdk[");
        paramTestInfos.append(k);
        paramTestInfos.append("]");
        QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
      }
      return null;
    }
    int m = paramTestInfos.d;
    if (m < 0)
    {
      if (QLog.isDevelopLevel())
      {
        paramTestInfos = new StringBuilder();
        paramTestInfos.append("async_min_sdk不合法, codec[");
        paramTestInfos.append(j);
        paramTestInfos.append("], async_min_sdk[");
        paramTestInfos.append(m);
        paramTestInfos.append("]");
        QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
      }
      return null;
    }
    String str = paramTestInfos.a;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel())
      {
        paramTestInfos = new StringBuilder();
        paramTestInfos.append("min_version不合法, codec[");
        paramTestInfos.append(j);
        paramTestInfos.append("], min_version[");
        paramTestInfos.append(str);
        paramTestInfos.append("]");
        QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
      }
      return null;
    }
    int n = paramTestInfos.g;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel())
      {
        paramTestInfos = new StringBuilder();
        paramTestInfos.append("test_ver不合法, codec[");
        paramTestInfos.append(j);
        paramTestInfos.append("], test_ver[");
        paramTestInfos.append(n);
        paramTestInfos.append("]");
        QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
      }
      return null;
    }
    if ((paramTestInfos.h != null) && (paramTestInfos.h.size() != 0)) {}
    try
    {
      localObject1 = paramTestInfos.i;
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject2).parse((String)localObject1).getTime();
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      long l;
      label381:
      HashMap localHashMap;
      break label381;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("没有过期时间, codec[");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("], expdate[");
    ((StringBuilder)localObject1).append(paramTestInfos.i);
    ((StringBuilder)localObject1).append("]");
    QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject1).toString());
    l = 0L;
    localHashMap = new HashMap();
    localObject1 = paramTestInfos.h.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CodecTestInfo.TestInfos.Samples)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).e)) {
        for (;;)
        {
          if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).d))
          {
            if ((j != 1) && (j != i))
            {
              if (((j != 2) && (j != 8)) || ((((CodecTestInfo.TestInfos.Samples)localObject2).a != 0) && (((CodecTestInfo.TestInfos.Samples)localObject2).b != 0))) {
                break label660;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("w/h 为空, codec[");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append("]");
              QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject2).toString());
            }
            else
            {
              if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).c)) {
                break label660;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("exp 为空, codec[");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append("]");
              QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject2).toString());
            }
            i = 4;
            break;
            label660:
            AVTestforEncDecConfig.Sample localSample = new AVTestforEncDecConfig.Sample();
            localSample.b = ((CodecTestInfo.TestInfos.Samples)localObject2).d;
            localSample.c = ((CodecTestInfo.TestInfos.Samples)localObject2).c;
            localSample.a = ((CodecTestInfo.TestInfos.Samples)localObject2).e;
            localSample.d = ((CodecTestInfo.TestInfos.Samples)localObject2).a;
            localSample.e = ((CodecTestInfo.TestInfos.Samples)localObject2).b;
            localSample.f = paramTestInfos.e;
            localHashMap.put(((CodecTestInfo.TestInfos.Samples)localObject2).e, localSample);
            i = 4;
          }
        }
      }
    }
    if (localHashMap.size() == 0)
    {
      if (QLog.isDevelopLevel())
      {
        paramTestInfos = new StringBuilder();
        paramTestInfos.append("样本不够, codec[");
        paramTestInfos.append(j);
        paramTestInfos.append("]");
        QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
      }
      return null;
    }
    if ((paramTestInfos.f != null) && (paramTestInfos.f.size() > 0))
    {
      i = 0;
      localObject1 = null;
      while (i < paramTestInfos.f.size())
      {
        int i1 = ((Integer)paramTestInfos.f.get(i)).intValue();
        if (i1 > 0)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(Integer.valueOf(i1));
          localObject1 = localObject2;
        }
        i += 1;
      }
    }
    else
    {
      localObject1 = null;
    }
    localObject2 = new AVTestforEncDecConfig.TestInfo();
    ((AVTestforEncDecConfig.TestInfo)localObject2).h = localHashMap;
    ((AVTestforEncDecConfig.TestInfo)localObject2).d = ((ArrayList)localObject1);
    ((AVTestforEncDecConfig.TestInfo)localObject2).c = k;
    ((AVTestforEncDecConfig.TestInfo)localObject2).e = m;
    ((AVTestforEncDecConfig.TestInfo)localObject2).b = j;
    ((AVTestforEncDecConfig.TestInfo)localObject2).f = str;
    ((AVTestforEncDecConfig.TestInfo)localObject2).g = n;
    ((AVTestforEncDecConfig.TestInfo)localObject2).i = paramTestInfos.e;
    ((AVTestforEncDecConfig.TestInfo)localObject2).j = l;
    return localObject2;
    if (QLog.isDevelopLevel())
    {
      paramTestInfos = new StringBuilder();
      paramTestInfos.append("没有样本, codec[");
      paramTestInfos.append(j);
      paramTestInfos.append("]");
      QLog.w("QAVConfig_431", 1, paramTestInfos.toString());
    }
    return null;
  }
  
  public static AVTestforEncDecConfig.TestInfo b(int paramInt)
  {
    Object localObject = (AVTestforEncDecConfig.Item)QConfigManager.b().b(431);
    if (((AVTestforEncDecConfig.Item)localObject).a == null) {
      return null;
    }
    AVTestforEncDecConfig.TestInfo localTestInfo = (AVTestforEncDecConfig.TestInfo)((AVTestforEncDecConfig.Item)localObject).a.get(Integer.valueOf(paramInt));
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadTestInfo, content[");
      if (localTestInfo != null) {
        localObject = localTestInfo.toString();
      } else {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("]");
      QLog.w("QAVConfig_431", 1, localStringBuilder.toString());
    }
    return localTestInfo;
  }
  
  @NonNull
  public AVTestforEncDecConfig.Item a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("migrateOldOrDefaultContent, type[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w("QAVConfig_431", 1, localStringBuilder.toString());
    }
    return new AVTestforEncDecConfig.Item();
  }
  
  @Nullable
  protected AVTestforEncDecConfig.Item a(QConfItem[] paramArrayOfQConfItem)
  {
    AVTestforEncDecConfig.Item localItem = new AVTestforEncDecConfig.Item();
    int j = paramArrayOfQConfItem.length;
    int i = 0;
    while (i < j)
    {
      QConfItem localQConfItem = paramArrayOfQConfItem[i];
      Object localObject1 = CodecTestInfo.a(localQConfItem.b);
      boolean bool;
      if ((localObject1 != null) && (((CodecTestInfo)localObject1).a != null)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject2;
      if (AudioHelper.e())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parsed, taskId[");
        ((StringBuilder)localObject2).append(localQConfItem.a);
        ((StringBuilder)localObject2).append("], suc[");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("], oldVersion[");
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("], content[");
        ((StringBuilder)localObject2).append(localQConfItem.b);
        ((StringBuilder)localObject2).append("]");
        QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        localObject1 = ((CodecTestInfo)localObject1).a.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CodecTestInfo.TestInfos)((Iterator)localObject1).next();
          AVTestforEncDecConfig.TestInfo localTestInfo1 = a((CodecTestInfo.TestInfos)localObject2);
          if (localTestInfo1 == null)
          {
            if (AudioHelper.e()) {
              QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            }
          }
          else if (localItem.a.containsKey(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).b)))
          {
            AVTestforEncDecConfig.TestInfo localTestInfo2 = (AVTestforEncDecConfig.TestInfo)localItem.a.get(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).b));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parsed, 数据已存在, codec[");
            localStringBuilder.append(((CodecTestInfo.TestInfos)localObject2).b);
            localStringBuilder.append("], _taskId[");
            localStringBuilder.append(localTestInfo2.a);
            localStringBuilder.append("], _test_ver[");
            localStringBuilder.append(localTestInfo2.g);
            localStringBuilder.append("], taskId[");
            localStringBuilder.append(localQConfItem.a);
            localStringBuilder.append("], test_ver[");
            localStringBuilder.append(localTestInfo1.g);
            localStringBuilder.append("]");
            QLog.w("QAVConfig_431", 1, localStringBuilder.toString());
            if (localTestInfo1.g <= localTestInfo2.g) {}
          }
          else
          {
            localTestInfo1.a = localQConfItem.a;
            localItem.a.put(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).b), localTestInfo1);
          }
        }
      }
      i += 1;
    }
    return localItem;
  }
  
  public void a(AVTestforEncDecConfig.Item paramItem)
  {
    super.onUpdate(paramItem);
    int i = QConfigManager.b().a(431, "");
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      Object localObject2 = (QQAppInterface)localObject1;
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", ((QQAppInterface)localObject2).getCurrentAccountUin());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("ver", ((StringBuilder)localObject2).toString());
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = new int[4];
      Object tmp125_123 = localObject2;
      tmp125_123[0] = 1;
      Object tmp129_125 = tmp125_123;
      tmp129_125[1] = 2;
      Object tmp133_129 = tmp129_125;
      tmp133_129[2] = 4;
      Object tmp137_133 = tmp133_129;
      tmp137_133[3] = 8;
      tmp137_133;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        Object localObject3 = (AVTestforEncDecConfig.TestInfo)paramItem.a.get(Integer.valueOf(k));
        if (localObject3 != null)
        {
          int m = CodecConfigUtil.a((AVTestforEncDecConfig.TestInfo)localObject3);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("test");
          ((StringBuilder)localObject4).append(k);
          ((HashMap)localObject1).put(((StringBuilder)localObject4).toString(), "1");
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("test");
          ((StringBuilder)localObject4).append(k);
          ((StringBuilder)localObject4).append("_ver");
          localObject4 = ((StringBuilder)localObject4).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((AVTestforEncDecConfig.TestInfo)localObject3).g);
          localStringBuilder.append("");
          ((HashMap)localObject1).put(localObject4, localStringBuilder.toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("test");
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append("_flag");
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(m);
          ((StringBuilder)localObject4).append("");
          ((HashMap)localObject1).put(localObject3, ((StringBuilder)localObject4).toString());
        }
        i += 1;
      }
      UserAction.onUserAction("qav_codec_config", true, -1L, -1L, (Map)localObject1, true, true);
    }
  }
  
  public Class<AVTestforEncDecConfig.Item> clazz()
  {
    return AVTestforEncDecConfig.Item.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.AVTestforEncDecConfig
 * JD-Core Version:    0.7.0.1
 */