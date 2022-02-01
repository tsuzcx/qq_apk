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
import java.util.List;

@TargetApi(14)
public class bqcb
  extends bqgi
  implements bqgu, brli, brlj, xuh, xvt
{
  protected int a;
  public ImageView a;
  protected TextView a;
  protected bqst a;
  protected TrimTextureVideoView a;
  protected String a;
  protected boolean a;
  protected bqce[] a;
  protected int b;
  protected boolean b;
  
  public int a()
  {
    return 0;
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBqce.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    bqce localbqce = this.jdField_a_of_type_ArrayOfBqce[paramInt];
    return localbqce.jdField_b_of_type_Int - localbqce.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBqce.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    bqce localbqce = this.jdField_a_of_type_ArrayOfBqce[paramInt];
    if (localbqce.c.isRecycled()) {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localbqce.c;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public List<? extends bqix> a()
  {
    bqce[] arrayOfbqce = new bqce[this.jdField_a_of_type_ArrayOfBqce.length];
    int i = 0;
    while (i < arrayOfbqce.length)
    {
      arrayOfbqce[i] = bqce.a(this.jdField_a_of_type_ArrayOfBqce[i], a(this.jdField_a_of_type_ArrayOfBqce[i].c));
      i += 1;
    }
    return Arrays.asList(arrayOfbqce);
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_Bqgk.a.d()) || (!this.jdField_a_of_type_Bqgk.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bqgk.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    int n = this.jdField_a_of_type_Bqgk.a.d();
    this.jdField_a_of_type_ArrayOfBqce = new bqce[n];
    yuk.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int j = k;
    int i = 0;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfBqce[i] = new bqce(i, null);
      bqce localbqce = this.jdField_a_of_type_ArrayOfBqce[i];
      localbqce.jdField_a_of_type_Int = j;
      localbqce.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localbqce.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)a(2131366869));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131365109));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376088));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (bqyp.a != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      localObject = bqyp.a;
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bqgk.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_Bqgk.a.a("extra_upload_temp_directory");
    this.jdField_a_of_type_Bqst = new bqst();
    this.jdField_a_of_type_Bqst.a(null);
    this.jdField_a_of_type_Bqst.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, false, new bqcc(this), new bqcd(this));
    a(bqgu.class, this);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    if ((parambqua.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfBqce[paramInt] + ",mNeedRotate=" + this.jdField_b_of_type_Boolean);
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfBqce[paramInt].jdField_a_of_type_Int;
      parambqua.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfBqce[paramInt].jdField_b_of_type_Int;
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.seekTo((int)paramLong);
    }
  }
  
  public void a(Bitmap paramBitmap) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void a(TransferData paramTransferData) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ArrayOfBqce[this.jdField_a_of_type_Bqgk.a()].jdField_a_of_type_Boolean = paramBoolean;
    b(false);
  }
  
  public boolean a(long paramLong)
  {
    return false;
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
    int i;
    if (paramMessage.what == 6)
    {
      i = paramMessage.arg2;
      if ((this.jdField_a_of_type_ArrayOfBqce == null) || (i >= this.jdField_a_of_type_ArrayOfBqce.length) || (this.jdField_a_of_type_ArrayOfBqce[i].jdField_b_of_type_Boolean))
      {
        yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfBqce), Integer.valueOf(i) });
        return false;
      }
      b(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfBqce == null) || (i >= this.jdField_a_of_type_ArrayOfBqce.length))
      {
        yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfBqce), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfBqce[i].jdField_b_of_type_Boolean = true;
      yuk.b("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
  }
  
  public void aY_()
  {
    super.aY_();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    switch (paramInt)
    {
    case 6: 
    case 10: 
    case 2: 
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      b(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void a_(xvo paramxvo)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    yuk.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_Bqgk.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void b()
  {
    bqch localbqch = (bqch)a(bqch.class);
    if (localbqch != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localbqch.b();
    }
  }
  
  public void b(int paramInt) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.seekTo((int)paramLong);
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    int i = this.jdField_a_of_type_Bqgk.a();
    if ((this.jdField_a_of_type_ArrayOfBqce == null) || (i >= this.jdField_a_of_type_ArrayOfBqce.length) || (this.jdField_a_of_type_ArrayOfBqce[i].jdField_b_of_type_Boolean))
    {
      yuk.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfBqce), Integer.valueOf(i) });
      return;
    }
    bqce localbqce = this.jdField_a_of_type_ArrayOfBqce[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setPlayRange(localbqce.jdField_a_of_type_Int, localbqce.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbqce.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbqce.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
  }
  
  public void c() {}
  
  public void d() {}
  
  public void f()
  {
    super.f();
    b(false);
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Bqst.a();
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_a_of_type_Bqgk.a(Message.obtain(null, 8));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
  }
  
  public void l()
  {
    b(true);
  }
  
  public void y_()
  {
    super.y_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqcb
 * JD-Core Version:    0.7.0.1
 */