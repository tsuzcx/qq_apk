package com.tencent.av.ManageConfig;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public abstract class QAVConfigBase<T>
  extends IQConfigProcessor<T>
{
  String a;
  int b;
  
  public QAVConfigBase() {}
  
  public QAVConfigBase(int paramInt)
  {
    this.b = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QAVConfig_");
    localStringBuilder.append(this.b);
    this.a = localStringBuilder.toString();
  }
  
  private static int a(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).optInt("task_id");
      return i;
    }
    catch (Exception paramString)
    {
      label16:
      break label16;
    }
    return 0;
  }
  
  @Nullable
  static QConfItem a(String paramString, int paramInt, QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject1 = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      boolean bool = QLog.isDevelopLevel();
      int k = 0;
      int i;
      if ((!bool) && (paramArrayOfQConfItem.length <= 1)) {
        i = 0;
      } else {
        i = 1;
      }
      Object localObject2 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramInt = QConfigManager.b().a(paramInt, ((AppInterface)localObject2).getCurrentAccountUin());
      if (i != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSuitableItem, Version[");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("], size[");
        ((StringBuilder)localObject1).append(paramArrayOfQConfItem.length);
        ((StringBuilder)localObject1).append("]");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = paramArrayOfQConfItem[0];
      Object localObject4 = localObject1;
      Object localObject3 = localObject2;
      if (paramArrayOfQConfItem.length > 1)
      {
        int m = paramArrayOfQConfItem.length;
        int j = 0;
        paramInt = k;
        for (;;)
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (paramInt >= m) {
            break;
          }
          localObject4 = paramArrayOfQConfItem[paramInt];
          k = a(((QConfItem)localObject4).b);
          localObject3 = localObject1;
          if (i != 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(", \nindex[");
            ((StringBuilder)localObject3).append(j);
            ((StringBuilder)localObject3).append("], taskId[");
            ((StringBuilder)localObject3).append(((QConfItem)localObject4).a);
            ((StringBuilder)localObject3).append("], task_id[");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append("]");
            localObject3 = ((StringBuilder)localObject3).toString();
          }
          if (k == ((QConfItem)localObject4).a) {
            localObject2 = localObject4;
          }
          j += 1;
          paramInt += 1;
          localObject1 = localObject3;
        }
      }
      if (i != 0)
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append((String)localObject4);
        paramArrayOfQConfItem.append(", \nselect taskId[");
        paramArrayOfQConfItem.append(((QConfItem)localObject3).a);
        paramArrayOfQConfItem = paramArrayOfQConfItem.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramArrayOfQConfItem);
        ((StringBuilder)localObject1).append("], content\n");
        ((StringBuilder)localObject1).append(((QConfItem)localObject3).b);
        QLog.w(paramString, 1, ((StringBuilder)localObject1).toString());
      }
      return localObject3;
    }
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, "getSuitableItem, confFiles is null or empty.");
    }
    return null;
  }
  
  public int a()
  {
    String str;
    if (isAccountRelated()) {
      str = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin();
    } else {
      str = "";
    }
    return QConfigManager.b().a(this.b, str);
  }
  
  @NonNull
  protected abstract T b(QConfItem[] paramArrayOfQConfItem);
  
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
      Object localObject = b(paramArrayOfQConfItem);
      return localObject;
    }
    catch (Exception localException)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed, 配置解析异常, [\n");
      localStringBuilder.append(paramArrayOfQConfItem[0].b);
      localStringBuilder.append("\n]");
      QLog.w(str, 1, localStringBuilder.toString(), localException);
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append(this.a);
      paramArrayOfQConfItem.append("配置解析异常");
      AudioHelper.d(paramArrayOfQConfItem.toString());
    }
    return migrateOldOrDefaultContent(type());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      int i = a();
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed, failCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], version[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isDevelopLevel())
    {
      int i = a();
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive, version[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void onUpdate(T paramT)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate, ");
      localStringBuilder.append(paramT);
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ManageConfig.QAVConfigBase
 * JD-Core Version:    0.7.0.1
 */