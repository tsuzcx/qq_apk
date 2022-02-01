package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
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
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null)
    {
      QLog.e("cmshow_scripted_SpriteUIHandler", 1, "[onDoubleTap], mContext is null.");
      return;
    }
    Object localObject1;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
      if (this.b)
      {
        i = 1;
        label37:
        ((SpriteContext)localObject1).d = i;
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.e(this.b);
      }
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
      if (localObject2 == null) {
        break;
      }
      QLog.d("cmshow_scripted_SpriteUIHandler", 1, new Object[] { "[showOrHideSprite], isHide:", Boolean.valueOf(this.b), ",from:", this.jdField_a_of_type_JavaLangString, ",surfaceView:", localObject1, ",canInit:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean), ",isViweReady:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f()) });
      if (this.b) {
        break label368;
      }
      if ((localObject1 != null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean)) {
        break label220;
      }
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is going to be created in basechatpie, pls wait.");
      return;
      i = 0;
      break label37;
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
    label220:
    if ((localObject1 != null) && (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f()))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "surfaceView is being created but NOT yet ready, pls wait.");
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if ((localObject3 != null) && (((BaseChatPie)localObject3).a != null) && (((BaseChatPie)localObject3).a.c))
    {
      QLog.i("cmshow_scripted_SpriteUIHandler", 1, "want to show apollo but AIO finish now");
      return;
    }
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.f())) {
      ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).onSurfaceReady(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new SpriteUIHandler.SpriteVisibleRunnable.1(this, (IApolloRenderView)localObject1));
      return;
      if ((localObject3 != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean))
      {
        ((BaseChatPie)localObject3).b();
        continue;
        label368:
        localObject3 = SpriteUtil.a((QQAppInterface)localObject2);
        if (localObject3 != null) {
          ((SpriteActionScript)localObject3).b(2);
        }
        localObject2 = ((SpriteScriptManagerImpl)((QQAppInterface)localObject2).getRuntimeService(ISpriteScriptManager.class, "all")).getSpriteBackgroundManager();
        if (localObject2 != null) {
          ((SpriteBackgroundManager)localObject2).e();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.SpriteVisibleRunnable
 * JD-Core Version:    0.7.0.1
 */