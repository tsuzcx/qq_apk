import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class asvf
  extends asuu
  implements assy, assz
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Asst.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new asvh(this);
  protected aswr a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new asvi(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new asvj(this);
  private List<assv> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Asst.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Asst.c();
  private boolean d;
  
  public asvf(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
    this.jdField_a_of_type_Aswr = new aswr(paramActivity);
    a(this.jdField_a_of_type_Aswr);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    assv localassv = (assv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Asst.c());
    if (localassv == null) {
      return null;
    }
    String str = localassv.a();
    if (TextUtils.isEmpty(str)) {
      return localassv.b();
    }
    return str;
  }
  
  private void b()
  {
    Object localObject = b();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("PictureFilePresenter<QFile>", 1, "startEditPicture. but file path is null.");
      return;
    }
    localObject = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, true, true, true, true, true, 2, 130, 7);
    ((Intent)localObject).putExtra("open_chatfragment", true);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    ((Intent)localObject).putExtra("key_enable_edit_title_bar", true);
    ((Intent)localObject).putExtra("key_help_forward_pic", true);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    int i;
    switch (this.jdField_a_of_type_Asst.l())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      bcef.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772039, 2130772041);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Asst.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Asst.e()))
    {
      this.jdField_a_of_type_Aswr.c(a(b()));
      aszk.b(BaseApplicationImpl.getContext().getString(2131692199));
    }
    this.jdField_a_of_type_Aswr.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Aswr.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_Aswr.a(new asvg(this));
    this.jdField_a_of_type_Aswr.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    this.jdField_a_of_type_Aswr.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Aswr.c(this.jdField_a_of_type_Asst.c());
    h();
    this.jdField_a_of_type_Asst.a(this);
    this.jdField_a_of_type_Asst.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Asst.c(paramInt);
    if ((this.jdField_a_of_type_Asst.i()) && (this.jdField_a_of_type_Asst.a() != null))
    {
      this.jdField_a_of_type_Aswr.b(true);
      this.jdField_a_of_type_Aswr.a(false);
      b(0.0F);
      this.jdField_a_of_type_Asst.a().a();
    }
    h();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
      }
    }
    assv localassv;
    do
    {
      return;
      localassv = (assv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Asst.c());
    } while (!localassv.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localassv.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localassv.a(paramString2);
    localassv.a(2);
    this.jdField_a_of_type_Aswr.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aswr.a(false);
    this.jdField_a_of_type_Aswr.b(true);
    b(this.jdField_a_of_type_Asst.a());
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
    ((assv)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Asst.c())).b(this.jdField_a_of_type_Asst.d());
    this.jdField_a_of_type_Aswr.c();
    this.jdField_a_of_type_Aswr.d();
    if (this.jdField_a_of_type_Asqp != null) {
      this.jdField_a_of_type_Asqp.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aswr.a(true);
    this.jdField_a_of_type_Aswr.b(false);
    h();
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_Asst.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Aswr.a(false);
      this.jdField_a_of_type_Aswr.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Aswr.a(true);
        this.jdField_a_of_type_Aswr.b(false);
      }
      super.h();
    } while (this.jdField_a_of_type_Asst.f() != 9501);
    this.jdField_a_of_type_Aswr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvf
 * JD-Core Version:    0.7.0.1
 */