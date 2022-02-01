import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import java.util.Iterator;
import java.util.List;

public class bpff
  extends bpen
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  biaj jdField_a_of_type_Biaj;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bpff(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  private biaj a()
  {
    biaj localbiaj = new biaj(a());
    localbiaj.a(afur.a(50.0F, a()));
    localbiaj.a(true);
    localbiaj.c(false);
    localbiaj.f(-1);
    localbiaj.e(0);
    localbiaj.d(-15550475);
    localbiaj.g(3);
    localbiaj.jdField_f_of_type_Boolean = true;
    localbiaj.jdField_f_of_type_Int = 2;
    localbiaj.e(true);
    localbiaj.a(new bpfi(this));
    return localbiaj;
  }
  
  private void k()
  {
    bcst.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bcjb.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    bcjb.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    bcjb.x = 0;
    bcjb.E = 0;
    int i;
    bpsf localbpsf;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bcjb.J = i;
      yqp.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + bcjb.z + " CodecParam.mRecordTime" + bcjb.y);
      localbpsf = new bpsf(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbpsf.b = bpsy.a(2);
      localActivity = this.jdField_a_of_type_Bpfx.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbpsf.jdField_a_of_type_Bpsn = new bpsn(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bpep.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bpen)((Iterator)localObject).next()).a(0, localbpsf);
      }
      i = 0;
      break;
    }
    yqp.d("EditVideoSave", "PUBLISH start ...");
    a(anni.a(2131702636), false, 0);
    a(2);
    Stream.of(localbpsf).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bpso()).map((StreamFunction)wjz.a(bpsg.class, new Object[] { (bozw)this.jdField_a_of_type_Bpep.a(bozw.class) })).map(new bpta(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bpfg(this, localbpsf));
  }
  
  private void l()
  {
    yqp.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bpsf localbpsf;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbpsf = new bpsf(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = bcjb.r;
      if (bclh.f()) {
        localbpsf.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (bclh.b() * 1000);
      }
      localbpsf.b = bpsy.a(2);
      localObject2 = this.jdField_a_of_type_Bpfx.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbpsf.jdField_a_of_type_Bpsn = new bpsn((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bpep.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bpen)((Iterator)localObject1).next()).a(0, localbpsf);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    yqp.d("EditVideoSave", "PUBLISH start ...");
    a(anni.a(2131702499), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbpsf).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bpsk());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpcv != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpcv.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpca != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bpep.jdField_a_of_type_Bpca.a(0));
    }
    ((Stream)localObject2).map(new bpst()).map(new bpta(this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bpfh(this, localbpsf));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biaj == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Biaj.a();
      this.jdField_a_of_type_Biaj.c(paramInt);
      this.jdField_a_of_type_Biaj.b(true);
      this.jdField_a_of_type_Biaj.d(false);
      this.jdField_a_of_type_Biaj.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Biaj.a() + ", progress:" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramIntent != null) && ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramIntent.getStringExtra("fakeId")))));
      this.jdField_a_of_type_Bpep.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bpfx.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(anni.a(2131702674));; localStringBuilder = new StringBuilder(anni.a(2131702528)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bpfx.a(), 1, localStringBuilder, 0).a();
          return;
        }
      }
    } while (paramInt2 != 0);
    j();
  }
  
  @TargetApi(14)
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561876);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372926);
      this.jdField_a_of_type_Biaj = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Biaj);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371338)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Biaj.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Bpep.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bpfx == null) {
      return;
    }
    this.jdField_a_of_type_Bpfx.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void g()
  {
    j();
    super.g();
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpff
 * JD-Core Version:    0.7.0.1
 */