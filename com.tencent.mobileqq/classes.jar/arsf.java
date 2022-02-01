import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arsf
  implements View.OnClickListener
{
  public arsf(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqFacetofaceFace2FaceAddFriendActivity.app.getPreferences().edit().putBoolean(this.jdField_a_of_type_JavaLangString, true).commit();
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(new arsg(this));
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arsf
 * JD-Core Version:    0.7.0.1
 */