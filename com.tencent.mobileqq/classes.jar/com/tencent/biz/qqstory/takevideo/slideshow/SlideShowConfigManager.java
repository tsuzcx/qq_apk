package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.SlideShowStoryConfigBean;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class SlideShowConfigManager
{
  private static SlideShowConfigManager b;
  private Context a;
  private Map<String, List<SlideShowConfigManager.Music>> c = new ConcurrentHashMap();
  
  public SlideShowConfigManager(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.a = paramContext;
    b(paramContext);
  }
  
  public static SlideShowConfigManager a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new SlideShowConfigManager(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  private void b(Context paramContext)
  {
    paramContext = (SlideShowStoryConfigBean)QConfigManager.b().b(362);
    if (paramContext != null) {
      paramContext = paramContext.a;
    } else {
      paramContext = null;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SlideShowConfigManager userConfigContents=");
      ((StringBuilder)localObject1).append(paramContext);
      QLog.d("SlideShowConfigManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramContext)) {
      this.c.clear();
    }
    try
    {
      paramContext = new JSONArray(paramContext);
      int i = 0;
      while (i < paramContext.length())
      {
        Object localObject2 = paramContext.getJSONObject(i);
        localObject1 = ((JSONObject)localObject2).optString("effectID", "");
        localObject2 = ((JSONObject)localObject2).getJSONArray("musics");
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (j < ((JSONArray)localObject2).length())
        {
          SlideShowConfigManager.Music localMusic = new SlideShowConfigManager.Music();
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
          localMusic.a = Integer.parseInt(localJSONObject.getString("tagId"));
          localMusic.b = Integer.parseInt(localJSONObject.getString("itemId"));
          localArrayList.add(localMusic);
          j += 1;
        }
        this.c.put(localObject1, localArrayList);
        i += 1;
      }
    }
    catch (Exception paramContext)
    {
      label235:
      break label235;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowConfigManager", 2, "");
    }
  }
  
  public List<SlideShowConfigManager.Music> a(String paramString)
  {
    if (this.c.size() == 0) {
      b(this.a);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (List)this.c.get(paramString);
    if (paramString != null)
    {
      if (paramString.size() == 0) {
        return null;
      }
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowConfigManager
 * JD-Core Version:    0.7.0.1
 */