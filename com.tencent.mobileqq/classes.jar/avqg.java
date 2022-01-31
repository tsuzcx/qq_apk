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

public class avqg
{
  private static avqq a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Avqq = new avqh();
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
  
  public static void a(Context paramContext, long paramLong, avqr paramavqr, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    bfol localbfol;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbfol = bfol.c(paramContext);
      ((DispatchActionMoveScrollView)localbfol.findViewById(2131361923)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131562618, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      avqe localavqe = new avqe(paramContext, 25);
      avqf localavqf1 = new avqf(paramContext, avql.a, 25);
      avqf localavqf2 = new avqf(paramContext, avql.b, 25);
      int i = (int)avql.a(paramLong);
      int j = avql.a(paramLong);
      int k = avql.b(paramLong);
      avqq localavqq = jdField_a_of_type_Avqq;
      ((IosTimepicker)localObject).a(paramContext, localbfol, paramavqr, null, new BaseAdapter[] { localavqe, localavqf1, localavqf2 }, new int[] { i, j, k }, localavqq);
      if (Build.VERSION.SDK_INT >= 11) {
        localbfol.getWindow().setFlags(16777216, 16777216);
      }
      localbfol.a((View)localObject, null);
      localbfol.setOnDismissListener(new avqi((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbfol.show();
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
 * Qualified Name:     avqg
 * JD-Core Version:    0.7.0.1
 */