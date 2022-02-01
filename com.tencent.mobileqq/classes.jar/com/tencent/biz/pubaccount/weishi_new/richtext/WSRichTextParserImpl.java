package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
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

public class WSRichTextParserImpl
  implements IWSRichTextParser
{
  private static HashMap<String, Drawable> a = new HashMap();
  private static final Pattern b = Pattern.compile("@?\\{uid:.+?,nick:.*?\\}", 2);
  private static final Pattern c = Pattern.compile("#?\\{tid:.+?,name:.*?\\}", 2);
  private static final Pattern d = Pattern.compile("\\[em\\]e\\d+\\[/em\\]", 2);
  
  private void a(WSRichTextParserImpl.InnerSpannableBuilder paramInnerSpannableBuilder, int paramInt, Drawable.Callback paramCallback)
  {
    if (paramInnerSpannableBuilder == null) {
      return;
    }
    Matcher localMatcher = d.matcher(paramInnerSpannableBuilder);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      String str = paramInnerSpannableBuilder.subSequence(i, j).toString();
      if (a.containsKey(str)) {
        paramCallback = (Drawable)a.get(str);
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
          if (k < Patterns.e.length) {
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
          if (k < Patterns.f.length) {
            localObject = EmoWindow.b(k, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density, BaseApplicationImpl.getContext(), null);
          }
        }
      }
      if (localObject != null)
      {
        a.put(str, localObject);
        ((Drawable)localObject).setBounds(new Rect(0, 0, paramInt, paramInt));
        paramInnerSpannableBuilder.setSpan(new VerticalCenterImageSpan((Drawable)localObject, 0), i, j, 33);
      }
    }
  }
  
  private WSRichTextParserImpl.WSTopic b(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("tid:");
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new WSRichTextParserImpl.WSTopic("", "");
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
    return new WSRichTextParserImpl.WSTopic(str, paramString1);
  }
  
  private ArrayList<WSRichTextParserImpl.WSTopic> b(WSRichTextParserImpl.InnerSpannableBuilder paramInnerSpannableBuilder, FeedRichTextView.OnElementClickListener paramOnElementClickListener)
  {
    if (TextUtils.isEmpty(paramInnerSpannableBuilder)) {
      return null;
    }
    Matcher localMatcher = c.matcher(paramInnerSpannableBuilder);
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        WSRichTextParserImpl.WSTopic localWSTopic = b(str1, ",name:");
        String str2 = localWSTopic.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" #");
        ((StringBuilder)localObject).append(localWSTopic.b);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        paramInnerSpannableBuilder.replace(j, k - i, (CharSequence)localObject);
        i += str1.length() - ((String)localObject).length();
        k = ((String)localObject).length() + j;
        paramInnerSpannableBuilder.setSpan(new WSRichTextParserImpl.2(this, paramOnElementClickListener, str2), j, k, 33);
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
  
  public WSRichTextParserImpl.InnerSpannableBuilder a(CharSequence paramCharSequence, int paramInt, FeedRichTextView.OnElementClickListener paramOnElementClickListener, Drawable.Callback paramCallback)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = new WSRichTextParserImpl.InnerSpannableBuilder(paramCharSequence);
      a(paramCharSequence, paramOnElementClickListener);
      b(paramCharSequence, paramOnElementClickListener);
      a(paramCharSequence, paramInt, paramCallback);
      return paramCharSequence;
    }
    return null;
  }
  
  public WSRichTextParserImpl.WSUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uid:");
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new WSRichTextParserImpl.WSUser("", "");
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
    return new WSRichTextParserImpl.WSUser(str, paramString1);
  }
  
  protected ArrayList<WSRichTextParserImpl.WSUser> a(WSRichTextParserImpl.InnerSpannableBuilder paramInnerSpannableBuilder, FeedRichTextView.OnElementClickListener paramOnElementClickListener)
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
        WSRichTextParserImpl.WSUser localWSUser = a(str1, ",nick:");
        String str2 = localWSUser.a;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @");
        ((StringBuilder)localObject).append(localWSUser.b);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        paramInnerSpannableBuilder.replace(j, k - i, (CharSequence)localObject);
        i += str1.length() - ((String)localObject).length();
        k = ((String)localObject).length() + j;
        paramInnerSpannableBuilder.setSpan(new WSRichTextParserImpl.1(this, paramOnElementClickListener, str2), j, k, 33);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSRichTextParserImpl
 * JD-Core Version:    0.7.0.1
 */