import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class bcef
  extends bcff
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public bcef(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick;
      this.c = bcnc.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark;
      this.c = bcnc.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = bcnc.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = bcnc.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = bcnc.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, bbzc.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = bcnc.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, bbzc.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    l = bcnc.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, bbzc.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = bcnc.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, bbzc.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += bbzc.z;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (bcnc.a(this.jdField_b_of_type_Int))
    {
      alik.a = true;
      alik.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, 1000, c(), false, null);
      bcnc.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      bcnc.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      bcnc.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        bcnc.a("search", "contact", "contacts", 0, 0, new String[] { bcnc.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bcnc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      bcjs.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    bcnc.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (bcnc.a(this.jdField_b_of_type_Int)) {
      return anvx.a(2131702032);
    }
    return anvx.a(2131702023);
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1000;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public int e()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcef
 * JD-Core Version:    0.7.0.1
 */