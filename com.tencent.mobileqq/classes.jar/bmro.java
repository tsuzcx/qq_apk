import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bmro
{
  private static final Set<Integer> a = new HashSet(5);
  private static final Set<Integer> b = new HashSet(5);
  
  static
  {
    a.add(Integer.valueOf(4));
    a.add(Integer.valueOf(5));
    a.add(Integer.valueOf(9));
    a.add(Integer.valueOf(10));
    b.add(Integer.valueOf(9));
    b.add(Integer.valueOf(10));
  }
  
  public static int a(bmrn parambmrn)
  {
    int j = 0;
    int i = j;
    switch (parambmrn.a)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMInformationPasterManager", 2, "check num of download dir:" + i);
      }
      return i;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 14;
      continue;
      i = 1;
      continue;
      i = 33;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static BitmapDrawable a(String paramString1, Context paramContext, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString1);
      }
      localJSONObject = new JSONObject(paramString1);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      i = localObject.optInt("type", 0);
      switch (i)
      {
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      default: 
        paramString1 = null;
      }
    }
    if (localJSONObject == null) {}
    for (;;)
    {
      return null;
      Object localObject;
      int i;
      while (paramString1 != null)
      {
        return new BitmapDrawable(paramContext.getResources(), paramString1.a());
        paramString1 = new bmtl(paramContext, paramString1).a(paramString1);
        paramString1 = new bmtl(paramContext, bmtl.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bmta(paramContext, paramString1).a(paramString1);
        paramString1 = new bmta(paramContext, bmta.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bmtf(paramContext, bmtf.a(i, new bmtf(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bmtc(paramContext, bmtc.a(i, new bmtc(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bmtr(paramContext, paramString1).a(paramString1);
        paramString1 = new bmtr(paramContext, bmtr.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bmth a(Context paramContext, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("InformationFaceConstant", 2, "to be parsed" + paramString);
      }
      localJSONObject = new JSONObject(paramString);
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      for (;;)
      {
        JSONObject localJSONObject;
        if (QLog.isColorLevel()) {
          QLog.e("InformationFaceConstant", 2, localJSONException, new Object[0]);
        }
        localObject = null;
      }
      switch (localObject.optInt("type", 0))
      {
      case 8: 
      default: 
        return null;
      case 1: 
        return new bmsz(paramContext, paramString);
      case 2: 
        return new bmto(paramContext, paramString);
      case 3: 
        return new bmtm(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bmtl(paramContext, paramString);
    return new bmta(paramContext, paramString);
    return new bmts(paramContext, paramString);
    return new bmsy(paramContext, paramString);
    return new bmtf(paramContext, paramString);
    return new bmtc(paramContext, paramString);
    return new bmtr(paramContext, paramString);
    return new bmsx(paramContext, paramString);
  }
  
  public static bmth a(bmrn parambmrn, Context paramContext, long paramLong)
  {
    int i = parambmrn.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bmsz(paramContext, bmsz.a(i, bluu.c(paramLong), bluu.d(paramLong), bluu.e(paramLong)));
    case 2: 
      return new bmto(paramContext, bmto.a(i, bluu.b(paramLong), bluu.a(paramLong)));
    case 3: 
      str2 = blrc.b(parambmrn);
      parambmrn = bluu.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bmtm(paramContext, bmtm.a(i, parambmrn[2], parambmrn[3], parambmrn[0], parambmrn[1], (String)localObject, str1, str2));
    case 4: 
      str1 = blrc.b(parambmrn) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambmrn.l;
      if (TextUtils.isEmpty(parambmrn.l)) {
        localObject = alpo.a(2131706142);
      }
      return new bmtl(paramContext, bmtl.a(i, bluu.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = blrc.b(parambmrn);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambmrn.l;
      if (TextUtils.isEmpty(parambmrn.l)) {
        localObject = alpo.a(2131706139);
      }
      return new bmta(paramContext, bmta.a(i, (String)localObject, bluu.f(paramLong), str2, str1));
    case 6: 
      String str4 = blrc.b(parambmrn);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambmrn.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambmrn.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambmrn.c;
      if (parambmrn.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bmts(paramContext, bmts.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambmrn = blrc.b(parambmrn);
      return new bmsy(paramContext, bmsy.a(i, parambmrn + File.separator + "city.bpng"));
    case 12: 
      return new bmtf(paramContext, bmtf.a(i, bluu.g(paramLong)));
    case 9: 
      str1 = parambmrn.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bmtc(paramContext, bmtc.a(i, blrc.b(parambmrn) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambmrn.l;
      return new bmtr(paramContext, bmtr.a(i, blrc.b(parambmrn) + File.separator + "location4_icon.png", blrc.b(parambmrn) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bmsx(paramContext, bmsx.a(i, blrc.b(parambmrn) + File.separator + "up.png", blrc.b(parambmrn) + File.separator + "down.png", bluu.h(paramLong), bluu.i(paramLong)));
  }
  
  public static bmth a(bmth parambmth, Context paramContext, String paramString)
  {
    switch (parambmth.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bmsz(paramContext, bmsz.a(parambmth.a(), bluu.c(-1L), bluu.d(-1L), bluu.e(-1L)));
    case 2: 
      return new bmto(paramContext, bmto.a(parambmth.a(), bluu.b(-1L), bluu.a(-1L)));
    case 4: 
      parambmth = (bmtl)parambmth;
      return new bmtl(paramContext, bmtl.a(parambmth.a(), parambmth.a(), paramString, parambmth.b()));
    case 5: 
      parambmth = (bmta)parambmth;
      return new bmta(paramContext, bmta.a(parambmth.a(), paramString, bluu.f(-1L), parambmth.a(), parambmth.b()));
    case 12: 
      parambmth = (bmtf)parambmth;
      return new bmtf(paramContext, bmtf.a(parambmth.a(), parambmth.a()));
    case 11: 
      parambmth = (bmsx)parambmth;
      return new bmsx(paramContext, bmsx.a(parambmth.a(), parambmth.a(), parambmth.b(), bluu.h(-1L), bluu.i(-1L)));
    case 9: 
      parambmth = (bmtc)parambmth;
      return new bmtc(paramContext, bmtc.a(parambmth.a(), parambmth.a(), paramString));
    }
    parambmth = (bmtr)parambmth;
    return new bmtr(paramContext, bmtr.a(parambmth.a(), parambmth.a(), parambmth.b(), paramString));
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean b(int paramInt)
  {
    return b.contains(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmro
 * JD-Core Version:    0.7.0.1
 */