package com.tencent.biz.pubaccount.weishi_new.comment;

import NS_KING_SOCIALIZE_META.stMetaPerson;
import UserGrowth.stSimpleComment;
import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaPerson;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import java.util.List;

public class WSCommentUtil
{
  public static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, List<Friends> paramList, int paramInt3, int paramInt4, String paramString)
  {
    if (paramCharSequence != null)
    {
      int i = paramCharSequence.length();
      int j = 1;
      if (i <= 1) {
        return -1;
      }
      int k = Math.min(paramCharSequence.length(), paramInt1);
      i = k - 1;
      paramInt1 = j;
      while ((i >= 0) && (paramInt1 <= paramInt2))
      {
        if ((paramCharSequence.charAt(i) == '@') && (a(paramCharSequence.toString().substring(i, k), false, paramList, paramInt3, paramInt4, paramString))) {
          return i;
        }
        i -= 1;
        paramInt1 += 1;
      }
    }
    return -1;
  }
  
  public static stMetaPerson a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    return new stMetaPerson(paramstSimpleMetaPerson.id, paramstSimpleMetaPerson.type, paramstSimpleMetaPerson.uid, paramstSimpleMetaPerson.createtime, paramstSimpleMetaPerson.nick, paramstSimpleMetaPerson.avatar, paramstSimpleMetaPerson.sex, "", "", "", "", "", "", -1, 0, "");
  }
  
  public static stSimpleComment a(stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    stSimpleMetaPerson localstSimpleMetaPerson = paramstSimpleMetaComment.poster;
    if (!android.text.TextUtils.isEmpty(localstSimpleMetaPerson.nick)) {
      paramstSimpleMetaPerson = localstSimpleMetaPerson;
    }
    return new stSimpleComment(paramstSimpleMetaComment.id, paramstSimpleMetaComment.wording, paramstSimpleMetaComment.poster_id, a(paramstSimpleMetaPerson), paramstSimpleMetaComment.dingNum, paramstSimpleMetaComment.isDing, paramstSimpleMetaComment.feedId, null);
  }
  
  public static String a(QQTextBuilder paramQQTextBuilder)
  {
    int i = paramQQTextBuilder.length();
    Object localObject1 = new char[i];
    int j = 0;
    paramQQTextBuilder.getChars(0, i, (char[])localObject1, 0);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append((char[])localObject1);
    localObject1 = (EmoticonSpan[])paramQQTextBuilder.getSpans(0, i, EmoticonSpan.class);
    int m = localObject1.length;
    int k = 0;
    while (j < m)
    {
      Object localObject2 = localObject1[j];
      int n = paramQQTextBuilder.getSpanStart(localObject2);
      int i1 = paramQQTextBuilder.getSpanEnd(localObject2);
      i = ((EmoticonSpan)localObject2).emojiType;
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            break label236;
          }
          localObject2 = ((EmoticonSpan)localObject2).getDescription();
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
        else
        {
          localObject2 = QQSysFaceUtil.getFaceDescription(((EmoticonSpan)localObject2).index & 0x7FFFFFFF);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
      }
      for (;;)
      {
        k += i - (i1 - n);
        break label236;
        try
        {
          localObject2 = com.tencent.mobileqq.text.TextUtils.getEmojiString(((EmoticonSpan)localObject2).index);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject2);
          i = ((String)localObject2).length();
        }
        catch (Exception localException)
        {
          WSLog.d("WSCommentUtil", localException.getMessage());
        }
      }
      label236:
      j += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = paramView.getHeight();
    localLayoutParams.weight = 0.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  public static void a(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    paramWindow = paramWindow.getDecorView();
    if (!(paramWindow instanceof ViewGroup)) {
      return;
    }
    paramWindow = (ViewGroup)paramWindow;
    int i = 0;
    paramWindow = paramWindow.getChildAt(0);
    if (!(paramWindow instanceof ViewGroup)) {
      return;
    }
    paramWindow = (ViewGroup)paramWindow;
    int j = paramWindow.getChildCount();
    while (i < j)
    {
      View localView = paramWindow.getChildAt(i);
      if (localView == null) {
        return;
      }
      if (localView.getId() == 16908290) {
        return;
      }
      if (!(localView instanceof ViewStub)) {
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, String paramString)
  {
    return (paramInt1 != -1) && (paramInt2 != -1) && (paramString != null) && (paramString.length() > 0);
  }
  
  public static boolean a(String paramString1, boolean paramBoolean, List<Friends> paramList, int paramInt1, int paramInt2, String paramString2)
  {
    if (((a(paramInt1, paramInt2, paramString2)) || (!paramBoolean)) && (paramList != null))
    {
      paramInt2 = paramList.size();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString2 = (Friends)paramList.get(paramInt1);
        if ((paramString2 != null) && (paramString2.name != null) && (paramString1 != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("@");
          localStringBuilder.append(paramString2.name);
          if (!paramString1.equalsIgnoreCase(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("@");
            localStringBuilder.append(paramString2.name);
            localStringBuilder.append(" ");
            if (!paramString1.equalsIgnoreCase(localStringBuilder.toString())) {}
          }
          else
          {
            if (paramBoolean) {
              paramList.remove(paramInt1);
            }
            return true;
          }
        }
        paramInt1 += 1;
      }
    }
    return false;
  }
  
  public static void b(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.height = 0;
    localLayoutParams.weight = 1.0F;
    paramView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WSCommentUtil
 * JD-Core Version:    0.7.0.1
 */