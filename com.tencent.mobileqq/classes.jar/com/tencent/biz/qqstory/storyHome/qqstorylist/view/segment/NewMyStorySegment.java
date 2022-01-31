package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.handler.DeleteStoryVideoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep.Result;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserSelfInfoStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.GetResultSimpleStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStep.InitParamSimpleStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.Step;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.utils.UncheckedCallable;
import com.tencent.biz.qqstory.view.StoryImageDialog;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nzi;
import nzj;
import nzk;
import nzl;
import nzm;
import nzn;
import nzo;
import nzq;
import nzs;
import nzu;
import nzw;
import nzx;

public class NewMyStorySegment
  extends SegmentView
  implements Handler.Callback, IEventReceiver
{
  public static final String KEY = "NewMyStorySegment";
  private static final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  private float jdField_a_of_type_Float;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected QQStoryObserver a;
  protected StoryConfigManager a;
  private QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private MyStorys jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
  protected SerialStepExecutor a;
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder;
  private IMyStoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView;
  protected NewMyStorySegment.DeleteStoryVideoReceiver a;
  protected NewMyStorySegment.StoryVideoPublishStatusReceiver a;
  protected NewMyStorySegment.UpdateUserInfoReceiver a;
  public final UncheckedCallable a;
  private StoryImageDialog jdField_a_of_type_ComTencentBizQqstoryViewStoryImageDialog;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final UncheckedCallable b;
  private boolean jdField_b_of_type_Boolean;
  public final UncheckedCallable c;
  private boolean c;
  public final UncheckedCallable d = new nzo(this);
  
  public NewMyStorySegment(Activity paramActivity, IMyStoryListView paramIMyStoryListView)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new nzi(this);
    this.jdField_b_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new nzm(this);
    this.jdField_c_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new nzn(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new nzq(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView = paramIMyStoryListView;
    this.jdField_a_of_type_Float = (UIUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 145.0F));
    this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager = ((StoryConfigManager)SuperManager.a(10));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor = new SerialStepExecutor(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = new MyStorys();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$StoryVideoPublishStatusReceiver = new NewMyStorySegment.StoryVideoPublishStatusReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$DeleteStoryVideoReceiver = new NewMyStorySegment.DeleteStoryVideoReceiver(this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$UpdateUserInfoReceiver = new NewMyStorySegment.UpdateUserInfoReceiver(this);
    QQStoryContext.a();
    QQStoryContext.a().addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(StoryListUtils.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(MyStorys paramMyStorys, int paramInt, TextPaint paramTextPaint)
  {
    jdField_a_of_type_JavaLangStringBuilder.append(paramMyStorys.a(paramInt, paramTextPaint));
    paramMyStorys = jdField_a_of_type_JavaLangStringBuilder.toString();
    jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    return paramMyStorys;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    PlayModeUtils.a(paramStoryVideoItem, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.b()) {
      return;
    }
    if (paramStoryVideoItem.mUnreadLikeCount > 0) {}
    for (String str1 = "1";; str1 = "2")
    {
      String str2 = "2";
      if ((TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str2 = "1";
      }
      StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
      StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, QQStoryContext.a().b(), paramStoryVideoItem.mVid, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, 2, 1, paramView);
      return;
    }
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = paramBaseViewHolder;
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131371836);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131371840);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131371837);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131371841);
    View localView = paramBaseViewHolder.a(2131371838);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a();
    paramInt = -657931;
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b() == 0)
    {
      paramViewGroup.setImageResource(2130843617);
      localTextView.post(new nzw(this, localTextView, localView, localImageView2));
      if (!this.jdField_b_of_type_Boolean) {
        break label332;
      }
      if (!bool) {
        break label321;
      }
      localImageView2.setImageResource(2130843485);
      label170:
      localImageView2.setContentDescription("收起更多");
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() <= 0) {
        break label367;
      }
      localImageView2.setVisibility(0);
      label197:
      if (!this.jdField_b_of_type_Boolean) {
        break label397;
      }
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().findViewById(2131371835).setOnClickListener(paramBaseViewHolder);
      if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener == null) {
        paramBaseViewHolder.a(new nzx(this));
      }
      return;
      if ((localQQUserUIItem == null) || (TextUtils.isEmpty(localQQUserUIItem.headUrl)))
      {
        SLog.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
        paramViewGroup.setImageResource(2130843617);
        GetUserInfoHandler.d();
        break;
      }
      UIUtils.b(paramViewGroup, ThumbnailUrlHelper.b(localQQUserUIItem.headUrl), 200, 200, ImageUtil.a(1), "QQStory200");
      break;
      label321:
      localImageView2.setImageResource(2130843484);
      break label170;
      label332:
      if (bool) {
        localImageView2.setImageResource(2130843483);
      }
      for (;;)
      {
        localImageView2.setContentDescription("更多");
        break;
        localImageView2.setImageResource(2130843482);
      }
      label367:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b() != 0)
      {
        localImageView2.setVisibility(8);
        break label197;
      }
      localImageView2.setVisibility(8);
      break label197;
      label397:
      localImageView1.setVisibility(8);
    }
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, ImageView paramImageView)
  {
    paramImageView.setVisibility(4);
  }
  
  private void a(MyStorys paramMyStorys, View paramView)
  {
    if (UIUtils.b()) {
      return;
    }
    if (paramMyStorys.d) {}
    for (String str = "1"; paramMyStorys.b() == 0; str = "2")
    {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131371836) {
      StoryReportor.a("mystory", "clk_head_data", 0, 0, new String[0]);
    }
    for (;;)
    {
      paramMyStorys = QQStoryContext.a().b();
      StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 3, paramMyStorys);
      return;
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.b()) {
      return;
    }
    View localView = paramView.findViewById(2131371842);
    if (paramStoryVideoItem.mUnreadLikeCount > 0)
    {
      a(paramInt, paramStoryVideoItem, localView);
      return;
    }
    String str1;
    String str2;
    if (paramStoryVideoItem.mUnreadLikeCount > 0)
    {
      paramView = "1";
      str1 = "2";
      if ((!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (!TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
        str1 = "1";
      }
      StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str1 });
      paramView = this.jdField_a_of_type_AndroidAppActivity;
      str1 = QQStoryContext.a().b();
      str2 = paramStoryVideoItem.mVid;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem != null) {
        break label150;
      }
    }
    label150:
    for (paramStoryVideoItem = "";; paramStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString)
    {
      StoryPlayVideoActivity.a(paramView, str1, str2, paramStoryVideoItem, 2, 1, localView);
      return;
      paramView = "2";
      break;
    }
  }
  
  private void b(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    Object localObject1 = (StoryCoverView)paramBaseViewHolder.a(2131371842);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131371852);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371849);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371848);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131371844);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371853);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131371850);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131371845);
    paramViewGroup = (Button)paramBaseViewHolder.a(2131371854);
    ImageView localImageView4 = (ImageView)paramBaseViewHolder.a(2131371843);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a() == null))
    {
      SLog.e("NewMyStorySegment", "myStorys is null!");
      return;
    }
    paramBaseViewHolder.a().setTag(-3, Integer.valueOf(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131371843);
    Object localObject2 = (ImageView)paramBaseViewHolder.a(2131371846);
    paramInt = -657931;
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
      paramInt = -15980466;
    }
    paramViewGroup.setBackgroundColor(paramInt);
    ((ImageView)localObject2).setBackgroundColor(paramInt);
    localObject2 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(i);
    SLog.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
    label289:
    boolean bool2;
    if (StoryListUtils.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath))
    {
      paramViewGroup = ImageDownloader.FILE.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);
      bool2 = false;
      UIUtils.a(((StoryCoverView)localObject1).a, paramViewGroup, 106, 170, 5, UIUtils.b, "myStory");
      ((StoryCoverView)localObject1).setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      ((StoryCoverView)localObject1).setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      localTextView3.setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
      localImageView4.setVisibility(0);
      bool1 = bool2;
    }
    switch (((StoryVideoItem)localObject2).mUploadStatus)
    {
    default: 
      bool1 = bool2;
    case 7: 
    case 8: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
    case 6: 
    case 9: 
      for (;;)
      {
        a((StoryVideoItem)localObject2, localImageView1);
        if ((((StoryVideoItem)localObject2).mViewTotalTime <= 0L) && (!bool1)) {
          break label1027;
        }
        localTextView1.setEnabled(true);
        label461:
        paramBaseViewHolder.jdField_b_of_type_Int = i;
        paramBaseViewHolder.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
        localTextView1.setOnClickListener(paramBaseViewHolder);
        paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
        paramBaseViewHolder.a().setContentDescription("我的日迹第" + (i + 1) + "条");
        localTextView2.setOnClickListener(paramBaseViewHolder);
        localImageView2.setOnClickListener(paramBaseViewHolder);
        if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener != null) {
          break;
        }
        paramBaseViewHolder.a(new nzj(this, bool1));
        return;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null) {
          SLog.e("NewMyStorySegment", "mVideoThumbnailUrl is null! vid=" + ((StoryVideoItem)localObject2).mVid);
        }
        paramViewGroup = ThumbnailUrlHelper.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl);
        break label289;
        localTextView4.setVisibility(0);
        localTextView4.setText("等待中...");
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(8);
        localTextView2.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView4.setVisibility(0);
        localTextView4.setText(2131432102);
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(8);
        localTextView2.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView3.setVisibility(8);
        localImageView3.setVisibility(8);
        localImageView2.setVisibility(0);
        localTextView4.setVisibility(8);
        bool1 = bool2;
        continue;
        localTextView4.setVisibility(0);
        localTextView4.setText("小视频删除中...");
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(8);
        localTextView2.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView2.setVisibility(8);
        bool1 = bool2;
      }
    }
    localTextView4.setVisibility(8);
    if (!TextUtils.isEmpty(((StoryVideoItem)localObject2).mDoodleText))
    {
      localTextView3.setText(((StoryVideoItem)localObject2).mDoodleText);
      localTextView3.setVisibility(0);
      label854:
      localTextView2.setVisibility(8);
      localImageView3.setVisibility(0);
      localImageView2.setVisibility(8);
      if ((((StoryVideoItem)localObject2).mVideoSpreadGroupList == null) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_Int != 4) || (((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label1036;
      }
      paramViewGroup = ((TroopManager)PlayModeUtils.a().getManager(51)).a((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
      if ((paramViewGroup == null) || (TextUtils.isEmpty(paramViewGroup.getTroopName()))) {
        break label1036;
      }
      paramViewGroup = "来自 " + paramViewGroup.getTroopName();
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = paramViewGroup;
      if (TextUtils.isEmpty(paramViewGroup)) {
        localObject1 = a((StoryVideoItem)localObject2);
      }
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setVisibility(0);
      break;
      localTextView3.setVisibility(8);
      break label854;
      label1027:
      localTextView1.setEnabled(false);
      break label461;
      label1036:
      paramViewGroup = "";
    }
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371849);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371848);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131371844);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371853);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131371845);
    switch (paramInt)
    {
    case 7: 
    case 8: 
    default: 
      return;
    case 0: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramBaseViewHolder.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 1: 
    case 2: 
    case 4: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramBaseViewHolder.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    case 3: 
    case 6: 
      localTextView1.setVisibility(8);
      localTextView3.setVisibility(0);
      localTextView2.setVisibility(8);
      paramBaseViewHolder.setVisibility(8);
      localImageView.setVisibility(0);
      return;
    case 9: 
      localTextView1.setVisibility(8);
      localTextView2.setVisibility(8);
      localTextView3.setVisibility(8);
      paramBaseViewHolder.setVisibility(0);
      localImageView.setVisibility(8);
      return;
    }
    localTextView3.setVisibility(8);
    paramBaseViewHolder.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramBaseViewHolder.a(2131365532);
    View localView1 = paramBaseViewHolder.a(2131371620);
    View localView2 = paramBaseViewHolder.a(2131371622);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494267);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramBaseViewHolder.a(2131371623);
    localView1 = paramBaseViewHolder.a(2131371621);
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    localView1.setOnClickListener(paramBaseViewHolder);
    if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener == null) {
      paramBaseViewHolder.a(new nzk(this));
    }
  }
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > 0)) {
        return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() + 2;
      }
      return 1;
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == a() - 1) {
      return 2;
    }
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int i = a(paramInt);
    SLog.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      a(paramInt, paramBaseViewHolder, paramViewGroup);
      continue;
      b(paramInt, paramBaseViewHolder, paramViewGroup);
      continue;
      c(paramInt, paramBaseViewHolder, paramViewGroup);
    }
  }
  
  public SerialStepExecutor a()
  {
    return new SerialStepExecutor(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt))
    {
    default: 
      paramViewGroup = null;
    }
    while (paramViewGroup != null)
    {
      return new BaseViewHolder(paramViewGroup);
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970795, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970796, paramViewGroup, false);
      continue;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970695, paramViewGroup, false);
    }
    return new BaseViewHolder(new TextView(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public String a()
  {
    return "NewMyStorySegment";
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.a(BaseApplication.getContext(), 1, "删除失败，请稍后重试", 0).a();
    l();
  }
  
  protected void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    SLog.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramStoryVideoPublishStatusEvent);
    Object localObject1 = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      SLog.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a((StoryVideoItem)localObject1);
      if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage == null) {
        break label268;
      }
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    }
    for (;;)
    {
      if (paramStoryVideoPublishStatusEvent.b != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(((StoryVideoItem)localObject1).mVid, paramStoryVideoPublishStatusEvent.b);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_Boolean = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.mIsContribute;
        if ((!TextUtils.isEmpty(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)) && (!TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId)))
        {
          SLog.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId);
          Object localObject2 = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelGeneralFeedItem.feedId;
          localObject1 = new SimpleStep.InitParamSimpleStep(GetMyStoryVideoListStep.Result.a((String)localObject2));
          Step localStep = (Step)this.jdField_b_of_type_ComTencentBizQqstoryUtilsUncheckedCallable.a();
          localObject2 = new SimpleStep.GetResultSimpleStep(new nzl(this, (String)localObject2));
          SerialStepExecutor localSerialStepExecutor = a();
          a(new Step[] { localObject1, localStep, localObject2 }, localSerialStepExecutor);
        }
      }
      if (!paramStoryVideoPublishStatusEvent.jdField_c_of_type_Boolean) {
        break label279;
      }
      a().i();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b((StoryVideoItem)localObject1);
      break;
      label268:
      SLog.e("NewMyStorySegment", "item error info is null!!");
    }
    label279:
    l();
  }
  
  public void a(MyStorys paramMyStorys)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = paramMyStorys;
    GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys);
    c(true);
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    a().u();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt) != null)
    {
      localObject = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).mVid;
      if (!StoryVideoItem.isFakeVid((String)localObject)) {
        break label103;
      }
      StoryVideoUploadManager.a((String)localObject);
      l();
      if (!((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).isUploading()) {
        break label96;
      }
    }
    label96:
    for (paramBaseViewHolder = "1";; paramBaseViewHolder = "3")
    {
      StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { paramBaseViewHolder });
      return;
    }
    label103:
    new DeleteStoryVideoHandler().a((String)localObject);
    ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).mUploadStatus = 9;
    Object localObject = (TextView)paramBaseViewHolder.a(2131371850);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText("小视频删除中...");
    b(paramBaseViewHolder, 9);
    StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
  }
  
  public void a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.c(paramString);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_Boolean = false;
    }
    ((FeedVideoManager)SuperManager.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, 0, paramString);
    l();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    l();
  }
  
  public void a(Step[] paramArrayOfStep)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor = new SerialStepExecutor(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfStep, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor);
  }
  
  protected void a(Step[] paramArrayOfStep, SerialStepExecutor paramSerialStepExecutor)
  {
    int j = paramArrayOfStep.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Step localStep = paramArrayOfStep[i];
        try
        {
          paramSerialStepExecutor.a(localStep);
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    paramSerialStepExecutor.a(new nzu(this)).a(new nzs(this));
    paramSerialStepExecutor.a();
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder)
  {
    super.a_(paramBaseViewHolder);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131371843);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131371844);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131371845);
    if ((localImageView3 != null) && (localImageView2 != null) && (localImageView1 != null))
    {
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
      localImageView3.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > paramBaseViewHolder.jdField_b_of_type_Int)
    {
      paramBaseViewHolder = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramBaseViewHolder.jdField_b_of_type_Int);
      if (!paramBaseViewHolder.isUploadSuc()) {
        break label135;
      }
      paramBaseViewHolder = "2";
    }
    for (;;)
    {
      StoryReportor.a("mystory", "slide_del", 0, 0, new String[] { paramBaseViewHolder });
      return;
      label135:
      if (paramBaseViewHolder.isUploadFail()) {
        paramBaseViewHolder = "3";
      } else if (paramBaseViewHolder.isUploading()) {
        paramBaseViewHolder = "1";
      } else {
        paramBaseViewHolder = "2";
      }
    }
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    a(new Step[] { (Step)this.jdField_a_of_type_ComTencentBizQqstoryUtilsUncheckedCallable.a(), (Step)this.jdField_b_of_type_ComTencentBizQqstoryUtilsUncheckedCallable.a(), (Step)this.jdField_c_of_type_ComTencentBizQqstoryUtilsUncheckedCallable.a(), (Step)this.d.a() });
    return true;
  }
  
  public void b_(BaseViewHolder paramBaseViewHolder)
  {
    super.b_(paramBaseViewHolder);
    ((ImageView)paramBaseViewHolder.a(2131371843)).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > paramBaseViewHolder.jdField_b_of_type_Int) {
      b(paramBaseViewHolder, ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramBaseViewHolder.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$StoryVideoPublishStatusReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$DeleteStoryVideoReceiver);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$UpdateUserInfoReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
    List localList = ((StoryManager)SuperManager.a(5)).e(QQStoryContext.a().b());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b();
    MyStorys localMyStorys = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
    if (((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_i_am_vip", Integer.valueOf(-1))).intValue() == 1)
    {
      bool = true;
      localMyStorys.jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_fans_count", Integer.valueOf(0))).intValue();
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_vidoe_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_visiter_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_newest_video_cover", ""));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_newest_video_vid", ""));
      localMyStorys = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
      if (((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_story_have_contributed", Integer.valueOf(-1))).intValue() != 1) {
        break label471;
      }
    }
    label471:
    for (boolean bool = true;; bool = false)
    {
      localMyStorys.jdField_b_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_like_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_comment_count", Integer.valueOf(0))).intValue();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_view_count", Integer.valueOf(0))).intValue();
      if (localList.size() == 0) {
        SLog.d("NewMyStorySegment", "Story DB have no mystory data!");
      }
      Collections.sort(localList);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(localList);
      SLog.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) });
      this.jdField_c_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$StoryVideoPublishStatusReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$DeleteStoryVideoReceiver);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$UpdateUserInfoReceiver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor.c();
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewStoryImageDialog != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewStoryImageDialog.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  protected int d_()
  {
    return 3;
  }
  
  protected void e() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a((MyStorys)paramMessage.obj);
    }
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment
 * JD-Core Version:    0.7.0.1
 */