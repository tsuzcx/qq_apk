package com.tencent.mobileqq.ark;

import aqaf;
import aqai;
import bhto;
import com.tencent.common.app.AppInterface;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;

public final class ArkAiDictMgr$4
  implements Runnable
{
  public ArkAiDictMgr$4(AppInterface paramAppInterface) {}
  
  public void run()
  {
    try
    {
      if (!aqaf.a(this.a)) {
        break label263;
      }
      String str1 = aqai.a();
      if (str1 == null)
      {
        ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, local dict config not available", new Object[0]));
        return;
      }
      if ((aqaf.b() != null) && (aqaf.b().equals(str1)))
      {
        ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, dict already loaded, dict-id=%s", new Object[] { aqaf.b() }));
        return;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      ArkAppCenter.c("ArkApp.Dict", "reloadWordData, UnsatisfiedLinkError, err:" + localUnsatisfiedLinkError.getMessage());
      return;
    }
    String str2 = aqaf.a(localUnsatisfiedLinkError);
    if (!new File(str2).exists())
    {
      ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, "reloadWordData, local dict file not available, dict-id=%s", new Object[] { localUnsatisfiedLinkError }));
      return;
    }
    WordSegment.uninit();
    int i = WordSegment.init(str2 + '/');
    if (i != 0)
    {
      ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, String.format(Locale.CHINA, "reloadWordData failed, dict-id=%s, ret=%d", new Object[] { localUnsatisfiedLinkError, Integer.valueOf(i) }), new Object[0]));
      return;
    }
    ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, String.format("reloadWordData success, dict-id=%s", new Object[] { localUnsatisfiedLinkError }), new Object[0]));
    aqaf.b(localUnsatisfiedLinkError);
    if (this.a != null)
    {
      bhto.a(this.a);
      return;
      label263:
      ArkAppCenter.c("ArkApp.Dict", String.format("reloadWordData, dict flag is off", new Object[0]));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.4
 * JD-Core Version:    0.7.0.1
 */