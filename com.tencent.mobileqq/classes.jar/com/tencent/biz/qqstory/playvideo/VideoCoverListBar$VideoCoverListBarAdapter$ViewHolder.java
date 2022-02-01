package com.tencent.biz.qqstory.playvideo;

import android.graphics.PorterDuff.Mode;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.TimeZone;

class VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoCoverImgBorder jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder;
  private String jdField_a_of_type_JavaLangString;
  
  public VideoCoverListBar$VideoCoverListBarAdapter$ViewHolder(VideoCoverListBar.VideoCoverListBarAdapter paramVideoCoverListBarAdapter, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder = ((VideoCoverImgBorder)paramView.findViewById(2131363691));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378688));
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setOnClickListener(new VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder.1(this, paramVideoCoverListBarAdapter));
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder, paramString, VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), "VideoCoverList");
      return;
    }
    UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder, paramString, VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), VideoCoverListBar.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a), "VideoCoverList");
  }
  
  public void a(int paramInt)
  {
    SLog.a("Q.qqstory.player:VideoCoverListBar", "bindView, position=%d", Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a(paramInt);
    StoryVideoItem localStoryVideoItem = VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a).b(this.jdField_a_of_type_JavaLangString);
    Object localObject = localStoryVideoItem;
    if (localStoryVideoItem == null)
    {
      localObject = new StoryVideoItem();
      ((StoryVideoItem)localObject).mVid = this.jdField_a_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(((StoryVideoItem)localObject).getThumbUrl())) {
      a(ThumbnailUrlHelper.a(((StoryVideoItem)localObject).getThumbUrl()), paramInt);
    } else {
      a(ThumbnailUrlHelper.a(ImageDownloader.FILE.a(((StoryVideoItem)localObject).mVideoLocalThumbnailPath)), paramInt);
    }
    if (((StoryVideoItem)localObject).isUploadFail()) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(0);
    } else if (TextUtils.isEmpty(VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a))) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(2);
    } else if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a))) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(1);
    } else {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setState(2);
    }
    if ((!VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a).a()) && (!VideoCoverListBar.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverListBar$VideoCoverListBarAdapter.a).b()))
    {
      if ((!PlayModeUtils.b((StoryVideoItem)localObject)) && (((StoryVideoItem)localObject).mErrorCode == 0))
      {
        long l2 = ((StoryVideoItem)localObject).mCreateTime;
        long l1;
        boolean bool;
        if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L)
        {
          l1 = ((StoryVideoItem)localObject).mTimeZoneOffsetMillis;
          bool = true;
        }
        else
        {
          l1 = TimeZone.getDefault().getRawOffset();
          bool = false;
        }
        localObject = StoryListUtils.a(l2, l1, bool, false, true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.setColorFilter(1711276032, PorterDuff.Mode.SRC_ATOP);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoVideoCoverImgBorder.clearColorFilter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */