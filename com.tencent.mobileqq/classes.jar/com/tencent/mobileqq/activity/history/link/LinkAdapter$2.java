package com.tencent.mobileqq.activity.history.link;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class LinkAdapter$2
  implements View.OnClickListener
{
  LinkAdapter$2(LinkAdapter paramLinkAdapter, TroopLinkElement paramTroopLinkElement, LinkAdapter.ViewHolder paramViewHolder) {}
  
  public void onClick(View paramView)
  {
    if (!LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter))
    {
      Intent localIntent = new Intent(LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).startActivity(localIntent);
    }
    else
    {
      boolean bool = LinkAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter$ViewHolder).isChecked();
      if (bool) {
        LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      } else {
        LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      }
      LinkAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter$ViewHolder).setChecked(bool ^ true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter.2
 * JD-Core Version:    0.7.0.1
 */