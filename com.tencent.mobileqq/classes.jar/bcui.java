import android.os.Bundle;
import com.tencent.mobileqq.highway.transaction.Transaction;

public class bcui
  extends bcuj
{
  public bcui(bcug parambcug, int paramInt)
  {
    super(parambcug, paramInt);
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_Bcug.a)) {
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
      bcuh.a().a(bool, this.jdField_a_of_type_Int, localBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcui
 * JD-Core Version:    0.7.0.1
 */