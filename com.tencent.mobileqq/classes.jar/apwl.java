import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class apwl
  implements BusinessObserver
{
  private static apwl jdField_a_of_type_Apwl;
  private int jdField_a_of_type_Int;
  private final SparseArray<apwk> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static apwl a()
  {
    if (jdField_a_of_type_Apwl == null) {}
    try
    {
      if (jdField_a_of_type_Apwl == null) {
        jdField_a_of_type_Apwl = new apwl();
      }
      return jdField_a_of_type_Apwl;
    }
    finally {}
  }
  
  public int a(Context paramContext, apvs paramapvs)
  {
    return a(new apwk(paramContext, paramapvs));
  }
  
  public int a(Context paramContext, apvx paramapvx)
  {
    return a(new apwk(paramContext, paramapvx));
  }
  
  public int a(apwk paramapwk)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramapwk);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    apwk localapwk = (apwk)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localapwk.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localapwk.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwl
 * JD-Core Version:    0.7.0.1
 */