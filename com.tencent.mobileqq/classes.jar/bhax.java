import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bhax<T, E>
{
  private static final String TAG = "StateMachine";
  private bhax<T, E>.bhaz<T> mCurrState;
  private List<E> mEvents = new ArrayList();
  private List<bhay> mStateListeners = new ArrayList();
  private Map<bhaz, List<bhba>> mStateTransferMap = new HashMap();
  
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
        Object localObject4 = (bhaz)((Map.Entry)localObject3).getKey();
        if (this.mCurrState == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bhba)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(bhba.a((bhba)localObject4)))) {
              break;
            }
            setCurrState(bhba.b((bhba)localObject4));
            this.mEvents.remove(localObject2);
          }
        }
      }
    }
  }
  
  public void addStateChangeListener(bhay parambhay)
  {
    try
    {
      if (!this.mStateListeners.contains(parambhay)) {
        this.mStateListeners.add(parambhay);
      }
      return;
    }
    finally
    {
      parambhay = finally;
      throw parambhay;
    }
  }
  
  public void addStateTransfer(bhax<T, E>.bhba<E> parambhax)
  {
    if ((parambhax == null) || (bhba.a(parambhax) == null)) {
      return;
    }
    List localList = (List)this.mStateTransferMap.get(parambhax.a());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.mStateTransferMap.put(bhba.a(parambhax), localObject);
    }
    ((List)localObject).add(parambhax);
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
        Object localObject2 = (bhaz)((Map.Entry)localObject1).getKey();
        if (this.mCurrState != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bhba)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(bhba.a((bhba)localObject2))))
          {
            setCurrState(bhba.b((bhba)localObject2));
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
  
  public bhaz getCurrState()
  {
    return this.mCurrState;
  }
  
  protected void notifyStateChange(bhaz parambhaz1, bhaz parambhaz2)
  {
    try
    {
      parambhaz1 = this.mStateListeners.iterator();
      while (parambhaz1.hasNext())
      {
        parambhaz2 = (bhay)parambhaz1.next();
        if (parambhaz2 != null) {
          parambhaz2.onStateChanged();
        }
      }
    }
    finally {}
  }
  
  public boolean removeStateChangeListener(bhay parambhay)
  {
    try
    {
      boolean bool = this.mStateListeners.remove(parambhay);
      return bool;
    }
    finally
    {
      parambhay = finally;
      throw parambhay;
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
        Object localObject2 = (bhaz)((Map.Entry)localObject1).getKey();
        if (this.mCurrState == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bhba)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(bhba.a((bhba)localObject2)))) {
              break;
            }
            setCurrState(bhba.b((bhba)localObject2));
          }
        }
      }
    }
  }
  
  public void setCurrState(bhaz parambhaz)
  {
    bhaz localbhaz = getCurrState();
    if ((parambhaz == null) || (parambhaz == this.mCurrState)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.mCurrState != null) {}
    for (Object localObject = this.mCurrState.a;; localObject = "N/A")
    {
      QMLog.i("StateMachine", localObject + " to " + parambhaz.a);
      this.mCurrState = parambhaz;
      this.mCurrState.a();
      autoConsumeCacheEvents();
      if (parambhaz == localbhaz) {
        break;
      }
      notifyStateChange(localbhaz, parambhaz);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhax
 * JD-Core Version:    0.7.0.1
 */