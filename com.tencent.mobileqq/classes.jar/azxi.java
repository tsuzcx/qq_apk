import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.now.NowVideoLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class azxi
  extends azut
{
  private QQAppInterface a;
  
  protected int b()
  {
    return 18;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout18", 2, "getView.");
    }
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    paramContext.getResources();
    if ((paramBundle instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramBundle);
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    paramBundle = null;
    if (((Iterator)localObject2).hasNext())
    {
      azus localazus = (azus)((Iterator)localObject2).next();
      if (!"live".equals(localazus.a)) {
        break label255;
      }
      paramBundle = (azwb)localazus;
    }
    label247:
    label255:
    for (;;)
    {
      break;
      if (paramBundle == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsgItemLayout18", 2, "getView itemLive is null.");
        }
        return null;
      }
      if (paramView != null)
      {
        paramContext = (azxj)paramView.getTag();
        localObject2 = null;
        localObject1 = paramView;
        paramView = paramContext;
        paramContext = (Context)localObject2;
        if (paramView != null) {
          break label247;
        }
        paramView = new azxj();
        paramView.jdField_a_of_type_Azwb = paramBundle;
        paramView.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramContext;
      }
      for (;;)
      {
        ((View)localObject1).setTag(paramView);
        paramView = ((View)localObject1).findViewById(2131377137);
        if (paramView != null) {
          paramView.setOnClickListener(paramBundle.a);
        }
        if (paramContext != null) {
          paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
        }
        return localObject1;
        localObject2 = paramBundle.a(paramContext, null, null);
        paramContext = (NowVideoLayout)((View)localObject2).findViewById(2131377137);
        paramContext.a();
        paramView = (View)localObject1;
        localObject1 = localObject2;
        break;
        paramContext = paramView.jdField_a_of_type_ComTencentBizNowNowVideoLayout;
      }
    }
  }
  
  public String b()
  {
    return "Layout18";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxi
 * JD-Core Version:    0.7.0.1
 */