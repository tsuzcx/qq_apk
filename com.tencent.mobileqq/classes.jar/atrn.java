import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.util.ArrayList;
import java.util.UUID;

public class atrn
  implements bcfj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private bfmo jdField_a_of_type_Bfmo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public atrn(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, bfmo parambfmo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bfmo = parambfmo;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  private CharSequence a(bfif parambfif)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(parambfif.jdField_c_of_type_JavaLangString))
        {
          str1 = str2;
          if (parambfif.jdField_c_of_type_JavaLangString.toLowerCase().contains("".toLowerCase())) {
            str1 = (String)this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList.get(0);
          }
        }
      }
    }
    str2 = parambfif.jdField_c_of_type_JavaLangString;
    if (!TextUtils.isEmpty(str1)) {
      return bcnc.a(parambfif.jdField_c_of_type_JavaLangString, str1);
    }
    return str2;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bfmo == null) {
      return;
    }
    Object localObject4 = "";
    long l1 = this.jdField_a_of_type_Bfmo.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Bfmo.jdField_b_of_type_Long;
    long l3 = this.jdField_a_of_type_Bfmo.jdField_c_of_type_Long;
    bfif localbfif = this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif;
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    Object localObject2;
    label108:
    Object localObject3;
    if ((localObject1 != null) && (ContactUtils.isValideName(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3))))
    {
      i = 1;
      if (i == 0) {
        break label355;
      }
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      if (this.jdField_a_of_type_Bfmo.jdField_c_of_type_Long <= 0L) {
        break label504;
      }
      localObject3 = String.valueOf(this.jdField_a_of_type_Bfmo.jdField_c_of_type_Long);
      localObject4 = bfmp.a();
      localObject1 = ((bfmp)localObject4).a((String)localObject3);
      if (localObject1 == null) {
        break label361;
      }
      i = bfmp.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString, ((bbyj)localObject1).jdField_c_of_type_JavaLangString, ((bbyj)localObject1).d, this.jdField_a_of_type_Bfmo.d, ((bbyj)localObject1).jdField_a_of_type_JavaLangString, ((bbyj)localObject1).jdField_b_of_type_JavaLangString);
      localObject1 = bfmp.a((String)localObject2, this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bfmo.d, i);
      label217:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label426;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString)) {
        break label414;
      }
      localObject1 = this.jdField_a_of_type_Bfmo.d;
      label247:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label259:
      localObject3 = localObject2;
      localObject2 = localbfif.a();
      localObject4 = localbfif.m;
      Object localObject5 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append("  ");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        ((SpannableStringBuilder)localObject5).append(bcnc.a((String)localObject3, (String)localObject1)).append("  ");
      }
      for (;;)
      {
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject2);
        this.b = ((CharSequence)localObject5);
        this.jdField_a_of_type_JavaLangCharSequence = a(localbfif);
        return;
        i = 0;
        break;
        label355:
        localObject2 = null;
        break label108;
        label361:
        i = bfmp.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString, null, null, this.jdField_a_of_type_Bfmo.d, null, null);
        localObject1 = bfmp.a((String)localObject2, this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bfmo.d, i);
        break label217;
        label414:
        localObject1 = this.jdField_a_of_type_Bfmo.jdField_c_of_type_JavaLangString;
        break label247;
        label426:
        if ((i == 1) || (i == 4) || (i == 7))
        {
          localObject3 = this.jdField_a_of_type_JavaLangString;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label259;
        }
        if ((i != 5) && (i != 6) && (i != 2) && (i != 3)) {
          break label642;
        }
        localObject3 = ((bfmp)localObject4).a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label259;
        label504:
        if (i != 0) {}
        for (;;)
        {
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList == null) {
            break;
          }
          localObject3 = localObject2;
          localObject1 = localObject4;
          if (this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            break;
          }
          localObject5 = (String)this.jdField_a_of_type_Bfmo.jdField_a_of_type_JavaUtilArrayList.get(0);
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
          localObject2 = this.jdField_a_of_type_Bfmo.jdField_b_of_type_JavaLangString;
        }
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject3).append("  ");
      }
      label642:
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfmo.jdField_a_of_type_Long);
    bfif localbfif = this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif;
    bfjs localbfjs = ((TroopFileTransferManager)localObject).a(localbfif.jdField_b_of_type_JavaLangString);
    localObject = localbfjs;
    if (localbfjs == null)
    {
      localObject = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfmo.jdField_a_of_type_Long, localbfif.jdField_a_of_type_JavaUtilUUID.toString(), localbfif.jdField_b_of_type_JavaLangString, localbfif.jdField_c_of_type_JavaLangString, localbfif.jdField_a_of_type_Long, localbfif.jdField_a_of_type_Int);
      ((bfjs)localObject).jdField_c_of_type_JavaLangString = localbfif.k;
      ((bfjs)localObject).d = localbfif.l;
      ((bfjs)localObject).jdField_b_of_type_JavaLangString = localbfif.j;
    }
    if ((localObject != null) && (((bfjs)localObject).jdField_c_of_type_Long == 0L)) {
      ((bfjs)localObject).jdField_c_of_type_Long = localbfif.jdField_a_of_type_Long;
    }
    paramView = aufd.a(paramView.findViewById(2131366742), localbfif.jdField_c_of_type_JavaLangString);
    aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Bfmo.jdField_a_of_type_Long, (bfjs)localObject, localbfif.f, localbfif.jdField_c_of_type_Int, 2, 4, paramView, false, false);
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bfmo.jdField_a_of_type_Long);
    bfif localbfif = this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif;
    bfjs localbfjs = ((TroopFileTransferManager)localObject).a(localbfif.jdField_b_of_type_JavaLangString);
    if (localbfjs != null) {
      str = localbfjs.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!FileUtils.fileExistsAndNotEmpty(str)) {
        localObject = this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif.j;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localbfif.jdField_a_of_type_JavaUtilUUID, 128);
    }
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif != null) {
      return this.jdField_a_of_type_Bfmo.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrn
 * JD-Core Version:    0.7.0.1
 */