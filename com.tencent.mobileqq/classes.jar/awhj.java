import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ChnToSpell;
import mqq.app.MobileQQ;

public class awhj
  extends awig
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Friends jdField_a_of_type_ComTencentMobileqqDataFriends;
  public String a;
  public String b;
  public String c;
  public String d;
  private String e;
  private String f;
  
  @SuppressLint({"DefaultLocale"})
  public awhj(Context paramContext, QQAppInterface paramQQAppInterface, Friends paramFriends, String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.aa = paramLong2;
    this.e = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.length() != 0))
    {
      this.jdField_a_of_type_JavaLangString = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 1).toLowerCase();
      this.b = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark, 2).toLowerCase();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends.name != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.length() != 0))
    {
      this.c = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 1).toLowerCase();
      this.d = ChnToSpell.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name, 2).toLowerCase();
    }
    b();
  }
  
  private String e()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected long a()
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0);
    if (localMessage != null) {
      return localMessage.time;
    }
    return 0L;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public Friends a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends;
  }
  
  public String a()
  {
    if (nbc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131689764);
    }
    return this.e;
  }
  
  @SuppressLint({"DefaultLocale"})
  public void a(String paramString)
  {
    String str1;
    String str2;
    label44:
    String str3;
    label63:
    String str4;
    label82:
    String str5;
    String str6;
    String str7;
    String str8;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark != null)
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.name == null) {
        break label600;
      }
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name.toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin == null) {
        break label606;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias == null) {
        break label612;
      }
      str4 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
      str5 = this.jdField_a_of_type_JavaLangString;
      str6 = this.b;
      str7 = this.c;
      str8 = this.d;
      paramString = paramString.toLowerCase();
      l2 = -9223372036854775808L;
      this.Z = -9223372036854775808L;
      l1 = l2;
      if (str1 != null)
      {
        l1 = l2;
        if (str1.length() != 0)
        {
          if ((!str1.equals(paramString)) && ((str5 == null) || (!str5.equals(paramString))) && ((str6 == null) || (!str6.equals(paramString)))) {
            break label629;
          }
          l1 = awig.u;
          if ((str1.equals(paramString)) || (str1.equals(str5))) {
            break label618;
          }
          l1 += awig.s;
          label213:
          l2 = l1 + 0L;
          l1 = l2;
          if (this.Z < l2)
          {
            this.Z = l2;
            this.jdField_a_of_type_Int = 2;
            l1 = l2;
          }
        }
      }
      if ((str2 == null) || (str2.length() == 0)) {
        break label1090;
      }
      if ((!str2.equals(paramString)) && ((str7 == null) || (!str7.equals(paramString))) && ((str8 == null) || (!str8.equals(paramString)))) {
        break label773;
      }
      l1 = awig.u;
      if ((str2.equals(paramString)) || (str2.equals(str7))) {
        break label753;
      }
      l1 = awig.s + l1;
      label330:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
        break label764;
      }
      l1 += 0L;
      label349:
      l2 = l1;
      if (this.Z < l1)
      {
        this.Z = l1;
        this.jdField_a_of_type_Int = 1;
      }
    }
    label449:
    label1090:
    for (long l2 = l1;; l2 = l1)
    {
      long l3 = l2;
      if (str4 != null)
      {
        l3 = l2;
        if (str4.length() != 0)
        {
          if (!str4.equals(paramString)) {
            break label928;
          }
          l1 = awig.u + awig.r;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label919;
          }
          l1 += 0L;
          l3 = l1;
          if (this.Z < l1)
          {
            this.Z = l1;
            this.jdField_a_of_type_Int = 3;
            l3 = l1;
          }
        }
      }
      if (1 != this.jdField_a_of_type_ComTencentMobileqqDataFriends.cSpecialFlag)
      {
        l1 = l3;
        if (str3 != null)
        {
          if (!str3.equals(paramString)) {
            break label1003;
          }
          l1 = awig.u + awig.r;
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
            break label994;
          }
          l1 += 0L;
        }
      }
      for (;;)
      {
        if (this.Z < l1)
        {
          this.Z = l1;
          this.jdField_a_of_type_Int = 0;
        }
        if (this.Z != -9223372036854775808L) {
          this.Z += this.aa;
        }
        return;
        str1 = null;
        break;
        label600:
        str2 = null;
        break label44;
        label606:
        str3 = null;
        break label63;
        label612:
        str4 = null;
        break label82;
        label618:
        l1 += awig.r;
        break label213;
        label629:
        int k = str1.indexOf(paramString);
        int j;
        if (str5 != null)
        {
          i = str5.indexOf(paramString);
          if (str6 == null) {
            break label729;
          }
          j = str6.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label732;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label734;
          }
          l1 = awig.v;
          if ((k >= 0) || (str1.equals(str5))) {
            break label742;
          }
        }
        label729:
        label732:
        label734:
        label742:
        for (l1 += awig.s;; l1 += awig.r)
        {
          l2 = l1 + 0L;
          break;
          i = -1;
          break label649;
          j = -1;
          break label661;
          break;
          l1 = awig.w;
          break label692;
        }
        label753:
        l1 = awig.r + l1;
        break label330;
        label764:
        l1 += 0L;
        break label349;
        k = str2.indexOf(paramString);
        if (str7 != null)
        {
          i = str7.indexOf(paramString);
          if (str8 == null) {
            break label886;
          }
          j = str8.indexOf(paramString);
          if ((k < 0) && (i < 0) && (j < 0)) {
            break label1087;
          }
          if ((k != 0) && (i != 0) && (j != 0)) {
            break label891;
          }
          l1 = awig.v;
          label836:
          if ((k >= 0) || (str2.equals(str7))) {
            break label899;
          }
        }
        for (l1 = awig.s + l1;; l1 = awig.r + l1)
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) {
            break label910;
          }
          l1 += 0L;
          break;
          i = -1;
          break label793;
          label886:
          j = -1;
          break label805;
          label891:
          l1 = awig.w;
          break label836;
        }
        l1 += 0L;
        break label349;
        l1 += 0L;
        break label449;
        l1 = l2;
        if (str4.indexOf(paramString) < 0) {
          break label449;
        }
        l1 = awig.w + awig.r;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name)))
        {
          l1 += 0L;
          break label449;
        }
        l1 += 0L;
        break label449;
        label994:
        l1 += 0L;
        continue;
        label1003:
        int i = str3.indexOf(paramString);
        l1 = l3;
        if (i >= 0)
        {
          if (i == 0) {}
          for (l1 = awig.v;; l1 = awig.w)
          {
            l1 += awig.r;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark)) || (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.name))) {
              break label1078;
            }
            l1 += 0L;
            break;
          }
          l1 += 0L;
        }
      }
      break label349;
    }
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    if (this.f != null) {
      return String.format("(%s)", new Object[] { this.f });
    }
    return null;
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.remark;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.name;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.alias;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject2 = null;
    case 0: 
    case 2: 
      do
      {
        do
        {
          return localObject2;
          if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              localObject1 = str1;
            }
            for (;;)
            {
              localObject1 = String.format("%s", new Object[] { localObject1 });
              this.f = e();
              return localObject1;
            }
          }
          return str2;
          localObject2 = localObject1;
        } while (str1 == null);
        localObject2 = localObject1;
      } while (str1.length() == 0);
      localObject1 = String.format("%s", new Object[] { localObject1 });
      this.f = str1;
      return localObject1;
    case 1: 
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = String.format("%s", new Object[] { localObject1 });
        this.f = str1;
        return localObject1;
      }
      localObject1 = String.format("%s", new Object[] { str1 });
      this.f = e();
      return localObject1;
    }
    if (((str1 != null) && (str1.length() != 0)) || ((localObject1 != null) && (((String)localObject1).length() != 0)))
    {
      localObject1 = String.format("%s", new Object[] { bbcl.a(this.jdField_a_of_type_ComTencentMobileqqDataFriends) });
      this.f = ((String)localObject2);
      return localObject1;
    }
    return localObject2;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhj
 * JD-Core Version:    0.7.0.1
 */