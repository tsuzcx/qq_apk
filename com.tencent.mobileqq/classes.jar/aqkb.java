import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class aqkb
  implements BusinessObserver
{
  private static aqkb jdField_a_of_type_Aqkb;
  private int jdField_a_of_type_Int;
  private final SparseArray<aqka> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static aqkb a()
  {
    if (jdField_a_of_type_Aqkb == null) {}
    try
    {
      if (jdField_a_of_type_Aqkb == null) {
        jdField_a_of_type_Aqkb = new aqkb();
      }
      return jdField_a_of_type_Aqkb;
    }
    finally {}
  }
  
  public int a(Context paramContext, aqji paramaqji)
  {
    return a(new aqka(paramContext, paramaqji));
  }
  
  public int a(Context paramContext, aqjn paramaqjn)
  {
    return a(new aqka(paramContext, paramaqjn));
  }
  
  public int a(aqka paramaqka)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramaqka);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    aqka localaqka = (aqka)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localaqka.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localaqka.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkb
 * JD-Core Version:    0.7.0.1
 */