import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "Lmqq/manager/Manager;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "bPref", "", "getBPref", "()I", "setBPref", "(I)V", "isSwitching", "", "()Z", "setSwitching", "(Z)V", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "needCheckShowModeSwitchDialog", "oldType", "getOldType", "setOldType", "onModeChangeResultCallbacks", "", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$OnModeChangeResultCallback;", "simpleUIObserver", "Lcom/tencent/mobileqq/simpleui/SimpleUIObserver;", "studentFlagPullStatus", "studyModePullStatus", "tag", "", "targetType", "getTargetType", "setTargetType", "addCallback", "", "onModeChangeResultCallback", "changeMode", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager$SwitchingStatus;", "activity", "Landroid/app/Activity;", "bSwitchElsePref", "checkAndReportStockStudyMode", "doChangeMode", "isSameDayWithLastReport", "onChangeStudyModeComplete", "isSuc", "message", "onColorfulChangeResult", "onDestroy", "onModeChangeResult", "onStudentFlagPullComplete", "isStudent", "onStudyModePullComplete", "isStudy", "onSwitchUICallBackInManager", "bChangeTheme", "statusCode", "releaseDialog", "removeCallback", "showModeSwitchDialog", "Lcom/tencent/mobileqq/app/BaseActivity;", "OnModeChangeResultCallback", "SwitchingStatus", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class baau
  implements Manager
{
  private int jdField_a_of_type_Int;
  private final azmj jdField_a_of_type_Azmj;
  private bdjz jdField_a_of_type_Bdjz;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private final List<baav> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  
  public baau(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = "GeneralModeSwitcherManager";
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.c = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Azmj = ((azmj)new baba(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((alpg)this.jdField_a_of_type_Azmj);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(154);
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
    }
    localObject = (azmg)localObject;
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
      if (((azmg)localObject).a(bool1, paramInt1, paramBoolean, bool2)) {
        break label165;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doChangeMode switching");
      }
      QQToast.a((Context)BaseApplication.getContext(), 0, 2131719908, 0).a();
      localObject = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((baav)((Iterator)localObject).next()).d(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
      ((baav)((Iterator)localObject).next()).b(paramInt2, paramInt3);
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    while (localIterator.hasNext()) {
      ((baav)localIterator.next()).a(paramBoolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramString);
    }
    if ((paramBoolean) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_b_of_type_Int == 2))) {
      bdne.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_has_change", Boolean.valueOf(true));
    }
  }
  
  private final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "checkAndReportStockStudyMode -> studyModePullStatus : " + this.d + ", studentFlagPullStatus : " + this.e);
    }
    if ((this.d == 1) && (this.e != 0))
    {
      boolean bool1 = babd.b();
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
      bdne.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_last_report_time", localSimpleDateFormat.format(new Date()));
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD6C", "0X800AD6C", 0, i, "", "", "", "");
      return;
    }
  }
  
  private final boolean b()
  {
    Object localObject1 = (String)bdne.b((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_last_report_time", "");
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
      i = 2131693079;
      str = alud.a(i);
      if (!paramBoolean) {
        break;
      }
    }
    for (String str = BaseApplicationImpl.getContext().getString(2131694448, new Object[] { str });; str = BaseApplicationImpl.getContext().getString(2131694450, new Object[] { str }))
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "message");
      a(paramBoolean, str);
      return;
      i = 2131693082;
      break;
      i = 2131693084;
      break;
    }
  }
  
  private final void e(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      String str = BaseApplicationImpl.getContext().getString(2131694449);
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
  public final baax a(@NotNull Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "changeMode targetType: " + paramInt1 + ", bPref : " + paramInt2);
    }
    int i = baar.a();
    if ((!this.jdField_a_of_type_Boolean) && ((i != paramInt1) || (paramInt2 != this.c)))
    {
      if (!AppNetConnInfo.isNetSupport())
      {
        QQToast.a((Context)BaseApplication.getContext(), 1, 2131694831, 0).a();
        paramActivity = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
        while (paramActivity.hasNext()) {
          ((baav)paramActivity.next()).c(paramInt1, i);
        }
        return new baax(false, paramInt1, i);
      }
      if (paramInt1 == 1)
      {
        Object localObject = ThemeUtil.getUinThemePreferences((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (((SharedPreferences)localObject).getBoolean("key_simple_should_show_switch_dialog", true))
        {
          ((SharedPreferences)localObject).edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject = (DialogInterface.OnClickListener)new baaz(this, paramInt2, paramInt1, i, paramBoolean);
          bdjz localbdjz = this.jdField_a_of_type_Bdjz;
          if (localbdjz != null) {
            localbdjz.dismiss();
          }
          this.jdField_a_of_type_Bdjz = bdgm.a(paramActivity, BaseApplicationImpl.getContext().getString(2131719903), 0, 2131719901, (DialogInterface.OnClickListener)localObject, null);
          paramActivity = this.jdField_a_of_type_Bdjz;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.setOnDismissListener((DialogInterface.OnDismissListener)new baay(this, paramInt1, i));
          paramActivity = this.jdField_a_of_type_Bdjz;
          if (paramActivity == null) {
            Intrinsics.throwNpe();
          }
          paramActivity.show();
        }
      }
      for (;;)
      {
        return new baax(true, paramInt1, i);
        a(paramInt2, paramInt1, i, paramBoolean);
        continue;
        a(paramInt2, paramInt1, i, paramBoolean);
      }
    }
    return new baax(this.jdField_a_of_type_Boolean, paramInt1, i);
  }
  
  public final void a()
  {
    bdjz localbdjz = this.jdField_a_of_type_Bdjz;
    if (localbdjz != null) {
      localbdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = ((bdjz)null);
  }
  
  public final void a(@Nullable baav parambaav)
  {
    if (parambaav != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambaav);
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
      if ((this.d == 2) && (this.e == 1) && (babd.c()) && (!((Boolean)bdne.b((Context)paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_has_change", Boolean.valueOf(false))).booleanValue()) && (!((Boolean)bdne.b((Context)paramBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "study_mode_change_dialog_has_show", Boolean.valueOf(false))).booleanValue()))
      {
        new babh(paramBaseActivity).show();
        bdne.a((Context)BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true, "study_mode_change_dialog_has_show", Boolean.valueOf(true));
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
  
  public final void b(@Nullable baav parambaav)
  {
    if ((parambaav != null) && (this.jdField_a_of_type_JavaUtilList.contains(parambaav))) {
      this.jdField_a_of_type_JavaUtilList.remove(parambaav);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onStudyModePullComplete isStudy : " + paramBoolean);
    }
    if (paramBoolean) {
      i = 1;
    }
    this.d = i;
    b();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((alpg)this.jdField_a_of_type_Azmj);
    bdjz localbdjz = this.jdField_a_of_type_Bdjz;
    if (localbdjz != null) {
      localbdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = ((bdjz)null);
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
 * Qualified Name:     baau
 * JD-Core Version:    0.7.0.1
 */