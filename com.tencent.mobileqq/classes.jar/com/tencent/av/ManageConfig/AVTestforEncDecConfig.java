package com.tencent.av.ManageConfig;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.av.mediacodec.config.CodecConfigUtil;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.AudioHelper;
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
      localObject = null;
    }
    AVTestforEncDecConfig.TestInfo localTestInfo;
    do
    {
      return localObject;
      localTestInfo = (AVTestforEncDecConfig.TestInfo)((AVTestforEncDecConfig.Item)localObject).jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      localObject = localTestInfo;
    } while (!QLog.isDevelopLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("loadTestInfo, content[");
    if (localTestInfo != null) {}
    for (localObject = localTestInfo.toString();; localObject = "")
    {
      QLog.w("QAVConfig_431", 1, (String)localObject + "]");
      return localTestInfo;
    }
  }
  
  static AVTestforEncDecConfig.TestInfo a(CodecTestInfo.TestInfos paramTestInfos)
  {
    int j = paramTestInfos.jdField_a_of_type_Int;
    if ((j != 1) && (j != 2) && (j != 4) && (j != 8)) {
      return null;
    }
    int k = paramTestInfos.jdField_b_of_type_Int;
    if (k <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_sdk不合法, codec[" + j + "], min_sdk[" + k + "]");
      }
      return null;
    }
    int m = paramTestInfos.c;
    if (m < 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "async_min_sdk不合法, codec[" + j + "], async_min_sdk[" + m + "]");
      }
      return null;
    }
    String str = paramTestInfos.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "min_version不合法, codec[" + j + "], min_version[" + str + "]");
      }
      return null;
    }
    int n = paramTestInfos.d;
    if (n <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "test_ver不合法, codec[" + j + "], test_ver[" + n + "]");
      }
      return null;
    }
    if ((paramTestInfos.jdField_b_of_type_JavaUtilList == null) || (paramTestInfos.jdField_b_of_type_JavaUtilList.size() == 0))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("QAVConfig_431", 1, "没有样本, codec[" + j + "]");
      }
      return null;
    }
    long l;
    HashMap localHashMap;
    label591:
    AVTestforEncDecConfig.Sample localSample;
    label675:
    Object localObject2;
    try
    {
      Object localObject1 = paramTestInfos.jdField_b_of_type_JavaLangString;
      localObject3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = ((SimpleDateFormat)localObject3).parse((String)localObject1).getTime();
      localHashMap = new HashMap();
      localObject1 = paramTestInfos.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label675;
        }
        localObject3 = (CodecTestInfo.TestInfos.Samples)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject3).c)) && (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject3).jdField_b_of_type_JavaLangString)))
        {
          if ((j != 1) && (j != 4)) {
            break;
          }
          if (!TextUtils.isEmpty(((CodecTestInfo.TestInfos.Samples)localObject3).jdField_a_of_type_JavaLangString)) {
            break label591;
          }
          QLog.w("QAVConfig_431", 1, "exp 为空, codec[" + j + "]");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QAVConfig_431", 1, "没有过期时间, codec[" + j + "], expdate[" + paramTestInfos.jdField_b_of_type_JavaLangString + "]");
        l = 0L;
        continue;
        if (((j == 2) || (j == 8)) && ((((CodecTestInfo.TestInfos.Samples)localObject3).jdField_a_of_type_Int == 0) || (((CodecTestInfo.TestInfos.Samples)localObject3).jdField_b_of_type_Int == 0)))
        {
          QLog.w("QAVConfig_431", 1, "w/h 为空, codec[" + j + "]");
        }
        else
        {
          localSample = new AVTestforEncDecConfig.Sample();
          localSample.jdField_b_of_type_JavaLangString = ((CodecTestInfo.TestInfos.Samples)localObject3).jdField_b_of_type_JavaLangString;
          localSample.c = ((CodecTestInfo.TestInfos.Samples)localObject3).jdField_a_of_type_JavaLangString;
          localSample.jdField_a_of_type_JavaLangString = ((CodecTestInfo.TestInfos.Samples)localObject3).c;
          localSample.jdField_a_of_type_Int = ((CodecTestInfo.TestInfos.Samples)localObject3).jdField_a_of_type_Int;
          localSample.jdField_b_of_type_Int = ((CodecTestInfo.TestInfos.Samples)localObject3).jdField_b_of_type_Int;
          localSample.jdField_a_of_type_Boolean = paramTestInfos.jdField_a_of_type_Boolean;
          localHashMap.put(((CodecTestInfo.TestInfos.Samples)localObject3).c, localSample);
        }
      }
      if (localHashMap.size() == 0)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("QAVConfig_431", 1, "样本不够, codec[" + j + "]");
        }
        return null;
      }
      localSample = null;
      localObject2 = null;
      localObject3 = localSample;
      if (paramTestInfos.jdField_a_of_type_JavaUtilList == null) {
        break label831;
      }
    }
    Object localObject3 = localSample;
    int i1;
    if (paramTestInfos.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      for (;;)
      {
        localObject3 = localObject2;
        if (i >= paramTestInfos.jdField_a_of_type_JavaUtilList.size()) {
          break label831;
        }
        i1 = ((Integer)paramTestInfos.jdField_a_of_type_JavaUtilList.get(i)).intValue();
        if (i1 > 0) {
          break;
        }
        i += 1;
      }
      if (localObject2 != null) {
        break label906;
      }
      localObject2 = new ArrayList();
    }
    label906:
    for (;;)
    {
      ((ArrayList)localObject2).add(Integer.valueOf(i1));
      break;
      label831:
      localObject2 = new AVTestforEncDecConfig.TestInfo();
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaUtilHashMap = localHashMap;
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject3);
      ((AVTestforEncDecConfig.TestInfo)localObject2).c = k;
      ((AVTestforEncDecConfig.TestInfo)localObject2).d = m;
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_b_of_type_Int = j;
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_JavaLangString = str;
      ((AVTestforEncDecConfig.TestInfo)localObject2).e = n;
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_Boolean = paramTestInfos.jdField_a_of_type_Boolean;
      ((AVTestforEncDecConfig.TestInfo)localObject2).jdField_a_of_type_Long = l;
      return localObject2;
    }
  }
  
  @NonNull
  public AVTestforEncDecConfig.Item a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("QAVConfig_431", 1, "migrateOldOrDefaultContent, type[" + paramInt + "]");
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
      Object localObject = CodecTestInfo.a(localQConfItem.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (((CodecTestInfo)localObject).jdField_a_of_type_JavaUtilList != null))
      {
        bool = true;
        if (AudioHelper.e()) {
          QLog.w("QAVConfig_431", 1, "parsed, taskId[" + localQConfItem.jdField_a_of_type_Int + "], suc[" + bool + "], oldVersion[" + a() + "], content[" + localQConfItem.jdField_a_of_type_JavaLangString + "]");
        }
        if (bool) {
          localObject = ((CodecTestInfo)localObject).jdField_a_of_type_JavaUtilList.iterator();
        }
      }
      else
      {
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label379;
          }
          CodecTestInfo.TestInfos localTestInfos = (CodecTestInfo.TestInfos)((Iterator)localObject).next();
          AVTestforEncDecConfig.TestInfo localTestInfo1 = a(localTestInfos);
          if (localTestInfo1 == null)
          {
            if (!AudioHelper.e()) {
              continue;
            }
            QLog.w("QAVConfig_431", 1, "parsed, 数据不合法");
            continue;
            bool = false;
            break;
          }
          if (localItem.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(localTestInfos.jdField_a_of_type_Int)))
          {
            AVTestforEncDecConfig.TestInfo localTestInfo2 = (AVTestforEncDecConfig.TestInfo)localItem.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(localTestInfos.jdField_a_of_type_Int));
            QLog.w("QAVConfig_431", 1, "parsed, 数据已存在, codec[" + localTestInfos.jdField_a_of_type_Int + "], _taskId[" + localTestInfo2.jdField_a_of_type_Int + "], _test_ver[" + localTestInfo2.e + "], taskId[" + localQConfItem.jdField_a_of_type_Int + "], test_ver[" + localTestInfo1.e + "]");
            if (localTestInfo1.e <= localTestInfo2.e) {}
          }
          else
          {
            localTestInfo1.jdField_a_of_type_Int = localQConfItem.jdField_a_of_type_Int;
            localItem.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(localTestInfos.jdField_a_of_type_Int), localTestInfo1);
          }
        }
      }
      label379:
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
      ((HashMap)localObject1).put("ver", i + "");
      ((HashMap)localObject1).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
      localObject2 = new int[4];
      Object tmp113_111 = localObject2;
      tmp113_111[0] = 1;
      Object tmp117_113 = tmp113_111;
      tmp117_113[1] = 2;
      Object tmp121_117 = tmp117_113;
      tmp121_117[2] = 4;
      Object tmp125_121 = tmp121_117;
      tmp125_121[3] = 8;
      tmp125_121;
      int j = localObject2.length;
      i = 0;
      while (i < j)
      {
        int k = localObject2[i];
        AVTestforEncDecConfig.TestInfo localTestInfo = (AVTestforEncDecConfig.TestInfo)paramItem.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        if (localTestInfo != null)
        {
          int m = CodecConfigUtil.a(localTestInfo);
          ((HashMap)localObject1).put("test" + k, "1");
          ((HashMap)localObject1).put("test" + k + "_ver", localTestInfo.e + "");
          ((HashMap)localObject1).put("test" + k + "_flag", m + "");
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