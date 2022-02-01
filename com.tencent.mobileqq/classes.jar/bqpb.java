import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bqpb
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
  
  public static int a(bqpa parambqpa)
  {
    int j = 0;
    int i = j;
    switch (parambqpa.a)
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
        paramString1 = new bqqy(paramContext, paramString1).a(paramString1);
        paramString1 = new bqqy(paramContext, bqqy.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bqqn(paramContext, paramString1).a(paramString1);
        paramString1 = new bqqn(paramContext, bqqn.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bqqs(paramContext, bqqs.a(i, new bqqs(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bqqp(paramContext, bqqp.a(i, new bqqp(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bqre(paramContext, paramString1).a(paramString1);
        paramString1 = new bqre(paramContext, bqre.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bqqu a(Context paramContext, String paramString)
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
        return new bqqm(paramContext, paramString);
      case 2: 
        return new bqrb(paramContext, paramString);
      case 3: 
        return new bqqz(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bqqy(paramContext, paramString);
    return new bqqn(paramContext, paramString);
    return new bqrf(paramContext, paramString);
    return new bqql(paramContext, paramString);
    return new bqqs(paramContext, paramString);
    return new bqqp(paramContext, paramString);
    return new bqre(paramContext, paramString);
    return new bqqk(paramContext, paramString);
  }
  
  public static bqqu a(bqpa parambqpa, Context paramContext, long paramLong)
  {
    int i = parambqpa.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bqqm(paramContext, bqqm.a(i, bpuf.c(paramLong), bpuf.d(paramLong), bpuf.e(paramLong)));
    case 2: 
      return new bqrb(paramContext, bqrb.a(i, bpuf.b(paramLong), bpuf.a(paramLong)));
    case 3: 
      str2 = bpqn.b(parambqpa);
      parambqpa = bpuf.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bqqz(paramContext, bqqz.a(i, parambqpa[2], parambqpa[3], parambqpa[0], parambqpa[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bpqn.b(parambqpa) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambqpa.l;
      if (TextUtils.isEmpty(parambqpa.l)) {
        localObject = anzj.a(2131704662);
      }
      return new bqqy(paramContext, bqqy.a(i, bpuf.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bpqn.b(parambqpa);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambqpa.l;
      if (TextUtils.isEmpty(parambqpa.l)) {
        localObject = anzj.a(2131704659);
      }
      return new bqqn(paramContext, bqqn.a(i, (String)localObject, bpuf.f(paramLong), str2, str1));
    case 6: 
      String str4 = bpqn.b(parambqpa);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambqpa.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambqpa.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambqpa.c;
      if (parambqpa.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bqrf(paramContext, bqrf.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambqpa = bpqn.b(parambqpa);
      return new bqql(paramContext, bqql.a(i, parambqpa + File.separator + "city.bpng"));
    case 12: 
      return new bqqs(paramContext, bqqs.a(i, bpuf.g(paramLong)));
    case 9: 
      str1 = parambqpa.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bqqp(paramContext, bqqp.a(i, bpqn.b(parambqpa) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambqpa.l;
      return new bqre(paramContext, bqre.a(i, bpqn.b(parambqpa) + File.separator + "location4_icon.png", bpqn.b(parambqpa) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bqqk(paramContext, bqqk.a(i, bpqn.b(parambqpa) + File.separator + "up.png", bpqn.b(parambqpa) + File.separator + "down.png", bpuf.h(paramLong), bpuf.i(paramLong)));
  }
  
  public static bqqu a(bqqu parambqqu, Context paramContext, String paramString)
  {
    switch (parambqqu.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bqqm(paramContext, bqqm.a(parambqqu.a(), bpuf.c(-1L), bpuf.d(-1L), bpuf.e(-1L)));
    case 2: 
      return new bqrb(paramContext, bqrb.a(parambqqu.a(), bpuf.b(-1L), bpuf.a(-1L)));
    case 4: 
      parambqqu = (bqqy)parambqqu;
      return new bqqy(paramContext, bqqy.a(parambqqu.a(), parambqqu.a(), paramString, parambqqu.b()));
    case 5: 
      parambqqu = (bqqn)parambqqu;
      return new bqqn(paramContext, bqqn.a(parambqqu.a(), paramString, bpuf.f(-1L), parambqqu.a(), parambqqu.b()));
    case 12: 
      parambqqu = (bqqs)parambqqu;
      return new bqqs(paramContext, bqqs.a(parambqqu.a(), parambqqu.a()));
    case 11: 
      parambqqu = (bqqk)parambqqu;
      return new bqqk(paramContext, bqqk.a(parambqqu.a(), parambqqu.a(), parambqqu.b(), bpuf.h(-1L), bpuf.i(-1L)));
    case 9: 
      parambqqu = (bqqp)parambqqu;
      return new bqqp(paramContext, bqqp.a(parambqqu.a(), parambqqu.a(), paramString));
    }
    parambqqu = (bqre)parambqqu;
    return new bqre(paramContext, bqre.a(parambqqu.a(), parambqqu.a(), parambqqu.b(), paramString));
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
 * Qualified Name:     bqpb
 * JD-Core Version:    0.7.0.1
 */