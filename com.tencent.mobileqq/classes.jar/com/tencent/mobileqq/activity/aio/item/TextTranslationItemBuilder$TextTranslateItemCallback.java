package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.SystemClock;
import android.widget.BaseAdapter;
import android.widget.Toast;
import com.rookery.translate.model.TransDiskCache;
import com.rookery.translate.model.TransMemCache;
import com.rookery.translate.model.TranslateCache;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateCallback;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class TextTranslationItemBuilder$TextTranslateItemCallback
  implements TranslateCallback
{
  public BaseAdapter a;
  public QQAppInterface b;
  private Context c;
  private TextTranslationItemBuilder.Holder d;
  private String e;
  
  public TextTranslationItemBuilder$TextTranslateItemCallback(Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, BaseAdapter paramBaseAdapter, QQAppInterface paramQQAppInterface)
  {
    this.c = paramContext;
    this.d = paramHolder;
    this.e = paramString;
    this.a = paramBaseAdapter;
    this.b = paramQQAppInterface;
  }
  
  @NotNull
  private String a()
  {
    if (this.d.d == 0) {
      return "0";
    }
    if (this.d.d == 1) {
      return "1";
    }
    if (this.d.d == 3000) {
      return "2";
    }
    return "";
  }
  
  private void a(Language paramLanguage)
  {
    if (paramLanguage.toString().equalsIgnoreCase(this.e))
    {
      TextTranslationItemBuilder.G += 1;
      return;
    }
    if ((paramLanguage.toString().equalsIgnoreCase("zh-CHS")) && (this.e.equalsIgnoreCase("zh-CN")))
    {
      TextTranslationItemBuilder.G += 1;
      return;
    }
    if ((paramLanguage.toString().equalsIgnoreCase("zh-CHT")) && (this.e.equalsIgnoreCase("zh-TW"))) {
      TextTranslationItemBuilder.G += 1;
    }
  }
  
  void a(int paramInt)
  {
    Toast.makeText(this.c, paramInt, 0).show();
  }
  
  public void a(long paramLong, String paramString1, Language paramLanguage, String paramString2, TextTranslationItemBuilder.Holder paramHolder)
  {
    TextTranslationItemBuilder.a(this.c, this.d);
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramHolder != null) {
      TranslateCache.a(this.c).a(this.e, paramHolder.g, paramHolder.c, localBoolean);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ChatAdapter]holder id:");
      ((StringBuilder)localObject).append(this.d.c);
      ((StringBuilder)localObject).append("request id:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("Translator", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString1.equalsIgnoreCase(this.d.e)) && (this.d.c == paramLong) && (paramHolder != null) && (paramHolder.s != null))
    {
      a(paramLanguage);
      localObject = a();
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.c);
      QQAppInterface localQQAppInterface = this.b;
      localStatisticCollector.reportActionCountRes(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 0, String.valueOf(SystemClock.uptimeMillis() - paramHolder.D), (String)localObject, paramLanguage.toString(), this.e);
      if ((!paramLanguage.toString().equalsIgnoreCase(this.e)) && (!paramString2.equalsIgnoreCase(paramString1)))
      {
        paramLanguage = TranslateCache.b(this.c.getApplicationContext());
        if (paramLanguage != null) {
          paramLanguage.a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.e);
        }
        paramHolder.f = 1;
        this.a.notifyDataSetChanged();
        return;
      }
      paramLanguage = TranslateCache.b(this.c.getApplicationContext());
      if (paramLanguage != null) {
        paramLanguage.a(paramString1, paramString2, paramLong, localBoolean, this.e);
      }
      a(2131914204);
      return;
    }
    if (!paramLanguage.toString().equalsIgnoreCase(this.e))
    {
      TranslateCache.b(this.c).a(paramString1, paramString2, paramLong, Boolean.valueOf(true), this.e);
      return;
    }
    TranslateCache.b(this.c).a(paramString1, paramString2, paramLong, localBoolean, this.e);
  }
  
  public void a(long paramLong, String paramString, TranslateError paramTranslateError, TextTranslationItemBuilder.Holder paramHolder)
  {
    TextTranslationItemBuilder.a(this.c, this.d);
    if (paramHolder != null) {
      TranslateCache.a(this.c).a(this.e, paramHolder.g, paramHolder.c, Boolean.valueOf(false));
    }
    if ((paramHolder != null) && (paramHolder.s != null) && (paramTranslateError != null))
    {
      if ((paramTranslateError.getMessage() != null) && (paramTranslateError.getMessage().length() > 0))
      {
        if ((paramTranslateError.getMessage().indexOf("Unable to resolve host") < 0) && (paramTranslateError.getMessage().indexOf("can't resolve host") < 0)) {
          a(2131914207);
        } else {
          a(2131914205);
        }
      }
      else {
        a(2131914208);
      }
      paramString = a();
      paramHolder = StatisticCollector.getInstance(this.c);
      QQAppInterface localQQAppInterface = this.b;
      paramHolder.reportActionCountRes(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), "", "Translate_external", "Translate_external", 0, 1, 1, "", paramString, "", "");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onFailed:");
        paramString.append(paramTranslateError);
        QLog.e("Translator", 2, paramString.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("Translator", 2, "onFailed:e is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.TextTranslateItemCallback
 * JD-Core Version:    0.7.0.1
 */