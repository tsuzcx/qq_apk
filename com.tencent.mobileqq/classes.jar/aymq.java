import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class aymq
  extends aynq
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public aymq(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick;
      this.c = ayvm.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark;
      this.c = ayvm.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = ayvm.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = ayvm.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = ayvm.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, ayhr.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = ayvm.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, ayhr.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    l = ayvm.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, ayhr.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = ayvm.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, ayhr.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += ayhr.z;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (ayvm.a(this.jdField_b_of_type_Int))
    {
      ajlb.a = true;
      ajlb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, 1000, c(), false);
      ayvm.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      ayvm.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      ayvm.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        ayvm.a("search", "contact", "contacts", 0, 0, new String[] { ayvm.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        ayvm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    ayvm.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (ayvm.a(this.jdField_b_of_type_Int)) {
      return alud.a(2131702932);
    }
    return alud.a(2131702923);
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
 * Qualified Name:     aymq
 * JD-Core Version:    0.7.0.1
 */