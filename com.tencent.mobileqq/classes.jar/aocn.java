import com.tencent.qphone.base.util.QLog;

class aocn
  extends biht
{
  aocn(aocm paramaocm) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambihu.f + ", url: " + parambihu.a);
    }
    int i = parambihu.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambihu.a;
      if (!aocl.a.contains(str)) {
        break label105;
      }
      this.a.a(parambihu);
    }
    label105:
    do
    {
      return;
      str = parambihu.a.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambihu);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambihu.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aocn
 * JD-Core Version:    0.7.0.1
 */