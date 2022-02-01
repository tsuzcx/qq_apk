import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.util.LruCache;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class bcej
  extends bcfn
{
  private static LruCache<String, String> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(3);
  private long jdField_a_of_type_Long;
  public bhlb a;
  public PhoneContact a;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  public bhlb b;
  
  public bcej(QQAppInterface paramQQAppInterface, int paramInt, PhoneContact paramPhoneContact)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_b_of_type_Long = bbzf.I;
    this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact = paramPhoneContact;
    if (TextUtils.isEmpty(paramPhoneContact.uin)) {
      this.jdField_b_of_type_Long = bbzf.Q;
    }
    if (!TextUtils.isEmpty(paramPhoneContact.name))
    {
      this.jdField_a_of_type_Bhlb = ChnToSpell.a(paramPhoneContact.name, 1);
      this.jdField_b_of_type_Bhlb = ChnToSpell.a(paramPhoneContact.name, 2);
    }
  }
  
  protected long a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = bcni.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, this.jdField_a_of_type_Bhlb, this.jdField_b_of_type_Bhlb, bbzf.m);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    String str2 = (String)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramString.replaceAll("-", "");
      jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, str1);
    }
    l = bcni.a(str1, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo, bbzf.p, true);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    l = bcni.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName, bbzf.l, false);
    if (l > this.jdField_a_of_type_Long) {
      this.jdField_a_of_type_Long = l;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L) {
      this.jdField_a_of_type_Long += this.jdField_b_of_type_Long;
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Object a()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "mn:" + this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    int j;
    int i;
    Object localObject1;
    if ((paramView.getId() == 2131376575) && (this.jdField_b_of_type_Int == 17)) {
      if (!((axfr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i())
      {
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 3, 0, "", "", "", "");
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077CD", "0X80077CD", 0, 0, "", "", "", "");
        j = 1;
        i = 3075;
        localObject1 = AddFriendLogicActivity.a(paramView.getContext(), 2, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, null, i, j, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, null, null, anzj.a(2131701475), null);
        paramView.getContext().startActivity((Intent)localObject1);
      }
    }
    for (;;)
    {
      if ((bcni.a(this.jdField_b_of_type_Int)) && ((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        bcni.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i == null) || (TextUtils.isEmpty(this.i))) {
          break label1170;
        }
        bcjy.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
      }
      return;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 3, 0, "", "", "", "");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80077D3", "0X80077D3", 0, 0, "", "", "", "");
      j = 13;
      i = 3006;
      break;
      Object localObject2;
      if (this.jdField_b_of_type_Int == 17)
      {
        PhoneContact localPhoneContact = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact;
        localObject1 = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11);
        if ((!TextUtils.isEmpty(localPhoneContact.uin)) && (!"0".equals(localPhoneContact.uin)))
        {
          localObject2 = localPhoneContact.unifiedCode;
          localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
          i = 56939;
        }
        for (;;)
        {
          ((ProfileActivity.AllInOne)localObject1).k = localPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_JavaLangString = localPhoneContact.name;
          ((ProfileActivity.AllInOne)localObject1).jdField_h_of_type_Int = 103;
          ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject1);
          aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject2, "", i);
          break;
          if ("0".equals(localPhoneContact.uin))
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            if (((PhoneContactManagerImp)localObject1).i())
            {
              localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
              i = 56941;
            }
            else
            {
              localObject1 = new ProfileActivity.AllInOne((String)localObject2, 29);
              i = 56940;
            }
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject1 = new ProfileActivity.AllInOne((String)localObject2, 53);
            i = 56942;
          }
        }
      }
      if (bcni.a(this.jdField_b_of_type_Int))
      {
        alpb.a = true;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
        i = 0;
        if (!((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(11)).i())
        {
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 29);
            ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).g = 3;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56940);
            return;
          }
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
            ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).g = 3;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56942);
          }
        }
        else
        {
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
            localObject2 = new ProfileActivity.AllInOne((String)localObject1, 53);
            ((ProfileActivity.AllInOne)localObject2).a = new ArrayList();
            ((ProfileActivity.AllInOne)localObject2).k = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.nickName;
            ((ProfileActivity.AllInOne)localObject2).d = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.ability;
            ((ProfileActivity.AllInOne)localObject2).g = 3;
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 103;
            ProfileActivity.b(paramView.getContext(), (ProfileActivity.AllInOne)localObject2);
            aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
            bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", 56942);
            return;
          }
          if ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin))
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
            i = 1006;
          }
        }
        alpb.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1, i, this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name, false);
        bcni.a(this.jdField_a_of_type_JavaLangString, 20, 1, paramView);
        aoha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        bcni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), (String)localObject1, "", i);
        bcni.a(this.jdField_a_of_type_JavaLangString, 20, paramView, false);
        bcni.a(this, paramView);
        if (SearchConfigManager.needSeparate) {
          bcni.a("search", "contact", "contacts", 0, 0, new String[] { bcni.a(this.jdField_b_of_type_Int) });
        }
      }
      else
      {
        bcni.a(paramView, this);
      }
    }
    label1170:
    bcjy.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public CharSequence b()
  {
    if (this.jdField_b_of_type_Int == 17)
    {
      String str = d();
      if (!TextUtils.isEmpty(str))
      {
        if ((!str.equals(this.k)) || (!TextUtils.equals(this.j, a())))
        {
          this.k = str;
          this.j = a();
          SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anzj.a(2131701440));
          localSpannableStringBuilder.append(bcni.a(str, a(), 10));
          this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder;
        }
        return this.jdField_b_of_type_JavaLangCharSequence;
      }
      this.k = null;
      return null;
    }
    return super.b();
  }
  
  public String b()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin;
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("0"));
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
  
  public int c()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) || (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0"))) {
      return 11;
    }
    return 1;
  }
  
  public CharSequence c()
  {
    if (bcni.a(this.jdField_b_of_type_Int)) {
      return anzj.a(2131701434);
    }
    if ((this.jdField_b_of_type_Int == 17) || (this.jdField_b_of_type_Int == 19))
    {
      anyw localanyw = (anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equalsIgnoreCase("0"))) {
        return anzj.a(2131701455);
      }
      if (localanyw.a(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode, true)) {
        return anzj.a(2131701479);
      }
      return null;
    }
    return anzj.a(2131701472);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.name;
  }
  
  public int d()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin)) {
      return 56938;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.uin.equals("0")) {
      return 1006;
    }
    return 0;
  }
  
  public CharSequence d()
  {
    if ((this.jdField_b_of_type_Int == 17) && (this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend > 0)) {
      return String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131690941), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.samFriend) });
    }
    return null;
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_Int == 17) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.mobileNo;
  }
  
  public int e()
  {
    return 4;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataPhoneContact.unifiedCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcej
 * JD-Core Version:    0.7.0.1
 */