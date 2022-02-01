package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class SearchFriendListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private XListView a;
  private SearchFriendListActivity.SearchFriendAdapter b;
  private ArrayList<SearchResultItem> c;
  private AvatarObserver d = new SearchFriendListActivity.1(this);
  
  void a(View paramView, int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      Object localObject4 = (SearchResultItem)this.c.get(paramInt);
      if (localObject4 == null) {
        return;
      }
      Object localObject1 = ((SearchResultItem)localObject4).c;
      Object localObject2 = String.valueOf(((SearchResultItem)localObject4).a);
      Object localObject3 = ((SearchResultItem)localObject4).d;
      int i = ((SearchResultItem)localObject4).b;
      localObject4 = (SearchFriendListActivity.ViewHolder)paramView.getTag();
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((SearchFriendListActivity.ViewHolder)localObject4).b.setText((CharSequence)localObject1);
      }
      else
      {
        TextView localTextView = ((SearchFriendListActivity.ViewHolder)localObject4).b;
        if (i == 1) {
          localObject1 = localObject2;
        } else {
          localObject1 = localObject3;
        }
        localTextView.setText((CharSequence)localObject1);
      }
      if (i == 1)
      {
        ((SearchFriendListActivity.ViewHolder)localObject4).a.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.app, (String)localObject2, (byte)3));
        localObject1 = ((SearchFriendListActivity.ViewHolder)localObject4).c;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("QQ号码: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((TextView)localObject1).setText(((StringBuilder)localObject3).toString());
      }
      else
      {
        ((SearchFriendListActivity.ViewHolder)localObject4).a.setImageDrawable(FaceDrawable.getMobileFaceDrawable(this.app, (String)localObject3, (byte)3));
        localObject1 = ((SearchFriendListActivity.ViewHolder)localObject4).c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131911096));
        ((StringBuilder)localObject2).append((String)localObject3);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      ((SearchFriendListActivity.ViewHolder)localObject4).d = paramInt;
      paramView.setContentDescription(((SearchFriendListActivity.ViewHolder)localObject4).b.getText());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629222);
    setContentBackgroundResource(2130838958);
    setTitle(HardCodeUtil.a(2131911095));
    this.a = ((XListView)findViewById(2131445423));
    this.a.setContentBackground(2130838958);
    addObserver(this.d);
    this.c = getIntent().getParcelableArrayListExtra("param_search_result_item_list");
    if (this.c == null) {
      this.c = new ArrayList();
    }
    this.b = new SearchFriendListActivity.SearchFriendAdapter(this, null);
    this.a.setAdapter(this.b);
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.d);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof SearchFriendListActivity.ViewHolder))
    {
      int i = ((SearchFriendListActivity.ViewHolder)paramView.getTag()).d;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (i >= 0)
      {
        localObject1 = localObject2;
        if (i < this.c.size()) {
          localObject1 = (SearchResultItem)this.c.get(i);
        }
      }
      if (localObject1 != null) {
        if (((SearchResultItem)localObject1).g == 0) {
          AddFriendActivity.startProfileCardActivity(this, (SearchResultItem)localObject1, this.app, false, 1);
        } else {
          CrmUtils.a(this, null, String.valueOf(((SearchResultItem)localObject1).a), false, -1, true, -1);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SearchFriendListActivity
 * JD-Core Version:    0.7.0.1
 */