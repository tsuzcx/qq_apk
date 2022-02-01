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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

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
  private boolean c = false;
  
  public MemoriesProfileSegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter = new MemoriesProfilePresenter(paramString, this);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a();
  }
  
  private void a(ViewGroup paramViewGroup, ProgressBar paramProgressBar, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.medalLevel;
    int j = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed;
    SLog.a("Q.qqstory.memories.MemoriesProfileSegment", "medalLevel:%s, gradeSpeed:%s", Integer.valueOf(i), Integer.valueOf(j));
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (j >= 0))
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setOnClickListener(this);
      paramProgressBar.setMax(10);
      if (j < 10)
      {
        paramTextView.setText("QQ等级加速");
        paramProgressBar.setProgress(j);
        if (j == 0)
        {
          paramProgressBar.setMax(12);
          paramProgressBar.setProgress(1);
        }
      }
      else
      {
        paramTextView.setText("加速0.5天");
        paramProgressBar.setProgress(10);
      }
    }
    else
    {
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    if ((i >= 0) && ((!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isFriend()) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())))
    {
      paramImageView.setVisibility(0);
      paramImageView.setOnClickListener(this);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramImageView.setVisibility(8);
              paramImageView.setOnClickListener(null);
              return;
            }
            paramImageView.setImageResource(2130846840);
            return;
          }
          paramImageView.setImageResource(2130846841);
          return;
        }
        paramImageView.setImageResource(2130846839);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
      {
        paramImageView.setImageResource(2130846842);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(8);
    paramImageView.setOnClickListener(null);
  }
  
  private void i()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      SLog.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_JavaLangString });
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra = 0;
      ThreadManager.post(new MemoriesProfileSegment.1(this), 5, null, false);
      c(true);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131706563));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    StoryReportor.a("memory", "clk_fan_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = true;
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131706561));
    localIntent.putExtra("isShowAd", false);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    StoryReportor.a("memory", "clk_follow_list", StoryMemoriesFragment.a(this.jdField_b_of_type_Int), 0, new String[] { "", "", "", "" });
  }
  
  private void l()
  {
    AppInterface localAppInterface = QQStoryContext.a();
    Object localObject1 = localAppInterface.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("public_account_qq_mail_");
    ((StringBuilder)localObject2).append(localAppInterface.getCurrentAccountUin());
    localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("profile_card_qim_online_url", null);
    localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
    if ((localAppInterface instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      SegmentList localSegmentList = a();
      if (localSegmentList != null)
      {
        int k = this.jdField_a_of_type_AndroidViewView.getBottom() - (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131299168);
        boolean bool = ImmersiveTitleBar2.TRANSLUCENT_STATUS_BAR;
        int i = 1;
        if ((!bool) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          i = 0;
        }
        int j = k;
        if (i != 0) {
          j = k - (ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext) - UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
        }
        localSegmentList.smoothScrollBy(j, 500);
      }
    }
  }
  
  protected void M_()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.a(false);
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null) {
      return paramBaseViewHolder.a();
    }
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131368504);
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131368502);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131378563);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131368570);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131378589);
    View localView2 = paramBaseViewHolder.a(2131369788);
    View localView3 = paramBaseViewHolder.a(2131369765);
    View localView4 = paramBaseViewHolder.a(2131369885);
    TextView localTextView5 = (TextView)paramBaseViewHolder.a(2131378519);
    TextView localTextView6 = (TextView)paramBaseViewHolder.a(2131378521);
    TextView localTextView7 = (TextView)paramBaseViewHolder.a(2131378612);
    Object localObject3 = (TextView)paramBaseViewHolder.a(2131378070);
    TextView localTextView8 = (TextView)paramBaseViewHolder.a(2131378513);
    TextView localTextView9 = (TextView)paramBaseViewHolder.a(2131378511);
    TextView localTextView10 = (TextView)paramBaseViewHolder.a(2131378512);
    View localView1 = paramBaseViewHolder.a(2131363502);
    ViewGroup localViewGroup = (ViewGroup)paramBaseViewHolder.a(2131367768);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131367769);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131367770);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131370728);
    Object localObject2 = (RedTouch)paramBaseViewHolder.a("redTouch");
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131369753);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131379824);
    View localView5 = paramBaseViewHolder.a(2131366470);
    View localView6 = paramBaseViewHolder.a(2131367062);
    if (QQStoryContext.a())
    {
      localTextView3.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView4.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView7.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView5.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView6.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView8.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView9.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localTextView10.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localFrameLayout.setBackgroundResource(2130846636);
      ((ImageView)localObject1).setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166529));
      localView5.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      localView6.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166528));
      ((TextView)localObject3).setBackgroundResource(2130846772);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl)) {
      UIUtils.a((ImageView)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.backgroundUrl, 0, 0, null);
    }
    UIUtils.b(paramViewGroup, ThumbnailUrlHelper.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.headUrl), 200, 200, ImageUtil.a(1), "QQStory200");
    paramViewGroup.setContentDescription(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setText(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localTextView3.setContentDescription(PlayModeUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem));
    localStoryUserBadgeView.setUnionID(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.getUnionId(), 3);
    if (localStoryUserBadgeView.getVisibility() == 0)
    {
      if (!((Boolean)paramBaseViewHolder.a("hasExposure")).booleanValue())
      {
        paramBaseViewHolder.a("hasExposure", new Boolean(true));
        localStoryUserBadgeView.a();
      }
    }
    else {
      localStoryUserBadgeView.setVisibility(8);
    }
    localTextView4.setText(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.signature);
    localTextView5.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCount, 0)));
    localTextView6.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.followCount, 0)));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isVip()) {
      localView2.setVisibility(0);
    } else {
      localView2.setVisibility(8);
    }
    localTextView7.setText(UIUtils.a(Math.max(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount, 0)));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.videoCount < 0) {
      localView4.setVisibility(8);
    } else {
      localView4.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe())
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
      if (StoryProfileUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem))
      {
        this.jdField_a_of_type_Int = 1;
        paramViewGroup.height = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 254.0F);
      }
      else
      {
        this.jdField_a_of_type_Int = 2;
        paramViewGroup.height = UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 220.0F);
      }
      localView1.setLayoutParams(paramViewGroup);
    }
    if (this.jdField_a_of_type_Int != 1)
    {
      ((TextView)localObject3).setVisibility(8);
    }
    else
    {
      ((TextView)localObject3).setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isSubscribe()) {
        ((TextView)localObject3).setText(HardCodeUtil.a(2131706565));
      } else {
        ((TextView)localObject3).setText(HardCodeUtil.a(2131706572));
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra != 0))
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("+");
      paramViewGroup.append(UIUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.fansCountExtra));
      paramViewGroup = RedPointUtils.a(4, paramViewGroup.toString(), 0);
      ((RedTouch)localObject2).setVisibility(0);
      ((RedTouch)localObject2).a(paramViewGroup);
    }
    else
    {
      ((RedTouch)localObject2).setVisibility(8);
    }
    if (this.c)
    {
      paramViewGroup = QQStoryContext.a();
      localObject1 = paramViewGroup.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("public_account_qq_mail_");
      ((StringBuilder)localObject2).append(paramViewGroup.getCurrentAccountUin());
      localObject2 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0);
      localObject3 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_url", null);
      localObject1 = ((SharedPreferences)localObject2).getString("key_story_qim_online_icon_url", null);
      localObject2 = ((SharedPreferences)localObject2).getString("profile_card_qim_online_wording", null);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText((CharSequence)localObject2);
        paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298151);
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRetryCount = 2;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = paramInt;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = paramInt;
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        ((Drawable)localObject1).setBounds(0, 0, paramInt, paramInt);
        localTextView2.setCompoundDrawables((Drawable)localObject1, null, null, null);
        localTextView2.setContentDescription((CharSequence)localObject2);
        localTextView2.setOnClickListener(this);
        if ((paramViewGroup instanceof QQAppInterface)) {
          ReportController.b((QQAppInterface)paramViewGroup, "dc00898", "", "", "0X8008640", "0X8008640", 3, 0, "", "", "", "");
        }
      }
      else
      {
        localTextView2.setVisibility(8);
      }
    }
    else
    {
      localTextView2.setVisibility(8);
    }
    a(localViewGroup, localProgressBar, localTextView1, localImageView);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561704, paramViewGroup, false);
    paramViewGroup = new BaseViewHolder(this.jdField_a_of_type_AndroidViewView);
    View localView = paramViewGroup.a(2131376329);
    paramViewGroup.a("redTouch", new RedTouch(this.jdField_a_of_type_AndroidViewView.getContext(), localView).b(21).d(3).c(5).a());
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
  
  public void f()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void g()
  {
    String str = QQStoryContext.a().a();
    if (TextUtils.isEmpty(str))
    {
      SLog.e("Q.qqstory.memories.MemoriesProfileSegment", "onGradeSpeedClick, uin is empty");
      return;
    }
    str = String.format("https://story.now.qq.com/m/gaccel/?uin=%s", new Object[] { str });
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 0) {
      i = 1;
    } else if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed > 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed < 10)) {
      i = 2;
    } else if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.gradeSpeed == 10) {
      i = 3;
    } else {
      i = -1;
    }
    StoryReportor.a("memory", "clk_level", 0, 0, new String[] { String.valueOf(i) });
  }
  
  public void h()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {
      str = "https://ti.qq.com/qqmedal2/index.html?from=8&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22";
    } else {
      str = String.format("https://ti.qq.com/qqmedal2/index.html?from=9&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22&tuin=%s", new Object[] { NearbyURLSafeUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.qq) });
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesProfilePresenter.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {
      str = "1";
    } else {
      str = "2";
    }
    StoryReportor.a("memory", "clk_medal", 0, 0, new String[] { str });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131379824: 
      l();
      break;
    case 2131378070: 
      f();
      break;
    case 2131370728: 
      h();
      break;
    case 2131369885: 
      n();
      break;
    case 2131369788: 
      i();
      break;
    case 2131369765: 
      j();
      break;
    case 2131367768: 
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment
 * JD-Core Version:    0.7.0.1
 */