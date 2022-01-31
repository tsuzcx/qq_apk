package com.tencent.biz.qqstory.storyHome.detail.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.comment.StoryQQTextCacher;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TroopNickNameManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import nzj;

public class SpannableStringUtils
{
  public static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    if (paramCommentEntry.commentType == 1) {
      return c(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
    }
    if (paramCommentEntry.commentType == 2) {
      return d(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
    }
    return b(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
  }
  
  public static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, List paramList, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str1 = paramCommentLikeFeedItem.feedId + "_" + paramList.hashCode();
    Object localObject = StoryQQTextCacher.a().a(str1);
    if ((localObject != null) && ((localObject instanceof SpannableStringBuilder))) {
      return new SpannableStringBuilder((CharSequence)localObject);
    }
    boolean bool;
    if ((paramCommentLikeFeedItem.getOwner() != null) && (paramCommentLikeFeedItem.getOwner().getRelationType() == 2))
    {
      bool = true;
      if (!(paramCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
        break label423;
      }
      paramCommentLikeFeedItem = (QQUserUIItem)paramCommentLikeFeedItem.getOwner();
      if (!bool) {
        break label423;
      }
    }
    label261:
    label392:
    label423:
    for (paramCommentLikeFeedItem = paramCommentLikeFeedItem.qq;; paramCommentLikeFeedItem = null)
    {
      int i = 1;
      int j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          LikeEntry localLikeEntry = (LikeEntry)paramList.get(j);
          localObject = ((UserManager)SuperManager.a(2)).c(localLikeEntry.unionId);
          if ((localObject == null) || (!((QQUserUIItem)localObject).isAvailable()))
          {
            i = 0;
            j += 1;
            continue;
            bool = false;
            break;
          }
          String str2 = a((QQUserUIItem)localObject);
          int k;
          label220:
          String str3;
          StringBuilder localStringBuilder;
          if (!android.text.TextUtils.isEmpty(str2))
          {
            k = 1;
            str3 = a(localLikeEntry.unionId, localLikeEntry.uin, bool, paramCommentLikeFeedItem);
            localStringBuilder = new StringBuilder().append(str3);
            if (k == 0) {
              break label385;
            }
            localObject = "V";
            localStringBuilder = localStringBuilder.append((String)localObject);
            if (j != paramList.size() - 1) {
              break label392;
            }
          }
          for (localObject = "";; localObject = ", ")
          {
            localObject = (String)localObject;
            int m = localSpannableStringBuilder.length();
            int n = ((String)localObject).length() + m;
            localSpannableStringBuilder.append((CharSequence)localObject);
            int i1 = str3.length() + m;
            if (k != 0) {
              a(localSpannableStringBuilder, str2, i1, i1 + 1);
            }
            a(localSpannableStringBuilder, m, n);
            a(localSpannableStringBuilder, m, n, paramClickNickCallback, localLikeEntry.unionId);
            break;
            k = 0;
            break label220;
            localObject = "";
            break label261;
          }
        }
      }
      if (i != 0) {
        StoryQQTextCacher.a().a(str1, localSpannableStringBuilder);
      }
      return new SpannableStringBuilder(localSpannableStringBuilder);
    }
  }
  
