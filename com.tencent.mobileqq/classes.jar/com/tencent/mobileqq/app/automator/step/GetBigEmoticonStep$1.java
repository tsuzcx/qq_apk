package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.utils.FileUtils;
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
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_EMOTICON_SAVE);
    ((StringBuilder)localObject1).append("emojiIds.txt");
    Object localObject2 = new File(((StringBuilder)localObject1).toString());
    if (!((File)localObject2).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GetBigEmoticonStep", 2, "doStep ends, file not exist.");
      }
      return;
    }
    localObject1 = new ArrayList();
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(FileUtils.readFileContent((File)localObject2)).getJSONArray("data");
        if (localObject2 != null)
        {
          if (((JSONArray)localObject2).length() != 0) {
            break label293;
          }
          return;
          GetBigEmoticonStep.PackTypePair localPackTypePair;
          if (i < ((JSONArray)localObject2).length())
          {
            int k = ((JSONArray)localObject2).getJSONObject(i).getInt("epId");
            int m = ((JSONArray)localObject2).getJSONObject(i).getInt("type");
            localPackTypePair = new GetBigEmoticonStep.PackTypePair();
            localPackTypePair.jdField_a_of_type_JavaLangString = Integer.toString(k);
            localPackTypePair.jdField_a_of_type_Int = m;
            ((List)localObject1).add(localPackTypePair);
            i += 1;
            continue;
          }
          if (((List)localObject1).size() == 0) {
            return;
          }
          localObject2 = (IEmojiManagerService)this.this$0.mAutomator.a.getRuntimeService(IEmojiManagerService.class);
          i = j;
          if (i < ((List)localObject1).size())
          {
            localPackTypePair = (GetBigEmoticonStep.PackTypePair)((List)localObject1).get(i);
            EmoticonPackage localEmoticonPackage = new EmoticonPackage();
            localEmoticonPackage.jobType = localPackTypePair.jdField_a_of_type_Int;
            localEmoticonPackage.epId = localPackTypePair.jdField_a_of_type_JavaLangString;
            ((IEmojiManagerService)localObject2).pullEmoticonPackage(localEmoticonPackage, true);
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      label293:
      int j = 0;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetBigEmoticonStep.1
 * JD-Core Version:    0.7.0.1
 */