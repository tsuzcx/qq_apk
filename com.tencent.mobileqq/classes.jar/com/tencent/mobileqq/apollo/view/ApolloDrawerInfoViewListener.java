package com.tencent.mobileqq.apollo.view;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApolloDrawerInfoViewListener
  extends ApolloExtensionObserverImpl
  implements OnApolloViewListener
{
  private int jdField_a_of_type_Int = 0;
  private volatile String jdField_a_of_type_JavaLangString = null;
  private WeakReference<SpriteDrawerInfoManager> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ApolloDrawerInfoViewListener(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramSpriteDrawerInfoManager);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(ApolloManagerServiceImpl paramApolloManagerServiceImpl)
  {
    Object localObject = paramApolloManagerServiceImpl.getCMSActionList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)((Iterator)localObject).next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction != 0)) {
          paramApolloManagerServiceImpl.handleCMSPlayerGetFrame("apolloPanel", localApolloActionData, new ApolloDrawerInfoViewListener.FrameCallback(localApolloActionData));
        }
      }
    }
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    if (paramArrayList.contains(paramString))
    {
      paramString = ApolloPanelUtil.a(paramString);
      QLog.d("ApolloDrawerInfoViewListener", 1, "check needReGetFrame, current dressInfo:" + paramString + ", old dressInfo:" + this.jdField_a_of_type_JavaLangString);
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        return true;
      }
    }
    return false;
  }
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      SpriteActionScript localSpriteActionScript = ((SpriteDrawerInfoManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localSpriteActionScript != null) {
        localSpriteActionScript.a(SpriteUtil.a(paramInt), null, paramString);
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.1(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener
 * JD-Core Version:    0.7.0.1
 */