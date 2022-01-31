package com.tencent.mobileqq.app.automator.step;

import alof;
import amhx;
import apro;
import bdhb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class GetBigEmoticonStep$1
  implements Runnable
{
  GetBigEmoticonStep$1(GetBigEmoticonStep paramGetBigEmoticonStep) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(alof.bS);
    ((StringBuilder)localObject1).append("emojiIds.txt");
    Object localObject2 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject2).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("GetBigEmoticonStep", 2, "doStep ends, file not exist.");
      }
    }
    for (;;)
    {
      return;
      localObject1 = new ArrayList();
      amhx localamhx;
      try
      {
        localObject2 = new JSONObject(bdhb.a((File)localObject2)).getJSONArray("data");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0)) {
          continue;
        }
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          int j = ((JSONArray)localObject2).getJSONObject(i).getInt("epId");
          int k = ((JSONArray)localObject2).getJSONObject(i).getInt("type");
          localamhx = new amhx();
          localamhx.jdField_a_of_type_JavaLangString = Integer.toString(j);
          localamhx.jdField_a_of_type_Int = k;
          ((List)localObject1).add(localamhx);
          i += 1;
        }
        if (localJSONException.size() == 0) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      localObject2 = (apro)this.this$0.a.app.getManager(43);
      int i = 0;
      while (i < localJSONException.size())
      {
        localamhx = (amhx)localJSONException.get(i);
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.jobType = localamhx.jdField_a_of_type_Int;
        localEmoticonPackage.epId = localamhx.jdField_a_of_type_JavaLangString;
        ((apro)localObject2).a(localEmoticonPackage, true);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep.1
 * JD-Core Version:    0.7.0.1
 */