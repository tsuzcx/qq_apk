package com.tencent.biz.pubaccount.weishi_new.like;

import UserGrowth.stFriendLike;
import UserGrowth.stFriendLikes;
import UserGrowth.stSimpleMetaFeed;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class WSFriendLikeParser
{
  private static int jdField_a_of_type_Int = ScreenUtil.getRealWidth(BaseApplicationImpl.context) - ScreenUtil.dip2px(30.0F);
  private static String jdField_a_of_type_JavaLangString = "、";
  
  @NotNull
  private static WSFriendLikeParser.FriendClickableSpan a(stSimpleMetaFeed paramstSimpleMetaFeed, stFriendLike paramstFriendLike, int paramInt)
  {
    return new WSFriendLikeParser.FriendClickableSpan(paramstSimpleMetaFeed, paramstFriendLike.schema, paramInt);
  }
  
  public static WSFriendLikeParserEntity a(stSimpleMetaFeed paramstSimpleMetaFeed, TextPaint paramTextPaint, int paramInt)
  {
    Object localObject1 = paramTextPaint;
    long l1 = System.currentTimeMillis();
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j = 0;
    if (paramstSimpleMetaFeed != null)
    {
      Object localObject2 = paramstSimpleMetaFeed.friendLikes;
      if (localObject2 != null)
      {
        int m = ((stFriendLikes)localObject2).total;
        if ((m > 0) && (localObject1 != null))
        {
          if (((stFriendLikes)localObject2).likeFriends == null)
          {
            WSLog.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes.likeFriends is empty，but friendLikes.total > 0，show the num");
            return new WSFriendLikeParserEntity(null, 0, b(m));
          }
          int i = ((stFriendLikes)localObject2).likeFriends.size();
          int n = (int)((TextPaint)localObject1).measureText(a());
          int i1 = (int)((TextPaint)localObject1).measureText(a(m));
          int i2 = jdField_a_of_type_Int;
          float f = 0.0F;
          int k = 0;
          localObject1 = localObject2;
          while (j < i)
          {
            stFriendLike localstFriendLike = (stFriendLike)((stFriendLikes)localObject1).likeFriends.get(j);
            String str = localstFriendLike.nick;
            if (j == i - 1)
            {
              localObject2 = str;
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localSpannableStringBuilder.append((CharSequence)localObject2);
            f = paramTextPaint.measureText(localSpannableStringBuilder.toString());
            if (f > i2 - n)
            {
              l2 = System.currentTimeMillis();
              paramstSimpleMetaFeed = new StringBuilder();
              paramstSimpleMetaFeed.append("[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing： ");
              paramstSimpleMetaFeed.append(l2 - l1);
              WSLog.a("WSFriendLikeUtil", paramstSimpleMetaFeed.toString());
              WSLog.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is out of the max width，show with ...");
              return new WSFriendLikeParserEntity(localSpannableStringBuilder, i2 - i1, a(m));
            }
            localSpannableStringBuilder.setSpan(a(paramstSimpleMetaFeed, localstFriendLike, paramInt), k, str.length() + k, 33);
            k += ((String)localObject2).length();
            j += 1;
          }
          long l2 = System.currentTimeMillis();
          paramstSimpleMetaFeed = new StringBuilder();
          paramstSimpleMetaFeed.append("[WSFriendLikeParser.parse()]the cost of friendLikes'Parsing： ");
          paramstSimpleMetaFeed.append(l2 - l1);
          WSLog.a("WSFriendLikeUtil", paramstSimpleMetaFeed.toString());
          WSLog.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]the width of friendLikes is in the max width，show completely");
          return new WSFriendLikeParserEntity(localSpannableStringBuilder, (int)f, a());
        }
      }
    }
    WSLog.e("WSFriendLikeUtil", "[WSFriendLikeParser.parse()]friendLikes is empty，hide displayLine");
    return new WSFriendLikeParserEntity(null, 0, "");
  }
  
  private static String a()
  {
    return " 赞了";
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 等");
    localStringBuilder.append(c(paramInt));
    localStringBuilder.append("位好友赞了");
    return localStringBuilder.toString();
  }
  
  private static String b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c(paramInt));
    localStringBuilder.append("位好友 赞了");
    return localStringBuilder.toString();
  }
  
  private static String c(int paramInt)
  {
    return ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonCountToString(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSFriendLikeParser
 * JD-Core Version:    0.7.0.1
 */