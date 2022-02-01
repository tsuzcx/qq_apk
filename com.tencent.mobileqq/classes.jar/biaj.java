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

public class biaj
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private biaf jdField_a_of_type_Biaf;
  private biam jdField_a_of_type_Biam;
  private biao jdField_a_of_type_Biao;
  private biav jdField_a_of_type_Biav;
  private biax jdField_a_of_type_Biax;
  private RegisterLiangHaoChoiceLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoChoiceLayoutView;
  private RegisterLiangHaoPayFailLayoutView jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  private String jdField_a_of_type_JavaLangString;
  private biax b;
  
  public biaj(Context paramContext, biaf parambiaf)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biaf = parambiaf;
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
    if ((this.jdField_a_of_type_Biao == null) || (this.jdField_a_of_type_Biao.a == null)) {
      return;
    }
    a().a(this.jdField_a_of_type_Biao);
    int i = this.jdField_a_of_type_Biao.a.size();
    if (i > 4)
    {
      this.jdField_a_of_type_Biao.a = this.jdField_a_of_type_Biao.a.subList(4, i);
      return;
    }
    this.jdField_a_of_type_Biao.a.clear();
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
  
  public RegisterLiangHaoPayFailLayoutView a(bian parambian)
  {
    if (parambian == null) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView = new RegisterLiangHaoPayFailLayoutView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setUin(parambian.a);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView.setLiangHaoHelper(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVipLianghaoViewRegisterLiangHaoPayFailLayoutView;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Biao != null) && (this.jdField_a_of_type_Biao.a != null) && (this.jdField_a_of_type_Biao.a.size() >= 4))
    {
      c();
      return;
    }
    if (this.b == null) {
      this.b = new bial(this);
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new biaw(str, i, this.b).a();
  }
  
  public void a(biaq parambiaq)
  {
    if ((this.jdField_a_of_type_Biaf == null) || (!a())) {
      return;
    }
    this.jdField_a_of_type_Biaf.c();
    LiangHaoBuyFragment.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biaf.a(), parambiaq);
  }
  
  public void a(String paramString, biam parambiam)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Biam = parambiam;
    if (this.jdField_a_of_type_Biax == null) {
      this.jdField_a_of_type_Biax = new biak(this);
    }
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    new biaw(paramString, i, this.jdField_a_of_type_Biax).a();
  }
  
  public void a(String paramString, biav parambiav)
  {
    this.jdField_a_of_type_Biav = parambiav;
    new biau(paramString, parambiav).a();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Biaf == null) || (!a())) {
      return;
    }
    if ((this.jdField_a_of_type_Biao != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Biao.b)))
    {
      str = this.jdField_a_of_type_Biao.b;
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
      localIntent.putExtras(this.jdField_a_of_type_Biaf.a());
      localIntent.putExtra("lh_reg_from", 1);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      str = "https://haoma.qq.com/m/clientReg/index.html";
      break;
    }
  }
  
  public void b(biaq parambiaq)
  {
    if (this.jdField_a_of_type_Biaf == null) {
      return;
    }
    LiangHaoBuyFragment.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Biaf.a(), parambiaq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biaj
 * JD-Core Version:    0.7.0.1
 */