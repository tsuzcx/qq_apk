import android.media.MediaFormat;
import com.tencent.biz.qqstory.utils.ffmpeg.QimSegmentMergeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.tencent.mobileqq.shortvideo.util.VidUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class amsh
  implements Runnable
{
  public amsh(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, List paramList) {}
  
  public void run()
  {
    QimSegmentMergeUtil localQimSegmentMergeUtil = new QimSegmentMergeUtil();
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = new CameraCaptureView.VideoCaptureResult();
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (CameraCaptureView.VideoCaptureResult)((Iterator)localObject1).next();
      localArrayList1.add(((CameraCaptureView.VideoCaptureResult)localObject2).videoMp4FilePath);
      if (!((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath.endsWith("/noaudio")) {
        localArrayList2.add(((CameraCaptureView.VideoCaptureResult)localObject2).audioDataFilePath);
      }
      CameraCaptureView.VideoCaptureResult localVideoCaptureResult = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
      int i = localVideoCaptureResult.videoFrameCount;
      localVideoCaptureResult.videoFrameCount = (((CameraCaptureView.VideoCaptureResult)localObject2).videoFrameCount + i);
    }
    if (this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a() != null)
    {
      localObject2 = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a() + "/" + System.currentTimeMillis() + ".mp4";
      if (localArrayList2.size() != this.jdField_a_of_type_JavaUtilList.size()) {
        break label484;
      }
      localObject1 = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a() + File.separator + "audio_data_cache" + File.separator + VidUtil.a();
      localQimSegmentMergeUtil.a(localArrayList2, (String)localObject1);
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath = ((String)localObject1);
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath = ((String)localObject2);
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.type = ((CameraCaptureView.VideoCaptureResult)this.jdField_a_of_type_JavaUtilList.get(0)).type;
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.orientation = ((CameraCaptureView.VideoCaptureResult)this.jdField_a_of_type_JavaUtilList.get(0)).orientation;
      QIMCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit, new LocalMediaInfo());
      QIMCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit).path = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath;
      QIMCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit).mMimeType = "video";
      localObject1 = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a();
      if (localObject1 == null) {
        break label517;
      }
      bool = localQimSegmentMergeUtil.a(localArrayList1, (String)localObject2, 0, 0, (MediaFormat)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("VERSION_CODES", 2, "[segmentCapture] onSegmentVideoCaptured segment video merge result: " + bool);
      }
      MediaScanner.a(BaseApplicationImpl.getContext()).a(new amsi(this), QIMCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit));
    }
    label484:
    while (!QLog.isColorLevel())
    {
      boolean bool;
      return;
      localObject1 = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a() + "/noaudio";
      FileUtils.c((String)localObject1);
      break;
    }
    label517:
    QLog.e("VERSION_CODES", 2, "[segmentCapture]onSegmentVideoCaptured mediaFormat null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amsh
 * JD-Core Version:    0.7.0.1
 */