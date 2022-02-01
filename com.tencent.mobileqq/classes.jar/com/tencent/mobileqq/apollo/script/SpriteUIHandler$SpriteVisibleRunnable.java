package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class SpriteUIHandler$SpriteVisibleRunnable
  implements Runnable
{
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public SpriteUIHandler$SpriteVisibleRunnable(SpriteContext paramSpriteContext, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.b = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
    if (localObject1 == null)
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      ((SpriteContext)localObject1).e(this.b);
    }
    else
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      if (localObject2 != null) {
        ((SpriteContext)localObject1).a((String)localObject2, this.b);
      }
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localObject2 == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().a().a();
    } else {
      localObject1 = null;
    }
    QLog.d("[cmshow][scripted]SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.b), ", from:", this.jdField_a_of_type_JavaLangString, ", cmshowView:", localObject1, ", canInit:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean), ", isViewReady:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f()) });
    Object localObject3;
    if (!this.b)
    {
      if ((localObject1 == null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "view is going to be created in basechatpie, pls wait.");
        return;
      }
      if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f()))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "view is being created but NOT yet ready, pls wait.");
        return;
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if ((localObject3 != null) && (((BaseChatPie)localObject3).B))
      {
        QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "want to show apollo but AIO finish now");
        return;
      }
      if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f()))
      {
        ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).onSurfaceReady(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
      }
      else if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean))
      {
        localObject2 = (ApolloAIOHelperImpl)((BaseChatPie)localObject3).a(8);
        if (localObject2 != null) {
          ((ApolloAIOHelperImpl)localObject2).ifApolloFunAvailThenInit();
        }
      }
    }
    else
    {
      localObject3 = SpriteUtil.a((AppRuntime)localObject2);
      if (localObject3 != null) {
        ((SpriteActionScript)localObject3).b(2);
      }
      localObject2 = ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
      if (localObject2 != null) {
        ((SpriteBackgroundManager)localObject2).e();
      }
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (ICMShowView)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable
 * JD-Core Version:    0.7.0.1
 */