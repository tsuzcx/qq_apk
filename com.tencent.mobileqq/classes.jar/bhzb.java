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

public class bhzb
{
  public static bhzd a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject = antf.bZ + paramInt + File.separator + "config.json";
    paramQQAppInterface = VasQuickUpdateManager.getFileFromLocal(paramQQAppInterface, 1000L, "signature.item." + paramInt + ".json", (String)localObject, true, null);
    try
    {
      paramQQAppInterface = bhmi.a(paramQQAppInterface, -1);
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
    localObject = new bhzd(Integer.toString(paramInt));
    a(paramQQAppInterface, (bhzd)localObject);
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
    StringBuilder localStringBuilder = new StringBuilder(antf.bZ);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static void a(bhzd parambhzd, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      a(parambhzd, paramJSONArray.getJSONObject(i));
      i += 1;
    }
  }
  
  private static void a(bhzd parambhzd, JSONObject paramJSONObject)
  {
    int i;
    int j;
    if (paramJSONObject.has("aio_rows"))
    {
      i = paramJSONObject.getInt("aio_rows");
      if ((i == 0) || ((i > 1) && (i < 6)))
      {
        bhze[] arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label356;
        }
        j = i;
        label43:
        arrayOfbhze[j].jdField_a_of_type_Int = i;
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label363;
        }
        j = i;
        label63:
        arrayOfbhze[j].jdField_a_of_type_JavaLangString = ((String)a(paramJSONObject.has("pngZip"), paramJSONObject.getString("pngZip"), ""));
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label370;
        }
        j = i;
        label102:
        arrayOfbhze[j].jdField_a_of_type_Float = ((Float)a(paramJSONObject.has("posX"), paramJSONObject.getString("posX"), Integer.valueOf(0))).floatValue();
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label377;
        }
        j = i;
        label146:
        arrayOfbhze[j].jdField_b_of_type_Float = ((Float)a(paramJSONObject.has("posY"), paramJSONObject.getString("posY"), Integer.valueOf(0))).floatValue();
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label384;
        }
        j = i;
        label190:
        arrayOfbhze[j].jdField_c_of_type_Float = ((Float)a(paramJSONObject.has("width"), paramJSONObject.getString("width"), Integer.valueOf(0))).floatValue();
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label391;
        }
        j = i;
        label234:
        arrayOfbhze[j].d = ((Float)a(paramJSONObject.has("height"), paramJSONObject.getString("height"), Integer.valueOf(0))).floatValue();
        arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label398;
        }
        j = i;
        label278:
        arrayOfbhze[j].jdField_b_of_type_Int = ((Integer)a(paramJSONObject.has("repeatTimes"), paramJSONObject.getString("repeatTimes"), Integer.valueOf(0))).intValue();
        parambhzd = parambhzd.jdField_a_of_type_ArrayOfBhze;
        if (i != 0) {
          break label405;
        }
      }
    }
    for (;;)
    {
      parambhzd[i].jdField_c_of_type_Int = ((Integer)a(paramJSONObject.has("interval"), paramJSONObject.getString("interval"), Integer.valueOf(0))).intValue();
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
  
  public static void a(String paramString, bhzd parambhzd)
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
        parambhzd.a();
        return;
      }
      parambhzd.jdField_f_of_type_JavaLangString = ((JSONObject)localObject).optString("qqVer", "0.0.0");
      if (AppSetting.a(parambhzd.jdField_f_of_type_JavaLangString) < 0)
      {
        parambhzd.a();
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("SignatureTemplateConfig", 1, "getSignatureTemplateInfoFromFile error: " + paramString.getMessage());
      return;
    }
    parambhzd.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("name", anzj.a(2131712998));
    parambhzd.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("type", -1);
    parambhzd.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("feeType", 1);
    parambhzd.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("actUrl", null);
    parambhzd.jdField_c_of_type_Int = ((JSONObject)localObject).optInt("newOrHot", 0);
    parambhzd.jdField_d_of_type_Int = ((JSONObject)localObject).optInt("platId");
    parambhzd.jdField_e_of_type_JavaLangString = ((JSONObject)localObject).optString("fontColor", "");
    parambhzd.jdField_g_of_type_Int = ((JSONObject)localObject).optInt("signType", 0);
    for (;;)
    {
      int j;
      int i;
      try
      {
        Color.parseColor(parambhzd.jdField_e_of_type_JavaLangString);
        parambhzd.n = ((JSONObject)localObject).optString("defText", "");
        parambhzd.o = ((JSONObject)localObject).optString("defTextColor", "");
      }
      catch (Exception localException2)
      {
        try
        {
          Color.parseColor(parambhzd.o);
          parambhzd.p = ((JSONObject)localObject).optString("timeAndLocation", "");
        }
        catch (Exception localException2)
        {
          try
          {
            Color.parseColor(parambhzd.p);
            parambhzd.jdField_e_of_type_Int = ((JSONObject)localObject).optInt("isLimited", 1);
            parambhzd.q = ((JSONObject)localObject).optString("startTime");
            parambhzd.r = ((JSONObject)localObject).optString("endTime");
            parambhzd.s = ((JSONObject)localObject).optString("dot9png");
            parambhzd.jdField_d_of_type_JavaLangString = ((JSONObject)localObject).optString("cover");
            parambhzd.jdField_g_of_type_JavaLangString = ((JSONObject)localObject).optString("aio_2");
            parambhzd.h = ((JSONObject)localObject).optString("aio_3");
            parambhzd.i = ((JSONObject)localObject).optString("aio_4");
            parambhzd.j = ((JSONObject)localObject).optString("icon");
            parambhzd.k = ((JSONObject)localObject).optString("view");
            parambhzd.l = ((JSONObject)localObject).optString("action_off");
            parambhzd.m = ((JSONObject)localObject).optString("action_on");
            parambhzd.t = ((JSONObject)localObject).optString("backgroundColor");
            parambhzd.u = ((JSONObject)localObject).optString("shadowColor");
            parambhzd.jdField_f_of_type_Int = ((JSONObject)localObject).optInt("materialVersion");
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
                bhze[] arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label896;
                }
                k = i;
                arrayOfbhze[k].jdField_a_of_type_Int = i;
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label904;
                }
                k = i;
                arrayOfbhze[k].jdField_a_of_type_JavaLangString = localJSONObject.optString("pngZip");
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label912;
                }
                k = i;
                arrayOfbhze[k].jdField_a_of_type_Float = ((float)localJSONObject.optDouble("posX", 0.0D));
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label920;
                }
                k = i;
                arrayOfbhze[k].jdField_b_of_type_Float = ((float)localJSONObject.optDouble("posY", 0.0D));
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label928;
                }
                k = i;
                arrayOfbhze[k].jdField_c_of_type_Float = ((float)localJSONObject.optDouble("width", 0.0D));
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label936;
                }
                k = i;
                arrayOfbhze[k].d = ((float)localJSONObject.optDouble("height", 0.0D));
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label944;
                }
                k = i;
                arrayOfbhze[k].jdField_b_of_type_Int = localJSONObject.optInt("repeatTimes", 0);
                arrayOfbhze = parambhzd.jdField_a_of_type_ArrayOfBhze;
                if (i != 0) {
                  break label952;
                }
                arrayOfbhze[i].jdField_c_of_type_Int = localJSONObject.optInt("interval", 0);
                break label889;
                localException1 = localException1;
                parambhzd.jdField_e_of_type_JavaLangString = "";
                continue;
                localException2 = localException2;
                parambhzd.o = "";
              }
            }
          }
          catch (Exception localException3)
          {
            parambhzd.p = "";
            continue;
            paramString = paramString.optJSONArray("imgItem");
            if ((paramString != null) && (paramString.length() > 0))
            {
              paramString = paramString.getJSONObject(0);
              parambhzd.getClass();
              localObject = new bhzf(parambhzd);
              ((bhzf)localObject).jdField_b_of_type_JavaLangString = paramString.optString("content");
              ((bhzf)localObject).jdField_a_of_type_JavaLangString = paramString.optString("img");
              ((bhzf)localObject).jdField_a_of_type_Int = paramString.optInt("imgWidth");
              ((bhzf)localObject).jdField_b_of_type_Int = paramString.optInt("imgHeight");
              ((bhzf)localObject).jdField_c_of_type_JavaLangString = paramString.optString("imgCover");
              parambhzd.jdField_a_of_type_Bhzf = ((bhzf)localObject);
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
  
  private static void a(Map<Integer, bhzc> paramMap, JSONObject paramJSONObject, Iterator paramIterator)
  {
    paramJSONObject = paramJSONObject.getJSONArray((String)paramIterator.next());
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.getJSONObject(i);
      paramIterator = new bhzd(((JSONObject)localObject).getString("id"));
      b(paramIterator, ((JSONObject)localObject).getJSONArray("data"));
      if (((JSONObject)localObject).has("dynamicItem")) {
        a(paramIterator, ((JSONObject)localObject).getJSONArray("dynamicItem"));
      }
      localObject = ((JSONObject)localObject).optJSONArray("imgItem");
      if ((localObject != null) && (((JSONArray)localObject).length() > 0))
      {
        localObject = ((JSONArray)localObject).getJSONObject(0);
        paramIterator.getClass();
        bhzf localbhzf = new bhzf(paramIterator);
        localbhzf.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("content");
        localbhzf.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("img");
        localbhzf.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("imgWidth");
        localbhzf.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("imgHeight");
        localbhzf.jdField_c_of_type_JavaLangString = ((JSONObject)localObject).optString("imgCover");
        paramIterator.jdField_a_of_type_Bhzf = localbhzf;
      }
      localObject = (bhzc)paramMap.get(Integer.valueOf(paramIterator.jdField_b_of_type_Int));
      if (localObject != null) {
        ((bhzc)localObject).jdField_a_of_type_JavaUtilArrayList.add(paramIterator);
      }
      i += 1;
    }
  }
  
  public static bhzc[] a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1;
    try
    {
      localObject1 = new LinkedHashMap();
      paramQQAppInterface = new File(SignatureManager.jdField_b_of_type_JavaLangString);
      try
      {
        paramQQAppInterface = bhmi.a(paramQQAppInterface, -1);
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
        bhzc localbhzc = new bhzc();
        localbhzc.jdField_a_of_type_Int = localJSONObject.getInt("sigId");
        localbhzc.jdField_a_of_type_JavaLangString = localJSONObject.getString("sigType");
        ((Map)localObject1).put(Integer.valueOf(localbhzc.jdField_a_of_type_Int), localbhzc);
        i += 1;
      }
      paramQQAppInterface = paramQQAppInterface.getJSONObject("items");
      localObject2 = paramQQAppInterface.keys();
      while (((Iterator)localObject2).hasNext()) {
        a((Map)localObject1, paramQQAppInterface, (Iterator)localObject2);
      }
      paramQQAppInterface = ((Map)localObject1).entrySet().iterator();
      while (paramQQAppInterface.hasNext()) {
        if (((bhzc)((Map.Entry)paramQQAppInterface.next()).getValue()).jdField_a_of_type_JavaUtilArrayList.size() == 0) {
          paramQQAppInterface.remove();
        }
      }
      paramQQAppInterface = new bhzc[((Map)localObject1).values().size()];
      ((Map)localObject1).values().toArray(paramQQAppInterface);
    }
  }
  
  private static void b(bhzd parambhzd, JSONArray paramJSONArray)
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
        parambhzd.jdField_f_of_type_JavaLangString = localJSONObject.getString("qqVer");
        if (AppSetting.a(parambhzd.jdField_f_of_type_JavaLangString) >= 0)
        {
          parambhzd.jdField_b_of_type_JavaLangString = ((String)a(localJSONObject.has("name"), localJSONObject.getString("name"), anzj.a(2131712979)));
          parambhzd.jdField_b_of_type_Int = ((Integer)a(localJSONObject.has("type"), Integer.valueOf(localJSONObject.getInt("type")), Integer.valueOf(-1))).intValue();
          parambhzd.jdField_a_of_type_Int = ((Integer)a(localJSONObject.has("feeType"), Integer.valueOf(localJSONObject.getInt("feeType")), Integer.valueOf(1))).intValue();
          parambhzd.jdField_c_of_type_JavaLangString = ((String)a(localJSONObject.has("actUrl"), localJSONObject.getString("actUrl"), null));
          parambhzd.jdField_c_of_type_Int = ((Integer)a(localJSONObject.has("newOrHot"), localJSONObject.getString("newOrHot"), Integer.valueOf(0))).intValue();
          parambhzd.jdField_d_of_type_Int = localJSONObject.getInt("platId");
          parambhzd.jdField_e_of_type_JavaLangString = ((String)a(localJSONObject.has("fontColor"), localJSONObject.getString("fontColor"), ""));
          try
          {
            Color.parseColor(parambhzd.jdField_e_of_type_JavaLangString);
            parambhzd.n = ((String)a(localJSONObject.has("defText"), localJSONObject.getString("defText"), ""));
            parambhzd.o = ((String)a(localJSONObject.has("defTextColor"), localJSONObject.getString("defTextColor"), ""));
          }
          catch (Exception localException2)
          {
            try
            {
              Color.parseColor(parambhzd.o);
              parambhzd.p = ((String)a(localJSONObject.has("timeAndLocation"), localJSONObject.getString("timeAndLocation"), ""));
            }
            catch (Exception localException2)
            {
              try
              {
                for (;;)
                {
                  Color.parseColor(parambhzd.p);
                  parambhzd.jdField_e_of_type_Int = ((Integer)a(localJSONObject.has("isLimited"), localJSONObject.getString("isLimited"), Integer.valueOf(1))).intValue();
                  parambhzd.q = ((String)a(localJSONObject.has("startTime"), localJSONObject.getString("startTime"), ""));
                  parambhzd.r = ((String)a(localJSONObject.has("endTime"), localJSONObject.getString("endTime"), ""));
                  parambhzd.s = ((String)a(localJSONObject.has("dot9png"), localJSONObject.getString("dot9png"), ""));
                  parambhzd.t = ((String)a(localJSONObject.has("backgroundColor"), localJSONObject.getString("backgroundColor"), ""));
                  if (localJSONObject.has("cover")) {
                    parambhzd.jdField_d_of_type_JavaLangString = localJSONObject.getString("cover");
                  }
                  if (localJSONObject.has("aio_2")) {
                    parambhzd.jdField_g_of_type_JavaLangString = localJSONObject.getString("aio_2");
                  }
                  if (localJSONObject.has("aio_3")) {
                    parambhzd.h = localJSONObject.getString("aio_3");
                  }
                  if (localJSONObject.has("aio_4")) {
                    parambhzd.i = localJSONObject.getString("aio_4");
                  }
                  if (localJSONObject.has("icon")) {
                    parambhzd.j = localJSONObject.getString("icon");
                  }
                  if (localJSONObject.has("view")) {
                    parambhzd.k = localJSONObject.getString("view");
                  }
                  if (localJSONObject.has("action_off")) {
                    parambhzd.l = localJSONObject.getString("action_off");
                  }
                  if (!localJSONObject.has("action_on")) {
                    break;
                  }
                  parambhzd.m = localJSONObject.getString("action_on");
                  break;
                  localException1 = localException1;
                  parambhzd.jdField_e_of_type_JavaLangString = "";
                }
                localException2 = localException2;
                parambhzd.o = "";
              }
              catch (Exception localException3)
              {
                for (;;)
                {
                  parambhzd.p = "";
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
 * Qualified Name:     bhzb
 * JD-Core Version:    0.7.0.1
 */