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
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
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
  private RelativePersonalDetailHeadItemView.FansGroupAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$FansGroupAdapter;
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
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
    {
      localObject = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
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
  
  private boolean b()
  {
    return a(1);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131370311);
    }
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user.youZhan.size() != 0))
    {
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan;
      int m = 0;
      if (((CertifiedAccountMeta.StYouZanShop)((PBRepeatMessageField)localObject).get(0)).goods.size() != 0)
      {
        CertifiedAccountMeta.StYouZanShop localStYouZanShop = (CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370260));
        }
        if (this.h == null) {
          this.h = ((TextView)findViewById(2131379706));
        }
        TextView localTextView = (TextView)findViewById(2131379877);
        if (SubscribeUtils.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get())) {
          localObject = HardCodeUtil.a(2131713295);
        } else {
          localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.nick.get();
        }
        localTextView.setText((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.h.setText(String.format(HardCodeUtil.a(2131719353), new Object[] { Integer.valueOf(localStYouZanShop.goodNum.get()) }));
        int n = localStYouZanShop.goods.size();
        int k = 4;
        if (n <= 4) {
          k = localStYouZanShop.goods.size();
        }
        while (m < k)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((CertifiedAccountMeta.StYouZanGood)localStYouZanShop.goods.get(m)));
          m += 1;
        }
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(new RelativePersonalDetailHeadItemView.1(this, localStYouZanShop));
        return;
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private boolean c()
  {
    return a(3);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get())) {
        localArrayList.add(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.iconInfo.iconUrl.get());
      } else {
        localArrayList.add(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.icon.get());
      }
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
      VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_head", 0, 0, new String[0]);
    }
  }
  
  private void e()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SubscribeUtils.a());
      ((StringBuilder)localObject).append("/certified_account_personal_head_bg.png");
      localObject = ((StringBuilder)localObject).toString();
      if (new File((String)localObject).exists())
      {
        ViewGroup.LayoutParams localLayoutParams = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.width = ImmersiveUtils.getScreenWidth();
        int k = localLayoutParams.width;
        double d1 = k;
        Double.isNaN(d1);
        k = (int)(d1 * 0.66D);
        localLayoutParams.height = k;
        this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
        localObject = Drawable.createFromPath((String)localObject);
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getResources().getDrawable(2130848918));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      if (localImageView.getVisibility() == 8) {
        return;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
    }
  }
  
  private void g()
  {
    AnimationDrawable localAnimationDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localAnimationDrawable != null) {
      localAnimationDrawable.stop();
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130850675);
  }
  
  public int a()
  {
    return 2131558751;
  }
  
  protected TopGestureLayout a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null) && ((getContext() instanceof BaseActivity)))
    {
      Object localObject = (ViewGroup)((BaseActivity)getContext()).getWindow().getDecorView();
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376874));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setNestedScrollingEnabled(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379782));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379611));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView = ((NewStyleFollowTextView)findViewById(2131379686));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379670));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379663));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379689));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369387));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363916));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379662));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369423));
    this.g = ((TextView)findViewById(2131380240));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369422));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369542));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369436));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370254));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366933));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370253));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369469));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369492));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView = ((FollowedRecommendBannerView)findViewById(2131376213));
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370272));
    this.i = ((TextView)findViewById(2131379763));
    this.j = ((TextView)findViewById(2131379764));
    e();
    a();
    a(false);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = ((CertifiedAccountRead.StGetMainPageRsp)paramObject);
    paramObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
    if (paramObject == null) {
      return;
    }
    NewStyleFollowTextView localNewStyleFollowTextView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView;
    if (localNewStyleFollowTextView != null)
    {
      localNewStyleFollowTextView.setUserData(paramObject.user);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setNoneReportType(false);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setExtraTypeInfo(a());
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get().size() != 0))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$FansGroupAdapter = new RelativePersonalDetailHeadItemView.FansGroupAdapter(this, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView$FansGroupAdapter);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_Boolean))
      {
        VSReporter.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get() != null)) {
      setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(SubscribeUtils.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.feedCount.get()));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(SubscribeUtils.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get()));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(SubscribeUtils.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.followCount.get()));
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = a();
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
    case 2131370254: 
      localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).user.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (b())) {
        SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
      }
      break;
    case 2131370253: 
      localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).user.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) && (b()))
      {
        SubscribeLaucher.a("https://h5.qzone.qq.com/subscription/fanslist/{uin}?_proxy=1&_wv=3".replace("{uin}", this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get()));
        VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_fans", 0, 0, new String[0]);
      }
      break;
    case 2131369542: 
    case 2131380240: 
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
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
          QZoneHelper.forwardToPublishQueue((Activity)this.jdField_a_of_type_AndroidContentContext, localUserInfo, (Intent)localObject1, -1);
        }
      }
      break;
    case 2131369422: 
    case 2131369423: 
      localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).messStatus != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get())))
      {
        SubscribeLaucher.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get());
        VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
      }
      break;
    case 2131369387: 
      d();
      break;
    case 2131366933: 
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) {
        if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a())
        {
          this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a();
          this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130838993);
          VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "show_reco", 0, 0, new String[0]);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get());
          this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130838994);
          VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "fold_reco", 0, 0, new String[0]);
        }
      }
      break;
    case 2131363916: 
      localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject1 != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject1).jumpURLs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get()))) {
        SubscribeLaucher.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get());
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    AnimationDrawable localAnimationDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
    if (localAnimationDrawable != null)
    {
      localAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FollowUpdateEvent))
    {
      Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
      {
        String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get();
        localObject = (FollowUpdateEvent)paramSimpleBaseEvent;
        if (TextUtils.equals(str, ((FollowUpdateEvent)localObject).useId))
        {
          int m = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get();
          int k;
          if ((((FollowUpdateEvent)localObject).followStatus == 1) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 0))
          {
            k = m + 1;
            if (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a()) {
              this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a(((FollowUpdateEvent)localObject).useId);
            }
            this.jdField_f_of_type_AndroidWidgetImageView.setImageResource(2130838994);
          }
          else
          {
            k = m;
            if (((FollowUpdateEvent)localObject).followStatus == 0)
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
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.set(k);
          this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.set(((FollowUpdateEvent)localObject).followStatus);
          ThreadManager.getUIHandler().post(new RelativePersonalDetailHeadItemView.2(this, k));
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
      SubImageLoader.a(paramStUser.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
      if (a()) {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      } else {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      if (c())
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
        if ((localStGetMainPageRsp != null) && (localStGetMainPageRsp.messStatus != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.readStatus.get() == 1)) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (b())
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (paramStUser.type.get() == 1)
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewNewStyleFollowTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.g.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (paramStUser.personInfo.sex.get() == 1) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838998);
      } else if (paramStUser.personInfo.sex.get() == 2) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130838999);
      }
      if ((TextUtils.isEmpty(paramStUser.personInfo.location.get())) && (TextUtils.isEmpty(paramStUser.personInfo.school.get())))
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.i.setText(a(paramStUser.personInfo.location.get()));
      this.j.setText(paramStUser.personInfo.school.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView
 * JD-Core Version:    0.7.0.1
 */