import com.tencent.common.app.AppInterface;

class bltu
  extends blur
{
  bltu(blts paramblts, AppInterface paramAppInterface) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean) {
      synchronized (blts.a(this.jdField_a_of_type_Blts))
      {
        blts.a(this.jdField_a_of_type_Blts, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltu
 * JD-Core Version:    0.7.0.1
 */