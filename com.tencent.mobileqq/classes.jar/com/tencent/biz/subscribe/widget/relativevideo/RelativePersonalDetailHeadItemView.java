package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPersonInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StMainPageJumpH5URL;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.widget.textview.NewStyleFollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class RelativePersonalDetailHeadItemView
  extends RelativeFeedBaseHeaderView
  implements View.OnClickListener, SimpleEventReceiver
{
  private NewStyleFollowTextView A;
  private ImageView B;
  private ImageView C;
  private LinearLayout D;
  private TextView E;
  private TextView F;
  private TopGestureLayout G;
  private FollowedRecommendBannerView H;
  private AnimationDrawable I;
  private boolean c;
  private Context d;
  private CertifiedAccountRead.StGetMainPageRsp e;
  private RecyclerView f;
  private RelativePersonalDetailHeadItemView.FansGroupAdapter g;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private SquareImageView m;
  private Button n;
  private TextView o;
  private ImageView p;
  private TextView q;
  private ImageView r;
  private ImageView s;
  private ImageView t;
  private View u;
  private TextView v;
  private LinearLayout w;
  private LinearLayout x;
  private LinearLayout y;
  private FrameLayout z;
  
  public RelativePersonalDetailHeadItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.d = paramContext;
  }
  
  private View a(CertifiedAccountMeta.StYouZanGood paramStYouZanGood)
  {
    SquareImageView localSquareImageView = new SquareImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(27.0F), ImmersiveUtils.dpToPx(27.0F));
    localLayoutParams.rightMargin = ImmersiveUtils.dpToPx(5.0F);
    localSquareImageView.setLayoutParams(localLayoutParams);
    localSquareImageView.setRoundRect(ImmersiveUtils.dpToPx(5.0F));
    localSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    UIUtils.a(localSquareImageView, paramStYouZanGood.img.get(), ImmersiveUtils.dpToPx(27.0F), ImmersiveUtils.dpToPx(27.0F), null, "");
    return localSquareImageView;
  }
  
  private String a(String paramString)
  {
    Object localObject2 = "";
    if (paramString == null) {
      return "";
    }
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString).optJSONObject("location");
      paramString = (String)localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        String str1 = ((JSONObject)localObject3).optString("country");
        localObject1 = localObject2;
        String str2 = ((JSONObject)localObject3).optString("province");
        localObject1 = localObject2;
        localObject3 = ((JSONObject)localObject3).optString("area");
        paramString = (String)localObject2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str1)) {
          paramString = str1;
        }
        localObject1 = paramString;
        boolean bool = TextUtils.isEmpty(str2);
        localObject2 = paramString;
        if (!bool)
        {
          localObject1 = paramString;
          localObject2 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject2).append(paramString);
          localObject1 = paramString;
          ((StringBuilder)localObject2).append("·");
          localObject1 = paramString;
          ((StringBuilder)localObject2).append(str2);
          localObject1 = paramString;
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        localObject1 = localObject2;
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = localObject2;
          paramString = new StringBuilder();
          localObject1 = localObject2;
          paramString.append((String)localObject2);
          localObject1 = localObject2;
          paramString.append("·");
          localObject1 = localObject2;
          paramString.append((String)localObject3);
          localObject1 = localObject2;
          paramString = paramString.toString();
          return paramString;
        }
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = (String)localObject1;
    }
    return paramString;
  }
  
  private void a()
  {
    this.n.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
  }
  
  private void a(PublishBoxStatusEvent paramPublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.3(this, paramPublishBoxStatusEvent));
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
    {
      localObject = Long.toBinaryString(this.e.user.attr.get());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > paramInt))
      {
        paramInt = ((String)localObject).charAt(((String)localObject).length() - 1 - paramInt);
        break label67;
      }
    }
    paramInt = 48;
    label67:
    return paramInt == 49;
  }
  
  private void b()
  {
    if (this.u == null) {
      this.u = findViewById(2131437561);
    }
    Object localObject = this.e;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user.youZhan.size() != 0))
    {
      localObject = this.e.user.youZhan;
      int i2 = 0;
      if (((CertifiedAccountMeta.StYouZanShop)((PBRepeatMessageField)localObject).get(0)).goods.size() != 0)
      {
        CertifiedAccountMeta.StYouZanShop localStYouZanShop = (CertifiedAccountMeta.StYouZanShop)this.e.user.youZhan.get(0);
        if (this.w == null) {
          this.w = ((LinearLayout)findViewById(2131437467));
        }
        if (this.v == null) {
          this.v = ((TextView)findViewById(2131448502));
        }
        TextView localTextView = (TextView)findViewById(2131448745);
        if (SubscribeUtils.a(this.e.user.attr.get())) {
          localObject = HardCodeUtil.a(2131910848);
        } else {
          localObject = this.e.user.nick.get();
        }
        localTextView.setText((CharSequence)localObject);
        this.w.removeAllViews();
        this.u.setVisibility(0);
        this.v.setText(String.format(HardCodeUtil.a(2131916905), new Object[] { Integer.valueOf(localStYouZanShop.goodNum.get()) }));
        int i3 = localStYouZanShop.goods.size();
        int i1 = 4;
        if (i3 <= 4) {
          i1 = localStYouZanShop.goods.size();
        }
        while (i2 < i1)
        {
          this.w.addView(a((CertifiedAccountMeta.StYouZanGood)localStYouZanShop.goods.get(i2)));
          i2 += 1;
        }
        this.u.setOnClickListener(new RelativePersonalDetailHeadItemView.1(this, localStYouZanShop));
        return;
      }
    }
    this.u.setVisibility(8);
  }
  
  private void c()
  {
    if (this.e != null)
    {
      if (this.d == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.e.user.iconInfo.iconUrl.get())) {
        localArrayList.add(this.e.user.iconInfo.iconUrl.get());
      } else {
        localArrayList.add(this.e.user.icon.get());
      }
      Intent localIntent = new Intent(this.d, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("seqNum", localArrayList);
      localBundle.putBoolean("delete_ability", false);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", false);
      localBundle.putBoolean("is_not_show_index", false);
      localIntent.putExtras(localBundle);
      this.d.startActivity(localIntent);
      VSReporter.b(this.e.user.id.get(), "auth_person", "clk_head", 0, 0, new String[0]);
    }
  }
  
  private boolean d()
  {
    return a(0);
  }
  
  private boolean e()
  {
    return a(1);
  }
  
  private boolean h()
  {
    return a(3);
  }
  
  private void i()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SubscribeUtils.b());
      ((StringBuilder)localObject).append("/certified_account_personal_head_bg.png");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists())
      {
        ViewGroup.LayoutParams localLayoutParams = this.t.getLayoutParams();
        localLayoutParams.width = ImmersiveUtils.getScreenWidth();
        int i1 = localLayoutParams.width;
        double d1 = i1;
        Double.isNaN(d1);
        i1 = (int)(d1 * 0.66D);
        localLayoutParams.height = i1;
        this.t.setLayoutParams(localLayoutParams);
        localObject = Drawable.createFromPath((String)localObject);
        this.t.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    if (this.I == null) {
      this.I = ((AnimationDrawable)getResources().getDrawable(2130850585));
    }
    this.I.stop();
    ImageView localImageView = this.s;
    if (localImageView != null)
    {
      if (localImageView.getVisibility() == 8) {
        return;
      }
      this.s.setImageDrawable(this.I);
      this.I.start();
    }
  }
  
  private void k()
  {
    AnimationDrawable localAnimationDrawable = this.I;
    if (localAnimationDrawable != null) {
      localAnimationDrawable.stop();
    }
    this.s.setImageResource(2130852479);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.f = ((RecyclerView)findViewById(2131445209));
    this.f.setLayoutManager(new LinearLayoutManager(this.d, 0, false));
    this.f.setNestedScrollingEnabled(true);
    this.h = ((TextView)findViewById(2131448603));
    this.i = ((TextView)findViewById(2131448375));
    this.A = ((NewStyleFollowTextView)findViewById(2131448468));
    this.j = ((TextView)findViewById(2131448450));
    this.k = ((TextView)findViewById(2131448442));
    this.l = ((TextView)findViewById(2131448471));
    this.m = ((SquareImageView)findViewById(2131436420));
    this.n = ((Button)findViewById(2131429872));
    this.o = ((TextView)findViewById(2131448441));
    this.p = ((ImageView)findViewById(2131436463));
    this.q = ((TextView)findViewById(2131449158));
    this.r = ((ImageView)findViewById(2131436461));
    this.s = ((ImageView)findViewById(2131436643));
    this.t = ((ImageView)findViewById(2131436488));
    this.x = ((LinearLayout)findViewById(2131437452));
    this.z = ((FrameLayout)findViewById(2131433286));
    this.y = ((LinearLayout)findViewById(2131437450));
    this.C = ((ImageView)findViewById(2131436538));
    this.B = ((ImageView)findViewById(2131436568));
    this.H = ((FollowedRecommendBannerView)findViewById(2131444421));
    this.D = ((LinearLayout)findViewById(2131437491));
    this.E = ((TextView)findViewById(2131448572));
    this.F = ((TextView)findViewById(2131448573));
    i();
    a();
    a(false);
  }
  
  public void a(Object paramObject)
  {
    this.e = ((CertifiedAccountRead.StGetMainPageRsp)paramObject);
    paramObject = this.e;
    if (paramObject == null) {
      return;
    }
    NewStyleFollowTextView localNewStyleFollowTextView = this.A;
    if (localNewStyleFollowTextView != null)
    {
      localNewStyleFollowTextView.setUserData(paramObject.user);
      this.A.setNoneReportType(false);
      this.A.setExtraTypeInfo(getExtraTypeInfo());
    }
    if ((this.e.vecGroup.get() != null) && (this.e.vecGroup.get().size() != 0))
    {
      this.o.setVisibility(0);
      this.g = new RelativePersonalDetailHeadItemView.FansGroupAdapter(this, this.e.vecGroup.get());
      this.f.setAdapter(this.g);
      if ((this.e.user != null) && (this.c))
      {
        VSReporter.a(this.e.user.id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
        this.c = false;
      }
    }
    else
    {
      this.o.setVisibility(8);
    }
    if ((this.e.user != null) && (this.e.user.get() != null)) {
      setPostUserData(this.e.user);
    }
    this.j.setText(SubscribeUtils.b(this.e.feedCount.get()));
    this.k.setText(SubscribeUtils.b(this.e.fansCount.get()));
    this.l.setText(SubscribeUtils.b(this.e.followCount.get()));
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = getTopGestureLayout();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableFlingRight->enable:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("RelativePersonalDetailH", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return 2131624371;
  }
  
  protected TopGestureLayout getTopGestureLayout()
  {
    if ((this.G == null) && ((getContext() instanceof BaseActivity)))
    {
      Object localObject = (ViewGroup)((BaseActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.G = ((TopGestureLayout)localObject);
      }
    }
    return this.G;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131437452: 
      localObject1 = this.e;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).user.has()) && (!TextUtils.isEmpty(this.e.user.id.get())) && (e())) {
        SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
      }
      break;
    case 2131437450: 
      localObject1 = this.e;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).user.has()) && (!TextUtils.isEmpty(this.e.user.id.get())) && (e()))
      {
        SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/fanslist/{uin}?_proxy=1&_wv=3".replace("{uin}", this.e.user.id.get()));
        VSReporter.b(this.e.user.id.get(), "auth_person", "clk_fans", 0, 0, new String[0]);
      }
      break;
    case 2131436643: 
    case 2131449158: 
      if (this.d != null)
      {
        localObject1 = this.e;
        if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).user != null))
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_type_queue", 2);
          QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
          Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject2 instanceof QQAppInterface))
          {
            localObject2 = (QQAppInterface)localObject2;
            localUserInfo.nickname = ((QQAppInterface)localObject2).getCurrentNickname();
            localUserInfo.qzone_uin = ((QQAppInterface)localObject2).getCurrentUin();
          }
          QZoneHelper.forwardToPublishQueue((Activity)this.d, localUserInfo, (Intent)localObject1, -1);
        }
      }
      break;
    case 2131436461: 
    case 2131436463: 
      localObject1 = this.e;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).messStatus != null) && (!TextUtils.isEmpty(this.e.messStatus.jumpURL.get())))
      {
        SubscribeLaucher.a(this.e.messStatus.jumpURL.get());
        VSReporter.b(this.e.user.id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
      }
      break;
    case 2131436420: 
      c();
      break;
    case 2131433286: 
      if (this.e != null) {
        if (this.H.b())
        {
          this.H.a();
          this.C.setImageResource(2130839147);
          VSReporter.b(this.e.user.id.get(), "auth_person", "show_reco", 0, 0, new String[0]);
        }
        else
        {
          this.H.a(this.e.user.id.get());
          this.C.setImageResource(2130839148);
          VSReporter.b(this.e.user.id.get(), "auth_person", "fold_reco", 0, 0, new String[0]);
        }
      }
      break;
    case 2131429872: 
      localObject1 = this.e;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).jumpURLs != null) && (!TextUtils.isEmpty(this.e.jumpURLs.editPageURL.get()))) {
        SubscribeLaucher.a(this.e.jumpURLs.editPageURL.get());
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    AnimationDrawable localAnimationDrawable = this.I;
    if (localAnimationDrawable != null)
    {
      localAnimationDrawable.stop();
      this.I = null;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent))
    {
      Object localObject = this.e;
      if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
      {
        String str = this.e.user.id.get();
        localObject = (FollowUpdateEvent)paramSimpleBaseEvent;
        if (TextUtils.equals(str, ((FollowUpdateEvent)localObject).useId))
        {
          int i2 = this.e.fansCount.get();
          int i1;
          if ((((FollowUpdateEvent)localObject).followStatus == 1) && (this.e.user.followState.get() == 0))
          {
            i1 = i2 + 1;
            if (!this.H.b()) {
              this.H.a(((FollowUpdateEvent)localObject).useId);
            }
            this.C.setImageResource(2130839148);
          }
          else
          {
            i1 = i2;
            if (((FollowUpdateEvent)localObject).followStatus == 0)
            {
              i1 = i2;
              if (this.e.user.followState.get() == 1)
              {
                i1 = i2;
                if (i2 > 0) {
                  i1 = i2 - 1;
                }
              }
            }
          }
          this.e.fansCount.set(i1);
          this.e.user.followState.set(((FollowUpdateEvent)localObject).followStatus);
          ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.2(this, i1));
          paramSimpleBaseEvent = new StringBuilder();
          paramSimpleBaseEvent.append("onReceiveEvent  id:");
          paramSimpleBaseEvent.append(((FollowUpdateEvent)localObject).useId);
          paramSimpleBaseEvent.append(" , status:");
          paramSimpleBaseEvent.append(((FollowUpdateEvent)localObject).followStatus);
          paramSimpleBaseEvent.append(" ");
          paramSimpleBaseEvent.append(toString());
          SLog.c("RelativePersonalDetailH", paramSimpleBaseEvent.toString());
          return;
        }
      }
    }
    if ((paramSimpleBaseEvent instanceof PublishBoxStatusEvent)) {
      a((PublishBoxStatusEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setCardReport(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setPostUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      this.h.setText(paramStUser.nick.get());
      this.i.setText(paramStUser.desc.get());
      this.m.getLayoutParams().width = ScreenUtil.dip2px(92.0F);
      this.m.getLayoutParams().height = ScreenUtil.dip2px(92.0F);
      SubImageLoader.a(paramStUser.icon.get(), this.m);
      if (d()) {
        this.n.setVisibility(0);
      } else {
        this.n.setVisibility(8);
      }
      if (h())
      {
        this.r.setVisibility(0);
        CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = this.e;
        if ((localStGetMainPageRsp != null) && (localStGetMainPageRsp.messStatus != null) && (this.e.messStatus.readStatus.get() == 1)) {
          this.p.setVisibility(0);
        } else {
          this.p.setVisibility(8);
        }
      }
      else
      {
        this.r.setVisibility(8);
        this.p.setVisibility(8);
      }
      if (e())
      {
        this.A.setVisibility(8);
        this.z.setVisibility(8);
        this.x.setVisibility(0);
      }
      else
      {
        this.n.setVisibility(8);
        if (paramStUser.type.get() == 1)
        {
          this.A.setVisibility(0);
          this.z.setVisibility(0);
        }
        else
        {
          this.A.setVisibility(8);
          this.z.setVisibility(8);
        }
        this.s.setVisibility(8);
        this.q.setVisibility(8);
        this.x.setVisibility(8);
      }
      if (paramStUser.personInfo.sex.get() == 1) {
        this.B.setImageResource(2130839152);
      } else if (paramStUser.personInfo.sex.get() == 2) {
        this.B.setImageResource(2130839153);
      }
      if ((TextUtils.isEmpty(paramStUser.personInfo.location.get())) && (TextUtils.isEmpty(paramStUser.personInfo.school.get())))
      {
        this.D.setVisibility(8);
        return;
      }
      this.D.setVisibility(0);
      this.E.setText(a(paramStUser.personInfo.location.get()));
      this.F.setText(paramStUser.personInfo.school.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView
 * JD-Core Version:    0.7.0.1
 */