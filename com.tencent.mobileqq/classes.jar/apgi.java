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

public class apgi
  implements awog
{
  private Context jdField_a_of_type_AndroidContentContext;
  private azta jdField_a_of_type_Azta;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private CharSequence b;
  
  public apgi(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, azta paramazta)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Azta = paramazta;
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Azta == null) {
      return;
    }
    Object localObject4 = "";
    long l1 = this.jdField_a_of_type_Azta.jdField_a_of_type_Long;
    long l2 = this.jdField_a_of_type_Azta.jdField_b_of_type_Long;
    long l3 = this.jdField_a_of_type_Azta.jdField_c_of_type_Long;
    azpg localazpg = this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg;
    Object localObject1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(l1), String.valueOf(l2));
    int i;
    Object localObject2;
    label107:
    Object localObject3;
    if ((localObject1 != null) && (bbcl.a(((TroopMemberInfo)localObject1).troopnick, String.valueOf(l3))))
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      localObject2 = ((TroopMemberInfo)localObject1).troopnick;
      if (this.jdField_a_of_type_Azta.jdField_c_of_type_Long <= 0L) {
        break label593;
      }
      localObject3 = String.valueOf(this.jdField_a_of_type_Azta.jdField_c_of_type_Long);
      localObject4 = aztb.a();
      localObject1 = ((aztb)localObject4).a((String)localObject3);
      if (localObject1 == null) {
        break label450;
      }
      i = aztb.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString, ((awhj)localObject1).jdField_c_of_type_JavaLangString, ((awhj)localObject1).d, this.jdField_a_of_type_Azta.d, ((awhj)localObject1).jdField_a_of_type_JavaLangString, ((awhj)localObject1).jdField_b_of_type_JavaLangString);
      localObject1 = aztb.a((String)localObject2, this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Azta.d, i);
      label216:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label515;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString)) {
        break label503;
      }
      localObject1 = this.jdField_a_of_type_Azta.d;
      label246:
      localObject3 = "";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      label258:
      localObject3 = localObject2;
      if ((this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        localObject2 = (String)this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((TextUtils.isEmpty(localazpg.jdField_c_of_type_JavaLangString)) || (!localazpg.jdField_c_of_type_JavaLangString.toLowerCase().contains(((String)localObject2).toLowerCase()))) {}
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangCharSequence = localazpg.jdField_c_of_type_JavaLangString;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_JavaLangCharSequence = awvy.a(localazpg.jdField_c_of_type_JavaLangString, (String)localObject2);
        }
        localObject2 = localazpg.a();
        localObject4 = localazpg.l;
        Object localObject5 = new SpannableStringBuilder();
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append("  ");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((SpannableStringBuilder)localObject5).append(awvy.a((String)localObject3, (String)localObject1)).append("  ");
        }
        for (;;)
        {
          ((SpannableStringBuilder)localObject5).append((CharSequence)localObject2);
          this.b = ((CharSequence)localObject5);
          return;
          i = 0;
          break;
          label444:
          localObject2 = null;
          break label107;
          label450:
          i = aztb.a(this.jdField_a_of_type_JavaLangString, (String)localObject2, this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString, null, null, this.jdField_a_of_type_Azta.d, null, null);
          localObject1 = aztb.a((String)localObject2, this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Azta.d, i);
          break label216;
          label503:
          localObject1 = this.jdField_a_of_type_Azta.jdField_c_of_type_JavaLangString;
          break label246;
          label515:
          if ((i == 1) || (i == 4) || (i == 7))
          {
            localObject3 = this.jdField_a_of_type_JavaLangString;
            localObject2 = localObject1;
            localObject1 = localObject3;
            break label258;
          }
          if ((i != 5) && (i != 6) && (i != 2) && (i != 3)) {
            break label738;
          }
          localObject3 = ((aztb)localObject4).a(this.jdField_a_of_type_JavaLangString, (String)localObject3);
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label258;
          label593:
          if (i != 0) {}
          for (;;)
          {
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList == null) {
              break;
            }
            localObject3 = localObject2;
            localObject1 = localObject4;
            if (this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
              break;
            }
            localObject5 = (String)this.jdField_a_of_type_Azta.jdField_a_of_type_JavaUtilArrayList.get(0);
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
            localObject2 = this.jdField_a_of_type_Azta.jdField_b_of_type_JavaLangString;
          }
          ((SpannableStringBuilder)localObject5).append((CharSequence)localObject3).append("  ");
        }
        localObject2 = "";
      }
      label738:
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azta.jdField_a_of_type_Long);
    azpg localazpg = this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg;
    azqt localazqt = ((TroopFileTransferManager)localObject).a(localazpg.jdField_b_of_type_JavaLangString);
    localObject = localazqt;
    if (localazqt == null)
    {
      localObject = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azta.jdField_a_of_type_Long, localazpg.jdField_a_of_type_JavaUtilUUID.toString(), localazpg.jdField_b_of_type_JavaLangString, localazpg.jdField_c_of_type_JavaLangString, localazpg.jdField_a_of_type_Long, localazpg.jdField_a_of_type_Int);
      ((azqt)localObject).jdField_c_of_type_JavaLangString = localazpg.j;
      ((azqt)localObject).d = localazpg.k;
      ((azqt)localObject).jdField_b_of_type_JavaLangString = localazpg.i;
    }
    if ((localObject != null) && (((azqt)localObject).jdField_c_of_type_Long == 0L)) {
      ((azqt)localObject).jdField_c_of_type_Long = localazpg.jdField_a_of_type_Long;
    }
    paramView = apvk.a(paramView.findViewById(2131366211), localazpg.jdField_c_of_type_JavaLangString);
    apvk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Azta.jdField_a_of_type_Long, (azqt)localObject, localazpg.e, localazpg.jdField_c_of_type_Int, 2, 4, paramView, false, false);
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
    Object localObject = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azta.jdField_a_of_type_Long);
    azpg localazpg = this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg;
    azqt localazqt = ((TroopFileTransferManager)localObject).a(localazpg.jdField_b_of_type_JavaLangString);
    if (localazqt != null) {
      str = localazqt.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = str;
      if (!bbdj.b(str)) {
        localObject = this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg.i;
      }
      return localObject;
      ((TroopFileTransferManager)localObject).a(localazpg.jdField_a_of_type_JavaUtilUUID, 128);
    }
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg != null) {
      return this.jdField_a_of_type_Azta.jdField_a_of_type_Azpg.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgi
 * JD-Core Version:    0.7.0.1
 */