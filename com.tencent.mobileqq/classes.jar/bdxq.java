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

public class bdxq
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bdxm jdField_a_of_type_Bdxm;
  private bdxt jdField_a_of_type_Bdxt;
  private bdxv jdField_a_of_type_Bdxv;
  private bdyc jdField_a_of_type_Bdyc;
  private bdye jdField_a_of_type_Bdye;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bdye b;
  
  public bdxq(Context paramContext, bdxm parambdxm)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdxm = parambdxm;
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
    if ((this.jdField_a_of_type_Bdxv == null) || (this.jdField_a_of_type_Bdxv.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bdxv);
    int i = this.jdField_a_of_type_Bdxv.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bdxv.a = this.jdField_a_of_type_Bdxv.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bdxv.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bdxu parambdxu)
  {
    if (parambdxu == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambdxu.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bdxv != null) && (this.jdField_a_of_type_Bdxv.a != null) && (this.jdField_a_of_type_Bdxv.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bdxs(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bdyd(str, i, this.b).a();
  }
  
  public void a(bdxx parambdxx)
  {
    if ((this.jdField_a_of_type_Bdxm == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bdxm.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bdxm.a(), parambdxx);
  }
  
  public void a(String paramString, bdxt parambdxt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bdxt = parambdxt;
    if (this.jdField_a_of_type_Bdye == null) {
      this.jdField_a_of_type_Bdye = new bdxr(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bdyd(paramString, i, this.jdField_a_of_type_Bdye).a();
  }
  
  public void a(String paramString, bdyc parambdyc)
  {
    this.jdField_a_of_type_Bdyc = parambdyc;
    new bdyb(paramString, parambdyc).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bdxm == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bdxv != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bdxv.b)))
    {
      str = this.jdField_a_of_type_Bdxv.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Bdxm.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bdxx parambdxx)
  {
    if (this.jdField_a_of_type_Bdxm == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bdxm.a(), parambdxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxq
 * JD-Core Version:    0.7.0.1
 */