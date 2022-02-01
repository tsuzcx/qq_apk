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
  public int a = 0;
  public int b;
  private MemoriesProfilePresenter c;
  private boolean d = false;
  private boolean e = false;
  private View f;
  
  public MemoriesProfileSegment(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
    this.b = paramInt;
    this.c = new MemoriesProfilePresenter(paramString, this);
    this.c.a();
  }
  
  private void a(ViewGroup paramViewGroup, ProgressBar paramProgressBar, TextView paramTextView, ImageView paramImageView)
  {
    int i = this.c.b.medalLevel;
    int j = this.c.b.gradeSpeed;
    SLog.a("Q.qqstory.memories.MemoriesProfileSegment", "medalLevel:%s, gradeSpeed:%s", Integer.valueOf(i), Integer.valueOf(j));
    if ((this.c.b.isMe()) && (j >= 0))
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
    if ((i >= 0) && ((!this.c.b.isVip()) || (this.c.b.isFriend()) || (this.c.b.isMe())))
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
            paramImageView.setImageResource(2130848392);
            return;
          }
          paramImageView.setImageResource(2130848393);
          return;
        }
        paramImageView.setImageResource(2130848391);
        return;
      }
      if (this.c.b.isMe())
      {
        paramImageView.setImageResource(2130848394);
        return;
      }
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(8);
    paramImageView.setOnClickListener(null);
  }
  
  private void m()
  {
    this.d = true;
    if (this.c.b == null)
    {
      SLog.d("Q.qqstory.memories.MemoriesProfileSegment", "current userUIItem is null, %s", new Object[] { this.c.a });
      return;
    }
    if (this.c.b.fansCountExtra != 0)
    {
      this.c.b.fansCountExtra = 0;
      ThreadManager.post(new MemoriesProfileSegment.1(this), 5, null, false);
      e(true);
    }
    Intent localIntent = new Intent(this.l, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/fans_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("isShowAd", false);
    this.l.startActivity(localIntent);
    StoryReportor.a("memory", "clk_fan_list", StoryMemoriesFragment.a(this.b), 0, new String[] { "", "", "", "" });
  }
  
  private void n()
  {
    this.d = true;
    Intent localIntent = new Intent(this.l, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://story.now.qq.com/mobile/follow_list.html?_wv=1031&_bid=2603");
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("isShowAd", false);
    this.l.startActivity(localIntent);
    StoryReportor.a("memory", "clk_follow_list", StoryMemoriesFragment.a(this.b), 0, new String[] { "", "", "", "" });
  }
  
  private void p()
  {
    AppInterface localAppInterface = QQStoryContext.k();
    Object localObject1 = localAppInterface.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("public_account_qq_mail_");
    ((StringBuilder)localObject2).append(localAppInterface.getCurrentAccountUin());
    localObject1 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("profile_card_qim_online_url", null);
    localObject2 = new Intent(this.l, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    ((Intent)localObject2).putExtra("hide_operation_bar", true);
    this.l.startActivity((Intent)localObject2);
    if ((localAppInterface instanceof QQAppInterface)) {
      ReportController.b((QQAppInterface)localAppInterface, "dc00898", "", "", "0X8008641", "0X8008641", 3, 0, "", "", "", "");
    }
  }
  
  private void q()
  {
    if (this.f != null)
    {
      SegmentList localSegmentList = w();
      if (localSegmentList != null)
      {
        int k = this.f.getBottom() - (int)this.l.getResources().getDimension(2131299920);
        boolean bool = ImmersiveTitleBar2.TRANSLUCENT_STATUS_BAR;
        int i = 1;
        if ((!bool) || (ImmersiveUtils.isSupporImmersive() != 1)) {
          i = 0;
        }
        int j = k;
        if (i != 0) {
          j = k - (ImmersiveUtils.getStatusBarHeight(this.l) - UIUtils.a(this.l, 15.0F));
        }
        localSegmentList.smoothScrollBy(j, 500);
      }
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if (this.c.b == null) {
      return paramBaseViewHolder.a();
    }
    Object localObject1 = (ImageView)paramBaseViewHolder.a(2131435406);
    paramViewGroup = (ImageView)paramBaseViewHolder.a(2131435404);
    TextView localTextView3 = (TextView)paramBaseViewHolder.a(2131447188);
    StoryUserBadgeView localStoryUserBadgeView = (StoryUserBadgeView)paramBaseViewHolder.a(2131435479);
    TextView localTextView4 = (TextView)paramBaseViewHolder.a(2131447218);
    View localView2 = paramBaseViewHolder.a(2131436918);
    View localView3 = paramBaseViewHolder.a(2131436892);
    View localView4 = paramBaseViewHolder.a(2131437024);
    TextView localTextView5 = (TextView)paramBaseViewHolder.a(2131447137);
    TextView localTextView6 = (TextView)paramBaseViewHolder.a(2131447140);
    TextView localTextView7 = (TextView)paramBaseViewHolder.a(2131447243);
    Object localObject3 = (TextView)paramBaseViewHolder.a(2131446570);
    TextView localTextView8 = (TextView)paramBaseViewHolder.a(2131447129);
    TextView localTextView9 = (TextView)paramBaseViewHolder.a(2131447127);
    TextView localTextView10 = (TextView)paramBaseViewHolder.a(2131447128);
    View localView1 = paramBaseViewHolder.a(2131429404);
    ViewGroup localViewGroup = (ViewGroup)paramBaseViewHolder.a(2131434337);
    ProgressBar localProgressBar = (ProgressBar)paramBaseViewHolder.a(2131434338);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131434339);
    ImageView localImageView = (ImageView)paramBaseViewHolder.a(2131438028);
    Object localObject2 = (RedTouch)paramBaseViewHolder.a("redTouch");
    FrameLayout localFrameLayout = (FrameLayout)paramBaseViewHolder.a(2131436878);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131448669);
    View localView5 = paramBaseViewHolder.a(2131432789);
    View localView6 = paramBaseViewHolder.a(2131433515);
    if (QQStoryContext.e())
    {
      localTextView3.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView4.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView7.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView5.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView6.setTextColor(this.l.getResources().getColor(2131167385));
      ((TextView)localObject3).setTextColor(this.l.getResources().getColor(2131167385));
      localTextView8.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView9.setTextColor(this.l.getResources().getColor(2131167385));
      localTextView10.setTextColor(this.l.getResources().getColor(2131167385));
      localFrameLayout.setBackgroundResource(2130848188);
      ((ImageView)localObject1).setColorFilter(this.l.getResources().getColor(2131167386));
      localView5.setBackgroundColor(this.l.getResources().getColor(2131167385));
      localView6.setBackgroundColor(this.l.getResources().getColor(2131167385));
      ((TextView)localObject3).setBackgroundResource(2130848324);
    }
    if (!TextUtils.isEmpty(this.c.b.backgroundUrl)) {
      UIUtils.a((ImageView)localObject1, this.c.b.backgroundUrl, 0, 0, null);
    }
    UIUtils.b(paramViewGroup, ThumbnailUrlHelper.b(this.c.b.headUrl), 200, 200, ImageUtil.b(1), "QQStory200");
    paramViewGroup.setContentDescription(PlayModeUtils.a(this.c.b));
    localTextView3.setText(PlayModeUtils.a(this.c.b));
    localTextView3.setContentDescription(PlayModeUtils.a(this.c.b));
    localStoryUserBadgeView.setUnionID(this.c.b.getUnionId(), 3);
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
    localTextView4.setText(this.c.b.signature);
    localTextView5.setText(UIUtils.a(Math.max(this.c.b.fansCount, 0)));
    localTextView6.setText(UIUtils.a(Math.max(this.c.b.followCount, 0)));
    if (this.c.b.isVip()) {
      localView2.setVisibility(0);
    } else {
      localView2.setVisibility(8);
    }
    localTextView7.setText(UIUtils.a(Math.max(this.c.b.videoCount, 0)));
    if (this.c.b.videoCount < 0) {
      localView4.setVisibility(8);
    } else {
      localView4.setVisibility(0);
    }
    if (this.c.b.isMe())
    {
      localView2.setOnClickListener(this);
      localView3.setOnClickListener(this);
    }
    localView4.setOnClickListener(this);
    ((TextView)localObject3).setOnClickListener(this);
    if (this.a == 0)
    {
      localObject1 = (FrameLayout.LayoutParams)localView1.getLayoutParams();
      paramViewGroup = (ViewGroup)localObject1;
      if (localObject1 == null) {
        paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
      }
      if (StoryProfileUtils.a(this.c.b))
      {
        this.a = 1;
        paramViewGroup.height = UIUtils.a(this.f.getContext(), 254.0F);
      }
      else
      {
        this.a = 2;
        paramViewGroup.height = UIUtils.a(this.f.getContext(), 220.0F);
      }
      localView1.setLayoutParams(paramViewGroup);
    }
    if (this.a != 1)
    {
      ((TextView)localObject3).setVisibility(8);
    }
    else
    {
      ((TextView)localObject3).setVisibility(0);
      if (this.c.b.isSubscribe()) {
        ((TextView)localObject3).setText(HardCodeUtil.a(2131904419));
      } else {
        ((TextView)localObject3).setText(HardCodeUtil.a(2131899712));
      }
    }
    if ((this.c.b.isMe()) && (this.c.b.fansCountExtra != 0))
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("+");
      paramViewGroup.append(UIUtils.a(this.c.b.fansCountExtra));
      paramViewGroup = RedPointUtils.a(4, paramViewGroup.toString(), 0);
      ((RedTouch)localObject2).setVisibility(0);
      ((RedTouch)localObject2).a(paramViewGroup);
    }
    else
    {
      ((RedTouch)localObject2).setVisibility(8);
    }
    if (this.e)
    {
      paramViewGroup = QQStoryContext.k();
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
        paramInt = this.l.getResources().getDimensionPixelSize(2131298837);
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
    this.f = LayoutInflater.from(this.l).inflate(2131628083, paramViewGroup, false);
    paramViewGroup = new BaseViewHolder(this.f);
    View localView = paramViewGroup.a(2131444542);
    paramViewGroup.a("redTouch", new RedTouch(this.f.getContext(), localView).c(21).b(3.0F).d(5).a());
    paramViewGroup.a("hasExposure", new Boolean(false));
    return paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      e(true);
      return;
    }
    e(false);
  }
  
  public String b()
  {
    return "MemoriesProfileSegment";
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    e(true);
  }
  
  protected void bs_()
  {
    super.bs_();
  }
  
  protected boolean d(boolean paramBoolean)
  {
    this.c.a(false);
    return true;
  }
  
  protected void g()
  {
    this.c.a(true);
  }
  
  protected void h()
  {
    super.h();
    this.c.b();
  }
  
  protected void i()
  {
    if (this.d)
    {
      this.d = false;
      this.c.a(false);
    }
  }
  
  public void j()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void k()
  {
    String str = QQStoryContext.a().g();
    if (TextUtils.isEmpty(str))
    {
      SLog.e("Q.qqstory.memories.MemoriesProfileSegment", "onGradeSpeedClick, uin is empty");
      return;
    }
    str = String.format("https://story.now.qq.com/m/gaccel/?uin=%s", new Object[] { str });
    Intent localIntent = new Intent(this.l, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.l.startActivity(localIntent);
    int i;
    if (this.c.b.gradeSpeed == 0) {
      i = 1;
    } else if ((this.c.b.gradeSpeed > 0) && (this.c.b.gradeSpeed < 10)) {
      i = 2;
    } else if (this.c.b.gradeSpeed == 10) {
      i = 3;
    } else {
      i = -1;
    }
    StoryReportor.a("memory", "clk_level", 0, 0, new String[] { String.valueOf(i) });
  }
  
  public void l()
  {
    String str;
    if (this.c.b.isMe()) {
      str = "https://ti.qq.com/qqmedal2/index.html?from=8&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22";
    } else {
      str = String.format("https://ti.qq.com/qqmedal2/index.html?from=9&_nav_alpha=0&_nav_anim=true&_wwv=4&_wv=1&_nav_txtclr=ffffff&_bid=2450&_nav_titleclr=ffffff&openMedalId=22&tuin=%s", new Object[] { NearbyURLSafeUtil.b(this.c.b.qq) });
    }
    Intent localIntent = new Intent(this.l, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    this.l.startActivity(localIntent);
    if (this.c.b.isMe()) {
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
    case 2131448669: 
      p();
      break;
    case 2131446570: 
      j();
      break;
    case 2131438028: 
      l();
      break;
    case 2131437024: 
      q();
      break;
    case 2131436918: 
      m();
      break;
    case 2131436892: 
      n();
      break;
    case 2131434337: 
      k();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesProfileSegment
 * JD-Core Version:    0.7.0.1
 */