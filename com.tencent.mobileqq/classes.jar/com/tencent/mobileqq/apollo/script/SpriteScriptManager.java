package com.tencent.mobileqq.apollo.script;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloResponseManager;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IApolloRenderView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class SpriteScriptManager
  implements Manager
{
  private SpriteActionMessage jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage;
  private SpriteBackgroundManager jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager;
  private SpriteBridge jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge;
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteRscBuilder jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  private SpriteScriptCreator jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  private SpriteTaskHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private ApolloBubbleLogic jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public SpriteScriptManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = new SpriteContext(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler = new SpriteTaskHandler(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator = new SpriteScriptCreator(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder = new SpriteRscBuilder(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge = new SpriteBridge(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder);
  }
  
  public SpriteActionMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage;
  }
  
  public SpriteBackgroundManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager;
  }
  
  public SpriteBridge a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge;
  }
  
  public SpriteContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  }
  
  public SpriteRscBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder;
  }
  
  public SpriteScriptCreator a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator;
  }
  
  public SpriteTaskHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler;
  }
  
  public SpriteUIHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  }
  
  public ApolloBubbleLogic a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic;
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = SpriteUtil.a(a());
      if (paramString != null) {
        paramString.c(1);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager.c();
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    Object localObject = SpriteUtil.a(a());
    if (localObject != null) {
      ((SpriteActionScript)localObject).a(paramInt, paramArrayList);
    }
    for (;;)
    {
      return;
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        SpriteDrawerInfoManager localSpriteDrawerInfoManager = (SpriteDrawerInfoManager)((WeakReference)((Iterator)localObject).next()).get();
        if ((localSpriteDrawerInfoManager != null) && (localSpriteDrawerInfoManager.a().d == 1)) {
          localSpriteDrawerInfoManager.a(paramInt, paramArrayList);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramBaseChatPie);
    paramBaseChatPie = a();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (ApolloResponseManager)paramBaseChatPie.getManager(231);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic = new ApolloBubbleLogic(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage = new SpriteActionMessage(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager = new SpriteBackgroundManager(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramApolloTextureView);
  }
  
  public void a(IApolloRenderView paramIApolloRenderView)
  {
    if (paramIApolloRenderView == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramIApolloRenderView);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramIApolloRenderView);
  }
  
  public void a(SpriteDrawerInfoManager paramSpriteDrawerInfoManager)
  {
    if (paramSpriteDrawerInfoManager != null)
    {
      paramSpriteDrawerInfoManager = new WeakReference(paramSpriteDrawerInfoManager);
      this.jdField_a_of_type_JavaUtilList.add(paramSpriteDrawerInfoManager);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.d(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator == null)) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Boolean)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a(paramInt, 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (!SpriteUtil.b(a(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b(true);
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler.b(null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge.a(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
    }
    QQAppInterface localQQAppInterface = a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c == 1) {}
    for (int i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, 0, new String[] { Integer.toString(ApolloUtil.b(paramInt)), "", "", paramString });
      return;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!SpriteUtil.b(a(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = SpriteUtil.a(a());
      if (paramString != null) {
        paramString.c(2);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager.d();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteRscBuilder.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    if (localObject != null)
    {
      localObject = ((IApolloRenderView)localObject).getRenderImpl();
      if (localObject != null) {
        ((ApolloRenderInterfaceImpl)localObject).c();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskHandler.a();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteScriptCreator.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBridge.a();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloBubbleLogic = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage.a();
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteActionMessage = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager.f();
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteBackgroundManager = null;
    }
    localObject = a();
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_AndroidContentSharedPreferences != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_AndroidContentSharedPreferences.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
    }
    ((ApolloGameManager)((QQAppInterface)localObject).getManager(210)).a = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteScriptManager
 * JD-Core Version:    0.7.0.1
 */