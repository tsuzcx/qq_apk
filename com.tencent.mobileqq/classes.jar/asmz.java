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
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class asmz
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private asmq jdField_a_of_type_Asmq;
  private aspf jdField_a_of_type_Aspf;
  private asqm jdField_a_of_type_Asqm;
  private bhpm jdField_a_of_type_Bhpm;
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
  
  public asmz(View paramView, asqm paramasqm, asmq paramasmq, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Asmq = paramasmq;
    this.jdField_a_of_type_Asqm = paramasqm;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366318);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368703));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380333));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369317));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370388));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363946));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363818));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366882));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131380313));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368754));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364015));
    this.f = ((ImageView)paramView.findViewById(2131381241));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(astl.a);
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
    bhqf localbhqf = new bhqf(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130846115);
    localbhqf.a(true);
    localbhqf.a(new asna(this));
    localVasResDrawable.a(localbhqf);
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
    if (this.jdField_a_of_type_Bhpm == null)
    {
      this.jdField_a_of_type_Bhpm = new bhpm(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bhqi localbhqi = new bhqi(this.jdField_a_of_type_Bhpm, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbhqi.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bhpm.a(localbhqi);
      localbhqi.a(-1);
      return;
    }
    ((bhqi)this.jdField_a_of_type_Bhpm.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bhqi)this.jdField_a_of_type_Bhpm.a()).a(paramInt1, paramInt2);
  }
  
  public void a(asmz paramasmz, asnq paramasnq, int paramInt)
  {
    int i;
    if (paramasnq.mIsMyFeed)
    {
      paramasmz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramasmz.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramasnq.mbAllowStrangerVote) {
        paramasmz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramasnq.mVoiceUrl)) {
        break label605;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramasmz.getPosition();
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramasnq.mVoiceUrl, paramInt);
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramasnq.mVoiceUrl);
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramasnq.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Asmq.a(paramasnq.mUin, paramasnq.mNickName, paramasmz.jdField_a_of_type_AndroidWidgetImageView);
      paramasmz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramasmz.jdField_a_of_type_AndroidWidgetTextView.setText(paramasnq.mNickName);
      paramasmz.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramasnq.mDeclaration), 3, 24));
      paramasmz.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramasmz.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramasnq.mLiked) {
        break label618;
      }
      if (paramasnq.mAvailLikeCount != 0) {
        break label611;
      }
      paramInt = 2130845092;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramasnq, paramasmz.f);
      paramasmz.f.setTag(paramasnq);
      a();
      if (!bdfk.b())
      {
        a(paramasnq.clothesId);
        a(paramasnq.fontId, paramasnq.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = assv.a(paramasnq, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = assv.b(paramasnq, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = assv.a(paramasnq, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label642;
      }
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramasmz.jdField_a_of_type_Aspf == null) {
        break label625;
      }
      paramasmz.jdField_a_of_type_Aspf.a();
      label387:
      paramasmz.jdField_a_of_type_Aspf.a(this.jdField_b_of_type_Boolean);
      paramasmz.jdField_a_of_type_Aspf.a((List)localObject1);
      label407:
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramasmz.jdField_a_of_type_Aspf);
      if ((paramasnq.mSchoolInfos == null) || (paramasnq.mSchoolInfos.size() <= 0)) {
        break label679;
      }
      localObject1 = (asns)paramasnq.mSchoolInfos.get(0);
      if (localObject1 == null) {
        break label667;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(((asns)localObject1).b)) {
        paramasmz.jdField_b_of_type_AndroidWidgetTextView.setText(((asns)localObject1).b);
      }
      if (((asns)localObject1).a != 2L) {
        break label654;
      }
      paramasmz.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845139);
      label510:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label691;
      }
    }
    label642:
    label654:
    label667:
    label679:
    label691:
    for (paramasmz = "2";; paramasmz = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramasmz);
      paramasmz = new HashMap();
      paramasmz.put("feed_uid", paramasnq.mUin);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "expose#voice_tab#feed", true, -1L, -1L, paramasmz, true, true);
      return;
      paramasmz.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramasmz.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label605:
      i = 0;
      break label61;
      label611:
      paramInt = 2130845091;
      break label212;
      label618:
      paramInt = 2130845088;
      break label212;
      label625:
      paramasmz.jdField_a_of_type_Aspf = new aspf(BaseApplicationImpl.getContext());
      break label387;
      paramasmz.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      paramasmz.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845140);
      break label510;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label510;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label510;
    }
  }
  
  public void a(bhoj parambhoj)
  {
    if (parambhoj == null) {}
    do
    {
      return;
      if ((parambhoj.e != null) && (!TextUtils.isEmpty(parambhoj.e)))
      {
        this.jdField_a_of_type_Int = Color.parseColor(parambhoj.e);
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
        }
      }
    } while ((parambhoj.t == null) || (TextUtils.isEmpty(parambhoj.t)));
    this.jdField_b_of_type_Int = Color.parseColor(parambhoj.t);
    if (SignTextEditFragment.a(this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_e_of_type_AndroidWidgetImageView.setColorFilter(null);
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
    if (this.jdField_a_of_type_Asqm != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363946) || (l - this.jdField_a_of_type_Asqm.a() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_Asqm.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363818: 
        this.jdField_a_of_type_Asqm.c(i);
        break;
      case 2131366318: 
        this.jdField_a_of_type_Asqm.a(i, 2);
        break;
      case 2131368703: 
        this.jdField_a_of_type_Asqm.a(i, 1);
        break;
      case 2131381288: 
        this.jdField_a_of_type_Asqm.a(i);
        break;
      case 2131363946: 
        this.jdField_a_of_type_Asqm.b(i);
        break;
      case 2131364015: 
        this.jdField_a_of_type_Asqm.d(i);
        break;
      case 2131381241: 
        VipUtils.a(paramView, (asnq)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmz
 * JD-Core Version:    0.7.0.1
 */