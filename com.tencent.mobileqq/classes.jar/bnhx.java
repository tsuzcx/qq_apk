import com.tencent.common.app.AppInterface;

class bnhx
  extends bnju
{
  bnhx(bnhv parambnhv, AppInterface paramAppInterface) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (bnhv.a(this.jdField_a_of_type_Bnhv))
      {
        bnhv.a(this.jdField_a_of_type_Bnhv, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhx
 * JD-Core Version:    0.7.0.1
 */