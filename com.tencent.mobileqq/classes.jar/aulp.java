import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aulp
  implements View.OnClickListener
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
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
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new aulq(this));
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
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131702864), 0).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      Object localObject;
      if (this.b)
      {
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
        {
          if (this.jdField_a_of_type_Boolean)
          {
            new StringBuilder(this.jdField_a_of_type_JavaLangString);
            if (this.jdField_a_of_type_JavaLangString.indexOf("?") > 0) {
              this.jdField_a_of_type_JavaLangString += "&converFrom=qqFile";
            }
          }
          else
          {
            if (!this.jdField_a_of_type_Boolean) {
              break label204;
            }
            beeg.a(null, "0X800ABAB");
          }
          for (;;)
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("url", this.jdField_a_of_type_JavaLangString);
            ((Bundle)localObject).putBoolean("temp_preview_from_qq", true);
            ((Bundle)localObject).putParcelable("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject, false);
            break;
            this.jdField_a_of_type_JavaLangString += "?converFrom=qqFile";
            break label115;
            label204:
            beeg.a(null, "0X800ABAC");
          }
        }
      }
      else
      {
        localObject = BaseApplicationImpl.sApplication.getRuntime();
        if ((localObject instanceof QQAppInterface))
        {
          localObject = (bebl)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_IMPORT_HANDLER);
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
          {
            if (!((bebl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo))
            {
              this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
              ((bebl)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
            }
            beeg.a(null, "0X800ABA6");
            beaz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulp
 * JD-Core Version:    0.7.0.1
 */