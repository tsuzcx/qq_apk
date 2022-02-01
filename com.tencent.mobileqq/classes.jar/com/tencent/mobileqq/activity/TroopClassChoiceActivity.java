package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.OnItemClickListener
{
  ArrayList<GroupCatalogBean> a;
  GroupCatalogBean b;
  String c;
  private XListView d;
  private TroopClassChoiceActivity.TroopClassChoiceAdapter e;
  private String f;
  
  private void b()
  {
    Object localObject = getIntent();
    this.f = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    GroupCatalogBean localGroupCatalogBean = GroupCatalogTool.a(this).d();
    if ((localGroupCatalogBean != null) && (this.f.equals(localGroupCatalogBean.c))) {
      this.b = localGroupCatalogBean;
    } else {
      this.b = GroupCatalogTool.a(this).a(this, this.f);
    }
    this.c = ((Intent)localObject).getStringExtra("id");
    if (TextUtils.isEmpty(this.c))
    {
      this.a = GroupCatalogTool.a(this).b();
    }
    else
    {
      this.a = GroupCatalogTool.a(this).a(this.c);
      localObject = this.a;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (GroupCatalogBean)this.a.get(0);
        if (((GroupCatalogBean)localObject).e != null) {
          setTitle(((GroupCatalogBean)localObject).e.b);
        }
      }
    }
    CacheManager.a(CommonDataAdapter.a().b());
    a();
  }
  
  private void c()
  {
    setContentBackgroundResource(2130838958);
    this.d = ((XListView)findViewById(2131447867));
    this.d.setOnItemClickListener(this);
    this.e = new TroopClassChoiceActivity.TroopClassChoiceAdapter(this);
    this.d.setAdapter(this.e);
  }
  
  public void a()
  {
    GroupCatalogTool.a(BaseApplicationImpl.getContext()).a(this.f, new TroopClassChoiceActivity.GetClassChoiceCallBack(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131629563);
    setTitle(2131917407);
    b();
    c();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (GroupCatalogBean)this.a.get(paramInt);
    if ((paramAdapterView.d != null) && (paramAdapterView.d.size() > 0) && (!paramAdapterView.c.equals("10015")) && (!paramAdapterView.c.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.c);
      paramView.putExtra("troopGroupClassExt", this.f);
      startActivityForResult(paramView, 11);
      return;
    }
    GroupCatalogTool.a(this).a(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.c);
    setResult(-1, paramView);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */