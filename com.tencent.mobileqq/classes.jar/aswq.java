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

public class aswq
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private aswh jdField_a_of_type_Aswh;
  private asys jdField_a_of_type_Asys;
  private aszz jdField_a_of_type_Aszz;
  private biai jdField_a_of_type_Biai;
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
  
  public aswq(View paramView, aszz paramaszz, aswh paramaswh, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Aswh = paramaswh;
    this.jdField_a_of_type_Aszz = paramaszz;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366186);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368520));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380267));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369127));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380063));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370237));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363848));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363718));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366738));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380247));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368570));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363915));
    this.f = ((ImageView)paramView.findViewById(2131381170));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(atcx.a);
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
    biba localbiba = new biba(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130846136);
    localbiba.a(true);
    localbiba.a(new aswr(this));
    localVasResDrawable.a(localbiba);
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
    if (this.jdField_a_of_type_Biai == null)
    {
      this.jdField_a_of_type_Biai = new biai(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bibd localbibd = new bibd(this.jdField_a_of_type_Biai, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbibd.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Biai.a(localbibd);
      localbibd.a(-1);
      return;
    }
    ((bibd)this.jdField_a_of_type_Biai.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bibd)this.jdField_a_of_type_Biai.a()).a(paramInt1, paramInt2);
  }
  
  public void a(aswq paramaswq, asxh paramasxh, int paramInt)
  {
    int i;
    if (paramasxh.mIsMyFeed)
    {
      paramaswq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaswq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramasxh.mbAllowStrangerVote) {
        paramaswq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramasxh.mVoiceUrl)) {
        break label560;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramaswq.getPosition();
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasxh.mVoiceUrl, paramInt);
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramasxh.mVoiceUrl);
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramasxh.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Aswh.a(paramasxh.mUin, paramasxh.mNickName, paramaswq.jdField_a_of_type_AndroidWidgetImageView);
      paramaswq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramaswq.jdField_a_of_type_AndroidWidgetTextView.setText(paramasxh.mNickName);
      paramaswq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new begp(bnqj.c(paramasxh.mDeclaration), 3, 24));
      paramaswq.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramaswq.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramasxh.mLiked) {
        break label573;
      }
      if (paramasxh.mAvailLikeCount != 0) {
        break label566;
      }
      paramInt = 2130845131;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramasxh, paramaswq.f);
      paramaswq.f.setTag(paramasxh);
      a();
      if (!bdgb.b())
      {
        a(paramasxh.clothesId);
        a(paramasxh.fontId, paramasxh.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = atch.a(paramasxh, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = atch.b(paramasxh, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = atch.a(paramasxh, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label597;
      }
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramaswq.jdField_a_of_type_Asys == null) {
        break label580;
      }
      paramaswq.jdField_a_of_type_Asys.a();
      label387:
      paramaswq.jdField_a_of_type_Asys.a(this.jdField_b_of_type_Boolean);
      paramaswq.jdField_a_of_type_Asys.a((List)localObject1);
      label407:
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramaswq.jdField_a_of_type_Asys);
      if ((paramasxh.mSchoolInfos == null) || (paramasxh.mSchoolInfos.size() <= 0)) {
        break label634;
      }
      paramasxh = (asxj)paramasxh.mSchoolInfos.get(0);
      if (paramasxh == null) {
        break label622;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramasxh.b)) {
        paramaswq.jdField_b_of_type_AndroidWidgetTextView.setText(paramasxh.b);
      }
      if (paramasxh.a != 2L) {
        break label609;
      }
      paramaswq.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845178);
      label505:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label646;
      }
    }
    label646:
    for (paramaswq = "2";; paramaswq = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramaswq);
      return;
      paramaswq.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaswq.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label560:
      i = 0;
      break label61;
      label566:
      paramInt = 2130845130;
      break label212;
      label573:
      paramInt = 2130845127;
      break label212;
      label580:
      paramaswq.jdField_a_of_type_Asys = new asys(BaseApplicationImpl.getContext());
      break label387;
      label597:
      paramaswq.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      label609:
      paramaswq.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845179);
      break label505;
      label622:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
      label634:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
    }
  }
  
  public void a(bhzd parambhzd)
  {
    if ((parambhzd.e != null) && (!TextUtils.isEmpty(parambhzd.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambhzd.e);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambhzd != null) && (parambhzd.t != null) && (!TextUtils.isEmpty(parambhzd.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambhzd.t);
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
    if (this.jdField_a_of_type_Aszz != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363848) || (l - this.jdField_a_of_type_Aszz.a() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_Aszz.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363718: 
        this.jdField_a_of_type_Aszz.c(i);
        break;
      case 2131366186: 
        this.jdField_a_of_type_Aszz.a(i, 2);
        break;
      case 2131368520: 
        this.jdField_a_of_type_Aszz.a(i, 1);
        break;
      case 2131381217: 
        this.jdField_a_of_type_Aszz.a(i);
        break;
      case 2131363848: 
        this.jdField_a_of_type_Aszz.b(i);
        break;
      case 2131363915: 
        this.jdField_a_of_type_Aszz.d(i);
        break;
      case 2131381170: 
        VipUtils.a(paramView, (asxh)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswq
 * JD-Core Version:    0.7.0.1
 */