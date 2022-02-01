import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class bcem
  extends bcfn
{
  public int a;
  private long jdField_a_of_type_Long;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = bbzf.M;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public bcem(QQAppInterface paramQQAppInterface, int paramInt, TroopInfo paramTroopInfo, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    if (paramQQAppInterface.a().a().isUinInRecent(paramTroopInfo.troopuin)) {
      this.jdField_b_of_type_Long = bbzf.C;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopmask != 2) || (!axan.a().a(paramTroopInfo.troopuin))) {
      return;
    }
    this.jdField_b_of_type_Long = bbzf.C;
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop())
    {
      this.jdField_b_of_type_JavaLangString = "";
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.wMemberNumClient + anzj.a(2131701432));
      return;
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  protected long a(String paramString)
  {
    this.c = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = bcni.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName(), bbzf.f);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.hasSetTroopName())) {}
    }
    do
    {
      return -9223372036854775808L;
      l = bcni.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, bbzf.o, false);
      if (l <= this.jdField_a_of_type_Long) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isQidianPrivateTroop()) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()));
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
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (bcni.a(this.jdField_b_of_type_Int))
    {
      alpb.a = true;
      alpb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, 1, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName(), false);
      bcni.a(this.c, 20, 2, paramView);
      aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
      bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, 1);
      bcni.a(this.c, 30, paramView, false);
      bcni.a(this, paramView);
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bcni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label253;
        }
        bcjy.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin }).a();
      return;
      label253:
      bcjy.a(null, 0, this.jdField_b_of_type_Int, "0X8009D3B", 0, 0, null, null);
      continue;
      bcni.a(paramView, this);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
  }
  
  public int c()
  {
    return 4;
  }
  
  public CharSequence c()
  {
    if (bcni.a(this.jdField_b_of_type_Int)) {
      return "";
    }
    if (this.jdField_b_of_type_Int == 8) {
      return "";
    }
    return anzj.a(2131701473);
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
 * Qualified Name:     bcem
 * JD-Core Version:    0.7.0.1
 */