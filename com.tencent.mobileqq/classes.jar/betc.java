import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NowShowVideoInfo;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.ProfileCardNewPhotoWallView;
import java.util.ArrayList;
import java.util.LinkedList;

public class betc
  implements View.OnClickListener
{
  public betc(ProfileCardNewPhotoWallView paramProfileCardNewPhotoWallView, ProfilePhotoWall paramProfilePhotoWall, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataProfilePhotoWall instanceof NowShowVideoInfo))
    {
      localObject1 = (NowShowVideoInfo)this.jdField_a_of_type_ComTencentMobileqqDataProfilePhotoWall;
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("url", ((NowShowVideoInfo)localObject1).mJumpUrl);
      paramView.getContext().startActivity((Intent)localObject2);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "NOW", "", "qq_zlk", "replay_click", 0, 0, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_AndroidAppActivity, TroopAvatarWallPreviewActivity.class);
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("index", this.jdField_a_of_type_Int);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_JavaUtilLinkedList.size())
    {
      Object localObject3 = (ProfilePhotoWall)this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_JavaUtilLinkedList.get(i);
      if ((localObject3 instanceof QZonePhotoInfo))
      {
        ((ArrayList)localObject2).add(((ProfilePhotoWall)localObject3).getOriginUrl());
        localObject3 = (QZonePhotoInfo)localObject3;
        localArrayList1.add(((QZonePhotoInfo)localObject3).photoId);
        localArrayList2.add(((QZonePhotoInfo)localObject3).time + "");
      }
      i += 1;
    }
    ((Bundle)localObject1).putStringArrayList("seqNum", (ArrayList)localObject2);
    ((Bundle)localObject1).putBoolean("from_photo_wall", true);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_JavaLangString))
    {
      ((Bundle)localObject1).putBoolean("delete_ability", true);
      ((Bundle)localObject1).putStringArrayList("photoIds", localArrayList1);
      ((Bundle)localObject1).putStringArrayList("photoTimes", localArrayList2);
    }
    ((Bundle)localObject1).putBoolean("SHOW_MENU", true);
    ((Bundle)localObject1).putBoolean("IS_EDIT", false);
    ((Bundle)localObject1).putBoolean("is_use_path", true);
    ((Bundle)localObject1).putBoolean("is_show_action", true);
    ((Bundle)localObject1).putBoolean("is_not_show_index", true);
    paramView.putExtras((Bundle)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_JavaLangString))
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A80", "0X8006A80", 0, 0, "", "", "", "");
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardNewPhotoWallView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006A94", "0X8006A94", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betc
 * JD-Core Version:    0.7.0.1
 */