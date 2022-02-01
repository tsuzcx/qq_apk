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
import com.tencent.avgame.gamelobby.data.AVGameLobbyRandomMatchContentInfo;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class AVGameLobbyRandomMatchCellViewHolder
  extends BaseViewHolder<AVGameLobbyRandomMatchContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder";
  private Context jdField_a_of_type_AndroidContentContext = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private AsyncImageView jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  
  public AVGameLobbyRandomMatchCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363104));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363105));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372844));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131371697));
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363103));
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
    paramViewHolderContext.width = GameRoomViewLayoutParamsDef.p;
    paramViewHolderContext.height = GameRoomViewLayoutParamsDef.q;
    paramInt = ViewUtils.a(15.0F);
    int i = paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_Int % 3;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(53);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, GameRoomViewLayoutParamsDef.u, paramInt);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(49);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, paramInt);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setGravity(51);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(GameRoomViewLayoutParamsDef.u, 0, 0, paramInt);
    }
    if (TextUtils.isEmpty(paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690378), new Object[] { Integer.valueOf(0) }));
    } else {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyRandomMatchContentInfo.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbyRandomMatchContentInfo.a);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbyRandomMatchContentInfo.b);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyRandomMatchCellViewHolder
 * JD-Core Version:    0.7.0.1
 */