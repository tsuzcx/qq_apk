package com.tencent.mobileqq.activity.aio.item;

import ahll;
import ahlo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import awzc;
import bdla;
import bhny;
import bhrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class TroopPobingItemView
  extends RelativeLayout
  implements View.OnClickListener, awzc<bhny>
{
  public static final HashMap<Integer, String> a;
  int jdField_a_of_type_Int;
  private ahlo jdField_a_of_type_Ahlo;
  private View jdField_a_of_type_AndroidViewView;
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
    inflate(paramContext, 2131562025, this);
    findViewById(2131372984).setOnClickListener(this);
    findViewById(2131372978).setOnClickListener(this);
  }
  
  static String a(int paramInt)
  {
    return "pobing.bitmap.cache." + paramInt;
  }
  
  private void b(bhny parambhny)
  {
    Resources localResources = getContext().getResources();
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      int j = localView.getId();
      BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(localResources, (Bitmap)parambhny.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      switch (j)
      {
      default: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
      case 2131372976: 
        for (;;)
        {
          i += 1;
          break;
          localObject = (Bitmap)parambhny.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
          ((TextView)localView).setTextColor(parambhny.b);
          ((TextView)localView).setMaxWidth(localBitmapDrawable1.getIntrinsicWidth());
          localView.setBackgroundDrawable(bhrt.a(getResources(), (Bitmap)localObject));
        }
      case 2131372975: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
        if (this.jdField_a_of_type_Boolean) {}
        for (j = 8;; j = 0)
        {
          localView.setVisibility(j);
          break;
        }
      }
      Object localObject = new StateListDrawable();
      BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(localResources, (Bitmap)parambhny.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      localBitmapDrawable2.setColorFilter(0, PorterDuff.Mode.CLEAR);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localBitmapDrawable1);
      ((StateListDrawable)localObject).addState(new int[] { 0 }, localBitmapDrawable2);
      localView.setBackgroundDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_Boolean) {}
      for (j = 8;; j = 0)
      {
        localView.setVisibility(j);
        ((TextView)localView).setTextColor(parambhny.b);
        break;
      }
    }
    ahll.a(this.jdField_a_of_type_AndroidViewView, true);
    bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    bhny localbhny = (bhny)BaseApplicationImpl.sImageCache.get(a(paramInt));
    if (localbhny != null)
    {
      b(localbhny);
      return;
    }
    new PobingDecoder(paramInt, jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(View paramView, ahlo paramahlo)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Ahlo = paramahlo;
  }
  
  public void a(bhny parambhny)
  {
    BaseApplicationImpl.sImageCache.put(a(parambhny.jdField_a_of_type_Int), parambhny);
    if (parambhny.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
      b(parambhny);
    }
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
      if (this.jdField_a_of_type_Ahlo != null) {
        this.jdField_a_of_type_Ahlo.a(this);
      }
      bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 2, 0, "", "", "", "");
      continue;
      Context localContext = getContext();
      String str = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
      Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      localContext.startActivity(localIntent);
      bdla.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemView
 * JD-Core Version:    0.7.0.1
 */