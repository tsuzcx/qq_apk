import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.qphone.base.util.QLog;

class amjf
  implements andx
{
  amjf(amje paramamje) {}
  
  public void a(int paramInt)
  {
    QLog.d("sava_ChatPieApolloViewController", 1, "sava_native_log preLoadApolloEngine onSoLoadComplete ret:" + paramInt);
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sava_ChatPieApolloViewController", 2, "sava_native_log preLoadApolloEngine onSoLoadComplete");
      }
      if (amje.a(this.a))
      {
        QLog.i("sava_ChatPieApolloViewController", 1, "onSoLoadComplete but AIO destroy!");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.preLoadDirector();
        amje.a(this.a);
      }
    }
    andw.b(this.a.jdField_a_of_type_Andx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjf
 * JD-Core Version:    0.7.0.1
 */