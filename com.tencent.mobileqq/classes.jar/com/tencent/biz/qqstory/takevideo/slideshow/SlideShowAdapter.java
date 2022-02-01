package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SlideShowAdapter
  extends RecyclerView.Adapter<SlideShowAdapter.SlideShowViewHolder>
  implements ItemTouchHelperAction
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private SlideShowAdapter.onItemClipClickListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter$onItemClipClickListener;
  private SlideShowViewController.SlideShowActionListener jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener;
  private List<SlideItemInfo> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  
  public SlideShowAdapter(Context paramContext, View.OnClickListener paramOnClickListener, SlideShowViewController.SlideShowActionListener paramSlideShowActionListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener = paramSlideShowActionListener;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      if ((!paramBoolean) || (this.jdField_a_of_type_Int == paramInt)) {
        break label44;
      }
    }
    label44:
    for (this.jdField_a_of_type_Int = paramInt;; this.jdField_a_of_type_Int = -1)
    {
      notifyItemChanged(paramInt, Integer.valueOf(0));
      return;
    }
  }
  
  public SlideShowAdapter.SlideShowViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new SlideShowAdapter.SlideShowViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561882, paramViewGroup, false));
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(4);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setBorder(true);
    paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new SlideShowAdapter.1(this, paramViewGroup));
    return paramViewGroup;
  }
  
  public String a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_Int >= 0)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()) {
        str1 = ((SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      if (this.jdField_a_of_type_Int < 0) {
        a(paramInt, true);
      }
    }
    while (this.jdField_a_of_type_Int < 0)
    {
      return;
      a(this.jdField_a_of_type_Int, false);
      a(paramInt, true);
      return;
    }
    a(this.jdField_a_of_type_Int, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 1;
    Collections.swap(this.jdField_a_of_type_JavaUtilList, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    SlideItemInfo localSlideItemInfo;
    if ((this.jdField_a_of_type_Int == paramInt1) || (this.jdField_a_of_type_Int == paramInt2))
    {
      if (this.jdField_a_of_type_Int == paramInt1)
      {
        this.jdField_a_of_type_Int = paramInt2;
        notifyItemChanged(paramInt1, Integer.valueOf(0));
        notifyItemChanged(paramInt2, Integer.valueOf(0));
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowViewController$SlideShowActionListener.a(paramInt1, paramInt2);
      }
      if (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        if (localSlideItemInfo != null) {
          if (SlideShowPhotoListManager.a().a() != 11) {
            break label188;
          }
        }
      }
    }
    label188:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramInt2 = i;
      if (localSlideItemInfo.jdField_b_of_type_Int == 0) {
        paramInt2 = 0;
      }
      StoryReportor.a("pic_choose_slides", "edit_seq", paramInt1, 0, new String[] { paramInt2 + "" });
      return;
      this.jdField_a_of_type_Int = paramInt1;
      break;
    }
  }
  
  public void a(SlideShowAdapter.SlideShowViewHolder paramSlideShowViewHolder, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localSlideItemInfo);
    paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(localSlideItemInfo);
    if (localSlideItemInfo != null) {
      if (localSlideItemInfo.jdField_a_of_type_JavaNetURL != null)
      {
        Object localObject = paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getDrawable();
        if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.jdField_a_of_type_JavaNetURL.equals(((URLDrawable)localObject).getURL())))
        {
          localObject = URLDrawableHelper.getDrawable(localSlideItemInfo.jdField_a_of_type_JavaNetURL, URLDrawableHelper.getLoadingDrawable(), URLDrawableHelper.getFailedDrawable());
          ((URLDrawable)localObject).setTag(localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
          paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable((Drawable)localObject);
          paramSlideShowViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setTag(localSlideItemInfo);
        }
      }
    }
    switch (localSlideItemInfo.jdField_b_of_type_Int)
    {
    default: 
      if ((paramInt == this.jdField_a_of_type_Int) && (!paramSlideShowViewHolder.jdField_a_of_type_Boolean))
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(0.94F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(0.94F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.post(new SlideShowAdapter.3(this, paramSlideShowViewHolder));
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramSlideShowViewHolder, paramInt, getItemId(paramInt));
      return;
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(SlideShowUtils.a(localSlideItemInfo.jdField_a_of_type_Long));
      break;
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (localSlideItemInfo.jdField_a_of_type_Long > 0L) {
        paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(SlideShowUtils.a(localSlideItemInfo.c - localSlideItemInfo.jdField_b_of_type_Long));
      }
      paramSlideShowViewHolder.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new SlideShowAdapter.2(this, paramInt));
      break;
      if (paramSlideShowViewHolder.jdField_a_of_type_Boolean)
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.13F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.13F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(0.65F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
      else
      {
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleX(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setScaleY(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
        paramSlideShowViewHolder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
      }
    }
  }
  
  public void a(SlideShowAdapter.onItemClipClickListener paramonItemClipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowAdapter$onItemClipClickListener = paramonItemClipClickListener;
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter
 * JD-Core Version:    0.7.0.1
 */