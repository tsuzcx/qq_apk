package com.tencent.biz.qqstory.takevideo.slideshow;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import olw;

public class SlideShowPhotoListManager$SlideShowAdapter
  extends RecyclerView.Adapter
  implements ItemTouchHelperAction
{
  private Bitmap a;
  
  public SlideShowPhotoListManager$SlideShowAdapter(SlideShowPhotoListManager paramSlideShowPhotoListManager) {}
  
  public SlideShowPhotoListManager.SlideShowViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new SlideShowPhotoListManager.SlideShowViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970800, paramViewGroup, false));
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(4);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager);
    return paramViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Collections.swap(SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager), paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    if ((SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager) == paramInt1) || (SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager) == paramInt2))
    {
      if (SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager) != paramInt1) {
        break label116;
      }
      SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager, paramInt2);
    }
    for (;;)
    {
      notifyItemChanged(paramInt1, Integer.valueOf(0));
      notifyItemChanged(paramInt2, Integer.valueOf(0));
      if (SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager) != null) {
        SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager).a(paramInt1, paramInt2);
      }
      StoryReportor.a("pic_choose_slides", "edit_seq", 0, 0, new String[0]);
      return;
      label116:
      SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager, paramInt1);
    }
  }
  
  public void a(SlideShowPhotoListManager.SlideShowViewHolder paramSlideShowViewHolder, int paramInt)
  {
    SlideShowPhotoListManager.SlideItemInfo localSlideItemInfo = (SlideShowPhotoListManager.SlideItemInfo)SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager).get(paramInt);
    if (localSlideItemInfo.a != null)
    {
      Object localObject = paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.a.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = URLDrawableHelper.a(localSlideItemInfo.a, URLDrawableHelper.b(), URLDrawableHelper.a());
        paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
        paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
      }
    }
    if ((paramInt == SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager)) && (!paramSlideShowViewHolder.jdField_a_of_type_Boolean))
    {
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleX(0.94F);
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleY(0.94F);
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setAlpha(1.0F);
      paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setScaleX(0.94F);
      paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setScaleY(0.94F);
      paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.post(new olw(this, paramSlideShowViewHolder));
      return;
    }
    if (paramSlideShowViewHolder.jdField_a_of_type_Boolean)
    {
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleX(1.13F);
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleY(1.13F);
      paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setAlpha(0.65F);
      paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      return;
    }
    paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleX(1.0F);
    paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setScaleY(1.0F);
    paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setAlpha(1.0F);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setScaleX(1.0F);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setScaleY(1.0F);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
  }
  
  public int getItemCount()
  {
    return SlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.SlideShowAdapter
 * JD-Core Version:    0.7.0.1
 */