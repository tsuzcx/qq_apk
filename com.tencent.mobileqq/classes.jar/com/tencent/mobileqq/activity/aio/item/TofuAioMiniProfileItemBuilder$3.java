package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class TofuAioMiniProfileItemBuilder$3
  implements AdapterView.OnItemClickListener
{
  TofuAioMiniProfileItemBuilder$3(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder, List paramList) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAioMiniProfileItemBuilder.a, TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", paramInt);
    localBundle.putStringArrayList("seqNum", new ArrayList(this.jdField_a_of_type_JavaUtilList));
    localBundle.putBoolean("from_photo_wall", false);
    localBundle.putBoolean("SHOW_MENU", true);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", true);
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAioMiniProfileItemBuilder.a.startActivity(localIntent);
    ReportController.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", TofuAioMiniProfileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTofuAioMiniProfileItemBuilder), "精选照片");
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */