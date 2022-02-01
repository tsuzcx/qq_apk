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
  private Context a;
  private List<SlideItemInfo> b = new CopyOnWriteArrayList();
  private Bitmap c = null;
  private int d = -1;
  private SlideShowAdapter.onItemClipClickListener e;
  private View.OnClickListener f;
  private SlideShowActionListener g;
  
  public SlideShowAdapter(Context paramContext, View.OnClickListener paramOnClickListener, SlideShowActionListener paramSlideShowActionListener)
  {
    this.a = paramContext;
    this.f = paramOnClickListener;
    this.g = paramSlideShowActionListener;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size()))
    {
      if ((paramBoolean) && (this.d != paramInt)) {
        this.d = paramInt;
      } else {
        this.d = -1;
      }
      notifyItemChanged(paramInt, Integer.valueOf(0));
    }
  }
  
  public SlideShowAdapter.SlideShowViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new SlideShowAdapter.SlideShowViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628112, paramViewGroup, false));
    paramViewGroup.b.setCorner(4);
    paramViewGroup.b.setBorder(true);
    paramViewGroup.b.setOnClickListener(this.f);
    paramViewGroup.f.setOnClickListener(new SlideShowAdapter.1(this, paramViewGroup));
    return paramViewGroup;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = this.d;
      if (i < 0)
      {
        a(paramInt, true);
        return;
      }
      a(i, false);
      a(paramInt, true);
      return;
    }
    paramInt = this.d;
    if (paramInt >= 0) {
      a(paramInt, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Collections.swap(this.b, paramInt1, paramInt2);
    notifyItemMoved(paramInt1, paramInt2);
    int i = this.d;
    Object localObject = Integer.valueOf(0);
    if ((i == paramInt1) || (i == paramInt2))
    {
      if (this.d == paramInt1) {
        this.d = paramInt2;
      } else {
        this.d = paramInt1;
      }
      notifyItemChanged(paramInt1, localObject);
      notifyItemChanged(paramInt2, localObject);
    }
    localObject = this.g;
    if (localObject != null) {
      ((SlideShowActionListener)localObject).a(paramInt1, paramInt2);
    }
    if (paramInt1 < this.b.size())
    {
      localObject = (SlideItemInfo)this.b.get(paramInt1);
      if (localObject != null)
      {
        paramInt1 = SlideShowPhotoListManager.a().d();
        paramInt2 = 1;
        if (paramInt1 == 11) {
          paramInt1 = 0;
        } else {
          paramInt1 = 1;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (((SlideItemInfo)localObject).e == 0) {
          paramInt2 = 0;
        }
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("");
        StoryReportor.a("pic_choose_slides", "edit_seq", paramInt1, 0, new String[] { localStringBuilder.toString() });
      }
    }
  }
  
  public void a(SlideShowAdapter.SlideShowViewHolder paramSlideShowViewHolder, int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)this.b.get(paramInt);
    paramSlideShowViewHolder.a.setTag(localSlideItemInfo);
    paramSlideShowViewHolder.f.setTag(localSlideItemInfo);
    if (localSlideItemInfo != null)
    {
      if (localSlideItemInfo.g != null)
      {
        Object localObject = paramSlideShowViewHolder.b.getDrawable();
        if ((!(localObject instanceof URLDrawable)) || (!localSlideItemInfo.g.equals(((URLDrawable)localObject).getURL())))
        {
          localObject = URLDrawableHelper.getDrawable(localSlideItemInfo.g, URLDrawableHelper.getLoadingDrawable(), URLDrawableHelper.getFailedDrawable());
          ((URLDrawable)localObject).setTag(localSlideItemInfo.a);
          paramSlideShowViewHolder.b.setImageDrawable((Drawable)localObject);
          paramSlideShowViewHolder.b.setTag(localSlideItemInfo);
        }
      }
      int i = localSlideItemInfo.e;
      if (i != 0)
      {
        if (i == 1)
        {
          paramSlideShowViewHolder.e.setVisibility(0);
          if (localSlideItemInfo.h > 0L) {
            paramSlideShowViewHolder.d.setText(SlideShowUtils.a(localSlideItemInfo.j - localSlideItemInfo.i));
          }
          paramSlideShowViewHolder.e.setOnClickListener(new SlideShowAdapter.2(this, paramInt));
        }
      }
      else
      {
        paramSlideShowViewHolder.e.setVisibility(8);
        paramSlideShowViewHolder.d.setText(SlideShowUtils.a(localSlideItemInfo.h));
      }
    }
    if ((paramInt == this.d) && (!paramSlideShowViewHolder.g))
    {
      paramSlideShowViewHolder.a.setScaleX(0.94F);
      paramSlideShowViewHolder.a.setScaleY(0.94F);
      paramSlideShowViewHolder.a.setAlpha(1.0F);
      paramSlideShowViewHolder.c.post(new SlideShowAdapter.3(this, paramSlideShowViewHolder));
    }
    else if (paramSlideShowViewHolder.g)
    {
      paramSlideShowViewHolder.a.setScaleX(1.13F);
      paramSlideShowViewHolder.a.setScaleY(1.13F);
      paramSlideShowViewHolder.a.setAlpha(0.65F);
      paramSlideShowViewHolder.c.setBackgroundDrawable(null);
    }
    else
    {
      paramSlideShowViewHolder.a.setScaleX(1.0F);
      paramSlideShowViewHolder.a.setScaleY(1.0F);
      paramSlideShowViewHolder.a.setAlpha(1.0F);
      paramSlideShowViewHolder.c.setBackgroundDrawable(null);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramSlideShowViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(SlideShowAdapter.onItemClipClickListener paramonItemClipClickListener)
  {
    this.e = paramonItemClipClickListener;
  }
  
  public void a(List<SlideItemInfo> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideShowAdapter
 * JD-Core Version:    0.7.0.1
 */