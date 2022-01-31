import com.tencent.qphone.base.util.QLog;

class bizg
  implements birp
{
  public void a(bire parambire, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    bizf.a().a(parambire.a, paramInt);
  }
  
  public void a(bire parambire, boolean paramBoolean)
  {
    if (parambire == null) {
      return;
    }
    parambire.e = false;
    if (paramBoolean) {
      parambire.d = true;
    }
    for (;;)
    {
      bizf.a().a(parambire, paramBoolean);
      bizf.a(bizf.a(), parambire.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambire.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizg
 * JD-Core Version:    0.7.0.1
 */