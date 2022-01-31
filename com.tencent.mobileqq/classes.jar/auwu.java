import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class auwu
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
  
  public auwu(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static auwu a(int paramInt, String paramString)
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
        auwu localauwu = new auwu(paramInt);
        localauwu.jdField_a_of_type_JavaLangString = paramString.optString("name");
        localauwu.jdField_b_of_type_JavaLangString = paramString.optString("text");
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
          localauwu.jdField_b_of_type_Int = Color.parseColor("#" + paramString);
          return localauwu;
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
        paramString = bbdj.b(localFile);
        return paramString;
      }
      catch (OutOfMemoryError paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("PraiseInfo", 2, paramString.getMessage());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwu
 * JD-Core Version:    0.7.0.1
 */