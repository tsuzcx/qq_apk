import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class asmi
{
  public static ashf a(asht paramasht, Context paramContext)
  {
    if (paramasht == null) {}
    while ((paramasht.mGender != 1) && (paramasht.mGender != 2) && (paramasht.mAge == -1)) {
      return null;
    }
    ashf localashf = new ashf();
    int i;
    String str;
    if (paramasht.mGender == 2)
    {
      i = 0;
      localashf.jdField_a_of_type_Int = i;
      if (paramasht.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localashf.jdField_a_of_type_JavaLangString = str;
      if ((paramasht.mGender == 1) || (paramasht.mGender == 2))
      {
        if (paramasht.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130845109);
        label106:
        localashf.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramasht.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localashf.b = paramContext;
        if (paramasht.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramasht = "#33FF80BF";; paramasht = "#3300CAFC")
    {
      localashf.c = paramasht;
      return localashf;
      i = 1;
      break;
      str = String.valueOf(paramasht.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130845110);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<ahbt> a(Context paramContext, JSONArray paramJSONArray)
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
            ahbt localahbt = new ahbt();
            localahbt.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localahbt.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localahbt.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localahbt.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localahbt);
            }
            else
            {
              j = localahbt.jdField_a_of_type_JavaLangCharSequence.charAt(0);
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
  
  public static List<ashf> a(asht paramasht, Context paramContext)
  {
    if (paramasht == null) {
      return null;
    }
    if ((paramasht.mLabelInfos == null) || (paramasht.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    int i = 0;
    while (i < paramasht.mLabelInfos.size())
    {
      ashf localashf = new ashf();
      localashf.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localashf.jdField_a_of_type_Int = 3;
      localashf.jdField_a_of_type_JavaLangString = ((ashu)paramasht.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localashf.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localashf.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localashf.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localashf.b = arrayOfString[(j % arrayOfString.length)];
          localashf.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localashf);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static ashf b(asht paramasht, Context paramContext)
  {
    if (paramasht == null) {
      return null;
    }
    ashf localashf = new ashf();
    localashf.jdField_a_of_type_Int = 2;
    localashf.jdField_a_of_type_JavaLangString = String.valueOf(paramasht.mPopularity);
    localashf.b = "#8173FF";
    localashf.c = "#338173FF";
    localashf.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845111);
    return localashf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmi
 * JD-Core Version:    0.7.0.1
 */