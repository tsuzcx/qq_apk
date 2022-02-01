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

public class bbcx
{
  private static bbdh a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Bbdh = new bbcy();
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
  
  public static void a(Context paramContext, long paramLong, bbdi parambbdi, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    blir localblir;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localblir = blir.c(paramContext);
      ((DispatchActionMoveScrollView)localblir.findViewById(2131361980)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131563114, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      bbcv localbbcv = new bbcv(paramContext, 25);
      bbcw localbbcw1 = new bbcw(paramContext, bbdc.a, 25);
      bbcw localbbcw2 = new bbcw(paramContext, bbdc.b, 25);
      int i = (int)bbdc.a(paramLong);
      int j = bbdc.a(paramLong);
      int k = bbdc.b(paramLong);
      bbdh localbbdh = jdField_a_of_type_Bbdh;
      ((IosTimepicker)localObject).a(paramContext, localblir, parambbdi, null, new BaseAdapter[] { localbbcv, localbbcw1, localbbcw2 }, new int[] { i, j, k }, localbbdh);
      if (Build.VERSION.SDK_INT >= 11) {
        localblir.getWindow().setFlags(16777216, 16777216);
      }
      localblir.a((View)localObject, null);
      localblir.setOnDismissListener(new bbcz((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localblir.show();
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
 * Qualified Name:     bbcx
 * JD-Core Version:    0.7.0.1
 */