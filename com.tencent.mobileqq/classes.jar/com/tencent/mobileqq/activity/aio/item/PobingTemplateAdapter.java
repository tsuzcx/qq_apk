package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeData;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class PobingTemplateAdapter
  extends RecyclerView.Adapter<PobingTemplateAdapter.Holder>
  implements View.OnClickListener, PobingDecoder.DecodeCallBack
{
  private static final int[][] jdField_a_of_type_Array2dOfInt = { { 2000, 2131694942, 0, 4 }, { 2001, 2131694944, 2130847430, 1 }, { 2002, 2131694943, 2130847429, 2 }, { 2003, 2131694941, 2130847428, 3 } };
  private int jdField_a_of_type_Int = 2000;
  private PobingTemplateAdapter.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter$Callback;
  
  public PobingTemplateAdapter(PobingTemplateAdapter.Callback paramCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter$Callback = paramCallback;
  }
  
  public static int a(int paramInt)
  {
    int k = 0;
    int[][] arrayOfInt = jdField_a_of_type_Array2dOfInt;
    int m = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        int[] arrayOfInt1 = arrayOfInt[i];
        if (arrayOfInt1[0] == paramInt) {
          j = arrayOfInt1[3];
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public PobingTemplateAdapter.Holder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new PobingTemplateAdapter.Holder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562164, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_Array2dOfInt.length)
      {
        if (paramInt == jdField_a_of_type_Array2dOfInt[i][0])
        {
          this.jdField_a_of_type_Int = paramInt;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter$Callback != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioItemPobingTemplateAdapter$Callback.a(paramInt);
          }
          notifyDataSetChanged();
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void a(PobingTemplateAdapter.Holder paramHolder, int paramInt)
  {
    int j = 0;
    Object localObject1 = jdField_a_of_type_Array2dOfInt[paramInt];
    int k = localObject1[0];
    int i = localObject1[2];
    paramHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localObject1[1]);
    paramHolder.b.setImageResource(i);
    localObject1 = paramHolder.b;
    Object localObject2;
    boolean bool;
    if (i != 0)
    {
      i = 0;
      ((ImageView)localObject1).setVisibility(i);
      localObject1 = PobingDecoder.a(PobingManager.b(k));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setId(k);
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 == null) {
        break label213;
      }
      bool = true;
      label99:
      ((ImageView)localObject2).setClickable(bool);
      localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView;
      if (k != this.jdField_a_of_type_Int) {
        break label219;
      }
      i = 2130840700;
      label124:
      ((ImageView)localObject2).setImageResource(i);
      localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject1 != null) {
        break label224;
      }
      i = j;
      label144:
      ((ProgressBar)localObject2).setVisibility(i);
      if (localObject1 == null) {
        break label274;
      }
      if (k != 2003) {
        break label230;
      }
      localObject1 = VasApngFactory.a("", new VasApngFactory.Options(), ((PobingDecoder.BitmapsCache)localObject1).a(2131373308));
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramHolder, paramInt, getItemId(paramInt));
      return;
      i = 8;
      break;
      label213:
      bool = false;
      break label99;
      label219:
      i = 0;
      break label124;
      label224:
      i = 8;
      break label144;
      label230:
      localObject2 = paramHolder.jdField_a_of_type_AndroidWidgetImageView.getResources();
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable((Resources)localObject2, (Bitmap)((PobingDecoder.BitmapsCache)localObject1).a.get(Integer.valueOf(2131373308))));
      continue;
      label274:
      paramHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
      new PobingDecoder(k, TroopPobingItemView.b, this);
    }
  }
  
  public void a(PobingDecoder.DecodeData paramDecodeData)
  {
    paramDecodeData = PobingDecoder.a(paramDecodeData, true);
    if (paramDecodeData == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new PobingTemplateAdapter.1(this, paramDecodeData));
  }
  
  void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < jdField_a_of_type_Array2dOfInt.length)
      {
        if (paramInt == jdField_a_of_type_Array2dOfInt[i][0]) {
          notifyItemChanged(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return jdField_a_of_type_Array2dOfInt.length;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    a(i);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F9", a(i), 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PobingTemplateAdapter
 * JD-Core Version:    0.7.0.1
 */