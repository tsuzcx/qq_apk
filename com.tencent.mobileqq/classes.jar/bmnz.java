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

public class bmnz
  extends bmnh
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  betn jdField_a_of_type_Betn;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bmnz(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  private betn a()
  {
    betn localbetn = new betn(a());
    localbetn.a(aepi.a(50.0F, a()));
    localbetn.a(true);
    localbetn.c(false);
    localbetn.f(-1);
    localbetn.e(0);
    localbetn.d(-15550475);
    localbetn.g(3);
    localbetn.jdField_f_of_type_Boolean = true;
    localbetn.jdField_f_of_type_Int = 2;
    localbetn.e(true);
    localbetn.a(new bmoc(this));
    return localbetn;
  }
  
  private void k()
  {
    azqs.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    azib.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    azib.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    azib.x = 0;
    azib.E = 0;
    int i;
    bnaz localbnaz;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      azib.J = i;
      wxe.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + azib.z + " CodecParam.mRecordTime" + azib.y);
      localbnaz = new bnaz(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbnaz.b = bnbs.a(2);
      localActivity = this.jdField_a_of_type_Bmor.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbnaz.jdField_a_of_type_Bnbh = new bnbh(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bmnj.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bmnh)((Iterator)localObject).next()).a(0, localbnaz);
      }
      i = 0;
      break;
    }
    wxe.d("EditVideoSave", "PUBLISH start ...");
    a(alud.a(2131704239), false, 0);
    a(2);
    Stream.of(localbnaz).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bnbi()).map((StreamFunction)uqn.a(bnba.class, new Object[] { (bmiq)this.jdField_a_of_type_Bmnj.a(bmiq.class) })).map(new bnbu(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bmoa(this, localbnaz));
  }
  
  private void l()
  {
    wxe.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bnaz localbnaz;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbnaz = new bnaz(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = azib.r;
      if (azki.f()) {
        localbnaz.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (azki.b() * 1000);
      }
      localbnaz.b = bnbs.a(2);
      localObject2 = this.jdField_a_of_type_Bmor.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbnaz.jdField_a_of_type_Bnbh = new bnbh((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bmnj.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bmnh)((Iterator)localObject1).next()).a(0, localbnaz);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    wxe.d("EditVideoSave", "PUBLISH start ...");
    a(alud.a(2131704102), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbnaz).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bnbe());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmlp.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmku != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bmnj.jdField_a_of_type_Bmku.a(0));
    }
    ((Stream)localObject2).map(new bnbn()).map(new bnbu(this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bmob(this, localbnaz));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Betn == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Betn.a();
      this.jdField_a_of_type_Betn.c(paramInt);
      this.jdField_a_of_type_Betn.b(true);
      this.jdField_a_of_type_Betn.d(false);
      this.jdField_a_of_type_Betn.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Betn.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bmnj.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bmor.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(alud.a(2131704277));; localStringBuilder = new StringBuilder(alud.a(2131704131)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bmor.a(), 1, localStringBuilder, 0).a();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561642);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372332);
      this.jdField_a_of_type_Betn = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Betn);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370777)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Betn.c(0);
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
    if ((this.jdField_a_of_type_Bmnj.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bmor == null) {
      return;
    }
    this.jdField_a_of_type_Bmor.a().postDelayed(new EditVideoSave.5(this), 1000L);
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
 * Qualified Name:     bmnz
 * JD-Core Version:    0.7.0.1
 */