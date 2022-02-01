package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class SavedStateHandle$1
  implements SavedStateRegistry.SavedStateProvider
{
  SavedStateHandle$1(SavedStateHandle paramSavedStateHandle) {}
  
  @NonNull
  public Bundle saveState()
  {
    Object localObject = this.this$0.mRegular.keySet();
    ArrayList localArrayList1 = new ArrayList(((Set)localObject).size());
    ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localArrayList1.add(str);
      localArrayList2.add(this.this$0.mRegular.get(str));
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("keys", localArrayList1);
    ((Bundle)localObject).putParcelableArrayList("values", localArrayList2);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.lifecycle.SavedStateHandle.1
 * JD-Core Version:    0.7.0.1
 */