package com.tencent.mobileqq.activity.richmedia;

import aluf;
import alxd;
import alxk;
import alxl;
import alxm;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import bhgm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

public class VideoFilterViewPager
  extends ViewPager
{
  private int jdField_a_of_type_Int;
  private alxk jdField_a_of_type_Alxk;
  private alxl jdField_a_of_type_Alxl;
  private alxm jdField_a_of_type_Alxm;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoFilterViewPager.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = true;
  
  public VideoFilterViewPager(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public VideoFilterViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  private void a(View paramView, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, String.format("onPageSelect position:%s, instantiate:%s, mShowGuideWording:%s, mShowNewGuide:%s, camera:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.b), Integer.valueOf(aluf.jdField_a_of_type_Int) }));
    }
    Object localObject2 = this.jdField_a_of_type_Alxm.a(paramInt);
    if (!paramBoolean) {
      alxd.a().a((FilterDesc)localObject2);
    }
    paramView = (TextView)paramView.findViewById(2131374351);
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
    int i = ((SharedPreferences)localObject1).getInt("wordingShowTimes", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    boolean bool = ((SharedPreferences)localObject1).getBoolean("showSvafGuideWording_" + str, true);
    if ((this.jdField_a_of_type_Boolean) && (i < 3) && (this.jdField_a_of_type_Alxm.a(paramInt) == 0))
    {
      if (!paramBoolean) {
        ((SharedPreferences)localObject1).edit().putInt("wordingShowTimes", i + 1).commit();
      }
      localObject2 = bhgm.a(getResources(), 2130846004);
      if (localObject2 != null)
      {
        paramInt = ((Bitmap)localObject2).getWidth();
        i = ((Bitmap)localObject2).getHeight();
        localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
        ((Drawable)localObject2).setBounds(0, 0, paramInt, i);
        paramView.setCompoundDrawables(null, (Drawable)localObject2, null, null);
        paramView.setText("");
        ((SharedPreferences)localObject1).edit().putBoolean("showSvafGuideWording_" + str, false).commit();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.b = false;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("VideoFilterViewPager", 2, "decode arrow bitmap failed! position: " + paramInt);
      }
      paramView.setCompoundDrawables(null, null, null, null);
      paramView.setText("");
      continue;
      if ((this.b) && (bool) && (aluf.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Alxm.a(paramInt) == 0) && (QmcfManager.getInstance().hasQmcfEntrance(1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFilterViewPager", 2, "mShowSvafGuideWording!");
        }
        ((SharedPreferences)localObject1).edit().putBoolean("showSvafGuideWording_" + str, false).commit();
        localObject1 = bhgm.a(getResources(), 2130846003);
        if (localObject1 != null)
        {
          paramInt = ((Bitmap)localObject1).getWidth();
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          ((Drawable)localObject1).setBounds(0, 0, paramInt, i);
          paramView.setCompoundDrawables(null, (Drawable)localObject1, null, null);
          paramView.setText("");
        }
      }
      else if (localObject2 != null)
      {
        localObject1 = bhgm.a(((FilterDesc)localObject2).getIconFile(alxd.b));
        if (localObject1 != null)
        {
          paramInt = ((Bitmap)localObject1).getWidth();
          i = ((Bitmap)localObject1).getHeight();
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          ((Drawable)localObject1).setBounds(0, 0, paramInt, i);
          paramView.setCompoundDrawables(null, (Drawable)localObject1, null, null);
          paramView.setText("");
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoFilterViewPager", 2, "decode filter bitmap failed! position: " + paramInt);
          }
          paramView.setCompoundDrawables(null, null, null, null);
          paramView.setText("");
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Alxm = new alxm(this);
    this.jdField_a_of_type_Alxl = new alxl(this);
    setAdapter(this.jdField_a_of_type_Alxm);
    setOnPageChangeListener(this.jdField_a_of_type_Alxl);
  }
  
  public FilterDesc a()
  {
    return this.jdField_a_of_type_Alxm.a(getCurrentItem());
  }
  
  public FilterDesc a(int paramInt)
  {
    return this.jdField_a_of_type_Alxm.a(paramInt);
  }
  
  public void a()
  {
    int i = getCurrentItem();
    if ((this.b) && (this.jdField_a_of_type_Alxm.a(i) == 0) && (aluf.jdField_a_of_type_Int == 2) && (QmcfManager.getInstance().hasQmcfEntrance(1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "onCameraChange back!");
      }
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (localSharedPreferences.getBoolean("showSvafGuideWording_" + str, true)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
    }
  }
  
  public void a(List<FilterDesc> paramList)
  {
    int i = 1;
    setVisibility(0);
    this.jdField_a_of_type_Alxm.a(paramList);
    setCurrentItem(this.jdField_a_of_type_Alxm.a() * 50, false);
    paramList = BaseApplicationImpl.getApplication().getSharedPreferences("VideoFilterViewPager_video_filter", 0);
    int j = paramList.getInt("wordingShowTimes", 0);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((aluf.jdField_a_of_type_Int == 2) && (paramList.getBoolean("showSvafGuideWording_" + str, true))) {}
    for (;;)
    {
      int k = getCurrentItem();
      if (((j < 3) || (i != 0)) && (this.jdField_a_of_type_Alxm.a(k) == 0)) {
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
      }
      return;
      i = 0;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c()
  {
    if (isShown())
    {
      int i = getCurrentItem();
      View localView = this.jdField_a_of_type_Alxm.a(i);
      if (localView != null)
      {
        localView.removeCallbacks((Runnable)localView.getTag());
        localView.clearAnimation();
        localView.setVisibility(4);
        if (this.jdField_a_of_type_Alxk != null)
        {
          this.jdField_a_of_type_Alxk.a(1);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener hideWordingIfNeed state: 1");
          }
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setViewPagerItemVisiableChangeListener(alxk paramalxk)
  {
    this.jdField_a_of_type_Alxk = paramalxk;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager
 * JD-Core Version:    0.7.0.1
 */