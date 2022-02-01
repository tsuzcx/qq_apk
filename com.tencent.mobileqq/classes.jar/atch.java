import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class atch
{
  public static aswt a(asxh paramasxh, Context paramContext)
  {
    if (paramasxh == null) {}
    while ((paramasxh.mGender != 1) && (paramasxh.mGender != 2) && (paramasxh.mAge == -1)) {
      return null;
    }
    aswt localaswt = new aswt();
    int i;
    String str;
    if (paramasxh.mGender == 2)
    {
      i = 0;
      localaswt.jdField_a_of_type_Int = i;
      if (paramasxh.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localaswt.jdField_a_of_type_JavaLangString = str;
      if ((paramasxh.mGender == 1) || (paramasxh.mGender == 2))
      {
        if (paramasxh.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130845124);
        label106:
        localaswt.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramasxh.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localaswt.b = paramContext;
        if (paramasxh.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramasxh = "#33FF80BF";; paramasxh = "#3300CAFC")
    {
      localaswt.c = paramasxh;
      return localaswt;
      i = 1;
      break;
      str = String.valueOf(paramasxh.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130845125);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<ahlf> a(Context paramContext, JSONArray paramJSONArray)
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
            ahlf localahlf = new ahlf();
            localahlf.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localahlf.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localahlf.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localahlf.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localahlf);
            }
            else
            {
              j = localahlf.jdField_a_of_type_JavaLangCharSequence.charAt(0);
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
  
  public static List<aswt> a(asxh paramasxh, Context paramContext)
  {
    if (paramasxh == null) {
      return null;
    }
    if ((paramasxh.mLabelInfos == null) || (paramasxh.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    int i = 0;
    while (i < paramasxh.mLabelInfos.size())
    {
      aswt localaswt = new aswt();
      localaswt.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localaswt.jdField_a_of_type_Int = 3;
      localaswt.jdField_a_of_type_JavaLangString = ((asxi)paramasxh.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localaswt.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localaswt.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localaswt.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localaswt.b = arrayOfString[(j % arrayOfString.length)];
          localaswt.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localaswt);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static aswt b(asxh paramasxh, Context paramContext)
  {
    if (paramasxh == null) {
      return null;
    }
    aswt localaswt = new aswt();
    localaswt.jdField_a_of_type_Int = 2;
    localaswt.jdField_a_of_type_JavaLangString = String.valueOf(paramasxh.mPopularity);
    localaswt.b = "#8173FF";
    localaswt.c = "#338173FF";
    localaswt.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845126);
    return localaswt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atch
 * JD-Core Version:    0.7.0.1
 */