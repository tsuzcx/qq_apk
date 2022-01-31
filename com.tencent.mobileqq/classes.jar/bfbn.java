import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class bfbn
  implements ValueCallback
{
  bfbn(bfbm parambfbm) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!TextUtils.isEmpty(bfbm.a(this.a))) && (bfbm.a(this.a).contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this.a.a);
    }
    this.a.a.a(bfbl.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbn
 * JD-Core Version:    0.7.0.1
 */