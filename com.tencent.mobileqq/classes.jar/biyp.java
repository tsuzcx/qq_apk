import com.tencent.qphone.base.util.QLog;

class biyp
  implements biqy
{
  public void a(biqn parambiqn, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    biyo.a().a(parambiqn.a, paramInt);
  }
  
  public void a(biqn parambiqn, boolean paramBoolean)
  {
    if (parambiqn == null) {
      return;
    }
    parambiqn.e = false;
    if (paramBoolean) {
      parambiqn.d = true;
    }
    for (;;)
    {
      biyo.a().a(parambiqn, paramBoolean);
      biyo.a(biyo.a(), parambiqn.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambiqn.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biyp
 * JD-Core Version:    0.7.0.1
 */