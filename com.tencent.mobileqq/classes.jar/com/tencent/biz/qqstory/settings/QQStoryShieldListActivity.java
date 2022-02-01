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
  int jdField_a_of_type_Int;
  protected DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  QQStoryHandler jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
  QQStoryManager jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new QQStoryShieldListActivity.1(this);
  QQStoryShieldListActivity.ListAdapter jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$ListAdapter;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  protected QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131692486));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", HardCodeUtil.a(2131710975));
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(paramActivity, localIntent, 1001);
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$ListAdapter.a(paramList);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
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
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
        boolean bool;
        if (this.jdField_a_of_type_Int == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((QQStoryHandler)localObject).a(paramIntent, bool, true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131718170, 0);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("sheild_type", 1);
    if (this.jdField_a_of_type_Int == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131710955));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131710984));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    super.setContentView(2131561771);
    super.setTitle(paramBundle);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378745));
    if (this.jdField_a_of_type_Int == 2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131710959));
      paramBundle.append(QQStoryConstant.b);
      paramBundle = paramBundle.toString();
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(HardCodeUtil.a(2131710976));
      paramBundle.append(QQStoryConstant.b);
      paramBundle.append(HardCodeUtil.a(2131710988));
      paramBundle.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
      paramBundle.append(HardCodeUtil.a(2131710986));
      paramBundle = paramBundle.toString();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131377441));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2131561396);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(QQManagerFactory.QQSTORY_MANAGER));
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER));
    this.jdField_a_of_type_JavaLangString = String.valueOf(hashCode());
    paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
    boolean bool;
    if (this.jdField_a_of_type_Int == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramBundle = new ArrayList(paramBundle.a(bool));
    Object localObject;
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, HardCodeUtil.a(2131710979), 0).b(getTitleBarHeight());
    }
    else
    {
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      if (this.jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).a(null, 10, bool, this.jdField_a_of_type_JavaLangString);
      super.startTitleProgress();
    }
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$ListAdapter = new QQStoryShieldListActivity.ListAdapter(this, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$ListAdapter);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370122);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371914);
    if (paramBundle.size() == 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Int == 2)
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
    ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131371903)).setText(paramBundle);
    this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this, 20.0F));
    setLeftViewName(2131690529);
    this.rightViewText.setOnClickListener(this);
    this.rightViewText.setText(HardCodeUtil.a(2131689589));
    this.rightViewText.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
    return true;
  }
  
  protected void doOnDestroy()
  {
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
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
    if (paramView.getId() == 2131365500)
    {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, HardCodeUtil.a(2131710993), 0).b(getTitleBarHeight());
        break label441;
      }
      localObject = (QQStoryUserInfo)paramView.getTag();
      localArrayList = new ArrayList();
      localArrayList.add(((QQStoryUserInfo)localObject).uin);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      if (this.jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).a(localArrayList, bool, false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(0, 2131718170, 0);
      if (this.jdField_a_of_type_Int == 2) {
        StoryReportor.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
      } else {
        StoryReportor.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
      }
    }
    if (paramView == this.rightViewText) {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, HardCodeUtil.a(2131710980), 0).b(getTitleBarHeight());
      }
      else
      {
        localArrayList = new ArrayList();
        localArrayList.add(this.app.getCurrentAccountUin());
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
        if (this.jdField_a_of_type_Int == 2) {
          bool = true;
        } else {
          bool = false;
        }
        localObject = ((QQStoryManager)localObject).a(bool);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localArrayList.add(((QQStoryUserInfo)((Iterator)localObject).next()).uin);
          }
        }
        if (this.jdField_a_of_type_Int == 1) {
          bool = true;
        } else {
          bool = false;
        }
        a(this, localArrayList, bool);
        if (this.jdField_a_of_type_Int == 2) {
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
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity$ListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */