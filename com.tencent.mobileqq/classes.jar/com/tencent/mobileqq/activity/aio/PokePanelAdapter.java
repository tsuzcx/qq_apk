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
import java.util.ArrayList;
import java.util.Iterator;

public class PokePanelAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private PokePanel jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public PokePanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
    while ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 3) || ((this.jdField_a_of_type_JavaUtilArrayList.size() > 3) && (this.jdField_a_of_type_JavaUtilArrayList.size() <= 6)) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 6)) {
      return 3;
    }
    return 4;
  }
  
  public ArrayList a()
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
    for (;;)
    {
      PokePanel.PokeData localPokeData;
      if (localIterator.hasNext())
      {
        localPokeData = (PokePanel.PokeData)localIterator.next();
        if (!paramString.equals("poke.item.effect.")) {
          break label63;
        }
        if (localPokeData.jdField_b_of_type_Int == paramInt) {
          localPokeData.jdField_c_of_type_Boolean = paramBoolean1;
        }
      }
      else
      {
        return;
      }
      notifyDataSetChanged();
      continue;
      label63:
      if (paramString.equals("poke.item.res."))
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
  
  public void a(ArrayList paramArrayList)
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
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt)) {
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
    int i;
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new LinearLayout(this.jdField_a_of_type_AndroidContentContext, null);
      paramViewGroup.setOrientation(0);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      i = 0;
      while (i < j)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        if (paramView != null) {
          break label982;
        }
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968773, null);
        paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new PokePanelAdapter.ViewHolder(this);
        ((PokePanelAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject2).findViewById(2131363678));
        ((PokePanelAdapter.ViewHolder)localObject1).b = ((ImageView)((View)localObject2).findViewById(2131363679));
        ((PokePanelAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131362943));
        ((PokePanelAdapter.ViewHolder)localObject1).c = ((ImageView)((View)localObject2).findViewById(2131363682));
        ((PokePanelAdapter.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject2).findViewById(2131362691));
        ((PokePanelAdapter.ViewHolder)localObject1).d = ((ImageView)((View)localObject2).findViewById(2131363681));
        ((View)localObject2).setTag(localObject1);
        i += 1;
      }
      paramView = paramViewGroup;
    }
    for (;;)
    {
      paramViewGroup = (ViewGroup)paramView;
      label281:
      PokePanel.PokeData localPokeData;
      if (paramInt == 0)
      {
        paramViewGroup.setPadding(AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(14.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        i = 0;
        if (i >= j) {
          break label970;
        }
        int k = j * paramInt + i;
        localObject1 = paramViewGroup.getChildAt(i);
        localObject2 = (PokePanelAdapter.ViewHolder)((View)localObject1).getTag();
        if (k >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label879;
        }
        localPokeData = (PokePanel.PokeData)this.jdField_a_of_type_JavaUtilArrayList.get(k);
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setCustomDrawable(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("type", localPokeData.jdField_a_of_type_Int);
        ((Bundle)localObject3).putInt("id", localPokeData.jdField_b_of_type_Int);
        ((Bundle)localObject3).putString("name", localPokeData.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putInt("feeType", localPokeData.jdField_c_of_type_Int);
        ((Bundle)localObject3).putBoolean("isShowDownload", localPokeData.jdField_b_of_type_Boolean);
        ((Bundle)localObject3).putBoolean("isShowLoading", localPokeData.jdField_c_of_type_Boolean);
        ((Bundle)localObject3).putString("minVersion", localPokeData.jdField_c_of_type_JavaLangString);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setExtraInfo((Bundle)localObject3);
        ((ClickedWaveView)((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView).setOnTouchReceive(this.jdField_a_of_type_ComTencentMobileqqActivityAioPokePanel);
        if (!(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)) {
          break label750;
        }
        localObject3 = (URLDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        if (((URLDrawable)localObject3).getStatus() == 2) {
          ((URLDrawable)localObject3).restartDownload();
        }
        label535:
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localPokeData.jdField_a_of_type_JavaLangString);
        if (!localPokeData.jdField_a_of_type_Boolean) {
          break label785;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).b.setVisibility(0);
        label565:
        if (localPokeData.jdField_c_of_type_Int != 4) {
          break label798;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).c.setVisibility(0);
        ((PokePanelAdapter.ViewHolder)localObject2).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844065));
        label604:
        if (!localPokeData.jdField_b_of_type_Boolean) {
          break label853;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).d.setVisibility(0);
        ((PokePanelAdapter.ViewHolder)localObject2).d.setTag(Integer.valueOf(localPokeData.jdField_b_of_type_Int));
        label637:
        if (!localPokeData.jdField_c_of_type_Boolean) {
          break label866;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        label654:
        ((View)localObject1).setContentDescription(localPokeData.jdField_a_of_type_JavaLangString);
        ((View)localObject1).setEnabled(true);
        AccessibilityUtil.a((View)localObject1, true);
      }
      for (;;)
      {
        AccessibilityUtil.a(((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView, false);
        i += 1;
        break label281;
        paramViewGroup.setPadding(AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(7.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        break;
        label750:
        if (!(localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof CustomFrameAnimationDrawable)) {
          break label535;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((CustomFrameAnimationDrawable)localPokeData.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
        break label535;
        label785:
        ((PokePanelAdapter.ViewHolder)localObject2).b.setVisibility(8);
        break label565;
        label798:
        if (localPokeData.jdField_c_of_type_Int == 5)
        {
          ((PokePanelAdapter.ViewHolder)localObject2).c.setVisibility(0);
          ((PokePanelAdapter.ViewHolder)localObject2).c.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844064));
          break label604;
        }
        ((PokePanelAdapter.ViewHolder)localObject2).c.setVisibility(8);
        break label604;
        label853:
        ((PokePanelAdapter.ViewHolder)localObject2).d.setVisibility(8);
        break label637;
        label866:
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        break label654;
        label879:
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(null);
        ((PokePanelAdapter.ViewHolder)localObject2).b.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject2).c.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject2).jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject2).d.setVisibility(8);
        ((PokePanelAdapter.ViewHolder)localObject2).d.setTag(null);
        ((View)localObject1).setEnabled(false);
        AccessibilityUtil.a((View)localObject1, false);
      }
      label970:
      paramView.setOnLongClickListener(null);
      AccessibilityUtil.a(paramView, false);
      return paramView;
      label982:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PokePanelAdapter
 * JD-Core Version:    0.7.0.1
 */