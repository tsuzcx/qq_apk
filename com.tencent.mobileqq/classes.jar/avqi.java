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

public class avqi
{
  private static avqs a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Avqs = new avqj();
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
  
  public static void a(Context paramContext, long paramLong, avqt paramavqt, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    bfpc localbfpc;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbfpc = bfpc.c(paramContext);
      ((DispatchActionMoveScrollView)localbfpc.findViewById(2131361922)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131562617, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      avqg localavqg = new avqg(paramContext, 25);
      avqh localavqh1 = new avqh(paramContext, avqn.a, 25);
      avqh localavqh2 = new avqh(paramContext, avqn.b, 25);
      int i = (int)avqn.a(paramLong);
      int j = avqn.a(paramLong);
      int k = avqn.b(paramLong);
      avqs localavqs = jdField_a_of_type_Avqs;
      ((IosTimepicker)localObject).a(paramContext, localbfpc, paramavqt, null, new BaseAdapter[] { localavqg, localavqh1, localavqh2 }, new int[] { i, j, k }, localavqs);
      if (Build.VERSION.SDK_INT >= 11) {
        localbfpc.getWindow().setFlags(16777216, 16777216);
      }
      localbfpc.a((View)localObject, null);
      localbfpc.setOnDismissListener(new avqk((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbfpc.show();
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
 * Qualified Name:     avqi
 * JD-Core Version:    0.7.0.1
 */