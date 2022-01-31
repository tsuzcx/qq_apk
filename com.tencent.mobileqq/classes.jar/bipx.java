import com.tencent.common.app.AppInterface;

class bipx
  extends biqy
{
  bipx(bipv parambipv, AppInterface paramAppInterface) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (bipv.a(this.jdField_a_of_type_Bipv))
      {
        bipv.a(this.jdField_a_of_type_Bipv, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipx
 * JD-Core Version:    0.7.0.1
 */