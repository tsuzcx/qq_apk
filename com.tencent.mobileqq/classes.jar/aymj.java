import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aymj
  extends aynq
{
  protected int a;
  protected long a;
  protected TroopInfo a;
  public String a;
  protected long b;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public aymj(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = ayhr.V;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
      this.jdField_b_of_type_Long = ayhr.G;
    }
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.e = "";
      this.f = null;
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.c))
      {
        this.e = this.c;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      if (!TextUtils.isEmpty(this.d))
      {
        this.e = this.d;
        this.f = this.jdField_b_of_type_JavaLangString;
        return;
      }
      this.e = this.jdField_b_of_type_JavaLangString;
      this.f = null;
      return;
    case 2: 
      this.e = this.c;
      if (!TextUtils.isEmpty(this.d))
      {
        this.f = this.d;
        return;
      }
      this.f = this.jdField_b_of_type_JavaLangString;
      return;
    }
    if (!TextUtils.isEmpty(this.c))
    {
      this.e = this.c;
      this.f = this.d;
      return;
    }
    this.e = this.d;
    this.f = this.jdField_b_of_type_JavaLangString;
  }
  
  protected long a(String paramString)
  {
    this.g = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop())
    {
      bool = false;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        break label188;
      }
      l = ayhr.i;
      label38:
      l = ayvm.a(paramString, this.c, l, false, false, bool);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 2;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop()) {
        break label195;
      }
    }
    label188:
    label195:
    for (long l = ayhr.h;; l = ayhr.l)
    {
      l = ayvm.a(paramString, this.d, l, false, false, bool);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 1;
      }
      l = ayvm.a(paramString, this.jdField_b_of_type_JavaLangString, ayhr.o, false, true, true);
      if (l > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Long != -9223372036854775808L)
      {
        this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
        a();
      }
      return this.jdField_a_of_type_Long;
      bool = true;
      break;
      l = ayhr.q;
      break label38;
    }
  }
  
  public Object a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    String str2;
    Object localObject;
    if (ayvm.a(this.jdField_b_of_type_Int))
    {
      ajlb.a = true;
      str2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).d(this.jdField_a_of_type_JavaLangString);
      localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_b_of_type_JavaLangString);
      if (ayif.a(this.jdField_b_of_type_JavaLangString)) {
        break label390;
      }
      if ((localObject == null) || (!((Friends)localObject).isFriend())) {
        break label276;
      }
      ajlb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0, bdgc.a((Friends)localObject), false);
      ayvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bdgc.a((Friends)localObject), this.jdField_b_of_type_JavaLangString, "", 0);
    }
    for (;;)
    {
      amcg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g);
      ayvm.a(this.g, 20, 1, paramView);
      ayvm.a(this.g, 20, paramView, false);
      ayvm.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        ayvm.a("search", "contact", "contacts", 0, 0, new String[] { ayvm.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        ayvm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.g, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break;
        }
        aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
      }
      return;
      label276:
      ajlb.a(paramView.getContext(), this.jdField_b_of_type_JavaLangString, str2, 1000, a().toString(), false);
      String str1 = a().toString();
      localObject = str1;
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "saveSearchHistory title is null");
        }
        str1 = c();
        localObject = str1;
        if (TextUtils.isEmpty(str1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(h, 2, "saveSearchHistory titlestr is null");
          }
          localObject = d();
        }
      }
      ayvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject, this.jdField_b_of_type_JavaLangString, str2, 1000);
      continue;
      label390:
      bclg.a(paramView.getContext(), null, this.jdField_b_of_type_JavaLangString);
      ayvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_b_of_type_JavaLangString, str2, 1000);
    }
    aysc.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    String str = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
    if (str != null) {
      return alud.a(2131702916) + str;
    }
    return alud.a(2131702908);
  }
  
  public String c()
  {
    return this.e;
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
    return this.f;
  }
  
  public int e()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aymj
 * JD-Core Version:    0.7.0.1
 */