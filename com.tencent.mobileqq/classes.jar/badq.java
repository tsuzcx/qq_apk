import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class badq
  implements bkzq
{
  badq(badm parambadm, bkzi parambkzi, String paramString) {}
  
  private void a()
  {
    if (((azrb)badm.t(this.jdField_a_of_type_Badm)).b) {
      VasWebviewUtil.reportCommercialDrainage(badm.o(this.jdField_a_of_type_Badm).getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((azrb)badm.u(this.jdField_a_of_type_Badm)).a.lCurrentStyleId == azri.j) || (((azrb)badm.v(this.jdField_a_of_type_Badm)).a.lCurrentStyleId == azri.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((azrb)badm.w(this.jdField_a_of_type_Badm)).a.lCurrentBgId), String.valueOf(((azrb)badm.x(this.jdField_a_of_type_Badm)).a.lCurrentStyleId));
    }
    String str2 = "";
    Object localObject = badm.a(this.jdField_a_of_type_Badm);
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((String)localObject).equals("CustomCover")) {
        str1 = "oldCustom=1";
      }
    }
    localObject = badm.h(this.jdField_a_of_type_Badm);
    String str3 = badm.p(this.jdField_a_of_type_Badm).getCurrentAccountUin();
    if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
    for (str2 = "inside.friendCardBackground";; str2 = "inside.blackBar")
    {
      bhaa.a((Activity)localObject, str3, str2, 1, 1, 1, str1, false);
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
      this.jdField_a_of_type_Bkzi.e();
      return;
      bdla.b(badm.a(this.jdField_a_of_type_Badm), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(badm.b(this.jdField_a_of_type_Badm), badm.c(this.jdField_a_of_type_Badm).getCurrentAccountUin()));
      if (((azrb)badm.a(this.jdField_a_of_type_Badm)).b) {
        VasWebviewUtil.reportCommercialDrainage(badm.d(this.jdField_a_of_type_Badm).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((azrb)badm.b(this.jdField_a_of_type_Badm)).a.lCurrentStyleId == azri.j) || (((azrb)badm.c(this.jdField_a_of_type_Badm)).a.lCurrentStyleId == azri.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), String.valueOf(((azrb)badm.d(this.jdField_a_of_type_Badm)).a.lCurrentBgId), String.valueOf(((azrb)badm.e(this.jdField_a_of_type_Badm)).a.lCurrentStyleId));
      }
      if ((((azrb)badm.f(this.jdField_a_of_type_Badm)).a.lCurrentBgId == 160L) || (((azrb)badm.g(this.jdField_a_of_type_Badm)).a.lCurrentBgId == 1600L) || ((bhaa.e(((azrb)badm.h(this.jdField_a_of_type_Badm)).a.getBgTypeArray())) && (((azrb)badm.i(this.jdField_a_of_type_Badm)).a.cardType != 2) && (((azrb)badm.j(this.jdField_a_of_type_Badm)).a.dynamicCardFlag != 1)))
      {
        Toast.makeText(badm.f(this.jdField_a_of_type_Badm), 2131694902, 0).show();
      }
      else if (azri.a(((azrb)badm.k(this.jdField_a_of_type_Badm)).a.lCurrentStyleId))
      {
        bhha.a(((azrb)badm.l(this.jdField_a_of_type_Badm)).a, badm.e(this.jdField_a_of_type_Badm), badm.g(this.jdField_a_of_type_Badm));
        bdla.b(badm.f(this.jdField_a_of_type_Badm), "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(((azrb)badm.m(this.jdField_a_of_type_Badm)).a.diyText)) && (((azrb)badm.n(this.jdField_a_of_type_Badm)).a.diyTextFontId != 0))
      {
        if ((this.jdField_a_of_type_Badm instanceof badv)) {
          ((badv)this.jdField_a_of_type_Badm).j();
        }
      }
      else
      {
        badm.a(this.jdField_a_of_type_Badm, ((azrb)badm.o(this.jdField_a_of_type_Badm)).a.lCurrentStyleId, ((azrb)badm.p(this.jdField_a_of_type_Badm)).a.lCurrentBgId, ((azrb)badm.q(this.jdField_a_of_type_Badm)).a.backgroundColor, ((azrb)badm.r(this.jdField_a_of_type_Badm)).a.strExtInfo);
        bdla.b(badm.g(this.jdField_a_of_type_Badm), "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        bdla.b(badm.h(this.jdField_a_of_type_Badm), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(badm.i(this.jdField_a_of_type_Badm), badm.j(this.jdField_a_of_type_Badm).getCurrentAccountUin()));
        a();
        continue;
        bdla.b(badm.k(this.jdField_a_of_type_Badm), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(badm.l(this.jdField_a_of_type_Badm), badm.m(this.jdField_a_of_type_Badm).getCurrentAccountUin()));
        if (((azrb)badm.s(this.jdField_a_of_type_Badm)).b) {
          VasWebviewUtil.reportCommercialDrainage(badm.n(this.jdField_a_of_type_Badm).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     badq
 * JD-Core Version:    0.7.0.1
 */