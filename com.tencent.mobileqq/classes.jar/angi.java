import android.graphics.SurfaceTexture;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase.IVideoViewCallBack;
import java.nio.ByteBuffer;

public class angi
  implements IVideoViewBase
{
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private angj jdField_a_of_type_Angj;
  
  public angi(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
  }
  
  public void a(angj paramangj)
  {
    this.jdField_a_of_type_Angj = paramangj;
  }
  
  public void addViewCallBack(IVideoViewBase.IVideoViewCallBack paramIVideoViewCallBack)
  {
    QLog.d("AROnlineVideoView", 1, "addViewCallBack");
  }
  
  public void chooseDisplayView(int paramInt)
  {
    QLog.d("AROnlineVideoView", 1, "chooseDisplayView");
  }
  
  public void doCacheSurfaceTexture() {}
  
  public void doRecoverSurfaceTexture() {}
  
  public void doRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    QLog.d("AROnlineVideoView", 1, "doRotate");
  }
  
  public void drawFrame(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, boolean paramBoolean)
  {
    QLog.d("AROnlineVideoView", 1, "drawFrame-hardware");
  }
  
  public void drawFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    if (this.jdField_a_of_type_Angj != null) {
      this.jdField_a_of_type_Angj.a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean);
    }
  }
  
  public View getCurrentDisplayView()
  {
    QLog.d("AROnlineVideoView", 1, "getCurrentDisplayView");
    return null;
  }
  
  public Object getRenderObject()
  {
    QLog.d("AROnlineVideoView", 1, "getRenderObject");
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public String getSeriableNO()
  {
    QLog.d("AROnlineVideoView", 1, "getSeriableNO");
    return null;
  }
  
  public int getViewHeight()
  {
    QLog.d("AROnlineVideoView", 1, "getViewHeight, h=0");
    return 0;
  }
  
  public int getViewWidth()
  {
    QLog.d("AROnlineVideoView", 1, "getViewWidth, w=0");
    return 0;
  }
  
  public int getXOnScreen()
  {
    return 0;
  }
  
  public int getYOnScreen()
  {
    return 0;
  }
  
  public boolean isSurfaceReady()
  {
    QLog.d("AROnlineVideoView", 1, "isSurfaceReady");
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null;
  }
  
  public void onResume()
  {
    QLog.d("AROnlineVideoView", 1, "onResume");
  }
  
  public void removeViewCallBack(IVideoViewBase.IVideoViewCallBack paramIVideoViewCallBack)
  {
    QLog.d("AROnlineVideoView", 1, "removeViewCallBack");
  }
  
  public void resetView()
  {
    QLog.d("AROnlineVideoView", 1, "resetView");
  }
  
  public void setDegree(int paramInt)
  {
    QLog.d("AROnlineVideoView", 1, "setDegree");
  }
  
  public void setEnableAntDis(boolean paramBoolean)
  {
    QLog.d("AROnlineVideoView", 1, "setEnableAntDis");
  }
  
  public void setEnableVREyeControl(boolean paramBoolean)
  {
    QLog.d("AROnlineVideoView", 1, "setEnableVREyeControl");
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    QLog.d("AROnlineVideoView", 1, "setFixedSize");
  }
  
  public void setGypSensor(boolean paramBoolean)
  {
    QLog.d("AROnlineVideoView", 1, "setGypSensor");
  }
  
  public void setLogTag(String paramString) {}
  
  public void setRadio(int paramInt1, int paramInt2) {}
  
  public void setScaleParam(int paramInt1, int paramInt2, float paramFloat)
  {
    QLog.d("AROnlineVideoView", 1, "setScaleParam");
  }
  
  public void setSubtitleString(String paramString)
  {
    QLog.d("AROnlineVideoView", 1, "setSubtitleString");
  }
  
  public void setVREnable(boolean paramBoolean)
  {
    QLog.d("AROnlineVideoView", 1, "setVREnable");
  }
  
  public void setVrViewPattern(int paramInt)
  {
    QLog.d("AROnlineVideoView", 1, "setVrViewPattern");
  }
  
  public void setXYaxis(int paramInt)
  {
    QLog.d("AROnlineVideoView", 1, "setXYaxis");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angi
 * JD-Core Version:    0.7.0.1
 */