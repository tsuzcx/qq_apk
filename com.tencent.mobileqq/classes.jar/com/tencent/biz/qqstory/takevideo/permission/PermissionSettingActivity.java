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
import anvk;
import anvx;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import vzv;
import ykq;
import ykv;
import yxl;
import yxn;
import yxo;
import yxq;
import yxr;
import yxt;
import yxv;
import yxw;

public class PermissionSettingActivity
  extends QQStoryBaseActivity
{
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private yxr jdField_a_of_type_Yxr;
  
  private yxo a(Groups paramGroups, List<Entity> paramList, @NonNull List<String> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Friends localFriends = (Friends)paramList.next();
        if (!paramList1.contains(localFriends.uin)) {
          localArrayList.add(new yxn(localFriends));
        }
      }
    }
    return new yxo(paramGroups, localArrayList);
  }
  
  private void a(int paramInt, List<String> paramList)
  {
    if (this.app == null)
    {
      ykq.e("Q.qqstoryPermissionSettingActivity", "some error occur app is null, finish now.");
      finish();
      return;
    }
    Object localObject1 = ((vzv)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).a(true);
    Object localObject4 = new ArrayList();
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentUin();
    ykq.a("Q.qqstoryPermissionSettingActivity", "my uin:%s", this.jdField_a_of_type_JavaLangString);
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
    Object localObject5 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject6 = ((anvk)localObject5).e();
    if (localObject6 != null)
    {
      ykq.a("Q.qqstoryPermissionSettingActivity", "friends groups:%s", localObject6.toString());
      localObject6 = ((List)localObject6).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (Entity)((Iterator)localObject6).next();
        if ((localObject7 instanceof Groups))
        {
          localObject8 = (Groups)localObject7;
          ArrayList localArrayList = ((anvk)localObject5).a(String.valueOf(((Groups)localObject8).group_id));
          if ((localArrayList != null) && (!localArrayList.isEmpty()))
          {
            localObject7 = a((Groups)localObject8, localArrayList, (List)localObject4);
            localObject8 = a((Groups)localObject8, localArrayList, (List)localObject4);
            if (((yxo)localObject7).b() > 0) {
              ((List)localObject3).add(localObject7);
            }
            if (((yxo)localObject8).b() > 0) {
              ((List)localObject2).add(localObject8);
            }
          }
        }
      }
    }
    ykq.e("Q.qqstoryPermissionSettingActivity", "friends group list is null! ");
    localObject4 = new yxq(this, "", UIUtils.dip2px(this, 20.0F));
    ((yxq)localObject4).a(false, true);
    localObject5 = new yxw(this, getString(2131698922), 10004);
    ((yxw)localObject5).c(true);
    localObject6 = new yxw(this, getString(2131698918), 10000);
    ((yxw)localObject6).c(true);
    Object localObject7 = new yxw(this, getString(2131698919), 10001);
    ((yxw)localObject7).c(false);
    Object localObject8 = new yxq(this, "", UIUtils.dip2px(this, 20.0F));
    ((yxq)localObject8).a(true, true);
    localObject3 = new yxl(this, getString(2131698921), 10002, (List)localObject3, this.app);
    localObject2 = new yxl(this, getString(2131698920), 10003, (List)localObject2, this.app);
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
      localObject1 = new yxr((List)localObject1);
      this.jdField_a_of_type_Yxr = ((yxr)localObject1);
      paramList.setAdapter((ListAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this.jdField_a_of_type_Yxr);
      return;
      ((yxw)localObject5).b(true);
      continue;
      ((yxw)localObject6).b(true);
      continue;
      ((yxw)localObject7).b(true);
      continue;
      ((yxl)localObject3).b(true);
      ((yxl)localObject3).a(paramList);
      continue;
      ((yxl)localObject2).b(true);
      ((yxl)localObject2).a(paramList);
    }
  }
  
  private void a(@Nonnull yxt paramyxt)
  {
    int i = paramyxt.b();
    Intent localIntent = new Intent();
    ykq.a("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, partType:%s", Integer.valueOf(i));
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
      paramyxt = ((yxl)paramyxt).a();
      if (paramyxt.isEmpty())
      {
        ykq.d("Q.qqstoryPermissionSettingActivity", "onCompleteBtnClick, empty friend list.");
        QQToast.a(this, anvx.a(2131707387), 0).a();
        return;
      }
      paramyxt = paramyxt.iterator();
      while (paramyxt.hasNext()) {
        localArrayList.add(((yxn)paramyxt.next()).a());
      }
      localIntent.putExtra("PERMISSION_UIN_LIST_KEY", localArrayList);
      ykq.a("Q.qqstoryPermissionSettingActivity", "select uin list:%s", localArrayList.toString());
    }
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
    ykv.a("pub_control", "clk_return", 0, 0, new String[0]);
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
    setContentView(2131561769);
    super.setTitle(anvx.a(2131707382));
    this.rightViewImg.setVisibility(8);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(anvx.a(2131707393));
    this.rightViewText.setContentDescription(anvx.a(2131707389));
    this.rightViewText.setOnClickListener(new yxv(this));
    paramBundle = getIntent();
    int i;
    if (paramBundle != null) {
      i = paramBundle.getIntExtra("PERMISSION_TYPE_KEY", 10000);
    }
    for (paramBundle = paramBundle.getStringArrayListExtra("PERMISSION_UIN_LIST_KEY");; paramBundle = null)
    {
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131372563));
      a(i, paramBundle);
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetListView.getParent()).setBackgroundColor(getResources().getColor(2131167086));
      ykv.a("pub_control", "exp_page", 0, 0, new String[0]);
      return;
      i = 10000;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.permission.PermissionSettingActivity
 * JD-Core Version:    0.7.0.1
 */