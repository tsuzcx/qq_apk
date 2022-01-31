import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.Dex2Oat;
import cooperation.plugin.IPluginManager.OnPluginReadyListener;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.plugin.PluginManagerV2;

public class amty
  implements DialogInterface.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  IPluginManager.OnPluginReadyListener jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener;
  IPluginManager.PluginParams jdField_a_of_type_CooperationPluginIPluginManager$PluginParams;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  boolean b;
  
  private amty(PluginManagerV2 paramPluginManagerV2, IPluginManager.OnPluginReadyListener paramOnPluginReadyListener, boolean paramBoolean1, Context paramContext, IPluginManager.PluginParams paramPluginParams, boolean paramBoolean2, String paramString)
  {
    this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener = paramOnPluginReadyListener;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams = paramPluginParams;
    this.b = paramBoolean2;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, 1, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      return;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramInt = i;
    }
    for (;;)
    {
      PluginManagerV2.a(this.jdField_a_of_type_CooperationPluginPluginManagerV2, paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_CooperationPluginIPluginManager$PluginParams, this.jdField_a_of_type_CooperationPluginIPluginManager$OnPluginReadyListener);
      return;
      paramInt = i;
      if (this.b)
      {
        if (PluginManagerV2.a())
        {
          boolean bool = Dex2Oat.a(this.jdField_a_of_type_JavaLangString);
          if (bool) {}
          for (i = 4;; i = 2)
          {
            paramInt = i;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("plugin_tag", 2, "dialog needOTA :" + bool);
            paramInt = i;
            break;
          }
        }
        paramInt = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amty
 * JD-Core Version:    0.7.0.1
 */