package com.tencent.mobileqq.app.qqdaily;

import com.tencent.ark.open.ArkView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArkCollector
{
  private List<ArkView> a = new ArrayList();
  
  public void a()
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArkView localArkView = (ArkView)((Iterator)localObject).next();
      if (localArkView != null) {
        localArkView.onDestroy();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(" ArkViews onDestroy");
      QLog.d("ArkCollector", 2, ((StringBuilder)localObject).toString());
    }
    this.a.clear();
  }
  
  public void a(ArkView paramArkView)
  {
    this.a.add(paramArkView);
  }
  
  public void b()
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArkView localArkView = (ArkView)((Iterator)localObject).next();
      if (localArkView != null) {
        localArkView.onPause();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(" ArkViews onPause");
      QLog.d("ArkCollector", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    Object localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArkView localArkView = (ArkView)((Iterator)localObject).next();
      if (localArkView != null) {
        localArkView.onResume();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(" ArkViews onResume");
      QLog.d("ArkCollector", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.ArkCollector
 * JD-Core Version:    0.7.0.1
 */