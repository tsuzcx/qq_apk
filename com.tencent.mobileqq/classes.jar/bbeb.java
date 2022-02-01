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

public class bbeb
{
  private static bbel a;
  public static String a;
  public static boolean a;
  public static String b;
  private static String c = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Bbel = new bbec();
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
  
  public static void a(Context paramContext, long paramLong, bbem parambbem, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    bkzi localbkzi;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localbkzi = bkzi.c(paramContext);
      ((DispatchActionMoveScrollView)localbkzi.findViewById(2131361981)).dispatchActionMove = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2131563076, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      bbdz localbbdz = new bbdz(paramContext, 25);
      bbea localbbea1 = new bbea(paramContext, bbeg.a, 25);
      bbea localbbea2 = new bbea(paramContext, bbeg.b, 25);
      int i = (int)bbeg.a(paramLong);
      int j = bbeg.a(paramLong);
      int k = bbeg.b(paramLong);
      bbel localbbel = jdField_a_of_type_Bbel;
      ((IosTimepicker)localObject).a(paramContext, localbkzi, parambbem, null, new BaseAdapter[] { localbbdz, localbbea1, localbbea2 }, new int[] { i, j, k }, localbbel);
      if (Build.VERSION.SDK_INT >= 11) {
        localbkzi.getWindow().setFlags(16777216, 16777216);
      }
      localbkzi.a((View)localObject, null);
      localbkzi.setOnDismissListener(new bbed((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localbkzi.show();
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
 * Qualified Name:     bbeb
 * JD-Core Version:    0.7.0.1
 */