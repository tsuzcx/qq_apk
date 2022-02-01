package com.tencent.biz.videostory.config.processor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class VSEntranceStyleProcessor
  extends IQConfigProcessor<VSEntranceStyleBean>
{
  private void a(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      VSConfigManager.a().b("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      VSConfigManager.a().b("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      VSConfigManager.a().b("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public VSEntranceStyleBean a(int paramInt)
  {
    return new VSEntranceStyleBean();
  }
  
  @Nullable
  public VSEntranceStyleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onParsed ");
      ((StringBuilder)localObject).append(paramArrayOfQConfItem[0].b);
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = VSEntranceStyleBean.a(paramArrayOfQConfItem[0].b);
      if (localObject == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)VSConfigManager.a().a("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(((VSEntranceStyleBean)localObject).c())) && (!((VSEntranceStyleBean)localObject).c().equals(str)))
      {
        VSEntranceWidgetDownLoadHelper.a().a((VSEntranceStyleBean)localObject);
        a(((VSEntranceStyleBean)localObject).c(), paramArrayOfQConfItem[0].b);
      }
      return localObject;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(VSEntranceStyleBean paramVSEntranceStyleBean)
  {
    if (paramVSEntranceStyleBean != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate:");
      localStringBuilder.append(paramVSEntranceStyleBean.toString());
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<VSEntranceStyleBean> clazz()
  {
    return VSEntranceStyleBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSEntranceStyleProcessor
 * JD-Core Version:    0.7.0.1
 */