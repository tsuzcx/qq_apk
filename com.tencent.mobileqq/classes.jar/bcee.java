import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class bcee
  extends bcff
{
  public int a;
  private long jdField_a_of_type_Long;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = bbzc.M;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public bcee(QQAppInterface paramQQAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    if (paramQQAppInterface.getProxyManager().a().isUinInRecent(paramTroopInfo.troopuin)) {
      this.jdField_b_of_type_Long = bbzc.C;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmask != 2) || (!awtz.a().a(paramTroopInfo.troopuin))) {
      return;
    }
    this.jdField_b_of_type_Long = bbzc.C;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop())
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop())
    {
      this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNumClient + anvx.a(2131702018));
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  protected long a(String paramString)
  {
    this.c = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = bcnc.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName(), bbzc.f);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopName())) {}
    }
    do
    {
      return -9223372036854775808L;
      l = bcnc.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, bbzc.o, false);
      if (l <= this.jdField_a_of_type_Long) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isQidianPrivateTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop()));
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Int = 2;
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public TroopInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (bcnc.a(this.jdField_b_of_type_Int))
    {
      alik.a = true;
      alik.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName(), false);
      bcnc.a(this.c, 20, 2, paramView);
      aode.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
      bcnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 1);
      bcnc.a(this.c, 30, paramView, false);
      bcnc.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bcnc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label253;
        }
        bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin }).a();
      return;
      label253:
      bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
      continue;
      bcnc.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
  }
  
  public int c()
  {
    return 4;
  }
  
  public CharSequence c()
  {
    if (bcnc.a(this.jdField_b_of_type_Int)) {
      return "";
    }
    if (this.jdField_b_of_type_Int == 8) {
      return "";
    }
    return anvx.a(2131702059);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcee
 * JD-Core Version:    0.7.0.1
 */