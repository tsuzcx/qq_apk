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
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class AVGameLobbySurvivalCellViewHolder
  extends BaseViewHolder<AVGameLobbySurvivalContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = AVGameLobbySurvivalCellViewHolder.class.getName();
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView;
  private TextView c;
  private TextView d;
  
  public AVGameLobbySurvivalCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363307));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363301));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363299);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363302));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363297));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363296));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363298));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363305));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363304));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.c = ((TextView)paramView.findViewById(2131363306));
    this.d = ((TextView)paramView.findViewById(2131363308));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363300);
    paramView.setOnTouchListener(this);
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setOnTouchListener(this);
    a(this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView);
    a(paramView);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbySurvivalContentInfo paramAVGameLobbySurvivalContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbySurvivalContentInfo, paramInt);
    if (paramAVGameLobbySurvivalContentInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbySurvivalContentInfo.b());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbySurvivalContentInfo.d());
    if (!TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.h()))
    {
      paramViewHolderContext = URLDrawable.getDrawable(paramAVGameLobbySurvivalContentInfo.h(), URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramViewHolderContext);
      this.d.setVisibility(0);
      if (TextUtils.isEmpty(paramAVGameLobbySurvivalContentInfo.g())) {
        break label296;
      }
      this.d.setText(paramAVGameLobbySurvivalContentInfo.g());
      label95:
      if (!paramAVGameLobbySurvivalContentInfo.a()) {
        break label380;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(8);
      if (!paramAVGameLobbySurvivalContentInfo.c()) {
        break label310;
      }
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setClickable(true);
      label143:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mReserveImageView isClickable:" + this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.isClickable());
      }
      if (!paramAVGameLobbySurvivalContentInfo.b()) {
        break label321;
      }
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbySurvivalContentInfo.f());
      this.c.setVisibility(8);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).rightMargin = ViewUtils.a(10.0F);
      return;
      float f = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      paramInt = paramAVGameLobbySurvivalContentInfo.f();
      int i = paramAVGameLobbySurvivalContentInfo.g();
      paramViewHolderContext = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, i | 0xFF000000 });
      paramViewHolderContext.setCornerRadius(f);
      paramViewHolderContext.setGradientType(0);
      break;
      label296:
      this.d.setText(paramAVGameLobbySurvivalContentInfo.a());
      break label95;
      label310:
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setClickable(false);
      break label143;
      label321:
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbySurvivalContentInfo.e());
      this.c.setVisibility(0);
      this.c.setText(String.format(this.itemView.getContext().getString(2131690463), new Object[] { Integer.valueOf(paramAVGameLobbySurvivalContentInfo.e()) }));
    }
    label380:
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ApngImage url:" + paramAVGameLobbySurvivalContentInfo.c());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbySurvivalContentInfo.c());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).rightMargin = ViewUtils.a(90.0F);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbySurvivalCellViewHolder
 * JD-Core Version:    0.7.0.1
 */