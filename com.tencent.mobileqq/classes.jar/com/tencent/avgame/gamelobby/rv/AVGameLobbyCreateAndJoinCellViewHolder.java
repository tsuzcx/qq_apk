package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCreateAndJoinContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AVGameLobbyCreateAndJoinCellViewHolder
  extends BaseViewHolder<AVGameLobbyCreateAndJoinContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = AVGameLobbyCreateAndJoinCellViewHolder.class.getName();
  private Context jdField_a_of_type_AndroidContentContext = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private AsyncImageView jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  
  public AVGameLobbyCreateAndJoinCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363282));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363294));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363280));
    this.jdField_b_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363292));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363279));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    View localView = paramView.findViewById(2131363281);
    paramView = paramView.findViewById(2131363293);
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
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.c);
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyCreateAndJoinContentInfo.d);
    int j = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i;
    if (paramAVGameLobbyCreateAndJoinContentInfo.jdField_a_of_type_Boolean) {
      i = AIOUtils.a(97.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    for (paramInt = AIOUtils.a(27.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; paramInt = AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams().height = i;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(j, paramInt, j, 0);
      return;
      i = AIOUtils.a(83.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    }
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCreateAndJoinCellViewHolder
 * JD-Core Version:    0.7.0.1
 */