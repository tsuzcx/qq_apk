package com.tencent.mobileqq.apollo.sdk;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.sdk.ICmShowSDKPlatform;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.api.sdk.PlayActionConfig;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import mqq.util.WeakReference;

public class CmShowRenderView
  extends ApolloTextureView
{
  private static final HashMap<String, WeakReference<CmShowRenderView>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private RenderViewController jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public CmShowRenderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CmShowRenderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(paramContext)) {
      throw new RuntimeException("isSdkInit is false!");
    }
    jdField_a_of_type_JavaUtilHashMap.put(toString(), new WeakReference(this));
  }
  
  public static void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "onDressChanged uin.size:" + paramList.size());
    ThreadManagerV2.getUIHandlerV2().post(new CmShowRenderView.1(paramList));
  }
  
  private void b(List<String> paramList)
  {
    Object localObject1 = null;
    if ((paramList == null) || (paramList.isEmpty())) {
      break label15;
    }
    label15:
    while (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController == null) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    Object localObject2 = null;
    paramList = (List<String>)localObject1;
    label35:
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = localObject2;
        if (str.equals(this.jdField_a_of_type_JavaLangString)) {
          localObject1 = this.jdField_a_of_type_JavaLangString;
        }
      }
      if ((TextUtils.isEmpty(str)) || (!str.equals(this.b))) {
        break label140;
      }
      paramList = this.b;
    }
    label140:
    for (;;)
    {
      localObject2 = localObject1;
      break label35;
      if ((TextUtils.isEmpty(localObject2)) && (!TextUtils.isEmpty(paramList))) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(localObject2, paramList);
      return;
    }
  }
  
  public int a(String paramString)
  {
    return CmShowDataHelper.a(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "stopAction actionId:", Integer.valueOf(paramInt1), " actionSeqId:", Integer.valueOf(paramInt2) });
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramInt1, paramInt2);
  }
  
  public void a(IRenderViewListener paramIRenderViewListener, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController = new RenderViewController(this, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramIRenderViewListener);
  }
  
  public void a(PlayActionConfig paramPlayActionConfig)
  {
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(BaseApplicationImpl.getContext()))
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction !isSdkInit");
      return;
    }
    if (paramPlayActionConfig == null)
    {
      QLog.e("CmShow_CmShowRenderView", 1, "playAction playActionConfig == null");
      return;
    }
    QLog.i("CmShow_CmShowRenderView", 1, "playAction before");
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramPlayActionConfig);
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "playAction playActionConfig:", paramPlayActionConfig });
  }
  
  public void a(String paramString)
  {
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString) });
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "changeSpriteModel mode:", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString, paramInt);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "updateAvatarParam");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(String paramString1, String paramString2, float paramFloat, int paramInt, Bundle paramBundle)
  {
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "initAvatar !isSdkInit");
    }
    do
    {
      return;
      if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
      {
        QLog.e("CmShow_CmShowRenderView", 1, "initAvatar empty uin");
        return;
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString1, paramString2, paramFloat, paramInt, paramBundle);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!((ICmShowSDKPlatform)QRoute.api(ICmShowSDKPlatform.class)).isSdkInit(BaseApplicationImpl.getContext())) {
      QLog.e("CmShow_CmShowRenderView", 1, "showBubble !isSdkInit");
    }
    do
    {
      return;
      QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "showBubble uin:", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString1), " bubbleText:", paramString2 });
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "hideAvatar uin", ((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString), " show:", Boolean.valueOf(paramBoolean) });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramString, paramBoolean);
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    QLog.d("CmShow_CmShowRenderView", 1, "disposeAvatar");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a(paramList, paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.a();
    }
  }
  
  public void c()
  {
    QLog.d("CmShow_CmShowRenderView", 1, "onDestroy");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloSdkRenderViewController.c();
    }
    jdField_a_of_type_JavaUtilHashMap.remove(toString());
  }
  
  public void setTouchEventRect(Rect paramRect1, Rect paramRect2, String paramString1, Rect paramRect3, String paramString2)
  {
    QLog.d("CmShow_CmShowRenderView", 1, new Object[] { "setTouchEventRect leftRect:", paramRect2, " leftUin:", paramString1, " rightRect:", paramRect3, " rightUin:", paramString2 });
    ApolloRender localApolloRender = getRender();
    if (localApolloRender != null)
    {
      ApolloRender.setAABBCallBack(localApolloRender, paramRect2.left, paramRect1.bottom - paramRect2.bottom, paramRect2.right - paramRect2.left, paramRect2.bottom - paramRect2.top, paramString1, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
      ApolloRender.setAABBCallBack(localApolloRender, paramRect3.left, paramRect1.bottom - paramRect3.bottom, paramRect3.right - paramRect3.left, paramRect3.bottom - paramRect3.top, paramString2, "", 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowRenderView
 * JD-Core Version:    0.7.0.1
 */