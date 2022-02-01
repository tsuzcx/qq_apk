package com.tencent.autotemplate.utils;

import android.support.annotation.NonNull;
import com.tencent.tavsticker.model.TAVSticker;

public class TavStickerUtils
{
  public static TAVSticker createSticker(@NonNull String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      return new TAVSticker().setAssetFilePath(paramString).setScale(1.0F).setRotate(0.0F).setCenterX(0.5F).setCenterY(0.5F).init();
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    paramString = new TAVSticker().setFilePath(paramString).setScale(1.0F).setRotate(0.0F).setCenterX(0.5F).setCenterY(0.5F).init();
    return paramString;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.utils.TavStickerUtils
 * JD-Core Version:    0.7.0.1
 */