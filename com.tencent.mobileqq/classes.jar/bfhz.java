import com.tencent.qphone.base.util.QLog;

class bfhz
  implements bfjs
{
  bfhz(bfhy parambfhy) {}
  
  public int a(long paramLong1, long paramLong2, long paramLong3, Object paramObject1, Object paramObject2, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    if ((paramObject1 != null) && ((paramObject1 instanceof String)) && (paramObject2 != null) && ((paramObject2 instanceof byte[])))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QSec.CSP", 2, String.format("Cookie: %08X, cmd: %s", new Object[] { Long.valueOf(paramLong1), paramObject1 }));
      }
      if (paramLong1 == 0L) {
        break label99;
      }
      this.a.a((String)paramObject1, (byte[])paramObject2, new bfic(this.a, paramLong1));
    }
    for (;;)
    {
      return 0;
      label99:
      this.a.a((String)paramObject1, (byte[])paramObject2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhz
 * JD-Core Version:    0.7.0.1
 */