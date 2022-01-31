package com.tencent.biz.pubaccount.readinjoy.view;

import amrk;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class AlbumPermissionView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQPermissionCallback jdField_a_of_type_MqqAppQQPermissionCallback;
  
  public AlbumPermissionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131559835, this, true);
    setOrientation(1);
    setGravity(17);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378769);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379040));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT > 23) {
      return amrk.a(BaseApplication.getContext());
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131378769) {
      amrk.a((AppActivity)this.jdField_a_of_type_AndroidContentContext, 10000, this.jdField_a_of_type_MqqAppQQPermissionCallback);
    }
  }
  
  public void setCallback(QQPermissionCallback paramQQPermissionCallback)
  {
    this.jdField_a_of_type_MqqAppQQPermissionCallback = paramQQPermissionCallback;
  }
  
  public void setContextStyleBlack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167201));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165318));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView
 * JD-Core Version:    0.7.0.1
 */