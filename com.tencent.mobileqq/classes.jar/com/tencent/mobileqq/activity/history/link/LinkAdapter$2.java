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
    if (!LinkAdapter.a(this.c))
    {
      Intent localIntent = new Intent(LinkAdapter.b(this.c), QQBrowserActivity.class);
      localIntent.putExtra("url", this.a.url);
      LinkAdapter.b(this.c).startActivity(localIntent);
    }
    else
    {
      boolean bool = LinkAdapter.ViewHolder.e(this.b).isChecked();
      if (bool) {
        LinkAdapter.c(this.c).remove(this.a);
      } else {
        LinkAdapter.c(this.c).add(this.a);
      }
      LinkAdapter.ViewHolder.e(this.b).setChecked(bool ^ true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.LinkAdapter.2
 * JD-Core Version:    0.7.0.1
 */