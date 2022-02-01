import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class anxg
  implements afrq
{
  private QQAppInterface a;
  
  public anxg(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void a() {}
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    if ((paramRedPacketInfo == null) || (TextUtils.isEmpty(paramRedPacketInfo.templateId))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(anxc.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = (anxc)this.a.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
    if ((localObject == null) || (!((anxc)localObject).c()) || (((anxc)localObject).c.get()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = anxc.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject != null) {
          break label150;
        }
      }
      label150:
      for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((anxc)localObject).a().jdField_a_of_type_Boolean + ", PacketEnable:" + ((anxc)localObject).b() + ", mIsSDCardError:" + ((anxc)localObject).c.get())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.post(new IndividualRedPacketManager.VIPHBStrategy.1(this, (anxc)localObject, paramRedPacketInfo), 8, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, ahya paramahya)
  {
    if ((paramRedPacketInfo != null) && ((paramahya instanceof ahyg)))
    {
      paramahya = (ahyg)paramahya;
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramahya.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramahya.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      paramRedPacketInfo.jdField_a_of_type_Afrp = paramahya.jdField_a_of_type_Afrp;
      paramRedPacketInfo.b = paramahya.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxg
 * JD-Core Version:    0.7.0.1
 */