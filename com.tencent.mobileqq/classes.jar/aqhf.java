import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqhf
{
  public static aqcj a(aqcx paramaqcx, Context paramContext)
  {
    if (paramaqcx == null) {}
    while ((paramaqcx.mGender != 1) && (paramaqcx.mGender != 2) && (paramaqcx.mAge == -1)) {
      return null;
    }
    aqcj localaqcj = new aqcj();
    int i;
    String str;
    if (paramaqcx.mGender == 2)
    {
      i = 0;
      localaqcj.jdField_a_of_type_Int = i;
      if (paramaqcx.mAge != -1) {
        break label154;
      }
      str = "";
      label66:
      localaqcj.jdField_a_of_type_JavaLangString = str;
      if ((paramaqcx.mGender == 1) || (paramaqcx.mGender == 2))
      {
        if (paramaqcx.mGender != 2) {
          break label165;
        }
        paramContext = paramContext.getResources().getDrawable(2130844712);
        label106:
        localaqcj.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
        if (paramaqcx.mGender != 2) {
          break label178;
        }
        paramContext = "#FF80BF";
        label123:
        localaqcj.b = paramContext;
        if (paramaqcx.mGender != 2) {
          break label184;
        }
      }
    }
    label154:
    label165:
    label178:
    label184:
    for (paramaqcx = "#33FF80BF";; paramaqcx = "#3300CAFC")
    {
      localaqcj.c = paramaqcx;
      return localaqcj;
      i = 1;
      break;
      str = String.valueOf(paramaqcx.mAge);
      break label66;
      paramContext = paramContext.getResources().getDrawable(2130844713);
      break label106;
      paramContext = "#02B2DD";
      break label123;
    }
  }
  
  public static List<afun> a(Context paramContext, JSONArray paramJSONArray)
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
            afun localafun = new afun();
            localafun.jdField_a_of_type_JavaLangCharSequence = localJSONObject.optString("tagName");
            int j;
            if (TextUtils.isEmpty(localafun.jdField_a_of_type_JavaLangCharSequence))
            {
              j = 0;
              localafun.b = Color.parseColor(arrayOfString[(j % arrayOfString.length)]);
              localafun.jdField_a_of_type_Int = Color.parseColor(paramContext[(j % paramContext.length)]);
              localArrayList.add(localafun);
            }
            else
            {
              j = localafun.jdField_a_of_type_JavaLangCharSequence.charAt(0);
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
  
  public static List<aqcj> a(aqcx paramaqcx, Context paramContext)
  {
    if (paramaqcx == null) {
      return null;
    }
    if ((paramaqcx.mLabelInfos == null) || (paramaqcx.mLabelInfos.size() <= 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramContext.getResources().getStringArray(2130968658);
    paramContext = paramContext.getResources().getStringArray(2130968657);
    int i = 0;
    while (i < paramaqcx.mLabelInfos.size())
    {
      aqcj localaqcj = new aqcj();
      localaqcj.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      localaqcj.jdField_a_of_type_Int = 3;
      localaqcj.jdField_a_of_type_JavaLangString = ((aqcy)paramaqcx.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(localaqcj.jdField_a_of_type_JavaLangString))
      {
        i += 1;
      }
      else
      {
        if (TextUtils.isEmpty(localaqcj.jdField_a_of_type_JavaLangString)) {}
        for (int j = 0;; j = localaqcj.jdField_a_of_type_JavaLangString.charAt(0))
        {
          localaqcj.b = arrayOfString[(j % arrayOfString.length)];
          localaqcj.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localaqcj);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static aqcj b(aqcx paramaqcx, Context paramContext)
  {
    if (paramaqcx == null) {
      return null;
    }
    aqcj localaqcj = new aqcj();
    localaqcj.jdField_a_of_type_Int = 2;
    localaqcj.jdField_a_of_type_JavaLangString = String.valueOf(paramaqcx.mPopularity);
    localaqcj.b = "#8173FF";
    localaqcj.c = "#338173FF";
    localaqcj.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844714);
    return localaqcj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhf
 * JD-Core Version:    0.7.0.1
 */