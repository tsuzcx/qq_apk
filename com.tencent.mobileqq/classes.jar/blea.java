import com.tencent.qphone.base.util.QLog;

class blea
  implements bkwg
{
  public void a(bkvu parambkvu, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    bldz.a().a(parambkvu.a, paramInt);
  }
  
  public void a(bkvu parambkvu, boolean paramBoolean)
  {
    if (parambkvu == null) {
      return;
    }
    parambkvu.e = false;
    if (paramBoolean) {
      parambkvu.d = true;
    }
    for (;;)
    {
      bldz.a().a(parambkvu, paramBoolean);
      bldz.a(bldz.a(), parambkvu.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambkvu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blea
 * JD-Core Version:    0.7.0.1
 */