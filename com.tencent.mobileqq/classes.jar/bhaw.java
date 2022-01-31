import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class bhaw
  implements ValueCallback
{
  bhaw(bhav parambhav) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!TextUtils.isEmpty(bhav.a(this.a))) && (bhav.a(this.a).contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this.a.a);
    }
    this.a.a.a(bhau.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaw
 * JD-Core Version:    0.7.0.1
 */