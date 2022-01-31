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

public class anpb
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public View a;
  public ImageView a;
  public TextView a;
  private anov jdField_a_of_type_Anov;
  private ansk jdField_a_of_type_Ansk;
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
  
  public anpb(View paramView, ansk paramansk, anov paramanov, Activity paramActivity)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView = ((ExtendFriendFeedView)paramView);
    this.jdField_a_of_type_Anov = paramanov;
    this.jdField_a_of_type_Ansk = paramansk;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300198);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302353));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312661));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302345));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312664));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298028));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131297910));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312621));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312635));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView = ((ExtendFriendVoiceView)paramView.findViewById(2131302401));
    this.e = ((ImageView)paramView.findViewById(2131298082));
    this.f = ((ImageView)paramView.findViewById(2131313431));
    this.f.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener((View.OnTouchListener)paramView);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(anue.a);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setMode(1);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setActivity((BaseActivity)paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.a(true);
    this.e.setOnClickListener(this);
  }
  
  public void a(anpb paramanpb, anpv paramanpv, int paramInt)
  {
    int j = 8;
    Object localObject;
    int i;
    if (paramanpv.mIsMyFeed)
    {
      paramanpb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramanpb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      paramanpb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (!paramanpv.mbAllowStrangerVote) {
        paramanpb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localObject = paramanpb.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramanpv.mGender != 1) && (paramanpv.mGender != 2)) {
        break label356;
      }
      i = 0;
      label79:
      ((ImageView)localObject).setVisibility(i);
      localObject = paramanpb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView;
      if (!TextUtils.isEmpty(paramanpv.mVoiceUrl)) {
        break label363;
      }
      i = j;
      label106:
      ((ExtendFriendVoiceView)localObject).setVisibility(i);
      i = paramanpb.getPosition();
      paramanpb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedView.setFeedBgParams(i, paramanpv.mVoiceUrl, paramInt);
      paramanpb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceUrl(paramanpv.mVoiceUrl);
      paramanpb.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView.setVoiceDuration(paramanpv.mVoiceDuration);
      localObject = this.jdField_a_of_type_Anov.a(paramanpv.mUin, paramanpv.mNickName, paramanpb.jdField_a_of_type_AndroidWidgetImageView);
      paramanpb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      paramanpb.jdField_a_of_type_AndroidWidgetTextView.setText(paramanpv.mNickName);
      paramanpb.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramanpv.mPopularity));
      paramanpb.jdField_d_of_type_AndroidWidgetTextView.setText(paramanpv.mDeclaration);
      localObject = paramanpb.jdField_b_of_type_AndroidWidgetImageView;
      if (paramanpv.mGender != 2) {
        break label369;
      }
      paramInt = 2130844209;
      label241:
      ((ImageView)localObject).setImageResource(paramInt);
      localObject = paramanpb.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramanpv.mLiked) {
        break label381;
      }
      if (paramanpv.mAvailLikeCount != 0) {
        break label375;
      }
      paramInt = 2130844216;
    }
    for (;;)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      bajr.a(paramanpv, paramanpb.f);
      paramanpb.f.setTag(paramanpv);
      return;
      paramanpb.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramanpb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramanpv.mAddFriendVerified)
      {
        paramanpb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        paramanpb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        break;
      }
      paramanpb.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      paramanpb.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      label356:
      i = 8;
      break label79;
      label363:
      i = 0;
      break label106;
      label369:
      paramInt = 2130844210;
      break label241;
      label375:
      paramInt = 2130844215;
      continue;
      label381:
      paramInt = 2130844212;
    }
  }
  
  public void onClick(View paramView)
  {
    long l;
    if (this.jdField_a_of_type_Ansk != null)
    {
      l = System.currentTimeMillis();
      if ((paramView.getId() == 2131298028) || (l - this.jdField_a_of_type_Ansk.a() >= 500L)) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ansk.a(l);
    int i = getPosition();
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297910: 
      this.jdField_a_of_type_Ansk.c(i);
      return;
    case 2131300198: 
      this.jdField_a_of_type_Ansk.a(i, 2);
      return;
    case 2131302353: 
      this.jdField_a_of_type_Ansk.a(i, 1);
      return;
    case 2131313477: 
      this.jdField_a_of_type_Ansk.a(i);
      return;
    case 2131298028: 
      this.jdField_a_of_type_Ansk.b(i);
      return;
    case 2131298082: 
      this.jdField_a_of_type_Ansk.d(i);
      return;
    }
    bajr.a(paramView, (anpv)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anpb
 * JD-Core Version:    0.7.0.1
 */