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

public class aofm
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public ImageView a;
  public TextView a;
  private aofg jdField_a_of_type_Aofg;
  private aoiw jdField_a_of_type_Aoiw;
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
  
  public aofm(View paramView, aoiw paramaoiw, aofg paramaofg, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Aofg = paramaofg;
    this.jdField_a_of_type_Aoiw = paramaoiw;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365797);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367973));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378485));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367965));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378488));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363578));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363456));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378445));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378459));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131368021));
    this.e = ((ImageView)paramView.findViewById(2131363634));
    this.f = ((ImageView)paramView.findViewById(2131379265));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(aokr.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a(true);
    this.e.setOnClickListener(this);
  }
  
  public void a(aofm paramaofm, aogh paramaogh, int paramInt)
  {
    int j = 8;
    Object localObject;
    int i;
    if (paramaogh.mIsMyFeed)
    {
      paramaofm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaofm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramaofm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!paramaogh.mbAllowStrangerVote) {
        paramaofm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localObject = paramaofm.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramaogh.mGender != 1) && (paramaogh.mGender != 2)) {
        break label356;
      }
      i = 0;
      label79:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramaofm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramaogh.mVoiceUrl)) {
        break label363;
      }
      i = j;
      label106:
      ((ExtendFriendVoiceView)localObject).setVisibility(i);
      i = paramaofm.getPosition();
      paramaofm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramaogh.mVoiceUrl, paramInt);
      paramaofm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramaogh.mVoiceUrl);
      paramaofm.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramaogh.mVoiceDuration);
      localObject = this.jdField_a_of_type_Aofg.a(paramaogh.mUin, paramaogh.mNickName, paramaofm.jdField_a_of_type_AndroidWidgetImageView);
      paramaofm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramaofm.jdField_a_of_type_AndroidWidgetTextView.setText(paramaogh.mNickName);
      paramaofm.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramaogh.mPopularity));
      paramaofm.jdField_d_of_type_AndroidWidgetTextView.setText(paramaogh.mDeclaration);
      localObject = paramaofm.jdField_b_of_type_AndroidWidgetImageView;
      if (paramaogh.mGender != 2) {
        break label369;
      }
      paramInt = 2130844286;
      label241:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = paramaofm.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramaogh.mLiked) {
        break label381;
      }
      if (paramaogh.mAvailLikeCount != 0) {
        break label375;
      }
      paramInt = 2130844294;
    }
    for (;;)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      VipUtils.a(paramaogh, paramaofm.f);
      paramaofm.f.setTag(paramaogh);
      return;
      paramaofm.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaofm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramaogh.mAddFriendVerified)
      {
        paramaofm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramaofm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      paramaofm.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramaofm.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label356:
      i = 8;
      break label79;
      label363:
      i = 0;
      break label106;
      label369:
      paramInt = 2130844287;
      break label241;
      label375:
      paramInt = 2130844293;
      continue;
      label381:
      paramInt = 2130844290;
    }
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Aoiw != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131363578) || (l - this.jdField_a_of_type_Aoiw.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aoiw.a(l);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363456: 
      this.jdField_a_of_type_Aoiw.c(i);
      return;
    case 2131365797: 
      this.jdField_a_of_type_Aoiw.a(i, 2);
      return;
    case 2131367973: 
      this.jdField_a_of_type_Aoiw.a(i, 1);
      return;
    case 2131379312: 
      this.jdField_a_of_type_Aoiw.a(i);
      return;
    case 2131363578: 
      this.jdField_a_of_type_Aoiw.b(i);
      return;
    case 2131363634: 
      this.jdField_a_of_type_Aoiw.d(i);
      return;
    }
    VipUtils.a(paramView, (aogh)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aofm
 * JD-Core Version:    0.7.0.1
 */