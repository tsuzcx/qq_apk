import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoPlayer.3;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.util.Arrays;

@TargetApi(14)
public class borx
  extends botu
  implements boud, bpui, bpuj, xkn, xlz
{
  protected int a;
  public ImageView a;
  protected TextView a;
  protected bpdt a;
  protected TrimTextureVideoView a;
  protected String a;
  protected boolean a;
  protected bosa[] a;
  protected int b;
  protected boolean b;
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBosa.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    bosa localbosa = this.jdField_a_of_type_ArrayOfBosa[paramInt];
    if (localbosa.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localbosa.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_Botw.a.d()) || (!this.jdField_a_of_type_Botw.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_Botw.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    int n = this.jdField_a_of_type_Botw.a.d();
    this.jdField_a_of_type_ArrayOfBosa = new bosa[n];
    ykq.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int j = k;
    int i = 0;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfBosa[i] = new bosa(i, null);
      bosa localbosa = this.jdField_a_of_type_ArrayOfBosa[i];
      localbosa.jdField_a_of_type_Int = j;
      localbosa.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localbosa.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)a(2131367011));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365221));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376102));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (bpij.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      localObject = bpij.jdField_a_of_type_AndroidGraphicsBitmap;
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Botw.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_Botw.a.a("extra_upload_temp_directory");
    this.jdField_a_of_type_Bpdt = new bpdt();
    this.jdField_a_of_type_Bpdt.a(null);
    this.jdField_a_of_type_Bpdt.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, false, new bory(this), new borz(this));
    a(boud.class, this);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, @NonNull bpel parambpel)
  {
    if ((parambpel.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      ykq.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfBosa[paramInt] + ",mNeedRotate=" + this.jdField_b_of_type_Boolean);
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfBosa[paramInt].jdField_a_of_type_Int;
      parambpel.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfBosa[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    }
    b(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfBosa[this.jdField_a_of_type_Botw.a()].jdField_a_of_type_Boolean = paramBoolean;
    b(false);
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 3)
    {
      switch (paramMessage.arg1)
      {
      default: 
        return true;
      case 1: 
        b(false);
        return true;
      case 2: 
        this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
        return true;
      }
      b(true);
      return true;
    }
    return false;
  }
  
  public void aG_()
  {
    b(true);
  }
  
  public void aH_()
  {
    super.aH_();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void aI_()
  {
    super.aI_();
    b(false);
  }
  
  public void a_(xlu paramxlu)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    ykq.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_Botw.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void b()
  {
    bosc localbosc = (bosc)a(bosc.class);
    if (localbosc != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localbosc.b();
    }
  }
  
  public void b(int paramInt) {}
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_Botw.a();
    if ((this.jdField_a_of_type_ArrayOfBosa == null) || (i >= this.jdField_a_of_type_ArrayOfBosa.length) || (this.jdField_a_of_type_ArrayOfBosa[i].jdField_b_of_type_Boolean))
    {
      ykq.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfBosa), Integer.valueOf(i) });
      return;
    }
    bosa localbosa = this.jdField_a_of_type_ArrayOfBosa[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setPlayRange(localbosa.jdField_a_of_type_Int, localbosa.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbosa.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbosa.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bpdt.a();
  }
  
  public void i() {}
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Botw.a(Message.obtain(null, 8));
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borx
 * JD-Core Version:    0.7.0.1
 */