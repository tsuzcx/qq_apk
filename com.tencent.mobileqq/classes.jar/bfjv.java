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

public class bfjv
  implements bfjr
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  bfjs jdField_a_of_type_Bfjs;
  boolean jdField_a_of_type_Boolean;
  
  public bfjv(bfjs parambfjs)
  {
    this.jdField_a_of_type_Bfjs = parambfjs;
    a();
  }
  
  public static ajtt a()
  {
    ajtt localajtt = new ajtt();
    localajtt.jdField_a_of_type_JavaLangString = "0";
    localajtt.b = anni.a(2131710002);
    localajtt.j = anni.a(2131710005);
    localajtt.g = anni.a(2131710003);
    localajtt.l = ChnToSpell.a(localajtt.j, 1);
    localajtt.k = ChnToSpell.a(localajtt.j, 2);
    return localajtt;
  }
  
  public static ArrayList<ajtt> a(String paramString, List<ajtt> paramList, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    paramQQAppInterface = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajtt localajtt = (ajtt)paramList.next();
      if ((bfjk.a(localajtt.j, paramString)) || (bfjk.a(localajtt.k, paramString)) || (bfjk.a(localajtt.l, paramString)))
      {
        localajtt.v = localajtt.j;
        localajtt.w = localajtt.l;
        localajtt.x = localajtt.k;
        paramQQAppInterface.add(localajtt);
      }
      else if ((bfjk.a(localajtt.m, paramString)) || (bfjk.a(localajtt.n, paramString)) || (bfjk.a(localajtt.o, paramString)))
      {
        localajtt.v = localajtt.m;
        localajtt.w = localajtt.o;
        localajtt.x = localajtt.n;
        paramQQAppInterface.add(localajtt);
      }
      else if ((bfjk.a(localajtt.g, paramString)) || (bfjk.a(localajtt.h, paramString)) || (bfjk.a(localajtt.i, paramString)))
      {
        localajtt.v = localajtt.g;
        localajtt.w = localajtt.i;
        localajtt.x = localajtt.h;
        paramQQAppInterface.add(localajtt);
      }
      else
      {
        String str1;
        String str2;
        String str3;
        if (bfjk.a(localajtt.jdField_a_of_type_JavaLangString, paramString))
        {
          str1 = bfjk.c(localajtt);
          str2 = bfjk.d(localajtt);
          str3 = bfjk.e(localajtt);
          localajtt.v = str1;
          localajtt.w = str3;
          localajtt.x = str2;
          paramQQAppInterface.add(localajtt);
        }
        else if (a(localajtt, paramString, paramTroopInfo))
        {
          str1 = bfjk.c(localajtt);
          str2 = bfjk.d(localajtt);
          str3 = bfjk.e(localajtt);
          localajtt.v = str1;
          localajtt.w = str3;
          localajtt.x = str2;
          paramQQAppInterface.add(localajtt);
        }
        else if (b(localajtt, paramString, paramTroopInfo))
        {
          str1 = bfjk.c(localajtt);
          str2 = bfjk.d(localajtt);
          str3 = bfjk.e(localajtt);
          localajtt.v = str1;
          localajtt.w = str3;
          localajtt.x = str2;
          paramQQAppInterface.add(localajtt);
        }
        else if (c(localajtt, paramString, paramTroopInfo))
        {
          str1 = bfjk.c(localajtt);
          str2 = bfjk.d(localajtt);
          str3 = bfjk.e(localajtt);
          localajtt.v = str1;
          localajtt.w = str3;
          localajtt.x = str2;
          paramQQAppInterface.add(localajtt);
        }
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<ajtt> a(QQAppInterface paramQQAppInterface, List<ajtt> paramList, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramList;
    }
    paramQQAppInterface = (bftx)paramQQAppInterface.getManager(203);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ajtt localajtt = (ajtt)paramList.next();
      if (!paramQQAppInterface.b(localajtt.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localajtt);
      }
    }
    return localArrayList;
  }
  
  private static boolean a(ajtt paramajtt, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajtt localajtt = new ajtt();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajtt != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopOwner(paramajtt.jdField_a_of_type_JavaLangString))
        {
          localajtt.b = anni.a(2131710004);
          localajtt.j = anni.a(2131710000);
          localajtt.l = ChnToSpell.a(localajtt.j, 1);
          localajtt.k = ChnToSpell.a(localajtt.j, 2);
          if ((!bfjk.a(localajtt.j, paramString)) && (!bfjk.a(localajtt.k, paramString)))
          {
            bool1 = bool2;
            if (!bfjk.a(localajtt.l, paramString)) {}
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
  
  public static boolean a(String paramString, ajtt paramajtt)
  {
    if ("all".equalsIgnoreCase(paramString)) {}
    String str1;
    String str2;
    do
    {
      return true;
      str1 = bfjk.c(paramajtt);
      str2 = bfjk.d(paramajtt);
      paramajtt = bfjk.e(paramajtt);
    } while ((bfjk.a(str1, paramString)) || (bfjk.a(str2, paramString)) || (bfjk.a(paramajtt, paramString)));
    return false;
  }
  
  private static boolean b(ajtt paramajtt, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    ajtt localajtt = new ajtt();
    boolean bool1 = bool2;
    if (paramTroopInfo != null)
    {
      bool1 = bool2;
      if (paramajtt != null)
      {
        bool1 = bool2;
        if (paramTroopInfo.isTroopAdmin(paramajtt.jdField_a_of_type_JavaLangString))
        {
          localajtt.b = anni.a(2131709996);
          localajtt.j = anni.a(2131709999);
          localajtt.l = ChnToSpell.a(localajtt.j, 1);
          localajtt.k = ChnToSpell.a(localajtt.j, 2);
          if ((!bfjk.a(localajtt.j, paramString)) && (!bfjk.a(localajtt.k, paramString)))
          {
            bool1 = bool2;
            if (!bfjk.a(localajtt.l, paramString)) {}
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
  
  private static boolean c(ajtt paramajtt, String paramString, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    paramTroopInfo = new ajtt();
    boolean bool1 = bool2;
    if (paramajtt != null)
    {
      bool1 = bool2;
      if (paramajtt.jdField_a_of_type_Boolean)
      {
        paramTroopInfo.b = anni.a(2131709997);
        paramTroopInfo.j = anni.a(2131710001);
        paramTroopInfo.l = ChnToSpell.a(paramTroopInfo.j, 1);
        paramTroopInfo.k = ChnToSpell.a(paramTroopInfo.j, 2);
        if ((!bfjk.a(paramTroopInfo.j, paramString)) && (!bfjk.a(paramTroopInfo.k, paramString)))
        {
          bool1 = bool2;
          if (!bfjk.a(paramTroopInfo.l, paramString)) {}
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
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842420);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Bfjs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localBitmap);
  }
  
  public void a(View paramView)
  {
    boolean bool = false;
    if ((paramView instanceof TextView))
    {
      paramView = (TextView)paramView;
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setText(2131693880);
        if (this.jdField_a_of_type_Bfjs.jdField_a_of_type_Bfjh != null) {
          this.jdField_a_of_type_Bfjs.jdField_a_of_type_Bfjh.a();
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
    paramView.setText(2131692257);
    if (this.jdField_a_of_type_Bfjs.b) {
      this.jdField_a_of_type_Bfjs.notifyDataSetChanged();
    }
    for (;;)
    {
      bcst.b(this.jdField_a_of_type_Bfjs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A48F", "0X800A48F", 0, 0, "", "", "", "");
      break;
      this.jdField_a_of_type_Bfjs.jdField_a_of_type_Bfjh.a(this.jdField_a_of_type_Bfjs.jdField_a_of_type_JavaLangString, true);
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
    return this.jdField_a_of_type_Bfjs.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 20;
  }
  
  void b()
  {
    QQToast.a(BaseApplicationImpl.context, 0, anni.a(2131709998), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjv
 * JD-Core Version:    0.7.0.1
 */