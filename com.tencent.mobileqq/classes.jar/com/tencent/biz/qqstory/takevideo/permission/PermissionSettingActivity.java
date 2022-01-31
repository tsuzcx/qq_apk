package com.tencent.biz.qqstory.takevideo.permission;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import ojx;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private PermissionListAdapter jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionListAdapter;
  private String jdField_a_of_type_JavaLangString;
  
  private ComplexPart.Group a(Groups paramGroups, List paramList1, @NonNull List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList1 != null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        Friends localFriends = (Friends)paramList1.next();
        if (!paramList2.contains(localFriends.uin)) {
          localArrayList.add(new ComplexPart.Friend(localFriends));
        }
      }
    }
    return new ComplexPart.Group(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List paramList)
  {
    if (this.app == null)
    {
      SLog.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((QQStoryManager)this.app.getManager(180)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.c();
    SLog.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (FriendsManager)this.app.getManager(50);
    Object localObject6 = ((FriendsManager)localObject5).d();
    if (localObject6 != null)
    {
      SLog.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((FriendsManager)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((ComplexPart.Group)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((ComplexPart.Group)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    SLog.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new EmptyPart(this, "", UIUtils.a(this, 20.0F));
    ((EmptyPart)localObject4).a(false, true);
    localObject5 = new SinglePart(this, getString(2131438696), 10004);
    ((SinglePart)localObject5).c(true);
    localObject6 = new SinglePart(this, getString(2131438697), 10000);
    ((SinglePart)localObject6).c(true);
    Object localObject7 = new SinglePart(this, getString(2131438698), 10001);
    ((SinglePart)localObject7).c(false);
    Object localObject8 = new EmptyPart(this, "", UIUtils.a(this, 20.0F));
    ((EmptyPart)localObject8).a(true, true);
    localObject3 = new ComplexPart(this, getString(2131438699), 10002, (List)localObject3, this.app);
    localObject2 = new ComplexPart(this, getString(2131438700), 10003, (List)localObject2, this.app);
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
      localObject1 = new PermissionListAdapter((List)localObject1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionListAdapter = ((PermissionListAdapter)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPermissionPermissionListAdapter);
      return;
      ((SinglePart)localObject5).b(true);
      continue;
      ((SinglePart)localObject6).b(true);
      continue;
      ((SinglePart)localObject7).b(true);
      continue;
      ((ComplexPart)localObject3).b(true);
      ((ComplexPart)localObject3).a(paramList);
      continue;
      ((ComplexPart)localObject2).b(true);
      ((ComplexPart)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull PermissionPart paramPermissionPart)
  {
    int i = paramPermissionPart.b();
    Intent localIntent = new Intent();
    SLog.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramPermissionPart = ((ComplexPart)paramPermissionPart).a();
      if (paramPermissionPart.isEmpty())
      {
        SLog.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this, "请选择分组", 0).a();
        return;
      }
      paramPermissionPart = paramPermissionPart.iterator();
      while (paramPermissionPart.hasNext()) {
        localArrayList.add(((ComplexPart.Friend)paramPermissionPart.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      SLog.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
  }
  
  protected boolean onBackEvent()
  {
    StoryReportor.a("pub_control", "clk_return", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130970764);
    super.setTitle("谁能看见");
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText("完成");
    this.rightViewText.setContentDescription("完成");
    this.rightViewText.setOnClickListener(new ojx(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131364380));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131494248));
      StoryReportor.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */