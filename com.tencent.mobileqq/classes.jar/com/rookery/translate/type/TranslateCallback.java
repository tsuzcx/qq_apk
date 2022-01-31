package com.rookery.translate.type;

import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;

public abstract interface TranslateCallback
{
  public abstract void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, TextTranslationItemBuilder.Holder paramHolder);
  
  public abstract void a(long paramLong, String paramString, TranslateError paramTranslateError, TextTranslationItemBuilder.Holder paramHolder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.rookery.translate.type.TranslateCallback
 * JD-Core Version:    0.7.0.1
 */