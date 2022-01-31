import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti.AVCustomData;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.qphone.base.util.QLog;

class bgjy
  implements AVRoomMulti.EventListener
{
  bgjy(bgjx parambgjx) {}
  
  public void onCameraSettingNotify(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onDisableAudioIssue() {}
  
  public void onEndpointsUpdateInfo(int paramInt, String[] paramArrayOfString)
  {
    QLog.i("AVManager", 1, String.format("onEndpointsUpdateInfo|eventid=%d", new Object[] { Integer.valueOf(paramInt) }));
    if (this.a.jdField_a_of_type_Bgkb != null) {
      this.a.jdField_a_of_type_Bgkb.a(paramInt, paramArrayOfString);
    }
  }
  
  public void onEnterRoomComplete(int paramInt, String paramString)
  {
    QLog.i("AVManager", 1, "mRoomEventListener.onEnterRoomComplete| result = " + paramInt + paramString);
    if (paramInt != 0) {
      this.a.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().stopTRAEService();
    }
    if (this.a.jdField_a_of_type_Bgka != null) {
      this.a.jdField_a_of_type_Bgka.a(paramInt, paramString);
    }
  }
  
  public void onExitRoomComplete()
  {
    QLog.i("AVManager", 1, "mRoomEventListener.onExitRoomComplete");
    this.a.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().stopTRAEService();
    if (this.a.jdField_a_of_type_Bgkb != null) {
      this.a.jdField_a_of_type_Bgkb.a();
    }
  }
  
  public void onHwStateChangeNotify(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void onPrivilegeDiffNotify(int paramInt) {}
  
  public void onRecvCustomData(AVRoomMulti.AVCustomData paramAVCustomData, String paramString) {}
  
  public void onRoomDisconnect(int paramInt, String paramString)
  {
    if (this.a.jdField_a_of_type_Bgkb != null) {
      this.a.jdField_a_of_type_Bgkb.a(paramInt, paramString);
    }
  }
  
  public void onRoomEvent(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void onSemiAutoRecvCameraVideo(String[] paramArrayOfString)
  {
    QLog.i("AVManager", 1, String.format("onSemiAutoRecvCameraVideo", new Object[0]));
    if (this.a.jdField_a_of_type_Bgkb != null) {
      this.a.jdField_a_of_type_Bgkb.a(paramArrayOfString);
    }
  }
  
  public void onSemiAutoRecvMediaFileVideo(String[] paramArrayOfString) {}
  
  public void onSemiAutoRecvScreenVideo(String[] paramArrayOfString) {}
  
  public void onSwitchRoomComplete(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjy
 * JD-Core Version:    0.7.0.1
 */