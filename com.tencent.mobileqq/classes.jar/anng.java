import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWLog;
import dov.com.tencent.biz.qqstory.takevideo.rmw.RMWService;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import dov.com.tencent.mobileqq.shortvideo.util.FileFFmpegUtils;
import java.io.File;

public class anng
  extends Thread
{
  public anng(RMWService paramRMWService) {}
  
  public void run()
  {
    RMWLog.a("RMWService", "preload AVCodec - start -");
    if (!new File(FileFFmpegUtils.a(VideoEnvironment.a())).exists())
    {
      RMWLog.a("RMWService", "check no ffmpeg file, recopy AVCodec - start -");
      VideoEnvironment.a(2131230759, 2131230760);
      RMWLog.a("RMWService", "check no ffmpeg file, recopy AVCodec - end -");
    }
    VideoEnvironment.a("AVCodec", null, true);
    RMWLog.a("RMWService", "preload AVCodec - end -");
    RMWLog.a("RMWService", "preload PtvFilterSoLoad - start -");
    if (QLog.isColorLevel()) {
      QLog.d(".photo", 2, "RMWService onCreate");
    }
    PtvFilterSoLoad.a(VideoEnvironment.a(), false);
    RMWLog.a("RMWService", "preload PtvFilterSoLoad - end -");
    RMWLog.a("RMWService", "preload GraphicRenderMgr loadSo - end -");
    GraphicRenderMgr.loadSo();
    RMWLog.a("RMWService", "preload GraphicRenderMgr loadSo - end -");
    RMWLog.a("RMWService", "preInit DoodleEmojiManager - start -");
    ((DoodleEmojiManager)SuperManager.a(36)).a(this.a);
    RMWLog.a("RMWService", "preInit DoodleEmojiManager - end -");
    RMWLog.a("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    HwEnvData.a();
    RMWLog.a("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    RMWLog.a("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    VcSystemInfo.a();
    RMWLog.a("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anng
 * JD-Core Version:    0.7.0.1
 */