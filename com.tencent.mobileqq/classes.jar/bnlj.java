import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bnlj
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
  
  public static int a(bnli parambnli)
  {
    int j = 0;
    int i = j;
    switch (parambnli.a)
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
        paramString1 = new bnnc(paramContext, paramString1).a(paramString1);
        paramString1 = new bnnc(paramContext, bnnc.a(i, paramString1[0], paramString2, paramString1[2]));
        continue;
        paramString1 = new bnmt(paramContext, paramString1).a(paramString1);
        paramString1 = new bnmt(paramContext, bnmt.a(i, paramString2, paramString1[1], paramString1[3], paramString1[2]));
        continue;
        paramString1 = new bnmw(paramContext, bnmw.a(i, new bnmw(paramContext, paramString1).a(paramString1)[1]));
        continue;
        paramString1 = new bnmv(paramContext, bnmv.a(i, new bnmv(paramContext, paramString1).a(paramString1)[0], paramString2));
        continue;
        paramString1 = new bnni(paramContext, paramString1).a(paramString1);
        paramString1 = new bnni(paramContext, bnni.a(i, paramString1[0], paramString1[1], paramString2));
      }
    }
  }
  
  public static bnmy a(Context paramContext, String paramString)
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
        return new bnms(paramContext, paramString);
      case 2: 
        return new bnnf(paramContext, paramString);
      case 3: 
        return new bnnd(paramContext, paramString);
      }
    }
    if (localJSONObject == null) {
      return null;
    }
    return new bnnc(paramContext, paramString);
    return new bnmt(paramContext, paramString);
    return new bnnj(paramContext, paramString);
    return new bnmr(paramContext, paramString);
    return new bnmw(paramContext, paramString);
    return new bnmv(paramContext, paramString);
    return new bnni(paramContext, paramString);
    return new bnmq(paramContext, paramString);
  }
  
  public static bnmy a(bnli parambnli, Context paramContext, long paramLong)
  {
    int i = parambnli.a;
    String str2;
    Object localObject;
    String str1;
    switch (i)
    {
    case 8: 
    default: 
      return null;
    case 1: 
      return new bnms(paramContext, bnms.a(i, bmxl.c(paramLong), bmxl.d(paramLong), bmxl.e(paramLong)));
    case 2: 
      return new bnnf(paramContext, bnnf.a(i, bmxl.b(paramLong), bmxl.a(paramLong)));
    case 3: 
      str2 = bmug.b(parambnli);
      parambnli = bmxl.a(paramLong);
      localObject = str2 + File.separator + "eea02a45.ttf";
      str1 = str2 + File.separator + "outsideBorder.png";
      str2 = str2 + File.separator + "insideBorder.png";
      if (QLog.isColorLevel()) {
        QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + (String)localObject);
      }
      return new bnnd(paramContext, bnnd.a(i, parambnli[2], parambnli[3], parambnli[0], parambnli[1], (String)localObject, str1, str2));
    case 4: 
      str1 = bmug.b(parambnli) + File.separator + "Roboto-Condensed.ttf";
      localObject = parambnli.l;
      if (TextUtils.isEmpty(parambnli.l)) {
        localObject = amtj.a(2131704892);
      }
      return new bnnc(paramContext, bnnc.a(i, bmxl.b(paramLong), (String)localObject, str1));
    case 5: 
      localObject = bmug.b(parambnli);
      str1 = (String)localObject + File.separator + "Roboto-Condensed.ttf";
      str2 = (String)localObject + File.separator + "location_icon.png";
      localObject = parambnli.l;
      if (TextUtils.isEmpty(parambnli.l)) {
        localObject = amtj.a(2131704889);
      }
      return new bnmt(paramContext, bnmt.a(i, (String)localObject, bmxl.f(paramLong), str2, str1));
    case 6: 
      String str4 = bmug.b(parambnli);
      localObject = str4 + File.separator + "DINCond-Medium.ttf";
      str1 = str4 + File.separator + parambnli.k + ".apng";
      str2 = str4 + File.separator + "temperatureSymbol.png";
      String str3 = parambnli.j;
      str4 = str4 + File.separator + "line.png";
      int j = parambnli.c;
      if (parambnli.d == 3) {}
      for (boolean bool = true;; bool = false) {
        return new bnnj(paramContext, bnnj.a(i, j, str1, str3, str2, (String)localObject, str4, bool));
      }
    case 7: 
      parambnli = bmug.b(parambnli);
      return new bnmr(paramContext, bnmr.a(i, parambnli + File.separator + "city.bpng"));
    case 12: 
      return new bnmw(paramContext, bnmw.a(i, bmxl.g(paramLong)));
    case 9: 
      str1 = parambnli.l;
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = "YOUR CITY";
      }
      return new bnmv(paramContext, bnmv.a(i, bmug.b(parambnli) + File.separator + "location3_icon_3x.png", (String)localObject));
    case 10: 
      localObject = parambnli.l;
      return new bnni(paramContext, bnni.a(i, bmug.b(parambnli) + File.separator + "location4_icon.png", bmug.b(parambnli) + File.separator + "lantingzhonghei.ttf", (String)localObject));
    }
    return new bnmq(paramContext, bnmq.a(i, bmug.b(parambnli) + File.separator + "up.png", bmug.b(parambnli) + File.separator + "down.png", bmxl.h(paramLong), bmxl.i(paramLong)));
  }
  
  public static bnmy a(bnmy parambnmy, Context paramContext, String paramString)
  {
    switch (parambnmy.a())
    {
    case 3: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return null;
    case 1: 
      return new bnms(paramContext, bnms.a(parambnmy.a(), bmxl.c(-1L), bmxl.d(-1L), bmxl.e(-1L)));
    case 2: 
      return new bnnf(paramContext, bnnf.a(parambnmy.a(), bmxl.b(-1L), bmxl.a(-1L)));
    case 4: 
      parambnmy = (bnnc)parambnmy;
      return new bnnc(paramContext, bnnc.a(parambnmy.a(), parambnmy.a(), paramString, parambnmy.b()));
    case 5: 
      parambnmy = (bnmt)parambnmy;
      return new bnmt(paramContext, bnmt.a(parambnmy.a(), paramString, bmxl.f(-1L), parambnmy.a(), parambnmy.b()));
    case 12: 
      parambnmy = (bnmw)parambnmy;
      return new bnmw(paramContext, bnmw.a(parambnmy.a(), parambnmy.a()));
    case 11: 
      parambnmy = (bnmq)parambnmy;
      return new bnmq(paramContext, bnmq.a(parambnmy.a(), parambnmy.a(), parambnmy.b(), bmxl.h(-1L), bmxl.i(-1L)));
    case 9: 
      parambnmy = (bnmv)parambnmy;
      return new bnmv(paramContext, bnmv.a(parambnmy.a(), parambnmy.a(), paramString));
    }
    parambnmy = (bnni)parambnmy;
    return new bnni(paramContext, bnni.a(parambnmy.a(), parambnmy.a(), parambnmy.b(), paramString));
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
 * Qualified Name:     bnlj
 * JD-Core Version:    0.7.0.1
 */