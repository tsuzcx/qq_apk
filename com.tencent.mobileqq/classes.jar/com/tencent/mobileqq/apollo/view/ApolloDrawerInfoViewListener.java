package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import zdu;
import zdv;

public class ApolloDrawerInfoViewListener
  extends VasExtensionObserver
  implements OnApolloViewListener
{
  private int jdField_a_of_type_Int = 0;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ApolloDrawerInfoViewListener(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSpriteDrawerInfoManager);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  protected void l(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new zdv(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    SpriteActionScript localSpriteActionScript;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      localSpriteActionScript = ((SpriteDrawerInfoManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localSpriteActionScript != null) {
        if (paramInt != 7) {
          break label81;
        }
      }
    }
    label81:
    for (paramInt = 1;; paramInt = 0)
    {
      localSpriteActionScript.a(paramInt, null, paramString);
      return;
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new zdu(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener
 * JD-Core Version:    0.7.0.1
 */