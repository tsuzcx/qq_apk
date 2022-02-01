import QC.UniSetRsp;
import java.util.concurrent.atomic.AtomicInteger;

class bdfw
  implements anui
{
  bdfw(bdfv parambdfv) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramBoolean) && ((paramObject instanceof UniSetRsp)) && (((UniSetRsp)paramObject).ret == 0))
    {
      paramBoolean = true;
      paramObject = this.a;
      if (bdfv.a(this.a).get() != 1) {
        break label91;
      }
      bool1 = true;
      label48:
      paramInt = bdfv.b(this.a).get();
      if (bdfv.c(this.a).get() != 1) {
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
 * Qualified Name:     bdfw
 * JD-Core Version:    0.7.0.1
 */