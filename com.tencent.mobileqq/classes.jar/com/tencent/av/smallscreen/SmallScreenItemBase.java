package com.tencent.av.smallscreen;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;

public class SmallScreenItemBase
{
  protected SmallScreenRelativeLayout a;
  protected SmallScreenToast a;
  protected String a;
  protected int i;
  protected int j;
  protected int k;
  
  public SmallScreenItemBase()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = null;
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = null;
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.FloatListener paramFloatListener)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout = ((SmallScreenRelativeLayout)paramLayoutInflater.inflate(this.i, null));
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.b();
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setFloatListener(paramFloatListener);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast = new SmallScreenToast(paramContext, this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setIsRotateSize(true);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    a(this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a());
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 136;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    int m;
    if (SmallScreenUtils.a()) {
      m = 2005;
    } else {
      m = 2002;
    }
    paramLayoutParams.type = m;
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setSize(this.j, this.k);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.f();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = a();
    String str;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      if (!this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.b()) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast.a();
      }
      if (!bool)
      {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.setCurPosition(paramInt);
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.d();
        if (QLog.isDevelopLevel())
        {
          str = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("showOrHide, show toast view , tag[");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("]");
          QLog.w(str, 4, localStringBuilder.toString());
        }
      }
    }
    else if (bool)
    {
      this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.e();
      if (QLog.isDevelopLevel())
      {
        str = this.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("showOrHide, hide toast view , tag[");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("]");
        QLog.w(str, 4, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenItemBase
 * JD-Core Version:    0.7.0.1
 */