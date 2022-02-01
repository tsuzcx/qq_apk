package com.tencent.mobileqq.activity.contacts.mayknow;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.HeadViewScrollListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendFriendFragment
  extends ContactsBaseFragment
  implements HeadViewScrollListener
{
  View a;
  XListView b;
  View c;
  RecommendsAdapter d;
  protected int e = -1;
  protected int f = -1;
  FriendListObserver g = new RecommendFriendFragment.1(this);
  protected Runnable h = new RecommendFriendFragment.2(this);
  protected Runnable i = new RecommendFriendFragment.3(this);
  protected Runnable j = new RecommendFriendFragment.4(this);
  
  private boolean j()
  {
    RecommendsAdapter localRecommendsAdapter = this.d;
    if (localRecommendsAdapter != null) {
      return localRecommendsAdapter.isEmpty();
    }
    return false;
  }
  
  private void k()
  {
    if (this.d != null)
    {
      Object localObject = (MayknowRecommendManager)this.s.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject != null)
      {
        ((MayknowRecommendManager)localObject).e(3);
        localObject = ((MayknowRecommendManager)localObject).f();
        this.d.a((List)localObject);
        this.c.removeCallbacks(this.j);
        this.c.postDelayed(this.j, 100L);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadAndUpdateData size:");
        ((StringBuilder)localObject).append(this.d.getCount());
        ((StringBuilder)localObject).append("  uin:");
        ((StringBuilder)localObject).append(this.s.getCurrentAccountUin());
        QLog.d("RecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramLayoutInflater = new StringBuilder();
      paramLayoutInflater.append("getView mListView=");
      paramLayoutInflater.append(this.b);
      QLog.d("RecommendFriendFragment", 2, paramLayoutInflater.toString());
    }
    paramLayoutInflater = this.a;
    if (paramLayoutInflater == null)
    {
      this.a = LayoutInflater.from(this.w).inflate(2131624562, null, false);
      this.b = ((XListView)this.a.findViewById(2131444476));
      this.b.setSelector(new ColorDrawable(0));
      this.b.setNeedCheckSpringback(true);
      this.b.setCacheColorHint(0);
      this.b.setDivider(null);
      this.b.setOverScrollMode(0);
      this.b.mForContacts = true;
      this.c = this.a.findViewById(2131432490);
      paramLayoutInflater = (ImageView)this.a.findViewById(2131432505);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestHeight = AIOUtils.b(200.0F, BaseApplication.getContext().getResources());
      paramBundle.mRequestWidth = AIOUtils.b(145.0F, BaseApplication.getContext().getResources());
      paramBundle.mLoadingDrawable = null;
      paramBundle.mFailedDrawable = null;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/nearby/recommend/recommend_empty.png", paramBundle));
    }
    else
    {
      paramLayoutInflater = paramLayoutInflater.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.a);
      }
    }
    return this.a;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnDestroy");
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((RecommendsAdapter)localObject).a();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((View)localObject).removeCallbacks(this.i);
      this.c.removeCallbacks(this.j);
    }
    localObject = this.b;
    if (localObject != null) {
      ((XListView)localObject).removeCallbacks(this.h);
    }
    e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHeadViewScrollChanged currentY:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("  maxY:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("RecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    this.e = paramInt1;
    this.f = paramInt2;
    Object localObject = this.c;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0) && (this.c.getMeasuredHeight() > 0) && (this.a.getMeasuredHeight() > 0))
    {
      this.c.removeCallbacks(this.i);
      this.c.post(this.i);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.b == null) {
      return;
    }
    d();
    if (this.d == null)
    {
      this.d = new RecommendsAdapter(this.w, this.s, this.b, 1, true);
      this.b.setAdapter(this.d);
      k();
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((RecommendsAdapter)localObject).b();
    }
    a(this.e, this.f);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnPause:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RecommendFriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean) {
      e();
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((RecommendsAdapter)localObject).d();
    }
  }
  
  public void bU_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "refresh");
    }
    k();
    if (this.q != null) {
      this.q.a(i(), true, null);
    }
  }
  
  public void c()
  {
    k();
    RecommendsAdapter localRecommendsAdapter = this.d;
    if (localRecommendsAdapter != null) {
      localRecommendsAdapter.a(this.s);
    }
  }
  
  protected void d()
  {
    if (this.s != null) {
      this.s.addObserver(this.g);
    }
  }
  
  protected void e()
  {
    if (this.s != null) {
      this.s.removeObserver(this.g);
    }
  }
  
  public View getScrollableView()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */