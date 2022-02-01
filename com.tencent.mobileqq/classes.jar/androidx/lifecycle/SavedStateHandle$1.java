package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SavedStateHandle$1
  implements SavedStateRegistry.SavedStateProvider
{
  SavedStateHandle$1(SavedStateHandle paramSavedStateHandle) {}
  
  @NonNull
  public Bundle saveState()
  {
    Object localObject1 = new HashMap(this.this$0.mSavedStateProviders).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = ((SavedStateRegistry.SavedStateProvider)((Map.Entry)localObject2).getValue()).saveState();
      this.this$0.set((String)((Map.Entry)localObject2).getKey(), localObject3);
    }
    Object localObject3 = this.this$0.mRegular.keySet();
    localObject1 = new ArrayList(((Set)localObject3).size());
    Object localObject2 = new ArrayList(((ArrayList)localObject1).size());
    localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      String str = (String)((Iterator)localObject3).next();
      ((ArrayList)localObject1).add(str);
      ((ArrayList)localObject2).add(this.this$0.mRegular.get(str));
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putParcelableArrayList("keys", (ArrayList)localObject1);
    ((Bundle)localObject3).putParcelableArrayList("values", (ArrayList)localObject2);
    return localObject3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandle.1
 * JD-Core Version:    0.7.0.1
 */