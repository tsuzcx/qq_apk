import com.tencent.qphone.base.util.QLog;

class bjgp
  implements bjgv
{
  bjgp(bjgo parambjgo) {}
  
  public void a(float paramFloat, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onUpdateProgress, progress is : " + paramFloat);
    }
    bjgo.a(this.a, paramFloat);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QComboDText", 2, "CaptureComboText onDownloadFinish, success: " + paramBoolean);
    }
    if (paramBoolean)
    {
      bjgo.a(this.a, 3);
      this.a.b();
      return;
    }
    bjgo.a(this.a, 2);
    this.a.a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgp
 * JD-Core Version:    0.7.0.1
 */