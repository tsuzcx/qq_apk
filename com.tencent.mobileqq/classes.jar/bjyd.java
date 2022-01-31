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

public class bjyd
  extends bjxl
{
  public float a;
  int jdField_a_of_type_Int = -1;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  bcpu jdField_a_of_type_Bcpu;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  public float b = 3.0F;
  
  public bjyd(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private bcpu a()
  {
    bcpu localbcpu = new bcpu(a());
    localbcpu.a(actj.a(50.0F, a()));
    localbcpu.a(true);
    localbcpu.c(false);
    localbcpu.f(-1);
    localbcpu.e(0);
    localbcpu.d(-15550475);
    localbcpu.g(3);
    localbcpu.jdField_f_of_type_Boolean = true;
    localbcpu.jdField_f_of_type_Int = 2;
    localbcpu.e(true);
    localbcpu.a(new bjyg(this));
    return localbcpu;
  }
  
  private void k()
  {
    axqy.b(null, "dc00898", "", "", "0X80077E0", "0X80077E0", 0, 0, "", "", "", "");
    Object localObject = (EditRecordVideoSource)this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    axim.y = (int)((EditRecordVideoSource)localObject).jdField_a_of_type_Long;
    axim.z = ((EditRecordVideoSource)localObject).jdField_a_of_type_Int;
    axim.x = 0;
    axim.E = 0;
    int i;
    bkld localbkld;
    Activity localActivity;
    int j;
    String str;
    float f;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter != null)
    {
      i = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a();
      axim.J = i;
      ved.b("EditVideoSave", "onSaveBtnPressed CodecParam.mRecordFrames" + axim.z + " CodecParam.mRecordTime" + axim.y);
      localbkld = new bkld(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbkld.b = bklw.a(2);
      localActivity = this.jdField_a_of_type_Bjyv.getActivity();
      i = ((EditRecordVideoSource)localObject).jdField_f_of_type_Int;
      j = ((EditRecordVideoSource)localObject).g;
      str = ((EditRecordVideoSource)localObject).jdField_a_of_type_JavaLangString;
      f = ((EditRecordVideoSource)localObject).jdField_a_of_type_Float;
      if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label300;
      }
    }
    label300:
    for (boolean bool = true;; bool = false)
    {
      localbkld.jdField_a_of_type_Bkll = new bkll(localActivity, i, j, str, f, bool, ((EditRecordVideoSource)localObject).e, 0.0D, 0.0D, ((EditRecordVideoSource)localObject).b, ((EditRecordVideoSource)localObject).jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Bjxn.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((bjxl)((Iterator)localObject).next()).a(0, localbkld);
      }
      i = 0;
      break;
    }
    ved.d("EditVideoSave", "PUBLISH start ...");
    a(ajya.a(2131703855), false, 0);
    a(2);
    Stream.of(localbkld).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bklm()).map((StreamFunction)sxm.a(bkle.class, new Object[] { (bjsu)this.jdField_a_of_type_Bjxn.a(bjsu.class) })).map(new bkly(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bjye(this, localbkld));
  }
  
  private void l()
  {
    ved.b("EditVideoSave", "saveHWVideo");
    int i = 0;
    Object localObject1 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a;
    bkld localbkld;
    int j;
    int k;
    String str;
    float f;
    if ((localObject1 instanceof EditLocalVideoSource))
    {
      i = ((EditLocalVideoSource)localObject1).a.rotation;
      localbkld = new bkld(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams);
      localbkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = axim.r;
      if (axkt.f()) {
        localbkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoMaxrate = (axkt.b() * 1000);
      }
      localbkld.b = bklw.a(2);
      localObject2 = this.jdField_a_of_type_Bjyv.getActivity();
      j = ((EditVideoParams.EditSource)localObject1).a();
      k = ((EditVideoParams.EditSource)localObject1).b();
      str = ((EditVideoParams.EditSource)localObject1).a();
      f = ((EditVideoParams.EditSource)localObject1).a() * 1.0F / ((EditVideoParams.EditSource)localObject1).b();
      if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter == null) || (this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoFilter.a() != 5)) {
        break label277;
      }
    }
    label277:
    for (boolean bool = true;; bool = false)
    {
      localbkld.jdField_a_of_type_Bkll = new bkll((Activity)localObject2, j, k, str, f, bool, i, 0.0D, 0.0D, "", false);
      localObject1 = this.jdField_a_of_type_Bjxn.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((bjxl)((Iterator)localObject1).next()).a(0, localbkld);
      }
      if (!(localObject1 instanceof EditTakeVideoSource)) {
        break;
      }
      i = ((EditTakeVideoSource)localObject1).a.rotation;
      break;
    }
    ved.d("EditVideoSave", "PUBLISH start ...");
    a(ajya.a(2131703718), false, 0);
    a(2);
    Object localObject2 = Stream.of(localbkld).map(new ThreadOffFunction("EditVideoSave", 2)).map(new bkli());
    localObject1 = localObject2;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt != null) {
      localObject1 = ((Stream)localObject2).map(this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjvt.a(0));
    }
    localObject2 = localObject1;
    if (this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjuy != null) {
      localObject2 = ((Stream)localObject1).map(this.jdField_a_of_type_Bjxn.jdField_a_of_type_Bjuy.a(0));
    }
    ((Stream)localObject2).map(new bklr()).map(new bkly(this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams)).map(new UIThreadOffFunction(this)).subscribe(new bjyf(this, localbkld));
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bcpu == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Bcpu.a();
      this.jdField_a_of_type_Bcpu.c(paramInt);
      this.jdField_a_of_type_Bcpu.b(true);
      this.jdField_a_of_type_Bcpu.d(false);
      this.jdField_a_of_type_Bcpu.a(String.valueOf(paramInt) + "%");
    } while (!QLog.isColorLevel());
    QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.jdField_a_of_type_Bcpu.a() + ", progress:" + paramInt);
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
      this.jdField_a_of_type_Bjxn.a(0);
      this.jdField_a_of_type_Boolean = true;
      if (paramInt2 == -1)
      {
        a(100);
        this.jdField_a_of_type_Bjyv.a().postDelayed(new EditVideoSave.1(this, paramInt1, paramIntent), 500L);
        return;
      }
      if (paramInt2 == 1)
      {
        j();
        if (paramInt1 == 222) {}
        for (StringBuilder localStringBuilder = new StringBuilder(ajya.a(2131703893));; localStringBuilder = new StringBuilder(ajya.a(2131703747)))
        {
          if ((paramIntent != null) && (paramIntent.getStringExtra("error") != null)) {
            localStringBuilder.append(": ").append(paramIntent.getStringExtra("error"));
          }
          bcql.a(this.jdField_a_of_type_Bjyv.a(), 1, localStringBuilder, 0).a();
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131561434);
      localObject = (ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371995);
      this.jdField_a_of_type_Bcpu = a();
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_Bcpu);
    }
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370452)).setText(paramString);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(paramBoolean);
    this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(paramBoolean);
    this.jdField_a_of_type_Bcpu.c(0);
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
    if ((this.jdField_a_of_type_Bjxn.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a instanceof EditRecordVideoSource))
    {
      k();
      return;
    }
    l();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Bjyv == null) {
      return;
    }
    this.jdField_a_of_type_Bjyv.a().postDelayed(new EditVideoSave.5(this), 1000L);
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
 * Qualified Name:     bjyd
 * JD-Core Version:    0.7.0.1
 */