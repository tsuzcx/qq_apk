package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DataObserver;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.HeaderDataModel;
import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.List;

class ReadInJoyCGIDynamicChannelFragment$1
  extends DataObserver
{
  ReadInJoyCGIDynamicChannelFragment$1(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment) {}
  
  public void a(int paramInt, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.a(this.a)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.a).a(paramList);
      ReadInJoyCGIDynamicChannelFragment.a(this.a).a(true, true);
      return;
    }
    ReadInJoyCGIDynamicChannelFragment.b(this.a).b();
  }
  
  public void a(int paramInt1, boolean paramBoolean, List<HeaderDataModel> paramList, int paramInt2)
  {
    int i = 0;
    if (paramInt1 != ReadInJoyCGIDynamicChannelFragment.d(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyCGIDynamicChannelFragment.a(this.a, paramInt1, paramList);
    }
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onHeaderRefreshed, channelID = ", Integer.valueOf(paramInt1), ", success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i), ", insertIndex = ", Integer.valueOf(paramInt2) });
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.b(this.a)) {
      return;
    }
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      if ((!paramBoolean1) || (i <= 0)) {
        break label175;
      }
    }
    label175:
    for (String str = String.format(this.a.getResources().getString(2131718094), new Object[] { Integer.valueOf(i) });; str = this.a.getResources().getString(2131718093))
    {
      ReadInJoyCGIDynamicChannelFragment.c(this.a).a(paramBoolean1, str);
      if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0)) {
        ReadInJoyCGIDynamicChannelFragment.a(this.a).a(paramList);
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onDataRefreshed, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", refreshSize = ", Integer.valueOf(i) });
      ReadInJoyCGIDynamicChannelFragment.d(this.a).a(true, true);
      return;
      i = 0;
      break;
    }
  }
  
  public void b(int paramInt, boolean paramBoolean1, boolean paramBoolean2, List<DynamicChannelDataModel> paramList)
  {
    int i = 0;
    if (paramInt != ReadInJoyCGIDynamicChannelFragment.c(this.a)) {
      return;
    }
    if ((paramBoolean1) && (paramList != null) && (paramList.size() > 0))
    {
      ReadInJoyCGIDynamicChannelFragment.a(this.a).b(paramList);
      ReadInJoyCGIDynamicChannelFragment.e(this.a).a(true, paramBoolean2);
    }
    for (;;)
    {
      if (paramList != null) {
        i = paramList.size();
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "onLoadMoreData, channelID = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(paramBoolean1), ", size = ", Integer.valueOf(i), ", hasMore = ", Boolean.valueOf(paramBoolean2) });
      return;
      ReadInJoyCGIDynamicChannelFragment.f(this.a).a(false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.1
 * JD-Core Version:    0.7.0.1
 */