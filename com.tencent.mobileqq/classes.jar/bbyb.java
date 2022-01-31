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

public class bbyb
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bbxx jdField_a_of_type_Bbxx;
  private bbye jdField_a_of_type_Bbye;
  private bbyg jdField_a_of_type_Bbyg;
  private bbyn jdField_a_of_type_Bbyn;
  private bbyp jdField_a_of_type_Bbyp;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private bbyp b;
  
  public bbyb(Context paramContext, bbxx parambbxx)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bbxx = parambbxx;
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
    if ((this.jdField_a_of_type_Bbyg == null) || (this.jdField_a_of_type_Bbyg.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Bbyg);
    int i = this.jdField_a_of_type_Bbyg.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Bbyg.a = this.jdField_a_of_type_Bbyg.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Bbyg.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bbyf parambbyf)
  {
    if (parambbyf == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambbyf.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Bbyg != null) && (this.jdField_a_of_type_Bbyg.a != null) && (this.jdField_a_of_type_Bbyg.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bbyd(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bbyo(str, i, this.b).a();
  }
  
  public void a(bbyi parambbyi)
  {
    if ((this.jdField_a_of_type_Bbxx == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Bbxx.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbxx.a(), parambbyi);
  }
  
  public void a(String paramString, bbye parambbye)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bbye = parambbye;
    if (this.jdField_a_of_type_Bbyp == null) {
      this.jdField_a_of_type_Bbyp = new bbyc(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new bbyo(paramString, i, this.jdField_a_of_type_Bbyp).a();
  }
  
  public void a(String paramString, bbyn parambbyn)
  {
    this.jdField_a_of_type_Bbyn = parambbyn;
    new bbym(paramString, parambbyn).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Bbxx == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Bbyg != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bbyg.b)))
    {
      str = this.jdField_a_of_type_Bbyg.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Bbxx.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(bbyi parambbyi)
  {
    if (this.jdField_a_of_type_Bbxx == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbxx.a(), parambbyi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyb
 * JD-Core Version:    0.7.0.1
 */