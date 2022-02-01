package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.comment.Patterns;
import com.tencent.biz.subscribe.widget.span.CustomSchemaSpan.OnCustomSchemaClickListener;
import com.tencent.biz.subscribe.widget.span.CustomUrlSpan.OnCustomUrlClickListener;
import com.tencent.biz.subscribe.widget.span.UserNameSapn;
import com.tencent.biz.subscribe.widget.span.UserNameSapn.OnUserNameClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RichTextParser
{
  private static HashMap<String, Drawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  public static final Pattern a;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\{img:(.*?),w:(\\d+),h:(\\d+)\\}");
    jdField_a_of_type_JavaUtilMap = new RichTextParser.1();
  }
  
  public static CertifiedAccountMeta.StUser a(String paramString1, String paramString2)
  {
    int j = paramString1.indexOf("uin:");
    int i = paramString1.indexOf(paramString2);
    if (i == -1) {
      return new CertifiedAccountMeta.StUser();
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
      label64:
      break label64;
    }
    paramString2 = new CertifiedAccountMeta.StUser();
    paramString2.nick.set(paramString1);
    paramString2.id.set(str);
    return paramString2;
  }
  
  public static RichTextParser.RichSpannableStringBuilder a(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig, Context paramContext, CharSequence paramCharSequence, ColorStateList paramColorStateList, int paramInt1, int paramInt2, int paramInt3, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener, CustomUrlSpan.OnCustomUrlClickListener paramOnCustomUrlClickListener, CustomSchemaSpan.OnCustomSchemaClickListener paramOnCustomSchemaClickListener, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramOnCustomUrlClickListener = paramCharSequence;
    try
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramOnCustomUrlClickListener = "";
      }
      paramCharSequence = new RichTextParser.RichSpannableStringBuilder(paramOnCustomUrlClickListener);
      if (paramBoolean1) {
        a(paramContext, paramCharSequence);
      }
      if (!paramBoolean2)
      {
        a(paramContext, paramCharSequence, paramColorStateList, paramOnUserNameClickListener);
        a(paramContext, paramCharSequence, paramInt1, paramOnUserNameClickListener);
      }
      a(paramTextImageSpanConfig, paramOnCustomUrlClickListener, a(paramTextImageSpanConfig), paramCharSequence, paramURLDrawableListener);
      paramTextImageSpanConfig.jdField_a_of_type_Float += ViewUtils.b(4.0F);
      b(paramTextImageSpanConfig, paramOnCustomUrlClickListener, a(paramTextImageSpanConfig), paramCharSequence, paramURLDrawableListener);
      return paramCharSequence;
    }
    catch (Exception paramTextImageSpanConfig)
    {
      QLog.e("RichTextParser", 2, paramTextImageSpanConfig.getStackTrace());
    }
    return new RichTextParser.RichSpannableStringBuilder("");
  }
  
  private static VerticalCenterImageSpan a(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig, Drawable paramDrawable)
  {
    int i = (int)paramTextImageSpanConfig.jdField_a_of_type_Float;
    Rect localRect = new Rect(0, 0, i, i);
    if (paramDrawable != null)
    {
      paramDrawable.setBounds(localRect);
      return new VerticalCenterImageSpan(paramDrawable, paramTextImageSpanConfig.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public static ArrayList<CertifiedAccountMeta.StUser> a(Context paramContext, RichTextParser.RichSpannableStringBuilder paramRichSpannableStringBuilder, int paramInt, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    boolean bool = TextUtils.isEmpty(paramRichSpannableStringBuilder);
    paramContext = null;
    if (bool) {
      return null;
    }
    Matcher localMatcher = Patterns.c.matcher(paramRichSpannableStringBuilder);
    int i = 0;
    Object localObject2;
    for (;;)
    {
      localObject2 = paramContext;
      try
      {
        if (localMatcher.find())
        {
          localObject2 = paramContext;
          paramRichSpannableStringBuilder.a = true;
          localObject2 = paramContext;
          int j = localMatcher.start() - i;
          localObject2 = paramContext;
          int k = localMatcher.end();
          localObject2 = paramContext;
          Object localObject1 = localMatcher.group();
          localObject2 = paramContext;
          CertifiedAccountMeta.StUser localStUser = a((String)localObject1, ",nickname:");
          localObject2 = paramContext;
          String str = localStUser.id.get();
          localObject2 = paramContext;
          Object localObject3 = new StringBuilder();
          localObject2 = paramContext;
          ((StringBuilder)localObject3).append("@");
          localObject2 = paramContext;
          ((StringBuilder)localObject3).append(localStUser.nick);
          localObject2 = paramContext;
          ((StringBuilder)localObject3).append(" ");
          localObject2 = paramContext;
          localObject3 = ((StringBuilder)localObject3).toString();
          localObject2 = paramContext;
          paramRichSpannableStringBuilder.replace(j, k - i, (CharSequence)localObject3);
          localObject2 = paramContext;
          i += ((String)localObject1).length() - ((String)localObject3).length();
          localObject2 = paramContext;
          k = ((String)localObject3).length() + j;
          if (paramInt != -2147483648)
          {
            localObject2 = paramContext;
            paramRichSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), j, k, 33);
          }
          localObject2 = paramContext;
          paramRichSpannableStringBuilder.setSpan(new UserNameSapn(str, paramInt, paramOnUserNameClickListener), j, k, 33);
          localObject2 = paramContext;
          paramRichSpannableStringBuilder.setSpan(new StyleSpan(1), j, k, 33);
          localObject1 = paramContext;
          if (paramContext == null)
          {
            localObject2 = paramContext;
            localObject1 = new ArrayList();
          }
          localObject2 = localObject1;
          ((ArrayList)localObject1).add(localStUser);
          paramContext = (Context)localObject1;
        }
        else
        {
          return paramContext;
        }
      }
      catch (Exception paramContext) {}
    }
    return localObject2;
  }
  
  private static HashMap<String, ImageSpan> a(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig)
  {
    paramTextImageSpanConfig = paramTextImageSpanConfig.jdField_a_of_type_JavaLangCharSequence;
    if ((paramTextImageSpanConfig != null) && ((paramTextImageSpanConfig instanceof Spannable)))
    {
      paramTextImageSpanConfig = (Spannable)paramTextImageSpanConfig;
      int j = paramTextImageSpanConfig.length();
      int i = 0;
      paramTextImageSpanConfig = (ImageSpan[])paramTextImageSpanConfig.getSpans(0, j, ImageSpan.class);
      if (paramTextImageSpanConfig != null)
      {
        HashMap localHashMap = new HashMap();
        j = paramTextImageSpanConfig.length;
        while (i < j)
        {
          Object localObject = paramTextImageSpanConfig[i];
          localHashMap.put(localObject.getSource(), localObject);
          i += 1;
        }
        return localHashMap;
      }
    }
    return null;
  }
  
  private static void a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (!TextUtils.isEmpty(paramSpannableStringBuilder))
    {
      if (paramContext == null) {
        return;
      }
      Matcher localMatcher = Patterns.i.matcher(paramSpannableStringBuilder);
      int i = 0;
      while (localMatcher.find())
      {
        int k = localMatcher.start() - i;
        int j = localMatcher.end();
        String str2 = localMatcher.group();
        int m = str2.indexOf(",color:");
        int n = str2.indexOf(",useDefaultFont:");
        ColorStateList localColorStateList = null;
        int i1 = str2.indexOf("text:");
        Object localObject;
        if (i1 != -1)
        {
          localObject = str2.substring(m + 7, n);
          String str1 = str2.substring(i1 + 5, str2.indexOf(",color:"));
          Integer localInteger = (Integer)jdField_a_of_type_JavaUtilMap.get(localObject);
          localObject = str1;
          if (localInteger != null)
          {
            localColorStateList = paramContext.getResources().getColorStateList(localInteger.intValue());
            localObject = str1;
          }
        }
        else
        {
          localObject = "";
        }
        paramSpannableStringBuilder.replace(k, j - i, (CharSequence)localObject);
        j = i + (str2.length() - ((String)localObject).length());
        m = ((String)localObject).length();
        i = j;
        if (localColorStateList != null)
        {
          paramSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, (int)(paramContext.getResources().getDisplayMetrics().density * 14.0F), localColorStateList, null), k, m + k, 33);
          i = j;
        }
      }
    }
  }
  
  public static void a(Context paramContext, RichTextParser.RichSpannableStringBuilder paramRichSpannableStringBuilder, ColorStateList paramColorStateList, UserNameSapn.OnUserNameClickListener paramOnUserNameClickListener)
  {
    if (!TextUtils.isEmpty(paramRichSpannableStringBuilder))
    {
      if (paramContext == null) {
        return;
      }
      Matcher localMatcher = Patterns.jdField_a_of_type_JavaUtilRegexPattern.matcher(paramRichSpannableStringBuilder);
      int i = 0;
      while (localMatcher.find())
      {
        paramRichSpannableStringBuilder.a = true;
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        Object localObject = a(str1, ",nickname:");
        String str2 = ((CertifiedAccountMeta.StUser)localObject).id.get();
        localObject = ((CertifiedAccountMeta.StUser)localObject).nick.get();
        paramRichSpannableStringBuilder.replace(j, k - i, (CharSequence)localObject);
        k = str1.length();
        int m = ((String)localObject).length();
        int n = j + ((String)localObject).length();
        if (paramColorStateList != null) {
          paramRichSpannableStringBuilder.setSpan(new TextAppearanceSpan(null, 1, (int)(paramContext.getResources().getDisplayMetrics().density * 14.0F), paramColorStateList, null), j, n, 33);
        }
        paramRichSpannableStringBuilder.setSpan(new UserNameSapn(str2, paramColorStateList, paramOnUserNameClickListener), j, n, 33);
        i += k - m;
      }
    }
  }
  
  public static void a(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, RichTextParser.RichSpannableStringBuilder paramRichSpannableStringBuilder, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    a(paramTextImageSpanConfig, paramCharSequence, paramHashMap, paramRichSpannableStringBuilder, paramURLDrawableListener, true);
  }
  
  public static void a(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, RichTextParser.RichSpannableStringBuilder paramRichSpannableStringBuilder, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    if (paramRichSpannableStringBuilder == null) {
      return;
    }
    Matcher localMatcher = Patterns.g.matcher(paramRichSpannableStringBuilder);
    while (localMatcher.find())
    {
      paramRichSpannableStringBuilder.c = true;
      int i = localMatcher.start();
      int j = localMatcher.end();
      String str = paramRichSpannableStringBuilder.subSequence(i, j).toString();
      paramCharSequence = null;
      paramHashMap = paramCharSequence;
      if (paramBoolean)
      {
        paramHashMap = paramCharSequence;
        if (jdField_a_of_type_JavaUtilHashMap.containsKey(str)) {
          paramHashMap = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str);
        }
      }
      paramCharSequence = paramHashMap;
      if (paramHashMap == null) {
        if (QQSysFaceUtil.getLocalIdFromEMCode(str) != -1)
        {
          paramCharSequence = QQSysFaceUtil.getFaceDrawable(QQSysFaceUtil.getLocalIdFromEMCode(str));
        }
        else if (QQEmojiUtil.getLocalIdFromEMCode(str) != -1)
        {
          paramCharSequence = QQEmojiUtil.getEmojiDrawable(QQEmojiUtil.getLocalIdFromEMCode(str));
        }
        else
        {
          int k = str.indexOf("[em]") + 4;
          int m = str.indexOf("[/em]");
          if (k != -1)
          {
            if (m == -1) {
              return;
            }
            paramHashMap = str.substring(k, m);
          }
        }
      }
      try
      {
        paramCharSequence = QzoneEmotionUtils.getEmoUrlFromConfig(paramHashMap);
      }
      catch (Exception paramCharSequence)
      {
        label191:
        break label191;
      }
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("https://qzonestyle.gtimg.cn/qzone/em/");
      paramCharSequence.append(paramHashMap);
      paramCharSequence.append(".gif");
      paramCharSequence = paramCharSequence.toString();
      paramHashMap = URLDrawable.URLDrawableOptions.obtain();
      paramHashMap.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848488);
      paramHashMap = URLDrawable.getDrawable(paramCharSequence, paramHashMap);
      paramCharSequence = paramHashMap;
      if (paramHashMap != null)
      {
        paramCharSequence = paramHashMap;
        if (paramURLDrawableListener != null)
        {
          paramHashMap.setURLDrawableListener(paramURLDrawableListener);
          paramCharSequence = paramHashMap;
          break label277;
          return;
        }
      }
      label277:
      if (paramCharSequence != null)
      {
        if (paramBoolean) {
          jdField_a_of_type_JavaUtilHashMap.put(str, paramCharSequence);
        }
        paramCharSequence = a(paramTextImageSpanConfig, paramCharSequence);
        if (paramCharSequence != null) {
          paramRichSpannableStringBuilder.setSpan(paramCharSequence, i, j, 33);
        }
      }
    }
  }
  
  private static void b(RichTextParser.TextImageSpanConfig paramTextImageSpanConfig, CharSequence paramCharSequence, HashMap<String, ImageSpan> paramHashMap, RichTextParser.RichSpannableStringBuilder paramRichSpannableStringBuilder, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    if (TextUtils.isEmpty(paramRichSpannableStringBuilder)) {
      return;
    }
    Matcher localMatcher = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramRichSpannableStringBuilder);
    try
    {
      while (localMatcher.find())
      {
        String str2 = localMatcher.group(1);
        if (str2.startsWith("https://qzonestyle.gtimg.cn/"))
        {
          String str3 = localMatcher.group(2);
          String str4 = localMatcher.group(3);
          int i = localMatcher.start();
          int j = localMatcher.end();
          String str1 = paramRichSpannableStringBuilder.subSequence(i, j).toString();
          paramCharSequence = null;
          if (jdField_a_of_type_JavaUtilHashMap.containsKey(str1)) {
            paramCharSequence = (Drawable)jdField_a_of_type_JavaUtilHashMap.get(str1);
          }
          paramHashMap = paramCharSequence;
          if (paramCharSequence == null)
          {
            paramCharSequence = URLDrawable.URLDrawableOptions.obtain();
            try
            {
              int k = Integer.parseInt(str4);
              int m = Integer.parseInt(str3);
              if ((k > 0) && (m > 0))
              {
                paramCharSequence.mRequestHeight = k;
                paramCharSequence.mRequestWidth = m;
              }
            }
            catch (Exception paramHashMap)
            {
              QLog.e("RichTextParser", 1, paramHashMap, new Object[0]);
            }
            paramCharSequence.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848488);
            paramCharSequence = URLDrawable.getDrawable(str2, paramCharSequence);
            paramHashMap = paramCharSequence;
            if (paramCharSequence != null)
            {
              paramHashMap = paramCharSequence;
              if (paramURLDrawableListener != null)
              {
                paramCharSequence.setURLDrawableListener(paramURLDrawableListener);
                paramHashMap = paramCharSequence;
              }
            }
          }
          if (paramHashMap != null)
          {
            jdField_a_of_type_JavaUtilHashMap.put(str1, paramHashMap);
            paramCharSequence = a(paramTextImageSpanConfig, paramHashMap);
            if (paramCharSequence != null) {
              paramRichSpannableStringBuilder.setSpan(paramCharSequence, i, j, 33);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramTextImageSpanConfig)
    {
      paramTextImageSpanConfig.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.RichTextParser
 * JD-Core Version:    0.7.0.1
 */