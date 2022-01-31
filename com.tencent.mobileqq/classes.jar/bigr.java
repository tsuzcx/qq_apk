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
import com.tencent.qphone.base.util.QLog;
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

public class bigr
  extends bifz
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bbmh jdField_a_of_type_Bbmh;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bigr(@NonNull bigb parambigb)
  {
    super(parambigb);
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
    localbbmh.a(new bigu(this));
    return localbbmh;
  }
  
  private void k()
  {
    awqx.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    awje.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    awje.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    awje.x = 0;
    awje.E = 0;
    int i;
    bitz localbitz;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      awje.J = i;
      urk.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + awje.z + " CodecParam.mRecordTime" + awje.y);
      localbitz = new bitz(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbitz.b = biut.a(2);
      localActivity = this.jdField_a_of_type_Bihj.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbitz.jdField_a_of_type_Biuh = new biuh(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bigb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bifz)((Iterator)localObject).next()).a(0, localbitz);
      }
      i = 0;
      break;
    }
    urk.d("EditVideoSave", "PUBLISH start ...");
    a(ajjy.a(2131638059), false, 0);
    a(2);
    Stream.of(localbitz).map(new ThreadOffFunction("EditVideoSave", 2)).map(new biui()).map((StreamFunction)skt.a(biua.class, new Object[] { (bibg)this.jdField_a_of_type_Bigb.a(bibg.class) })).map(new biuv(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bigs(this, localbitz));
  }
  
  private void l()
  {
    urk.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bitz localbitz;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbitz = new bitz(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = awje.r;
      if (awll.f()) {
        localbitz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (awll.b() * 1000);
      }
      localbitz.b = biut.a(2);
      localObject2 = this.jdField_a_of_type_Bihj.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbitz.jdField_a_of_type_Biuh = new biuh((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bigb.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bifz)((Iterator)localObject1).next()).a(0, localbitz);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    urk.d("EditVideoSave", "PUBLISH start ...");
    a(ajjy.a(2131637922), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbitz).map(new ThreadOffFunction("EditVideoSave", 2)).map(new biue());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bigb.jdField_a_of_type_Bief.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bigb.jdField_a_of_type_Bidk != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bigb.jdField_a_of_type_Bidk.a(0));
    }
    ((Stream)localObject2).map(new biuo()).map(new biuv(this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bigt(this, localbitz));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbmh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bbmh.a();
      this.jdField_a_of_type_Bbmh.c(paramInt);
      this.jdField_a_of_type_Bbmh.b(true);
      this.jdField_a_of_type_Bbmh.d(false);
      this.jdField_a_of_type_Bbmh.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bbmh.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bigb.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bihj.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(ajjy.a(2131638097));; localStringBuilder = new StringBuilder(ajjy.a(2131637951)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          bbmy.a(this.jdField_a_of_type_Bihj.a(), 1, localStringBuilder, 0).a();
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
    if ((this.jdField_a_of_type_Bigb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bihj == null) {
      return;
    }
    this.jdField_a_of_type_Bihj.a().postDelayed(new EditVideoSave.5(this), 1000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigr
 * JD-Core Version:    0.7.0.1
 */