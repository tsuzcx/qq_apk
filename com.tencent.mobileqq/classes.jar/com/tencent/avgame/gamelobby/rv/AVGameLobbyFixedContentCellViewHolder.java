package com.tencent.avgame.gamelobby.rv;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.data.AVGameLobbyFixedContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;

public class AVGameLobbyFixedContentCellViewHolder
  extends BaseViewHolder<AVGameLobbyFixedContentInfo>
{
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RecyclerView.LayoutParams jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c;
  
  public AVGameLobbyFixedContentCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams = ((RecyclerView.LayoutParams)paramView.getLayoutParams());
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width;
    this.c = this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363290));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363287));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363286);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363288));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363284));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363283));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363285));
    paramView.setOnTouchListener(new AVGameLobbyFixedContentCellViewHolder.1(this));
    a(paramView);
  }
  
  private void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyFixedContentInfo paramAVGameLobbyFixedContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyFixedContentInfo, paramInt);
    if (paramAVGameLobbyFixedContentInfo == null) {
      return;
    }
    if ((paramAVGameLobbyFixedContentInfo.a()) && (!AVGameLobbyFixedContentInfo.b()))
    {
      this.itemView.setVisibility(8);
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = 0;
      this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = 0;
      return;
    }
    this.itemView.setVisibility(0);
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.width = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidxRecyclerviewWidgetRecyclerView$LayoutParams.height = this.c;
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyFixedContentInfo.a());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyFixedContentInfo.c());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramAVGameLobbyFixedContentInfo.d());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbyFixedContentInfo.b());
    if (paramAVGameLobbyFixedContentInfo.a())
    {
      if ((paramViewHolderContext instanceof AVGameLobbyViewHolderContext)) {
        a(((AVGameLobbyViewHolderContext)paramViewHolderContext).a());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.a(17, 17, paramAVGameLobbyFixedContentInfo.a(), this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.itemView.getContext().getString(2131690459, new Object[] { Integer.valueOf(paramAVGameLobbyFixedContentInfo.e()) }));
      if (paramAVGameLobbyFixedContentInfo.e() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyFixedContentCellViewHolder
 * JD-Core Version:    0.7.0.1
 */