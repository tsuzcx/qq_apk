package com.rookery.translate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Pair;
import com.rookery.asyncHttpClient.AsyncHttpClient;
import com.rookery.translate.google.GoogleInfo;
import com.rookery.translate.google.GoogleTranslator;
import com.rookery.translate.microsoft.MicrosoftInfo;
import com.rookery.translate.microsoft.MicrosoftTranslator;
import com.rookery.translate.type.Language;
import com.rookery.translate.type.TranslateCallback;
import com.rookery.translate.type.TranslateError;
import com.tencent.mobileqq.activity.aio.item.TextTranslationItemBuilder.Holder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AITranslator
{
  private static AITranslator a;
  private GoogleInfo b = new GoogleInfo();
  private MicrosoftInfo c = new MicrosoftInfo();
  private boolean d = true;
  private List<String> e = Collections.synchronizedList(new ArrayList());
  
  private long a(long paramLong, AITranslator.TranslatorType paramTranslatorType)
  {
    long l = 9223372036854775807L;
    if (paramLong == 9223372036854775807L) {
      return 9223372036854775807L;
    }
    int i = AITranslator.4.a[paramTranslatorType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        paramLong = l;
        if (!QLog.isColorLevel()) {
          return paramLong;
        }
        QLog.e("Translator", 2, "unknown type");
        return 9223372036854775807L;
      }
      l = 2L;
    }
    else
    {
      l = 3L;
    }
    paramLong = l * paramLong;
    return paramLong;
  }
  
  private long a(Context paramContext, AITranslator.TranslatorType paramTranslatorType)
  {
    int i = AITranslator.4.a[paramTranslatorType.ordinal()];
    long l = 0L;
    if (i != 1)
    {
      if (i != 2)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("Translator", 2, "unknown type");
          return 0L;
        }
      }
      else {
        return paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_ms_nice", 0L);
      }
    }
    else {
      l = paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_google_nice", 0L);
    }
    return l;
  }
  
  public static AITranslator a()
  {
    try
    {
      if (a == null) {
        a = new AITranslator();
      }
      AITranslator localAITranslator = a;
      return localAITranslator;
    }
    finally {}
  }
  
  private Language a(List<Language> paramList)
  {
    Object localObject1 = new HashMap();
    paramList = paramList.iterator();
    Object localObject2;
    while (paramList.hasNext())
    {
      localObject2 = (Language)paramList.next();
      if (!((HashMap)localObject1).containsKey(localObject2)) {
        ((HashMap)localObject1).put(localObject2, Integer.valueOf(1));
      } else {
        ((HashMap)localObject1).put(localObject2, Integer.valueOf(((Integer)((HashMap)localObject1).get(localObject2)).intValue() + 1));
      }
    }
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    paramList = null;
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Integer)((Map.Entry)localObject2).getValue()).intValue() > i)
      {
        paramList = (Language)((Map.Entry)localObject2).getKey();
        i = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      }
    }
    localObject1 = paramList;
    if (paramList == null) {
      localObject1 = Language.AUTO_DETECT;
    }
    return localObject1;
  }
  
  public static List<Pair<String, String>> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k;
    for (int m = 0; i < paramString.length() - 1; m = k)
    {
      int n = i;
      k = m;
      if (paramString.charAt(i) == '\024')
      {
        int j = m;
        if (m != i)
        {
          String str = paramString.substring(m, i);
          localArrayList.add(new Pair(str, str));
          j = i;
        }
        int i1 = i + 1;
        k = paramString.charAt(i1);
        m = k;
        if (k > 255) {
          m = 65535 - k + 127;
        }
        n = i;
        k = j;
        if (m < 143)
        {
          k = i1 + 1;
          localArrayList.add(new Pair(paramString.substring(j, k), ""));
          n = i1;
        }
      }
      i = n + 1;
    }
    if ((m != i) || (m == 0))
    {
      paramString = paramString.substring(m);
      localArrayList.add(new Pair(paramString, paramString));
    }
    return localArrayList;
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, AITranslator.TranslatorType paramTranslatorType, List<Language> paramList, List<String> paramList1, List<Pair<String, String>> paramList2, Long paramLong1)
  {
    Object localObject = new ArrayList();
    paramLanguage = paramList2.iterator();
    int i = 0;
    while (paramLanguage.hasNext())
    {
      paramList2 = (Pair)paramLanguage.next();
      if ((paramList2.second != null) && (((String)paramList2.second).length() > 0))
      {
        ((List)localObject).add(paramList1.get(i));
        i += 1;
      }
      else
      {
        ((List)localObject).add(paramList2.first);
      }
    }
    paramList1 = Long.valueOf(System.currentTimeMillis() - paramLong1.longValue());
    paramLanguage = new String();
    paramList2 = ((List)localObject).iterator();
    while (paramList2.hasNext())
    {
      paramLong1 = (String)paramList2.next();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLanguage);
      ((StringBuilder)localObject).append(paramLong1);
      paramLanguage = ((StringBuilder)localObject).toString();
    }
    paramTranslateCallback.a(paramLong, paramString, a(paramList), paramLanguage, paramHolder);
    if (QLog.isColorLevel())
    {
      paramHolder = new StringBuilder();
      paramHolder.append("onSuccess Translator type: ");
      paramHolder.append(paramTranslatorType.toString());
      paramHolder.append("\tTime: ");
      paramHolder.append(paramList1);
      paramHolder.append("\t recursion time:");
      paramHolder.append(paramInt);
      QLog.d("Translator", 2, paramHolder.toString());
    }
    a(paramContext, paramTranslatorType, a(paramList1.longValue(), paramTranslatorType));
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, List<Pair<String, String>> paramList, List<String> paramList1, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, AITranslator.TranslatorType paramTranslatorType, TranslateError paramTranslateError, Long paramLong1)
  {
    if (QLog.isColorLevel())
    {
      paramLong1 = new StringBuilder();
      paramLong1.append("AI[onFailed:] recursion_time:");
      paramLong1.append(paramInt);
      paramLong1.append("\tException:");
      paramLong1.append(paramTranslateError);
      QLog.e("Translator", 2, paramLong1.toString());
    }
    if (paramInt >= AITranslator.TranslatorType.values().length - 1) {
      paramTranslateCallback.a(paramLong, paramString, paramTranslateError, paramHolder);
    }
    paramTranslateError = Long.valueOf(9223372036854775807L);
    if (QLog.isColorLevel())
    {
      paramLong1 = new StringBuilder();
      paramLong1.append("onFailed Translator type: ");
      paramLong1.append(paramTranslatorType.toString());
      paramLong1.append("\tTime: ");
      paramLong1.append(paramTranslateError);
      QLog.e("Translator", 2, paramLong1.toString());
    }
    paramTranslateError = Long.valueOf(a(paramTranslateError.longValue(), paramTranslatorType));
    a(paramContext, paramTranslatorType, paramTranslateError.longValue());
    if (paramTranslateError.longValue() == 9223372036854775807L) {
      a(paramLong, paramContext, paramHolder, paramString, paramList, paramList1, paramLanguage, paramTranslateError, paramTranslateCallback, paramInt + 1);
    }
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, List<Pair<String, String>> paramList, List<String> paramList1, Language paramLanguage, Long paramLong1, TranslateCallback paramTranslateCallback, int paramInt)
  {
    if (paramInt >= AITranslator.TranslatorType.values().length) {
      return;
    }
    AITranslator.TranslatorType localTranslatorType = b(paramContext);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    synchronized (this.e)
    {
      int i = AITranslator.4.a[localTranslatorType.ordinal()];
      Object localObject1;
      Object localObject2;
      String str1;
      String str2;
      if (i != 1)
      {
        if (i == 2)
        {
          paramLong1 = new StringBuilder();
          paramLong1.append(paramString);
          paramLong1.append(paramLanguage.toString());
          paramLong1.append("M");
          localObject1 = paramLong1.toString();
          if (!this.e.contains(localObject1))
          {
            this.e.add(localObject1);
            localObject2 = MicrosoftTranslator.a();
            str1 = this.c.b();
            str2 = this.c.c();
            paramLong1 = ???;
          }
        }
      }
      else
      {
        try
        {
          ((MicrosoftTranslator)localObject2).a(paramContext, paramList1, paramLanguage, localLong, str1, str2, new AITranslator.2(this, (String)localObject1, paramLong, paramContext, paramHolder, paramString, paramLanguage, paramTranslateCallback, paramList, paramList1, paramInt, localTranslatorType));
          break label358;
          localObject1 = ???;
          paramLong1 = (Long)localObject1;
          localObject2 = new StringBuilder();
          paramLong1 = (Long)localObject1;
          ((StringBuilder)localObject2).append(paramString);
          paramLong1 = (Long)localObject1;
          ((StringBuilder)localObject2).append(paramLanguage.toString());
          paramLong1 = (Long)localObject1;
          ((StringBuilder)localObject2).append("G");
          paramLong1 = (Long)localObject1;
          localObject2 = ((StringBuilder)localObject2).toString();
          paramLong1 = (Long)localObject1;
          if (!this.e.contains(localObject2))
          {
            paramLong1 = (Long)localObject1;
            this.e.add(localObject2);
            paramLong1 = (Long)localObject1;
            GoogleTranslator.a().a(paramContext, paramList1, paramLanguage, this.b.b(), localLong, new AITranslator.1(this, (String)localObject2, paramLong, paramContext, paramHolder, paramString, paramLanguage, paramTranslateCallback, paramList, paramList1, paramInt, localTranslatorType));
          }
          label358:
          paramLong1 = ???;
          return;
        }
        finally
        {
          for (;;)
          {
            paramHolder = paramLong1;
          }
        }
        paramLong1 = paramHolder;
        throw paramContext;
      }
    }
  }
  
  @TargetApi(9)
  private void a(Context paramContext, AITranslator.TranslatorType paramTranslatorType, long paramLong)
  {
    int i = AITranslator.4.a[paramTranslatorType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "unknow type");
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).apply();
          return;
        }
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).commit();
      }
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).apply();
        return;
      }
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).commit();
    }
  }
  
  @TargetApi(9)
  private void a(Context paramContext, Boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).apply();
        return;
      }
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).commit();
    }
  }
  
  private AITranslator.TranslatorType b(Context paramContext)
  {
    long l1 = a(paramContext, AITranslator.TranslatorType.GOOGLE);
    long l2 = a(paramContext, AITranslator.TranslatorType.MS);
    if ((l1 == 9223372036854775807L) && (l2 == 9223372036854775807L))
    {
      a(paramContext, AITranslator.TranslatorType.MS, 0L);
      a(paramContext, AITranslator.TranslatorType.GOOGLE, 0L);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("google: ");
      paramContext.append(l1);
      paramContext.append("\t MS:");
      paramContext.append(l2);
      QLog.i("Translator", 2, paramContext.toString());
    }
    if (l2 <= l1) {
      return AITranslator.TranslatorType.MS;
    }
    return AITranslator.TranslatorType.GOOGLE;
  }
  
  public static boolean b()
  {
    try
    {
      return a != null;
    }
    finally {}
  }
  
  @TargetApi(9)
  private void c(Context paramContext)
  {
    Long localLong = Long.valueOf(paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_policy_update_time", 0L));
    if ((localLong.longValue() != 0L) && (System.currentTimeMillis() - localLong.longValue() <= 86400000L))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Translator", 2, "needn't update policy");
      }
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 9) {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).apply();
      } else {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).commit();
      }
      PolicyClient.a(paramContext, new AITranslator.3(this, paramContext));
    }
  }
  
  public Boolean a(Context paramContext)
  {
    if (paramContext != null) {
      return Boolean.valueOf(paramContext.getSharedPreferences("[Translate]pref", 0).getBoolean("pref_trans_service_status", true));
    }
    return Boolean.valueOf(true);
  }
  
  public Boolean a(Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, Language paramLanguage, TranslateCallback paramTranslateCallback)
  {
    boolean bool = a(paramContext).booleanValue();
    int i = 0;
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool) {
      return localBoolean;
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" ");
    localObject = a(((StringBuilder)localObject).toString());
    long l2 = paramHolder.c;
    if (this.d == true)
    {
      c(paramContext);
      this.d = false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second != null) && (((String)localPair.second).length() > 0))
      {
        localArrayList.add(localPair.second);
        i += ((String)localPair.second).trim().length();
      }
    }
    if ((localArrayList.size() > 0) && (i > 0))
    {
      a(l2, paramContext, paramHolder, paramString, (List)localObject, localArrayList, paramLanguage, Long.valueOf(l1), paramTranslateCallback, 0);
      return Boolean.valueOf(true);
    }
    return localBoolean;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (TranslateClient.b()) {
      TranslateClient.a().a(paramContext, paramBoolean);
    }
    paramContext = this.e;
    if (paramContext != null) {
      paramContext.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.AITranslator
 * JD-Core Version:    0.7.0.1
 */