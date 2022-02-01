package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader;

public class DataProviderTest2
{
  public SimpleDataProvider a;
  private IDataProvider.Data b;
  private IDataProvider.GroupId c;
  private PlayerDataPreLoader d;
  private IDataProvider.ICallBack e = new DataProviderTest2.1(this);
  private IDataProvider.ICallBack f = new DataProviderTest2.2(this);
  
  public void onClickTestDown(View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      paramView.a(this.f);
      this.a.b(this.e);
      this.a.a(this.c, 2, 1, null);
    }
  }
  
  public void onClickTestUp(View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      paramView.b(this.f);
      this.a.a(this.e);
      this.a.a(this.c, 0, 1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.DataProviderTest2
 * JD-Core Version:    0.7.0.1
 */