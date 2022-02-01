package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AVGameLobbyRandomMatchCellViewHolder
  extends BaseViewHolder<AVGameLobbyRandomMatchContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = AVGameLobbyRandomMatchCellViewHolder.class.getName();
  private Context jdField_a_of_type_AndroidContentContext = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private AsyncImageView jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView;
  
  public AVGameLobbyRandomMatchCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363164));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363165));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373265));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131372115));
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363163));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this);
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyRandomMatchContentInfo paramAVGameLobbyRandomMatchContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyRandomMatchContentInfo, paramInt);
    if (paramAVGameLobbyRandomMatchContentInfo == null) {
      return;
    }
    paramViewHolderContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramViewHolderContext.width = GameRoomViewLayoutParamsDef.e;
    paramViewHolderContext.height = GameRoomViewLayoutParamsDef.f;
    paramInt = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    switch (paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_Int % 3)
    {
    default: 
      if (TextUtils.isEmpty(paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690454), new Object[] { Integer.valueOf(0) }));
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyRandomMatchContentInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyRandomMatchContentInfo.b);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(51);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(GameRoomViewLayoutParamsDef.j, 0, 0, paramInt);
      break;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(49);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, paramInt);
      break;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(53);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, GameRoomViewLayoutParamsDef.j, paramInt);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_JavaLangString);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder
 * JD-Core Version:    0.7.0.1
 */