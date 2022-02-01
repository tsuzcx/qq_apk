package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;

public class WebFastProteusAdInnerCreator
  extends WebFastBaseProteusAdCreator
{
  public int a(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof ProteusInnerData)) {
      return FastWeqAdUtils.a((ProteusInnerData)paramBaseData);
    }
    return 20;
  }
  
  protected BaseItemViewHolder a(View paramView, BaseData paramBaseData)
  {
    return new WebFastProteusAdInnerCreator.ProteusItemHolder(this, paramView, paramBaseData, this.a);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject;
    if (this.a != null) {
      localObject = (Context)this.a.get();
    } else {
      localObject = null;
    }
    if ((localObject instanceof Activity))
    {
      if (((Activity)localObject).getWindow().getAttributes().softInputMode != 4) {
        return;
      }
      localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
      if (localObject != null) {
        ((InputMethodManager)localObject).hideSoftInputFromWindow(paramAbsListView.getWindowToken(), 2);
      }
    }
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData != null) && (paramBaseData.u == 22);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator
 * JD-Core Version:    0.7.0.1
 */