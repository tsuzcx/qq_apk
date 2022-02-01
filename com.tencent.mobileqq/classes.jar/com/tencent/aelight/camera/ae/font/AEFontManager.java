package com.tencent.aelight.camera.ae.font;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aelight.camera.aeeditor.data.AEEditorDownloadResBean;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.HashMap;

public class AEFontManager
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private final HashMap<String, Typeface> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static AEFontManager a()
  {
    return AEFontManager.Holder.a;
  }
  
  private void a(AEEditorDownloadResBean paramAEEditorDownloadResBean)
  {
    String str = paramAEEditorDownloadResBean.getId();
    paramAEEditorDownloadResBean = paramAEEditorDownloadResBean.getFontFamily();
    if (a().a(str) == Typeface.DEFAULT) {
      ThreadManager.excute(new AEFontManager.2(this, str, paramAEEditorDownloadResBean), 64, null, false);
    }
  }
  
  @NonNull
  public Typeface a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return Typeface.DEFAULT;
    }
    Typeface localTypeface = (Typeface)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    paramString = localTypeface;
    if (localTypeface == null) {
      paramString = Typeface.DEFAULT;
    }
    return paramString;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean)
    {
      AEQLog.b("AEFontManager", "[preDownloadAndRegisterGifFonts] already triggered");
      return;
    }
    jdField_a_of_type_Boolean = true;
    ThreadManager.excute(new AEFontManager.1(this), 128, null, false);
  }
  
  public void a(String paramString, Typeface paramTypeface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramTypeface == null) {
        return;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramTypeface);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (a(paramString1) != Typeface.DEFAULT) {
        return;
      }
      paramString2 = new File(paramString2);
      if (!paramString2.exists())
      {
        paramString1 = new StringBuilder();
        paramString1.append("[cacheTypeface], fontFile not exists, path=");
        paramString1.append(paramString2.getAbsolutePath());
        AEQLog.d("AEFontManager", paramString1.toString());
        return;
      }
      try
      {
        paramString2 = Typeface.createFromFile(paramString2);
        if (paramString2 != null)
        {
          a(paramString1, paramString2);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        AEQLog.a("AEFontManager", "[cacheTypeface], create typeface raised exception, e=", paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.font.AEFontManager
 * JD-Core Version:    0.7.0.1
 */