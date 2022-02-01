import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class bckg
  extends bcgx
{
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, bcki parambcki)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130850322);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.dp2px(239.0F, paramResources);
    localLayoutParams.topMargin = AIOUtils.dp2px(10.0F, paramResources);
    parambcki.jdField_a_of_type_AndroidWidgetImageView = paramContext;
    paramContext.setVisibility(4);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, bcki parambcki)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376011);
    paramContext.setTextColor(Color.parseColor("#777777"));
    paramContext.setTextSize(1, 14.0F);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(25.0F, paramResources));
    localLayoutParams.topMargin = AIOUtils.dp2px(83.0F, paramResources);
    localLayoutParams.leftMargin = AIOUtils.dp2px(30.0F, paramResources);
    parambcki.b = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, bcki parambcki)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376012);
    paramContext.setText(2131697936);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setTextColor(-1);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.dp2px(75.0F, paramResources));
    localLayoutParams.leftMargin = AIOUtils.dp2px(60.0F, paramResources);
    localLayoutParams.topMargin = AIOUtils.dp2px(8.0F, paramResources);
    parambcki.jdField_a_of_type_AndroidWidgetTextView = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  protected int b()
  {
    return 29;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    azuu localazuu = azuu.a();
    Resources localResources = paramContext.getResources();
    int j = 0;
    if (paramView == null)
    {
      paramBundle = new RelativeLayout(paramContext);
      paramView = new bcki(null);
      paramBundle.setTag(-1, paramView);
      paramBundle.setId(2131376010);
      paramView.jdField_a_of_type_AndroidViewView = paramBundle;
      c(paramContext, paramBundle, localResources, paramView);
      b(paramContext, paramBundle, localResources, paramView);
      a(paramContext, paramBundle, localResources, paramView);
      j = 1;
      paramContext = paramBundle;
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null)) {
        break label190;
      }
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayout29", 2, "getView but parentMsg or message is null");
      }
      if (!QLog.isDebugVersion()) {
        break label384;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) {
        break label179;
      }
    }
    label179:
    for (paramContext = "-";; paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message)
    {
      throw new IllegalStateException(String.format("getView but parentMsg or message is null, %s / %s", new Object[] { paramView, paramContext }));
      paramContext = (RelativeLayout)paramView;
      paramView = (bcki)paramContext.getTag(-1);
      break;
    }
    label190:
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    if (paramBundle.hasNext())
    {
      bcgw localbcgw = (bcgw)paramBundle.next();
      if ((!"type".equals(localbcgw.a)) || (!(localbcgw instanceof bcmd))) {
        break label447;
      }
      i = ((bcmd)localbcgw).o;
    }
    label384:
    label447:
    for (;;)
    {
      break;
      if ((bool != paramView.jdField_a_of_type_Boolean) || (i != paramView.jdField_a_of_type_Int) || (j != 0))
      {
        paramContext.setBackgroundDrawable(new BitmapDrawable(localResources, localazuu.a(localResources, bool, i)));
        paramView.jdField_a_of_type_Boolean = bool;
        paramView.jdField_a_of_type_Int = i;
      }
      if (bool)
      {
        paramView.b.setText(2131697935);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      for (;;)
      {
        if ((!bool) && (BaseApplicationImpl.sProcessId == 1))
        {
          paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          azuu.a().a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
        }
        return paramContext;
        if ("1".equals(azuu.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message)))
        {
          paramView.b.setText(2131697933);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
        else
        {
          paramView.b.setText(2131697934);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
    }
  }
  
  public String b()
  {
    return "layout29";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckg
 * JD-Core Version:    0.7.0.1
 */