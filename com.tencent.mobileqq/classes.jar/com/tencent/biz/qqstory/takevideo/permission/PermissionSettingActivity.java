package com.tencent.biz.qqstory.takevideo.permission;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import anyw;
import anzj;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import wjb;
import yuk;
import yup;
import zhs;
import zhu;
import zhv;
import zhx;
import zhy;
import zia;
import zic;
import zid;
import zps;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private zhy jdField_a_of_type_Zhy;
  
  private zhv a(Groups paramGroups, List<Entity> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new zhu(localFriends));
        }
      }
    }
    return new zhv(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      yuk.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((wjb)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    yuk.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
    ((List)localObject4).add(this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject4).add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    localObject1 = new ArrayList();
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject5 = (anyw)this.app.getManager(51);
    Object localObject6 = ((anyw)localObject5).e();
    if (localObject6 != null)
    {
      yuk.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((anyw)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((zhv)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((zhv)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    yuk.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new zhx(this, "", zps.a(this, 20.0F));
    ((zhx)localObject4).a(false, true);
    localObject5 = new zid(this, getString(2131698456), 10004);
    ((zid)localObject5).c(true);
    localObject6 = new zid(this, getString(2131698452), 10000);
    ((zid)localObject6).c(true);
    Object localObject7 = new zid(this, getString(2131698453), 10001);
    ((zid)localObject7).c(false);
    Object localObject8 = new zhx(this, "", zps.a(this, 20.0F));
    ((zhx)localObject8).a(true, true);
    localObject3 = new zhs(this, getString(2131698455), 10002, (List)localObject3, this.app);
    localObject2 = new zhs(this, getString(2131698454), 10003, (List)localObject2, this.app);
    switch (paramInt)
    {
    }
    for (;;)
    {
      ((List)localObject1).add(localObject4);
      ((List)localObject1).add(localObject5);
      ((List)localObject1).add(localObject6);
      ((List)localObject1).add(localObject7);
      ((List)localObject1).add(localObject8);
      ((List)localObject1).add(localObject3);
      ((List)localObject1).add(localObject2);
      paramList = this.jdField_a_of_type_AndroidWidgetListView;
      localObject1 = new zhy((List)localObject1);
      this.jdField_a_of_type_Zhy = ((zhy)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Zhy);
      return;
      ((zid)localObject5).b(true);
      continue;
      ((zid)localObject6).b(true);
      continue;
      ((zid)localObject7).b(true);
      continue;
      ((zhs)localObject3).b(true);
      ((zhs)localObject3).a(paramList);
      continue;
      ((zhs)localObject2).b(true);
      ((zhs)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull zia paramzia)
  {
    int i = paramzia.b();
    Intent localIntent = new Intent();
    yuk.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
    localIntent.putExtra("PERMISSION_TYPE_KEY", i);
    localIntent.putExtra("PERMISSION_CURRENT_UIN_KEY", this.jdField_a_of_type_JavaLangString);
    switch (i)
    {
    }
    for (;;)
    {
      setResult(1, localIntent);
      return;
      ArrayList localArrayList = new ArrayList();
      paramzia = ((zhs)paramzia).a();
      if (paramzia.isEmpty())
      {
        yuk.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this, anzj.a(2131706808), 0).a();
        return;
      }
      paramzia = paramzia.iterator();
      while (paramzia.hasNext()) {
        localArrayList.add(((zhu)paramzia.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      yuk.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean onBackEvent()
  {
    yup.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
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
    setContentView(2131561823);
    super.setTitle(anzj.a(2131706803));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(anzj.a(2131706814));
    this.rightViewText.setContentDescription(anzj.a(2131706810));
    this.rightViewText.setOnClickListener(new zic(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131372403));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131167050));
      yup.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */