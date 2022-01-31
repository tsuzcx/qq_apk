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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class aqcg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private aqbx jdField_a_of_type_Aqbx;
  private aqec jdField_a_of_type_Aqec;
  private aqfj jdField_a_of_type_Aqfj;
  private bdvb jdField_a_of_type_Bdvb;
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
  
  public aqcg(View paramView, aqfj paramaqfj, aqbx paramaqbx, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Aqbx = paramaqbx;
    this.jdField_a_of_type_Aqfj = paramaqfj;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365885);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368121));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379160));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368702));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378984));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369710));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363624));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363497));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366434));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131379134));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368170));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363688));
    this.f = ((ImageView)paramView.findViewById(2131380029));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(aqhx.a);
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
    bdvs localbdvs = new bdvs(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130845711);
    localbdvs.a(true);
    localbdvs.a(new aqch(this));
    localVasResDrawable.a(localbdvs);
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
    if (this.jdField_a_of_type_Bdvb == null)
    {
      this.jdField_a_of_type_Bdvb = new bdvb(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bdvv localbdvv = new bdvv(this.jdField_a_of_type_Bdvb, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbdvv.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bdvb.a(localbdvv);
      localbdvv.a(-1);
      return;
    }
    ((bdvv)this.jdField_a_of_type_Bdvb.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bdvv)this.jdField_a_of_type_Bdvb.a()).a(paramInt1, paramInt2);
  }
  
  public void a(aqcg paramaqcg, aqcx paramaqcx, int paramInt)
  {
    int i;
    if (paramaqcx.mIsMyFeed)
    {
      paramaqcg.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaqcg.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramaqcx.mbAllowStrangerVote) {
        paramaqcg.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramaqcx.mVoiceUrl)) {
        break label525;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramaqcg.getPosition();
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaqcx.mVoiceUrl, paramInt);
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramaqcx.mVoiceUrl);
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramaqcx.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Aqbx.a(paramaqcx.mUin, paramaqcx.mNickName, paramaqcg.jdField_a_of_type_AndroidWidgetImageView);
      paramaqcg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramaqcg.jdField_a_of_type_AndroidWidgetTextView.setText(paramaqcx.mNickName);
      paramaqcg.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new bamp(bkaw.d(paramaqcx.mDeclaration), 3, 24));
      paramaqcg.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramaqcg.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramaqcx.mLiked) {
        break label538;
      }
      if (paramaqcx.mAvailLikeCount != 0) {
        break label531;
      }
      paramInt = 2130844719;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramaqcx, paramaqcg.f);
      paramaqcg.f.setTag(paramaqcx);
      a();
      if (!azmk.b())
      {
        a(paramaqcx.clothesId);
        a(paramaqcx.fontId, paramaqcx.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = aqhf.a(paramaqcx, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = aqhf.b(paramaqcx, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = aqhf.a(paramaqcx, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label562;
      }
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramaqcg.jdField_a_of_type_Aqec == null) {
        break label545;
      }
      paramaqcg.jdField_a_of_type_Aqec.a();
      label387:
      paramaqcg.jdField_a_of_type_Aqec.a(this.jdField_b_of_type_Boolean);
      paramaqcg.jdField_a_of_type_Aqec.a((List)localObject1);
    }
    for (;;)
    {
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramaqcg.jdField_a_of_type_Aqec);
      if ((paramaqcx.mSchoolInfos == null) || (paramaqcx.mSchoolInfos.size() <= 0)) {
        break label595;
      }
      paramaqcx = (aqcz)paramaqcx.mSchoolInfos.get(0);
      if (paramaqcx == null) {
        break label585;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramaqcx.b)) {
        paramaqcg.jdField_b_of_type_AndroidWidgetTextView.setText(paramaqcx.b);
      }
      if (paramaqcx.a != 2L) {
        break label574;
      }
      paramaqcg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844770);
      return;
      paramaqcg.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaqcg.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label525:
      i = 0;
      break label61;
      label531:
      paramInt = 2130844718;
      break label212;
      label538:
      paramInt = 2130844715;
      break label212;
      label545:
      paramaqcg.jdField_a_of_type_Aqec = new aqec(BaseApplicationImpl.getContext());
      break label387;
      label562:
      paramaqcg.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
    }
    label574:
    paramaqcg.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844772);
    return;
    label585:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return;
    label595:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(bdtv parambdtv)
  {
    if ((parambdtv.e != null) && (!TextUtils.isEmpty(parambdtv.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambdtv.e);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambdtv != null) && (parambdtv.t != null) && (!TextUtils.isEmpty(parambdtv.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambdtv.t);
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
    if (this.jdField_a_of_type_Aqfj != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363624) || (l - this.jdField_a_of_type_Aqfj.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aqfj.a(l);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363497: 
      this.jdField_a_of_type_Aqfj.c(i);
      return;
    case 2131365885: 
      this.jdField_a_of_type_Aqfj.a(i, 2);
      return;
    case 2131368121: 
      this.jdField_a_of_type_Aqfj.a(i, 1);
      return;
    case 2131380076: 
      this.jdField_a_of_type_Aqfj.a(i);
      return;
    case 2131363624: 
      this.jdField_a_of_type_Aqfj.b(i);
      return;
    case 2131363688: 
      this.jdField_a_of_type_Aqfj.d(i);
      return;
    }
    VipUtils.a(paramView, (aqcx)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcg
 * JD-Core Version:    0.7.0.1
 */