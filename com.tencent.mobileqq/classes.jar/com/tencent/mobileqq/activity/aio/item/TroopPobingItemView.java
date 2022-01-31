package com.tencent.mobileqq.activity.aio.item;

import agfa;
import agfd;
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
import aufy;
import azqs;
import bdtm;
import bdwn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vas.PobingDecoder;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class TroopPobingItemView
  extends RelativeLayout
  implements View.OnClickListener, aufy<bdtm>
{
  public static final HashMap<Integer, String> a;
  int jdField_a_of_type_Int;
  private agfd jdField_a_of_type_Agfd;
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
    inflate(paramContext, 2131561802, this);
    findViewById(2131372133).setOnClickListener(this);
    findViewById(2131372127).setOnClickListener(this);
  }
  
  static String a(int paramInt)
  {
    return "pobing.bitmap.cache." + paramInt;
  }
  
  private void b(bdtm parambdtm)
  {
    Resources localResources = getContext().getResources();
    int i = 0;
    if (i < getChildCount())
    {
      View localView = getChildAt(i);
      int j = localView.getId();
      BitmapDrawable localBitmapDrawable1 = new BitmapDrawable(localResources, (Bitmap)parambdtm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      switch (j)
      {
      default: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
      case 2131372125: 
        for (;;)
        {
          i += 1;
          break;
          localObject = (Bitmap)parambdtm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
          ((TextView)localView).setTextColor(parambdtm.b);
          ((TextView)localView).setMaxWidth(localBitmapDrawable1.getIntrinsicWidth());
          localView.setBackgroundDrawable(bdwn.a(getResources(), (Bitmap)localObject));
        }
      case 2131372124: 
        localView.setBackgroundDrawable(localBitmapDrawable1);
        if (this.jdField_a_of_type_Boolean) {}
        for (j = 8;; j = 0)
        {
          localView.setVisibility(j);
          break;
        }
      }
      Object localObject = new StateListDrawable();
      BitmapDrawable localBitmapDrawable2 = new BitmapDrawable(localResources, (Bitmap)parambdtm.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j)));
      localBitmapDrawable2.setColorFilter(0, PorterDuff.Mode.CLEAR);
      ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localBitmapDrawable1);
      ((StateListDrawable)localObject).addState(new int[] { 0 }, localBitmapDrawable2);
      localView.setBackgroundDrawable((Drawable)localObject);
      if (this.jdField_a_of_type_Boolean) {}
      for (j = 8;; j = 0)
      {
        localView.setVisibility(j);
        ((TextView)localView).setTextColor(parambdtm.b);
        break;
      }
    }
    agfa.a(this.jdField_a_of_type_AndroidViewView, true);
    azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A4F6", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    bdtm localbdtm = (bdtm)BaseApplicationImpl.sImageCache.get(a(paramInt));
    if (localbdtm != null)
    {
      b(localbdtm);
      return;
    }
    new PobingDecoder(paramInt, jdField_a_of_type_JavaUtilHashMap, this);
  }
  
  public void a(View paramView, agfd paramagfd)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Agfd = paramagfd;
  }
  
  public void a(bdtm parambdtm)
  {
    BaseApplicationImpl.sImageCache.put(a(parambdtm.jdField_a_of_type_Int), parambdtm);
    if (parambdtm.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
      b(parambdtm);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372133: 
      if (this.jdField_a_of_type_Agfd != null) {
        this.jdField_a_of_type_Agfd.a(this);
      }
      azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 2, 0, "", "", "", "");
      return;
    }
    paramView = getContext();
    String str = QzoneConfig.getInstance().getConfig("qqsetting", "addgroupvasjumpurl", "https://m.vip.qq.com/freedom/newbird.html?_cwv=1&_wv=553648133&g_ch=aio");
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramView.startActivity(localIntent);
    azqs.b(null, "dc00898", "", "", "qq_vip", "0X800A4F7", 3, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemView
 * JD-Core Version:    0.7.0.1
 */