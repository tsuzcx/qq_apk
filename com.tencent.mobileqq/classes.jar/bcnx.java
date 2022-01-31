import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.QLog;

class bcnx
  extends bcoc
{
  public TroopAioTopADInfo a;
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    paramTroopFeedItem = paramView;
    if (paramView == null) {
      paramTroopFeedItem = LayoutInflater.from(this.jdField_a_of_type_Bcnw.jdField_a_of_type_AndroidContentContext).inflate(2131560402, null);
    }
    Object localObject = (bcny)paramTroopFeedItem.getTag();
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new bcny(this);
      paramView.a = ((URLImageView)paramTroopFeedItem.findViewById(2131362015));
      paramTroopFeedItem.setOnClickListener(this.jdField_a_of_type_Bcnw);
      paramTroopFeedItem.setTag(paramView);
    }
    if (!bdee.d(this.jdField_a_of_type_Bcnw.jdField_a_of_type_AndroidContentContext)) {
      if (this.jdField_a_of_type_Bcnw.jdField_a_of_type_Bbnl != null) {
        this.jdField_a_of_type_Bcnw.jdField_a_of_type_Bbnl.c();
      }
    }
    do
    {
      return paramTroopFeedItem;
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        apgg localapgg = new apgg(1, 1);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localapgg;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localapgg;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl, (URLDrawable.URLDrawableOptions)localObject);
        paramView.a.setBackgroundDrawable((Drawable)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioADManager", 2, "URLDrawable: " + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl);
        }
        azmj.b(this.jdField_a_of_type_Bcnw.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Exp_Promote", 0, 0, this.jdField_a_of_type_Bcnw.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.adId + "", "", "");
        return paramTroopFeedItem;
      }
      catch (IllegalArgumentException paramView) {}
    } while (!QLog.isColorLevel());
    QLog.e("TroopAioADManager", 2, "IllegalArgumentException");
    return paramTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnx
 * JD-Core Version:    0.7.0.1
 */