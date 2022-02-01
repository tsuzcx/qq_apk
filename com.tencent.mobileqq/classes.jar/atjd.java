import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.util.ArrayList;
import java.util.UUID;

public class atjd
  implements bbmy
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bewg jdField_a_of_type_Bewg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public atjd(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, bewg parambewg)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bewg = parambewg;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  private CharSequence a(besl parambesl)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(parambesl.jdField_c_of_type_JavaLangString))
        {
          str1 = str2;
          if (parambesl.jdField_c_of_type_JavaLangString.toLowerCase().contains("".toLowerCase())) {
            str1 = (String)this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList.get(0);
          }
        }
      }
    }
    str2 = parambesl.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1)) {
      return bbup.a(parambesl.jdField_c_of_type_JavaLangString, str1);
    }
    return str2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bewg == null) {
      return;
    }
    Object localObject4 = "";
    long l1 = this.jdField_a_of_type_Bewg.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bewg.jdField_b_of_type_Long;
    long l3 = this.jdField_a_of_type_Bewg.jdField_c_of_type_Long;
    besl localbesl = this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl;
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    Object localObject2;
    label107:
    Object localObject3;
    if ((localObject1 != null) && (bglf.a(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3))))
    {
      i = 1;
      if (i == 0) {
        break label354;
      }
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      if (this.jdField_a_of_type_Bewg.jdField_c_of_type_Long <= 0L) {
        break label503;
      }
      localObject3 = String.valueOf(this.jdField_a_of_type_Bewg.jdField_c_of_type_Long);
      localObject4 = bewh.a();
      localObject1 = ((bewh)localObject4).a((String)localObject3);
      if (localObject1 == null) {
        break label360;
      }
      i = bewh.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString, ((bbfg)localObject1).jdField_c_of_type_JavaLangString, ((bbfg)localObject1).d, this.jdField_a_of_type_Bewg.d, ((bbfg)localObject1).jdField_a_of_type_JavaLangString, ((bbfg)localObject1).jdField_b_of_type_JavaLangString);
      localObject1 = bewh.a((String)localObject2, this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bewg.d, i);
      label216:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label425;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString)) {
        break label413;
      }
      localObject1 = this.jdField_a_of_type_Bewg.d;
      label246:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label258:
      localObject3 = localObject2;
      localObject2 = localbesl.a();
      localObject4 = localbesl.l;
      Object localObject5 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append("  ");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((SpannableStringBuilder)localObject5).append(bbup.a((String)localObject3, (String)localObject1)).append("  ");
      }
      for (;;)
      {
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject2);
        this.b = ((CharSequence)localObject5);
        this.jdField_a_of_type_JavaLangCharSequence = a(localbesl);
        return;
        i = 0;
        break;
        label354:
        localObject2 = null;
        break label107;
        label360:
        i = bewh.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString, null, null, this.jdField_a_of_type_Bewg.d, null, null);
        localObject1 = bewh.a((String)localObject2, this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bewg.d, i);
        break label216;
        label413:
        localObject1 = this.jdField_a_of_type_Bewg.jdField_c_of_type_JavaLangString;
        break label246;
        label425:
        if ((i == 1) || (i == 4) || (i == 7))
        {
          localObject3 = this.jdField_a_of_type_JavaLangString;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label258;
        }
        if ((i != 5) && (i != 6) && (i != 2) && (i != 3)) {
          break label641;
        }
        localObject3 = ((bewh)localObject4).a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label258;
        label503:
        if (i != 0) {}
        for (;;)
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList == null) {
            break;
          }
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break;
          }
          localObject5 = (String)this.jdField_a_of_type_Bewg.jdField_a_of_type_JavaUtilArrayList.get(0);
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (!((String)localObject2).toLowerCase().contains(((String)localObject5).toLowerCase())) {
            break;
          }
          localObject1 = localObject5;
          localObject3 = localObject2;
          break;
          localObject2 = this.jdField_a_of_type_Bewg.jdField_b_of_type_JavaLangString;
        }
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject3).append("  ");
      }
      label641:
      localObject2 = localObject1;
      localObject1 = "";
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(View paramView)
  {
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bewg.jdField_a_of_type_Long);
    besl localbesl = this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl;
    bety localbety = ((TroopFileTransferManager)localObject).a(localbesl.jdField_b_of_type_JavaLangString);
    localObject = localbety;
    if (localbety == null)
    {
      localObject = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bewg.jdField_a_of_type_Long, localbesl.jdField_a_of_type_JavaUtilUUID.toString(), localbesl.jdField_b_of_type_JavaLangString, localbesl.jdField_c_of_type_JavaLangString, localbesl.jdField_a_of_type_Long, localbesl.jdField_a_of_type_Int);
      ((bety)localObject).jdField_c_of_type_JavaLangString = localbesl.j;
      ((bety)localObject).d = localbesl.k;
      ((bety)localObject).jdField_b_of_type_JavaLangString = localbesl.i;
    }
    if ((localObject != null) && (((bety)localObject).jdField_c_of_type_Long == 0L)) {
      ((bety)localObject).jdField_c_of_type_Long = localbesl.jdField_a_of_type_Long;
    }
    paramView = atwt.a(paramView.findViewById(2131366555), localbesl.jdField_c_of_type_JavaLangString);
    atwt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Bewg.jdField_a_of_type_Long, (bety)localObject, localbesl.e, localbesl.jdField_c_of_type_Int, 2, 4, paramView, false, false);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return 0;
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return null;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    return this.b;
  }
  
  public String c()
  {
    String str = "";
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bewg.jdField_a_of_type_Long);
    besl localbesl = this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl;
    bety localbety = ((TroopFileTransferManager)localObject).a(localbesl.jdField_b_of_type_JavaLangString);
    if (localbety != null) {
      str = localbety.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!bgmg.b(str)) {
        localObject = this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl.i;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localbesl.jdField_a_of_type_JavaUtilUUID, 128);
    }
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl != null) {
      return this.jdField_a_of_type_Bewg.jdField_a_of_type_Besl.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjd
 * JD-Core Version:    0.7.0.1
 */