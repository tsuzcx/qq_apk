import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary.RspBody.PhotoInfo;

public class bjaf
  extends anus
{
  private WeakReference<PhotoWallView> a;
  
  public bjaf(PhotoWallView paramPhotoWallView)
  {
    this.a = new WeakReference(paramPhotoWallView);
  }
  
  public void a(int paramInt, List<NowLiveGallary.RspBody.PhotoInfo> paramList)
  {
    if (this.a != null) {}
    for (PhotoWallView localPhotoWallView = (PhotoWallView)this.a.get();; localPhotoWallView = null)
    {
      if (localPhotoWallView == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay errorCode:" + paramInt);
        }
        localPhotoWallView.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoWallView", 2, "onGetNowOnliveGallay size:" + paramList.size());
      }
      localPhotoWallView.jdField_a_of_type_JavaUtilArrayList.clear();
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        Object localObject = (NowLiveGallary.RspBody.PhotoInfo)paramList.get(paramInt);
        localObject = new NowShowVideoInfo(((NowLiveGallary.RspBody.PhotoInfo)localObject).cover.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).video.get().toStringUtf8(), ((NowLiveGallary.RspBody.PhotoInfo)localObject).timestamp.get());
        localPhotoWallView.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        paramInt += 1;
      }
      if (localPhotoWallView.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        bdll.b((QQAppInterface)this.b.get(), "dc00899", "NOW", "", "qq_zlk", "replay_exp", 0, 0, localPhotoWallView.jdField_a_of_type_JavaLangString, "", "", "");
      }
      localPhotoWallView.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjaf
 * JD-Core Version:    0.7.0.1
 */