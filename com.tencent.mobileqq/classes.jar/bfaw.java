import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class bfaw
  implements ValueCallback
{
  bfaw(bfav parambfav) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!TextUtils.isEmpty(bfav.a(this.a))) && (bfav.a(this.a).contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this.a.a);
    }
    this.a.a.a(bfau.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfaw
 * JD-Core Version:    0.7.0.1
 */