import android.os.Bundle;
import com.tencent.mobileqq.highway.transaction.Transaction;

public class barf
  extends barg
{
  public barf(bard parambard, int paramInt)
  {
    super(parambard, paramInt);
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_Bard.a)) {
      return;
    }
    e();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      c();
    }
  }
  
  public void c()
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("isVideo", 0);
    if (this.b != null)
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.b);
    }
    for (;;)
    {
      bare.a().a(bool, this.jdField_a_of_type_Int, localBundle);
      return;
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
      bool = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barf
 * JD-Core Version:    0.7.0.1
 */