import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class appd
  extends apos
  implements apna, apnb
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Apmx.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new appe(this);
  protected apqq a;
  private bfpc jdField_a_of_type_Bfpc = new appf(this);
  private bfpe jdField_a_of_type_Bfpe = new appg(this);
  private List<apmy> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Apmx.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Apmx.c();
  private boolean d;
  
  public appd(apmx paramapmx, Activity paramActivity)
  {
    super(paramapmx, paramActivity);
    this.jdField_a_of_type_Apqq = new apqq(paramActivity);
    a(this.jdField_a_of_type_Apqq);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    apmy localapmy = (apmy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apmx.c());
    if (localapmy == null) {
      return null;
    }
    String str = localapmy.a();
    if (TextUtils.isEmpty(str)) {
      return localapmy.b();
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
    switch (this.jdField_a_of_type_Apmx.k())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Apmx.b();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Apmx.e()))
    {
      this.jdField_a_of_type_Apqq.c(a(b()));
      aptv.b(BaseApplicationImpl.getContext().getString(2131692482));
    }
    this.jdField_a_of_type_Apqq.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Apqq.a(this.jdField_a_of_type_Bfpc);
    this.jdField_a_of_type_Apqq.a(this.jdField_a_of_type_Bfpe);
    this.jdField_a_of_type_Apqq.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Apqq.c(this.jdField_a_of_type_Apmx.c());
    b();
    this.jdField_a_of_type_Apmx.a(this);
    this.jdField_a_of_type_Apmx.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Apmx.c(paramInt);
    if ((this.jdField_a_of_type_Apmx.i()) && (this.jdField_a_of_type_Apmx.a() != null))
    {
      this.jdField_a_of_type_Apqq.b(true);
      this.jdField_a_of_type_Apqq.a(false);
      b(0.0F);
      this.jdField_a_of_type_Apmx.a().a();
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
    apmy localapmy;
    do
    {
      return;
      localapmy = (apmy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apmx.c());
    } while (!localapmy.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localapmy.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localapmy.a(paramString2);
    localapmy.a(2);
    this.jdField_a_of_type_Apqq.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_Apmx.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Apqq.a(false);
      this.jdField_a_of_type_Apqq.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Apqq.a(true);
        this.jdField_a_of_type_Apqq.b(false);
      }
      super.b();
    } while (this.jdField_a_of_type_Apmx.f() != 9501);
    this.jdField_a_of_type_Apqq.b();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apqq.a(false);
    this.jdField_a_of_type_Apqq.b(true);
    b(this.jdField_a_of_type_Apmx.a());
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    b();
    ((apmy)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apmx.c())).b(this.jdField_a_of_type_Apmx.c());
    this.jdField_a_of_type_Apqq.c();
    this.jdField_a_of_type_Apqq.d();
    if (this.jdField_a_of_type_Apkm != null) {
      this.jdField_a_of_type_Apkm.e();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apqq.a(true);
    this.jdField_a_of_type_Apqq.b(false);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appd
 * JD-Core Version:    0.7.0.1
 */