import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.widget.DocCooperationBanner.2;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class arun
  implements View.OnClickListener
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public View a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  aoxx jdField_a_of_type_Aoxx;
  aoya jdField_a_of_type_Aoya;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  final String jdField_a_of_type_JavaLangString = "DocCooperationBanner";
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  
  public arun(Activity paramActivity, ViewGroup paramViewGroup, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, aoxx paramaoxx)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131560686, paramViewGroup, true);
    this.jdField_a_of_type_Aoxx = paramaoxx;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131364850);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    b();
  }
  
  private Drawable a(int paramInt, String paramString)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramInt == 0) {
        return bdbk.a((AppInterface)localObject, 1, paramString);
      }
      if (paramInt == 1) {
        return bdbk.a((AppInterface)localObject, 4, paramString);
      }
      if (paramInt == 3000) {
        return bdbk.a((AppInterface)localObject, 101, paramString);
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = aoyb.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((aoxx)localObject).jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((aoxx)localObject).d;
      break;
      label80:
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 3;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368427));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364854));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364853));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364846));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364847));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364848));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364852));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364855));
    String str;
    if ((this.jdField_a_of_type_Aoxx != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
    {
      localObject = this.jdField_a_of_type_Aoxx.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Aoya = ((aoya)localObject);
      if ((localObject != null) && (!TextUtils.isEmpty(((aoya)localObject).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        str = ((aoya)localObject).jdField_a_of_type_JavaLangString;
        if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000)) {
          break label245;
        }
      }
    }
    label245:
    for (Object localObject = alud.a(2131703782);; localObject = alud.a(2131703767))
    {
      localObject = str.replace("$name", (CharSequence)localObject);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramString != null) {
      this.jdField_b_of_type_JavaLangString = paramString;
    }
    boolean bool;
    if (this.jdField_a_of_type_Aoya != null)
    {
      bool = this.jdField_a_of_type_Aoya.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
      if (paramInt <= 0) {
        break label171;
      }
      localObject = new StringBuilder().append(paramInt).append(alud.a(2131703771));
      if (!bool) {
        break label153;
      }
      paramString = alud.a(2131703779);
      label94:
      localObject = paramString;
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label162;
      }
    }
    label153:
    label162:
    for (paramString = alud.a(2131703763);; paramString = alud.a(2131703772))
    {
      localTextView.setText(paramString);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramString = (String)localObject;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      return;
      bool = false;
      break;
      paramString = alud.a(2131703773);
      break label94;
    }
    label171:
    Object localObject = alud.a(2131703769);
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder().append(alud.a(2131703768));
    if (bool) {}
    for (paramString = alud.a(2131703783);; paramString = alud.a(2131703766))
    {
      localTextView.setText(paramString + alud.a(2131703781));
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null)
      {
        paramString = a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        if (paramString != null) {
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString);
        }
      }
      paramString = (String)localObject;
      break;
    }
  }
  
  public void a(int paramInt, List<aoxy> paramList, String paramString)
  {
    int i = 0;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    boolean bool;
    Object localObject1;
    if (this.jdField_a_of_type_Aoya != null)
    {
      bool = this.jdField_a_of_type_Aoya.jdField_a_of_type_Boolean;
      if (paramInt != 1) {
        break label365;
      }
      this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
      localObject1 = new StringBuilder().append(alud.a(2131703765));
      if (!bool) {
        break label321;
      }
      paramString = alud.a(2131703777);
      label92:
      paramString = paramString;
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label331;
      }
      localObject1 = (aoxy)paramList.get(0);
      paramString = ((aoxy)localObject1).jdField_a_of_type_JavaLangString + paramString;
      label150:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label355;
      }
    }
    label321:
    label331:
    label355:
    for (paramString = alud.a(2131703780);; paramString = alud.a(2131703770))
    {
      ((TextView)localObject1).setText(paramString);
      if (paramList == null) {
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentImageURLImageView;
      localObject1 = this.jdField_b_of_type_ComTencentImageURLImageView;
      URLImageView localURLImageView = this.jdField_c_of_type_ComTencentImageURLImageView;
      paramInt = i;
      while (paramInt < paramList.size())
      {
        Object localObject2 = ((aoxy)paramList.get(paramInt)).jdField_b_of_type_JavaLangString;
        if (paramInt < 3)
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, URLDrawable.URLDrawableOptions.obtain());
          i = aepi.a(24.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          ((URLDrawable)localObject2).setTag(bcyz.b(i, i, i / 2));
          ((URLDrawable)localObject2).setDecodeHandler(bcyz.c);
          new URLImageView[] { paramString, localObject1, localURLImageView }[paramInt].setImageDrawable((Drawable)localObject2);
        }
        paramInt += 1;
      }
      bool = false;
      break;
      paramString = alud.a(2131703784);
      break label92;
      paramString = "1人" + paramString;
      break label150;
    }
    label365:
    this.jdField_b_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (paramInt == 2)
    {
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(8);
      label387:
      localObject1 = new StringBuilder().append(paramInt).append(alud.a(2131703778));
      if (!bool) {
        break label477;
      }
      paramString = alud.a(2131703775);
      label421:
      paramString = paramString;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      localObject1 = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label487;
      }
    }
    label477:
    label487:
    for (paramString = alud.a(2131703762);; paramString = alud.a(2131703761))
    {
      ((TextView)localObject1).setText(paramString);
      break;
      this.jdField_c_of_type_ComTencentImageURLImageView.setVisibility(0);
      break label387;
      paramString = alud.a(2131703764);
      break label421;
    }
  }
  
  public void a(String paramString1, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, boolean paramBoolean, String paramString2)
  {
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramString1)) && (paramTeamWorkFileImportInfo != null))
    {
      new StringBuilder(paramString1);
      if (paramString1.indexOf("?") <= 0) {
        break label213;
      }
      paramString1 = paramString1 + "&adtag=s_qq_file_inviteedit";
      if (paramBoolean)
      {
        paramBoolean = aoyb.a().a(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
        localStringBuilder = new StringBuilder(alud.a(2131703776));
        if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000)) {
          break label237;
        }
        localStringBuilder.append("群成员");
        label108:
        if (!paramBoolean) {
          break label256;
        }
        localStringBuilder.append("一起编辑");
      }
    }
    for (;;)
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, localStringBuilder.toString(), 1).a();
      ThreadManager.excute(new DocCooperationBanner.2(this, paramTeamWorkFileImportInfo, paramString1, paramBoolean, paramString2), 128, null, false);
      bajr.a(null, "0X800A637");
      paramString2 = new Bundle();
      paramString2.putString("url", paramString1);
      paramString2.putBoolean("temp_preview_from_qq", true);
      paramString2.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
      TeamWorkDocEditBrowserActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString2, false);
      return;
      label213:
      paramString1 = paramString1 + "?adtag=s_qq_file_inviteedit";
      break;
      label237:
      if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0) {
        break label108;
      }
      localStringBuilder.append("好友");
      break label108;
      label256:
      localStringBuilder.append("一起查看");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Aoxx != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null))
    {
      if (!paramBoolean) {
        break label106;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { 0.0F });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
    }
    return;
    label106:
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
          this.jdField_a_of_type_AndroidAnimationObjectAnimator.cancel();
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { this.jdField_a_of_type_AndroidViewView.getHeight() });
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new aruo(this));
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(180L);
        this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (!bdin.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131703774), 0).a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        paramView = BaseApplicationImpl.sApplication.getRuntime();
        if ((paramView instanceof QQAppInterface))
        {
          paramView = (bagw)((QQAppInterface)paramView).a(120);
          if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null) && (!paramView.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo)))
          {
            bajr.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
            this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.g = 0;
            paramView.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
          }
        }
      }
      for (boolean bool = true; this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo != null; bool = false)
      {
        a(bool, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int);
        return;
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
          a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, false, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arun
 * JD-Core Version:    0.7.0.1
 */