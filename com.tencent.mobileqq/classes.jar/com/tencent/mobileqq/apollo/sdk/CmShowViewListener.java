package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CmShowViewListener
  extends ApolloExtensionObserverImpl
  implements OnApolloViewListener
{
  private int jdField_a_of_type_Int = 3;
  private IRenderViewListener jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener;
  private WeakReference<CmShowScriptManager> jdField_a_of_type_JavaLangRefWeakReference;
  
  public CmShowViewListener(CmShowScriptManager paramCmShowScriptManager, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramCmShowScriptManager);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(IRenderViewListener paramIRenderViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener = paramIRenderViewListener;
  }
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new CmShowViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyLongTouch name", paramString });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener.a(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      CmShowSpriteActionScript localCmShowSpriteActionScript = ((CmShowScriptManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localCmShowSpriteActionScript != null) {
        localCmShowSpriteActionScript.a(SpriteUtil.a(paramInt), null, paramString);
      }
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart:", Integer.valueOf(paramInt), " apolloId:" + paramString });
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApiSdkIRenderViewListener.a(paramInt, paramString);
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new CmShowViewListener.1(this, paramInt1, paramInt2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener
 * JD-Core Version:    0.7.0.1
 */