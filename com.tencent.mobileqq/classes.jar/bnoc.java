import com.tencent.common.app.AppInterface;

class bnoc
  extends bnoz
{
  bnoc(bnoa parambnoa, AppInterface paramAppInterface) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (bnoa.a(this.jdField_a_of_type_Bnoa))
      {
        bnoa.a(this.jdField_a_of_type_Bnoa, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnoc
 * JD-Core Version:    0.7.0.1
 */