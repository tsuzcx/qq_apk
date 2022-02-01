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
    if (shouldAddLinksFallbackToFramework()) {
      Linkify.addLinks(paramTextView, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
    }
    SpannableString localSpannableString;
    do
    {
      return;
      localSpannableString = SpannableString.valueOf(paramTextView.getText());
    } while (!addLinks(localSpannableString, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter));
    paramTextView.setText(localSpannableString);
    addLinkMovementMethod(paramTextView);
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
    boolean bool2;
    if (shouldAddLinksFallbackToFramework())
    {
      bool2 = Linkify.addLinks(paramSpannable, paramPattern, paramString, paramArrayOfString, paramMatchFilter, paramTransformFilter);
      return bool2;
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
    if (i < paramString.length)
    {
      paramArrayOfString = paramString[i];
      if (paramArrayOfString == null) {}
      for (paramArrayOfString = "";; paramArrayOfString = paramArrayOfString.toLowerCase(Locale.ROOT))
      {
        arrayOfString[(i + 1)] = paramArrayOfString;
        i += 1;
        break;
      }
    }
    paramPattern = paramPattern.matcher(paramSpannable);
    boolean bool1 = false;
    label207:
    for (;;)
    {
      bool2 = bool1;
      if (!paramPattern.find()) {
        break;
      }
      i = paramPattern.start();
      int j = paramPattern.end();
      if (paramMatchFilter != null) {}
      for (bool2 = paramMatchFilter.acceptMatch(paramSpannable, i, j);; bool2 = true)
      {
        if (!bool2) {
          break label207;
        }
        applyLink(makeUrl(paramPattern.group(0), arrayOfString, paramPattern, paramTransformFilter), i, j, paramSpannable);
        bool1 = true;
        break;
      }
    }
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
    //   15: ifnull +115 -> 130
    //   18: aload_1
    //   19: aload 6
    //   21: invokevirtual 273	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   24: istore_3
    //   25: iload_3
    //   26: ifge +4 -> 30
    //   29: return
    //   30: new 161	androidx/core/text/util/LinkifyCompat$LinkSpec
    //   33: dup
    //   34: invokespecial 254	androidx/core/text/util/LinkifyCompat$LinkSpec:<init>	()V
    //   37: astore 5
    //   39: aload 6
    //   41: invokevirtual 274	java/lang/String:length	()I
    //   44: iload_3
    //   45: iadd
    //   46: istore 4
    //   48: aload 5
    //   50: iload_3
    //   51: iload_2
    //   52: iadd
    //   53: putfield 173	androidx/core/text/util/LinkifyCompat$LinkSpec:start	I
    //   56: aload 5
    //   58: iload_2
    //   59: iload 4
    //   61: iadd
    //   62: putfield 176	androidx/core/text/util/LinkifyCompat$LinkSpec:end	I
    //   65: aload_1
    //   66: iload 4
    //   68: invokevirtual 277	java/lang/String:substring	(I)Ljava/lang/String;
    //   71: astore_1
    //   72: iload_2
    //   73: iload 4
    //   75: iadd
    //   76: istore_2
    //   77: aload 6
    //   79: ldc_w 279
    //   82: invokestatic 285	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: astore 6
    //   87: aload 5
    //   89: new 287	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 288	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 290
    //   99: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 6
    //   104: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: putfield 169	androidx/core/text/util/LinkifyCompat$LinkSpec:url	Ljava/lang/String;
    //   113: aload_0
    //   114: aload 5
    //   116: invokevirtual 258	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: goto -113 -> 7
    //   123: astore_0
    //   124: return
    //   125: astore 5
    //   127: goto -120 -> 7
    //   130: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramArrayList	ArrayList<LinkifyCompat.LinkSpec>
    //   0	131	1	paramSpannable	Spannable
    //   6	71	2	i	int
    //   24	29	3	j	int
    //   46	30	4	k	int
    //   37	78	5	localLinkSpec	LinkifyCompat.LinkSpec
    //   125	1	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   11	92	6	str	String
    // Exception table:
    //   from	to	target	type
    //   7	13	123	java/lang/UnsupportedOperationException
    //   18	25	123	java/lang/UnsupportedOperationException
    //   30	72	123	java/lang/UnsupportedOperationException
    //   77	87	123	java/lang/UnsupportedOperationException
    //   87	120	123	java/lang/UnsupportedOperationException
    //   77	87	125	java/io/UnsupportedEncodingException
  }
  
  private static String makeUrl(@NonNull String paramString, @NonNull String[] paramArrayOfString, Matcher paramMatcher, @Nullable Linkify.TransformFilter paramTransformFilter)
  {
    int k = 1;
    if (paramTransformFilter != null) {}
    for (paramMatcher = paramTransformFilter.transformUrl(paramMatcher, paramString);; paramMatcher = paramString)
    {
      int i = 0;
      int j;
      if (i < paramArrayOfString.length) {
        if (paramMatcher.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
        {
          paramString = paramMatcher;
          j = k;
          if (!paramMatcher.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
          {
            paramString = paramArrayOfString[i] + paramMatcher.substring(paramArrayOfString[i].length());
            j = k;
          }
        }
      }
      for (;;)
      {
        paramMatcher = paramString;
        if (j == 0)
        {
          paramMatcher = paramString;
          if (paramArrayOfString.length > 0) {
            paramMatcher = paramArrayOfString[0] + paramString;
          }
        }
        return paramMatcher;
        i += 1;
        break;
        j = 0;
        paramString = paramMatcher;
      }
    }
  }
  
  private static void pruneOverlaps(ArrayList<LinkifyCompat.LinkSpec> paramArrayList, Spannable paramSpannable)
  {
    int j = 0;
    Object localObject = (URLSpan[])paramSpannable.getSpans(0, paramSpannable.length(), URLSpan.class);
    int i = 0;
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
    if (j < k - 1)
    {
      localObject = (LinkifyCompat.LinkSpec)paramArrayList.get(j);
      localLinkSpec = (LinkifyCompat.LinkSpec)paramArrayList.get(j + 1);
      if ((((LinkifyCompat.LinkSpec)localObject).start <= localLinkSpec.start) && (((LinkifyCompat.LinkSpec)localObject).end > localLinkSpec.start)) {
        if (localLinkSpec.end <= ((LinkifyCompat.LinkSpec)localObject).end) {
          i = j + 1;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localObject = ((LinkifyCompat.LinkSpec)paramArrayList.get(i)).frameworkAddedSpan;
        if (localObject != null) {
          paramSpannable.removeSpan(localObject);
        }
        paramArrayList.remove(i);
        k -= 1;
        break;
        if (((LinkifyCompat.LinkSpec)localObject).end - ((LinkifyCompat.LinkSpec)localObject).start > localLinkSpec.end - localLinkSpec.start)
        {
          i = j + 1;
          continue;
        }
        if (((LinkifyCompat.LinkSpec)localObject).end - ((LinkifyCompat.LinkSpec)localObject).start >= localLinkSpec.end - localLinkSpec.start) {
          break label295;
        }
        i = j;
        continue;
      }
      j += 1;
      break;
      return;
      label295:
      i = -1;
    }
  }
  
  private static boolean shouldAddLinksFallbackToFramework()
  {
    return Build.VERSION.SDK_INT >= 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.util.LinkifyCompat
 * JD-Core Version:    0.7.0.1
 */