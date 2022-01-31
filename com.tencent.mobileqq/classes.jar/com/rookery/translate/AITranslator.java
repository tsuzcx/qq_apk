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
import jcp;
import jcq;
import jcr;
import jct;

public class AITranslator
{
  private static AITranslator jdField_a_of_type_ComRookeryTranslateAITranslator;
  private GoogleInfo jdField_a_of_type_ComRookeryTranslateGoogleGoogleInfo = new GoogleInfo();
  private MicrosoftInfo jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftInfo = new MicrosoftInfo();
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  private boolean jdField_a_of_type_Boolean = true;
  
  private long a(long paramLong, AITranslator.TranslatorType paramTranslatorType)
  {
    if (paramLong == 9223372036854775807L) {}
    do
    {
      return 9223372036854775807L;
      switch (jcs.a[paramTranslatorType.ordinal()])
      {
      }
    } while (!QLog.isColorLevel());
    QLog.e("Translator", 2, "unknown type");
    return 9223372036854775807L;
    return 3L * paramLong;
    return 2L * paramLong;
  }
  
  private long a(Context paramContext, AITranslator.TranslatorType paramTranslatorType)
  {
    switch (jcs.a[paramTranslatorType.ordinal()])
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Translator", 2, "unknown type");
      }
      return 0L;
    case 1: 
      return paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_google_nice", 0L);
    }
    return paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_ms_nice", 0L);
  }
  
  private AITranslator.TranslatorType a(Context paramContext)
  {
    long l1 = a(paramContext, AITranslator.TranslatorType.GOOGLE);
    long l2 = a(paramContext, AITranslator.TranslatorType.MS);
    if ((l1 == 9223372036854775807L) && (l2 == 9223372036854775807L))
    {
      a(paramContext, AITranslator.TranslatorType.MS, 0L);
      a(paramContext, AITranslator.TranslatorType.GOOGLE, 0L);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Translator", 2, "google: " + l1 + "\t MS:" + l2);
    }
    if (l2 <= l1) {
      return AITranslator.TranslatorType.MS;
    }
    return AITranslator.TranslatorType.GOOGLE;
  }
  
  public static AITranslator a()
  {
    try
    {
      if (jdField_a_of_type_ComRookeryTranslateAITranslator == null) {
        jdField_a_of_type_ComRookeryTranslateAITranslator = new AITranslator();
      }
      AITranslator localAITranslator = jdField_a_of_type_ComRookeryTranslateAITranslator;
      return localAITranslator;
    }
    finally {}
  }
  
  private Language a(List paramList)
  {
    Object localObject1 = null;
    int i = 0;
    Object localObject2 = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Language localLanguage = (Language)paramList.next();
      if (!((HashMap)localObject2).containsKey(localLanguage)) {
        ((HashMap)localObject2).put(localLanguage, Integer.valueOf(1));
      } else {
        ((HashMap)localObject2).put(localLanguage, Integer.valueOf(((Integer)((HashMap)localObject2).get(localLanguage)).intValue() + 1));
      }
    }
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    paramList = (List)localObject1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((Integer)((Map.Entry)localObject1).getValue()).intValue() <= i) {
        break label183;
      }
      paramList = (Language)((Map.Entry)localObject1).getKey();
      i = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
    }
    label183:
    for (;;)
    {
      break;
      localObject1 = paramList;
      if (paramList == null) {
        localObject1 = Language.AUTO_DETECT;
      }
      return localObject1;
    }
  }
  
  public static List a(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
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
        k = paramString.charAt(i + 1);
        m = k;
        if (k > 255) {
          m = 65535 - k + 127;
        }
        n = i;
        k = j;
        if (m < 143)
        {
          n = i + 1;
          localArrayList.add(new Pair(paramString.substring(j, n + 1), ""));
          k = n + 1;
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
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, AITranslator.TranslatorType paramTranslatorType, List paramList1, List paramList2, List paramList3, Long paramLong1)
  {
    ArrayList localArrayList = new ArrayList();
    paramLanguage = paramList3.iterator();
    int i = 0;
    if (paramLanguage.hasNext())
    {
      paramList3 = (Pair)paramLanguage.next();
      if ((paramList3.second != null) && (((String)paramList3.second).length() > 0))
      {
        int j = i + 1;
        localArrayList.add(paramList2.get(i));
        i = j;
      }
      for (;;)
      {
        break;
        localArrayList.add(paramList3.first);
      }
    }
    paramList2 = Long.valueOf(System.currentTimeMillis() - paramLong1.longValue());
    paramLanguage = new String();
    paramList3 = localArrayList.iterator();
    while (paramList3.hasNext())
    {
      paramLong1 = (String)paramList3.next();
      paramLanguage = paramLanguage + paramLong1;
    }
    paramTranslateCallback.a(paramLong, paramString, a(paramList1), paramLanguage, paramHolder);
    if (QLog.isColorLevel()) {
      QLog.d("Translator", 2, "onSuccess Translator type: " + paramTranslatorType.toString() + "\tTime: " + paramList2 + "\t recursion time:" + paramInt);
    }
    a(paramContext, paramTranslatorType, a(paramList2.longValue(), paramTranslatorType));
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, List paramList1, List paramList2, Language paramLanguage, TranslateCallback paramTranslateCallback, int paramInt, AITranslator.TranslatorType paramTranslatorType, TranslateError paramTranslateError, Long paramLong1)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "AI[onFailed:] recursion_time:" + paramInt + "\tException:" + paramTranslateError);
    }
    if (paramInt >= AITranslator.TranslatorType.values().length - 1) {
      paramTranslateCallback.a(paramLong, paramString, paramTranslateError, paramHolder);
    }
    paramTranslateError = Long.valueOf(9223372036854775807L);
    if (QLog.isColorLevel()) {
      QLog.e("Translator", 2, "onFailed Translator type: " + paramTranslatorType.toString() + "\tTime: " + paramTranslateError);
    }
    paramTranslateError = Long.valueOf(a(paramTranslateError.longValue(), paramTranslatorType));
    a(paramContext, paramTranslatorType, paramTranslateError.longValue());
    if (paramTranslateError.longValue() == 9223372036854775807L) {
      a(paramLong, paramContext, paramHolder, paramString, paramList1, paramList2, paramLanguage, paramTranslateError, paramTranslateCallback, paramInt + 1);
    }
  }
  
  private void a(long paramLong, Context paramContext, TextTranslationItemBuilder.Holder paramHolder, String paramString, List paramList1, List paramList2, Language paramLanguage, Long arg9, TranslateCallback paramTranslateCallback, int paramInt)
  {
    if (paramInt >= AITranslator.TranslatorType.values().length) {
      return;
    }
    AITranslator.TranslatorType localTranslatorType = a(paramContext);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        switch (jcs.a[localTranslatorType.ordinal()])
        {
        case 1: 
          return;
        }
      }
      String str = paramString + paramLanguage.toString() + "G";
      if (!this.jdField_a_of_type_JavaUtilList.contains(str))
      {
        this.jdField_a_of_type_JavaUtilList.add(str);
        GoogleTranslator.a().a(paramContext, paramList2, paramLanguage, this.jdField_a_of_type_ComRookeryTranslateGoogleGoogleInfo.a(), localLong, new jcp(this, str, paramLong, paramContext, paramHolder, paramString, paramLanguage, paramTranslateCallback, paramList1, paramList2, paramInt, localTranslatorType));
        continue;
        str = paramString + paramLanguage.toString() + "M";
        if (!this.jdField_a_of_type_JavaUtilList.contains(str))
        {
          this.jdField_a_of_type_JavaUtilList.add(str);
          MicrosoftTranslator.a().a(paramContext, paramList2, paramLanguage, localLong, this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftInfo.a(), this.jdField_a_of_type_ComRookeryTranslateMicrosoftMicrosoftInfo.b(), new jcq(this, str, paramLong, paramContext, paramHolder, paramString, paramLanguage, paramTranslateCallback, paramList1, paramList2, paramInt, localTranslatorType));
        }
      }
    }
  }
  
  @TargetApi(9)
  private void a(Context paramContext)
  {
    Long localLong = Long.valueOf(paramContext.getSharedPreferences("[Translate]pref", 0).getLong("pref_policy_update_time", 0L));
    if ((localLong.longValue() == 0L) || (System.currentTimeMillis() - localLong.longValue() > 86400000L)) {
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).apply();
        jct.a(paramContext, new jcr(this, paramContext));
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_policy_update_time", System.currentTimeMillis()).commit();
      }
    }
    QLog.i("Translator", 2, "needn't update policy");
  }
  
  @TargetApi(9)
  private void a(Context paramContext, AITranslator.TranslatorType paramTranslatorType, long paramLong)
  {
    switch (jcs.a[paramTranslatorType.ordinal()])
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("Translator", 2, "unknow type");
      }
      return;
    case 1: 
      if (Build.VERSION.SDK_INT >= 9)
      {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).apply();
        return;
      }
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_google_nice", paramLong).commit();
      return;
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).apply();
      return;
    }
    paramContext.getSharedPreferences("[Translate]pref", 0).edit().putLong("pref_ms_nice", paramLong).commit();
  }
  
  @TargetApi(9)
  private void a(Context paramContext, Boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).apply();
      }
    }
    else {
      return;
    }
    paramContext.getSharedPreferences("[Translate]pref", 0).edit().putBoolean("pref_trans_service_status", paramBoolean.booleanValue()).commit();
  }
  
  public static boolean a()
  {
    try
    {
      return jdField_a_of_type_ComRookeryTranslateAITranslator != null;
    }
    finally {}
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
    if (!a(paramContext).booleanValue()) {
      return Boolean.valueOf(false);
    }
    long l1 = System.currentTimeMillis();
    List localList = a(paramString + " ");
    long l2 = paramHolder.b;
    if (this.jdField_a_of_type_Boolean == true)
    {
      a(paramContext);
      this.jdField_a_of_type_Boolean = false;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      if ((localPair.second == null) || (((String)localPair.second).length() <= 0)) {
        break label218;
      }
      localArrayList.add(localPair.second);
      i += ((String)localPair.second).trim().length();
    }
    label218:
    for (;;)
    {
      break;
      if ((localArrayList.size() > 0) && (i > 0))
      {
        a(l2, paramContext, paramHolder, paramString, localList, localArrayList, paramLanguage, Long.valueOf(l1), paramTranslateCallback, 0);
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (TranslateClient.a()) {
      TranslateClient.a().a(paramContext, paramBoolean);
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.rookery.translate.AITranslator
 * JD-Core Version:    0.7.0.1
 */