package com.tencent.biz.qqstory.takevideo.permission;

import ajjj;
import ajjy;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import atmo;
import bbmy;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import sga;
import urk;
import urp;
import ves;
import veu;
import vev;
import vex;
import vey;
import vfa;
import vfc;
import vfd;
import vms;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private vey jdField_a_of_type_Vey;
  
  private vev a(Groups paramGroups, List<atmo> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new veu(localFriends));
        }
      }
    }
    return new vev(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      urk.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((sga)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    urk.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (ajjj)this.app.getManager(51);
    Object localObject6 = ((ajjj)localObject5).e();
    if (localObject6 != null)
    {
      urk.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (atmo)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((ajjj)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((vev)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((vev)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    urk.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new vex(this, "", vms.a(this, 20.0F));
    ((vex)localObject4).a(false, true);
    localObject5 = new vfd(this, getString(2131633748), 10004);
    ((vfd)localObject5).c(true);
    localObject6 = new vfd(this, getString(2131633740), 10000);
    ((vfd)localObject6).c(true);
    Object localObject7 = new vfd(this, getString(2131633744), 10001);
    ((vfd)localObject7).c(false);
    Object localObject8 = new vex(this, "", vms.a(this, 20.0F));
    ((vex)localObject8).a(true, true);
    localObject3 = new ves(this, getString(2131633747), 10002, (List)localObject3, this.app);
    localObject2 = new ves(this, getString(2131633746), 10003, (List)localObject2, this.app);
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
      localObject1 = new vey((List)localObject1);
      this.jdField_a_of_type_Vey = ((vey)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Vey);
      return;
      ((vfd)localObject5).b(true);
      continue;
      ((vfd)localObject6).b(true);
      continue;
      ((vfd)localObject7).b(true);
      continue;
      ((ves)localObject3).b(true);
      ((ves)localObject3).a(paramList);
      continue;
      ((ves)localObject2).b(true);
      ((ves)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull vfa paramvfa)
  {
    int i = paramvfa.b();
    Intent localIntent = new Intent();
    urk.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramvfa = ((ves)paramvfa).a();
      if (paramvfa.isEmpty())
      {
        urk.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        bbmy.a(this, ajjy.a(2131642142), 0).a();
        return;
      }
      paramvfa = paramvfa.iterator();
      while (paramvfa.hasNext()) {
        localArrayList.add(((veu)paramvfa.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      urk.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    urp.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131495749);
    super.setTitle(ajjy.a(2131642137));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(ajjy.a(2131642148));
    this.rightViewText.setContentDescription(ajjy.a(2131642144));
    this.rightViewText.setOnClickListener(new vfc(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131305683));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131101317));
      urp.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */