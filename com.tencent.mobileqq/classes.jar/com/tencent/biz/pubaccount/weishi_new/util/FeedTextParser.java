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
    FeedTextParser.InnerSpannableBuilder localInnerSpannableBuilder = null;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      localInnerSpannableBuilder = new FeedTextParser.InnerSpannableBuilder(paramCharSequence);
      a(localInnerSpannableBuilder, paramOnElementClickListener);
      b(localInnerSpannableBuilder, paramOnElementClickListener);
      a(localInnerSpannableBuilder, paramInt, paramCallback);
    }
    return localInnerSpannableBuilder;
  }
  
  private static FeedTextParser.WSTopic a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int k = "tid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new FeedTextParser.WSTopic("", "");
    }
    String str = paramString1.substring(j + k, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
    return new FeedTextParser.WSTopic(str, paramString1);
  }
  
  private static FeedTextParser.WSUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int k = "uid:".length();
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new FeedTextParser.WSUser("", "");
    }
    String str = paramString1.substring(j + k, i);
    j = paramString1.length();
    paramString1 = paramString1.substring(i + paramString2.length(), j - 1);
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
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
        String str3 = " @" + localWSUser.b + " ";
        paramInnerSpannableBuilder.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
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
    label14:
    int i;
    int j;
    String str;
    if (localMatcher.find())
    {
      i = localMatcher.start();
      j = localMatcher.end();
      str = paramInnerSpannableBuilder.subSequence(i, j).toString();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
        break label288;
      }
    }
    label288:
    for (Object localObject = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);; localObject = null)
    {
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null) {
        paramCallback = QzoneEmotionUtils.getDrawable(str);
      }
      localObject = paramCallback;
      int k;
      if (paramCallback == null)
      {
        k = Patterns.a(str);
        localObject = paramCallback;
        if (k > -1)
        {
          localObject = paramCallback;
          if (k < Patterns.b.length) {
            localObject = EmoWindow.a(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      paramCallback = (Drawable.Callback)localObject;
      if (localObject == null)
      {
        k = Patterns.b(str);
        WSLog.b("emotion", "emotion code:" + str + ",index:" + k);
        paramCallback = (Drawable.Callback)localObject;
        if (k > -1)
        {
          paramCallback = (Drawable.Callback)localObject;
          if (k < Patterns.c.length) {
            paramCallback = EmoWindow.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (paramCallback == null) {
        break label14;
      }
      jdField_a_of_type_JavaUtilHashMap.put(str, paramCallback);
      paramCallback.setBounds(new Rect(0, 0, paramInt, paramInt));
      paramInnerSpannableBuilder.setSpan(new VerticalCenterImageSpan(paramCallback, 0), i, j, 33);
      break label14;
      break;
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
        String str3 = " #" + localWSTopic.b + " ";
        paramInnerSpannableBuilder.replace(j, k - i, str3);
        i += str1.length() - str3.length();
        k = str3.length() + j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.FeedTextParser
 * JD-Core Version:    0.7.0.1
 */