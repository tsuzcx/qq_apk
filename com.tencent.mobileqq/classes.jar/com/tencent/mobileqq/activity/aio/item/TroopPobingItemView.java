package com.tencent.mobileqq.activity.aio.item;

import adta;
import adtd;
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
import arok;
import awqx;
import banz;
import baqu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class TroopPobingItemView
  extends RelativeLayout
  implements View.OnClickListener, arok<banz>
{
  public static final HashMap<Integer, String> a;
  int jdField_a_of_type_Int;
  private adtd jdField_a_of_type_Adtd;
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
    inflate(paramContext, 2131496002, this);
    findViewById(2131306098).setOnClickListener(this);
    findViewById(2131306092).setOnClickListener(this);
  }
  
  static String a(int paramInt)
  {
    return "pobing.bitmap.cache." + paramInt;
  }
  
  private void b(banz parambanz)
  {
    Resources localResources = getContext().getResources();
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      int j = localView.getId();
      BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(localResources, (Bitmap)parambanz.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      switch (j)
      {
      default: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
      case 2131306090: 
        for (;;)
        {
          i += 1;
          break;
          localObject = (Bitmap)parambanz.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
          ((TextView)localView).setTextColor(parambanz.b);
          ((TextView)localView).setMaxWidth(localBitmapDrawable1.getIntrinsicWidth());
          localView.setBackgroundDrawable(baqu.a(getResources(), (Bitmap)localObject));
        }
      case 2131306089: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
        if (this.jdField_a_of_type_Boolean) {}
        for (j = 8;; j = 0)
        {
          localView.setVisibility(j);
          break;
        }
      }
      Object localObject = new StateListDrawable();
      BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(localResources, (Bitmap)parambanz.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      localBitmapDrawable2.setColorFilter(0, PorterDuff.Mode.CLEAR);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localBitmapDrawable1);
      ((StateListDrawable)localObject).addState(new int[] { 0 }, localBitmapDrawable2);
      localView.setBackgroundDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_Boolean) {}
      for (j = 8;; j = 0)
      {
        localView.setVisibility(j);
        ((TextView)localView).setTextColor(parambanz.b);
        break;
      }
    }
    adta.a(this.jdField_a_of_type_AndroidViewView, true);
    awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    banz localbanz = (banz)BaseApplicationImpl.sImageCache.get(a(paramInt));
    if (localbanz != null)
    {
      b(localbanz);
      return;
    }
    new PobingDecoder(paramInt, jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(View paramView, adtd paramadtd)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Adtd = paramadtd;
  }
  
  public void a(banz parambanz)
  {
    BaseApplicationImpl.sImageCache.put(a(parambanz.jdField_a_of_type_Int), parambanz);
    if (parambanz.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
      b(parambanz);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306098: 
      if (this.jdField_a_of_type_Adtd != null) {
        this.jdField_a_of_type_Adtd.a(this);
      }
      awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 2, 0, "", "", "", "");
      return;
    }
    paramView = getContext();
    String str = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.startActivity(localIntent);
    awqx.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemView
 * JD-Core Version:    0.7.0.1
 */