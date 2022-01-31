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

public class axmp
{
  private static axmz a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Axmz = new axmq();
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
  
  public static void a(Context paramContext, long paramLong, axna paramaxna, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    bhuf localbhuf;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbhuf = bhuf.c(paramContext);
      ((DispatchActionMoveScrollView)localbhuf.findViewById(2131361924)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131562839, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      axmn localaxmn = new axmn(paramContext, 25);
      axmo localaxmo1 = new axmo(paramContext, axmu.a, 25);
      axmo localaxmo2 = new axmo(paramContext, axmu.b, 25);
      int i = (int)axmu.a(paramLong);
      int j = axmu.a(paramLong);
      int k = axmu.b(paramLong);
      axmz localaxmz = jdField_a_of_type_Axmz;
      ((IosTimepicker)localObject).a(paramContext, localbhuf, paramaxna, null, new BaseAdapter[] { localaxmn, localaxmo1, localaxmo2 }, new int[] { i, j, k }, localaxmz);
      if (Build.VERSION.SDK_INT >= 11) {
        localbhuf.getWindow().setFlags(16777216, 16777216);
      }
      localbhuf.a((View)localObject, null);
      localbhuf.setOnDismissListener(new axmr((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbhuf.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axmp
 * JD-Core Version:    0.7.0.1
 */