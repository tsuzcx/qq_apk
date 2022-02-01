import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.utils.NetworkUtil;

public class avsr
  implements avtb
{
  public avsr(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(boolean paramBoolean)
  {
    int k = 1;
    IVPluginDataReporter localIVPluginDataReporter;
    int j;
    if (!NetworkUtil.isWifiEnabled(GroupVideoLoadingFragment.a(this.a)))
    {
      i = 1;
      if (!paramBoolean) {
        break label80;
      }
      GroupVideoLoadingFragment.a(this.a, false);
      localIVPluginDataReporter = GroupVideoLoadingFragment.a(this.a).opType("enterPage");
      if (!paramBoolean) {
        break label111;
      }
      j = 1;
      label50:
      localIVPluginDataReporter = localIVPluginDataReporter.opIn(j);
      if (i == 0) {
        break label116;
      }
    }
    label80:
    label111:
    label116:
    for (int i = k;; i = 0)
    {
      localIVPluginDataReporter.opResult(i).report();
      return;
      i = 0;
      break;
      if (i != 0) {
        GroupVideoLoadingFragment.a(this.a, true);
      }
      for (;;)
      {
        avue.b("2880338");
        break;
        GroupVideoLoadingFragment.a(this.a, false);
      }
      j = 0;
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsr
 * JD-Core Version:    0.7.0.1
 */