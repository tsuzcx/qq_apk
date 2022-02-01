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
import com.tencent.mobileqq.activity.aio.AIOUtils;
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

public class bosl
  extends botu
{
  public int a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bisa jdField_a_of_type_Bisa;
  private bpfr jdField_a_of_type_Bpfr;
  ThreadExcutor.IThreadListener jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener = new bosm(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  private boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  public bosl(@NonNull botw parambotw)
  {
    super(parambotw);
    this.jdField_b_of_type_Int = 20;
  }
  
  private bisa a()
  {
    bisa localbisa = new bisa(a());
    localbisa.a(AIOUtils.dp2px(50.0F, a()));
    localbisa.a(true);
    localbisa.c(false);
    localbisa.g(-1);
    localbisa.f(0);
    localbisa.d(-15550475);
    localbisa.i(3);
    localbisa.jdField_f_of_type_Boolean = true;
    localbisa.jdField_f_of_type_Int = 2;
    localbisa.e(true);
    localbisa.a(new boso(this));
    return localbisa;
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
    if ((this.jdField_a_of_type_Bouo.getActivity() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
    while (new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return;
    }
  }
  
  private void d()
  {
    bpel localbpel = new bpel(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
    localbpel.b = bpfc.a(2);
    localbpel.a = new bpeq(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a.a());
    Iterator localIterator = this.jdField_a_of_type_Botw.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((botu)localIterator.next()).a(0, localbpel);
    }
    ykq.d("EditPicSave", "PUBLISH start ...");
    a(anvx.a(2131703171), false, 0);
    a(20);
    Stream.of(localbpel).map(new bpeo((bors)a(bors.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new bpfa(bose.jdField_a_of_type_JavaLangString + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new bosn(this));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Bisa == null) {
      return;
    }
    this.jdField_a_of_type_Bisa.a();
    this.jdField_a_of_type_Bisa.c(paramInt);
    if (QLog.isColorLevel()) {
      QLog.w("EditPicSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bisa.a() + ", progress:" + paramInt);
    }
    this.jdField_a_of_type_Bisa.b(true);
    this.jdField_a_of_type_Bisa.d(false);
    this.jdField_a_of_type_Bisa.a(String.valueOf(paramInt) + "%");
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ykw.b("0X80080E1", ykw.a);
      d();
      return;
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_a_of_type_Bpfr = null;
      return;
      this.jdField_c_of_type_Int = paramInt;
    } while (!(paramObject instanceof bpfr));
    this.jdField_a_of_type_Bpfr = ((bpfr)paramObject);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561862);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373219);
      this.jdField_a_of_type_Bisa = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bisa);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371598)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bisa.c(0);
    a().a().postDelayed(new EditPicSave.3(this), paramInt);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bouo.a().postDelayed(new EditPicSave.4(this), 1000L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = true;
    c();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosl
 * JD-Core Version:    0.7.0.1
 */