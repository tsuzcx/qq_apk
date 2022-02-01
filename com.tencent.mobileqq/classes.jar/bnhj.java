import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.view.AECompoundButton;

class bnhj
  implements Observer<Boolean>
{
  bnhj(bnhf parambnhf) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    bnrh.a("AEVideoStoryTopBarPart", "【抠背开关】-> observe ->更新按钮状态:" + paramBoolean);
    if (paramBoolean == null) {
      return;
    }
    bnhf.f(this.a).setSelected(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhj
 * JD-Core Version:    0.7.0.1
 */