import com.tencent.TMG.sdk.AVVideoCtrl.RemoteVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.2.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class amsp
  extends AVVideoCtrl.RemoteVideoPreviewCallback
{
  amsp(amsn paramamsn) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = anbd.a(amsm.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ande)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.2.1(this, paramVideoFrame, (ApolloSurfaceView)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsp
 * JD-Core Version:    0.7.0.1
 */