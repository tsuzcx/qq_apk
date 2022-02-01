package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
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
import mqq.util.WeakReference;

public class TroopPobingEffectItemView
  extends RelativeLayout
  implements View.OnClickListener, PobingDecoder.DecodeCallBack
{
  public static final HashMap<Integer, String> a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new TroopPobingEffectItemView.3(this);
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private TroopPobingItemBuilder.Callback jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<URLImageView> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  private WeakReference<Button> jdField_b_of_type_MqqUtilWeakReference;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new TroopPobingEffectItemView.1();
  }
  
  public TroopPobingEffectItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TroopPobingEffectItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131562162, this);
    findViewById(2131366096).setOnClickListener(this);
    findViewById(2131366095).setOnClickListener(this);
    setHorizontalGravity(0);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference((URLImageView)findViewById(2131366095));
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference((Button)findViewById(2131366096));
  }
  
  private void a()
  {
    post(new TroopPobingEffectItemView.4(this));
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    do
    {
      return;
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
    } while (!(paramURLDrawable instanceof ApngDrawable));
    ((ApngDrawable)paramURLDrawable).setOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
  }
  
  private void a(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    c(paramBitmapsCache);
    b(paramBitmapsCache);
    TroopPobingItemBuilder.a(this.jdField_a_of_type_AndroidViewView, true);
    ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 3, 0, "", "", "", "");
  }
  
  private void b()
  {
    Object localObject = (URLImageView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    }
    localObject = (Button)this.jdField_b_of_type_MqqUtilWeakReference.get();
    if (localObject != null) {
      if (!this.jdField_a_of_type_Boolean) {
        break label77;
      }
    }
    label77:
    for (int i = 8;; i = 0)
    {
      ((Button)localObject).setVisibility(i);
      localObject = (TextView)findViewById(2131366094);
      ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      ((TextView)localObject).setVisibility(0);
      return;
    }
  }
  
  private void b(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    if (this.jdField_a_of_type_Boolean) {}
    StateListDrawable localStateListDrawable;
    do
    {
      return;
      localStateListDrawable = new StateListDrawable();
      URLDrawable localURLDrawable = VasApngFactory.a("press", new VasApngFactory.Options(), paramBitmapsCache.a(2131366096));
      localURLDrawable.setColorFilter(1291845632, PorterDuff.Mode.SRC_ATOP);
      paramBitmapsCache = VasApngFactory.a("normal", new VasApngFactory.Options(), paramBitmapsCache.a(2131366096));
      localStateListDrawable.addState(new int[] { 16842919 }, localURLDrawable);
      localStateListDrawable.addState(new int[] { 0 }, paramBitmapsCache);
      paramBitmapsCache = (Button)this.jdField_b_of_type_MqqUtilWeakReference.get();
    } while (paramBitmapsCache == null);
    paramBitmapsCache.setBackgroundDrawable(localStateListDrawable);
  }
  
  private void c(PobingDecoder.BitmapsCache paramBitmapsCache)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable = VasApngFactory.a("", new VasApngFactory.Options(), paramBitmapsCache.a(2131366094));
    if (!PobingManager.a(this.jdField_a_of_type_Long)) {
      b();
    }
    do
    {
      URLImageView localURLImageView;
      do
      {
        return;
        localURLImageView = (URLImageView)this.jdField_a_of_type_MqqUtilWeakReference.get();
      } while ((localURLImageView == null) || (localURLImageView.getBackground() != null));
      VasApngFactory.Options localOptions = new VasApngFactory.Options();
      localOptions.a(1);
      localOptions.a(new TroopPobingEffectItemView.2(this));
      this.jdField_b_of_type_ComTencentImageURLDrawable = VasApngFactory.a("", localOptions, paramBitmapsCache.a(2131366095));
      localURLImageView.setImageDrawable(this.jdField_b_of_type_ComTencentImageURLDrawable);
    } while (this.jdField_b_of_type_ComTencentImageURLDrawable.getStatus() != 1);
    a(this.jdField_b_of_type_ComTencentImageURLDrawable);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    PobingDecoder.BitmapsCache localBitmapsCache = PobingDecoder.a(PobingManager.a(this.jdField_a_of_type_Int));
    if (localBitmapsCache != null)
    {
      a(localBitmapsCache);
      return;
    }
    new PobingDecoder(this.jdField_a_of_type_Int, jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(PobingDecoder.DecodeData paramDecodeData)
  {
    paramDecodeData = PobingDecoder.a(paramDecodeData, false);
    if (paramDecodeData == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new TroopPobingEffectItemView.5(this, paramDecodeData));
  }
  
  public void a(String paramString, View paramView, TroopPobingItemBuilder.Callback paramCallback)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback = paramCallback;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$Callback.a(this);
      }
      ReportController.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
      continue;
      PobingManager.a(getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingEffectItemView
 * JD-Core Version:    0.7.0.1
 */