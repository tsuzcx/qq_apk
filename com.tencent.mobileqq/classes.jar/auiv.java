import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class auiv
  extends auik
  implements augo, augp
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Augj.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new auix(this);
  protected aukh a;
  private bljm jdField_a_of_type_Bljm = new auiy(this);
  private bljo jdField_a_of_type_Bljo = new auiz(this);
  private List<augl> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Augj.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Augj.c();
  private boolean d;
  
  public auiv(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
    this.jdField_a_of_type_Aukh = new aukh(paramActivity);
    a(this.jdField_a_of_type_Aukh);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    augl localaugl = (augl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Augj.c());
    if (localaugl == null) {
      return null;
    }
    String str = localaugl.a();
    if (TextUtils.isEmpty(str)) {
      return localaugl.b();
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
    switch (this.jdField_a_of_type_Augj.l())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      bdll.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772037, 2130772039);
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
    return this.jdField_a_of_type_Augj.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Augj.e()))
    {
      this.jdField_a_of_type_Aukh.c(a(b()));
      auna.b(BaseApplicationImpl.getContext().getString(2131692151));
    }
    this.jdField_a_of_type_Aukh.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Aukh.a(this.jdField_a_of_type_Bljm);
    this.jdField_a_of_type_Aukh.a(new auiw(this));
    this.jdField_a_of_type_Aukh.a(this.jdField_a_of_type_Bljo);
    this.jdField_a_of_type_Aukh.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Aukh.c(this.jdField_a_of_type_Augj.c());
    h();
    this.jdField_a_of_type_Augj.a(this);
    this.jdField_a_of_type_Augj.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Augj.c(paramInt);
    if ((this.jdField_a_of_type_Augj.i()) && (this.jdField_a_of_type_Augj.a() != null))
    {
      this.jdField_a_of_type_Aukh.b(true);
      this.jdField_a_of_type_Aukh.a(false);
      b(0.0F);
      this.jdField_a_of_type_Augj.a().a();
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
    augl localaugl;
    do
    {
      return;
      localaugl = (augl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Augj.c());
    } while (!localaugl.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localaugl.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localaugl.a(paramString2);
    localaugl.a(2);
    this.jdField_a_of_type_Aukh.c();
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
    this.jdField_a_of_type_Aukh.a(false);
    this.jdField_a_of_type_Aukh.b(true);
    b(this.jdField_a_of_type_Augj.a());
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
    ((augl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Augj.c())).b(this.jdField_a_of_type_Augj.d());
    this.jdField_a_of_type_Aukh.c();
    this.jdField_a_of_type_Aukh.d();
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_Auef.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Aukh.a(true);
    this.jdField_a_of_type_Aukh.b(false);
    h();
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_Augj.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Aukh.a(false);
      this.jdField_a_of_type_Aukh.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Aukh.a(true);
        this.jdField_a_of_type_Aukh.b(false);
      }
      super.h();
    } while (this.jdField_a_of_type_Augj.f() != 9501);
    this.jdField_a_of_type_Aukh.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiv
 * JD-Core Version:    0.7.0.1
 */