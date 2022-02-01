package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class QAVConfigBase<T>
  extends IQConfigProcessor<T>
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  
  public QAVConfigBase() {}
  
  public QAVConfigBase(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = ("QAVConfig_" + this.jdField_a_of_type_Int);
  }
  
  private static int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  @Nullable
  static QConfItem a(String paramString, int paramInt, QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = null;
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length == 0))
    {
      paramArrayOfQConfItem = (QConfItem[])localObject1;
      if (QLog.isColorLevel())
      {
        QLog.i(paramString, 2, "getSuitableItem, confFiles is null or empty.");
        paramArrayOfQConfItem = (QConfItem[])localObject1;
      }
      return paramArrayOfQConfItem;
    }
    int i;
    if ((QLog.isDevelopLevel()) || (paramArrayOfQConfItem.length > 1))
    {
      i = 1;
      label47:
      localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramInt = QConfigManager.a().a(paramInt, ((AppInterface)localObject1).getCurrentAccountUin());
      if (i == 0) {
        break label341;
      }
    }
    label139:
    label338:
    label341:
    for (Object localObject2 = "getSuitableItem, Version[" + paramInt + "], size[" + paramArrayOfQConfItem.length + "]";; localObject2 = null)
    {
      localObject1 = paramArrayOfQConfItem[0];
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      int j;
      if (paramArrayOfQConfItem.length > 1)
      {
        int k = paramArrayOfQConfItem.length;
        paramInt = 0;
        j = 0;
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (paramInt < k)
        {
          localObject4 = paramArrayOfQConfItem[paramInt];
          int m = a(((QConfItem)localObject4).jdField_a_of_type_JavaLangString);
          localObject3 = localObject2;
          if (i != 0) {
            localObject3 = (String)localObject2 + ", \nindex[" + j + "], taskId[" + ((QConfItem)localObject4).jdField_a_of_type_Int + "], task_id[" + m + "]";
          }
          if (m != ((QConfItem)localObject4).jdField_a_of_type_Int) {
            break label338;
          }
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        j += 1;
        paramInt += 1;
        localObject2 = localObject3;
        break label139;
        i = 0;
        break label47;
        paramArrayOfQConfItem = (QConfItem[])localObject3;
        if (i == 0) {
          break;
        }
        paramArrayOfQConfItem = (String)localObject4 + ", \nselect taskId[" + ((QConfItem)localObject3).jdField_a_of_type_Int;
        QLog.w(paramString, 1, paramArrayOfQConfItem + "], content\n" + ((QConfItem)localObject3).jdField_a_of_type_JavaLangString);
        return localObject3;
      }
    }
  }
  
  public int a()
  {
    String str = "";
    if (isAccountRelated()) {
      str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
    }
    return QConfigManager.a().a(this.jdField_a_of_type_Int, str);
  }
  
  @NonNull
  protected abstract T a(QConfItem[] paramArrayOfQConfItem);
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public final T onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    try
    {
      Object localObject = a(paramArrayOfQConfItem);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onParsed, 配置解析异常, [\n" + paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString + "\n]", localException);
      AudioHelper.c(this.jdField_a_of_type_JavaLangString + HardCodeUtil.a(2131708887));
    }
    return migrateOldOrDefaultContent(type());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      int i = a();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onReqFailed, failCode[" + paramInt + "], version[" + i + "]");
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isDevelopLevel())
    {
      int i = a();
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onReqNoReceive, version[" + i + "]");
    }
  }
  
  public void onUpdate(T paramT)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onUpdate, " + paramT);
    }
  }
  
  public int type()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.QAVConfigBase
 * JD-Core Version:    0.7.0.1
 */