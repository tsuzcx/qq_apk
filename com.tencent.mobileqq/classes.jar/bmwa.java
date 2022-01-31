import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bmwa
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
  
  public static int a(bmvz parambmvz)
  {
    int j = 0;
    int i = j;
    switch (parambmvz.a)
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
        paramString1 = new bmxx(paramContext, paramString1).a(paramString1);
        paramString1 = new bmxx(paramContext, bmxx.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bmxm(paramContext, paramString1).a(paramString1);
        paramString1 = new bmxm(paramContext, bmxm.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bmxr(paramContext, bmxr.a(i, new bmxr(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bmxo(paramContext, bmxo.a(i, new bmxo(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bmyd(paramContext, paramString1).a(paramString1);
        paramString1 = new bmyd(paramContext, bmyd.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bmxt a(Context paramContext, String paramString)
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
        return new bmxl(paramContext, paramString);
      case 2: 
        return new bmya(paramContext, paramString);
      case 3: 
        return new bmxy(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bmxx(paramContext, paramString);
    return new bmxm(paramContext, paramString);
    return new bmye(paramContext, paramString);
    return new bmxk(paramContext, paramString);
    return new bmxr(paramContext, paramString);
    return new bmxo(paramContext, paramString);
    return new bmyd(paramContext, paramString);
    return new bmxj(paramContext, paramString);
  }
  
  public static bmxt a(bmvz parambmvz, Context paramContext, long paramLong)
  {
    int i = parambmvz.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bmxl(paramContext, bmxl.a(i, blzg.c(paramLong), blzg.d(paramLong), blzg.e(paramLong)));
    case 2: 
      return new bmya(paramContext, bmya.a(i, blzg.b(paramLong), blzg.a(paramLong)));
    case 3: 
      str2 = blvo.b(parambmvz);
      parambmvz = blzg.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bmxy(paramContext, bmxy.a(i, parambmvz[2], parambmvz[3], parambmvz[0], parambmvz[1], (String)localObject, str1, str2));
    case 4: 
      str1 = blvo.b(parambmvz) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambmvz.l;
      if (TextUtils.isEmpty(parambmvz.l)) {
        localObject = alud.a(2131706154);
      }
      return new bmxx(paramContext, bmxx.a(i, blzg.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = blvo.b(parambmvz);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambmvz.l;
      if (TextUtils.isEmpty(parambmvz.l)) {
        localObject = alud.a(2131706151);
      }
      return new bmxm(paramContext, bmxm.a(i, (String)localObject, blzg.f(paramLong), str2, str1));
    case 6: 
      String str4 = blvo.b(parambmvz);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambmvz.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambmvz.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambmvz.c;
      if (parambmvz.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bmye(paramContext, bmye.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambmvz = blvo.b(parambmvz);
      return new bmxk(paramContext, bmxk.a(i, parambmvz + File.separator + "city.bpng"));
    case 12: 
      return new bmxr(paramContext, bmxr.a(i, blzg.g(paramLong)));
    case 9: 
      str1 = parambmvz.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bmxo(paramContext, bmxo.a(i, blvo.b(parambmvz) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambmvz.l;
      return new bmyd(paramContext, bmyd.a(i, blvo.b(parambmvz) + File.separator + "location4_icon.png", blvo.b(parambmvz) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bmxj(paramContext, bmxj.a(i, blvo.b(parambmvz) + File.separator + "up.png", blvo.b(parambmvz) + File.separator + "down.png", blzg.h(paramLong), blzg.i(paramLong)));
  }
  
  public static bmxt a(bmxt parambmxt, Context paramContext, String paramString)
  {
    switch (parambmxt.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bmxl(paramContext, bmxl.a(parambmxt.a(), blzg.c(-1L), blzg.d(-1L), blzg.e(-1L)));
    case 2: 
      return new bmya(paramContext, bmya.a(parambmxt.a(), blzg.b(-1L), blzg.a(-1L)));
    case 4: 
      parambmxt = (bmxx)parambmxt;
      return new bmxx(paramContext, bmxx.a(parambmxt.a(), parambmxt.a(), paramString, parambmxt.b()));
    case 5: 
      parambmxt = (bmxm)parambmxt;
      return new bmxm(paramContext, bmxm.a(parambmxt.a(), paramString, blzg.f(-1L), parambmxt.a(), parambmxt.b()));
    case 12: 
      parambmxt = (bmxr)parambmxt;
      return new bmxr(paramContext, bmxr.a(parambmxt.a(), parambmxt.a()));
    case 11: 
      parambmxt = (bmxj)parambmxt;
      return new bmxj(paramContext, bmxj.a(parambmxt.a(), parambmxt.a(), parambmxt.b(), blzg.h(-1L), blzg.i(-1L)));
    case 9: 
      parambmxt = (bmxo)parambmxt;
      return new bmxo(paramContext, bmxo.a(parambmxt.a(), parambmxt.a(), paramString));
    }
    parambmxt = (bmyd)parambmxt;
    return new bmyd(paramContext, bmyd.a(parambmxt.a(), parambmxt.a(), parambmxt.b(), paramString));
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
 * Qualified Name:     bmwa
 * JD-Core Version:    0.7.0.1
 */