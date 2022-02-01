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

public class auax
  implements bcfr
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bfwa jdField_a_of_type_Bfwa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public auax(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, bfwa parambfwa)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfwa = parambfwa;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  private CharSequence a(bfrs parambfrs)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(parambfrs.jdField_c_of_type_JavaLangString))
        {
          str1 = str2;
          if (parambfrs.jdField_c_of_type_JavaLangString.toLowerCase().contains("".toLowerCase())) {
            str1 = (String)this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList.get(0);
          }
        }
      }
    }
    str2 = parambfrs.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1)) {
      return bcni.a(parambfrs.jdField_c_of_type_JavaLangString, str1);
    }
    return str2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfwa == null) {
      return;
    }
    Object localObject4 = "";
    long l1 = this.jdField_a_of_type_Bfwa.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bfwa.jdField_b_of_type_Long;
    long l3 = this.jdField_a_of_type_Bfwa.jdField_c_of_type_Long;
    bfrs localbfrs = this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs;
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    Object localObject2;
    label107:
    Object localObject3;
    if ((localObject1 != null) && (bhlg.a(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3))))
    {
      i = 1;
      if (i == 0) {
        break label354;
      }
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      if (this.jdField_a_of_type_Bfwa.jdField_c_of_type_Long <= 0L) {
        break label503;
      }
      localObject3 = String.valueOf(this.jdField_a_of_type_Bfwa.jdField_c_of_type_Long);
      localObject4 = bfwb.a();
      localObject1 = ((bfwb)localObject4).a((String)localObject3);
      if (localObject1 == null) {
        break label360;
      }
      i = bfwb.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString, ((bbxz)localObject1).jdField_c_of_type_JavaLangString, ((bbxz)localObject1).d, this.jdField_a_of_type_Bfwa.d, ((bbxz)localObject1).jdField_a_of_type_JavaLangString, ((bbxz)localObject1).jdField_b_of_type_JavaLangString);
      localObject1 = bfwb.a((String)localObject2, this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bfwa.d, i);
      label216:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label425;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString)) {
        break label413;
      }
      localObject1 = this.jdField_a_of_type_Bfwa.d;
      label246:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label258:
      localObject3 = localObject2;
      localObject2 = localbfrs.a();
      localObject4 = localbfrs.l;
      Object localObject5 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append("  ");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((SpannableStringBuilder)localObject5).append(bcni.a((String)localObject3, (String)localObject1)).append("  ");
      }
      for (;;)
      {
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject2);
        this.b = ((CharSequence)localObject5);
        this.jdField_a_of_type_JavaLangCharSequence = a(localbfrs);
        return;
        i = 0;
        break;
        label354:
        localObject2 = null;
        break label107;
        label360:
        i = bfwb.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString, null, null, this.jdField_a_of_type_Bfwa.d, null, null);
        localObject1 = bfwb.a((String)localObject2, this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bfwa.d, i);
        break label216;
        label413:
        localObject1 = this.jdField_a_of_type_Bfwa.jdField_c_of_type_JavaLangString;
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
        localObject3 = ((bfwb)localObject4).a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label258;
        label503:
        if (i != 0) {}
        for (;;)
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList == null) {
            break;
          }
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break;
          }
          localObject5 = (String)this.jdField_a_of_type_Bfwa.jdField_a_of_type_JavaUtilArrayList.get(0);
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
          localObject2 = this.jdField_a_of_type_Bfwa.jdField_b_of_type_JavaLangString;
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfwa.jdField_a_of_type_Long);
    bfrs localbfrs = this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs;
    bftf localbftf = ((TroopFileTransferManager)localObject).a(localbfrs.jdField_b_of_type_JavaLangString);
    localObject = localbftf;
    if (localbftf == null)
    {
      localObject = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfwa.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_JavaUtilUUID.toString(), localbfrs.jdField_b_of_type_JavaLangString, localbfrs.jdField_c_of_type_JavaLangString, localbfrs.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int);
      ((bftf)localObject).jdField_c_of_type_JavaLangString = localbfrs.j;
      ((bftf)localObject).d = localbfrs.k;
      ((bftf)localObject).jdField_b_of_type_JavaLangString = localbfrs.i;
    }
    if ((localObject != null) && (((bftf)localObject).jdField_c_of_type_Long == 0L)) {
      ((bftf)localObject).jdField_c_of_type_Long = localbfrs.jdField_a_of_type_Long;
    }
    paramView = auoo.a(paramView.findViewById(2131366604), localbfrs.jdField_c_of_type_JavaLangString);
    auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Bfwa.jdField_a_of_type_Long, (bftf)localObject, localbfrs.e, localbfrs.jdField_c_of_type_Int, 2, 4, paramView, false, false);
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfwa.jdField_a_of_type_Long);
    bfrs localbfrs = this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs;
    bftf localbftf = ((TroopFileTransferManager)localObject).a(localbfrs.jdField_b_of_type_JavaLangString);
    if (localbftf != null) {
      str = localbftf.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!bhmi.b(str)) {
        localObject = this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs.i;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localbfrs.jdField_a_of_type_JavaUtilUUID, 128);
    }
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs != null) {
      return this.jdField_a_of_type_Bfwa.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auax
 * JD-Core Version:    0.7.0.1
 */