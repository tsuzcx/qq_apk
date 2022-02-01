package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.data.TransitionCategoryItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class TransitionProviderGridAdapter
  extends BaseAdapter
{
  public static final int a;
  public static final int b;
  public static final int c = ViewUtils.b(10.0F);
  float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<TransitionProviderGridAdapter.ConvertViewTag> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList(0);
  public boolean a;
  float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  int d;
  
  static
  {
    jdField_a_of_type_Int = ViewUtils.b(40.0F);
    jdField_b_of_type_Int = ViewUtils.b(5.0F);
  }
  
  public TransitionProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    if (!this.jdField_a_of_type_Boolean)
    {
      i = c;
      localFrameLayout.setPadding(i, i, i, i);
    }
    else
    {
      i = jdField_b_of_type_Int;
      localFrameLayout.setPadding(i, 0, i, i);
    }
    int i = jdField_b_of_type_Int;
    ((RelativeLayout.LayoutParams)localObject1).setMargins(i, i, i, i);
    localRelativeLayout.addView(localFrameLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject1).setId(2131368343);
    ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
    i = jdField_a_of_type_Int;
    Object localObject2 = new FrameLayout.LayoutParams(i, i);
    ((FrameLayout.LayoutParams)localObject2).gravity = 49;
    localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131366842);
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    Object localObject3 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject3).gravity = 81;
    localFrameLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TransitionProviderGridAdapter.ConvertViewTag();
    ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject1);
    ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_AndroidViewView = localFrameLayout;
    ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
    ((TransitionProviderGridAdapter.ConvertViewTag)localObject3).jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localRelativeLayout.setTag(localObject3);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
    return localRelativeLayout;
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      try
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        if (paramString.getStatus() == 2) {
          paramString.restartDownload();
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      catch (Error paramImageView)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setStaticURLDrawable ");
          paramString.append(paramImageView.toString());
          QLog.d("TransitionProviderGridAdapter", 2, paramString.toString());
        }
      }
    }
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    if ((paramImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getFilesDir());
      ((StringBuilder)localObject1).append("/shortvideo_transition_preview/");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdir();
      }
      localObject2 = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject2);
      localObject1 = VasApngUtil.getApngDrawable(localAppRuntime, localStringBuilder.toString(), paramString, null, new int[] { 16 }, "-Transition-", null);
      if (localObject1 != null)
      {
        paramImageView.setImageDrawable((Drawable)localObject1);
        if (((URLDrawable)localObject1).getStatus() == 2)
        {
          if (QLog.isColorLevel())
          {
            paramImageView = new StringBuilder();
            paramImageView.append("restartDownload apng:");
            paramImageView.append(paramString);
            QLog.d("TransitionProviderGridAdapter", 2, paramImageView.toString());
          }
          ((URLDrawable)localObject1).restartDownload();
        }
        return;
      }
      throw new Exception("urlDrawableApng null");
    }
    throw new Exception("apngUrl null");
  }
  
  public void a()
  {
    TransitionCategoryItem localTransitionCategoryItem1 = VideoFilterTools.a().a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransitionProviderGridAdapter.ConvertViewTag localConvertViewTag = (TransitionProviderGridAdapter.ConvertViewTag)localIterator.next();
      TransitionCategoryItem localTransitionCategoryItem2 = localConvertViewTag.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localTransitionCategoryItem2 != null)
      {
        if (localTransitionCategoryItem1 != null) {
          bool1 = TextUtils.equals(localTransitionCategoryItem1.a, localConvertViewTag.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem.a);
        } else {
          bool1 = false;
        }
        if (!bool1) {
          if (localTransitionCategoryItem1 != null)
          {
            bool1 = bool2;
            if (!localTransitionCategoryItem1.b()) {}
          }
          else
          {
            bool1 = bool2;
            if (localConvertViewTag.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem.b()) {
              bool1 = true;
            }
          }
        }
      }
      localConvertViewTag.a(bool1);
    }
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderGridAdapter", 2, "onDestroy");
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Float <= 0.0F) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Float = paramViewGroup.getMeasuredWidth();
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_Float = ((this.jdField_a_of_type_Float - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 3.2F + 0.5F);
      } else {
        this.jdField_b_of_type_Float = ((this.jdField_a_of_type_Float - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4.0F + 0.5F);
      }
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    if ((paramViewGroup.getTag() != null) && ((paramViewGroup.getTag() instanceof TransitionProviderGridAdapter.ConvertViewTag)))
    {
      TransitionProviderGridAdapter.ConvertViewTag localConvertViewTag = (TransitionProviderGridAdapter.ConvertViewTag)paramViewGroup.getTag();
      TextView localTextView = localConvertViewTag.jdField_a_of_type_AndroidWidgetTextView;
      URLImageView localURLImageView = localConvertViewTag.jdField_a_of_type_ComTencentImageURLImageView;
      TransitionCategoryItem localTransitionCategoryItem = (TransitionCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localConvertViewTag.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataTransitionCategoryItem = localTransitionCategoryItem;
      paramView = VideoFilterTools.a().a();
      boolean bool1;
      if (paramView != null) {
        bool1 = TextUtils.equals(paramView.a, localTransitionCategoryItem.a);
      } else {
        bool1 = false;
      }
      boolean bool2 = bool1;
      if (!bool1) {
        if (((paramView == null) || (paramView.b())) && (localTransitionCategoryItem.b())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
      Object localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        paramViewGroup.setLayoutParams(paramView);
      }
      paramView.height = ((int)this.jdField_b_of_type_Float);
      localConvertViewTag.a(bool2);
      try
      {
        b(localURLImageView, localTransitionCategoryItem.j);
      }
      catch (Exception paramView)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setApngURLDrawable ");
          ((StringBuilder)localObject).append(paramView.toString());
          QLog.d("TransitionProviderGridAdapter", 2, ((StringBuilder)localObject).toString());
        }
        a(localURLImageView, localTransitionCategoryItem.d);
      }
      catch (Error paramView)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setApngURLDrawable ");
          ((StringBuilder)localObject).append(paramView.toString());
          QLog.d("TransitionProviderGridAdapter", 2, ((StringBuilder)localObject).toString());
        }
        a(localURLImageView, localTransitionCategoryItem.d);
      }
      localTextView.setText(localTransitionCategoryItem.b);
      paramViewGroup.setFocusable(true);
      paramViewGroup.setFocusableInTouchMode(true);
      paramView = new StringBuilder();
      paramView.append(localTransitionCategoryItem.b);
      paramView.append(HardCodeUtil.a(2131714853));
      paramViewGroup.setContentDescription(paramView.toString());
      return paramViewGroup;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderGridAdapter", 2, "ConvertViewTag null");
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.TransitionProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */