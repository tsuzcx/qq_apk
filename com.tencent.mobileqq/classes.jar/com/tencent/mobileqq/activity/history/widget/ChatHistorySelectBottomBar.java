package com.tencent.mobileqq.activity.history.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistorySelectBottomBar
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ChatHistorySelectBottomBar.OnActionListener jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar$OnActionListener;
  private CustomFastOnClickListener jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener = new ChatHistorySelectBottomBar.2(this);
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private ImageView e;
  
  public ChatHistorySelectBottomBar(Context paramContext, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramViewGroup;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560775, null, false);
    Object localObject = paramViewGroup;
    if (!(paramViewGroup instanceof RelativeLayout))
    {
      localObject = new RelativeLayout(paramContext);
      paramViewGroup.addView((View)localObject, new RelativeLayout.LayoutParams(-1, -1));
    }
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(12);
    ((ViewGroup)localObject).addView(this.jdField_b_of_type_AndroidViewView, paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366036));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366035));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366040));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366037));
    this.e = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366034));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131366031);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
    this.e.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetCustomFastOnClickListener);
    b();
  }
  
  private void a(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView);
    while (!localArrayList.isEmpty())
    {
      int i = 0;
      paramView = (View)localArrayList.remove(0);
      if ((paramView instanceof ListView))
      {
        this.jdField_d_of_type_AndroidViewView = paramView;
        return;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        while (i < paramView.getChildCount())
        {
          localArrayList.add(paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  private boolean a()
  {
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext.getString(2131693191));
      return false;
    }
    return true;
  }
  
  public int a()
  {
    return AIOUtils.b(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_AndroidViewView == null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_d_of_type_AndroidViewView == null) {
        this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    c();
  }
  
  public void a(@DrawableRes int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
            return;
          }
          this.e.setEnabled(paramBoolean);
          return;
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
  }
  
  public void a(ChatHistorySelectBottomBar.OnActionListener paramOnActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar$OnActionListener = paramOnActionListener;
  }
  
  public void a(List<Integer> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int i = ((Integer)paramList.next()).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              }
            }
            else {
              this.e.setVisibility(0);
            }
          }
          else {
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          }
        }
        else {
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      else {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(1, paramBoolean);
    a(2, paramBoolean);
    a(3, paramBoolean);
    a(4, paramBoolean);
    a(5, paramBoolean);
  }
  
  public void b()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
  }
  
  @TargetApi(19)
  protected void c()
  {
    QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localQQBlurView != null)
    {
      localQQBlurView.c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130844308);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_d_of_type_AndroidViewView);
    localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    localQQBlurView.b(localQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ChatHistorySelectBottomBar.1(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar
 * JD-Core Version:    0.7.0.1
 */