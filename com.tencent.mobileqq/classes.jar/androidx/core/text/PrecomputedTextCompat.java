package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrecomputedTextCompat
  implements Spannable
{
  private static final char LINE_FEED = '\n';
  @GuardedBy("sLock")
  @NonNull
  private static Executor sExecutor = null;
  private static final Object sLock = new Object();
  @NonNull
  private final int[] mParagraphEnds;
  @NonNull
  private final PrecomputedTextCompat.Params mParams;
  @NonNull
  private final Spannable mText;
  @Nullable
  private final PrecomputedText mWrapped;
  
  @RequiresApi(28)
  private PrecomputedTextCompat(@NonNull PrecomputedText paramPrecomputedText, @NonNull PrecomputedTextCompat.Params paramParams)
  {
    this.mText = paramPrecomputedText;
    this.mParams = paramParams;
    this.mParagraphEnds = null;
    if (Build.VERSION.SDK_INT < 29) {
      paramPrecomputedText = null;
    }
    this.mWrapped = paramPrecomputedText;
  }
  
  private PrecomputedTextCompat(@NonNull CharSequence paramCharSequence, @NonNull PrecomputedTextCompat.Params paramParams, @NonNull int[] paramArrayOfInt)
  {
    this.mText = new SpannableString(paramCharSequence);
    this.mParams = paramParams;
    this.mParagraphEnds = paramArrayOfInt;
    this.mWrapped = null;
  }
  
  @SuppressLint({"NewApi"})
  public static PrecomputedTextCompat create(@NonNull CharSequence paramCharSequence, @NonNull PrecomputedTextCompat.Params paramParams)
  {
    Preconditions.checkNotNull(paramCharSequence);
    Preconditions.checkNotNull(paramParams);
    for (;;)
    {
      try
      {
        TraceCompat.beginSection("PrecomputedText");
        if ((Build.VERSION.SDK_INT >= 29) && (paramParams.mWrapped != null))
        {
          paramCharSequence = new PrecomputedTextCompat(PrecomputedText.create(paramCharSequence, paramParams.mWrapped), paramParams);
          TraceCompat.endSection();
          return paramCharSequence;
        }
        localArrayList = new ArrayList();
        int j = paramCharSequence.length();
        i = 0;
        if (i >= j) {
          continue;
        }
        i = TextUtils.indexOf(paramCharSequence, '\n', i, j);
        if (i >= 0) {
          continue;
        }
        i = j;
      }
      finally
      {
        ArrayList localArrayList;
        int i;
        int[] arrayOfInt;
        TraceCompat.endSection();
        continue;
        throw paramCharSequence;
        continue;
        i += 1;
        continue;
      }
      localArrayList.add(Integer.valueOf(i));
    }
    arrayOfInt = new int[localArrayList.size()];
    i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramParams.getTextPaint(), 2147483647).setBreakStrategy(paramParams.getBreakStrategy()).setHyphenationFrequency(paramParams.getHyphenationFrequency()).setTextDirection(paramParams.getTextDirection()).build();
    } else if (Build.VERSION.SDK_INT >= 21) {
      new StaticLayout(paramCharSequence, paramParams.getTextPaint(), 2147483647, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    }
    paramCharSequence = new PrecomputedTextCompat(paramCharSequence, paramParams, arrayOfInt);
    TraceCompat.endSection();
    return paramCharSequence;
  }
  
  @UiThread
  public static Future<PrecomputedTextCompat> getTextFuture(@NonNull CharSequence paramCharSequence, @NonNull PrecomputedTextCompat.Params paramParams, @Nullable Executor arg2)
  {
    paramParams = new PrecomputedTextCompat.PrecomputedTextFutureTask(paramParams, paramCharSequence);
    paramCharSequence = ???;
    if (??? == null) {
      synchronized (sLock)
      {
        if (sExecutor == null) {
          sExecutor = Executors.newFixedThreadPool(1);
        }
        paramCharSequence = sExecutor;
      }
    }
    paramCharSequence.execute(paramParams);
    return paramParams;
  }
  
  public char charAt(int paramInt)
  {
    return this.mText.charAt(paramInt);
  }
  
  @SuppressLint({"NewApi"})
  @IntRange(from=0L)
  public int getParagraphCount()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mWrapped.getParagraphCount();
    }
    return this.mParagraphEnds.length;
  }
  
  @SuppressLint({"NewApi"})
  @IntRange(from=0L)
  public int getParagraphEnd(@IntRange(from=0L) int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mWrapped.getParagraphEnd(paramInt);
    }
    return this.mParagraphEnds[paramInt];
  }
  
  @SuppressLint({"NewApi"})
  @IntRange(from=0L)
  public int getParagraphStart(@IntRange(from=0L) int paramInt)
  {
    Preconditions.checkArgumentInRange(paramInt, 0, getParagraphCount(), "paraIndex");
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mWrapped.getParagraphStart(paramInt);
    }
    if (paramInt == 0) {
      return 0;
    }
    return this.mParagraphEnds[(paramInt - 1)];
  }
  
  @NonNull
  public PrecomputedTextCompat.Params getParams()
  {
    return this.mParams;
  }
  
  @Nullable
  @RequiresApi(28)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public PrecomputedText getPrecomputedText()
  {
    Spannable localSpannable = this.mText;
    if ((localSpannable instanceof PrecomputedText)) {
      return (PrecomputedText)localSpannable;
    }
    return null;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return this.mText.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return this.mText.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    return this.mText.getSpanStart(paramObject);
  }
  
  @SuppressLint({"NewApi"})
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mWrapped.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.mText.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public int length()
  {
    return this.mText.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.mText.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  @SuppressLint({"NewApi"})
  public void removeSpan(Object paramObject)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.mWrapped.removeSpan(paramObject);
        return;
      }
      this.mText.removeSpan(paramObject);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  @SuppressLint({"NewApi"})
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.mWrapped.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
        return;
      }
      this.mText.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.mText.subSequence(paramInt1, paramInt2);
  }
  
  @NonNull
  public String toString()
  {
    return this.mText.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat
 * JD-Core Version:    0.7.0.1
 */