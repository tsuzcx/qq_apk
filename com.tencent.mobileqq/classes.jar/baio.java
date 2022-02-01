import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class baio
  implements bliz
{
  baio(baik parambaik, blir paramblir, String paramString) {}
  
  private void a()
  {
    if (((azxr)baik.t(this.jdField_a_of_type_Baik)).b) {
      VasWebviewUtil.reportCommercialDrainage(baik.o(this.jdField_a_of_type_Baik).getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((azxr)baik.u(this.jdField_a_of_type_Baik)).a.lCurrentStyleId == azxy.j) || (((azxr)baik.v(this.jdField_a_of_type_Baik)).a.lCurrentStyleId == azxy.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, nnr.a(), String.valueOf(((azxr)baik.w(this.jdField_a_of_type_Baik)).a.lCurrentBgId), String.valueOf(((azxr)baik.x(this.jdField_a_of_type_Baik)).a.lCurrentStyleId));
    }
    String str2 = "";
    Object localObject = baik.a(this.jdField_a_of_type_Baik);
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((String)localObject).equals("CustomCover")) {
        str1 = "oldCustom=1";
      }
    }
    localObject = baik.h(this.jdField_a_of_type_Baik);
    String str3 = baik.p(this.jdField_a_of_type_Baik).getCurrentAccountUin();
    if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
    for (str2 = "inside.friendCardBackground";; str2 = "inside.blackBar")
    {
      bhhz.a((Activity)localObject, str3, str2, 1, 1, 1, str1, false);
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
      this.jdField_a_of_type_Blir.e();
      return;
      bdll.b(baik.a(this.jdField_a_of_type_Baik), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(baik.b(this.jdField_a_of_type_Baik), baik.c(this.jdField_a_of_type_Baik).getCurrentAccountUin()));
      if (((azxr)baik.a(this.jdField_a_of_type_Baik)).b) {
        VasWebviewUtil.reportCommercialDrainage(baik.d(this.jdField_a_of_type_Baik).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((azxr)baik.b(this.jdField_a_of_type_Baik)).a.lCurrentStyleId == azxy.j) || (((azxr)baik.c(this.jdField_a_of_type_Baik)).a.lCurrentStyleId == azxy.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, nnr.a(), String.valueOf(((azxr)baik.d(this.jdField_a_of_type_Baik)).a.lCurrentBgId), String.valueOf(((azxr)baik.e(this.jdField_a_of_type_Baik)).a.lCurrentStyleId));
      }
      if ((((azxr)baik.f(this.jdField_a_of_type_Baik)).a.lCurrentBgId == 160L) || (((azxr)baik.g(this.jdField_a_of_type_Baik)).a.lCurrentBgId == 1600L) || ((bhhz.e(((azxr)baik.h(this.jdField_a_of_type_Baik)).a.getBgTypeArray())) && (((azxr)baik.i(this.jdField_a_of_type_Baik)).a.cardType != 2) && (((azxr)baik.j(this.jdField_a_of_type_Baik)).a.dynamicCardFlag != 1)))
      {
        Toast.makeText(baik.f(this.jdField_a_of_type_Baik), 2131694583, 0).show();
      }
      else if (azxy.a(((azxr)baik.k(this.jdField_a_of_type_Baik)).a.lCurrentStyleId))
      {
        bhrn.a(((azxr)baik.l(this.jdField_a_of_type_Baik)).a, baik.e(this.jdField_a_of_type_Baik), baik.g(this.jdField_a_of_type_Baik));
        bdll.b(baik.f(this.jdField_a_of_type_Baik), "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(((azxr)baik.m(this.jdField_a_of_type_Baik)).a.diyText)) && (((azxr)baik.n(this.jdField_a_of_type_Baik)).a.diyTextFontId != 0))
      {
        if ((this.jdField_a_of_type_Baik instanceof bait)) {
          ((bait)this.jdField_a_of_type_Baik).j();
        }
      }
      else
      {
        baik.a(this.jdField_a_of_type_Baik, ((azxr)baik.o(this.jdField_a_of_type_Baik)).a.lCurrentStyleId, ((azxr)baik.p(this.jdField_a_of_type_Baik)).a.lCurrentBgId, ((azxr)baik.q(this.jdField_a_of_type_Baik)).a.backgroundColor, ((azxr)baik.r(this.jdField_a_of_type_Baik)).a.strExtInfo);
        bdll.b(baik.g(this.jdField_a_of_type_Baik), "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        bdll.b(baik.h(this.jdField_a_of_type_Baik), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(baik.i(this.jdField_a_of_type_Baik), baik.j(this.jdField_a_of_type_Baik).getCurrentAccountUin()));
        a();
        continue;
        bdll.b(baik.k(this.jdField_a_of_type_Baik), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(baik.l(this.jdField_a_of_type_Baik), baik.m(this.jdField_a_of_type_Baik).getCurrentAccountUin()));
        if (((azxr)baik.s(this.jdField_a_of_type_Baik)).b) {
          VasWebviewUtil.reportCommercialDrainage(baik.n(this.jdField_a_of_type_Baik).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baio
 * JD-Core Version:    0.7.0.1
 */