import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class anog
  implements View.OnClickListener
{
  anog(anob paramanob, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ApolloUtil.a(anob.a(this.jdField_a_of_type_Anob).mActivity, anob.a(this.jdField_a_of_type_Anob).app.getCurrentUin(), "lmx_actchat");
    this.jdField_a_of_type_Anob.a();
    anob.a(this.jdField_a_of_type_Anob, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionData, "action_flame_clickgain");
    anme.a(125, String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anog
 * JD-Core Version:    0.7.0.1
 */