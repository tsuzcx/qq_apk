import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.view.ProfileTemplateException;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ayyq
{
  public static void a(aymg paramaymg)
  {
    long l5 = aymn.jdField_a_of_type_Long;
    long l4 = 0L;
    Object localObject2 = null;
    long l2 = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate curStyleId=%s", new Object[] { Long.valueOf(l2) }));
    }
    Object localObject1;
    long l3;
    long l1;
    if (bbyp.b())
    {
      localObject1 = localObject2;
      l3 = l4;
      l1 = l5;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTemplateCheckUtils", 2, "checkCurrentUseTemplate simple mode");
        l1 = l5;
        l3 = l4;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate useStyleId=%s useTemplateVersion=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3) }));
      }
      paramaymg.jdField_a_of_type_Long = l1;
      paramaymg.b = l3;
      paramaymg.jdField_a_of_type_Aymn = ((aymn)localObject1);
      return;
      if ((l2 == aymn.b) || (l2 == aymn.c) || (l2 == aymn.d))
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (a(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == aymn.e)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (b(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == aymn.f)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (c(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == aymn.g)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (d(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == aymn.h)
      {
        l1 = aymn.jdField_a_of_type_Long;
        localObject1 = localObject2;
        l3 = l4;
      }
      else if ((l2 == aymn.i) || (l2 == aymn.j))
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (e(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else if (l2 == aymn.k)
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (f(paramaymg))
        {
          localObject1 = paramaymg.jdField_a_of_type_Aymn;
          l1 = l2;
          l3 = l4;
        }
      }
      else
      {
        localObject1 = localObject2;
        l3 = l4;
        l1 = l5;
        if (aymn.a(l2))
        {
          localObject1 = localObject2;
          l3 = l4;
          l1 = l5;
          if (ayyr.a.a(paramaymg))
          {
            l3 = aymn.a(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard);
            l1 = l2;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private static void a(aymg paramaymg, HashMap<String, String> paramHashMap)
  {
    paramaymg = paramaymg.jdField_a_of_type_Aymn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((paramaymg == null) || (paramaymg.size() <= 0)) {
      throw new ProfileTemplateException("template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label372:
    label375:
    for (;;)
    {
      Object localObject1;
      String str1;
      Object localObject2;
      int i;
      String str2;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str1 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramaymg.get(str1);
        String[] arrayOfString = ((String)localObject1).split(",");
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label372;
        }
        str2 = arrayOfString[i];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
          if ((str2.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label375;
        }
        throw new ProfileTemplateException("template attr " + str1 + " type is not " + (String)localObject1);
        if ((str2.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          i = 1;
        }
        else if ((str2.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          i = 1;
        }
        else
        {
          i += 1;
          break;
          return;
          i = 0;
        }
      }
    }
  }
  
  private static boolean a(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkGameTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("gameHeadInfoBackground", "color");
    localHashMap.put("gameNickNameColor", "color");
    localHashMap.put("gameAddressColor", "color");
    localHashMap.put("gameSignColor", "color");
    localHashMap.put("gamePlayNowColor", "color");
    localHashMap.put("gameMoreColor", "color");
    localHashMap.put("gameMoreGameDrawableRight", "drawable");
    localHashMap.put("gamePlayTitleColor", "color");
    localHashMap.put("gameIconBorder", "drawable");
    return a(paramaymg, localHashMap);
  }
  
  private static boolean a(aymg paramaymg, HashMap<String, String> paramHashMap)
  {
    try
    {
      a(paramaymg, paramHashMap);
      bool = true;
    }
    catch (Exception paramaymg)
    {
      for (;;)
      {
        QLog.e("ProfileTemplateCheckUtils", 1, "checkShopTemplateValid fail.", paramaymg);
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkTemplateValidWithResult valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private static boolean b(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkPhotoTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    return a(paramaymg, localHashMap);
  }
  
  private static boolean c(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkTagTemplateValid");
    }
    return a(paramaymg, new HashMap());
  }
  
  private static boolean d(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkSimpleTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    return a(paramaymg, localHashMap);
  }
  
  private static boolean e(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkWZRYTemplateValid");
    }
    return a(paramaymg, new HashMap());
  }
  
  private static boolean f(aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkQVipV5TemplateValid");
    }
    return a(paramaymg, new HashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyq
 * JD-Core Version:    0.7.0.1
 */