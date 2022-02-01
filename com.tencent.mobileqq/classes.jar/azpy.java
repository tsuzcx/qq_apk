import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class azpy
  implements bkhw
{
  azpy(azpu paramazpu, bkho parambkho, String paramString) {}
  
  private void a()
  {
    if (((azfe)azpu.t(this.jdField_a_of_type_Azpu)).b) {
      VasWebviewUtil.reportCommercialDrainage(azpu.o(this.jdField_a_of_type_Azpu).getCurrentAccountUin(), "group_card", "click_more", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    if ((((azfe)azpu.u(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId == azfl.j) || (((azfe)azpu.v(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId == azfl.i)) {
      VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_morecard", "0", 1, 0, 0, nlw.a(), String.valueOf(((azfe)azpu.w(this.jdField_a_of_type_Azpu)).a.lCurrentBgId), String.valueOf(((azfe)azpu.x(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId));
    }
    String str2 = "";
    Object localObject = azpu.a(this.jdField_a_of_type_Azpu);
    String str1 = str2;
    if (localObject != null)
    {
      str1 = str2;
      if (((String)localObject).equals("CustomCover")) {
        str1 = "oldCustom=1";
      }
    }
    localObject = azpu.h(this.jdField_a_of_type_Azpu);
    String str3 = azpu.p(this.jdField_a_of_type_Azpu).getCurrentAccountUin();
    if (this.jdField_a_of_type_JavaLangString.equals("CLICK_HEADER_BG")) {}
    for (str2 = "inside.friendCardBackground";; str2 = "inside.blackBar")
    {
      bghy.a((Activity)localObject, str3, str2, 1, 1, 1, str1, false);
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
      this.jdField_a_of_type_Bkho.e();
      return;
      bcst.b(azpu.a(this.jdField_a_of_type_Azpu), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "1", "", "", VipUtils.a(azpu.b(this.jdField_a_of_type_Azpu), azpu.c(this.jdField_a_of_type_Azpu).getCurrentAccountUin()));
      if (((azfe)azpu.a(this.jdField_a_of_type_Azpu)).b) {
        VasWebviewUtil.reportCommercialDrainage(azpu.d(this.jdField_a_of_type_Azpu).getCurrentAccountUin(), "group_card", "click_setresult", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      if ((((azfe)azpu.b(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId == azfl.j) || (((azfe)azpu.c(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId == azfl.i)) {
        VasWebviewUtil.reportCommercialDrainage("", "card_gameking", "clk_setmy", "0", 1, 0, 0, nlw.a(), String.valueOf(((azfe)azpu.d(this.jdField_a_of_type_Azpu)).a.lCurrentBgId), String.valueOf(((azfe)azpu.e(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId));
      }
      if ((((azfe)azpu.f(this.jdField_a_of_type_Azpu)).a.lCurrentBgId == 160L) || (((azfe)azpu.g(this.jdField_a_of_type_Azpu)).a.lCurrentBgId == 1600L) || ((bghy.e(((azfe)azpu.h(this.jdField_a_of_type_Azpu)).a.getBgTypeArray())) && (((azfe)azpu.i(this.jdField_a_of_type_Azpu)).a.cardType != 2) && (((azfe)azpu.j(this.jdField_a_of_type_Azpu)).a.dynamicCardFlag != 1)))
      {
        Toast.makeText(azpu.f(this.jdField_a_of_type_Azpu), 2131694541, 0).show();
      }
      else if (azfl.a(((azfe)azpu.k(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId))
      {
        bgrl.a(((azfe)azpu.l(this.jdField_a_of_type_Azpu)).a, azpu.e(this.jdField_a_of_type_Azpu), azpu.g(this.jdField_a_of_type_Azpu));
        bcst.b(azpu.f(this.jdField_a_of_type_Azpu), "dc00898", "", "", "qvip", "0X8009E3A", 2, 0, "", "", "", "");
      }
      else if ((!TextUtils.isEmpty(((azfe)azpu.m(this.jdField_a_of_type_Azpu)).a.diyText)) && (((azfe)azpu.n(this.jdField_a_of_type_Azpu)).a.diyTextFontId != 0))
      {
        if ((this.jdField_a_of_type_Azpu instanceof azqd)) {
          ((azqd)this.jdField_a_of_type_Azpu).j();
        }
      }
      else
      {
        azpu.a(this.jdField_a_of_type_Azpu, ((azfe)azpu.o(this.jdField_a_of_type_Azpu)).a.lCurrentStyleId, ((azfe)azpu.p(this.jdField_a_of_type_Azpu)).a.lCurrentBgId, ((azfe)azpu.q(this.jdField_a_of_type_Azpu)).a.backgroundColor, ((azfe)azpu.r(this.jdField_a_of_type_Azpu)).a.strExtInfo);
        bcst.b(azpu.g(this.jdField_a_of_type_Azpu), "dc00898", "", "", "", "0X800A4C1", 0, 0, "", "", "", "");
        continue;
        bcst.b(azpu.h(this.jdField_a_of_type_Azpu), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "2", "", "", VipUtils.a(azpu.i(this.jdField_a_of_type_Azpu), azpu.j(this.jdField_a_of_type_Azpu).getCurrentAccountUin()));
        a();
        continue;
        bcst.b(azpu.k(this.jdField_a_of_type_Azpu), "CliOper", "", "", "card_mall", "0X8006680", 0, 0, "3", "", "", VipUtils.a(azpu.l(this.jdField_a_of_type_Azpu), azpu.m(this.jdField_a_of_type_Azpu).getCurrentAccountUin()));
        if (((azfe)azpu.s(this.jdField_a_of_type_Azpu)).b) {
          VasWebviewUtil.reportCommercialDrainage(azpu.n(this.jdField_a_of_type_Azpu).getCurrentAccountUin(), "group_card", "click_cancel", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpy
 * JD-Core Version:    0.7.0.1
 */