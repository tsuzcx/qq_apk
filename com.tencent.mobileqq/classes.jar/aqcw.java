import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqcw
{
  public static apya a(apyo paramapyo, Context paramContext)
  {
    if (paramapyo == null) {}
    while ((paramapyo.mGender != 1) && (paramapyo.mGender != 2) && (paramapyo.mAge == -1)) {
      return null;
    }
    apya localapya = new apya();
    int i;
    String str;
    if (paramapyo.mGender == 2)
    {
      i = 0;
      localapya.jdField_a_of_type_Int = i;
      if (paramapyo.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localapya.jdField_a_of_type_JavaLangString = str;
      if ((paramapyo.mGender == 1) || (paramapyo.mGender == 2))
      {
        if (paramapyo.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130844640);
        label106:
        localapya.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramapyo.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localapya.b = paramContext;
        if (paramapyo.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramapyo = "#33FF80BF";; paramapyo = "#3300CAFC")
    {
      localapya.c = paramapyo;
      return localapya;
      i = 1;
      break;
      str = String.valueOf(paramapyo.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130844641);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<afpy> a(Context paramContext, JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        String[] arrayOfString = paramContext.getResources().getStringArray(2130968658);
        paramContext = paramContext.getResources().getStringArray(2130968657);
        int k = paramJSONArray.length();
        i = 0;
        if (i < k)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null)
          {
            afpy localafpy = new afpy();
            localafpy.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localafpy.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localafpy.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localafpy.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localafpy);
            }
            else
            {
              j = localafpy.jdField_a_of_type_JavaLangCharSequence.charAt(0);
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
  
  public static List<apya> a(apyo paramapyo, Context paramContext)
  {
    if (paramapyo == null) {
      return null;
    }
    if ((paramapyo.mLabelInfos == null) || (paramapyo.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968658);
    paramContext = paramContext.getResources().getStringArray(2130968657);
    int i = 0;
    while (i < paramapyo.mLabelInfos.size())
    {
      apya localapya = new apya();
      localapya.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localapya.jdField_a_of_type_Int = 3;
      localapya.jdField_a_of_type_JavaLangString = ((apyp)paramapyo.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localapya.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localapya.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localapya.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localapya.b = arrayOfString[(j % arrayOfString.length)];
          localapya.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localapya);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static apya b(apyo paramapyo, Context paramContext)
  {
    if (paramapyo == null) {
      return null;
    }
    apya localapya = new apya();
    localapya.jdField_a_of_type_Int = 2;
    localapya.jdField_a_of_type_JavaLangString = String.valueOf(paramapyo.mPopularity);
    localapya.b = "#8173FF";
    localapya.c = "#338173FF";
    localapya.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844642);
    return localapya;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcw
 * JD-Core Version:    0.7.0.1
 */