package com.tencent.biz.qqstory.takevideo.shareto;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anvx;
import aoxz;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import wzk;
import ykv;
import yzd;
import yze;
import yzf;
import yzg;

public class ShareToActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, yzf
{
  protected XListView a;
  protected yze a;
  
  private ArrayList<TroopInfo> a()
  {
    QQAppInterface localQQAppInterface = wzk.a();
    Object localObject2 = (TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject1 = ((TroopManager)localObject2).b();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject1).size());
    Object localObject4 = localQQAppInterface.getProxyManager().a().getRecentList(false);
    Object localObject3 = new ArrayList();
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject4).next();
      if (localRecentUser.getType() == 1) {
        ((ArrayList)localObject3).add(localRecentUser);
      }
    }
    Collections.sort((List)localObject3, new yzd(this));
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((TroopManager)localObject2).c(((RecentUser)((Iterator)localObject3).next()).uin);
      if ((((TroopInfo)localObject4).troopuin != null) && (!((TroopInfo)localObject4).isQidianPrivateTroop())) {
        localArrayList.add(localObject4);
      }
    }
    localObject2 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (TroopInfo)((Iterator)localObject1).next();
      if ((localObject4 != null) && (!localArrayList.contains(localObject4)) && (!((TroopInfo)localObject4).isQidianPrivateTroop()))
      {
        int i = localQQAppInterface.getTroopMask(((TroopInfo)localObject4).troopuin);
        if (i == 3) {
          ((ArrayList)localObject2).add(localObject4);
        } else if (i == 2) {
          ((ArrayList)localObject3).add(localObject4);
        } else {
          localArrayList.add(localObject4);
        }
      }
    }
    localArrayList.addAll((Collection)localObject3);
    localArrayList.addAll((Collection)localObject2);
    return localArrayList;
  }
  
  private void b(ArrayList<String> paramArrayList)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = this.jdField_a_of_type_Yze.a();
    }
    int i = ((ArrayList)localObject).size();
    if (i > 0)
    {
      this.rightViewText.setText(anvx.a(2131713418) + i + ")");
      return;
    }
    this.rightViewText.setText(anvx.a(2131713419));
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    b(paramArrayList);
  }
  
  public boolean a(ArrayList<String> paramArrayList, yzg paramyzg)
  {
    if ((!paramyzg.a) && (paramArrayList.size() >= 10))
    {
      QQToast.a(wzk.a(), 0, "最多只能选择10个群", 0).a();
      return false;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean onBackEvent()
  {
    ykv.a("story_grp", "share_return", 0, 0, new String[] { "", "", "", "" });
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    ykv.a("story_grp", "share_suc", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Yze.a().size()), "", "", "" });
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("share_to_group_key", this.jdField_a_of_type_Yze.a());
    setResult(1, localIntent);
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
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
    setContentView(2131561771);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377545));
    paramBundle = getLayoutInflater().inflate(2131561772, null);
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      paramBundle.setBackgroundColor(-16444373);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundColor(-16444373);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("share_to_group_key");
    ArrayList localArrayList = a();
    this.jdField_a_of_type_Yze = new yze(getBaseContext(), localArrayList, paramBundle);
    this.jdField_a_of_type_Yze.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Yze);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    super.setTitle(anvx.a(2131713420));
    super.a(anvx.a(2131713417), this);
    b(null);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (paramBundle = "2";; paramBundle = "1")
    {
      ykv.a("story_grp", "exp_share", 0, 0, new String[] { paramBundle, "", "", "" });
      return;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong <= -1L) {}
    do
    {
      return;
      paramInt = (int)paramLong;
      paramAdapterView = (yzg)this.jdField_a_of_type_Yze.getItem(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_Yze.a(paramAdapterView);
    ykv.a("story_grp", "clk_share", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity
 * JD-Core Version:    0.7.0.1
 */