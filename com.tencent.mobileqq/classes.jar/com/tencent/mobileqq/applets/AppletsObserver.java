package com.tencent.mobileqq.applets;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.applets.data.AppletsSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppletsObserver
  implements BusinessObserver
{
  public static final String TAG = "AppletsObserver";
  
  protected void onAppletsSettingSwitchChange(int paramInt) {}
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList) {}
  
  protected void onGetAppletsPushUnreadInfo(Object paramObject) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<AppletsSetting> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onGetAppletsSettingSwitch:  isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AppletsObserver", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      localObject1 = (AppletsFolderManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
    }
    if (localObject1 == null) {
      return;
    }
    localObject2 = new HashSet();
    if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject3 = (AppletsSetting)paramList.next();
        Object localObject4 = ((AppletsSetting)localObject3).b;
        paramBoolean = true;
        if ((localObject4 != null) && (((AppletsSetting)localObject3).b.size() > 0) && (((AppletsSetting)localObject3).b.get(0) != null) && (((AppletItem)((AppletsSetting)localObject3).b.get(0)).a() == 1L))
        {
          localObject3 = (AppletItem)((AppletsSetting)localObject3).b.get(0);
          if (((AppletItem)localObject3).e() != 1) {
            paramBoolean = false;
          }
          ((AppletsFolderManager)localObject1).b(paramBoolean);
          onAppletsSettingSwitchChange(((AppletItem)localObject3).e());
        }
        else if ((((AppletsSetting)localObject3).b != null) && (((AppletsSetting)localObject3).b.size() > 0))
        {
          localObject3 = ((AppletsSetting)localObject3).b.iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (AppletItem)((Iterator)localObject3).next();
            if ((((AppletItem)localObject4).a() != 1L) && (((AppletItem)localObject4).e() != 1)) {
              ((Set)localObject2).add(String.valueOf(((AppletItem)localObject4).a()));
            }
          }
        }
      }
    }
    ((AppletsFolderManager)localObject1).a((Set)localObject2);
  }
  
  protected void onReceiveAppletsMessageUnreadInfo(Map<String, Integer> paramMap) {}
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSetAppletsSettingSwitch:  isSuccess: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AppletsObserver", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 instanceof QQAppInterface)) {
      localObject1 = (AppletsFolderManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.APPLETS_ACCOUNT_MANAGER);
    }
    if (localObject1 == null) {
      return;
    }
    if ((paramList != null) && (paramBoolean))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (AppletItem)paramList.next();
        int i = ((AppletItem)localObject2).e();
        if (((AppletItem)localObject2).a() == 1L)
        {
          paramBoolean = true;
          if (i != 1) {
            paramBoolean = false;
          }
          ((AppletsFolderManager)localObject1).b(paramBoolean);
          onAppletsSettingSwitchChange(i);
        }
        else if (localObject1 != null)
        {
          if (i == 0) {
            ((AppletsFolderManager)localObject1).e(String.valueOf(((AppletItem)localObject2).a()));
          } else {
            ((AppletsFolderManager)localObject1).f(String.valueOf(((AppletItem)localObject2).a()));
          }
        }
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9) {
              return;
            }
            onGetAppletsPushUnreadInfo(paramObject);
            return;
          }
          onReceiveAppletsMessageUnreadInfo((Map)paramObject);
          return;
        }
        onSetAppletsSettingSwitch(paramBoolean, (List)paramObject);
        return;
      }
      onGetAppletsSettingSwitch(paramBoolean, (List)paramObject);
      return;
    }
    onGetAppletsDetail(paramBoolean, (List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.AppletsObserver
 * JD-Core Version:    0.7.0.1
 */