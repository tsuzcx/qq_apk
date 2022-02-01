package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StIconInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPersonInfo;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StMainPageJumpH5URL;
import aacb;
import aacc;
import aanb;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import anvx;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.widget.textview.NewStyleFollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
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
import ykq;
import zqf;
import zqm;
import zqn;

public class RelativePersonalDetailHeadItemView
  extends RelativeFeedBaseHeaderView
  implements View.OnClickListener, SimpleEventReceiver
{
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private aacc jdField_a_of_type_Aacc;
  private Context jdField_a_of_type_AndroidContentContext;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowedRecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView;
  private NewStyleFollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  
  public RelativePersonalDetailHeadItemView(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private View a(CertifiedAccountMeta.StYouZanGood paramStYouZanGood)
  {
    SquareImageView localSquareImageView = new SquareImageView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ImmersiveUtils.a(27.0F), ImmersiveUtils.a(27.0F));
    localLayoutParams.rightMargin = ImmersiveUtils.a(5.0F);
    localSquareImageView.setLayoutParams(localLayoutParams);
    localSquareImageView.setRoundRect(ImmersiveUtils.a(5.0F));
    localSquareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    UIUtils.setViewByURL(localSquareImageView, paramStYouZanGood.img.get(), ImmersiveUtils.a(27.0F), ImmersiveUtils.a(27.0F), null, "");
    return localSquareImageView;
  }
  
  private String a(String paramString)
  {
    Object localObject1;
    if (paramString == null)
    {
      localObject1 = "";
      return localObject1;
    }
    String str2 = "";
    String str1 = str2;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString).optJSONObject("location");
        localObject1 = str2;
        if (localObject2 == null) {
          break;
        }
        str1 = str2;
        paramString = ((JSONObject)localObject2).optString("country");
        str1 = str2;
        localObject1 = ((JSONObject)localObject2).optString("province");
        str1 = str2;
        localObject2 = ((JSONObject)localObject2).optString("area");
        str1 = str2;
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          break label186;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject2;
        paramString.printStackTrace();
        return str1;
      }
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label183;
        }
        str1 = paramString + "·" + (String)localObject1;
        paramString = str1;
      }
      catch (JSONException localJSONException)
      {
        str1 = paramString;
        paramString = localJSONException;
        continue;
        continue;
      }
      localObject1 = paramString;
      str1 = paramString;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      str1 = paramString;
      paramString = paramString + "·" + (String)localObject2;
      return paramString;
      label183:
      label186:
      paramString = "";
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
  }
  
  private void a(PublishBoxStatusEvent paramPublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.3(this, paramPublishBoxStatusEvent));
  }
  
  private boolean a()
  {
    return a(0);
  }
  
  private boolean a(int paramInt)
  {
    int m = 48;
    int k = m;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      k = m;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null)
      {
        String str = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
        k = m;
        if (!TextUtils.isEmpty(str))
        {
          k = m;
          if (str.length() > paramInt) {
            k = str.charAt(str.length() - 1 - paramInt);
          }
        }
      }
    }
    return k == 49;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131370397);
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() == 0) || (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).goods.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    CertifiedAccountMeta.StYouZanShop localStYouZanShop = (CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370339));
    }
    if (this.h == null) {
      this.h = ((TextView)findViewById(2131379962));
    }
    TextView localTextView = (TextView)findViewById(2131380157);
    String str;
    if (zqn.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      str = anvx.a(2131712831);
      localTextView.setText(str);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.h.setText(String.format(anvx.a(2131719094), new Object[] { Integer.valueOf(localStYouZanShop.goodNum.get()) }));
      if (localStYouZanShop.goods.size() <= 4) {
        break label299;
      }
    }
    label299:
    for (int k = 4;; k = localStYouZanShop.goods.size())
    {
      int m = 0;
      while (m < k)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((CertifiedAccountMeta.StYouZanGood)localStYouZanShop.goods.get(m)));
        m += 1;
      }
      str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.nick.get();
      break;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aacb(this, localStYouZanShop));
  }
  
  private boolean b()
  {
    return a(1);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get())) {
      localArrayList.add(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get());
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putStringArrayList("seqNum", localArrayList);
      localBundle.putBoolean("delete_ability", false);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", false);
      localBundle.putBoolean("is_not_show_index", false);
      localIntent.putExtras(localBundle);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_head", 0, 0, new String[0]);
      return;
      localArrayList.add(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.icon.get());
    }
  }
  
  private boolean c()
  {
    return a(3);
  }
  
  private void d()
  {
    try
    {
      Object localObject = zqn.a() + "/certified_account_personal_head_bg.png";
      if (new File((String)localObject).exists())
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.width = ImmersiveUtils.a();
        localLayoutParams.height = ((int)(localLayoutParams.width * 0.66D));
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        localObject = Drawable.createFromPath((String)localObject);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130848658));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    if ((this.jdField_c_of_type_AndroidWidgetImageView == null) || (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850349);
  }
  
  public int a()
  {
    return 2131558813;
  }
  
  protected TopGestureLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && ((getContext() instanceof FragmentActivity)))
    {
      Object localObject = (ViewGroup)((FragmentActivity)getContext()).getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131377014));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setNestedScrollingEnabled(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380042));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379870));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView = ((NewStyleFollowTextView)findViewById(2131379937));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379921));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379915));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379940));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369431));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363891));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379914));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369466));
    this.g = ((TextView)findViewById(2131380529));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369465));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369585));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369486));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370334));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366904));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370333));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369520));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369538));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView = ((FollowedRecommendBannerView)findViewById(2131376319));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370349));
    this.i = ((TextView)findViewById(2131380019));
    this.j = ((TextView)findViewById(2131380020));
    d();
    a();
    a(false);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = ((CertifiedAccountRead.StGetMainPageRsp)paramObject);
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setNoneReportType(false);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setExtraTypeInfo(a());
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get().size() != 0))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_Aacc = new aacc(this, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aacc);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_Boolean))
      {
        aanb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get() != null)) {
        setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(zqn.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.feedCount.get()));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(zqn.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get()));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(zqn.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.followCount.get()));
      b();
      return;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RelativePersonalDetailH", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SimpleEventBus.getInstance().registerReceiver(this);
    QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get())))
      {
        zqm.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get());
        continue;
        if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("key_type_queue", 2);
          QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject instanceof QQAppInterface))
          {
            localObject = (QQAppInterface)localObject;
            localUserInfo.nickname = ((QQAppInterface)localObject).getCurrentNickname();
            localUserInfo.qzone_uin = ((QQAppInterface)localObject).getCurrentUin();
          }
          QZoneHelper.forwardToPublishQueue((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, localIntent, -1);
          continue;
          if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get())))
          {
            zqm.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get());
            aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
            continue;
            if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (b()))
            {
              zqm.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
              continue;
              c();
              continue;
              if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (b()))
              {
                zqm.a("https://h5.qzone.qq.com/subscription/fanslist/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get()));
                aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_fans", 0, 0, new String[0]);
                continue;
                if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) {
                  if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a())
                  {
                    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a();
                    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130839072);
                    aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "show_reco", 0, 0, new String[0]);
                  }
                  else
                  {
                    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get());
                    this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130839073);
                    aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "fold_reco", 0, 0, new String[0]);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (TextUtils.equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), ((FollowUpdateEvent)paramSimpleBaseEvent).useId)))
    {
      m = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get();
      if ((((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 1) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 0))
      {
        k = m + 1;
        if (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a()) {
          this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
        }
        this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130839073);
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.set(k);
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.2(this, k));
        ykq.c("RelativePersonalDetailH", "onReceiveEvent  id:" + ((FollowUpdateEvent)paramSimpleBaseEvent).useId + " , status:" + ((FollowUpdateEvent)paramSimpleBaseEvent).followStatus + " " + toString());
      }
    }
    while (!(paramSimpleBaseEvent instanceof PublishBoxStatusEvent)) {
      for (;;)
      {
        int m;
        return;
        int k = m;
        if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0)
        {
          k = m;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 1)
          {
            k = m;
            if (m > 0) {
              k = m - 1;
            }
          }
        }
      }
    }
    a((PublishBoxStatusEvent)paramSimpleBaseEvent);
  }
  
  public void setCardReport(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPostUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    if ((paramStUser != null) && (paramStUser.get() != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStUser.nick.get());
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStUser.desc.get());
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = ScreenUtil.dip2px(92.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = ScreenUtil.dip2px(92.0F);
      zqf.a(paramStUser.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      if (!a()) {
        break label256;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      if (!c()) {
        break label280;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.readStatus.get() != 1)) {
        break label268;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label157:
      if (!b()) {
        break label301;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (paramStUser.personInfo.sex.get() != 1) {
        break label388;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839077);
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramStUser.personInfo.location.get())) || (!TextUtils.isEmpty(paramStUser.personInfo.school.get()))) {
        break label415;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
      label256:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break;
      label268:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label157;
      label280:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label157;
      label301:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      if (paramStUser.type.get() == 1)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.g.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        break;
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      label388:
      if (paramStUser.personInfo.sex.get() == 2) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130839078);
      }
    }
    label415:
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.i.setText(a(paramStUser.personInfo.location.get()));
    this.j.setText(paramStUser.personInfo.school.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView
 * JD-Core Version:    0.7.0.1
 */