import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

class bhfd
  implements ValueCallback
{
  bhfd(bhfc parambhfc) {}
  
  public void onReceiveValue(Object paramObject)
  {
    if ((!TextUtils.isEmpty(bhfc.a(this.a))) && (bhfc.a(this.a).contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs finish " + this.a.a);
    }
    this.a.a.a(bhfb.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhfd
 * JD-Core Version:    0.7.0.1
 */