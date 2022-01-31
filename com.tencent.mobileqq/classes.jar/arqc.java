import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class arqc
  implements View.OnClickListener
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  final String jdField_a_of_type_JavaLangString = "DocCollectFormBanner";
  boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public arqc(Activity paramActivity, ViewGroup paramViewGroup, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560665, paramViewGroup, true);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131364415);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364850));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364853));
    a();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698491);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698492);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    this.jdField_b_of_type_Boolean = true;
    StringBuilder localStringBuilder = new StringBuilder().append(paramInt).append(alpo.a(2131703759));
    if (paramBoolean) {}
    for (paramString = alpo.a(2131698493);; paramString = alpo.a(2131703767))
    {
      paramString = paramString;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      if (!paramBoolean) {
        break;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131698490);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131703750);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null)
    {
      if (!paramBoolean) {
        break label98;
      }
      if (!this.c)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.c = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
    return;
    label98:
    this.c = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.c = false;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { this.jdField_a_of_type_AndroidViewView.getHeight() });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new arqd(this));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
      return;
    }
    this.c = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (!bdee.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alpo.a(2131703762), 0).a();
    }
    label195:
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_b_of_type_Boolean) {
            break;
          }
        } while ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null));
        if (this.jdField_a_of_type_Boolean)
        {
          new StringBuilder(this.jdField_b_of_type_JavaLangString);
          if (this.jdField_b_of_type_JavaLangString.indexOf("?") > 0) {
            this.jdField_b_of_type_JavaLangString += "&converFrom=qqFile";
          }
        }
        else
        {
          if (!this.jdField_a_of_type_Boolean) {
            break label195;
          }
          bafi.a(null, "0X800ABAB");
        }
        for (;;)
        {
          paramView = new Bundle();
          paramView.putString("url", this.jdField_b_of_type_JavaLangString);
          paramView.putBoolean("temp_preview_from_qq", true);
          paramView.putParcelable("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramView, false);
          return;
          this.jdField_b_of_type_JavaLangString += "?converFrom=qqFile";
          break;
          bafi.a(null, "0X800ABAC");
        }
        paramView = BaseApplicationImpl.sApplication.getRuntime();
      } while (!(paramView instanceof QQAppInterface));
      paramView = (bacn)((QQAppInterface)paramView).a(120);
    } while ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null));
    if (!paramView.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
      paramView.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    bafi.a(null, "0X800ABA6");
    bacb.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqc
 * JD-Core Version:    0.7.0.1
 */