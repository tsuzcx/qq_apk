package com.tencent.avgame.gamelobby.rv;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.avgame.gamelobby.data.AVGameLobbyCommonContentInfo;
import com.tencent.avgame.gamelobby.view.AutoResizeAsyncImageView;
import com.tencent.avgame.gamelobby.view.OverlappingImgLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class AVGameLobbyCommonCellViewHolder
  extends BaseViewHolder<AVGameLobbyCommonContentInfo>
  implements View.OnTouchListener
{
  private static final String jdField_a_of_type_JavaLangString = "com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder";
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AutoResizeAsyncImageView jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView;
  private OverlappingImgLayout jdField_a_of_type_ComTencentAvgameGamelobbyViewOverlappingImgLayout;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
  private AsyncImageView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView;
  
  public AVGameLobbyCommonCellViewHolder(@NonNull View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131363210));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363207);
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView = ((AutoResizeAsyncImageView)paramView.findViewById(2131363208));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131363205));
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewOverlappingImgLayout = ((OverlappingImgLayout)paramView.findViewById(2131363204));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363206));
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
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    super.a();
  }
  
  public void a(ViewHolderContext paramViewHolderContext, AVGameLobbyCommonContentInfo paramAVGameLobbyCommonContentInfo, int paramInt)
  {
    super.a(paramViewHolderContext, paramAVGameLobbyCommonContentInfo, paramInt);
    if (paramAVGameLobbyCommonContentInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setUrlIconAsyncImage(paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaLangString);
    float f = ViewUtils.a(6.0F);
    paramInt = paramAVGameLobbyCommonContentInfo.jdField_c_of_type_Int;
    int i = paramAVGameLobbyCommonContentInfo.d;
    Object localObject = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { paramInt | 0xFF000000, 0xFF000000 | i });
    ((GradientDrawable)localObject).setCornerRadius(f);
    ((GradientDrawable)localObject).setGradientType(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApngImage url:");
    localStringBuilder.append(paramAVGameLobbyCommonContentInfo.b);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameGamelobbyViewAutoResizeAsyncImageView.a(paramAVGameLobbyCommonContentInfo.b);
    if ((paramViewHolderContext instanceof AVGameLobbyViewHolderContext)) {
      a(((AVGameLobbyViewHolderContext)paramViewHolderContext).a());
    }
    if (paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGamelobbyViewOverlappingImgLayout.a(17, 17, paramAVGameLobbyCommonContentInfo.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAVGameLobbyCommonContentInfo.jdField_c_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyCommonCellViewHolder
 * JD-Core Version:    0.7.0.1
 */