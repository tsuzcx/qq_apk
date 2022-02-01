package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class AVGameLobbySurvivalCellViewHolder
  extends BaseViewHolder<AVGameLobbySurvivalContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder";
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentAvgameGamelobbyViewOverlappingImgLayout;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private TextView c;
  private TextView d;
  
  public AVGameLobbySurvivalCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363239));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363233));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363231);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363234));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363229));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363228));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363230));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363237));
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363236));
    this.c = ((TextView)paramView.findViewById(2131363238));
    this.d = ((TextView)paramView.findViewById(2131363240));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363232);
    paramView.setOnTouchListener(this);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setOnTouchListener(this);
    a(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView);
    a(paramView);
  }
  
  protected void a()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbySurvivalContentInfo paramAVGameLobbySurvivalContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbySurvivalContentInfo, paramInt);
    if (paramAVGameLobbySurvivalContentInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.b());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbySurvivalContentInfo.d());
    if (!TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.h()))
    {
      paramViewHolderContext = URLDrawable.getDrawable(paramAVGameLobbySurvivalContentInfo.h(), URLDrawableHelperConstants.a, URLDrawableHelperConstants.a);
    }
    else
    {
      float f = ViewUtils.a(6.0F);
      paramInt = paramAVGameLobbySurvivalContentInfo.f();
      int i = paramAVGameLobbySurvivalContentInfo.g();
      paramViewHolderContext = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, i | 0xFF000000 });
      paramViewHolderContext.setCornerRadius(f);
      paramViewHolderContext.setGradientType(0);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramViewHolderContext);
    this.d.setVisibility(0);
    if (!TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.g())) {
      this.d.setText(paramAVGameLobbySurvivalContentInfo.g());
    } else {
      this.d.setText(paramAVGameLobbySurvivalContentInfo.a());
    }
    if (paramAVGameLobbySurvivalContentInfo.a())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
      if (paramAVGameLobbySurvivalContentInfo.c()) {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setClickable(true);
      } else {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setClickable(false);
      }
      if (QLog.isColorLevel())
      {
        paramViewHolderContext = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mReserveImageView isClickable:");
        localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.isClickable());
        QLog.d(paramViewHolderContext, 2, localStringBuilder.toString());
      }
      if (paramAVGameLobbySurvivalContentInfo.b())
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.f());
        this.c.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbySurvivalContentInfo.e());
        this.c.setVisibility(0);
        this.c.setText(String.format(this.itemView.getContext().getString(2131690387), new Object[] { Integer.valueOf(paramAVGameLobbySurvivalContentInfo.e()) }));
      }
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).rightMargin = ViewUtils.a(10.0F);
      return;
    }
    paramViewHolderContext = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApngImage url:");
    localStringBuilder.append(paramAVGameLobbySurvivalContentInfo.c());
    QLog.d(paramViewHolderContext, 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbySurvivalContentInfo.c());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).rightMargin = ViewUtils.a(90.0F);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder
 * JD-Core Version:    0.7.0.1
 */