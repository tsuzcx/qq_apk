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

public class bltd
{
  private static bltd jdField_a_of_type_Bltd;
  private static String b = "LimixiuAVManager";
  private Context jdField_a_of_type_AndroidContentContext;
  bltf jdField_a_of_type_Bltf = null;
  bltg jdField_a_of_type_Bltg = null;
  blth jdField_a_of_type_Blth = null;
  AVContext jdField_a_of_type_ComTencentTMGSdkAVContext = null;
  private AVRoomMulti.EventListener jdField_a_of_type_ComTencentTMGSdkAVRoomMulti$EventListener = new blte(this);
  String jdField_a_of_type_JavaLangString = null;
  
  private bltd(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = "user";
  }
  
  public static bltd a(Context paramContext)
  {
    if (jdField_a_of_type_Bltd == null) {}
    try
    {
      if (jdField_a_of_type_Bltd == null) {
        jdField_a_of_type_Bltd = new bltd(paramContext);
      }
      return jdField_a_of_type_Bltd;
    }
    finally {}
  }
  
  private AVContext.StartParam a()
  {
    blsv localblsv = new blsv();
    localblsv.sdkAppId = Integer.parseInt(this.jdField_a_of_type_Bltf.jdField_a_of_type_JavaLangString);
    localblsv.accountType = this.jdField_a_of_type_Bltf.b;
    localblsv.appIdAt3rd = this.jdField_a_of_type_Bltf.jdField_a_of_type_JavaLangString;
    localblsv.identifier = this.jdField_a_of_type_Bltf.c;
    localblsv.engineCtrlType = 2;
    localblsv.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Bltf.f).intValue();
    localblsv.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_Bltf.g).longValue();
    QLog.i("AVManager", 1, "getStartParams|param.sdkAppId=" + localblsv.sdkAppId + ", param.accountType=" + localblsv.accountType + ", param.appIdAt3rd=" + localblsv.appIdAt3rd + ", param.identifier=" + localblsv.identifier + ", param.engineCtrlType=" + localblsv.engineCtrlType + ", param.nGameID=" + localblsv.jdField_a_of_type_Int + ", param.lGameRoomID=" + localblsv.jdField_a_of_type_Long);
    return localblsv;
  }
  
  private AVRoomMulti.EnterParam a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    byte[] arrayOfByte = QAVAuthBuffer.a().genAuthBuffer(Integer.parseInt(this.jdField_a_of_type_Bltf.jdField_a_of_type_JavaLangString), Integer.parseInt(paramString), this.jdField_a_of_type_Bltf.c, Integer.parseInt(this.jdField_a_of_type_Bltf.b), this.jdField_a_of_type_Bltf.d, 1800, -1);
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
  
  public void a(bltf parambltf)
  {
    this.jdField_a_of_type_Bltf = parambltf;
  }
  
  public void a(blth paramblth)
  {
    this.jdField_a_of_type_Blth = paramblth;
  }
  
  public void a(AVCallback paramAVCallback)
  {
    int i = 0;
    AVChannelManager.setIMChannelType(1);
    com.tencent.TMG.utils.SoUtil.customLibPath = bltk.a();
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
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.setAppVersion(this.jdField_a_of_type_Bltf.e);
      this.jdField_a_of_type_ComTencentTMGSdkAVContext.start(a(), null, paramAVCallback);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, bltg parambltg)
  {
    QLog.i("AVManager", 1, "enterRoom.");
    this.jdField_a_of_type_Bltg = parambltg;
    if (this.jdField_a_of_type_ComTencentTMGSdkAVContext == null)
    {
      Log.e("AVManager", "enterRoom| enter room faild, because of context not started.");
      if (this.jdField_a_of_type_Bltg != null) {
        this.jdField_a_of_type_Bltg.a(1101, "context not started.");
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
 * Qualified Name:     bltd
 * JD-Core Version:    0.7.0.1
 */