import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bios
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
  
  public static int a(bior parambior)
  {
    int j = 0;
    int i = j;
    switch (parambior.a)
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
        paramString1 = new biqp(paramContext, paramString1).a(paramString1);
        paramString1 = new biqp(paramContext, biqp.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new biqe(paramContext, paramString1).a(paramString1);
        paramString1 = new biqe(paramContext, biqe.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new biqj(paramContext, biqj.a(i, new biqj(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new biqg(paramContext, biqg.a(i, new biqg(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new biqv(paramContext, paramString1).a(paramString1);
        paramString1 = new biqv(paramContext, biqv.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static biql a(Context paramContext, String paramString)
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
        return new biqd(paramContext, paramString);
      case 2: 
        return new biqs(paramContext, paramString);
      case 3: 
        return new biqq(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new biqp(paramContext, paramString);
    return new biqe(paramContext, paramString);
    return new biqw(paramContext, paramString);
    return new biqc(paramContext, paramString);
    return new biqj(paramContext, paramString);
    return new biqg(paramContext, paramString);
    return new biqv(paramContext, paramString);
    return new biqb(paramContext, paramString);
  }
  
  public static biql a(bior parambior, Context paramContext, long paramLong)
  {
    int i = parambior.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new biqd(paramContext, biqd.a(i, bhoa.c(paramLong), bhoa.d(paramLong), bhoa.e(paramLong)));
    case 2: 
      return new biqs(paramContext, biqs.a(i, bhoa.b(paramLong), bhoa.a(paramLong)));
    case 3: 
      str2 = bhki.b(parambior);
      parambior = bhoa.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new biqq(paramContext, biqq.a(i, parambior[2], parambior[3], parambior[0], parambior[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bhki.b(parambior) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambior.l;
      if (TextUtils.isEmpty(parambior.l)) {
        localObject = ajjy.a(2131639974);
      }
      return new biqp(paramContext, biqp.a(i, bhoa.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bhki.b(parambior);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambior.l;
      if (TextUtils.isEmpty(parambior.l)) {
        localObject = ajjy.a(2131639971);
      }
      return new biqe(paramContext, biqe.a(i, (String)localObject, bhoa.f(paramLong), str2, str1));
    case 6: 
      String str4 = bhki.b(parambior);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambior.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambior.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambior.c;
      if (parambior.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new biqw(paramContext, biqw.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambior = bhki.b(parambior);
      return new biqc(paramContext, biqc.a(i, parambior + File.separator + "city.bpng"));
    case 12: 
      return new biqj(paramContext, biqj.a(i, bhoa.g(paramLong)));
    case 9: 
      str1 = parambior.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new biqg(paramContext, biqg.a(i, bhki.b(parambior) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambior.l;
      return new biqv(paramContext, biqv.a(i, bhki.b(parambior) + File.separator + "location4_icon.png", bhki.b(parambior) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new biqb(paramContext, biqb.a(i, bhki.b(parambior) + File.separator + "up.png", bhki.b(parambior) + File.separator + "down.png", bhoa.h(paramLong), bhoa.i(paramLong)));
  }
  
  public static biql a(biql parambiql, Context paramContext, String paramString)
  {
    switch (parambiql.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new biqd(paramContext, biqd.a(parambiql.a(), bhoa.c(-1L), bhoa.d(-1L), bhoa.e(-1L)));
    case 2: 
      return new biqs(paramContext, biqs.a(parambiql.a(), bhoa.b(-1L), bhoa.a(-1L)));
    case 4: 
      parambiql = (biqp)parambiql;
      return new biqp(paramContext, biqp.a(parambiql.a(), parambiql.a(), paramString, parambiql.b()));
    case 5: 
      parambiql = (biqe)parambiql;
      return new biqe(paramContext, biqe.a(parambiql.a(), paramString, bhoa.f(-1L), parambiql.a(), parambiql.b()));
    case 12: 
      parambiql = (biqj)parambiql;
      return new biqj(paramContext, biqj.a(parambiql.a(), parambiql.a()));
    case 11: 
      parambiql = (biqb)parambiql;
      return new biqb(paramContext, biqb.a(parambiql.a(), parambiql.a(), parambiql.b(), bhoa.h(-1L), bhoa.i(-1L)));
    case 9: 
      parambiql = (biqg)parambiql;
      return new biqg(paramContext, biqg.a(parambiql.a(), parambiql.a(), paramString));
    }
    parambiql = (biqv)parambiql;
    return new biqv(paramContext, biqv.a(parambiql.a(), parambiql.a(), parambiql.b(), paramString));
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
 * Qualified Name:     bios
 * JD-Core Version:    0.7.0.1
 */