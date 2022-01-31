package com.tencent.mobileqq.activity.emogroupstore;

import afuh;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView.ScaleType;
import ansh;
import axli;
import bbqs;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import java.util.LinkedList;
import java.util.List;

public class ImgPreviewAdapter
  extends PagerAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afuh(this);
  private ansh jdField_a_of_type_Ansh;
  private LinkedList<URLImageView> jdField_a_of_type_JavaUtilLinkedList;
  private List<EmoticonFromGroupEntity> jdField_a_of_type_JavaUtilList;
  
  public ImgPreviewAdapter(QQAppInterface paramQQAppInterface, Context paramContext, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Ansh = ((bbqs)paramQQAppInterface.getManager(235)).jdField_a_of_type_Ansh;
  }
  
  public EmoticonFromGroupEntity a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (URLImageView)paramObject;
    paramViewGroup.removeView(paramObject);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    URLImageView localURLImageView;
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      localURLImageView = (URLImageView)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    }
    for (;;)
    {
      localURLImageView.setImageDrawable((URLDrawable)this.jdField_a_of_type_Ansh.a((EmoticonFromGroupEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt), 1, -1, null));
      localURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.addView(localURLImageView);
      return localURLImageView;
      localURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      localURLImageView.setLayoutParams(new Gallery.LayoutParams(axli.a(166.0F), axli.a(166.0F)));
      localURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localURLImageView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165359));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.ImgPreviewAdapter
 * JD-Core Version:    0.7.0.1
 */