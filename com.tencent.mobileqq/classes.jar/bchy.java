import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class bchy
  implements bchu
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bchv jdField_a_of_type_Bchv;
  boolean jdField_a_of_type_Boolean;
  
  public bchy(bchv parambchv)
  {
    this.jdField_a_of_type_Bchv = parambchv;
    a();
  }
  
  public static aidf a()
  {
    aidf localaidf = new aidf();
    localaidf.jdField_a_of_type_JavaLangString = "0";
    localaidf.b = alud.a(2131711624);
    localaidf.j = alud.a(2131711627);
    localaidf.g = alud.a(2131711625);
    localaidf.l = ChnToSpell.a(localaidf.j, 1);
    localaidf.k = ChnToSpell.a(localaidf.j, 2);
    return localaidf;
  }
  
  public static ArrayList<aidf> a(String paramString, List<aidf> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aidf localaidf = (aidf)paramList.next();
      if ((bchn.a(localaidf.j, paramString)) || (bchn.a(localaidf.k, paramString)) || (bchn.a(localaidf.l, paramString)))
      {
        localaidf.v = localaidf.j;
        localaidf.w = localaidf.l;
        localaidf.x = localaidf.k;
        paramQQAppInterface.add(localaidf);
      }
      else if ((bchn.a(localaidf.m, paramString)) || (bchn.a(localaidf.n, paramString)) || (bchn.a(localaidf.o, paramString)))
      {
        localaidf.v = localaidf.m;
        localaidf.w = localaidf.o;
        localaidf.x = localaidf.n;
        paramQQAppInterface.add(localaidf);
      }
      else if ((bchn.a(localaidf.g, paramString)) || (bchn.a(localaidf.h, paramString)) || (bchn.a(localaidf.i, paramString)))
      {
        localaidf.v = localaidf.g;
        localaidf.w = localaidf.i;
        localaidf.x = localaidf.h;
        paramQQAppInterface.add(localaidf);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (bchn.a(localaidf.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = bchn.c(localaidf);
          str2 = bchn.d(localaidf);
          str3 = bchn.e(localaidf);
          localaidf.v = str1;
          localaidf.w = str3;
          localaidf.x = str2;
          paramQQAppInterface.add(localaidf);
        }
        else if (a(localaidf, paramString, paramTroopInfo))
        {
          str1 = bchn.c(localaidf);
          str2 = bchn.d(localaidf);
          str3 = bchn.e(localaidf);
          localaidf.v = str1;
          localaidf.w = str3;
          localaidf.x = str2;
          paramQQAppInterface.add(localaidf);
        }
        else if (b(localaidf, paramString, paramTroopInfo))
        {
          str1 = bchn.c(localaidf);
          str2 = bchn.d(localaidf);
          str3 = bchn.e(localaidf);
          localaidf.v = str1;
          localaidf.w = str3;
          localaidf.x = str2;
          paramQQAppInterface.add(localaidf);
        }
        else if (c(localaidf, paramString, paramTroopInfo))
        {
          str1 = bchn.c(localaidf);
          str2 = bchn.d(localaidf);
          str3 = bchn.e(localaidf);
          localaidf.v = str1;
          localaidf.w = str3;
          localaidf.x = str2;
          paramQQAppInterface.add(localaidf);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<aidf> a(QQAppInterface paramQQAppInterface, List<aidf> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bcpg)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aidf localaidf = (aidf)paramList.next();
      if (!paramQQAppInterface.b(localaidf.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localaidf);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(aidf paramaidf, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    aidf localaidf = new aidf();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramaidf != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramaidf.jdField_a_of_type_JavaLangString))
        {
          localaidf.b = alud.a(2131711626);
          localaidf.j = alud.a(2131711622);
          localaidf.l = ChnToSpell.a(localaidf.j, 1);
          localaidf.k = ChnToSpell.a(localaidf.j, 2);
          if ((!bchn.a(localaidf.j, paramString)) && (!bchn.a(localaidf.k, paramString)))
          {
            bool1 = bool2;
            if (!bchn.a(localaidf.l, paramString)) {}
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
  
  public static boolean a(String paramString, aidf paramaidf)
  {
    if (bchn.a(paramString, "all")) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = bchn.c(paramaidf);
      str2 = bchn.d(paramaidf);
      paramaidf = bchn.e(paramaidf);
    } while ((bchn.a(str1, paramString)) || (bchn.a(str2, paramString)) || (bchn.a(paramaidf, paramString)));
    return false;
  }
  
  private static boolean b(aidf paramaidf, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    aidf localaidf = new aidf();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramaidf != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramaidf.jdField_a_of_type_JavaLangString))
        {
          localaidf.b = alud.a(2131711618);
          localaidf.j = alud.a(2131711621);
          localaidf.l = ChnToSpell.a(localaidf.j, 1);
          localaidf.k = ChnToSpell.a(localaidf.j, 2);
          if ((!bchn.a(localaidf.j, paramString)) && (!bchn.a(localaidf.k, paramString)))
          {
            bool1 = bool2;
            if (!bchn.a(localaidf.l, paramString)) {}
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
  
  private static boolean c(aidf paramaidf, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new aidf();
    boolean bool1 = bool2;
    if (paramaidf != null)
    {
      bool1 = bool2;
      if (paramaidf.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = alud.a(2131711619);
        paramTroopInfo.j = alud.a(2131711623);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!bchn.a(paramTroopInfo.j, paramString)) && (!bchn.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!bchn.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842110);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bchv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694627);
        if (this.jdField_a_of_type_Bchv.jdField_a_of_type_Bchk != null) {
          this.jdField_a_of_type_Bchv.jdField_a_of_type_Bchk.a();
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
    paramView.setText(2131692682);
    if (this.jdField_a_of_type_Bchv.b) {
      this.jdField_a_of_type_Bchv.notifyDataSetChanged();
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_Bchv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bchv.jdField_a_of_type_Bchk.a(this.jdField_a_of_type_Bchv.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bchv.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, alud.a(2131711620), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchy
 * JD-Core Version:    0.7.0.1
 */