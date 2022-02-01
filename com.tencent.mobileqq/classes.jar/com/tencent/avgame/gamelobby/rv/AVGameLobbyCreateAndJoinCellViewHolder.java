package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class AVGameLobbyCreateAndJoinCellViewHolder
  extends BaseViewHolder<AVGameLobbyCreateAndJoinContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder";
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private AsyncImageView jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  
  public AVGameLobbyCreateAndJoinCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363214));
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363226));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363212));
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363224));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363211));
    View localView = paramView.findViewById(2131363213);
    paramView = paramView.findViewById(2131363225);
    localView.setOnTouchListener(this);
    paramView.setOnTouchListener(this);
    a(paramView);
    a(localView);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyCreateAndJoinContentInfo paramAVGameLobbyCreateAndJoinContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyCreateAndJoinContentInfo, paramInt);
    if (paramAVGameLobbyCreateAndJoinContentInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbyCreateAndJoinContentInfo.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbyCreateAndJoinContentInfo.b);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.c);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.d);
    int j = ViewUtils.a(16.0F);
    int i;
    if (paramAVGameLobbyCreateAndJoinContentInfo.jdField_a_of_type_Boolean)
    {
      paramInt = ViewUtils.a(97.0F);
      i = ViewUtils.a(27.0F);
    }
    else
    {
      paramInt = ViewUtils.a(83.0F);
      i = ViewUtils.a(13.0F);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = paramInt;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, i, j, 0);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder
 * JD-Core Version:    0.7.0.1
 */