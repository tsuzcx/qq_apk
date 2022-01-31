import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.CaptureComboText.1;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;

public class bhlw
  extends bhgn
{
  private float jdField_a_of_type_Float;
  private bhmd jdField_a_of_type_Bhmd = new bhlx(this);
  private DynamicTextConfigManager.DynamicTextConfigBean jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
  private DynamicTextConfigManager jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager;
  private String jdField_a_of_type_JavaLangString;
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private float b;
  private float c;
  private volatile float jdField_d_of_type_Float;
  private volatile int jdField_d_of_type_Int = 2;
  
  public bhlw(@NonNull String paramString, @NonNull List<String> paramList, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager = ((DynamicTextConfigManager)bhfm.a(7));
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText id is: " + paramString);
    }
  }
  
  public float a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText getProgress, progress is: " + this.jdField_d_of_type_Float);
    }
    return this.jdField_d_of_type_Float * 0.01F;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.c();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
    }
    int i;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) {
      i = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "CaptureComboText getState, state is: " + i + " id is: " + this.jdField_a_of_type_JavaLangString);
      }
      return i;
      if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean)) && (this.jdField_d_of_type_Int == 2)) {
        i = 3;
      } else {
        i = this.jdField_d_of_type_Int;
      }
    }
  }
  
  public int a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboDText", 2, "apply ComboText");
    }
    if ((this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) || (!this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean))) {}
    DoodleLayout localDoodleLayout;
    DynamicTextItem localDynamicTextItem;
    do
    {
      do
      {
        do
        {
          return 0;
        } while (paramActivity == null);
        localDoodleLayout = bhnz.a().a(paramInt);
      } while ((localDoodleLayout == null) || (localDoodleLayout.a() == null));
      localDoodleLayout.a().b(4);
      localDynamicTextItem = new bhlz().a(Integer.valueOf(this.jdField_a_of_type_JavaLangString).intValue(), this.jdField_a_of_type_JavaUtilList);
    } while (localDynamicTextItem == null);
    float f = bjlo.a * this.c / localDynamicTextItem.a();
    bijq localbijq = new bijq(this.jdField_a_of_type_Float * bjlo.a, this.b * bjlo.a, f, 0.0F, 0.0F, 0.0F, localDynamicTextItem.a(), localDynamicTextItem.b());
    if (localDoodleLayout.a().a(localbijq, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, localDoodleLayout.d()) != null)
    {
      localDynamicTextItem.a(true);
      localDoodleLayout.a().b(localDynamicTextItem);
      localDoodleLayout.a().k();
      return 0;
    }
    bbmy.a(paramActivity, paramActivity.getString(2131632580), 0).a();
    ThreadManager.getUIHandler().post(new CaptureComboText.1(this, localDoodleLayout));
    return 0;
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity != null)
    {
      paramActivity = bhnz.a().a(paramInt);
      if ((paramActivity != null) && (paramActivity.a() != null))
      {
        paramActivity.a().b(4);
        paramActivity.a().f();
        paramActivity.a().k();
      }
    }
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText download, state is: " + this.jdField_d_of_type_Int);
    }
    if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 3)) {
      return this.jdField_d_of_type_Int;
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null) {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.c();
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "CaptureComboText download, bean is null.");
      }
      this.jdField_d_of_type_Int = 2;
      return 2;
    }
    a();
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QComboDText", 2, "startDownload dynamicText is usable.");
      }
      b();
      this.jdField_d_of_type_Int = 3;
      return 2;
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager.a(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean, this.jdField_a_of_type_Bhmd);
    this.jdField_d_of_type_Int = 1;
    return 1;
  }
  
  public String toString()
  {
    return "Text@" + Arrays.toString(this.jdField_a_of_type_JavaUtilList.toArray()) + "@" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlw
 * JD-Core Version:    0.7.0.1
 */