import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class bgot
  extends bgoy
{
  public TroopAioTopADInfo a;
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    paramTroopFeedItem = paramView;
    if (paramView == null) {
      paramTroopFeedItem = LayoutInflater.from(this.jdField_a_of_type_Bgos.jdField_a_of_type_AndroidContentContext).inflate(2131560633, null);
    }
    Object localObject = (bgou)paramTroopFeedItem.getTag();
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new bgou(this);
      paramView.a = ((URLImageView)paramTroopFeedItem.findViewById(2131362080));
      paramTroopFeedItem.setOnClickListener(this.jdField_a_of_type_Bgos);
      paramTroopFeedItem.setTag(paramView);
    }
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_Bgos.jdField_a_of_type_AndroidContentContext)) {
      if (this.jdField_a_of_type_Bgos.jdField_a_of_type_Bfhz != null) {
        this.jdField_a_of_type_Bgos.jdField_a_of_type_Bfhz.c();
      }
    }
    do
    {
      return paramTroopFeedItem;
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        asbg localasbg = new asbg(1, 1);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localasbg;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localasbg;
        localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl, (URLDrawable.URLDrawableOptions)localObject);
        paramView.a.setBackgroundDrawable((Drawable)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("TroopAioADManager", 2, "URLDrawable: " + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.uiUrl);
        }
        bdla.b(this.jdField_a_of_type_Bgos.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "Exp_Promote", 0, 0, this.jdField_a_of_type_Bgos.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTopADInfo.adId + "", "", "");
        return paramTroopFeedItem;
      }
      catch (IllegalArgumentException paramView) {}
    } while (!QLog.isColorLevel());
    QLog.e("TroopAioADManager", 2, "IllegalArgumentException");
    return paramTroopFeedItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgot
 * JD-Core Version:    0.7.0.1
 */