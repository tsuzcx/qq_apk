import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.3;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class bjtb
  extends bjwu
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpf jdField_a_of_type_Bcpf;
  private bklx jdField_a_of_type_Bklx;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new bjtc(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public bjtb(@NonNull bjww parambjww)
  {
    super(parambjww);
    this.jdField_b_of_type_Int = 20;
  }
  
  private bcpf a()
  {
    bcpf localbcpf = new bcpf(a());
    localbcpf.a(actn.a(50.0F, a()));
    localbcpf.a(true);
    localbcpf.c(false);
    localbcpf.f(-1);
    localbcpf.e(0);
    localbcpf.d(-15550475);
    localbcpf.g(3);
    localbcpf.jdField_f_of_type_Boolean = true;
    localbcpf.jdField_f_of_type_Int = 2;
    localbcpf.e(true);
    localbcpf.a(new bjte(this));
    return localbcpf;
  }
  
  private String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("mini_launch_ae_tag", 0).getString("mini_launch_ae_app_id", "");
    }
    return "";
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_Bjye.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void j()
  {
    bkkm localbkkm = new bkkm(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbkkm.b = bklf.a(2);
    localbkkm.a = new bkks(this.jdField_a_of_type_Bjww.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Bjww.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bjwu)localIterator.next()).a(0, localbkkm);
    }
    veg.d("EditPicSave", "PUBLISH start ...");
    a(ajyc.a(2131703686), false, 0);
    a(20);
    Stream.of(localbkkm).map(new bkkp((bjsd)a(bjsd.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new bkld(bjsv.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new bjtd(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bcpf == null) {
      return;
    }
    this.jdField_a_of_type_Bcpf.a();
    this.jdField_a_of_type_Bcpf.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpf.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bcpf.b(true);
    this.jdField_a_of_type_Bcpf.d(false);
    this.jdField_a_of_type_Bcpf.a(String.valueOf(paramInt) + "%");
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561435);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpf = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpf);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370453)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpf.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      vem.b("0X80080E1", vem.a);
      j();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Bklx = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof bklx));
    this.jdField_a_of_type_Bklx = ((bklx)paramObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bjye.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    d();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtb
 * JD-Core Version:    0.7.0.1
 */