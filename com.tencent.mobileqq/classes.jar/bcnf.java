import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class bcnf
  extends bghn
{
  bcnf(bcne parambcne, bggs parambggs, AppRuntime paramAppRuntime, int paramInt)
  {
    super(parambggs, paramAppRuntime, paramInt);
  }
  
  protected void a(ETTextView paramETTextView, ga paramga, float paramFloat)
  {
    paramETTextView.setTextSize(0, paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("AlphabeticFontHelper", 2, "handleAlphabeticFont set textSize: " + paramFloat);
    }
    super.a(paramETTextView, paramga, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnf
 * JD-Core Version:    0.7.0.1
 */