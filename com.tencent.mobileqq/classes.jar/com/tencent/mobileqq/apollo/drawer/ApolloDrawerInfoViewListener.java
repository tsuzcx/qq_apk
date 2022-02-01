package com.tencent.mobileqq.apollo.drawer;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class ApolloDrawerInfoViewListener
  extends ApolloExtensionObserver
  implements ISurfaceStateListener, ITouchListener
{
  private WeakReference<SpriteDrawerInfoManager> a;
  private int b = 0;
  private volatile String c = null;
  
  public ApolloDrawerInfoViewListener(SpriteDrawerInfoManager paramSpriteDrawerInfoManager, int paramInt)
  {
    this.a = new WeakReference(paramSpriteDrawerInfoManager);
    this.b = paramInt;
  }
  
  private IApolloResManager a()
  {
    Scene localScene;
    if (this.b == 2) {
      localScene = Scene.FRIEND_CARD;
    } else {
      localScene = Scene.DRAWER;
    }
    return ApolloResManagerFacade.a.a(localScene);
  }
  
  private void a(ApolloManagerServiceImpl paramApolloManagerServiceImpl)
  {
    Object localObject = paramApolloManagerServiceImpl.getMemeActionList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)((Iterator)localObject).next();
        if ((localApolloActionData != null) && (localApolloActionData.isForPlayerAction != 0)) {
          paramApolloManagerServiceImpl.handleMemeGetFrame("apolloDrawerInfoViewListener", localApolloActionData, new ApolloDrawerInfoViewListener.FrameCallback(localApolloActionData), a());
        }
      }
    }
  }
  
  private boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if (paramArrayList.contains(paramString))
      {
        paramString = ApolloPanelUtil.a(paramString, a());
        paramArrayList = new StringBuilder();
        paramArrayList.append("check needReGetFrame, current dressInfo:");
        paramArrayList.append(paramString);
        paramArrayList.append(", old dressInfo:");
        paramArrayList.append(this.c);
        QLog.d("[cmshow]ApolloDrawerInfoViewListener", 1, paramArrayList.toString());
        if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.c)))
        {
          this.c = paramString;
          return true;
        }
      }
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onSurfaceReady], w:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",h:");
      localStringBuilder.append(paramInt2);
      QLog.d("[cmshow]ApolloDrawerInfoViewListener", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.1(this), 8, null, true);
  }
  
  public void a(int paramInt, @NotNull String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.a.get() != null)
    {
      SpriteActionScript localSpriteActionScript = ((SpriteDrawerInfoManager)this.a.get()).e();
      if (localSpriteActionScript != null) {
        localSpriteActionScript.a(SpriteUtil.a(paramInt), null, paramString);
      }
    }
  }
  
  public void a(@NotNull String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onApolloDressChange], result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",data:");
      localStringBuilder.append(paramObject);
      QLog.d("[cmshow]ApolloDrawerInfoViewListener", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ApolloDrawerInfoViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoViewListener
 * JD-Core Version:    0.7.0.1
 */