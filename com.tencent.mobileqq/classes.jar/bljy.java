import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import java.util.ArrayList;

public final class bljy
  implements yvz
{
  public bljy(FrameVideoHelper paramFrameVideoHelper, yvz paramyvz) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    blfg.b("AEEditorMusicHelper", "[extractFrameForSmartMusic], onResult(), isSuccess=" + paramBoolean + ", dataArray=" + paramArrayList + ", frameSize=" + paramLong);
    int i;
    if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[extractFrameForSmartMusic], executeTime=").append(this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a()).append(", frameCount=");
      if (paramArrayList == null)
      {
        i = 0;
        blfg.a("AEEditorMusicHelper", i + ", size=" + this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.b() + "KB");
      }
    }
    else if (this.jdField_a_of_type_Yvz != null)
    {
      if (paramArrayList != null) {
        break label169;
      }
    }
    label169:
    for (paramArrayList = null;; paramArrayList = new ArrayList(paramArrayList))
    {
      this.jdField_a_of_type_Yvz.a(paramBoolean, paramArrayList, paramLong);
      if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper != null) {
        this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
      }
      return;
      i = paramArrayList.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljy
 * JD-Core Version:    0.7.0.1
 */