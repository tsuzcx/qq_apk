import com.tencent.common.app.AppInterface;

class bkur
  extends bkvo
{
  bkur(bkup parambkup, AppInterface paramAppInterface) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (bkup.a(this.jdField_a_of_type_Bkup))
      {
        bkup.a(this.jdField_a_of_type_Bkup, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkur
 * JD-Core Version:    0.7.0.1
 */