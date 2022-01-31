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

public class auqx
{
  private static aurh a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Aurh = new auqy();
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
  
  public static void a(Context paramContext, long paramLong, auri paramauri, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    begr localbegr;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbegr = begr.c(paramContext);
      ((DispatchActionMoveScrollView)localbegr.findViewById(2131296387)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131497021, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      auqv localauqv = new auqv(paramContext, 25);
      auqw localauqw1 = new auqw(paramContext, aurc.a, 25);
      auqw localauqw2 = new auqw(paramContext, aurc.b, 25);
      int i = (int)aurc.a(paramLong);
      int j = aurc.a(paramLong);
      int k = aurc.b(paramLong);
      aurh localaurh = jdField_a_of_type_Aurh;
      ((IosTimepicker)localObject).a(paramContext, localbegr, paramauri, null, new BaseAdapter[] { localauqv, localauqw1, localauqw2 }, new int[] { i, j, k }, localaurh);
      if (Build.VERSION.SDK_INT >= 11) {
        localbegr.getWindow().setFlags(16777216, 16777216);
      }
      localbegr.a((View)localObject, null);
      localbegr.setOnDismissListener(new auqz((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbegr.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auqx
 * JD-Core Version:    0.7.0.1
 */