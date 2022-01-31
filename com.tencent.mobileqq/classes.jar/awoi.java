import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class awoi
{
  public int a;
  public Bitmap a;
  public String a;
  public int b;
  public Bitmap b;
  public String b;
  public Bitmap c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public awoi(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static awoi a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = a(paramString);
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PraiseInfo", 2, "content:" + paramString);
        }
        paramString = new JSONObject(paramString);
        awoi localawoi = new awoi(paramInt);
        localawoi.jdField_a_of_type_JavaLangString = paramString.optString("name");
        localawoi.jdField_b_of_type_JavaLangString = paramString.optString("text");
        if (paramString.has("color"))
        {
          String str = paramString.optString("color").trim();
          paramString = str;
          if (str.startsWith("0x")) {
            paramString = str.substring(2);
          }
        }
        try
        {
          localawoi.jdField_b_of_type_Int = Color.parseColor("#" + paramString);
          return localawoi;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PraiseInfo", 2, "color invalid");
            }
          }
        }
        return null;
      }
      catch (JSONException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with JsonException.", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        QLog.e("PraiseInfo", 1, "parsePraiseInfo failed with IOException.", paramString);
      }
    }
  }
  
  private static String a(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      QLog.e("PraiseInfo", 1, paramString + " not exist!");
    }
    do
    {
      return null;
      try
      {
        paramString = bdcs.b(localFile);
        return paramString;
      }
      catch (OutOfMemoryError paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PraiseInfo", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awoi
 * JD-Core Version:    0.7.0.1
 */