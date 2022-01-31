package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.ProfilePresenterListener;
import com.tencent.biz.qqstory.storyHome.memory.model.StoryProfileUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.RedPointUtils;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.StoryUserBadgeView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import nxq;

public class MemoriesProfileSegment
  extends SegmentView
  implements View.OnClickListener, MemoriesProfilePresenter.ProfilePresenterListener
{
  public static final String KEY = "MemoriesProfileSegment";
  public int a;
  private View jdField_a_of_type_AndroidViewView;
  private MemoriesProfilePresenter jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter;
  public int b;
  private boolean b;
  private boolean c;
  
  public MemoriesProfileSegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter = new MemoriesProfilePresenter(paramString, this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a();
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.fansCountExtra != 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.fansCountExtra = 0;
      ThreadManager.post(new nxq(this), 5, null, false);
      c(true);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", "返回");
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    StoryReportor.a("memory", "clk_fan_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = true;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", "返回");
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    StoryReportor.a("memory", "clk_follow_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void j()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    String str = localAppInterface.getApplication().getSharedPreferences("public_account_qq_mail_" + localAppInterface.getCurrentAccountUin(), 0).getString("profile_card_qim_online_url", null);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if ((localAppInterface instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
    }
  }
  
  private void l()
  {
    int i = 1;
    SegmentList localSegmentList;
    int k;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localSegmentList = a();
      if (localSegmentList != null)
      {
        k = this.jdField_a_of_type_AndroidViewView.getBottom() - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131558448);
        if ((!ImmersiveTitleBar2.a) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          break label91;
        }
      }
    }
    for (;;)
    {
      int j = k;
      if (i != 0) {
        j = k - (ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
      }
      localSegmentList.smoothScrollBy(j, 500);
      return;
      label91:
      i = 0;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a == null) {
      return paramBaseViewHolder.a();
    }
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131371884);
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131371886);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371887);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131371888);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131371890);
    View localView2 = paramBaseViewHolder.a(2131370761);
    View localView3 = paramBaseViewHolder.a(2131371897);
    View localView4 = paramBaseViewHolder.a(2131371892);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131370763);
    TextView localTextView5 = (TextView)paramBaseViewHolder.a(2131370766);
    TextView localTextView6 = (TextView)paramBaseViewHolder.a(2131371894);
    Object localObject3 = (TextView)paramBaseViewHolder.a(2131371695);
    View localView1 = paramBaseViewHolder.a(2131371883);
    Object localObject2 = (RedTouch)paramBaseViewHolder.a("redTouch");
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371889);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.backgroundUrl)) {
      UIUtils.a(paramViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.backgroundUrl, 0, 0, null);
    }
    UIUtils.b((ImageView)localObject1, ThumbnailUrlHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.headUrl), 200, 200, ImageUtil.a(1), "QQStory200");
    ((ImageView)localObject1).setContentDescription(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a));
    localTextView2.setText(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a));
    localTextView2.setContentDescription(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a));
    localStoryUserBadgeView.setUnionID(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.getUnionId(), 3);
    if (((UserManager)SuperManager.a(2)).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.qq))
    {
      localStoryUserBadgeView.setVisibility(8);
      localTextView3.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.signature);
      localTextView4.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.fansCount, 0)));
      localTextView5.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.followCount, 0)));
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isVip()) {
        break label890;
      }
      localView2.setVisibility(0);
      label403:
      localTextView6.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.videoCount, 0)));
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.videoCount >= 0) {
        break label900;
      }
      localView4.setVisibility(8);
      label446:
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isMe())
      {
        localView2.setOnClickListener(this);
        localView3.setOnClickListener(this);
      }
      localView4.setOnClickListener(this);
      ((TextView)localObject3).setOnClickListener(this);
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject1 = (FrameLayout.LayoutParams)localView1.getLayoutParams();
        paramViewGroup = (ViewGroup)localObject1;
        if (localObject1 == null) {
          paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
        }
        if (!StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a)) {
          break label909;
        }
        this.jdField_a_of_type_Int = 1;
        paramViewGroup.height = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 254.0F);
        label554:
        localView1.setLayoutParams(paramViewGroup);
      }
      if (this.jdField_a_of_type_Int == 1) {
        break label934;
      }
      ((TextView)localObject3).setVisibility(8);
      label575:
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.fansCountExtra != 0)) {
        break label975;
      }
      ((RedTouch)localObject2).setVisibility(8);
      label608:
      if (!this.c) {
        break label1039;
      }
      paramViewGroup = QQStoryContext.a();
      localObject2 = paramViewGroup.getApplication().getSharedPreferences("public_account_qq_mail_" + paramViewGroup.getCurrentAccountUin(), 0);
      localObject3 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_url", null);
      localObject1 = ((SharedPreferences)localObject2).getString("key_story_qim_online_icon_url", null);
      localObject2 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_wording", null);
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label1029;
      }
      localTextView1.setVisibility(0);
      localTextView1.setText((CharSequence)localObject2);
      paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559464);
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mRetryCount = 2;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt;
      ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt;
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
      localTextView1.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView1.setContentDescription((CharSequence)localObject2);
      localTextView1.setOnClickListener(this);
      if ((paramViewGroup instanceof QQAppInterface)) {
        ReportController.b((QQAppInterface)paramViewGroup, "dc00898", "", "", "0X8008640", "0X8008640", 3, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      localStoryUserBadgeView.setVisibility(0);
      if (((Boolean)paramBaseViewHolder.a("hasExposure")).booleanValue()) {
        break;
      }
      paramBaseViewHolder.a("hasExposure", new Boolean(true));
      localStoryUserBadgeView.a();
      break;
      label890:
      localView2.setVisibility(8);
      break label403;
      label900:
      localView4.setVisibility(0);
      break label446;
      label909:
      this.jdField_a_of_type_Int = 2;
      paramViewGroup.height = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F);
      break label554;
      label934:
      ((TextView)localObject3).setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isSubscribe())
      {
        ((TextView)localObject3).setText("已关注");
        break label575;
      }
      ((TextView)localObject3).setText("关注");
      break label575;
      label975:
      paramViewGroup = RedPointUtils.a(4, "+" + UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.fansCountExtra), 0);
      ((RedTouch)localObject2).setVisibility(0);
      ((RedTouch)localObject2).a(paramViewGroup);
      break label608;
      label1029:
      localTextView1.setVisibility(8);
      continue;
      label1039:
      localTextView1.setVisibility(8);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970772, paramViewGroup, false);
    paramViewGroup = new BaseViewHolder(this.jdField_a_of_type_AndroidViewView);
    View localView = paramViewGroup.a(2131371896);
    paramViewGroup.a("redTouch", new RedTouch(this.jdField_a_of_type_AndroidViewView.getContext(), localView).a(21).c(3).b(5).a());
    paramViewGroup.a("hasExposure", new Boolean(false));
    return paramViewGroup;
  }
  
  public String a()
  {
    return "MemoriesProfileSegment";
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      c(true);
      return;
    }
    c(false);
  }
  
  protected boolean a_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a(false);
    return true;
  }
  
  protected void b()
  {
    super.b();
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    c(true);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a(true);
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.b();
  }
  
  protected void e()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a(false);
    }
  }
  
  public void f()
  {
    SLog.c("Q.qqstory.memories.MemoriesProfileSegment", "on subscribe button click. ");
    int j = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isSubscribe;
    Object localObject = (QQStoryHandler)PlayModeUtils.a().a(98);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isVip())
    {
      i = 1;
      ((QQStoryHandler)localObject).a(i, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.uid, j, 2);
      i = StoryMemoriesFragment.a(this.jdField_b_of_type_Int);
      if (j != 1) {
        break label138;
      }
      localObject = "2";
      label81:
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a.isVip()) {
        break label145;
      }
    }
    label138:
    label145:
    for (String str = "1";; str = "2")
    {
      StoryReportor.a("memory", "follow_card", i, 0, new String[] { localObject, str, "", "" });
      return;
      i = 0;
      break;
      localObject = "1";
      break label81;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131370761: 
      h();
      return;
    case 2131371897: 
      i();
      return;
    case 2131371889: 
      j();
      return;
    case 2131371892: 
      l();
      return;
    }
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment
 * JD-Core Version:    0.7.0.1
 */