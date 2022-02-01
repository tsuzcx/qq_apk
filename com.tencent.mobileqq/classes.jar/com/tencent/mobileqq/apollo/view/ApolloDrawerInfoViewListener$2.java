package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class ApolloDrawerInfoViewListener$2
  implements Runnable
{
  ApolloDrawerInfoViewListener$2(ApolloDrawerInfoViewListener paramApolloDrawerInfoViewListener, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangObject != null))
      {
        if (ApolloDrawerInfoViewListener.a(this.this$0).get() == null) {
          return;
        }
        Object localObject2 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
        if (localObject2 != null)
        {
          if (((ArrayList)localObject2).size() == 0) {
            return;
          }
          Object localObject1 = (SpriteDrawerInfoManager)ApolloDrawerInfoViewListener.a(this.this$0).get();
          Object localObject3 = ((SpriteDrawerInfoManager)localObject1).a();
          SpriteContext localSpriteContext = ((SpriteDrawerInfoManager)localObject1).a();
          if (localObject3 != null)
          {
            if (localSpriteContext == null) {
              return;
            }
            Iterator localIterator = ((ArrayList)localObject2).iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              if (str.equals(localSpriteContext.a())) {
                ((SpriteActionScript)localObject3).a(str, true);
              }
            }
            if (((SpriteDrawerInfoManager)localObject1).a() == null) {
              return;
            }
            localObject3 = ((SpriteDrawerInfoManager)localObject1).a().getCurrentUin();
            boolean bool = ApolloDrawerInfoViewListener.a(this.this$0, (String)localObject3, (ArrayList)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onApolloDressChange reGetFrame:");
            ((StringBuilder)localObject2).append(bool);
            QLog.d("[cmshow]ApolloDrawerInfoViewListener", 1, ((StringBuilder)localObject2).toString());
            if (!bool) {
              return;
            }
            localObject1 = (ApolloManagerServiceImpl)((SpriteDrawerInfoManager)localObject1).a().getRuntimeService(IApolloManagerService.class, "all");
            if ((localObject1 == null) || (((ApolloManagerServiceImpl)localObject1).getApolloUserStatus() == 2)) {
              return;
            }
            ThreadManager.getSubThreadHandler().post(new ApolloDrawerInfoViewListener.2.1(this, (ApolloManagerServiceImpl)localObject1));
            ThreadManager.getSubThreadHandler().postDelayed(new ApolloDrawerInfoViewListener.2.2(this, (ApolloManagerServiceImpl)localObject1), CmShowWnsUtils.c());
            return;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2
 * JD-Core Version:    0.7.0.1
 */