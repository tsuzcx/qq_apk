import com.tencent.common.app.AppInterface;

class bnll
  extends bnju
{
  bnll(bnlk parambnlk, AppInterface paramAppInterface) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, bnme parambnme)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
    if (paramBoolean)
    {
      bnlk.a(this.jdField_a_of_type_Bnlk).a(parambnme);
      return;
    }
    bnlk.a(this.jdField_a_of_type_Bnlk).a(new bnme());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnll
 * JD-Core Version:    0.7.0.1
 */