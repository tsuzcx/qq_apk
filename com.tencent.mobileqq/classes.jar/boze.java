import com.tencent.qphone.base.util.QLog;

class boze
  implements borc
{
  public void a(boqu paramboqu, int paramInt)
  {
    if (paramInt <= 1) {
      return;
    }
    bozd.a().a(paramboqu.a, paramInt);
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    if (paramboqu == null) {
      return;
    }
    paramboqu.f = false;
    if (paramBoolean) {
      paramboqu.e = true;
    }
    for (;;)
    {
      bozd.a().a(paramboqu, paramBoolean);
      bozd.a(bozd.a(), paramboqu.a);
      return;
      QLog.e("PlayDownloadManagerWrap", 1, "download failed with id: " + paramboqu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boze
 * JD-Core Version:    0.7.0.1
 */