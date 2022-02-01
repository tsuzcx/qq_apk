import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class assv
{
  public static asnc a(asnq paramasnq, Context paramContext)
  {
    if (paramasnq == null) {}
    while ((paramasnq.mGender != 1) && (paramasnq.mGender != 2) && (paramasnq.mAge == -1)) {
      return null;
    }
    asnc localasnc = new asnc();
    int i;
    String str;
    if (paramasnq.mGender == 2)
    {
      i = 0;
      localasnc.jdField_a_of_type_Int = i;
      if (paramasnq.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localasnc.jdField_a_of_type_JavaLangString = str;
      if ((paramasnq.mGender == 1) || (paramasnq.mGender == 2))
      {
        if (paramasnq.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130845085);
        label106:
        localasnc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramasnq.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localasnc.b = paramContext;
        if (paramasnq.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramasnq = "#33FF80BF";; paramasnq = "#3300CAFC")
    {
      localasnc.c = paramasnq;
      return localasnc;
      i = 1;
      break;
      str = String.valueOf(paramasnq.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130845086);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<ahai> a(Context paramContext, JSONArray paramJSONArray)
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
            ahai localahai = new ahai();
            localahai.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localahai.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localahai.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localahai.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localahai);
            }
            else
            {
              j = localahai.jdField_a_of_type_JavaLangCharSequence.charAt(0);
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
  
  public static List<asnc> a(asnq paramasnq, Context paramContext)
  {
    if (paramasnq == null) {
      return null;
    }
    if ((paramasnq.mLabelInfos == null) || (paramasnq.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
    paramContext = paramContext.getResources().getStringArray(2130968659);
    int i = 0;
    while (i < paramasnq.mLabelInfos.size())
    {
      asnc localasnc = new asnc();
      localasnc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localasnc.jdField_a_of_type_Int = 3;
      localasnc.jdField_a_of_type_JavaLangString = ((asnr)paramasnq.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localasnc.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localasnc.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localasnc.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localasnc.b = arrayOfString[(j % arrayOfString.length)];
          localasnc.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localasnc);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static asnc b(asnq paramasnq, Context paramContext)
  {
    if (paramasnq == null) {
      return null;
    }
    asnc localasnc = new asnc();
    localasnc.jdField_a_of_type_Int = 2;
    localasnc.jdField_a_of_type_JavaLangString = String.valueOf(paramasnq.mPopularity);
    localasnc.b = "#8173FF";
    localasnc.c = "#338173FF";
    localasnc.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845087);
    return localasnc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assv
 * JD-Core Version:    0.7.0.1
 */