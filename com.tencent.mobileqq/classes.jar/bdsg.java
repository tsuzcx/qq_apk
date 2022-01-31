import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class bdsg
  extends bdrz
{
  public static bdsg a = new bdsg();
  
  public static String a(Context paramContext, int paramInt)
  {
    paramContext = a.getDir(paramContext, "specialRing." + paramInt);
    return paramContext + File.separator + paramInt + ".wav";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, bdpj parambdpj, boolean paramBoolean)
  {
    a.download(paramQQAppInterface, "specialRing." + paramInt, parambdpj, paramBoolean);
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    Object localObject = "specialRing." + paramInt;
    paramContext = a.getDir(paramContext, (String)localObject);
    if (!new File(paramContext).exists()) {
      return false;
    }
    localObject = new String[3];
    localObject[0] = ".wav";
    localObject[1] = ".json";
    localObject[2] = ".jpg";
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      if (!new File(paramContext, paramInt + str).exists())
      {
        QLog.e("RingUpdateCallback", 1, "missing: " + paramInt + str);
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    paramContext = a.getDir(paramContext, "specialRing." + paramInt);
    paramContext = bdcs.a(new File(paramContext + File.separator + paramInt + ".json"));
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = new JSONObject(paramContext).optString("name", null);
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        QLog.e("RingUpdateCallback", 1, "getName error", paramContext);
        return null;
      }
    }
    QLog.e("RingUpdateCallback", 1, "getName missing json: " + paramInt);
    return null;
  }
  
  public long getBID()
  {
    return 37L;
  }
  
  protected String getRootDir()
  {
    return "ring";
  }
  
  protected String getScidPrefix()
  {
    return "specialRing.";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsg
 * JD-Core Version:    0.7.0.1
 */