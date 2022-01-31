import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.open.agent.CreateVirtualAccountFragment;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;

public class bdaa
  implements bfoq
{
  public bdaa(CreateVirtualAccountFragment paramCreateVirtualAccountFragment, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bfol.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      paramView = new Intent();
      paramInt = bazo.b(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity());
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramView.putExtra("Business_Origin", 103);
      paramView.putExtra("BUSINESS_ORIGIN_NEW", 103);
      paramView.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
      paramView.putExtra("fromWhereClick", 11);
      PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity(), PublicFragmentActivityForOpenSDK.class.getName(), paramInt, paramInt, 1080, 1080, bazo.a());
      continue;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity().checkSelfPermission("android.permission.CAMERA") != 0)
        {
          paramInt = 1;
          if (paramInt != 0) {
            this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity().requestPermissions(new bdab(this), 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else
        {
          paramInt = 0;
          continue;
        }
        this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.a = ProfileActivity.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity(), 257);
      }
      else
      {
        this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.a = ProfileActivity.a(this.jdField_a_of_type_ComTencentOpenAgentCreateVirtualAccountFragment.getActivity(), 257);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdaa
 * JD-Core Version:    0.7.0.1
 */