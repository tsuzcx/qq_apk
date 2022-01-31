package com.tencent.biz.qqstory.takevideo.permission;

import aloz;
import alpo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import awbv;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import uhl;
import wsv;
import wta;
import xgd;
import xgf;
import xgg;
import xgi;
import xgj;
import xgl;
import xgn;
import xgo;
import xod;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private xgj jdField_a_of_type_Xgj;
  
  private xgg a(Groups paramGroups, List<awbv> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new xgf(localFriends));
        }
      }
    }
    return new xgg(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      wsv.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((uhl)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    wsv.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (aloz)this.app.getManager(51);
    Object localObject6 = ((aloz)localObject5).e();
    if (localObject6 != null)
    {
      wsv.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (awbv)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((aloz)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((xgg)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((xgg)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    wsv.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new xgi(this, "", xod.a(this, 20.0F));
    ((xgi)localObject4).a(false, true);
    localObject5 = new xgo(this, getString(2131699896), 10004);
    ((xgo)localObject5).c(true);
    localObject6 = new xgo(this, getString(2131699888), 10000);
    ((xgo)localObject6).c(true);
    Object localObject7 = new xgo(this, getString(2131699892), 10001);
    ((xgo)localObject7).c(false);
    Object localObject8 = new xgi(this, "", xod.a(this, 20.0F));
    ((xgi)localObject8).a(true, true);
    localObject3 = new xgd(this, getString(2131699895), 10002, (List)localObject3, this.app);
    localObject2 = new xgd(this, getString(2131699894), 10003, (List)localObject2, this.app);
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
      localObject1 = new xgj((List)localObject1);
      this.jdField_a_of_type_Xgj = ((xgj)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Xgj);
      return;
      ((xgo)localObject5).b(true);
      continue;
      ((xgo)localObject6).b(true);
      continue;
      ((xgo)localObject7).b(true);
      continue;
      ((xgd)localObject3).b(true);
      ((xgd)localObject3).a(paramList);
      continue;
      ((xgd)localObject2).b(true);
      ((xgd)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull xgl paramxgl)
  {
    int i = paramxgl.b();
    Intent localIntent = new Intent();
    wsv.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramxgl = ((xgd)paramxgl).a();
      if (paramxgl.isEmpty())
      {
        wsv.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this, alpo.a(2131708310), 0).a();
        return;
      }
      paramxgl = paramxgl.iterator();
      while (paramxgl.hasNext()) {
        localArrayList.add(((xgf)paramxgl.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      wsv.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    wta.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561529);
    super.setTitle(alpo.a(2131708305));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(alpo.a(2131708316));
    this.rightViewText.setContentDescription(alpo.a(2131708312));
    this.rightViewText.setOnClickListener(new xgn(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131371695));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131166959));
      wta.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */