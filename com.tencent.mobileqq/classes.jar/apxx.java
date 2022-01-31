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

public class apxx
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private apxo jdField_a_of_type_Apxo;
  private apzt jdField_a_of_type_Apzt;
  private aqba jdField_a_of_type_Aqba;
  private bdqs jdField_a_of_type_Bdqs;
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
  
  public apxx(View paramView, aqba paramaqba, apxo paramapxo, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Apxo = paramapxo;
    this.jdField_a_of_type_Aqba = paramaqba;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365883);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368110));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379102));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368690));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378926));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369691));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363622));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363495));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366429));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131379076));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368159));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363686));
    this.f = ((ImageView)paramView.findViewById(2131379971));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(aqdo.a);
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
    bdrj localbdrj = new bdrj(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130845639);
    localbdrj.a(true);
    localbdrj.a(new apxy(this));
    localVasResDrawable.a(localbdrj);
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
    if (this.jdField_a_of_type_Bdqs == null)
    {
      this.jdField_a_of_type_Bdqs = new bdqs(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bdrm localbdrm = new bdrm(this.jdField_a_of_type_Bdqs, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbdrm.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bdqs.a(localbdrm);
      localbdrm.a(-1);
      return;
    }
    ((bdrm)this.jdField_a_of_type_Bdqs.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bdrm)this.jdField_a_of_type_Bdqs.a()).a(paramInt1, paramInt2);
  }
  
  public void a(apxx paramapxx, apyo paramapyo, int paramInt)
  {
    int i;
    if (paramapyo.mIsMyFeed)
    {
      paramapxx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramapxx.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramapyo.mbAllowStrangerVote) {
        paramapxx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramapyo.mVoiceUrl)) {
        break label525;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramapxx.getPosition();
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramapyo.mVoiceUrl, paramInt);
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramapyo.mVoiceUrl);
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramapyo.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Apxo.a(paramapyo.mUin, paramapyo.mNickName, paramapxx.jdField_a_of_type_AndroidWidgetImageView);
      paramapxx.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramapxx.jdField_a_of_type_AndroidWidgetTextView.setText(paramapyo.mNickName);
      paramapxx.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new baig(bjwp.d(paramapyo.mDeclaration), 3, 24));
      paramapxx.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramapxx.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramapyo.mLiked) {
        break label538;
      }
      if (paramapyo.mAvailLikeCount != 0) {
        break label531;
      }
      paramInt = 2130844647;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramapyo, paramapxx.f);
      paramapxx.f.setTag(paramapyo);
      a();
      if (!azib.b())
      {
        a(paramapyo.clothesId);
        a(paramapyo.fontId, paramapyo.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = aqcw.a(paramapyo, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = aqcw.b(paramapyo, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = aqcw.a(paramapyo, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label562;
      }
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramapxx.jdField_a_of_type_Apzt == null) {
        break label545;
      }
      paramapxx.jdField_a_of_type_Apzt.a();
      label387:
      paramapxx.jdField_a_of_type_Apzt.a(this.jdField_b_of_type_Boolean);
      paramapxx.jdField_a_of_type_Apzt.a((List)localObject1);
    }
    for (;;)
    {
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramapxx.jdField_a_of_type_Apzt);
      if ((paramapyo.mSchoolInfos == null) || (paramapyo.mSchoolInfos.size() <= 0)) {
        break label595;
      }
      paramapyo = (apyq)paramapyo.mSchoolInfos.get(0);
      if (paramapyo == null) {
        break label585;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramapyo.b)) {
        paramapxx.jdField_b_of_type_AndroidWidgetTextView.setText(paramapyo.b);
      }
      if (paramapyo.a != 2L) {
        break label574;
      }
      paramapxx.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844698);
      return;
      paramapxx.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramapxx.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label525:
      i = 0;
      break label61;
      label531:
      paramInt = 2130844646;
      break label212;
      label538:
      paramInt = 2130844643;
      break label212;
      label545:
      paramapxx.jdField_a_of_type_Apzt = new apzt(BaseApplicationImpl.getContext());
      break label387;
      label562:
      paramapxx.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
    }
    label574:
    paramapxx.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844700);
    return;
    label585:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return;
    label595:
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void a(bdpm parambdpm)
  {
    if ((parambdpm.e != null) && (!TextUtils.isEmpty(parambdpm.e)))
    {
      this.jdField_a_of_type_Int = Color.parseColor(parambdpm.e);
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
      }
    }
    if ((parambdpm != null) && (parambdpm.t != null) && (!TextUtils.isEmpty(parambdpm.t)))
    {
      this.jdField_b_of_type_Int = Color.parseColor(parambdpm.t);
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
    if (this.jdField_a_of_type_Aqba != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363622) || (l - this.jdField_a_of_type_Aqba.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aqba.a(l);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363495: 
      this.jdField_a_of_type_Aqba.c(i);
      return;
    case 2131365883: 
      this.jdField_a_of_type_Aqba.a(i, 2);
      return;
    case 2131368110: 
      this.jdField_a_of_type_Aqba.a(i, 1);
      return;
    case 2131380018: 
      this.jdField_a_of_type_Aqba.a(i);
      return;
    case 2131363622: 
      this.jdField_a_of_type_Aqba.b(i);
      return;
    case 2131363686: 
      this.jdField_a_of_type_Aqba.d(i);
      return;
    }
    VipUtils.a(paramView, (apyo)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apxx
 * JD-Core Version:    0.7.0.1
 */