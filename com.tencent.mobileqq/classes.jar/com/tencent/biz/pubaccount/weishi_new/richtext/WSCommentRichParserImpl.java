package com.tencent.biz.pubaccount.weishi_new.richtext;

import android.graphics.Color;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WSCommentRichParserImpl
  extends WSRichTextParserImpl
{
  private static final Pattern a = Pattern.compile("@?\\{uid:.*?,uidtype:.*?,nick:.*?\\}", 2);
  
  private String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i = paramString1.indexOf(paramString2) + paramString2.length();
    if (paramBoolean) {
      return paramString1.substring(i, paramString1.length() - 1);
    }
    int j = paramString1.indexOf(paramString3);
    if (j == -1) {
      return "";
    }
    return paramString1.substring(i, j);
  }
  
  public WSRichTextParserImpl.WSUser a(String paramString)
  {
    String str2 = a(paramString, "uid:", ",uidtype:", false);
    String str3 = a(paramString, ",uidtype:", ",nick:", false);
    paramString = a(paramString, ",nick:", "", true);
    try
    {
      String str1 = URLDecoder.decode(paramString);
      paramString = str1;
    }
    catch (Exception localException)
    {
      WSLog.d("WSCommentRichParserImpl", localException.getLocalizedMessage());
    }
    return new WSRichTextParserImpl.WSUser(str2, paramString, str3);
  }
  
  protected ArrayList<WSRichTextParserImpl.WSUser> a(WSRichTextParserImpl.InnerSpannableBuilder paramInnerSpannableBuilder, FeedRichTextView.OnElementClickListener paramOnElementClickListener)
  {
    if (TextUtils.isEmpty(paramInnerSpannableBuilder)) {
      return null;
    }
    Matcher localMatcher = a.matcher(paramInnerSpannableBuilder);
    localArrayList = new ArrayList();
    int i = 0;
    try
    {
      while (localMatcher.find())
      {
        int j = localMatcher.start() - i;
        int k = localMatcher.end();
        String str1 = localMatcher.group();
        WSRichTextParserImpl.WSUser localWSUser = a(str1);
        String str2 = localWSUser.a;
        if (TextUtils.isEmpty(localWSUser.b.trim())) {
          localWSUser.b = "微视用户";
        }
        if (localWSUser.b.length() > 9)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localWSUser.b.substring(0, 8));
          ((StringBuilder)localObject).append("...");
          localWSUser.b = ((StringBuilder)localObject).toString();
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" @");
        ((StringBuilder)localObject).append(localWSUser.b);
        ((StringBuilder)localObject).append(" ");
        localObject = ((StringBuilder)localObject).toString();
        paramInnerSpannableBuilder.replace(j, k - i, (CharSequence)localObject);
        i += str1.length() - ((String)localObject).length();
        k = ((String)localObject).length() + j;
        paramInnerSpannableBuilder.setSpan(new WSCommentRichParserImpl.1(this, paramOnElementClickListener, localWSUser, str2), j, k, 33);
        if (TextUtils.equals(localWSUser.c, "1")) {
          paramInnerSpannableBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#fe9526")), j, k, 33);
        }
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.richtext.WSCommentRichParserImpl
 * JD-Core Version:    0.7.0.1
 */