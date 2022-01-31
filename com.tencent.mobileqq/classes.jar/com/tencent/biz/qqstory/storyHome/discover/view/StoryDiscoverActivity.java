package com.tencent.biz.qqstory.storyHome.discover.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoActivityLauncher;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.ArrayList;
import nwf;
import nwg;
import nwh;
import nwi;
import nwj;

public class StoryDiscoverActivity
  extends QQStoryBaseActivity
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQStoryTakeVideoActivityLauncher jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher;
  private QQStoryDiscoverFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment;
  public TakeVideoButtonMainPart a;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  
  public static void a(Activity paramActivity, long paramLong, String paramString1, @Nullable CardItem paramCardItem, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, StoryDiscoverActivity.class);
    localIntent.putExtra("topic_id", paramLong);
    if (paramCardItem != null) {
      localIntent.putExtra("topic_card_item", paramCardItem.toCardEntry().PBData);
    }
    localIntent.putExtra("source", paramInt);
    if (!"0".equals(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool, "openDiscoverActivity from 0");
      StoryReportor.a("content_flow", "exp_hot_page", 0, StoryApi.a(2131689488), new String[] { String.valueOf(paramLong), paramString2, paramString1 });
      paramActivity.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, StoryDiscoverActivity.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("selfSet_leftViewText", paramString);
    }
    localIntent.putExtra("source", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void b()
  {
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setContentDescription("分享");
    this.rightViewImg.setImageResource(2130843645);
    this.rightViewImg.getLayoutParams().width = -2;
    this.rightViewImg.setPadding(0, 0, DisplayUtil.a(this, 5.0F), 0);
    new nwf(this);
    this.rightViewImg.setOnClickListener(new nwg(this));
  }
  
  private boolean b()
  {
    Intent localIntent = getIntent();
    this.jdField_a_of_type_Int = localIntent.getIntExtra("source", 1);
    this.jdField_a_of_type_Long = localIntent.getLongExtra("topic_id", 0L);
    this.jdField_a_of_type_ArrayOfByte = localIntent.getByteArrayExtra("topic_card_item");
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      this.jdField_a_of_type_JavaLangString = new CardItem.ActivityCardInfo(this.jdField_a_of_type_ArrayOfByte).a();
    }
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("display_fake_item", this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Boolean)
    {
      this.b = localIntent.getStringExtra("card_feed_id");
      this.c = localIntent.getStringExtra("card_cover_url");
      this.jdField_a_of_type_JavaUtilArrayList = localIntent.getStringArrayListExtra("card_vid_list");
      if (TextUtils.isEmpty(this.b))
      {
        SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "mFakeFeedId is empty, can not display fake item");
        this.jdField_a_of_type_Boolean = false;
      }
      if (TextUtils.isEmpty(this.c))
      {
        SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "mFakeCoverUrl is empty, can not display fake item");
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null)
      {
        SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "mFakeVidList is null");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
    }
    return true;
  }
  
  private void c()
  {
    setContentView(2130970754);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart = new TakeVideoButtonMainPart(new nwh(this), findViewById(2131371825));
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment = QQStoryDiscoverFragment.a(this.b, this.c, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Int);
      localFragmentTransaction.replace(2131362841, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment);
      setTitle("广场");
    }
    for (;;)
    {
      if ((!a()) && (this.jdField_a_of_type_Int == 3)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.a(8);
      }
      localFragmentTransaction.commitAllowingStateLoss();
      return;
      if (this.jdField_a_of_type_Long > 0L)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment = QQStoryDiscoverFragment.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
        localFragmentTransaction.replace(2131362841, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment);
        setTitle("热门活动");
        b();
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment = QQStoryDiscoverFragment.a(this.jdField_a_of_type_Int);
        localFragmentTransaction.replace(2131362841, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment);
        setTitle("广场");
        if (!StoryApi.a()) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonMainPart.a(8);
        }
      }
    }
  }
  
  public void a()
  {
    nwi localnwi = new nwi(this);
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle("参加热门活动");
    localQQCustomDialog.setMessage("今天的所有视频将会公开展示在热门活动和广场中");
    localQQCustomDialog.setNegativeButton(2131433015, localnwi);
    localQQCustomDialog.setPositiveButton(2131433016, localnwi);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    localQQCustomDialog.show();
    StoryReportor.a("content_flow", "exp_hot_pub", 0, 0, new String[0]);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    HotTopicInfoItem localHotTopicInfoItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverViewQQStoryDiscoverFragment.a();
    Object localObject;
    if (this.jdField_a_of_type_Long > 0L) {
      if (localHotTopicInfoItem != null)
      {
        paramString = String.valueOf(localHotTopicInfoItem.mTopicId);
        if (localHotTopicInfoItem == null) {
          break label208;
        }
        localObject = localHotTopicInfoItem.mSubjectName;
        label44:
        StoryReportor.a("content_flow", "pub_page", 0, 0, new String[] { paramString, "", localObject });
        label73:
        paramString = StoryPublishLauncher.a();
        if (!paramString.a()) {
          break label245;
        }
        localObject = new Bundle();
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (localHotTopicInfoItem != null)) {
          this.jdField_a_of_type_JavaLangString = localHotTopicInfoItem.mSubjectName;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label233;
        }
        ((Bundle)localObject).putString("story_default_label", this.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putLong("story_topic_id", this.jdField_a_of_type_Long);
        ((Bundle)localObject).putInt("entrance_type", 16);
        SLog.b("Q.qqstory.discover.StoryDiscoverActivity", "topicId=%d, topic subject name=%s", Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      paramString.a(this, (Bundle)localObject, 20000);
      overridePendingTransition(2131034327, 2131034167);
      return;
      paramString = "";
      break;
      label208:
      localObject = "";
      break label44;
      StoryReportor.a("content_flow", "clk_pub", 0, 0, new String[0]);
      break label73;
      label233:
      ((Bundle)localObject).putInt("entrance_type", 5);
    }
    label245:
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (ShortVideoUtils.a(this.app)))
    {
      bool = true;
      paramString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher.a(this, paramBoolean1, bool);
      if (!bool) {
        break label448;
      }
      paramString.putExtra("start_time", l);
      paramString.putExtra("extra_donot_jump_story_home", true);
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (localHotTopicInfoItem != null)) {
        this.jdField_a_of_type_JavaLangString = localHotTopicInfoItem.mSubjectName;
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label427;
      }
      paramString.putExtra("story_default_label", this.jdField_a_of_type_JavaLangString);
      paramString.putExtra("story_topic_id", this.jdField_a_of_type_Long);
      paramString.putExtra("entrance_type", 16);
      SLog.b("Q.qqstory.discover.StoryDiscoverActivity", "topicId=%d, topic subject name=%s", Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString);
      label390:
      startActivityForResult(paramString, 20000);
      if (!paramBoolean2) {
        break label439;
      }
      super.overridePendingTransition(2131034327, 2131034167);
    }
    for (;;)
    {
      SLog.b("Q.qqstory.discover.StoryDiscoverActivity", "launchNewVideoTakeActivity end");
      return;
      bool = false;
      break;
      label427:
      paramString.putExtra("entrance_type", 5);
      break label390;
      label439:
      super.overridePendingTransition(0, 0);
    }
    label448:
    startActivityForResult(paramString, 20001);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long > 0L;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoActivityLauncher = new QQStoryTakeVideoActivityLauncher(this.app);
    if (!b())
    {
      SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "发现页输入参数错误");
      finish();
      return false;
    }
    c();
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "doOnActivityResult post createStoryVideo ... ");
      Bosses.get().postJob(new nwj(this));
      QQToast.a(this, 2, "小视频发表中，请稍候", 0).a();
      continue;
      a(false, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity
 * JD-Core Version:    0.7.0.1
 */