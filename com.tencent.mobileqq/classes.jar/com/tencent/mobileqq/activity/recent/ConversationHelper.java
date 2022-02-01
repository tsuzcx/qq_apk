package com.tencent.mobileqq.activity.recent;

import android.util.Pair;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.config.recentlist.RecentCheckFilterDispatcher;
import com.tencent.mobileqq.activity.recent.config.recentlist.base.RecentListConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import java.util.Comparator;
import java.util.List;

public class ConversationHelper
  implements Comparator<RecentBaseData>
{
  private BaseQQAppInterface a;
  
  public ConversationHelper(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  private void b(List<RecentUser> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (!TempMsgBoxManagerProxy.a((BaseQQAppInterface)localObject)) {
        return;
      }
      localObject = ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class)).getRecentUserCache();
      RecentUser localRecentUser = null;
      if (localObject != null)
      {
        localRecentUser = ((RecentUserProxy)localObject).c(AppConstants.TEMP_MSG_BOX_UIN, 10011);
        localObject = ((RecentUserProxy)localObject).c(AppConstants.FILTER_MSG_UIN, 10012);
      }
      else
      {
        localObject = null;
      }
      if (localRecentUser != null) {
        paramList.add(localRecentUser);
      }
      if (localObject != null) {
        paramList.add(localObject);
      }
    }
  }
  
  public int a(RecentBaseData paramRecentBaseData1, RecentBaseData paramRecentBaseData2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(List<RecentUser> paramList)
  {
    ConversationHelper.LogBuilder localLogBuilder = new ConversationHelper.LogBuilder("Q.recent", null);
    ConversationHelper.LogBuilder.a(localLogBuilder, paramList);
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    i -= 1;
    while (i >= 0)
    {
      Object localObject = (RecentUser)paramList.get(i);
      if (localObject == null)
      {
        paramList.remove(i);
      }
      else if ((((RecentUser)localObject).uin != null) && (((RecentUser)localObject).uin.trim().length() != 0))
      {
        localObject = RecentListConfig.a().a(this.a, (RecentUser)localObject, i);
        if ((localObject != null) && (((Boolean)((Pair)localObject).second).booleanValue()))
        {
          paramList.remove(i);
          ConversationHelper.LogBuilder.a(localLogBuilder, new String[] { (String)((Pair)localObject).first });
        }
      }
      else
      {
        paramList.remove(i);
        ConversationHelper.LogBuilder.a(localLogBuilder, new String[] { String.valueOf(i), ",", String.valueOf(((RecentUser)localObject).getType()), ";" });
      }
      i -= 1;
    }
    if (paramList != null) {
      b(paramList);
    }
    ConversationHelper.LogBuilder.a(localLogBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationHelper
 * JD-Core Version:    0.7.0.1
 */