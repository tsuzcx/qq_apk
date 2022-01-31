package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.net.URL;
import java.util.List;

public class SlideShowPhotoListManager$SlideShowAdapter
  extends RecyclerView.Adapter
{
  public SlideShowPhotoListManager$SlideShowAdapter(SlideShowPhotoListManager paramSlideShowPhotoListManager) {}
  
  public SlideShowPhotoListManager.SlideShowViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new SlideShowPhotoListManager.SlideShowViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970752, paramViewGroup, false));
    paramViewGroup.a.setCorner(4);
    paramViewGroup.a.setOnClickListener(this.a);
    return paramViewGroup;
  }
  
  public void a(SlideShowPhotoListManager.SlideShowViewHolder paramSlideShowViewHolder, int paramInt)
  {
    SlideShowPhotoListManager.SlideItemInfo localSlideItemInfo = (SlideShowPhotoListManager.SlideItemInfo)SlideShowPhotoListManager.a(this.a).get(paramInt);
    if (localSlideItemInfo.a != null)
    {
      Object localObject = paramSlideShowViewHolder.a.getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.a.equals(((URLDrawable)localObject).getURL())))
      {
        localObject = URLDrawableHelper.a(localSlideItemInfo.a, URLDrawableHelper.b(), URLDrawableHelper.a());
        paramSlideShowViewHolder.a.setImageDrawable((Drawable)localObject);
      }
    }
    paramSlideShowViewHolder.a.setTag(localSlideItemInfo);
  }
  
  public int getItemCount()
  {
    return SlideShowPhotoListManager.a(this.a).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.SlideShowPhotoListManager.SlideShowAdapter
 * JD-Core Version:    0.7.0.1
 */