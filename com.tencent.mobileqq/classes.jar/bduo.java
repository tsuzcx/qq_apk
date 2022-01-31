import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class bduo
  implements ValueCallback
{
  bduo(bdun parambdun) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!TextUtils.isEmpty(bdun.a(this.a))) && (bdun.a(this.a).contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this.a.a);
    }
    this.a.a.a(bdum.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bduo
 * JD-Core Version:    0.7.0.1
 */