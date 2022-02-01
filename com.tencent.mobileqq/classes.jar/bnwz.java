import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.ae.play.AbsAEPublishVideoProcessFragment;

public class bnwz
  implements TAVCut.Callback
{
  public bnwz(AbsAEPublishVideoProcessFragment paramAbsAEPublishVideoProcessFragment) {}
  
  public void onDone(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      bnzb.d("AbsAEPublishVideoProces", "初始化TAVCut失败：tavkit so库加载异常");
      return;
    case -2: 
      bnzb.d("AbsAEPublishVideoProces", "初始化TAVCut失败：pag so库加载异常");
      return;
    }
    bnzb.a("AbsAEPublishVideoProces", "初始化TAVCut成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnwz
 * JD-Core Version:    0.7.0.1
 */