import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class aoar
  implements aghi
{
  private QQAppInterface a;
  
  public aoar(QQAppInterface paramQQAppInterface)
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
      QLog.d(aoan.b(), 2, "VIPHBStrategy.get Id = " + paramRedPacketInfo.templateId + "content = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString);
    }
    Object localObject = (aoan)this.a.getManager(131);
    if ((localObject == null) || (!((aoan)localObject).c()) || (((aoan)localObject).c.get()))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        str = aoan.b();
        localStringBuilder = new StringBuilder().append("VIPHBStrategy get fail! Redpacket Disable or no TemplateInfo! ");
        if (localObject != null) {
          break label150;
        }
      }
      label150:
      for (localObject = "redPacketManager == null";; localObject = "isShowRedpacket:" + ((aoan)localObject).a().jdField_a_of_type_Boolean + ", PacketEnable:" + ((aoan)localObject).b() + ", mIsSDCardError:" + ((aoan)localObject).c.get())
      {
        QLog.d(str, 2, (String)localObject);
        CustomizeStrategyFactory.a().a(paramRedPacketInfo);
        return;
      }
    }
    ThreadManager.post(new IndividualRedPacketManager.VIPHBStrategy.1(this, (aoan)localObject, paramRedPacketInfo), 8, null, true);
  }
  
  public void a(CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, aigs paramaigs)
  {
    if ((paramRedPacketInfo != null) && ((paramaigs instanceof aigy)))
    {
      paramaigs = (aigy)paramaigs;
      paramRedPacketInfo.jdField_a_of_type_AndroidGraphicsBitmap = paramaigs.jdField_a_of_type_AndroidGraphicsBitmap;
      paramRedPacketInfo.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramaigs.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
      paramRedPacketInfo.jdField_a_of_type_Aghh = paramaigs.jdField_a_of_type_Aghh;
      paramRedPacketInfo.b = paramaigs.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoar
 * JD-Core Version:    0.7.0.1
 */