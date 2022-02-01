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
  
  public static AVTestforEncDecConfig.TestInfo a(int paramInt)
  {
    Object localObject = (AVTestforEncDecConfig.Item)QConfigManager.a().a(431);
    if (((AVTestforEncDecConfig.Item)localObject).jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    AVTestforEncDecConfig.TestInfo localTestInfo = (AVTestforEncDecConfig.TestInfo)((AVTestforEncDecConfig.Item)localObject).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
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
  
  static AVTestforEncDecConfig.TestInfo a(CodecTestInfo.TestInfos paramTestInfos)
  {
    int j = paramTestInfos.jdField_a_of_type_Int;
    int i = 4;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramTestInfos.jdField_b_of_type_Int;
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
    int m = paramTestInfos.c;
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
    String str = paramTestInfos.jdField_a_of_type_JavaLangString;
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
    int n = paramTestInfos.d;
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
    if ((paramTestInfos.jdField_b_of_type_JavaUtilList != null) && (paramTestInfos.jdField_b_of_type_JavaUtilList.size() != 0)) {}
    try
    {
      localObject1 = paramTestInfos.jdField_b_of_type_JavaLangString;
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
    ((StringBuilder)localObject1).append(paramTestInfos.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("]");
    QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject1).toString());
    l = 0L;
    localHashMap = new HashMap();
    localObject1 = paramTestInfos.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CodecTestInfo.TestInfos.Samples)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).c)) {
        for (;;)
        {
          if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).jdField_b_of_type_JavaLangString))
          {
            if ((j != 1) && (j != i))
            {
              if (((j != 2) && (j != 8)) || ((((CodecTestInfo.TestInfos.Samples)localObject2).jdField_a_of_type_Int != 0) && (((CodecTestInfo.TestInfos.Samples)localObject2).jdField_b_of_type_Int != 0))) {
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
              if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject2).jdField_a_of_type_JavaLangString)) {
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
            localSample.jdField_b_of_type_JavaLangString = ((CodecTestInfo.TestInfos.Samples)localObject2).jdField_b_of_type_JavaLangString;
            localSample.c = ((CodecTestInfo.TestInfos.Samples)localObject2).jdField_a_of_type_JavaLangString;
            localSample.jdField_a_of_type_JavaLangString = ((CodecTestInfo.TestInfos.Samples)localObject2).c;
            localSample.jdField_a_of_type_Int = ((CodecTestInfo.TestInfos.Samples)localObject2).jdField_a_of_type_Int;
            localSample.jdField_b_of_type_Int = ((CodecTestInfo.TestInfos.Samples)localObject2).jdField_b_of_type_Int;
            localSample.jdField_a_of_type_Boolean = paramTestInfos.jdField_a_of_type_Boolean;
            localHashMap.put(((CodecTestInfo.TestInfos.Samples)localObject2).c, localSample);
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
    if ((paramTestInfos.jdField_a_of_type_JavaUtilList != null) && (paramTestInfos.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      i = 0;
      localObject1 = null;
      while (i < paramTestInfos.jdField_a_of_type_JavaUtilList.size())
      {
        int i1 = ((Integer)paramTestInfos.jdField_a_of_type_JavaUtilList.get(i)).intValue();
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
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject1);
    ((AVTestforEncDecConfig.TestInfo)localObject2).c = k;
    ((AVTestforEncDecConfig.TestInfo)localObject2).d = m;
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_b_of_type_Int = j;
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaLangString = str;
    ((AVTestforEncDecConfig.TestInfo)localObject2).e = n;
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_Boolean = paramTestInfos.jdField_a_of_type_Boolean;
    ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_Long = l;
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
      Object localObject1 = CodecTestInfo.a(localQConfItem.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject1 != null) && (((CodecTestInfo)localObject1).jdField_a_of_type_JavaUtilList != null)) {
        bool = true;
      } else {
        bool = false;
      }
      Object localObject2;
      if (AudioHelper.b())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("parsed, taskId[");
        ((StringBuilder)localObject2).append(localQConfItem.jdField_a_of_type_Int);
        ((StringBuilder)localObject2).append("], suc[");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("], oldVersion[");
        ((StringBuilder)localObject2).append(a());
        ((StringBuilder)localObject2).append("], content[");
        ((StringBuilder)localObject2).append(localQConfItem.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("]");
        QLog.w("QAVConfig_431", 1, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        localObject1 = ((CodecTestInfo)localObject1).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CodecTestInfo.TestInfos)((Iterator)localObject1).next();
          AVTestforEncDecConfig.TestInfo localTestInfo1 = a((CodecTestInfo.TestInfos)localObject2);
          if (localTestInfo1 == null)
          {
            if (AudioHelper.b()) {
              QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            }
          }
          else if (localItem.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).jdField_a_of_type_Int)))
          {
            AVTestforEncDecConfig.TestInfo localTestInfo2 = (AVTestforEncDecConfig.TestInfo)localItem.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).jdField_a_of_type_Int));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parsed, 数据已存在, codec[");
            localStringBuilder.append(((CodecTestInfo.TestInfos)localObject2).jdField_a_of_type_Int);
            localStringBuilder.append("], _taskId[");
            localStringBuilder.append(localTestInfo2.jdField_a_of_type_Int);
            localStringBuilder.append("], _test_ver[");
            localStringBuilder.append(localTestInfo2.e);
            localStringBuilder.append("], taskId[");
            localStringBuilder.append(localQConfItem.jdField_a_of_type_Int);
            localStringBuilder.append("], test_ver[");
            localStringBuilder.append(localTestInfo1.e);
            localStringBuilder.append("]");
            QLog.w("QAVConfig_431", 1, localStringBuilder.toString());
            if (localTestInfo1.e <= localTestInfo2.e) {}
          }
          else
          {
            localTestInfo1.jdField_a_of_type_Int = localQConfItem.jdField_a_of_type_Int;
            localItem.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(((CodecTestInfo.TestInfos)localObject2).jdField_a_of_type_Int), localTestInfo1);
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
    int i = QConfigManager.a().a(431, "");
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
      Object tmp123_121 = localObject2;
      tmp123_121[0] = 1;
      Object tmp127_123 = tmp123_121;
      tmp127_123[1] = 2;
      Object tmp131_127 = tmp127_123;
      tmp131_127[2] = 4;
      Object tmp135_131 = tmp131_127;
      tmp135_131[3] = 8;
      tmp135_131;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        Object localObject3 = (AVTestforEncDecConfig.TestInfo)paramItem.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
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
          localStringBuilder.append(((AVTestforEncDecConfig.TestInfo)localObject3).e);
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