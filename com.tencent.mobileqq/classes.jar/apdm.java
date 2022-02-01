import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class apdm
  implements BusinessObserver
{
  private static apdm jdField_a_of_type_Apdm;
  private int jdField_a_of_type_Int;
  private final SparseArray<apdl> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static apdm a()
  {
    if (jdField_a_of_type_Apdm == null) {}
    try
    {
      if (jdField_a_of_type_Apdm == null) {
        jdField_a_of_type_Apdm = new apdm();
      }
      return jdField_a_of_type_Apdm;
    }
    finally {}
  }
  
  public int a(Context paramContext, apct paramapct)
  {
    return a(new apdl(paramContext, paramapct));
  }
  
  public int a(Context paramContext, apcy paramapcy)
  {
    return a(new apdl(paramContext, paramapcy));
  }
  
  public int a(apdl paramapdl)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramapdl);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    apdl localapdl = (apdl)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localapdl.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localapdl.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdm
 * JD-Core Version:    0.7.0.1
 */