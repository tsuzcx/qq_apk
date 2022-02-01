package com.tencent.avgame.config;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class AvGameConfProcessor
  extends IQConfigProcessor<AvGameConfBean>
{
  private final List<AvGameConfProcessor.OnGetConfigListener> a = new LinkedList();
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("[notifyListeners]:");
      ((StringBuilder)???).append(this.a.size());
      QLog.d("AvGameConfProcessor", 2, ((StringBuilder)???).toString());
    }
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    try
    {
      synchronized (this.a)
      {
        if (this.a.size() > 0)
        {
          Iterator localIterator = this.a.iterator();
          while (localIterator.hasNext())
          {
            AvGameConfProcessor.OnGetConfigListener localOnGetConfigListener = (AvGameConfProcessor.OnGetConfigListener)localIterator.next();
            try
            {
              localOnGetConfigListener.a(paramInt);
            }
            catch (Throwable localThrowable2) {}
            if (QLog.isColorLevel()) {
              QLog.e("AvGameConfProcessor", 1, localThrowable2, new Object[0]);
            }
          }
          this.a.clear();
        }
        return;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameConfProcessor", 1, localThrowable1, new Object[0]);
      }
    }
  }
  
  @NonNull
  public AvGameConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("AvGameConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new AvGameConfBean();
  }
  
  @Nullable
  public AvGameConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("AvGameConfProcessor", 2, localStringBuilder.toString());
      }
      return AvGameConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(AvGameConfProcessor.OnGetConfigListener paramOnGetConfigListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvGameConfProcessor", 2, "[getConfig]");
    }
    synchronized (this.a)
    {
      if (this.a.size() > 0)
      {
        this.a.add(paramOnGetConfigListener);
        return;
      }
      this.a.add(paramOnGetConfigListener);
      QConfigManager.b().a(new int[] { 642 });
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
      ThreadManager.getSubThreadHandler().postAtTime(new AvGameConfProcessor.1(this), this, SystemClock.uptimeMillis() + 10000L);
      return;
    }
  }
  
  public void a(AvGameConfBean paramAvGameConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramAvGameConfBean != null) {
        paramAvGameConfBean = paramAvGameConfBean.toString();
      } else {
        paramAvGameConfBean = " empty";
      }
      localStringBuilder.append(paramAvGameConfBean);
      QLog.d("AvGameConfProcessor", 2, localStringBuilder.toString());
    }
    b(0);
  }
  
  public Class clazz()
  {
    return AvGameConfBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("AvGameConfProcessor", 2, localStringBuilder.toString());
    }
    b(paramInt);
  }
  
  public int type()
  {
    return 642;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.AvGameConfProcessor
 * JD-Core Version:    0.7.0.1
 */