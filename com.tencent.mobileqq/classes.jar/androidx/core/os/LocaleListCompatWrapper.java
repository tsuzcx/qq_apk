package androidx.core.os;

import android.os.Build.VERSION;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

final class LocaleListCompatWrapper
  implements LocaleListInterface
{
  private static final Locale EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
  private static final Locale LOCALE_AR_XB;
  private static final Locale LOCALE_EN_XA;
  private static final Locale[] sEmptyList = new Locale[0];
  private final Locale[] mList;
  @NonNull
  private final String mStringRepresentation;
  
  static
  {
    LOCALE_EN_XA = new Locale("en", "XA");
    LOCALE_AR_XB = new Locale("ar", "XB");
  }
  
  LocaleListCompatWrapper(@NonNull Locale... paramVarArgs)
  {
    if (paramVarArgs.length == 0)
    {
      this.mList = sEmptyList;
      this.mStringRepresentation = "";
      return;
    }
    Locale[] arrayOfLocale = new Locale[paramVarArgs.length];
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Locale localLocale = paramVarArgs[i];
      if (localLocale != null)
      {
        if (!localHashSet.contains(localLocale))
        {
          localLocale = (Locale)localLocale.clone();
          arrayOfLocale[i] = localLocale;
          toLanguageTag(localStringBuilder, localLocale);
          if (i < paramVarArgs.length - 1) {
            localStringBuilder.append(',');
          }
          localHashSet.add(localLocale);
          i += 1;
        }
        else
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("list[");
          paramVarArgs.append(i);
          paramVarArgs.append("] is a repetition");
          throw new IllegalArgumentException(paramVarArgs.toString());
        }
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("list[");
        paramVarArgs.append(i);
        paramVarArgs.append("] is null");
        throw new NullPointerException(paramVarArgs.toString());
      }
    }
    this.mList = arrayOfLocale;
    this.mStringRepresentation = localStringBuilder.toString();
  }
  
  private Locale computeFirstMatch(Collection<String> paramCollection, boolean paramBoolean)
  {
    int i = computeFirstMatchIndex(paramCollection, paramBoolean);
    if (i == -1) {
      return null;
    }
    return this.mList[i];
  }
  
  private int computeFirstMatchIndex(Collection<String> paramCollection, boolean paramBoolean)
  {
    Locale[] arrayOfLocale = this.mList;
    if (arrayOfLocale.length == 1) {
      return 0;
    }
    if (arrayOfLocale.length == 0) {
      return -1;
    }
    int i;
    if (paramBoolean)
    {
      i = findFirstMatchIndex(EN_LATN);
      if (i == 0) {
        return 0;
      }
      if (i < 2147483647) {}
    }
    else
    {
      i = 2147483647;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      int j = findFirstMatchIndex(LocaleListCompat.forLanguageTagCompat((String)paramCollection.next()));
      if (j == 0) {
        return 0;
      }
      if (j < i) {
        i = j;
      }
    }
    if (i == 2147483647) {
      return 0;
    }
    return i;
  }
  
  private int findFirstMatchIndex(Locale paramLocale)
  {
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (matchScore(paramLocale, arrayOfLocale[i]) > 0) {
        return i;
      }
      i += 1;
    }
    return 2147483647;
  }
  
  private static String getLikelyScript(Locale paramLocale)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramLocale = paramLocale.getScript();
      if (!paramLocale.isEmpty()) {
        return paramLocale;
      }
    }
    return "";
  }
  
  private static boolean isPseudoLocale(Locale paramLocale)
  {
    return (LOCALE_EN_XA.equals(paramLocale)) || (LOCALE_AR_XB.equals(paramLocale));
  }
  
  @IntRange(from=0L, to=1L)
  private static int matchScore(Locale paramLocale1, Locale paramLocale2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @VisibleForTesting
  static void toLanguageTag(StringBuilder paramStringBuilder, Locale paramLocale)
  {
    paramStringBuilder.append(paramLocale.getLanguage());
    String str = paramLocale.getCountry();
    if ((str != null) && (!str.isEmpty()))
    {
      paramStringBuilder.append('-');
      paramStringBuilder.append(paramLocale.getCountry());
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof LocaleListCompatWrapper)) {
      return false;
    }
    paramObject = ((LocaleListCompatWrapper)paramObject).mList;
    if (this.mList.length != paramObject.length) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (!arrayOfLocale[i].equals(paramObject[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Locale get(int paramInt)
  {
    if (paramInt >= 0)
    {
      Locale[] arrayOfLocale = this.mList;
      if (paramInt < arrayOfLocale.length) {
        return arrayOfLocale[paramInt];
      }
    }
    return null;
  }
  
  public Locale getFirstMatch(@NonNull String[] paramArrayOfString)
  {
    return computeFirstMatch(Arrays.asList(paramArrayOfString), false);
  }
  
  @Nullable
  public Object getLocaleList()
  {
    return null;
  }
  
  public int hashCode()
  {
    int j = 1;
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      j = j * 31 + arrayOfLocale[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Locale paramLocale)
  {
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      if (arrayOfLocale[i].equals(paramLocale)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.mList.length == 0;
  }
  
  public int size()
  {
    return this.mList.length;
  }
  
  public String toLanguageTags()
  {
    return this.mStringRepresentation;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    int i = 0;
    for (;;)
    {
      Locale[] arrayOfLocale = this.mList;
      if (i >= arrayOfLocale.length) {
        break;
      }
      localStringBuilder.append(arrayOfLocale[i]);
      if (i < this.mList.length - 1) {
        localStringBuilder.append(',');
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.LocaleListCompatWrapper
 * JD-Core Version:    0.7.0.1
 */