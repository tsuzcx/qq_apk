import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class aqgq
  implements BusinessObserver
{
  private static aqgq jdField_a_of_type_Aqgq;
  private int jdField_a_of_type_Int;
  private final SparseArray<aqgp> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static aqgq a()
  {
    if (jdField_a_of_type_Aqgq == null) {}
    try
    {
      if (jdField_a_of_type_Aqgq == null) {
        jdField_a_of_type_Aqgq = new aqgq();
      }
      return jdField_a_of_type_Aqgq;
    }
    finally {}
  }
  
  public int a(Context paramContext, aqfx paramaqfx)
  {
    return a(new aqgp(paramContext, paramaqfx));
  }
  
  public int a(Context paramContext, aqgc paramaqgc)
  {
    return a(new aqgp(paramContext, paramaqgc));
  }
  
  public int a(aqgp paramaqgp)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramaqgp);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    aqgp localaqgp = (aqgp)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localaqgp.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localaqgp.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgq
 * JD-Core Version:    0.7.0.1
 */