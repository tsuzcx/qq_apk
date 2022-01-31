package com.tencent.biz.qqstory.takevideo.permission;

import ajxn;
import ajyc;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import aukm;
import bcpw;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import ssw;
import veg;
import vel;
import vro;
import vrq;
import vrr;
import vrt;
import vru;
import vrw;
import vry;
import vrz;
import vzo;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private vru jdField_a_of_type_Vru;
  
  private vrr a(Groups paramGroups, List<aukm> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new vrq(localFriends));
        }
      }
    }
    return new vrr(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      veg.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((ssw)this.app.getManager(181)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    veg.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (ajxn)this.app.getManager(51);
    Object localObject6 = ((ajxn)localObject5).e();
    if (localObject6 != null)
    {
      veg.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (aukm)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((ajxn)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((vrr)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((vrr)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    veg.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new vrt(this, "", vzo.a(this, 20.0F));
    ((vrt)localObject4).a(false, true);
    localObject5 = new vrz(this, getString(2131699530), 10004);
    ((vrz)localObject5).c(true);
    localObject6 = new vrz(this, getString(2131699522), 10000);
    ((vrz)localObject6).c(true);
    Object localObject7 = new vrz(this, getString(2131699526), 10001);
    ((vrz)localObject7).c(false);
    Object localObject8 = new vrt(this, "", vzo.a(this, 20.0F));
    ((vrt)localObject8).a(true, true);
    localObject3 = new vro(this, getString(2131699529), 10002, (List)localObject3, this.app);
    localObject2 = new vro(this, getString(2131699528), 10003, (List)localObject2, this.app);
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
      localObject1 = new vru((List)localObject1);
      this.jdField_a_of_type_Vru = ((vru)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Vru);
      return;
      ((vrz)localObject5).b(true);
      continue;
      ((vrz)localObject6).b(true);
      continue;
      ((vrz)localObject7).b(true);
      continue;
      ((vro)localObject3).b(true);
      ((vro)localObject3).a(paramList);
      continue;
      ((vro)localObject2).b(true);
      ((vro)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull vrw paramvrw)
  {
    int i = paramvrw.b();
    Intent localIntent = new Intent();
    veg.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramvrw = ((vro)paramvrw).a();
      if (paramvrw.isEmpty())
      {
        veg.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        bcpw.a(this, ajyc.a(2131707927), 0).a();
        return;
      }
      paramvrw = paramvrw.iterator();
      while (paramvrw.hasNext()) {
        localArrayList.add(((vrq)paramvrw.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      veg.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  public boolean onBackEvent()
  {
    vel.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131561340);
    super.setTitle(ajyc.a(2131707922));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(ajyc.a(2131707933));
    this.rightViewText.setContentDescription(ajyc.a(2131707929));
    this.rightViewText.setOnClickListener(new vry(this));
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
      vel.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */