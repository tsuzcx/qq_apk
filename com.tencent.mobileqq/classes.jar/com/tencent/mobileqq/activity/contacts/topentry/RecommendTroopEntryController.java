package com.tencent.mobileqq.activity.contacts.topentry;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.List;

public class RecommendTroopEntryController
  extends CTEntryController
{
  public static boolean i = false;
  private RecommendTroopAdapter j;
  private RecommendTroopAdapter.IRecommendTroopAdapterCallback k = new RecommendTroopEntryController.1(this);
  private View.OnClickListener l = new RecommendTroopEntryController.2(this);
  
  public RecommendTroopEntryController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void g()
  {
    if (!bV_())
    {
      this.c.setVisibility(8);
      return;
    }
    Object localObject = (MayknowRecommendManager)this.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (TextUtils.isEmpty(((MayknowRecommendManager)localObject).k))
    {
      this.d.setOnClickListener(null);
      this.d.setClickable(false);
      this.f.setVisibility(8);
    }
    else
    {
      this.d.setOnClickListener(this.l);
      this.d.setClickable(true);
      this.f.setVisibility(0);
    }
    RecommendTroopAdapter localRecommendTroopAdapter = this.j;
    int m;
    if (localRecommendTroopAdapter == null) {
      m = 0;
    } else {
      m = localRecommendTroopAdapter.getCount();
    }
    localObject = ((MayknowRecommendManager)localObject).j(m);
    if (localObject == null)
    {
      this.c.setVisibility(8);
      return;
    }
    if (!((List)localObject).isEmpty())
    {
      this.c.setVisibility(0);
      localRecommendTroopAdapter = this.j;
      if (localRecommendTroopAdapter == null)
      {
        this.j = new RecommendTroopAdapter(b(), this.b, this.g, 4, true, this.k);
        this.j.a((List)localObject);
        this.g.setAdapter(this.j);
      }
      else
      {
        localRecommendTroopAdapter.a((List)localObject);
      }
      if (((List)localObject).size() == 1) {
        h();
      }
    }
    else
    {
      localObject = this.j;
      if (localObject != null) {
        ((RecommendTroopAdapter)localObject).notifyDataSetChanged();
      }
    }
  }
  
  private void h()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.height = AIOUtils.b(88.0F, this.c.getResources());
    this.c.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.d.enableAlphaClick(false);
    this.e.setText(HardCodeUtil.a(2131910733));
    g();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.b != paramQQAppInterface)
    {
      this.b = paramQQAppInterface;
      RecommendTroopAdapter localRecommendTroopAdapter = this.j;
      if (localRecommendTroopAdapter != null) {
        localRecommendTroopAdapter.a(paramQQAppInterface);
      }
    }
    g();
  }
  
  public void a(String paramString)
  {
    RecommendTroopAdapter localRecommendTroopAdapter = this.j;
    if ((localRecommendTroopAdapter != null) && (localRecommendTroopAdapter.a(paramString)))
    {
      ((MayknowRecommendManager)this.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).s();
      g();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    i = true;
    g();
  }
  
  public void c(boolean paramBoolean)
  {
    RecommendTroopAdapter localRecommendTroopAdapter = this.j;
    if (localRecommendTroopAdapter != null) {
      localRecommendTroopAdapter.a(paramBoolean);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.runOnUiThread(new RecommendTroopEntryController.3(this));
    }
  }
  
  public void e()
  {
    super.e();
    RecommendTroopAdapter localRecommendTroopAdapter = this.j;
    if (localRecommendTroopAdapter != null) {
      localRecommendTroopAdapter.a();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.g != null) {
      this.g.setAdapter(null);
    }
    RecommendTroopAdapter localRecommendTroopAdapter = this.j;
    if (localRecommendTroopAdapter != null) {
      localRecommendTroopAdapter.a();
    }
    this.j = null;
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController
 * JD-Core Version:    0.7.0.1
 */