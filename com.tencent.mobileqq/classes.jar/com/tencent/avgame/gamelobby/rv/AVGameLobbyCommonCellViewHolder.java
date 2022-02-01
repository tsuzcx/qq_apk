package com.tencent.avgame.gamelobby.rv;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.connections.OverlappingImgLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AVGameLobbyCommonCellViewHolder
  extends BaseViewHolder<AVGameLobbyCommonContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = AVGameLobbyCommonCellViewHolder.class.getName();
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AsyncImageView jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  
  public AVGameLobbyCommonCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363278));
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultColorDrawable(0);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363275);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363276));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363273));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363272));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363274));
    paramView.setOnTouchListener(this);
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
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyCommonContentInfo paramAVGameLobbyCommonContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyCommonContentInfo, paramInt);
    if (paramAVGameLobbyCommonContentInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaLangString);
    float f = AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    paramInt = paramAVGameLobbyCommonContentInfo.jdField_c_of_type_Int;
    int i = paramAVGameLobbyCommonContentInfo.d;
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, i | 0xFF000000 });
    localGradientDrawable.setCornerRadius(f);
    localGradientDrawable.setGradientType(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ApngImage url:" + paramAVGameLobbyCommonContentInfo.b);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbyCommonContentInfo.b);
    if ((paramViewHolderContext instanceof AVGameLobbyViewHolderContext)) {
      a(((AVGameLobbyViewHolderContext)paramViewHolderContext).a());
    }
    if (paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactConnectionsOverlappingImgLayout.a(17, 17, paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyCommonContentInfo.jdField_c_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder
 * JD-Core Version:    0.7.0.1
 */