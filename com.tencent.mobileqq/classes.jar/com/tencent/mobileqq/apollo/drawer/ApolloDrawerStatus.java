package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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
  Handler a;
  protected boolean a;
  public boolean b = false;
  public boolean c = true;
  
  public ApolloDrawerStatus(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
    if (paramQQAppInterface == null) {}
    int i;
    int j;
    do
    {
      return;
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("apollo_sp", 0);
      i = localSharedPreferences.getInt(paramQQAppInterface.getCurrentAccountUin() + "_count_" + ApolloUtilImpl.getTodayKey(), 0);
      j = localSharedPreferences.getInt("bubble_max_count", 3);
      this.c = a(paramQQAppInterface);
    } while (i < j);
    this.jdField_a_of_type_Boolean = true;
    QLog.i("AplloDrawerStatus", 1, "Bubble show count limited:" + i + "," + j);
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt1, int paramInt2, AppInterface paramAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AplloDrawerStatus", 2, new Object[] { "draw execAction default say hi, model:", Integer.valueOf(paramInt1) });
    }
    if (paramInt1 == 3) {}
    for (paramInt1 = 14;; paramInt1 = 5)
    {
      paramAppInterface = new ApolloActionData();
      paramAppInterface.actionId = -1;
      paramAppInterface.actionType = 0;
      SpriteUtil.a(paramSpriteDrawerInfoManager, paramInt1, paramAppInterface);
      return 0;
    }
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    paramAppInterface = new ApolloActionData();
    paramAppInterface.actionId = -1;
    paramAppInterface.actionType = 0;
    SpriteUtil.a(paramSpriteDrawerInfoManager, 5, paramAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("AplloDrawerStatus", 2, "draw execAction random say hi");
    }
    return 0;
  }
  
  public void a() {}
  
  protected void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = paramContext.getSharedPreferences("apollo_sp", 0);
    Object localObject1 = paramQQAppInterface.getCurrentAccountUin() + "_count_";
    paramContext = (String)localObject1 + ApolloUtilImpl.getTodayKey();
    paramQQAppInterface = ((SharedPreferences)localObject2).edit();
    if (((SharedPreferences)localObject2).contains(paramContext)) {
      paramQQAppInterface.putInt(paramContext, ((SharedPreferences)localObject2).getInt(paramContext, 0) + 1);
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      return;
      Object localObject3 = ((SharedPreferences)localObject2).getAll();
      localObject2 = new ArrayList();
      if (localObject3 != null)
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          String str = (String)localEntry.getKey();
          if ((str != null) && (str.startsWith((String)localObject1))) {
            ((List)localObject2).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramQQAppInterface.remove((String)((Iterator)localObject1).next());
        }
      }
      paramQQAppInterface.putInt(paramContext, 1);
    }
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
    if ((paramAppInterface == null) || (!(paramAppInterface instanceof QQAppInterface))) {}
    boolean bool;
    do
    {
      return false;
      bool = ApolloGameUtil.b((QQAppInterface)paramAppInterface);
      if ((bool) && (QLog.isColorLevel())) {
        QLog.d("AplloDrawerStatus", 2, "isShowDrawerAction current is 3D User");
      }
    } while (bool);
    return true;
  }
  
  public void b(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, Context paramContext, QQAppInterface paramQQAppInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus
 * JD-Core Version:    0.7.0.1
 */