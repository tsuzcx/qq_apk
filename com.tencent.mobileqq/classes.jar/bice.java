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

public class bice
  extends bifz
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bbmh jdField_a_of_type_Bbmh;
  private bivl jdField_a_of_type_Bivl;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new bicf(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public bice(@NonNull bigb parambigb)
  {
    super(parambigb);
    this.jdField_b_of_type_Int = 20;
  }
  
  private bbmh a()
  {
    bbmh localbbmh = new bbmh(a());
    localbbmh.a(aciy.a(50.0F, a()));
    localbbmh.a(true);
    localbbmh.c(false);
    localbbmh.f(-1);
    localbbmh.e(0);
    localbbmh.d(-15550475);
    localbbmh.g(3);
    localbbmh.jdField_f_of_type_Boolean = true;
    localbbmh.jdField_f_of_type_Int = 2;
    localbbmh.e(true);
    localbbmh.a(new bich(this));
    return localbbmh;
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
    if ((this.jdField_a_of_type_Bihj.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void j()
  {
    bitz localbitz = new bitz(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbitz.b = biut.a(2);
    localbitz.a = new biuf(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Bigb.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bifz)localIterator.next()).a(0, localbitz);
    }
    urk.d("EditPicSave", "PUBLISH start ...");
    a(ajjy.a(2131637901), false, 0);
    a(20);
    Stream.of(localbitz).map(new biuc((bibg)a(bibg.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new biur(biby.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new bicg(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bbmh == null) {
      return;
    }
    this.jdField_a_of_type_Bbmh.a();
    this.jdField_a_of_type_Bbmh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bbmh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bbmh.b(true);
    this.jdField_a_of_type_Bbmh.d(false);
    this.jdField_a_of_type_Bbmh.a(String.valueOf(paramInt) + "%");
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131495844);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131306298);
      this.jdField_a_of_type_Bbmh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bbmh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131304792)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bbmh.c(0);
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
      urq.b("0X80080E1", urq.a);
      j();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Bivl = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof bivl));
    this.jdField_a_of_type_Bivl = ((bivl)paramObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bihj.a().postDelayed(new EditPicSave.4(this), 1000L);
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
 * Qualified Name:     bice
 * JD-Core Version:    0.7.0.1
 */