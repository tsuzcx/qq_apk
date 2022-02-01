package com.tencent.biz.qqstory.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  int a;
  XListView b;
  QQStoryShieldListActivity.ListAdapter c;
  TextView d;
  IFaceDecoder e;
  QQStoryManager f;
  QQStoryHandler g;
  int h;
  protected QQProgressNotifier i;
  View j;
  View k;
  protected DisplayMetrics l;
  QQStoryObserver m = new QQStoryShieldListActivity.1(this);
  private String n;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131889474));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", HardCodeUtil.a(2131908641));
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, localIntent, 1001);
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      this.c.a(paramList);
      return;
    }
    this.j.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1001))
    {
      Object localObject = paramIntent.getParcelableArrayListExtra("friendsSelected");
      if (localObject != null)
      {
        if (((ArrayList)localObject).size() == 0) {
          return;
        }
        paramIntent = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramIntent.add(((ResultRecord)((Iterator)localObject).next()).uin);
        }
        localObject = this.g;
        boolean bool;
        if (this.a == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((QQStoryHandler)localObject).a(paramIntent, bool, true);
        this.i.b(0, 2131915649, 0);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = getIntent().getIntExtra("sheild_type", 1);
    if (this.a == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131908622));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131908650));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    super.setContentView(2131628150);
    super.setTitle(paramBundle);
    this.d = ((TextView)super.findViewById(2131447419));
    if (this.a == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131908626));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131908642));
      paramBundle.append(QQStoryConstant.b);
      paramBundle.append(HardCodeUtil.a(2131908654));
      paramBundle.append(QQStoryConstant.a);
      paramBundle.append(HardCodeUtil.a(2131908652));
      paramBundle = paramBundle.toString();
    }
    this.d.setText(paramBundle);
    this.b = ((XListView)super.findViewById(2131445840));
    this.i = new QQProgressNotifier(this, 2131627752);
    this.f = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.g = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    this.n = String.valueOf(hashCode());
    paramBundle = this.f;
    boolean bool;
    if (this.a == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramBundle = new ArrayList(paramBundle.j(bool));
    Object localObject;
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, 1, HardCodeUtil.a(2131908645), 0).show(getTitleBarHeight());
    }
    else
    {
      this.app.addObserver(this.m);
      localObject = this.g;
      if (this.a == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).a(null, 10, bool, this.n);
      super.startTitleProgress();
    }
    this.c = new QQStoryShieldListActivity.ListAdapter(this, paramBundle);
    this.b.setAdapter(this.c);
    this.j = super.findViewById(2131437284);
    this.k = super.findViewById(2131439359);
    if (paramBundle.size() == 0)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
    }
    else
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
    }
    if (this.a == 2)
    {
      localObject = new StringBuilder();
      paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的";
    }
    else
    {
      localObject = new StringBuilder();
      paramBundle = "把好友添加到这里后\r\n将不会看到该好友的";
    }
    ((StringBuilder)localObject).append(paramBundle);
    ((StringBuilder)localObject).append(QQStoryConstant.b);
    paramBundle = ((StringBuilder)localObject).toString();
    ((TextView)this.k.findViewById(2131439348)).setText(paramBundle);
    this.h = ((int)DisplayUtils.a(this, 20.0F));
    setLeftViewName(2131887440);
    this.rightViewText.setOnClickListener(this);
    this.rightViewText.setText(HardCodeUtil.a(2131886199));
    this.rightViewText.setVisibility(0);
    this.e = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.e.setDecodeTaskCompletionListener(this);
    this.l = getResources().getDisplayMetrics();
    return true;
  }
  
  protected void doOnDestroy()
  {
    IFaceDecoder localIFaceDecoder = this.e;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    this.i.b();
    this.app.removeObserver(this.m);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    StoryReportor.a(14, this.currentActivityStayTime);
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    ArrayList localArrayList;
    boolean bool;
    if (paramView.getId() == 2131431715)
    {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.makeText(this, 1, HardCodeUtil.a(2131908659), 0).show(getTitleBarHeight());
        break label441;
      }
      localObject = (QQStoryUserInfo)paramView.getTag();
      localArrayList = new ArrayList();
      localArrayList.add(((QQStoryUserInfo)localObject).uin);
      localObject = this.g;
      if (this.a == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).a(localArrayList, bool, false);
      this.i.b(0, 2131915649, 0);
      if (this.a == 2) {
        StoryReportor.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
      } else {
        StoryReportor.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
      }
    }
    if (paramView == this.rightViewText) {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.makeText(this, 1, HardCodeUtil.a(2131908646), 0).show(getTitleBarHeight());
      }
      else
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.f;
        if (this.a == 2) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = ((QQStoryManager)localObject).j(bool);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((QQStoryUserInfo)((Iterator)localObject).next()).uin);
          }
        }
        if (this.a == 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(this, localArrayList, bool);
        if (this.a == 2) {
          StoryReportor.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
        } else {
          StoryReportor.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
        }
      }
    }
    label441:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */