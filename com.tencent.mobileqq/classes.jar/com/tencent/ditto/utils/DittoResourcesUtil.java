package com.tencent.ditto.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.ditto.content.res.DittoResources;
import com.tencent.ditto.shell.DittoUIEngine;

public class DittoResourcesUtil
{
  public static final String COLOR_ID_PREFIX = "@color/";
  public static final String CUSTOM_COLOR_ID_PREFIX = "@customColor/";
  public static final int CUSTOM_COLOR_ID_PREFIX_LENGTH = "@customColor/".length();
  public static final String TAG = "DittoResourcesUtil";
  
  public static int parseColor(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Unknown color");
    }
    DittoResources localDittoResources;
    if (paramString.startsWith("@color/"))
    {
      localDittoResources = DittoUIEngine.g().getDittoResources();
      if (localDittoResources != null) {
        return localDittoResources.getColor(DittoUIEngine.g().getResourceId(paramString));
      }
      throw new IllegalStateException("CanvasResources is null");
    }
    if (paramString.startsWith("@customColor/"))
    {
      localDittoResources = DittoUIEngine.g().getDittoResources();
      if (localDittoResources != null) {
        return localDittoResources.getCustomColor(paramString.substring(CUSTOM_COLOR_ID_PREFIX_LENGTH));
      }
      throw new IllegalStateException("CanvasResources is null");
    }
    return Color.parseColor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.utils.DittoResourcesUtil
 * JD-Core Version:    0.7.0.1
 */