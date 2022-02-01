package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import org.json.JSONObject;

public class DetailGeneralCommentEventProxy
  implements IDetailCommentEventProxy
{
  public static final String a = HardCodeUtil.a(2131901263);
  public static final String b = HardCodeUtil.a(2131901264);
  public static final String c = HardCodeUtil.a(2131901266);
  public static final String d = HardCodeUtil.a(2131901265);
  public static final String e = HardCodeUtil.a(2131901267);
  public static final String f = HardCodeUtil.a(2131898212);
  private Context g;
  private int h;
  private CommentLikeFeedItem i;
  private DetailGeneralCommentEventProxy.ActionSheetEventCallback j;
  
  public DetailGeneralCommentEventProxy(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.g = paramContext;
    this.h = paramInt;
    this.i = paramCommentLikeFeedItem;
    this.j = paramActionSheetEventCallback;
  }
  
  public boolean a()
  {
    SLog.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.isNetSupport(this.g))
    {
      QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131901268), 0).show();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.g, paramCommentEntry.f(), null);
      StoryReportor.a("play_video", "multishoot_icon", 0, 0, new String[0]);
    }
    for (;;)
    {
      bool = false;
      break label250;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          StoryPlayerLauncher.b(this.g, (String)localObject, paramCommentEntry, 74);
        }
      }
      else if (!NetworkUtil.isNetSupport(this.g))
      {
        QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131901262), 0).show();
      }
      else
      {
        if (!QQStoryContext.a().b(paramCommentEntry.authorUnionId)) {
          break;
        }
        localObject = ActionSheet.create(this.g);
        if (paramCommentEntry.status == 2) {
          ((ActionSheet)localObject).addButton(d);
        } else {
          ((ActionSheet)localObject).addButton(e);
        }
        ((ActionSheet)localObject).addButton(a, 3);
        ((ActionSheet)localObject).addCancelButton(f);
        ((ActionSheet)localObject).setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener((ActionSheet)localObject, paramCommentEntry, paramInt1, this.j));
        ((ActionSheet)localObject).show();
      }
    }
    boolean bool = true;
    label250:
    paramInt1 = StoryReportor.a(this.i);
    if (this.i.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.b(this.h), "", this.i.feedId });
    return bool;
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.g);
    if (QQStoryContext.a().b(paramCommentEntry.authorUnionId))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(d);
      } else {
        localActionSheet.addButton(e);
      }
      localActionSheet.addButton(a, 3);
    }
    else if (this.i.getOwner().isMe())
    {
      if ((this.i.getOwner().isVip()) || (paramInt2 == 2)) {
        localActionSheet.addButton(a, 3);
      }
      localActionSheet.addButton(c);
      localActionSheet.addButton(e);
    }
    else
    {
      localActionSheet.addButton(c);
      localActionSheet.addButton(e);
    }
    localActionSheet.addCancelButton(f);
    localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.j));
    localActionSheet.show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailGeneralCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */