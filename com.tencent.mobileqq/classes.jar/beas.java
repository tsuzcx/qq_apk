import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AutoVerticalScrollTextView;

public class beas
{
  private int jdField_a_of_type_Int = 1;
  private Activity jdField_a_of_type_AndroidAppActivity;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhpc jdField_a_of_type_Bhpc;
  public AppInterface a;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private AutoVerticalScrollTextView jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[2];
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public beas(RelativeLayout paramRelativeLayout, Activity paramActivity, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Bhpc == null) || (this.jdField_a_of_type_Bhpc.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("TeamWorkFileImportCover", 1, " dismiss exception: " + localException.toString());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299011);
  }
  
  public View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidAppActivity.findViewById(paramInt);
  }
  
  public View a(Bundle paramBundle)
  {
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131562987, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(3, 2131376731);
    paramBundle.topMargin = (-a());
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidViewView, 1);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376731).setBackgroundColor(-1);
    this.jdField_a_of_type_AndroidViewView = a(2131378481);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131378478));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131378477));
    this.jdField_b_of_type_AndroidViewView = a(2131378482);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131362694));
    paramBundle = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getLayoutParams();
    paramBundle.height = bhtq.b(60.0F);
    paramBundle.width = bhtq.b(60.0F);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setLayoutParams(paramBundle);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131378483));
    this.d = ((TextView)a(2131378486));
    this.e = ((TextView)a(2131378484));
    this.f = ((TextView)a(2131378485));
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView = ((AutoVerticalScrollTextView)a(2131378479));
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.jdField_a_of_type_AndroidAppActivity.getString(2131718597);
    this.jdField_a_of_type_ArrayOfJavaLangString[1] = this.jdField_a_of_type_AndroidAppActivity.getString(2131718598);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setTextArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    a(this.jdField_a_of_type_AndroidAppActivity.getIntent(), this.jdField_a_of_type_AndroidAppActivity);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "show loading view start time [" + System.currentTimeMillis() / 1000L + "]");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getApplication()).inflate(2131562983, this.jdField_a_of_type_AndroidWidgetRelativeLayout, false));
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(14, -1);
    paramBundle.addRule(12, -1);
    paramBundle.bottomMargin = bhtq.b(12.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBundle);
    becb.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null, "0X8009ED4");
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (a()) {
      becb.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null, "0X8009ED5");
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    if (this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView != null) {
      this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = null;
    c();
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_c_of_type_AndroidViewView = null;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = 4;
    becb.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, null, "0X800A2F2");
    if (this.jdField_a_of_type_AndroidAppActivity == null)
    {
      QLog.i("teamConvert", 1, "showFailedView, but activity is null");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.d.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    label146:
    String str;
    if ((paramInt == 116) || (paramInt == -116))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramInt == 116)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718600));
        if (!TextUtils.isEmpty(paramString)) {
          break label281;
        }
        str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718607);
        label167:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376731).setBackgroundColor(Color.parseColor("#f6f7f9"));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("teamConvert", 2, "tencentdoc log:show failed view finish time [" + System.currentTimeMillis() / 1000L + "] error code = " + paramInt + " errorStr = " + paramString);
      return;
      if (paramInt != -116) {
        break label146;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718627));
      break label146;
      label281:
      str = paramString;
      break label167;
      if (paramInt == 106)
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718628);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
      else
      {
        if ((Math.abs(paramInt) >= 100) && (Math.abs(paramInt) < 116))
        {
          if (TextUtils.isEmpty(paramString)) {}
          for (str = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718607);; str = paramString)
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
            break;
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131718607));
      }
    }
  }
  
  public void a(Intent paramIntent, Context paramContext)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      paramIntent.getExtras().setClassLoader(TeamWorkFileImportInfo.class.getClassLoader());
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = ((TeamWorkFileImportInfo)paramIntent.getParcelableExtra("key_team_work_file_import_info"));
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d()) {
          break label213;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718616));
        this.d.setText(paramContext.getString(2131718619));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("teamwork/tim_data_loading.json");
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.loop(true);
      if (!bhnv.d(BaseApplicationImpl.getContext())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkFileImportCover", 2, "tencentdoc log:---FileImport start, fileName： " + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b + " ---");
      }
      bedq.a("cover_loading_time");
      bedq.a("get_url_time");
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d == 9)) {
        bedq.a(null, "0X800A4B4");
      }
      return;
      label213:
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g == 6)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718615));
        this.d.setText(paramContext.getString(2131718618));
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d == 12)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718653));
        this.d.setText(paramContext.getString(2131718619));
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d == 13)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718639));
        this.d.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetAutoVerticalScrollTextView.setVisibility(8);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718653));
        this.d.setText(paramContext.getString(2131718619));
      }
      else
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramContext.getString(2131718614));
        this.d.setText(paramContext.getString(2131718617));
      }
    }
    QQToast.a(paramContext, 2131693965, 0).b(a());
    a(-1, null);
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376731).setBackgroundColor(Color.parseColor("#f6f7f9"));
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("teamConvert", 2, "hide loading view finish time [" + System.currentTimeMillis() / 1000L + "]");
    }
    long l = bedq.a("cover_loading_time");
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {}
    for (String str = "";; str = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k)
    {
      bedq.a(null, str, "0X8009E9C", String.valueOf(l), "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo == null) {
        break;
      }
      bedq.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k);
      return;
    }
    bedq.a("TeamWorkFileImportCover", "cover_loading_time", String.valueOf(l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beas
 * JD-Core Version:    0.7.0.1
 */