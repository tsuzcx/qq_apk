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

public class bgjw
  implements bgjs
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bgjt jdField_a_of_type_Bgjt;
  boolean jdField_a_of_type_Boolean;
  
  public bgjw(bgjt parambgjt)
  {
    this.jdField_a_of_type_Bgjt = parambgjt;
    a();
  }
  
  public static akfc a()
  {
    akfc localakfc = new akfc();
    localakfc.jdField_a_of_type_JavaLangString = "0";
    localakfc.b = anzj.a(2131710111);
    localakfc.j = anzj.a(2131710114);
    localakfc.g = anzj.a(2131710112);
    localakfc.l = ChnToSpell.a(localakfc.j, 1);
    localakfc.k = ChnToSpell.a(localakfc.j, 2);
    return localakfc;
  }
  
  public static ArrayList<akfc> a(String paramString, List<akfc> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akfc localakfc = (akfc)paramList.next();
      if ((bgjl.a(localakfc.j, paramString)) || (bgjl.a(localakfc.k, paramString)) || (bgjl.a(localakfc.l, paramString)))
      {
        localakfc.v = localakfc.j;
        localakfc.w = localakfc.l;
        localakfc.x = localakfc.k;
        paramQQAppInterface.add(localakfc);
      }
      else if ((bgjl.a(localakfc.m, paramString)) || (bgjl.a(localakfc.n, paramString)) || (bgjl.a(localakfc.o, paramString)))
      {
        localakfc.v = localakfc.m;
        localakfc.w = localakfc.o;
        localakfc.x = localakfc.n;
        paramQQAppInterface.add(localakfc);
      }
      else if ((bgjl.a(localakfc.g, paramString)) || (bgjl.a(localakfc.h, paramString)) || (bgjl.a(localakfc.i, paramString)))
      {
        localakfc.v = localakfc.g;
        localakfc.w = localakfc.i;
        localakfc.x = localakfc.h;
        paramQQAppInterface.add(localakfc);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (bgjl.a(localakfc.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = bgjl.c(localakfc);
          str2 = bgjl.d(localakfc);
          str3 = bgjl.e(localakfc);
          localakfc.v = str1;
          localakfc.w = str3;
          localakfc.x = str2;
          paramQQAppInterface.add(localakfc);
        }
        else if (a(localakfc, paramString, paramTroopInfo))
        {
          str1 = bgjl.c(localakfc);
          str2 = bgjl.d(localakfc);
          str3 = bgjl.e(localakfc);
          localakfc.v = str1;
          localakfc.w = str3;
          localakfc.x = str2;
          paramQQAppInterface.add(localakfc);
        }
        else if (b(localakfc, paramString, paramTroopInfo))
        {
          str1 = bgjl.c(localakfc);
          str2 = bgjl.d(localakfc);
          str3 = bgjl.e(localakfc);
          localakfc.v = str1;
          localakfc.w = str3;
          localakfc.x = str2;
          paramQQAppInterface.add(localakfc);
        }
        else if (c(localakfc, paramString, paramTroopInfo))
        {
          str1 = bgjl.c(localakfc);
          str2 = bgjl.d(localakfc);
          str3 = bgjl.e(localakfc);
          localakfc.v = str1;
          localakfc.w = str3;
          localakfc.x = str2;
          paramQQAppInterface.add(localakfc);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<akfc> a(QQAppInterface paramQQAppInterface, List<akfc> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bgty)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      akfc localakfc = (akfc)paramList.next();
      if (!paramQQAppInterface.b(localakfc.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localakfc);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(akfc paramakfc, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    akfc localakfc = new akfc();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramakfc != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramakfc.jdField_a_of_type_JavaLangString))
        {
          localakfc.b = anzj.a(2131710113);
          localakfc.j = anzj.a(2131710109);
          localakfc.l = ChnToSpell.a(localakfc.j, 1);
          localakfc.k = ChnToSpell.a(localakfc.j, 2);
          if ((!bgjl.a(localakfc.j, paramString)) && (!bgjl.a(localakfc.k, paramString)))
          {
            bool1 = bool2;
            if (!bgjl.a(localakfc.l, paramString)) {}
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
  
  public static boolean a(String paramString, akfc paramakfc)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = bgjl.c(paramakfc);
      str2 = bgjl.d(paramakfc);
      paramakfc = bgjl.e(paramakfc);
    } while ((bgjl.a(str1, paramString)) || (bgjl.a(str2, paramString)) || (bgjl.a(paramakfc, paramString)));
    return false;
  }
  
  private static boolean b(akfc paramakfc, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    akfc localakfc = new akfc();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramakfc != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramakfc.jdField_a_of_type_JavaLangString))
        {
          localakfc.b = anzj.a(2131710105);
          localakfc.j = anzj.a(2131710108);
          localakfc.l = ChnToSpell.a(localakfc.j, 1);
          localakfc.k = ChnToSpell.a(localakfc.j, 2);
          if ((!bgjl.a(localakfc.j, paramString)) && (!bgjl.a(localakfc.k, paramString)))
          {
            bool1 = bool2;
            if (!bgjl.a(localakfc.l, paramString)) {}
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
  
  private static boolean c(akfc paramakfc, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new akfc();
    boolean bool1 = bool2;
    if (paramakfc != null)
    {
      bool1 = bool2;
      if (paramakfc.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = anzj.a(2131710106);
        paramTroopInfo.j = anzj.a(2131710110);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!bgjl.a(paramTroopInfo.j, paramString)) && (!bgjl.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!bgjl.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842432);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bgjt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131693897);
        if (this.jdField_a_of_type_Bgjt.jdField_a_of_type_Bgji != null) {
          this.jdField_a_of_type_Bgjt.jdField_a_of_type_Bgji.a();
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
    paramView.setText(2131692262);
    if (this.jdField_a_of_type_Bgjt.b) {
      this.jdField_a_of_type_Bgjt.notifyDataSetChanged();
    }
    for (;;)
    {
      bdll.b(this.jdField_a_of_type_Bgjt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bgjt.jdField_a_of_type_Bgji.a(this.jdField_a_of_type_Bgjt.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bgjt.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, anzj.a(2131710107), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjw
 * JD-Core Version:    0.7.0.1
 */