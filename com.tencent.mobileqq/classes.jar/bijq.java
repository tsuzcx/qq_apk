import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoPayFailLayoutView;
import java.util.List;

public class bijq
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bijm jdField_a_of_type_Bijm;
  private bijt jdField_a_of_type_Bijt;
  private bijv jdField_a_of_type_Bijv;
  private bikc jdField_a_of_type_Bikc;
  private bike jdField_a_of_type_Bike;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bike b;
  
  public bijq(Context paramContext, bijm parambijm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bijm = parambijm;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof RegisterByNicknameAndPwdActivity)) {
      return ((RegisterByNicknameAndPwdActivity)this.jdField_a_of_type_AndroidContentContext).a();
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof RegisterPersonalInfoActivity)) {
      return ((RegisterPersonalInfoActivity)this.jdField_a_of_type_AndroidContentContext).a();
    }
    return false;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bijv == null) || (this.jdField_a_of_type_Bijv.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bijv);
    int i = this.jdField_a_of_type_Bijv.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bijv.a = this.jdField_a_of_type_Bijv.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bijv.a.clear();
  }
  
  public RegisterLiangHaoChoiceLayoutView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView = new RegisterLiangHaoChoiceLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  }
  
  public RegisterLiangHaoPayFailLayoutView a(biju parambiju)
  {
    if (parambiju == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambiju.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bijv != null) && (this.jdField_a_of_type_Bijv.a != null) && (this.jdField_a_of_type_Bijv.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bijs(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bikd(str, i, this.b).a();
  }
  
  public void a(bijx parambijx)
  {
    if ((this.jdField_a_of_type_Bijm == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bijm.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bijm.a(), parambijx);
  }
  
  public void a(String paramString, bijt parambijt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bijt = parambijt;
    if (this.jdField_a_of_type_Bike == null) {
      this.jdField_a_of_type_Bike = new bijr(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bikd(paramString, i, this.jdField_a_of_type_Bike).a();
  }
  
  public void a(String paramString, bikc parambikc)
  {
    this.jdField_a_of_type_Bikc = parambikc;
    new bikb(paramString, parambikc).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bijm == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bijv != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bijv.b)))
    {
      str = this.jdField_a_of_type_Bijv.b;
      if (str.indexOf("?") >= 0) {
        break label146;
      }
    }
    label146:
    for (String str = str + "?phone=" + this.jdField_a_of_type_JavaLangString;; str = str + "&phone=" + this.jdField_a_of_type_JavaLangString)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtras(this.jdField_a_of_type_Bijm.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bijx parambijx)
  {
    if (this.jdField_a_of_type_Bijm == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bijm.a(), parambijx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bijq
 * JD-Core Version:    0.7.0.1
 */