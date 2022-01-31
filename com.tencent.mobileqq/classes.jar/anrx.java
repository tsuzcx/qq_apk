import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import mqq.observer.BusinessObserver;

public class anrx
  implements BusinessObserver
{
  private static anrx jdField_a_of_type_Anrx;
  private int jdField_a_of_type_Int;
  private final SparseArray<anrw> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public static anrx a()
  {
    if (jdField_a_of_type_Anrx == null) {}
    try
    {
      if (jdField_a_of_type_Anrx == null) {
        jdField_a_of_type_Anrx = new anrx();
      }
      return jdField_a_of_type_Anrx;
    }
    finally {}
  }
  
  public int a(Context paramContext, anre paramanre)
  {
    return a(new anrw(paramContext, paramanre));
  }
  
  public int a(Context paramContext, anrj paramanrj)
  {
    return a(new anrw(paramContext, paramanrj));
  }
  
  public int a(anrw paramanrw)
  {
    synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
    {
      SparseArray localSparseArray2 = this.jdField_a_of_type_AndroidUtilSparseArray;
      int i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      localSparseArray2.append(i, paramanrw);
      i = this.jdField_a_of_type_Int;
      return i;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = paramBundle.getInt("req_id");
    anrw localanrw = (anrw)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(i);
      return;
      localanrw.b(paramBoolean, paramBundle.getBoolean("allow_download", true), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"), paramBundle.getString("jump_url"));
      continue;
      localanrw.b(paramBoolean, paramBundle.getInt("jump", 0), paramBundle.getInt("err_code", 0), paramBundle.getString("err_msg"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrx
 * JD-Core Version:    0.7.0.1
 */