import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class arif
  extends arhu
  implements arge, argf
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Arfz.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new arih(this);
  protected arjx a;
  private bhqp jdField_a_of_type_Bhqp = new arii(this);
  private bhqr jdField_a_of_type_Bhqr = new arij(this);
  private List<argc> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Arfz.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Arfz.c();
  private boolean d;
  
  public arif(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_Arjx = new arjx(paramActivity);
    a(this.jdField_a_of_type_Arjx);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    argc localargc = (argc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arfz.c());
    if (localargc == null) {
      return null;
    }
    String str = localargc.a();
    if (TextUtils.isEmpty(str)) {
      return localargc.b();
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
    switch (this.jdField_a_of_type_Arfz.k())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      azmj.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Arfz.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Arfz.e()))
    {
      this.jdField_a_of_type_Arjx.c(a(b()));
      armz.b(BaseApplicationImpl.getContext().getString(2131692559));
    }
    this.jdField_a_of_type_Arjx.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Arjx.a(this.jdField_a_of_type_Bhqp);
    this.jdField_a_of_type_Arjx.a(new arig(this));
    this.jdField_a_of_type_Arjx.a(this.jdField_a_of_type_Bhqr);
    this.jdField_a_of_type_Arjx.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Arjx.c(this.jdField_a_of_type_Arfz.c());
    b();
    this.jdField_a_of_type_Arfz.a(this);
    this.jdField_a_of_type_Arfz.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Arfz.c(paramInt);
    if ((this.jdField_a_of_type_Arfz.i()) && (this.jdField_a_of_type_Arfz.a() != null))
    {
      this.jdField_a_of_type_Arjx.b(true);
      this.jdField_a_of_type_Arjx.a(false);
      b(0.0F);
      this.jdField_a_of_type_Arfz.a().a();
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
    argc localargc;
    do
    {
      return;
      localargc = (argc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arfz.c());
    } while (!localargc.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localargc.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localargc.a(paramString2);
    localargc.a(2);
    this.jdField_a_of_type_Arjx.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_Arfz.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Arjx.a(false);
      this.jdField_a_of_type_Arjx.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Arjx.a(true);
        this.jdField_a_of_type_Arjx.b(false);
      }
      super.b();
    } while (this.jdField_a_of_type_Arfz.f() != 9501);
    this.jdField_a_of_type_Arjx.b();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arjx.a(false);
    this.jdField_a_of_type_Arjx.b(true);
    b(this.jdField_a_of_type_Arfz.a());
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    b();
    ((argc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Arfz.c())).b(this.jdField_a_of_type_Arfz.d());
    this.jdField_a_of_type_Arjx.c();
    this.jdField_a_of_type_Arjx.d();
    if (this.jdField_a_of_type_Ardn != null) {
      this.jdField_a_of_type_Ardn.e();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Arjx.a(true);
    this.jdField_a_of_type_Arjx.b(false);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arif
 * JD-Core Version:    0.7.0.1
 */