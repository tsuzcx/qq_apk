import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class bgyw
{
  public static bgyy a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = anhk.bZ + paramInt + File.separator + "config.json";
    paramQQAppInterface = VasQuickUpdateManager.getFileFromLocal(paramQQAppInterface, 1000L, "signature.item." + paramInt + ".json", (String)localObject, true, null);
    try
    {
      paramQQAppInterface = bgmg.a(paramQQAppInterface, -1);
      if (paramQQAppInterface == null)
      {
        QLog.e("SignatureTemplateConfig", 1, "read config fail result = null");
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      QLog.e("SignatureTemplateConfig", 1, "read config fail", paramQQAppInterface);
      return null;
    }
    localObject = new bgyy(Integer.toString(paramInt));
    a(paramQQAppInterface, (bgyy)localObject);
    return localObject;
  }
  
  private static Object a(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    if (paramBoolean) {
      return paramObject1;
    }
    return paramObject2;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(anhk.bZ);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void a(bgyy parambgyy, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      a(parambgyy, paramJSONArray.getJSONObject(i));
      i += 1;
    }
  }
  
  private static void a(bgyy parambgyy, JSONObject paramJSONObject)
  {
    int i;
    int j;
    if (paramJSONObject.has("aio_rows"))
    {
      i = paramJSONObject.getInt("aio_rows");
      if ((i == 0) || ((i > 1) && (i < 6)))
      {
        bgyz[] arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label356;
        }
        j = i;
        label43:
        arrayOfbgyz[j].jdField_a_of_type_Int = i;
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label363;
        }
        j = i;
        label63:
        arrayOfbgyz[j].jdField_a_of_type_JavaLangString = ((String)a(paramJSONObject.has("pngZip"), paramJSONObject.getString("pngZip"), ""));
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label370;
        }
        j = i;
        label102:
        arrayOfbgyz[j].jdField_a_of_type_Float = ((Float)a(paramJSONObject.has("posX"), paramJSONObject.getString("posX"), Integer.valueOf(0))).floatValue();
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label377;
        }
        j = i;
        label146:
        arrayOfbgyz[j].jdField_b_of_type_Float = ((Float)a(paramJSONObject.has("posY"), paramJSONObject.getString("posY"), Integer.valueOf(0))).floatValue();
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label384;
        }
        j = i;
        label190:
        arrayOfbgyz[j].jdField_c_of_type_Float = ((Float)a(paramJSONObject.has("width"), paramJSONObject.getString("width"), Integer.valueOf(0))).floatValue();
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label391;
        }
        j = i;
        label234:
        arrayOfbgyz[j].d = ((Float)a(paramJSONObject.has("height"), paramJSONObject.getString("height"), Integer.valueOf(0))).floatValue();
        arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label398;
        }
        j = i;
        label278:
        arrayOfbgyz[j].jdField_b_of_type_Int = ((Integer)a(paramJSONObject.has("repeatTimes"), paramJSONObject.getString("repeatTimes"), Integer.valueOf(0))).intValue();
        parambgyy = parambgyy.jdField_a_of_type_ArrayOfBgyz;
        if (i != 0) {
          break label405;
        }
      }
    }
    for (;;)
    {
      parambgyy[i].jdField_c_of_type_Int = ((Integer)a(paramJSONObject.has("interval"), paramJSONObject.getString("interval"), Integer.valueOf(0))).intValue();
      return;
      i = -1;
      break;
      label356:
      j = i - 1;
      break label43;
      label363:
      j = i - 1;
      break label63;
      label370:
      j = i - 1;
      break label102;
      label377:
      j = i - 1;
      break label146;
      label384:
      j = i - 1;
      break label190;
      label391:
      j = i - 1;
      break label234;
      label398:
      j = i - 1;
      break label278;
      label405:
      i -= 1;
    }
  }
  
  public static void a(String paramString, bgyy parambgyy)
  {
    Object localObject;
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.optJSONArray("data");
      if ((localObject == null) || (((JSONArray)localObject).length() != 1)) {
        break label888;
      }
      localObject = ((JSONArray)localObject).getJSONObject(0);
      if (((JSONObject)localObject).optInt("platId") == 1)
      {
        parambgyy.a();
        return;
      }
      parambgyy.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("qqVer", "0.0.0");
      if (AppSetting.a(parambgyy.jdField_f_of_type_JavaLangString) < 0)
      {
        parambgyy.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SignatureTemplateConfig", 1, "getSignatureTemplateInfoFromFile error: " + paramString.getMessage());
      return;
    }
    parambgyy.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", anni.a(2131712889));
    parambgyy.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
    parambgyy.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeType", 1);
    parambgyy.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("actUrl", null);
    parambgyy.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("newOrHot", 0);
    parambgyy.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("platId");
    parambgyy.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("fontColor", "");
    parambgyy.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("signType", 0);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Color.parseColor(parambgyy.jdField_e_of_type_JavaLangString);
        parambgyy.n = ((JSONObject)localObject).optString("defText", "");
        parambgyy.o = ((JSONObject)localObject).optString("defTextColor", "");
      }
      catch (Exception localException2)
      {
        try
        {
          Color.parseColor(parambgyy.o);
          parambgyy.p = ((JSONObject)localObject).optString("timeAndLocation", "");
        }
        catch (Exception localException2)
        {
          try
          {
            Color.parseColor(parambgyy.p);
            parambgyy.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("isLimited", 1);
            parambgyy.q = ((JSONObject)localObject).optString("startTime");
            parambgyy.r = ((JSONObject)localObject).optString("endTime");
            parambgyy.s = ((JSONObject)localObject).optString("dot9png");
            parambgyy.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("cover");
            parambgyy.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("aio_2");
            parambgyy.h = ((JSONObject)localObject).optString("aio_3");
            parambgyy.i = ((JSONObject)localObject).optString("aio_4");
            parambgyy.j = ((JSONObject)localObject).optString("icon");
            parambgyy.k = ((JSONObject)localObject).optString("view");
            parambgyy.l = ((JSONObject)localObject).optString("action_off");
            parambgyy.m = ((JSONObject)localObject).optString("action_on");
            parambgyy.t = ((JSONObject)localObject).optString("backgroundColor");
            parambgyy.u = ((JSONObject)localObject).optString("shadowColor");
            parambgyy.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("materialVersion");
            if (paramString.has("dynamicItem"))
            {
              localObject = paramString.getJSONArray("dynamicItem");
              j = 0;
              if (j < ((JSONArray)localObject).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
                i = localJSONObject.optInt("aio_rows", -1);
                if ((i != 0) && ((i <= 1) || (i >= 6))) {
                  break label889;
                }
                bgyz[] arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label896;
                }
                k = i;
                arrayOfbgyz[k].jdField_a_of_type_Int = i;
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label904;
                }
                k = i;
                arrayOfbgyz[k].jdField_a_of_type_JavaLangString = localJSONObject.optString("pngZip");
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label912;
                }
                k = i;
                arrayOfbgyz[k].jdField_a_of_type_Float = ((float)localJSONObject.optDouble("posX", 0.0D));
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label920;
                }
                k = i;
                arrayOfbgyz[k].jdField_b_of_type_Float = ((float)localJSONObject.optDouble("posY", 0.0D));
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label928;
                }
                k = i;
                arrayOfbgyz[k].jdField_c_of_type_Float = ((float)localJSONObject.optDouble("width", 0.0D));
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label936;
                }
                k = i;
                arrayOfbgyz[k].d = ((float)localJSONObject.optDouble("height", 0.0D));
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label944;
                }
                k = i;
                arrayOfbgyz[k].jdField_b_of_type_Int = localJSONObject.optInt("repeatTimes", 0);
                arrayOfbgyz = parambgyy.jdField_a_of_type_ArrayOfBgyz;
                if (i != 0) {
                  break label952;
                }
                arrayOfbgyz[i].jdField_c_of_type_Int = localJSONObject.optInt("interval", 0);
                break label889;
                localException1 = localException1;
                parambgyy.jdField_e_of_type_JavaLangString = "";
                continue;
                localException2 = localException2;
                parambgyy.o = "";
              }
            }
          }
          catch (Exception localException3)
          {
            parambgyy.p = "";
            continue;
            paramString = paramString.optJSONArray("imgItem");
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramString = paramString.getJSONObject(0);
              parambgyy.getClass();
              localObject = new bgza(parambgyy);
              ((bgza)localObject).jdField_b_of_type_JavaLangString = paramString.optString("content");
              ((bgza)localObject).jdField_a_of_type_JavaLangString = paramString.optString("img");
              ((bgza)localObject).jdField_a_of_type_Int = paramString.optInt("imgWidth");
              ((bgza)localObject).jdField_b_of_type_Int = paramString.optInt("imgHeight");
              ((bgza)localObject).jdField_c_of_type_JavaLangString = paramString.optString("imgCover");
              parambgyy.jdField_a_of_type_Bgza = ((bgza)localObject);
            }
          }
        }
      }
      label888:
      return;
      label889:
      j += 1;
      continue;
      label896:
      int k = i - 1;
      continue;
      label904:
      k = i - 1;
      continue;
      label912:
      k = i - 1;
      continue;
      label920:
      k = i - 1;
      continue;
      label928:
      k = i - 1;
      continue;
      label936:
      k = i - 1;
      continue;
      label944:
      k = i - 1;
      continue;
      label952:
      i -= 1;
    }
  }
  
  private static void a(Map<Integer, bgyx> paramMap, JSONObject paramJSONObject, Iterator paramIterator)
  {
    paramJSONObject = paramJSONObject.getJSONArray((String)paramIterator.next());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      paramIterator = new bgyy(((JSONObject)localObject).getString("id"));
      b(paramIterator, ((JSONObject)localObject).getJSONArray("data"));
      if (((JSONObject)localObject).has("dynamicItem")) {
        a(paramIterator, ((JSONObject)localObject).getJSONArray("dynamicItem"));
      }
      localObject = ((JSONObject)localObject).optJSONArray("imgItem");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        paramIterator.getClass();
        bgza localbgza = new bgza(paramIterator);
        localbgza.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("content");
        localbgza.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("img");
        localbgza.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("imgWidth");
        localbgza.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("imgHeight");
        localbgza.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("imgCover");
        paramIterator.jdField_a_of_type_Bgza = localbgza;
      }
      localObject = (bgyx)paramMap.get(Integer.valueOf(paramIterator.jdField_b_of_type_Int));
      if (localObject != null) {
        ((bgyx)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramIterator);
      }
      i += 1;
    }
  }
  
  public static bgyx[] a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    try
    {
      localObject1 = new LinkedHashMap();
      paramQQAppInterface = new File(SignatureManager.jdField_b_of_type_JavaLangString);
      try
      {
        paramQQAppInterface = bgmg.a(paramQQAppInterface, -1);
        if (paramQQAppInterface != null) {
          break label119;
        }
      }
      catch (OutOfMemoryError paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("SignatureTemplateConfig", 2, "read config fail", paramQQAppInterface);
        return null;
      }
      return null;
    }
    catch (Exception paramQQAppInterface)
    {
      localObject1 = new File(SignatureManager.jdField_b_of_type_JavaLangString);
      if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
        ((File)localObject1).delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SignatureTemplateConfig", 2, "parse sig cfg fail " + paramQQAppInterface.getMessage());
      }
      paramQQAppInterface = null;
    }
    for (;;)
    {
      return paramQQAppInterface;
      label119:
      paramQQAppInterface = new JSONObject((String)paramQQAppInterface.subSequence(paramQQAppInterface.indexOf("{"), paramQQAppInterface.length())).getJSONObject("data");
      Object localObject2 = paramQQAppInterface.getJSONArray("itemType");
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
        bgyx localbgyx = new bgyx();
        localbgyx.jdField_a_of_type_Int = localJSONObject.getInt("sigId");
        localbgyx.jdField_a_of_type_JavaLangString = localJSONObject.getString("sigType");
        ((Map)localObject1).put(Integer.valueOf(localbgyx.jdField_a_of_type_Int), localbgyx);
        i += 1;
      }
      paramQQAppInterface = paramQQAppInterface.getJSONObject("items");
      localObject2 = paramQQAppInterface.keys();
      while (((Iterator)localObject2).hasNext()) {
        a((Map)localObject1, paramQQAppInterface, (Iterator)localObject2);
      }
      paramQQAppInterface = ((Map)localObject1).entrySet().iterator();
      while (paramQQAppInterface.hasNext()) {
        if (((bgyx)((Map.Entry)paramQQAppInterface.next()).getValue()).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramQQAppInterface.remove();
        }
      }
      paramQQAppInterface = new bgyx[((Map)localObject1).values().size()];
      ((Map)localObject1).values().toArray(paramQQAppInterface);
    }
  }
  
  private static void b(bgyy parambgyy, JSONArray paramJSONArray)
  {
    int i = 0;
    if (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      if (localJSONObject.getInt("platId") == 1) {}
      for (;;)
      {
        i += 1;
        break;
        parambgyy.jdField_f_of_type_JavaLangString = localJSONObject.getString("qqVer");
        if (AppSetting.a(parambgyy.jdField_f_of_type_JavaLangString) >= 0)
        {
          parambgyy.jdField_b_of_type_JavaLangString = ((String)a(localJSONObject.has("name"), localJSONObject.getString("name"), anni.a(2131712870)));
          parambgyy.jdField_b_of_type_Int = ((Integer)a(localJSONObject.has("type"), Integer.valueOf(localJSONObject.getInt("type")), Integer.valueOf(-1))).intValue();
          parambgyy.jdField_a_of_type_Int = ((Integer)a(localJSONObject.has("feeType"), Integer.valueOf(localJSONObject.getInt("feeType")), Integer.valueOf(1))).intValue();
          parambgyy.jdField_c_of_type_JavaLangString = ((String)a(localJSONObject.has("actUrl"), localJSONObject.getString("actUrl"), null));
          parambgyy.jdField_c_of_type_Int = ((Integer)a(localJSONObject.has("newOrHot"), localJSONObject.getString("newOrHot"), Integer.valueOf(0))).intValue();
          parambgyy.jdField_d_of_type_Int = localJSONObject.getInt("platId");
          parambgyy.jdField_e_of_type_JavaLangString = ((String)a(localJSONObject.has("fontColor"), localJSONObject.getString("fontColor"), ""));
          try
          {
            Color.parseColor(parambgyy.jdField_e_of_type_JavaLangString);
            parambgyy.n = ((String)a(localJSONObject.has("defText"), localJSONObject.getString("defText"), ""));
            parambgyy.o = ((String)a(localJSONObject.has("defTextColor"), localJSONObject.getString("defTextColor"), ""));
          }
          catch (Exception localException2)
          {
            try
            {
              Color.parseColor(parambgyy.o);
              parambgyy.p = ((String)a(localJSONObject.has("timeAndLocation"), localJSONObject.getString("timeAndLocation"), ""));
            }
            catch (Exception localException2)
            {
              try
              {
                for (;;)
                {
                  Color.parseColor(parambgyy.p);
                  parambgyy.jdField_e_of_type_Int = ((Integer)a(localJSONObject.has("isLimited"), localJSONObject.getString("isLimited"), Integer.valueOf(1))).intValue();
                  parambgyy.q = ((String)a(localJSONObject.has("startTime"), localJSONObject.getString("startTime"), ""));
                  parambgyy.r = ((String)a(localJSONObject.has("endTime"), localJSONObject.getString("endTime"), ""));
                  parambgyy.s = ((String)a(localJSONObject.has("dot9png"), localJSONObject.getString("dot9png"), ""));
                  parambgyy.t = ((String)a(localJSONObject.has("backgroundColor"), localJSONObject.getString("backgroundColor"), ""));
                  if (localJSONObject.has("cover")) {
                    parambgyy.jdField_d_of_type_JavaLangString = localJSONObject.getString("cover");
                  }
                  if (localJSONObject.has("aio_2")) {
                    parambgyy.jdField_g_of_type_JavaLangString = localJSONObject.getString("aio_2");
                  }
                  if (localJSONObject.has("aio_3")) {
                    parambgyy.h = localJSONObject.getString("aio_3");
                  }
                  if (localJSONObject.has("aio_4")) {
                    parambgyy.i = localJSONObject.getString("aio_4");
                  }
                  if (localJSONObject.has("icon")) {
                    parambgyy.j = localJSONObject.getString("icon");
                  }
                  if (localJSONObject.has("view")) {
                    parambgyy.k = localJSONObject.getString("view");
                  }
                  if (localJSONObject.has("action_off")) {
                    parambgyy.l = localJSONObject.getString("action_off");
                  }
                  if (!localJSONObject.has("action_on")) {
                    break;
                  }
                  parambgyy.m = localJSONObject.getString("action_on");
                  break;
                  localException1 = localException1;
                  parambgyy.jdField_e_of_type_JavaLangString = "";
                }
                localException2 = localException2;
                parambgyy.o = "";
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  parambgyy.p = "";
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyw
 * JD-Core Version:    0.7.0.1
 */