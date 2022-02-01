import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ashc
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private asgt jdField_a_of_type_Asgt;
  private asjb jdField_a_of_type_Asjb;
  private aski jdField_a_of_type_Aski;
  private bhac jdField_a_of_type_Bhac;
  public ETTextView a;
  public ExtendFriendFeedView a;
  private ExtendFriendLabelFlowLayout jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout;
  public ExtendFriendVoiceView a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public ImageView b;
  public TextView b;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  public ImageView c;
  private int d;
  public ImageView d;
  private int e;
  public ImageView e;
  public ImageView f;
  
  public ashc(View paramView, aski paramaski, asgt paramasgt, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Asgt = paramasgt;
    this.jdField_a_of_type_Aski = paramaski;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366137);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368447));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380082));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369033));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379881));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370138));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363824));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363693));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366688));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380062));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368497));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363891));
    this.f = ((ImageView)paramView.findViewById(2131380990));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(asmy.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a(true);
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_AndroidViewView.setBackground(null);
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 10000)
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if ((this.jdField_a_of_type_AndroidViewView.getBackground() instanceof VasResDrawable)) {
        ((VasResDrawable)this.jdField_a_of_type_AndroidViewView.getBackground()).b(paramInt);
      }
    }
    else
    {
      return;
    }
    VasResDrawable localVasResDrawable = new VasResDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt);
    bhau localbhau = new bhau(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130846121);
    localbhau.a(true);
    localbhau.a(new ashd(this));
    localVasResDrawable.a(localbhau);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localVasResDrawable);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setVisibility(0);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(0, System.currentTimeMillis());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mMsgId = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_Bhac == null)
    {
      this.jdField_a_of_type_Bhac = new bhac(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bhax localbhax = new bhax(this.jdField_a_of_type_Bhac, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbhax.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bhac.a(localbhax);
      localbhax.a(-1);
      return;
    }
    ((bhax)this.jdField_a_of_type_Bhac.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bhax)this.jdField_a_of_type_Bhac.a()).a(paramInt1, paramInt2);
  }
  
  public void a(ashc paramashc, asht paramasht, int paramInt)
  {
    int i;
    if (paramasht.mIsMyFeed)
    {
      paramashc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramashc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramasht.mbAllowStrangerVote) {
        paramashc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramasht.mVoiceUrl)) {
        break label560;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramashc.getPosition();
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasht.mVoiceUrl, paramInt);
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramasht.mVoiceUrl);
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramasht.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Asgt.a(paramasht.mUin, paramasht.mNickName, paramashc.jdField_a_of_type_AndroidWidgetImageView);
      paramashc.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramashc.jdField_a_of_type_AndroidWidgetTextView.setText(paramasht.mNickName);
      paramashc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new bdnt(bmpg.c(paramasht.mDeclaration), 3, 24));
      paramashc.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramashc.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramasht.mLiked) {
        break label573;
      }
      if (paramasht.mAvailLikeCount != 0) {
        break label566;
      }
      paramInt = 2130845116;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramasht, paramashc.f);
      paramashc.f.setTag(paramasht);
      a();
      if (!bcnj.b())
      {
        a(paramasht.clothesId);
        a(paramasht.fontId, paramasht.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = asmi.a(paramasht, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = asmi.b(paramasht, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = asmi.a(paramasht, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label597;
      }
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramashc.jdField_a_of_type_Asjb == null) {
        break label580;
      }
      paramashc.jdField_a_of_type_Asjb.a();
      label387:
      paramashc.jdField_a_of_type_Asjb.a(this.jdField_b_of_type_Boolean);
      paramashc.jdField_a_of_type_Asjb.a((List)localObject1);
      label407:
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramashc.jdField_a_of_type_Asjb);
      if ((paramasht.mSchoolInfos == null) || (paramasht.mSchoolInfos.size() <= 0)) {
        break label634;
      }
      paramasht = (ashv)paramasht.mSchoolInfos.get(0);
      if (paramasht == null) {
        break label622;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramasht.b)) {
        paramashc.jdField_b_of_type_AndroidWidgetTextView.setText(paramasht.b);
      }
      if (paramasht.a != 2L) {
        break label609;
      }
      paramashc.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845163);
      label505:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label646;
      }
    }
    label646:
    for (paramashc = "2";; paramashc = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramashc);
      return;
      paramashc.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramashc.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label560:
      i = 0;
      break label61;
      label566:
      paramInt = 2130845115;
      break label212;
      label573:
      paramInt = 2130845112;
      break label212;
      label580:
      paramashc.jdField_a_of_type_Asjb = new asjb(BaseApplicationImpl.getContext());
      break label387;
      label597:
      paramashc.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      label609:
      paramashc.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845164);
      break label505;
      label622:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
      label634:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
    }
  }
  
  public void a(bgyy parambgyy)
  {
    if ((parambgyy.e != null) && (!TextUtils.isEmpty(parambgyy.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambgyy.e);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambgyy != null) && (parambgyy.t != null) && (!TextUtils.isEmpty(parambgyy.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambgyy.t);
      if (SignTextEditFragment.a(this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_e_of_type_AndroidWidgetImageView.setColorFilter(null);
      }
    }
    else
    {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setColorFilter(-1291845633);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Aski != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363824) || (l - this.jdField_a_of_type_Aski.a() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_Aski.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363693: 
        this.jdField_a_of_type_Aski.c(i);
        break;
      case 2131366137: 
        this.jdField_a_of_type_Aski.a(i, 2);
        break;
      case 2131368447: 
        this.jdField_a_of_type_Aski.a(i, 1);
        break;
      case 2131381037: 
        this.jdField_a_of_type_Aski.a(i);
        break;
      case 2131363824: 
        this.jdField_a_of_type_Aski.b(i);
        break;
      case 2131363891: 
        this.jdField_a_of_type_Aski.d(i);
        break;
      case 2131380990: 
        VipUtils.a(paramView, (asht)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashc
 * JD-Core Version:    0.7.0.1
 */