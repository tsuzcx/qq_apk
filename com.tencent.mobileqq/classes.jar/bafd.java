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

public class bafd
  implements baez
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bafa jdField_a_of_type_Bafa;
  boolean jdField_a_of_type_Boolean;
  
  public bafd(bafa parambafa)
  {
    this.jdField_a_of_type_Bafa = parambafa;
    a();
  }
  
  public static agas a()
  {
    agas localagas = new agas();
    localagas.jdField_a_of_type_JavaLangString = "0";
    localagas.b = ajya.a(2131711240);
    localagas.j = ajya.a(2131711243);
    localagas.g = ajya.a(2131711241);
    localagas.l = ChnToSpell.a(localagas.j, 1);
    localagas.k = ChnToSpell.a(localagas.j, 2);
    return localagas;
  }
  
  public static ArrayList<agas> a(String paramString, List<agas> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      agas localagas = (agas)paramList.next();
      if ((baes.a(localagas.j, paramString)) || (baes.a(localagas.k, paramString)) || (baes.a(localagas.l, paramString)))
      {
        localagas.v = localagas.j;
        localagas.w = localagas.l;
        localagas.x = localagas.k;
        paramQQAppInterface.add(localagas);
      }
      else if ((baes.a(localagas.m, paramString)) || (baes.a(localagas.n, paramString)) || (baes.a(localagas.o, paramString)))
      {
        localagas.v = localagas.m;
        localagas.w = localagas.o;
        localagas.x = localagas.n;
        paramQQAppInterface.add(localagas);
      }
      else if ((baes.a(localagas.g, paramString)) || (baes.a(localagas.h, paramString)) || (baes.a(localagas.i, paramString)))
      {
        localagas.v = localagas.g;
        localagas.w = localagas.i;
        localagas.x = localagas.h;
        paramQQAppInterface.add(localagas);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (baes.a(localagas.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = baes.c(localagas);
          str2 = baes.d(localagas);
          str3 = baes.e(localagas);
          localagas.v = str1;
          localagas.w = str3;
          localagas.x = str2;
          paramQQAppInterface.add(localagas);
        }
        else if (a(localagas, paramString, paramTroopInfo))
        {
          str1 = baes.c(localagas);
          str2 = baes.d(localagas);
          str3 = baes.e(localagas);
          localagas.v = str1;
          localagas.w = str3;
          localagas.x = str2;
          paramQQAppInterface.add(localagas);
        }
        else if (b(localagas, paramString, paramTroopInfo))
        {
          str1 = baes.c(localagas);
          str2 = baes.d(localagas);
          str3 = baes.e(localagas);
          localagas.v = str1;
          localagas.w = str3;
          localagas.x = str2;
          paramQQAppInterface.add(localagas);
        }
        else if (c(localagas, paramString, paramTroopInfo))
        {
          str1 = baes.c(localagas);
          str2 = baes.d(localagas);
          str3 = baes.e(localagas);
          localagas.v = str1;
          localagas.w = str3;
          localagas.x = str2;
          paramQQAppInterface.add(localagas);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<agas> a(QQAppInterface paramQQAppInterface, List<agas> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bamk)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      agas localagas = (agas)paramList.next();
      if (!paramQQAppInterface.b(localagas.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localagas);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(agas paramagas, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    agas localagas = new agas();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramagas != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramagas.jdField_a_of_type_JavaLangString))
        {
          localagas.b = ajya.a(2131711242);
          localagas.j = ajya.a(2131711238);
          localagas.l = ChnToSpell.a(localagas.j, 1);
          localagas.k = ChnToSpell.a(localagas.j, 2);
          if ((!baes.a(localagas.j, paramString)) && (!baes.a(localagas.k, paramString)))
          {
            bool1 = bool2;
            if (!baes.a(localagas.l, paramString)) {}
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
  
  public static boolean a(String paramString, agas paramagas)
  {
    if (baes.a(paramString, "all")) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = baes.c(paramagas);
      str2 = baes.d(paramagas);
      paramagas = baes.e(paramagas);
    } while ((baes.a(str1, paramString)) || (baes.a(str2, paramString)) || (baes.a(paramagas, paramString)));
    return false;
  }
  
  private static boolean b(agas paramagas, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    agas localagas = new agas();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramagas != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramagas.jdField_a_of_type_JavaLangString))
        {
          localagas.b = ajya.a(2131711234);
          localagas.j = ajya.a(2131711237);
          localagas.l = ChnToSpell.a(localagas.j, 1);
          localagas.k = ChnToSpell.a(localagas.j, 2);
          if ((!baes.a(localagas.j, paramString)) && (!baes.a(localagas.k, paramString)))
          {
            bool1 = bool2;
            if (!baes.a(localagas.l, paramString)) {}
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
  
  private static boolean c(agas paramagas, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new agas();
    boolean bool1 = bool2;
    if (paramagas != null)
    {
      bool1 = bool2;
      if (paramagas.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = ajya.a(2131711235);
        paramTroopInfo.j = ajya.a(2131711239);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!baes.a(paramTroopInfo.j, paramString)) && (!baes.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!baes.a(paramTroopInfo.l, paramString)) {}
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
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bafa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694468);
        if (this.jdField_a_of_type_Bafa.jdField_a_of_type_Baep != null) {
          this.jdField_a_of_type_Bafa.jdField_a_of_type_Baep.a();
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
    paramView.setText(2131692601);
    if (this.jdField_a_of_type_Bafa.b) {
      this.jdField_a_of_type_Bafa.notifyDataSetChanged();
    }
    for (;;)
    {
      axqy.b(this.jdField_a_of_type_Bafa.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bafa.jdField_a_of_type_Baep.a(this.jdField_a_of_type_Bafa.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bafa.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    bcql.a(BaseApplicationImpl.context, 0, ajya.a(2131711236), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafd
 * JD-Core Version:    0.7.0.1
 */