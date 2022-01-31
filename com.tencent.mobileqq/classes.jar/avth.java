import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;

public class avth
  implements DialogInterface.OnDismissListener, avvt
{
  public static final int[] a;
  ahwl a;
  public View a;
  public AppInterface a;
  public CaptureVideoFilterViewPager a;
  public EffectsCameraCaptureView a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, 25, 43, 60, 78, 95 };
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (paramInt >= 0) && (paramInt <= 5))
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putInt("sv_beauty_level", paramInt).commit();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(jdField_a_of_type_ArrayOfInt[paramInt]);
      if (QLog.isColorLevel()) {
        QLog.d("sv_beauty_level", 2, "beauty level : " + jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      avtb.b(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    SubtitleLayout localSubtitleLayout = (SubtitleLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376705);
    if (localSubtitleLayout != null)
    {
      ahzh.a().c = ahyc.a(paramInt);
      if (paramInt == 0)
      {
        localSubtitleLayout.setAnimType(0, null, null, 0, 0);
        localSubtitleLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localSubtitleLayout.setVisibility(0);
    localSubtitleLayout.setAnimType(paramInt, paramString, null, 0, 0);
  }
  
  public void a(FilterCategoryItem paramFilterCategoryItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.setCurrentItem(paramFilterCategoryItem);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFilter(paramFilterCategoryItem);
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    axqw.b(null, "dc00898", "", "", "0X800859F", "0X800859F", 1, 0, "", "", paramPtvTemplateInfo.id, "");
    if (paramPtvTemplateInfo.popup)
    {
      boolean bool = a(paramPtvTemplateInfo.androidopenurlheader);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        axqw.b(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 1, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent, paramPtvTemplateInfo.popupbtn, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
        return;
      }
      a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent2, paramPtvTemplateInfo.popupbtn2, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
      return;
    }
    a(paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl);
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null)
    {
      avrt.a();
      if (axjq.a(avrt.a))
      {
        localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
        if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
          break label53;
        }
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      localEffectsCameraCaptureView.g(bool);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
    }
  }
  
  void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_AndroidViewView.getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.jdField_a_of_type_AndroidViewView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("EffectsListenerController", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    try
    {
      if (!bbjw.a(paramString2)) {}
      for (paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2)); paramString1 != null; paramString1 = this.jdField_a_of_type_AndroidViewView.getContext().getPackageManager().getLaunchIntentForPackage(paramString1))
      {
        paramString1.addCategory("android.intent.category.DEFAULT");
        this.jdField_a_of_type_AndroidViewView.getContext().startActivity(paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EffectsListenerController", 1, "TryJumpToQIM catch an Exception.", paramString1);
      new bcqc(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp()).a(ajyc.a(2131703987), 100, 0, 1);
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    if (a(paramString1))
    {
      a(paramString1, paramString2);
      return;
    }
    a(paramString3);
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Ahwl == null))
    {
      ahwl localahwl = new ahwl(this.jdField_a_of_type_AndroidViewView.getContext());
      this.jdField_a_of_type_Ahwl = localahwl;
      localahwl.a(paramString1, paramString2, paramString3, paramString7);
      localahwl.a(new avti(this, paramInt, paramBoolean, paramString4, paramString5, paramString6));
      localahwl.a();
      this.jdField_a_of_type_Ahwl.setOnDismissListener(this);
      this.jdField_a_of_type_Ahwl.show();
      paramString1 = this.jdField_a_of_type_Ahwl.getWindow().getAttributes();
      paramString1.width = -1;
      paramString1.height = -1;
      this.jdField_a_of_type_Ahwl.getWindow().setAttributes(paramString1);
    }
  }
  
  public boolean a(String paramString)
  {
    QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall appPackageName is " + paramString);
    if (bbjw.a(paramString)) {}
    do
    {
      return false;
      try
      {
        paramString = this.jdField_a_of_type_AndroidViewView.getContext().getPackageManager().getPackageInfo(paramString, 1);
        if (paramString == null)
        {
          QLog.d("EffectsListenerController", 1, "CheckJumpAPPisInstall PackageInfo is null");
          return false;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("EffectsListenerController", 1, "CheckJumpAPPisInstall catch an Exception.", paramString);
        return false;
      }
      paramString = paramString.activities[0].name;
      QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall qqAppActivity is " + paramString);
    } while (paramString == null);
    return true;
  }
  
  public void b(FilterCategoryItem paramFilterCategoryItem)
  {
    if (paramFilterCategoryItem == null) {
      return;
    }
    axqw.b(null, "dc00898", "", "", "0X800859F", "0X800859F", 2, 0, "", "", paramFilterCategoryItem.a, "");
    if (paramFilterCategoryItem.b)
    {
      boolean bool = a(paramFilterCategoryItem.g);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        axqw.b(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 2, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramFilterCategoryItem.k, paramFilterCategoryItem.l, paramFilterCategoryItem.m, paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i, paramFilterCategoryItem.p, 2, bool);
        return;
      }
      a(paramFilterCategoryItem.k, paramFilterCategoryItem.n, paramFilterCategoryItem.o, paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i, paramFilterCategoryItem.p, 2, bool);
      return;
    }
    a(paramFilterCategoryItem.g, paramFilterCategoryItem.h, paramFilterCategoryItem.i);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Ahwl = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avth
 * JD-Core Version:    0.7.0.1
 */