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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
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
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.4;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave.5;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import java.util.Iterator;
import java.util.List;

public class bneo
  extends bnec
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bhhi jdField_a_of_type_Bhhi;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bneo(@NonNull bnee parambnee)
  {
    super(parambnee);
  }
  
  private bhhi a()
  {
    bhhi localbhhi = new bhhi(a());
    localbhhi.a(AIOUtils.dp2px(50.0F, a()));
    localbhhi.a(true);
    localbhhi.c(false);
    localbhhi.g(-1);
    localbhhi.f(0);
    localbhhi.d(-15550475);
    localbhhi.i(3);
    localbhhi.jdField_f_of_type_Boolean = true;
    localbhhi.jdField_f_of_type_Int = 2;
    localbhhi.e(true);
    localbhhi.a(new bner(this));
    return localbhhi;
  }
  
  private void d()
  {
    bcef.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    bnot localbnot;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null)
    {
      i = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();
      CodecParam.mSaveMode = i;
      xvv.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localbnot = new bnot(this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbnot.b = bnpk.a(2);
      localActivity = this.jdField_a_of_type_Bnew.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbnot.jdField_a_of_type_Bnpa = new bnpa(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bnee.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bnec)((Iterator)localObject).next()).a(0, localbnot);
      }
      i = 0;
      break;
    }
    xvv.d("EditVideoSave", "PUBLISH start ...");
    a(amtj.a(2131702975), false, 0);
    a(2);
    Stream.of(localbnot).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bnpb()).map((StreamFunction)vpl.a(bnou.class, new Object[] { (bnca)this.jdField_a_of_type_Bnee.a(bnca.class) })).map(new bnpm(this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bnep(this, localbnot));
  }
  
  private void i()
  {
    xvv.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bnot localbnot;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbnot = new bnot(this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
      if (bbwy.f()) {
        localbnot.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (bbwy.b() * 1000);
      }
      localbnot.b = bnpk.a(2);
      localObject2 = this.jdField_a_of_type_Bnew.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbnot.jdField_a_of_type_Bnpa = new bnpa((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bnee.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bnec)((Iterator)localObject1).next()).a(0, localbnot);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    xvv.d("EditVideoSave", "PUBLISH start ...");
    a(amtj.a(2131702841), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbnot).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bnox());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bnee.jdField_a_of_type_Bndn.a(0));
    }
    ((Stream)localObject1).map(new bnpf()).map(new bnpm(this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bneq(this, localbnot));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bhhi == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bhhi.a();
      this.jdField_a_of_type_Bhhi.c(paramInt);
      this.jdField_a_of_type_Bhhi.b(true);
      this.jdField_a_of_type_Bhhi.d(false);
      this.jdField_a_of_type_Bhhi.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bhhi.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bnee.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bnew.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        c();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(amtj.a(2131703013));; localStringBuilder = new StringBuilder(amtj.a(2131702870)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bnew.a(), 1, localStringBuilder, 0).a();
          return;
        }
      }
    } while (paramInt2 != 0);
    c();
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_Bnee.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      d();
      return;
    }
    i();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561794);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373009);
      this.jdField_a_of_type_Bhhi = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bhhi);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371413)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bhhi.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bnew == null) {
      return;
    }
    this.jdField_a_of_type_Bnew.a().postDelayed(new EditVideoSave.5(this), 1000L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void g()
  {
    c();
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneo
 * JD-Core Version:    0.7.0.1
 */