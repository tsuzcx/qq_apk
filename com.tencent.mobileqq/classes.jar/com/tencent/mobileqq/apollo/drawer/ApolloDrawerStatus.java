package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class ApolloDrawerStatus
{
  public int a;
  protected boolean a = false;
  public boolean b = false;
  public boolean c = true;
  
  public ApolloDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_count_");
    localStringBuilder.append(ApolloUtilImpl.getTodayKey());
    int i = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    int j = localSharedPreferences.getInt("bubble_max_count", 3);
    this.c = a(paramQQAppInterface);
    if (i >= j)
    {
      this.a = true;
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("Bubble show count limited:");
      paramQQAppInterface.append(i);
      paramQQAppInterface.append(",");
      paramQQAppInterface.append(j);
      QLog.i("[cmshow]AplloDrawerStatus", 1, paramQQAppInterface.toString());
    }
  }
  
  protected int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt1, int paramInt2, AppInterface paramAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]AplloDrawerStatus", 2, new Object[] { "draw execAction default say hi, model:", Integer.valueOf(paramInt1) });
    }
    if (paramInt1 == 3) {
      paramInt1 = 14;
    } else {
      paramInt1 = 5;
    }
    paramAppInterface = new ApolloActionData();
    paramAppInterface.actionId = -1;
    paramAppInterface.actionType = 0;
    SpriteUtil.a(paramSpriteDrawerInfoManager, paramInt1, paramAppInterface);
    return 0;
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    paramContext = new ApolloActionData();
    paramContext.actionId = -1;
    paramContext.actionType = 0;
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get_user_apollo_info_drawer_dress_sp");
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    paramAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    if (paramAppInterface.contains("actid"))
    {
      paramContext.actionId = paramAppInterface.getInt("actid", -1);
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("actid=");
      paramAppInterface.append(paramContext.actionId);
      QLog.d("[cmshow]AplloDrawerStatus", 1, paramAppInterface.toString());
      SpriteUtil.a(paramSpriteDrawerInfoManager, 12, paramContext);
      return 0;
    }
    SpriteUtil.a(paramSpriteDrawerInfoManager, 5, paramContext);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]AplloDrawerStatus", 2, "draw execAction random say hi");
    }
    return 0;
  }
  
  public void a() {}
  
  protected void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramContext.getSharedPreferences("apollo_sp", 0);
    paramContext = new StringBuilder();
    paramContext.append(paramQQAppInterface.getCurrentAccountUin());
    paramContext.append("_count_");
    paramContext = paramContext.toString();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append(paramContext);
    paramQQAppInterface.append(ApolloUtilImpl.getTodayKey());
    paramQQAppInterface = paramQQAppInterface.toString();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    if (((SharedPreferences)localObject1).contains(paramQQAppInterface))
    {
      localEditor.putInt(paramQQAppInterface, ((SharedPreferences)localObject1).getInt(paramQQAppInterface, 0) + 1);
    }
    else
    {
      Object localObject2 = ((SharedPreferences)localObject1).getAll();
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          String str = (String)localEntry.getKey();
          if ((str != null) && (str.startsWith(paramContext))) {
            ((List)localObject1).add(localEntry.getKey());
          }
        }
        paramContext = ((List)localObject1).iterator();
        while (paramContext.hasNext()) {
          localEditor.remove((String)paramContext.next());
        }
      }
      localEditor.putInt(paramQQAppInterface, 1);
    }
    localEditor.commit();
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public void a(QQAppInterface paramQQAppInterface, SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    this.b = false;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)))
    {
      boolean bool = ApolloUtilImpl.isApollo3DUser(paramAppInterface);
      if ((bool) && (QLog.isColorLevel())) {
        QLog.d("[cmshow]AplloDrawerStatus", 2, "isShowDrawerAction current is 3D User");
      }
      return bool ^ true;
    }
    return false;
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus
 * JD-Core Version:    0.7.0.1
 */