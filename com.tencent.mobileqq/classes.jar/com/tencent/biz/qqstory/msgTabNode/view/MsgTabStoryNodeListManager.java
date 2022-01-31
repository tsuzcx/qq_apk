package com.tencent.biz.qqstory.msgTabNode.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.utils.DynamicUnitUtils;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.msgTabNode.view.viewholder.old_version.RecommendActivityViewHolder;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.UrlJumpUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.config.WorldCupStaticInstance;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import dov.com.qq.im.QIMShortVideoUtils;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import njb;
import njc;
import njd;
import nje;
import njf;
import njh;
import nji;
import njj;
import njk;
import njl;
import njn;
import njo;

public class MsgTabStoryNodeListManager
  implements BaseAdapter.OnItemClickListener, BaseAdapter.OnItemLongClickListener, DrawerFrame.StoryTouchEventInterceptor, ARMapHongBaoListView.QQStoryListViewListener, ActionSheet.OnButtonClickListener
{
  public static String a;
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static long b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static boolean g;
  public static String h;
  private static String i;
  float jdField_a_of_type_Float;
  public int a;
  long jdField_a_of_type_Long;
  public Context a;
  DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  View jdField_a_of_type_AndroidViewView;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nji(this);
  private DotAnimationView jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView;
  public MsgNodeShotView a;
  public MsgTabStoryNodeAdapter a;
  public MsgTabStoryNodeDelegate a;
  public MsgTabStoryNodeView a;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new njh(this);
  public QQAppInterface a;
  public HongBao2018ListView a;
  protected GetRedPointExObserver a;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public CalloutPopupWindow a;
  public Runnable a;
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 30;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new njb(this);
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 70;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  public boolean d;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  public boolean e;
  private int f;
  public boolean f;
  private int g;
  boolean h;
  
  static
  {
    jdField_a_of_type_JavaLangString = "查看全部小视频";
    jdField_b_of_type_JavaLangString = "设置";
    jdField_c_of_type_JavaLangString = "屏蔽";
    jdField_d_of_type_JavaLangString = "关注";
    jdField_e_of_type_JavaLangString = "取消关注";
    jdField_f_of_type_JavaLangString = "退出圈子";
    jdField_g_of_type_JavaLangString = "不感兴趣";
    jdField_h_of_type_JavaLangString = "测试压缩";
    i = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new String[] { jdField_a_of_type_JavaLangString, jdField_c_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), new String[] { jdField_a_of_type_JavaLangString, jdField_e_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), new String[] { jdField_a_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), new String[] { jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), new String[] { jdField_g_of_type_JavaLangString });
  }
  
  public MsgTabStoryNodeListManager(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new njf(this);
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new njc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView = ((HongBao2018ListView)paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = paramPullRefreshHeader;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = paramBreathEffectView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131371908);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView = ((DotAnimationView)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131371914));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)this.jdField_a_of_type_AndroidContentContext.getSystemService("vibrator"));
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter = new MsgTabStoryNodeAdapter(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView = new MsgNodeShotView(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.setLayoutParams(new RecyclerView.LayoutParams(DynamicUnitUtils.a(67.0F), DynamicUnitUtils.a(102.0F)));
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate = new MsgTabStoryNodeDelegate(this, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setOnScrollListener(new njk(this));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new njl(this);
    this.jdField_b_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_c_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_d_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -120.0F);
    this.jdField_d_of_type_Int = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -80.0F);
    this.jdField_e_of_type_Int = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.jdField_g_of_type_Int != 3)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a(paramFloat);
    }
    float f1;
    if ((paramFloat <= this.jdField_c_of_type_Float) && (paramFloat > this.jdField_e_of_type_Float)) {
      if (paramFloat <= this.jdField_d_of_type_Float)
      {
        f1 = (this.jdField_d_of_type_Float - paramFloat) / (this.jdField_d_of_type_Float - this.jdField_e_of_type_Float);
        float f2 = this.jdField_d_of_type_Int + (this.jdField_c_of_type_Float - this.jdField_d_of_type_Float) * 1.0F;
        f1 = f2 - f1 * f2 * 1.5F;
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY();
        this.jdField_b_of_type_AndroidViewView.setTranslationY(f1);
        if (this.jdField_b_of_type_AndroidViewView.getTranslationY() < this.jdField_d_of_type_Int) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(this.jdField_d_of_type_Int);
        }
        if (this.jdField_b_of_type_AndroidViewView.getTranslationY() > 0.0F) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
        }
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY() - f2;
        a(1.0F - this.jdField_b_of_type_AndroidViewView.getTranslationY() / this.jdField_d_of_type_Int + 0.8F);
        f1 = f2;
        if (this.jdField_a_of_type_AndroidOsVibrator != null)
        {
          f1 = f2;
          if (this.jdField_a_of_type_Float > this.jdField_c_of_type_Float)
          {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
            ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
            f1 = f2;
          }
        }
        label244:
        if (paramFloat <= UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -75.0F)) {
          break label322;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.setTranslationY((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.getHeight() + paramFloat) / 2.0F);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramFloat;
      return;
      f1 = this.jdField_d_of_type_Int + (this.jdField_c_of_type_Float - paramFloat) * 1.0F;
      break;
      if (paramFloat <= this.jdField_e_of_type_Float) {
        a(true);
      }
      f1 = 0.0F;
      break label244;
      label322:
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.setTranslationY(f1 + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.getTranslationY());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidViewView.getTranslationY() != 0.0F) {
        this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
      }
      if (this.jdField_b_of_type_AndroidViewView.getAlpha() != 1.0F) {
        a(1.0F);
      }
    }
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidViewView.getTranslationY() != this.jdField_d_of_type_Int) {
        this.jdField_b_of_type_AndroidViewView.setTranslationY(this.jdField_d_of_type_Int);
      }
    } while (this.jdField_b_of_type_AndroidViewView.getAlpha() == 0.0F);
    a(0.0F);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131363968);
    if (paramBoolean) {}
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  private boolean b()
  {
    if (!c())
    {
      SLog.b(i, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!d())
    {
      SLog.b(i, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null)
    {
      SLog.b(i, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = CalloutPopupWindow.a(this.jdField_a_of_type_AndroidContentContext).a(true).a("试试拍个小视频吧").a(16.0F).b(5).a(-1);
      ((CalloutPopupWindow.Builder)localObject).c(50);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new njd(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.c(this.jdField_a_of_type_AndroidViewView, DynamicUnitUtils.a(7.0F), DynamicUnitUtils.a(-5.0F));
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      SLog.a(i, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a(PlayModeUtils.a().getCurrentAccountUin(), "7.6.8".replace(".", ""));
      StoryReportor.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.jdField_c_of_type_Boolean = false;
      ((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    SLog.b(i, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { this.jdField_a_of_type_AndroidViewView, Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(this.jdField_e_of_type_Boolean), Boolean.valueOf(e()), Boolean.valueOf(WorldCupStaticInstance.a().jdField_c_of_type_Boolean) });
    return (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (this.jdField_e_of_type_Boolean) && (e()) && (!WorldCupStaticInstance.a().jdField_c_of_type_Boolean);
  }
  
  private boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      bool1 = bool2;
      if (localRecyclerView != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null) {
          if (((LinearLayoutManager)localRecyclerView.getLayoutManager()).findFirstVisibleItemPosition() != 0) {
            break label64;
          }
        }
      }
    }
    label64:
    for (bool1 = true;; bool1 = false)
    {
      SLog.a(i, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
      return bool1;
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop();
      SLog.a(i, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.isShown()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean));
      bool1 = bool2;
      if (j >= 0)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    SLog.a(i, "isMsgTabVisible %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private void o()
  {
    String str = i;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      SLog.a(str, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(bool));
      p();
      QIMShortVideoUtils.a(BaseApplicationImpl.getContext());
      jdField_b_of_type_Long = SystemClock.uptimeMillis();
      return;
    }
  }
  
  private void p()
  {
    StoryReportor.a("msg_tab", "show_story", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", true, false);
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_Boolean)) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void q()
  {
    StoryReportor.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
        SLog.b(i, "dismissTipWindows() dismiss");
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
        return;
        SLog.b(i, "dismissTipWindows() not showing, not need dismiss()");
      }
    }
    SLog.b(i, "dismissTipWindows() but mTipWindow is null");
  }
  
  private void s()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangRunnable = new nje(this);
      boolean bool = c();
      SLog.a(i, "prepareShowTips can show tips window %b", Boolean.valueOf(bool));
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
      else if (jdField_g_of_type_JavaLangString.equals(localObject))
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
      else if ("debug info".equals(localObject))
      {
        Toast.makeText(paramView, localMsgTabNodeInfo.toString(), 1).show();
        paramView = "";
      }
      else
      {
        if (jdField_h_of_type_JavaLangString.equals(localObject)) {}
        paramView = "";
      }
    }
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int a(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onViewCompleteAfterRefresh, mode:" + this.jdField_f_of_type_Int);
    }
    if (this.jdField_f_of_type_Int == 2) {
      if (paramARMapHongBaoListView.mForStory)
      {
        this.jdField_f_of_type_Int = 3;
        j = -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
      }
    }
    while (this.jdField_f_of_type_Int != 3)
    {
      return j;
      this.jdField_f_of_type_Int = 1;
      return 0;
    }
    return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
  }
  
  public void a()
  {
    if (QQStoryContext.a() == null) {
      return;
    }
    ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(250)).a().c();
    ThreadManager.getUIHandler().post(new njj(this));
  }
  
  void a(float paramFloat)
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setAlpha(paramFloat);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null))
    {
      if (paramInt1 == 2) {
        a(paramInt2, false);
      }
      if (paramInt2 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    Context localContext = paramView.getContext();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemViewType(paramInt);
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramInt);
    Object localObject1;
    Object localObject2;
    if (localMsgTabNodeInfo != null)
    {
      localObject1 = "";
      if (localMsgTabNodeInfo.jdField_a_of_type_Int == 5)
      {
        if (localMsgTabNodeInfo.jdField_c_of_type_Int > 0) {
          localObject1 = "2";
        }
      }
      else
      {
        if (localMsgTabNodeInfo.jdField_b_of_type_Int != 0) {
          break label246;
        }
        localObject2 = "2";
        label73:
        StoryReportor.a("msg_tab", "clk_story", 0, 0, new String[] { localMsgTabNodeInfo.jdField_a_of_type_Int + "", localObject2, localObject1, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
      }
    }
    else
    {
      switch (j)
      {
      default: 
        if (localMsgTabNodeInfo != null) {
          break;
        }
      }
    }
    label246:
    while (!QLog.isDevelopLevel())
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = "1";
              break;
              localObject2 = "1";
              break label73;
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
            } while ((localMsgTabNodeInfo == null) || (UIUtils.b()));
            SLog.b(i, "onItemClick(), unionId=%s, videoCover=%s", localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, localMsgTabNodeInfo.jdField_f_of_type_JavaLangString);
            localObject1 = (ImageView)paramView.findViewById(2131371915);
            if ((paramView instanceof StoryMsgNodeFrameLayout))
            {
              StoryPlayVideoActivity.a((Activity)localContext, ((StoryMsgNodeFrameLayout)paramView).a, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "", false);
              return;
            }
            StoryPlayVideoActivity.a((Activity)localContext, paramView, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, "", false);
            return;
          } while ((!(localContext instanceof Activity)) || (localMsgTabNodeInfo == null) || (TextUtils.isEmpty(localMsgTabNodeInfo.jdField_e_of_type_JavaLangString)));
          localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a();
        } while ((localObject1 == null) || (((List)localObject1).isEmpty()));
        localObject1 = (Activity)localContext;
        localObject2 = (ImageView)paramView.findViewById(2131371915);
        StoryPlayVideoActivity.a((Activity)localObject1, localMsgTabNodeInfo.jdField_e_of_type_JavaLangString, -1, paramView);
        localMsgTabNodeInfo.jdField_b_of_type_Int = 0;
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(localMsgTabNodeInfo);
        }
        RecommendActivityViewHolder.b(localMsgTabNodeInfo);
        return;
        StoryReportor.a("home_page-exp-d4", "5");
        localContext.startActivity(StoryTransitionActivity.a(localContext));
        return;
        localContext.startActivity(StoryMessageListActivity.a(localContext, "1", 3));
        return;
      } while (localMsgTabNodeInfo == null);
      UrlJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, localMsgTabNodeInfo.jdField_d_of_type_JavaLangString, true);
      localMsgTabNodeInfo.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(localMsgTabNodeInfo);
      }
      RecommendActivityViewHolder.b(localMsgTabNodeInfo);
      return;
    }
    QLog.e(i, 2, "发现一个野生的类型: " + localMsgTabNodeInfo.jdField_a_of_type_Int);
  }
  
  public void a(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel()) {
      QLog.i(i, 2, paramDrawerFrame + " initLater " + this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(this);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a != null))
    {
      RecyclerView localRecyclerView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      localRecyclerView.setScrollX(0);
      ((LinearLayoutManager)localRecyclerView.getLayoutManager()).scrollToPosition(0);
      SLog.b(i, "onAccountChanged set Scroll to 0!");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      jdField_g_of_type_Boolean = paramQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("isFriendlistok", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Float == 0.0F) {
      this.jdField_e_of_type_Float = (-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
    }
    float f1 = paramARMapHongBaoListView.getScrollY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
        } while (this.jdField_f_of_type_Int != 1);
        this.jdField_h_of_type_Boolean = true;
        a(false);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
        return;
        if ((!this.jdField_h_of_type_Boolean) && (this.jdField_f_of_type_Int == 1))
        {
          this.jdField_h_of_type_Boolean = true;
          a(false);
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
        }
      } while ((f1 > 0.0F) || (this.jdField_f_of_type_Int != 1));
      a(f1, true);
      return;
    }
    this.jdField_h_of_type_Boolean = false;
    this.jdField_g_of_type_Int = this.jdField_f_of_type_Int;
    if (f1 >= 0.0F)
    {
      if (paramARMapHongBaoListView.mForStory) {
        q();
      }
      this.jdField_f_of_type_Int = 1;
      paramARMapHongBaoListView.mForStory = false;
    }
    for (;;)
    {
      b(paramARMapHongBaoListView.mForStory);
      return;
      if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131363969);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains("刷新成功"))) {}
          for (this.jdField_f_of_type_Int = 3;; this.jdField_f_of_type_Int = 2)
          {
            paramARMapHongBaoListView.mForStory = true;
            break;
            SLog.b(i, "story node start refresh onTouchMoving");
          }
        }
        if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.jdField_f_of_type_Int = 1;
          paramARMapHongBaoListView.mForStory = false;
          q();
        }
      }
      else if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        if (this.jdField_f_of_type_Int != 2)
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          o();
        }
      }
      else if (f1 <= this.jdField_b_of_type_Float)
      {
        if (this.jdField_f_of_type_Int == 2)
        {
          a(false);
        }
        else
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          o();
        }
      }
      else
      {
        this.jdField_f_of_type_Int = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    int j;
    int k;
    do
    {
      return false;
      j = this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getPositionForView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      k = this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getFirstVisiblePosition();
    } while ((j <= k) && ((j != k) || (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getTop() <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight() / 2)));
    return true;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView != null) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getScrollY() != 0))
    {
      SLog.b(i, "interceptDrawer, send touchevent to content view");
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a(paramView, paramMotionEvent);
    }
    paramMotionEvent = i;
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null)
    {
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView == null) {
        break label101;
      }
      label66:
      if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView != null) {
        break label107;
      }
    }
    label101:
    label107:
    for (paramView = "null";; paramView = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getScrollY()))
    {
      SLog.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
      return false;
      bool1 = false;
      break;
      bool2 = false;
      break label66;
    }
  }
  
  public int b(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f1 = paramARMapHongBaoListView.getScrollY();
    if (this.jdField_f_of_type_Int == 1) {
      return 0;
    }
    if (this.jdField_f_of_type_Int == 3) {
      return -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();
    }
    if (this.jdField_f_of_type_Int == 2) {
      return -paramARMapHongBaoListView.getOverScrollHeight();
    }
    return (int)f1;
  }
  
  public void b()
  {
    SLog.c(i, "MsgTab launch()");
    this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.b();
    AssertUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.indexOfChild(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView) >= 0) {
        break label332;
      }
      Object localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131363968);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.addView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView, (ViewGroup.LayoutParams)localObject);
      b(false);
      a(false);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setMaxOverScrollTopDistance(70);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setQQStoryListViewListener(this);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory = true;
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(this);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.b();
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getAdapter().registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      localObject = (StoryConfigManager)SuperManager.a(10);
      this.jdField_c_of_type_Boolean = ((Boolean)((StoryConfigManager)localObject).b("key_msg_tab_show_shot_tips_new", Boolean.valueOf(true))).booleanValue();
      this.jdField_d_of_type_Boolean = ((Boolean)((StoryConfigManager)localObject).b("first_show_node", Boolean.valueOf(true))).booleanValue();
      s();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.addOnLayoutChangeListener(new njn(this, (StoryConfigManager)localObject));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("acc_info" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getBoolean("isFriendlistok", false);
      a();
      this.jdField_a_of_type_Boolean = true;
      return;
      label332:
      if (QLog.isColorLevel()) {
        QLog.d(i, 2, "mChatTopRefresh already added msgNodeView " + this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onScrollStateChanged:" + paramInt + ",mode:" + this.jdField_f_of_type_Int);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getChildCount() > 0)
    {
      if (paramInt != 0) {
        break label97;
      }
      if ((this.jdField_b_of_type_Boolean) && (a()))
      {
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_out", true, false);
      }
    }
    return;
    label97:
    r();
  }
  
  public void b(View paramView, int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemViewType(paramInt);
    String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
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
    int k = arrayOfString.length;
    j = 0;
    label96:
    if (j < k)
    {
      paramView = arrayOfString[j];
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
      j += 1;
      break label96;
      paramView = jdField_d_of_type_JavaLangString;
      continue;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new njo(this, localMsgTabNodeInfo));
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
    SLog.c(i, "MsgTab shutdown()");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.removeView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      b(true);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setMaxOverScrollTopDistance(30);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setQQStoryListViewListener(null);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory = false;
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(null);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.c();
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getAdapter().unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      r();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        QQCatchedExceptionReporter.reportQQCatchedException(localNullPointerException, "QQStoryMsgTabShutdon", "shutdown crash");
      }
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null)
    {
      SLog.b(i, "updateAllFriendNodeItems()");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(6);
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_f_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onDrawerStartMoving");
    }
    r();
  }
  
  public void g()
  {
    this.jdField_f_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onDrawerOpened");
    }
    r();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory) && (a() == 1))
    {
      SLog.b(i, "startBreath() show breathView");
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.d();
      StoryReportor.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    SLog.a(i, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory), Integer.valueOf(a()));
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory) && (!this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.a() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setScrollY(-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory = true;
      this.jdField_f_of_type_Int = 3;
      a(true);
      b(true);
      p();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.g();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mEnableStory) && (this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory))
    {
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setScrollY(0);
      this.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      a(false);
      b(false);
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.b();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.c();
  }
  
  public void l()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onDrawerClosed");
    }
    s();
  }
  
  public void m()
  {
    this.jdField_e_of_type_Boolean = true;
    s();
  }
  
  public void n()
  {
    this.jdField_e_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(i, 2, "onPause");
    }
    r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager
 * JD-Core Version:    0.7.0.1
 */