import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class bfmu
{
  private static bfmu jdField_a_of_type_Bfmu;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long g;
  private long h;
  private long i;
  private long j;
  private long k;
  private long l;
  private long m;
  private long n;
  private long o;
  private long p;
  private long q;
  private long r;
  private long s;
  private long t;
  private long u;
  private long v;
  
  public static bfmu a()
  {
    if (jdField_a_of_type_Bfmu == null) {
      jdField_a_of_type_Bfmu = new bfmu();
    }
    return jdField_a_of_type_Bfmu;
  }
  
  public void a()
  {
    jdField_a_of_type_Bfmu = null;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long += paramLong;
    this.b += 1L;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.i += paramLong1;
    this.j += paramLong2;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AutoMonitor", 2, paramString1 + ", cost=" + paramString2);
      return;
    }
    Log.i("AutoMonitor", paramString1 + ", cost=" + paramString2);
  }
  
  public void b()
  {
    a("MSG_DbIoTime", this.jdField_a_of_type_Long + "");
    this.jdField_a_of_type_Long = 0L;
    a("MSG_DbIoNum", this.b + "");
    this.b = 0L;
    a("MSG_DbIoTransaction", this.c + "");
    this.c = 0L;
  }
  
  public void b(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.c += paramLong;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int += 1;
  }
  
  public void c(long paramLong)
  {
    this.d += paramLong;
  }
  
  public void d()
  {
    a("MSG_ObserverTime", this.d + "");
    a("MSG_ObserverNotifyNum", this.jdField_a_of_type_Int + "");
    this.d = 0L;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void d(long paramLong)
  {
    this.m += paramLong;
  }
  
  public void e()
  {
    this.p = System.currentTimeMillis();
  }
  
  public void e(long paramLong)
  {
    this.n += paramLong;
  }
  
  public void f()
  {
    this.o = (System.currentTimeMillis() - this.p);
  }
  
  public void f(long paramLong)
  {
    this.e += paramLong;
    this.f += 1L;
  }
  
  public void g()
  {
    this.r = System.currentTimeMillis();
  }
  
  public void g(long paramLong)
  {
    this.g += paramLong;
    this.h += 1L;
  }
  
  public void h()
  {
    this.q = (System.currentTimeMillis() - this.r);
  }
  
  public void h(long paramLong)
  {
    this.k += paramLong;
    this.l += 1L;
  }
  
  public void i()
  {
    this.t = System.currentTimeMillis();
  }
  
  public void j()
  {
    this.s = (System.currentTimeMillis() - this.t);
  }
  
  public void k()
  {
    a("MSG_DecodeC2CMsgNum", String.valueOf(this.f));
    a("MSG_DecodeC2CMsgTime", String.valueOf(this.e));
    a("MSG_DecodeGrpDisMsgNum", String.valueOf(this.h));
    a("MSG_DecodeGrpDisMsgTime", String.valueOf(this.g));
    a("MSG_AddMsgNum", String.valueOf(this.j));
    a("MSG_AddMsgTime", String.valueOf(this.i));
    a("MSG_MsgFilterNum", String.valueOf(this.l));
    a("MSG_MsgFilterTime", String.valueOf(this.k));
    a("MSG_PROXY_SEQ_DIS_T", String.valueOf(this.m));
    a("MSG_PROXY_SEQ_GRP_T", String.valueOf(this.n));
    b();
    d();
    a("MSG_NOTIFY_FIN_C2C", String.valueOf(this.o));
    a("MSG_NOTIFY_FIN_GRP", String.valueOf(this.q));
    a("MSG_NOTIFY_FIN_DIS", String.valueOf(this.s));
    a("MSG_PROXY_THREAD_NUM_BEGIN", String.valueOf(this.u));
    a("MSG_PROXY_THREAD_NUM_END", String.valueOf(this.v));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmu
 * JD-Core Version:    0.7.0.1
 */