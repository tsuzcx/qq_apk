import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class bgak
  implements bgag
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bgah jdField_a_of_type_Bgah;
  boolean jdField_a_of_type_Boolean;
  
  public bgak(bgah parambgah)
  {
    this.jdField_a_of_type_Bgah = parambgah;
    a();
  }
  
  public static ajvr a()
  {
    ajvr localajvr = new ajvr();
    localajvr.jdField_a_of_type_JavaLangString = "0";
    localajvr.b = anvx.a(2131710690);
    localajvr.j = anvx.a(2131710693);
    localajvr.g = anvx.a(2131710691);
    localajvr.l = ChnToSpell.a(localajvr.j, 1);
    localajvr.k = ChnToSpell.a(localajvr.j, 2);
    return localajvr;
  }
  
  public static ArrayList<ajvr> a(String paramString, List<ajvr> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajvr localajvr = (ajvr)paramList.next();
      if ((bfzz.a(localajvr.j, paramString)) || (bfzz.a(localajvr.k, paramString)) || (bfzz.a(localajvr.l, paramString)))
      {
        localajvr.v = localajvr.j;
        localajvr.w = localajvr.l;
        localajvr.x = localajvr.k;
        paramQQAppInterface.add(localajvr);
      }
      else if ((bfzz.a(localajvr.m, paramString)) || (bfzz.a(localajvr.n, paramString)) || (bfzz.a(localajvr.o, paramString)))
      {
        localajvr.v = localajvr.m;
        localajvr.w = localajvr.o;
        localajvr.x = localajvr.n;
        paramQQAppInterface.add(localajvr);
      }
      else if ((bfzz.a(localajvr.g, paramString)) || (bfzz.a(localajvr.h, paramString)) || (bfzz.a(localajvr.i, paramString)))
      {
        localajvr.v = localajvr.g;
        localajvr.w = localajvr.i;
        localajvr.x = localajvr.h;
        paramQQAppInterface.add(localajvr);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (bfzz.a(localajvr.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = bfzz.c(localajvr);
          str2 = bfzz.d(localajvr);
          str3 = bfzz.e(localajvr);
          localajvr.v = str1;
          localajvr.w = str3;
          localajvr.x = str2;
          paramQQAppInterface.add(localajvr);
        }
        else if (a(localajvr, paramString, paramTroopInfo))
        {
          str1 = bfzz.c(localajvr);
          str2 = bfzz.d(localajvr);
          str3 = bfzz.e(localajvr);
          localajvr.v = str1;
          localajvr.w = str3;
          localajvr.x = str2;
          paramQQAppInterface.add(localajvr);
        }
        else if (b(localajvr, paramString, paramTroopInfo))
        {
          str1 = bfzz.c(localajvr);
          str2 = bfzz.d(localajvr);
          str3 = bfzz.e(localajvr);
          localajvr.v = str1;
          localajvr.w = str3;
          localajvr.x = str2;
          paramQQAppInterface.add(localajvr);
        }
        else if (c(localajvr, paramString, paramTroopInfo))
        {
          str1 = bfzz.c(localajvr);
          str2 = bfzz.d(localajvr);
          str3 = bfzz.e(localajvr);
          localajvr.v = str1;
          localajvr.w = str3;
          localajvr.x = str2;
          paramQQAppInterface.add(localajvr);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ajvr> a(QQAppInterface paramQQAppInterface, List<ajvr> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajvr localajvr = (ajvr)paramList.next();
      if (!paramQQAppInterface.b(localajvr.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localajvr);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ajvr paramajvr, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajvr localajvr = new ajvr();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajvr != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramajvr.jdField_a_of_type_JavaLangString))
        {
          localajvr.b = anvx.a(2131710692);
          localajvr.j = anvx.a(2131710688);
          localajvr.l = ChnToSpell.a(localajvr.j, 1);
          localajvr.k = ChnToSpell.a(localajvr.j, 2);
          if ((!bfzz.a(localajvr.j, paramString)) && (!bfzz.a(localajvr.k, paramString)))
          {
            bool1 = bool2;
            if (!bfzz.a(localajvr.l, paramString)) {}
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
  
  public static boolean a(String paramString, ajvr paramajvr)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = bfzz.c(paramajvr);
      str2 = bfzz.d(paramajvr);
      paramajvr = bfzz.e(paramajvr);
    } while ((bfzz.a(str1, paramString)) || (bfzz.a(str2, paramString)) || (bfzz.a(paramajvr, paramString)));
    return false;
  }
  
  private static boolean b(ajvr paramajvr, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajvr localajvr = new ajvr();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajvr != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramajvr.jdField_a_of_type_JavaLangString))
        {
          localajvr.b = anvx.a(2131710684);
          localajvr.j = anvx.a(2131710687);
          localajvr.l = ChnToSpell.a(localajvr.j, 1);
          localajvr.k = ChnToSpell.a(localajvr.j, 2);
          if ((!bfzz.a(localajvr.j, paramString)) && (!bfzz.a(localajvr.k, paramString)))
          {
            bool1 = bool2;
            if (!bfzz.a(localajvr.l, paramString)) {}
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
  
  private static boolean c(ajvr paramajvr, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ajvr();
    boolean bool1 = bool2;
    if (paramajvr != null)
    {
      bool1 = bool2;
      if (paramajvr.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = anvx.a(2131710685);
        paramTroopInfo.j = anvx.a(2131710689);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!bfzz.a(paramTroopInfo.j, paramString)) && (!bfzz.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!bfzz.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842508);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Bgah.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidGraphicsBitmap = QQAppInterface.getRoundFaceBitmap(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694187);
        if (this.jdField_a_of_type_Bgah.jdField_a_of_type_Bfzw != null) {
          this.jdField_a_of_type_Bgah.jdField_a_of_type_Bfzw.a();
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
    paramView.setText(2131692403);
    if (this.jdField_a_of_type_Bgah.b) {
      this.jdField_a_of_type_Bgah.notifyDataSetChanged();
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_Bgah.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bgah.jdField_a_of_type_Bfzw.a(this.jdField_a_of_type_Bgah.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bgah.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, anvx.a(2131710686), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgak
 * JD-Core Version:    0.7.0.1
 */