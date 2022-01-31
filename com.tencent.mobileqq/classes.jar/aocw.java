import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class aocw
  extends anyh
{
  public static HashMap<String, List<Integer>> a;
  public static final int[] a;
  private static boolean jdField_b_of_type_Boolean;
  private static int[] jdField_b_of_type_ArrayOfInt = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 112, 116, 118, 119, 120, 123, 130, 140, 141, 180, 184, 176, 177, 182, 179, 185, 143, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 214, 215, 216, 187, 209, 198, 186, 189, 212, 188, 190, 201, 210, 191, 197, 203, 205, 193, 194, 211, 204, 192, 207, 213, 202, 196, 208, 200, 206, 195, 199 };
  private static int[] c;
  public int a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216 };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(214));
    localArrayList.add(Integer.valueOf(215));
    localArrayList.add(Integer.valueOf(216));
    jdField_a_of_type_JavaUtilHashMap.put("8.0.0", localArrayList);
  }
  
  public static List<anyh> a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      aocw localaocw = new aocw();
      localaocw.jdField_a_of_type_Int = paramArrayOfInt[i];
      localaocw.jdField_c_of_type_Int = 1;
      localArrayList.add(localaocw);
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    if ((!paramBoolean) && (jdField_b_of_type_Boolean)) {
      return true;
    }
    paramAppRuntime = VasQuickUpdateManager.getJSONFromLocal(paramAppRuntime, "emoji.systemEmojiWhiteList.json", true, null);
    if (paramAppRuntime != null) {}
    for (;;)
    {
      int j;
      try
      {
        Object localObject = paramAppRuntime.optJSONArray("systemEmojiWhiteList").optJSONObject(0).optJSONArray("androidEmoticonWhiteList");
        paramAppRuntime = new int[((JSONArray)localObject).length()];
        int m = ((JSONArray)localObject).length();
        j = 0;
        int i = 0;
        if (j < m)
        {
          int n = ((JSONArray)localObject).optInt(j, -1);
          if ((n < 0) || (n >= ayjy.jdField_a_of_type_Int)) {
            break label218;
          }
          int k = i + 1;
          paramAppRuntime[i] = n;
          i = k;
          break label218;
        }
        if (i == 0)
        {
          QLog.e("SystemEmoticonInfo", 1, "parseWhiteList no valid emoticon, use default");
          return true;
        }
        localObject = Arrays.copyOf(paramAppRuntime, i);
        if (QLog.isColorLevel()) {
          QLog.d("SystemEmoticonInfo", 2, "newOrderList: " + Arrays.toString((int[])localObject));
        }
        paramAppRuntime = Arrays.copyOf(paramAppRuntime, i);
        Arrays.sort(paramAppRuntime);
        jdField_b_of_type_ArrayOfInt = (int[])localObject;
        jdField_c_of_type_ArrayOfInt = paramAppRuntime;
        jdField_b_of_type_Boolean = true;
      }
      catch (Throwable paramAppRuntime)
      {
        QLog.e("SystemEmoticonInfo", 2, "parseWhiteList error", paramAppRuntime);
        continue;
      }
      return jdField_b_of_type_Boolean;
      if (QLog.isColorLevel())
      {
        QLog.d("SystemEmoticonInfo", 2, "parseWhiteList: local file not exist.");
        continue;
        label218:
        j += 1;
      }
    }
  }
  
  public static int[] a()
  {
    return jdField_b_of_type_ArrayOfInt;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return aylc.a(this.jdField_a_of_type_Int, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.d == 1) {
      axqy.b(null, "CliOper", "", "", "0X8005507", "0X8005507", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      int i = paramEditText.getSelectionStart();
      int j = paramEditText.getSelectionEnd();
      paramEditText.getEditableText().replace(i, j, aylc.c(this.jdField_a_of_type_Int));
      paramEditText.requestFocus();
      return;
      if (this.d == 2) {
        axqy.b(null, "CliOper", "", "", "0X8005508", "0X8005508", 0, 0, "", "", "", "");
      }
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return aylc.a(this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocw
 * JD-Core Version:    0.7.0.1
 */