import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public final class auta
  implements INetEngine.INetEngineListener
{
  public auta(INetEngine.INetEngineListener paramINetEngineListener) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.a != null) {
      this.a.onResp(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.a != null) {
      this.a.onUpdateProgeress(paramNetReq, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auta
 * JD-Core Version:    0.7.0.1
 */