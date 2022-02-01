import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class amlj
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  amlj(amli paramamli) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = amwn.a(amlh.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((amyo)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlj
 * JD-Core Version:    0.7.0.1
 */