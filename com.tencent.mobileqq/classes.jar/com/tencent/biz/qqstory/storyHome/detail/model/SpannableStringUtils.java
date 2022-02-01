package com.tencent.biz.qqstory.storyHome.detail.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.FloatRange;
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
import com.tencent.biz.qqstory.view.widget.AlignImageSpan;
import com.tencent.biz.qqstory.view.widget.VerticalImageSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpannableStringUtils
{
  public static SpannableStringBuilder a(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    if (paramCommentEntry.commentType == 1) {
      return c(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
    }
    if (paramCommentEntry.commentType == 2) {
      return d(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
    }
    if (paramCommentEntry.commentType == 5) {
      return c(paramContext, paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
    }
    if (paramCommentEntry.commentType == 4) {
      return a(paramContext, paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback, true);
    }
    return a(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
  }
  
  private static SpannableStringBuilder a(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback, boolean paramBoolean)
  {
    paramContext = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, paramContext);
    String str2 = a(paramCommentEntry.authorRole, paramContext);
    String str3 = a(paramContext);
    boolean bool = android.text.TextUtils.isEmpty(str3);
    Object localObject2 = paramCommentEntry.content;
    paramCommentLikeFeedItem = null;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramCommentEntry.content)) {
      paramCommentLikeFeedItem = EmotionCodecUtils.c(paramCommentEntry.content);
    }
    int i;
    if (paramBoolean) {
      i = 2131911632;
    } else {
      i = 2131911635;
    }
    String str4 = HardCodeUtil.a(i);
    Object localObject1 = "";
    if ((bool ^ true)) {
      paramContext = "V";
    } else {
      paramContext = "";
    }
    if (paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(str2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (paramCommentLikeFeedItem != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append(paramCommentLikeFeedItem);
      paramCommentLikeFeedItem = new QQTextBuilder(((StringBuilder)localObject2).toString(), 3, 16);
    }
    else
    {
      paramCommentLikeFeedItem = new StringBuilder();
      paramCommentLikeFeedItem.append((String)localObject1);
      paramCommentLikeFeedItem.append(str4);
      paramCommentLikeFeedItem.append(": ");
      paramCommentLikeFeedItem.append(localObject2);
      paramCommentLikeFeedItem = new SpannableStringBuilder(paramCommentLikeFeedItem.toString());
    }
    if (paramBoolean)
    {
      i = str1.length();
      a(paramCommentLikeFeedItem, 0, i);
      if (StoryDepends.a()) {
        b(paramCommentLikeFeedItem, 0, i, -16777216);
      }
      k = paramContext.length() + i;
      if (i != k) {
        a(paramCommentLikeFeedItem, str3, i, k);
      }
      a(paramCommentLikeFeedItem, 0, k, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = k + str2.length();
      i = j;
      if (k != j)
      {
        b(paramCommentLikeFeedItem, k, j, -4473925);
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    int j = 0;
    int k = str4.length() + i;
    b(paramCommentLikeFeedItem, i, k, -4473925);
    try
    {
      paramContext = paramCommentEntry.getExtraJson().optJSONArray("styles");
      if (paramContext == null) {
        break label506;
      }
      k += 2;
      i = j;
      while (i < paramContext.length())
      {
        paramCommentEntry = paramContext.optJSONObject(i);
        if (paramCommentEntry.optInt("type") == 1) {
          b(paramCommentLikeFeedItem, paramCommentEntry.optInt("start") + k, paramCommentEntry.optInt("end") + k, -605655);
        }
        i += 1;
      }
    }
    catch (Exception paramContext)
    {
      label492:
      break label492;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.qqstory.detail.SpannableStringUtils", 2, "styles error.");
    }
    label506:
    paramCommentLikeFeedItem.append(" ").append("I");
    a(paramCommentLikeFeedItem, paramCommentLikeFeedItem.length() - 1, paramCommentLikeFeedItem.length(), 2130848243, 15, 15, 3);
    return paramCommentLikeFeedItem;
  }
  
  private static SpannableStringBuilder a(@NonNull CommentEntry paramCommentEntry)
  {
    Object localObject = paramCommentEntry.content;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramCommentEntry.content)) {
      paramCommentEntry = EmotionCodecUtils.c(paramCommentEntry.content);
    } else {
      paramCommentEntry = null;
    }
    String str = HardCodeUtil.a(2131911633);
    if (paramCommentEntry != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(": ");
      ((StringBuilder)localObject).append(paramCommentEntry);
      paramCommentEntry = new QQTextBuilder(((StringBuilder)localObject).toString(), 3, 16);
    }
    else
    {
      paramCommentEntry = new StringBuilder();
      paramCommentEntry.append(str);
      paramCommentEntry.append(": ");
      paramCommentEntry.append(localObject);
      paramCommentEntry = new SpannableStringBuilder(paramCommentEntry.toString());
    }
    b(paramCommentEntry, 0, str.length(), -4473925);
    return paramCommentEntry;
  }
  
  private static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject1 = (UserManager)SuperManager.a(2);
    Object localObject3 = ((UserManager)localObject1).c(paramCommentEntry.authorUnionId);
    String str4 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject3);
    String str5 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject3);
    boolean bool = paramCommentEntry.isReply();
    String str2 = "";
    String str1 = null;
    Object localObject2;
    if (bool)
    {
      localObject2 = ((UserManager)localObject1).c(paramCommentEntry.replierUnionId);
      localObject1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject2);
      str3 = a(paramCommentEntry.replierRole, (QQUserUIItem)localObject2);
      paramCommentLikeFeedItem = (CommentLikeFeedItem)localObject2;
      localObject2 = str3;
    }
    else
    {
      localObject2 = "";
      localObject1 = null;
      paramCommentLikeFeedItem = (CommentLikeFeedItem)localObject1;
    }
    String str3 = a((QQUserUIItem)localObject3);
    localObject3 = a(paramCommentLikeFeedItem);
    bool = android.text.TextUtils.isEmpty(str3);
    int i = 1;
    if ((!paramCommentEntry.isReply()) || (android.text.TextUtils.isEmpty((CharSequence)localObject3))) {
      i = 0;
    }
    Object localObject4 = paramCommentEntry.content;
    paramCommentLikeFeedItem = str1;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramCommentEntry.content)) {
      paramCommentLikeFeedItem = EmotionCodecUtils.c(paramCommentEntry.content);
    }
    String str6 = HardCodeUtil.a(2131911638);
    if ((bool ^ true)) {
      str1 = "V";
    } else {
      str1 = "";
    }
    if (i != 0) {
      str2 = "V";
    }
    int j;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (paramCommentLikeFeedItem != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str4);
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(str5);
        ((StringBuilder)localObject1).append(": ");
        ((StringBuilder)localObject1).append(paramCommentLikeFeedItem);
        paramCommentLikeFeedItem = new QQTextBuilder(((StringBuilder)localObject1).toString(), 3, 16);
      }
      else
      {
        paramCommentLikeFeedItem = new StringBuilder();
        paramCommentLikeFeedItem.append(str4);
        paramCommentLikeFeedItem.append(str1);
        paramCommentLikeFeedItem.append(str5);
        paramCommentLikeFeedItem.append(": ");
        paramCommentLikeFeedItem.append(localObject4);
        paramCommentLikeFeedItem = new SpannableStringBuilder(paramCommentLikeFeedItem.toString());
      }
      j = str4.length();
      a(paramCommentLikeFeedItem, 0, j);
      if (StoryDepends.a()) {
        b(paramCommentLikeFeedItem, 0, j, -16777216);
      }
      i = str1.length() + j;
      if (j != i) {
        a(paramCommentLikeFeedItem, str3, j, i);
      }
      a(paramCommentLikeFeedItem, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = str5.length() + i;
      paramClickNickCallback = paramCommentLikeFeedItem;
      if (i != j)
      {
        b(paramCommentLikeFeedItem, i, j, -4473925);
        paramClickNickCallback = paramCommentLikeFeedItem;
      }
    }
    else
    {
      if (paramCommentLikeFeedItem != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str4);
        ((StringBuilder)localObject4).append(str1);
        ((StringBuilder)localObject4).append(str5);
        ((StringBuilder)localObject4).append(str6);
        ((StringBuilder)localObject4).append((String)localObject1);
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(": ");
        ((StringBuilder)localObject4).append(paramCommentLikeFeedItem);
        paramCommentLikeFeedItem = new QQTextBuilder(((StringBuilder)localObject4).toString(), 3, 14);
      }
      else
      {
        paramCommentLikeFeedItem = new StringBuilder();
        paramCommentLikeFeedItem.append(str4);
        paramCommentLikeFeedItem.append(str1);
        paramCommentLikeFeedItem.append(str5);
        paramCommentLikeFeedItem.append(str6);
        paramCommentLikeFeedItem.append((String)localObject1);
        paramCommentLikeFeedItem.append(str2);
        paramCommentLikeFeedItem.append((String)localObject2);
        paramCommentLikeFeedItem.append(": ");
        paramCommentLikeFeedItem.append(localObject4);
        paramCommentLikeFeedItem = new SpannableStringBuilder(paramCommentLikeFeedItem.toString());
      }
      j = str4.length();
      a(paramCommentLikeFeedItem, 0, j);
      if (StoryDepends.a()) {
        b(paramCommentLikeFeedItem, 0, j, -16777216);
      }
      i = str1.length() + j;
      if (j != i) {
        a(paramCommentLikeFeedItem, str3, j, i);
      }
      a(paramCommentLikeFeedItem, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = str5.length() + i;
      if (i != j) {
        b(paramCommentLikeFeedItem, i, j, -4473925);
      }
      j += str6.length();
      i = ((String)localObject1).length() + j;
      a(paramCommentLikeFeedItem, j, i);
      if (StoryDepends.a()) {
        b(paramCommentLikeFeedItem, j, i, -16777216);
      }
      j = str2.length() + i;
      if (i != j) {
        a(paramCommentLikeFeedItem, (String)localObject3, i, j);
      }
      a(paramCommentLikeFeedItem, i - ((String)localObject1).length(), j, paramClickNickCallback, paramCommentEntry.replierUnionId, paramCommentEntry.replierRole);
      i = ((String)localObject2).length() + j;
      if (j != i) {
        b(paramCommentLikeFeedItem, j, i, -4473925);
      }
      paramClickNickCallback = paramCommentLikeFeedItem;
    }
    if (paramCommentEntry.status == 2)
    {
      paramClickNickCallback.append(" ");
      paramCommentLikeFeedItem = HardCodeUtil.a(2131911637);
      i = paramClickNickCallback.length();
      j = paramCommentLikeFeedItem.length();
      paramClickNickCallback.append(paramCommentLikeFeedItem);
      b(paramClickNickCallback, i, j + i, -48606);
      i = paramClickNickCallback.length();
      paramClickNickCallback.append("[icon]  ");
      a(paramClickNickCallback, i, i + 8, 2130850603);
    }
    return paramClickNickCallback;
  }
  
  public static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, List<LikeEntry> paramList, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCommentLikeFeedItem.feedId);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramList.hashCode());
    String str2 = ((StringBuilder)localObject).toString();
    localObject = StoryQQTextCacher.a().a(str2);
    if ((localObject != null) && ((localObject instanceof SpannableStringBuilder))) {
      return new SpannableStringBuilder((CharSequence)localObject);
    }
    boolean bool2;
    if ((paramCommentLikeFeedItem.getOwner() != null) && (paramCommentLikeFeedItem.getOwner().getRelationType() == 2)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str1 = null;
    localObject = str1;
    if ((paramCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))
    {
      paramCommentLikeFeedItem = (QQUserUIItem)paramCommentLikeFeedItem.getOwner();
      localObject = str1;
      if (bool2) {
        localObject = paramCommentLikeFeedItem.qq;
      }
    }
    int i = 0;
    int j = 1;
    while (i < paramList.size())
    {
      LikeEntry localLikeEntry = (LikeEntry)paramList.get(i);
      paramCommentLikeFeedItem = ((UserManager)SuperManager.a(2)).c(localLikeEntry.unionId);
      if ((paramCommentLikeFeedItem != null) && (paramCommentLikeFeedItem.isAvailable()))
      {
        String str3 = a(paramCommentLikeFeedItem);
        boolean bool1 = android.text.TextUtils.isEmpty(str3) ^ true;
        String str4 = a(localLikeEntry.unionId, localLikeEntry.uin, bool2, (String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str4);
        str1 = "";
        if (bool1) {
          paramCommentLikeFeedItem = "V";
        } else {
          paramCommentLikeFeedItem = "";
        }
        localStringBuilder.append(paramCommentLikeFeedItem);
        if (i == paramList.size() - 1) {
          paramCommentLikeFeedItem = str1;
        } else {
          paramCommentLikeFeedItem = ", ";
        }
        localStringBuilder.append(paramCommentLikeFeedItem);
        paramCommentLikeFeedItem = localStringBuilder.toString();
        int k = localSpannableStringBuilder.length();
        int m = paramCommentLikeFeedItem.length() + k;
        localSpannableStringBuilder.append(paramCommentLikeFeedItem);
        int n = str4.length() + k;
        if (bool1) {
          a(localSpannableStringBuilder, str3, n, n + 1);
        }
        a(localSpannableStringBuilder, k, m);
        a(localSpannableStringBuilder, k, m, paramClickNickCallback, localLikeEntry.unionId);
      }
      else
      {
        j = 0;
      }
      i += 1;
    }
    if (j != 0) {
      StoryQQTextCacher.a().a(str2, localSpannableStringBuilder);
    }
    return new SpannableStringBuilder(localSpannableStringBuilder);
  }
  
  private static String a(int paramInt, QQUserUIItem paramQQUserUIItem)
  {
    if (paramInt != 0)
    {
      if (paramInt == 2) {
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
    return "";
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
    boolean bool = paramCommentLikeFeedItem instanceof VideoListFeedItem;
    Object localObject = null;
    int j;
    if (bool)
    {
      VideoListFeedItem localVideoListFeedItem = (VideoListFeedItem)paramCommentLikeFeedItem;
      int i;
      if ((localVideoListFeedItem != null) && (localVideoListFeedItem.getOwner() != null) && (localVideoListFeedItem.getOwner().getRelationType() == 2)) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      paramCommentLikeFeedItem = localObject;
      if (i != 0)
      {
        j = i;
        paramCommentLikeFeedItem = localObject;
        if ((localVideoListFeedItem.getOwner() instanceof QQUserUIItem))
        {
          paramCommentLikeFeedItem = ((QQUserUIItem)localVideoListFeedItem.getOwner()).qq;
          j = i;
        }
      }
    }
    else
    {
      j = 0;
      paramCommentLikeFeedItem = localObject;
    }
    if (j != 0) {
      return ((TroopNickNameManager)SuperManager.a(23)).a(paramQQUserUIItem, paramCommentLikeFeedItem, false, false);
    }
    return PlayModeUtils.a(paramQQUserUIItem);
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
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 1.0F);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    paramInt4 = UIUtils.a(BaseApplicationImpl.getContext(), paramInt4);
    paramInt5 = UIUtils.a(BaseApplicationImpl.getContext(), paramInt5);
    Object localObject = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt3);
    ((Drawable)localObject).setBounds(0, 0, paramInt4, paramInt5);
    ((Drawable)localObject).setAlpha((int)(paramFloat * 255.0F));
    if (paramInt6 == 1) {
      localObject = new ImageSpan((Drawable)localObject, 1);
    } else if (paramInt6 == 0) {
      localObject = new ImageSpan((Drawable)localObject, 0);
    } else if (paramInt6 == 3) {
      localObject = new AlignImageSpan((Drawable)localObject);
    } else {
      localObject = new VerticalImageSpan((Drawable)localObject);
    }
    paramSpannableStringBuilder.setSpan(localObject, paramInt1, paramInt2, 33);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramClickNickCallback, paramString, 0);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, SpannableStringUtils.ClickNickCallback paramClickNickCallback, String paramString, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new SpannableStringUtils.1(paramClickNickCallback, paramString, paramInt3), paramInt1, paramInt2, 33);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramString.getStatus() != 1) {
      paramString.startDownload();
    }
    int i = UIUtils.a(BaseApplicationImpl.getContext(), 13.0F);
    paramString.setBounds(0, 0, i, i);
    paramSpannableStringBuilder.setSpan(new VerticalImageSpan(paramString), paramInt1, paramInt2, 33);
  }
  
  public static SpannableStringBuilder b(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    if (paramCommentEntry.commentType == 1) {
      return a(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 2) {
      return b(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 5) {
      return c(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 4) {
      return a(paramContext, paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback, false);
    }
    return b(paramCommentLikeFeedItem, paramCommentEntry, paramClickNickCallback);
  }
  
  private static SpannableStringBuilder b(@NonNull CommentEntry paramCommentEntry)
  {
    String str = HardCodeUtil.a(2131911634);
    int i = Integer.parseInt(paramCommentEntry.content);
    paramCommentEntry = new StringBuilder();
    paramCommentEntry.append(str);
    paramCommentEntry.append(": ");
    paramCommentEntry.append("A");
    paramCommentEntry = new SpannableStringBuilder(paramCommentEntry.toString());
    int j = str.length();
    b(paramCommentEntry, 0, j, -4473925);
    j += 2;
    int k = j + 1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return paramCommentEntry;
            }
            a(paramCommentEntry, j, k, 2130845982, 37, 16);
            return paramCommentEntry;
          }
          a(paramCommentEntry, j, k, 2130845983, 37, 16);
          return paramCommentEntry;
        }
        a(paramCommentEntry, j, k, 2130845985, 37, 16);
        return paramCommentEntry;
      }
      a(paramCommentEntry, j, k, 2130845986, 37, 16);
      return paramCommentEntry;
    }
    a(paramCommentEntry, j, k, 2130845984, 37, 16);
    return paramCommentEntry;
  }
  
  private static SpannableStringBuilder b(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject1 = (UserManager)SuperManager.a(2);
    boolean bool = paramCommentEntry.isReply();
    Object localObject4 = "";
    Object localObject3 = null;
    if (bool)
    {
      localObject2 = ((UserManager)localObject1).c(paramCommentEntry.replierUnionId);
      localObject1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject2);
      paramCommentLikeFeedItem = a(paramCommentEntry.replierRole, (QQUserUIItem)localObject2);
    }
    else
    {
      paramCommentLikeFeedItem = "";
      localObject1 = null;
      localObject2 = localObject1;
    }
    String str1 = a((QQUserUIItem)localObject2);
    if ((paramCommentEntry.isReply()) && (!android.text.TextUtils.isEmpty(str1))) {
      i = 1;
    } else {
      i = 0;
    }
    String str3 = paramCommentEntry.content;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramCommentEntry.content)) {
      localObject3 = EmotionCodecUtils.c(paramCommentEntry.content);
    }
    String str2 = HardCodeUtil.a(2131911626);
    Object localObject2 = localObject4;
    if (i != 0) {
      localObject2 = "V";
    }
    if (android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (localObject3 != null) {
        return new QQTextBuilder((CharSequence)localObject3, 3, 16);
      }
      return new SpannableStringBuilder(str3);
    }
    if (localObject3 != null)
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str2);
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append((String)localObject2);
      ((StringBuilder)localObject4).append(paramCommentLikeFeedItem);
      ((StringBuilder)localObject4).append(": ");
      ((StringBuilder)localObject4).append((String)localObject3);
      localObject3 = new QQTextBuilder(((StringBuilder)localObject4).toString(), 3, 14);
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str2);
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append(paramCommentLikeFeedItem);
      ((StringBuilder)localObject3).append(": ");
      ((StringBuilder)localObject3).append(str3);
      localObject3 = new SpannableStringBuilder(((StringBuilder)localObject3).toString());
    }
    int j = str2.length();
    int i = ((String)localObject1).length() + j;
    a((SpannableStringBuilder)localObject3, j, i);
    if (StoryDepends.a()) {
      b((SpannableStringBuilder)localObject3, j, i, -16777216);
    }
    j = ((String)localObject2).length() + i;
    if (i != j) {
      a((SpannableStringBuilder)localObject3, str1, i, j);
    }
    a((SpannableStringBuilder)localObject3, i - ((String)localObject1).length(), j, paramClickNickCallback, paramCommentEntry.replierUnionId, paramCommentEntry.replierRole);
    i = paramCommentLikeFeedItem.length() + j;
    if (j != i) {
      b((SpannableStringBuilder)localObject3, j, i, -4473925);
    }
    return localObject3;
  }
  
  private static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
  }
  
  private static SpannableStringBuilder c(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    paramContext = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, paramContext);
    String str2 = a(paramCommentEntry.authorRole, paramContext);
    String str3 = a(paramContext);
    boolean bool = android.text.TextUtils.isEmpty(str3);
    int i = paramCommentEntry.atVideoShootTime;
    paramContext = null;
    if (i > 0) {
      paramContext = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
    }
    if (android.text.TextUtils.isEmpty(paramContext))
    {
      paramContext = HardCodeUtil.a(2131911627);
    }
    else
    {
      paramCommentLikeFeedItem = new StringBuilder();
      paramCommentLikeFeedItem.append(" @");
      paramCommentLikeFeedItem.append(paramContext);
      paramCommentLikeFeedItem.append(HardCodeUtil.a(2131911627));
      paramContext = paramCommentLikeFeedItem.toString();
    }
    if ((bool ^ true)) {
      paramCommentLikeFeedItem = "V";
    } else {
      paramCommentLikeFeedItem = "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(paramCommentLikeFeedItem);
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("A");
    localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
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
    i = j + 1 + paramContext.length();
    if (j != i) {
      b((SpannableStringBuilder)localObject, j, i, -16777216);
    }
    j = i + 1;
    if (i != j) {
      a((SpannableStringBuilder)localObject, i, j, 2130848243, 15, 15, 3);
    }
    return localObject;
  }
  
  private static SpannableStringBuilder c(@NonNull CommentEntry paramCommentEntry)
  {
    int i = paramCommentEntry.atVideoShootTime;
    if (i > 0) {
      paramCommentEntry = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
    } else {
      paramCommentEntry = null;
    }
    if (android.text.TextUtils.isEmpty(paramCommentEntry))
    {
      paramCommentEntry = HardCodeUtil.a(2131911631);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(paramCommentEntry);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131911629));
      paramCommentEntry = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCommentEntry);
    ((StringBuilder)localObject).append("A");
    localObject = new SpannableStringBuilder(((StringBuilder)localObject).toString());
    i = paramCommentEntry.length();
    int j = i + 1;
    if (i != j) {
      a((SpannableStringBuilder)localObject, i, j, 2130848243, 15, 15);
    }
    return localObject;
  }
  
  private static SpannableStringBuilder c(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject1 = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject1);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject1);
    String str3 = a((QQUserUIItem)localObject1);
    boolean bool = android.text.TextUtils.isEmpty(str3);
    Object localObject2 = paramCommentEntry.content;
    localObject1 = null;
    if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramCommentEntry.content)) {
      localObject1 = EmotionCodecUtils.c(paramCommentEntry.content);
    }
    String str4 = HardCodeUtil.a(2131911630);
    if ((bool ^ true)) {
      paramCommentLikeFeedItem = "V";
    } else {
      paramCommentLikeFeedItem = "";
    }
    if (localObject1 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(paramCommentLikeFeedItem);
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append(": ");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = new QQTextBuilder(((StringBuilder)localObject2).toString(), 3, 16);
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(paramCommentLikeFeedItem);
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append(": ");
      ((StringBuilder)localObject1).append(localObject2);
      localObject1 = new SpannableStringBuilder(((StringBuilder)localObject1).toString());
    }
    int j = str1.length();
    a((SpannableStringBuilder)localObject1, 0, j);
    if (StoryDepends.a()) {
      b((SpannableStringBuilder)localObject1, 0, j, -16777216);
    }
    int i = paramCommentLikeFeedItem.length() + j;
    if (j != i) {
      a((SpannableStringBuilder)localObject1, str3, j, i);
    }
    a((SpannableStringBuilder)localObject1, 0, i, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
    j = str2.length() + i;
    if (i != j) {
      b((SpannableStringBuilder)localObject1, i, j, -4473925);
    }
    b((SpannableStringBuilder)localObject1, j, str4.length() + j, -4473925);
    return localObject1;
  }
  
  private static SpannableStringBuilder d(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, SpannableStringUtils.ClickNickCallback paramClickNickCallback)
  {
    Object localObject1 = ((UserManager)SuperManager.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject1);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject1);
    localObject1 = a((QQUserUIItem)localObject1);
    boolean bool = android.text.TextUtils.isEmpty((CharSequence)localObject1);
    String str3 = HardCodeUtil.a(2131911636);
    if ((bool ^ true)) {
      paramCommentLikeFeedItem = "V";
    } else {
      paramCommentLikeFeedItem = "";
    }
    int i = Integer.parseInt(paramCommentEntry.content);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(paramCommentLikeFeedItem);
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(": ");
    ((StringBuilder)localObject2).append("A");
    localObject2 = new SpannableStringBuilder(((StringBuilder)localObject2).toString());
    int k = str1.length();
    a((SpannableStringBuilder)localObject2, 0, k);
    if (StoryDepends.a()) {
      b((SpannableStringBuilder)localObject2, 0, k, -16777216);
    }
    int j = paramCommentLikeFeedItem.length() + k;
    if (k != j) {
      a((SpannableStringBuilder)localObject2, (String)localObject1, k, j);
    }
    a((SpannableStringBuilder)localObject2, 0, j, paramClickNickCallback, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
    k = str2.length() + j;
    if (j != k) {
      b((SpannableStringBuilder)localObject2, j, k, -4473925);
    }
    j = str3.length() + k;
    b((SpannableStringBuilder)localObject2, k, j, -4473925);
    j += 2;
    k = j + 1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return localObject2;
            }
            a((SpannableStringBuilder)localObject2, j, k, 2130845982, 37, 16, 3);
            return localObject2;
          }
          a((SpannableStringBuilder)localObject2, j, k, 2130845983, 37, 16, 3);
          return localObject2;
        }
        a((SpannableStringBuilder)localObject2, j, k, 2130845985, 37, 16, 3);
        return localObject2;
      }
      a((SpannableStringBuilder)localObject2, j, k, 2130845986, 37, 16, 3);
      return localObject2;
    }
    a((SpannableStringBuilder)localObject2, j, k, 2130845984, 37, 16, 3);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.SpannableStringUtils
 * JD-Core Version:    0.7.0.1
 */