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
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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

public class bqcp
  extends bqgi
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bjbh jdField_a_of_type_Bjbh;
  private bqvl jdField_a_of_type_Bqvl;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new bqcq(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public bqcp(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
    this.jdField_b_of_type_Int = 20;
  }
  
  private bjbh a()
  {
    bjbh localbjbh = new bjbh(a());
    localbjbh.a(agej.a(50.0F, a()));
    localbjbh.a(true);
    localbjbh.c(false);
    localbjbh.g(-1);
    localbjbh.f(0);
    localbjbh.d(-15550475);
    localbjbh.i(3);
    localbjbh.jdField_f_of_type_Boolean = true;
    localbjbh.jdField_f_of_type_Int = 2;
    localbjbh.e(true);
    localbjbh.a(new bqcs(this));
    return localbjbh;
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
    if ((this.jdField_a_of_type_Bqhs.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void j()
  {
    bqua localbqua = new bqua(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbqua.b = bqut.a(2);
    localbqua.a = new bqug(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Bqgk.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bqgi)localIterator.next()).a(0, localbqua);
    }
    yuk.d("EditPicSave", "PUBLISH start ...");
    a(anzj.a(2131702585), false, 0);
    a(20);
    Stream.of(localbqua).map(new bqud((bqbr)a(bqbr.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new bqur(bqcj.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new bqcr(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bjbh == null) {
      return;
    }
    this.jdField_a_of_type_Bjbh.a();
    this.jdField_a_of_type_Bjbh.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bjbh.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bjbh.b(true);
    this.jdField_a_of_type_Bjbh.d(false);
    this.jdField_a_of_type_Bjbh.a(String.valueOf(paramInt) + "%");
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(a());
      Object localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      if (localObject != null)
      {
        ((Window)localObject).setBackgroundDrawable(new ColorDrawable());
        if (Build.VERSION.SDK_INT >= 14) {
          ((Window)localObject).setDimAmount(0.0F);
        }
      }
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561917);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373039);
      this.jdField_a_of_type_Bjbh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bjbh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371445)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bjbh.c(0);
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
      yuq.b("0X80080E1", yuq.a);
      j();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Bqvl = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof bqvl));
    this.jdField_a_of_type_Bqvl = ((bqvl)paramObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bqhs.a().postDelayed(new EditPicSave.4(this), 1000L);
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
 * Qualified Name:     bqcp
 * JD-Core Version:    0.7.0.1
 */