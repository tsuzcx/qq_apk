import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkjj
{
  public ArrayList<Integer> a = new ArrayList();
  
  public static bkjj a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new bkjj();
    }
    bkjj localbkjj = new bkjj();
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("black_version_list");
      if (paramString != null)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramString.length())
        {
          localArrayList.add((Integer)paramString.get(i));
          i += 1;
        }
        localbkjj.a = localArrayList;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return localbkjj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkjj
 * JD-Core Version:    0.7.0.1
 */