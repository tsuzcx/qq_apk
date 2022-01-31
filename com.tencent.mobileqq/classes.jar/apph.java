import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class apph
  extends apow
  implements apne, apnf
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Apnb.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new appi(this);
  protected apqu a;
  private bfpt jdField_a_of_type_Bfpt = new appj(this);
  private bfpv jdField_a_of_type_Bfpv = new appk(this);
  private List<apnc> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Apnb.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Apnb.c();
  private boolean d;
  
  public apph(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_Apqu = new apqu(paramActivity);
    a(this.jdField_a_of_type_Apqu);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    apnc localapnc = (apnc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apnb.c());
    if (localapnc == null) {
      return null;
    }
    String str = localapnc.a();
    if (TextUtils.isEmpty(str)) {
      return localapnc.b();
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
    switch (this.jdField_a_of_type_Apnb.k())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      axqy.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Apnb.b();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Apnb.e()))
    {
      this.jdField_a_of_type_Apqu.c(a(b()));
      aptx.b(BaseApplicationImpl.getContext().getString(2131692483));
    }
    this.jdField_a_of_type_Apqu.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Apqu.a(this.jdField_a_of_type_Bfpt);
    this.jdField_a_of_type_Apqu.a(this.jdField_a_of_type_Bfpv);
    this.jdField_a_of_type_Apqu.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Apqu.c(this.jdField_a_of_type_Apnb.c());
    b();
    this.jdField_a_of_type_Apnb.a(this);
    this.jdField_a_of_type_Apnb.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Apnb.c(paramInt);
    if ((this.jdField_a_of_type_Apnb.i()) && (this.jdField_a_of_type_Apnb.a() != null))
    {
      this.jdField_a_of_type_Apqu.b(true);
      this.jdField_a_of_type_Apqu.a(false);
      b(0.0F);
      this.jdField_a_of_type_Apnb.a().a();
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
    apnc localapnc;
    do
    {
      return;
      localapnc = (apnc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apnb.c());
    } while (!localapnc.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localapnc.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localapnc.a(paramString2);
    localapnc.a(2);
    this.jdField_a_of_type_Apqu.c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    int i = this.jdField_a_of_type_Apnb.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Apqu.a(false);
      this.jdField_a_of_type_Apqu.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Apqu.a(true);
        this.jdField_a_of_type_Apqu.b(false);
      }
      super.b();
    } while (this.jdField_a_of_type_Apnb.f() != 9501);
    this.jdField_a_of_type_Apqu.b();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apqu.a(false);
    this.jdField_a_of_type_Apqu.b(true);
    b(this.jdField_a_of_type_Apnb.a());
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    b();
    ((apnc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Apnb.c())).b(this.jdField_a_of_type_Apnb.c());
    this.jdField_a_of_type_Apqu.c();
    this.jdField_a_of_type_Apqu.d();
    if (this.jdField_a_of_type_Apkq != null) {
      this.jdField_a_of_type_Apkq.e();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Apqu.a(true);
    this.jdField_a_of_type_Apqu.b(false);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apph
 * JD-Core Version:    0.7.0.1
 */