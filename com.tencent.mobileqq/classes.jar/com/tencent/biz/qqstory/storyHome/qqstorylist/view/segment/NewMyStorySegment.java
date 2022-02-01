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
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.UpdateProgressListener;
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
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryDesFromVidListStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryFeatureDataStep;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetMyStoryVideoListStep;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewMyStorySegment
  extends SegmentView<MyStorys>
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
  private BaseViewHolder jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = null;
  private IMyStoryListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView;
  protected NewMyStorySegment.DeleteStoryVideoReceiver a;
  protected NewMyStorySegment.StoryVideoPublishStatusReceiver a;
  protected NewMyStorySegment.UpdateUserInfoReceiver a;
  public final UncheckedCallable<GetMyStoryVideoListStep> a;
  private StoryImageDialog jdField_a_of_type_ComTencentBizQqstoryViewStoryImageDialog;
  private Handler jdField_b_of_type_AndroidOsHandler;
  public final UncheckedCallable<GetMyStoryFeatureDataStep> b;
  private boolean jdField_b_of_type_Boolean = false;
  public final UncheckedCallable<GetUserSelfInfoStep> c;
  private boolean c;
  public final UncheckedCallable<GetMyStoryDesFromVidListStep> d = new NewMyStorySegment.4(this);
  
  public NewMyStorySegment(Activity paramActivity, IMyStoryListView paramIMyStoryListView)
  {
    super(paramActivity);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new NewMyStorySegment.1(this);
    this.jdField_b_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new NewMyStorySegment.2(this);
    this.jdField_c_of_type_ComTencentBizQqstoryUtilsUncheckedCallable = new NewMyStorySegment.3(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new NewMyStorySegment.5(this);
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
    paramInt = paramStoryVideoItem.mUnreadLikeCount;
    String str3 = "1";
    String str1;
    if (paramInt > 0) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    String str2 = str3;
    if (!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) {
      if (TextUtils.isEmpty(paramStoryVideoItem.mLabel)) {
        str2 = str3;
      } else {
        str2 = "2";
      }
    }
    StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "2", str1, str2 });
    paramStoryVideoItem = new VidListPlayInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
    StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem, 2, paramView);
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = paramBaseViewHolder;
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374606);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374573);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131374579);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131374577);
    View localView = paramBaseViewHolder.a(2131374578);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a();
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null);
    if (bool) {
      paramInt = -15980466;
    } else {
      paramInt = -657931;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).a();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b() == 0)
    {
      paramViewGroup.setImageResource(2130847059);
    }
    else if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl)))
    {
      UIUtils.b(paramViewGroup, ThumbnailUrlHelper.b(localQQUserUIItem.headUrl), 200, 200, ImageUtil.a(1), "QQStory200");
    }
    else
    {
      SLog.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
      paramViewGroup.setImageResource(2130847059);
      GetUserInfoHandler.d();
    }
    localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
    if (this.jdField_b_of_type_Boolean)
    {
      if (bool) {
        localImageView2.setImageResource(2130846898);
      } else {
        localImageView2.setImageResource(2130846897);
      }
      localImageView2.setContentDescription(HardCodeUtil.a(2131707540));
    }
    else
    {
      if (bool) {
        localImageView2.setImageResource(2130846896);
      } else {
        localImageView2.setImageResource(2130846895);
      }
      localImageView2.setContentDescription(HardCodeUtil.a(2131707531));
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > 0) {
      localImageView2.setVisibility(0);
    } else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b() != 0) {
      localImageView2.setVisibility(8);
    } else {
      localImageView2.setVisibility(8);
    }
    if (this.jdField_b_of_type_Boolean) {
      localImageView1.setVisibility(0);
    } else {
      localImageView1.setVisibility(8);
    }
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    paramBaseViewHolder.a().findViewById(2131374603).setOnClickListener(paramBaseViewHolder);
    if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener == null) {
      paramBaseViewHolder.a(new NewMyStorySegment.9(this));
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
    String str;
    if (paramMyStorys.d) {
      str = "1";
    } else {
      str = "2";
    }
    if (paramMyStorys.b() == 0)
    {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewIMyStoryListView.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131374606) {
      StoryReportor.a("mystory", "clk_head_data", 0, 0, new String[0]);
    } else {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
    paramMyStorys = QQStoryContext.a().b();
    StoryApi.a(this.jdField_a_of_type_AndroidContentContext, 3, paramMyStorys);
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.b()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131374566);
    if (paramStoryVideoItem.mUnreadLikeCount > 0)
    {
      a(paramInt, paramStoryVideoItem, localStoryCoverView.a);
      return;
    }
    paramInt = paramStoryVideoItem.mUnreadLikeCount;
    String str = "2";
    if (paramInt > 0) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    if ((!TextUtils.isEmpty(paramStoryVideoItem.mDoodleText)) || (!TextUtils.isEmpty(paramStoryVideoItem.mLabel))) {
      str = "1";
    }
    StoryReportor.a("mystory", "clk_onevideo", 0, 0, new String[] { "1", paramView, str });
    paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid), 2);
    StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidAppActivity, paramStoryVideoItem.a(), localStoryCoverView.a);
  }
  
  private void b(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int i = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramBaseViewHolder.a(2131374566);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131374580);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374567);
    Object localObject1 = (TextView)paramBaseViewHolder.a(2131374608);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131374569);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131374611);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374572);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131374565);
    paramViewGroup = (Button)paramBaseViewHolder.a(2131374607);
    ImageView localImageView4 = (ImageView)paramBaseViewHolder.a(2131374570);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
    if ((localObject2 != null) && (((MyStorys)localObject2).a() != null))
    {
      paramBaseViewHolder.a().setTag(-3, Integer.valueOf(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 84.0F)));
      paramViewGroup.setOnClickListener(paramBaseViewHolder);
      paramViewGroup = (ImageView)paramBaseViewHolder.a(2131374570);
      localObject2 = (ImageView)paramBaseViewHolder.a(2131374571);
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        paramInt = -15980466;
      } else {
        paramInt = -657931;
      }
      paramViewGroup.setBackgroundColor(paramInt);
      ((ImageView)localObject2).setBackgroundColor(paramInt);
      localObject2 = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(i);
      SLog.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(i), ((StoryVideoItem)localObject2).toString());
      if (StoryListUtils.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath)) {}
      for (paramViewGroup = ImageDownloader.FILE.a(((StoryVideoItem)localObject2).mVideoLocalThumbnailPath);; paramViewGroup = ThumbnailUrlHelper.a(((StoryVideoItem)localObject2).mVideoThumbnailUrl))
      {
        break;
        if (((StoryVideoItem)localObject2).mVideoThumbnailUrl == null)
        {
          paramViewGroup = new StringBuilder();
          paramViewGroup.append("mVideoThumbnailUrl is null! vid=");
          paramViewGroup.append(((StoryVideoItem)localObject2).mVid);
          SLog.e("NewMyStorySegment", paramViewGroup.toString());
        }
      }
      UIUtils.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, UIUtils.b, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(UIUtils.b(this.jdField_a_of_type_AndroidContentContext, 160.0F));
      localImageView4.setVisibility(0);
      paramInt = ((StoryVideoItem)localObject2).mUploadStatus;
      if (paramInt != 9)
      {
        switch (paramInt)
        {
        default: 
          break;
        case 3: 
        case 6: 
          localTextView2.setVisibility(8);
          localTextView1.setVisibility(0);
          if (((StoryVideoItem)localObject2).mUpLoadFailedError == 10404) {
            localTextView1.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getText(2131699936));
          }
          ((TextView)localObject1).setVisibility(8);
          localImageView3.setVisibility(8);
          localImageView1.setVisibility(0);
          localTextView3.setVisibility(8);
          break;
        case 1: 
        case 2: 
        case 4: 
          localTextView3.setVisibility(0);
          if (StoryVideoItem.isFakeVid(((StoryVideoItem)localObject2).mVid))
          {
            paramInt = StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject2).mVid);
            if (paramInt >= 0)
            {
              paramViewGroup = new StringBuilder();
              paramViewGroup.append(HardCodeUtil.a(2131707535));
              paramViewGroup.append(paramInt);
              paramViewGroup.append("%");
              localTextView3.setText(paramViewGroup.toString());
            }
            paramViewGroup = new NewMyStorySegment.11(this, localTextView3);
            localTextView3.setTag(paramViewGroup);
            StoryVideoUploadProgressManager.a().a(((StoryVideoItem)localObject2).mVid, paramViewGroup);
          }
          else
          {
            if ((localTextView3.getTag() != null) && ((localTextView3.getTag() instanceof StoryVideoUploadProgressManager.UpdateProgressListener))) {
              StoryVideoUploadProgressManager.a().a((StoryVideoUploadProgressManager.UpdateProgressListener)localTextView3.getTag());
            }
            localTextView3.setText(2131699933);
          }
          localTextView2.setVisibility(8);
          ((TextView)localObject1).setVisibility(8);
          localTextView1.setVisibility(8);
          localImageView3.setVisibility(0);
          localImageView1.setVisibility(8);
          break;
        case 0: 
          localTextView3.setVisibility(0);
          localTextView3.setText(HardCodeUtil.a(2131707534));
          localTextView2.setVisibility(8);
          ((TextView)localObject1).setVisibility(8);
          localTextView1.setVisibility(8);
          localImageView3.setVisibility(0);
          localImageView1.setVisibility(8);
          break;
        case -1: 
        case 5: 
          localTextView3.setVisibility(8);
          if (!TextUtils.isEmpty(((StoryVideoItem)localObject2).mDoodleText))
          {
            ((TextView)localObject1).setText(((StoryVideoItem)localObject2).mDoodleText);
            ((TextView)localObject1).setVisibility(0);
          }
          else
          {
            ((TextView)localObject1).setVisibility(8);
          }
          localTextView1.setVisibility(8);
          localImageView3.setVisibility(0);
          localImageView1.setVisibility(8);
          if ((((StoryVideoItem)localObject2).mVideoSpreadGroupList != null) && (((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_Int == 4) && (!((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            paramViewGroup = ((TroopManager)PlayModeUtils.a().getManager(QQManagerFactory.TROOP_MANAGER)).b((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.jdField_a_of_type_JavaUtilList.get(0));
            if ((paramViewGroup != null) && (!TextUtils.isEmpty(paramViewGroup.getTroopDisplayName())))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707536));
              ((StringBuilder)localObject1).append(paramViewGroup.getTroopDisplayName());
              paramViewGroup = ((StringBuilder)localObject1).toString();
              bool = true;
              break label987;
            }
          }
          paramViewGroup = "";
          bool = false;
          label987:
          localObject1 = paramViewGroup;
          if (TextUtils.isEmpty(paramViewGroup)) {
            localObject1 = a((StoryVideoItem)localObject2);
          }
          localTextView2.setText((CharSequence)localObject1);
          localTextView2.setVisibility(0);
          break;
        }
      }
      else
      {
        localTextView3.setVisibility(0);
        localTextView3.setText(HardCodeUtil.a(2131707539));
        localTextView2.setVisibility(8);
        ((TextView)localObject1).setVisibility(8);
        localTextView1.setVisibility(8);
        localImageView3.setVisibility(0);
        localImageView1.setVisibility(8);
      }
      boolean bool = false;
      a((StoryVideoItem)localObject2, localImageView2);
      if ((((StoryVideoItem)localObject2).mViewTotalTime <= 0L) && (!bool)) {
        localTextView2.setEnabled(false);
      } else {
        localTextView2.setEnabled(true);
      }
      paramBaseViewHolder.jdField_b_of_type_Int = i;
      paramBaseViewHolder.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
      localTextView2.setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      paramViewGroup = paramBaseViewHolder.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707533));
      ((StringBuilder)localObject1).append(QQStoryConstant.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707545));
      ((StringBuilder)localObject1).append(i + 1);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131707532));
      paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
      localTextView1.setOnClickListener(paramBaseViewHolder);
      localImageView1.setOnClickListener(paramBaseViewHolder);
      if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener == null) {
        paramBaseViewHolder.a(new NewMyStorySegment.12(this, bool));
      }
      return;
    }
    SLog.e("NewMyStorySegment", "myStorys is null!");
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131374567);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131374608);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131374569);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131374611);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131374565);
    if (paramInt != 9)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 3: 
      case 6: 
        localTextView1.setVisibility(8);
        localTextView3.setVisibility(0);
        localTextView2.setVisibility(8);
        paramBaseViewHolder.setVisibility(8);
        localImageView.setVisibility(0);
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
      case 0: 
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
      return;
    }
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
    localTextView3.setVisibility(8);
    paramBaseViewHolder.setVisibility(0);
    localImageView.setVisibility(8);
  }
  
  private void c(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramBaseViewHolder.a(2131370041);
    View localView1 = paramBaseViewHolder.a(2131370072);
    View localView2 = paramBaseViewHolder.a(2131370073);
    paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167149);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramBaseViewHolder.a(2131378586);
    localView1 = paramBaseViewHolder.a(2131378489);
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    localView1.setOnClickListener(paramBaseViewHolder);
    if (paramBaseViewHolder.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener == null) {
      paramBaseViewHolder.a(new NewMyStorySegment.13(this));
    }
  }
  
  protected void M_() {}
  
  public int a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        MyStorys localMyStorys = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
        if ((localMyStorys != null) && (localMyStorys.a().size() > 0)) {
          return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() + 2;
        }
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
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          c(paramInt, paramBaseViewHolder, paramViewGroup);
        }
      }
      else {
        b(paramInt, paramBaseViewHolder, paramViewGroup);
      }
    }
    else {
      a(paramInt, paramBaseViewHolder, paramViewGroup);
    }
    return paramBaseViewHolder.a();
  }
  
  public SerialStepExecutor a()
  {
    return new SerialStepExecutor(new Handler(ThreadManager.getSubThreadLooper()));
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = a(paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramViewGroup = null;
        } else {
          paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561674, paramViewGroup, false);
        }
      }
      else {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561780, paramViewGroup, false);
      }
    }
    else {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561779, paramViewGroup, false);
    }
    if (paramViewGroup != null) {
      return new BaseViewHolder(paramViewGroup);
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
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131707541), 0).a();
    m();
  }
  
  protected void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    SLog.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramStoryVideoPublishStatusEvent);
    Object localObject1 = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      SLog.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a((StoryVideoItem)localObject1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b((StoryVideoItem)localObject1);
    }
    if (paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null) {
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode;
    } else {
      SLog.e("NewMyStorySegment", "item error info is null!!");
    }
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
        localObject2 = new SimpleStep.GetResultSimpleStep(new NewMyStorySegment.14(this, (String)localObject2));
        SerialStepExecutor localSerialStepExecutor = a();
        a(new Step[] { localObject1, localStep, localObject2 }, localSerialStepExecutor);
      }
    }
    if (paramStoryVideoPublishStatusEvent.jdField_c_of_type_Boolean)
    {
      a().h();
      return;
    }
    m();
  }
  
  public void a(MyStorys paramMyStorys)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys = paramMyStorys;
    GetUserSelfInfoStep.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys);
    c(true);
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    a().hideCurShowingRightView();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > paramInt) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt) != null))
    {
      Object localObject = ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).mVid;
      if (StoryVideoItem.isFakeVid((String)localObject))
      {
        StoryVideoUploadManager.a((String)localObject);
        m();
        if (((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).isUploading()) {
          paramBaseViewHolder = "1";
        } else {
          paramBaseViewHolder = "3";
        }
        StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { paramBaseViewHolder });
        return;
      }
      new DeleteStoryVideoHandler().a((String)localObject);
      ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramInt)).mUploadStatus = 9;
      localObject = (TextView)paramBaseViewHolder.a(2131374572);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(HardCodeUtil.a(2131707543));
      b(paramBaseViewHolder, 9);
      StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
    }
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
    m();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    m();
  }
  
  protected void a(Step[] paramArrayOfStep)
  {
    SerialStepExecutor localSerialStepExecutor = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor;
    if (localSerialStepExecutor != null) {
      localSerialStepExecutor.c();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor = new SerialStepExecutor(this.jdField_a_of_type_AndroidOsHandler);
    a(paramArrayOfStep, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor);
  }
  
  protected void a(Step[] paramArrayOfStep, SerialStepExecutor paramSerialStepExecutor)
  {
    int j = paramArrayOfStep.length;
    int i = 0;
    while (i < j)
    {
      Step localStep = paramArrayOfStep[i];
      try
      {
        paramSerialStepExecutor.a(localStep);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
    paramSerialStepExecutor.a(new NewMyStorySegment.7(this)).a(new NewMyStorySegment.6(this));
    paramSerialStepExecutor.a();
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder)
  {
    super.a_(paramBaseViewHolder);
    Object localObject = (ImageView)paramBaseViewHolder.a(2131374570);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131374569);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131374565);
    if ((localImageView2 != null) && (localImageView1 != null) && (localObject != null))
    {
      ((ImageView)localObject).setVisibility(8);
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > paramBaseViewHolder.jdField_b_of_type_Int)
    {
      localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramBaseViewHolder.jdField_b_of_type_Int);
      boolean bool = ((StoryVideoItem)localObject).isUploadSuc();
      paramBaseViewHolder = "2";
      if (!bool) {
        if (((StoryVideoItem)localObject).isUploadFail()) {
          paramBaseViewHolder = "3";
        } else if (((StoryVideoItem)localObject).isUploading()) {
          paramBaseViewHolder = "1";
        }
      }
      StoryReportor.a("mystory", "slide_del", 0, 0, new String[] { paramBaseViewHolder });
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
    ((ImageView)paramBaseViewHolder.a(2131374570)).setVisibility(0);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().size() > paramBaseViewHolder.jdField_b_of_type_Int) {
      b(paramBaseViewHolder, ((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a().get(paramBaseViewHolder.jdField_b_of_type_Int)).mUploadStatus);
    }
  }
  
  protected void c()
  {
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$StoryVideoPublishStatusReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$DeleteStoryVideoReceiver);
    StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$UpdateUserInfoReceiver);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
    List localList = ((StoryManager)SuperManager.a(5)).d(QQStoryContext.a().b());
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.b();
    MyStorys localMyStorys = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager;
    Integer localInteger = Integer.valueOf(-1);
    int i = ((Integer)((StoryConfigManager)localObject).b("qqstory_i_am_vip", localInteger)).intValue();
    localObject = Integer.valueOf(0);
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localMyStorys.jdField_c_of_type_Boolean = bool;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_fans_count", localObject)).intValue();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_vidoe_count", localObject)).intValue();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_Long = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_visiter_count", localObject)).intValue();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_b_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_newest_video_cover", ""));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_c_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_newest_video_vid", ""));
    localMyStorys = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys;
    if (((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_my_story_have_contributed", localInteger)).intValue() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localMyStorys.jdField_b_of_type_Boolean = bool;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_JavaLangString = ((String)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_feed_id", ""));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_a_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_like_count", localObject)).intValue();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_b_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_comment_count", localObject)).intValue();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.jdField_a_of_type_ComTencentBizQqstoryModelItemFeedFeatureItem.jdField_c_of_type_Int = ((Integer)this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("qqstory_key_story_latest_feed_feature_total_view_count", localObject)).intValue();
    if (localList.size() == 0) {
      SLog.d("NewMyStorySegment", "Story DB have no mystory data!");
    }
    Collections.sort(localList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a(localList);
    SLog.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistMyStorys.a()) });
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void d()
  {
    super.d();
    this.jdField_c_of_type_Boolean = false;
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$StoryVideoPublishStatusReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$DeleteStoryVideoReceiver);
    StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentNewMyStorySegment$UpdateUserInfoReceiver);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistModelRequestSerialStepExecutor.c();
    StoryImageDialog localStoryImageDialog = this.jdField_a_of_type_ComTencentBizQqstoryViewStoryImageDialog;
    if (localStoryImageDialog != null) {
      localStoryImageDialog.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.a().removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
  }
  
  protected int d_()
  {
    return 3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      a((MyStorys)paramMessage.obj);
    }
    return true;
  }
  
  public boolean isValidate()
  {
    return this.jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment
 * JD-Core Version:    0.7.0.1
 */