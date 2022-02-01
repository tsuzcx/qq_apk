import com.tencent.qphone.base.util.QLog;

class anzd
  extends bhyn
{
  anzd(anzc paramanzc) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambhyo.f + ", url: " + parambhyo.a);
    }
    int i = parambhyo.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambhyo.a;
      if (!anzb.a.contains(str)) {
        break label105;
      }
      this.a.a(parambhyo);
    }
    label105:
    do
    {
      return;
      str = parambhyo.a.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambhyo);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambhyo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzd
 * JD-Core Version:    0.7.0.1
 */