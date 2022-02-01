import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bpbb
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
  
  public static int a(bpba parambpba)
  {
    int j = 0;
    int i = j;
    switch (parambpba.a)
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
        paramString1 = new bpcu(paramContext, paramString1).a(paramString1);
        paramString1 = new bpcu(paramContext, bpcu.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bpcl(paramContext, paramString1).a(paramString1);
        paramString1 = new bpcl(paramContext, bpcl.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bpco(paramContext, bpco.a(i, new bpco(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bpcn(paramContext, bpcn.a(i, new bpcn(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bpda(paramContext, paramString1).a(paramString1);
        paramString1 = new bpda(paramContext, bpda.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bpcq a(Context paramContext, String paramString)
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
        return new bpck(paramContext, paramString);
      case 2: 
        return new bpcx(paramContext, paramString);
      case 3: 
        return new bpcv(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bpcu(paramContext, paramString);
    return new bpcl(paramContext, paramString);
    return new bpdb(paramContext, paramString);
    return new bpcj(paramContext, paramString);
    return new bpco(paramContext, paramString);
    return new bpcn(paramContext, paramString);
    return new bpda(paramContext, paramString);
    return new bpci(paramContext, paramString);
  }
  
  public static bpcq a(bpba parambpba, Context paramContext, long paramLong)
  {
    int i = parambpba.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bpck(paramContext, bpck.a(i, bond.c(paramLong), bond.d(paramLong), bond.e(paramLong)));
    case 2: 
      return new bpcx(paramContext, bpcx.a(i, bond.b(paramLong), bond.a(paramLong)));
    case 3: 
      str2 = bojy.b(parambpba);
      parambpba = bond.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bpcv(paramContext, bpcv.a(i, parambpba[2], parambpba[3], parambpba[0], parambpba[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bojy.b(parambpba) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambpba.l;
      if (TextUtils.isEmpty(parambpba.l)) {
        localObject = anvx.a(2131705243);
      }
      return new bpcu(paramContext, bpcu.a(i, bond.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bojy.b(parambpba);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambpba.l;
      if (TextUtils.isEmpty(parambpba.l)) {
        localObject = anvx.a(2131705240);
      }
      return new bpcl(paramContext, bpcl.a(i, (String)localObject, bond.f(paramLong), str2, str1));
    case 6: 
      String str4 = bojy.b(parambpba);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambpba.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambpba.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambpba.c;
      if (parambpba.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bpdb(paramContext, bpdb.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambpba = bojy.b(parambpba);
      return new bpcj(paramContext, bpcj.a(i, parambpba + File.separator + "city.bpng"));
    case 12: 
      return new bpco(paramContext, bpco.a(i, bond.g(paramLong)));
    case 9: 
      str1 = parambpba.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bpcn(paramContext, bpcn.a(i, bojy.b(parambpba) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambpba.l;
      return new bpda(paramContext, bpda.a(i, bojy.b(parambpba) + File.separator + "location4_icon.png", bojy.b(parambpba) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bpci(paramContext, bpci.a(i, bojy.b(parambpba) + File.separator + "up.png", bojy.b(parambpba) + File.separator + "down.png", bond.h(paramLong), bond.i(paramLong)));
  }
  
  public static bpcq a(bpcq parambpcq, Context paramContext, String paramString)
  {
    switch (parambpcq.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bpck(paramContext, bpck.a(parambpcq.a(), bond.c(-1L), bond.d(-1L), bond.e(-1L)));
    case 2: 
      return new bpcx(paramContext, bpcx.a(parambpcq.a(), bond.b(-1L), bond.a(-1L)));
    case 4: 
      parambpcq = (bpcu)parambpcq;
      return new bpcu(paramContext, bpcu.a(parambpcq.a(), parambpcq.a(), paramString, parambpcq.b()));
    case 5: 
      parambpcq = (bpcl)parambpcq;
      return new bpcl(paramContext, bpcl.a(parambpcq.a(), paramString, bond.f(-1L), parambpcq.a(), parambpcq.b()));
    case 12: 
      parambpcq = (bpco)parambpcq;
      return new bpco(paramContext, bpco.a(parambpcq.a(), parambpcq.a()));
    case 11: 
      parambpcq = (bpci)parambpcq;
      return new bpci(paramContext, bpci.a(parambpcq.a(), parambpcq.a(), parambpcq.b(), bond.h(-1L), bond.i(-1L)));
    case 9: 
      parambpcq = (bpcn)parambpcq;
      return new bpcn(paramContext, bpcn.a(parambpcq.a(), parambpcq.a(), paramString));
    }
    parambpcq = (bpda)parambpcq;
    return new bpda(paramContext, bpda.a(parambpcq.a(), parambpcq.a(), parambpcq.b(), paramString));
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
 * Qualified Name:     bpbb
 * JD-Core Version:    0.7.0.1
 */