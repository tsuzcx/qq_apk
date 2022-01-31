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
public class bjte
  extends bjxl
  implements bjxx, bldm, bldn, uea, ufm
{
  protected int a;
  public ImageView a;
  protected TextView a;
  protected bkjw a;
  protected TrimTextureVideoView a;
  protected String a;
  protected boolean a;
  protected bjth[] a;
  protected int b;
  protected boolean b;
  
  public int a()
  {
    return 0;
  }
  
  public long a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBjth.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    bjth localbjth = this.jdField_a_of_type_ArrayOfBjth[paramInt];
    return localbjth.jdField_b_of_type_Int - localbjth.jdField_a_of_type_Int;
  }
  
  public Bitmap a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBjth.length)) {
      throw new IllegalArgumentException("getDurationOfFragment 传入了错误的index: " + paramInt);
    }
    bjth localbjth = this.jdField_a_of_type_ArrayOfBjth[paramInt];
    if (localbjth.c.isRecycled()) {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "自己的bitmap被外边recycle了!");
    }
    return localbjth.c;
  }
  
  protected Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createBitmap(paramBitmap);
  }
  
  public List<? extends bkaa> a()
  {
    bjth[] arrayOfbjth = new bjth[this.jdField_a_of_type_ArrayOfBjth.length];
    int i = 0;
    while (i < arrayOfbjth.length)
    {
      arrayOfbjth[i] = bjth.a(this.jdField_a_of_type_ArrayOfBjth[i], a(this.jdField_a_of_type_ArrayOfBjth[i].c));
      i += 1;
    }
    return Arrays.asList(arrayOfbjth);
  }
  
  public void a()
  {
    super.a();
    if ((!this.jdField_a_of_type_Bjxn.a.d()) || (!this.jdField_a_of_type_Bjxn.a.b())) {
      return;
    }
    Object localObject = (EditLocalVideoSource)this.jdField_a_of_type_Bjxn.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource;
    int k = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    int m = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    int n = this.jdField_a_of_type_Bjxn.a.d();
    this.jdField_a_of_type_ArrayOfBjth = new bjth[n];
    ved.a("Q.qqstory.record.EditLocalVideoPlayer", "onCreate EditSource fragmentCount is %d", Integer.valueOf(n));
    int j = k;
    int i = 0;
    while (i < n)
    {
      this.jdField_a_of_type_ArrayOfBjth[i] = new bjth(i, null);
      bjth localbjth = this.jdField_a_of_type_ArrayOfBjth[i];
      localbjth.jdField_a_of_type_Int = j;
      localbjth.jdField_b_of_type_Int = Math.min(j + 10000, m);
      if (i == n - 1) {
        localbjth.jdField_b_of_type_Int = m;
      }
      j += 10000;
      i += 1;
    }
    this.jdField_a_of_type_Int = ((EditLocalVideoSource)localObject).jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = ((EditLocalVideoSource)localObject).jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView = ((TrimTextureVideoView)a(2131366441));
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131364749));
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth, ((EditLocalVideoSource)localObject).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131374709));
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (bkpv.a != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a();
      localObject = bkpv.a;
      if (!bool) {
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      ved.b("Q.qqstory.record.EditLocalVideoPlayer", "onCreate mBackgroundImage.setImageBitmap()");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnRecyclePlayListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setOnPreparedListener(this);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bjxn.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a();
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setVideoPath(this.jdField_a_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_Bjxn.a.a("extra_upload_temp_directory");
    this.jdField_a_of_type_Bkjw = new bkjw();
    this.jdField_a_of_type_Bkjw.a(null);
    this.jdField_a_of_type_Bkjw.a(this.jdField_a_of_type_JavaLangString, (String)localObject, this.jdField_b_of_type_Boolean, 480, k, 10000, n, false, new bjtf(this), new bjtg(this));
    a(bjxx.class, this);
  }
  
  public void a(float paramFloat) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, float paramFloat) {}
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    if ((parambkld.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
    {
      parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hasFragments = true;
      ved.b("Q.qqstory.record.EditLocalVideoPlayer", "editVideoPrePublish(%d) -> %s", Integer.valueOf(paramInt), this.jdField_a_of_type_ArrayOfBjth[paramInt] + ",mNeedRotate=" + this.jdField_b_of_type_Boolean);
      parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoNeedRotate = this.jdField_b_of_type_Boolean;
      parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeStart = this.jdField_a_of_type_ArrayOfBjth[paramInt].jdField_a_of_type_Int;
      parambkld.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoRangeEnd = this.jdField_a_of_type_ArrayOfBjth[paramInt].jdField_b_of_type_Int;
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
    this.jdField_a_of_type_ArrayOfBjth[this.jdField_a_of_type_Bjxn.a()].jdField_a_of_type_Boolean = paramBoolean;
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
      if ((this.jdField_a_of_type_ArrayOfBjth == null) || (i >= this.jdField_a_of_type_ArrayOfBjth.length) || (this.jdField_a_of_type_ArrayOfBjth[i].jdField_b_of_type_Boolean))
      {
        ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfBjth), Integer.valueOf(i) });
        return false;
      }
      b(true);
      return true;
    }
    if (paramMessage.what == 7)
    {
      i = paramMessage.arg1;
      if ((this.jdField_a_of_type_ArrayOfBjth == null) || (i >= this.jdField_a_of_type_ArrayOfBjth.length))
      {
        ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! PlayerContext is illegal %s index=%d", new Object[] { Arrays.toString(this.jdField_a_of_type_ArrayOfBjth), Integer.valueOf(i) });
        return false;
      }
      this.jdField_a_of_type_ArrayOfBjth[i].jdField_b_of_type_Boolean = true;
      ved.b("Q.qqstory.record.EditLocalVideoPlayer", "PlayerContext %d Deleted!", Integer.valueOf(i));
      return true;
    }
    return false;
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
  
  public void a_(ufh paramufh)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new EditLocalVideoPlayer.3(this), 300L);
    }
    ved.a("Q.qqstory.record.EditLocalVideoPlayer", "onPrepared %s", this.jdField_a_of_type_Bjxn.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
    this.jdField_a_of_type_Boolean = true;
    b(true);
  }
  
  public void b()
  {
    bjtk localbjtk = (bjtk)a(bjtk.class);
    if (localbjtk != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onPlayRecycle()");
      }
      localbjtk.b();
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
    int i = this.jdField_a_of_type_Bjxn.a();
    if ((this.jdField_a_of_type_ArrayOfBjth == null) || (i >= this.jdField_a_of_type_ArrayOfBjth.length) || (this.jdField_a_of_type_ArrayOfBjth[i].jdField_b_of_type_Boolean))
    {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Error! resumePlay(%b): PlayerContext is illegal %s index=%d", new Object[] { Boolean.valueOf(paramBoolean), Arrays.toString(this.jdField_a_of_type_ArrayOfBjth), Integer.valueOf(i) });
      return;
    }
    bjth localbjth = this.jdField_a_of_type_ArrayOfBjth[i];
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.setPlayRange(localbjth.jdField_a_of_type_Int, localbjth.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbjth.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.b(localbjth.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.a(false);
  }
  
  public void ba_()
  {
    super.ba_();
    if (this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryBoundariesExtensionWidgetsTrimTextureVideoView.c();
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
    this.jdField_a_of_type_Bkjw.a();
  }
  
  public void i() {}
  
  public void j()
  {
    this.jdField_a_of_type_Bjxn.a(Message.obtain(null, 8));
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
  
  public void z_()
  {
    super.z_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjte
 * JD-Core Version:    0.7.0.1
 */