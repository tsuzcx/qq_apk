import com.tencent.qphone.base.util.QLog;

class bnxu
  implements bnpq
{
  public void a(bnpf parambnpf, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    bnxt.a().a(parambnpf.a, paramInt);
  }
  
  public void a(bnpf parambnpf, boolean paramBoolean)
  {
    if (parambnpf == null) {
      return;
    }
    parambnpf.f = false;
    if (paramBoolean) {
      parambnpf.e = true;
    }
    for (;;)
    {
      bnxt.a().a(parambnpf, paramBoolean);
      bnxt.a(bnxt.a(), parambnpf.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + parambnpf.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxu
 * JD-Core Version:    0.7.0.1
 */