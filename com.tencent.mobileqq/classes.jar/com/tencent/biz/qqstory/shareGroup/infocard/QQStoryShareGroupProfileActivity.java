package com.tencent.biz.qqstory.shareGroup.infocard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetVideoByHotSortEvent;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.newshare.StoryShare;
import com.tencent.biz.qqstory.shareGroup.addvideo.AddVideoController;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListAdapter;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter.PublishVideoItem;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QQStoryShareGroupProfileActivity
  extends QQStoryBaseActivity
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  GetHotSortVideoHandler jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler;
  StoryShare jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
  QQStoryShareGroupHelper jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper;
  ShareGroupDataPuller jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller;
  ShareGroupsListAdapter jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter;
  ShareGroupsListView jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView;
  ShareGroupItem jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem;
  TranslucentTitleBarHelper jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper;
  LoadMoreLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int = 0;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  String jdField_d_of_type_JavaLangString;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  private boolean h = false;
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, QQStoryShareGroupProfileActivity.class);
    paramContext.putExtra("extra_share_group_id", paramString1);
    paramContext.putExtra("extra_share_group_type", paramInt1);
    paramContext.putExtra("extra_share_group_from", paramInt2);
    paramContext.putExtra("extra_share_group_play_from", paramInt3);
    paramContext.putExtra("extra_user_group_uin", paramString2);
    return paramContext;
  }
  
  private List<VideoCollectionItem> a(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localVideoCollectionItem1 = (VideoCollectionItem)paramList.next();
      if (localVideoCollectionItem1.collectionCount > 0)
      {
        localVideoCollectionItem2 = new VideoCollectionItem();
        localVideoCollectionItem2.copy(localVideoCollectionItem1);
        localArrayList.add(localVideoCollectionItem2);
      }
    }
    if (!paramBoolean) {
      return localArrayList;
    }
    if (localArrayList.size() < 2) {
      return localArrayList;
    }
    paramList = (VideoCollectionItem)localArrayList.get(0);
    VideoCollectionItem localVideoCollectionItem1 = (VideoCollectionItem)localArrayList.get(1);
    VideoCollectionItem localVideoCollectionItem2 = VideoCollectionItem.getCurrentYearFakeItem(this.jdField_b_of_type_JavaLangString);
    VideoCollectionItem localVideoCollectionItem3 = VideoCollectionItem.getTodayFakeItem(this.jdField_b_of_type_JavaLangString);
    if (paramList.collectionType != 0)
    {
      localArrayList.add(0, localVideoCollectionItem2);
      if (!DateUtils.b(paramList.collectionTime))
      {
        localArrayList.add(1, localVideoCollectionItem3);
        return localArrayList;
      }
      paramList.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
      return localArrayList;
    }
    if (DateUtils.a(paramList.collectionTime))
    {
      if (DateUtils.b(localVideoCollectionItem1.collectionTime))
      {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new MemoriesInnerListAdapter.PublishVideoItem());
        return localArrayList;
      }
      localArrayList.add(1, localVideoCollectionItem3);
      return localArrayList;
    }
    localArrayList.add(0, localVideoCollectionItem2);
    localArrayList.add(1, localVideoCollectionItem3);
    return localArrayList;
  }
  
  private void a(int paramInt)
  {
    if (this.h)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
      return;
    }
    if ((paramInt < this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getFirstVisiblePosition()) || (paramInt > this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getLastVisiblePosition()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
      this.h = true;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext.startActivity(a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3));
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int j;
    if (this.jdField_c_of_type_Int == 1) {
      j = 3;
    } else if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()) {
      j = 2;
    } else {
      j = 1;
    }
    int k;
    if (this.jdField_c_of_type_Int == 1) {
      k = 2;
    } else {
      k = 1;
    }
    int m = paramIntent.getIntExtra("totalPublishVideoCount", 1);
    boolean bool1 = paramIntent.getBooleanExtra("isLocalPublish", false);
    boolean bool2 = paramIntent.getBooleanExtra("isTakePhoto", false);
    int i;
    if (paramIntent.getBooleanExtra("isAddFromExist", false)) {
      i = 5;
    } else if (bool1)
    {
      if (bool2) {
        i = 2;
      } else {
        i = 1;
      }
    }
    else if (bool2) {
      i = 4;
    } else {
      i = 3;
    }
    StoryReportor.a("share_story", "clk_add_suc", j, k, new String[] { paramString, String.valueOf(m), String.valueOf(i) });
    if ((this.jdField_a_of_type_Int == 8) && (this.jdField_d_of_type_Int == 0))
    {
      paramIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      paramIntent.putExtra("uintype", 1);
      paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
    }
    if ((this.jdField_a_of_type_Int != 9) && (this.jdField_d_of_type_Int != 9))
    {
      paramIntent = StoryTransitionActivity.a(this);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
    }
    paramIntent = new Intent(this, TroopStoryMainActivity.class);
    paramIntent.addFlags(71303168);
    startActivity(paramIntent);
  }
  
  private void a(DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    List localList = a(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList, paramGetCollectionListEvent.jdField_c_of_type_Boolean);
    if (paramGetCollectionListEvent.jdField_c_of_type_Boolean)
    {
      if ((paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetCollectionListEvent.e))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a(localList, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
        if (!paramGetCollectionListEvent.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetCollectionListEvent.jdField_a_of_type_Boolean);
      if (!paramGetCollectionListEvent.jdField_b_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty())
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(true);
        }
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(0);
        return;
      }
      if (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(0);
      }
    }
    else
    {
      if ((paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramGetCollectionListEvent.e)) {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.c(localList, paramGetCollectionListEvent.jdField_a_of_type_Boolean);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetCollectionListEvent.jdField_a_of_type_Boolean);
    }
  }
  
  private void a(GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent)
  {
    if (!paramGetVideoByHotSortEvent.jdField_c_of_type_Boolean) {
      if ((paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList != null) && (paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        if (paramGetVideoByHotSortEvent.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.f(paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(paramGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
        }
      }
      else if (!paramGetVideoByHotSortEvent.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a();
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(0);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a(paramGetVideoByHotSortEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess(), paramGetVideoByHotSortEvent.jdField_a_of_type_Boolean);
  }
  
  private void a(GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    QQToast.a(this, 1, HardCodeUtil.a(2131710991), 1).a();
  }
  
  private void a(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(0);
    if ((!paramShareGroupItem.isInvalid()) && (paramShareGroupItem.type != 2))
    {
      int i;
      if ((paramShareGroupItem.type == 2) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe())) {
        i = 1;
      } else {
        i = 0;
      }
      if (!this.e)
      {
        boolean bool;
        if ((paramShareGroupItem.type == 2) && (paramShareGroupItem.isPublic())) {
          bool = true;
        } else {
          bool = false;
        }
        this.g = bool;
      }
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(QQStoryConstant.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(true, false);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(false, false);
        if (!this.e)
        {
          this.e = true;
          b(true);
        }
        b(paramShareGroupItem);
      }
      if (!this.f)
      {
        this.f = true;
        i = paramShareGroupItem.getReportGroupProp();
        int j = StoryApi.a(2131427366);
        paramShareGroupItem = paramShareGroupItem.getReportUserType();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("");
        StoryReportor.a("share_story", "exp_data", i, j, new String[] { paramShareGroupItem, ((StringBuilder)localObject).toString() });
      }
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131699922);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(true, false);
  }
  
  private void a(String paramString, int paramInt)
  {
    int i;
    if (this.jdField_c_of_type_Int == 1) {
      i = 3;
    } else if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic()) {
      i = 2;
    } else {
      i = 1;
    }
    int j;
    if (this.jdField_c_of_type_Int == 1) {
      j = 2;
    } else {
      j = 1;
    }
    StoryReportor.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
    AddVideoController localAddVideoController = new AddVideoController(this.app);
    if ("2".equals(paramString)) {
      i = 2;
    } else if ("5".equals(paramString)) {
      i = 5;
    } else {
      i = 0;
    }
    localAddVideoController.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 1;
  }
  
  private void b()
  {
    View localView = LayoutInflater.from(this).inflate(2131561770, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(localView);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper.a(false, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131378837));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369249));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369216));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369233));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)super.findViewById(2131378881));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131369810));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366238);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839388);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366218));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131366229));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131377425));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130839388);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131374576));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(1);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    c();
  }
  
  private void b(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramShareGroupItem.name);
      if ((paramShareGroupItem.videoCount != 0) && (this.jdField_a_of_type_Int != 8)) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a(paramShareGroupItem);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter = ((ShareGroupsListAdapter)StoryApi.a(ShareGroupsListAdapter.class, new Object[] { this, Boolean.valueOf(this.g) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter);
    QQStoryShareGroupProfileActivity.UIEventListenerImpl localUIEventListenerImpl = new QQStoryShareGroupProfileActivity.UIEventListenerImpl(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localUIEventListenerImpl);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(localUIEventListenerImpl);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(localUIEventListenerImpl);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(localUIEventListenerImpl);
  }
  
  private void c(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((ShareGroupManager)SuperManager.a(7)).a(this.jdField_b_of_type_JavaLangString);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      a(localShareGroupItem);
    }
    if (this.jdField_c_of_type_Int == 1)
    {
      new GetShareGroupInfoHandler(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString).a();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    a(localShareGroupItem);
  }
  
  private void d()
  {
    ActionSheet localActionSheet = ActionSheet.create(this);
    if (this.jdField_c_of_type_Int == 1) {
      localActionSheet.addButton(HardCodeUtil.a(2131710964), 5);
    }
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new QQStoryShareGroupProfileActivity.2(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller = new ShareGroupDataPuller(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.c();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardModelShareGroupDataPuller.d();
  }
  
  public int a()
  {
    int i = this.jdField_b_of_type_Int;
    if (i > 0) {
      return i;
    }
    if (this.jdField_c_of_type_Int == 1) {
      return 88;
    }
    return 87;
  }
  
  @NonNull
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler = new GetHotSortVideoHandler(this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler.b();
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (paramString.equals(((VideoCollectionItem)localIterator.next()).feedId))
      {
        a(i);
        return;
      }
      i += 1;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.jdField_a_of_type_JavaUtilList, false);
      }
      else
      {
        List localList = ((HotSortVideoManager)SuperManager.a(25)).a(this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.e(localList, false);
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler == null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler = new GetHotSortVideoHandler(this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.setState(1);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler.a();
  }
  
  public boolean a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (paramVideoCollectionItem.collectionCount <= paramVideoCollectionItem.collectionVideoUIItemList.size()) {
      return false;
    }
    qqstory_service.ReqLoadMoreVideoList localReqLoadMoreVideoList = new qqstory_service.ReqLoadMoreVideoList();
    localReqLoadMoreVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.feedId));
    Object localObject = localReqLoadMoreVideoList.from;
    int j = this.jdField_c_of_type_Int;
    int i = 2;
    if (j != 2) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localReqLoadMoreVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.nextCookie));
    localReqLoadMoreVideoList.video_count.set(10);
    localObject = new Bundle();
    ((Bundle)localObject).putString("extra_feedid", paramVideoCollectionItem.feedId);
    ProtoUtils.a(this.app, new QQStoryShareGroupProfileActivity.3(this), localReqLoadMoreVideoList.toByteArray(), StoryApi.a("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.g)
    {
      localShareGroupsListView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView;
      localShareGroupsListView.setPadding(localShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.a(this, 76.0F));
      a(paramBoolean);
      return;
    }
    ShareGroupsListView localShareGroupsListView = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView;
    localShareGroupsListView.setPadding(localShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), UIUtils.a(this, 89.0F));
    d(paramBoolean);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 1003)
      {
        if (paramInt1 != 1004)
        {
          StoryShare localStoryShare = this.jdField_a_of_type_ComTencentBizQqstoryNewshareStoryShare;
          if (localStoryShare != null) {
            localStoryShare.a(paramInt1, paramInt2, paramIntent);
          }
        }
        else
        {
          a(paramIntent, "5");
        }
      }
      else {
        a(paramIntent, "2");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsTranslucentTitleBarHelper = new TranslucentTitleBarHelper(this, 20);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("extra_share_group_id");
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("extra_share_group_type", 1);
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("extra_user_group_uin");
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("extra_share_group_from", 0);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("extra_share_from_user_uid");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("extra_share_group_play_from", 0);
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("extra_last_open_from", 0);
    this.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardQQStoryShareGroupHelper = ((QQStoryShareGroupHelper)StoryApi.a(QQStoryShareGroupHelper.class, new Object[0]));
    b();
    if ((this.jdField_c_of_type_Int == 1) && (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_user_group_uin must not be empty!");
        }
        super.finish();
        return false;
      }
      new GetUserGroupUnionIDHandler(this.jdField_c_of_type_JavaLangString).a();
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_share_group_id must not be empty!");
        }
        super.finish();
        return false;
      }
      c(a() ^ true);
    }
    if (this.jdField_a_of_type_Int == 5) {
      new Handler(Looper.getMainLooper()).postDelayed(new QQStoryShareGroupProfileActivity.1(this), 200L);
    }
    return true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      c(true);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      b(false);
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListAdapter.notifyDataSetChanged();
    }
  }
  
  protected boolean isWrapContent()
  {
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreateSubscribers(@NonNull Map<Subscriber, String> paramMap)
  {
    super.onCreateSubscribers(paramMap);
    paramMap.put(new QQStoryShareGroupProfileActivity.GetCollectListEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetSimpleInfoListEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetGroupInfoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.UpdateUserInfoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetUserGroupUnionIDEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.VideoSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.GetVideoByHotSortEventReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.ReportVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.StoryVideoPublishStatusReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.WatchVideoReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.FeedInfoUpdateReceiver(this), "");
    paramMap.put(new QQStoryShareGroupProfileActivity.PlayVideoChangeReceiver(this), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */