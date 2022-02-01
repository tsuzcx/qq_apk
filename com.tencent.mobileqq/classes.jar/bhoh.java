import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.utils.FileUtils;
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

public class bhoh
{
  public static bhoj a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT + paramInt + File.separator + "config.json";
    paramQQAppInterface = VasQuickUpdateManager.getFileFromLocal(paramQQAppInterface, 1000L, "signature.item." + paramInt + ".json", (String)localObject, true, null);
    try
    {
      paramQQAppInterface = FileUtils.readFileToStringEx(paramQQAppInterface, -1);
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
    localObject = new bhoj(Integer.toString(paramInt));
    a(paramQQAppInterface, (bhoj)localObject);
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
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.SDCARD_SIGNATURE_TEMPLATE_ROOT);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void a(bhoj parambhoj, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      a(parambhoj, paramJSONArray.getJSONObject(i));
      i += 1;
    }
  }
  
  private static void a(bhoj parambhoj, JSONObject paramJSONObject)
  {
    int i;
    int j;
    if (paramJSONObject.has("aio_rows"))
    {
      i = paramJSONObject.getInt("aio_rows");
      if ((i == 0) || ((i > 1) && (i < 6)))
      {
        bhok[] arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label356;
        }
        j = i;
        label43:
        arrayOfbhok[j].jdField_a_of_type_Int = i;
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label363;
        }
        j = i;
        label63:
        arrayOfbhok[j].jdField_a_of_type_JavaLangString = ((String)a(paramJSONObject.has("pngZip"), paramJSONObject.getString("pngZip"), ""));
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label370;
        }
        j = i;
        label102:
        arrayOfbhok[j].jdField_a_of_type_Float = ((Float)a(paramJSONObject.has("posX"), paramJSONObject.getString("posX"), Integer.valueOf(0))).floatValue();
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label377;
        }
        j = i;
        label146:
        arrayOfbhok[j].jdField_b_of_type_Float = ((Float)a(paramJSONObject.has("posY"), paramJSONObject.getString("posY"), Integer.valueOf(0))).floatValue();
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label384;
        }
        j = i;
        label190:
        arrayOfbhok[j].jdField_c_of_type_Float = ((Float)a(paramJSONObject.has("width"), paramJSONObject.getString("width"), Integer.valueOf(0))).floatValue();
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label391;
        }
        j = i;
        label234:
        arrayOfbhok[j].d = ((Float)a(paramJSONObject.has("height"), paramJSONObject.getString("height"), Integer.valueOf(0))).floatValue();
        arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label398;
        }
        j = i;
        label278:
        arrayOfbhok[j].jdField_b_of_type_Int = ((Integer)a(paramJSONObject.has("repeatTimes"), paramJSONObject.getString("repeatTimes"), Integer.valueOf(0))).intValue();
        parambhoj = parambhoj.jdField_a_of_type_ArrayOfBhok;
        if (i != 0) {
          break label405;
        }
      }
    }
    for (;;)
    {
      parambhoj[i].jdField_c_of_type_Int = ((Integer)a(paramJSONObject.has("interval"), paramJSONObject.getString("interval"), Integer.valueOf(0))).intValue();
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
  
  public static void a(String paramString, bhoj parambhoj)
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
        parambhoj.a();
        return;
      }
      parambhoj.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("qqVer", "0.0.0");
      if (AppSetting.a(parambhoj.jdField_f_of_type_JavaLangString) < 0)
      {
        parambhoj.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SignatureTemplateConfig", 1, "getSignatureTemplateInfoFromFile error: " + paramString.getMessage());
      return;
    }
    parambhoj.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", anvx.a(2131713577));
    parambhoj.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
    parambhoj.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeType", 1);
    parambhoj.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("actUrl", null);
    parambhoj.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("newOrHot", 0);
    parambhoj.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("platId");
    parambhoj.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("fontColor", "");
    parambhoj.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("signType", 0);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Color.parseColor(parambhoj.jdField_e_of_type_JavaLangString);
        parambhoj.n = ((JSONObject)localObject).optString("defText", "");
        parambhoj.o = ((JSONObject)localObject).optString("defTextColor", "");
      }
      catch (Exception localException2)
      {
        try
        {
          Color.parseColor(parambhoj.o);
          parambhoj.p = ((JSONObject)localObject).optString("timeAndLocation", "");
        }
        catch (Exception localException2)
        {
          try
          {
            Color.parseColor(parambhoj.p);
            parambhoj.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("isLimited", 1);
            parambhoj.q = ((JSONObject)localObject).optString("startTime");
            parambhoj.r = ((JSONObject)localObject).optString("endTime");
            parambhoj.s = ((JSONObject)localObject).optString("dot9png");
            parambhoj.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("cover");
            parambhoj.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("aio_2");
            parambhoj.h = ((JSONObject)localObject).optString("aio_3");
            parambhoj.i = ((JSONObject)localObject).optString("aio_4");
            parambhoj.j = ((JSONObject)localObject).optString("icon");
            parambhoj.k = ((JSONObject)localObject).optString("view");
            parambhoj.l = ((JSONObject)localObject).optString("action_off");
            parambhoj.m = ((JSONObject)localObject).optString("action_on");
            parambhoj.t = ((JSONObject)localObject).optString("backgroundColor");
            parambhoj.u = ((JSONObject)localObject).optString("shadowColor");
            parambhoj.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("materialVersion");
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
                bhok[] arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label896;
                }
                k = i;
                arrayOfbhok[k].jdField_a_of_type_Int = i;
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label904;
                }
                k = i;
                arrayOfbhok[k].jdField_a_of_type_JavaLangString = localJSONObject.optString("pngZip");
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label912;
                }
                k = i;
                arrayOfbhok[k].jdField_a_of_type_Float = ((float)localJSONObject.optDouble("posX", 0.0D));
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label920;
                }
                k = i;
                arrayOfbhok[k].jdField_b_of_type_Float = ((float)localJSONObject.optDouble("posY", 0.0D));
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label928;
                }
                k = i;
                arrayOfbhok[k].jdField_c_of_type_Float = ((float)localJSONObject.optDouble("width", 0.0D));
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label936;
                }
                k = i;
                arrayOfbhok[k].d = ((float)localJSONObject.optDouble("height", 0.0D));
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label944;
                }
                k = i;
                arrayOfbhok[k].jdField_b_of_type_Int = localJSONObject.optInt("repeatTimes", 0);
                arrayOfbhok = parambhoj.jdField_a_of_type_ArrayOfBhok;
                if (i != 0) {
                  break label952;
                }
                arrayOfbhok[i].jdField_c_of_type_Int = localJSONObject.optInt("interval", 0);
                break label889;
                localException1 = localException1;
                parambhoj.jdField_e_of_type_JavaLangString = "";
                continue;
                localException2 = localException2;
                parambhoj.o = "";
              }
            }
          }
          catch (Exception localException3)
          {
            parambhoj.p = "";
            continue;
            paramString = paramString.optJSONArray("imgItem");
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramString = paramString.getJSONObject(0);
              parambhoj.getClass();
              localObject = new bhol(parambhoj);
              ((bhol)localObject).jdField_b_of_type_JavaLangString = paramString.optString("content");
              ((bhol)localObject).jdField_a_of_type_JavaLangString = paramString.optString("img");
              ((bhol)localObject).jdField_a_of_type_Int = paramString.optInt("imgWidth");
              ((bhol)localObject).jdField_b_of_type_Int = paramString.optInt("imgHeight");
              ((bhol)localObject).jdField_c_of_type_JavaLangString = paramString.optString("imgCover");
              parambhoj.jdField_a_of_type_Bhol = ((bhol)localObject);
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
  
  private static void a(Map<Integer, bhoi> paramMap, JSONObject paramJSONObject, Iterator paramIterator)
  {
    paramJSONObject = paramJSONObject.getJSONArray((String)paramIterator.next());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      paramIterator = new bhoj(((JSONObject)localObject).getString("id"));
      b(paramIterator, ((JSONObject)localObject).getJSONArray("data"));
      if (((JSONObject)localObject).has("dynamicItem")) {
        a(paramIterator, ((JSONObject)localObject).getJSONArray("dynamicItem"));
      }
      localObject = ((JSONObject)localObject).optJSONArray("imgItem");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        paramIterator.getClass();
        bhol localbhol = new bhol(paramIterator);
        localbhol.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("content");
        localbhol.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("img");
        localbhol.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("imgWidth");
        localbhol.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("imgHeight");
        localbhol.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("imgCover");
        paramIterator.jdField_a_of_type_Bhol = localbhol;
      }
      localObject = (bhoi)paramMap.get(Integer.valueOf(paramIterator.jdField_b_of_type_Int));
      if (localObject != null) {
        ((bhoi)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramIterator);
      }
      i += 1;
    }
  }
  
  public static bhoi[] a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    try
    {
      localObject1 = new LinkedHashMap();
      paramQQAppInterface = new File(SignatureManager.jdField_b_of_type_JavaLangString);
      try
      {
        paramQQAppInterface = FileUtils.readFileToStringEx(paramQQAppInterface, -1);
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
        bhoi localbhoi = new bhoi();
        localbhoi.jdField_a_of_type_Int = localJSONObject.getInt("sigId");
        localbhoi.jdField_a_of_type_JavaLangString = localJSONObject.getString("sigType");
        ((Map)localObject1).put(Integer.valueOf(localbhoi.jdField_a_of_type_Int), localbhoi);
        i += 1;
      }
      paramQQAppInterface = paramQQAppInterface.getJSONObject("items");
      localObject2 = paramQQAppInterface.keys();
      while (((Iterator)localObject2).hasNext()) {
        a((Map)localObject1, paramQQAppInterface, (Iterator)localObject2);
      }
      paramQQAppInterface = ((Map)localObject1).entrySet().iterator();
      while (paramQQAppInterface.hasNext()) {
        if (((bhoi)((Map.Entry)paramQQAppInterface.next()).getValue()).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramQQAppInterface.remove();
        }
      }
      paramQQAppInterface = new bhoi[((Map)localObject1).values().size()];
      ((Map)localObject1).values().toArray(paramQQAppInterface);
    }
  }
  
  private static void b(bhoj parambhoj, JSONArray paramJSONArray)
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
        parambhoj.jdField_f_of_type_JavaLangString = localJSONObject.getString("qqVer");
        if (AppSetting.a(parambhoj.jdField_f_of_type_JavaLangString) >= 0)
        {
          parambhoj.jdField_b_of_type_JavaLangString = ((String)a(localJSONObject.has("name"), localJSONObject.getString("name"), anvx.a(2131713558)));
          parambhoj.jdField_b_of_type_Int = ((Integer)a(localJSONObject.has("type"), Integer.valueOf(localJSONObject.getInt("type")), Integer.valueOf(-1))).intValue();
          parambhoj.jdField_a_of_type_Int = ((Integer)a(localJSONObject.has("feeType"), Integer.valueOf(localJSONObject.getInt("feeType")), Integer.valueOf(1))).intValue();
          parambhoj.jdField_c_of_type_JavaLangString = ((String)a(localJSONObject.has("actUrl"), localJSONObject.getString("actUrl"), null));
          parambhoj.jdField_c_of_type_Int = ((Integer)a(localJSONObject.has("newOrHot"), localJSONObject.getString("newOrHot"), Integer.valueOf(0))).intValue();
          parambhoj.jdField_d_of_type_Int = localJSONObject.getInt("platId");
          parambhoj.jdField_e_of_type_JavaLangString = ((String)a(localJSONObject.has("fontColor"), localJSONObject.getString("fontColor"), ""));
          try
          {
            Color.parseColor(parambhoj.jdField_e_of_type_JavaLangString);
            parambhoj.n = ((String)a(localJSONObject.has("defText"), localJSONObject.getString("defText"), ""));
            parambhoj.o = ((String)a(localJSONObject.has("defTextColor"), localJSONObject.getString("defTextColor"), ""));
          }
          catch (Exception localException2)
          {
            try
            {
              Color.parseColor(parambhoj.o);
              parambhoj.p = ((String)a(localJSONObject.has("timeAndLocation"), localJSONObject.getString("timeAndLocation"), ""));
            }
            catch (Exception localException2)
            {
              try
              {
                for (;;)
                {
                  Color.parseColor(parambhoj.p);
                  parambhoj.jdField_e_of_type_Int = ((Integer)a(localJSONObject.has("isLimited"), localJSONObject.getString("isLimited"), Integer.valueOf(1))).intValue();
                  parambhoj.q = ((String)a(localJSONObject.has("startTime"), localJSONObject.getString("startTime"), ""));
                  parambhoj.r = ((String)a(localJSONObject.has("endTime"), localJSONObject.getString("endTime"), ""));
                  parambhoj.s = ((String)a(localJSONObject.has("dot9png"), localJSONObject.getString("dot9png"), ""));
                  parambhoj.t = ((String)a(localJSONObject.has("backgroundColor"), localJSONObject.getString("backgroundColor"), ""));
                  if (localJSONObject.has("cover")) {
                    parambhoj.jdField_d_of_type_JavaLangString = localJSONObject.getString("cover");
                  }
                  if (localJSONObject.has("aio_2")) {
                    parambhoj.jdField_g_of_type_JavaLangString = localJSONObject.getString("aio_2");
                  }
                  if (localJSONObject.has("aio_3")) {
                    parambhoj.h = localJSONObject.getString("aio_3");
                  }
                  if (localJSONObject.has("aio_4")) {
                    parambhoj.i = localJSONObject.getString("aio_4");
                  }
                  if (localJSONObject.has("icon")) {
                    parambhoj.j = localJSONObject.getString("icon");
                  }
                  if (localJSONObject.has("view")) {
                    parambhoj.k = localJSONObject.getString("view");
                  }
                  if (localJSONObject.has("action_off")) {
                    parambhoj.l = localJSONObject.getString("action_off");
                  }
                  if (!localJSONObject.has("action_on")) {
                    break;
                  }
                  parambhoj.m = localJSONObject.getString("action_on");
                  break;
                  localException1 = localException1;
                  parambhoj.jdField_e_of_type_JavaLangString = "";
                }
                localException2 = localException2;
                parambhoj.o = "";
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  parambhoj.p = "";
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
 * Qualified Name:     bhoh
 * JD-Core Version:    0.7.0.1
 */