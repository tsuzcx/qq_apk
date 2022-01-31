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

public class bavh
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bavd jdField_a_of_type_Bavd;
  private bavk jdField_a_of_type_Bavk;
  private bavm jdField_a_of_type_Bavm;
  private bavt jdField_a_of_type_Bavt;
  private bavv jdField_a_of_type_Bavv;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bavv b;
  
  public bavh(Context paramContext, bavd parambavd)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bavd = parambavd;
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
    if ((this.jdField_a_of_type_Bavm == null) || (this.jdField_a_of_type_Bavm.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bavm);
    int i = this.jdField_a_of_type_Bavm.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bavm.a = this.jdField_a_of_type_Bavm.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bavm.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bavl parambavl)
  {
    if (parambavl == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambavl.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bavm != null) && (this.jdField_a_of_type_Bavm.a != null) && (this.jdField_a_of_type_Bavm.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bavj(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bavu(str, i, this.b).a();
  }
  
  public void a(bavo parambavo)
  {
    if ((this.jdField_a_of_type_Bavd == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bavd.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bavd.a(), parambavo);
  }
  
  public void a(String paramString, bavk parambavk)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bavk = parambavk;
    if (this.jdField_a_of_type_Bavv == null) {
      this.jdField_a_of_type_Bavv = new bavi(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bavu(paramString, i, this.jdField_a_of_type_Bavv).a();
  }
  
  public void a(String paramString, bavt parambavt)
  {
    this.jdField_a_of_type_Bavt = parambavt;
    new bavs(paramString, parambavt).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bavd == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bavm != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bavm.b)))
    {
      str = this.jdField_a_of_type_Bavm.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Bavd.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bavo parambavo)
  {
    if (this.jdField_a_of_type_Bavd == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bavd.a(), parambavo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavh
 * JD-Core Version:    0.7.0.1
 */