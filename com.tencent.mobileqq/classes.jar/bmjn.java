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

public class bmjn
  extends bmiv
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bepe jdField_a_of_type_Bepe;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bmjn(@NonNull bmix parambmix)
  {
    super(parambmix);
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
    localbepe.a(new bmjq(this));
    return localbepe;
  }
  
  private void k()
  {
    azmj.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    azds.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    azds.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    azds.x = 0;
    azds.E = 0;
    int i;
    bmwn localbmwn;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azds.J = i;
      wsv.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + azds.z + " CodecParam.mRecordTime" + azds.y);
      localbmwn = new bmwn(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbmwn.b = bmxg.a(2);
      localActivity = this.jdField_a_of_type_Bmkf.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbmwn.jdField_a_of_type_Bmwv = new bmwv(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bmix.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bmiv)((Iterator)localObject).next()).a(0, localbmwn);
      }
      i = 0;
      break;
    }
    wsv.d("EditVideoSave", "PUBLISH start ...");
    a(alpo.a(2131704227), false, 0);
    a(2);
    Stream.of(localbmwn).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bmww()).map((StreamFunction)ume.a(bmwo.class, new Object[] { (bmee)this.jdField_a_of_type_Bmix.a(bmee.class) })).map(new bmxi(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bmjo(this, localbmwn));
  }
  
  private void l()
  {
    wsv.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bmwn localbmwn;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbmwn = new bmwn(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azds.r;
      if (azfz.f()) {
        localbmwn.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (azfz.b() * 1000);
      }
      localbmwn.b = bmxg.a(2);
      localObject2 = this.jdField_a_of_type_Bmkf.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbmwn.jdField_a_of_type_Bmwv = new bmwv((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bmix.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bmiv)((Iterator)localObject1).next()).a(0, localbmwn);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    wsv.d("EditVideoSave", "PUBLISH start ...");
    a(alpo.a(2131704090), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbmwn).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bmws());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmhd != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmhd.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgi != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bmix.jdField_a_of_type_Bmgi.a(0));
    }
    ((Stream)localObject2).map(new bmxb()).map(new bmxi(this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bmjp(this, localbmwn));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bepe == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bepe.a();
      this.jdField_a_of_type_Bepe.c(paramInt);
      this.jdField_a_of_type_Bepe.b(true);
      this.jdField_a_of_type_Bepe.d(false);
      this.jdField_a_of_type_Bepe.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bepe.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bmix.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bmkf.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(alpo.a(2131704265));; localStringBuilder = new StringBuilder(alpo.a(2131704119)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bmkf.a(), 1, localStringBuilder, 0).a();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561624);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372312);
      this.jdField_a_of_type_Bepe = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bepe);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370758)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bepe.c(0);
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
    if ((this.jdField_a_of_type_Bmix.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bmkf == null) {
      return;
    }
    this.jdField_a_of_type_Bmkf.a().postDelayed(new EditVideoSave.5(this), 1000L);
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
 * Qualified Name:     bmjn
 * JD-Core Version:    0.7.0.1
 */