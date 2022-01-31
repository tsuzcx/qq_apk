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

public class azdu
  implements azdq
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  azdr jdField_a_of_type_Azdr;
  boolean jdField_a_of_type_Boolean;
  
  public azdu(azdr paramazdr)
  {
    this.jdField_a_of_type_Azdr = paramazdr;
    a();
  }
  
  public static afou a()
  {
    afou localafou = new afou();
    localafou.jdField_a_of_type_JavaLangString = "0";
    localafou.b = ajjy.a(2131645441);
    localafou.j = ajjy.a(2131645444);
    localafou.g = ajjy.a(2131645442);
    localafou.l = ChnToSpell.a(localafou.j, 1);
    localafou.k = ChnToSpell.a(localafou.j, 2);
    return localafou;
  }
  
  public static ArrayList<afou> a(String paramString, List<afou> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      afou localafou = (afou)paramList.next();
      if ((azdj.a(localafou.j, paramString)) || (azdj.a(localafou.k, paramString)) || (azdj.a(localafou.l, paramString)))
      {
        localafou.v = localafou.j;
        localafou.w = localafou.l;
        localafou.x = localafou.k;
        paramQQAppInterface.add(localafou);
      }
      else if ((azdj.a(localafou.m, paramString)) || (azdj.a(localafou.n, paramString)) || (azdj.a(localafou.o, paramString)))
      {
        localafou.v = localafou.m;
        localafou.w = localafou.o;
        localafou.x = localafou.n;
        paramQQAppInterface.add(localafou);
      }
      else if ((azdj.a(localafou.g, paramString)) || (azdj.a(localafou.h, paramString)) || (azdj.a(localafou.i, paramString)))
      {
        localafou.v = localafou.g;
        localafou.w = localafou.i;
        localafou.x = localafou.h;
        paramQQAppInterface.add(localafou);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (azdj.a(localafou.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = azdj.c(localafou);
          str2 = azdj.d(localafou);
          str3 = azdj.e(localafou);
          localafou.v = str1;
          localafou.w = str3;
          localafou.x = str2;
          paramQQAppInterface.add(localafou);
        }
        else if (a(localafou, paramString, paramTroopInfo))
        {
          str1 = azdj.c(localafou);
          str2 = azdj.d(localafou);
          str3 = azdj.e(localafou);
          localafou.v = str1;
          localafou.w = str3;
          localafou.x = str2;
          paramQQAppInterface.add(localafou);
        }
        else if (b(localafou, paramString, paramTroopInfo))
        {
          str1 = azdj.c(localafou);
          str2 = azdj.d(localafou);
          str3 = azdj.e(localafou);
          localafou.v = str1;
          localafou.w = str3;
          localafou.x = str2;
          paramQQAppInterface.add(localafou);
        }
        else if (c(localafou, paramString, paramTroopInfo))
        {
          str1 = azdj.c(localafou);
          str2 = azdj.d(localafou);
          str3 = azdj.e(localafou);
          localafou.v = str1;
          localafou.w = str3;
          localafou.x = str2;
          paramQQAppInterface.add(localafou);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<afou> a(QQAppInterface paramQQAppInterface, List<afou> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (azks)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      afou localafou = (afou)paramList.next();
      if (!paramQQAppInterface.b(localafou.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localafou);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(afou paramafou, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    afou localafou = new afou();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramafou != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramafou.jdField_a_of_type_JavaLangString))
        {
          localafou.b = ajjy.a(2131645443);
          localafou.j = ajjy.a(2131645439);
          localafou.l = ChnToSpell.a(localafou.j, 1);
          localafou.k = ChnToSpell.a(localafou.j, 2);
          if ((!azdj.a(localafou.j, paramString)) && (!azdj.a(localafou.k, paramString)))
          {
            bool1 = bool2;
            if (!azdj.a(localafou.l, paramString)) {}
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
  
  public static boolean a(String paramString, afou paramafou)
  {
    if (azdj.a(paramString, "all")) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = azdj.c(paramafou);
      str2 = azdj.d(paramafou);
      paramafou = azdj.e(paramafou);
    } while ((azdj.a(str1, paramString)) || (azdj.a(str2, paramString)) || (azdj.a(paramafou, paramString)));
    return false;
  }
  
  private static boolean b(afou paramafou, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    afou localafou = new afou();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramafou != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramafou.jdField_a_of_type_JavaLangString))
        {
          localafou.b = ajjy.a(2131645435);
          localafou.j = ajjy.a(2131645438);
          localafou.l = ChnToSpell.a(localafou.j, 1);
          localafou.k = ChnToSpell.a(localafou.j, 2);
          if ((!azdj.a(localafou.j, paramString)) && (!azdj.a(localafou.k, paramString)))
          {
            bool1 = bool2;
            if (!azdj.a(localafou.l, paramString)) {}
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
  
  private static boolean c(afou paramafou, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new afou();
    boolean bool1 = bool2;
    if (paramafou != null)
    {
      bool1 = bool2;
      if (paramafou.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = ajjy.a(2131645436);
        paramTroopInfo.j = ajjy.a(2131645440);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!azdj.a(paramTroopInfo.j, paramString)) && (!azdj.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!azdj.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130841851);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Azdr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131628806);
        if (this.jdField_a_of_type_Azdr.jdField_a_of_type_Azdg != null) {
          this.jdField_a_of_type_Azdr.jdField_a_of_type_Azdg.a();
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
    paramView.setText(2131626982);
    if (this.jdField_a_of_type_Azdr.b) {
      this.jdField_a_of_type_Azdr.notifyDataSetChanged();
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_Azdr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Azdr.jdField_a_of_type_Azdg.a(this.jdField_a_of_type_Azdr.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Azdr.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    bbmy.a(BaseApplicationImpl.context, 0, ajjy.a(2131645437), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdu
 * JD-Core Version:    0.7.0.1
 */