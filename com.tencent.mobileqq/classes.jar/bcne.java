import QC.UniSetRsp;
import java.util.concurrent.atomic.AtomicInteger;

class bcne
  implements anil
{
  bcne(bcnd parambcnd) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      paramBoolean = true;
      paramObject = this.a;
      if (bcnd.a(this.a).get() != 1) {
        break label91;
      }
      bool1 = true;
      label48:
      paramInt = bcnd.b(this.a).get();
      if (bcnd.c(this.a).get() != 1) {
        break label97;
      }
    }
    for (;;)
    {
      paramObject.a(paramBoolean, bool1, paramInt, bool2, false, false);
      return;
      paramBoolean = false;
      break;
      label91:
      bool1 = false;
      break label48;
      label97:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcne
 * JD-Core Version:    0.7.0.1
 */