package com.tencent.biz.qqcircle.widgets.textview;

import android.text.SpannableString;
import android.text.SpannedString;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextAtConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextHashTagConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig.TextImageSpanConfig;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;

public class QCircleRichTextPreloadHelper
{
  public static void a(FeedCloudMeta.StFeed paramStFeed)
  {
    d(paramStFeed);
    c(paramStFeed);
    if (QCircleConfigHelper.bg()) {
      b(paramStFeed);
    }
  }
  
  private static void b(FeedCloudMeta.StFeed paramStFeed)
  {
    paramStFeed = new RichTextPreloadParserInfo("immersive_feed_des_", new SpannableString(paramStFeed.content.get()));
    RichTextPreloadConfig localRichTextPreloadConfig = new RichTextPreloadConfig().a(new RichTextPreloadConfig.TextImageSpanConfig()).a(new RichTextPreloadConfig.TextAtConfig().a(2131168464).a(true)).a(new RichTextPreloadConfig.TextHashTagConfig().a(2131168464).a(true));
    RFWPreloadParseRichTextHelper.a().a(paramStFeed, localRichTextPreloadConfig);
  }
  
  private static void c(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = new RichTextPreloadParserInfo("feed_des_", new SpannableString(paramStFeed.content.get()));
    RichTextPreloadConfig localRichTextPreloadConfig = new RichTextPreloadConfig().a(new RichTextPreloadConfig.TextImageSpanConfig()).a(new RichTextPreloadConfig.TextAtConfig()).a(new RichTextPreloadConfig.TextHashTagConfig());
    RFWPreloadParseRichTextHelper.a().a((RichTextPreloadParserInfo)localObject, localRichTextPreloadConfig);
    paramStFeed = new RichTextPreloadParserInfo("layer_feed_title_", new SpannableString(paramStFeed.content.get()));
    localObject = new RichTextPreloadConfig().a(new RichTextPreloadConfig.TextImageSpanConfig()).a(new RichTextPreloadConfig.TextAtConfig().a(2131167079).a(true)).a(new RichTextPreloadConfig.TextHashTagConfig().a(2131167079).a(true));
    RFWPreloadParseRichTextHelper.a().a(paramStFeed, (RichTextPreloadConfig)localObject);
  }
  
  private static void d(FeedCloudMeta.StFeed paramStFeed)
  {
    int j = Math.min(paramStFeed.vecComment.size(), 3);
    int i = 0;
    while (i < j)
    {
      Object localObject1 = (FeedCloudMeta.StComment)paramStFeed.vecComment.get(i);
      Object localObject2 = new RichTextPreloadParserInfo("feed_comment_", new SpannableString(((FeedCloudMeta.StComment)localObject1).content.get()));
      RichTextPreloadConfig localRichTextPreloadConfig = new RichTextPreloadConfig().a(new RichTextPreloadConfig.TextImageSpanConfig()).a(new RichTextPreloadConfig.TextAtConfig()).a(new RichTextPreloadConfig.TextHashTagConfig());
      RFWPreloadParseRichTextHelper.a().a((RichTextPreloadParserInfo)localObject2, localRichTextPreloadConfig);
      if (((FeedCloudMeta.StComment)localObject1).vecReply.size() > 0)
      {
        localObject1 = new RichTextPreloadParserInfo("feed_reply_", new SpannedString(((FeedCloudMeta.StReply)((FeedCloudMeta.StComment)localObject1).vecReply.get().get(0)).content.get()));
        localObject2 = new RichTextPreloadConfig().a(new RichTextPreloadConfig.TextImageSpanConfig()).a(new RichTextPreloadConfig.TextAtConfig()).a(new RichTextPreloadConfig.TextHashTagConfig());
        RFWPreloadParseRichTextHelper.a().a((RichTextPreloadParserInfo)localObject1, (RichTextPreloadConfig)localObject2);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.textview.QCircleRichTextPreloadHelper
 * JD-Core Version:    0.7.0.1
 */