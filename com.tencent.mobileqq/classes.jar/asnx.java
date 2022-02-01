import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportDialogFragment;

public class asnx
  extends ReportDialogFragment
  implements DialogInterface.OnKeyListener, View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDrawable jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable;
  private Button b;
  
  public static asnx a(int paramInt)
  {
    asnx localasnx = new asnx();
    Bundle localBundle = new Bundle();
    localBundle.putInt("extend_friend_apollo_face_type", paramInt);
    localasnx.setArguments(localBundle);
    return localasnx;
  }
  
  private void a()
  {
    this.b.setOnClickListener(this);
    getDialog().setOnKeyListener(this);
    a(this.jdField_a_of_type_Int);
  }
  
  private void a(int paramInt)
  {
    if (!a()) {}
    while ((paramInt == -1) || (bhhr.E(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin()) != 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable = asmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin(), new asny(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDrawable);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.b.setTextColor(ContextCompat.getColor(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131167363));
    }
    switch (paramInt)
    {
    default: 
      b(184);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698467);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new asoa(this));
      return;
    case 4: 
      b(340);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698468);
      b();
      return;
    }
    b(184);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698467);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new asnz(this));
  }
  
  private void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (QQBrowserActivity.a(1000L)))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    }
  }
  
  private boolean a()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while ((Build.VERSION.SDK_INT >= 17) && (getActivity().isDestroyed())) {
      return false;
    }
    return true;
  }
  
  private void b()
  {
    bhhr.o(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 1, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentAccountUin());
  }
  
  private void b(int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt);
    localLayoutParams.width = -1;
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      dismiss();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("extend_friend_apollo_face_type", -1);
    }
    setStyle(0, 2131755207);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)getActivity());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561107, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramLayoutInflater.findViewById(2131362790));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131367798));
    this.b = ((Button)paramLayoutInflater.findViewById(2131367797));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131362810));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131362825));
    a();
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (a()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
    {
      b();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnx
 * JD-Core Version:    0.7.0.1
 */