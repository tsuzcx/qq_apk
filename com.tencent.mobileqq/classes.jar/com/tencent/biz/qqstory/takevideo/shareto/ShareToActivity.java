package com.tencent.biz.qqstory.takevideo.shareto;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShareToActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, ShareToGroupAdapter.OnSelectStateChangeListener, AdapterView.OnItemClickListener
{
  protected ShareToGroupAdapter a;
  protected XListView a;
  
  private ArrayList a()
  {
    QQAppInterface localQQAppInterface = PlayModeUtils.a();
    Object localObject2 = (TroopManager)localQQAppInterface.getManager(51);
    Object localObject1 = ((TroopManager)localObject2).a();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject1).size());
    Object localObject4 = localQQAppInterface.a().a().a(false);
    Object localObject3 = new ArrayList();
    localObject4 = ((List)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      RecentUser localRecentUser = (RecentUser)((Iterator)localObject4).next();
      if (localRecentUser.type == 1) {
        ((ArrayList)localObject3).add(localRecentUser);
      }
    }
    Collections.sort((List)localObject3, new ShareToActivity.CommonlyUsedTroopCompator(this));
    localObject3 = ((ArrayList)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((TroopManager)localObject2).b(((RecentUser)((Iterator)localObject3).next()).uin);
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
        int i = localQQAppInterface.b(((TroopInfo)localObject4).troopuin);
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
  
  private void b(ArrayList paramArrayList)
  {
    ArrayList localArrayList = paramArrayList;
    if (paramArrayList == null) {
      localArrayList = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.a();
    }
    int i = localArrayList.size();
    if (i > 0)
    {
      this.rightViewText.setText("完成(" + i + ")");
      return;
    }
    this.rightViewText.setText("完成");
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong <= -1L) {}
    do
    {
      return;
      paramInt = (int)paramLong;
      paramAdapterView = (ShareToGroupAdapter.TroopInfoSelector)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.getItem(paramInt);
    } while (paramAdapterView == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.a(paramAdapterView);
    StoryReportor.a("story_grp", "clk_share", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void a(ArrayList paramArrayList)
  {
    b(paramArrayList);
  }
  
  public boolean a(ArrayList paramArrayList, ShareToGroupAdapter.TroopInfoSelector paramTroopInfoSelector)
  {
    if ((!paramTroopInfoSelector.a) && (paramArrayList.size() >= 10))
    {
      QQToast.a(PlayModeUtils.a(), 0, "最多只能选择10个群", 0).a();
      return false;
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    StoryReportor.a("story_grp", "share_return", 0, 0, new String[] { "", "", "", "" });
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    StoryReportor.a("story_grp", "share_suc", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.a().size()), "", "", "" });
    paramView = new Intent();
    paramView.putStringArrayListExtra("share_to_group_key", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.a());
    setResult(1, paramView);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970831);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371969));
    paramBundle = getLayoutInflater().inflate(2130970832, null);
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      paramBundle.setBackgroundColor(-16444373);
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundColor(-16444373);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(paramBundle);
    paramBundle = getIntent().getStringArrayListExtra("share_to_group_key");
    ArrayList localArrayList = a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter = new ShareToGroupAdapter(getBaseContext(), localArrayList, paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter.a(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    super.setTitle("同步到群");
    super.a("完成", this);
    b(null);
    if ((localArrayList == null) || (localArrayList.isEmpty())) {}
    for (paramBundle = "2";; paramBundle = "1")
    {
      StoryReportor.a("story_grp", "exp_share", 0, 0, new String[] { paramBundle, "", "", "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity
 * JD-Core Version:    0.7.0.1
 */