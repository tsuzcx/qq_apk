import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class armo
  extends armd
  implements arkn, arko
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Arki.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new armq(this);
  protected arog a;
  private bhuw jdField_a_of_type_Bhuw = new armr(this);
  private bhuy jdField_a_of_type_Bhuy = new arms(this);
  private List<arkl> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Arki.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Arki.c();
  private boolean d;
  
  public armo(arki paramarki, Activity paramActivity)
  {
    super(paramarki, paramActivity);
    this.jdField_a_of_type_Arog = new arog(paramActivity);
    a(this.jdField_a_of_type_Arog);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    arkl localarkl = (arkl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arki.c());
    if (localarkl == null) {
      return null;
    }
    String str = localarkl.a();
    if (TextUtils.isEmpty(str)) {
      return localarkl.b();
    }
    return str;
  }
  
  private void c()
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
    switch (this.jdField_a_of_type_Arki.k())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      azqs.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772036, 2130772038);
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
    return this.jdField_a_of_type_Arki.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Arki.e()))
    {
      this.jdField_a_of_type_Arog.c(a(b()));
      arri.b(BaseApplicationImpl.getContext().getString(2131692560));
    }
    this.jdField_a_of_type_Arog.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arog.a(this.jdField_a_of_type_Bhuw);
    this.jdField_a_of_type_Arog.a(new armp(this));
    this.jdField_a_of_type_Arog.a(this.jdField_a_of_type_Bhuy);
    this.jdField_a_of_type_Arog.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Arog.c(this.jdField_a_of_type_Arki.c());
    b();
    this.jdField_a_of_type_Arki.a(this);
    this.jdField_a_of_type_Arki.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Arki.c(paramInt);
    if ((this.jdField_a_of_type_Arki.i()) && (this.jdField_a_of_type_Arki.a() != null))
    {
      this.jdField_a_of_type_Arog.b(true);
      this.jdField_a_of_type_Arog.a(false);
      b(0.0F);
      this.jdField_a_of_type_Arki.a().a();
    }
    b();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
      }
    }
    arkl localarkl;
    do
    {
      return;
      localarkl = (arkl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arki.c());
    } while (!localarkl.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localarkl.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localarkl.a(paramString2);
    localarkl.a(2);
    this.jdField_a_of_type_Arog.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_Arki.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Arog.a(false);
      this.jdField_a_of_type_Arog.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Arog.a(true);
        this.jdField_a_of_type_Arog.b(false);
      }
      super.b();
    } while (this.jdField_a_of_type_Arki.f() != 9501);
    this.jdField_a_of_type_Arog.b();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arog.a(false);
    this.jdField_a_of_type_Arog.b(true);
    b(this.jdField_a_of_type_Arki.a());
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    b();
    ((arkl)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arki.c())).b(this.jdField_a_of_type_Arki.d());
    this.jdField_a_of_type_Arog.c();
    this.jdField_a_of_type_Arog.d();
    if (this.jdField_a_of_type_Arhw != null) {
      this.jdField_a_of_type_Arhw.e();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Arog.a(true);
    this.jdField_a_of_type_Arog.b(false);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armo
 * JD-Core Version:    0.7.0.1
 */