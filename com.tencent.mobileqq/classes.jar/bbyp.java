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

public class bbyp
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bbyl jdField_a_of_type_Bbyl;
  private bbys jdField_a_of_type_Bbys;
  private bbyu jdField_a_of_type_Bbyu;
  private bbzb jdField_a_of_type_Bbzb;
  private bbzd jdField_a_of_type_Bbzd;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bbzd b;
  
  public bbyp(Context paramContext, bbyl parambbyl)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bbyl = parambbyl;
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
    if ((this.jdField_a_of_type_Bbyu == null) || (this.jdField_a_of_type_Bbyu.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bbyu);
    int i = this.jdField_a_of_type_Bbyu.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bbyu.a = this.jdField_a_of_type_Bbyu.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bbyu.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bbyt parambbyt)
  {
    if (parambbyt == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambbyt.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bbyu != null) && (this.jdField_a_of_type_Bbyu.a != null) && (this.jdField_a_of_type_Bbyu.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bbyr(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bbzc(str, i, this.b).a();
  }
  
  public void a(bbyw parambbyw)
  {
    if ((this.jdField_a_of_type_Bbyl == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bbyl.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbyl.a(), parambbyw);
  }
  
  public void a(String paramString, bbys parambbys)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bbys = parambbys;
    if (this.jdField_a_of_type_Bbzd == null) {
      this.jdField_a_of_type_Bbzd = new bbyq(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bbzc(paramString, i, this.jdField_a_of_type_Bbzd).a();
  }
  
  public void a(String paramString, bbzb parambbzb)
  {
    this.jdField_a_of_type_Bbzb = parambbzb;
    new bbza(paramString, parambbzb).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bbyl == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bbyu != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bbyu.b)))
    {
      str = this.jdField_a_of_type_Bbyu.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Bbyl.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bbyw parambbyw)
  {
    if (this.jdField_a_of_type_Bbyl == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbyl.a(), parambbyw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyp
 * JD-Core Version:    0.7.0.1
 */