  private static String a(int paramInt, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramInt == 0) || (paramInt == 2)) {
      return "";
    }
    if (paramQQUserUIItem == null) {
      return "";
    }
    if (android.text.TextUtils.isEmpty(paramQQUserUIItem.nickPostfix)) {
      return "";
    }
    return paramQQUserUIItem.nickPostfix;
  }
  
  private static String a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null) {
      return null;
    }
    return paramQQUserUIItem.getUserIconUrl();
  }
  
  private static String a(CommentLikeFeedItem paramCommentLikeFeedItem, QQUserUIItem paramQQUserUIItem)
  {
    int i;
    if ((paramCommentLikeFeedItem instanceof VideoListFeedItem))
    {
      paramCommentLikeFeedItem = (VideoListFeedItem)paramCommentLikeFeedItem;
      if ((paramCommentLikeFeedItem != null) && (paramCommentLikeFeedItem.getOwner() != null) && (paramCommentLikeFeedItem.getOwner().getRelationType() == 2))
      {
        i = 1;
        if ((i == 0) || (!(paramCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))) {
          break label93;
        }
        paramCommentLikeFeedItem = ((QQUserUIItem)paramCommentLikeFeedItem.getOwner()).qq;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return ((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramCommentLikeFeedItem, false, false);
        i = 0;
        break;
      }
      return PlayModeUtils.a(paramQQUserUIItem);
      label93:
      paramCommentLikeFeedItem = null;
      continue;
      paramCommentLikeFeedItem = null;
      i = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    paramString1 = ((UserManager)SuperManager.a(2)).c(paramString1);
    if (paramBoolean) {
      return ((TroopNickNameManager)SuperManager.a(23)).a(paramString1, paramString3, false, false);
    }
    return PlayModeUtils.a(paramString1);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt1, paramInt2, 33);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramInt3, 15, 15);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 2);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt4 = UIUtils.a(BaseApplicationImpl.getContext(), paramInt4);
    paramInt5 = UIUtils.a(BaseApplicationImpl.getContext(), paramInt5);
    Object localObject = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt3);
    ((Drawable)localObject).setBounds(0, 0, paramInt4, paramInt5);
    if (paramInt6 == 1) {
      localObject = new ImageSpan((Drawable)localObject, 1);
    }
    for (;;)
    {
      paramSpannableStringBuilder.setSpan(localObject, paramInt1, paramInt2, 33);
      return;
      if (paramInt6 == 0) {
        localObject = new ImageSpan((Drawable)localObject, 0);
      } else {
        localObject = new VerticalImageSpan((Drawable)localObject);
      }
    }
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramClickNickCallback, paramString, 0);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new nzj(paramClickNickCallback, paramString, paramInt3), paramInt1, paramInt2, 33);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramString.getStatus() != 1) {
      paramString.startDownload();
    }
    int i = UIUtils.a(BaseApplicationImpl.getContext(), 13.0F);
    paramString.setBounds(0, 0, i, i);
    paramSpannableStringBuilder.setSpan(new VerticalImageSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  private static SpannableStringBuilder b(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject3 = ((UserManager)localObject1).c(paramCommentEntry.authorUnionId);
    String str2 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject3);
    String str3 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject3);
    Object localObject2;
    String str1;
    if (paramCommentEntry.isReply())
    {
      localObject2 = ((UserManager)localObject1).c(paramCommentEntry.replierUnionId);
      str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject2);
      localObject1 = a(paramCommentEntry.replierRole, (QQUserUIItem)localObject2);
    }
    for (paramCommentLikeFeedItem = (CommentLikeFeedItem)localObject2;; paramCommentLikeFeedItem = null)
    {
      String str4 = a((QQUserUIItem)localObject3);
      String str5 = a(paramCommentLikeFeedItem);
      int i;
      int j;
      label120:
      String str6;
      if (!android.text.TextUtils.isEmpty(str4))
      {
        i = 1;
        if ((!paramCommentEntry.isReply()) || (android.text.TextUtils.isEmpty(str5))) {
          break label408;
        }
        j = 1;
        str6 = paramCommentEntry.content;
        paramCommentLikeFeedItem = null;
        if (com.tencent.mobileqq.text.TextUtils.a(paramCommentEntry.content)) {
          paramCommentLikeFeedItem = MessageUtils.b(paramCommentEntry.content);
        }
        if (i == 0) {
          break label414;
        }
        localObject2 = "V";
        label154:
        if (j == 0) {
          break label421;
        }
        localObject3 = "V";
        label163:
        if (!android.text.TextUtils.isEmpty(str1)) {
          break label475;
        }
        if (paramCommentLikeFeedItem == null) {
          break label428;
        }
      }
      label408:
      label414:
      label421:
      label428:
      for (paramCommentLikeFeedItem = new QQTextBuilder(str2 + (String)localObject2 + str3 + ": " + paramCommentLikeFeedItem, 3, 16);; paramCommentLikeFeedItem = new SpannableStringBuilder(str2 + (String)localObject2 + str3 + ": " + str6))
      {
        j = str2.length();
        a(paramCommentLikeFeedItem, 0, j);
        if (StoryDepends.a()) {
          b(paramCommentLikeFeedItem, 0, j, -16777216);
        }
        i = j + ((String)localObject2).length();
        if (j != i) {
          a(paramCommentLikeFeedItem, str4, j, i);
        }
        a(paramCommentLikeFeedItem, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
        j = str3.length() + i;
        paramClickNickCallback = paramCommentLikeFeedItem;
        if (i != j)
        {
          b(paramCommentLikeFeedItem, i, j, -4473925);
          paramClickNickCallback = paramCommentLikeFeedItem;
        }
        if (paramCommentEntry.status == 2)
        {
          paramClickNickCallback.append(" ");
          i = paramClickNickCallback.length();
          j = "评论失败".length();
          paramClickNickCallback.append("评论失败");
          b(paramClickNickCallback, i, j + i, -48606);
          i = paramClickNickCallback.length();
          j = "[icon]  ".length();
          paramClickNickCallback.append("[icon]  ");
          a(paramClickNickCallback, i, j + i, 2130845101);
        }
        return paramClickNickCallback;
        i = 0;
        break;
        j = 0;
        break label120;
        localObject2 = "";
        break label154;
        localObject3 = "";
        break label163;
      }
      label475:
      if (paramCommentLikeFeedItem != null) {}
      for (paramCommentLikeFeedItem = new QQTextBuilder(str2 + (String)localObject2 + str3 + "回复" + str1 + (String)localObject3 + (String)localObject1 + ": " + paramCommentLikeFeedItem, 3, 14);; paramCommentLikeFeedItem = new SpannableStringBuilder(str2 + (String)localObject2 + str3 + "回复" + str1 + (String)localObject3 + (String)localObject1 + ": " + str6))
      {
        j = str2.length();
        a(paramCommentLikeFeedItem, 0, j);
        if (StoryDepends.a()) {
          b(paramCommentLikeFeedItem, 0, j, -16777216);
        }
        i = j + ((String)localObject2).length();
        if (j != i) {
          a(paramCommentLikeFeedItem, str4, j, i);
        }
        a(paramCommentLikeFeedItem, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
        j = str3.length() + i;
        if (i != j) {
          b(paramCommentLikeFeedItem, i, j, -4473925);
        }
        j += "回复".length();
        i = j + str1.length();
        a(paramCommentLikeFeedItem, j, i);
        if (StoryDepends.a()) {
          b(paramCommentLikeFeedItem, j, i, -16777216);
        }
        j = i + ((String)localObject3).length();
        if (i != j) {
          a(paramCommentLikeFeedItem, str5, i, j);
        }
        a(paramCommentLikeFeedItem, i - str1.length(), j, paramClickNickCallback, paramCommentEntry.replierUnionId, paramCommentEntry.replierRole);
        i = ((String)localObject1).length() + j;
        paramClickNickCallback = paramCommentLikeFeedItem;
        if (j == i) {
          break;
        }
        b(paramCommentLikeFeedItem, j, i, -4473925);
        paramClickNickCallback = paramCommentLikeFeedItem;
        break;
      }
      localObject1 = "";
      str1 = null;
    }
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
  }
  
  private static SpannableStringBuilder c(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject);
    String str3 = a((QQUserUIItem)localObject);
    int i;
    String str4;
    if (!android.text.TextUtils.isEmpty(str3))
    {
      i = 1;
      str4 = paramCommentEntry.content;
      localObject = null;
      if (com.tencent.mobileqq.text.TextUtils.a(paramCommentEntry.content)) {
        localObject = MessageUtils.b(paramCommentEntry.content);
      }
      if (i == 0) {
        break label270;
      }
      paramCommentLikeFeedItem = "V";
      label87:
      if (localObject == null) {
        break label276;
      }
    }
    label270:
    label276:
    for (localObject = new QQTextBuilder(str1 + paramCommentLikeFeedItem + str2 + " 选择 " + ": " + (String)localObject, 3, 16);; localObject = new SpannableStringBuilder(str1 + paramCommentLikeFeedItem + str2 + " 选择 " + ": " + str4))
    {
      int j = str1.length();
      a((SpannableStringBuilder)localObject, 0, j);
      if (StoryDepends.a()) {
        b((SpannableStringBuilder)localObject, 0, j, -16777216);
      }
      i = paramCommentLikeFeedItem.length() + j;
      if (j != i) {
        a((SpannableStringBuilder)localObject, str3, j, i);
      }
      a((SpannableStringBuilder)localObject, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = str2.length() + i;
      if (i != j) {
        b((SpannableStringBuilder)localObject, i, j, -4473925);
      }
      b((SpannableStringBuilder)localObject, j, " 选择 ".length() + j, -4473925);
      return localObject;
      i = 0;
      break;
      paramCommentLikeFeedItem = "";
      break label87;
    }
  }
  
  private static SpannableStringBuilder d(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject);
    localObject = a((QQUserUIItem)localObject);
    int i;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      label52:
      if (i == 0) {
        break label312;
      }
    }
    SpannableStringBuilder localSpannableStringBuilder;
    int k;
    int j;
    label312:
    for (paramCommentLikeFeedItem = "V";; paramCommentLikeFeedItem = "")
    {
      i = Integer.parseInt(paramCommentEntry.content);
      localSpannableStringBuilder = new SpannableStringBuilder(str1 + paramCommentLikeFeedItem + str2 + " 评分 " + ": " + "A");
      k = str1.length();
      a(localSpannableStringBuilder, 0, k);
      if (StoryDepends.a()) {
        b(localSpannableStringBuilder, 0, k, -16777216);
      }
      j = k + paramCommentLikeFeedItem.length();
      if (k != j) {
        a(localSpannableStringBuilder, (String)localObject, k, j);
      }
      a(localSpannableStringBuilder, 0, j, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      k = str2.length() + j;
      if (j != k) {
        b(localSpannableStringBuilder, j, k, -4473925);
      }
      j = " 评分 ".length() + k;
      b(localSpannableStringBuilder, k, j, -4473925);
      j = ": ".length() + j;
      k = "A".length() + j;
      switch (i)
      {
      default: 
        return localSpannableStringBuilder;
        i = 0;
        break label52;
      }
    }
    a(localSpannableStringBuilder, j, k, 2130841994, 37, 16);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130841996, 37, 16);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130841995, 37, 16);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130841993, 37, 16);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130841992, 37, 16);
    return localSpannableStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils
 * JD-Core Version:    0.7.0.1
 */