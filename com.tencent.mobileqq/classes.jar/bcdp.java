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

public class bcdp
  implements bcdl
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bcdm jdField_a_of_type_Bcdm;
  boolean jdField_a_of_type_Boolean;
  
  public bcdp(bcdm parambcdm)
  {
    this.jdField_a_of_type_Bcdm = parambcdm;
    a();
  }
  
  public static ahyq a()
  {
    ahyq localahyq = new ahyq();
    localahyq.jdField_a_of_type_JavaLangString = "0";
    localahyq.b = alpo.a(2131711612);
    localahyq.j = alpo.a(2131711615);
    localahyq.g = alpo.a(2131711613);
    localahyq.l = ChnToSpell.a(localahyq.j, 1);
    localahyq.k = ChnToSpell.a(localahyq.j, 2);
    return localahyq;
  }
  
  public static ArrayList<ahyq> a(String paramString, List<ahyq> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ahyq localahyq = (ahyq)paramList.next();
      if ((bcde.a(localahyq.j, paramString)) || (bcde.a(localahyq.k, paramString)) || (bcde.a(localahyq.l, paramString)))
      {
        localahyq.v = localahyq.j;
        localahyq.w = localahyq.l;
        localahyq.x = localahyq.k;
        paramQQAppInterface.add(localahyq);
      }
      else if ((bcde.a(localahyq.m, paramString)) || (bcde.a(localahyq.n, paramString)) || (bcde.a(localahyq.o, paramString)))
      {
        localahyq.v = localahyq.m;
        localahyq.w = localahyq.o;
        localahyq.x = localahyq.n;
        paramQQAppInterface.add(localahyq);
      }
      else if ((bcde.a(localahyq.g, paramString)) || (bcde.a(localahyq.h, paramString)) || (bcde.a(localahyq.i, paramString)))
      {
        localahyq.v = localahyq.g;
        localahyq.w = localahyq.i;
        localahyq.x = localahyq.h;
        paramQQAppInterface.add(localahyq);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (bcde.a(localahyq.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = bcde.c(localahyq);
          str2 = bcde.d(localahyq);
          str3 = bcde.e(localahyq);
          localahyq.v = str1;
          localahyq.w = str3;
          localahyq.x = str2;
          paramQQAppInterface.add(localahyq);
        }
        else if (a(localahyq, paramString, paramTroopInfo))
        {
          str1 = bcde.c(localahyq);
          str2 = bcde.d(localahyq);
          str3 = bcde.e(localahyq);
          localahyq.v = str1;
          localahyq.w = str3;
          localahyq.x = str2;
          paramQQAppInterface.add(localahyq);
        }
        else if (b(localahyq, paramString, paramTroopInfo))
        {
          str1 = bcde.c(localahyq);
          str2 = bcde.d(localahyq);
          str3 = bcde.e(localahyq);
          localahyq.v = str1;
          localahyq.w = str3;
          localahyq.x = str2;
          paramQQAppInterface.add(localahyq);
        }
        else if (c(localahyq, paramString, paramTroopInfo))
        {
          str1 = bcde.c(localahyq);
          str2 = bcde.d(localahyq);
          str3 = bcde.e(localahyq);
          localahyq.v = str1;
          localahyq.w = str3;
          localahyq.x = str2;
          paramQQAppInterface.add(localahyq);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ahyq> a(QQAppInterface paramQQAppInterface, List<ahyq> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bckx)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ahyq localahyq = (ahyq)paramList.next();
      if (!paramQQAppInterface.b(localahyq.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localahyq);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ahyq paramahyq, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ahyq localahyq = new ahyq();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramahyq != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramahyq.jdField_a_of_type_JavaLangString))
        {
          localahyq.b = alpo.a(2131711614);
          localahyq.j = alpo.a(2131711610);
          localahyq.l = ChnToSpell.a(localahyq.j, 1);
          localahyq.k = ChnToSpell.a(localahyq.j, 2);
          if ((!bcde.a(localahyq.j, paramString)) && (!bcde.a(localahyq.k, paramString)))
          {
            bool1 = bool2;
            if (!bcde.a(localahyq.l, paramString)) {}
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
  
  public static boolean a(String paramString, ahyq paramahyq)
  {
    if (bcde.a(paramString, "all")) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = bcde.c(paramahyq);
      str2 = bcde.d(paramahyq);
      paramahyq = bcde.e(paramahyq);
    } while ((bcde.a(str1, paramString)) || (bcde.a(str2, paramString)) || (bcde.a(paramahyq, paramString)));
    return false;
  }
  
  private static boolean b(ahyq paramahyq, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ahyq localahyq = new ahyq();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramahyq != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramahyq.jdField_a_of_type_JavaLangString))
        {
          localahyq.b = alpo.a(2131711606);
          localahyq.j = alpo.a(2131711609);
          localahyq.l = ChnToSpell.a(localahyq.j, 1);
          localahyq.k = ChnToSpell.a(localahyq.j, 2);
          if ((!bcde.a(localahyq.j, paramString)) && (!bcde.a(localahyq.k, paramString)))
          {
            bool1 = bool2;
            if (!bcde.a(localahyq.l, paramString)) {}
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
  
  private static boolean c(ahyq paramahyq, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ahyq();
    boolean bool1 = bool2;
    if (paramahyq != null)
    {
      bool1 = bool2;
      if (paramahyq.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = alpo.a(2131711607);
        paramTroopInfo.j = alpo.a(2131711611);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!bcde.a(paramTroopInfo.j, paramString)) && (!bcde.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!bcde.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842097);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bcdm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131694625);
        if (this.jdField_a_of_type_Bcdm.jdField_a_of_type_Bcdb != null) {
          this.jdField_a_of_type_Bcdm.jdField_a_of_type_Bcdb.a();
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
    paramView.setText(2131692680);
    if (this.jdField_a_of_type_Bcdm.b) {
      this.jdField_a_of_type_Bcdm.notifyDataSetChanged();
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_Bcdm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bcdm.jdField_a_of_type_Bcdb.a(this.jdField_a_of_type_Bcdm.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bcdm.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, alpo.a(2131711608), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdp
 * JD-Core Version:    0.7.0.1
 */