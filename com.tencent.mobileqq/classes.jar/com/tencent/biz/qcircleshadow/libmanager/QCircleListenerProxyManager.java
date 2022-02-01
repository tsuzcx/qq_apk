package com.tencent.biz.qcircleshadow.libmanager;

import android.util.SparseArray;
import com.tencent.aelight.camera.api.IAEEditorGenerateResultListener;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.aelight.camera.api.IAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorGenerateResultListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleAEEditorUICallbackListener;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.biz.qcircleshadow.listenerproxy.QCircleAEEditorGenerateResultListenerProxy;
import com.tencent.biz.qcircleshadow.listenerproxy.QCircleAEEditorUICallbackListenerProxy;
import com.tencent.biz.qcircleshadow.listenerproxy.QCircleWXShareListenerProxy;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QCircleListenerProxyManager
{
  private static final String TAG = "QCircleListenerProxyManager";
  private static volatile QCircleListenerProxyManager sInstance;
  private SparseArray<IAEEditorGenerateResultListener> mMapAEEditorResultListener = new SparseArray();
  private SparseArray<IAEEditorUICallbackListener> mMapAEEditorUICallbackListener = new SparseArray();
  private SparseArray<IWXShareHelperListener> mMapWXShareListener = new SparseArray();
  private ConcurrentLinkedQueue<IQQFrontBackListener> mQQFrontBackListener = new ConcurrentLinkedQueue();
  
  public static QCircleListenerProxyManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleListenerProxyManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void addQCircleAEEditorGenerateResultListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    if (paramQCircleAEEditorGenerateResultListener == null) {
      return;
    }
    QCircleAEEditorGenerateResultListenerProxy localQCircleAEEditorGenerateResultListenerProxy = new QCircleAEEditorGenerateResultListenerProxy(paramQCircleAEEditorGenerateResultListener);
    this.mMapAEEditorResultListener.append(paramQCircleAEEditorGenerateResultListener.hashCode(), localQCircleAEEditorGenerateResultListenerProxy);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).addListener(localQCircleAEEditorGenerateResultListenerProxy);
  }
  
  public void addQCircleAEEditorUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    if (paramQCircleAEEditorUICallbackListener == null) {
      return;
    }
    QCircleAEEditorUICallbackListenerProxy localQCircleAEEditorUICallbackListenerProxy = new QCircleAEEditorUICallbackListenerProxy(paramQCircleAEEditorUICallbackListener);
    this.mMapAEEditorUICallbackListener.append(paramQCircleAEEditorUICallbackListener.hashCode(), localQCircleAEEditorUICallbackListenerProxy);
    ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).addUICallbackListener(localQCircleAEEditorUICallbackListenerProxy);
  }
  
  public void addQCircleWXShareListener(QCircleWXShareListener paramQCircleWXShareListener)
  {
    if (paramQCircleWXShareListener == null) {
      return;
    }
    QCircleWXShareListenerProxy localQCircleWXShareListenerProxy = new QCircleWXShareListenerProxy(paramQCircleWXShareListener);
    this.mMapWXShareListener.append(paramQCircleWXShareListener.hashCode(), localQCircleWXShareListenerProxy);
    ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).addObserver(localQCircleWXShareListenerProxy);
  }
  
  public void addQQFrontBackListener(IQQFrontBackListener paramIQQFrontBackListener)
  {
    if (paramIQQFrontBackListener == null) {
      return;
    }
    this.mQQFrontBackListener.add(paramIQQFrontBackListener);
  }
  
  public void onQQEnterBackground()
  {
    Iterator localIterator = this.mQQFrontBackListener.iterator();
    while (localIterator.hasNext()) {
      ((IQQFrontBackListener)localIterator.next()).onQQEnterBackground();
    }
  }
  
  public void onQQEnterForeground()
  {
    Iterator localIterator = this.mQQFrontBackListener.iterator();
    while (localIterator.hasNext()) {
      ((IQQFrontBackListener)localIterator.next()).onQQEnterForeground();
    }
  }
  
  public void removeQCircleAEEditorGenerateResultListener(QCircleAEEditorGenerateResultListener paramQCircleAEEditorGenerateResultListener)
  {
    if (paramQCircleAEEditorGenerateResultListener == null) {
      return;
    }
    paramQCircleAEEditorGenerateResultListener = (IAEEditorGenerateResultListener)this.mMapAEEditorResultListener.get(paramQCircleAEEditorGenerateResultListener.hashCode());
    if (paramQCircleAEEditorGenerateResultListener != null) {
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeListener(paramQCircleAEEditorGenerateResultListener);
    }
  }
  
  public void removeQCircleAEEditorUICallbackListener(QCircleAEEditorUICallbackListener paramQCircleAEEditorUICallbackListener)
  {
    if (paramQCircleAEEditorUICallbackListener == null) {
      return;
    }
    paramQCircleAEEditorUICallbackListener = (IAEEditorUICallbackListener)this.mMapAEEditorUICallbackListener.get(paramQCircleAEEditorUICallbackListener.hashCode());
    if (paramQCircleAEEditorUICallbackListener != null) {
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).removeUICallbackListener(paramQCircleAEEditorUICallbackListener);
    }
  }
  
  public void removeQCircleWXShareListener(QCircleWXShareListener paramQCircleWXShareListener)
  {
    if (paramQCircleWXShareListener == null) {
      return;
    }
    paramQCircleWXShareListener = (IWXShareHelperListener)this.mMapWXShareListener.get(paramQCircleWXShareListener.hashCode());
    if (paramQCircleWXShareListener != null) {
      ((IWXShareHelper)QRoute.api(IWXShareHelper.class)).removeObserver(paramQCircleWXShareListener);
    }
  }
  
  public void removeQQFrontBackListener(IQQFrontBackListener paramIQQFrontBackListener)
  {
    if (paramIQQFrontBackListener == null) {
      return;
    }
    this.mQQFrontBackListener.remove(paramIQQFrontBackListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager
 * JD-Core Version:    0.7.0.1
 */