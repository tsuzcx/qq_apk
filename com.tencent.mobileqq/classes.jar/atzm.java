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

public class atzm
  extends atzb
  implements atxf, atxg
{
  private int jdField_a_of_type_Int = this.jdField_a_of_type_Atxa.c();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new atzo(this);
  protected auay a;
  private AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = new atzp(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new atzq(this);
  private List<atxc> jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_Atxa.a();
  boolean jdField_a_of_type_Boolean = false;
  private int b = this.jdField_a_of_type_Atxa.c();
  private boolean d;
  
  public atzm(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
    this.jdField_a_of_type_Auay = new auay(paramActivity);
    a(this.jdField_a_of_type_Auay);
  }
  
  private boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String b()
  {
    atxc localatxc = (atxc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Atxa.c());
    if (localatxc == null) {
      return null;
    }
    String str = localatxc.a();
    if (TextUtils.isEmpty(str)) {
      return localatxc.b();
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
    switch (this.jdField_a_of_type_Atxa.l())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      bdla.b(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Atxa.c();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int) != null) && (this.jdField_a_of_type_Atxa.e()))
    {
      this.jdField_a_of_type_Auay.c(a(b()));
      audr.b(BaseApplicationImpl.getContext().getString(2131692289));
    }
    this.jdField_a_of_type_Auay.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Auay.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
    this.jdField_a_of_type_Auay.a(new atzn(this));
    this.jdField_a_of_type_Auay.a(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    this.jdField_a_of_type_Auay.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_Auay.c(this.jdField_a_of_type_Atxa.c());
    h();
    this.jdField_a_of_type_Atxa.a(this);
    this.jdField_a_of_type_Atxa.a(this);
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Atxa.c(paramInt);
    if ((this.jdField_a_of_type_Atxa.i()) && (this.jdField_a_of_type_Atxa.a() != null))
    {
      this.jdField_a_of_type_Auay.b(true);
      this.jdField_a_of_type_Auay.a(false);
      b(0.0F);
      this.jdField_a_of_type_Atxa.a().a();
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
    atxc localatxc;
    do
    {
      return;
      localatxc = (atxc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Atxa.c());
    } while (!localatxc.a(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      localatxc.a(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    localatxc.a(paramString2);
    localatxc.a(2);
    this.jdField_a_of_type_Auay.c();
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
    this.jdField_a_of_type_Auay.a(false);
    this.jdField_a_of_type_Auay.b(true);
    b(this.jdField_a_of_type_Atxa.a());
  }
  
  public void e()
  {
    h();
  }
  
  public void f()
  {
    h();
    ((atxc)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Atxa.c())).b(this.jdField_a_of_type_Atxa.d());
    this.jdField_a_of_type_Auay.c();
    this.jdField_a_of_type_Auay.d();
    if (this.jdField_a_of_type_Atuw != null) {
      this.jdField_a_of_type_Atuw.c();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_Auay.a(true);
    this.jdField_a_of_type_Auay.b(false);
    h();
  }
  
  protected void h()
  {
    int i = this.jdField_a_of_type_Atxa.i();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Auay.a(false);
      this.jdField_a_of_type_Auay.b(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Auay.a(true);
        this.jdField_a_of_type_Auay.b(false);
      }
      super.h();
    } while (this.jdField_a_of_type_Atxa.f() != 9501);
    this.jdField_a_of_type_Auay.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzm
 * JD-Core Version:    0.7.0.1
 */