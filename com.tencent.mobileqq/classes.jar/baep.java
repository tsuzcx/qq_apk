import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class baep
  implements bael
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  baem jdField_a_of_type_Baem;
  boolean jdField_a_of_type_Boolean;
  
  public baep(baem parambaem)
  {
    this.jdField_a_of_type_Baem = parambaem;
    a();
  }
  
  public static agau a()
  {
    agau localagau = new agau();
    localagau.jdField_a_of_type_JavaLangString = "0";
    localagau.b = ajyc.a(2131711229);
    localagau.j = ajyc.a(2131711232);
    localagau.g = ajyc.a(2131711230);
    localagau.l = ChnToSpell.a(localagau.j, 1);
    localagau.k = ChnToSpell.a(localagau.j, 2);
    return localagau;
  }
  
  public static ArrayList<agau> a(String paramString, List<agau> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      agau localagau = (agau)paramList.next();
      if ((baee.a(localagau.j, paramString)) || (baee.a(localagau.k, paramString)) || (baee.a(localagau.l, paramString)))
      {
        localagau.v = localagau.j;
        localagau.w = localagau.l;
        localagau.x = localagau.k;
        paramQQAppInterface.add(localagau);
      }
      else if ((baee.a(localagau.m, paramString)) || (baee.a(localagau.n, paramString)) || (baee.a(localagau.o, paramString)))
      {
        localagau.v = localagau.m;
        localagau.w = localagau.o;
        localagau.x = localagau.n;
        paramQQAppInterface.add(localagau);
      }
      else if ((baee.a(localagau.g, paramString)) || (baee.a(localagau.h, paramString)) || (baee.a(localagau.i, paramString)))
      {
        localagau.v = localagau.g;
        localagau.w = localagau.i;
        localagau.x = localagau.h;
        paramQQAppInterface.add(localagau);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (baee.a(localagau.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = baee.c(localagau);
          str2 = baee.d(localagau);
          str3 = baee.e(localagau);
          localagau.v = str1;
          localagau.w = str3;
          localagau.x = str2;
          paramQQAppInterface.add(localagau);
        }
        else if (a(localagau, paramString, paramTroopInfo))
        {
          str1 = baee.c(localagau);
          str2 = baee.d(localagau);
          str3 = baee.e(localagau);
          localagau.v = str1;
          localagau.w = str3;
          localagau.x = str2;
          paramQQAppInterface.add(localagau);
        }
        else if (b(localagau, paramString, paramTroopInfo))
        {
          str1 = baee.c(localagau);
          str2 = baee.d(localagau);
          str3 = baee.e(localagau);
          localagau.v = str1;
          localagau.w = str3;
          localagau.x = str2;
          paramQQAppInterface.add(localagau);
        }
        else if (c(localagau, paramString, paramTroopInfo))
        {
          str1 = baee.c(localagau);
          str2 = baee.d(localagau);
          str3 = baee.e(localagau);
          localagau.v = str1;
          localagau.w = str3;
          localagau.x = str2;
          paramQQAppInterface.add(localagau);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<agau> a(QQAppInterface paramQQAppInterface, List<agau> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (balw)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      agau localagau = (agau)paramList.next();
      if (!paramQQAppInterface.b(localagau.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localagau);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(agau paramagau, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    agau localagau = new agau();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramagau != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramagau.jdField_a_of_type_JavaLangString))
        {
          localagau.b = ajyc.a(2131711231);
          localagau.j = ajyc.a(2131711227);
          localagau.l = ChnToSpell.a(localagau.j, 1);
          localagau.k = ChnToSpell.a(localagau.j, 2);
          if ((!baee.a(localagau.j, paramString)) && (!baee.a(localagau.k, paramString)))
          {
            bool1 = bool2;
            if (!baee.a(localagau.l, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, agau paramagau)
  {
    if (baee.a(paramString, "all")) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = baee.c(paramagau);
      str2 = baee.d(paramagau);
      paramagau = baee.e(paramagau);
    } while ((baee.a(str1, paramString)) || (baee.a(str2, paramString)) || (baee.a(paramagau, paramString)));
    return false;
  }
  
  private static boolean b(agau paramagau, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    agau localagau = new agau();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramagau != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramagau.jdField_a_of_type_JavaLangString))
        {
          localagau.b = ajyc.a(2131711223);
          localagau.j = ajyc.a(2131711226);
          localagau.l = ChnToSpell.a(localagau.j, 1);
          localagau.k = ChnToSpell.a(localagau.j, 2);
          if ((!baee.a(localagau.j, paramString)) && (!baee.a(localagau.k, paramString)))
          {
            bool1 = bool2;
            if (!baee.a(localagau.l, paramString)) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean c(agau paramagau, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new agau();
    boolean bool1 = bool2;
    if (paramagau != null)
    {
      bool1 = bool2;
      if (paramagau.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = ajyc.a(2131711224);
        paramTroopInfo.j = ajyc.a(2131711228);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!baee.a(paramTroopInfo.j, paramString)) && (!baee.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!baee.a(paramTroopInfo.l, paramString)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  void a()
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841945);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Baem.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694467);
        if (this.jdField_a_of_type_Baem.jdField_a_of_type_Baeb != null) {
          this.jdField_a_of_type_Baem.jdField_a_of_type_Baeb.a();
        }
        if (!this.jdField_a_of_type_Boolean) {
          bool = true;
        }
        this.jdField_a_of_type_Boolean = bool;
      }
    }
    else
    {
      return;
    }
    paramView.setText(2131692600);
    if (this.jdField_a_of_type_Baem.b) {
      this.jdField_a_of_type_Baem.notifyDataSetChanged();
    }
    for (;;)
    {
      axqw.b(this.jdField_a_of_type_Baem.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Baem.jdField_a_of_type_Baeb.a(this.jdField_a_of_type_Baem.jdField_a_of_type_JavaLangString, true);
    }
  }
  
  void a(ImageView paramImageView)
  {
    if (paramImageView != null) {
      paramImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Baem.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    bcpw.a(BaseApplicationImpl.context, 0, ajyc.a(2131711225), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baep
 * JD-Core Version:    0.7.0.1
 */