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
  public static final String a;
  public static final String b = HardCodeUtil.a(2131703172);
  public static final String c = HardCodeUtil.a(2131703174);
  public static final String d = HardCodeUtil.a(2131703173);
  public static final String e = HardCodeUtil.a(2131703175);
  public static final String f = HardCodeUtil.a(2131703171);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private DetailGeneralCommentEventProxy.ActionSheetEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131703170);
  }
  
  public DetailGeneralCommentEventProxy(Context paramContext, int paramInt, CommentLikeFeedItem paramCommentLikeFeedItem, DetailGeneralCommentEventProxy.ActionSheetEventCallback paramActionSheetEventCallback)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = paramCommentLikeFeedItem;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback = paramActionSheetEventCallback;
  }
  
  public boolean a()
  {
    SLog.c("Q.qqstory.detail.DetailGeneralCommentEventProxy", "on comment button click.");
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703176), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
      StoryReportor.a("play_video", "multishoot_icon", 0, 0, new String[0]);
      bool = false;
      paramInt1 = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
        break label330;
      }
    }
    label330:
    for (paramCommentEntry = "1";; paramCommentEntry = "2")
    {
      StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return bool;
      Object localObject;
      if (paramCommentEntry.commentType == 4)
      {
        localObject = paramCommentEntry.getExtraJson().optString("vid");
        paramCommentEntry = paramCommentEntry.getExtraJson().optString("feedid");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramCommentEntry))) {
          StoryPlayerLauncher.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
        bool = false;
        break;
      }
      if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703169), 0).a();
        bool = false;
        break;
      }
      if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
      {
        localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((ActionSheet)localObject).addButton(d);
        }
        for (;;)
        {
          ((ActionSheet)localObject).addButton(jdField_a_of_type_JavaLangString, 3);
          ((ActionSheet)localObject).addCancelButton(f);
          ((ActionSheet)localObject).setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener((ActionSheet)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
          ((ActionSheet)localObject).show();
          bool = false;
          break;
          ((ActionSheet)localObject).addButton(e);
        }
      }
      bool = true;
      break;
    }
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
      if (paramCommentEntry.status == 2)
      {
        localActionSheet.addButton(d);
        localActionSheet.addButton(jdField_a_of_type_JavaLangString, 3);
      }
    }
    for (;;)
    {
      localActionSheet.addCancelButton(f);
      localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
      localActionSheet.show();
      return false;
      localActionSheet.addButton(e);
      break;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isVip()) || (paramInt2 == 2)) {
          localActionSheet.addButton(jdField_a_of_type_JavaLangString, 3);
        }
        localActionSheet.addButton(c);
        localActionSheet.addButton(e);
      }
      else
      {
        localActionSheet.addButton(c);
        localActionSheet.addButton(e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailGeneralCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */