import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class bake
{
  private static bako a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Bako = new bakf();
  }
  
  public static int a(Context paramContext, String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3, int[] paramArrayOfInt)
  {
    return -9;
  }
  
  public static Long a(String paramString)
  {
    long l2 = new Date().getTime() / 1000L;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      return Long.valueOf(l1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(c, 2, "getLong error: " + paramString.getMessage());
          paramString.printStackTrace();
          l1 = l2;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      do
      {
        paramString1 = str;
      } while (!QLog.isColorLevel());
      QLog.d(c, 2, "getString from json error:" + paramString2.getMessage());
    }
    return "";
  }
  
  public static void a(Context paramContext, long paramLong, bakp parambakp, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    bkho localbkho;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbkho = bkho.c(paramContext);
      ((DispatchActionMoveScrollView)localbkho.findViewById(2131361980)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131563078, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      bakc localbakc = new bakc(paramContext, 25);
      bakd localbakd1 = new bakd(paramContext, bakj.a, 25);
      bakd localbakd2 = new bakd(paramContext, bakj.b, 25);
      int i = (int)bakj.a(paramLong);
      int j = bakj.a(paramLong);
      int k = bakj.b(paramLong);
      bako localbako = jdField_a_of_type_Bako;
      ((IosTimepicker)localObject).a(paramContext, localbkho, parambakp, null, new BaseAdapter[] { localbakc, localbakd1, localbakd2 }, new int[] { i, j, k }, localbako);
      if (Build.VERSION.SDK_INT >= 11) {
        localbkho.getWindow().setFlags(16777216, 16777216);
      }
      localbkho.a((View)localObject, null);
      localbkho.setOnDismissListener(new bakg((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbkho.show();
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(c, 2, paramContext.getMessage());
    }
  }
  
  public static boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bake
 * JD-Core Version:    0.7.0.1
 */