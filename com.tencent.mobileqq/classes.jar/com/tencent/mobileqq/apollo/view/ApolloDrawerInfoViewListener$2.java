package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.CmShowWnsUtils;
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
    Object localObject1;
    try
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangObject == null)) {
        return;
      }
      if (ApolloDrawerInfoViewListener.a(this.this$0).get() == null) {
        return;
      }
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaLangObject;
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0)) {
        return;
      }
      SpriteDrawerInfoManager localSpriteDrawerInfoManager = (SpriteDrawerInfoManager)ApolloDrawerInfoViewListener.a(this.this$0).get();
      localObject2 = localSpriteDrawerInfoManager.a();
      ISpriteContext localISpriteContext = localSpriteDrawerInfoManager.a();
      if ((localObject2 == null) || (localISpriteContext == null)) {
        return;
      }
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.equals(localISpriteContext.a())) {
          ((SpriteActionScript)localObject2).a(str, true);
        }
      }
      if (localThrowable.a() == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloDrawerInfoViewListener", 1, localThrowable, new Object[0]);
      return;
    }
    Object localObject2 = localThrowable.a().getCurrentUin();
    boolean bool = ApolloDrawerInfoViewListener.a(this.this$0, (String)localObject2, (ArrayList)localObject1);
    QLog.d("ApolloDrawerInfoViewListener", 1, "onApolloDressChange reGetFrame:" + bool);
    if (bool)
    {
      localObject1 = (ApolloManagerServiceImpl)localThrowable.a().getRuntimeService(IApolloManagerService.class, "all");
      if ((localObject1 != null) && (((ApolloManagerServiceImpl)localObject1).getApolloUserStatus(localThrowable.a()) != 2))
      {
        ThreadManager.getSubThreadHandler().post(new ApolloDrawerInfoViewListener.2.1(this, (ApolloManagerServiceImpl)localObject1));
        ThreadManager.getSubThreadHandler().postDelayed(new ApolloDrawerInfoViewListener.2.2(this, (ApolloManagerServiceImpl)localObject1), CmShowWnsUtils.b());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener.2
 * JD-Core Version:    0.7.0.1
 */