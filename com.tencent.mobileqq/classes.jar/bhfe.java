import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bhfe<T, E>
{
  private static final String TAG = "StateMachine";
  private bhfe<T, E>.bhfg<T> mCurrState;
  private List<E> mEvents = new ArrayList();
  private List<bhff> mStateListeners = new ArrayList();
  private Map<bhfg, List<bhfh>> mStateTransferMap = new HashMap();
  
  private void autoConsumeCacheEvents()
  {
    Object localObject1 = new ArrayList(this.mEvents);
    if (((List)localObject1).size() <= 0) {
      label21:
      return;
    } else {
      localObject1 = ((List)localObject1).iterator();
    }
    label182:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label21;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label182;
        }
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject4 = (bhfg)((Map.Entry)localObject3).getKey();
        if (this.mCurrState == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bhfh)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(bhfh.a((bhfh)localObject4)))) {
              break;
            }
            setCurrState(bhfh.b((bhfh)localObject4));
            this.mEvents.remove(localObject2);
          }
        }
      }
    }
  }
  
  public void addStateChangeListener(bhff parambhff)
  {
    try
    {
      if (!this.mStateListeners.contains(parambhff)) {
        this.mStateListeners.add(parambhff);
      }
      return;
    }
    finally
    {
      parambhff = finally;
      throw parambhff;
    }
  }
  
  public void addStateTransfer(bhfe<T, E>.bhfh<E> parambhfe)
  {
    if ((parambhfe == null) || (bhfh.a(parambhfe) == null)) {
      return;
    }
    List localList = (List)this.mStateTransferMap.get(parambhfe.a());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mStateTransferMap.put(bhfh.a(parambhfe), localObject);
    }
    ((List)localObject).add(parambhfe);
  }
  
  public void appendEvent(E paramE)
  {
    if ((paramE == null) || (this.mCurrState == null)) {}
    label156:
    label157:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (bhfg)((Map.Entry)localObject1).getKey();
        if (this.mCurrState != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bhfh)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(bhfh.a((bhfh)localObject2))))
          {
            setCurrState(bhfh.b((bhfh)localObject2));
            i = 1;
          }
        }
      }
      for (;;)
      {
        break;
        if (i != 0) {
          break label157;
        }
        this.mEvents.add(paramE);
        return;
      }
    }
  }
  
  public bhfg getCurrState()
  {
    return this.mCurrState;
  }
  
  protected void notifyStateChange(bhfg parambhfg1, bhfg parambhfg2)
  {
    try
    {
      parambhfg1 = this.mStateListeners.iterator();
      while (parambhfg1.hasNext())
      {
        parambhfg2 = (bhff)parambhfg1.next();
        if (parambhfg2 != null) {
          parambhfg2.onStateChanged();
        }
      }
    }
    finally {}
  }
  
  public boolean removeStateChangeListener(bhff parambhff)
  {
    try
    {
      boolean bool = this.mStateListeners.remove(parambhff);
      return bool;
    }
    finally
    {
      parambhff = finally;
      throw parambhff;
    }
  }
  
  public void sendEvent(E paramE)
  {
    if ((paramE == null) || (this.mCurrState == null)) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator = this.mStateTransferMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (bhfg)((Map.Entry)localObject1).getKey();
        if (this.mCurrState == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bhfh)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(bhfh.a((bhfh)localObject2)))) {
              break;
            }
            setCurrState(bhfh.b((bhfh)localObject2));
          }
        }
      }
    }
  }
  
  public void setCurrState(bhfg parambhfg)
  {
    bhfg localbhfg = getCurrState();
    if ((parambhfg == null) || (parambhfg == this.mCurrState)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.mCurrState != null) {}
    for (Object localObject = this.mCurrState.a;; localObject = "N/A")
    {
      QMLog.i("StateMachine", localObject + " to " + parambhfg.a);
      this.mCurrState = parambhfg;
      this.mCurrState.a();
      autoConsumeCacheEvents();
      if (parambhfg == localbhfg) {
        break;
      }
      notifyStateChange(localbhfg, parambhfg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfe
 * JD-Core Version:    0.7.0.1
 */