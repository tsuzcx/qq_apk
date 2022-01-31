import com.tencent.qphone.base.util.QLog;

class bhlx
  implements bhmd
{
  bhlx(bhlw parambhlw) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + paramFloat);
    }
    bhlw.a(this.a, paramFloat);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + paramBoolean);
    }
    if (paramBoolean)
    {
      bhlw.a(this.a, 3);
      this.a.b();
      return;
    }
    bhlw.a(this.a, 2);
    this.a.a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhlx
 * JD-Core Version:    0.7.0.1
 */