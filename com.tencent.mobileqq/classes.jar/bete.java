import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class bete
  implements beta
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  betb jdField_a_of_type_Betb;
  boolean jdField_a_of_type_Boolean;
  
  public bete(betb parambetb)
  {
    this.jdField_a_of_type_Betb = parambetb;
    a();
  }
  
  public static ajac a()
  {
    ajac localajac = new ajac();
    localajac.jdField_a_of_type_JavaLangString = "0";
    localajac.b = amtj.a(2131710343);
    localajac.j = amtj.a(2131710346);
    localajac.g = amtj.a(2131710344);
    localajac.l = ChnToSpell.a(localajac.j, 1);
    localajac.k = ChnToSpell.a(localajac.j, 2);
    return localajac;
  }
  
  public static ArrayList<ajac> a(String paramString, List<ajac> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajac localajac = (ajac)paramList.next();
      if ((best.a(localajac.j, paramString)) || (best.a(localajac.k, paramString)) || (best.a(localajac.l, paramString)))
      {
        localajac.v = localajac.j;
        localajac.w = localajac.l;
        localajac.x = localajac.k;
        paramQQAppInterface.add(localajac);
      }
      else if ((best.a(localajac.m, paramString)) || (best.a(localajac.n, paramString)) || (best.a(localajac.o, paramString)))
      {
        localajac.v = localajac.m;
        localajac.w = localajac.o;
        localajac.x = localajac.n;
        paramQQAppInterface.add(localajac);
      }
      else if ((best.a(localajac.g, paramString)) || (best.a(localajac.h, paramString)) || (best.a(localajac.i, paramString)))
      {
        localajac.v = localajac.g;
        localajac.w = localajac.i;
        localajac.x = localajac.h;
        paramQQAppInterface.add(localajac);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (best.a(localajac.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = best.c(localajac);
          str2 = best.d(localajac);
          str3 = best.e(localajac);
          localajac.v = str1;
          localajac.w = str3;
          localajac.x = str2;
          paramQQAppInterface.add(localajac);
        }
        else if (a(localajac, paramString, paramTroopInfo))
        {
          str1 = best.c(localajac);
          str2 = best.d(localajac);
          str3 = best.e(localajac);
          localajac.v = str1;
          localajac.w = str3;
          localajac.x = str2;
          paramQQAppInterface.add(localajac);
        }
        else if (b(localajac, paramString, paramTroopInfo))
        {
          str1 = best.c(localajac);
          str2 = best.d(localajac);
          str3 = best.e(localajac);
          localajac.v = str1;
          localajac.w = str3;
          localajac.x = str2;
          paramQQAppInterface.add(localajac);
        }
        else if (c(localajac, paramString, paramTroopInfo))
        {
          str1 = best.c(localajac);
          str2 = best.d(localajac);
          str3 = best.e(localajac);
          localajac.v = str1;
          localajac.w = str3;
          localajac.x = str2;
          paramQQAppInterface.add(localajac);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ajac> a(QQAppInterface paramQQAppInterface, List<ajac> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bfdm)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajac localajac = (ajac)paramList.next();
      if (!paramQQAppInterface.b(localajac.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localajac);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ajac paramajac, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajac localajac = new ajac();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajac != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramajac.jdField_a_of_type_JavaLangString))
        {
          localajac.b = amtj.a(2131710345);
          localajac.j = amtj.a(2131710341);
          localajac.l = ChnToSpell.a(localajac.j, 1);
          localajac.k = ChnToSpell.a(localajac.j, 2);
          if ((!best.a(localajac.j, paramString)) && (!best.a(localajac.k, paramString)))
          {
            bool1 = bool2;
            if (!best.a(localajac.l, paramString)) {}
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
  
  public static boolean a(String paramString, ajac paramajac)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = best.c(paramajac);
      str2 = best.d(paramajac);
      paramajac = best.e(paramajac);
    } while ((best.a(str1, paramString)) || (best.a(str2, paramString)) || (best.a(paramajac, paramString)));
    return false;
  }
  
  private static boolean b(ajac paramajac, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajac localajac = new ajac();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajac != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramajac.jdField_a_of_type_JavaLangString))
        {
          localajac.b = amtj.a(2131710337);
          localajac.j = amtj.a(2131710340);
          localajac.l = ChnToSpell.a(localajac.j, 1);
          localajac.k = ChnToSpell.a(localajac.j, 2);
          if ((!best.a(localajac.j, paramString)) && (!best.a(localajac.k, paramString)))
          {
            bool1 = bool2;
            if (!best.a(localajac.l, paramString)) {}
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
  
  private static boolean c(ajac paramajac, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ajac();
    boolean bool1 = bool2;
    if (paramajac != null)
    {
      bool1 = bool2;
      if (paramajac.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = amtj.a(2131710338);
        paramTroopInfo.j = amtj.a(2131710342);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!best.a(paramTroopInfo.j, paramString)) && (!best.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!best.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842478);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Betb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
        paramView.setText(2131693996);
        if (this.jdField_a_of_type_Betb.jdField_a_of_type_Besq != null) {
          this.jdField_a_of_type_Betb.jdField_a_of_type_Besq.a();
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
    paramView.setText(2131692310);
    if (this.jdField_a_of_type_Betb.b) {
      this.jdField_a_of_type_Betb.notifyDataSetChanged();
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_Betb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Betb.jdField_a_of_type_Besq.a(this.jdField_a_of_type_Betb.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Betb.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, amtj.a(2131710339), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bete
 * JD-Core Version:    0.7.0.1
 */