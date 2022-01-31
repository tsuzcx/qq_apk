package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StMainPageJumpH5URL;
import ajjy;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import awmc;
import bfpr;
import bfpy;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import vms;
import vvr;
import vvy;
import vvz;
import wgz;
import wha;
import wye;

public class RelativePersonalDetailHeadItemView
  extends RelativeFeedBaseHeaderView
  implements View.OnClickListener
{
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private wha jdField_a_of_type_Wha;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
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
    vms.a(localSquareImageView, paramStYouZanGood.img.get(), ImmersiveUtils.a(27.0F), ImmersiveUtils.a(27.0F), null, "");
    return localSquareImageView;
  }
  
  private String a(int paramInt)
  {
    DecimalFormat localDecimalFormat;
    if (paramInt >= 10000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 10000.0D) + "w";
    }
    if (paramInt >= 1000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 1000.0D) + "k";
    }
    return String.valueOf(paramInt);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private boolean a()
  {
    return a(0);
  }
  
  private boolean a(int paramInt)
  {
    int j = 48;
    int i = j;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      i = j;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null)
      {
        String str = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          i = j;
          if (str.length() > paramInt) {
            i = str.charAt(str.length() - 1 - paramInt);
          }
        }
      }
    }
    return i == 49;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = findViewById(2131303771);
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() == 0) || (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).goods.size() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    CertifiedAccountMeta.StYouZanShop localStYouZanShop = (CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303729));
    }
    if (this.h == null) {
      this.h = ((TextView)findViewById(2131312374));
    }
    TextView localTextView = (TextView)findViewById(2131312519);
    String str2 = ajjy.a(2131654035);
    String str1;
    if (vvz.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      str1 = ajjy.a(2131647581);
      localTextView.setText(String.format(str2, new Object[] { str1 }));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.h.setText(String.format(ajjy.a(2131654034), new Object[] { Integer.valueOf(localStYouZanShop.goodNum.get()) }));
      if (localStYouZanShop.goods.size() <= 4) {
        break label313;
      }
    }
    label313:
    for (int i = 4;; i = localStYouZanShop.goods.size())
    {
      int j = 0;
      while (j < i)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((CertifiedAccountMeta.StYouZanGood)localStYouZanShop.goods.get(j)));
        j += 1;
      }
      str1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.nick.get();
      break;
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new wgz(this, localStYouZanShop));
  }
  
  private boolean b()
  {
    return a(1);
  }
  
  private void c()
  {
    try
    {
      Object localObject = vvz.a() + "/certified_account_personal_head_bg.png";
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
  
  private boolean c()
  {
    return a(3);
  }
  
  public int a()
  {
    return 2131493130;
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
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131309795));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setNestedScrollingEnabled(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312439));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312302));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView = ((FollowTextView)findViewById(2131312354));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312341));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312335));
    this.e = ((TextView)findViewById(2131312356));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131302963));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297976));
    this.f = ((TextView)findViewById(2131312334));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302993));
    this.g = ((TextView)findViewById(2131312853));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302992));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303085));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303003));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303715));
    c();
    a();
    a(false);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = ((CertifiedAccountRead.StGetMainPageRsp)paramObject);
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setNoneReportType(false);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setExtraTypeInfo(a());
    }
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get() != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get().size() != 0))
    {
      this.f.setVisibility(0);
      this.jdField_a_of_type_Wha = new wha(this, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecGroup.get());
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Wha);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_Boolean))
      {
        wye.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get() != null))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.nick.get());
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.desc.get());
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().width = awmc.a(80.0F);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams().height = awmc.a(80.0F);
        vvr.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.icon.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
        if (!a()) {
          break label461;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        label308:
        if (!c()) {
          break label485;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.readStatus.get() != 1)) {
          break label473;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label358:
        if (!b()) {
          break label506;
        }
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.feedCount.get()));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get()));
      this.e.setText(a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.followCount.get()));
      b();
      return;
      this.f.setVisibility(8);
      break;
      label461:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      break label308;
      label473:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label358;
      label485:
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label358;
      label506:
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.g.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs == null) || (TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get())));
          vvy.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.jumpURLs.editPageURL.get());
          return;
        } while ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user == null));
        paramView = new Intent();
        paramView.putExtra("key_is_from_publish_account", true);
        bfpy localbfpy = bfpy.a();
        Object localObject = BaseApplicationImpl.getApplication().getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (QQAppInterface)localObject;
          localbfpy.b = ((QQAppInterface)localObject).getCurrentNickname();
          localbfpy.a = ((QQAppInterface)localObject).c();
        }
        bfpr.c((Activity)this.jdField_a_of_type_AndroidContentContext, localbfpy, paramView, -1);
        return;
      } while ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus == null) || (TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get())));
      vvy.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.messStatus.jumpURL.get());
      wye.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
      return;
    } while ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) || (!this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.has()) || (TextUtils.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get())) || (!b()));
    vvy.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
  }
  
  public void setCardReport(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView
 * JD-Core Version:    0.7.0.1
 */