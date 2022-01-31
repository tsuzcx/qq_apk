import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bkfn
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
  
  public static int a(bkfm parambkfm)
  {
    int j = 0;
    int i = j;
    switch (parambkfm.a)
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
        paramString1 = new bkhk(paramContext, paramString1).a(paramString1);
        paramString1 = new bkhk(paramContext, bkhk.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bkgz(paramContext, paramString1).a(paramString1);
        paramString1 = new bkgz(paramContext, bkgz.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bkhe(paramContext, bkhe.a(i, new bkhe(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bkhb(paramContext, bkhb.a(i, new bkhb(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bkhq(paramContext, paramString1).a(paramString1);
        paramString1 = new bkhq(paramContext, bkhq.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bkhg a(Context paramContext, String paramString)
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
        return new bkgy(paramContext, paramString);
      case 2: 
        return new bkhn(paramContext, paramString);
      case 3: 
        return new bkhl(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bkhk(paramContext, paramString);
    return new bkgz(paramContext, paramString);
    return new bkhr(paramContext, paramString);
    return new bkgx(paramContext, paramString);
    return new bkhe(paramContext, paramString);
    return new bkhb(paramContext, paramString);
    return new bkhq(paramContext, paramString);
    return new bkgw(paramContext, paramString);
  }
  
  public static bkhg a(bkfm parambkfm, Context paramContext, long paramLong)
  {
    int i = parambkfm.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bkgy(paramContext, bkgy.a(i, bjis.c(paramLong), bjis.d(paramLong), bjis.e(paramLong)));
    case 2: 
      return new bkhn(paramContext, bkhn.a(i, bjis.b(paramLong), bjis.a(paramLong)));
    case 3: 
      str2 = bjfa.b(parambkfm);
      parambkfm = bjis.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bkhl(paramContext, bkhl.a(i, parambkfm[2], parambkfm[3], parambkfm[0], parambkfm[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bjfa.b(parambkfm) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambkfm.l;
      if (TextUtils.isEmpty(parambkfm.l)) {
        localObject = ajyc.a(2131705759);
      }
      return new bkhk(paramContext, bkhk.a(i, bjis.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bjfa.b(parambkfm);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambkfm.l;
      if (TextUtils.isEmpty(parambkfm.l)) {
        localObject = ajyc.a(2131705756);
      }
      return new bkgz(paramContext, bkgz.a(i, (String)localObject, bjis.f(paramLong), str2, str1));
    case 6: 
      String str4 = bjfa.b(parambkfm);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambkfm.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambkfm.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambkfm.c;
      if (parambkfm.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bkhr(paramContext, bkhr.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambkfm = bjfa.b(parambkfm);
      return new bkgx(paramContext, bkgx.a(i, parambkfm + File.separator + "city.bpng"));
    case 12: 
      return new bkhe(paramContext, bkhe.a(i, bjis.g(paramLong)));
    case 9: 
      str1 = parambkfm.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bkhb(paramContext, bkhb.a(i, bjfa.b(parambkfm) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambkfm.l;
      return new bkhq(paramContext, bkhq.a(i, bjfa.b(parambkfm) + File.separator + "location4_icon.png", bjfa.b(parambkfm) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bkgw(paramContext, bkgw.a(i, bjfa.b(parambkfm) + File.separator + "up.png", bjfa.b(parambkfm) + File.separator + "down.png", bjis.h(paramLong), bjis.i(paramLong)));
  }
  
  public static bkhg a(bkhg parambkhg, Context paramContext, String paramString)
  {
    switch (parambkhg.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bkgy(paramContext, bkgy.a(parambkhg.a(), bjis.c(-1L), bjis.d(-1L), bjis.e(-1L)));
    case 2: 
      return new bkhn(paramContext, bkhn.a(parambkhg.a(), bjis.b(-1L), bjis.a(-1L)));
    case 4: 
      parambkhg = (bkhk)parambkhg;
      return new bkhk(paramContext, bkhk.a(parambkhg.a(), parambkhg.a(), paramString, parambkhg.b()));
    case 5: 
      parambkhg = (bkgz)parambkhg;
      return new bkgz(paramContext, bkgz.a(parambkhg.a(), paramString, bjis.f(-1L), parambkhg.a(), parambkhg.b()));
    case 12: 
      parambkhg = (bkhe)parambkhg;
      return new bkhe(paramContext, bkhe.a(parambkhg.a(), parambkhg.a()));
    case 11: 
      parambkhg = (bkgw)parambkhg;
      return new bkgw(paramContext, bkgw.a(parambkhg.a(), parambkhg.a(), parambkhg.b(), bjis.h(-1L), bjis.i(-1L)));
    case 9: 
      parambkhg = (bkhb)parambkhg;
      return new bkhb(paramContext, bkhb.a(parambkhg.a(), parambkhg.a(), paramString));
    }
    parambkhg = (bkhq)parambkhg;
    return new bkhq(paramContext, bkhq.a(parambkhg.a(), parambkhg.a(), parambkhg.b(), paramString));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkfn
 * JD-Core Version:    0.7.0.1
 */