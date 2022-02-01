import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class awim
  extends awid
{
  public awim(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof agab)) {
      ((agab)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).b();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_Awil.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin();
    if (this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_Awil.jdField_a_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_Awik = new awik();
    this.jdField_a_of_type_Awik.jdField_a_of_type_JavaLangString = "c2c_AIO";
    this.jdField_a_of_type_Awik.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Awik.b = "";
  }
  
  public void k()
  {
    if ((behu.a().k_()) && (!bdfk.a())) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("BaseListenTogetherPanel_C2C", 1, String.format("[music-panel] onVasSkinStateChange mutualLevel=%d vasSkinShowing [%b-->%b]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Awil.f), Boolean.valueOf(this.e), Boolean.valueOf(bool) }));
      if (bool != this.e)
      {
        this.e = bool;
        a(this.jdField_a_of_type_Awil);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awim
 * JD-Core Version:    0.7.0.1
 */