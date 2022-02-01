package com.tencent.mobileqq.apollo.script;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListAdapter;
import com.tencent.widget.XListView;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class SpriteUIHandler
  implements ISpriteUIHandler
{
  private SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private SpriteUIHandler.SpriteVisibleRunnable jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable;
  private WeakReference<XListView> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<XListAdapter> b;
  
  public SpriteUIHandler(SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
  }
  
  private XListAdapter a()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference == null) {
      return null;
    }
    return (XListAdapter)localWeakReference.get();
  }
  
  private XListView a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (XListView)localWeakReference.get();
  }
  
  private void a(long paramLong, int paramInt)
  {
    Object localObject1 = a();
    if (!(localObject1 instanceof ChatAdapter1))
    {
      QLog.e("[cmshow][scripted]SpriteUIHandler", 1, "adatper is null.");
      return;
    }
    Object localObject3 = (ChatAdapter1)localObject1;
    Object localObject2 = a();
    if (localObject2 == null) {
      return;
    }
    int i = AIOUtils.a(paramLong, (ListAdapter)localObject3);
    if (i < 0) {
      return;
    }
    localObject1 = (ChatMessage)((ChatAdapter1)localObject3).getItem(i);
    localObject3 = ((ChatAdapter1)localObject3).a.a((ChatMessage)localObject1, (BaseAdapter)localObject3);
    if (((localObject3 instanceof ApolloItemBuilder)) && ((localObject1 instanceof MessageForApollo)))
    {
      localObject3 = (ApolloItemBuilder)localObject3;
      i = AIOUtils.a(paramLong, ((XListView)localObject2).getAdapter());
      View localView = AIOUtils.a((ListView)localObject2, i);
      if ((localView instanceof BaseChatItemLayout))
      {
        localObject2 = (BaseChatItemLayout)AIOUtils.a((ListView)localObject2, i);
        if (paramInt == 1)
        {
          ((ApolloItemBuilder)localObject3).a((View)localObject2, (MessageForApollo)localObject1);
          return;
        }
        ((ApolloItemBuilder)localObject3).b((View)localObject2, (MessageForApollo)localObject1);
        return;
      }
      if ((localView == null) && (paramInt == 1)) {
        ((ApolloItemBuilder)localObject3).a(null, (MessageForApollo)localObject1);
      }
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.4(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.5(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", downloadStatus:");
      QLog.d("[cmshow][scripted]SpriteUIHandler", 2, new Object[] { "[onActionDownloadNotify], ret:", localStringBuilder.toString(), Integer.valueOf(paramInt2), ", msgId:", Long.valueOf(paramLong) });
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.1(this, paramLong, paramInt2, paramInt1));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteUIHandler", 2, new Object[] { "[onTaskStart], msgId:", Long.valueOf(paramLong) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.2(this, paramLong);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteUIHandler", 2, new Object[] { "[onTaskComplete], msgId:", Long.valueOf(paramLong), ",type:", Integer.valueOf(paramInt) });
    }
    paramSpriteTaskParam = new SpriteUIHandler.3(this, paramLong, paramInt);
    ThreadManager.getUIHandler().post(paramSpriteTaskParam);
  }
  
  public void a(XListView paramXListView, XListAdapter paramXListAdapter)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXListView);
    this.b = new WeakReference(paramXListAdapter);
  }
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SpriteUIHandler.7(this, paramString));
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt, String paramString)
  {
    if (!(paramAppRuntime instanceof QQAppInterface)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramAppRuntime;
    if (!SpriteUtil.b(localQQAppInterface, paramInt, paramString))
    {
      QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "[onDoubleTap], condition NOT meet.");
      return;
    }
    if (((IApolloActionHelper)QRoute.api(IApolloActionHelper.class)).getApolloFuncSwitch(localQQAppInterface.getCurrentUin(), localQQAppInterface) == 0)
    {
      QLog.i("[cmshow][scripted]SpriteUIHandler", 1, "[onDoubleTap] sava onDoubleTap user is init status return");
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    a(paramAppRuntime, bool ^ true);
    a(bool ^ true, true, null);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][scripted]SpriteUIHandler", 2, new Object[] { "onDoubleTap isShow:", Boolean.valueOf(bool ^ true) });
    }
    if (!bool)
    {
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getString(2131690050), 1).a();
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_double_disappear_clk", this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_JavaLangString, 0, 0, new String[] { Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)), "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
    }
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { Integer.toString(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.jdField_a_of_type_Int)), "0" });
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    Object localObject = (AppInterface)paramAppRuntime;
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    paramAppRuntime = (IApolloDaoManagerService)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    localObject = paramAppRuntime.getApolloBaseInfo(((AppInterface)localObject).getCurrentUin());
    ((ApolloBaseInfo)localObject).apolloAIOStatus = (paramBoolean ^ true);
    paramAppRuntime.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject);
    if (localIApolloExtensionHandler != null) {
      localIApolloExtensionHandler.a((ApolloBaseInfo)localObject);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (!"none_apollo_play_action".equals(paramString)) {
      return;
    }
    QLog.d("[cmshow][scripted]SpriteUIHandler", 1, new Object[] { "showOrHideSurfaceView isHide:", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() != null) {
      paramString = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().a().a();
    } else {
      paramString = null;
    }
    ThreadManager.getUIHandler().post(new SpriteUIHandler.6(this, paramString, paramBoolean));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable = new SpriteUIHandler.SpriteVisibleRunnable(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext, paramBoolean1, paramBoolean2, paramString);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler$SpriteVisibleRunnable);
  }
  
  public boolean a(MotionEvent paramMotionEvent, RelativeLayout paramRelativeLayout)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
    float f3 = paramMotionEvent.getY();
    float f1 = 0.0F;
    if (paramRelativeLayout != null) {
      f1 = paramRelativeLayout.getHeight();
    }
    float f2;
    if ((bool ^ true)) {
      f2 = QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowDisappearHeight", 0.3F);
    } else {
      f2 = QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowDisplayHeight", 0.3F);
    }
    return f3 >= (1.0F - f2) * f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler
 * JD-Core Version:    0.7.0.1
 */