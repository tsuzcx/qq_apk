import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.util.QZoneExceptionReport;

class amsy
  implements Runnable
{
  amsy(amsx paramamsx, String paramString, boolean paramBoolean1, boolean paramBoolean2, IPluginManager.PluginParams paramPluginParams) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidAppActivity;
    Object localObject2;
    if ((this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
    {
      localObject2 = ((BasePluginActivity)this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, "参数错误，尝试进行兼容" + this.jdField_a_of_type_JavaLangString + ",context:" + this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidAppActivity);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof PluginTab)) {
          localObject1 = ((PluginTab)localObject2).getOutActivity();
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        QZoneExceptionReport.a(new IllegalArgumentException("跳转参数传递错误 activityName：" + this.jdField_a_of_type_JavaLangString + ",context:" + this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidAppActivity), "跳转错误");
        return;
      }
      Intent localIntent = null;
      localObject2 = localIntent;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = localIntent;
        if (!this.b)
        {
          localObject2 = new QzoneProgressDialog((Context)localObject1, this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidContentIntent);
          ((QzoneProgressDialog)localObject2).a("  正在加载...");
          ((QzoneProgressDialog)localObject2).setOnDismissListener(new amsz(this));
        }
      }
      localIntent = this.jdField_a_of_type_Amsx.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams.a = ((Dialog)localObject2);
        IPluginManager.a((Activity)localObject1, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsy
 * JD-Core Version:    0.7.0.1
 */