import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.facetoface.Face2FaceFriendDetailView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aswg
  implements View.OnClickListener
{
  public aswg(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity))
    {
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.a.d();
      localObject = Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).obtainMessage();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = 2;
      ((Message)localObject).obj = this.jdField_a_of_type_JavaLangString;
      Face2FaceAddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity).sendMessage((Message)localObject);
      bdla.b(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getResources().getString(2131692084);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity, 0, (CharSequence)localObject, 0).b(this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswg
 * JD-Core Version:    0.7.0.1
 */