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

public class bdrb
  extends bdom
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
      bdol localbdol = (bdol)((Iterator)localObject2).next();
      if (!"live".equals(localbdol.a)) {
        break label255;
      }
      paramBundle = (bdpu)localbdol;
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
        paramContext = (bdrc)paramView.getTag();
        localObject2 = null;
        localObject1 = paramView;
        paramView = paramContext;
        paramContext = (Context)localObject2;
        if (paramView != null) {
          break label247;
        }
        paramView = new bdrc();
        paramView.jdField_a_of_type_Bdpu = paramBundle;
        paramView.jdField_a_of_type_ComTencentBizNowNowVideoLayout = paramContext;
      }
      for (;;)
      {
        ((View)localObject1).setTag(paramView);
        paramView = ((View)localObject1).findViewById(2131378099);
        if (paramView != null) {
          paramView.setOnClickListener(paramBundle.a);
        }
        if (paramContext != null) {
          paramContext.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
        }
        return localObject1;
        localObject2 = paramBundle.a(paramContext, null, null);
        paramContext = (NowVideoLayout)((View)localObject2).findViewById(2131378099);
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
 * Qualified Name:     bdrb
 * JD-Core Version:    0.7.0.1
 */