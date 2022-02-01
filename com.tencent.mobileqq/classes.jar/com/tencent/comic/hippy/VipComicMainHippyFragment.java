package com.tencent.comic.hippy;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.utils.SerializableMap;
import java.util.HashMap;

public class VipComicMainHippyFragment
  extends VipComicHippyFragment
{
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      paramBundle = (String)((SerializableMap)getParameters().getSerializable("js_param_map")).getMap().get("mod");
      if (TextUtils.isEmpty(paramBundle))
      {
        com.tencent.comic.data.VipComicDataHelper.k = "";
        return;
      }
      com.tencent.comic.data.VipComicDataHelper.k = paramBundle;
      return;
    }
    catch (Throwable paramBundle) {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.comic.data.VipComicDataHelper.k = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.hippy.VipComicMainHippyFragment
 * JD-Core Version:    0.7.0.1
 */