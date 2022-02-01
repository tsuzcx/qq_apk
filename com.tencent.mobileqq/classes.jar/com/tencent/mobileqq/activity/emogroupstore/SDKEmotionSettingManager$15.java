package com.tencent.mobileqq.activity.emogroupstore;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class SDKEmotionSettingManager$15
  implements View.OnClickListener
{
  SDKEmotionSettingManager$15(SDKEmotionSettingManager paramSDKEmotionSettingManager, int paramInt, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (!SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager))
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label48;
      }
      SDKSetEmotionPreviewFragment.a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0), SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager), null);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      Intent localIntent = new Intent();
      localIntent.putStringArrayListExtra("path_list", this.jdField_a_of_type_JavaUtilArrayList);
      PublicFragmentActivity.a(SDKEmotionSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityEmogroupstoreSDKEmotionSettingManager), localIntent, SDKSetEmotionPreviewFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.emogroupstore.SDKEmotionSettingManager.15
 * JD-Core Version:    0.7.0.1
 */