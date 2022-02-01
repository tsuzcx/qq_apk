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

public class bqha
  extends bqgi
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bjbh jdField_a_of_type_Bjbh;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bqha(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
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
    localbjbh.a(new bqhd(this));
    return localbjbh;
  }
  
  private void k()
  {
    bdll.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bdbt.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    bdbt.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    bdbt.x = 0;
    bdbt.E = 0;
    int i;
    bqua localbqua;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      bdbt.J = i;
      yuk.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + bdbt.z + " CodecParam.mRecordTime" + bdbt.y);
      localbqua = new bqua(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbqua.b = bqut.a(2);
      localActivity = this.jdField_a_of_type_Bqhs.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbqua.jdField_a_of_type_Bqui = new bqui(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bqgk.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bqgi)((Iterator)localObject).next()).a(0, localbqua);
      }
      i = 0;
      break;
    }
    yuk.d("EditVideoSave", "PUBLISH start ...");
    a(anzj.a(2131702743), false, 0);
    a(2);
    Stream.of(localbqua).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bquj()).map((StreamFunction)wnu.a(bqub.class, new Object[] { (bqbr)this.jdField_a_of_type_Bqgk.a(bqbr.class) })).map(new bquv(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bqhb(this, localbqua));
  }
  
  private void l()
  {
    yuk.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bqua localbqua;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbqua = new bqua(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = bdbt.r;
      if (bddz.f()) {
        localbqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (bddz.b() * 1000);
      }
      localbqua.b = bqut.a(2);
      localObject2 = this.jdField_a_of_type_Bqhs.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbqua.jdField_a_of_type_Bqui = new bqui((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bqgk.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bqgi)((Iterator)localObject1).next()).a(0, localbqua);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    yuk.d("EditVideoSave", "PUBLISH start ...");
    a(anzj.a(2131702606), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbqua).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bquf());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqeq.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqdv != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bqgk.jdField_a_of_type_Bqdv.a(0));
    }
    ((Stream)localObject2).map(new bquo()).map(new bquv(this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bqhc(this, localbqua));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bjbh == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bjbh.a();
      this.jdField_a_of_type_Bjbh.c(paramInt);
      this.jdField_a_of_type_Bjbh.b(true);
      this.jdField_a_of_type_Bjbh.d(false);
      this.jdField_a_of_type_Bjbh.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bjbh.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bqgk.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bqhs.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(anzj.a(2131702781));; localStringBuilder = new StringBuilder(anzj.a(2131702635)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          QQToast.a(this.jdField_a_of_type_Bqhs.a(), 1, localStringBuilder, 0).a();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561917);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373039);
      this.jdField_a_of_type_Bjbh = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bjbh);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371445)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bjbh.c(0);
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
    if ((this.jdField_a_of_type_Bqgk.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bqhs == null) {
      return;
    }
    this.jdField_a_of_type_Bqhs.a().postDelayed(new EditVideoSave.5(this), 1000L);
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
 * Qualified Name:     bqha
 * JD-Core Version:    0.7.0.1
 */