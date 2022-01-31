import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import com.tencent.mobileqq.utils.VipUtils;

public class aofr
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public ImageView a;
  public TextView a;
  private aofl jdField_a_of_type_Aofl;
  private aojb jdField_a_of_type_Aojb;
  public ExtendFriendFeedView a;
  public ExtendFriendVoiceView a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  public TextView c;
  public ImageView d;
  public TextView d;
  public ImageView e;
  public ImageView f;
  
  public aofr(View paramView, aojb paramaojb, aofl paramaofl, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Aofl = paramaofl;
    this.jdField_a_of_type_Aojb = paramaojb;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365796);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367973));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378490));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367965));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378493));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363577));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363455));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378450));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378464));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368021));
    this.e = ((ImageView)paramView.findViewById(2131363633));
    this.f = ((ImageView)paramView.findViewById(2131379270));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(aokw.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a(true);
    this.e.setOnClickListener(this);
  }
  
  public void a(aofr paramaofr, aogm paramaogm, int paramInt)
  {
    int j = 8;
    Object localObject;
    int i;
    if (paramaogm.mIsMyFeed)
    {
      paramaofr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaofr.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaofr.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!paramaogm.mbAllowStrangerVote) {
        paramaofr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localObject = paramaofr.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramaogm.mGender != 1) && (paramaogm.mGender != 2)) {
        break label356;
      }
      i = 0;
      label79:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramaofr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramaogm.mVoiceUrl)) {
        break label363;
      }
      i = j;
      label106:
      ((ExtendFriendVoiceView)localObject).setVisibility(i);
      i = paramaofr.getPosition();
      paramaofr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaogm.mVoiceUrl, paramInt);
      paramaofr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramaogm.mVoiceUrl);
      paramaofr.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramaogm.mVoiceDuration);
      localObject = this.jdField_a_of_type_Aofl.a(paramaogm.mUin, paramaogm.mNickName, paramaofr.jdField_a_of_type_AndroidWidgetImageView);
      paramaofr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaofr.jdField_a_of_type_AndroidWidgetTextView.setText(paramaogm.mNickName);
      paramaofr.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaogm.mPopularity));
      paramaofr.jdField_d_of_type_AndroidWidgetTextView.setText(paramaogm.mDeclaration);
      localObject = paramaofr.jdField_b_of_type_AndroidWidgetImageView;
      if (paramaogm.mGender != 2) {
        break label369;
      }
      paramInt = 2130844287;
      label241:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = paramaofr.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramaogm.mLiked) {
        break label381;
      }
      if (paramaogm.mAvailLikeCount != 0) {
        break label375;
      }
      paramInt = 2130844295;
    }
    for (;;)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      VipUtils.a(paramaogm, paramaofr.f);
      paramaofr.f.setTag(paramaogm);
      return;
      paramaofr.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaofr.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramaogm.mAddFriendVerified)
      {
        paramaofr.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaofr.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      paramaofr.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaofr.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label356:
      i = 8;
      break label79;
      label363:
      i = 0;
      break label106;
      label369:
      paramInt = 2130844288;
      break label241;
      label375:
      paramInt = 2130844294;
      continue;
      label381:
      paramInt = 2130844291;
    }
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Aojb != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363577) || (l - this.jdField_a_of_type_Aojb.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aojb.a(l);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363455: 
      this.jdField_a_of_type_Aojb.c(i);
      return;
    case 2131365796: 
      this.jdField_a_of_type_Aojb.a(i, 2);
      return;
    case 2131367973: 
      this.jdField_a_of_type_Aojb.a(i, 1);
      return;
    case 2131379317: 
      this.jdField_a_of_type_Aojb.a(i);
      return;
    case 2131363577: 
      this.jdField_a_of_type_Aojb.b(i);
      return;
    case 2131363633: 
      this.jdField_a_of_type_Aojb.d(i);
      return;
    }
    VipUtils.a(paramView, (aogm)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofr
 * JD-Core Version:    0.7.0.1
 */