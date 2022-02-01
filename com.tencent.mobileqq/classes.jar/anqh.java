import com.tencent.qphone.base.util.QLog;

class anqh
  extends bhhe
{
  anqh(anqg paramanqg) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambhhf.f + ", url: " + parambhhf.a);
    }
    int i = parambhhf.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambhhf.a;
      if (!anqf.a.contains(str)) {
        break label105;
      }
      this.a.a(parambhhf);
    }
    label105:
    do
    {
      return;
      str = parambhhf.a.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambhhf);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambhhf.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqh
 * JD-Core Version:    0.7.0.1
 */