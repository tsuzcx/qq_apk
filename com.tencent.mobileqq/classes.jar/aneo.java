import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aneo
  implements View.OnClickListener
{
  aneo(anem paramanem) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(anem.a(this.a))) && (!anem.a(this.a).equals("0")))
    {
      QQAppInterface localQQAppInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app;
      int i = this.a.a.jdField_a_of_type_Int;
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqDataApolloGameData != null)
      {
        localObject = Integer.toString(this.a.a.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "clk_fuwuhao", i, 0, new String[] { localObject });
        localObject = new Intent(this.a.a.getActivity(), AccountDetailActivity.class);
        ((Intent)localObject).putExtra("uin", anem.a(this.a));
        ((Intent)localObject).putExtra("uintype", 1008);
        this.a.a.getActivity().startActivity((Intent)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = "";
      break;
      QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setPubAccountInfo] uin is null or = 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aneo
 * JD-Core Version:    0.7.0.1
 */