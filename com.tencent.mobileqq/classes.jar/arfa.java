import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;

public class arfa
  implements arfk
{
  public arfa(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void a(boolean paramBoolean)
  {
    int k = 1;
    IVPluginDataReporter localIVPluginDataReporter;
    int j;
    if (!bbev.a(GroupVideoLoadingFragment.a(this.a)))
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
        argi.b("2880338");
        break;
        GroupVideoLoadingFragment.a(this.a, false);
      }
      j = 0;
      break label50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arfa
 * JD-Core Version:    0.7.0.1
 */