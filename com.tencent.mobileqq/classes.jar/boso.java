import com.tencent.qphone.base.util.QLog;

class boso
  implements bisc
{
  boso(bosl parambosl) {}
  
  public void onProgressChanged(bisa parambisa, int paramInt1, int paramInt2) {}
  
  public void onProgressCompleted(bisa parambisa)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditPicSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + parambisa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boso
 * JD-Core Version:    0.7.0.1
 */