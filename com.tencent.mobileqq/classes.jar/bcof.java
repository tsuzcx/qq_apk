import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "Lmqq/manager/Manager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "bPref", "", "getBPref", "()I", "setBPref", "(I)V", "isSwitching", "", "()Z", "setSwitching", "(Z)V", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "needCheckShowModeSwitchDialog", "oldType", "getOldType", "setOldType", "onModeChangeResultCallbacks", "", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "simpleUIObserver", "Lcom/tencent/mobileqq/simpleui/SimpleUIObserver;", "studentFlagPullStatus", "studyModePullStatus", "tag", "", "targetType", "getTargetType", "setTargetType", "addCallback", "", "onModeChangeResultCallback", "changeMode", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$SwitchingStatus;", "activity", "Landroid/app/Activity;", "bSwitchElsePref", "checkAndReportStockStudyMode", "doChangeMode", "endChangebPref", "isSameDayWithLastReport", "onChangeStudyModeComplete", "isSuc", "message", "onColorfulChangeResult", "onDestroy", "onModeChangeResult", "onStudentFlagPullComplete", "isStudent", "onStudyModePullComplete", "isStudy", "onSwitchUICallBackInManager", "bChangeTheme", "statusCode", "releaseDialog", "removeCallback", "showModeSwitchDialog", "Lcom/tencent/mobileqq/app/BaseActivity;", "OnModeChangeResultCallback", "SwitchingStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bcof
  implements Manager
{
  private int jdField_a_of_type_Int;
  private final bbyo jdField_a_of_type_Bbyo;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final String jdField_a_of_type_JavaLangString;
  private final List<bcog> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public bcof(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = "GeneralModeSwitcherManager";
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bbyo = ((bbyo)new bcol(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_Bbyo);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(154);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    localObject = (bbyj)localObject;
    boolean bool1;
    if (paramInt2 == 1)
    {
      bool1 = true;
      if (paramInt2 != 2) {
        break label159;
      }
    }
    for (;;)
    {
      if (((bbyj)localObject).a(bool1, paramInt1, paramBoolean, bool2)) {
        break label165;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doChangeMode switching");
      }
      QQToast.a((Context)BaseApplication.getContext(), 0, 2131718228, 0).a();
      localObject = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bcog)((Iterator)localObject).next()).d(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      bool1 = false;
      break;
      label159:
      bool2 = false;
    }
    label165:
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doChangeMode switch start");
    }
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.c = paramInt1;
    localObject = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((bcog)((Iterator)localObject).next()).b(paramInt2, paramInt3);
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((bcog)localIterator.next()).a(paramBoolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramString);
    }
    if ((paramBoolean) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_b_of_type_Int == 2))) {
      bfyz.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_has_change", Boolean.valueOf(true));
    }
  }
  
  private final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkAndReportStockStudyMode -> studyModePullStatus : " + this.d + ", studentFlagPullStatus : " + this.e);
    }
    if ((this.d == 1) && (this.e != 0))
    {
      boolean bool1 = bcoo.b();
      boolean bool2 = b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkAndReportStockStudyMode -> configSwitch : " + bool1 + ", isSameDay ： " + bool2);
      }
      if ((bool1) && (!bool2)) {
        if (this.e != 1) {
          break label253;
        }
      }
    }
    label253:
    for (int i = 1;; i = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkAndReportStockStudyMode ReportController 0X800AD6C ， identity ： " + i);
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
      bfyz.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_last_report_time", localSimpleDateFormat.format(new Date()));
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, i, "", "", "", "");
      return;
    }
  }
  
  private final boolean b()
  {
    Object localObject1 = (String)bfyz.b((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_last_report_time", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject1);
      localObject1 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "calendarLast");
      ((Calendar)localObject1).setTime((Date)localObject2);
      localObject2 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "calendarNow");
      ((Calendar)localObject2).setTime(new Date());
      if ((((Calendar)localObject1).get(0) == ((Calendar)localObject2).get(0)) && (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1)) && (((Calendar)localObject1).get(6) == ((Calendar)localObject2).get(6))) {
        return true;
      }
    }
    return false;
  }
  
  private final void d(boolean paramBoolean)
  {
    int i;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      i = 2131692667;
      str = amtj.a(i);
      if (!paramBoolean) {
        break;
      }
    }
    for (String str = BaseApplicationImpl.getContext().getString(2131693834, new Object[] { str });; str = BaseApplicationImpl.getContext().getString(2131693836, new Object[] { str }))
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "message");
      a(paramBoolean, str);
      return;
      i = 2131692671;
      break;
      i = 2131692674;
      break;
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = BaseApplicationImpl.getContext().getString(2131693835);
      Intrinsics.checkExpressionValueIsNotNull(str, "BaseApplicationImpl.getC…mode_operation_open_fail)");
      a(false, str);
      return;
    }
    a(true, "");
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final bcoi a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "changeMode targetType: " + paramInt1 + ", bPref : " + paramInt2);
    }
    int i = bcoa.a();
    if ((!this.jdField_a_of_type_Boolean) && ((i != paramInt1) || (paramInt2 != this.c)))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.a((Context)BaseApplication.getContext(), 1, 2131694108, 0).a();
        paramActivity = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
        while (paramActivity.hasNext()) {
          ((bcog)paramActivity.next()).c(paramInt1, i);
        }
        return new bcoi(false, paramInt1, i);
      }
      if (paramInt1 == 1)
      {
        Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((SharedPreferences)localObject).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject = (DialogInterface.OnClickListener)new bcok(this, paramInt2, paramInt1, i, paramBoolean);
          QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (localQQCustomDialog != null) {
            localQQCustomDialog.dismiss();
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(paramActivity, BaseApplicationImpl.getContext().getString(2131718223), 0, 2131718221, (DialogInterface.OnClickListener)localObject, null);
          paramActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.setOnDismissListener((DialogInterface.OnDismissListener)new bcoj(this, paramInt1, i));
          paramActivity = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.show();
        }
      }
      for (;;)
      {
        return new bcoi(true, paramInt1, i);
        a(paramInt2, paramInt1, i, paramBoolean);
        continue;
        a(paramInt2, paramInt1, i, paramBoolean);
      }
    }
    return new bcoi(this.jdField_a_of_type_Boolean, paramInt1, i);
  }
  
  public final void a()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.setOnDismissListener(null);
    }
    localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)null);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.c = paramInt1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public final void a(@Nullable bcog parambcog)
  {
    if (parambcog != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambcog);
    }
  }
  
  public final void a(@NotNull BaseActivity paramBaseActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "showModeSwitchDialog studyModePullStatus : " + this.d + " , studentFlagPullStatus : " + this.e);
    }
    if (this.jdField_b_of_type_Boolean) {
      if ((this.d != 0) && (this.e != 0)) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      if ((this.d == 2) && (this.e == 1) && (bcoo.c()) && (!((Boolean)bfyz.b((Context)paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_has_change", Boolean.valueOf(false))).booleanValue()) && (!((Boolean)bfyz.b((Context)paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_change_dialog_has_show", Boolean.valueOf(false))).booleanValue()))
      {
        new bcot(paramBaseActivity).show();
        bfyz.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_change_dialog_has_show", Boolean.valueOf(true));
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onSwitchUICallBack targetType : " + this.jdField_a_of_type_Int + ", isSuc : " + paramBoolean1 + " , bChangeTheme : " + paramBoolean2 + ", bSwitchElsePref : " + paramBoolean3 + " , statusCode : " + paramInt);
    }
    if (paramBoolean3)
    {
      d(paramBoolean1);
      return;
    }
    e(paramBoolean1);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(@Nullable bcog parambcog)
  {
    if ((parambcog != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambcog))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambcog);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onStudyModePullComplete isStudy : " + paramBoolean);
    }
    bcnw.a("INIT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean) {
      i = 1;
    }
    this.d = i;
    b();
    bcoo.b();
  }
  
  public final void c(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onStudentFlagPullComplete isStudent : " + paramBoolean);
    }
    if (paramBoolean) {
      i = 1;
    }
    this.e = i;
    b();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_Bbyo);
    a();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.d = 0;
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcof
 * JD-Core Version:    0.7.0.1
 */