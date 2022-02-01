package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyVideoVisibilityDialog
  extends ReportDialog
  implements View.OnClickListener
{
  LeftTabBarView a;
  ViewPager b;
  Context c;
  QQAppInterface d;
  VideoSpreadGroupList e;
  String f;
  int g;
  MyVideoVisiblePersonPageView h;
  MyVideoVisibleTroopPageView i;
  TroopManager j;
  boolean k;
  
  public MyVideoVisibilityDialog(@NonNull Context paramContext, String paramString, int paramInt, VideoSpreadGroupList paramVideoSpreadGroupList, boolean paramBoolean)
  {
    super(paramContext, 16973841);
    super.requestWindowFeature(1);
    super.setContentView(LayoutInflater.from(paramContext).inflate(2131628209, null));
    this.c = paramContext;
    this.d = PlayModeUtils.b();
    this.f = paramString;
    this.g = paramInt;
    this.e = paramVideoSpreadGroupList;
    this.j = ((TroopManager)PlayModeUtils.b().getManager(QQManagerFactory.TROOP_MANAGER));
    this.k = paramBoolean;
  }
  
  void a()
  {
    this.b = ((ViewPager)findViewById(2131449829));
    this.a = ((LeftTabBarView)findViewById(2131446733));
    this.a.setUnselectColor(-1);
    this.a.setSelectColor(-1);
    this.a.setBackgroundDrawable(null);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.e;
    if ((localObject1 != null) && (this.k))
    {
      if ((((VideoSpreadGroupList)localObject1).b != null) && (!this.e.b.isEmpty()))
      {
        localObject1 = new ArrayList(this.e.b.size());
        Iterator localIterator = this.e.b.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)localIterator.next();
          localObject2 = this.j.f((String)localObject2);
          if (localObject2 != null) {
            ((List)localObject1).add(localObject2);
          }
        }
        Collections.sort((List)localObject1, ContactSorter.a);
        this.i = new MyVideoVisibleTroopPageView(this, this.c, (List)localObject1, this.j);
      }
      this.h = new MyVideoVisiblePersonPageView(this, this.c, this.f, this.g);
    }
    else
    {
      this.h = new MyVideoVisiblePersonPageView(this, this.c, this.f, this.g);
    }
    localObject1 = this.h;
    if (localObject1 != null)
    {
      this.a.a(((MyVideoVisiblePersonPageView)localObject1).getTabTitle());
      localArrayList.add(this.h);
    }
    localObject1 = this.i;
    if (localObject1 != null)
    {
      this.a.a(((MyVideoVisibleTroopPageView)localObject1).getTabTitle());
      localArrayList.add(this.i);
    }
    this.a.setSelectedTab(0, false);
    this.a.setOnTabChangeListener(new MyVideoVisibilityDialog.1(this));
    this.b.setAdapter(new MyVideoVisibilityDialog.MyPagerAdapter(this, localArrayList));
    this.b.setOnPageChangeListener(new MyVideoVisibilityDialog.2(this));
    int m = this.g;
    if (m == 2) {
      m = 1;
    } else if (m == 3) {
      m = 2;
    } else if (m == 1) {
      m = 3;
    } else {
      m = 0;
    }
    StoryReportor.a("pub_control", "exp_list", 0, 0, new String[] { String.valueOf(m), "", "", this.f });
  }
  
  public void dismiss()
  {
    super.dismiss();
    MyVideoVisiblePersonPageView localMyVideoVisiblePersonPageView = this.h;
    if (localMyVideoVisiblePersonPageView != null) {
      localMyVideoVisiblePersonPageView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131430825) {
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.getWindow();
    paramBundle.setGravity(80);
    paramBundle.setWindowAnimations(2131952028);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog
 * JD-Core Version:    0.7.0.1
 */