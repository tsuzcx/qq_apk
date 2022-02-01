import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfhw
  implements View.OnClickListener
{
  public bfhw(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, ArticleInfo paramArticleInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent())) {
      qam.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getActivity() != null) && ((this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getActivity() instanceof TroopAvatarWallPreviewActivity))) {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
        {
          TroopAvatarWallPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          ozs.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getActivity(), this.jdField_a_of_type_JavaLangString);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.j) {
            TroopAvatarWallPreviewActivity.d(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhw
 * JD-Core Version:    0.7.0.1
 */