import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class baxp
  extends bayp
{
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public baxp(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo)
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
      this.c = bbgk.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 3: 
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark;
      this.c = bbgk.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin });
      return;
    case 1: 
      this.jdField_b_of_type_JavaLangString = bbgk.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark });
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
      return;
    }
    this.jdField_b_of_type_JavaLangString = bbgk.a(new String[] { this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick });
    this.c = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin;
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = bbgk.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick, basn.g);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = bbgk.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.autoremark, basn.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 3;
    }
    l = bbgk.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick, basn.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = bbgk.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, basn.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += basn.z;
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
    if (bbgk.a(this.jdField_b_of_type_Int))
    {
      akms.a = true;
      akms.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, 1000, c(), false);
      bbgk.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
      bbgk.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
      bbgk.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        bbgk.a("search", "contact", "contacts", 0, 0, new String[] { bbgk.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bbgk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          bbda.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      bbda.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    bbgk.a(paramView, this);
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
    if (bbgk.a(this.jdField_b_of_type_Int)) {
      return amtj.a(2131701681);
    }
    return amtj.a(2131701672);
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
 * Qualified Name:     baxp
 * JD-Core Version:    0.7.0.1
 */