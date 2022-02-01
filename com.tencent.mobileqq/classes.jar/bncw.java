import com.tencent.qphone.base.util.QLog;

class bncw
  implements bhhk
{
  bncw(bnct parambnct) {}
  
  public void onProgressChanged(bhhi parambhhi, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(bhhi parambhhi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditPicSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + parambhhi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncw
 * JD-Core Version:    0.7.0.1
 */