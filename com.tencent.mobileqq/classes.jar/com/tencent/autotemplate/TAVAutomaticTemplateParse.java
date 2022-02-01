package com.tencent.autotemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.autotemplate.utils.JsonUtils;
import java.io.File;

public class TAVAutomaticTemplateParse
{
  private static final String TAG = "com.tencent.autotemplate.TAVAutomaticTemplateParse";
  
  public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    paramString2 = (TAVAutomaticTemplate)JsonUtils.parseObjectFromFile(paramContext, localStringBuilder.toString(), TAVAutomaticTemplate.class);
    if (paramString2 != null)
    {
      paramString2.setContext(paramContext);
      paramString2.setTemplateDir(paramString1);
      return paramString2;
    }
    Log.d(TAG, "parseAutomaticTemplate error, TAVAutomaticTemplate Object is null, Please template config file.");
    return paramString2;
  }
  
  public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull String paramString)
  {
    return (TAVAutomaticTemplate)JsonUtils.parseObjectFromFile(null, paramString, TAVAutomaticTemplate.class);
  }
  
  public static TAVAutomaticTemplate parseAutomaticTemplate(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramString2 = (TAVAutomaticTemplate)JsonUtils.parseObjectFromFile(null, localStringBuilder.toString(), TAVAutomaticTemplate.class);
    paramString2.setTemplateDir(paramString1);
    return paramString2;
  }
  
  public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@Nullable Context paramContext, @NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramContext = (TAVRhythmAutomaticTemplate)JsonUtils.parseObjectFromFile(paramContext, localStringBuilder.toString(), TAVRhythmAutomaticTemplate.class);
    if (paramContext == null) {
      return null;
    }
    paramContext.setTemplateDir(paramString1);
    return paramContext;
  }
  
  public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@NonNull String paramString)
  {
    return (TAVRhythmAutomaticTemplate)JsonUtils.parseObjectFromFile(null, paramString, TAVRhythmAutomaticTemplate.class);
  }
  
  public static TAVRhythmAutomaticTemplate parseRhythmAutomaticTemplate(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramString2 = (TAVRhythmAutomaticTemplate)JsonUtils.parseObjectFromFile(null, localStringBuilder.toString(), TAVRhythmAutomaticTemplate.class);
    if (paramString2 == null) {
      return null;
    }
    paramString2.setTemplateDir(paramString1);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.TAVAutomaticTemplateParse
 * JD-Core Version:    0.7.0.1
 */