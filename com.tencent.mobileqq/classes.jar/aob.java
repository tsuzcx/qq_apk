import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.TextView;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackObserver;
import com.qq.im.poi.LbsStrangerPoiDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aob
  extends LbsPackObserver
{
  public aob(LbsStrangerPoiDialog paramLbsStrangerPoiDialog) {}
  
  public void onGetRedPackPage(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      boolean bool = paramBundle.getBoolean("firstPage", true);
      long l = paramBundle.getLong("poiId");
      paramBundle = paramBundle.getParcelableArrayList("packInfoList");
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsStrangerPoiDialog onGetRedPackPage, isSuccess  = " + paramBoolean + " firstPage=" + bool + " mPoiId=" + this.a.jdField_a_of_type_Long + "onGetRedPackPage poiId=" + l);
      }
      if ((l == this.a.jdField_a_of_type_Long) && (l != 0L))
      {
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          Parcelable localParcelable = (Parcelable)paramBundle.next();
          if ((localParcelable instanceof LbsPackInfo)) {
            this.a.jdField_a_of_type_ComQqImPoiLbsPackInfo = ((LbsPackInfo)localParcelable);
          }
        }
        Message.obtain().what = 100;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
      }
    }
  }
  
  public void onGetSenderNick(boolean paramBoolean, Bundle paramBundle)
  {
    String str;
    if (paramBoolean)
    {
      str = this.a.jdField_a_of_type_ComQqImPoiLbsPackManager.b(this.a.jdField_a_of_type_ComQqImPoiLbsPackInfo.jdField_a_of_type_Long + "");
      if (!TextUtils.isEmpty(str))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText("AR红包");
        if (this.a.d <= 1) {
          break label218;
        }
        paramBundle = "等" + this.a.d + "人";
        this.a.b.setText(str + paramBundle);
        if (this.a.d <= 1) {
          break label224;
        }
      }
    }
    label218:
    label224:
    for (paramBundle = "等" + this.a.d + "人发" + this.a.getContext().getString(2131438799);; paramBundle = this.a.getContext().getString(2131438799))
    {
      this.a.c.setText(str + paramBundle);
      return;
      paramBundle = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aob
 * JD-Core Version:    0.7.0.1
 */