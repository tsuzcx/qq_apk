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

public class boug
  extends botu
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bisa jdField_a_of_type_Bisa;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public boug(@NonNull botw parambotw)
  {
    super(parambotw);
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
    localbisa.a(new bouj(this));
    return localbisa;
  }
  
  private void d()
  {
    bdla.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    CodecParam.mRecordTime = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    CodecParam.mRecordFrames = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    int i;
    bpel localbpel;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter != null)
    {
      i = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a();
      CodecParam.mSaveMode = i;
      ykq.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
      localbpel = new bpel(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbpel.b = bpfc.a(2);
      localActivity = this.jdField_a_of_type_Bouo.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbpel.jdField_a_of_type_Bpes = new bpes(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Botw.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((botu)((Iterator)localObject).next()).a(0, localbpel);
      }
      i = 0;
      break;
    }
    ykq.d("EditVideoSave", "PUBLISH start ...");
    a(anvx.a(2131703326), false, 0);
    a(2);
    Stream.of(localbpel).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bpet()).map((StreamFunction)weg.a(bpem.class, new Object[] { (bors)this.jdField_a_of_type_Botw.a(bors.class) })).map(new bpfe(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bouh(this, localbpel));
  }
  
  private void i()
  {
    ykq.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bpel localbpel;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbpel = new bpel(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
      if (bddt.f()) {
        localbpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (bddt.b() * 1000);
      }
      localbpel.b = bpfc.a(2);
      localObject2 = this.jdField_a_of_type_Bouo.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter == null) || (this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSpeedFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbpel.jdField_a_of_type_Bpes = new bpes((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Botw.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((botu)((Iterator)localObject1).next()).a(0, localbpel);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    ykq.d("EditVideoSave", "PUBLISH start ...");
    a(anvx.a(2131703192), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbpel).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bpep());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Botw.jdField_a_of_type_Botf != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Botw.jdField_a_of_type_Botf.a(0));
    }
    ((Stream)localObject1).map(new bpex()).map(new bpfe(this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new boui(this, localbpel));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bisa == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bisa.a();
      this.jdField_a_of_type_Bisa.c(paramInt);
      this.jdField_a_of_type_Bisa.b(true);
      this.jdField_a_of_type_Bisa.d(false);
      this.jdField_a_of_type_Bisa.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bisa.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Botw.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bouo.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        c();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(anvx.a(2131703364));; localStringBuilder = new StringBuilder(anvx.a(2131703221)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bouo.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Botw.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561862);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373219);
      this.jdField_a_of_type_Bisa = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bisa);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371598)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bisa.c(0);
    a().a().postDelayed(new EditVideoSave.4(this), paramInt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bouo == null) {
      return;
    }
    this.jdField_a_of_type_Bouo.a().postDelayed(new EditVideoSave.5(this), 1000L);
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
 * Qualified Name:     boug
 * JD-Core Version:    0.7.0.1
 */