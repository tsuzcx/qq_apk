package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.quickupdate.PobingUpdateCallback;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.BitmapsCache;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeCallBack;
import com.tencent.mobileqq.vas.trooppobing.PobingDecoder.DecodeData;
import com.tencent.mobileqq.vas.trooppobing.PobingManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class TroopPobingItemView
  extends RelativeLayout
  implements View.OnClickListener, PobingDecoder.DecodeCallBack
{
  public static final HashMap<Integer, String> a;
  public static final HashMap<Integer, String> b = new TroopPobingItemView.2();
  int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TroopPobingItemBuilder.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new TroopPobingItemView.1();
  }
  
  public TroopPobingItemView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopPobingItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562000, this);
    findViewById(2131372890).setOnClickListener(this);
    findViewById(2131372884).setOnClickListener(this);
  }
  
  private void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    Resources localResources = getContext().getResources();
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      int k = localView.getId();
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(localResources, (Bitmap)paramBitmapsCache.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k)));
      int j = 8;
      Object localObject1;
      Object localObject2;
      switch (k)
      {
      default: 
        localView.setBackgroundDrawable(localBitmapDrawable);
        break;
      case 2131372890: 
        localObject1 = new StateListDrawable();
        localObject2 = new BitmapDrawable(localResources, (Bitmap)paramBitmapsCache.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k)));
        ((Drawable)localObject2).setColorFilter(0, PorterDuff.Mode.CLEAR);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, localBitmapDrawable);
        ((StateListDrawable)localObject1).addState(new int[] { 0 }, (Drawable)localObject2);
        localView.setBackgroundDrawable((Drawable)localObject1);
        if (!this.jdField_a_of_type_Boolean) {
          j = 0;
        }
        localView.setVisibility(j);
        ((TextView)localView).setTextColor(paramBitmapsCache.b);
        break;
      case 2131372882: 
        localObject1 = (Bitmap)paramBitmapsCache.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(k));
        localObject2 = (TextView)localView;
        ((TextView)localObject2).setTextColor(paramBitmapsCache.b);
        ((TextView)localObject2).setMaxWidth(localBitmapDrawable.getIntrinsicWidth());
        localView.setBackgroundDrawable(PobingUpdateCallback.createNinePatchDrawable(getResources(), (Bitmap)localObject1));
        break;
      case 2131372881: 
        localView.setBackgroundDrawable(localBitmapDrawable);
        if (!this.jdField_a_of_type_Boolean) {
          j = 0;
        }
        localView.setVisibility(j);
      }
      i += 1;
    }
    TroopPobingItemBuilder.a(this.jdField_a_of_type_AndroidViewView, true);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    PobingDecoder.BitmapsCache localBitmapsCache = PobingDecoder.a(PobingManager.a(paramInt));
    if (localBitmapsCache != null)
    {
      a(localBitmapsCache);
      return;
    }
    new PobingDecoder(paramInt, jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(View paramView, TroopPobingItemBuilder.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback = paramCallback;
  }
  
  public void a(PobingDecoder.DecodeData paramDecodeData)
  {
    paramDecodeData = PobingDecoder.a(paramDecodeData, false);
    if (paramDecodeData == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new TroopPobingItemView.3(this, paramDecodeData));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131372884)
    {
      if (i == 2131372890)
      {
        TroopPobingItemBuilder.Callback localCallback = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback;
        if (localCallback != null) {
          localCallback.a(this);
        }
        ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 2, 0, "", "", "", "");
      }
    }
    else {
      PobingManager.a(getContext());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemView
 * JD-Core Version:    0.7.0.1
 */