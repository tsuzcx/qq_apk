import android.content.Context;
import android.util.Log;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.logger.AVLoggerChooser;
import com.tencent.TMG.sdk.AVAudioCtrl;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableMicCompleteCallback;
import com.tencent.TMG.sdk.AVAudioCtrl.EnableSpeakerCompleteCallback;
import com.tencent.TMG.sdk.AVCallback;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam;
import com.tencent.TMG.sdk.AVRoomMulti.EnterParam.Builder;
import com.tencent.TMG.sdk.AVRoomMulti.EventListener;
import com.tencent.av.sig.QAVAuthBuffer;
import com.tencent.qphone.base.util.QLog;

public class bmdu
{
  private static bmdu jdField_a_of_type_Bmdu;
  private static String b = "LimixiuAVManager";
  private Context jdField_a_of_type_AndroidContentContext;
  bmdw jdField_a_of_type_Bmdw = null;
  bmdx jdField_a_of_type_Bmdx = null;
  bmdy jdField_a_of_type_Bmdy = null;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new bmdv(this);
  String jdField_a_of_type_JavaLangString = null;
  
  private bmdu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "user";
  }
  
  public static bmdu a(Context paramContext)
  {
    if (jdField_a_of_type_Bmdu == null) {}
    try
    {
      if (jdField_a_of_type_Bmdu == null) {
        jdField_a_of_type_Bmdu = new bmdu(paramContext);
      }
      return jdField_a_of_type_Bmdu;
    }
    finally {}
  }
  
  private AVContext.StartParam a()
  {
    bmdm localbmdm = new bmdm();
    localbmdm.sdkAppId = Integer.parseInt(this.jdField_a_of_type_Bmdw.jdField_a_of_type_JavaLangString);
    localbmdm.accountType = this.jdField_a_of_type_Bmdw.b;
    localbmdm.appIdAt3rd = this.jdField_a_of_type_Bmdw.jdField_a_of_type_JavaLangString;
    localbmdm.identifier = this.jdField_a_of_type_Bmdw.c;
    localbmdm.engineCtrlType = 2;
    localbmdm.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Bmdw.f).intValue();
    localbmdm.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_Bmdw.g).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localbmdm.sdkAppId + ", param.accountType=" + localbmdm.accountType + ", param.appIdAt3rd=" + localbmdm.appIdAt3rd + ", param.identifier=" + localbmdm.identifier + ", param.engineCtrlType=" + localbmdm.engineCtrlType + ", param.nGameID=" + localbmdm.jdField_a_of_type_Int + ", param.lGameRoomID=" + localbmdm.jdField_a_of_type_Long);
    return localbmdm;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.jdField_a_of_type_Bmdw.jdField_a_of_type_JavaLangString), Integer.parseInt(paramString), this.jdField_a_of_type_Bmdw.c, Integer.parseInt(this.jdField_a_of_type_Bmdw.b), this.jdField_a_of_type_Bmdw.d, 1800, -1);
    return new AVRoomMulti.EnterParam.Builder(Integer.parseInt(paramString)).auth(-1L, arrayOfByte).avControlRole("user").autoCreateRoom(true).videoRecvMode(0).screenRecvMode(0).isEnableMic(paramBoolean1).isEnableSpeaker(paramBoolean2).isEnableHwEnc(true).isEnableHwDec(true).build();
  }
  
  public int a()
  {
    int i = 1003;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      i = this.jdField_a_of_type_ComTencentTMGSdkAVContext.exitRoom();
    }
    QLog.i("AVManager", 1, "exitRoom|ret=" + i);
    return i;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(bmdw parambmdw)
  {
    this.jdField_a_of_type_Bmdw = parambmdw;
  }
  
  public void a(bmdy parambmdy)
  {
    this.jdField_a_of_type_Bmdy = parambmdy;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = bmeb.a();
    AVLoggerChooser.setUseImsdk(false);
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      this.jdField_a_of_type_ComTencentTMGSdkAVContext = AVContext.createInstance(this.jdField_a_of_type_AndroidContentContext, false);
    }
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null) {
      if (AVContext.getSoExtractError() != 0) {
        i = AVContext.getSoExtractError();
      }
    }
    for (;;)
    {
      QLog.i("AVManager", 1, "startContext|ret=" + i);
      if (i != 0) {
        paramAVCallback.onComplete(i, "internal error.");
      }
      return;
      i = 1101;
      continue;
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_Bmdw.e);
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, bmdx parambmdx)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_Bmdx = parambmdx;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_Bmdx != null) {
        this.jdField_a_of_type_Bmdx.a(1101, "context not started.");
      }
      return;
    }
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl().startTRAEService();
    QLog.e("AVManager", 1, "enterRoom| try enter room implement!!!!!!!!!");
    this.jdField_a_of_type_ComTencentTMGSdkAVContext.enterRoom(this.jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener, a(paramString, paramBoolean1, paramBoolean2, paramInt));
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableMicCompleteCallback paramEnableMicCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableMic(paramBoolean, paramEnableMicCompleteCallback);
    }
  }
  
  public void a(boolean paramBoolean, AVAudioCtrl.EnableSpeakerCompleteCallback paramEnableSpeakerCompleteCallback)
  {
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {
      localAVAudioCtrl.enableSpeaker(paramBoolean, paramEnableSpeakerCompleteCallback);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getMicState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b()
  {
    boolean bool = false;
    AVAudioCtrl localAVAudioCtrl = null;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext != null) {
      localAVAudioCtrl = this.jdField_a_of_type_ComTencentTMGSdkAVContext.getAudioCtrl();
    }
    if (localAVAudioCtrl != null) {}
    for (int i = localAVAudioCtrl.getSpeakerState();; i = 0)
    {
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdu
 * JD-Core Version:    0.7.0.1
 */