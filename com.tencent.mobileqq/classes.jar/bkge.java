import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bkge
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
  
  public static int a(bkgd parambkgd)
  {
    int j = 0;
    int i = j;
    switch (parambkgd.a)
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
        paramString1 = new bkib(paramContext, paramString1).a(paramString1);
        paramString1 = new bkib(paramContext, bkib.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bkhq(paramContext, paramString1).a(paramString1);
        paramString1 = new bkhq(paramContext, bkhq.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bkhv(paramContext, bkhv.a(i, new bkhv(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bkhs(paramContext, bkhs.a(i, new bkhs(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bkih(paramContext, paramString1).a(paramString1);
        paramString1 = new bkih(paramContext, bkih.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bkhx a(Context paramContext, String paramString)
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
        return new bkhp(paramContext, paramString);
      case 2: 
        return new bkie(paramContext, paramString);
      case 3: 
        return new bkic(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bkib(paramContext, paramString);
    return new bkhq(paramContext, paramString);
    return new bkii(paramContext, paramString);
    return new bkho(paramContext, paramString);
    return new bkhv(paramContext, paramString);
    return new bkhs(paramContext, paramString);
    return new bkih(paramContext, paramString);
    return new bkhn(paramContext, paramString);
  }
  
  public static bkhx a(bkgd parambkgd, Context paramContext, long paramLong)
  {
    int i = parambkgd.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bkhp(paramContext, bkhp.a(i, bjjj.c(paramLong), bjjj.d(paramLong), bjjj.e(paramLong)));
    case 2: 
      return new bkie(paramContext, bkie.a(i, bjjj.b(paramLong), bjjj.a(paramLong)));
    case 3: 
      str2 = bjfr.b(parambkgd);
      parambkgd = bjjj.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bkic(paramContext, bkic.a(i, parambkgd[2], parambkgd[3], parambkgd[0], parambkgd[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bjfr.b(parambkgd) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambkgd.l;
      if (TextUtils.isEmpty(parambkgd.l)) {
        localObject = ajya.a(2131705770);
      }
      return new bkib(paramContext, bkib.a(i, bjjj.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bjfr.b(parambkgd);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambkgd.l;
      if (TextUtils.isEmpty(parambkgd.l)) {
        localObject = ajya.a(2131705767);
      }
      return new bkhq(paramContext, bkhq.a(i, (String)localObject, bjjj.f(paramLong), str2, str1));
    case 6: 
      String str4 = bjfr.b(parambkgd);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambkgd.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambkgd.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambkgd.c;
      if (parambkgd.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bkii(paramContext, bkii.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambkgd = bjfr.b(parambkgd);
      return new bkho(paramContext, bkho.a(i, parambkgd + File.separator + "city.bpng"));
    case 12: 
      return new bkhv(paramContext, bkhv.a(i, bjjj.g(paramLong)));
    case 9: 
      str1 = parambkgd.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bkhs(paramContext, bkhs.a(i, bjfr.b(parambkgd) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambkgd.l;
      return new bkih(paramContext, bkih.a(i, bjfr.b(parambkgd) + File.separator + "location4_icon.png", bjfr.b(parambkgd) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bkhn(paramContext, bkhn.a(i, bjfr.b(parambkgd) + File.separator + "up.png", bjfr.b(parambkgd) + File.separator + "down.png", bjjj.h(paramLong), bjjj.i(paramLong)));
  }
  
  public static bkhx a(bkhx parambkhx, Context paramContext, String paramString)
  {
    switch (parambkhx.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bkhp(paramContext, bkhp.a(parambkhx.a(), bjjj.c(-1L), bjjj.d(-1L), bjjj.e(-1L)));
    case 2: 
      return new bkie(paramContext, bkie.a(parambkhx.a(), bjjj.b(-1L), bjjj.a(-1L)));
    case 4: 
      parambkhx = (bkib)parambkhx;
      return new bkib(paramContext, bkib.a(parambkhx.a(), parambkhx.a(), paramString, parambkhx.b()));
    case 5: 
      parambkhx = (bkhq)parambkhx;
      return new bkhq(paramContext, bkhq.a(parambkhx.a(), paramString, bjjj.f(-1L), parambkhx.a(), parambkhx.b()));
    case 12: 
      parambkhx = (bkhv)parambkhx;
      return new bkhv(paramContext, bkhv.a(parambkhx.a(), parambkhx.a()));
    case 11: 
      parambkhx = (bkhn)parambkhx;
      return new bkhn(paramContext, bkhn.a(parambkhx.a(), parambkhx.a(), parambkhx.b(), bjjj.h(-1L), bjjj.i(-1L)));
    case 9: 
      parambkhx = (bkhs)parambkhx;
      return new bkhs(paramContext, bkhs.a(parambkhx.a(), parambkhx.a(), paramString));
    }
    parambkhx = (bkih)parambkhx;
    return new bkih(paramContext, bkih.a(parambkhx.a(), parambkhx.a(), parambkhx.b(), paramString));
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
 * Qualified Name:     bkge
 * JD-Core Version:    0.7.0.1
 */