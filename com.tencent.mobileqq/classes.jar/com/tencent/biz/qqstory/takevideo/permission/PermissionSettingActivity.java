package com.tencent.biz.qqstory.takevideo.permission;

import ajxl;
import ajya;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import auko;
import bcql;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import sst;
import ved;
import vei;
import vrl;
import vrn;
import vro;
import vrq;
import vrr;
import vrt;
import vrv;
import vrw;
import vzl;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private vrr jdField_a_of_type_Vrr;
  
  private vro a(Groups paramGroups, List<auko> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new vrn(localFriends));
        }
      }
    }
    return new vro(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      ved.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((sst)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    ved.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (ajxl)this.app.getManager(51);
    Object localObject6 = ((ajxl)localObject5).e();
    if (localObject6 != null)
    {
      ved.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (auko)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((ajxl)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((vro)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((vro)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    ved.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new vrq(this, "", vzl.a(this, 20.0F));
    ((vrq)localObject4).a(false, true);
    localObject5 = new vrw(this, getString(2131699541), 10004);
    ((vrw)localObject5).c(true);
    localObject6 = new vrw(this, getString(2131699533), 10000);
    ((vrw)localObject6).c(true);
    Object localObject7 = new vrw(this, getString(2131699537), 10001);
    ((vrw)localObject7).c(false);
    Object localObject8 = new vrq(this, "", vzl.a(this, 20.0F));
    ((vrq)localObject8).a(true, true);
    localObject3 = new vrl(this, getString(2131699540), 10002, (List)localObject3, this.app);
    localObject2 = new vrl(this, getString(2131699539), 10003, (List)localObject2, this.app);
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
      localObject1 = new vrr((List)localObject1);
      this.jdField_a_of_type_Vrr = ((vrr)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Vrr);
      return;
      ((vrw)localObject5).b(true);
      continue;
      ((vrw)localObject6).b(true);
      continue;
      ((vrw)localObject7).b(true);
      continue;
      ((vrl)localObject3).b(true);
      ((vrl)localObject3).a(paramList);
      continue;
      ((vrl)localObject2).b(true);
      ((vrl)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull vrt paramvrt)
  {
    int i = paramvrt.b();
    Intent localIntent = new Intent();
    ved.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramvrt = ((vrl)paramvrt).a();
      if (paramvrt.isEmpty())
      {
        ved.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        bcql.a(this, ajya.a(2131707938), 0).a();
        return;
      }
      paramvrt = paramvrt.iterator();
      while (paramvrt.hasNext()) {
        localArrayList.add(((vrn)paramvrt.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      ved.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    vei.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561339);
    super.setTitle(ajya.a(2131707933));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(ajya.a(2131707944));
    this.rightViewText.setContentDescription(ajya.a(2131707940));
    this.rightViewText.setOnClickListener(new vrv(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131371379));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131166912));
      vei.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */