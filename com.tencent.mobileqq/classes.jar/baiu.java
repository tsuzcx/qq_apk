import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class baiu
  extends baik
{
  public baiu(baei parambaei, azxr paramazxr)
  {
    super(parambaei, paramazxr);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ProfileLabelEditorActivity.class);
    localIntent.putExtra("uin", ((azxr)this.b).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(localIntent, 1004);
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "card_mall", "0X80066C6", 0, 0, "1", "", "", "");
  }
  
  public String a()
  {
    return "VasProfileHeaderTagComponent";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null)
    {
      VasProfileTagView localVasProfileTagView = new VasProfileTagView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (azxr)this.b);
      localVasProfileTagView.setProfileArgs(this.jdField_a_of_type_Baei);
      localVasProfileTagView.setClickListener(this);
      localVasProfileTagView.a();
      this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView = localVasProfileTagView;
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).removeAllViews();
      ((FrameLayout)this.jdField_a_of_type_JavaLangObject).addView(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
      paramIntent = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    } while (paramIntent == null);
    ((azxr)this.b).jdField_a_of_type_ComTencentMobileqqDataCard = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.i((azxr)this.b);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getTag() instanceof azvr)) {
      switch (((azvr)paramView.getTag()).a)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baiu
 * JD-Core Version:    0.7.0.1
 */