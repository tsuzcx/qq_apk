package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.vas.VasExtensionManager;
import java.util.LinkedList;
import java.util.List;

public class ImgPreviewAdapter
  extends PagerAdapter
{
  private LinkedList<URLImageView> a;
  private Context b;
  private List<EmoticonFromGroupEntity> c;
  private ViewPager d;
  private IEmoticonFromGroupManager e;
  private View.OnClickListener f = new ImgPreviewAdapter.1(this);
  
  ImgPreviewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ViewPager paramViewPager)
  {
    this.b = paramContext;
    this.d = paramViewPager;
    this.a = new LinkedList();
    this.e = ((VasExtensionManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d;
  }
  
  EmoticonFromGroupEntity a(int paramInt)
  {
    List localList = this.c;
    if (localList == null) {
      return null;
    }
    return (EmoticonFromGroupEntity)localList.get(paramInt);
  }
  
  public void a(List<EmoticonFromGroupEntity> paramList)
  {
    this.c = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (URLImageView)paramObject;
    paramViewGroup.removeView(paramObject);
    this.a.add(paramObject);
  }
  
  public int getCount()
  {
    List localList = this.c;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    URLImageView localURLImageView;
    if (this.a.size() > 0)
    {
      localURLImageView = (URLImageView)this.a.removeFirst();
    }
    else
    {
      localURLImageView = new URLImageView(this.b);
      localURLImageView.setLayoutParams(new Gallery.LayoutParams(ScreenUtil.dip2px(166.0F), ScreenUtil.dip2px(166.0F)));
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localURLImageView.setBackgroundColor(this.b.getResources().getColor(2131165715));
    }
    localURLImageView.setImageDrawable((URLDrawable)this.e.a((EmoticonFromGroupEntity)this.c.get(paramInt), 1, -1, null));
    localURLImageView.setOnClickListener(this.f);
    paramViewGroup.addView(localURLImageView);
    return localURLImageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */