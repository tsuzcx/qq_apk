import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.qq.im.poi.LbsPackInfo;
import com.qq.im.poi.LbsPackListActivity;
import com.qq.im.poi.LbsPackListAdapter;
import com.qq.im.poi.LbsPackObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class amw
  extends LbsPackObserver
{
  public amw(LbsPackListActivity paramLbsPackListActivity) {}
  
  public void onGetRedPackPage(boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool;
    long l;
    Object localObject1;
    if ((paramBoolean) && (paramBundle != null))
    {
      bool = paramBundle.getBoolean("firstPage", false);
      l = paramBundle.getLong("poiId");
      localObject1 = paramBundle.getParcelableArrayList("packInfoList");
      paramBundle = paramBundle.getString("pageCookie");
      if (QLog.isColorLevel())
      {
        QLog.d("LbsPack", 2, "LbsPackListActivityonGetRedPackPage, isSuccess  = " + paramBoolean + " firstPage=" + bool + " mPoiId=" + LbsPackListActivity.a(this.a) + "onGetRedPackPage poiId=" + l + " pageCookie=" + paramBundle);
        if (localObject1 != null) {
          QLog.d("LbsPack", 2, "LbsPackListActivityonGetRedPackPage size=" + ((List)localObject1).size());
        }
      }
      if (bool) {
        LbsPackListActivity.a(this.a).clear();
      }
      if ((l == LbsPackListActivity.a(this.a)) && (l != 0L) && (localObject1 != null)) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    label513:
    for (;;)
    {
      Object localObject2;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Parcelable)((Iterator)localObject1).next();
        if (!(localObject2 instanceof LbsPackInfo)) {
          continue;
        }
        localObject2 = (LbsPackInfo)localObject2;
        if (TextUtils.isEmpty(((LbsPackInfo)localObject2).b))
        {
          if (!QLog.isColorLevel()) {
            break label505;
          }
          QLog.e("LbsPack", 2, "LbsPackListActivityonGetRedPackPage info pid= null ");
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label513;
        }
        LbsPackListActivity.a(this.a).add(localObject2);
        break;
        Iterator localIterator = LbsPackListActivity.a(this.a).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            LbsPackInfo localLbsPackInfo = (LbsPackInfo)localIterator.next();
            if ((TextUtils.isEmpty(localLbsPackInfo.b)) || (((LbsPackInfo)localObject2).b.equals(localLbsPackInfo.b)))
            {
              if (QLog.isColorLevel())
              {
                QLog.e("LbsPack", 2, "LbsPackListActivity onGetRedPackPage info pid= lbsPackInfo。pid ");
                i = 1;
                break;
                localObject1 = Message.obtain();
                ((Message)localObject1).what = 1002;
                if (bool)
                {
                  i = LbsPackListActivity.jdField_a_of_type_Int;
                  ((Message)localObject1).arg1 = i;
                  ((Message)localObject1).obj = Long.valueOf(l);
                  this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
                  if (!TextUtils.isEmpty(paramBundle)) {
                    break label466;
                  }
                  LbsPackListActivity.a(this.a, true);
                }
                for (;;)
                {
                  if (LbsPackListActivity.a(this.a) != null) {
                    LbsPackListActivity.a(this.a).setVisibility(4);
                  }
                  return;
                  i = LbsPackListActivity.b;
                  break;
                  label466:
                  LbsPackListActivity.a(this.a, false);
                  continue;
                  LbsPackListActivity.a(this.a, false);
                  QQToast.a(this.a, 1, "红包获取失败，再刷新试试吧。", 0).a();
                }
              }
              label505:
              i = 1;
              break;
            }
          }
        }
        i = 0;
      }
    }
  }
  
  public void onGetSenderNick(boolean paramBoolean, Bundle paramBundle)
  {
    LbsPackListActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amw
 * JD-Core Version:    0.7.0.1
 */