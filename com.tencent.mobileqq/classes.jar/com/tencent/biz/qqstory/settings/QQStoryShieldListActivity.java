package com.tencent.biz.qqstory.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nvx;
import nvy;

public class QQStoryShieldListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public DisplayMetrics a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQStoryHandler a;
  public QQStoryManager a;
  QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nvx(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  nvy jdField_a_of_type_Nvy;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  
  public static void a(Activity paramActivity, ArrayList paramArrayList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_entrance", 24);
    localIntent.putExtra("param_only_friends", true);
    localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131434550));
    localIntent.putExtra("param_uins_selected_default", paramArrayList);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_donot_need_discussion", true);
    localIntent.putExtra("param_donot_need_troop", true);
    localIntent.putExtra("param_title", "选择联系人");
    localIntent.putExtra("is_support_select_from_friend_groups", true);
    localIntent.putExtra("isExpandFirst", false);
    localIntent.putExtra("is_story_not_see", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 1001);
  }
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Nvy.a(paramList);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 1001))
    {
      localObject = paramIntent.getParcelableArrayListExtra("friendsSelected");
      if ((localObject != null) && (((ArrayList)localObject).size() != 0)) {}
    }
    else
    {
      return;
    }
    paramIntent = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(((ResultRecord)((Iterator)localObject).next()).a);
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      ((QQStoryHandler)localObject).a(paramIntent, bool, true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131433021, 0);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    boolean bool2 = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("sheild_type", 1);
    label68:
    boolean bool1;
    if (this.jdField_a_of_type_Int == 2)
    {
      paramBundle = "不让他看我的小视频";
      super.setContentView(2130970852);
      super.setTitle(paramBundle);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131362733));
      if (this.jdField_a_of_type_Int != 2) {
        break label373;
      }
      paramBundle = "把好友添加到这里后，发小视频他将无法看到。";
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372004));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this, 2130970591);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager = ((QQStoryManager)this.app.getManager(180));
      this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler = ((QQStoryHandler)this.app.a(98));
      paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
      if (this.jdField_a_of_type_Int != 2) {
        break label380;
      }
      bool1 = true;
      label151:
      paramBundle = paramBundle.a(bool1);
      this.jdField_a_of_type_Nvy = new nvy(this, paramBundle);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Nvy);
      this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370355);
      this.jdField_b_of_type_AndroidViewView = super.findViewById(2131372005);
      if ((paramBundle != null) && (paramBundle.size() != 0)) {
        break label385;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      label231:
      if (this.jdField_a_of_type_Int != 2) {
        break label405;
      }
      paramBundle = "把好友添加到这里后\r\n该好友将不会看到我的小视频";
      label242:
      ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366709)).setText(paramBundle);
      this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this, 20.0F));
      this.rightViewText.setOnClickListener(this);
      this.rightViewText.setText("添加");
      this.rightViewText.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this.app);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      if (NetworkUtil.g(this)) {
        break label412;
      }
      QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidUtilDisplayMetrics = getResources().getDisplayMetrics();
      return true;
      paramBundle = "不看他的小视频";
      break;
      label373:
      paramBundle = "把好友添加到这里后，他更新的视频将不会在小视频列表出现";
      break label68;
      label380:
      bool1 = false;
      break label151;
      label385:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label231;
      label405:
      paramBundle = "把好友添加到这里后\r\n将不会看到该好友的小视频";
      break label242;
      label412:
      paramBundle = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == 2) {
        bool1 = true;
      }
      paramBundle.a(null, 10, bool1);
      super.startTitleProgress();
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    StoryListUtils.a(this.app);
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if (paramView == this.rightViewText)
      {
        if (NetworkUtil.g(this)) {
          break;
        }
        QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
      }
      return;
      if (!NetworkUtil.g(this))
      {
        QQToast.a(this, 1, "无法连接网络，请检查你的网络设置", 0).b(getTitleBarHeight());
        return;
      }
      Object localObject2 = (QQStoryUserInfo)paramView.getTag();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(((QQStoryUserInfo)localObject2).uin);
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler;
      if (this.jdField_a_of_type_Int == 2) {}
      for (bool = true;; bool = false)
      {
        ((QQStoryHandler)localObject2).a((ArrayList)localObject1, bool, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(0, 2131433021, 0);
        if (this.jdField_a_of_type_Int != 2) {
          break label199;
        }
        StoryReportor.a("friend_story_settings", "move_notletsee", 0, 0, new String[] { "", "", "", "" });
        break;
      }
      label199:
      StoryReportor.a("friend_story_settings", "move_notsee", 0, 0, new String[] { "", "", "", "" });
    }
    paramView = new ArrayList();
    paramView.add(this.app.getCurrentAccountUin());
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryManager;
    if (this.jdField_a_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ((QQStoryManager)localObject1).a(bool);
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramView.add(((QQStoryUserInfo)((Iterator)localObject1).next()).uin);
      }
    }
    if (this.jdField_a_of_type_Int == 1) {}
    for (bool = true;; bool = false)
    {
      a(this, paramView, bool);
      if (this.jdField_a_of_type_Int != 2) {
        break;
      }
      StoryReportor.a("friend_story_settings", "add_notletsee", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    StoryReportor.a("friend_story_settings", "add_notsee", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Nvy.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldListActivity
 * JD-Core Version:    0.7.0.1
 */