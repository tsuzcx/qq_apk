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

public class bgpz
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bgpv jdField_a_of_type_Bgpv;
  private bgqc jdField_a_of_type_Bgqc;
  private bgqe jdField_a_of_type_Bgqe;
  private bgql jdField_a_of_type_Bgql;
  private bgqn jdField_a_of_type_Bgqn;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bgqn b;
  
  public bgpz(Context paramContext, bgpv parambgpv)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bgpv = parambgpv;
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
    if ((this.jdField_a_of_type_Bgqe == null) || (this.jdField_a_of_type_Bgqe.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bgqe);
    int i = this.jdField_a_of_type_Bgqe.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bgqe.a = this.jdField_a_of_type_Bgqe.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bgqe.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bgqd parambgqd)
  {
    if (parambgqd == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambgqd.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bgqe != null) && (this.jdField_a_of_type_Bgqe.a != null) && (this.jdField_a_of_type_Bgqe.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bgqb(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bgqm(str, i, this.b).a();
  }
  
  public void a(bgqg parambgqg)
  {
    if ((this.jdField_a_of_type_Bgpv == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bgpv.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgpv.a(), parambgqg);
  }
  
  public void a(String paramString, bgqc parambgqc)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bgqc = parambgqc;
    if (this.jdField_a_of_type_Bgqn == null) {
      this.jdField_a_of_type_Bgqn = new bgqa(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bgqm(paramString, i, this.jdField_a_of_type_Bgqn).a();
  }
  
  public void a(String paramString, bgql parambgql)
  {
    this.jdField_a_of_type_Bgql = parambgql;
    new bgqk(paramString, parambgql).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bgpv == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bgqe != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bgqe.b)))
    {
      str = this.jdField_a_of_type_Bgqe.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Bgpv.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bgqg parambgqg)
  {
    if (this.jdField_a_of_type_Bgpv == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bgpv.a(), parambgqg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgpz
 * JD-Core Version:    0.7.0.1
 */