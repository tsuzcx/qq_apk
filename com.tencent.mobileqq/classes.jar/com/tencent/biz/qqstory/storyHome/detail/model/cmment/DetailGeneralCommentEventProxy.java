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
  public static final String b = HardCodeUtil.a(2131703304);
  public static final String c = HardCodeUtil.a(2131703306);
  public static final String d = HardCodeUtil.a(2131703305);
  public static final String e = HardCodeUtil.a(2131703307);
  public static final String f = HardCodeUtil.a(2131703303);
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private DetailGeneralCommentEventProxy.ActionSheetEventCallback jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131703302);
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
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703308), 0).a();
      return false;
    }
    return true;
  }
  
  public boolean a(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    if (paramCommentEntry.commentType == 5)
    {
      paramCommentEntry = new OpenPlayerBuilder(new VidListPlayInfo(paramCommentEntry.togetherFeedId, paramCommentEntry.togetherVid), 126);
      StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidContentContext, paramCommentEntry.a(), null);
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
          StoryPlayerLauncher.b(this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramCommentEntry, 74);
        }
      }
      else if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
      {
        QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131703301), 0).a();
      }
      else
      {
        if (!QQStoryContext.a().a(paramCommentEntry.authorUnionId)) {
          break;
        }
        localObject = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
        if (paramCommentEntry.status == 2) {
          ((ActionSheet)localObject).addButton(d);
        } else {
          ((ActionSheet)localObject).addButton(e);
        }
        ((ActionSheet)localObject).addButton(jdField_a_of_type_JavaLangString, 3);
        ((ActionSheet)localObject).addCancelButton(f);
        ((ActionSheet)localObject).setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener((ActionSheet)localObject, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
        ((ActionSheet)localObject).show();
      }
    }
    boolean bool = true;
    label250:
    paramInt1 = StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe()) {
      paramCommentEntry = "1";
    } else {
      paramCommentEntry = "2";
    }
    StoryReportor.a("home_page", "clk_content", paramInt1, 0, new String[] { paramCommentEntry, StoryReportor.a(this.jdField_a_of_type_Int), "", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
    return bool;
  }
  
  public boolean b(CommentEntry paramCommentEntry, int paramInt1, int paramInt2)
  {
    ActionSheet localActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
    if (QQStoryContext.a().a(paramCommentEntry.authorUnionId))
    {
      if (paramCommentEntry.status == 2) {
        localActionSheet.addButton(d);
      } else {
        localActionSheet.addButton(e);
      }
      localActionSheet.addButton(jdField_a_of_type_JavaLangString, 3);
    }
    else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.getOwner().isMe())
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
    localActionSheet.addCancelButton(f);
    localActionSheet.setOnButtonClickListener(new DetailGeneralCommentEventProxy.OnActionSheetButtonClickListener(localActionSheet, paramCommentEntry, paramInt1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelCmmentDetailGeneralCommentEventProxy$ActionSheetEventCallback));
    localActionSheet.show();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailGeneralCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */