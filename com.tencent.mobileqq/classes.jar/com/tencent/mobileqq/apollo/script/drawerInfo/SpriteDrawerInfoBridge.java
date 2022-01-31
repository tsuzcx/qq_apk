package com.tencent.mobileqq.apollo.script.drawerInfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteBridgeInterface;
import com.tencent.mobileqq.apollo.script.callback.ISpriteTaskInterface;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import ypg;

public class SpriteDrawerInfoBridge
  implements ISpriteBridgeInterface
{
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private ISpriteTaskInterface jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface;
  private CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  
  public SpriteDrawerInfoBridge(SpriteContext paramSpriteContext, ISpriteTaskInterface paramISpriteTaskInterface, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteTaskInterface = paramISpriteTaskInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = paramSpriteScriptCreator;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
  }
  
  public void a(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (paramSpriteContext == null) || (!paramSpriteContext.c())) {}
    String str;
    SpriteActionScript localSpriteActionScript;
    do
    {
      do
      {
        return;
        if (!a(0, -1))
        {
          QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
          return;
        }
        str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
      } while (TextUtils.isEmpty(str));
      localSpriteActionScript = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0);
    } while (localSpriteActionScript == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    localSpriteActionScript.a(localStringBuilder.toString());
    localSpriteActionScript.a(paramSpriteContext.jdField_b_of_type_JavaLangString, false);
    localSpriteActionScript.a(paramSpriteContext.a, false);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.post(new ypg(this, paramSpriteTaskParam), 8, null, true);
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam);
    if (!a(paramSpriteTaskParam.jdField_c_of_type_Int, paramSpriteTaskParam.f))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    SpriteAioScript localSpriteAioScript = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(paramSpriteTaskParam.jdField_c_of_type_Int);
    if (localSpriteAioScript == null)
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.jdField_b_of_type_Int = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.f) });
    }
    paramSpriteTaskParam.jdField_b_of_type_Int = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playDrawerInfoAction ('").append((String)localObject).append("');");
    localSpriteAioScript.a(localStringBuilder.toString());
    localSpriteAioScript.a(paramSpriteTaskParam.a, false);
    localSpriteAioScript.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ApolloActionHelper.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge
 * JD-Core Version:    0.7.0.1
 */