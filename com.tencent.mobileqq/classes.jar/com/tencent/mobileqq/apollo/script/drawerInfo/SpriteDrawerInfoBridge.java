package com.tencent.mobileqq.apollo.script.drawerInfo;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteScriptCreator;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class SpriteDrawerInfoBridge
  implements ISpriteBridge
{
  private ISpriteTaskHandler jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private String jdField_a_of_type_JavaLangString;
  
  public SpriteDrawerInfoBridge(SpriteContext paramSpriteContext, ISpriteTaskHandler paramISpriteTaskHandler, SpriteRscBuilder paramSpriteRscBuilder, SpriteScriptCreator paramSpriteScriptCreator)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiScriptISpriteTaskHandler = paramISpriteTaskHandler;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = paramSpriteRscBuilder;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = paramSpriteScriptCreator;
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
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
  }
  
  public void a(int paramInt, @NotNull MessageForApollo paramMessageForApollo) {}
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[sendMsg], msg:", paramMessageForApollo });
    }
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
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
    localSpriteAioScript.b(localStringBuilder.toString());
    localSpriteAioScript.a(paramSpriteTaskParam.jdField_a_of_type_JavaLangString, false);
    localSpriteAioScript.a(paramSpriteTaskParam.jdField_b_of_type_JavaLangString, false);
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {}
    for (;;)
    {
      ApolloActionHelperImpl.doActionReport((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.jdField_b_of_type_Boolean);
      return;
      bool = false;
    }
  }
  
  public void a(SpriteContext paramSpriteContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder == null) || (paramSpriteContext == null) || (!paramSpriteContext.c())) {
      if (paramSpriteContext != null) {
        TraceReportUtil.a(paramSpriteContext.d(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    SpriteActionScript localSpriteActionScript;
    do
    {
      do
      {
        return;
        if (a(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramSpriteContext.e != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramSpriteContext));
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        TraceReportUtil.a(paramSpriteContext.d(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.jdField_a_of_type_JavaLangString;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.jdField_a_of_type_JavaLangString = null;
      }
      localSpriteActionScript = (SpriteActionScript)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a(0);
    } while (localSpriteActionScript == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    TraceReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d(), 350);
    localSpriteActionScript.b(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localSpriteActionScript, paramSpriteContext));
  }
  
  public void b() {}
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge
 * JD-Core Version:    0.7.0.1
 */