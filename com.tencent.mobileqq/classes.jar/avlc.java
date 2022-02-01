import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class avlc
{
  public static int a(int paramInt)
  {
    if (paramInt <= 0) {
      return 0;
    }
    return Math.abs(new Random().nextInt(paramInt));
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return -1;
      } while (!paramString.contains("rscType"));
      i = paramString.indexOf("rscType") + "rscType".length() + 1;
    } while (i + 1 >= paramString.length());
    paramString = paramString.substring(i, i + 1);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private avlf a(String paramString1, String paramString2)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      localavlf = new avlf();
      try
      {
        paramString1 = new JSONObject(paramString1);
        if (paramString1.has("num")) {
          localavlf.jdField_a_of_type_Int = paramString1.getInt("num");
        }
        if (paramString1.has("process_frame"))
        {
          localObject = paramString1.getJSONObject("process_frame");
          if (((JSONObject)localObject).has("repeat")) {
            localavlf.jdField_b_of_type_Int = ((JSONObject)localObject).getInt("repeat");
          }
          if (((JSONObject)localObject).has("frame_delay")) {
            localavlf.c = ((JSONObject)localObject).getInt("frame_delay");
          }
          localObject = ((JSONObject)localObject).getJSONArray("seq_array");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            localavlf.jdField_a_of_type_ArrayOfJavaLangString = new String[((JSONArray)localObject).length()];
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              localavlf.jdField_a_of_type_ArrayOfJavaLangString[i] = (EmoticonUtils.pngFramePath.replace("[epId]", paramString2) + ((JSONArray)localObject).getString(i));
              i += 1;
            }
          }
        }
        Object localObject = paramString1.getJSONArray("result_frame");
        paramString1 = localavlf;
        if (localObject == null) {
          continue;
        }
        paramString1 = localavlf;
        if (((JSONArray)localObject).length() <= 0) {
          continue;
        }
        localavlf.jdField_b_of_type_ArrayOfJavaLangString = new String[((JSONArray)localObject).length()];
        int i = j;
        for (;;)
        {
          paramString1 = localavlf;
          if (i >= ((JSONArray)localObject).length()) {
            break;
          }
          localavlf.jdField_b_of_type_ArrayOfJavaLangString[i] = (EmoticonUtils.pngFramePath.replace("[epId]", paramString2) + ((JSONArray)localObject).getString(i));
          i += 1;
        }
        return localavlf;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(EmoticonUtils.pngFramePath.replace("[epId]", paramString));
    localStringBuffer.append("config.json");
    paramString = new File(localStringBuffer.toString());
    if (!paramString.exists()) {
      return null;
    }
    return FileUtils.readFileContent(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + paramString.getAbsolutePath() + "].");
      }
      return false;
    }
    Object localObject1 = new File(paramString, "config.json");
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + ((File)localObject1).getAbsolutePath() + "].");
      }
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(FileUtils.readFileContent((File)localObject1));
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("process_frame");
        if (((JSONObject)localObject2).has("seq_array"))
        {
          localObject2 = ((JSONObject)localObject2).getJSONArray("seq_array");
          if (((JSONArray)localObject2).length() > 0)
          {
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              File localFile = new File(paramString, (String)((JSONArray)localObject2).get(i));
              if (localFile.exists()) {
                break label383;
              }
              if (!QLog.isColorLevel()) {
                break label381;
              }
              QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + localFile.getAbsolutePath() + "].");
              break label381;
            }
          }
        }
        localObject1 = ((JSONObject)localObject1).getJSONArray("result_frame");
        if (((JSONArray)localObject1).length() > 0)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = new File(paramString, (String)((JSONArray)localObject1).get(i));
            if (!((File)localObject2).exists())
            {
              if (QLog.isColorLevel()) {
                QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + ((File)localObject2).getAbsolutePath() + "].");
              }
              return false;
            }
            i += 1;
            continue;
          }
        }
        return true;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PngFrameUtil", 2, "func checkRandomPngExist, exception:" + paramString.getMessage());
        }
        return false;
      }
      label381:
      return false;
      label383:
      i += 1;
    }
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      do
      {
        return 0;
      } while (!paramString.contains("value"));
      i = paramString.indexOf("value") + "value".length() + 1;
    } while (i >= paramString.length());
    paramString = paramString.substring(i);
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public int a(File paramFile)
  {
    paramFile = FileUtils.readFileContent(paramFile);
    if (!TextUtils.isEmpty(paramFile)) {
      try
      {
        paramFile = new JSONObject(paramFile);
        if (paramFile.has("rscType"))
        {
          int i = paramFile.getInt("rscType");
          if (QLog.isColorLevel()) {
            QLog.d("PngFrameUtil", 2, "func getRscType(from local json file),type:" + i);
          }
          return i;
        }
        return 0;
      }
      catch (JSONException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    return 0;
  }
  
  public avlf a(String paramString)
  {
    return a(a(paramString), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avlc
 * JD-Core Version:    0.7.0.1
 */