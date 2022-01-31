package com.tencent.mobileqq.app.automator.step;

import ajsf;
import aklt;
import anvs;
import bbdj;
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
    ((StringBuilder)localObject1).append(ajsf.bR);
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
      aklt localaklt;
      try
      {
        localObject2 = new JSONObject(bbdj.a((File)localObject2)).getJSONArray("data");
        if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0)) {
          continue;
        }
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          int j = ((JSONArray)localObject2).getJSONObject(i).getInt("epId");
          int k = ((JSONArray)localObject2).getJSONObject(i).getInt("type");
          localaklt = new aklt();
          localaklt.jdField_a_of_type_JavaLangString = Integer.toString(j);
          localaklt.jdField_a_of_type_Int = k;
          ((List)localObject1).add(localaklt);
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
      localObject2 = (anvs)this.this$0.a.app.getManager(43);
      int i = 0;
      while (i < localJSONException.size())
      {
        localaklt = (aklt)localJSONException.get(i);
        EmoticonPackage localEmoticonPackage = new EmoticonPackage();
        localEmoticonPackage.jobType = localaklt.jdField_a_of_type_Int;
        localEmoticonPackage.epId = localaklt.jdField_a_of_type_JavaLangString;
        ((anvs)localObject2).a(localEmoticonPackage, true);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep.1
 * JD-Core Version:    0.7.0.1
 */