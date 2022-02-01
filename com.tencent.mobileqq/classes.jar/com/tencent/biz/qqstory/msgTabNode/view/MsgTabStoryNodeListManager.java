package com.tencent.biz.qqstory.msgTabNode.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemClickListener;
import com.tencent.biz.qqstory.common.recyclerview.BaseAdapter.OnItemLongClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.ButtonConfig;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.StoryDebugUtils.StoryExceptionCallback;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.activity.recent.DrawerFrame.StoryTouchEventInterceptor;
import com.tencent.mobileqq.activity.recent.bannerprocessor.PushBannerProcessor;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.portal.BreathEffectView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.widget.ARMapHongBaoListView;
import com.tencent.widget.ARMapHongBaoListView.QQStoryListViewListener;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ListView;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class MsgTabStoryNodeListManager
  implements BaseAdapter.OnItemClickListener, BaseAdapter.OnItemLongClickListener, DrawerFrame.StoryTouchEventInterceptor, ARMapHongBaoListView.QQStoryListViewListener, ActionSheet.OnButtonClickListener
{
  public static String a;
  private static HashMap<Integer, String[]> jdField_a_of_type_JavaUtilHashMap;
  public static long b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static boolean h;
  private static String jdField_i_of_type_JavaLangString;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  View jdField_a_of_type_AndroidViewView;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new MsgTabStoryNodeListManager.4(this);
  private DotAnimationView jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView;
  public MsgNodeShotView a;
  MsgTabStoryNodeAdapter jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter;
  MsgTabStoryNodeDelegate jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate;
  public MsgTabStoryNodeListManager.MsgTabShowCounter a;
  MsgTabStoryNodeView jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityHomeConversation;
  private DrawerFrame jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new MsgTabStoryNodeListManager.3(this);
  public QQAppInterface a;
  protected GetRedPointExObserver a;
  private BreathEffectView jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  ARMapHongBaoListView jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  CalloutPopupWindow jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
  Runnable jdField_a_of_type_JavaLangRunnable = new MsgTabStoryNodeListManager.11(this);
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 30;
  private View jdField_b_of_type_AndroidViewView;
  private Runnable jdField_b_of_type_JavaLangRunnable = new MsgTabStoryNodeListManager.1(this);
  boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 70;
  private long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  boolean jdField_e_of_type_Boolean = false;
  private int f;
  public boolean f;
  private int g;
  public boolean g;
  boolean jdField_i_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131706998);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131707002);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131707000);
    jdField_d_of_type_JavaLangString = HardCodeUtil.a(2131707007);
    jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131706999);
    jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131707003);
    jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131707004);
    jdField_h_of_type_JavaLangString = HardCodeUtil.a(2131707006);
    jdField_i_of_type_JavaLangString = "Q.qqstory.msgTab.MsgTabStoryNodeListManager";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), new String[] { jdField_a_of_type_JavaLangString, jdField_b_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(6), new String[] { jdField_a_of_type_JavaLangString, jdField_c_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(7), new String[] { jdField_a_of_type_JavaLangString, jdField_e_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(9), new String[] { jdField_a_of_type_JavaLangString, jdField_d_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), new String[] { jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(10), new String[] { jdField_g_of_type_JavaLangString });
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), new String[] { jdField_a_of_type_JavaLangString, jdField_g_of_type_JavaLangString });
    jdField_h_of_type_Boolean = false;
    jdField_b_of_type_Long = 0L;
  }
  
  public MsgTabStoryNodeListManager(Context paramContext, Conversation paramConversation, ListView paramListView, PullRefreshHeader paramPullRefreshHeader, DrawerFrame paramDrawerFrame, BreathEffectView paramBreathEffectView)
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_f_of_type_Int = 1;
    this.jdField_g_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new MsgTabStoryNodeListManager.2(this);
    AssertUtils.assertNotNull_DEBUG(paramPullRefreshHeader);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramConversation.a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation = paramConversation;
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView = ((ARMapHongBaoListView)paramListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = paramPullRefreshHeader;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView = new MsgTabStoryNodeView(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView = paramBreathEffectView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131377922);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView = ((DotAnimationView)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.findViewById(2131365812));
    this.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)this.jdField_a_of_type_AndroidContentContext.getSystemService("vibrator"));
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter = new MsgTabStoryNodeAdapter(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView = new MsgNodeShotView(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView;
    q();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.setLayoutParams(new RecyclerView.LayoutParams(AIOUtils.b(67.0F, this.jdField_b_of_type_AndroidViewView.getResources()), AIOUtils.b(102.0F, this.jdField_b_of_type_AndroidViewView.getResources())));
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate = new MsgTabStoryNodeDelegate(this, this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.setOnScrollListener(new MsgTabStoryNodeListManager.6(this));
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new MsgTabStoryNodeListManager.7(this);
    this.jdField_b_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_c_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -50.0F);
    this.jdField_d_of_type_Float = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -120.0F);
    this.jdField_d_of_type_Int = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -80.0F);
    this.jdField_e_of_type_Int = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
    AbstractGifImage.resumeAll();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_i_of_type_JavaLangString, 2, "on create");
    }
  }
  
  private void a(float paramFloat, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.jdField_g_of_type_Int != 3)) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a(paramFloat);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 4, String.format("fight..doOnScroll.scrollY:%f,offset_node_scrll:%f,offset_scroll_over:%f", new Object[] { Float.valueOf(paramFloat), Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(this.jdField_e_of_type_Float) }));
    }
    float f1 = this.jdField_c_of_type_Float;
    float f2 = 0.0F;
    if (paramFloat <= f1)
    {
      float f3 = this.jdField_e_of_type_Float;
      if (paramFloat > f3)
      {
        f2 = this.jdField_d_of_type_Float;
        if (paramFloat <= f2)
        {
          f3 = (f2 - paramFloat) / (f2 - f3);
          f1 = this.jdField_d_of_type_Int + (f1 - f2) * 1.0F;
          f1 -= f3 * f1 * 1.5F;
        }
        else
        {
          f1 = this.jdField_d_of_type_Int + (f1 - paramFloat) * 1.0F;
        }
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY();
        this.jdField_b_of_type_AndroidViewView.setTranslationY(f1);
        f1 = this.jdField_b_of_type_AndroidViewView.getTranslationY();
        int j = this.jdField_d_of_type_Int;
        if (f1 < j) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(j);
        }
        if (this.jdField_b_of_type_AndroidViewView.getTranslationY() > 0.0F) {
          this.jdField_b_of_type_AndroidViewView.setTranslationY(0.0F);
        }
        f2 = this.jdField_b_of_type_AndroidViewView.getTranslationY() - f2;
        a(1.0F - this.jdField_b_of_type_AndroidViewView.getTranslationY() / this.jdField_d_of_type_Int + 0.8F);
        f1 = f2;
        if (this.jdField_a_of_type_AndroidOsVibrator == null) {
          break label337;
        }
        f1 = f2;
        if (this.jdField_a_of_type_Float <= this.jdField_c_of_type_Float) {
          break label337;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
        f1 = f2;
        break label337;
      }
    }
    f1 = f2;
    if (paramFloat <= this.jdField_e_of_type_Float)
    {
      a(true);
      f1 = f2;
    }
    label337:
    DotAnimationView localDotAnimationView;
    if (paramFloat > UIUtils.a(this.jdField_a_of_type_AndroidContentContext, -75.0F))
    {
      localDotAnimationView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView;
      localDotAnimationView.setTranslationY((localDotAnimationView.getHeight() + paramFloat) / 2.0F);
    }
    else
    {
      localDotAnimationView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView;
      localDotAnimationView.setTranslationY(localDotAnimationView.getTranslationY() + f1);
    }
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  private void a(Context paramContext)
  {
    Object localObject = new QQStoryMainActivity.ButtonConfig("mainHallConfig");
    String str;
    if ((!TextUtils.isEmpty(((QQStoryMainActivity.ButtonConfig)localObject).jdField_c_of_type_JavaLangString)) && (HttpUtil.isValidUrl(((QQStoryMainActivity.ButtonConfig)localObject).jdField_c_of_type_JavaLangString))) {
      str = ((QQStoryMainActivity.ButtonConfig)localObject).jdField_c_of_type_JavaLangString;
    } else {
      str = "https://story.now.qq.com/mobile/find.html?_wv=3&_bid=2542";
    }
    if ((((QQStoryMainActivity.ButtonConfig)localObject).jdField_a_of_type_Int != 0) && (((QQStoryMainActivity.ButtonConfig)localObject).jdField_a_of_type_Int != 1))
    {
      if (((QQStoryMainActivity.ButtonConfig)localObject).jdField_a_of_type_Int == 2) {
        return;
      }
      int j = ((QQStoryMainActivity.ButtonConfig)localObject).jdField_a_of_type_Int;
      return;
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", str);
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(View paramView, Activity paramActivity, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo.jdField_a_of_type_Int == 12)
    {
      paramMsgTabNodeInfo.jdField_i_of_type_JavaLangString = "";
      paramMsgTabNodeInfo = new OpenPlayerBuilder(new MsgTabPlayInfo(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, 0, null, paramMsgTabNodeInfo.jdField_f_of_type_JavaLangString, paramMsgTabNodeInfo.jdField_e_of_type_JavaLangString), 106);
      paramMsgTabNodeInfo.a(a());
      paramMsgTabNodeInfo = paramMsgTabNodeInfo.a();
      paramMsgTabNodeInfo.mUIStyle.bottomWidgetShowFlag = 3;
      if ((paramView instanceof StoryMsgNodeFrameLayout))
      {
        StoryPlayerLauncher.a(paramActivity, paramMsgTabNodeInfo, ((StoryMsgNodeFrameLayout)paramView).a);
        return;
      }
      StoryPlayerLauncher.a(paramActivity, paramMsgTabNodeInfo, paramView);
      return;
    }
    MsgTabNodeVidListPullSegment localMsgTabNodeVidListPullSegment = new MsgTabNodeVidListPullSegment(jdField_i_of_type_JavaLangString);
    localMsgTabNodeVidListPullSegment.jdField_a_of_type_Boolean = true;
    Stream.of(paramMsgTabNodeInfo).map(new ThreadOffFunction(jdField_i_of_type_JavaLangString, 2)).map(localMsgTabNodeVidListPullSegment).map(new MsgTabNodeInsertLocalVideoInfoSegment(paramMsgTabNodeInfo)).map(new UIThreadOffFunction(null)).subscribe(new MsgTabStoryNodeListManager.9(this, paramMsgTabNodeInfo, paramView, paramActivity));
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
      localMessage = Message.obtain();
      localMessage.what = 2003;
      localMessage.getData().putBoolean("isStoryShow", true);
      localMessage.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
      localMessage = Message.obtain();
      localMessage.what = 2002;
      localMessage.getData().putBoolean("visible", false);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
      return;
    }
    float f1 = this.jdField_b_of_type_AndroidViewView.getTranslationY();
    int j = this.jdField_d_of_type_Int;
    if (f1 != j) {
      this.jdField_b_of_type_AndroidViewView.setTranslationY(j);
    }
    if (this.jdField_b_of_type_AndroidViewView.getAlpha() != 0.0F) {
      a(0.0F);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2003;
    localMessage.getData().putBoolean("isStoryShow", false);
    localMessage.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
    BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
    localMessage = Message.obtain();
    localMessage.what = 2002;
    localMessage.getData().putBoolean("visible", true);
    BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
  }
  
  private void b(boolean paramBoolean)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131376339);
    int j;
    if (paramBoolean) {
      j = 0;
    } else {
      j = 8;
    }
    localView.setVisibility(j);
  }
  
  private boolean b()
  {
    MsgTabStoryNodeView localMsgTabStoryNodeView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    if (localMsgTabStoryNodeView != null)
    {
      if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
        return false;
      }
      int[] arrayOfInt1 = new int[2];
      int[] arrayOfInt2 = new int[2];
      localMsgTabStoryNodeView.getLocationInWindow(arrayOfInt1);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getLocationInWindow(arrayOfInt2);
      return (arrayOfInt1[1] >= arrayOfInt2[1]) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getScrollY() < 0) && (this.jdField_f_of_type_Int == 3);
    }
    return false;
  }
  
  private boolean c()
  {
    if (!d())
    {
      SLog.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() canShowTipsWindows() == false");
      return false;
    }
    if (!e())
    {
      SLog.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() isShotViewVisible() == false");
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow == null)
    {
      SLog.b(jdField_i_of_type_JavaLangString, "showTipWindowForShot() mTipWindow == null, so create it!");
      localObject = CalloutPopupWindow.a(this.jdField_a_of_type_AndroidContentContext).a(true).a(HardCodeUtil.a(2131707005)).a(16.0F).b(5).a(-1);
      ((CalloutPopupWindow.Builder)localObject).c(50);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject).b(Color.argb(255, 0, 0, 0)).a(5).a().b(5).a();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(82);
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.a(new MsgTabStoryNodeListManager.14(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing())
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.b(this.jdField_a_of_type_AndroidViewView, AIOUtils.b(7.0F, this.jdField_b_of_type_AndroidViewView.getResources()), AIOUtils.b(-5.0F, this.jdField_b_of_type_AndroidViewView.getResources()));
      localObject = new Rect();
      this.jdField_a_of_type_AndroidViewView.getGlobalVisibleRect((Rect)localObject);
      SLog.a(jdField_i_of_type_JavaLangString, "showTipWindowForShot() is not showing, so show it!, %s", ((Rect)localObject).toShortString());
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a(PlayModeUtils.a().getCurrentAccountUin(), "8.7.0".replace(".", ""));
      StoryReportor.a("msg_tab", "exp_tips", 0, 0, new String[] { "1", "", "", "" });
      this.jdField_c_of_type_Boolean = false;
      ((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_shot_tips_new", Boolean.valueOf(false));
      return true;
    }
    return false;
  }
  
  private boolean d()
  {
    String str = jdField_i_of_type_JavaLangString;
    View localView = this.jdField_a_of_type_AndroidViewView;
    boolean bool2 = false;
    SLog.b(str, "canShowTipsWindows: mShotView %s, mIsNeedShowTip %b, mRunning %b, mIsDrawerOpened %b, mIsConversationTabShow %b, isMsgTabVisible %b, SplashShowing %s", new Object[] { localView, Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_g_of_type_Boolean), Boolean.valueOf(this.jdField_f_of_type_Boolean), Boolean.valueOf(f()), Boolean.valueOf(false) });
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool1 = bool2;
      if (this.jdField_c_of_type_Boolean)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Boolean)
        {
          bool1 = bool2;
          if (!this.jdField_g_of_type_Boolean)
          {
            bool1 = bool2;
            if (this.jdField_f_of_type_Boolean)
            {
              bool1 = bool2;
              if (f()) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((MsgTabStoryNodeView)localObject).a;
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter != null)
        {
          bool1 = bool2;
          if (((LinearLayoutManager)((RecyclerView)localObject).getLayoutManager()).findFirstVisibleItemPosition() == 0) {
            bool1 = true;
          }
        }
      }
    }
    SLog.a(jdField_i_of_type_JavaLangString, "isShotViewVisible result = %b", Boolean.valueOf(bool1));
    return bool1;
  }
  
  private boolean f()
  {
    MsgTabStoryNodeView localMsgTabStoryNodeView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    if (localMsgTabStoryNodeView != null)
    {
      int j = localMsgTabStoryNodeView.getTop();
      SLog.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible top=%d isShown=%b detached=%b", Integer.valueOf(j), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.isShown()), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean));
      if ((j >= 0) && (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean))
      {
        bool = true;
        break label68;
      }
    }
    boolean bool = false;
    label68:
    SLog.a(jdField_i_of_type_JavaLangString, "isMsgTabVisible %b", Boolean.valueOf(bool));
    return bool;
  }
  
  private void m()
  {
    SLog.a(jdField_i_of_type_JavaLangString, "onNodeScrollOut(), is storyView attached? %b", Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_b_of_type_Boolean ^ true));
    StoryReportor.a("msg_tab", "show_story", 0, 0, new String[0]);
    n();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", 6);
    jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_JavaLangRunnable != null) && (this.jdField_c_of_type_Boolean)) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    }
    ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext());
  }
  
  private void o()
  {
    StoryReportor.a("msg_tab", "hide_story", 0, 0, new String[0]);
  }
  
  private void p()
  {
    CalloutPopupWindow localCalloutPopupWindow = this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow;
    if (localCalloutPopupWindow != null)
    {
      if (localCalloutPopupWindow.isShowing())
      {
        this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
        SLog.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() dismiss");
      }
      else
      {
        SLog.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() not showing, not need dismiss()");
      }
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
      return;
    }
    SLog.b(jdField_i_of_type_JavaLangString, "dismissTipWindows() but mTipWindow is null");
  }
  
  private void q()
  {
    QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a();
    if (localQBaseActivity != null)
    {
      this.jdField_e_of_type_Boolean = localQBaseActivity.getIntent().getBooleanExtra("show_story_msg_tab", false);
      if (this.jdField_e_of_type_Boolean) {
        localQBaseActivity.getIntent().putExtra("show_story_msg_tab", false);
      }
    }
  }
  
  private void r()
  {
    q();
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.16(this));
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    Object localObject = this.jdField_a_of_type_ComTencentWidgetActionSheet.getActionMenuItem(paramInt);
    if (localObject == null) {
      return;
    }
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(((ActionMenuItem)localObject).action);
    if (localMsgTabNodeInfo == null) {
      return;
    }
    paramView = this.jdField_a_of_type_AndroidContentContext;
    localObject = ((ActionMenuItem)localObject).content;
    if (jdField_a_of_type_JavaLangString.equals(localObject))
    {
      if ((6 != localMsgTabNodeInfo.jdField_a_of_type_Int) && (7 != localMsgTabNodeInfo.jdField_a_of_type_Int) && (9 != localMsgTabNodeInfo.jdField_a_of_type_Int) && (5 != localMsgTabNodeInfo.jdField_a_of_type_Int))
      {
        if (8 == localMsgTabNodeInfo.jdField_a_of_type_Int) {
          QQStoryShareGroupProfileActivity.a(paramView, 2, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, String.valueOf(localMsgTabNodeInfo.jdField_b_of_type_Long), 17, 0);
        } else if (12 == localMsgTabNodeInfo.jdField_a_of_type_Int) {
          a(paramView);
        }
      }
      else {
        QQStoryMemoriesActivity.a(paramView, 26, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, false);
      }
      paramView = "1";
    }
    else if (jdField_b_of_type_JavaLangString.equals(localObject))
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
    else
    {
      if ("debug info".equals(localObject)) {
        Toast.makeText(paramView, localMsgTabNodeInfo.toString(), 1).show();
      } else {
        jdField_h_of_type_JavaLangString.equals(localObject);
      }
      paramView = "";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localMsgTabNodeInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { ((StringBuilder)localObject).toString(), paramView, "", localMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
  }
  
  public String a()
  {
    return String.valueOf(hashCode());
  }
  
  protected void a()
  {
    if (QQStoryContext.a() == null) {
      return;
    }
    ((MsgTabStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().b();
    ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.5(this));
  }
  
  void a(float paramFloat)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setAlpha(paramFloat);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(View paramView, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(DrawerFrame paramDrawerFrame)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_i_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramDrawerFrame);
      localStringBuilder.append(" initLater ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame = paramDrawerFrame;
    paramDrawerFrame = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
    if (paramDrawerFrame != null) {
      paramDrawerFrame.setStoryTouchEventInterceptor(this);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.d();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    if ((localObject != null) && (((MsgTabStoryNodeView)localObject).a != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a;
      ((RecyclerView)localObject).setScrollX(0);
      ((LinearLayoutManager)((RecyclerView)localObject).getLayoutManager()).scrollToPosition(0);
      SLog.b(jdField_i_of_type_JavaLangString, "onAccountChanged set Scroll to 0!");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      localObject = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("acc_info");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      jdField_h_of_type_Boolean = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("isFriendlistok", false);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (!this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getListViewScrollY() == 0))
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setScrollY(-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = true;
      this.jdField_f_of_type_Int = 3;
      a(true);
      b(true);
      n();
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.f();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager$MsgTabShowCounter.a();
      return true;
    }
    return false;
  }
  
  public void b()
  {
    SLog.c(jdField_i_of_type_JavaLangString, "MsgTab launch()");
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager$MsgTabShowCounter = new MsgTabStoryNodeListManager.MsgTabShowCounter();
    AssertUtils.checkNotNull(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
    Object localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (localObject2 != null) {
        if (((PullRefreshHeader)localObject2).indexOfChild((View)localObject1) < 0)
        {
          localObject1 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131376339);
          this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.addView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView, (ViewGroup.LayoutParams)localObject1);
          b(false);
          a(false);
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setMaxOverScrollTopDistance(70);
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setQQStoryListViewListener(this);
          localObject1 = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
          ((ARMapHongBaoListView)localObject1).mEnableStory = true;
          ((ARMapHongBaoListView)localObject1).mForStory = false;
          this.jdField_f_of_type_Int = 1;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame;
          if (localObject1 != null) {
            ((DrawerFrame)localObject1).setStoryTouchEventInterceptor(this);
          }
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.b();
          this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
          localObject1 = (StoryConfigManager)SuperManager.a(10);
          this.jdField_d_of_type_Boolean = ((Boolean)((StoryConfigManager)localObject1).b("first_show_node", Boolean.valueOf(true))).booleanValue();
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.addOnLayoutChangeListener(new MsgTabStoryNodeListManager.8(this, (StoryConfigManager)localObject1));
        }
        else if (QLog.isColorLevel())
        {
          localObject1 = jdField_i_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mChatTopRefresh already added msgNodeView ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("acc_info");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    jdField_h_of_type_Boolean = ((BaseApplication)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getBoolean("isFriendlistok", false);
    a();
    this.jdField_a_of_type_Boolean = true;
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2003;
    ((Message)localObject1).getData().putBoolean("isStoryShow", true);
    ((Message)localObject1).getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
    BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, (Message)localObject1);
    localObject1 = Message.obtain();
    ((Message)localObject1).what = 2002;
    ((Message)localObject1).getData().putBoolean("visible", false);
    BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, (Message)localObject1);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_i_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mode:");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(View paramView, int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.getItemViewType(paramInt);
    String[] arrayOfString = (String[])jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(j));
    MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.a(paramInt);
    if (localMsgTabNodeInfo == null) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if ((paramView != null) && (paramView.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      int k = arrayOfString.length;
      j = 0;
      while (j < k)
      {
        String str = arrayOfString[j];
        if (!jdField_d_of_type_JavaLangString.equals(str))
        {
          paramView = str;
          if (!jdField_e_of_type_JavaLangString.equals(str)) {}
        }
        else
        {
          QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).b(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
          paramView = str;
          if (localQQUserUIItem != null) {
            if (localQQUserUIItem.isSubscribe()) {
              paramView = jdField_e_of_type_JavaLangString;
            } else {
              paramView = jdField_d_of_type_JavaLangString;
            }
          }
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(new ActionMenuItem(paramView, paramInt, 0), 5);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new MsgTabStoryNodeListManager.10(this, localMsgTabNodeInfo));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      if (localMsgTabNodeInfo != null)
      {
        paramView = new StringBuilder();
        paramView.append(localMsgTabNodeInfo.jdField_a_of_type_Int);
        paramView.append("");
        StoryReportor.a("msg_tab", "press_story", 0, 0, new String[] { paramView.toString(), "", "", localMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
      }
    }
  }
  
  public void c()
  {
    SLog.c(jdField_i_of_type_JavaLangString, "MsgTab shutdown()");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.removeView(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView);
      b(true);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setMaxOverScrollTopDistance(30);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setQQStoryListViewListener(null);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.scrollTo(0, 0);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory = false;
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame.setStoryTouchEventInterceptor(null);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.c();
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getAdapter().unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      p();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
      Message localMessage = Message.obtain();
      localMessage.what = 2003;
      localMessage.getData().putBoolean("isStoryShow", false);
      localMessage.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
      localMessage = Message.obtain();
      localMessage.what = 2002;
      localMessage.getData().putBoolean("visible", true);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, localMessage);
    }
    catch (NullPointerException localNullPointerException)
    {
      CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.b("QQStoryMsgTabShutdown, Null", localNullPointerException), "QQStoryMsgTabShutdown NullPointerException");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate != null)
    {
      SLog.b(jdField_i_of_type_JavaLangString, "updateAllFriendNodeItems()");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a(6);
    }
  }
  
  public void e()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerStartMoving");
    }
    p();
  }
  
  public void f()
  {
    this.jdField_g_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerOpened");
    }
    p();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (getMode() == 1))
    {
      SLog.b(jdField_i_of_type_JavaLangString, "startBreath() show breathView");
      this.jdField_a_of_type_ComTencentMobileqqPortalBreathEffectView.c();
      StoryReportor.a("msg_tab", "exp_newpub", 0, 0, new String[0]);
      return;
    }
    SLog.a(jdField_i_of_type_JavaLangString, "startBreath() not show enableStory=%b, mode=%d", Boolean.valueOf(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory), Integer.valueOf(getMode()));
  }
  
  public int getMode()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public int getSpringbackOffset(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    float f1 = paramARMapHongBaoListView.getScrollY();
    int j = this.jdField_f_of_type_Int;
    if (j == 1) {
      return 0;
    }
    if (j == 3) {}
    for (j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();; j = paramARMapHongBaoListView.getOverScrollHeight())
    {
      return -j;
      if (j != 2) {
        break;
      }
    }
    return (int)f1;
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setScrollY(0);
      this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory = false;
      this.jdField_f_of_type_Int = 1;
      a(false);
      b(false);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.b();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgNodeShotView.c();
  }
  
  public boolean interceptDrawer(View paramView, MotionEvent paramMotionEvent)
  {
    if (b()) {
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a(paramView, paramMotionEvent);
    }
    paramMotionEvent = jdField_i_of_type_JavaLangString;
    paramView = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView;
    boolean bool2 = true;
    boolean bool1;
    if (paramView != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
      bool2 = false;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView;
    if (paramView == null) {
      paramView = "null";
    } else {
      paramView = Integer.valueOf(paramView.getScrollY());
    }
    SLog.a(paramMotionEvent, "interceptDrawer error. contentView:%s, listView:%s, scrollY:%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramView);
    return false;
  }
  
  public void j()
  {
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onDrawerClosed");
    }
  }
  
  public void k()
  {
    this.jdField_f_of_type_Boolean = true;
    AbstractGifImage.resumeAll();
    MsgTabStoryNodeAdapter localMsgTabStoryNodeAdapter = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeAdapter;
    if ((localMsgTabStoryNodeAdapter != null) && (this.jdField_a_of_type_Boolean)) {
      localMsgTabStoryNodeAdapter.notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onResume");
    }
    r();
  }
  
  public void l()
  {
    this.jdField_f_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onPause");
    }
    p();
    AbstractGifImage.pauseAll();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_i_of_type_JavaLangString, 2, "onPause");
    }
  }
  
  public void onFlingScrollHeader(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mEnableStory) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView != null))
    {
      if (paramInt1 == 2) {
        a(paramInt2, false);
      }
      if (paramInt2 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
        return;
      }
      StringBuilder localStringBuilder;
      if ((!this.jdField_i_of_type_Boolean) && (paramInt2 >= 0))
      {
        if (QLog.isDevelopLevel())
        {
          localObject = jdField_i_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("fight...onFlingScrollHeader1..scrollY = ");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append(",flag = ");
          localStringBuilder.append(this.jdField_i_of_type_Boolean);
          QLog.d((String)localObject, 4, localStringBuilder.toString());
        }
        localObject = Message.obtain();
        ((Message)localObject).what = 2003;
        ((Message)localObject).getData().putBoolean("isStoryShow", false);
        ((Message)localObject).getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
        BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, (Message)localObject);
        localObject = Message.obtain();
        ((Message)localObject).what = 2002;
        ((Message)localObject).getData().putBoolean("visible", true);
        BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, (Message)localObject);
        return;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = jdField_i_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("fight...onFlingScrollHeader2..scrollY = ");
        localStringBuilder.append(paramInt2);
        QLog.d((String)localObject, 4, localStringBuilder.toString());
      }
      Object localObject = Message.obtain();
      ((Message)localObject).what = 2001;
      ((Message)localObject).getData().putFloat("height", paramInt2);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, (Message)localObject);
    }
  }
  
  public void onTouchMoving(ARMapHongBaoListView paramARMapHongBaoListView, boolean paramBoolean, MotionEvent paramMotionEvent)
  {
    if (this.jdField_e_of_type_Float == 0.0F) {
      this.jdField_e_of_type_Float = (-this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight());
    }
    float f1 = paramARMapHongBaoListView.getScrollY();
    int j = paramMotionEvent.getAction() & 0xFF;
    if (j != 0)
    {
      if (j != 1) {
        if (j != 2)
        {
          if (j == 3) {}
        }
        else
        {
          if ((!this.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Int == 1))
          {
            this.jdField_i_of_type_Boolean = true;
            a(false);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
            paramARMapHongBaoListView = Message.obtain();
            paramARMapHongBaoListView.what = 2003;
            paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
            paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
            BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, paramARMapHongBaoListView);
          }
          if ((f1 <= 0.0F) && (this.jdField_f_of_type_Int == 1))
          {
            a(f1, true);
            return;
          }
          if (f1 >= 0.0F) {
            return;
          }
          if (QLog.isDevelopLevel())
          {
            paramARMapHongBaoListView = jdField_i_of_type_JavaLangString;
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("fight...onTouchMoving.onMove..scrollY = ");
            paramMotionEvent.append(f1);
            QLog.d(paramARMapHongBaoListView, 4, paramMotionEvent.toString());
          }
          paramARMapHongBaoListView = Message.obtain();
          paramARMapHongBaoListView.what = 2001;
          paramARMapHongBaoListView.getData().putFloat("height", f1);
          BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, paramARMapHongBaoListView);
          return;
        }
      }
      this.jdField_i_of_type_Boolean = false;
      this.jdField_g_of_type_Int = this.jdField_f_of_type_Int;
      if (f1 >= 0.0F)
      {
        if (paramARMapHongBaoListView.mForStory) {
          o();
        }
        this.jdField_f_of_type_Int = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      else if (paramARMapHongBaoListView.mForStory)
      {
        if (f1 <= -paramARMapHongBaoListView.getOverScrollHeight())
        {
          paramMotionEvent = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.findViewById(2131376344);
          if ((paramMotionEvent.getText().toString() != null) && (paramMotionEvent.getText().toString().contains(HardCodeUtil.a(2131706995))))
          {
            this.jdField_f_of_type_Int = 3;
          }
          else
          {
            SLog.b(jdField_i_of_type_JavaLangString, "story node start refresh onTouchMoving");
            this.jdField_f_of_type_Int = 2;
          }
          paramARMapHongBaoListView.mForStory = true;
        }
        else if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
        }
        else
        {
          this.jdField_f_of_type_Int = 1;
          paramARMapHongBaoListView.mForStory = false;
          o();
        }
      }
      else if (f1 <= -this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
      {
        if (this.jdField_f_of_type_Int != 2)
        {
          this.jdField_f_of_type_Int = 3;
          paramARMapHongBaoListView.mForStory = true;
          m();
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
          m();
        }
      }
      else
      {
        this.jdField_f_of_type_Int = 1;
        paramARMapHongBaoListView.mForStory = false;
      }
      b(paramARMapHongBaoListView.mForStory);
      if (QLog.isDevelopLevel())
      {
        paramARMapHongBaoListView = jdField_i_of_type_JavaLangString;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("fight...onTouchMoving.onUp..scrollY = ");
        paramMotionEvent.append(f1);
        QLog.d(paramARMapHongBaoListView, 4, paramMotionEvent.toString());
      }
      if (f1 >= 0.0F)
      {
        paramARMapHongBaoListView = Message.obtain();
        paramARMapHongBaoListView.what = 2003;
        paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
        paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
        BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, paramARMapHongBaoListView);
      }
    }
    else if (this.jdField_f_of_type_Int == 1)
    {
      this.jdField_i_of_type_Boolean = true;
      a(false);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewDotAnimationView.a();
      paramARMapHongBaoListView = Message.obtain();
      paramARMapHongBaoListView.what = 2003;
      paramARMapHongBaoListView.getData().putBoolean("isStoryShow", false);
      paramARMapHongBaoListView.getData().putFloat("nodeOffset", this.jdField_c_of_type_Float);
      BannerManager.a().b(PushBannerProcessor.jdField_a_of_type_Int, paramARMapHongBaoListView);
    }
  }
  
  public int onViewCompleteAfterRefresh(ARMapHongBaoListView paramARMapHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_i_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onViewCompleteAfterRefresh, mode:");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    int j = this.jdField_f_of_type_Int;
    if (j == 2) {
      if (paramARMapHongBaoListView.mForStory) {
        this.jdField_f_of_type_Int = 3;
      }
    }
    for (j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight();; j = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.getHeight())
    {
      return -j;
      this.jdField_f_of_type_Int = 1;
      return 0;
      if (j != 3) {
        break;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager
 * JD-Core Version:    0.7.0.1
 */