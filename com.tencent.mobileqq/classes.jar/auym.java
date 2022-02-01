import android.os.Bundle;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class auym
  implements BusinessObserver
{
  private int jdField_a_of_type_Int;
  private final SparseArray<WeakReference<auyo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    int j = 0;
    int i;
    if (paramBundle != null) {
      i = paramBundle.getInt("req_id");
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
      {
        localObject1 = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if (localObject1 == null) {
          break label149;
        }
        localObject2 = (auyo)((WeakReference)localObject1).get();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
          return;
        }
        i = paramBundle.getInt("result");
        j = paramBundle.getInt("jump_result");
        ??? = paramBundle.getString("jump_url");
        localObject2 = paramBundle.getString("ext_info");
        paramBundle = (Bundle)???;
        if (localObject1 == null) {
          break label148;
        }
        ((auyo)localObject1).a(paramBoolean, i, j, paramBundle, (String)localObject2);
        return;
      }
      Object localObject1 = null;
      Object localObject2 = null;
      paramBundle = null;
      i = 0;
      continue;
      label148:
      return;
      label149:
      localObject1 = null;
    }
  }
  
  int a(auyo paramauyo)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, new WeakReference(paramauyo));
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auym
 * JD-Core Version:    0.7.0.1
 */