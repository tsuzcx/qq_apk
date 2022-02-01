import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anqd
  implements amwb, amwd
{
  public WeakReference<BaseChatPie> a;
  private WeakReference<amwb> b;
  
  public anqd(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof aijm)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof aijc)) || ((paramBaseChatPie instanceof ailn))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onCompleteRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((amwb)this.b.get()).a(paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onStartRender");
    }
    if ((this.b != null) && (this.b.get() != null)) {
      ((amwb)this.b.get()).a(paramInt, paramString);
    }
  }
  
  public void a(amwb paramamwb)
  {
    this.b = new WeakReference(paramamwb);
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    Object localObject2 = (BaseChatPie)this.a.get();
    if ((localObject2 == null) || (((BaseChatPie)localObject2).jdField_a_of_type_Amuy == null)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject2 = ((BaseChatPie)localObject2).jdField_a_of_type_Amuy.a();
      } while ((localObject1 == null) || (localObject2 == null));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBackgroundViewListener", 2, "surfaceView.getWidth():" + ((ApolloTextureView)localObject2).getWidth());
      }
      ((ApolloTextureView)localObject2).getRenderImpl().a(1, null, 0, 1.0F, 250.0F, 0.0F);
      ((ApolloTextureView)localObject2).getRenderImpl().a(1000L);
      localObject1 = ((angf)((AppInterface)localObject1).getManager(249)).a();
    } while (localObject1 == null);
    ((anfw)localObject1).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqd
 * JD-Core Version:    0.7.0.1
 */