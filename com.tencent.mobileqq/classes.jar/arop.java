import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arop
{
  public static ariw a(arjk paramarjk, Context paramContext)
  {
    if (paramarjk == null) {}
    while ((paramarjk.mGender != 1) && (paramarjk.mGender != 2) && (paramarjk.mAge == -1)) {
      return null;
    }
    ariw localariw = new ariw();
    int i;
    String str;
    if (paramarjk.mGender == 2)
    {
      i = 0;
      localariw.jdField_a_of_type_Int = i;
      if (paramarjk.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localariw.jdField_a_of_type_JavaLangString = str;
      if ((paramarjk.mGender == 1) || (paramarjk.mGender == 2))
      {
        if (paramarjk.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130845011);
        label106:
        localariw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramarjk.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localariw.b = paramContext;
        if (paramarjk.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramarjk = "#33FF80BF";; paramarjk = "#3300CAFC")
    {
      localariw.c = paramarjk;
      return localariw;
      i = 1;
      break;
      str = String.valueOf(paramarjk.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130845012);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<aghr> a(Context paramContext, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
        paramContext = paramContext.getResources().getStringArray(2130968659);
        int k = paramJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            aghr localaghr = new aghr();
            localaghr.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localaghr.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localaghr.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localaghr.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localaghr);
            }
            else
            {
              j = localaghr.jdField_a_of_type_JavaLangCharSequence.charAt(0);
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramContext) {}
      i += 1;
    }
  }
  
  public static List<ariw> a(arjk paramarjk, Context paramContext)
  {
    if (paramarjk == null) {
      return null;
    }
    if ((paramarjk.mLabelInfos == null) || (paramarjk.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    int i = 0;
    while (i < paramarjk.mLabelInfos.size())
    {
      ariw localariw = new ariw();
      localariw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localariw.jdField_a_of_type_Int = 3;
      localariw.jdField_a_of_type_JavaLangString = ((arjl)paramarjk.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localariw.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localariw.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localariw.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localariw.b = arrayOfString[(j % arrayOfString.length)];
          localariw.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localariw);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static ariw b(arjk paramarjk, Context paramContext)
  {
    if (paramarjk == null) {
      return null;
    }
    ariw localariw = new ariw();
    localariw.jdField_a_of_type_Int = 2;
    localariw.jdField_a_of_type_JavaLangString = String.valueOf(paramarjk.mPopularity);
    localariw.b = "#8173FF";
    localariw.c = "#338173FF";
    localariw.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845013);
    return localariw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arop
 * JD-Core Version:    0.7.0.1
 */