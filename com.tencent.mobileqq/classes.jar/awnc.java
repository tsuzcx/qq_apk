import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class awnc
  extends awoc
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public awnc(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
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
      this.c = awvy.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark;
      this.c = awvy.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin });
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = awvy.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = awvy.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = awvy.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopnick, awig.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = awvy.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.autoremark, awig.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    l = awvy.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.friendnick, awig.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = awvy.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, awig.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += awig.z;
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
    if (awvy.a(this.jdField_b_of_type_Int))
    {
      ahpf.a = true;
      ahpf.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, 1000, c(), false);
      awvy.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      awvy.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      awvy.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        awvy.a("search", "contact", "contacts", 0, 0, new String[] { awvy.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        awvy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          awso.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      awso.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    awvy.a(paramView, this);
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
    if (awvy.a(this.jdField_b_of_type_Int)) {
      return ajyc.a(2131702537);
    }
    return ajyc.a(2131702528);
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
 * Qualified Name:     awnc
 * JD-Core Version:    0.7.0.1
 */