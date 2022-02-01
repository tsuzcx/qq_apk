import com.tencent.qphone.base.util.QLog;

class blmh
  implements bhhk
{
  blmh(blmd paramblmd) {}
  
  public void onProgressChanged(bhhi parambhhi, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(bhhi parambhhi)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListLogicAECircle", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + parambhhi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmh
 * JD-Core Version:    0.7.0.1
 */