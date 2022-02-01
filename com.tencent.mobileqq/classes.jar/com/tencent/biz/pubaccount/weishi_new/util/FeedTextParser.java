package com.tencent.biz.pubaccount.weishi_new.util;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.EmoWindow;
import com.tencent.biz.subscribe.comment.Patterns;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FeedTextParser
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern b = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  public static FeedTextParser.InnerSpannableBuilder a(CharSequence paramCharSequence, int paramInt, FeedRichTextView.OnElementClickListener paramOnElementClickListener, Drawable.Callback paramCallback)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = new FeedTextParser.InnerSpannableBuilder(paramCharSequence);
      a(paramCharSequence, paramOnElementClickListener);
      b(paramCharSequence, paramOnElementClickListener);
      a(paramCharSequence, paramInt, paramCallback);
      return paramCharSequence;
    }
    return null;
  }
  
  private static FeedTextParser.WSTopic a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new FeedTextParser.WSTopic("", "");
    }
    String str = paramString1.substring(j + 4, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return new FeedTextParser.WSTopic(str, paramString1);
  }
  
  private static FeedTextParser.WSUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new FeedTextParser.WSUser("", "");
    }
    String str = paramString1.substring(j + 4, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
    }
    return new FeedTextParser.WSUser(str, paramString1);
  }
  
  private static ArrayList<FeedTextParser.WSUser> a(FeedTextParser.InnerSpannableBuilder paramInnerSpannableBuilder, FeedRichTextView.OnElementClickListener paramOnElementClickListener)
  {
    if (TextUtils.isEmpty(paramInnerSpannableBuilder)) {
      return null;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramInnerSpannableBuilder);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        FeedTextParser.WSUser localWSUser = a(str1, ",nick:");
        String str2 = localWSUser.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @");
        ((StringBuilder)localObject).append(localWSUser.b);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        paramInnerSpannableBuilder.replace(j, k - i, (CharSequence)localObject);
        i += str1.length() - ((String)localObject).length();
        k = ((String)localObject).length() + j;
        paramInnerSpannableBuilder.setSpan(new FeedTextParser.1(paramOnElementClickListener, str2), j, k, 33);
        paramInnerSpannableBuilder.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localWSUser);
      }
      return localArrayList;
    }
    catch (Exception paramOnElementClickListener)
    {
      paramOnElementClickListener.printStackTrace();
      paramInnerSpannableBuilder.a(localArrayList);
    }
  }
  
  private static void a(FeedTextParser.InnerSpannableBuilder paramInnerSpannableBuilder, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramInnerSpannableBuilder == null) {
      return;
    }
    Matcher localMatcher = c.matcher(paramInnerSpannableBuilder);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      String str = paramInnerSpannableBuilder.subSequence(i, j).toString();
      if (jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        paramCallback = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);
      } else {
        paramCallback = null;
      }
      Object localObject = paramCallback;
      if (paramCallback == null) {
        localObject = QzoneEmotionUtils.getDrawable(str);
      }
      paramCallback = (Drawable.Callback)localObject;
      int k;
      if (localObject == null)
      {
        k = Patterns.a(str);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < Patterns.b.length) {
            paramCallback = EmoWindow.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      localObject = paramCallback;
      if (paramCallback == null)
      {
        k = Patterns.b(str);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emotion code:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(",index:");
        ((StringBuilder)localObject).append(k);
        WSLog.b("emotion", ((StringBuilder)localObject).toString());
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < Patterns.c.length) {
            localObject = EmoWindow.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (localObject != null)
      {
        jdField_a_of_type_JavaUtilHashMap.put(str, localObject);
        ((Drawable)localObject).setBounds(new Rect(0, 0, paramInt, paramInt));
        paramInnerSpannableBuilder.setSpan(new VerticalCenterImageSpan((Drawable)localObject, 0), i, j, 33);
      }
    }
  }
  
  private static ArrayList<FeedTextParser.WSTopic> b(FeedTextParser.InnerSpannableBuilder paramInnerSpannableBuilder, FeedRichTextView.OnElementClickListener paramOnElementClickListener)
  {
    if (TextUtils.isEmpty(paramInnerSpannableBuilder)) {
      return null;
    }
    Matcher localMatcher = b.matcher(paramInnerSpannableBuilder);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        FeedTextParser.WSTopic localWSTopic = a(str1, ",name:");
        String str2 = localWSTopic.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" #");
        ((StringBuilder)localObject).append(localWSTopic.b);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        paramInnerSpannableBuilder.replace(j, k - i, (CharSequence)localObject);
        i += str1.length() - ((String)localObject).length();
        k = ((String)localObject).length() + j;
        paramInnerSpannableBuilder.setSpan(new FeedTextParser.2(paramOnElementClickListener, str2), j, k, 33);
        paramInnerSpannableBuilder.setSpan(new StyleSpan(1), j, k, 33);
        localArrayList.add(localWSTopic);
      }
      return localArrayList;
    }
    catch (Exception paramOnElementClickListener)
    {
      paramOnElementClickListener.printStackTrace();
      paramInnerSpannableBuilder.b(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser
 * JD-Core Version:    0.7.0.1
 */