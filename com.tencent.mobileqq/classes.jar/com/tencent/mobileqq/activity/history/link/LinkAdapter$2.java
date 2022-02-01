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
    Object localObject;
    if (!LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter))
    {
      localObject = new Intent(LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement.url);
      LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).startActivity((Intent)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = LinkAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter$ViewHolder).isChecked();
    if (bool)
    {
      LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).remove(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      label92:
      localObject = LinkAdapter.ViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter$ViewHolder);
      if (bool) {
        break label134;
      }
    }
    label134:
    for (bool = true;; bool = false)
    {
      ((CheckBox)localObject).setChecked(bool);
      break;
      LinkAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkLinkAdapter).add(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryLinkTroopLinkElement);
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter.2
 * JD-Core Version:    0.7.0.1
 */