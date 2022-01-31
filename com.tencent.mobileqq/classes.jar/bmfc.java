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

public class bmfc
  extends bmiv
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bepe jdField_a_of_type_Bepe;
  private bmxy jdField_a_of_type_Bmxy;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new bmfd(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public bmfc(@NonNull bmix parambmix)
  {
    super(parambmix);
    this.jdField_b_of_type_Int = 20;
  }
  
  private bepe a()
  {
    bepe localbepe = new bepe(a());
    localbepe.a(aekt.a(50.0F, a()));
    localbepe.a(true);
    localbepe.c(false);
    localbepe.f(-1);
    localbepe.e(0);
    localbepe.d(-15550475);
    localbepe.g(3);
    localbepe.jdField_f_of_type_Boolean = true;
    localbepe.jdField_f_of_type_Int = 2;
    localbepe.e(true);
    localbepe.a(new bmff(this));
    return localbepe;
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
    if ((this.jdField_a_of_type_Bmkf.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void j()
  {
    bmwn localbmwn = new bmwn(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbmwn.b = bmxg.a(2);
    localbmwn.a = new bmwt(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Bmix.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bmiv)localIterator.next()).a(0, localbmwn);
    }
    wsv.d("EditPicSave", "PUBLISH start ...");
    a(alpo.a(2131704069), false, 0);
    a(20);
    Stream.of(localbmwn).map(new bmwq((bmee)a(bmee.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new bmxe(bmew.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new bmfe(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bepe == null) {
      return;
    }
    this.jdField_a_of_type_Bepe.a();
    this.jdField_a_of_type_Bepe.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bepe.b(true);
    this.jdField_a_of_type_Bepe.d(false);
    this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bepe.c(0);
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
      wtb.b("0X80080E1", wtb.a);
      j();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Bmxy = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof bmxy));
    this.jdField_a_of_type_Bmxy = ((bmxy)paramObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bmkf.a().postDelayed(new EditPicSave.4(this), 1000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfc
 * JD-Core Version:    0.7.0.1
 */