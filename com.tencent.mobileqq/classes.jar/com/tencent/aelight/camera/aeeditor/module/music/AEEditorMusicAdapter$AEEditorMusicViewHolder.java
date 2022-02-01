package com.tencent.aelight.camera.aeeditor.module.music;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.AEFastClickThrottle;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.utils.ApolloLottieAnim;
import com.tencent.mobileqq.utils.ViewUtils;

class AEEditorMusicAdapter$AEEditorMusicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AEDownLoadingView jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView;
  private AEEditorMusicAdapter.AEEditorMusicInfo jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
  private AEEditorMusicAdapter.ClickCallback jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private ApolloLottieAnim jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim;
  private final int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  public AEEditorMusicAdapter$AEEditorMusicViewHolder(@NonNull View paramView, @Nullable AEEditorMusicAdapter.ClickCallback paramClickCallback, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122538));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122317));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2064122208));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122318));
    this.c = ((ImageView)paramView.findViewById(2064122313));
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView = ((AEDownLoadingView)paramView.findViewById(2064122512));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122773));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2064122107));
    this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim = new ApolloLottieAnim(null, paramView.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback = paramClickCallback;
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgCorner(paramInt3 / 2);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumHeight(paramInt3);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setMinimumWidth(paramInt3);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressSizeAndMode(paramInt1, paramInt2, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setBgColor(0);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgressColor(-1);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.a(false);
  }
  
  void a()
  {
    DiniFlyAnimationView localDiniFlyAnimationView = this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
    if ((localDiniFlyAnimationView != null) && (localDiniFlyAnimationView.getVisibility() == 0) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
    }
  }
  
  public void a(@NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
    this.jdField_a_of_type_Int = paramInt1;
    if ((paramAEEditorMusicInfo.c == 2) && (!TextUtils.isEmpty(paramAEEditorMusicInfo.c())))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView, paramAEEditorMusicInfo.c(), UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), this.jdField_b_of_type_Int), UIUtils.a(this.jdField_a_of_type_AndroidWidgetImageView.getContext(), this.jdField_b_of_type_Int), this.jdField_a_of_type_AndroidWidgetImageView.getContext().getResources().getDrawable(2064056481), null);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    Object localObject;
    if (paramAEEditorMusicInfo.jdField_a_of_type_Boolean)
    {
      if (paramAEEditorMusicInfo.jdField_a_of_type_Int == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(0);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgress(paramAEEditorMusicInfo.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056483);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(AEEditorConstants.b)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(this.jdField_a_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, AEEditorConstants.b, true);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqUtilsApolloLottieAnim.a(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, "https://downv6.qq.com/shadow_qqcamera/Android/lottie/MusicWave_8e84b13bfc72dd3c86c70617db423aef.zip", AEEditorConstants.a, true);
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setTypeface(((TextView)localObject).getTypeface(), 1);
    }
    else
    {
      if (paramAEEditorMusicInfo.c == 0)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056481);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      else if (paramAEEditorMusicInfo.c == 1)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056489);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2064056520);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      else if (paramAEEditorMusicInfo.c == 3)
      {
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2064056481);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.c.setVisibility(8);
        this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056521);
      }
      else
      {
        if (paramAEEditorMusicInfo.jdField_a_of_type_Int == 1)
        {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(4);
          this.c.setVisibility(0);
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(0);
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setProgress(paramAEEditorMusicInfo.jdField_b_of_type_Int);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetFrameLayout.setVisibility(8);
          this.c.setVisibility(8);
          this.jdField_a_of_type_ComTencentAelightCameraAeViewAEDownLoadingView.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(null, 0);
    }
    if (paramAEEditorMusicInfo.c == 1)
    {
      paramAEEditorMusicInfo = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2064515185);
    }
    else if (paramAEEditorMusicInfo.c == 3)
    {
      paramAEEditorMusicInfo = this.jdField_a_of_type_AndroidWidgetTextView.getContext().getString(2064515189);
    }
    else if (TextUtils.isEmpty(AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo)))
    {
      paramAEEditorMusicInfo = "";
    }
    else if (AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).length() > 5)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo).substring(0, 5));
      ((StringBuilder)localObject).append("...");
      paramAEEditorMusicInfo = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramAEEditorMusicInfo = AEEditorMusicAdapter.AEEditorMusicInfo.a(paramAEEditorMusicInfo);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAEEditorMusicInfo);
    paramAEEditorMusicInfo = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramInt1 == 0)
    {
      paramAEEditorMusicInfo.leftMargin = ViewUtils.a(12.0F);
      paramAEEditorMusicInfo.rightMargin = (-ViewUtils.a(4.0F));
    }
    else if (paramInt1 == paramInt2 - 1)
    {
      paramAEEditorMusicInfo.leftMargin = (-ViewUtils.a(4.0F));
      paramAEEditorMusicInfo.rightMargin = ViewUtils.a(12.0F);
    }
    else
    {
      paramAEEditorMusicInfo.leftMargin = (-ViewUtils.a(4.0F));
      paramAEEditorMusicInfo.rightMargin = (-ViewUtils.a(4.0F));
    }
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAEEditorMusicInfo);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2064122538)
    {
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
      if ((paramView != null) && (paramView.c != 0) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback != null))
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.c != 1)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, getAdapterPosition(), true ^ this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.c);
          return;
        }
        if (!AEFastClickThrottle.a("tag_music_search_btn")) {
          this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$ClickCallback.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, getAdapterPosition(), true ^ this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicViewHolder
 * JD-Core Version:    0.7.0.1
 */