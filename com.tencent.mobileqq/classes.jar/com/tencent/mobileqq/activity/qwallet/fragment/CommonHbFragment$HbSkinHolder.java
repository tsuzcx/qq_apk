package com.tencent.mobileqq.activity.qwallet.fragment;

import Wallet.SkinInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.FrameAnimHelper;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;

public class CommonHbFragment$HbSkinHolder
  implements QwAdapter.IViewHolder
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AnimationView jdField_a_of_type_ComTencentMobileqqWidgetAnimationView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public CommonHbFragment$HbSkinHolder(CommonHbFragment paramCommonHbFragment) {}
  
  public void a(int paramInt, View paramView, HbSkinInfo paramHbSkinInfo)
  {
    Object localObject1 = null;
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CommonHbFragment", 2, "setItemView info = " + paramHbSkinInfo);
    }
    if (HbSkinInfo.c == paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
      CommonHbFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentCommonHbFragment, paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title);
    }
    FrameAnimHelper.a(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, false);
    label108:
    Object localObject2;
    if (1 == paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isHideTitle)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      paramView = this.jdField_a_of_type_AndroidViewView;
      if (1 != paramHbSkinInfo.b) {
        break label328;
      }
      paramInt = 8;
      paramView.setVisibility(paramInt);
      paramView = this.jdField_b_of_type_AndroidViewView;
      if (1 != paramHbSkinInfo.b) {
        break label333;
      }
      paramInt = i;
      label129:
      paramView.setVisibility(paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramHbSkinInfo.jdField_a_of_type_JavaLangString);
      localObject2 = this.jdField_c_of_type_AndroidViewView;
      if (HbSkinInfo.c != paramHbSkinInfo.jdField_a_of_type_WalletSkinInfo.skin_id) {
        break label339;
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841131);
      label174:
      ((View)localObject2).setBackgroundDrawable(paramView);
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon != null) {
        break label344;
      }
      paramView = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130843924);
      label206:
      ((ImageView)localObject2).setBackgroundDrawable(paramView);
      if (-1 != paramHbSkinInfo.b) {
        break label362;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841067);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841127));
    }
    for (;;)
    {
      localObject2 = this.jdField_b_of_type_AndroidWidgetImageView;
      paramView = localObject1;
      if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner != null) {
        paramView = paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner;
      }
      ((ImageView)localObject2).setImageBitmap(paramView);
      return;
      localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
      if (TextUtils.isEmpty(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)) {}
      for (paramView = paramView.getContext().getString(2131431248);; paramView = paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)
      {
        ((TextView)localObject2).setText(paramView);
        break;
      }
      label328:
      paramInt = 0;
      break label108;
      label333:
      paramInt = 8;
      break label129;
      label339:
      paramView = null;
      break label174;
      label344:
      paramView = new BitmapDrawable(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon);
      break label206;
      label362:
      if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.background != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.background));
      }
      if (paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo != null) {
        try
        {
          new FrameAnimHelper(this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView, 0, false, null).a(paramHbSkinInfo.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo);
        }
        catch (OutOfMemoryError paramView) {}
      }
    }
  }
  
  public QwAdapter.IViewHolder clone()
  {
    return (QwAdapter.IViewHolder)super.clone();
  }
  
  public View initView(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramView.getContext().getResources();
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131367888);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367887);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367895);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367893));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367891));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367889));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_START);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367894));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367892));
    this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationView = ((AnimationView)paramView.findViewById(2131367890));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment.HbSkinHolder
 * JD-Core Version:    0.7.0.1
 */