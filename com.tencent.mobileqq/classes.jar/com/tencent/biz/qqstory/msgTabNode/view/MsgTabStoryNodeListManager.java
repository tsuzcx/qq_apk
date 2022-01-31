package com.tencent.biz.qqstory.msgTabNode.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.RecommendActivityViewHolder;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.util.HashMap;
import java.util.List;
import nfb;
import nfc;
import nfd;
import nff;
import nfg;
import nfh;
import nfi;

public class MsgTabStoryNodeListManager
  implements ViewTreeObserver.OnGlobalLayoutListener, BaseAdapter.OnItemClickListener, BaseAdapter.OnItemLongClickListener, ActionSheet.OnButtonClickListener
{
  public static String a;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  private static String h;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = System.currentTimeMillis();
  public Context a;
  DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver;
  public MsgTabStoryNodeAdapter a;
  public MsgTabStoryNodeDelegate a;
  public MsgTabStoryNodeView a;
  ShotView jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public ListView a;
  public CalloutPopupWindow a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  boolean c;
  public boolean d;
  public boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "查看全部小视频";
    jdField_b_of_type_JavaLangString = "设置";
    jdField_c_of_type_JavaLangString = "屏蔽";
    jdField_d_of_type_JavaLangString = "关注";
    jdField_e_of_type_JavaLangString = "取消关注";
    f = "退出圈子";
    g = "不感兴趣";
    h = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new String[] { jdField_a_of_type_JavaLangString, jdField_c_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), new String[] { jdField_a_of_type_JavaLangString, jdField_e_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), new String[] { jdField_a_of_type_JavaLangString, jdField_d_of_type_JavaLangString, g });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), new String[] { g });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), new String[] { g });
  }
  
  public MsgTabStoryNodeListManager(Context paramContext, ListView paramListView)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter = new MsgTabStoryNodeAdapter(paramContext);
    if (Build.VERSION.SDK_INT >= 18)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView = new ShotView(paramContext);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView);
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new nfb(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate = new MsgTabStoryNodeDelegate(this, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setOnScrollListener(new nfc(this));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new nfd(this);
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (!this.jdField_e_of_type_Boolean) && (this.jdField_d_of_type_Boolean) && (d()) && (!WorldCupStaticInstance.a().jdField_c_of_type_Boolean);
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      if ((localRecyclerView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null)) {
        return (((LinearLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a());
      }
    }
    return false;
  }
  
  private boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop() >= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(h, 2, "isMsgTabVisible true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i(h, 2, "isMsgTabVisible false");
    }
    return false;
  }
  
  private void j()
  {
    if (!b()) {}
    do
    {
      do
      {
        return;
      } while (!c());
      if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null)
      {
        CalloutPopupWindow.Builder localBuilder = CalloutPopupWindow.a(this.jdField_a_of_type_AndroidContentContext).a(true).a("试试拍个视频吧").a(16.0F).b(5).a(-1);
        localBuilder.c(50);
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = new CalloutPopupWindow.DrawableBuilder(localBuilder).b(Color.argb(255, 0, 0, 0)).a(5).a().a();
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new nfi(this));
      }
    } while ((this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null) || (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing()));
    this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a(PlayModeUtils.a().getCurrentAccountUin());
    StoryReportor.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
    this.jdField_c_of_type_Boolean = false;
    ((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_shot_tips", Boolean.valueOf(false));
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
        if (QLog.isColorLevel()) {
          QLog.d(h, 2, "dismissTipWindows success");
        }
      }
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
    }
  }
  
  private void l()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i(h, 2, "prepareShowTips");
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (localObject == null) {}
    MsgTabNodeInfo localMsgTabNodeInfo;
    do
    {
      return;
      localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(((ActionMenuItem)localObject).jdField_c_of_type_Int);
    } while (localMsgTabNodeInfo == null);
    paramView = this.jdField_a_of_type_AndroidContentContext;
    localObject = ((ActionMenuItem)localObject).jdField_a_of_type_JavaLangString;
    if (jdField_a_of_type_JavaLangString.equals(localObject)) {
      if ((6 == localMsgTabNodeInfo.jdField_a_of_type_Int) || (7 == localMsgTabNodeInfo.jdField_a_of_type_Int) || (9 == localMsgTabNodeInfo.jdField_a_of_type_Int) || (5 == localMsgTabNodeInfo.jdField_a_of_type_Int))
      {
        QQStoryMemoriesActivity.a(paramView, 26, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, false);
        paramView = "1";
      }
    }
    for (;;)
    {
      StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { localMsgTabNodeInfo.jdField_a_of_type_Int + "", paramView, "", localMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
      return;
      if (8 != localMsgTabNodeInfo.jdField_a_of_type_Int) {
        break;
      }
      QQStoryShareGroupProfileActivity.a(paramView, 2, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, String.valueOf(localMsgTabNodeInfo.jdField_b_of_type_Long), 17, 0);
      break;
      if (jdField_b_of_type_JavaLangString.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryFriendSettings.class);
        ((Intent)localObject).putExtra("from", -1);
        paramView.startActivity((Intent)localObject);
        paramView = "2";
      }
      else if (jdField_c_of_type_JavaLangString.equals(localObject))
      {
        localObject = new Intent(paramView, QQStoryShieldActivity.class);
        ((Intent)localObject).putExtra("uin", String.valueOf(localMsgTabNodeInfo.jdField_b_of_type_Long));
        ((Intent)localObject).putExtra("from", 3);
        paramView.startActivity((Intent)localObject);
        paramView = "3";
      }
      else if (g.equals(localObject))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.b(localMsgTabNodeInfo);
        paramView = "7";
      }
      else if (jdField_d_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(localMsgTabNodeInfo, 0);
        paramView = "4";
      }
      else if (jdField_e_of_type_JavaLangString.equals(localObject))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(localMsgTabNodeInfo, 1);
        paramView = "5";
      }
      else
      {
        if ("debug info".equals(localObject)) {
          Toast.makeText(paramView, localMsgTabNodeInfo.toString(), 1).show();
        }
        paramView = "";
      }
    }
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_shot_tips", Boolean.valueOf(true))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, new Object[] { "check tips config is ", Boolean.valueOf(this.jdField_c_of_type_Boolean) });
    }
    this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView, 2);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    l();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetListView.getChildCount() > 0)
    {
      i = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (paramInt != 0) {
        break label203;
      }
      if (i < this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount())
      {
        View localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
        if (localView == this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView)
        {
          paramInt = localView.getTop();
          if ((paramInt < 0) && (paramInt > -localView.getHeight()))
          {
            if (this.jdField_a_of_type_Int != i) {
              break label173;
            }
            if (this.jdField_b_of_type_Int <= paramInt) {
              break label168;
            }
            paramInt = 1;
            if (paramInt == 0) {
              break label198;
            }
            if (-localView.getTop() >= localView.getHeight() / 2) {
              break label191;
            }
            paramInt = i;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetListView.post(new nff(this, paramInt));
      if ((this.jdField_b_of_type_Boolean) && (a()))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_out", true, false);
      }
      return;
      label168:
      paramInt = 0;
      break;
      label173:
      if (this.jdField_a_of_type_Int < i)
      {
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break;
      label191:
      paramInt = i + 1;
      continue;
      label198:
      paramInt = 0;
    }
    label203:
    this.jdField_a_of_type_Int = i;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0).getTop();
    k();
  }
  
  public void a(View paramView, int paramInt)
  {
    Context localContext = paramView.getContext();
    int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemViewType(paramInt);
    Object localObject2 = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramInt);
    switch (i)
    {
    default: 
      if (localObject2 != null) {
        break;
      }
    case 1024: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      label371:
      do
      {
        return;
        paramView = StoryPublishLauncher.a();
        if (paramView.a())
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("entrance_type", 103);
          ((Bundle)localObject1).putInt("report_entrance_type", 1);
          if ((localContext instanceof Activity))
          {
            localObject2 = (Activity)localContext;
            paramView.a((Activity)localObject2, (Bundle)localObject1, 0);
            ((Activity)localObject2).overridePendingTransition(2131034327, 2131034167);
          }
        }
        for (;;)
        {
          StoryReportor.a("msg_tab", "clk_story", 0, 0, new String[] { "1", "", "", "" });
          return;
          paramView.a(localContext, (Bundle)localObject1);
          continue;
          paramView = new QQStoryTakeVideoActivityLauncher(PlayModeUtils.a()).a(localContext, 103);
          paramView.putExtra("report_entrance_type", 1);
          if ((localContext instanceof Activity))
          {
            localObject1 = (Activity)localContext;
            ((Activity)localObject1).startActivityForResult(paramView, 0);
            ((Activity)localObject1).overridePendingTransition(2131034327, 2131034167);
          }
          else
          {
            localContext.startActivity(paramView);
          }
        }
        if ((localObject2 != null) && (!UIUtils.b()))
        {
          paramView = (ImageView)paramView.findViewById(2131371907);
          StoryPlayVideoActivity.a((Activity)localContext, paramView, ((MsgTabNodeInfo)localObject2).jdField_a_of_type_JavaLangString, "", false);
        }
      } while (localObject2 == null);
      paramView = "";
      if (((MsgTabNodeInfo)localObject2).jdField_a_of_type_Int == 5)
      {
        if (((MsgTabNodeInfo)localObject2).jdField_c_of_type_Int > 0) {
          paramView = "2";
        }
      }
      else {
        label401:
        if (((MsgTabNodeInfo)localObject2).jdField_b_of_type_Int != 0) {
          break label786;
        }
      }
      break;
    }
    label786:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      StoryReportor.a("msg_tab", "clk_story", 0, 0, new String[] { ((MsgTabNodeInfo)localObject2).jdField_a_of_type_Int + "", localObject1, paramView, ((MsgTabNodeInfo)localObject2).jdField_a_of_type_JavaLangString });
      return;
      if ((!(localContext instanceof Activity)) || (localObject2 == null) || (TextUtils.isEmpty(((MsgTabNodeInfo)localObject2).jdField_e_of_type_JavaLangString))) {
        break label371;
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label371;
      }
      localObject1 = (Activity)localContext;
      paramView = (ImageView)paramView.findViewById(2131371907);
      StoryPlayVideoActivity.a((Activity)localObject1, ((MsgTabNodeInfo)localObject2).jdField_e_of_type_JavaLangString, -1, paramView);
      break label371;
      StoryReportor.a("home_page-exp-d4", "5");
      localContext.startActivity(StoryTransitionActivity.a(localContext));
      break label371;
      paramView = new Intent(localContext, StoryMessageListActivity.class);
      paramView.putExtra("qqstory_message_list_source", 2);
      paramView.putExtra("qqstory_jump_source", "1");
      localContext.startActivity(paramView);
      break label371;
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((MsgTabNodeInfo)localObject2).jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label371;
      }
      paramView = (View)localObject1;
      if (((String)localObject1).toLowerCase().startsWith("www.")) {
        paramView = "http://" + (String)localObject1;
      }
      localObject1 = new Intent(localContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", paramView);
      localContext.startActivity((Intent)localObject1);
      ((MsgTabNodeInfo)localObject2).jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a((MsgTabNodeInfo)localObject2);
      }
      RecommendActivityViewHolder.b((MsgTabNodeInfo)localObject2);
      break label371;
      if (!QLog.isDevelopLevel()) {
        break label371;
      }
      QLog.e(h, 2, "发现一个野生的类型: " + ((MsgTabNodeInfo)localObject2).jdField_a_of_type_Int);
      break label371;
      paramView = "1";
      break label401;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(paramQQAppInterface);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null) {}
    try
    {
      long l = Long.valueOf(paramString).longValue();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(6, l);
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "updateFriendItem-----------");
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(h, 2, "updateFriendItem: " + QLog.getStackTraceString(paramString));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    if (j <= this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount()) {
      if (!paramBoolean) {
        break label68;
      }
    }
    label68:
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentWidgetListView.findHeaderViewPosition(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView))
    {
      if ((i != -1) && (i <= j))
      {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(i);
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_out", true, false);
        }
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.jdField_a_of_type_ComTencentWidgetListView.getPositionForView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    } while ((i <= j) && ((i != j) || (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop() <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight() / 2)));
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    if (this.jdField_a_of_type_Boolean) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.b();
      this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_Boolean = false;
      k();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        QQCatchedExceptionReporter.reportQQCatchedException(localIllegalStateException, "MSG_TAB_BUG", "这里多次shutdown了");
      }
    }
  }
  
  public void b(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemViewType(paramInt);
    String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramInt);
    if (localMsgTabNodeInfo == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
    int j = arrayOfString.length;
    i = 0;
    label96:
    if (i < j)
    {
      paramView = arrayOfString[i];
      if ((!jdField_d_of_type_JavaLangString.equals(paramView)) && (!jdField_e_of_type_JavaLangString.equals(paramView))) {
        break label303;
      }
      QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      if (localQQUserUIItem == null) {
        break label303;
      }
      if (localQQUserUIItem.isSubscribe()) {
        paramView = jdField_e_of_type_JavaLangString;
      }
    }
    label303:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new ActionMenuItem(paramView, paramInt, 0), 5);
      i += 1;
      break label96;
      paramView = jdField_d_of_type_JavaLangString;
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new nfg(this, localMsgTabNodeInfo));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      if (localMsgTabNodeInfo == null) {
        break;
      }
      StoryReportor.a("msg_tab", "press_story", 0, 0, new String[] { localMsgTabNodeInfo.jdField_a_of_type_Int + "", "", "", localMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(6);
      if (QLog.isColorLevel()) {
        QLog.d(h, 2, "updateFriendItems-----------");
      }
    }
  }
  
  public void d()
  {
    if ((!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a()) && (this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(1) == 0) && (this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() < this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount()))
    {
      this.jdField_a_of_type_ComTencentWidgetListView.setSelection(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount());
      this.jdField_a_of_type_ComTencentWidgetListView.post(new nfh(this));
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_not", false, false);
    }
  }
  
  public void e()
  {
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onDrawerStartMoving");
    }
    k();
  }
  
  public void f()
  {
    this.jdField_e_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onDrawerOpened");
    }
    k();
  }
  
  public void g()
  {
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onDrawerClosed");
    }
    l();
  }
  
  public void h()
  {
    this.jdField_d_of_type_Boolean = true;
    l();
  }
  
  public void i()
  {
    this.jdField_d_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(h, 2, "onPause");
    }
    k();
  }
  
  public void onGlobalLayout()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewShotView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager
 * JD-Core Version:    0.7.0.1
 */