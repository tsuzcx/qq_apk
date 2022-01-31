import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDTextFace.2;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.os.MqqHandler;

public class bmha
  extends bmiv
  implements bmhc
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  public String a;
  private List<String> jdField_a_of_type_JavaUtilList;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "default", "local_slides", "local_singlePhoto", "local_singleVideo", "bigVshare" };
  private String b;
  
  public bmha(@NonNull bmix parambmix, int paramInt)
  {
    super(parambmix);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ArrayOfJavaLangString.length) {}
    for (this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int];; this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString[0])
    {
      upm.a().a("EditVideoDTextFace.mSrcFrom", this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  private void a(int paramInt)
  {
    if ((paramInt != 44) && (paramInt != 41) && (paramInt != 9) && (paramInt != 42) && (paramInt != 34) && (paramInt != 22)) {
      d();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 5) && (paramInt != 9) && (paramInt != 34) && (paramInt != 42) && (paramInt != 22) && (paramInt != 41);
  }
  
  private void b(DoodleLayout paramDoodleLayout)
  {
    int j = 100;
    int i = j;
    if (paramDoodleLayout != null)
    {
      i = j;
      if (paramDoodleLayout.a() != null)
      {
        i = j;
        if (paramDoodleLayout.a().a != null) {
          i = Math.min(paramDoodleLayout.a().b(), paramDoodleLayout.a().a.size());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoDTextFace", 2, " check Last text layer count is " + i);
    }
    if (i <= 0) {
      i();
    }
  }
  
  private void j()
  {
    Object localObject = (bmee)a(bmee.class);
    if (localObject == null) {
      throw new IllegalStateException("not support doodle.");
    }
    localObject = ((bmee)localObject).a();
    DynamicTextItem localDynamicTextItem = ((DoodleLayout)localObject).a().a(((DoodleLayout)localObject).d());
    ((DoodleLayout)localObject).a(((DoodleLayout)localObject).a().a(), false);
    if (localDynamicTextItem != null)
    {
      ((DoodleLayout)localObject).a(localDynamicTextItem, 0, 0, true);
      return;
    }
    QQToast.a(a(), a().getString(2131698616), 0).a();
    ThreadManager.getUIHandler().post(new EditVideoDTextFace.2(this, (DoodleLayout)localObject));
  }
  
  public void a()
  {
    super.a();
    a(bmhc.class, this);
    DynamicTextConfigManager localDynamicTextConfigManager = (DynamicTextConfigManager)blmf.a(7);
    this.b = localDynamicTextConfigManager.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilList = blst.a(0);
    if (TextUtils.isEmpty(this.b)) {
      this.b = alpo.a(2131704205);
    }
    blst.a(0, Collections.singletonList(this.b));
    this.jdField_a_of_type_Bmix.a().a().postDelayed(new EditVideoDTextFace.1(this, localDynamicTextConfigManager), 1000L);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    super.a(paramInt1, paramInt2, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("EditVideoDTextFace", 2, "editVideoStateChanged" + paramInt1 + "->" + paramInt2);
    }
    if ((paramInt1 == 0) || ((paramInt2 != 0) && (paramInt1 == 44)) || ((paramInt2 == 40) && (paramInt1 == 41))) {
      a(paramInt2);
    }
    label80:
    do
    {
      bmmk localbmmk;
      do
      {
        do
        {
          do
          {
            break label80;
            break label80;
            do
            {
              return;
            } while ((paramInt2 != 0) || (!a(paramInt1)));
            paramObject = (bmee)a(bmee.class);
          } while (paramObject == null);
          paramObject = paramObject.a();
        } while (paramObject == null);
        localbmmk = paramObject.a();
      } while (localbmmk == null);
      paramInt1 = 0;
      if (localbmmk.a != null) {
        paramInt1 = paramObject.a().a.size();
      }
    } while (paramInt1 != 0);
    i();
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    parambmwn = ((bmee)a(bmee.class)).a().a();
    int i = parambmwn.a.size();
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < i)
    {
      localStringBuilder.append(((bmmn)parambmwn.a.get(paramInt)).a.c() + 1);
      if (paramInt < i - 1) {
        localStringBuilder.append(",");
      }
      paramInt += 1;
    }
    wta.a("video_edit_text", "pub_withText", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, localStringBuilder.toString(), String.valueOf(i), "" });
  }
  
  public void a(DoodleLayout paramDoodleLayout)
  {
    b(paramDoodleLayout);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Bmkf != null)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_Bmkf.getActivity().getSystemService("input_method");
      if ((localInputMethodManager != null) && (localInputMethodManager.isActive())) {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_Bmkf.a().getWindowToken(), 0);
      }
    }
    super.g();
    blst.a(0, this.jdField_a_of_type_JavaUtilList);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      wta.a("video_edit_text", "exp_textWording", 0, 0, new String[] { this.jdField_a_of_type_JavaLangString, "", "", "" });
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmha
 * JD-Core Version:    0.7.0.1
 */