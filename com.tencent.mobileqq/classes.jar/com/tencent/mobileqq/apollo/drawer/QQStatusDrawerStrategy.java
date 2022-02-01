package com.tencent.mobileqq.apollo.drawer;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.From;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;

public class QQStatusDrawerStrategy
  extends ApolloDrawerStrategy
{
  public QQStatusDrawerStrategy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = 97;
  }
  
  private void a(AppInterface paramAppInterface, long paramLong, ApolloActionData paramApolloActionData)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public int a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt, AppInterface paramAppInterface, Context paramContext)
  {
    if (!a()) {
      return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    Object localObject3 = (IApolloDaoManagerService)paramAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject3).getApolloBaseInfo(paramAppInterface.getCurrentUin());
    ApolloCmQQStatusData localApolloCmQQStatusData = localApolloBaseInfo.apolloCmQQStatusData;
    if ((localApolloCmQQStatusData != null) && (localApolloCmQQStatusData.shouldShowQQCmshowStatusAction(ApolloCmQQStatusData.From.DRAWER)))
    {
      Object localObject2 = ((IApolloDaoManagerService)localObject3).findActionInCache(localApolloCmQQStatusData.apolloQQAct);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((IApolloDaoManagerService)localObject3).findActionById(localApolloCmQQStatusData.apolloQQAct);
      }
      if (localObject1 == null)
      {
        QLog.e("[cmshow]ApolloDrawerStrategy", 1, "apolloDrawerCmQQStatus action data not found in db!");
        return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      }
      localObject2 = ApolloResManagerFacade.a.a(Scene.DRAWER);
      localObject3 = ((IApolloResManager)localObject2).a();
      boolean bool = ((IApolloResManager)localObject2).c(((ApolloActionData)localObject1).actionId, 0);
      QLog.d("[cmshow]ApolloDrawerStrategy", 1, new Object[] { "ApolloDrawerCmQQStatus onExecAction:", Integer.valueOf(((ApolloActionData)localObject1).actionId), ",isRscDone:", Boolean.valueOf(bool) });
      if (((ApolloActionData)localObject1).actionId > 0)
      {
        if (bool)
        {
          long l = System.currentTimeMillis();
          SpriteUtil.a(paramSpriteDrawerInfoManager, 12, (ApolloActionData)localObject1);
          localApolloCmQQStatusData.showUpFreqDecrement(ApolloCmQQStatusData.From.DRAWER);
          localApolloCmQQStatusData.printFreqRemaining();
          a(paramAppInterface, l, (ApolloActionData)localObject1);
          return 0;
        }
        ((IApolloResDownloader)localObject3).a(paramAppInterface, paramAppInterface.getCurrentUin(), ((IApolloResManager)localObject2).g(), paramInt, localApolloBaseInfo.getApolloDress().getDressIds(), ((ApolloActionData)localObject1).actionId, ((ApolloActionData)localObject1).actionType, true);
        return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
      }
      return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
    }
    QLog.e("[cmshow]ApolloDrawerStrategy", 1, "apolloDrawerCmQQStatus action data not valid!");
    return super.a(paramSpriteDrawerInfoManager, paramInt, paramAppInterface, paramContext);
  }
  
  public boolean a()
  {
    return (this.d) && (!this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.QQStatusDrawerStrategy
 * JD-Core Version:    0.7.0.1
 */