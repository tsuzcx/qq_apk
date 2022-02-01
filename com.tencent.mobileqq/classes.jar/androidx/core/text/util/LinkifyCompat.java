package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.PatternsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat
{
  private static final Comparator<LinkifyCompat.LinkSpec> COMPARATOR = new LinkifyCompat.1();
  private static final String[] EMPTY_STRING = new String[0];
  
  private static void addLinkMovementMethod(@NonNull TextView paramTextView)
  {
    if ((!(paramTextView.getMovementMethod() instanceof LinkMovementMethod)) && (paramTextView.getLinksClickable())) {
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, null, null);
  }
  
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
      return;
    }
    addLinks(paramTextView, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  @SuppressLint({"NewApi"})
  public static void addLinks(@NonNull TextView paramTextView, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework())
    {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return;
    }
    SpannableString localSpannableString = SpannableString.valueOf(paramTextView.getText());
    if (addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter))
    {
      paramTextView.setText(localSpannableString);
      addLinkMovementMethod(paramTextView);
    }
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject1 = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i = localObject1.length - 1;
    while (i >= 0)
    {
      paramSpannable.removeSpan(localObject1[i]);
      i -= 1;
    }
    if ((paramInt & 0x4) != 0) {
      Linkify.addLinks(paramSpannable, 4);
    }
    localObject1 = new ArrayList();
    Object localObject2;
    if ((paramInt & 0x1) != 0)
    {
      localObject2 = PatternsCompat.AUTOLINK_WEB_URL;
      Linkify.MatchFilter localMatchFilter = Linkify.sUrlMatchFilter;
      gatherLinks((ArrayList)localObject1, paramSpannable, (Pattern)localObject2, new String[] { "http://", "https://", "rtsp://" }, localMatchFilter, null);
    }
    if ((paramInt & 0x2) != 0) {
      gatherLinks((ArrayList)localObject1, paramSpannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[] { "mailto:" }, null, null);
    }
    if ((paramInt & 0x8) != 0) {
      gatherMapLinks((ArrayList)localObject1, paramSpannable);
    }
    pruneOverlaps((ArrayList)localObject1, paramSpannable);
    if (((ArrayList)localObject1).size() == 0) {
      return false;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (LinkifyCompat.LinkSpec)((Iterator)localObject1).next();
      if (((LinkifyCompat.LinkSpec)localObject2).frameworkAddedSpan == null) {
        applyLink(((LinkifyCompat.LinkSpec)localObject2).url, ((LinkifyCompat.LinkSpec)localObject2).start, ((LinkifyCompat.LinkSpec)localObject2).end, paramSpannable);
      }
    }
    return true;
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, null, null);
  }
  
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramMatchFilter, paramTransformFilter);
    }
    return addLinks(paramSpannable, paramPattern, paramString, null, paramMatchFilter, paramTransformFilter);
  }
  
  @SuppressLint({"NewApi"})
  public static boolean addLinks(@NonNull Spannable paramSpannable, @NonNull Pattern paramPattern, @Nullable String paramString, @Nullable String[] paramArrayOfString, @Nullable Linkify.MatchFilter paramMatchFilter, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramArrayOfString != null)
    {
      paramString = paramArrayOfString;
      if (paramArrayOfString.length >= 1) {}
    }
    else
    {
      paramString = EMPTY_STRING;
    }
    String[] arrayOfString = new String[paramString.length + 1];
    arrayOfString[0] = str.toLowerCase(Locale.ROOT);
    int i = 0;
    while (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      i += 1;
      if (paramArrayOfString == null) {
        paramArrayOfString = "";
      } else {
        paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT);
      }
      arrayOfString[i] = paramArrayOfString;
    }
    paramPattern = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    while (paramPattern.find())
    {
      i = paramPattern.start();
      int j = paramPattern.end();
      boolean bool2;
      if (paramMatchFilter != null) {
        bool2 = paramMatchFilter.acceptMatch(paramSpannable, i, j);
      } else {
        bool2 = true;
      }
      if (bool2)
      {
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), i, j, paramSpannable);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean addLinks(@NonNull TextView paramTextView, int paramInt)
  {
    if (shouldAddLinksFallbackToFramework()) {
      return Linkify.addLinks(paramTextView, paramInt);
    }
    if (paramInt == 0) {
      return false;
    }
    Object localObject = paramTextView.getText();
    if ((localObject instanceof Spannable))
    {
      if (addLinks((Spannable)localObject, paramInt))
      {
        addLinkMovementMethod(paramTextView);
        return true;
      }
      return false;
    }
    localObject = SpannableString.valueOf((CharSequence)localObject);
    if (addLinks((Spannable)localObject, paramInt))
    {
      addLinkMovementMethod(paramTextView);
      paramTextView.setText((CharSequence)localObject);
      return true;
    }
    return false;
  }
  
  private static void applyLink(String paramString, int paramInt1, int paramInt2, Spannable paramSpannable)
  {
    paramSpannable.setSpan(new URLSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static String findAddress(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return WebView.findAddress(paramString);
    }
    return FindAddress.findAddress(paramString);
  }
  
  private static void gatherLinks(ArrayList<LinkifyCompat.LinkSpec> paramArrayList, Spannable paramSpannable, Pattern paramPattern, String[] paramArrayOfString, Linkify.MatchFilter paramMatchFilter, Linkify.TransformFilter paramTransformFilter)
  {
    paramPattern = paramPattern.matcher(paramSpannable);
    while (paramPattern.find())
    {
      int i = paramPattern.start();
      int j = paramPattern.end();
      if ((paramMatchFilter == null) || (paramMatchFilter.acceptMatch(paramSpannable, i, j)))
      {
        LinkifyCompat.LinkSpec localLinkSpec = new LinkifyCompat.LinkSpec();
        localLinkSpec.url = makeUrl(paramPattern.group(0), paramArrayOfString, paramPattern, paramTransformFilter);
        localLinkSpec.start = i;
        localLinkSpec.end = j;
        paramArrayList.add(localLinkSpec);
      }
    }
  }
  
  /* Error */
  private static void gatherMapLinks(ArrayList<LinkifyCompat.LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 268	java/lang/Object:toString	()Ljava/lang/String;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_1
    //   8: invokestatic 269	androidx/core/text/util/LinkifyCompat:findAddress	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 6
    //   13: aload 6
    //   15: ifnull +116 -> 131
    //   18: aload_1
    //   19: aload 6
    //   21: invokevirtual 273	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore 4
    //   26: iload 4
    //   28: ifge +4 -> 32
    //   31: return
    //   32: new 161	androidx/core/text/util/LinkifyCompat$LinkSpec
    //   35: dup
    //   36: invokespecial 254	androidx/core/text/util/LinkifyCompat$LinkSpec:<init>	()V
    //   39: astore 5
    //   41: aload 6
    //   43: invokevirtual 274	java/lang/String:length	()I
    //   46: iload 4
    //   48: iadd
    //   49: istore_3
    //   50: aload 5
    //   52: iload 4
    //   54: iload_2
    //   55: iadd
    //   56: putfield 173	androidx/core/text/util/LinkifyCompat$LinkSpec:start	I
    //   59: iload_2
    //   60: iload_3
    //   61: iadd
    //   62: istore_2
    //   63: aload 5
    //   65: iload_2
    //   66: putfield 176	androidx/core/text/util/LinkifyCompat$LinkSpec:end	I
    //   69: aload_1
    //   70: iload_3
    //   71: invokevirtual 277	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: astore_1
    //   75: aload 6
    //   77: ldc_w 279
    //   80: invokestatic 285	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 6
    //   85: new 287	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   92: astore 7
    //   94: aload 7
    //   96: ldc_w 290
    //   99: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: aload 6
    //   107: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 5
    //   113: aload 7
    //   115: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: putfield 169	androidx/core/text/util/LinkifyCompat$LinkSpec:url	Ljava/lang/String;
    //   121: aload_0
    //   122: aload 5
    //   124: invokevirtual 258	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   127: pop
    //   128: goto -121 -> 7
    //   131: return
    //   132: astore_0
    //   133: return
    //   134: astore 5
    //   136: goto -129 -> 7
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	paramArrayList	ArrayList<LinkifyCompat.LinkSpec>
    //   0	139	1	paramSpannable	Spannable
    //   6	60	2	i	int
    //   49	22	3	j	int
    //   24	32	4	k	int
    //   39	84	5	localLinkSpec	LinkifyCompat.LinkSpec
    //   134	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   11	95	6	str	String
    //   92	22	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	13	132	java/lang/UnsupportedOperationException
    //   18	26	132	java/lang/UnsupportedOperationException
    //   32	59	132	java/lang/UnsupportedOperationException
    //   63	75	132	java/lang/UnsupportedOperationException
    //   75	85	132	java/lang/UnsupportedOperationException
    //   85	128	132	java/lang/UnsupportedOperationException
    //   75	85	134	java/io/UnsupportedEncodingException
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    String str = paramString;
    if (paramTransformFilter != null) {
      str = paramTransformFilter.transformUrl(paramMatcher, paramString);
    }
    int i = 0;
    for (;;)
    {
      j = paramArrayOfString.length;
      int k = 1;
      if (i >= j) {
        break;
      }
      if (str.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        j = k;
        paramString = str;
        if (str.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label146;
        }
        paramString = new StringBuilder();
        paramString.append(paramArrayOfString[i]);
        paramString.append(str.substring(paramArrayOfString[i].length()));
        paramString = paramString.toString();
        j = k;
        break label146;
      }
      i += 1;
    }
    int j = 0;
    paramString = str;
    label146:
    paramMatcher = paramString;
    if (j == 0)
    {
      paramMatcher = paramString;
      if (paramArrayOfString.length > 0)
      {
        paramMatcher = new StringBuilder();
        paramMatcher.append(paramArrayOfString[0]);
        paramMatcher.append(paramString);
        paramMatcher = paramMatcher.toString();
      }
    }
    return paramMatcher;
  }
  
  private static void pruneOverlaps(ArrayList<LinkifyCompat.LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    int i = paramSpannable.length();
    int j = 0;
    Object localObject = (URLSpan[])paramSpannable.getSpans(0, i, URLSpan.class);
    i = 0;
    LinkifyCompat.LinkSpec localLinkSpec;
    while (i < localObject.length)
    {
      localLinkSpec = new LinkifyCompat.LinkSpec();
      localLinkSpec.frameworkAddedSpan = localObject[i];
      localLinkSpec.start = paramSpannable.getSpanStart(localObject[i]);
      localLinkSpec.end = paramSpannable.getSpanEnd(localObject[i]);
      paramArrayList.add(localLinkSpec);
      i += 1;
    }
    Collections.sort(paramArrayList, COMPARATOR);
    int k = paramArrayList.size();
    i = j;
    while (i < k - 1)
    {
      localObject = (LinkifyCompat.LinkSpec)paramArrayList.get(i);
      int m = i + 1;
      localLinkSpec = (LinkifyCompat.LinkSpec)paramArrayList.get(m);
      if ((((LinkifyCompat.LinkSpec)localObject).start <= localLinkSpec.start) && (((LinkifyCompat.LinkSpec)localObject).end > localLinkSpec.start))
      {
        if (localLinkSpec.end <= ((LinkifyCompat.LinkSpec)localObject).end) {}
        while (((LinkifyCompat.LinkSpec)localObject).end - ((LinkifyCompat.LinkSpec)localObject).start > localLinkSpec.end - localLinkSpec.start)
        {
          j = m;
          break;
        }
        if (((LinkifyCompat.LinkSpec)localObject).end - ((LinkifyCompat.LinkSpec)localObject).start < localLinkSpec.end - localLinkSpec.start) {
          j = i;
        } else {
          j = -1;
        }
        if (j != -1)
        {
          localObject = ((LinkifyCompat.LinkSpec)paramArrayList.get(j)).frameworkAddedSpan;
          if (localObject != null) {
            paramSpannable.removeSpan(localObject);
          }
          paramArrayList.remove(j);
          k -= 1;
          continue;
        }
      }
      i = m;
    }
  }
  
  private static boolean shouldAddLinksFallbackToFramework()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.util.LinkifyCompat
 * JD-Core Version:    0.7.0.1
 */