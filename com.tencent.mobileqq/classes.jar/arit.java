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
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class arit
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  private arik jdField_a_of_type_Arik;
  private arkz jdField_a_of_type_Arkz;
  private armg jdField_a_of_type_Armg;
  private bggs jdField_a_of_type_Bggs;
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
  
  public arit(View paramView, armg paramarmg, arik paramarik, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Arik = paramarik;
    this.jdField_a_of_type_Armg = paramarmg;
    if ((paramActivity instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    }
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366214);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368545));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379994));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369155));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379815));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370211));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363874));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363747));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout = ((ExtendFriendLabelFlowLayout)paramView.findViewById(2131366766));
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = ((ETTextView)paramView.findViewById(2131379974));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368595));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363941));
    this.f = ((ImageView)paramView.findViewById(2131380889));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(arpf.a);
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
    bghk localbghk = new bghk(localVasResDrawable, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, 2130846027);
    localbghk.a(true);
    localbghk.a(new ariu(this));
    localVasResDrawable.a(localbghk);
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
    if (this.jdField_a_of_type_Bggs == null)
    {
      this.jdField_a_of_type_Bggs = new bggs(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt1);
      bghn localbghn = new bghn(this.jdField_a_of_type_Bggs, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, paramInt2);
      localbghn.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
      this.jdField_a_of_type_Bggs.a(localbghn);
      localbghn.a(-1);
      return;
    }
    ((bghn)this.jdField_a_of_type_Bggs.a()).a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize(), true);
    ((bghn)this.jdField_a_of_type_Bggs.a()).a(paramInt1, paramInt2);
  }
  
  public void a(arit paramarit, arjk paramarjk, int paramInt)
  {
    int i;
    if (paramarjk.mIsMyFeed)
    {
      paramarit.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramarit.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      if (!paramarjk.mbAllowStrangerVote) {
        paramarit.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      Object localObject1 = paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramarjk.mVoiceUrl)) {
        break label560;
      }
      i = 8;
      label61:
      ((ExtendFriendVoiceView)localObject1).setVisibility(i);
      i = paramarit.getPosition();
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramarjk.mVoiceUrl, paramInt);
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramarjk.mVoiceUrl);
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramarjk.mVoiceDuration);
      localObject1 = this.jdField_a_of_type_Arik.a(paramarjk.mUin, paramarjk.mNickName, paramarit.jdField_a_of_type_AndroidWidgetImageView);
      paramarit.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      paramarit.jdField_a_of_type_AndroidWidgetTextView.setText(paramarjk.mNickName);
      paramarit.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramarjk.mDeclaration), 3, 24));
      paramarit.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(-16777216);
      localObject1 = paramarit.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramarjk.mLiked) {
        break label573;
      }
      if (paramarjk.mAvailLikeCount != 0) {
        break label566;
      }
      paramInt = 2130845018;
      label212:
      ((ImageView)localObject1).setImageResource(paramInt);
      VipUtils.a(paramarjk, paramarit.f);
      paramarit.f.setTag(paramarjk);
      a();
      if (!bbyp.b())
      {
        a(paramarjk.clothesId);
        a(paramarjk.fontId, paramarjk.fontType);
      }
      localObject1 = new ArrayList();
      Object localObject2 = arop.a(paramarjk, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = arop.b(paramarjk, BaseApplicationImpl.getContext());
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
      localObject2 = arop.a(paramarjk, BaseApplicationImpl.getContext());
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
      if (((List)localObject1).size() <= 0) {
        break label597;
      }
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(0);
      if (paramarit.jdField_a_of_type_Arkz == null) {
        break label580;
      }
      paramarit.jdField_a_of_type_Arkz.a();
      label387:
      paramarit.jdField_a_of_type_Arkz.a(this.jdField_b_of_type_Boolean);
      paramarit.jdField_a_of_type_Arkz.a((List)localObject1);
      label407:
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setAdapter(paramarit.jdField_a_of_type_Arkz);
      if ((paramarjk.mSchoolInfos == null) || (paramarjk.mSchoolInfos.size() <= 0)) {
        break label634;
      }
      paramarjk = (arjm)paramarjk.mSchoolInfos.get(0);
      if (paramarjk == null) {
        break label622;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (!TextUtils.isEmpty(paramarjk.b)) {
        paramarit.jdField_b_of_type_AndroidWidgetTextView.setText(paramarjk.b);
      }
      if (paramarjk.a != 2L) {
        break label609;
      }
      paramarit.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845065);
      label505:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label646;
      }
    }
    label646:
    for (paramarit = "2";; paramarit = "1")
    {
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_show", "", 0, "", paramarit);
      return;
      paramarit.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramarit.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      break;
      label560:
      i = 0;
      break label61;
      label566:
      paramInt = 2130845017;
      break label212;
      label573:
      paramInt = 2130845014;
      break label212;
      label580:
      paramarit.jdField_a_of_type_Arkz = new arkz(BaseApplicationImpl.getContext());
      break label387;
      label597:
      paramarit.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendLabelFlowLayout.setVisibility(8);
      break label407;
      label609:
      paramarit.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845066);
      break label505;
      label622:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
      label634:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      break label505;
    }
  }
  
  public void a(bgfo parambgfo)
  {
    if (parambgfo == null) {}
    do
    {
      return;
      if ((parambgfo.e != null) && (!TextUtils.isEmpty(parambgfo.e)))
      {
        this.jdField_a_of_type_Int = Color.parseColor(parambgfo.e);
        if ((this.jdField_a_of_type_ComEtrumpMixlayoutETTextView != null) && (this.jdField_a_of_type_Int != 0)) {
          this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(this.jdField_a_of_type_Int);
        }
      }
    } while ((parambgfo.t == null) || (TextUtils.isEmpty(parambgfo.t)));
    this.jdField_b_of_type_Int = Color.parseColor(parambgfo.t);
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
    if (this.jdField_a_of_type_Armg != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363874) || (l - this.jdField_a_of_type_Armg.a() >= 500L)) {
        break label46;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label46:
      this.jdField_a_of_type_Armg.a(l);
      int i = getPosition();
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363747: 
        this.jdField_a_of_type_Armg.c(i);
        break;
      case 2131366214: 
        this.jdField_a_of_type_Armg.a(i, 2);
        break;
      case 2131368545: 
        this.jdField_a_of_type_Armg.a(i, 1);
        break;
      case 2131380936: 
        this.jdField_a_of_type_Armg.a(i);
        break;
      case 2131363874: 
        this.jdField_a_of_type_Armg.b(i);
        break;
      case 2131363941: 
        this.jdField_a_of_type_Armg.d(i);
        break;
      case 2131380889: 
        VipUtils.a(paramView, (arjk)paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arit
 * JD-Core Version:    0.7.0.1
 */