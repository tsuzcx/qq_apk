import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class anwg
  implements BusinessObserver
{
  private static anwg jdField_a_of_type_Anwg;
  private int jdField_a_of_type_Int;
  private final SparseArray<anwf> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static anwg a()
  {
    if (jdField_a_of_type_Anwg == null) {}
    try
    {
      if (jdField_a_of_type_Anwg == null) {
        jdField_a_of_type_Anwg = new anwg();
      }
      return jdField_a_of_type_Anwg;
    }
    finally {}
  }
  
  public int a(Context paramContext, anvn paramanvn)
  {
    return a(new anwf(paramContext, paramanvn));
  }
  
  public int a(Context paramContext, anvs paramanvs)
  {
    return a(new anwf(paramContext, paramanvs));
  }
  
  public int a(anwf paramanwf)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramanwf);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    anwf localanwf = (anwf)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localanwf.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localanwf.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwg
 * JD-Core Version:    0.7.0.1
 */