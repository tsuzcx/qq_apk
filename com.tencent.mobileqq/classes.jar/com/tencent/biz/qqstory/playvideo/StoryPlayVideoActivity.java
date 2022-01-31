package com.tencent.biz.qqstory.playvideo;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryPublishParams;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.AnimationUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer;
import com.tencent.biz.qqstory.videoplayer.StoryVideoPlayer.OnCloseListener;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout.OnDraggingListener;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealCompatLayout;
import com.tencent.biz.qqstory.widget.circularreveal.ViewAnimationCompatUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import nob;
import noc;
import nod;
import nof;
import nog;
import noh;
import noi;

public class StoryPlayVideoActivity
  extends QQStoryBaseActivity
  implements StoryVideoPlayer.OnCloseListener, DragFrameLayout.OnDraggingListener
{
  protected int a;
  public long a;
  protected Animator a;
  protected AudioManager.OnAudioFocusChangeListener a;
  protected AudioManager a;
  protected Bundle a;
  public Handler a;
  public View a;
  public ImageView a;
  public RelativeLayout a;
  public CustomViewPager a;
  public StoryVideoPlayer a;
  protected DragFrameLayout a;
  public CircularRevealCompatLayout a;
  boolean a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  int f;
  public int g;
  public int h;
  
  public StoryPlayVideoActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new noi(this);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 15);
    localIntent.putExtra("EXTRA_USER_UIN", String.valueOf(paramLong));
    localIntent.putExtra("extra_collection_key", paramString1);
    localIntent.putExtra("extra_share_time_zone", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid", paramString2);
    localIntent.putExtra("extra_identify", paramInt3);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (localStoryVideoItem.mInteractStatus != -1) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      a(paramActivity, paramString1, paramLong, 16, false, -1, paramInt1, paramString2, paramInt2);
      return;
    }
    PlayModeUtils.a(QQStoryContext.a(), paramActivity, paramString1, 16, false, -1, paramInt1, paramString2, paramInt2);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 6);
    localIntent.putExtra("extra_topic_id", paramLong);
    localIntent.putExtra("extra_topic_name", paramString);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 13);
    localIntent.putExtra("EXTRA_USER_UIN", String.valueOf(paramLong));
    localIntent.putExtra("extra_default_title", paramString2);
    localIntent.putExtra("extra_share_time", paramString1);
    localIntent.putExtra("need_image_animation", false);
    localIntent.putExtra("extra_share_time_zone", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid", paramString3);
    localIntent.putExtra("extra_identify", paramInt3);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 41);
    localIntent.putExtra("extra_discover_banner_id", paramString);
    localIntent.putExtra("extra_share_from_type", 102);
    if (paramView != null)
    {
      AnimationUtils.a(paramActivity, localIntent, paramView);
      return;
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 2131034167);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 46);
    if (paramBoolean) {
      localIntent.putExtra("extra_share_from_type", 111);
    }
    for (;;)
    {
      localIntent.putExtra("extra_msgtab_click_node", paramString1);
      localIntent.putExtra("extra_default_cover", paramString2);
      localIntent.putExtra("extra_msgtab_from_halo", paramBoolean);
      AnimationUtils.b(paramActivity, localIntent, paramView);
      return;
      localIntent.putExtra("extra_share_from_type", 106);
    }
  }
  
  public static void a(Activity paramActivity, View paramView, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 34);
    localIntent.putParcelableArrayListExtra("extra_discover_card_list", paramArrayList);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    if (paramView != null)
    {
      AnimationUtils.a(paramActivity, localIntent, paramView);
      return;
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 2131034167);
  }
  
  public static void a(Activity paramActivity, View paramView, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 28);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramArrayList1);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid_list", paramArrayList2);
    localIntent.putExtra("extra_story_type", paramInt3);
    if (paramView != null)
    {
      AnimationUtils.a(paramActivity, localIntent, paramView);
      return;
    }
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 2131034167);
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 36);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString1);
    localIntent.putExtra("extra_share_time_zone", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid", paramString2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 49);
    localIntent.putExtra("extra_share_from_type", 107);
    localIntent.putExtra("extra_story_type", paramInt);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", localArrayList);
    AnimationUtils.b(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString1, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", paramInt1);
    localIntent.putExtra("extra_video_id", paramString1);
    localIntent.putExtra("EXTRA_USER_UIN", String.valueOf(paramLong));
    localIntent.putExtra("extra_is_open_watchlist", paramBoolean);
    localIntent.putExtra("extra_target_comment_id", paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", localArrayList);
    localIntent.putExtra("need_image_animation", false);
    localIntent.putExtra("extra_share_from_type", paramInt3);
    localIntent.putExtra("extra_feedid", paramString2);
    localIntent.putExtra("extra_identify", paramInt4);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 33);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString1);
    localIntent.putExtra("extra_feedid", paramString2);
    localIntent.putExtra("extra_identify", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 15);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString1);
    localIntent.putExtra("extra_collection_key", paramString2);
    localIntent.putExtra("extra_share_time_zone", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid", paramString3);
    localIntent.putExtra("extra_identify", paramInt3);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString2);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (localStoryVideoItem.mInteractStatus != -1) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      a(paramActivity, paramString2, paramString1, "", 16, false, -1, paramInt1, paramString3, paramInt2);
      return;
    }
    PlayModeUtils.a(QQStoryContext.a(), paramActivity, paramString2, 16, false, -1, paramInt1, paramString3, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 51);
    localIntent.putExtra("extra_feedid", paramString1);
    localIntent.putExtra("extra_vid", paramString2);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 2);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString1);
    localIntent.putExtra("extra_feedid", paramString3);
    localIntent.putExtra("extra_share_from_type", paramInt1);
    localIntent.putExtra("extra_story_type", paramInt2);
    paramString1 = new ArrayList();
    paramString1.add(paramString2);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramString1);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 13);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString1);
    localIntent.putExtra("extra_default_title", paramString3);
    localIntent.putExtra("extra_share_time", paramString2);
    localIntent.putExtra("need_image_animation", false);
    localIntent.putExtra("extra_share_time_zone", paramInt1);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_feedid", paramString4);
    localIntent.putExtra("extra_identify", paramInt3);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 32);
    localIntent.putExtra("EXTRA_USER_UIN", paramString1);
    switch (paramInt1)
    {
    default: 
      localIntent.putExtra("EXTRA_USER_UNION_ID", paramString2);
    }
    for (;;)
    {
      localIntent.putExtra("extra_feedid", paramString3);
      localIntent.putExtra("extra_story_type", paramInt1);
      localIntent.putExtra("extra_vid", paramString4);
      localIntent.putExtra("extra_pull_type", paramInt2);
      localIntent.putExtra("extra_is_use_cache_videolist", paramBoolean);
      localIntent.putExtra("extra_share_from_type", paramInt3);
      localIntent.putExtra("extra_page_source", paramInt4);
      AnimationUtils.a(paramActivity, localIntent, paramView);
      return;
      localIntent.putExtra("EXTRA_SHARE_GROUP_UNION_ID", paramString2);
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString4, int paramInt4)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", paramInt1);
    localIntent.putExtra("extra_video_id", paramString1);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString2);
    localIntent.putExtra("EXTRA_SHARE_GROUP_UNION_ID", paramString3);
    localIntent.putExtra("extra_is_open_watchlist", paramBoolean);
    localIntent.putExtra("extra_target_comment_id", paramInt2);
    localIntent.putExtra("extra_identify", paramInt4);
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramString2);
    localIntent.putExtra("need_image_animation", false);
    localIntent.putExtra("extra_share_from_type", paramInt3);
    localIntent.putExtra("extra_feedid", paramString4);
    paramActivity.startActivity(localIntent);
    paramActivity.overridePendingTransition(2131034134, 0);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 47);
    localIntent.putExtra("EXTRA_USER_UIN", paramString1);
    localIntent.putExtra("extra_feedid", paramString2);
    localIntent.putExtra("extra_vid", paramString3);
    localIntent.putExtra("extra_feedid_list", paramArrayList);
    localIntent.putExtra("extra_pull_type", paramInt1);
    localIntent.putExtra("extra_is_use_cache_videolist", paramBoolean);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("extra_page_source", paramInt3);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString, ArrayList paramArrayList1, int paramInt1, int paramInt2, ArrayList paramArrayList2, View paramView, boolean paramBoolean, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 21);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString);
    localIntent.putExtra("extra_collection_key_list", paramArrayList1);
    localIntent.putExtra("extra_collection_key_index", paramInt1);
    localIntent.putExtra("extra_feedid_list", paramArrayList2);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt2);
    localIntent.putExtra("extra_memory_from", paramInt3);
    localIntent.putExtra("extra_memory_key_list_is_end", paramBoolean);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString, ArrayList paramArrayList1, int paramInt1, int paramInt2, ArrayList paramArrayList2, ArrayList paramArrayList3, View paramView, boolean paramBoolean, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 38);
    localIntent.putExtra("EXTRA_USER_UNION_ID", paramString);
    localIntent.putExtra("extra_collection_key_list", paramArrayList1);
    localIntent.putExtra("extra_collection_key_index", paramInt1);
    localIntent.putExtra("extra_feedid_list", paramArrayList2);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt2);
    localIntent.putExtra("extra_memory_from", paramInt3);
    localIntent.putExtra("extra_memory_key_list_is_end", paramBoolean);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramArrayList3);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 44);
    localIntent.putExtra("EXTRA_SHARE_GROUP_UNION_ID", paramString);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramArrayList1);
    localIntent.putStringArrayListExtra("extra_feedid_list", paramArrayList2);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt);
    localIntent.putExtra("extra_share_from_type", 87);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Activity paramActivity, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, View paramView)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 48);
    localIntent.putExtra("extra_feedid_list", paramArrayList1);
    localIntent.putStringArrayListExtra("EXTRA_VIDEO_ID_LIST", paramArrayList2);
    localIntent.putExtra("extra_share_from_type", paramInt2);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt1);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void a(Context paramContext, MessageForTroopStory paramMessageForTroopStory, View paramView)
  {
    Intent localIntent = new Intent(paramContext, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 23);
    localIntent.putExtra("EXTRA_USER_UIN", paramMessageForTroopStory.selfuin);
    localIntent.putExtra("extra_troop_uin", paramMessageForTroopStory.frienduin);
    localIntent.putExtra("extra_vid", paramMessageForTroopStory.storyId);
    localIntent.putExtra("extra_msg_seq", paramMessageForTroopStory.shmsgseq);
    localIntent.putExtra("extra_ugc_steaming_enabled", true);
    if ((paramContext instanceof Activity))
    {
      AnimationUtils.a((Activity)paramContext, localIntent, paramView);
      return;
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 26);
    localIntent.putExtra("extra_video_id", paramString);
    localIntent.putExtra("extra_troop_uin", TroopStoryUtil.a(paramString));
    localIntent.putExtra("need_image_animation", false);
    localIntent.putExtra("extra_ugc_steaming_enabled", true);
    localIntent.putExtra("extra_play_video_from", paramInt);
    if ((paramContext instanceof Activity))
    {
      paramContext.startActivity(localIntent);
      ((Activity)paramContext).overridePendingTransition(2131034134, 0);
      return;
    }
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (localStoryVideoItem.mInteractStatus != -1) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      a(paramActivity, paramString1, paramLong, paramInt1, false, -1, paramInt2, paramString2, paramInt3);
      return;
    }
    PlayModeUtils.a(paramQQAppInterface, paramActivity, paramString1, paramInt1, false, -1, paramInt2, paramString2, paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramString1, paramLong, paramInt1, 0, paramString2, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.player.StoryPlayVideoActivity", 2, new Object[] { "openFromAIOVideo vid null. shareFromType=", Integer.valueOf(paramInt2) });
      }
      return;
    }
    StoryVideoItem localStoryVideoItem = ((StoryManager)SuperManager.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (!TextUtils.isEmpty(localStoryVideoItem.mLocalVideoPath)) && (localStoryVideoItem.mInteractStatus != -1) && (new File(localStoryVideoItem.mLocalVideoPath).length() > 0L))
    {
      a(paramActivity, paramString1, paramString2, "", paramInt1, false, -1, paramInt2, paramString3, paramInt3);
      return;
    }
    PlayModeUtils.a(paramQQAppInterface, paramActivity, paramString1, paramInt1, false, -1, paramInt2, paramString3, paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    a(paramQQAppInterface, paramActivity, paramString1, paramString2, 35, paramInt, paramString3, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramString1, paramString2, 29, paramInt1, paramString3, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, View paramView)
  {
    paramView = ((StoryManager)SuperManager.a(5)).a(paramString3);
    if ((paramView != null) && (!TextUtils.isEmpty(paramView.mLocalVideoPath)) && (new File(paramView.mLocalVideoPath).length() > 0L))
    {
      a(paramActivity, paramString3, paramString1, paramString2, 18, false, -1, 0, paramString4, 0);
      return;
    }
    PlayModeUtils.a(paramQQAppInterface, paramActivity, paramString3, 18, false, 0, 0, paramString4, 0);
  }
  
  public static void b(Activity paramActivity, String paramString, ArrayList paramArrayList1, int paramInt1, int paramInt2, ArrayList paramArrayList2, View paramView, boolean paramBoolean, int paramInt3)
  {
    Intent localIntent = new Intent(paramActivity, StoryPlayVideoActivity.class);
    localIntent.putExtra("EXTRA_VIDEO_MODE", 45);
    localIntent.putExtra("EXTRA_SHARE_GROUP_UNION_ID", paramString);
    localIntent.putExtra("extra_collection_key_list", paramArrayList1);
    localIntent.putExtra("extra_collection_key_index", paramInt1);
    localIntent.putExtra("extra_feedid_list", paramArrayList2);
    localIntent.putExtra("EXTRA_CURRENT_INDEX", paramInt2);
    localIntent.putExtra("extra_memory_from", paramInt3);
    localIntent.putExtra("extra_memory_key_list_is_end", paramBoolean);
    AnimationUtils.a(paramActivity, localIntent, paramView);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramString1, paramLong, 29, paramInt1, paramString2, paramInt2);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  void a()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
          Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          localObject1 = ((Class)localObject1).getDeclaredField("mContext");
          ((Field)localObject1).setAccessible(true);
          if (((Field)localObject1).get(localObject2) == this)
          {
            ((Field)localObject1).set(localObject2, null);
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqstory.player.StoryPlayVideoActivity", 2, localThrowable, new Object[0]);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      d();
      return;
    }
    a(this);
    a(this, 0, 0);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f1 = 0.0F;
    float f2 = 1.0F - (paramInt3 - paramInt5) / DisplayUtil.a(this, 60.0F);
    if (f2 < 0.0F) {}
    for (;;)
    {
      ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, f1);
      return;
      f1 = f2;
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    this.e = localIntent.getIntExtra("extra_transition_mode", 0);
    if ((this.e == 1) && (!MsgTabStoryUtil.a())) {
      this.e = 0;
    }
    if (this.e == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setLayerType(2, null);
      if (paramBundle == null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setVisibility(4);
        this.f = localIntent.getIntExtra("EXTRA_CIRCULAR_REVEAL_START_RADIUS", 0);
        this.g = localIntent.getIntExtra("EXTRA_CIRCULAR_REVEAL_X", 0);
        this.h = localIntent.getIntExtra("EXTRA_CIRCULAR_REVEAL_Y", 0);
        this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getViewTreeObserver().addOnPreDrawListener(new noc(this));
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getViewTreeObserver().addOnPreDrawListener(new nod(this));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.jdField_a_of_type_Boolean = true;
    if (paramInt1 - paramInt3 > DisplayUtil.a(this, 60.0F)) {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.f();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(200);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-285212672);
      paramView = new AlphaAnimation(ViewHelper.getAlpha(this.jdField_a_of_type_AndroidViewView), 1.0F);
      paramView.setFillAfter(true);
      paramView.setDuration(200L);
      this.jdField_a_of_type_AndroidViewView.startAnimation(paramView);
    } while (this.e != 1);
    c();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.s();
  }
  
  public void a(CircularRevealCompatLayout paramCircularRevealCompatLayout, int paramInt1, int paramInt2)
  {
    int i = paramCircularRevealCompatLayout.getWidth() / 2;
    int j = paramCircularRevealCompatLayout.getHeight() / 2;
    float f1 = Math.max(i, j);
    Animator localAnimator = ViewAnimationCompatUtils.a(paramCircularRevealCompatLayout, paramInt1, paramInt2, this.f, i, j, f1 * 1.5F);
    localAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimator.setDuration(250L);
    paramCircularRevealCompatLayout.setVisibility(0);
    localAnimator.start();
  }
  
  void b()
  {
    if (!MsgTabStoryUtil.a()) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getHeight();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.a();
    float f1 = f2;
    if (f2 == -1.0F) {
      f1 = Math.max(i, j) * 0.75F;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(i / 2, j / 2, Math.min(i, j) / 2);
    this.jdField_a_of_type_AndroidAnimationAnimator = ViewAnimationCompatUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout, i / 2, j / 2, f1, Math.min(i, j) / 2);
    this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
  }
  
  protected void b(CircularRevealCompatLayout paramCircularRevealCompatLayout, int paramInt1, int paramInt2)
  {
    int i = paramCircularRevealCompatLayout.getWidth() / 2;
    int j = paramCircularRevealCompatLayout.getHeight() / 2;
    float f1 = Math.max(i, j);
    Animator localAnimator = ViewAnimationCompatUtils.a(paramCircularRevealCompatLayout, i, j, 1.5F * f1, paramInt1, paramInt2, this.f);
    localAnimator.setDuration(250L);
    localAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimator.addListener(new nof(this, paramCircularRevealCompatLayout));
    localAnimator.start();
  }
  
  void c()
  {
    if (!MsgTabStoryUtil.a()) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationAnimator.cancel();
    }
    int i = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getWidth();
    int j = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.getHeight();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.a();
    float f1 = f2;
    if (f2 == -1.0F) {
      f1 = Math.max(i, j) * 0.75F;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout.setRevealClip(i / 2, j / 2, Math.min(i, j) / 2);
    this.jdField_a_of_type_AndroidAnimationAnimator = ViewAnimationCompatUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout, i / 2, j / 2, f1, Math.max(i, j) * 0.75F);
    this.jdField_a_of_type_AndroidAnimationAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationAnimator.setInterpolator(new AccelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
  }
  
  protected void c(CircularRevealCompatLayout paramCircularRevealCompatLayout, int paramInt1, int paramInt2)
  {
    int i = paramCircularRevealCompatLayout.getWidth();
    int j = paramCircularRevealCompatLayout.getHeight();
    Animator localAnimator = ViewAnimationCompatUtils.a(paramCircularRevealCompatLayout, i / 2, j / 2, Math.min(i, j) / 2, paramInt1, paramInt2, this.f);
    localAnimator.setDuration(250L);
    localAnimator.addListener(new nog(this, paramCircularRevealCompatLayout));
    localAnimator.start();
  }
  
  protected void d()
  {
    if (this.e == 1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.f();
      if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationAnimator.end();
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(250);
        c(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout, this.g, this.h);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      b(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout, this.g, this.h);
      return;
    }
    if (!this.i)
    {
      finish();
      return;
    }
    ViewHelper.setAlpha(this.jdField_a_of_type_AndroidViewView, 0.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a(this.jdField_a_of_type_Int, this.b, this.c, this.d, 300, new noh(this));
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    SLog.d("Q.qqstory.player.StoryPlayVideoActivity", "[1/8] StoryPlayVideoActivity doOnCreate %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    PlayModeUtils.a(System.identityHashCode(this)).jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    Object localObject = super.getIntent();
    this.jdField_a_of_type_AndroidOsBundle = ((Intent)localObject).getExtras();
    ((Intent)localObject).putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
      return false;
    }
    super.getWindow().addFlags(128);
    super.setContentViewNoTitle(2130970803);
    SLog.b("Q.qqstory.player.StoryPlayVideoActivity", "[2/8] StoryPlayVideoActivity after super setContentViewNoTitle");
    localObject = (QQStoryActivityManager)SuperManager.a(18);
    if ((((QQStoryActivityManager)localObject).jdField_a_of_type_Boolean) && (((QQStoryActivityManager)localObject).jdField_a_of_type_JavaUtilMap != null) && (((QQStoryActivityManager)localObject).jdField_a_of_type_JavaUtilMap.size() >= 10)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new nob(this, (QQStoryActivityManager)localObject), 200L);
    }
    StoryPublishParams.a("Q.qqstory.player.StoryPlayVideoActivity", this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer = ((StoryVideoPlayer)findViewById(2131370599));
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager = this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager;
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)super.findViewById(2131365572));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131370595);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131370597));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout = ((CircularRevealCompatLayout)super.findViewById(2131370596));
    a(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131371942));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setOnDraggingListener(this);
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ArrayOfInt[0];
      this.b = this.jdField_a_of_type_ArrayOfInt[1];
      this.c = this.jdField_a_of_type_ArrayOfInt[2];
      this.d = this.jdField_a_of_type_ArrayOfInt[3];
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.jdField_a_of_type_Int = this.c;
    int i = this.c;
    if ((this.c > this.d) || (this.c > UIUtils.a(this) / 2)) {
      i = this.c / 2;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.setOnCloseListener(this);
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)super.getSystemService("audio"));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.c();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.a();
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      AnimatorProxy.wrap(this.jdField_a_of_type_AndroidViewView).reset();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout != null) {
      AnimatorProxy.wrap(this.jdField_a_of_type_ComTencentBizQqstoryWidgetCircularrevealCircularRevealCompatLayout).reset();
    }
    PlayModeUtils.a(System.identityHashCode(this));
    a();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a();
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.b();
    e();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {}
    for (;;)
    {
      return;
      try
      {
        int j = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 2);
        int i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 1);
        }
        if (i == 0)
        {
          this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, 3, 3);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean f_()
  {
    if (this.e == 1)
    {
      b();
      this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.c(1);
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    super.overridePendingTransition(0, 2131034167);
  }
  
  public boolean g_()
  {
    if (((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getAdapter().getCount() == 0) || (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getCurrentItem() == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getAdapter().getCount() - 1)) && (this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.b())) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.e == 1)) {
        b();
      }
      return bool;
    }
  }
  
  public boolean h_()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoCustomViewPager.getCurrentItem() == 0) && (!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.a())) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (this.e == 1)) {
        b();
      }
      return bool;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryVideoplayerStoryVideoPlayer.onKeyDown(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (isInMultiWindow())
    {
      QQToast.a(this, "该功能无法在分屏模式下使用。", 0).a();
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity
 * JD-Core Version:    0.7.0.1
 */