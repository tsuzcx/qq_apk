import com.tencent.qphone.base.util.QLog;

class amwp
  extends bgod
{
  amwp(amwo paramamwo) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status: " + parambgoe.f + ", url: " + parambgoe.a);
    }
    int i = parambgoe.a.indexOf("?");
    String str;
    if (i == -1)
    {
      str = parambgoe.a;
      if (!amwn.a.contains(str)) {
        break label105;
      }
      this.a.a(parambgoe);
    }
    label105:
    do
    {
      return;
      str = parambgoe.a.substring(0, i - 1);
      break;
      if ("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json".equals(str))
      {
        this.a.b(parambgoe);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.roammsg.MessageRoamManager", 2, "onDone unkonw url: " + parambgoe.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwp
 * JD-Core Version:    0.7.0.1
 */