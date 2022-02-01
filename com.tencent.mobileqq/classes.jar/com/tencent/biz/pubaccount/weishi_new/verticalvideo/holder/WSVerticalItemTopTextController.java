package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSDramaEpisodeInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalItemTopTextController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private WSVerticalPageFragment g;
  private TextView h;
  private TextView i;
  
  public WSVerticalItemTopTextController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.g = paramWSVerticalVideoHolder.d;
    }
  }
  
  protected void a() {}
  
  @SuppressLint({"StringFormatMatches"})
  @UiThread
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateUI hashcode******************************");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(",position:");
    ((StringBuilder)localObject).append(h());
    WSLog.a("WSVerticalItemTopTextController", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)c();
    if (localObject != null)
    {
      localObject = ((WSVerticalItemData)localObject).g();
      if (localObject == null) {
        return;
      }
      this.h.setText(((WSDramaEpisodeInfo)localObject).b());
      this.i.setText(this.a.getString(1929838604, new Object[] { Integer.valueOf(((WSDramaEpisodeInfo)localObject).c()) }));
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626091;
  }
  
  protected void j()
  {
    WSVerticalUtils.a(this.g.getBaseActivity(), (ViewGroup)this.b);
    ViewGroup.LayoutParams localLayoutParams = this.b.getLayoutParams();
    localLayoutParams.width = -1;
    this.b.setLayoutParams(localLayoutParams);
    this.h = ((TextView)c(2131449405));
    this.i = ((TextView)c(2131449404));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemTopTextController
 * JD-Core Version:    0.7.0.1
 */