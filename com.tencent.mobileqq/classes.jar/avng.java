import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.Map;

public class avng
  extends avoj
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 1000, 1004, 1005, 1006, 1001, 10002, 10004 };
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private RecentUser jdField_a_of_type_ComTencentMobileqqDataRecentUser;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String l;
  private String m;
  
  public avng(QQAppInterface paramQQAppInterface, int paramInt, RecentUser paramRecentUser, long paramLong)
  {
    super(paramQQAppInterface, paramInt, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqDataRecentUser = paramRecentUser;
    b();
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.l = this.c;
      this.m = avwf.a(new String[] { this.e, this.f });
      return;
    case 3: 
      this.l = this.d;
      this.m = avwf.a(new String[] { this.e, this.f });
      return;
    case 1: 
      this.l = avwf.a(new String[] { this.c, this.d });
      if (!TextUtils.isEmpty(this.l))
      {
        this.m = this.e;
        return;
      }
      this.l = this.e;
      this.m = this.f;
      return;
    case 4: 
      this.l = this.g;
      this.m = this.f;
      return;
    }
    this.l = avwf.a(new String[] { this.c, this.d, this.e });
    this.m = this.f;
  }
  
  private void b()
  {
    this.f = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
    this.e = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType())
    {
    default: 
      localObject1 = ajjy.a(2131636759);
      if (!avwf.a(this.jdField_b_of_type_Int)) {
        break;
      }
    }
    for (this.jdField_a_of_type_JavaLangString = (ajjy.a(2131636781) + (String)localObject1);; this.jdField_a_of_type_JavaLangString = ((String)localObject1))
    {
      if ((TextUtils.isEmpty(this.e)) || (this.e.equals(this.f))) {
        this.e = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.f, true);
      }
      return;
      localObject1 = ((TroopManager)localObject1).b(((TroopManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).troopnick)) {
          this.c = ((TroopMemberInfo)localObject1).troopnick;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).autoremark)) {
          this.d = ((TroopMemberInfo)localObject1).autoremark;
        }
        if (!TextUtils.isEmpty(((TroopMemberInfo)localObject1).friendnick)) {
          this.e = ((TroopMemberInfo)localObject1).friendnick;
        }
      }
      localObject1 = ajjy.a(2131636743);
      break;
      localObject1 = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin);
      if (localObject1 != null)
      {
        localObject1 = (DiscussionMemberInfo)((Map)localObject1).get(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        if (localObject1 != null)
        {
          localObject2 = ((DiscussionMemberInfo)localObject1).memberName;
          if (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark)) {
            this.d = ((DiscussionMemberInfo)localObject1).inteRemark;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            this.e = ((String)localObject2);
          }
        }
      }
      Object localObject2 = ajjy.a(2131636766);
      localObject1 = localObject2;
      if (this.e == null) {
        break;
      }
      localObject1 = localObject2;
      if (!this.e.equals(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        break;
      }
      this.e = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, true);
      localObject1 = localObject2;
      break;
      localObject1 = "wap临时会话";
      break;
      this.g = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.displayName;
      this.e = null;
      localObject1 = babh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      localObject2 = ((aroh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).c(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
      if (localObject2 != null) {
        this.g = ((PhoneContact)localObject2).name;
      }
      for (;;)
      {
        localObject1 = ajjy.a(2131636784);
        break;
        if (localObject1 != null) {
          this.g = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, true);
        }
      }
      localObject1 = ajjy.a(2131636778);
      break;
      localObject1 = ajjy.a(2131636749);
      break;
      localObject1 = "QQ电影票临时会话";
      break;
    }
  }
  
  protected long a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l1 = avwf.b(paramString, this.c, avin.g);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 2;
    }
    l1 = avwf.b(paramString, this.d, avin.k);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 3;
    }
    l1 = avwf.b(paramString, this.e, avin.l);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 1;
    }
    l1 = avwf.b(paramString, this.g, avin.m);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 4;
    }
    l1 = avwf.a(paramString, this.f, avin.o, false);
    if (l1 > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += avin.z;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (avwf.a(this.jdField_b_of_type_Int))
    {
      ahcq.a = true;
      QQAppInterface localQQAppInterface;
      String str2;
      String str3;
      if (!avjb.a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin)) {
        switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType())
        {
        default: 
          avwf.a(this.jdField_b_of_type_JavaLangString, 20, 1, paramView);
          ajrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          str2 = a().toString();
          str3 = this.f;
          if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin != null) {
            break;
          }
        }
      }
      for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin)
      {
        avwf.a(localQQAppInterface, str2, str3, str1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType());
        avwf.a(this.jdField_b_of_type_JavaLangString, 20, paramView, false);
        avwf.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          avwf.a("search", "contact", "contacts", 0, 0, new String[] { avwf.a(this.jdField_b_of_type_Int) });
        }
        if ((a() instanceof String)) {
          avwf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, this.i, (String)a(), e());
        }
        if ((paramView.getContext() instanceof UniteSearchActivity))
        {
          if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
            break label418;
          }
          avsv.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
        return;
        ahcq.a = true;
        ahcq.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), this.l, false);
        break;
        ahcq.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType(), this.l, false);
        break;
        azgu.a(paramView.getContext(), null, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin);
        break;
      }
      label418:
      avsv.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    avwf.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin;
  }
  
  public int c()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType())
    {
    case 1000: 
    case 1004: 
    case 1005: 
    default: 
      return 1;
    case 1006: 
      return 11;
    }
    return 32;
  }
  
  public CharSequence c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return this.l;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.getType();
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.m;
  }
  
  public int e()
  {
    return 1;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.troopUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avng
 * JD-Core Version:    0.7.0.1
 */