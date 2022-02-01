package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSVerticalItemBottomFlexibleController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private TextView g;
  private WSVerticalPageFragment h;
  private stSimpleMetaFeed i;
  
  public WSVerticalItemBottomFlexibleController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.h = paramWSVerticalVideoHolder.d;
    }
  }
  
  protected void a()
  {
    if ((c() != null) && ((((WSVerticalItemData)c()).b() instanceof stSimpleMetaFeed))) {
      this.i = ((WSVerticalItemData)c()).b();
    }
  }
  
  protected void b()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b().poster;
      if ((localObject != null) && (!TextUtils.isEmpty(((stSimpleMetaPerson)localObject).nick)))
      {
        this.g.setVisibility(0);
        this.g.setText(String.format("@%s", new Object[] { ((stSimpleMetaPerson)localObject).nick }));
        return;
      }
      this.g.setVisibility(8);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626080;
  }
  
  protected void j()
  {
    this.g = ((TextView)c(2131449403));
    this.g.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (paramView.getId() == 2131449403) {
      ((WSVerticalPageContract.Presenter)this.h.aO_()).a("nickname", this.h, this.i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomFlexibleController
 * JD-Core Version:    0.7.0.1
 */