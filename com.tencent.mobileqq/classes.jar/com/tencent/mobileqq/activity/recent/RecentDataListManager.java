package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.RecentConstants;
import com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.StartupDirectorConstants;
import com.tencent.mobileqq.imcore.proxy.business.FriendsProxy;
import com.tencent.mobileqq.imcore.proxy.business.RecentDataListManagerProxy;
import com.tencent.mobileqq.imcore.proxy.business.RecentFaceDecoderProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecentDataListManager
{
  public static final String a = "RecentDataListManager";
  private static volatile RecentDataListManager f;
  public boolean b = false;
  public final List<RecentBaseData> c = new ArrayList(IMCoreConstantsRoute.RecentConstants.a);
  public List<RecentBaseData> d;
  public String e;
  private boolean g;
  private final RecentDataListManager.CacheController h = new RecentDataListManager.CacheController(null);
  
  public static RecentDataListManager a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new RecentDataListManager();
        }
      }
      finally {}
    }
    return f;
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public RecentBaseData a(String paramString)
  {
    return this.h.a(paramString);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    this.h.a(paramRecentBaseData, paramString);
  }
  
  public void a(List<RecentBaseData> paramList, String paramString)
  {
    this.d = paramList;
    this.e = paramString;
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d(a, 2, new Object[] { "preloadRecentBaseData, isPreloaded= ", Boolean.valueOf(this.g), ", forUI=", Boolean.valueOf(paramBoolean2), ", loadMore=", Boolean.valueOf(paramBoolean1) });
    }
    if (this.g) {
      return true;
    }
    if (paramBoolean2) {
      this.g = true;
    }
    StartupTracker.a(null, "Recent_LoadData_query_recent_list");
    Object localObject2 = ((IRecentUserProxyService)paramBaseQQAppInterface.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
    Object localObject1 = new ArrayList();
    if (localObject2 != null) {
      localObject1 = ((RecentUserProxy)localObject2).a(true);
    }
    StartupTracker.a("Recent_LoadData_query_recent_list", null);
    int j = IMCoreConstantsRoute.StartupDirectorConstants.a;
    int i;
    if (localObject1 == null) {
      i = 0;
    } else {
      i = ((List)localObject1).size();
    }
    int k = Math.min(j, i);
    if (k > 0)
    {
      StartupTracker.a(null, "Recent_LoadData_preloadData");
      if (!RecentParcelUtil.a(paramBaseQQAppInterface)) {
        RecentDataListManagerProxy.a(paramBaseQQAppInterface, (List)localObject1);
      }
      StartupTracker.a("Recent_LoadData_preloadData", "Recent_LoadData_convert");
      this.d = new ArrayList(k);
      this.e = paramBaseQQAppInterface.getCurrentUin();
      if (RecentParcelUtil.a(paramBaseQQAppInterface))
      {
        i = 0;
        j = 0;
        while ((i < ((List)localObject1).size()) && (i < IMCoreConstantsRoute.StartupDirectorConstants.a))
        {
          RecentUser localRecentUser = (RecentUser)((List)localObject1).get(i);
          localObject2 = RecentParcelUtil.a(paramBaseQQAppInterface, paramContext, localRecentUser);
          if (localObject2 != null) {
            j += 1;
          } else {
            localObject2 = ConversationDataFactory.a(localRecentUser, paramBaseQQAppInterface, paramContext, true);
          }
          this.d.add(localObject2);
          i += 1;
        }
        RecentParcelUtil.a(((List)localObject1).size(), ((List)localObject1).size() - j);
        QLog.d(a, 1, new Object[] { "Recover from parcel, success size=", Integer.valueOf(j), " RU size=", Integer.valueOf(((List)localObject1).size()) });
      }
      else
      {
        ConversationDataFactory.a((List)localObject1, paramBaseQQAppInterface, paramContext, this.d, k);
        QLog.d(a, 1, new Object[] { "Recover from old way, success size= RU size=", Integer.valueOf(((List)localObject1).size()), " limit=", Integer.valueOf(k) });
      }
      StartupTracker.a("Recent_LoadData_convert", null);
      StartupTracker.a(null, "Recent_LoadMoreData_getFaceDrawable");
      if ((paramBaseQQAppInterface.isLogin()) && (FriendsProxy.a(paramBaseQQAppInterface.getCurrentAccountUin()))) {
        RecentFaceDecoderProxy.a(paramBaseQQAppInterface, 0, paramBaseQQAppInterface.getCurrentAccountUin());
      }
      i = 0;
      while (i < k)
      {
        paramContext = (RecentUser)((List)localObject1).get(i);
        if (paramContext != null) {
          RecentFaceDecoderProxy.a(paramBaseQQAppInterface, paramContext.getType(), paramContext.uin);
        }
        i += 1;
      }
      this.b = true;
      StartupTracker.a("Recent_LoadMoreData_getFaceDrawable", null);
    }
    paramBaseQQAppInterface = this.d;
    if (QLog.isColorLevel())
    {
      paramContext = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preloadRecentBaseData end: ");
      ((StringBuilder)localObject1).append(this.g);
      if (paramBaseQQAppInterface != null) {
        i = paramBaseQQAppInterface.size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d(paramContext, 2, ((StringBuilder)localObject1).toString());
    }
    paramBoolean1 = bool1;
    if (k > 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public void b()
  {
    this.h.a();
    this.c.clear();
  }
  
  public void b(String paramString)
  {
    this.h.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDataListManager
 * JD-Core Version:    0.7.0.1
 */