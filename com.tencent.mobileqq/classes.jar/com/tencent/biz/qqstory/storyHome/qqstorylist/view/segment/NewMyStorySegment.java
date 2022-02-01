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
  private static final StringBuilder x = new StringBuilder();
  protected StoryConfigManager a;
  protected SerialStepExecutor b;
  protected NewMyStorySegment.StoryVideoPublishStatusReceiver c;
  protected NewMyStorySegment.DeleteStoryVideoReceiver d;
  protected NewMyStorySegment.UpdateUserInfoReceiver e;
  public final UncheckedCallable<GetMyStoryVideoListStep> f = new NewMyStorySegment.1(this);
  public final UncheckedCallable<GetMyStoryFeatureDataStep> g = new NewMyStorySegment.2(this);
  public final UncheckedCallable<GetUserSelfInfoStep> h = new NewMyStorySegment.3(this);
  public final UncheckedCallable<GetMyStoryDesFromVidListStep> i = new NewMyStorySegment.4(this);
  protected QQStoryObserver j = new NewMyStorySegment.5(this);
  private MyStorys k;
  private boolean n = false;
  private float o;
  private QQUserUIItem p;
  private boolean q = false;
  private Activity r;
  private IMyStoryListView s;
  private Handler t;
  private Handler u;
  private StoryImageDialog v;
  private BaseViewHolder w = null;
  
  public NewMyStorySegment(Activity paramActivity, IMyStoryListView paramIMyStoryListView)
  {
    super(paramActivity);
    this.r = paramActivity;
    this.s = paramIMyStoryListView;
    this.o = (UIUtils.b(this.l) - UIUtils.a(this.l, 145.0F));
    this.a = ((StoryConfigManager)SuperManager.a(10));
    this.t = new Handler(ThreadManager.getSubThreadLooper());
    this.b = new SerialStepExecutor(this.t);
    this.u = new Handler(Looper.getMainLooper(), this);
    this.k = new MyStorys();
    this.c = new NewMyStorySegment.StoryVideoPublishStatusReceiver(this);
    this.d = new NewMyStorySegment.DeleteStoryVideoReceiver(this);
    this.e = new NewMyStorySegment.UpdateUserInfoReceiver(this);
    QQStoryContext.a();
    QQStoryContext.j().addObserver(this.j);
  }
  
  private String a(StoryVideoItem paramStoryVideoItem)
  {
    x.append(StoryListUtils.b(paramStoryVideoItem.mCreateTime));
    paramStoryVideoItem = x.toString();
    x.setLength(0);
    return paramStoryVideoItem;
  }
  
  private String a(MyStorys paramMyStorys, int paramInt, TextPaint paramTextPaint)
  {
    x.append(paramMyStorys.a(paramInt, paramTextPaint));
    paramMyStorys = x.toString();
    x.setLength(0);
    return paramMyStorys;
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    PlayModeUtils.a(paramStoryVideoItem, this.l);
  }
  
  private void a(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.d()) {
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
    paramStoryVideoItem = new VidListPlayInfo(this.k.t.a, paramStoryVideoItem.mVid);
    StoryPlayerLauncher.a(this.r, paramStoryVideoItem, 2, paramView);
  }
  
  private void a(StoryVideoItem paramStoryVideoItem, ImageView paramImageView)
  {
    paramImageView.setVisibility(4);
  }
  
  private void a(MyStorys paramMyStorys, View paramView)
  {
    if (UIUtils.d()) {
      return;
    }
    String str;
    if (paramMyStorys.s) {
      str = "1";
    } else {
      str = "2";
    }
    if (paramMyStorys.c() == 0)
    {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "2", "2", str });
      this.s.a(false, true, 2, null);
      return;
    }
    if (paramView.getId() == 2131442776) {
      StoryReportor.a("mystory", "clk_head_data", 0, 0, new String[0]);
    } else {
      StoryReportor.a("mystory", "clk_mystory", 0, 0, new String[] { "4", "2", str });
    }
    paramMyStorys = QQStoryContext.a().i();
    StoryApi.a(this.l, 3, paramMyStorys);
  }
  
  private void b(int paramInt, StoryVideoItem paramStoryVideoItem, View paramView)
  {
    if (UIUtils.d()) {
      return;
    }
    StoryCoverView localStoryCoverView = (StoryCoverView)paramView.findViewById(2131442736);
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
    paramStoryVideoItem = new OpenPlayerBuilder(new VidListPlayInfo(this.k.t.a, paramStoryVideoItem.mVid), 2);
    StoryPlayerLauncher.a(this.r, paramStoryVideoItem.f(), localStoryCoverView.a);
  }
  
  private void b(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    this.w = paramBaseViewHolder;
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442776);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131442743);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131442749);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131442747);
    View localView = paramBaseViewHolder.a(2131442748);
    this.k.d();
    QQStoryContext.a();
    boolean bool = ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null);
    if (bool) {
      paramInt = -15980466;
    } else {
      paramInt = -657931;
    }
    localImageView1.setBackgroundColor(paramInt);
    QQUserUIItem localQQUserUIItem = ((UserManager)SuperManager.a(2)).c();
    if (this.k.c() == 0)
    {
      paramViewGroup.setImageResource(2130848611);
    }
    else if ((localQQUserUIItem != null) && (!TextUtils.isEmpty(localQQUserUIItem.headUrl)))
    {
      UIUtils.b(paramViewGroup, ThumbnailUrlHelper.b(localQQUserUIItem.headUrl), 200, 200, ImageUtil.b(1), "QQStory200");
    }
    else
    {
      SLog.c("NewMyStorySegment", "Self HeadUrl is NULL!", new IllegalStateException());
      paramViewGroup.setImageResource(2130848611);
      GetUserInfoHandler.e();
    }
    localTextView.post(new NewMyStorySegment.8(this, localTextView, localView, localImageView2));
    if (this.n)
    {
      if (bool) {
        localImageView2.setImageResource(2130848450);
      } else {
        localImageView2.setImageResource(2130848449);
      }
      localImageView2.setContentDescription(HardCodeUtil.a(2131905355));
    }
    else
    {
      if (bool) {
        localImageView2.setImageResource(2130848448);
      } else {
        localImageView2.setImageResource(2130848447);
      }
      localImageView2.setContentDescription(HardCodeUtil.a(2131905346));
    }
    if (this.k.b().size() > 0) {
      localImageView2.setVisibility(0);
    } else if (this.k.c() != 0) {
      localImageView2.setVisibility(8);
    } else {
      localImageView2.setVisibility(8);
    }
    if (this.n) {
      localImageView1.setVisibility(0);
    } else {
      localImageView1.setVisibility(8);
    }
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    paramBaseViewHolder.a().findViewById(2131442773).setOnClickListener(paramBaseViewHolder);
    if (paramBaseViewHolder.i == null) {
      paramBaseViewHolder.a(new NewMyStorySegment.9(this));
    }
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131442737);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131442778);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131442739);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131442781);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131442735);
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
    int m = paramInt - 1;
    StoryCoverView localStoryCoverView = (StoryCoverView)paramBaseViewHolder.a(2131442736);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131442750);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131442737);
    Object localObject1 = (TextView)paramBaseViewHolder.a(2131442778);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131442739);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131442781);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131442742);
    ImageView localImageView3 = (ImageView)paramBaseViewHolder.a(2131442735);
    paramViewGroup = (Button)paramBaseViewHolder.a(2131442777);
    ImageView localImageView4 = (ImageView)paramBaseViewHolder.a(2131442740);
    Object localObject2 = this.k;
    if ((localObject2 != null) && (((MyStorys)localObject2).b() != null))
    {
      paramBaseViewHolder.a().setTag(-3, Integer.valueOf(UIUtils.a(this.l, 84.0F)));
      paramViewGroup.setOnClickListener(paramBaseViewHolder);
      paramViewGroup = (ImageView)paramBaseViewHolder.a(2131442740);
      localObject2 = (ImageView)paramBaseViewHolder.a(2131442741);
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.k(), false, null)) {
        paramInt = -15980466;
      } else {
        paramInt = -657931;
      }
      paramViewGroup.setBackgroundColor(paramInt);
      ((ImageView)localObject2).setBackgroundColor(paramInt);
      localObject2 = (StoryVideoItem)this.k.b().get(m);
      SLog.a("NewMyStorySegment", "bindMyStoryChildItem(%d) == %s", Integer.valueOf(m), ((StoryVideoItem)localObject2).toString());
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
      UIUtils.a(localStoryCoverView.a, paramViewGroup, 106, 170, 5, UIUtils.h, "myStory");
      localStoryCoverView.setPollLayout(((StoryVideoItem)localObject2).getPollLayout(), -1, null);
      localStoryCoverView.setRateLayout(((StoryVideoItem)localObject2).getInteractLayout(), -1, -1L, -1);
      ((TextView)localObject1).setMaxWidth(UIUtils.b(this.l, 160.0F));
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
            localTextView1.setText(this.l.getResources().getText(2131897989));
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
            paramInt = StoryVideoUploadProgressManager.a().f(((StoryVideoItem)localObject2).mVid);
            if (paramInt >= 0)
            {
              paramViewGroup = new StringBuilder();
              paramViewGroup.append(HardCodeUtil.a(2131905350));
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
            localTextView3.setText(2131897986);
          }
          localTextView2.setVisibility(8);
          ((TextView)localObject1).setVisibility(8);
          localTextView1.setVisibility(8);
          localImageView3.setVisibility(0);
          localImageView1.setVisibility(8);
          break;
        case 0: 
          localTextView3.setVisibility(0);
          localTextView3.setText(HardCodeUtil.a(2131905349));
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
          if ((((StoryVideoItem)localObject2).mVideoSpreadGroupList != null) && (((StoryVideoItem)localObject2).mVideoSpreadGroupList.a == 4) && (!((StoryVideoItem)localObject2).mVideoSpreadGroupList.b.isEmpty()))
          {
            paramViewGroup = ((TroopManager)PlayModeUtils.b().getManager(QQManagerFactory.TROOP_MANAGER)).f((String)((StoryVideoItem)localObject2).mVideoSpreadGroupList.b.get(0));
            if ((paramViewGroup != null) && (!TextUtils.isEmpty(paramViewGroup.getTroopDisplayName())))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905351));
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
        localTextView3.setText(HardCodeUtil.a(2131905354));
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
      paramBaseViewHolder.f = m;
      paramBaseViewHolder.h = this.k;
      localTextView2.setOnClickListener(paramBaseViewHolder);
      paramBaseViewHolder.a().setOnClickListener(paramBaseViewHolder);
      paramViewGroup = paramBaseViewHolder.a();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905348));
      ((StringBuilder)localObject1).append(QQStoryConstant.a);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905360));
      ((StringBuilder)localObject1).append(m + 1);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905347));
      paramViewGroup.setContentDescription(((StringBuilder)localObject1).toString());
      localTextView1.setOnClickListener(paramBaseViewHolder);
      localImageView1.setOnClickListener(paramBaseViewHolder);
      if (paramBaseViewHolder.i == null) {
        paramBaseViewHolder.a(new NewMyStorySegment.12(this, bool));
      }
      return;
    }
    SLog.e("NewMyStorySegment", "myStorys is null!");
  }
  
  private void d(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramBaseViewHolder.a(2131437197);
    View localView1 = paramBaseViewHolder.a(2131437233);
    View localView2 = paramBaseViewHolder.a(2131437234);
    paramInt = this.l.getResources().getColor(2131168130);
    paramViewGroup.setBackgroundColor(paramInt);
    localView1.setBackgroundColor(paramInt);
    localView2.setBackgroundColor(paramInt);
    paramViewGroup = paramBaseViewHolder.a(2131447215);
    localView1 = paramBaseViewHolder.a(2131447104);
    paramViewGroup.setOnClickListener(paramBaseViewHolder);
    localView1.setOnClickListener(paramBaseViewHolder);
    if (paramBaseViewHolder.i == null) {
      paramBaseViewHolder.a(new NewMyStorySegment.13(this));
    }
  }
  
  public int a()
  {
    if (this.q)
    {
      if (this.n)
      {
        MyStorys localMyStorys = this.k;
        if ((localMyStorys != null) && (localMyStorys.b().size() > 0)) {
          return this.k.b().size() + 2;
        }
      }
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    int m = g_(paramInt);
    SLog.a("NewMyStorySegment", "bindView(%d, %d)", Integer.valueOf(paramInt), Integer.valueOf(m));
    if (m != 0)
    {
      if (m != 1)
      {
        if (m == 2) {
          d(paramInt, paramBaseViewHolder, paramViewGroup);
        }
      }
      else {
        c(paramInt, paramBaseViewHolder, paramViewGroup);
      }
    }
    else {
      b(paramInt, paramBaseViewHolder, paramViewGroup);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    paramInt = g_(paramInt);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          paramViewGroup = null;
        } else {
          paramViewGroup = LayoutInflater.from(this.l).inflate(2131628053, paramViewGroup, false);
        }
      }
      else {
        paramViewGroup = LayoutInflater.from(this.l).inflate(2131628159, paramViewGroup, false);
      }
    }
    else {
      paramViewGroup = LayoutInflater.from(this.l).inflate(2131628158, paramViewGroup, false);
    }
    if (paramViewGroup != null) {
      return new BaseViewHolder(paramViewGroup);
    }
    return new BaseViewHolder(new TextView(this.l));
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.k.a(paramString);
    if (paramString != null) {
      paramString.mUploadStatus = paramInt;
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131905356), 0).show();
    u();
  }
  
  protected void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    SLog.a("NewMyStorySegment", "handleStoryVideoPublishEvent event=%s", paramStoryVideoPublishStatusEvent);
    Object localObject1 = paramStoryVideoPublishStatusEvent.c;
    if (this.k.a(((StoryVideoItem)localObject1).mVid) == null)
    {
      SLog.b("NewMyStorySegment", "handleStoryVideoPublishEvent add the new item to myStory list");
      this.k.a((StoryVideoItem)localObject1);
    }
    else
    {
      this.k.b((StoryVideoItem)localObject1);
    }
    if (paramStoryVideoPublishStatusEvent.g != null) {
      ((StoryVideoItem)localObject1).mUpLoadFailedError = paramStoryVideoPublishStatusEvent.g.errorCode;
    } else {
      SLog.e("NewMyStorySegment", "item error info is null!!");
    }
    if (paramStoryVideoPublishStatusEvent.d != null)
    {
      this.k.a(((StoryVideoItem)localObject1).mVid, paramStoryVideoPublishStatusEvent.d);
      this.k.g = paramStoryVideoPublishStatusEvent.e.mIsContribute;
      if ((!TextUtils.isEmpty(paramStoryVideoPublishStatusEvent.e.feedId)) && (!TextUtils.equals(this.k.t.a, paramStoryVideoPublishStatusEvent.e.feedId)))
      {
        SLog.a("NewMyStorySegment", "handleStoryVideoPublishEvent feedId changed from %s to %s", this.k.t.a, paramStoryVideoPublishStatusEvent.e.feedId);
        Object localObject2 = paramStoryVideoPublishStatusEvent.e.feedId;
        localObject1 = new SimpleStep.InitParamSimpleStep(GetMyStoryVideoListStep.Result.a((String)localObject2));
        Step localStep = (Step)this.g.b();
        localObject2 = new SimpleStep.GetResultSimpleStep(new NewMyStorySegment.14(this, (String)localObject2));
        SerialStepExecutor localSerialStepExecutor = j();
        a(new Step[] { localObject1, localStep, localObject2 }, localSerialStepExecutor);
      }
    }
    if (paramStoryVideoPublishStatusEvent.h)
    {
      w().i();
      return;
    }
    u();
  }
  
  public void a(MyStorys paramMyStorys)
  {
    this.k = paramMyStorys;
    GetUserSelfInfoStep.a(this.k);
    e(true);
  }
  
  public void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    w().hideCurShowingRightView();
    if ((this.k.b().size() > paramInt) && (this.k.b().get(paramInt) != null))
    {
      Object localObject = ((StoryVideoItem)this.k.b().get(paramInt)).mVid;
      if (StoryVideoItem.isFakeVid((String)localObject))
      {
        StoryVideoUploadManager.a((String)localObject);
        u();
        if (((StoryVideoItem)this.k.b().get(paramInt)).isUploading()) {
          paramBaseViewHolder = "1";
        } else {
          paramBaseViewHolder = "3";
        }
        StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { paramBaseViewHolder });
        return;
      }
      new DeleteStoryVideoHandler().a((String)localObject);
      ((StoryVideoItem)this.k.b().get(paramInt)).mUploadStatus = 9;
      localObject = (TextView)paramBaseViewHolder.a(2131442742);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(HardCodeUtil.a(2131905358));
      b(paramBaseViewHolder, 9);
      StoryReportor.a("mystory", "del_onevideo", 0, 0, new String[] { "2" });
    }
  }
  
  public void a(String paramString)
  {
    paramString = this.k.a(paramString);
    this.k.c(paramString);
    if (this.k.b().size() == 0)
    {
      this.n = false;
      this.k.g = false;
    }
    ((FeedVideoManager)SuperManager.a(12)).a(this.k.t.a, 0, paramString);
    u();
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    u();
  }
  
  protected void a(Step[] paramArrayOfStep)
  {
    SerialStepExecutor localSerialStepExecutor = this.b;
    if (localSerialStepExecutor != null) {
      localSerialStepExecutor.f();
    }
    this.b = new SerialStepExecutor(this.t);
    a(paramArrayOfStep, this.b);
  }
  
  protected void a(Step[] paramArrayOfStep, SerialStepExecutor paramSerialStepExecutor)
  {
    int i1 = paramArrayOfStep.length;
    int m = 0;
    while (m < i1)
    {
      Step localStep = paramArrayOfStep[m];
      try
      {
        paramSerialStepExecutor.a(localStep);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      m += 1;
    }
    paramSerialStepExecutor.a(new NewMyStorySegment.7(this)).a(new NewMyStorySegment.6(this));
    paramSerialStepExecutor.b();
  }
  
  public void a_(BaseViewHolder paramBaseViewHolder)
  {
    super.a_(paramBaseViewHolder);
    Object localObject = (ImageView)paramBaseViewHolder.a(2131442740);
    ImageView localImageView1 = (ImageView)paramBaseViewHolder.a(2131442739);
    ImageView localImageView2 = (ImageView)paramBaseViewHolder.a(2131442735);
    if ((localImageView2 != null) && (localImageView1 != null) && (localObject != null))
    {
      ((ImageView)localObject).setVisibility(8);
      localImageView1.setVisibility(8);
      localImageView2.setVisibility(8);
    }
    if (this.k.b().size() > paramBaseViewHolder.f)
    {
      localObject = (StoryVideoItem)this.k.b().get(paramBaseViewHolder.f);
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
  
  public String b()
  {
    return "NewMyStorySegment";
  }
  
  public void b_(BaseViewHolder paramBaseViewHolder)
  {
    super.b_(paramBaseViewHolder);
    ((ImageView)paramBaseViewHolder.a(2131442740)).setVisibility(0);
    if (this.k.b().size() > paramBaseViewHolder.f) {
      b(paramBaseViewHolder, ((StoryVideoItem)this.k.b().get(paramBaseViewHolder.f)).mUploadStatus);
    }
  }
  
  protected boolean d(boolean paramBoolean)
  {
    a(new Step[] { (Step)this.f.b(), (Step)this.g.b(), (Step)this.h.b(), (Step)this.i.b() });
    return true;
  }
  
  protected int f()
  {
    return 3;
  }
  
  protected void g()
  {
    StoryDispatcher.a().registerSubscriber(this.c);
    StoryDispatcher.a().registerSubscriber(this.d);
    StoryDispatcher.a().registerSubscriber(this.e);
    this.p = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().i());
    List localList = ((StoryManager)SuperManager.a(5)).g(QQStoryContext.a().i());
    this.k.e();
    MyStorys localMyStorys = this.k;
    Object localObject = this.a;
    Integer localInteger = Integer.valueOf(-1);
    int m = ((Integer)((StoryConfigManager)localObject).c("qqstory_i_am_vip", localInteger)).intValue();
    localObject = Integer.valueOf(0);
    boolean bool;
    if (m == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localMyStorys.h = bool;
    if (this.k.h) {
      this.k.i = ((Integer)this.a.c("qqstory_my_fans_count", localObject)).intValue();
    }
    this.k.j = ((Integer)this.a.c("qqstory_my_vidoe_count", localObject)).intValue();
    this.k.k = ((Integer)this.a.c("qqstory_my_visiter_count", localObject)).intValue();
    this.k.l = ((String)this.a.c("qqstory_my_newest_video_cover", ""));
    this.k.m = ((String)this.a.c("qqstory_my_newest_video_vid", ""));
    localMyStorys = this.k;
    if (((Integer)this.a.c("qqstory_my_story_have_contributed", localInteger)).intValue() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localMyStorys.g = bool;
    this.k.t.a = ((String)this.a.c("qqstory_key_story_latest_feed_feature_feed_id", ""));
    this.k.t.b = ((Integer)this.a.c("qqstory_key_story_latest_feed_feature_total_like_count", localObject)).intValue();
    this.k.t.c = ((Integer)this.a.c("qqstory_key_story_latest_feed_feature_total_comment_count", localObject)).intValue();
    this.k.t.d = ((Integer)this.a.c("qqstory_key_story_latest_feed_feature_total_view_count", localObject)).intValue();
    if (localList.size() == 0) {
      SLog.d("NewMyStorySegment", "Story DB have no mystory data!");
    }
    Collections.sort(localList);
    this.k.a(localList);
    SLog.d("NewMyStorySegment", "Story DB have %s mystory data!", new Object[] { Integer.valueOf(this.k.a()) });
    this.q = true;
  }
  
  protected int g_(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if (paramInt == a() - 1) {
      return 2;
    }
    return 1;
  }
  
  protected void h()
  {
    super.h();
    this.q = false;
    StoryDispatcher.a().unRegisterSubscriber(this.c);
    StoryDispatcher.a().unRegisterSubscriber(this.d);
    StoryDispatcher.a().unRegisterSubscriber(this.e);
    this.t.removeCallbacksAndMessages(null);
    this.b.f();
    StoryImageDialog localStoryImageDialog = this.v;
    if (localStoryImageDialog != null) {
      localStoryImageDialog.dismiss();
    }
    QQStoryContext.a();
    QQStoryContext.j().removeObserver(this.j);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      a((MyStorys)paramMessage.obj);
    }
    return true;
  }
  
  protected void i() {}
  
  public boolean isValidate()
  {
    return this.q;
  }
  
  public SerialStepExecutor j()
  {
    return new SerialStepExecutor(new Handler(ThreadManager.getSubThreadLooper()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment
 * JD-Core Version:    0.7.0.1
 */