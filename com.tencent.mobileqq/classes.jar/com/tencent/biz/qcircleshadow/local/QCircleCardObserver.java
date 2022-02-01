package com.tencent.biz.qcircleshadow.local;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleProfileCardChangeListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleCardObserver
  extends ProfileCardObserver
{
  private ConcurrentHashMap<Integer, WeakReference<QCircleProfileCardChangeListener>> a = new ConcurrentHashMap();
  
  public void a()
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public void a(QCircleProfileCardChangeListener paramQCircleProfileCardChangeListener)
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(Integer.valueOf(paramQCircleProfileCardChangeListener.hashCode()), new WeakReference(paramQCircleProfileCardChangeListener));
    }
  }
  
  public void b(QCircleProfileCardChangeListener paramQCircleProfileCardChangeListener)
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(Integer.valueOf(paramQCircleProfileCardChangeListener.hashCode()));
    }
  }
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger != null)
        {
          WeakReference localWeakReference = (WeakReference)this.a.get(localInteger);
          if ((localWeakReference != null) && (localWeakReference.get() != null)) {
            ((QCircleProfileCardChangeListener)localWeakReference.get()).updateNickName(paramCard.strNick, paramCard.uin);
          } else {
            this.a.remove(localInteger);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.QCircleCardObserver
 * JD-Core Version:    0.7.0.1
 */