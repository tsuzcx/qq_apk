package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoticonview.PanelRecycleBin;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uly;

public class PanelAdapter
  extends PagerAdapter
{
  int jdField_a_of_type_Int = 4;
  Context jdField_a_of_type_AndroidContentContext;
  public SparseArray a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  PanelRecycleBin jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin = new PanelRecycleBin();
  public String a;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  int b;
  public boolean b;
  
  public PanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(int paramInt, uly paramuly)
  {
    int m = this.jdField_a_of_type_Int;
    int n = this.jdField_b_of_type_Int;
    paramuly.a(paramInt);
    int i = 0;
    int j = 0;
    while (j < this.jdField_b_of_type_Int)
    {
      LinearLayout localLinearLayout = (LinearLayout)paramuly.getChildAt(j);
      int k = 0;
      if (k < this.jdField_a_of_type_Int)
      {
        View localView = localLinearLayout.getChildAt(k);
        PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)localView.getTag();
        int i1 = m * n * paramInt + i;
        if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          PlusPanel.PluginData localPluginData = (PlusPanel.PluginData)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          if ((localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
          {
            URLDrawable localURLDrawable = (URLDrawable)localPluginData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (localURLDrawable.getStatus() == 2) {
              localURLDrawable.restartDownload();
            }
          }
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localPluginData.jdField_a_of_type_JavaLangString);
          if (localPluginData.jdField_a_of_type_Boolean)
          {
            localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            label197:
            localViewHolder.jdField_a_of_type_Int = localPluginData.jdField_a_of_type_Int;
            localViewHolder.jdField_b_of_type_Int = localPluginData.jdField_b_of_type_Int;
            localView.setContentDescription(localPluginData.jdField_a_of_type_JavaLangString + "按钮");
            localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            localView.setEnabled(true);
            AccessibilityUtil.a(localView, true);
          }
        }
        for (;;)
        {
          AccessibilityUtil.a(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, false);
          i += 1;
          k += 1;
          break;
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          break label197;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
          localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localViewHolder.jdField_a_of_type_Int = 0;
          localViewHolder.jdField_b_of_type_Int = 0;
          localView.setOnClickListener(null);
          localView.setEnabled(false);
          AccessibilityUtil.a(localView, false);
        }
      }
      j += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    int i;
    do
    {
      return localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.jdField_a_of_type_AndroidViewViewGroup.getChildCount());
    uly localuly = (uly)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
    localObject2 = localObject1;
    int j;
    label57:
    int k;
    if (localuly != null)
    {
      j = 0;
      localObject2 = localObject1;
      if (j < this.jdField_b_of_type_Int)
      {
        LinearLayout localLinearLayout = (LinearLayout)localuly.getChildAt(j);
        k = 0;
        label83:
        if (k >= this.jdField_a_of_type_Int) {
          break label156;
        }
        localObject2 = localLinearLayout.getChildAt(k);
        PanelAdapter.ViewHolder localViewHolder = (PanelAdapter.ViewHolder)((View)localObject2).getTag();
        if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_Int == paramInt)) {
          localObject1 = localObject2;
        }
      }
    }
    label156:
    for (;;)
    {
      j += 1;
      break label57;
      k += 1;
      break label83;
      i += 1;
      localObject1 = localObject2;
      break;
    }
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public List a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    i = this.jdField_b_of_type_Int * i;
    int j = i * paramInt;
    List localList2 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, null);
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList2 = Collections.emptyList();
      localList1 = localList2;
      if (j >= 0)
      {
        localList1 = localList2;
        if (j < this.jdField_a_of_type_JavaUtilArrayList.size()) {
          localList1 = this.jdField_a_of_type_JavaUtilArrayList.subList(j, Math.min(this.jdField_a_of_type_JavaUtilArrayList.size(), i + j));
        }
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localList1);
    }
    return localList1;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {}
    for (;;)
    {
      return;
      if (paramInt >= 0)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_AndroidViewViewGroup.getChildCount())
        {
          uly localuly = (uly)this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
          if ((localuly != null) && (paramInt == localuly.jdField_a_of_type_Int))
          {
            a(paramInt, localuly);
            return;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    uly localuly = (uly)paramObject;
    ((ViewGroup)paramView).removeView(localuly);
    localuly.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a((View)paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
      return 0;
    }
    return (this.jdField_a_of_type_JavaUtilArrayList.size() + this.jdField_a_of_type_Int * this.jdField_b_of_type_Int - 1) / (this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (this.jdField_b_of_type_Boolean) {
      return -2;
    }
    if (((paramObject instanceof uly)) && (((uly)paramObject).jdField_a_of_type_Int >= getCount())) {
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PanelIconAdapter", 2, "instantiateItem " + paramInt);
    }
    uly localuly = (uly)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
    Object localObject;
    if (localuly != null)
    {
      localObject = localuly.getTag();
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localuly.getTag()).intValue() != XPanelContainer.d))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPanelRecycleBin.a();
        localuly = null;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
      localObject = localuly;
      if (localuly == null) {
        localObject = new uly(this, this.jdField_a_of_type_AndroidContentContext, null);
      }
      ((uly)localObject).a(paramInt);
      a(paramInt, (uly)localObject);
      if ((((uly)localObject).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject);
      }
      return localObject;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PanelAdapter
 * JD-Core Version:    0.7.0.1
 */