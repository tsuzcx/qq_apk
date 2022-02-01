import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class ayyf
  implements bjoe
{
  ayyf(ayyb paramayyb, bjnw parambjnw, String paramString) {}
  
  private void a()
  {
    if (((aymg)ayyb.t(this.jdField_a_of_type_Ayyb)).b) {
      VasWebviewUtil.reportCommercialDrainage(ayyb.o(this.jdField_a_of_type_Ayyb).getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((aymg)ayyb.u(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId == aymn.j) || (((aymg)ayyb.v(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId == aymn.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((aymg)ayyb.w(this.jdField_a_of_type_Ayyb)).a.lCurrentBgId), String.valueOf(((aymg)ayyb.x(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId));
    }
    String str2 = "";
    Object localObject = ayyb.a(this.jdField_a_of_type_Ayyb);
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((String)localObject).equals("CustomCover")) {
        str1 = "oldCustom=1";
      }
    }
    localObject = ayyb.h(this.jdField_a_of_type_Ayyb);
    String str3 = ayyb.p(this.jdField_a_of_type_Ayyb).getCurrentAccountUin();
    if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
    for (str2 = "inside.friendCardBackground";; str2 = "inside.blackBar")
    {
      bfrj.a((Activity)localObject, str3, str2, 1, 1, 1, str1, false);
      return;
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.e();
      return;
      bcef.b(ayyb.a(this.jdField_a_of_type_Ayyb), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(ayyb.b(this.jdField_a_of_type_Ayyb), ayyb.c(this.jdField_a_of_type_Ayyb).getCurrentAccountUin()));
      if (((aymg)ayyb.a(this.jdField_a_of_type_Ayyb)).b) {
        VasWebviewUtil.reportCommercialDrainage(ayyb.d(this.jdField_a_of_type_Ayyb).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((aymg)ayyb.b(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId == aymn.j) || (((aymg)ayyb.c(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId == aymn.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((aymg)ayyb.d(this.jdField_a_of_type_Ayyb)).a.lCurrentBgId), String.valueOf(((aymg)ayyb.e(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId));
      }
      if ((((aymg)ayyb.f(this.jdField_a_of_type_Ayyb)).a.lCurrentBgId == 160L) || (((aymg)ayyb.g(this.jdField_a_of_type_Ayyb)).a.lCurrentBgId == 1600L) || ((bfrj.e(((aymg)ayyb.h(this.jdField_a_of_type_Ayyb)).a.getBgTypeArray())) && (((aymg)ayyb.i(this.jdField_a_of_type_Ayyb)).a.cardType != 2) && (((aymg)ayyb.j(this.jdField_a_of_type_Ayyb)).a.dynamicCardFlag != 1)))
      {
        Toast.makeText(ayyb.f(this.jdField_a_of_type_Ayyb), 2131694699, 0).show();
      }
      else if (aymn.a(((aymg)ayyb.k(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId))
      {
        bfyi.a(((aymg)ayyb.l(this.jdField_a_of_type_Ayyb)).a, ayyb.e(this.jdField_a_of_type_Ayyb), ayyb.g(this.jdField_a_of_type_Ayyb));
        bcef.b(ayyb.f(this.jdField_a_of_type_Ayyb), "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(((aymg)ayyb.m(this.jdField_a_of_type_Ayyb)).a.diyText)) && (((aymg)ayyb.n(this.jdField_a_of_type_Ayyb)).a.diyTextFontId != 0))
      {
        if ((this.jdField_a_of_type_Ayyb instanceof ayyk)) {
          ((ayyk)this.jdField_a_of_type_Ayyb).j();
        }
      }
      else
      {
        ayyb.a(this.jdField_a_of_type_Ayyb, ((aymg)ayyb.o(this.jdField_a_of_type_Ayyb)).a.lCurrentStyleId, ((aymg)ayyb.p(this.jdField_a_of_type_Ayyb)).a.lCurrentBgId, ((aymg)ayyb.q(this.jdField_a_of_type_Ayyb)).a.backgroundColor, ((aymg)ayyb.r(this.jdField_a_of_type_Ayyb)).a.strExtInfo);
        bcef.b(ayyb.g(this.jdField_a_of_type_Ayyb), "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        bcef.b(ayyb.h(this.jdField_a_of_type_Ayyb), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(ayyb.i(this.jdField_a_of_type_Ayyb), ayyb.j(this.jdField_a_of_type_Ayyb).getCurrentAccountUin()));
        a();
        continue;
        bcef.b(ayyb.k(this.jdField_a_of_type_Ayyb), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(ayyb.l(this.jdField_a_of_type_Ayyb), ayyb.m(this.jdField_a_of_type_Ayyb).getCurrentAccountUin()));
        if (((aymg)ayyb.s(this.jdField_a_of_type_Ayyb)).b) {
          VasWebviewUtil.reportCommercialDrainage(ayyb.n(this.jdField_a_of_type_Ayyb).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyf
 * JD-Core Version:    0.7.0.1
 */