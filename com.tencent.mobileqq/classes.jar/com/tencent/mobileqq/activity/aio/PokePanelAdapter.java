package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ClickedWaveView;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class PokePanelAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel = null;
  ArrayList<PokePanel.PokeData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PokePanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int j = 3;
    int i = j;
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return 3;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 3) {
        return 3;
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 3) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 6)) {
        return 3;
      }
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 6) {
        i = 4;
      }
    }
    return i;
  }
  
  public ArrayList<PokePanel.PokeData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(PokePanel paramPokePanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel = paramPokePanel;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PokePanel.PokeData localPokeData = (PokePanel.PokeData)localIterator.next();
      if (paramString.equals("poke.item.effect."))
      {
        if (localPokeData.jdField_b_of_type_Int == paramInt)
        {
          localPokeData.jdField_c_of_type_Boolean = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
      else if (paramString.equals("poke.item.res."))
      {
        if (localPokeData.jdField_b_of_type_Int == paramInt)
        {
          localPokeData.jdField_b_of_type_Boolean = paramBoolean2;
          localPokeData.jdField_c_of_type_Boolean = paramBoolean1;
          return;
        }
        notifyDataSetChanged();
      }
    }
  }
  
  public void a(ArrayList<PokePanel.PokeData> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = a();
      return (this.jdField_a_of_type_JavaUtilArrayList.size() + i - 1) / i;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = a();
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      ((LinearLayout)localObject2).setOrientation(0);
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      while (i < j)
      {
        localObject3 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        }
        localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558843, null);
        ((LinearLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        localObject3 = new PokePanelAdapter.ViewHolder(this);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368487));
        ((PokePanelAdapter.ViewHolder)localObject3).b = ((ImageView)((View)localObject1).findViewById(2131366954));
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378476));
        ((PokePanelAdapter.ViewHolder)localObject3).c = ((ImageView)((View)localObject1).findViewById(2131366515));
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject1).findViewById(2131370379));
        ((PokePanelAdapter.ViewHolder)localObject3).d = ((ImageView)((View)localObject1).findViewById(2131365843));
        ((View)localObject1).setTag(localObject3);
        i += 1;
        localObject1 = paramView;
      }
      paramView = (View)localObject2;
    }
    Object localObject1 = (ViewGroup)paramView;
    if (paramInt == 0) {
      ((ViewGroup)localObject1).setPadding(AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    } else {
      ((ViewGroup)localObject1).setPadding(AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
    int i = 0;
    while (i < j)
    {
      int k = j * paramInt + i;
      localObject2 = ((ViewGroup)localObject1).getChildAt(i);
      localObject3 = (PokePanelAdapter.ViewHolder)((View)localObject2).getTag();
      if (k < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PokePanel.PokeData localPokeData = (PokePanel.PokeData)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView).setCustomDrawable(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject4 = new Bundle();
        ((Bundle)localObject4).putInt("type", localPokeData.jdField_a_of_type_Int);
        ((Bundle)localObject4).putInt("id", localPokeData.jdField_b_of_type_Int);
        ((Bundle)localObject4).putString("name", localPokeData.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject4).putInt("feeType", localPokeData.jdField_c_of_type_Int);
        ((Bundle)localObject4).putBoolean("isShowDownload", localPokeData.jdField_b_of_type_Boolean);
        ((Bundle)localObject4).putBoolean("isShowLoading", localPokeData.jdField_c_of_type_Boolean);
        ((Bundle)localObject4).putString("minVersion", localPokeData.jdField_c_of_type_JavaLangString);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView).setExtraInfo((Bundle)localObject4);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView).setOnTouchReceive(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
        if ((localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable))
        {
          localObject4 = (URLDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          if (((URLDrawable)localObject4).getStatus() == 2) {
            ((URLDrawable)localObject4).restartDownload();
          }
        }
        else if ((localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable))
        {
          ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          ((CustomFrameAnimationDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
        }
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(localPokeData.jdField_a_of_type_JavaLangString);
        if (localPokeData.jdField_a_of_type_Boolean) {
          ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(0);
        } else {
          ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(8);
        }
        if (localPokeData.jdField_c_of_type_Int == 4)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847639));
        }
        else if (localPokeData.jdField_c_of_type_Int == 5)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847638));
        }
        else
        {
          ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(8);
        }
        if (localPokeData.jdField_b_of_type_Boolean)
        {
          ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject3).d.setTag(Integer.valueOf(localPokeData.jdField_b_of_type_Int));
        }
        else
        {
          ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(8);
        }
        if (localPokeData.jdField_c_of_type_Boolean) {
          ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        } else {
          ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
        ((View)localObject2).setContentDescription(localPokeData.jdField_a_of_type_JavaLangString);
        ((View)localObject2).setEnabled(true);
        AccessibilityUtil.a((View)localObject2, true);
      }
      else
      {
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView.setText(null);
        ((PokePanelAdapter.ViewHolder)localObject3).b.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).c.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).d.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject3).d.setTag(null);
        ((View)localObject2).setEnabled(false);
        AccessibilityUtil.a((View)localObject2, false);
      }
      AccessibilityUtil.a(((PokePanelAdapter.ViewHolder)localObject3).jdField_a_of_type_AndroidWidgetTextView, false);
      i += 1;
    }
    paramView.setOnLongClickListener(null);
    AccessibilityUtil.a(paramView, false);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanelAdapter
 * JD-Core Version:    0.7.0.1
 */