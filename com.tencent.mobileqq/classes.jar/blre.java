import com.tencent.qphone.base.util.QLog;

class blre
  implements blrf
{
  blre(blrc paramblrc) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, bmrn parambmrn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "preload:" + paramString + " item:" + parambmrn.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blre
 * JD-Core Version:    0.7.0.1
 */