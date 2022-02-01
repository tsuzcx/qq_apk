package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import UserGrowth.stCollection;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageCollectionTopAreaController
  extends AbsWsUIGroup<Object>
{
  private static final int g = (int)(WeishiUIUtil.c() - WeishiUIUtil.q * 1.5F);
  private TextView h;
  private TextView i;
  private final WSVerticalPageFragment j;
  private stCollection k;
  private View l;
  
  protected void a()
  {
    if ((c() != null) && ((c() instanceof stCollection))) {
      this.k = ((stCollection)c());
    }
  }
  
  protected void b()
  {
    Object localObject = this.h;
    if ((localObject != null) && (this.k != null))
    {
      ((TextView)localObject).setMaxWidth(g);
      localObject = e().getString(2131918098);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(this.k.name);
      localObject = localStringBuilder.toString();
      this.h.setText((CharSequence)localObject);
    }
  }
  
  public void d(int paramInt)
  {
    if ((this.i != null) && (this.k != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.k.feed_count);
      localObject = ((StringBuilder)localObject).toString();
      this.i.setText((CharSequence)localObject);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626052;
  }
  
  protected void j()
  {
    if (this.j == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)c(2131449422);
    WSVerticalUtils.a(this.j.getBaseActivity(), localRelativeLayout);
    this.l = c(2131449421);
    this.l.setOnClickListener(new WSVerticalPageCollectionTopAreaController.1(this));
    this.h = ((TextView)c(2131449414));
    this.i = ((TextView)c(2131448333));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController
 * JD-Core Version:    0.7.0.1
 */