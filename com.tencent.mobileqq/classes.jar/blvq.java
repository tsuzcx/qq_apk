import com.tencent.qphone.base.util.QLog;

class blvq
  implements blvr
{
  blvq(blvo paramblvo) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, bmvz parambmvz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "preload:" + paramString + " item:" + parambmvz.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvq
 * JD-Core Version:    0.7.0.1
 */