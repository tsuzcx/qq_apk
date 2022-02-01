import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.view.AECompoundButton;

class blth
  implements Observer<Boolean>
{
  blth(bltd parambltd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    bmbx.a("AEVideoStoryTopBarPart", "【抠背开关】-> observe ->更新按钮状态:" + paramBoolean);
    if (paramBoolean == null) {
      return;
    }
    bltd.f(this.a).setSelected(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blth
 * JD-Core Version:    0.7.0.1
 */