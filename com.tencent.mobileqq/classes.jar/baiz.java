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

public class baiz
{
  public static void a(azxr paramazxr)
  {
    long l3 = azxy.jdField_a_of_type_Long;
    long l4 = azxy.a(paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard);
    Object localObject2 = null;
    long l2 = paramazxr.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate curStyleId=%s", new Object[] { Long.valueOf(l2) }));
    }
    Object localObject1;
    long l1;
    if (bdgb.b())
    {
      localObject1 = localObject2;
      l1 = l3;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileTemplateCheckUtils", 2, "checkCurrentUseTemplate simple mode");
        l1 = l3;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkCurrentUseTemplate useStyleId=%s useTemplateVersion=%s", new Object[] { Long.valueOf(l1), Long.valueOf(l4) }));
      }
      paramazxr.jdField_a_of_type_Long = l1;
      paramazxr.b = l4;
      paramazxr.jdField_a_of_type_Azxy = ((azxy)localObject1);
      return;
      if ((l2 == azxy.b) || (l2 == azxy.c) || (l2 == azxy.d))
      {
        localObject1 = localObject2;
        l1 = l3;
        if (a(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else if (l2 == azxy.e)
      {
        localObject1 = localObject2;
        l1 = l3;
        if (b(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else if (l2 == azxy.f)
      {
        localObject1 = localObject2;
        l1 = l3;
        if (c(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else if (l2 == azxy.g)
      {
        localObject1 = localObject2;
        l1 = l3;
        if (d(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else if (l2 == azxy.h)
      {
        l1 = azxy.jdField_a_of_type_Long;
        localObject1 = localObject2;
      }
      else if ((l2 == azxy.i) || (l2 == azxy.j))
      {
        localObject1 = localObject2;
        l1 = l3;
        if (e(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else if (l2 == azxy.k)
      {
        localObject1 = localObject2;
        l1 = l3;
        if (f(paramazxr))
        {
          localObject1 = paramazxr.jdField_a_of_type_Azxy;
          l1 = l2;
        }
      }
      else
      {
        localObject1 = localObject2;
        l1 = l3;
        if (azxy.a(l2))
        {
          localObject1 = localObject2;
          l1 = l3;
          if (baja.a.a(paramazxr))
          {
            l1 = l2;
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private static void a(azxr paramazxr, HashMap<String, String> paramHashMap)
  {
    paramazxr = paramazxr.jdField_a_of_type_Azxy.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if ((paramazxr == null) || (paramazxr.size() <= 0)) {
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
        localObject2 = paramazxr.get(str1);
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
  
  private static boolean a(azxr paramazxr)
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
    return a(paramazxr, localHashMap);
  }
  
  private static boolean a(azxr paramazxr, HashMap<String, String> paramHashMap)
  {
    try
    {
      a(paramazxr, paramHashMap);
      bool = true;
    }
    catch (Exception paramazxr)
    {
      for (;;)
      {
        QLog.e("ProfileTemplateCheckUtils", 1, "checkShopTemplateValid fail.", paramazxr);
        boolean bool = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, String.format("checkTemplateValidWithResult valid=%s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  private static boolean b(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkPhotoTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    return a(paramazxr, localHashMap);
  }
  
  private static boolean c(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkTagTemplateValid");
    }
    return a(paramazxr, new HashMap());
  }
  
  private static boolean d(azxr paramazxr)
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
    return a(paramazxr, localHashMap);
  }
  
  private static boolean e(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkWZRYTemplateValid");
    }
    return a(paramazxr, new HashMap());
  }
  
  private static boolean f(azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileTemplateCheckUtils", 2, "checkQVipV5TemplateValid");
    }
    return a(paramazxr, new HashMap());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiz
 * JD-Core Version:    0.7.0.1
 */